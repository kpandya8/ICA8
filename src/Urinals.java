//Authour: Krutik Pandya (1225833793) kpandya8

import java.io.*;
import java.util.*;

public class Urinals {
    //create urinals.java class that works as a shell class
    static BufferedReader file_input;

    static ArrayList<Integer> out_list = new ArrayList<>();
    public static int urinalsAvailable(String urinals){
        //available urinals "0's"
        //System.out.print("check if urinal is available");
        if (!goodString(urinals)) return -1;
        if (urinals.contains("11")) return -1;
        if (urinals.equals("0")) return 1;
        if (urinals.equals("1")) return 0;
        if (urinals.length()>20) return -1;

        char[] urinals_array = urinals.toCharArray();
        int counter = 0;

        for (int i = 0; i < urinals_array.length - 1; i++) {
            if (i == 0) {
                if (urinals_array[i] == '0' && urinals_array[i + 1] == '0') {
                    urinals_array[i] = '1';
                    counter++;
                }
            }
            if (i > 0) {
                if (urinals_array[i] == '0' && urinals_array[i - 1] == '0' && urinals_array[i + 1] == '0') {
                    urinals_array[i] = '1';
                    counter++;
                }
            }
        }
        if (urinals_array[urinals_array.length - 1] == '0' && urinals_array[urinals_array.length - 2] == '0') {
            counter++;
        }
        return counter;

    }

    public static int openFile(){
        try {
            file_input = new BufferedReader(new FileReader("src/urinal.dat"));
        } catch (FileNotFoundException e) {
            return -1;
        }
        return 0;
    }


    public static int readFile() {
        String line;
        out_list = new ArrayList<>();
        try {
            if((line = file_input.readLine()) == null){
                return -1;
            }
            while((line) != null) {
                    out_list.add(urinalsAvailable(line));
                line = file_input.readLine();
            }
        } catch (IOException e) {
            return -2;
        }
        return 0;
    }

    public static int generateOutput() {
        int counter = 1;
        File f = new File("rule.txt");
        while(f.exists()) {
            f = new File("rule" + counter + ".txt");
            counter++;
        }
        FileWriter out;
        try {
            out = new FileWriter(f);
        } catch (IOException e) {
            return-1;
        }
        for (Integer integer : out_list) {
            try {
                out.write(integer + "\n");
            } catch (IOException e) {
                return -1;
            }
        }
        try {
            out.close();
        } catch (IOException e) {
            return -1;
        }
        return 0;
    }


    public static void getString() {
        //Get String from the file

            Scanner sc = new Scanner(System.in);
            while (true) {
            System.out.print("Enter the keyboard input string for urinals:");
            String in_str = sc.next();
            if(in_str.equals("-1")){
                break;
            }
            int out = urinalsAvailable(in_str);
            System.out.print("Free urinals that can be used as per the Unwritten rule are: " + out + "/n");
        }
    }

    static Boolean goodString(String in_str) { // checks to see if valid string
        //System.out.println("Not yet implemented");
        if (in_str.length()<1) return false;
        if (in_str.length()>20) return false;
        if (in_str.contains("11")) return false;
        char[] urinals_array = in_str.toCharArray();
        for (int i = 0; i < urinals_array.length - 1; i++){
            if(urinals_array[i]!='0'&& urinals_array[i]!='1'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //Choose from two options: 1)To enter value using keyboards. 2)Read data from urinal.dat
        int x;
        Scanner console = new Scanner(System.in);
        System.out.print("Choose: /n 1. To enter User Input. /n 2. Get data from file. ");
        x = console.nextInt();
        switch (x) {
            case 1 -> getString();
            case 2 -> {
                openFile();
                readFile();
                generateOutput();
            }
            default -> System.out.println("Invalid input");
        }
    }
}