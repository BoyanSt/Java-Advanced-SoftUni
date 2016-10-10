import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
//        IOManager.changeCurrentDirAbsolute("C:");


        OutputWriter.writeMessage(String.format("%s -> ", SessionData.currentPath));
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        while (!input.equals(Messages.END_COMMAND)){
            CommandInterpreter.interpretCommand(input);
            OutputWriter.writeMessage(String.format("%s -> ", SessionData.currentPath));
            input = sc.nextLine().trim();
        }



//        IOManager.changeCurrentDirRelativePath("..");
//        System.out.println(SessionData.currentPath);

//        String test1Path = "res\\actual.txt";
//        String test2Path = "res\\expected.txt";
//        Tester.compareContent(test1Path, test2Path);

//        IOManager.traverseDirectory(5);

//        IOManager.changeCurrentDirAbsolute("D:\\ZoomIt");
//        IOManager.traverseDirectory(5);

//        IOManager.createDirectoryInCurrentFolder("myDirectory");


//        OutputWriter.traverseDirectory("D:\\03_ausbildung-Informatik\\Advanced-JavaScript");
//        StudentsRepository.initializeData();
//        StudentsRepository.getStudentsByCourse("Unity");
//        OutputWriter.writeMessageOnNewLine("Student Ivan has the following notes in Java:");
//        StudentsRepository.getStudentMarksInCourse("Unity", "Ivan");
//        OutputWriter.writeMessageOnNewLine(
//                "Student Lila haste the following notes in Java Fundamentals");
//        StudentsRepository.getStudentMarksInCourse("Java_fundamentals", "Lila");
    }
}

