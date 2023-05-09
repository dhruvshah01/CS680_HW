package edu.umb.cs680.hw12.fs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AlphabeticalComparatorTest {
    private static FileSystem fs;
    @BeforeAll
    static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifyGetChildrenAlphabeticalComparator(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(0);
        Directory lib = (Directory) prjRoot.getChildren().get(1);
        Directory test = (Directory) prjRoot.getChildren().get(2);
        File x = (File) prjRoot.getChildren().get(3);
        Link y = (Link) prjRoot.getChildren().get(4);
        FSElement expected[] = {lib, src, test, x, y};

        List<FSElement> actual = prjRoot.getChildren(new AlphabeticalComparator());
        assertArrayEquals(actual.toArray(), expected);
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetFilesAlphabeticalComparatorPrjRoot(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        File x = (File) prjRoot.getChildren().get(3);
        FSElement expected[] = {x};
        LinkedList<File> actual = prjRoot.getFiles(new AlphabeticalComparator());
        assertArrayEquals(actual.toArray(), expected);
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetFilesAlphabeticalComparatorSrc(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(0);
        File a = (File) src.getChildren().get(0);
        File b = (File) src.getChildren().get(1);
        FSElement expected[] = {a, b};

        LinkedList<File> actual = src.getFiles(new AlphabeticalComparator());
        assertArrayEquals(actual.toArray(), expected);
        fs.getRootDirs().clear();
    }

    @Test
    public void verifyGetSubDirectoriesAlphabeticalComparator(){
        fs = TestFixtureInitializer.createFS();
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory src = (Directory) prjRoot.getChildren().get(0);
        Directory lib = (Directory) prjRoot.getChildren().get(1);
        Directory test = (Directory) prjRoot.getChildren().get(2);
        FSElement expected[] = {lib, src, test};
        LinkedList<Directory> fse = prjRoot.getSubDirectories(new AlphabeticalComparator());
        assertArrayEquals(fse.toArray(), expected);
        fs.getRootDirs().clear();
    }

}
