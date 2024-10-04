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
                String readLine = fileReader("students.txt");
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
                String readLine = fileReader("students.txt");
                String words[] = readLine.split(",");
                Random random = new Random();
                int anInt = random.nextInt(words.length);
                System.out.println(words[anInt].trim());
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                Date date = new Date();
                String date_format = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(date_format);
                String formatted = dateFormat.format(date);
                writeToFile("students.txt", formatted, args[0].substring(1));
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String readLine = fileReader("students.txt");
                String words[] = readLine.split(",");
                boolean done = false;
                String substring = args[0].substring(1);

                for (int idx = 0; idx < words.length && !done; idx++) {
                    if (words[idx].trim().equals(substring)) {
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
                String readLine = fileReader("students.txt");
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

    public static String fileReader(String fileName){
        try{
            BufferedReader bufferedReader =  new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName)));
            return bufferedReader.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    public static void writeToFile(String filename, String finalDate, String word) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true));
            bufferedWriter.write(", " + word + "\nList last updated on " + finalDate);
            bufferedWriter.close();
        } catch (Exception e) {
            return ;
        }
    }


}