import com.wfs.dynamicprogramming.FibonacciNumber;
import com.wfs.dynamicprogramming.LongestCommonSubsequence;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Suryasnata on 5/15/2017.
 */
public class LongestCommonSubsequenceTest {
    @Test
    public void testLongestCommonSubsequence()
    {
        LongestCommonSubsequence longestCommonSubsequence=new LongestCommonSubsequence("AGGTAB" ,"GXTXAYB");
        Assert.assertEquals(longestCommonSubsequence.lcsDynamic() , "GTAB");
        longestCommonSubsequence=new LongestCommonSubsequence("ABCDGH" ,"AEDFHR");
        Assert.assertEquals(longestCommonSubsequence.lcsDynamic() , "ADH");
    }
}
