package org.example;
import Security.MonoalphabeticCipher;
public class Main {
    public static void main(String[] args) {
        System.out.println(MonoalphabeticCipher.findKey("ABCD", "WXYZ"));
    }
}