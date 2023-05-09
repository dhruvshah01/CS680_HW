package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.*;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Objects;


public class FileCrawlingVisitorTest {
    private static FileSystem fs;
    @BeforeAll
    static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }
    @Test
    public void verifyFilesInPrjRoot(){
        Directory prjRoot = fs.getRootDirs().getFirst();
        LinkedList<File> exp_files = new LinkedList<File>();
        Directory src = (Directory) prjRoot.getChildren().get(0);
        Directory lib = (Directory) prjRoot.getChildren().get(1);
        Directory test = (Directory) prjRoot.getChildren().get(2);
        Directory src_test = (Directory) test.getChildren().get(0);

        exp_files.add((File) src.getChildren().get(0));
        exp_files.add((File) src.getChildren().get(1));
        exp_files.add((File) lib.getChildren().get(0));
        exp_files.add((File) src_test.getChildren().get(0));
        exp_files.add((File) prjRoot.getChildren().get(3));

        FileCrawlingVisitor v = new FileCrawlingVisitor();
        prjRoot.accept(v);
        LinkedList<File> act_files = v.getFiles();

        assertArrayEquals(exp_files.toArray(), act_files.toArray());

    }

    @Test
    public void verifyFilesInSrc(){
        Directory prjRoot = fs.getRootDirs().getFirst();
        LinkedList<File> exp_files = new LinkedList<File>();
        Directory src = (Directory) prjRoot.getChildren().get(0);
        exp_files.add((File) src.getChildren().get(0));
        exp_files.add((File) src.getChildren().get(1));

        FileCrawlingVisitor v = new FileCrawlingVisitor();
        src.accept(v);
        LinkedList<File> act_files = v.getFiles();

        assertArrayEquals(exp_files.toArray(), act_files.toArray());
    }
}
