import java.util.Scanner;

class Node {
    int val;
    Node left, right;
    Node(int v) { val = v; }
}

public class Ex02_ValidateBST {
    // Verifica BST usando limites (long para evitar overflow)
    public static boolean isBST(Node node) {
        return isBSTRec(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isBSTRec(Node node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isBSTRec(node.left, min, node.val) && isBSTRec(node.right, node.val, max);
    }

    // Pequeno exemplo de construção manual e verificação
    public static void main(String[] args) {
        /*
         Exemplo:
                8
               / \
              3   10
             / \    \
            1   6    14
         */
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);

        System.out.println("Árvore de exemplo é BST? " + isBST(root));

        // Interface simples para usuário construir uma árvore (simples, usando inserção BST)
        Scanner sc = new Scanner(System.in);
        System.out.println("\nTeste interativo: digite números separados por espaço para criar BST (primeiro é raiz):");
        String line = sc.nextLine().trim();
        if (!line.isEmpty()) {
            String[] parts = line.split("\\s+");
            Node r = new Node(Integer.parseInt(parts[0]));
            for (int i = 1; i < parts.length; i++) {
                insertBST(r, Integer.parseInt(parts[i]));
            }
            System.out.println("A árvore construída é BST? " + isBST(r));
        }
        sc.close();
    }

    private static void insertBST(Node node, int val) {
        if (val <= node.val) {
            if (node.left == null) node.left = new Node(val);
            else insertBST(node.left, val);
        } else {
            if (node.right == null) node.right = new Node(val);
            else insertBST(node.right, val);
        }
    }
}
