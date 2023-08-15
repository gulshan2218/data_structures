import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

 class Pair{
    int first,second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
public class Graph {

    public static void dfs(int vertex,ArrayList<ArrayList<Integer>> adjlist,boolean[] vis,ArrayList<Integer> dfslist)
    {
       dfslist.add(vertex);
       vis[vertex]=true;
       for(Integer it:adjlist.get(vertex))
       {
           if(vis[it]!=true)
           {
               dfs(it,adjlist,vis,dfslist);
           }
       }

    }

    public static ArrayList<Integer> dfsTraversal(int vertex,ArrayList<ArrayList<Integer>> adjlist)
    {
        boolean vis[]=new boolean[vertex+1];
        ArrayList<Integer> dfslist=new ArrayList<>();
        dfs(1,adjlist,vis,dfslist);
        return dfslist;


    }
    public static ArrayList<Integer> bfsTraversal(int vertex,ArrayList<ArrayList<Integer>> adjlist)
    {
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean vis[]=new boolean[vertex+1];
        Queue<Integer> q=new ArrayDeque<>();
        q.add(1);
        vis[1]=true;
        while(!q.isEmpty())
        {
            Integer node=q.poll();
            bfs.add(node);
            for(Integer it:adjlist.get(node))
            {
                if(vis[it]!=true)
                {
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

    public static void bfs(int arr[][],int vis[][],int row,int col)
    {
        vis[row][col]=1;
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(row,col));
        int n=arr.length;
        int m= arr[0].length;
        while(q.size()>0)
        {
            int ro=q.peek().first;
            int co=q.peek().second;
            q.remove();
            for(int i=-1;i<=1;i++)
            {
                for(int j=-1;j<=1;j++)
                {
                    int nrow=ro+i;
                    int ncol=co+j;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && arr[nrow][ncol]==1)
                    {
                        q.add(new Pair(nrow,ncol));
                        vis[nrow][ncol]=1;
                    }
                }
            }
        }

    }
    public static int NumberofIsland(int arr[][])
    {
        int n= arr.length;
        int m=arr[0].length;
        int vis[][]=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && arr[i][j]==1)
                {

                    count++;
                    bfs(arr,vis,i,j);
                }
            }
        }
        return count;
    }
    public static void main(String[] args)throws IOException {
        Scanner sc=new Scanner(System.in);
       /* int nodes=sc.nextInt();
        int edges=sc.nextInt();
        ArrayList<ArrayList<Integer>> adjlist=new ArrayList<>();
        for(int i=0;i<=nodes;i++)
        {
            adjlist.add(new ArrayList<>());
        }
        for(int i=0;i<edges;i++)
        {
           int u=sc.nextInt();
           int v=sc.nextInt();
           adjlist.get(u).add(v);
           adjlist.get(v).add(u);
        }
        ArrayList<Integer> bfs=bfsTraversal(nodes,adjlist);
        ArrayList<Integer> dfs=dfsTraversal(nodes,adjlist);*/
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int arr[][]=new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        int n=NumberofIsland(arr);
        System.out.print(n);
            //System.out.print(bfs);
       // System.out.print(dfs);

    }
}





