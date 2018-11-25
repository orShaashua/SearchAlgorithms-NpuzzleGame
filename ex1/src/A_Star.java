import java.util.PriorityQueue;

public class A_Star implements SearcherAlgorithm {
  private String m_solution;
  private int m_numberOfNodesEvaluated=0;
  private int timestamp;

  public Solution search(ISearchable searchable) {
    int depth = 0;
    PriorityQueue<State> pQueue = new PriorityQueue<State>(new ManhattanDistance());
    pQueue.add(searchable.getInitialState());
    searchable.getInitialState().setDepth(depth);
    while (!pQueue.isEmpty()) {
      State state = pQueue.poll();
      m_numberOfNodesEvaluated++;
      if (searchable.checkIfGoalState(state)) {
        m_solution = state.findSolution();
        return new Solution(m_solution, m_numberOfNodesEvaluated, m_solution.length());
      }
      depth = state.getDepth() + 1;
      for (State s : searchable.getAllPossibleState(state)) {
        s.setDepth(depth);
        s.setTimestamp(timestamp);
        timestamp++;
        pQueue.add(s);
      }
    }
    return new Solution(m_solution, m_numberOfNodesEvaluated, m_solution.length());
  }
}
