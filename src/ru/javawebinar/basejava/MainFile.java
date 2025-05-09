package ru.javawebinar.basejava;

import java.io.File;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        /*String filePath = ".gitignore";
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
        }*/

        File pathFile = new File("src/..");        
        try {
            System.out.println("=========================================");
            System.out.println("All files and directories in: " + pathFile.getCanonicalPath());
            viewFiles(pathFile.getParentFile(), "");
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

    }

    /*public static void viewFiles(File file) throws IOException {
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
    }*/

    public static void viewFiles(File directory, String offset) throws IOException {
        File[] files = directory.listFiles();

        if(files != null) {
            for (File file : files) {
                if(file.isFile()) {
                    System.out.println(offset + "f: " + file.getName());
                } else if(file.isDirectory()) {
                    System.out.println(offset + "d: "+ file.getName());
                    viewFiles(file, offset + "  ");
                }
            }
        }
    }
}
