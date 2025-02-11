package ru.javawebinar.basejava;

import java.io.File;
import java.util.Date;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("src/ru/javawebinar/basejava");
        System.out.println(dir.isDirectory());

        String[] list = dir.list();
        if(list != null) {
            for (String name : dir.list()) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath);) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File pathFile = new File("src/ru/javawebinar/basejava");        
        try {
            System.out.println("=========================================");
            System.out.println("All files and directories in: " + pathFile.getCanonicalPath());
            viewFiles(pathFile);
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

    }

    public static void viewFiles(File file) throws IOException {
        if(file.isDirectory() && !file.isHidden()){
            System.out.println("d " + file.getName());
            File[] list = file.listFiles();
            for (int i = 0; i < list.length; i++) {
                viewFiles(list[i]);
            }
        }
        else {
            if(!file.isHidden()) {
                System.out.println("\t |- " + file.length() + " b\t" + new Date(file.lastModified()) + "\t" + file.getName());
            }
        }
    }
}
