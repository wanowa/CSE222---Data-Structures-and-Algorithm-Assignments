public class Question1 {
    /**
     * Given a query string and a big string, find the starting index of the query string in the big string
     *
     * @param queryString the string to be searched for
     * @param bigString The string to search through.
     * @param i the index of the current character in the big string
     * @return The index of the first character of the queryString in the bigString.
     */
    public int searchString(String queryString, String bigString, int i){
        return helper(queryString, bigString, i, 0 );
    }

    /**
     * Given a query string and a big string, find the index of the query string in the big string
     *
     * @param queryString the string to be searched for
     * @param bigString The string we are searching in.
     * @param i The number of times the query string appears in the big string.
     * @param index the index of the current character in the big string
     * @return The index of the queryString in the bigString.
     */
    private int helper(String queryString, String bigString, int i, int index){
        if(i == 0)
            return index - queryString.length();
        if(bigString.indexOf(queryString) == -1)
            return -1;
        index = index + bigString.indexOf(queryString);
        bigString = bigString.substring(bigString.indexOf(queryString) + queryString.length());
        return helper(queryString, bigString, --i, queryString.length() + index);
    }
}