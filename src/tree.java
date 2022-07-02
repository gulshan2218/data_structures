/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class tree
{
    private static class a
    {
        int data;
        ArrayList<a> child=new ArrayList<>();
        a()
        {

        }
        a(int data)
        {
            this.data=data;
        }

    }

    public static void display(a node)
    {
        String str=node.data+"->";
        for(a children:node.child)
        {
            str+=children.data+",";
        }
        System.out.println(str);
        for(a children:node.child)
        {
            display(children);
        }


    }
    public static int size(a root)
    {
        int s=0;
        s+=1;
        for(a children:root.child)
        {
            int cs=size(children);
            s+=cs;
        }
       // s+=1;
        return s;

    }
    public static int maxsize(a node)
    {
        int max=Integer.MIN_VALUE;
        for(a children:node.child)
        {
            if(max<maxsize(children))
               max=maxsize(children);
        }
        if(max<node.data)
        {
            max=node.data;
        }
        return max;
    }
    public static int height(a node)
    {
        int max=-1;
        for(a children:node.child)
        {
            if(max<height(children))
            {
                max=height(children);
            }

        }
        max+=1;
        return max;
    }

    public static void traversal(a node)
    {
        System.out.println("Pre"+node.data);
        for(a children:node.child)
        {
            System.out.println("Pre Edge"+node.data+"--"+children.data);
            traversal(children);
            System.out.println("Post Edge"+node.data+"--"+children.data);
        }
        System.out.println("Post"+node.data);
    }
    public static void levelOrder(a node)
    {
        Queue<a> q=new ArrayDeque<>();
        q.add(node);
        while(q.size()>0)
        {
            a p=q.remove();
            System.out.print(p.data+" ");
            for(a children:p.child)
            {
                q.add(children);
            }

        }
        System.out.println(".");
    }
    public static void levelOrderLinewise(a node)
    {
        Queue<a> mq=new ArrayDeque<>();
        Queue<a> cq=new ArrayDeque<>();
        mq.add(node);
        while(mq.size()>0 || cq.size()>0)
        {
            a p=mq.remove();
            System.out.print(p.data+" ");
            for(a children: p.child)
            {
                cq.add(children);
            }
            if(mq.size()==0)
            {
                mq=cq;
                cq=new ArrayDeque<>();
                System.out.println(".");
            }
        }
    }
    public static void levelOrderZigZag(a node)
    {
        Stack<a> ms=new Stack<>();
        Stack<a> cs=new Stack<>();
        ms.add(node);
       int  level=1;

        while(ms.size()>0 || cs.size()>0)
        {
            a p=ms.pop();
            System.out.print(p.data+" ");
            if(level%2==1) {
                for (a children : p.child) {
                    cs.add(children);
                }
            }
            else
            {
               for(int i=p.child.size()-1;i>=0;i--)
               {
                   cs.add(p.child.get(i));
               }
            }
            if(ms.size()==0)
            {
                ms=cs;
                cs=new Stack<>();
                System.out.println(".");
                level++;
            }
        }
    }
    public static void levelOrderLinewise2(a node)
    {
        Queue<a> mq=new ArrayDeque<>();

        mq.add(node);
        mq.add(new a(-1));
        while(mq.size()>0)
        {
            a p=mq.remove();
            //System.out.println(p.data);

            if(p.data!=-1) {
                System.out.print(p.data+" ");
                for (a children : p.child) {
                    mq.add(children);
                }
            }
            else
            {
                if(mq.size()>0)
                {

                    System.out.println();
                    mq.add(new a(-1));


                }
            }

        }
    }
    /*there is also one method where we can store the size of the current queue size
     and will make it run till then
     */
    private static class Pair{
        a node;
        int level;
        Pair(a n1,int level)
        {
            this.node=n1;
            this.level=level;
        }
    }
    public static void levelOrderLinewise3(a node)
    {
        Queue<Pair> mq=new ArrayDeque<>();
        mq.add(new Pair(node , 1));
        int level=1;
        while(mq.size()>0)
        {
            Pair p=mq.remove();
            if(p.level>level)
            {
                System.out.println();
                level=p.level;
            }
            System.out.print(p.node.data+" ");
            for(a children:p.node.child)
            {
                mq.add(new Pair(children,p.level+1));
            }

        }

    }

    public static void removeLeaves(a node)
    {
        for(int i=node.child.size()-1;i>=0;i--)
        {
            a p=node.child.get(i);
            if(p.child.size()==0)
                node.child.remove(p);
        }

        for(a children:node.child)
        {
            removeLeaves(children);
        }
    }



    public static void main (String[] args) throws java.lang.Exception
    {
        a root=null;
        int arr[]={10,20,50,-1,60,-1,-1,30,140,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Stack <a> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {

            if(arr[i]==-1)
                st.pop();
            else
            {
                a node=new a();
                node.data=arr[i];
                if(st.size()>0)
                {
                    st.peek().child.add(node);
                    st.push(node);
                }
                else
                {
                    root=node;
                    st.push(node);
                }
            }
        }
        //display(root);
        //int p=size(root);
        // int p=maxsize(root);
        //  int p=height(root);
        //System.out.println(p);
        //traversal(root);
        //levelOrder(root);
        //levelOrderLinewise(root);
        // levelOrderZigZag(root);
        //levelOrderLinewise2(root);
        //levelOrderLinewise3(root);
        removeLeaves(root);
        //display(root);
        // your code goes here
    }
}
