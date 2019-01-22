package com.wellsfargo.data_structure.array;

import java.util.Arrays;

public class ReArrange_Negative_Positive_Numbers {
	public static void main(String[] args) {
		int array[] = { -12, 11, -13, -5,  6, -7, 5, -3, -6 };
		int positive_number_count = countPositive(array, 0, array.length);
		reArrangeArray(array, 0, array.length-positive_number_count);
		reArrangeArray(array, array.length-positive_number_count, array.length);
		
		int count1 = countPositive(array, 0, array.length-positive_number_count);
		int count2 = countPositive(array, array.length-positive_number_count, array.length);
		
		int start1 = array.length-positive_number_count-count1;
		int end1   = start1 + count1 - 1;
		
		int start2 = array.length-positive_number_count;
		int end2   = array.length - count2 - 1;
		
		swapRemainingElements(array, start1, end1, start2, end2);
		System.out.println(Arrays.toString(array));
	}

	private static void swapRemainingElements(int[] array, int start1, int end1, int start2, int end2) {
		while(start1 <= end1) {
			swap(array, start1, start2);
			start1++;
			start2++;
		}
	}

	private static int countPositive(int[] array, int start, int end) {
		int count = 0;
		for(int index=start; index<end; index++) {
			if(array[index] >=0) {
				count++;
			}
		}
		return count;
	}

	private static void reArrangeArray(int[] array, int start, int end) {
		int mismatchIndex = -1;
		int matchIndex = -1;
		for(int index = start; index < end; index++) {
			if(mismatchIndex == -1 && array[index] >=0 ) {
				mismatchIndex = index;
			}
			if(mismatchIndex != -1 && matchIndex == -1 && array[index]<0) {
				matchIndex = index;
			}
			if(mismatchIndex != -1 && matchIndex != -1 && mismatchIndex < matchIndex) {
				swap(array, mismatchIndex, matchIndex);
				mismatchIndex = mismatchIndex+1;
				matchIndex=-1;
			}
		}
		if(mismatchIndex == end-2 && array[mismatchIndex] >=0 && array[mismatchIndex+1]>=0) {
			swap(array, mismatchIndex, mismatchIndex+1);
		}
	}

	private static void swap(int[] array, int i, int j) {		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
