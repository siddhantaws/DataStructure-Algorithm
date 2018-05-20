package com.wellsfargo.algo.mathematics;

public class ExcelColumnNameFromGivenColumnNumber {

    private int num;

    public ExcelColumnNameFromGivenColumnNumber(int num) {
        this.num = num;
    }

    public void printString()
    {
        // To store result (Excel column name)
        StringBuilder columnName = new StringBuilder();

        while (num > 0)
        {
            // Find remainder
            int rem = num % 26;

            // If remainder is 0, then a
            // 'Z' must be there in output
            if (rem == 0)
            {
                columnName.append("Z");
                num = (num / 26) - 1;
            }
            else // If remainder is non-zero
            {
                columnName.append((char)((rem - 1) + 'A'));
                num = num / 26;
            }
        }

        // Reverse the string and print result
        System.out.println(columnName.reverse());
    }

    public static void main(String[] args) {
        ExcelColumnNameFromGivenColumnNumber excel=new ExcelColumnNameFromGivenColumnNumber(51);
        excel.printString();
    }
}

