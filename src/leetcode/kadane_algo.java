package leetcode;

import java.io.IOException;
import java.util.Scanner;

public class kadane_algo {
    public static long maxSubarraySum(int arr[], int n){
        long max_sofar=Long.MIN_VALUE,max_current=0;
        for(int i=0;i<n;i++)
        {
            max_current+=arr[i];
            if(max_current>max_sofar)
                max_sofar=max_current;
            if(max_current<0)
                max_current=0;
        }
        return max_sofar;
        // Your code here

    }
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int arr[]=new int[1000];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(maxSubarraySum(arr,n));

    }
}
