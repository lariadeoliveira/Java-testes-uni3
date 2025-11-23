import java.util.*;

public class Ex09_DijkstraShortestPath {
    static class Edge {
        int to;
        int weight;
        Edge(int t, int w) { to = t; weight = w; }
    }

    public static List<Integer> dijkstra(List<List<Edge>> graph, int src, int target) {
        int n = graph.size();
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, src});

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (visited[u]) continue;
            visited[u] = true;
            if (u == target) break;

            for (Edge e : graph.get(u)) {
                int v = e.to;
                int nd = d + e.weight;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    parent[v] = u;
                    pq.add(new int[]{nd, v});
                }
            }
        }

        if (dist[target] == Integer.MAX_VALUE) return Collections.emptyList();

        LinkedList<Integer> path = new LinkedList<>();
        int cur = target;
        while (cur != -1) {
            path.addFirst(cur);
            cur = parent[cur];
        }
        return path;
    }

    // Demo: leitura do grafo com pesos
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de vértices: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        System.out.println("Digite arestas no formato u v w (uma por linha). Linha vazia para terminar:");
        while (true) {
            String l = sc.nextLine().trim();
            if (l.isEmpty()) break;
            String[] p = l.split("\\s+");
            int u = Integer.parseInt(p[0]), v = Integer.parseInt(p[1]), w = Integer.parseInt(p[2]);
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w)); // se grafo for não-direcionado
        }

        System.out.print("Origem: ");
        int s = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Destino: ");
        int t = Integer.parseInt(sc.nextLine().trim());

        List<Integer> path = dijkstra(graph, s, t);
        if (path.isEmpty()) System.out.println("Nenhum caminho encontrado.");
        else System.out.println("Caminho mais curto: " + path);
        sc.close();
    }
}
