package leetcode;

import java.io.IOException;
import java.util.Scanner;

public class max_product_subarray {
    public static long maxProduct(int[] arr, int n) {
        long max=arr[0];
        long min=arr[0];
        long prod=arr[0];
        for(int i=1;i<n;i++)
        {
            if(arr[i]<0)
            {
                long temp=min;
                min=max;
                max=temp;
            }
            max=Math.max(arr[i],max*arr[i]);
            min=Math.min(arr[i],min*arr[i]);
            prod=Math.max(prod,max);
        }

        return prod;
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
        System.out.println(maxProduct(arr,n));

    }
}
