package TREE;
import java.util.*;

public class LevelOrderTravesal {
    public static TreeNode buildTree(ArrayList<Integer> vec) {
        int n = vec.size();
        if (n == 0 || vec.getFirst() == 0) {
            return null;

        }
        TreeNode root = new TreeNode(vec.getFirst());
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < n) {
            TreeNode node = q.poll();
            if (vec.get(i) != -1) {
                node.left = new TreeNode(vec.get(i));
                q.add(node.left);
            }
            i++;
            if (i >= n) {
                break;
            }
            if (vec.get(i) != -1) {
                node.right = new TreeNode(vec.get(i));
                q.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void levelOrder(TreeNode root) {
        if(root == null){
            return ;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            System.out.print(node.data + " ");
            if(node.left!= null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
    }

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
        System.out.println("Level order traversal is: ");
        levelOrder(root);
    }
}
