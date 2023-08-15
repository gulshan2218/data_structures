
import java.util.*;
import java.lang.*;
public class Stack1 {
    public static void nge(int gul[],int n)
    {
        Stack<Integer> st=new Stack<>();
        st.push(gul[n-1]);
        int gul1[]=new int[n];
        gul1[n-1]=-1;
        for(int i=n-2;i>=0;i--)
        {
            while(st.size()>0 && st.peek()<=gul[i] )
                st.pop();
            if(st.size()!=0) {
                gul1[i] = st.peek();
            }
            else
            {
                gul1[i] = -1;
            }
            st.push(gul[i]);

        }
        for(int i=0;i<n;i++)
        {
            System.out.print(gul1[i]+" ");
        }
        System.out.println();
    }
    public static void ngealternative(int gul[],int n)
    {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int gul1[]=new int[n];

        for(int i=1;i<n;i++)
        {
            while(st.size()>0 && gul[st.peek()]<gul[i] ) {
                int p=st.peek();
                gul1[p]=gul[i];
                st.pop();
            }
            st.push(i);

        }
        while(st.size()>0)
        {
            int p=st.peek();
            gul1[p]=-1;
            st.pop();
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(gul1[i]+" ");
        }
        System.out.println();
    }
    public static void highestarea(int gul[],int n)
    {
        Stack<Integer> st=new Stack<>();
        int nsr[]=new int[n];
        int nsl[]=new int[n];
        nsr[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--)
        {
            while(st.size()>0 && gul[st.peek()]>=gul[i])
                st.pop();
            if(st.size()>0)
            {
                nsr[i]=st.peek();
            }
            else
            {
                nsr[i]=n;
            }
            st.push(i);
        }
        st=new Stack<>();
        st.push(0);
        nsl[0]=-1;
        for(int i=1;i<n;i++)
        {
            while(st.size()>0 && gul[st.peek()]>=gul[i])
                st.pop();
            if(st.size()>0)
            {
                nsl[i]=st.peek();
            }
            else
            {
                nsl[i]=-1;
            }
            st.push(i);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int area=gul[i]*(nsr[i]-nsl[i]-1);
            if(max<area)
                max=area;
        }
      for(int i=0;i<n;i++)
     {
           System.out.print(nsr[i]+" ");
       }
       System.out.println();
       for(int i=0;i<n;i++)
       {
            System.out.print(nsl[i]+" ");
       }
       System.out.println();
        System.out.println(max);

    }
    public static void maxArea(int[] height) {
        int n=height.length;
        Stack<Integer> st=new Stack<>();
        int nsr[]=new int[n];
        int nsl[]=new int[n];
        nsr[n-1]=n-1;
        st.push(n-1);
        for(int i=n-2;i>=0;i--)
        {
            int m=n-1;
            int p=0;

            while(st.size()>0)
            {

                if(height[i]<=height[st.peek()])
                {
                    m=st.peek();
                    p=1;

                }
                st.pop();

            }


            if(m==n-1 && p==0)
                nsr[i]=i;
            else
                nsr[i]=m;

            st.push(m);
            st.push(i);
        }
        st=new Stack<>();
        st.push(0);
        nsl[0]=0;
        for(int i=1;i<n;i++)
        {
            int m=0;
            int p=0;
            while(st.size()>0)
            {
                if(height[i]<=height[st.peek()])
                {
                    m=st.peek();
                    p=1;
                }
                st.pop();
            }

            if(m==0 && p==0)
                nsl[i]=i;
            else
                nsl[i]=m;

            st.push(m);
            st.push(i);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int area=height[i]*(nsr[i]-nsl[i]);
            if(max<area)
                max=area;
        }




        for(int i=0;i<n;i++)
        {
            System.out.print(nsr[i]+" ");
        }
        System.out.println();
        for(int i=0;i<n;i++)
        {
            System.out.print(nsl[i]+" ");
        }
        System.out.println();
        System.out.println( max);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int gul[]=new int[n];
        for(int i=0;i<n;i++)
        {
            gul[i]=sc.nextInt();
        }
        //nge(gul,n);
        //ngealternative(gul,n);
        //highestarea(gul,n);
        maxArea(gul);
    }
}
//2 5 9 3 1 12 6 8 7
//6 2 5 4 5 1 6