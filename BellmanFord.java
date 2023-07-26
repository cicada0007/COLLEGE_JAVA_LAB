import java.util.*;

public class BellmanFord {

    public static void main(String[] args) {
        // Create a graph with three vertices and two edges.
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex("A"));
        vertices.add(new Vertex("B"));
        vertices.add(new Vertex("C"));

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(vertices.get(0), vertices.get(1), 5));
        edges.add(new Edge(vertices.get(1), vertices.get(2), 2));

        // Initialize the distance from the source vertex to all other vertices to infinity.
        Map<Vertex, Integer> distances = new HashMap<>();
        for (Vertex vertex : vertices) {
            distances.put(vertex, Integer.MAX_VALUE);
        }

        // Set the distance from the source vertex to itself to 0.
        distances.put(vertices.get(0), 0);

        // Iterate over all edges in the graph.
        for (int i = 0; i < vertices.size(); i++) {
            for (Edge edge : edges) {
                // If the distance to the destination vertex is greater than the distance to the source vertex plus the weight of the edge, update the distance to the destination vertex.
                if (distances.get(edge.getDestination()) > distances.get(edge.getSource()) + edge.getWeight()) {
                    distances.put(edge.getDestination(), distances.get(edge.getSource()) + edge.getWeight());
                }
            }
        }

        // Print the shortest path from the source vertex to all other vertices.
        for (Vertex vertex : vertices) {
            System.out.println("The shortest path from " + vertices.get(0) + " to " + vertex + " is " + distances.get(vertex));
        }
    }

}
