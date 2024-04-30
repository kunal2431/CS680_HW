package umbcs680.internalfs;

import umbcs680.internalfs.fs.*;
import umbcs680.internalfs.util.*;
import umbcs680.internalfs.cmds.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class FSCommandTest{

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
    //Test Case 1: Functional Test: Verify Counting implementation
    public void verify_Counting(){
        Counting countCmd = new Counting(repo);
        LinkedList<Integer> actual = countCmd.execute();
        int dirNum = actual.get(0);
        int fileNum = actual.get(1);
        int linkNum = actual.get(2);
        assertEquals(dirNum, 4);
        assertEquals(fileNum, 5);
        assertEquals(linkNum, 1);
    }

    @Test
    //Test Case 2: Functional Test: Verify FileCrawlingVisitor implementation
    public void verify_FileCrawling(){
        FileCrawling crawlCmd = new FileCrawling(repo);
        LinkedList<File> actual =  crawlCmd.execute();
        assertTrue(actual.contains(readme));
        assertTrue(actual.contains(ATest));

        crawlCmd.changeCrawlDirectory(src);
        LinkedList<File> actual1 =  crawlCmd.execute();
        assertFalse(actual1.contains(readme));
        assertTrue(actual1.contains(ATest));
        assertTrue(actual1.contains(B));
    }

    @Test
    //Test Case 3: Functional Test: Verify FileSearch implementation
    public void verify_FileSearch(){
        FileSearch searchCmd = new FileSearch(test, "readme.md");
        assertTrue(searchCmd.execute().isEmpty());

        searchCmd.changeSearchDirectory(repo);
        for(File f: searchCmd.execute()){
            assertSame(readme, f);
        }
    }

}