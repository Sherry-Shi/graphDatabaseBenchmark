package blueprintneo4j;

import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;


import com.tinkerpop.blueprints.impls.neo4j2.Neo4j2Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLReader;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Direction;




public class Test {
	public static void main(String[] args) {

		Graph g = new Neo4j2Graph("C:/tmp/neo4j");
		//File f = new File("C:/Users/william/Desktop/termproject/graphML.xml");
		try{
		//final FileInputStream in = new FileInputStream(f);
		//Scanner s = new Scanner(in);
		//while(s.hasNext()){
			//System.out.print(s.next());
		//}
		GraphMLReader reader = new GraphMLReader(g);
		reader.inputGraph("C:/Users/william/Desktop/termproject/facebook.graphml");
		//g.loadGraphML("C:/Users/william/Desktop/term project/graph-example-1.xml");
		System.out.println(g.getVertex(4).getProperty("name"));
		Vertex ga = g.addVertex(null);
		Vertex gb = g.addVertex(null);
		ga.setProperty("name","marko");
		gb.setProperty("name","peter");
		Edge ge = g.addEdge(null, ga, gb, "knows");
		ge.setProperty("since", 2006);
		System.out.println("haha" + ge.getId());
		g.shutdown();
		testIteratingGraph();

		
		Graph graph = new TinkerGraph();
		
		Vertex a = graph.addVertex(null);
		Vertex b = graph.addVertex(null);
		a.setProperty("name", "marko");
		b.setProperty("name", "peter");
		Edge e = graph.addEdge(null, a, b, "knows");
		System.out.println(e.getVertex(Direction.OUT).getProperty("name") + "--" + e.getLabel() + "-->" + e.getVertex(Direction.IN).getProperty("name"));
		}catch(IOException e){
			System.out.println("read error");
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
}