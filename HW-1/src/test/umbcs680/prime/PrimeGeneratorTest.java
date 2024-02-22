package umbcs680.prime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.LinkedList;

public class PrimeGeneratorTest{
    @Test
    //TestCase1: Generate Prime Numbers from 1 to 6 - Positive Test
    //Functional test: Check prime generator produces correct primes in the given range
    public void primeGenerate1to6(){
        Long[] expected = {2L, 3L, 5L};
        PrimeGenerator cut = new PrimeGenerator(1, 6);
        cut.generatePrimes();
        assertTrue(cut instanceof PrimeGenerator);
        assertArrayEquals(expected, cut.getPrimes().toArray());
    }

    @Test
    //TestCase2: Test isPrime() method
    //Structural test: Check isPrime() method checks prime numbers correctly
    public void primeGenerate_isPrime(){
        PrimeGenerator cut = new PrimeGenerator(1 ,1000);
        assertTrue(cut.isPrime(79L));
        assertTrue(cut.isPrime(157L));
        assertTrue(cut.isPrime(997L));
        assertFalse(cut.isPrime(1L));
        assertFalse(cut.isPrime(80L));
        assertFalse(cut.isPrime(158L));
        assertFalse(cut.isPrime(996L));
    }

    @Test
    //TestCase3: Test Prime Generated from 7 to 15 are Prime Numbers only - Positive Test
    //Functional test: Check prime generator produces prime numbers only using isPrime() method which is working as expected as tested in test case 2
    public void primeGenerate7to15(){
        PrimeGenerator cut = new PrimeGenerator(7, 15);
        cut.generatePrimes();
        assertNotNull(cut.getPrimes().toArray());
        LinkedList<Long> actual = cut.getPrimes();
        Iterator<Long> it = actual.iterator();
        while(it.hasNext()) {
            assertTrue(cut.isPrime(it.next()));
        }
    }

    @Test
    //TestCase4: Generate Prime Numbers from 6 to 1 - Negative Test
    //Structural test: check condition - if(from >= 1 && to > from) works as expected and throws RuntimeException
    public void primeGenerate6to1(){
        try{
            PrimeGenerator cut = new PrimeGenerator(6, 1);
            fail("From is Greater than to");
        }
        catch(RuntimeException ex){
            assertTrue(ex instanceof RuntimeException);
            assertEquals("Wrong input values: from=6 to=1", ex.getMessage());
        }
    }

    @Test
    //TestCase5: Generate Prime Numbers from -5 to 8 - Negative Test
    //Structural test: check condition - if(from >= 1 && to > from) works as expected and throws RuntimeException
    public void primeGenerateNeg5to8(){
        try{
            PrimeGenerator cut = new PrimeGenerator(-5, 8);
            fail("From is greater than 1");
        }
        catch(RuntimeException ex){
            assertEquals("Wrong input values: from=-5 to=8", ex.getMessage());
        }
    }
}