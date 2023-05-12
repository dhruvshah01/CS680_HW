package edu.umb.cs680.hw14.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SizeComparatorTest {
    private static FileSystem fs;
    @BeforeAll
    static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifyGetChildren(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(0);
        Directory lib = (Directory) prjRoot.getChildren().get(1);
        Directory test = (Directory) prjRoot.getChildren().get(2);
        File x = (File) prjRoot.getChildren().get(3);
        Link y = (Link) prjRoot.getChildren().get(4);
        FSElement expected[] = {src, lib, test, y, x};
        LinkedList<FSElement> actual = prjRoot.getChildren((FSElement fs1, FSElement fs2) -> {
            return fs1.getSize() - fs2.getSize();
        });
        assertArrayEquals(expected, actual.toArray());
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetFilesPrjRoot(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        File x = (File) prjRoot.getChildren().get(3);
        FSElement expected[] = {x};
        LinkedList<File> actual = prjRoot.getFiles((FSElement fs1, FSElement fs2) -> {
            return fs1.getSize() - fs2.getSize();
        });
        assertArrayEquals(expected, actual.toArray());
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetFilesSrc(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(0);
        File a = (File) src.getChildren().get(0);
        File b = (File) src.getChildren().get(1);
        FSElement expected[] = {a, b};
        LinkedList<File> actual = src.getFiles((FSElement fs1, FSElement fs2) -> {
            return fs1.getSize() - fs2.getSize();
        });
        assertArrayEquals(expected, actual.toArray());
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetSubDirectories(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(0);
        Directory lib = (Directory) prjRoot.getChildren().get(1);
        Directory test = (Directory) prjRoot.getChildren().get(2);

        FSElement expected[] = {src, lib, test};
        LinkedList<Directory> actual = prjRoot.getSubDirectories((FSElement fs1, FSElement fs2) -> {
            return fs1.getSize() - (fs2.getSize());
        });
        assertArrayEquals(expected, actual.toArray());
        fs.getRootDirs().clear();
    }
}
