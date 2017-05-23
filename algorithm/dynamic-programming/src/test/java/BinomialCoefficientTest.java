import com.wfs.dynamicprogramming.BinomialCoefficient;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Suryasnata on 5/23/2017.
 */
public class BinomialCoefficientTest
{
    BinomialCoefficient binomialCoefficient ;
    @Test
    public void testBinomialCoefficient()
    {
        binomialCoefficient =new BinomialCoefficient(4, 2);
        Assert.assertEquals(binomialCoefficient.getCooficientValue() , 6);
        binomialCoefficient =new BinomialCoefficient(5, 2);
        Assert.assertEquals(binomialCoefficient.getCooficientValue() , 10);
    }
}
