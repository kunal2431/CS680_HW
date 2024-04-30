package umbcs680.internalfs;
import umbcs680.internalfs.fs.*;

import java.time.LocalDateTime;

public class TestFixtureInitializer{

    protected static LocalDateTime currentTime = LocalDateTime.now();

    public static FileSystem createFS(){
        FileSystem cut = FileSystem.getFileSystem();
        Directory repo = new Directory(null, "repo", 0, currentTime);
        cut.appendRootDir(repo);
        Directory src = new Directory(repo, "src", 0, currentTime);
        repo.appendChild(src);
        Directory main = new Directory(src, "main", 0, currentTime);
        src.appendChild(main);
        Directory test = new Directory(src, "test", 0, currentTime);
        src.appendChild(test);
        File readme = new File(repo, "readme.md", 10, currentTime);
        repo.appendChild(readme);
        File A = new File(main, "A.java", 20, LocalDateTime.now());
        main.appendChild(A);
        File B = new File(main, "B.java", 15, LocalDateTime.now());
        main.appendChild(B);
        Link rm = new Link(test, "rm.md", 0, currentTime, readme);
        test.appendChild(rm);
        File ATest = new File(test, "ATest.java", 13, currentTime);
        test.appendChild(ATest);
        File BTest = new File(test, "BTest.java", 12, currentTime);
        test.appendChild(BTest);
        return cut;
    }

}