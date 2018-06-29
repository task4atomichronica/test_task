package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringUtils contains method to format strings in needed manner
 */
public class StringUtils {

    /**
     * Gets text between tags
     *
     * @param text
     *          text to be formatted
     *
     * @return String representing formatted text
     */
    public static String removeHTMLTags(String text) {
        String regex = ">(.+?)<";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        matcher.find();
        return matcher.group(1);
    }
}
