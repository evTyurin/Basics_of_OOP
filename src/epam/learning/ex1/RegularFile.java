package epam.learning.ex1;

import java.io.File;
import java.io.IOException;

public abstract class RegularFile {

    private Directory directory;
    private File file;

    public RegularFile () {
        directory = new Directory();
        file = new File(directory.getDirectory().toString()); //???
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void createFile (String fileName) {
        file = new File(directory.getDirectoryPath().toString() + "//" + fileName);
        try {
            if(file.createNewFile())
                System.out.println("File has been created");
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteFile (String fileName) {
        file = new File(directory.getDirectoryPath().toString() + "//" + fileName);
        if (file.delete()) {
            System.out.println("file was deleted successfully");
        } else {
            System.out.println("this file not exist");
        }
    }

    public void showAllDirectoryFiles (Directory directory)  {
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

    public void renameFile (String currentFileName, String newFileName) {
        file = new File(directory.getDirectoryPath().toString() + "//" + currentFileName);
        File newFile = new File(directory.getDirectoryPath().toString() + "//" + newFileName);
        if (file.renameTo(newFile)) {
            System.out.println("File name changed successfully");
        } else {
            System.out.println("File name changed unsuccessfully");
        }
    }


}

