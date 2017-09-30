/*
 * Created by Alessandra Fais
 * Mat. 481017
 * MCSN - ASE 2017/18 - Homework 0
 */

package calculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test for the calculator class.
 */
public class CalculatorPrototypeTestExtended {

    /**
     * Test the sum between two positive numbers.
     */
    @Test
    public void testSumBothPositive() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int sum = calculator.sum(3,3);
        assertEquals(6, sum);
    }

    /**
     * Test the sum with the first addend negative.
     */
    @Test
    public void testSumFirstNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int sum = calculator.sum(-4,3);
        assertEquals(-1, sum);
    }

    /**
     * Test the sum with the second addend negative.
     */
    @Test
    public void testSumSecondNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int sum = calculator.sum(4,-3);
        assertEquals(1, sum);
    }

    /**
     * Test the sum between two negative numbers.
     */
    @Test
    public void testSumBothNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int sum = calculator.sum(-4,-3);
        assertEquals(-7, sum);
    }

    /**
     * Test the subtraction between two positive numbers.
     */
    @Test
    public void testSubtractBothPositive() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int dif = calculator.subtract(4,5);
        assertEquals(-1, dif);
    }

    /**
     * Test the subtraction with the first term negative.
     */
    @Test
    public void testSubtractFirstNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int dif = calculator.subtract(-4,5);
        assertEquals(-9, dif);
    }

    /**
     * Test the subtraction with the second term negative.
     */
    @Test
    public void testSubtractSecondNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int dif = calculator.subtract(4,-2);
        assertEquals(6, dif);
    }

    /**
     * Test the subtraction between two negative numbers.
     */
    @Test
    public void testSubtractBothNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int dif = calculator.subtract(-4,-1);
        assertEquals(-3, dif);
    }

    /**
     * Test the multiplication between two positive numbers.
     */
    @Test
    public void testMultiplicationBothPositive() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int mul = calculator.multiply(3, 2);
        assertEquals(6, mul);
    }

    /**
     * Test the multiplication with the first factor negative.
     */
    @Test
    public void testMultiplicationFirstNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int mul = calculator.multiply(-3, 2);
        assertEquals(-6, mul);
    }

    /**
     * Test the multiplication with the second factor negative.
     */
    @Test
    public void testMultiplicationSecondNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int mul = calculator.multiply(3, -2);
        assertEquals(-6, mul);
    }

    /**
     * Test the multiplication between two negative numbers.
     */
    @Test
    public void testMultiplicationBothNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int mul = calculator.multiply(-3, -2);
        assertEquals(6, mul);
    }

    /**
     * Test the multiplication with one factor zero.
     */
    @Test
    public void testMultiplicationByZero() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int mul = calculator.multiply(3, 0);
        assertEquals(0, mul);
    }

    /**
     * Test the exact division between two positive numbers.
     */
    @Test
    public void testDivisionExact() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(6,3);
        assertEquals(2, div);
    }

    /**
     * Test the not exact division between two positive numbers.
     */
    @Test
    public void testDivisionNotExact() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(7,3);
        assertEquals(2, div);
    }

    /**
     * Test the exact division between with a negative dividend
     * and a positive divisor.
     */
    @Test
    public void testDivisionExactFirstNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(-6,3);
        assertEquals(-2, div);
    }

    /**
     * Test the exact division between with a positive dividend
     * and a negative divisor.
     */
    @Test
    public void testDivisionExactSecondNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(6,-3);
        assertEquals(-2, div);
    }

    /**
     * Test the not exact division between with a negative dividend
     * and a positive divisor.
     */
    @Test
    public void testDivisionNotExactFirstNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(-7,3);
        assertEquals(-2, div);
    }

    /**
     * Test the not exact division between with a positive dividend
     * and a negative divisor.
     */
    @Test
    public void testDivisionNotExactSecondNegative() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(7,-3);
        assertEquals(-2, div);
    }

    /**
     * Test the division by zero.
     */
    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(3,0);
    }

}