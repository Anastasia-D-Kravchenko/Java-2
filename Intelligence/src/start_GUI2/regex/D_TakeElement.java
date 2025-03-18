package start_GUI2.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D_TakeElement {
    public static void main(String[] args) {

        String inputString = "My email is example@email.com and my website is https://www.example.com.";

        // Pattern for matching email addresses
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");
        Matcher emailMatcher = emailPattern.matcher(inputString);
        if (emailMatcher.find()) {
            System.out.println("Email found: " + emailMatcher.group());
        }

        // Pattern for matching URLs
        Pattern urlPattern = Pattern.compile("https?://\\S+");
        Matcher urlMatcher = urlPattern.matcher(inputString);
        if (urlMatcher.find()) {
            System.out.println("URL found: " + urlMatcher.group());
        }
    }
}
