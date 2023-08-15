package leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class next_permutation {
    public static ArrayList<Integer> nextPermutation(int N, int arr[]){
        // code here
        int i=N-2;
        for(i=N-2;i>=0;i--)
        {
            if(arr[i]<arr[i+1])
            {
                break;
            }
        }
        int j=N-1;
        if(i>=0)
        {
            for ( j = N - 1; j > i; j--)
            {
                if (arr[j] > arr[i])
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    break;
                }
            }
        }
        i++;

        j=N-1;

        while(i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }

        ArrayList<Integer> al=new ArrayList<>();
        for( i=0;i<N;i++)
            al.add(arr[i]);
        return al;
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
        ArrayList<Integer> ls=nextPermutation(n,arr);
        System.out.println(ls);

    }
}
