import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void compareContent(String actualOutput, String expectedOutput){
        OutputWriter.writeMessageOnNewLine("Reading files...");
        String mismatchPath = getMismatchPath(expectedOutput);
        try{

            List<String> actualOutputString = readTextFile(actualOutput);
            List<String> expectedOutputString = readTextFile(expectedOutput);

            boolean isMismatch = compareStrings(actualOutputString, expectedOutputString,
                    mismatchPath);

            if (isMismatch){
                List<String> mismatchText = readTextFile(mismatchPath);
                mismatchText.forEach(OutputWriter::writeMessageOnNewLine);
            } else {
                OutputWriter.writeMessageOnNewLine("Files are identical. " +
                        "There are not mismatches.");
            }

        } catch (IOException ex){
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
        }





    }

    private static String getMismatchPath(String expectedOutput){
        int index = expectedOutput.lastIndexOf("\\");
        String directoryPath = expectedOutput.substring(0, index);
        return directoryPath + "\\mismatch.txt";
    }

    private static List<String> readTextFile(String filePath) throws IOException {
        List<String> text = new ArrayList<>();

            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();

            while (line!=null && !line.equals("")){
                text.add(line);
                line = reader.readLine();
            }

            reader.close();


        return text;
    }

    private static boolean compareStrings(List<String> actualOutputString,
                                          List<String> expectedOutputString,
                                          String mismatchPath){
        OutputWriter.writeMessageOnNewLine("Comparing files...");
        String output = "";
        boolean isMismatch = false;

        try {
            FileWriter fileWriter = new FileWriter(mismatchPath);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            int maxLength = Math.max(expectedOutputString.size(),
                    actualOutputString.size());

            for (int i = 0; i < maxLength; i++) {
                String actualLine = actualOutputString.get(i);
                String expectedLine = expectedOutputString.get(i);

                 if (!actualLine.equals(expectedLine)){
                     output = String.format("mismatch -> expected{%s}, " +
                             "actual{%s}%n", expectedLine, actualLine);
                     isMismatch = true;
                 } else {
                     output = String.format("line match -> %s%n",actualLine);
                 }
                 writer.write(output);
            }

            writer.close();

        } catch (IOException ioe){
            isMismatch = true;
            OutputWriter.writeMessageOnNewLine(ExceptionMessages.CANNOT_ACCESS_FILE);
        } catch (IndexOutOfBoundsException ex){
            isMismatch = true;
            OutputWriter.writeMessage(ExceptionMessages.INVALID_OUTPUT_LENGTH);
        }

        return isMismatch;
    }
}
