package umbcs680.singleprime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeAll;

public class SingletonPrimeGeneratorTest{
    private static SingletonPrimeGenerator cut;

    @BeforeAll
    public static void setUp(){
        cut = SingletonPrimeGenerator.getInstance(1, 1000);
    }
    
    @Test
    //TestCase1: Verify 1) getInstance() return non-null value 2) getInstance() returns the identical instance when it is called multiple times.
    //Structural test: Verify Singleton functionality
    public void SingletonPrimeGenerate_getInstance(){
        cut.setRange(1,5);
        assertNotNull(cut);
        SingletonPrimeGenerator cut1 = SingletonPrimeGenerator.getInstance(1, 5);
        assertSame(cut, cut1);
    }

    @Test
    //TestCase2: Generate Prime Numbers from 1 to 15 - Positive Test
    //Functional test: Verify getPrimes() returns the expected result
    public void SingletonPrimeGenerate1to15(){
        Long[] expected = {2L, 3L, 5L, 7L, 11L, 13L};
        cut.setRange(1, 15);
        cut.generatePrimes();
        assertTrue(cut instanceof SingletonPrimeGenerator);
        assertArrayEquals(expected, cut.getPrimes().toArray());
    }

    @Test
    //TestCase3: Test isPrime() method - Positive Test
    //Structural test: Check isPrime() method checks prime numbers correctly
    public void SingletonPrimeGenerate_isPrime(){
        cut.setRange(1, 1000);
        assertTrue(cut.isPrime(79L));
        assertTrue(cut.isPrime(157L));
        assertTrue(cut.isPrime(997L));
        assertFalse(cut.isPrime(1L));
        assertFalse(cut.isPrime(80L));
        assertFalse(cut.isPrime(158L));
        assertFalse(cut.isPrime(996L));
    }

    @Test
    //TestCase4: Test Prime Generated from 7 to 15 are Prime Numbers only - Positive Test
    //Functional test: Check prime generator produces prime numbers only using isPrime() method which is working as expected as tested in test case 3
    public void SingletonPrimeGenerate7to15(){
        cut.setRange(7, 15);
        cut.generatePrimes();
        assertNotNull(cut.getPrimes().toArray());
        LinkedList<Long> actual = cut.getPrimes();
        Iterator<Long> it = actual.iterator();
        while(it.hasNext()) {
            assertTrue(cut.isPrime(it.next()));
        }
    }

    @Test
    //TestCase5: Generate Prime Numbers from 6 to 1 - Negative Test
    //Structural test: check condition - if(from >= 1 && to > from) works as expected and throws RuntimeException
    public void SingletonPrimeGenerate6to1(){
        try{
            cut.setRange(6, 1);
            fail("From is Greater than to");
        }
        catch(RuntimeException ex){
            assertTrue(ex instanceof RuntimeException);
            assertEquals("Wrong input values: from=6 to=1", ex.getMessage());
        }
    }

    @Test
    //TestCase6: Generate Prime Numbers from -5 to 8 - Negative Test
    //Structural test: check condition - if(from >= 1 && to > from) works as expected and throws RuntimeException
    public void SingletonPrimeGenerateNeg5to8(){
        try{
            cut.setRange(-5, 8);
            fail("From is less than 1");
        }
        catch(RuntimeException ex){
            assertEquals("Wrong input values: from=-5 to=8", ex.getMessage());
        }
    }
}
