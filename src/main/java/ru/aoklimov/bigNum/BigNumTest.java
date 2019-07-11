package ru.aoklimov.bigNum;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumTest {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("2");
        BigDecimal bd = new BigDecimal("2");

        System.out.println(bi.pow(1000));
        System.out.println(bd.pow(1000));
    }
}
