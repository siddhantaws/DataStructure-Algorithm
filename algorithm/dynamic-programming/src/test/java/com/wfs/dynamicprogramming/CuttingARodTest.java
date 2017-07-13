package com.wfs.dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Suryasnata on 6/4/2017.
 */
public class CuttingARodTest {

    CuttingARod cuttingARod ;

    @Test
    public void getMaxPriceList()
    {
        int[] lengthArray = {1, 2, 3, 4};
        int[] priceArray = {2, 5, 7, 8};
        cuttingARod = new CuttingARod(lengthArray, priceArray, 5);
        cuttingARod.getMaxPriceList().toArray();
    }

}