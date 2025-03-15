package LabFour;

import java.util.ArrayList;
import java.util.Scanner;

public class SecondMax {
    private static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val == root.val) {
            return root;
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private static void inOrderTraversal(TreeNode root, ArrayList<Integer> elements) {
        if (root != null) {
            inOrderTraversal(root.left, elements);
            elements.add(root.val);
            inOrderTraversal(root.right, elements);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            root = insert(root, num);
        }

        ArrayList<Integer> elements = new ArrayList<>();
        inOrderTraversal(root, elements);

        int secondLargest = elements.get(elements.size() - 2);
        System.out.println(secondLargest);
    }
}
