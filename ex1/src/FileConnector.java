
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class FileConnector {
  
  private SearcherAlgorithm m_searchAlghoritm;
  private Puzzle m_board;
  
  public FileConnector(){
    File file = new File("input.txt"); 
    
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(file));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } 
    try {
      String arg1 = br.readLine();
      if (arg1.equals("1")){
        m_searchAlghoritm = new IDS();
      }else if (arg1.equals("2")){
        m_searchAlghoritm = new BFS();
      }else{
        m_searchAlghoritm = new A_Star();
      }
      String boardSize = br.readLine();
      String startState = br.readLine();
      m_board = new Puzzle(Integer.parseInt(boardSize),startState);
      
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }

  public SearcherAlgorithm getAlgorithmType(){
    return m_searchAlghoritm;
  }
  public Puzzle getPuzzleBoard(){
    return m_board;
  }
  public void writeSolutionToOutputFile(Solution solution){
    FileOutputStream fop = null;
    File file;
    String content = solution.getPath()+ " " + solution.getNumberOfNodesEvaluated()
    + " " +solution.getDepthOrCost();;

    try {

      file = new File("output.txt");
      fop = new FileOutputStream(file);

      // if file doesnt exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }

      // get the content in bytes
      byte[] contentInBytes = content.getBytes();

      fop.write(contentInBytes);
      fop.flush();
      fop.close();

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fop != null) {
          fop.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  
}
