package edu.umb.cs680.hw07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class FileTest {
    private static FileSystem fs;
    @BeforeAll
    static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    private String[] fileToStringArray(File f){
        String[] fileInfo = {f.getName(), String.valueOf(f.getSize()), (f.getParent() != null) ? String.valueOf(f.getParent().getName()):null, String.valueOf(f.getCreationTime())};
        return fileInfo;
    }

    @Test
    public void verifyGetNameSrc(){
        Directory src = (Directory) fs.getRootDirs().getFirst().getChildren().get(0);
        String expected[] = {"a", "b"};
        String actual[] = new String[src.getFiles().size()];
        for (int i = 0; i < src.getFiles().size(); i++){
            actual[i] = src.getChildren().get(i).getName();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyGetSizeSrcForFileA(){
        Directory src = (Directory) fs.getRootDirs().getFirst().getChildren().get(0);
        int actual = src.getChildren().get(0).getSize();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void verifyGetParentForFileX(){
        Directory prjRoot = fs.getRootDirs().getFirst();
        File actual = (File) prjRoot.getChildren().get(3);
        String expected = "prjRoot";
        assertEquals(expected, actual.getParent().getName());
    }

    @Test
    public void verifyEqualityForFileA(){

        Directory dir = (Directory) fs.getRootDirs().get(0).getChildren().get(0);
        File actual = (File) dir.getChildren().get(0);
        String[] expected = {"a", "5", "src", String.valueOf(actual.getCreationTime())};
        assertArrayEquals(expected, fileToStringArray(actual));
    }




    @AfterAll
    public static void cleanUp() {
        fs.getRootDirs().clear();
    }
}
