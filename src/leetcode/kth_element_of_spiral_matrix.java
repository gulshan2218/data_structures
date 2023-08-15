package leetcode;

import java.io.IOException;
import java.util.Scanner;

public class kth_element_of_spiral_matrix {
    public static int findK(int A[][], int n, int m, int k)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        int left=0,right=m-1,top=0,bottom=n-1,p=0;
        while(left<=right && top<=bottom)
        {
            if(p==0)
            {
                for(int i=left;i<=right;i++)
                    arr.add(A[top][i]);
                top++;
                p=1;
            }
            if(p==1)
            {
                for(int i=top;i<=bottom;i++)
                    arr.add(A[i][right]);
                right--;
                p=2;
            }
            if(p==2)
            {
                for(int i=right;i>=left;i--)
                {
                    arr.add(A[bottom][i]);
                }
                bottom--;
                p=3;
            }
            if(p==3)
            {
                for(int i=bottom;i>=top;i--)
                {
                    arr.add(A[i][left]);
                }
                p=0;
                left++;
            }
        }
        return arr.get(k-1);
    }
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int m= sc.nextInt();
            int k=sc.nextInt();
            int arr[][]=new int[1000][1000];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            System.out.println(findK(arr,n,m,k));
        }
    }
}
