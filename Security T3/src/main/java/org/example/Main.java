package org.example;

// import static org.junit.jupiter.api.Assertions.assertEquals;

import Security.RSA;

public class Main {
    public static void main(String[] args) {
        RSA algorithm = new RSA();
        int cipher = algorithm.encrypt(11, 17, 88, 7);
        System.out.println(cipher);
        // assertEquals(11, cipher);
    }
}