package umbcs680.fssortlambda;

import umbcs680.fssortlambda.fs.*;
import umbcs680.fssortlambda.util.*;
import umbcs680.fssortlambda.cmds.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import java.util.Collections;
import java.util.Comparator;
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
        src = repo.getSubDirectories().getFirst();
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
        Comparator<FSElement> AlphabeticalComparator = (FSElement fs1, FSElement fs2)->{return fs1.getName().compareTo(fs2.getName());};
        LinkedList<FSElement> fsElements = main.getChildren();
        Collections.sort(fsElements, AlphabeticalComparator);
        assertEquals("A.java", fsElements.get(0).getName());
        assertEquals("B.java", fsElements.get(1).getName());

        LinkedList<FSElement> fsElements1 = test.getChildren();
        Collections.sort(fsElements1, AlphabeticalComparator);
        assertEquals("ATest.java", fsElements1.get(0).getName());
        assertEquals("BTest.java", fsElements1.get(1).getName());
        assertEquals("rm.md", fsElements1.get(2).getName());

        LinkedList<File> files = test.getFiles(AlphabeticalComparator);
        assertEquals("ATest.java", files.get(0).getName());
        assertEquals("BTest.java", files.get(1).getName());
    }

    @Test
    //Test Case 2: Functional Test: Verify ReverseAlphabeticalComparator implementation
    public void verify_ReverseAlphabeticalComparator(){
        Comparator<FSElement> ReverseAlphabeticalComparator = (FSElement fs1, FSElement fs2)->{return fs2.getName().compareTo(fs1.getName());};
        LinkedList<FSElement> fsElements = main.getChildren();
        Collections.sort(fsElements, ReverseAlphabeticalComparator);
        assertEquals("B.java", fsElements.get(0).getName());
        assertEquals("A.java", fsElements.get(1).getName());

        LinkedList<FSElement> fsElements1 = test.getChildren();
        Collections.sort(fsElements1, ReverseAlphabeticalComparator);
        assertEquals("rm.md", fsElements1.get(0).getName());
        assertEquals("BTest.java", fsElements1.get(1).getName());
        assertEquals("ATest.java", fsElements1.get(2).getName());

        LinkedList<Directory> dir = src.getSubDirectories(ReverseAlphabeticalComparator);
        assertEquals("test", dir.get(0).getName());
        assertEquals("main", dir.get(1).getName());
    }

    @Test
    //Test Case 3: Functional Test: Verify SizeComparator implementation
    public void verify_SizeComparator(){
        Comparator<FSElement> SizeComparator = (FSElement fs1, FSElement fs2)->{return fs1.getSize() - fs2.getSize();};
        LinkedList<FSElement> fsElements = main.getChildren();
        Collections.sort(fsElements, SizeComparator);
        assertEquals("B.java", fsElements.get(0).getName());
        assertEquals("A.java", fsElements.get(1).getName());

        LinkedList<FSElement> files = test.getChildren(SizeComparator);
        assertEquals("rm.md", files.get(0).getName());
        assertEquals("BTest.java", files.get(1).getName());
        assertEquals("ATest.java", files.get(2).getName());
    }

    @Test
    //Test Case 4: Functional Test: Verify TimeStampComparator implementation
    public void verify_TimeStampComparator(){
        Comparator<FSElement> TimeStampComparator = (FSElement fs1, FSElement fs2)->{return fs1.getcreationTime().compareTo(fs2.getcreationTime());};
        LinkedList<FSElement> fsElements = test.getChildren(TimeStampComparator);
        //Collections.sort(fsElements, TimeStampComparator);
        assertEquals("ATest.java", fsElements.get(0).getName());
        assertEquals("BTest.java", fsElements.get(1).getName());
        assertEquals("rm.md", fsElements.get(2).getName());
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
    }

}
