public class Question2 {
    /**
     * Given an array, find the number of elements that are between two indices
     *
     * @param arr the array to search
     * @param first the first index of the array
     * @param second the index of the second element in the array.
     * @return The number of elements between the two indices.
     */
    public int numberOfElements(int[] arr, int first, int second){
        int number = helper(arr, first, second, 0, 0, arr.length-1,0, false, false);
        if(number == -1)
            return -1;
        return number;
    }
    /**
     * If the first number is not found, then return -1.
     * If the second number is not found, then return -1.
     * If both numbers are found, then return the absolute value of the difference between the indices of the two numbers.
     * If neither number is found, then return -1
     *
     * @param arr the array to search
     * @param first the first number to search for
     * @param second the number we're looking for
     * @param i1 the index of the first number
     * @param i2 the index of the second element in the array.
     * @param right the rightmost index of the array
     * @param left the leftmost index of the array
     * @param firstFounded boolean to check if the first number is found
     * @param secondFounded boolean that indicates whether the second number has been found
     * @return The number of elements between the two numbers.
     */
    private int helper(int[] arr, int first, int second, int i1, int i2, int right, int left, boolean firstFounded, boolean secondFounded){
        if(!firstFounded){
            if(right < left)
                i1 = -1;

            int middle = left + (right - left)/2;

            if (arr[middle] == first) {
                i1 = middle;
                firstFounded = true;
                return helper(arr, first, second, i1, i2, arr.length-1, 0, firstFounded, secondFounded);
            }
            if (arr[middle] > first)
                return helper(arr, first, second, i1, i2, middle-1, left, firstFounded, secondFounded);

            return helper(arr, first, second, i1, i2, right, middle+1, firstFounded, secondFounded);
        }
        else if(!secondFounded){
            if(right < left)
                i2 = -1;

            int middle = left + (right - left)/2;

            if (arr[middle] == second) {
                i2 = middle;
                secondFounded = true;
                return helper(arr, first, second, i1, i2, arr.length-1, 0, firstFounded, secondFounded);
            }

            else if (arr[middle] > second)
                return helper(arr, first, second, i1, i2, middle-1, left, firstFounded, secondFounded);

            return helper(arr, first, second, i1, i2, right, middle+1, firstFounded, secondFounded);
        }
        else{
            if(i1 == -1 || i2 == -1)
                return -1;
            return Math.abs(i1 - i2)-1;
        }
    }
}