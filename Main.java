import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        String filename = "data.txt";
        Map<String, Vertex> graph = getGraph(readData(filename)); // complete the getGraph method below

        Vertex start = graph.get("A"); // assign your start vertex
        Vertex end =   graph.get("G"); // assign your end vertex

        // call computePath in DikstrasAlgorithm class and pass it the starting Vertex.
        DijkstrasAlgorithm da = new DijkstrasAlgorithm();

        da.computePath(start);

        // call getPath in DikstrasAlgorithm class
        List<Vertex> path = da.getPath(end);
            
        System.out.printf("\nPath from %s to %s = %s\n", start, end, path);
        System.out.printf("Distance from %s to %s = %d\n\n", start, end, end.getDistance());
    }

    /*
     * The getGraph method should return a Map where the Key is the Vertex name
     * and the value is the Vertex. You will need to create all the vertices then
     * add the edges to each Vertex.
     */
    public static Map<String, Vertex> getGraph(List<String> data) {
        Map<String, Vertex> graph = new HashMap<>();

        for (String current : data.get(0).split(" ")) {
            graph.put(current, new Vertex(current));
        }

        for (int i = 1; i < data.size(); i++) {
            String[] arr = data.get(i).split(" ");
            
            graph.get(arr[0]).addEdge(new Edge(graph.get(arr[0]), graph.get(arr[1]), Integer.parseInt(arr[2])));
        }

        return graph;
    }

    public static List<String> readData(String filename) {
        List<String> list = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                list.add(input.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Find not found");
        }
        return list;
    }

}
