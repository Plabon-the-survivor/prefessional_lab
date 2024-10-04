import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        if(args == null || args.length != 1){
            System.out.println("Usage: (a | r | c | +WORD | ?WORD)");
            return; //Exit early.
        }

//		Check arguments
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader =  new BufferedReader(
                                    new InputStreamReader(
                                    new FileInputStream("students.txt")));
                String readLine = bufferedReader.readLine();
                String words[] = readLine.split(",");
                for (String word : words) {
                    System.out.println(word.trim());
                }
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader =  new BufferedReader(
                                    new InputStreamReader(
                                    new FileInputStream("students.txt")));
                String readLine = bufferedReader.readLine();
                String strings[] = readLine.split(",");
                Random random = new Random();
                int anInt = random.nextInt(strings.length);
                System.out.println(strings[anInt].trim());
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter =  new BufferedWriter(
                                    new FileWriter("students.txt", true));
                String substring = args[0].substring(1);
                Date date = new Date();
                String date_format = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(date_format);
                String formatted = dateFormat.format(date);
                bufferedWriter.write(", " + substring + "\nList last updated on " + formatted);
                bufferedWriter.close();
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader =  new BufferedReader(
                                    new InputStreamReader(
                                    new FileInputStream("students.txt")));
                String readLine = bufferedReader.readLine();
                String strings[] = readLine.split(",");
                boolean done = false;
                String substring = args[0].substring(1);

                for (int idx = 0; idx < strings.length && !done; idx++) {
                    if (strings[idx].trim().equals(substring)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader =  new BufferedReader(
                                    new InputStreamReader(
                                    new FileInputStream("students.txt")));
                String readLine = bufferedReader.readLine();
                char readLineCharArray[] = readLine.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char char_Ind : readLineCharArray) {
                    if (char_Ind == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found ");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
    }
}