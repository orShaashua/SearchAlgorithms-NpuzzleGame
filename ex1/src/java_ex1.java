
public class java_ex1 {
  public static void main( String[] args){
    FileConnector f = new FileConnector();
    Solution solution = f.getAlgorithmType().search(f.getPuzzleBoard());
    f.writeSolutionToOutputFile(solution);
  }
}
