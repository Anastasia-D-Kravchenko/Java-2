package start_GUI2.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C_Find_Replace {
    public static void main(String[] args) {

        String inputString = "Java is fun. But sometimes, Java can be challenging.";
        Pattern pattern = Pattern.compile("Java");
        Matcher matcher = pattern.matcher(inputString);

        String replacedString = matcher.replaceAll("PPJ");
        System.out.println(replacedString);
    }

}
