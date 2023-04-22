package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SizeComparatorTest {
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
    public void verifyGetChildrenSizeComparator(){
        FSElement expected[] = {src, lib, test, y, x};
        Directory actual = prjRoot;
        List<FSElement> fse = prjRoot.getChildren(new SizeComparator());
        assertArrayEquals(fse.toArray(), expected);
    }

    @Test
    public void verifyGetFilesSizeComparatorPrjRoot(){
        FSElement expected[] = {x};
        Directory actual = prjRoot;
        LinkedList<File> fse = prjRoot.getFiles(new SizeComparator());
        assertArrayEquals(fse.toArray(), expected);
    }

    @Test
    public void verifyGetFilesSizeComparatorSrc(){
        FSElement expected[] = {a, b};
        Directory actual = src;
        LinkedList<File> fse = src.getFiles(new SizeComparator());
        assertArrayEquals(fse.toArray(), expected);
    }

    @Test
    public void verifyGetSubDirectoriesSizeComparator(){
        FSElement expected[] = {src, lib, test};
        Directory actual = prjRoot;
        LinkedList<Directory> fse = prjRoot.getSubDirectories(new SizeComparator());
        assertArrayEquals(fse.toArray(), expected);
    }

}
