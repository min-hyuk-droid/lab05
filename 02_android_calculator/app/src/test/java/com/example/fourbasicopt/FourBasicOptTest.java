package com.example.fourbasicopt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** 실습 1의 test_FourBasicOpt.py 와 동일한 테스트 케이스 */
public class FourBasicOptTest {
    private static final double DELTA = 1e-9;
    private final FourBasicOpt fourOpt = new FourBasicOpt();

    @Test
    public void add_01() {
        assertEquals(110, fourOpt.add(100, 10), DELTA);
    }

    @Test
    public void add_02() {
        assertEquals(90, fourOpt.add(100, -10), DELTA);
    }

    @Test
    public void subtract_01() {
        assertEquals(90, fourOpt.subtract(100, 10), DELTA);
    }

    @Test
    public void subtract_02() {
        assertEquals(110, fourOpt.subtract(100, -10), DELTA);
    }

    @Test
    public void divide_01() {
        assertEquals(10, fourOpt.divide(100, 10), DELTA);
    }

    @Test
    public void divide_02() {
        assertEquals(0, fourOpt.divide(100, 0), DELTA);
    }

    @Test
    public void multiply_01() {
        assertEquals(1000, fourOpt.multiply(100, 10), DELTA);
    }

    @Test
    public void multiply_02() {
        assertEquals(100, fourOpt.multiply(100, 1), DELTA);
    }
}
