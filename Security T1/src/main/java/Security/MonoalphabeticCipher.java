package Security;

import java.util.*;

public class MonoalphabeticCipher {

    // TODO: Implement this method to generate a substitution map from A-Z using the provided key
    private static Map<Character, Character> generateEncryptionMap(String key) {
        Map<Character, Character> encryptionMap = new HashMap<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        key = key.toUpperCase();

        // Students should complete this loop
        for (int i = 0; i < alphabet.length(); i++) {
            encryptionMap.put(alphabet.charAt(i), key.charAt(i));
        }
        return encryptionMap;
    }

    // TODO: Implement this method to reverse the encryption map (ciphertext -> plaintext)
    private static Map<Character, Character> generateDecryptionMap(String key) {
        Map<Character, Character> decryptionMap = new HashMap<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        key = key.toUpperCase();

        // Students should complete this loop
        for (int i = 0; i < alphabet.length(); i++) {
            decryptionMap.put(key.charAt(i), alphabet.charAt(i));
        }
        return decryptionMap;
    }

    public static String encrypt(String plaintext, String key) {
        Map<Character, Character> encryptionMap = generateEncryptionMap(key);
        plaintext = plaintext.toUpperCase();
        StringBuilder encryptedText = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            if(encryptionMap.containsKey(c)){
                encryptedText.append(encryptionMap.get(c));
            }
            else{
                encryptedText.append(c);
            }
        }       
        return encryptedText.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        Map<Character, Character> decryptionMap = generateDecryptionMap(key);
        ciphertext = ciphertext.toUpperCase();
        StringBuilder decryptedText = new StringBuilder();

        for (char c : ciphertext.toCharArray()) {
            if(decryptionMap.containsKey(c)){
                decryptedText.append(decryptionMap.get(c));
            }
            else{
                decryptedText.append(c);
            }
        }
        return decryptedText.toString();
    }

    public static String findKey(String plaintext, String ciphertext) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String remainingAlphabet = alphabet;
        char[] keyMap = new char[26];
        Arrays.fill(keyMap, ' ');

        plaintext = plaintext.toUpperCase();
        ciphertext = ciphertext.toUpperCase();

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            char cipherChar = ciphertext.charAt(i);

            if (Character.isLetter(plainChar)) {
                int plainCharIndex=alphabet.indexOf(plainChar);
                if(keyMap[plainCharIndex]==' '){
                    keyMap[plainCharIndex] = cipherChar;
                    remainingAlphabet=alphabet.replace(String.valueOf(plainChar), "");
            }
                
                
            }
        }
        System.out.println(remainingAlphabet);
        int j = 0;
        for(int i=0; i<keyMap.length; i++){
            if(keyMap[i]==' '){
                keyMap[i] = remainingAlphabet.charAt(j);
                j++;
            }
        }

        return new String(keyMap);
    }
}
