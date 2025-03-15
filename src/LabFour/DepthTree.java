package LabFour;

import java.util.Scanner;

public class DepthTree {
    private static void insertAndPrintDepth(TreeNode root, int val) {
        int depth = 1;
        TreeNode current = root;

        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    System.out.println(depth + 1);
                    break;
                } else {
                    current = current.left;
                    depth++;
                }
            } else if (val > current.val) {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    System.out.println(depth + 1);
                    break;
                } else {
                    current = current.right;
                    depth++;
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        int firstNum = scanner.nextInt();
        if (firstNum != 0) {
            root = new TreeNode(firstNum);
            System.out.println(1);
        }

        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            if (root == null) {
                root = new TreeNode(num);
                System.out.println(1);
            } else {
                insertAndPrintDepth(root, num);
            }
        }
    }
}
