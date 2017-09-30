/*
 * Created by Alessandra Fais
 * Mat. 481017
 * MCSN - ASE 2017/18 - Homework 0
 */

package calculator;

/**
 * Calculator class.
 */
public class CalculatorPrototype implements CalculatorIF {

    /**
     * Test for negative numbers.
     * @param x integer
     * @return true if the number is less than zero, false otherwise
     */
    private boolean isNegative(int x) {
        return (x < 0);
    }

    /**
     * Perform n unitary increments to the value of m and
     * return the result.
     * @param m first addend
     * @param n second addend
     * @return the result of the sum
     */
    @Override
    public int sum(int m, int n) {
        if (!isNegative(n)) {
            if (n == 0) return m;
            return sum(m + 1, n - 1);
        } else
            return sum(m - 1, n + 1);
    }

    /**
     * Perform n unitary decrements to the value of m and
     * return the result.
     * @param m first term
     * @param n second term
     * @return the result of the difference between m and n
     */
    @Override
    public int subtract(int m, int n) {
        return sum(m, -n);
    }

    /**
     * Sum n times m to himself and return the result.
     * @param m first factor
     * @param n second factor
     * @return the result of the product between n and m
     */
    @Override
    public int multiply(int m, int n) {
        if (m == 0 || n == 0) return 0;

        int temp = n;
        if (n < 0) temp = -temp;

        int res = 0;
        while (temp > 0) {
            res += m;
            temp--;
        }

        if (n > 0) return res;
        else return -res;
    }

    /**
     * Subtract n from m until it gets to zero and
     * return the result.
     * @param m dividend
     * @param n divisor
     * @return the quotient
     */
    @Override
    public int divide(int m, int n) {
        if (n == 0) throw new ArithmeticException("Argument divisor is zero.");
        if (n == 1 || m == 0) return m;

        int res = 1;
        int temp = n;
        int partial = m;
        if (n < 0) temp = -temp;
        if (m < 0) partial = -partial;

        partial -= temp;
        while (partial >= temp) {
            partial -= temp;
            res++;
        }

        if (m > 0 && n > 0 || m < 0 && n < 0) return res;
        else return -res;
    }
}
