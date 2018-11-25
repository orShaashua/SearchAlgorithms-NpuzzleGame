
public class IDS implements SearcherAlgorithm{
  private String m_solution;
  private int m_numberOfNodesEvaluated;
  private int m_depthOrCost = 0;
  public Solution search(ISearchable searchable){
    Solution solution;
    do {
      m_numberOfNodesEvaluated = 1;
      solution = this.DFS(searchable.getInitialState(),searchable,m_depthOrCost);
      m_depthOrCost++;
    }while(!solution.haveSolution());
    return solution;
  }
  
  private Solution DFS(State state,ISearchable searchable,int depth){
    if(searchable.checkIfGoalState(state)){
      m_solution = state.findSolution();
      return new Solution(m_solution,m_numberOfNodesEvaluated,m_solution.length());
    }
    if(depth == 0){return new Solution(false);}
    for(State s: searchable.getAllPossibleState(state)){
      m_numberOfNodesEvaluated++;
      Solution solution = DFS(s,searchable,depth-1);
      if (solution.haveSolution()){
        return solution;
      }
    }
    return new Solution(false);
  }
}
