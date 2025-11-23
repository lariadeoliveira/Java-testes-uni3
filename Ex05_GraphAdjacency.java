import java.util.ArrayList;
import java.util.List;

public class Ex05_GraphAdjacency {
    private final int vertices;
    private final List<List<Integer>> adj;

    public Ex05_GraphAdjacency(int v) {
        this.vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v, boolean undirected) {
        adj.get(u).add(v);
        if (undirected) adj.get(v).add(u);
    }

    public List<Integer> neighbors(int u) {
        return adj.get(u);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            System.out.println(adj.get(i));
        }
    }

    // Demo
    public static void main(String[] args) {
        // exemplo simples de grafo não-direcionado com 5 vértices
        Ex05_GraphAdjacency g = new Ex05_GraphAdjacency(5);
        g.addEdge(0, 1, true);
        g.addEdge(0, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(2, 4, true);
        System.out.println("Grafo de exemplo:");
        g.printGraph();
    }
}
