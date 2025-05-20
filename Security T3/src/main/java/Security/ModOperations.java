package Security;

import java.math.BigInteger;
import java.util.Dictionary;
import java.util.Hashtable;

public class ModOperations
{
    private static Dictionary<String, Integer> extenededEuclideanHelper(int q, int a1, int a2, int a3, int b1, int b2, int b3){
        if(b3==1){
            Dictionary<String, Integer> result = new Hashtable<>();
            result.put("inverse", b2);
            result.put("gcd", b3);
            return result;
        }
        else if(b3==0){
            Dictionary<String, Integer> result = new Hashtable<>();
            result.put("inverse", -1);
            result.put("gcd", a3);
        }
        int new_q = a3/b3;
        return extenededEuclideanHelper(new_q,b1,b2, b3, a1-new_q*b1, a2-new_q*b2,a3-new_q*b3);
    }
    private static Dictionary<String, Integer> extendedEucledian(int a, int b){
        return extenededEuclideanHelper(1,1,0, a, 0,1, b);
    }
    public static BigInteger modInverse(BigInteger number, BigInteger mod)  {
        Integer inverse = extendedEucledian(mod.intValue(), number.intValue()).get("inverse");
        // return BigInteger.valueOf(inverse).mod(mod); // to ensure it is positive
        // or, doing it the hard way:
        while(inverse < 0){
            inverse+=mod.intValue();
        }
        return BigInteger.valueOf(inverse);
    }
}
