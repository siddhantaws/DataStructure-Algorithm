package com.wfs.devideConqur;

public class AllocateMinimumNumberOfPages {

    private int bookPages[];

    private int studentNo;

    public AllocateMinimumNumberOfPages(int[] bookPages, int studentNo) {
        this.bookPages = bookPages;
        this.studentNo = studentNo;
    }
    public int getMinCount(){
        return getMinCount(bookPages,bookPages.length, studentNo );
    }

    public int getMinCount(int arr[], int n, int m){
        long sum = 0;

        // return -1 if no. of books is less than no. of students
        if (n < m)
            return -1;
        // Count total number of pages
        for (int i = 0; i < n; i++)
            sum += arr[i];
        // initialize start as 0 pages and end as total pages
        int start = 0, end = (int) sum;
        int result = Integer.MAX_VALUE;

        // traverse until start <= end
        while (start <= end)
        {
            // check if it is possible to distribute books by using mid is current minimum
            int mid = (start + end) / 2;
            if (isPossible(arr, n, m, mid))
            {
                // if yes then find the minimum distribution
                result = Math.min(result, mid);

                // as we are finding minimum and books
                // are sorted so reduce end = mid -1
                // that means
                end = mid - 1;
            }

            else
                // if not possible means pages should be
                // increased so update start = mid + 1
                start = mid + 1;
        }

        // at-last return minimum no. of  pages
        return result;
    }

    private boolean isPossible(int arr[], int n, int m, int curr_min) {
        int studentsRequired = 1;
        int curr_sum = 0;
        // iterate over all books
        for (int i = 0; i < n; i++) {
            // check if current number of pages are greater than curr_min that means we will get the result
            // after mid no. of pages
            if (arr[i] > curr_min)
                return false;
            // count how many students are required to distribute curr_min pages
            if (curr_sum + arr[i] > curr_min) {
                // increment student count
                studentsRequired++;
                // update curr_sum
                curr_sum = arr[i];
                // if students required becomes greater than given no. of students,return false
                if (studentsRequired > m)
                    return false;
            }
            else// else update curr_sum
                curr_sum += arr[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90};

        int m = 2; //No. of students
        AllocateMinimumNumberOfPages  allocateMinimumNumberOfPages=new AllocateMinimumNumberOfPages(arr, m);
        System.out.println(allocateMinimumNumberOfPages.getMinCount());
    }
}
