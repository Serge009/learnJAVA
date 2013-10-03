/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package learnjava;

import java.util.Arrays;

/**
 *
 * @author SERGE
 */
public class LearnJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testInvert();
        System.out.println();
        
        testMerge();
        System.out.println();
        
        testBubbleSort();
        System.out.println();
        
        testSelectionSort();
        System.out.println();
        
        testInsertionSearch();
        System.out.println();
        
        testMul();
    }
    
    private static void testMul() {
        int[][] data1 = {
            {1, 3},
            {2, 4}
        };
        int[][] data2 = {
            {0, 1},
            {5, 6}
        };
        int[][] result = mul(data1, data2);
        for(int[] a: result){
            System.out.println(Arrays.toString(a));
        }
    }
    
    public static int[][] mul(int[][] a, int[][] b) {
        int[][] result = {
                            {0, 0},
                            {0, 0}
                        };
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                for(int k = 0; k < a.length; k++){
                    result[i][j] += a[i][k]*b[k][j];
                }
            }
        } 
        return result;
    }
    
    private static void testInsertionSearch() {
        int[][] data = {
                {},
                {1},
                {0, 3, 2},
                {6, 8, 3, 123, 5, 4, 1, 2, 0, 9, 7},
        };
        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " -> ");
            insertionSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
    
    private static void insertionSort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int location = -(Arrays.binarySearch(arr, 0, k, newElement)+1);
            System.arraycopy(arr, location, arr, location+1, k-location);
            arr[location] = newElement;
        }
    }
    
    private static void testSelectionSort() {
         int[][] data = {
                {},
                {1},
                {2, 1},
                {4, 6, 2},
                {0, 3, 2, 1},
                {6, 8, 3, 100, 5, 4, 1, 2, 0, 9, 7},
        };
        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " -> ");
            selectionSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void selectionSort(int[] arr) {
        int minIndex, minItem = 0;
         for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            minItem = arr[barrier];
            minIndex = barrier;
            for (int index = barrier + 1; index < arr.length; index++) {
                if (minItem > arr[index]) {
                    minItem = arr[index];
                    minIndex = index;
                }
            }
            swap(arr, minIndex, barrier);
        }
    }
    
    private static void testBubbleSort() {
        int[][] data = {
                {},
                {1},
                {0, 3, 2, 1},
                {6, 8, 3, 5, 4, 1, 2, 0, 9, 7},
        };
        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " -> ");
            bubbleSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
    
    private static void bubbleSort(int[] arr) {
        boolean flag;
        for(int barrier = 0; barrier < arr.length; barrier++){
            flag = false;
            for(int index = arr.length-1; index > barrier; index--){
                //System.out.println(index);
                if(arr[index] < arr[index-1]){
                    flag = true;
                    swap(arr, index, index-1);
                }
            }
            if(!flag){
                return;
            }
        }
    }
    
    private static void testInvert() {
        int[] arr = {1, 2, 3, 4, 5};
        //array inverting
        invert(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    private static void testMerge() {
        int[] mergArr1 = {1, 3};
        int[] mergArr2 = {1};
        int[] mergedArr; 
        
        //array merging
        mergedArr = merge(mergArr1, mergArr2);
        System.out.println(Arrays.toString(mergedArr));
    }
    
    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }
    
    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex + bIndex != result.length) {
            if (aIndex >= (a.length)) {
                System.arraycopy(b, bIndex, result, aIndex+bIndex, b.length-bIndex);
                return result;
            } else if(bIndex >= (b.length)) {
                System.arraycopy(a, aIndex, result, aIndex+bIndex, a.length-aIndex);
                return result;
            }
            
            
            if (a[aIndex] < b[bIndex]) {
                result[aIndex + bIndex] = a[aIndex++];
            } else {
                result[aIndex + bIndex] = b[bIndex++];
            }
        }
        return result;
    }

    private static void invert(int[] arr) {
        int middle = arr.length / 2;
        int secondIndex;
        for(int i = (middle-1); i >= 0; i--){
            secondIndex = arr.length-(i+1);
            swap(arr, i, secondIndex);
        }
    }
}