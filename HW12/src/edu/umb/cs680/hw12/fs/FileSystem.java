package edu.umb.cs680.hw12.fs;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem fileSystem_Instance = new FileSystem();
    private LinkedList<Directory> RootDirs = new LinkedList<Directory>();
    private FileSystem(){};

    public static FileSystem getFileSystem(){
        return fileSystem_Instance;
    }

    public LinkedList<Directory> getRootDirs(){
        return this.RootDirs;
    }

    public void appendRootDir(Directory root){
        this.RootDirs.add(root);
    }

    public static void main(String[] args) {
        System.out.println("Implemented FileSystem with Comparator");
    }
}
