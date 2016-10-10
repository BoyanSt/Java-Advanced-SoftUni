import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class StudentsRepository {

    private static boolean isDataInitialized = false;
    private static HashMap<String, HashMap<String, ArrayList<Integer>>> studentsByCourse;

    public static void setIsDataInitialized(boolean isDataInitialized) {
        StudentsRepository.isDataInitialized = isDataInitialized;
    }

    public static void setStudentsByCourse() {
        studentsByCourse =
                new HashMap<String, HashMap<String, ArrayList<Integer>>>();
    }

    public static HashMap<String, HashMap<String, ArrayList<Integer>>> getStudentsByCourse() {
        return studentsByCourse;
    }

    public static boolean getIsDataInitialized(){
        return isDataInitialized;
    }

    public static void initializeData(String fileName) {
        if (isDataInitialized){
            System.out.println(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        setStudentsByCourse();

        try {
            readData(fileName);
        } catch (IOException e){
            OutputWriter.writeMessageOnNewLine(ExceptionMessages.INVALID_PATH);
        }

    }

    public static void readData(String fileName) throws IOException {

        String path = SessionData.currentPath + "\\" + fileName;
        List<String> lines = Files.readAllLines(Paths.get(path));
        String course = "";
        String student = "";
        int mark;

        for (String line : lines) {
            String[] token = line.split("\\s+");

            if (token.length != 3){
                OutputWriter.writeMessageOnNewLine(ExceptionMessages.INVALID_INPUTDATA_FILE);
                return;
            }
            course = token[0];
            student = token[1];
            mark = Integer.parseInt(token[2]);

            if (!studentsByCourse.containsKey(course)){
                studentsByCourse.put(course, new HashMap<>());
                studentsByCourse.get(course).put(student, new ArrayList<>());
                studentsByCourse.get(course).get(student).add(mark);
            } else {
                if (!studentsByCourse.get(course).containsKey(student)){
                    studentsByCourse.get(course).put(student, new ArrayList<>());
                    studentsByCourse.get(course).get(student).add(mark);
                } else {
                    studentsByCourse.get(course).get(student).add(mark);
                }
            }

        }

        isDataInitialized = true;
        OutputWriter.writeMessageOnNewLine("Data read.");

    }

    private static boolean isQueryForCoursePossible(String courseName){
        if (!isDataInitialized){
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }

        if (!studentsByCourse.containsKey(courseName)){
            OutputWriter.displayException(ExceptionMessages.NON_EXISTENT_COURSE);
        }
        return true;
    }

    private static boolean isQueryForStudentPossible(String courseName, String studentName){

        if (isQueryForCoursePossible(courseName)){
            return false;
        }

        if (!studentsByCourse.get(courseName).containsKey(studentName)){
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_STUDENT);
            return false;
        }
        return true;
    }

    public static void getStudentMarksInCourse(String course, String studentName){
        if (isQueryForStudentPossible(course, studentName)){
            return;
        }
        ArrayList<Integer> marks = studentsByCourse.get(course).get(studentName);
        OutputWriter.printStudent(studentName, marks);
    }

    public static void getStudentsByCourse(String course){
        if (!isQueryForCoursePossible(course)){
            return;
        }
        OutputWriter.writeMessageOnNewLine(course + ":");
        HashMap<String, ArrayList<Integer>> studentsNotes = studentsByCourse.get(course);
        for (Map.Entry<String, ArrayList<Integer>> entry : studentsNotes.entrySet()) {
            OutputWriter.printStudent(entry.getKey(), entry.getValue());
        }
    }


}
