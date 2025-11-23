import java.util.*;

public class Ex06_BFSShortestPath {
    public static List<Integer> bfsShortestPath(List<List<Integer>> adj, int src, int target) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == target) break;
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    q.add(v);
                }
            }
        }

        if (!visited[target]) return Collections.emptyList(); // sem caminho

        // reconstruir caminho
        LinkedList<Integer> path = new LinkedList<>();
        int cur = target;
        while (cur != -1) {
            path.addFirst(cur);
            cur = parent[cur];
        }
        return path;
    }

    // Demo: cria grafo via entrada simples
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantidade de vértices:");
        int n = Integer.parseInt(sc.nextLine().trim());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        System.out.println("Digite arestas no formato u v (uma por linha). Linha vazia para terminar:");
        while (true) {
            String l = sc.nextLine().trim();
            if (l.isEmpty()) break;
            String[] p = l.split("\\s+");
            int u = Integer.parseInt(p[0]), v = Integer.parseInt(p[1]);
            adj.get(u).add(v);
            adj.get(v).add(u); // grafo não ponderado e não direcionado para rota
        }

        System.out.print("Origem: ");
        int s = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Destino: ");
        int t = Integer.parseInt(sc.nextLine().trim());

        List<Integer> path = bfsShortestPath(adj, s, t);
        if (path.isEmpty()) System.out.println("Nenhum caminho encontrado.");
        else System.out.println("Caminho mais curto (vértices): " + path);

        sc.close();
    }
}
