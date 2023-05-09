package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.*;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Objects;
public class FileSearchVisitorTest {
    private static FileSystem fs;
    @BeforeAll
    static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }
    @Test
    public void verifyGetFoundFiles(){
        Directory dir = fs.getRootDirs().getFirst();
        FileSearchVisitor v = new FileSearchVisitor("a");
        dir.accept(v);
        assertEquals("a", v.getFoundFiles().get(0).getName());
    }

    @Test
    public void verifyGetFoundFilesForMultipleFiles(){
        Directory prjRoot = fs.getRootDirs().getFirst();
        Directory src = (Directory) prjRoot.getChildren().get(0);
        FileSearchVisitor v = new FileSearchVisitor("a");
        src.accept(v);
        v.setFileName("b");
        src.accept(v);
        LinkedList<File> actual = v.getFoundFiles();

        LinkedList<File> expected = new LinkedList<File>();
        expected.add((File) src.getChildren().get(0));
        expected.add((File) src.getChildren().get(1));

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
