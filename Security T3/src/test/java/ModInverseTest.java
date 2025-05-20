import Security.ElGamal;
import Security.ModOperations;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModInverseTest {
    public void modInverseTest(int num, int mod, int expected) {
        BigInteger big_num = BigInteger.valueOf(num);
        BigInteger big_mod = BigInteger.valueOf(mod);
        int inv = ModOperations.modInverse(big_num, big_mod).intValue();
        assertEquals(expected, inv);
    }

    @Test
    public void testCase1(){
        modInverseTest(23, 26, 17);
    }

    @Test
    public void testCase2(){
        modInverseTest(550, 1759, 355);
    }
}
