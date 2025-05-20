package Security;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ElGamal {
    public List<Long> encrypt(int q, int alpha, int y, int k, int m) {
        BigInteger bigAlpha = BigInteger.valueOf(alpha);
        BigInteger big_q = BigInteger.valueOf(q);
        BigInteger big_y = BigInteger.valueOf(y);
        BigInteger big_m = BigInteger.valueOf(m);
        BigInteger c1 = bigAlpha.pow(k).mod(big_q);
        BigInteger K = big_y.pow(k).mod(big_q);

        BigInteger c2 = K.multiply(big_m).mod(big_q);

        List<Long> ciphertext = new ArrayList<Long>();
        ciphertext.add(c1.longValue());
        ciphertext.add(c2.longValue());

        return ciphertext;
    }

    public int decrypt(int c1, int c2, int x, int q) {

        BigInteger big_c1 = BigInteger.valueOf(c1);
        BigInteger big_c2 = BigInteger.valueOf(c2);
        BigInteger big_q = BigInteger.valueOf(q);

        BigInteger c1_pow_x_inverse = ModOperations.modInverse(big_c1.pow(x).mod(big_q),big_q);
        BigInteger m = big_c2.multiply(c1_pow_x_inverse).mod(big_q);
        return m.intValue();

    }
}
