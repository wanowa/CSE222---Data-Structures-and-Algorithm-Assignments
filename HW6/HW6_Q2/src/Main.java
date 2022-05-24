public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 2, 7, 6, 4, 5, 1};
        MyMergeSort myMergeSort = new MyMergeSort();

        myMergeSort.sort(arr);
        /*for (int j : arr) {
            System.out.println(j + "\n");
        }*/

        arr = new Integer[]{3, 2, 7, 6, 4, 5, 1};

        MyQuickSort myQuickSort = new MyQuickSort();
        myQuickSort.sort(arr);

        /*
        for (int j : arr) {
            System.out.println(j + "\n");
        }
        */

        arr = new Integer[]{3, 2, 7, 6, 4, 5,10,11, 1, 8,9};
        NewSort myNewSort = new NewSort();
        myNewSort.new_sort(arr, 0, arr.length-1);
        for (int j : arr) {
            System.out.println(j + "\n");
        }
    }
}