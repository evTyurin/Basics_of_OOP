package epam.learning;

import epam.learning.ex1.Directory;
import epam.learning.ex1.TextFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Directory directory = new Directory("D:\\testDirectory");

        TextFile textFile1 = new TextFile("D:\\testDirectory\\first.txt");

        TextFile textFile2 = new TextFile("D:\\testDirectory", "second.nnn");

        TextFile textFile3 = new TextFile("D:\\testDirectory", "third.doc");

        textFile1.append("Hello friend!");
        textFile1.append("Nice to meet you");

        textFile1.renameTo("newFirst.doc");

        textFile1.delete();

        textFile1.renameTo("superFirst.txt");





    }
}


