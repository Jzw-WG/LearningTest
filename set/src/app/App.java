package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {4,2,3,8};
        int X = 11;
        System.out.println(getMaxRemainderFromArr(arr, X));
    }

    public static Integer getMaxRemainderFromArr(int[] arr, int X) {
        int[] curMax = new int[arr.length];
        int maxSum = 0;
        
        for (int j = 1; j < arr.length; j++) {
            curMax[j - 1] = arr[j - 1]%X;
            for (int i = j; i < arr.length; i++) {
                curMax[i] = (curMax[i-1]+arr[i])%X;
                if(curMax[i] > maxSum){
                    maxSum = curMax[i];
                }
            }
        }        
        return maxSum;
    }
}