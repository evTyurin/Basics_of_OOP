package epam.learning.ex1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class Directory {

    private File directory;
    private Path directoryPath;

    public File getDirectory() {
        return directory;
    }

    public Path getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectory(File directory) {
        this.directory = directory;
    }

    public void setDirectoryPath(Path directoryPath) {
        this.directoryPath = directoryPath;
    }

    public Directory () {
        //Basic directory
        directoryPath = Paths.get("D:/");

        directory = new File(directoryPath.toString());
    }

    public void showDirectoryPath () {
        System.out.println(directoryPath.normalize());
    }

    public void addDirectory (String str) {
        directoryPath = Paths.get(directoryPath.toString(), str);

        directory = new File(directoryPath.toString());

        if(directory.mkdir()) {
            System.out.println("directory created successfully");
        } else {
            System.out.println("current directory can't be created. It's already existed");
        }
    }

    public void deleteCurrentDirectory () {
        if(directory.delete()) {
            directoryPath = Paths.get(directoryPath.getParent().toString());
            directory = new File(directoryPath.toString());
            System.out.println("current directory deleted");
        } else {
            System.out.println("current directory can't be deleted. It's not empty");
        }
    }

    void showAllDirectoryFiles (Directory directory)  {
        try {
            File [] files = directory.getDirectory().listFiles();
            for (File file: files) {
                if (file.isFile()) {
                    System.out.println(file.getPath());
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}

