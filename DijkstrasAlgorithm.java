import java.util.*;

public class DijkstrasAlgorithm {

    /**
     * Given the start vertex find the minimum distance to each vertex. 
     * The method should set the distance and previous fields for each
     * vertex visited. Your algorithm will be very similar to the one 
     * used in the previous assignment except you will loop through a 
     * PriorityQueue instead of a topological ordered queue of vertices.
     *
     * Start by implementing a PriorityQueue. Then set the starting 
     * vertex's distance to 0 and add it to the PriorityQueue.
     *
     * When you change a target vertex's distance you also update its
     * previous field and add it to the PriorityQueue.
     */
    public static void computePath(Vertex start) {
        PriorityQueue<Vertex> queue = new PriorityQueue();

        start.setDistance(0);
        queue.add(start);

        while(!queue.isEmpty()) {
            Vertex current = queue.poll();

            for (Edge edge : current.getEdgeList()) {
                Vertex target = edge.getTargetVertex();
                int distance = current.getDistance() + edge.getWeight();

                if (target.getDistance() > distance) {
                    target.setDistance(distance);
                    target.setPrevious(current);
                    queue.add(target);
                }
            }
        }



    }

    /**
     * Given a vertex, return a List of vertices that make up the shortest
     * path by getting each vertex's previous vertex. Make sure the list
     * returned is ordered from the starting vertex to the given vertex.
     */
    public static List<Vertex> getPath(Vertex current) {
        List<Vertex> list = new ArrayList<>();
        
        while (current != null) {
            list.add(current);

            current = current.getPrevious();
        }

        Collections.reverse(list);

        return list;
    }
}
