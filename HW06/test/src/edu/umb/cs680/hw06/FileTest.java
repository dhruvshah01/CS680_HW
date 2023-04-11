package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class FileTest {
    public static LocalDateTime time = LocalDateTime.now();
    static Directory prjRoot = new Directory(null, "prjRoot", 0, time);
    static Directory src = new Directory(prjRoot, "src", 0, time);
    static Directory lib = new Directory(prjRoot, "lib", 0, time);
    static Directory test = new Directory(prjRoot, "test", 0, time);

    static Directory src_test = new Directory(test, "src", 0, time);
    static File a = new File(src, "a", 5, time);
    static File b = new File(src, "b", 5, time);
    static File c = new File(lib, "c", 5, time);
    static File d = new File(src_test, "d", 5, time);
    static File x = new File(prjRoot, "x", 5, time);
    @BeforeAll
    static void setUp(){
        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        prjRoot.appendChild(x);

        src.appendChild(a);
        src.appendChild(b);

        lib.appendChild(c);

        test.appendChild(src_test);

        src_test.appendChild(d);
    }

    private String[] fileToStringArray(File f){
        String[] fileInfo = {f.getName(), String.valueOf(f.getSize()), (f.getParent() != null) ? String.valueOf(f.getParent().getName()):null, String.valueOf(d.getCreationTime())};
        return fileInfo;
    }

    @Test
    public void verifyEqualityForFileA(){
        String[] expected = {"a", "5", "src", String.valueOf(time)};
        File actual = a;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityForFileB(){
        String[] expected = {"b", "5", "src", String.valueOf(time)};
        File actual = b;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityForFileC(){
        String[] expected = {"c", "5", "lib", String.valueOf(time)};
        File actual = c;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityForFileD(){
        String[] expected = {"d", "5", "src", String.valueOf(time)};
        File actual = d;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityForFileDX(){
        String[] expected = {"x", "5", "prjRoot", String.valueOf(time)};
        File actual = x;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

}
