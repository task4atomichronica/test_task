package utils;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

/**
 * MailboxConnectionHelper is used to connect to gmail mailbox
 */
public class MailboxConnectionHelper {

    private static MailboxConnectionHelper connection = new MailboxConnectionHelper();
    private final Properties properties;
    private final String host = SettingsHelper.getHost();
    private final String port = SettingsHelper.getPort();
    private final String protocol = SettingsHelper.getProtocol();
    private final String user = SettingsHelper.getLogin();
    private final String password = SettingsHelper.getPass();
    private Store store;

    private MailboxConnectionHelper() {
        properties = new Properties();
        properties.put("host", host);
        properties.put("port", port);
        properties.put("mail.store.protocol", protocol);
        Session emailSession = Session.getInstance(properties);
        try {
            store = emailSession.getStore(protocol);
            store.connect(host, user, password);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static MailboxConnectionHelper getConnection() {
        return connection;
    }

    public Store getStore() {
        return store;
    }

    public void closeConnection() {
        if (store != null && store.isConnected()) {
            try {
                store.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
