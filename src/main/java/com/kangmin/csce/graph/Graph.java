package main.java.com.kangmin.csce.graph;

import java.util.ArrayList;

/**
 * Graph Program
 * Here the directed Graph (can be weighted) class was implemented
 * Those public methods were created:
 *  addVertex(String);
 *  addEdge(String,String,double);
 *  removeEdge(String,String);
 *  printDFS();
 *  printBFS().
 */

//G = G(Vertex, Edge)

public class Graph {

    // internal class for Vertex
    private class Vertex {

        String name;
        ArrayList<Edge> neighbours;    // for storing adjacent vertices

        Vertex(String nameLabel) {
            this.name = nameLabel;
            this.neighbours = new ArrayList<>();
        }
    }

    // internal class for Edge
    private class Edge {

        Vertex toVert;
        double weight;

        // constructor of Edge, with parameter toVert and weight
        Edge(Vertex aVert, double aWeight) {
            // for un-weighted edge, just set to "1"
            this.toVert = aVert;
            this.weight = aWeight;
        }
    }

    // default constructor for Graph
    public Graph() {
        origin = null;
        Vertices = new ArrayList<>();
        AllEdges = new ArrayList<>();
    }

    //instance variables for Graph
    private Vertex origin;                      // original Vertex or starting point
    private final ArrayList<Vertex> Vertices;   // for Storing all Vertices
    private final ArrayList<Edge> AllEdges;     // my purpose for storing all edges in the graph

    public void printAllEdges() {
        // my purpose for showing all edges in the graph
        for (Edge currEg : AllEdges) {
            System.out.println("Edge: " + currEg.toVert.name);
        }

    }

    // method void add a vertex
    public void addVertex(String aName) {
        // check if this aName is already in the Vertices or not
        for (Vertex vert : Vertices) {
            if (vert.name.equals(aName)) {
                return; // found, already there
            }
        }

        Vertex v = new Vertex(aName);

        if (origin == null) {
            origin = v;
        }

        Vertices.add(v);
    }


    // method void addEdge
    public void addEdge(String fromVert, String toVert, double weight) {
        Vertex v1 = getVertex(fromVert);
        Vertex v2 = getVertex(toVert);
        if (v1 == null || v2 == null) {
            return; //can't ad an edge to nothing
        }

        v1.neighbours.add(new Edge(v2, weight));
        Edge temp = new Edge(v2, weight);
        AllEdges.add(temp);
    }

    // getVertex that already in the Vertices set
    private Vertex getVertex(String aName) {
        // check if it is there
        for (Vertex vert : Vertices) {
            if (vert.name.equals(aName)) {
                return vert;
            }
        }
        return null;    //not find this Vertex
    }

    // method void remove an existing Edge by name
    public void removeEdge(String fromName, String toName) {
        Vertex v1 = getVertex(fromName);
        Vertex v2 = getVertex(toName);
        this.removeEdge(v1, v2);
    }

    // method void remove an existing Edge by Vertex
    private void removeEdge(Vertex v1, Vertex v2) {
        if (v1 == null || v2 == null) {
            return;    // can't remove an non-existing edge to nothing
        }

        Edge theEdge = getEdge(v1, v2); // already exist the two Vertex
        if (theEdge != null) {
            v1.neighbours.remove(theEdge);
            AllEdges.remove(theEdge);
        }
    }

    public void removeDoubleEdge(String fromName, String toName) {
        Vertex v1 = getVertex(fromName);
        Vertex v2 = getVertex(toName);
        this.removeDoubleEdge(v1, v2);
    }

    private void removeDoubleEdge(Vertex v1, Vertex v2) {
        if (v1 == null || v2 == null)
            return;    //can't remove an non-existing edge to nothing
        Edge theEdge = getEdge(v1, v2);    //already exist the two Vertex
        Edge reverseEdge = getEdge(v2, v1);
        if (theEdge != null && reverseEdge != null) {
            v1.neighbours.remove(theEdge);
            v2.neighbours.remove(reverseEdge);
            AllEdges.remove(theEdge);
            AllEdges.remove(reverseEdge);
        }
    }

    private Edge getEdge(Vertex v1, Vertex v2) {
        if (v1 == null) return null;
        for (Edge eg : v1.neighbours) {
            if (eg.toVert.name.equals(v2.name)) //there is a match
                return eg;
        }
        return null;
    }

    // for storing the marked groups for DFS and BFS print
    private ArrayList<Vertex> markedVerts;

    public void printDFS() {
        if (markedVerts == null)
            markedVerts = new ArrayList<Vertex>();
        else
            markedVerts.clear();

        if (origin == null) return;
        printDFS(origin);
    }

    private void printDFS(Vertex vert) {
        if (markedVerts.contains(vert))
            return;    // already marked this vertex

        // else, not contains
        System.out.println(vert.name);
        markedVerts.add(vert);

        for (Edge edge : vert.neighbours)
            printDFS(edge.toVert);
    }


    private ArrayList<Edge> markedEdges;

    public void printDFSedges() {
        if (markedEdges == null)
            markedEdges = new ArrayList<Edge>();
        else
            markedEdges.clear();


        if (origin == null) return;

        for (Edge eg : origin.neighbours) {
            printDFSedges(eg);
        }
    }

    private void printDFSedges(Edge eg) {
        if (markedEdges.contains(eg))
            return;    //already marked this vertex

        //else, not contains
        System.out.println(eg.toVert.name);
        markedEdges.add(eg);

        for (Edge e : eg.toVert.neighbours)
            printDFSedges(e);
    }


    //for visited makers for BFS
    private ArrayList<Vertex> visitedVerts;

    public void printBFS() {
        if (markedVerts == null) {
            markedVerts = new ArrayList<Vertex>();
        } else
            markedVerts.clear();

        if (visitedVerts == null) {
            visitedVerts = new ArrayList<Vertex>();
        } else
            visitedVerts.clear();

        if (origin == null)
            return;
        System.out.println(origin.name);
        printBFS(origin);
    }

    private void printBFS(Vertex vert) {
        if (markedVerts.contains(vert))
            return;    //already marked this vertex
        else markedVerts.add(vert);

        for (Edge edge : vert.neighbours) {
            if (visitedVerts.contains(edge.toVert) ||
                    markedVerts.contains(edge.toVert)) {
                continue;
            }

            System.out.println(edge.toVert.name);
            visitedVerts.add(edge.toVert);
        }

        for (Edge edge : vert.neighbours) {
            printBFS(edge.toVert);
        }
    }


    // Lab-11 purpose
    // Print out all cyclic paths in the graphs
    public void printAllCycles() {
        for (Vertex currV : Vertices) {
            printCycles(currV);
        }
    }

    //for each vertex, print out the cyclic paths in the graphs ended with this vertex
    private void printCycles(Vertex vert) {
        if (markedVerts == null)
            markedVerts = new ArrayList<Vertex>();
        else
            markedVerts.clear();
        String aString = "";
        printCyclesDFS(vert, vert, aString);
    }

    private void printCyclesDFS(Vertex StartV, Vertex currVert, String aString) {
        aString += currVert.name + " ";
        if (markedVerts.contains(currVert)) {
            if (currVert.name.equals(StartV.name))
                System.out.println(aString);
            return;    //already marked this vertex
        }
//		System.out.println(currVert.name);
        markedVerts.add(currVert);

        for (Edge edge : currVert.neighbours)
            printCyclesDFS(StartV, edge.toVert, aString);

        markedVerts.remove(currVert);
    }





/*
	private ArrayList<Edge> visitedEdges;
	public void findEulerPath(String startName)
	{
		Vertex v1 = getVertex(startName);
		if( v1 == null)
			return;	//can't remove an non-existing edge to nothing

		if(visitedEdges == null)
				visitedEdges = new ArrayList<Edge>();
		else	visitedEdges.clear();

		findEulerPath(v1, null, v1);
	}


	public void findEulerPath(Vertex startV, Vertex prevV, Vertex currV)
	{
		Edge egPrev = getEdge(prevV, currV);
		if(egPrev != null)
			{
				prevV.neighbours.remove(egPrev);
				AllEdges.remove(egPrev);
			}


		System.out.println("Now:"+currV.name);
		System.out.println("Now:"+currV.neighbours.isEmpty());

		if(currV.neighbours.isEmpty()) //can not go further
		{
//			if (currV.name.equals(startV.name) && AllEdges.isEmpty())
			if (currV.name.equals(startV.name) && AllEdges.isEmpty())
			{
				System.out.println("Find path!");
				return;
			}
			else
			{
				System.out.println("Try other way around");
				return;
			}
		}

		//now there is some edge for this neighbour
		for(Edge edge: currV.neighbours)
		{
			if(!visitedEdges.contains(edge))
			{
				visitedEdges.add(edge);
				System.out.println("goto:"+edge.toVert.name);
				findEulerPath(startV, currV, edge.toVert);
			}
			else return;
//			currV.neighbours.add(edge);
//			AllEdges.add(edge);
		}

	}
*/
}
