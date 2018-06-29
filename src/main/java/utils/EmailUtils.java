package utils;

import com.google.common.base.Strings;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * EmailUtils class contains methods to interact with emails in the mailbox
 */
public class EmailUtils {

    public static String getEmailBody(String folderToCheck, String to) {
        try {
            String emailBody = "";
            MailboxConnectionHelper connection = MailboxConnectionHelper.getConnection();
            Folder emailFolder = connection.getStore().getFolder(folderToCheck);
            emailFolder.open(Folder.READ_WRITE);
            CompletableFuture<Message[]> future = CompletableFuture.supplyAsync(() -> {
                Message[] messages = null;
                boolean flag = true;
                while (flag) {
                    try {
                        messages = emailFolder.getMessages();
						if (emailFolder.hasNewMessages()) {
							messages = emailFolder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
							break;
						}
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                    if (messages.length > 0) {
                        flag = false;
                    }
                }
                return messages;
            });
            Message[] messages = future.get(120, TimeUnit.SECONDS);
            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                if (message.getFrom()[0].toString().contains(to)) {
                    MimeMultipart multipart = (MimeMultipart) messages[i].getContent();
                    for (int j = 0; j < multipart.getCount(); j++) {
                        Part bodyPart = multipart.getBodyPart(j);
                        emailBody = bodyPart.getContent().toString();
                    }
                }
                message.setFlag(Flags.Flag.DELETED, true);
            }
            emailFolder.close(true);
            connection.closeConnection();
            return emailBody;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(String
                    .format("Messages from specified folder: %s wasn't recivied for some reason", folderToCheck));
        }
    }

}
