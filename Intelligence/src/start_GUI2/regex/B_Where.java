package start_GUI2.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B_Where {
    public static void main(String[] args) {

        String inputString = "Kotlin is love. Kotlin is powerful. I love Kotlin.";
        Pattern pattern = Pattern.compile("Kotlin");
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            System.out.println("Found 'Kotlin' at index: " + matcher.start());
        }

    }
}
