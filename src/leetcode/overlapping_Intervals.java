package leetcode;

import java.io.IOException;
import java.util.*;

public class overlapping_Intervals {
    public static  int[][] overlappedInterval(int[][] Intervals)
    {
        Arrays.sort(Intervals,(a,b)->Integer.compare(a[0],b[0]));
        LinkedList<int[]> ll=new LinkedList<>();
        for(int[] a:Intervals)
        {
            if(ll.isEmpty() || ll.getLast()[1]<a[0])
            {
                ll.add(a);
            }
            else
            {
                ll.getLast()[1]=Math.max(a[1],ll.getLast()[1]);
            }
        }
        return ll.toArray(new int[ll.size()][2]);
        // Code here // Code here
    }
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int arr[][]=new int[1000][1000];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(overlappedInterval(arr));

    }
}
