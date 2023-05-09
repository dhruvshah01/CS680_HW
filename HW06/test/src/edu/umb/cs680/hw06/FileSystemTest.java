package edu.umb.cs680.hw06;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest {
    private static FileSystem fs;
    private static FileSystem fs1;
    LocalDateTime ldt = LocalDateTime.now();;
    @BeforeAll
    static void setUp(){
        fs = TestFixtureInitializer.createFS();
        fs1 = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifyFileSystemInstances(){
        assertEquals(fs, fs1);
    }

    @Test
    public void verifyGetRootDirsAndAppendRootDir(){
        Directory root = new Directory(null, "root", 0, ldt);
        fs.appendRootDir(root);
        String expected = "root";
        String actual = fs.getRootDirs().get(2).getName();
        assertEquals(expected, actual);
    }

    @AfterAll
    public static void cleanUp() {
        fs.getRootDirs().clear();
    }
}
