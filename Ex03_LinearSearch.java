import java.util.Scanner;

public class Ex03_LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i; // retorna índice (0-based)
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite números do array separados por espaço:");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i]);
        System.out.print("Número a buscar: ");
        int target = Integer.parseInt(sc.nextLine().trim());
        int pos = linearSearch(arr, target);
        if (pos >= 0) System.out.println("Encontrado na posição (0-based): " + pos);
        else System.out.println("Não encontrado (-1).");
        sc.close();
    }
}
