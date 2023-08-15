import java.util.Stack;

public class BinaryTree {
    public static class a{
        int data;
        a left;
        a right;
        a(int data,a left,a right)
        {
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public static class pair
    {
        a node;
        int state;
        pair(a node,int state)
        {
            this.node=node;
            this.state=state;
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Integer arr[]={50,25, 12 ,null, null, 37, 30, null, null, null,75,62,null,70,null,null,87,null,null};
        a root=new a(arr[0],null,null);
        pair rtp=new pair(root,1);
        Stack<pair> st=new Stack<>();
        st.push(rtp);
        int idx=0;
        while(st.size()>0)
        {
            pair top=st.peek();
            if(top.state==1)
            {
                ++idx;
                if(arr[idx]!=null)
                {
                   top.node.left=new a(arr[idx],null,null);
                   pair rp=new pair(top.node.left,1);
                   st.push(rp);

                }
                else
                {
                    top.node.left=null;
                }
                top.state++;
            }
            else if(top.state==2)
            {
                ++idx;
              if(arr[idx]!=null)
              {
                  top.node.right=new a(arr[idx],null,null);
                  pair rp=new pair(top.node.right,1);
                  st.push(rp);

              }
              else
              {
                  top.node.right=null;
              }
              top.state++;
            }
            else
            {
                st.pop();
            }
        }

    }
}
