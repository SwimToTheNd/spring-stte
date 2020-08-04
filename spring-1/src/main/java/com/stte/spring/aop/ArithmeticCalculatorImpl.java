package com.stte.spring.aop;

import org.springframework.stereotype.Service;

/**
 * create by BloodFly at 2020/6/25
 */
@Service("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    public int add(int i, int j) {
        return i + j;
    }

    public int sub(int i, int j) {
        return i - j;
    }

    public int mul(int i, int j) {
        return i * j;
    }

    public double div(int i, int j) {
        int r = 1 / 0;
        return i / (double) j;
    }
}
