
public class State {
  private int[][] m_state;
  private String m_comeFrom;
  private State m_comeFromState;
  private int m_depth;
  private int m_timestamp;
  
  public State(int[][] state,State comeFromState,String comeFrom){
    m_state = state;
    m_comeFrom = comeFrom;
    m_comeFromState = comeFromState;
  }
  public int[][] getStateBoard(){  
    return m_state;
  }
  public void setDepth(int depth){
    m_depth = depth;
  }
  public int getDepth(){
    return m_depth;
  }
  public void setTimestamp(int timestamp){
    m_timestamp = timestamp;
  }
  public int getTimestamp(){
    return m_timestamp;
  }
  public String findSolution(){
    String reversePath = this.getMove();
    State stateBefore = this.comeFromState();
    if (stateBefore!=null){
      while (stateBefore.getMove()!=""){
        reversePath +=stateBefore.getMove();
        stateBefore = stateBefore.comeFromState();
      }
    }
    StringBuilder solution = new StringBuilder(); 
    
    // append a string into StringBuilder solution 
    solution.append(reversePath); 

    // reverse StringBuilder solution 
    solution = solution.reverse(); 

    return solution.toString();    
  }
  
  public String getMove(){
    return m_comeFrom;
  }
  public State comeFromState(){
    return m_comeFromState;
  }
  public void printState(){
    int size = m_state.length;
    for (int i=0;i<size;i++){
      for (int j=0;j<size;j++){
        System.out.print(m_state[i][j]);
      }
    }
    System.out.println();
  }
}
