package edu.umb.cs680.hw12.fs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AlphabeticalComparatorTest {
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
    public void verifyGetChildrenAlphabeticalComparator(){
        FSElement expected[] = {lib, src, test, x, y};
        Directory actual = prjRoot;
        List<FSElement> fse = prjRoot.getChildren(new AlphabeticalComparator());
        assertArrayEquals(fse.toArray(), expected);
    }

    @Test
    public void verifyGetFilesAlphabeticalComparatorPrjRoot(){
        FSElement expected[] = {x};
        Directory actual = prjRoot;
        LinkedList<File> fse = prjRoot.getFiles(new AlphabeticalComparator());
        assertArrayEquals(fse.toArray(), expected);
    }

    @Test
    public void verifyGetFilesAlphabeticalComparatorSrc(){
        FSElement expected[] = {a, b};
        Directory actual = src;
        LinkedList<File> fse = src.getFiles(new AlphabeticalComparator());
        assertArrayEquals(fse.toArray(), expected);
    }

    @Test
    public void verifyGetSubDirectoriesAlphabeticalComparator(){
        FSElement expected[] = {lib, src, test};
        Directory actual = prjRoot;
        LinkedList<Directory> fse = prjRoot.getSubDirectories(new AlphabeticalComparator());
        assertArrayEquals(fse.toArray(), expected);
    }

}
