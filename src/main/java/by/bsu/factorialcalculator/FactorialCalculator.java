package by.bsu.factorialcalculator;

import by.bsu.exception.IncorrectParameter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FactorialCalculator {
    public List<BigInteger> getFirstNFactorials(int n) throws IncorrectParameter {
        if (n < 0) {
            throw new IncorrectParameter("N cannot be negative");
        }
        if (n == 0) {
            return new ArrayList<>();
        }

        List<BigInteger> factorials = new ArrayList<>();
        factorials.add(BigInteger.ONE);

        for (int i = 0; i < n - 1; i++) {
            BigInteger factorial = factorials.get(i).multiply(BigInteger.valueOf(i + 2));
            factorials.add(factorial);
        }
        return factorials;
    }

    public List<BigInteger> getFirstNFactorialsRecursion(int n) throws IncorrectParameter {
        if (n < 0) {
            throw new IncorrectParameter("N cannot be negative");
        }
        if (n == 0) {
            return new ArrayList<>();
        }

        List<BigInteger> factorials = new ArrayList<>();
        countFactorialRecursion(n, factorials);
        return factorials;
    }

    private BigInteger countFactorialRecursion(int n, List<BigInteger> factorials) {
        if (n > 1) {
            BigInteger factorial = countFactorialRecursion(n - 1, factorials)
                    .multiply(BigInteger.valueOf(n));
            factorials.add(factorial);
            return factorial;
        } else {
            factorials.add(BigInteger.ONE);
            return BigInteger.ONE;
        }
    }
}
