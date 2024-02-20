package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private HashMap<String, List<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    // if graph edges are bidirectional
    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) == null) return false;
        for (String v: adjList.get(vertex)) {
            adjList.get(v).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }




}
