package umbcs680.fssort;

import umbcs680.fssort.fs.*;
import umbcs680.fssort.util.*;
import umbcs680.fssort.cmds.*;
import umbcs680.fssort.sort.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class FSSortTest{

    private static FileSystem fs;
    private static Directory repo;
    private static Directory src;
    private static Directory main;
    private static Directory test;
    private static File readme;
    private static File A;
    private static File B;
    private static File ATest;
    private static File BTest;
    private static Link rm;

    @BeforeAll
    public static void setUpFS(){
        fs = TestFixtureInitializer.createFS();
        repo = fs.getRootDirs().getFirst();
        src = repo.getSubDirectories().get(1);
        main = src.getSubDirectories().getFirst();
        test = src.getSubDirectories().get(1);
        readme = repo.getFiles().getFirst();
        A = main.getFiles().getFirst();
        B = main.getFiles().get(1);
        ATest = test.getFiles().getFirst();
        BTest = test.getFiles().get(1);
        rm = test.getLink().getFirst();
    }


    @Test
    //Test Case 1: Functional Test: Verify AlphabeticalComparator implementation
    public void verify_AlphabeticalComparator(){
        LinkedList<FSElement> fsElements = main.getChildren();
        Collections.sort(fsElements, new AlphabeticalComparator());
        assertEquals("A.java", fsElements.get(0).getName());
        assertEquals("B.java", fsElements.get(1).getName());

        AlphabeticalComparator cut = new AlphabeticalComparator();
        LinkedList<FSElement> fsElements1 = main.getChildren(cut);
        Collections.sort(fsElements, new AlphabeticalComparator());
        assertEquals("A.java", fsElements1.get(0).getName());
        assertEquals("B.java", fsElements1.get(1).getName());

        LinkedList<File> files = test.getFiles(cut);
        assertEquals("ATest.java", files.get(0).getName());
        assertEquals("BTest.java", files.get(1).getName());

        LinkedList<Directory> dir = src.getSubDirectories(cut);
        assertEquals("main", dir.get(0).getName());
        assertEquals("test", dir.get(1).getName());

        LinkedList<Link> lin = test.getLink(cut);
        assertEquals("rm.md", lin.get(0).getName());
    }

    @Test
    //Test Case 2: Functional Test: Verify ReverseAlphabeticalComparator implementation
    public void verify_ReverseAlphabeticalComparator(){
        LinkedList<FSElement> fsElements = main.getChildren();
        Collections.sort(fsElements, new ReverseAlphabeticalComparator());
        assertEquals("B.java", fsElements.get(0).getName());
        assertEquals("A.java", fsElements.get(1).getName());

        ReverseAlphabeticalComparator cut = new ReverseAlphabeticalComparator();
        LinkedList<FSElement> fsElements1 = main.getChildren(cut);
        assertEquals("B.java", fsElements1.get(0).getName());
        assertEquals("A.java", fsElements1.get(1).getName());

        LinkedList<File> files = test.getFiles(cut);
        assertEquals("BTest.java", files.get(0).getName());
        assertEquals("ATest.java", files.get(1).getName());

        LinkedList<Directory> dir = src.getSubDirectories(cut);
        assertEquals("test", dir.get(0).getName());
        assertEquals("main", dir.get(1).getName());

        LinkedList<Link> lin = test.getLink(cut);
        assertEquals("rm.md", lin.get(0).getName());
    }

    @Test
    //Test Case 3: Functional Test: Verify SizeComparator implementation
    public void verify_SizeComparator(){
        LinkedList<FSElement> fsElements = main.getChildren();
        Collections.sort(fsElements, new SizeComparator());
        assertEquals("B.java", fsElements.get(0).getName());
        assertEquals("A.java", fsElements.get(1).getName());

        SizeComparator cut = new SizeComparator();
        LinkedList<FSElement> files = test.getChildren(cut);
        assertEquals("rm.md", files.get(0).getName());
        assertEquals("BTest.java", files.get(1).getName());
        assertEquals("ATest.java", files.get(2).getName());

        LinkedList<File> files1 = test.getFiles(cut);
        assertEquals("BTest.java", files1.get(0).getName());
        assertEquals("ATest.java", files1.get(1).getName());

        LinkedList<Directory> dir = src.getSubDirectories(cut);
        assertEquals("main", dir.get(0).getName());
        assertEquals("test", dir.get(1).getName());

        LinkedList<Link> lin = test.getLink(cut);
        assertEquals("rm.md", lin.get(0).getName());
    }

    @Test
    //Test Case 4: Functional Test: Verify TimeStampComparator implementation
    public void verify_TimeStampComparator(){
        TimeStampComparator cut = new TimeStampComparator();
        LinkedList<FSElement> fsElements = main.getChildren(cut);
        //Collections.sort(fsElements, new TimeStampComparator());
        assertEquals("A.java", fsElements.get(0).getName());
        assertEquals("B.java", fsElements.get(1).getName());

        LinkedList<File> files1 = main.getFiles(cut);
        assertEquals("A.java", files1.get(0).getName());
        assertEquals("B.java", files1.get(1).getName());

        LinkedList<Directory> dir = src.getSubDirectories(cut);
        assertEquals("main", dir.get(0).getName());
        assertEquals("test", dir.get(1).getName());

        LinkedList<Link> lin = test.getLink(cut);
        assertEquals("rm.md", lin.get(0).getName());
    }

    @Test
    //Test Case 5: Functional Test: Verify default AlphabeticalComparator implementation in get methods
    public void verify_AlphabeticalComparator_get(){
        LinkedList<FSElement> fsElements1 = test.getChildren();
        assertEquals("ATest.java", fsElements1.get(0).getName());
        assertEquals("BTest.java", fsElements1.get(1).getName());
        assertEquals("rm.md", fsElements1.get(2).getName());

        LinkedList<File> files = test.getFiles();
        assertEquals("ATest.java", files.get(0).getName());
        assertEquals("BTest.java", files.get(1).getName());

        LinkedList<Directory> dir = src.getSubDirectories();
        assertEquals("main", dir.get(0).getName());
        assertEquals("test", dir.get(1).getName());

        LinkedList<Link> lin = test.getLink();
        assertEquals("rm.md", lin.get(0).getName());
    }

}
