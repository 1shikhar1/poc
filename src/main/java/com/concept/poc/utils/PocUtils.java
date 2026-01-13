package com.concept.poc.utils;

import org.springframework.stereotype.Component;

@Component
public class PocUtils {

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // base case
        }
        return n * factorial(n - 1); // recursive call
    }
}