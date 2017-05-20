package com.example.wsmith.formulacalc;

import org.junit.Test;

import static com.example.wsmith.formulacalc.FormulaCalculator.binomialProbability;
import static com.example.wsmith.formulacalc.FormulaCalculator.factorial;
import static com.example.wsmith.formulacalc.FormulaCalculator.n_choose_r;
import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void factorial_isCorrect() throws Exception {
        assertEquals(factorial(0),0);
        assertEquals(factorial(1),1);
        assertEquals(factorial(2),2);
        assertEquals(factorial(3),6);
        assertEquals(factorial(4),24);
        assertEquals(factorial(5),120);
    }
    @Test
    public void binomial_isCorrect() throws Exception {
        assertEquals(binomialProbability(1,1,0.5),0.5,.001);
        assertEquals(binomialProbability(5,3,0.45), 0.275, .001);
        // error cases
        assertEquals(binomialProbability(5,6,0.5), Double.NaN, 0);
        assertEquals(binomialProbability(5,4,-0.1), Double.NaN, 0);
        assertEquals(binomialProbability(-1,0,0),Double.NaN,0);
        assertEquals(binomialProbability(5,-1,0),Double.NaN,0);
        assertEquals(binomialProbability(5,3,1.1),Double.NaN,0);
    }

    @Test
    public void n_choose_r_isCorrect() throws Exception {
        assertEquals(n_choose_r(1,1),1);
        assertEquals(n_choose_r(2,1),2);
        assertEquals(n_choose_r(2,2),1);
        assertEquals(n_choose_r(3,0),1);
        assertEquals(n_choose_r(5,2),10);
        assertEquals(n_choose_r(10,3),120);
        assertEquals(n_choose_r(3,5),0);
    }
}