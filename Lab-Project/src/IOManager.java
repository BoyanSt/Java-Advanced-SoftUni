import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class IOManager {

    public static void createDirectoryInCurrentFolder(String name){
        String path = getCurrentDirectoryPath() + "\\" + name;
        File file = new File(path);
        file.mkdir();
    }

    public static void traverseDirectory(int depth){
        LinkedList<File> subFolders = new LinkedList<>();

        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\\\").length;

        File root = new File(path);
        subFolders.add(root);

        while (subFolders.size() != 0){
            File currentFolder = subFolders.removeFirst();
            int currentIndentation = currentFolder.toString().split("\\\\").length - depth;

            if (depth - currentIndentation < 0){
                break;
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());

            if (currentFolder.listFiles() != null ){
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()){
                        subFolders.add(file);
                    } else {
                        int indexOfLastSlash = file.toString().lastIndexOf("\\");
                        for (int i = 0; i < indexOfLastSlash; i++) {
                            OutputWriter.writeMessage("-");
                        }
                        OutputWriter.writeMessage(file.getName());
                    }
                }
            }
        }
    }

    public static void traverseDirectory(String path){
        LinkedList<File> subFolders = new LinkedList<>();
        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0){
            File currFolder = subFolders.removeFirst();

            if (currFolder.listFiles() != null){
                for (File file : currFolder.listFiles()) {

                    if (file.isDirectory()){
                        traverseDirectory(file.getPath());
                    }
                }
            }

            OutputWriter.writeMessageOnNewLine(currFolder.toString());
        }
    }

    public static void changeCurrentDirRelativePath(String relativePath){
        if (relativePath.equals("..")){
            // go one directory up
            try{
                String currentPath = SessionData.currentPath;
                int indexOfLastSlash = currentPath.lastIndexOf("\\");
                String newPath = currentPath.substring(0, indexOfLastSlash);
                SessionData.currentPath = newPath;
            } catch (StringIndexOutOfBoundsException sioobe){
                OutputWriter.writeMessageOnNewLine(ExceptionMessages.INVALID_DESTINATION);
            }

        } else {
            // go to given directory
            String currPath = SessionData.currentPath;
            currPath += currPath + "\\" + relativePath;
            changeCurrentDirAbsolute(currPath);
        }
    }

    public static void changeCurrentDirAbsolute(String absolutePath){
        File file = new File(absolutePath);
        if (!file.exists()){
            OutputWriter.writeMessageOnNewLine(ExceptionMessages.INVALID_PATH);
            return;
        }

        SessionData.currentPath = absolutePath;
    }

    private static String getCurrentDirectoryPath(){
        String path = SessionData.currentPath;
        return path;
    }
}

