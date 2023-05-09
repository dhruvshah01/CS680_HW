package edu.umb.cs680.hw14.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

public class DirectoryTest {
    private static FileSystem fs;
    public LocalDateTime ldt = LocalDateTime.now();
    @BeforeAll
    static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    private String[] dirToStringArray(Directory d){
        String[] dirInfo = {d.getName(), String.valueOf(d.getSize()), (d.getParent() != null) ? String.valueOf(d.getParent().getName()):null, String.valueOf(d.getCreationTime())};
        return dirInfo;
    }

    @Test
    public void verifyGetChildrenPrjRoot(){
        Directory dir = fs.getRootDirs().get(0);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("src");
        expected.add("lib");
        expected.add("test");
        expected.add("x");
        expected.add("y");

        LinkedList<FSElement> children = dir.getChildren();
        ArrayList<String> actual = new ArrayList<>();
        for (int i = 0; i < children.size(); i++){
            actual.add(children.get(i).getName());
        }
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void verifyGetParentSrc(){
        LinkedList<FSElement> dir = fs.getRootDirs().get(0).getChildren();
        Directory actual = dir.getFirst().getParent();
        String expected = "prjRoot";
        assertEquals(expected, actual.getName());
    }

    @Test
    public void verifyGetNameprjRoot(){
        Directory dir = fs.getRootDirs().getFirst();
        String expected = "prjRoot";
        assertEquals(expected, dir.getName());
    }

    @Test
    public void verifyGetSize(){
        Directory dir = fs.getRootDirs().getFirst();
        assertEquals(0, dir.getSize());
    }

    @Test
    public void verifyGetTotalSize(){
        Directory dir = fs.getRootDirs().getFirst();
        assertEquals(25, dir.getTotalSize());
    }

    @Test
    public void verifyCountChildren(){
        Directory dir = fs.getRootDirs().get(0);
        assertEquals(5, dir.countChildren());
    }

    @Test
    public void verifyGetSubDirectories(){
        Directory dir = fs.getRootDirs().get(0);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("src");
        expected.add("lib");
        expected.add("test");

        LinkedList<Directory> subDir = dir.getSubDirectories();
        ArrayList<String> actual = new ArrayList<>();
        for (int i = 0; i < subDir.size(); i++){
            actual.add(subDir.get(i).getName());
        }
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void verifyEqualityTestPrjRoot(){
        Directory actual = fs.getRootDirs().get(0);
        String[] expected = {"prjRoot", "0", null, actual.getCreationTime().toString()};
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForSrcDirectory(){
        Directory actual = (Directory) fs.getRootDirs().get(0).getChildren().get(0);
        String[] expected = {"src", "0", "prjRoot", String.valueOf(actual.getCreationTime())};
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @AfterAll
    public static void cleanUp() {
        fs.getRootDirs().clear();
    }

}
