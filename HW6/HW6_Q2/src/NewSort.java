import java.util.ArrayList;
import java.lang.Number;

public class NewSort<T extends Comparable<T>> {
    private T min;
    private T max;
    private int minIndex;
    private int maxIndex;

    NewSort(){
        minIndex = 0;
        maxIndex = 0;
    }

    public T[] new_sort(T[] table, int head, int tail){
        min = table[table.length - 1];
        max = table[0];
        if(head > tail){
            if(table[table.length / 2].compareTo(table[table.length/2 - 1]) < 0){
                swap(table, table.length / 2, table.length/2 - 1);
            }
            return table;
        }

        else{
            min_max_finder(table, head, tail);

            swap(table, head, minIndex);
            swap(table, tail, maxIndex);
            return new_sort(table, head + 1, tail - 1);
        }
    }

/*
IF (head > tail)
    Return array;
ELSE{
    MIN, MAX = min_max_finder(array, head, tail);
    swap(array[head], array[MIN]);
    swap(array[tail], array[MAX]);
    Return new_sort(array, head + 1, tail -1);
}
The min_max_finder() is a recursive function that returns the indices of minimum and
maximum items between the given head and tail items in a single execution together. Don’t
implement this function by calling separate functions that find min and max items. Your
recursive function should divide the problem into two almost equal size subproblems.
*/

    private static <T> void swap(T[] table, int i, int j) {
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }

    public void min_max_finder(T[] nums, int left, int right){
        int mid;
        if (left == right){
            if (max.compareTo(nums[left]) < 0) {
                max = nums[left];
                maxIndex = left;
            }

            if (min.compareTo(nums[right]) > 0) {
                min = nums[right];
                minIndex = right;
            }
            return;
        }

        else if (right - left == 1)
        {
            if (nums[left].compareTo(nums[right]) < 0)
            {
                if (min.compareTo(nums[left]) > 0) {      // comparison 2
                    min = nums[left];
                    minIndex = left;
                }

                if (max.compareTo(nums[right]) < 0) {     // comparison 3
                    max = nums[right];
                    maxIndex = right;
                }
            }
            else {
                if (min.compareTo(nums[right]) > 0) {     // comparison 2
                    min = nums[right];
                    minIndex = right;
                }

                if (max.compareTo(nums[left]) < 0) {      // comparison 3
                    max = nums[left];
                    maxIndex = left;
                }
            }
            return;
        }

        mid = (left + right) / 2;
        min_max_finder(nums, left, mid);
        min_max_finder(nums, mid + 1, right);
    }
}
