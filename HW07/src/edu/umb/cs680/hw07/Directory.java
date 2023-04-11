package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Locale;

public class Directory extends FSElement{

    public LinkedList<FSElement> children = new LinkedList<FSElement>();
    public LinkedList<Directory> subDirectories;
    public LinkedList<File> files;
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
        for (FSElement fs_iterator : children){
            if (fs_iterator.isDirectory()){
                subDirectories.add((Directory) fs_iterator);
            }
        }
        return subDirectories;
    }

    public LinkedList<File> getFiles() {
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
}
