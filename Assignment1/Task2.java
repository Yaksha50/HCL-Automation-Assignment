package Assignment1;

import java.util.Scanner;

/*Write a menu driven program in Java to perform insertion, deletion, linear search, binary search,
 to find maximum value, to count even/ odd and to perform insertion sort operation in one dimensional
  array. */
public class Task2 {

        public static int binarySearch(int[] arr, int target) {
                    int low = 0;
                    int high = arr.length - 1;

                     while (low <= high) {
                             int mid = low + (high - low) / 2;

                             if (arr[mid] == target) {
                             return mid;
                             }
                             else if (arr[mid] < target) {
                                        low = mid + 1;
                             } 
                             else {
                                 high = mid - 1;
                            }
                    }

             return -1;
        }
    
        static void linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Element found at index " + i);
                return;
            }
        }

        System.out.println("Element not found");
    }

    static int[] insertion(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = element;

        return newArr;

    }

    static  boolean deletion(int[] arr, int element) {

        boolean elementPresent = false;
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
                if (arr[i] == element) {
                        elementPresent = true;
                }
                 else {
                    arr[j] = arr[i];
                    j++;
                }
}

        if (!elementPresent) {
            System.out.println("Element not found in the array");
            for(int i = 0 ; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            
        }  

       else{ System.out.println("Element deleted successfully");
        for(int i = 0 ; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();}
        return elementPresent;
    }

    static int maxValue (int[] arr) {
        int max =Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    static int even (int[] arr ,int n) {
        int countEven = 0;
         for(int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                countEven++;
            }}
        return countEven;
    }
    public static void insertionSort(int[] arr , int n) {
         
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int []arr = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        do{
            System.out.println("Enter 1 for insertion");
            System.out.println("Enter 2 for deletion");
            System.out.println("Enter 3 for linear search");
            System.out.println("Enter 4 for binary search");
            System.out.println("Enter 5 to find maximum value");
            System.out.println("Enter 6 to count even numbers");
            System.out.println("Enter 7 to perform insertion sort");
            System.out.println("Enter 8 to exit");
            System.out.println("Enter your choice");
            int ch = sc.nextInt();
            if(ch==8) return;
            switch(ch){
                case 1:
                    System.out.println("Enter the element to be inserted");
                    int elementToInsert = sc.nextInt();
                    arr = insertion(arr, elementToInsert);
                    System.out.println("Element inserted successfully");
                    System.out.println("Array after insertion:");
                    for (int i : arr) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter the element to be deleted");
                    int elementToDelete = sc.nextInt();
                    boolean isDeleted = deletion(arr, elementToDelete);
                    if (isDeleted) { n = n-1; }

                    break;
                case 3:
                    System.out.println("Enter the element to be searched (linear search)");
                    int target = sc.nextInt();
                    linearSearch(arr, target);
                    break;
                case 4:
                    System.out.println("Enter the element to be searched (binary search)");
                    int target1 = sc.nextInt();
                    insertionSort(arr , n); // Sort the array before performing binary search
                    int result = binarySearch(arr, target1);
                    if (result == -1) {
                        System.out.println("Element not found");
                    } else {
                        System.out.println("Element found at index " + result);
                    }
                    break;
                case 5:
                    int max = maxValue(arr);
                    System.out.println("Maximum value in the array: " + max);
                    break;
                case 6:
                    int countEven = even(arr , n);
                    System.out.println("Count of even numbers in the array: " + countEven);
                    System.out.println("Count of odd numbers in the array: " + (arr.length - countEven));
                    break;
                case 7:
                    insertionSort(arr , n);

                    System.out.println("Array after insertion sort:");
                    for (int i : arr) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while(true);
    }
}
