import java.util.*;

public class Ex10_TopologicalSort {
    public static List<Integer> topologicalSort(List<List<Integer>> adj) {
        int n = adj.size();
        int[] indeg = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v : adj.get(u)) indeg[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) q.add(i);

        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (int v : adj.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) q.add(v);
            }
        }

        if (order.size() != n) return Collections.emptyList(); // ciclo detectado
        return order;
    }

    // Demo simples
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de vértices: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        System.out.println("Digite arestas direcionadas u v (u -> v). Linha vazia para terminar:");
        while (true) {
            String l = sc.nextLine().trim();
            if (l.isEmpty()) break;
            String[] p = l.split("\\s+");
            int u = Integer.parseInt(p[0]), v = Integer.parseInt(p[1]);
            adj.get(u).add(v);
        }

        List<Integer> topo = topologicalSort(adj);
        if (topo.isEmpty()) System.out.println("O grafo possui ciclo (não é DAG).");
        else System.out.println("Ordenação topológica: " + topo);

        sc.close();
    }
}
