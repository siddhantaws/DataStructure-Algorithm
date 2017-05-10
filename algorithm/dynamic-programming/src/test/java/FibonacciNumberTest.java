import com.wfs.dynamicprogramming.overlaping_subproblem.FibonacciNumber;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Suryasnata on 5/10/2017.
 */
public class FibonacciNumberTest {

    @Test
    public void testFiboniciiNumber()
    {
        FibonacciNumber fibonacciNumber=new FibonacciNumber(11);
        Assert.assertEquals(fibonacciNumber.buttomUp(fibonacciNumber.getFibNumber()) ,fibonacciNumber.topDownFib(fibonacciNumber.getFibNumber()));
        fibonacciNumber=new FibonacciNumber(125);
        Assert.assertEquals(fibonacciNumber.buttomUp(fibonacciNumber.getFibNumber()) ,fibonacciNumber.topDownFib(fibonacciNumber.getFibNumber()));

    }
}
