package edu.umb.cs680.hw14.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class LinkTest {
    private static FileSystem fs;
    @BeforeAll
    static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifyGetTarget(){
        String expected = "src";
        Link link = (Link) fs.getRootDirs().getFirst().getChildren().getLast();
        String actual = link.getTarget().getName();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyGetParent(){
        String expected = "prjRoot";
        Link link = (Link) fs.getRootDirs().getFirst().getChildren().getLast();
        String actual = link.getParent().getName();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyGetSize(){
        Link link = (Link) fs.getRootDirs().getFirst().getChildren().getLast();
        int actual = link.getSize();
        assertEquals(0, actual);
    }

    @AfterAll
    public static void cleanUp() {
        fs.getRootDirs().clear();
    }



}
