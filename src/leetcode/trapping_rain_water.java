package leetcode;

import java.io.IOException;
import java.util.Scanner;

public class trapping_rain_water {
    public static long trappingWater(int arr[], int n) {
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=arr[0];
        for(int i=1;i<n;i++)
        {
            left[i]=Math.max(arr[i],left[i-1]);
        }
        right[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            right[i]=Math.max(right[i+1],arr[i]);
        }
        long ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=(Math.min(right[i],left[i])-arr[i]);
        }
        return ans;
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
            System.out.println(trappingWater(arr,n));

    }

}
