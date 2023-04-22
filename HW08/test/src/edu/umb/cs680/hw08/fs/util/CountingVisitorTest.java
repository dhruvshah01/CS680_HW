package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.*;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CountingVisitorTest {
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

    @Test
    public void verifyDirectoryNumberForPrjRoot(){
        CountingVisitor v = new CountingVisitor();
        prjRoot.accept(v);
        int expected = 5;
        int actual = v.getDirNum();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyLinkNumberForPrjRoot(){
        CountingVisitor v = new CountingVisitor();
        prjRoot.accept(v);
        int expected = 1;
        int actual = v.getLinkNum();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyFileNumberForPrjRoot(){
        CountingVisitor v = new CountingVisitor();
        prjRoot.accept(v);
        int expected = 5;
        int actual = v.getFileNum();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryNumberForTest(){
        CountingVisitor v = new CountingVisitor();
        test.accept(v);
        int expected = 2;
        int actual = v.getDirNum();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyLinkNumberForTest(){
        CountingVisitor v = new CountingVisitor();
        test.accept(v);
        int expected = 0;
        int actual = v.getLinkNum();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyFileNumberForTest(){
        CountingVisitor v = new CountingVisitor();
        test.accept(v);
        int expected = 1;
        int actual = v.getFileNum();
        assertEquals(expected, actual);
    }
}
