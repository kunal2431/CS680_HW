package umbcs680.internalfs.fs;
import umbcs680.internalfs.TestFixtureInitializer;
import umbcs680.internalfs.fs.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest{

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
    private LocalDateTime currentTime = TestFixtureInitializer.currentTime;

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

    private String[] fileToStringArray(File f){
        String[] fileInfo = { f.getName(), String.valueOf(f.getSize()), String.valueOf(f.getcreationTime())};
        return fileInfo;
    }

    @Test
    //Test Case 1: Structural Test: Verify public methods getFiles() and getTotalSize() methods
    public void verifyFile_getFiles(){
        LinkedList<File> actual = test.getFiles();
        assertEquals(25, test.getTotalSize());
        assertFalse(actual.contains(A));
        assertFalse(actual.contains(B));
        assertFalse(actual.contains(readme));
        assertTrue(actual.contains(ATest));
        assertTrue(actual.contains(BTest));
        assertFalse(B.isDirectory());
    }

    @Test
    //Test Case 2: Functional Test: Verify file Equality Check for file "ATest.java"
    public void verifyFileEqualityCheck_ATest_java(){
        String[] expected = {"ATest.java", "13", String.valueOf(currentTime)};
        assertTrue(ATest instanceof File);
        assertArrayEquals(expected, fileToStringArray(ATest));
        assertFalse(ATest.isDirectory());
    }

    @Test
    //Test Case 3: Functional Test: Verify file Equality Check for file "BTest.java"
    public void verifyFileEqualityCheck_BTest_java(){
        String[] expected = {"BTest.java", "12", String.valueOf(currentTime)};
        assertTrue(BTest instanceof File);
        assertArrayEquals(expected, fileToStringArray(BTest));
    }

}
