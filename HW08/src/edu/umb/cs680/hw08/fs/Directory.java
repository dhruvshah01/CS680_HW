package edu.umb.cs680.hw08.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Locale;

public class Directory extends FSElement{

    public LinkedList<FSElement> children = new LinkedList<FSElement>();

    public int totalSize;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime){
        super(parent, name, 0, creationTime);
    }
    public LinkedList<FSElement> getChildren(){
        return this.children;
    }

    public void appendChild(FSElement child){
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren(){
        return getChildren().size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirectories = new LinkedList<>();
        for (FSElement fs_iterator : this.children){
            if (fs_iterator.isDirectory()){
                subDirectories.add((Directory) fs_iterator);
            }
        }
        return subDirectories;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement fs_iterator : children){
            if (fs_iterator.isFile()){
                files.add((File) fs_iterator);
            }
        }
        return files;
    }

    public int getTotalSize() {
        totalSize = 0;
        for (FSElement fs_iterator : children){
            if (fs_iterator.isDirectory()) {
                totalSize += ((Directory) fs_iterator).getTotalSize();
            } else {
                totalSize += fs_iterator.getSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory(){
        return true;
    }

    @Override
    public boolean isFile(){
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement fs_iterator : children){
            fs_iterator.accept(v);
        }
    }
}
