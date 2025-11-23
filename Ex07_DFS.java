import java.util.*;

public class Ex07_DFS {
    private static void dfsRec(int u, boolean[] visited, List<List<Integer>> adj, List<Integer> out) {
        visited[u] = true;
        out.add(u);
        for (int v : adj.get(u)) {
            if (!visited[v]) dfsRec(v, visited, adj, out);
        }
    }

    public static List<Integer> dfs(int start, List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        List<Integer> visitedOrder = new ArrayList<>();
        dfsRec(start, visited, adj, visitedOrder);
        return visitedOrder;
    }

    public static void main(String[] args) {
        // Demonstração simples
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de vértices: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        System.out.println("Digite arestas u v (uma por linha). Linha vazia para terminar:");
        while (true) {
            String l = sc.nextLine().trim();
            if (l.isEmpty()) break;
            String[] p = l.split("\\s+");
            int u = Integer.parseInt(p[0]), v = Integer.parseInt(p[1]);
            adj.get(u).add(v);
            // para grafo não-direcionado:
            adj.get(v).add(u);
        }

        System.out.print("Início da DFS: ");
        int start = Integer.parseInt(sc.nextLine().trim());
        List<Integer> order = dfs(start, adj);
        System.out.println("Ordem de visita (DFS): " + order);
        sc.close();
    }
}
