package epam.learning;

import epam.learning.ex1.TextFile;

public class Main {

    public static void main(String[] args) {

//        Directory dir = new Directory();
//        dir.showDirectoryPath();
//        dir.addDirectory("hello");
//        dir.showDirectoryPath();
//        dir.addDirectory("hello");
//        dir.showDirectoryPath();
//        dir.addDirectory("hello");
//        dir.showDirectoryPath();
//        dir.deleteCurrentDirectory();
//        dir.showDirectoryPath();

//        RegularFile regFile = new RegularFile();
//        regFile.getDirectory().addDirectory("lol");
//        regFile.createFile("tot");
//        regFile.createFile("hot");
//        System.out.println(regFile.getDirectory().getDirectoryPath());
//        regFile.showAllDirectoryFiles(regFile.getDirectory());
//        regFile.deleteFile("tot");
//        System.out.println(regFile.getDirectory().getDirectoryPath());
//        regFile.renameFile("hot", "wrot");

        TextFile regFile = new TextFile();
        regFile.getDirectory().addDirectory("lol");
        regFile.createFile("tot.txt");
        regFile.createFile("hot.txt");
        System.out.println(regFile.getDirectory().getDirectoryPath());
        regFile.showAllDirectoryFiles(regFile.getDirectory());
//        regFile.deleteFile("tot");
//        System.out.println(regFile.getDirectory().getDirectoryPath());
        regFile.renameFile("hot.txt", "wrot.txt");
//        regFile.deleteFile("wrot");
//        regFile.writeIntoFile("wrot.txt", "dfdfd");
        regFile.readFromFile("wrot.txt");
//        regFile.writeIntoFile("wrot.txt","444444");
        regFile.writeIntoFile("wrot.txt", " 88888");
        regFile.readFromFile("wrot.txt");




//        dir.addDirectory("abcd");
//        File newDirectory = new File(dir.getStringBuilder().toString());
//        try
//        {
//            boolean creat = newDirectory.mkdir();
//            boolean created = newFile.createNewFile();
//            if(created)
//                System.out.println("File has been created");
//        }
//        catch(IOException ex){
//
//            System.out.println(ex.getMessage());
//        }
//        System.out.println(newDirectory.getPath());
//
//        Directory directory = new Directory();
//        directory.showDirectory();
//        directory.addDirectory("mydoc");


    }
}


