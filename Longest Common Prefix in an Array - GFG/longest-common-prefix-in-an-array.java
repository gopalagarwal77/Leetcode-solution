//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        if(arr==null||arr.length==0){
            return "-1";
        }
        
        String str=arr[0];
        for(int i=1;i<n;i++){
            String current=arr[i];
            int j=0;
            while(j<current.length()&&j<str.length()&&current.charAt(j)==str.charAt(j)){
                j++;
            }
            if(j==0){
                return "-1";
            }
            str=current.substring(0,j);
        }
        
        return str;
    }
}