package epam.learning.ex1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TextFile extends RegularFile{

    private Directory directory;
    private File file;
    private Path filePath;

    public TextFile () {
        super();
        this.directory = super.getDirectory();
        this.file = super.getFile();
        this.filePath = directory.getDirectoryPath();
    }

    @Override
    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public Directory getDirectory() {
        return directory;
    }

    public void writeIntoFile (String fileName, String newText) {
        filePath = Paths.get(directory.getDirectoryPath().toString(), fileName);

        try {
            byte[] bytes = Files.readAllBytes(filePath);
            String text = new String(bytes);

            FileWriter fw = new FileWriter(filePath.normalize().toString());
            fw.write(text);
            fw.append(newText);
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void readFromFile (String fileName) {
        filePath = Paths.get(directory.getDirectoryPath().toString(), fileName);
        try {
            byte[] bytes = Files.readAllBytes(filePath);
            String text = new String(bytes);
            System.out.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

