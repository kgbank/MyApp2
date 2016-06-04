package com.example.user.myapp2.calc;

/**
 * Created by USER on 2016-06-04.
 */
public interface CalcService {
    public int plus(int num1, int num2);
    public int minus(int num1, int num2);
    public int mult(int num1, int num2);
    public int divide(int num1, int num2); //몫만 취함
    public int nmg(int num1, int num2); // 나머지
}
