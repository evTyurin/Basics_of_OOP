package epam.learning.ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.nio.file.*;

public class TextFile extends File {

    private StringBuilder filePath;

    public TextFile(String path) {
        super(path);
        try {
            create();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        filePath = new StringBuilder(getAbsolutePath());
    }

    public TextFile(String path, String name) {
        super(path, name);
        try {
            create();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        filePath = new StringBuilder(getAbsolutePath());
    }

    public StringBuilder getFilePath() {
        return filePath;
    }

    public void setFilePath(StringBuilder filePath) {
        this.filePath = filePath;
    }

    private boolean check (String newFileName) {
        String regEx = "[A-Z]:[/a-zA-Z0-9]*([A-z0-9:]+\\.(txt|doc))$";
        String path = getParent() + "\\" + newFileName;

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(path);

        return matcher.find();
    }

    private void create () throws IOException {
        if (check(getName())) {
            try {
                if (createNewFile()) {
                    System.out.println("text file " + getName() + " created");
                } else {
                    System.out.println("already exists: " + getPath());
                }
            } catch (IOException ex) {
                System.out.println("Input and output operations fail");
            }
        } else {
            System.out.println("Invalid file format");
        }
    }

    public void print() {
        try (Scanner sc = new Scanner(new File(filePath.toString()))){
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Directory is not empty.");
        }
    }

    public void append(String newText) {
        try(Scanner textScan = new Scanner(new File(filePath.toString()))){

            StringBuilder fileText = new StringBuilder();
            while (textScan.hasNextLine()) {
                fileText.append(textScan.nextLine()).append(System.lineSeparator());
            }

            try(FileWriter fileWriter = new FileWriter(filePath.toString())) {
                fileWriter.write(fileText.toString());
                fileWriter.write(newText);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Directory is not empty.");
        } catch (IOException e) {
            System.out.println("Input and output operations fail");
        }
    }

    public void renameTo(String newFileName) {

        String path = getParent() + "\\" + newFileName;

        if (check(newFileName)) {

            try (Scanner scanner = new Scanner(new File(filePath.toString()));
                 FileWriter fileWriter = new FileWriter(path))  {
                StringBuilder fileText = new StringBuilder();

                while (scanner.hasNextLine()) {
                    fileText.append(scanner.nextLine()).append(System.lineSeparator());
                }

                fileWriter.write(fileText.toString());

            } catch (IOException e) {
                System.out.println("Input and output operations fail");
            } finally {

                if (delete()) {
                    filePath.replace(0, filePath.length(), "");
                    filePath.append(getParent()).append("\\").append(newFileName);
                }

            }

        }  else {
            System.out.println("Invalid file format");
        }

    }

    public boolean delete() {
        try {
            if (filePath != null) {
                return Files.deleteIfExists(Paths.get(filePath.toString()));
            }
        } catch(NoSuchFileException e) {
            System.out.println("No such file/directory exists");
        } catch(DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty.");
        } catch(IOException e) {
            System.out.println("Input and output operations fail");
        }
        return false;
    }


}

