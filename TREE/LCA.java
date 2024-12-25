package TREE;

import java.util.*;

public class LCA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter the elements (use -1 for null nodes): ");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        TreeNode root = buildTree(arr);
        System.out.println("Enter the two nodes to find LCA:");
        int a = sc.nextInt();
        int m = sc.nextInt();

        TreeNode ans = lca(root, a, m);
        if (ans != null) {
            System.out.println("LCA: " + ans.data);
        } else {
            System.out.println("LCA not found");
        }
        sc.close();
    }

    // Function to find the LCA of two nodes
    static TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        // If one side is null, return the other side (whichever is non-null)
        return (left != null) ? left : right; 
    }

    // Function to build a tree from a list of integers
    static TreeNode buildTree(ArrayList<Integer> vec) {
        int n = vec.size();
        if (n == 0 || vec.get(0) == -1) {
            return null;
        }

        TreeNode root = new TreeNode(vec.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < n) {
            TreeNode node = q.poll();

            // For left child
            if (vec.get(i) != -1) {
                node.left = new TreeNode(vec.get(i));
                q.add(node.left);
            }
            i++;

            if (i >= n) break;

            // For right child
            if (vec.get(i) != -1) {
                node.right = new TreeNode(vec.get(i));
                q.add(node.right);
            }
            i++;
        }
        return root;
    }
}
