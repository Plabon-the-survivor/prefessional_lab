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
        if (args[0].equals(Constants.ShowAll)) {
            System.out.println(Constants.LoadingDataText);
            try {
                String readLine = fileReader(Constants.FILE_NAME);
                String words[] = readLine.split(Constants.StudentEntryDelimiter);
                for (String word : words) {
                    System.out.println(word.trim());
                }
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals(Constants.ShowRandom)) {
            System.out.println(Constants.LoadingDataText);
            try {
                String readLine = fileReader(Constants.FILE_NAME);
                String words[] = readLine.split(Constants.StudentEntryDelimiter);
                Random random = new Random();
                int anInt = random.nextInt(words.length);
                System.out.println(words[anInt].trim());
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains(Constants.AddEntry)) {
            System.out.println(Constants.LoadingDataText);
            try {
                DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
                String formatted = dateFormat.format(new Date());
                writeToFile(Constants.FILE_NAME, formatted, args[0].substring(1));
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains(Constants.FindEntry)) {
            System.out.println(Constants.LoadingDataText);
            try {
                String readLine = fileReader(Constants.FILE_NAME);
                String words[] = readLine.split(Constants.StudentEntryDelimiter);
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
        } else if (args[0].contains(Constants.ShowCount)) {
            System.out.println(Constants.LoadingDataText);
            try {
                String readLine = fileReader(Constants.FILE_NAME);
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