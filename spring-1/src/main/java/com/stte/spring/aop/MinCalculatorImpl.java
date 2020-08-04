package com.stte.spring.aop;

import org.springframework.stereotype.Service;

/**
 * create by BloodFly at 2020/6/25
 */
@Service("minCalculator")
public class MinCalculatorImpl implements MinCalculator {
    public int min(int i, int j) {
        return Math.min(i, j);
    }
}
