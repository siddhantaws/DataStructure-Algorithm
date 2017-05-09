package com.wellsfargo.algo.mathematics;

/**
 * Created by Suryasnata on 5/7/2017.
 * Example:
 num1 =       1  2  A
 num2 =       C  D  3

 1. Add A and 3, we get 13(D). Since 13 is smaller than
 14, carry becomes 0 and resultant numeral becomes D

 2. Add 2, D and carry(0). we get 15. Since 15 is greater
 than 13, carry becomes 1 and resultant numeral is 15 - 14 = 1

 3. Add 1, C and carry(1). we get 14. Since 14 is greater
 than 13, carry becomes 1 and resultant numeral is 14 - 14 = 0

 Finally, there is a carry, so 1 is added as leftmost numeral and the result becomes
 101D
*/

public class AddTwoNumbersIinBase14 {

    private static String result=" ";

    public static void main(String[] args) {
        System.out.println("AddTwoNumbersIinBase14.main  " + addToBase14("DC2" , "0A3"));
    }

    private static String addToBase14(String num1 , String num2)
    {
        int len1=num1.length();
        int len2=num1.length();
        assert   len1==len2 : "unction doesn't support numbers of different lengths. If you want to add such numbers then prefix smaller number with required no. of zeroes " ;

        int res = len1 + 1;
        /* Add all numerals from right to left */
        int nml1, nml2, res_nml , carry = 0;
        for(int i=0 ; i>=0 ;i++)
        {
           nml1 = getNumeralValue(num1.toCharArray()[i]);
           nml2 = getNumeralValue(num2.toCharArray()[i]);
           /* Add decimal values of numerals and carry */
           res_nml = carry + nml1 + nml2;

           /* Check if we have carry for next addition of numerals */
         if(res_nml >= 14)
         {
             carry = 1 ;
             res_nml -= 14;
         }else
         {
             carry = 0;
         }
            result.toCharArray()[i] = getNumeral(res_nml);
        }
        /* if there is no carry after last iteration  then result should not include 0th character of the resultant string */
        if(carry == 0)
            return (result + 1);

        /* if we have carry after last iteration then result should include 0th character */
        result.toCharArray()[0] = '1';
        return result;
    }

    private static int getNumeralValue(char num)
    {
        if( num >= '0' && num <= '9')
            return (num - '0');
        if( num >= 'A' && num <= 'D')
            return (num - 'A' + 10);
        /* If we reach this line caller is giving invalid character so we assert and fail*/
        throw new AssertionError("invalid character so we assert and fail");
    }

    /* Function to get numeral for a value. For example it returns 'A' for input 10 '1' for 1, etc */
    private static char getNumeral(int val)
    {
        if( val >= 0 && val <= 9)
            return (char) (val + '0');
        if( val >= 10 && val <= 14)
            return (char)(val + 'A' - 10);

        /* If we reach this line caller is giving invalid no. so we assert and fail*/
        throw new AssertionError("invalid character so we assert and fail");
    }
}
