package Graph;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadder {

  static class Pair {
    int source;
    int destination;

    Pair(int s, int d) {
      this.source = s;
      this.destination = d;
    }
  }

  public static void main(String[] args) {
    int N = 36;
    int[] board = new int[N + 1];

    List<Pair> ladders = new ArrayList<>();
    ladders.add(new Pair(2, 15));
    ladders.add(new Pair(5, 7));
    ladders.add(new Pair(9, 27));
    ladders.add(new Pair(18, 29));
    ladders.add(new Pair(18, 29));
    ladders.add(new Pair(25, 35));

    List<Pair> snakes = new ArrayList<>();
    snakes.add(new Pair(34, 12));
    snakes.add(new Pair(32, 30));
    snakes.add(new Pair(24, 16));
    snakes.add(new Pair(20, 6));
    snakes.add(new Pair(17, 4));

    for (Pair snake : snakes) {
      int s = snake.source;
      int d = snake.destination;
      board[s] = d - s;
    }

    for (Pair ladder : ladders) {
      int s = ladder.source;
      int d = ladder.destination;
      board[s] = d - s;
    }

    Graph graph = new Graph(board.length);
    for (int u = 1; u < N; u++) {
      for (int dice = 1; dice <= 6; dice++) {
        int v = u + dice;
        if (v > N) break;
        v += board[v];
        if (v <= N) graph.addEdge(u, v, true);
      }
    }

    int[] x = graph.shortest(graph, 1);
    System.out.println(x[36]);
  }
}
