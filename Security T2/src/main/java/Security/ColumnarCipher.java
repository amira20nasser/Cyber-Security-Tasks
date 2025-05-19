package Security;
import java.util.*;

public class ColumnarCipher {

    public List<Integer> analyse(String plainText, String cipherText) {
        // DONE: Analyze the plainText and cipherText to determine the key(s)
        int keyLen = getKeyLen( plainText,  cipherText);
        System.out.println(keyLen);
        int rows = plainText.length() / keyLen;
        List<Integer> keys = new ArrayList<>(); 
        char [] firstRowColumnar = new char[keyLen]; // C O M P U
        char [] cipher = new char[keyLen]; // C P O M U
        int index = 0;
        for(int i =0; i<keyLen;i++){
            cipher[i] = cipherText.charAt(index);
            index+=rows;
        }
        for(int i =0; i<keyLen;i++){
            firstRowColumnar[i] = plainText.charAt(i);
        }
       for(int j =0; j<keyLen;j++){
        for(int l=0;l<keyLen;l++){
            if(firstRowColumnar[j]== cipher[l]){
                if(keys.contains(l+1)){
                    continue;
                }
                keys.add(l+1);
                break;
            }
        }
       } 
        // for(int j =0; j<cipherText.length();){
        //     Character c = cipherText.charAt(j);
        //     for (int k=0;k<keyLen;k++){
        //         if(c==firstRowColumnar[k]){
        //             keys.add(k+1);
        //             break;
        //         }
        //     }
        //     j = j + rows;
        // }
        return  keys; // Placeholder return
    }
    private int getKeyLen(String plainText, String cipherText){
        Character c1 = cipherText.charAt(0);
        Character c2 = cipherText.charAt(1); 
        for (int i = 0 ; i < plainText.length() ; i++){
            if (plainText.charAt(i) == c1){
                for (int j = i+1 ; j < plainText.length() ; j++){
                    if(c2 == plainText.charAt(j)){
                        int keyLen = j-i;
                        return keyLen;
                    }
                }   
            }
        }
        return -1;
    }

    public String decrypt(String cipherText, List<Integer> key) {
        int cipherSize = cipherText.length();
        int rows = (int) Math.ceil((double) cipherSize / key.size());
        char[][] grid = new char[rows][key.size()];
        int count = 0;

        Map<Integer, Integer> keyMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            keyMap.put(key.get(i) - 1, i);
        }

        int remainingCols = cipherSize % key.size();
        for (int i = 0; i < key.size(); i++) {
            for (int j = 0; j < rows; j++) {
                if (remainingCols != 0 && j == rows - 1 && keyMap.get(i) >= remainingCols) continue;
                grid[j][keyMap.get(i)] = cipherText.charAt(count++);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key.size(); j++) {
                result.append(grid[i][j]);
            }
        }
        return result.toString().toUpperCase().trim();
    }

    public String encrypt(String plainText, List<Integer> key) {
        int ptSize = plainText.length();
        int rows = (int) Math.ceil((double) ptSize / key.size());
        char[][] grid = new char[rows][key.size()];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key.size(); j++) {
                if (count >= ptSize) {
                    grid[i][j] = 'x';
                } else {
                    grid[i][j] = plainText.charAt(count++);
                }
            }
        }

        Map<Integer, Integer> keyMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            keyMap.put(key.get(i) - 1, i);
        }

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < key.size(); i++) {
            for (int j = 0; j < rows; j++) {
                cipherText.append(Character.toUpperCase(grid[j][keyMap.get(i)]));
            }
        }
        return cipherText.toString();
    }
}
