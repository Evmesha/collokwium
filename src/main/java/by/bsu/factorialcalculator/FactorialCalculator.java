package by.bsu.factorialcalculator;

import by.bsu.exception.IncorrectParameter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import by.springframework.http.MediaType;
import by.springframework.http.ResponseEntity;
import by.springframework.web.bind.annotation.PathVariable;
import by.springframework.web.bind.annotation.RequestMapping;
import by.springframework.web.bind.annotation.RequestMethod;
import by.springframework.web.bind.annotation.RestController;

@RestController

public class FactorialCalculator {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
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
    @RequestMapping(value = "/fact/{num}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestRes> restMethod(@PathVariable int num)
    {
        RestRes result = new RestRes();

        result.countFactorialRecursion(num);
        result.getNum();
        result.toString();
        result.setNum(num);


        return ResponseEntity.ok(result);
    }
}
