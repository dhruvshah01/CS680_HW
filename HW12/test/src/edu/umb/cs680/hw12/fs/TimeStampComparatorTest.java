package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TimeStampComparatorTest {
    private static FileSystem fs;
    @BeforeAll
    static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifyGetChildrenTimeStampComparator(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(0);
        Directory lib = (Directory) prjRoot.getChildren().get(1);
        Directory test = (Directory) prjRoot.getChildren().get(2);
        File x = (File) prjRoot.getChildren().get(3);
        Link y = (Link) prjRoot.getChildren().get(4);
        FSElement expected[] = {src, lib, test, x, y};
        List<FSElement> actual = prjRoot.getChildren(new TimeStampComparator());
        assertArrayEquals(actual.toArray(), expected);
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetFilesTimeStampComparatorPrjRoot(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        File x = (File) prjRoot.getChildren().get(3);
        FSElement expected[] = {x};
        LinkedList<File> actual = prjRoot.getFiles(new TimeStampComparator());
        assertArrayEquals(actual.toArray(), expected);
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetFilesTimeStampComparatorSrc(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(0);
        File a = (File) src.getChildren().get(0);
        File b = (File) src.getChildren().get(1);
        FSElement expected[] = {a, b};
        LinkedList<File> actual = src.getFiles(new TimeStampComparator());
        assertArrayEquals(actual.toArray(), expected);
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetSubDirectoriesTimeStampComparator(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(0);
        Directory lib = (Directory) prjRoot.getChildren().get(1);
        Directory test = (Directory) prjRoot.getChildren().get(2);
        FSElement expected[] = {src, lib, test};
        LinkedList<Directory> actual = prjRoot.getSubDirectories(new TimeStampComparator());
        assertArrayEquals(actual.toArray(), expected);
        fs.getRootDirs().clear();
    }

}
