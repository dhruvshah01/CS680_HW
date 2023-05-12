package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseAlphabeticalComparatorTest {
    private static FileSystem fs;
    @BeforeAll
    static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }
    @Test
    public void verifyGetChildrenReverseAlphabeticalComparator(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(1);
        Directory lib = (Directory) prjRoot.getChildren().get(0);
        Directory test = (Directory) prjRoot.getChildren().get(2);
        File x = (File) prjRoot.getChildren().get(3);
        Link y = (Link) prjRoot.getChildren().get(4);
        FSElement expected[] = {y, x, test, src, lib};
        List<FSElement> actual = prjRoot.getChildren(new ReverseAlphabeticalComparator());
        assertArrayEquals(expected, actual.toArray());
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetFilesReverseAlphabeticalComparatorPrjRoot(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        File x = (File) prjRoot.getChildren().get(3);
        FSElement expected[] = {x};
        LinkedList<File> fse = prjRoot.getFiles(new ReverseAlphabeticalComparator());
        assertArrayEquals(fse.toArray(), expected);
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetFilesReverseAlphabeticalComparatorSrc(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(1);
        File a = (File) src.getFiles().get(0);
        File b = (File) src.getFiles().get(1);
        FSElement expected[] = {b, a};
        LinkedList<File> actual = src.getFiles(new ReverseAlphabeticalComparator());
        assertArrayEquals(actual.toArray(), expected);
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetSubDirectoriesReverseAlphabeticalComparator(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(1);
        Directory lib = (Directory) prjRoot.getChildren().get(0);
        Directory test = (Directory) prjRoot.getChildren().get(2);
        FSElement expected[] = {test, src, lib};
        LinkedList<Directory> actual = prjRoot.getSubDirectories(new ReverseAlphabeticalComparator());
        assertArrayEquals(actual.toArray(), expected);
        fs.getRootDirs().clear();
    }


}
