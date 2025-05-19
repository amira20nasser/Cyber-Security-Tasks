package Security;

import java.math.BigInteger;

public class RSA {

    public int encrypt(int p, int q, int M, int e) {
        
        BigInteger pp = BigInteger.valueOf(p);
        BigInteger qq = BigInteger.valueOf(q);
        BigInteger MM = BigInteger.valueOf(M);
        BigInteger ee = BigInteger.valueOf(e);

        BigInteger n = pp.multiply(qq);

        BigInteger cipher = MM.modPow(ee, n);

        return cipher.intValue();
    
    }

    public int decrypt(int p, int q, int C, int e) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
