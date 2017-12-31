package external_tests;

import calculator.CalculatorPrototype;
import calculator.CalculatorPrototypeTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTestRefined extends CalculatorPrototypeTest {

    @Test
    public void testSumNegativeOne() {
        /*
            Tests the correcness of the sum when the first argument is negative
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int sum = calculator.sum(-5, 1);
        assertEquals(-4, sum);
    }

    @Test
    public void testSumNegativeTwo() {
        /*
            Tests the correctness of the sum when the second argument is negative
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int sum = calculator.sum(5, -1);
        assertEquals(4, sum);
    }

    @Test
    public void testSubtract() {
        /*
            Tests the correctness of the subtraction between two positive numbers
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int sub = calculator.subtract(7, 5);
        assertEquals(2, sub);
    }

    @Test
    public void testSubtractNegativeOne() {
        /*
            Tests the correctness of the subtraction when the first argument is negative
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int sub = calculator.subtract(-7, 5);
        assertEquals(-12, sub);
    }

    @Test
    public void testSubtractNegativeTwo() {
        /*
            Tests the correctness of the subtraction when the second argument is negative
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int sub = calculator.subtract(7, -5);
        assertEquals(12, sub);
    }

    @Test
    public void testMultiply() {
        /*
            Tests the correctness of the multiplication between two positive numbers
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int mul = calculator.multiply(3, 4);
        assertEquals(12, mul);
    }

    @Test
    public void testMultiplyNegativeOne() {
        /*
            Tests the correctness of the multiplication when the first argument is negative
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int mul = calculator.multiply(-3, 4);
        assertEquals(-12, mul);
    }

    @Test
    public void testMultiplyNegativeTwo() {
        /*
            Tests the correctness of the multiplication when the second argument is negative
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int mul = calculator.multiply(3, -4);
        assertEquals(-12, mul);
    }

    @Test
    public void testMultiplyNegativeBoth() {
        /*
            Tests the correctness of the multiplication when both arguments are negative
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int mul = calculator.multiply(-3, -4);
        assertEquals(12, mul);
    }

    @Test
    public void testDivideNegativeOne() {
        /*
            Tests the correctness of the division when the first argument is negative
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(-20, 4);
        assertEquals(-5, div);
    }

    @Test
    public void testDivideNegativeTwo() {
        /*
            Tests the correctness of the division when the second argument is negative
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(20, -4);
        assertEquals(-5, div);
    }

    @Test
    public void testDivideNegativeBoth() {
        /*
            Tests the correctness of the division when both arguments are negative
         */
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(-20, -4);
        assertEquals(5, div);
    }
}
