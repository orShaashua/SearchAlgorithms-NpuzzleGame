
import java.util.LinkedList;
import java.util.Queue;

public class BFS implements SearcherAlgorithm{
  private String m_solution= "";
  private int m_numberOfNodesEvaluated = 0;

  public Solution search(ISearchable searchable){
    
    Queue<State> queue = new LinkedList<>();
    queue.add(searchable.getInitialState());
    while(!queue.isEmpty()){
      State next = queue.poll();
      m_numberOfNodesEvaluated ++;
      if(searchable.checkIfGoalState(next)){
        m_solution = next.findSolution();
        return new Solution(m_solution,m_numberOfNodesEvaluated,0);
      }
      queue.addAll(searchable.getAllPossibleState(next));
    }
    return new Solution(m_solution,m_numberOfNodesEvaluated,0);
  }
}
