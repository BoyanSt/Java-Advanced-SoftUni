import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CommandInterpreter {
    public static void interpretCommand(String input) {
        String[] data = input.split("\\s+");
        String command = data[0];
        switch (command){
            case "open":
                tryOpenFile(input, data);
                break;
            case "mkdir":
                tryMakeDirectory(input, data);
                break;
            case "ls":
                tryTraverseFolder(input,data);
                break;
            case "cmp":
                tryCompareTwoFiles(input,data);
                break;
            case "changeDirRel":
                tryChangeRelativeDirectory(input, data);
                break;
            case "changeDirAbs":
                tryChangeAbsolutePath(input, data);
                break;
            case "readDb":
                tryToReadDataFromFile(input, data);
                break;
            case "filter":
                break;
            case "order":
                break;
            case "download":
                break;
            case "downloadAsynch":
                break;
            case "help":
                printHelp();
                break;
//            •	mkdir directoryName – make directory in current directory
//            •	ls (depth) – traverse current directory in given depth
//            •	cmp absolutePath1 absolutePath2 – comparing two files by given two absolute paths
//            •	changeDirRel relativePath – change current directory by a relative path
//            •	changeDirAbs absolutePath – change current directory by an absolute path
//            •	readDb dataBaseFileName –
// read students data base by given the name of the data base file which is searched in the current folder
//            •	filter courseName poor/average/excellent take 2/10/42/all – filter students from some course by given filter and add quantity for the number of students to take, or all, if you want to take all the students matching the current filter
//            •	order courseName ascending/descending take 3/26/52/all – order student from given course by ascending or descending order and then taking some quantity of the filter, or all that match it
//            •	download (path of file) – download file
//            •	downloadAsynch: (path of file) – download file asynchronously
//            •	help – get help
//            •	open – open file
            default:
                displayInvalidInputMessage(input);
                break;
        }
    }

    private static void displayInvalidInputMessage(String inputCmd){
        OutputWriter.writeMessageOnNewLine(
                String.format("The command %s is invalid", inputCmd));
    }

    private static void tryOpenFile(String input, String[] data){
        if (data.length != 2){
            displayInvalidInputMessage(input);
            return;
        }

        String fileName = data[1];
        String filePath = SessionData.currentPath + "\\" + fileName;
        File file = new File(filePath);

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            OutputWriter.writeMessageOnNewLine(ExceptionMessages.INVALID_DESTINATION);
        }
    }

    private static void tryMakeDirectory(String input, String[] data){
        if (data.length != 2){
            displayInvalidInputMessage(input);
            return;
        }

        String dirName = data[1];
        IOManager.createDirectoryInCurrentFolder(dirName);
    }

    private static void tryTraverseFolder(String input, String[] data){
        if (data.length != 1 && data.length != 2){
            displayInvalidInputMessage(input);
            return;
        }

        if (data.length == 1){
            IOManager.traverseDirectory(0);
        }

        if (data.length == 2){
            IOManager.traverseDirectory(Integer.parseInt(data[1]));
        }
    }

    private static void tryCompareTwoFiles(String input, String[] data){
        if (data.length != 3){
            displayInvalidInputMessage(input);
            return;
        }

        String firstPath = data[1];
        String secondPath = data[2];

        Tester.compareContent(firstPath, secondPath);
    }

    private static void tryChangeRelativeDirectory(String input, String[] data){
        if (data.length != 2){
            displayInvalidInputMessage(input);
        }

        String relativePath = data[1];
        IOManager.changeCurrentDirRelativePath(relativePath);
    }

    private static void tryChangeAbsolutePath(String input, String[] data){
        if (data.length != 2){
            displayInvalidInputMessage(input);
        }

        String absPath = data[1];
        IOManager.changeCurrentDirAbsolute(absPath);
    }

    private static void tryToReadDataFromFile(String input, String[] data) {
        if (data.length != 2){
            displayInvalidInputMessage(input);
        }

        String file = data[1];
        StudentsRepository.initializeData(file);
    }

    private static void printHelp(){
        OutputWriter.writeMessageOnNewLine("mkdir path - make directory");
        OutputWriter.writeMessageOnNewLine("ls depth - traverse directory");
        OutputWriter.writeMessageOnNewLine("cmp path1 path2 - compare two files");
        OutputWriter.writeMessageOnNewLine("changeDirRel relativePath - change directory");
        OutputWriter.writeMessageOnNewLine("changeDir absolutePath - change directory");
        OutputWriter.writeMessageOnNewLine("readDb path - read students data base");
        OutputWriter.writeMessageOnNewLine("filterExcelent - filter excelent students (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("filterExcelent path - filter excelent students (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("filterAverage - filter average students (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("filterAverage path - filter average students (the output is written in a file)");
        OutputWriter.writeMessageOnNewLine("filterPoor - filter low grade students (the output is on the console)");
        OutputWriter.writeMessageOnNewLine("filterPoor path - filter low grade students (the output is written in a file)");
        OutputWriter.writeMessageOnNewLine("order - sort students in increasing order (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("order path - sort students in increasing order (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("decOrder - sort students in decreasing order (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("decOrder path - sort students in decreasing order (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("download pathOfFile - download file (saved in current directory)");
        OutputWriter.writeMessageOnNewLine("downloadAsync path - download file asynchronously (save in the current directory)");
        OutputWriter.writeMessageOnNewLine("help - get help");
        OutputWriter.writeEmptyLine();
    }

}
