package com.stte.spring.aop;

import org.springframework.stereotype.Service;

/**
 * create by BloodFly at 2020/6/25
 */
@Service("maxCalculator")
public class MaxCalculatorImpl implements MaxCalculator {
    public int max(int i, int j) {
        return Math.max(i, j);
    }
}
