package Security;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DiffieHellman {
    public List<Integer> getKeys(int q, int alpha, int xa, int xb) {
        BigInteger bigAlpha = BigInteger.valueOf(alpha);
        BigInteger bigQ = BigInteger.valueOf(q);
        BigInteger ya = bigAlpha.pow(xa).mod(bigQ);
        BigInteger yb = bigAlpha.pow(xb).mod(bigQ);
        List<Integer> key = new ArrayList<Integer>();
        key.add(yb.pow(xa).mod(bigQ).intValue());
        key.add(ya.pow(xb).mod(bigQ).intValue());
        return key;
    }
}
