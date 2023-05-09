package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.*;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CountingVisitorTest {
    private static FileSystem fs;
    @BeforeAll
    static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifyDirectoryNumberForPrjRoot(){
        CountingVisitor v = new CountingVisitor();
        Directory dir = fs.getRootDirs().getFirst();
        dir.accept(v);
        int expected = 5;
        int actual = v.getDirNum();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyLinkNumberForPrjRoot(){
        CountingVisitor v = new CountingVisitor();
        Directory dir = fs.getRootDirs().getFirst();
        dir.accept(v);
        int expected = 1;
        int actual = v.getLinkNum();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyFileNumberForPrjRoot(){
        CountingVisitor v = new CountingVisitor();
        Directory dir = fs.getRootDirs().getFirst();
        dir.accept(v);
        int expected = 5;
        int actual = v.getFileNum();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryNumberForTest(){
        CountingVisitor v = new CountingVisitor();
        Directory test = (Directory) fs.getRootDirs().getFirst().getChildren().get(2);
        test.accept(v);
        int expected = 2;
        int actual = v.getDirNum();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyLinkNumberForTest(){
        CountingVisitor v = new CountingVisitor();
        Directory test = (Directory) fs.getRootDirs().getFirst().getChildren().get(2);
        test.accept(v);
        int expected = 0;
        int actual = v.getLinkNum();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyFileNumberForTest(){
        CountingVisitor v = new CountingVisitor();
        Directory test = (Directory) fs.getRootDirs().getFirst().getChildren().get(2);
        test.accept(v);
        int expected = 1;
        int actual = v.getFileNum();
        assertEquals(expected, actual);
    }
}
