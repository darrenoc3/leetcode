package NearestClone;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Triple {
	private {
		String sub;
		String pred;
		String obj;
	}
	public Triple(String sub, String pred, String obj) {
		this.sub = sub;
		this.pred = pred;
		this.obj = obj;
	}
	@Override
	public String toString() {
		return sub+";"+pred+";"+obj;
	}
}
class TripleStore {
	private {
		HashMap<String, Triple> spo = new HashMap<String, Triple>();
		HashMap<String, Triple> pos = new HashMap<String, Triple>();
		HashMap<String, Triple> osp = new HashMap<String, Triple>();
	}
}

public class NearestClone {
	// Complete the findShortest function below.

    /*
     * For the unweighted graph, x:
     *
     * 1. The number of nodes is xNodes.
     * 2. The number of edges is x>Edges.
     * 3. An edge exists between xFrom[i] to xTo[i].
     *
     */
    static int findShortest(int graphNodes, int graphEdges, int[] graphFrom, int[] graphTo, long[] ids, int val) {
    	List<Triple> triples = new LinkedList<Triple>();
    	for(int e = 0; e < graphEdges; e++) {
    		Triple t = new Triple(graphFrom[e], "", graphTo[e]);
    		triples.add(t);
    	}
    	return 0;
    }

    public static void main(String[] args) throws IOException {
    	File file = new File("C:\\Users\\darre_000\\eclipse-workspace\\HackerRank\\unsolved\\NearestClone\\input0.txt");
    	Scanner scanner = new Scanner(file);
        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];



        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphEdges, graphFrom, graphTo, ids, val);
        System.out.println(ans);

        scanner.close();
    }
}