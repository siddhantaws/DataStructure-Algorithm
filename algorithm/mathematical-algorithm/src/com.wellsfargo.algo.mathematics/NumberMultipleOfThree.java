package com.wellsfargo.algo.mathematics;

/**
 * There is a pattern in binary representation of the number that can be used to find if number is a multiple of 3.
 * If difference between count of odd set bits (Bits set at odd positions) and even set bits is multiple of 3 then is the number.
 * Example: 23 (00..10111)
 * 1) Get count of all set bits at odd positions (For 23 it’s 3). 
 * 2) Get count of all set bits at even positions (For 23 it’s 1).
 * 3) If difference of above two counts is a multiple of 3 then number is also a multiple of 3.
 * 
 */
public class NumberMultipleOfThree 
{
	public static void main(String[] args)
	{
		System.out.println("Number mukltiple of Three :" + new NumberMultipleOfThree().isMultipleOf3(42));
	}
	private boolean isMultipleOf3(int num)
	{
		int odd_Count =0;
		int even_Count =0;
		num = num<  0 ? num*-1 : num ;
		if(num ==0 )
			return true;
		else if(num==1)
			return false;
		while(num>0)
		{
			if((num & 1 ) >  0 )
				odd_Count++;
			
			num =num >>1 ;
			
			if((num & 1 ) >  0 )
				even_Count++;
			num =num >>1 ;
		}
		return isMultipleOf3(odd_Count - even_Count);
	}
}
