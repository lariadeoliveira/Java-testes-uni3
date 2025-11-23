import java.util.Arrays;
import java.util.Scanner;

public class Ex04_BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite números (não necessariamente ordenados) separados por espaço:");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i]);
        Arrays.sort(arr);
        System.out.println("Array ordenado: " + Arrays.toString(arr));
        System.out.print("Valor a buscar: ");
        int target = Integer.parseInt(sc.nextLine().trim());
        int pos = binarySearch(arr, target);
        System.out.println(pos >= 0 ? "Encontrado na posição (0-based): " + pos : "Não encontrado (-1).");
        sc.close();
    }
}
