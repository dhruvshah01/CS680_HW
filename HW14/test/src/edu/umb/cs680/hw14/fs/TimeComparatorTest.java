package edu.umb.cs680.hw14.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TimeComparatorTest {
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
    public void verifyGetChildren(){
        FSElement expected[] = {src, lib, test, x, y};
        LinkedList<FSElement> actual = prjRoot.getChildren((FSElement fs1, FSElement fs2) -> {
            return fs1.getCreationTime().compareTo(fs2.getCreationTime());
        });
        assertArrayEquals(actual.toArray(), expected);
    }

    @Test
    public void verifyGetFilesPrjRoot(){
        FSElement expected[] = {x};
        LinkedList<File> actual = prjRoot.getFiles((FSElement fs1, FSElement fs2) -> {
            return fs1.getCreationTime().compareTo(fs2.getCreationTime());
        });
        assertArrayEquals(actual.toArray(), expected);
    }

    @Test
    public void verifyGetFilesSrc(){
        FSElement expected[] = {a, b};
        LinkedList<File> actual = src.getFiles((FSElement fs1, FSElement fs2) -> {
            return fs1.getCreationTime().compareTo(fs2.getCreationTime());
        });
        assertArrayEquals(actual.toArray(), expected);
    }

    @Test
    public void verifyGetSubDirectories(){
        FSElement expected[] = {src, lib, test};
        LinkedList<Directory> actual = prjRoot.getSubDirectories((FSElement fs1, FSElement fs2) -> {
            return fs1.getCreationTime().compareTo(fs2.getCreationTime());
        });
        assertArrayEquals(actual.toArray(), expected);
    }
}
