package abs_GUI2;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PPJANG {
//    public static void hexValue(String str){
//        String regex = "^[0-9A-Fa-f]+$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(str);
//        System.out.print("All repeatings: ");
//        while(matcher.find()){
//            for(int i = 0; i<matcher.group().length(); i++){
//                System.out.print(matcher.group().charAt(i));
//            }
//        }
//        System.out.println();
//    }
//
//    public static void oddLength(String str){
//        String regex = "^[01]([01]{2})*$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(str);
//        System.out.print("All repeatings: ");
//        while(matcher.find()){
//            System.out.print(matcher.group());
//        }
//        System.out.println();
//    }

    // Task 1
    public static boolean isHexadecimal(String input) {
        return Pattern.matches("^[0-9A-Fa-f]+$", input);
        // ^ start $ end [] choose from which + one or more
    }

    // Task 2
    public static boolean isOddBinary(String input) {
        return Pattern.matches("^[01]([01]{2})*$", input);
        // (__{}) times repeating * zero or more
    }

    // Task 3
    public static void determineGender(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] parts = str.split("; ");
                String name = parts[1];
                if ( !name.equals("imie") ) {
                    if (name.endsWith("a")) {
                        System.out.println(name + ": Female");
                    } else {
                        System.out.println(name + ": Male");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 4
    public static void processIoTData(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String str;
            while ((str = reader.readLine()) != null) {
                String[] parts = str.split(" ");
                if (parts[0].equals("AT")) {
                    String hexData = parts[1];
                    int expected = Integer.parseInt(parts[2]);
                    int calculated = calc(hexData);
                    if (calculated == expected) {
                        String decoded = decodeHex(hexData);
                        if ( decoded.startsWith("LOGIN ") || decoded.startsWith("PASS ") ) {System.out.println(decoded);}
                        writer.write(decoded);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int calc(String date) {
        int sum = 0;
        for (int i = 0; i < date.length(); i++) {
            String hex = date.charAt(i) + "";
            sum += Integer.parseInt(hex, 16);
        }
        return sum % 128;
    }
    private static String decodeHex(String date) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < date.length(); i += 2) {
            String[] str = date.split("");
            String hex = str[i] + str[i + 1]; // 1A 2B 9F ... pair
            output.append((char) Integer.parseInt(hex, 16));
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String[] art = {
                "~^~^^^~^^^^^^^^^^^^^^^^^^^^^^~",
                "^^!!^~!^:::::::::::::::::::::^",
                "^^77!77!!!!!!!!!!!!!!!!!!!77^^",
                "^7#BBBBBBBBBBBBBBBBBBBBBBBB#7^",
                "^7BBBBBBBBBBBBBBBBBBBBBBBBBB7^",
                "^7BBBBBBBGPGBBBBBBGPBBBBBBBB7^",
                "^7BBBBBG7?Y?7GB5PBP~YBBBBBBB7^",
                "^7BBBBBY~P#BPBB5PBBJ!GBBBBBB7^",
                "^7BBBBB5~5B5JGBGBBBG!?BBBBBB7^",
                "^7BBBBBB5JJJ5BBJ5BBB5?GBBBBB7^",
                "^7BBBBBBBBBBBBBBBBBBBBBBBBBB7^",
                "^7BBBBBBBBBBBBBBBBBBBBBBBBBB7^",
                "^7BBBBBBBBBBBBBBBBBBBBBBBBBB7^",
                "^~!!!!!!!!!!!!!!!!!!!!!!!!!!~^"
        };

        for (String line : art) {
            System.out.println(line);
        }
        System.out.println();

        // Task 1
        System.out.println("Is 1A2B hexadecimal? " + isHexadecimal("1A2B"));
        System.out.println("Is 1G2B hexadecimal? " + isHexadecimal("1G2B"));
        System.out.println();System.out.println();System.out.println();

        // Task 2
        System.out.println("Is 101 odd binary? " + isOddBinary("101"));
        System.out.println("Is 1010 odd binary? " + isOddBinary("1010"));
        System.out.println();System.out.println();System.out.println();

        // Task 3
        determineGender("stud.csv");
        System.out.println();System.out.println();System.out.println();

        // Task 4
        processIoTData("receive.log", "commands.cmd");
    }
}
