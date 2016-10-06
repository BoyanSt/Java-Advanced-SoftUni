import java.util.ArrayList;

/**
* Created by boyan on 10/5/2016.
*/
public class OutputWriter{
    public static void writeMessage(String message){
        System.out.print(message);
    }

    public static void writeMessageOnNewLine(String message){
        System.out.println(message);
    }

    public static void writeEmptyLine(){
        System.out.println();

    }

    public static void displayException(String message){
        System.out.println(message);

    }

    public static void printStudent(String studentName, ArrayList<Integer> marks){
        String output = String.format("%s - %s", studentName, marks.toString());
        System.out.println(output);
    }

}
