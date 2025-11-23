import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int year;

    Book(String t, String a, int y) {
        this.title = t;
        this.author = a;
        this.year = y;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d)", title, author, year);
    }
}

class TreeNode {
    Book book;
    TreeNode left, right;

    TreeNode(Book b) {
        this.book = b;
    }
}

public class Ex01_BinaryTree {
    private TreeNode root;

    // Inserção simples (por título lexicográfico)
    public void insert(Book b) {
        root = insertRec(root, b);
    }

    private TreeNode insertRec(TreeNode node, Book b) {
        if (node == null) return new TreeNode(b);
        if (b.title.compareToIgnoreCase(node.book.title) <= 0) {
            node.left = insertRec(node.left, b);
        } else {
            node.right = insertRec(node.right, b);
        }
        return node;
    }

    public List<Book> inorder() {
        List<Book> out = new ArrayList<>();
        inorderRec(root, out);
        return out;
    }

    private void inorderRec(TreeNode node, List<Book> out) {
        if (node == null) return;
        inorderRec(node.left, out);
        out.add(node.book);
        inorderRec(node.right, out);
    }

    public List<Book> preorder() {
        List<Book> out = new ArrayList<>();
        preorderRec(root, out);
        return out;
    }

    private void preorderRec(TreeNode node, List<Book> out) {
        if (node == null) return;
        out.add(node.book);
        preorderRec(node.left, out);
        preorderRec(node.right, out);
    }

    public List<Book> postorder() {
        List<Book> out = new ArrayList<>();
        postorderRec(root, out);
        return out;
    }

    private void postorderRec(TreeNode node, List<Book> out) {
        if (node == null) return;
        postorderRec(node.left, out);
        postorderRec(node.right, out);
        out.add(node.book);
    }

    // Demo via console
    public static void main(String[] args) {
        Ex01_BinaryTree library = new Ex01_BinaryTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserir livros (formato: titulo;autor;ano). Digite linha vazia para terminar:");
        while (true) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            String[] parts = line.split(";");
            if (parts.length != 3) {
                System.out.println("Formato inválido. Use: titulo;autor;ano");
                continue;
            }
            try {
                String t = parts[0].trim();
                String a = parts[1].trim();
                int y = Integer.parseInt(parts[2].trim());
                library.insert(new Book(t, a, y));
            } catch (NumberFormatException e) {
                System.out.println("Ano inválido.");
            }
        }

        System.out.println("\nIn-order (alfabético por título):");
        for (Book b : library.inorder()) System.out.println(b);

        System.out.println("\nPre-order:");
        for (Book b : library.preorder()) System.out.println(b);

        System.out.println("\nPost-order:");
        for (Book b : library.postorder()) System.out.println(b);

        sc.close();
    }
}
