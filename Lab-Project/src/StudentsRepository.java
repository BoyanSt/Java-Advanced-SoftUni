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

    public static void initializeData(){
        if (isDataInitialized){
            System.out.println(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        setStudentsByCourse();
        readData();
    }

    public static void readData(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String course = "";
        String student = "";
        int mark;

        while (!input.equals("")){
            String[] token = input.split("\\s+");
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

            input = scan.nextLine();
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
