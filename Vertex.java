import java.util.*;

/**
 * Complete the Vertex class by implementing Comparable.
 */
public class Vertex implements Comparable<Vertex> {

    private String name;
    private List<Edge> edgeList;
    private int distance;    // distance from the starting vertex (source)
    private Vertex previous; // the previous vertex on the shortest path

    public Vertex(String name) {
        this.name = name;
        this.edgeList = new ArrayList<>();
        this.distance = Integer.MAX_VALUE;
    }

    // Complete the compareTo method that is needed for the PriorityQueue.
    public int compareTo(Vertex other) {
        return distance - other.getDistance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void addEdge(Edge edge) {
        this.edgeList.add(edge);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return name;
    }
}
