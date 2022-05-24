import java.util.ArrayList;
public class Question3 {
    /**
     * Given an array of integers, find all contiguous subarrays whose sum equals to a given target
     *
     * @param elements the array of integers
     * @param target the sum of the contiguous subarray we're looking for
     * @return An array of arrays.
     */
    public ArrayList<ArrayList<Integer>> findContiguousSubArrays(int[] elements, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
        helper(elements, target, arrays, arr, 0, 0, 0);
        return arrays;
    }

    /**
     * Given an array of integers, find all possible combinations of integers that sum up to a target number
     *
     * @param elements The array of integers.
     * @param target the sum we're trying to achieve
     * @param arrays This is the list of all the arrays that we have found so far.
     * @param arr the current subset of the array
     * @param startIndex The index of the first element in the array.
     * @param increment The increment to be added to the startIndex to get the next element.
     * @param sum the sum of the current subset
     */
    private void helper(int[] elements, int target, ArrayList<ArrayList<Integer>> arrays, ArrayList<Integer> arr, int startIndex, int increment, int sum) {
        if (startIndex != elements.length) {
            if (startIndex + increment == elements.length) {
                helper(elements, target, arrays, new ArrayList<>(), startIndex + 1, 0, 0);
            } else {
                sum = sum + elements[startIndex + increment];
                arr.add(elements[startIndex + increment]);
                if (sum == target)
                    arrays.add(arr);
                helper(elements, target, arrays, new ArrayList<>(arr), startIndex, increment + 1, sum);
            }
        }
    }
}