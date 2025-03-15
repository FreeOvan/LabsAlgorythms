package LabFour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SearchTwoChildren {
    private static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private static void collectNodesWithTwoChildren(TreeNode root, ArrayList<Integer> nodes) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right != null) {
            nodes.add(root.val);
        }
        collectNodesWithTwoChildren(root.left, nodes);
        collectNodesWithTwoChildren(root.right, nodes);
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

        ArrayList<Integer> nodesWithTwoChildren = new ArrayList<>();
        collectNodesWithTwoChildren(root, nodesWithTwoChildren);

        Collections.sort(nodesWithTwoChildren);

        for (int node : nodesWithTwoChildren) {
            System.out.print(node + " ");
        }
    }
}
