import org.example.Graphs.Graph;
import org.example.Graphs.WeightedGraph;
import org.example.Main;
import org.example.Search.BFS;
import org.example.Search.DFS;
import org.example.Search.Djikstra;
import org.example.Search.Search;
import org.example.Vertex;
import org.junit.Assert;
import org.junit.Test;

public class GraphTest {
    Graph<String> Graph = new Graph<>();

    @Test
    public void testBreadthFirstSearch() {
        Main.fillWithoutWeights(Graph);
        Search<String> bfs = new BFS<>(Graph, Main.Almaty);

        Vertex<String> target = Main.Kyzylorda;
        Assert.assertEquals("Almaty->Shymkent->Kyzylorda->", Main.showPathTo(bfs,target));
    }

    @Test
    public void testDepthFirstSearch() {
        Main.fillWithoutWeights(Graph);
        Search<String> dfs = new DFS<>(Graph, Main.Almaty);

        Vertex<String> target = Main.Kyzylorda;
        Assert.assertEquals("Almaty->Shymkent->Kyzylorda->", Main.showPathTo(dfs,target));
    }

    @Test
    public void testDjikstraSearch(){
        WeightedGraph<String> graph=new WeightedGraph<>();
        Main.fillWithWeights(graph);
        Search<String> djikstra=new Djikstra<>(graph, Main.Almaty);


        Vertex<String> target=Main.Kyzylorda;
        Assert.assertEquals("Almaty->Astana->Shymkent->Kyzylorda->", Main.showPathTo(djikstra,target));
    }
}
