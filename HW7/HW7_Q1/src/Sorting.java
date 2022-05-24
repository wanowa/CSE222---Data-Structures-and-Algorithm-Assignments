public class Sorting<E extends Comparable<E>> {

    /**
     * For each element in the array, compare it to the next element and swap them if the first element is greater than the
     * second element.
     *
     * @param arr The array to be sorted
     */
    public void sortArray(E[] arr)
    {
        int n = arr.length;
        E temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
