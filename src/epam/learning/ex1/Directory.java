package epam.learning.ex1;

import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.io.File;

public class Directory extends File {

    public ArrayList<File> directoryList;

    public Directory(String path) {
        super(path);
        directoryList = new ArrayList<>();
        check();
    }

    @Override
    public File[] listFiles() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File[] listFiles(FilenameFilter filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public File[] listFiles(FileFilter filter) {
        throw new UnsupportedOperationException();
    }

    private void check() {

        File[] listFiles = super.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!directoryList.contains(file) && file.isFile()) {
                    directoryList.add(file);
                }
            }
        }


        for (File file : directoryList) {
            if (!file.exists()) {
                directoryList.remove(file);
            }
        }

    }

    public void print() {
        check();
        for (File file : directoryList) {
            if (file != null) {
                System.out.println(file.getName());
            }
        }

    }


}
