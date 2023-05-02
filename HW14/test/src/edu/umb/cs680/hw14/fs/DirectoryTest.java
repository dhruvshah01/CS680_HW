package edu.umb.cs680.hw14.fs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class DirectoryTest {
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
    static Link y = new Link(prjRoot, "y", 0, time, src_test);
    @BeforeAll
    static void setUp(){
        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        prjRoot.appendChild(x);
        prjRoot.appendChild(y);

        src.appendChild(a);
        src.appendChild(b);

        lib.appendChild(c);

        test.appendChild(src_test);

        src_test.appendChild(d);
    }

    private String[] dirToStringArray(Directory d){
        String[] dirInfo = {d.getName(), String.valueOf(d.getSize()), (d.getParent() != null) ? String.valueOf(d.getParent().getName()):null, String.valueOf(d.getCreationTime())};
        return dirInfo;
    }
    @Test
    public void verifyEqualityForPrjRootDirectory(){
        String[] expected = {"prjRoot", "0", null, String.valueOf(time)};
        Directory actual = prjRoot;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForSrcDirectory(){
        String[] expected = {"src", "0", "prjRoot", String.valueOf(time)};
        Directory actual = src;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForLibDirectory(){
        String[] expected = {"lib", "0", "prjRoot", String.valueOf(time)};
        Directory actual = lib;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForTestDirectory(){
        String[] expected = {"test", "0", "prjRoot", String.valueOf(time)};
        Directory actual = test;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForSrcTestDirectory(){
        String[] expected = {"src", "0", "test", String.valueOf(time)};
        Directory actual = src_test;
        assertArrayEquals(expected, dirToStringArray(actual));
    }





}
