/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;

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
    //It will print all the node linearly
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
    //It will print all the nodes in same level in a same line.
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

    // for(int i=node.child.size()-1;i>=0;i--)
    //{
    //    a p=node.child.get(i);
    //if(p.child.size()==0)
    //        node.child.remove(p);
    //}


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
//if we perform the operation after calling then it will remove the future node
// which will make it to remove the past node also

//        for(int i=node.child.size()-1;i>=0;i--)
//        {
//            a p=node.child.get(i);
//            if(p.child.size()==0)
//                node.child.remove(p);
//        }
    }

    public static void Linearize(a node)
    {
        for(a children:node.child)
        {
            //the faith in this recursion is that it will return a
            // linear layer with children node
            Linearize(children);
        }

        while(node.child.size()>1)
        {
            // to remove the last child of the parent node.
            a lc=node.child.remove(node.child.size()-1);
            // to remove the second last child of the parent node.
            a sl=node.child.get(node.child.size()-1);
            a tail=getTail(sl);
            tail.child.add(lc);
        }
    }

      public static a getTail(a node)
      {
          while(node.child.size()==1)
          {
              node=node.child.get(0);
          }
          return node;
      }

      public static boolean find(a node,int data)
      {
          if(node.data==data)
          {
              return true;
          }
          for(a children: node.child)
          {
              boolean fic=find(children,data);
              if(fic)
              {
                  return true;
              }
          }
          return false;
      }
      public static ArrayList<Integer> nodetorootpath(a node,int data)
      {
          if(node.data==data)
          {
              ArrayList<Integer> arr=new ArrayList<>();
              arr.add(node.data);
              return arr;
          }
          for(a children:node.child)
          {
             ArrayList<Integer> arr=nodetorootpath(children,data);
             if(arr.size()>0)
             {
                 arr.add(node.data);
                 return arr;
             }
          }
          return new ArrayList<>();
      }
      public static void lowestCommonAncestor(a node,int data1,int data2)
      {
          ArrayList<Integer> l1=nodetorootpath(node,data1);
          ArrayList<Integer> l2=nodetorootpath(node,data2);
          int i=l1.size()-1;
          int j=l2.size()-1;
          while(i>=0 && j>=0 && l1.get(i)==l2.get(j))
          {
              i--;
              j--;
          }
          i++;
          System.out.println(l1.get(i));
      }
      public static void DistanceBetweenEdges(a node,int data1,int data2)
      {
          ArrayList<Integer> l1=nodetorootpath(node,data1);
          ArrayList<Integer> l2=nodetorootpath(node,data2);
          int i=l1.size()-1;
          int j=l2.size()-1;
          while(i>=0 && j>=0 && l1.get(i)==l2.get(j))
          {
              i--;
              j--;
          }
          i++;
          j++;
          System.out.println(i+j);

      }
      public static boolean SimilarShape(a node1,a node2)
      {
          if(node1.child.size()!=node2.child.size())
          {
              return false;
          }
          for(int i=0;i<node1.child.size();i++)
          {
              a p1=node1.child.get(i);
              a p2=node2.child.get(i);
              if(SimilarShape(p1,p2)==false)
                  return false;
          }
          return true;
      }

    public static boolean MirrorShape(a node1,a node2)
    {
        if(node1.child.size()!=node2.child.size())
        {
            return false;
        }
        for(int i=0;i<node1.child.size();i++)
        {
            int j=node1.child.size()-1-i;
            a p1=node1.child.get(i);
            a p2=node2.child.get(j);
            if(MirrorShape(p1,p2)==false)
                return false;
        }
        return true;
    }
    static int ceil;
    static int floor;


    public static void ceilandfloor(a node,int data)
    {
        if(node.data<data)
        {
            if(floor<node.data)
                floor=node.data;
        }
        else if(node.data>data)
        {
            if(ceil>node.data)
                ceil=node.data;
        }

            for(a children: node.child)
            {
                ceilandfloor(children,data);
            }

    }



    public static void main (String[] args) throws java.lang.Exception
    {
        a root=null;
        int arr[]={10,20,50,-1,60,-1,-1,30,140,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Stack<a> st=new Stack<>();
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
        display(root);
       // Linearize(root);
        //display(root);
        //System.out.println(find(root,70));
       // ArrayList<Integer> arr1=nodetorootpath(root,80);
       // for(int data:arr1)
      //   {
      //     System.out.println(data);
      // }
       // lowestCommonAncestor(root,80,110);
        //DistanceBetweenEdges(root,80,110);
        //ceil=Integer.MAX_VALUE;
       // floor=Integer.MIN_VALUE;
        //ceilandfloor(root,65);
       // System.out.println(floor+" "+ceil);
        // your code goes here
    }
}
