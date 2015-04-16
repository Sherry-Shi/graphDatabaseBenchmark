package blueprintneo4j;

import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;






import com.tinkerpop.blueprints.impls.neo4j2.Neo4j2Graph;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLReader;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLWriter;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.KeyIndexableGraph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Direction;

public class main {
	public static int[] id;
	public static void main(String[] args) {
		try
		{
			//KeyIndexableGraph graph = new Neo4j2Graph("C:/tmp/neo4j");
			//Graph g = new IdGraph(base);
			
			//Graph g = new Neo4j2Graph("C:/tmp/neo4j");
			OrientGraph g = new OrientGraph("plocal:C:/tmp/orient");
			GraphMLReader reader = new GraphMLReader(g);
			
			long startTime = System.nanoTime();
			//System.out.println("Load begin...\n" + date.getTime() + "\n");
			reader.inputGraph("D:/USC/14Spring/585/Term Paper/GraphML.xml");
			//System.out.println("Load end...\n" + date.getTime() + "\n");
			long endTime = System.nanoTime();
			System.out.format("Load time: %d\n", endTime - startTime);
			
			//Vertex vv = g.getVertex(77);
			//System.out.println(g.getVertex(1).getProperty("size"));
			//g.shutdown();
			
			id = new int[101];
			int nodeNum = 1034;
			for(int i=0;i<101;i++)
			{
				int tmp=0;
				while(check(tmp, i))
				{
					tmp = (int)(Math.random()*nodeNum);
				}
				id[i] = tmp;
				System.out.println(id[i]);
			}

			Vertex v;
			
			// Get Vertex by ID
			System.out.println("\n\nGet Vertex by ID, begin...\n");
			for(int i=0;i<101;i++)
			{
				startTime = System.nanoTime();
				v = g.getVertex(id[i]);
				endTime = System.nanoTime();
				System.out.format("%d\n", endTime - startTime);
				if(v==null)
					System.out.println("null\n");
			}
			System.out.println("\nGet Vertex by ID, end...\n");
			
			
			// Get Vertex by ID second time
			System.out.println("\n\nGet Vertex by ID-2, begin...\n");
			for(int i=0;i<101;i++)
			{
				startTime = System.nanoTime();
				v = g.getVertex(id[i]);
				endTime = System.nanoTime();
				System.out.format("%d\n", endTime - startTime);
			}
			System.out.println("\nGet Vertex by ID-2, end...\n");

			

			/*
			for (Vertex vertex : g.getVertices()) {
				vertex.setProperty("size", (int)(Math.random()*11));
				vertex.setProperty("r", (int)(Math.random()*256));
				vertex.setProperty("g", (int)(Math.random()*256));
				vertex.setProperty("b", (int)(Math.random()*256));
			}
			for (Edge edge : g.getEdges()) {
				edge.setProperty("weight", (int)(Math.random()*11));
			}
			GraphMLWriter writer = new GraphMLWriter(g);
			writer.setNormalize(true);
			writer.outputGraph(g, "D:/USC/14Spring/585/Term Paper/facebook2.graphml");
			*/
			
			//
			// Get Vertex by Property
			Iterable<Vertex> vertices;
			System.out.println("\n\nGet Vertex by Property, begin...\n");
			for(int i=0;i<5;i++)
			{
				startTime = System.nanoTime();
				vertices = g.getVertices("size", 2*i+1);
				endTime = System.nanoTime();
				System.out.format("%d\n", endTime - startTime);
			}
			System.out.println("\nGet Vertex by Property, end...\n");
			
			// Get Vertex by Property second time
			System.out.println("\n\nGet Vertex by Property-2, begin...\n");
			for(int i=0;i<5;i++)
			{
				startTime = System.nanoTime();
				vertices = g.getVertices("size", 2*i+1);
				endTime = System.nanoTime();
				System.out.format("%d\n", endTime - startTime);
			}
			System.out.println("\nGet Vertex by Property-2, end...\n");
			
			
			// Generate New Random IDs
			System.out.println("\nNew IDs: \n");
			for(int i=0;i<101;i++)
			{
				int tmp=0;
				while(check(tmp, i))
				{
					tmp = (int)(Math.random()*nodeNum);
				}
				id[i] = tmp;
				System.out.println(id[i]);
			}
			
			
			// Get Vertex by ID and Update Property
			System.out.println("\n\nGet Vertex by ID and Update Property, begin...\n");
			for(int i=0;i<101;i++)
			{
				startTime = System.nanoTime();
				v = g.getVertex(id[i]);
				v.setProperty("size", 20);
				endTime = System.nanoTime();
				System.out.format("%d\n", endTime - startTime);
			}
			System.out.println("\nGet Vertex by ID and Update Property, end...\n");
			
			// Get Vertex by ID and Update Property Second Time
			System.out.println("\n\nGet Vertex by ID and Update Property-2, begin...\n");
			for(int i=0;i<101;i++)
			{
				startTime = System.nanoTime();
				v = g.getVertex(id[i]);
				v.setProperty("size", 20);
				endTime = System.nanoTime();
				System.out.format("%d\n", endTime - startTime);
			}
			System.out.println("\nGet Vertex by ID and Update Property-2, end...\n");
			
			// vertex id changes after loaded to database
			// to do: get and update 2
			//        others
			
			
			// Generate New Random IDs
			System.out.println("\nNew IDs: \n");
			for(int i=0;i<101;i++)
			{
				int tmp=0;
				while(check(tmp, i))
				{
					tmp = (int)(Math.random()*nodeNum);
				}
				id[i] = tmp;
				System.out.println(id[i]);
			}
			
			Vertex v2;
			
			// Get Two Vertices and Add an Edge
			System.out.println("\n\nGet Two Vertices and Add an Edge, begin...\n");
			v = g.getVertex(id[0]);
			for(int i=1;i<=50;i++)
			{
				startTime = System.nanoTime();
				v = g.getVertex(id[i]);
				v2 = g.getVertex(id[101-i]);
				g.addEdge(null, v, v2, "new");
				endTime = System.nanoTime();
				System.out.format("%d\n", endTime - startTime);
			}
			System.out.println("\nGet Two Vertices and Add an Edge, end...\n");

			
			// Get Two Vertices and Add an Edge Second Time
			/*System.out.println("\n\nGet Two Vertices and Add an Edge-2, begin...\n");
			for(int i=0;i<50;i++)
			{
				startTime = System.nanoTime();
				v = g.getVertex(id[i]);
				v2 = g.getVertex(id[99-i]);
				g.addEdge(null, v, v2, "new");
				endTime = System.nanoTime();
				System.out.format("%d\n", endTime - startTime);
			}
			System.out.println("\nGet Two Vertices and Add an Edge-2, end...\n");*/
			
			// Generate New Random IDs
			System.out.println("\nNew IDs: \n");
			for(int i=0;i<101;i++)
			{
				int tmp=0;
				while(check(tmp, i))
				{
					tmp = (int)(Math.random()*nodeNum);
				}
				id[i] = tmp;
				System.out.println(id[i]);
			}
			
			// Update an Edge's Property of A Vertex
			System.out.println("\n\nUpdate an Edge's Property of A Vertex, begin...\n");
			for(int i=0;i<101;i++)
			{
				startTime = System.nanoTime();
				v = g.getVertex(id[i]);
				for (Edge edge : v.getEdges(Direction.BOTH, "_default")) {
					edge.setProperty("weight", 20);
					break;
				}
				endTime = System.nanoTime();
				System.out.format("%d\n", endTime - startTime);
			}
			System.out.println("\nUpdate an Edge's Property of A Vertex, end...\n");
			
			// Update an Edge's Property of A Vertex Second Time
			System.out.println("\n\nUpdate an Edge's Property of A Vertex-2, begin...\n");
			for(int i=0;i<101;i++)
			{
				startTime = System.nanoTime();
				v = g.getVertex(id[i]);
				for (Edge edge : v.getEdges(Direction.BOTH, "_default")) {
					edge.setProperty("weight", 20);
					break;
				}
				endTime = System.nanoTime();
				System.out.format("%d\n", endTime - startTime);
			}
			System.out.println("\nUpdate an Edge's Property of A Vertex-2, end...\n");
			
			
			// Generate New Random IDs
			System.out.println("\nNew IDs: \n");
			for(int i=0;i<101;i++)
			{
				int tmp=0;
				while(check(tmp, i))
				{
					tmp = (int)(Math.random()*nodeNum);
				}
				id[i] = tmp;
				System.out.println(id[i]);
			}
			
			// Delete an Edge of an Arbitrary Vertex
			System.out.println("\n\nDelete an Edge of an Arbitrary Vertex, begin...\n");
			for(int i=0;i<101;i++)
			{
				startTime = System.nanoTime();
				v = g.getVertex(id[i]);
				for (Edge edge : v.getEdges(Direction.BOTH, "_default")) {
					edge.remove();
					break;
				}
				endTime = System.nanoTime();
				System.out.format("%d\n", endTime - startTime);
			}
			System.out.println("\nDelete an Edge of an Arbitrary Vertex, end...\n");
			
			g.shutdown();
			
			//System.out.println(e.getVertex(Direction.OUT).getProperty("name") + "--" + e.getLabel() + "-->" + e.getVertex(Direction.IN).getProperty("name"));
		}
		catch(IOException e)
		{
			System.out.println("error");
		}
	}

	public static void testIteratingGraph() {
		Graph graph = TinkerGraphFactory.createTinkerGraph();
		System.out.println("Vertices of " + graph);
		for (Vertex vertex : graph.getVertices()) {
			System.out.println(vertex);
		}
		System.out.println("Edges of " + graph);
		for (Edge edge : graph.getEdges()) {
			System.out.println(edge);
		}
	}
	
	public static boolean check(int num, int size)
	{
		for(int i=0;i<size;i++)
		{
			if(num==id[i])
				return true;
		}
		return false;
	}
}