import java.util.ArrayList;
import java.util.Scanner;
public class Test {
    /**
     * This function is used to test the three parts of the assignment.
     */
    public void start(){
        boolean test = true;
        Scanner s = new Scanner(System.in);
        System.out.println("\n___________________QUESTION-1___________________");
        part1();
        System.out.println("\n___________________QUESTION-2___________________");
        part2();
        System.out.println("___________________QUESTION-3___________________");
        part3();
    }

    /**
     * Given a query string and a big string, find the occurrence of the query string in the big string
     */
    private void part1(){
        Scanner sc = new Scanner(System.in);
        Question1 q1 = new Question1();

        int index;
        int occurrence1 = 1;
        int occurrence2 = 2;
        int occurrence3 = 3;
        int occurrence4 = 4;
        int occurrence5 = 5;

        String bigString1 = "ayusufbcyusufdefyusufghijklyusuf";
        String queryString1 = "yusuf";
        String bigString2 = " ";
        String queryString2 = "deneme";
        String bigString3 = "question asdf ghj question76267 question";
        String queryString3 = "question";

        index = q1.searchString(queryString1, bigString1, occurrence1);
        printPart1(index, occurrence1, bigString1, queryString1);

        index = q1.searchString(queryString1, bigString1, occurrence2);
        printPart1(index, occurrence2, bigString1, queryString1);

        index = q1.searchString(queryString1, bigString1, occurrence5);
        printPart1(index, occurrence5, bigString1, queryString1);

        index = q1.searchString(queryString2, bigString2, occurrence1);
        printPart1(index, occurrence1, bigString1, queryString1);

        index = q1.searchString(queryString3, bigString3, occurrence1);
        printPart1(index, occurrence1, bigString3, queryString3);

        index = q1.searchString(queryString3, bigString3, occurrence4);
        printPart1(index, occurrence4, bigString3, queryString3);
    }

    /**
     * Print the index of the occurrence of the query string in the big string
     *
     * @param index the index of the first occurrence of the query string in the big string.
     * @param occurrence the occurrence of the query string in the big string
     * @param bigString the string to search in
     * @param queryString the string to search for
     */
    private void printPart1(int index, int occurrence, String bigString, String queryString){
        if(index == -1)
            System.out.println("There is no "+occurrence+" times of "+queryString+" in the "+bigString+"\n");
        else
            System.out.println(occurrence+"th occurrence of "+queryString+" founded in "+bigString+" at index "+index+"\n");
    }


    private void part2(){
        int[] sortedArray1 = new int[]{10,20,30,40,50,60,70,80,90};
        int[] sortedArray2 = new int[]{2, 4, 6, 8, 10, 12, 14, 16};
        int[] sortedArray3 = new int[]{53, 54, 55, 61, 81, 153, 155, 161, 167};
        int first1 = 20, second1 = 70, first2 = 4, second2 = 4, first3 = 54, second3 = 55, first4 = 81, second4 = 167;
        printPart2(first1, second1, sortedArray1);
        printPart2(first2, second2, sortedArray2);
        printPart2(first3, second3, sortedArray3);
        printPart2(first4, second4, sortedArray3);
    }
    /**
     * This function prints the number of elements between two given elements in an array
     *
     * @param first the first element in the range
     * @param second the second element in the array
     * @param arr the array to search
     */
    private void printPart2(int first, int second, int[] arr){
        Question2 q2 = new Question2();
        if(first == second){
            System.out.println("There is 0 element between "+first+" and "+second+"\n");
        }
        else{
            int number = q2.numberOfElements(arr,first,second);
            if(number == -1)
                System.out.println("One or more element doesn't exist in array!\n");
            else{
                System.out.println("There is "+number+" elements between "+first+" and "+second+"\n");
            }
        }
    }

    /**
     * Given an array of integers and a target integer, find the two integers in the array that sum to the target
     */
    private void part3(){
        int[] elements = new int[]{9, 1, 3, 6, 4, -2, 8, 7, 9, -6, 10};
        int target = 10;
        int[] elements1 = new int[]{1, 4, 5, -8, 2, 7, 9, 1, -5, 6, 3, };
        int target1 = 5;
        int[] elements2 = new int[]{2, 4, 6 -5, 8, -3, 10, 1, -2, 3, 5, 7, -6};
        int target2 = 6;
        printPart3(elements, target);
        printPart3(elements1, target1);
        printPart3(elements2, target2);
    }
    /**
     * Given an array of integers and a target integer, find all contiguous subarrays that sum to the target integer
     *
     * @param elements an array of integers
     * @param target the sum of the integers that we're looking for
     */
    private void printPart3(int[] elements, int target){
        Question3 q3 = new Question3();
        ArrayList<ArrayList<Integer>> arrays;
        arrays = q3.findContiguousSubArrays(elements, target);
        System.out.println("My elements are : ");
        for (int element : elements) {
            System.out.print("[" + element + "] ");
        }
        System.out.println("\nFounded Integers that their sum is "+target+" :");
        for (ArrayList<Integer> array : arrays) {
            for (Integer integer : array) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}