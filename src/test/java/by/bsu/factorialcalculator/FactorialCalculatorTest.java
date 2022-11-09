package by.bsu.factorialcalculator;

import by.bsu.exception.IncorrectParameter;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    public void getFirst0Factorials_ReturnsList() throws IncorrectParameter {
        int i = 0;
        List<BigInteger> result = calculator.getFirstNFactorials(i);
        List<BigInteger> expected = new ArrayList<>();

        assertEquals(expected, result);
    }

    @Test
    public void getFirst1Factorials_ReturnsList() throws IncorrectParameter {
        int i = 1;
        List<BigInteger> result = calculator.getFirstNFactorials(i);
        List<BigInteger> expected = List.of(BigInteger.ONE);

        assertEquals(expected, result);
    }

    @Test
    public void getFirst3Factorials_ReturnsList() throws IncorrectParameter {
        int i = 3;
        List<BigInteger> result = calculator.getFirstNFactorials(i);
        List<BigInteger> expected = List.of(
                BigInteger.ONE,
                BigInteger.TWO,
                BigInteger.TWO.multiply(BigInteger.valueOf(3))
        );

        assertEquals(expected, result);
    }

    @Test
    public void getFirstNFactorials_ReturnsException() {
        int i = -100;
        assertThrows(IncorrectParameter.class, () -> calculator.getFirstNFactorials(i));
    }
}