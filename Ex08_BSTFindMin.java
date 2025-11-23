import java.util.Scanner;

class BSTNode {
    int val;
    BSTNode left, right;
    BSTNode(int v) { val = v; }
}

public class Ex08_BSTFindMin {
    public static Integer findMin(BSTNode root) {
        if (root == null) return null;
        BSTNode cur = root;
        while (cur.left != null) cur = cur.left;
        return cur.val;
    }

    public static BSTNode insert(BSTNode root, int val) {
        if (root == null) return new BSTNode(val);
        if (val <= root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite valores para inserir na BST separados por espaço:");
        String[] parts = sc.nextLine().trim().split("\\s+");
        BSTNode root = null;
        for (String p : parts) {
            if (p.trim().isEmpty()) continue;
            root = insert(root, Integer.parseInt(p.trim()));
        }
        Integer min = findMin(root);
        if (min == null) System.out.println("Árvore vazia.");
        else System.out.println("Menor valor na BST: " + min);
        sc.close();
    }
}
