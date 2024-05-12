package umbcs680.command.cmds;

import umbcs680.command.fs.*;
import umbcs680.command.util.*;
import umbcs680.command.TestFixtureInitializer;

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
    //Test Case 1: Functional Test: Verify Counting implementation
    public void verify_Counting(){
        Counting countCmd = new Counting(repo);
        LinkedList<Integer> actual = countCmd.execute();
        int dirNum = actual.get(0);
        int fileNum = actual.get(1);
        int linkNum = actual.get(2);
        assertEquals(4, dirNum);
        assertEquals(5, fileNum);
        assertEquals(1, linkNum);
    }

    @Test
    //Test Case 2: Functional Test: Verify FileCrawlingVisitor implementation
    public void verify_FileCrawling(){
        FileCrawling crawlCmd = new FileCrawling(repo);
        LinkedList<File> actual =  crawlCmd.execute();
        assertEquals(5, actual.size());
        assertTrue(actual.contains(readme));
        assertTrue(actual.contains(ATest));

        crawlCmd.changeCrawlDirectory(src);
        LinkedList<File> actual1 =  crawlCmd.execute();
        assertEquals(4, actual1.size());
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
        assertEquals(1, searchCmd.execute().size());
        for(File f: searchCmd.execute()){
            assertSame(readme, f);
        }
    }

}
