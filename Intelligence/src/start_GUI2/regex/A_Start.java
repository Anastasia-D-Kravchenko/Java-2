package start_GUI2.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class A_Start {
    public static void main(String[] args) {
        // What
        Pattern pattern = Pattern.compile("");

        // Where
        String inputString = "I love PPJ!";

        // Combine
        Matcher matcher = pattern.matcher(inputString);

        // Check all
        System.out.println("---------------Matches---------------");
        if (matcher.matches()) {
            System.out.println("All match");
            System.out.println("Matched substring: " + matcher.group());
            System.out.println("Matched substring: " + matcher.group(0));
            System.out.println("Matched substring: " + matcher.group(1));
            System.out.println("Matched substring: " + matcher.group(2));
            //System.out.println("Matched substring: " + matcher.group(3)); //error
        }else{
            System.out.println("Not found");
        }

        matcher.reset();


        // Check part
        System.out.println("---------------Found1---------------");
        if (matcher.find()) {
            System.out.println("Found!");
            System.out.println("Matched substring: " + matcher.group());
        }else{
            System.out.println("Not found");
        }

        Pattern patternFind = Pattern.compile("...?");
        Matcher matcherFind = patternFind.matcher(inputString);
        // Check part
        System.out.println("---------------Found2---------------");
        while (matcherFind.find()) {
            System.out.println("Found!");
            System.out.println("Matched substring: " + matcherFind.group());
        }
    }
}
