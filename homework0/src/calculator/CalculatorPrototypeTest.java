package calculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Basic test for the calculator class.
 */
public class CalculatorPrototypeTest {

    @Test
    public void testSum() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int sum = calculator.sum(3,3);
        assertEquals(6, sum);
    }
    
    @Test
    public void testDivisionEven() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(6,3);
        assertEquals(2, div);
    }

    @Test
    public void testDivisionOdd() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(7,3);
        assertEquals(2, div);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        CalculatorPrototype calculator = new CalculatorPrototype();
        int div = calculator.divide(3,0);
    }

}