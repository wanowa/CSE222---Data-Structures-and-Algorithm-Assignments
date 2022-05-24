import java.io.Serializable;

public class Main {

    public static void main(String[] args) {

        System.out.println("---------FIRST CONVERT----------");

        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.createNSizeBinaryTree(0);
        Integer[] arr = {9, 2, 14, 6, 4, 13, 5, 8, 19, 1, 10, 7};
        Sorting<Integer> sorting = new Sorting<>();
        sorting.sortArray(arr);

        StringBuilder sb = new StringBuilder();
        binaryTree.binaryTreeToBST(binaryTree.getNode(), arr);
        binaryTree.preOrderTraverse(binaryTree.getNode(), 4, sb);
        System.out.println(sb);



        System.out.println("\n\n");

        System.out.println("---------SECOND CONVERT----------");


        BinaryTree<Integer> binaryTree2 = new BinaryTree<>();
        binaryTree.createNSizeBinaryTree(0);
        Integer[] arr2 = {100, 78, 111, 55, 34, 6, 41, 131, 125, 99, 42, 35};
        Sorting<Integer> sorting2 = new Sorting<>();
        sorting.sortArray(arr2);

        StringBuilder sb2 = new StringBuilder();
        binaryTree.binaryTreeToBST(binaryTree.getNode(), arr2);
        binaryTree.preOrderTraverse(binaryTree.getNode(), 4, sb2);
        System.out.println(sb2);


        System.out.println("\n\n");


        System.out.println("---------THIRD CONVERT----------");



        BinaryTree<Integer> binaryTree3 = new BinaryTree<>();
        binaryTree.createNSizeBinaryTree(0);
        Integer[] arr3 = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Sorting<Integer> sorting3 = new Sorting<>();
        sorting.sortArray(arr3);

        StringBuilder sb3 = new StringBuilder();
        binaryTree.binaryTreeToBST(binaryTree.getNode(), arr3);
        binaryTree.preOrderTraverse(binaryTree.getNode(), 4, sb3);
        System.out.println(sb3);

    }
}