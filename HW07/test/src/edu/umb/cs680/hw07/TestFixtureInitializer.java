package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class TestFixtureInitializer {
    public static FileSystem createFS(){
        FileSystem fs = FileSystem.getFileSystem();

        LocalDateTime time = LocalDateTime.now();
        Directory prjRoot = new Directory(null, "prjRoot", 0, time);
        fs.appendRootDir(prjRoot);
        Directory src = new Directory(prjRoot, "src", 0, time);
        Directory lib = new Directory(prjRoot, "lib", 0, time);
        Directory test = new Directory(prjRoot, "test", 0, time);
        Directory src_test = new Directory(test, "src", 0, time);
        File a = new File(src, "a", 5, time);
        File b = new File(src, "b", 5, time);
        File c = new File(lib, "c", 5, time);
        File d = new File(src_test, "d", 5, time);
        File x = new File(prjRoot, "x", 5, time);
        Link y = new Link(prjRoot, "y", 0, time, src_test);

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
        return fs;
    }

}
