package com.example.fourbasicopt;

/**
 * For the four basic arithmetic operations.
 * Class can be used to add(addition), subtract(subtraction), divide(division) and
 * multiply(multiplication).
 * (실습 1의 Python FourBasicOpt 클래스를 Java로 옮긴 것)
 */
public class FourBasicOpt {

    public double add(double x, double y) {
        return x + y;
    }

    public double subtract(double x, double y) {
        return x - y;
    }

    public double divide(double x, double y) {
        // 0으로 나누면 예외 대신 0을 반환 (test_divide_02)
        if (y == 0) {
            return 0;
        }
        return x / y;
    }

    public double multiply(double x, double y) {
        return x * y;
    }
}
