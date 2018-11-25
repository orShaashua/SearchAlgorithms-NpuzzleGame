
public class Solution {
  private String m_path;
  private int m_numberOfNodesEvaluated;
  private int m_depthOrCost;
  private boolean m_haveSolution;
  public Solution(String path, int numberOfNodesEvaluated,int depthOrCost){
    m_path = path;
    m_numberOfNodesEvaluated = numberOfNodesEvaluated;
    m_depthOrCost = depthOrCost;
    m_haveSolution = true;
  }
  public Solution(boolean haveSolution){
    m_haveSolution = false;
  }
  public String getPath(){
    return m_path;
  }
  public int getNumberOfNodesEvaluated(){
    return m_numberOfNodesEvaluated;
  }
  public int getDepthOrCost(){
    return m_depthOrCost;
  }
  public boolean haveSolution(){
    return m_haveSolution;
  }

}
