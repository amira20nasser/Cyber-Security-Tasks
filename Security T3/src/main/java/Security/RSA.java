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
        // e is public
        // i need d = e(inverse) mod totient(n)
        BigInteger pp = BigInteger.valueOf(p);
        BigInteger qq = BigInteger.valueOf(q);
        BigInteger CC = BigInteger.valueOf(C);
        BigInteger ee = BigInteger.valueOf(e);

        BigInteger n = pp.multiply(qq);
        BigInteger totient = pp.subtract(BigInteger.ONE).multiply(qq.subtract(BigInteger.ONE)); 
        BigInteger d = ee.modInverse(totient);
        BigInteger plain = CC.modPow(d, n);

        return plain.intValue();
    }
}
