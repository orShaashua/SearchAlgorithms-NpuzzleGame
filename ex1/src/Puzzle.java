
import java.util.ArrayList;
import java.util.List;

public class Puzzle implements ISearchable{
  private State m_initState;
  private int m_size; 
  
  public Puzzle(int size, String startState){
    m_size=size;
    getCurrentState(startState);
    
  }
  
  public State getInitialState(){
    return m_initState;
  }
  
  public List<State> getAllPossibleState(State state){
    List<State> possibaleState = new ArrayList<>();
    int rowAndColIndex[] = findZeroInBoard(state.getStateBoard());
    int row = rowAndColIndex[0];
    int col = rowAndColIndex[1];
    //move up
    if (row < m_size-1){
      int temp [][] = copyBoard(state.getStateBoard());
      temp[row][col]= temp[row+1][col];
      temp[row+1][col] = 0;
      possibaleState.add(new State(temp,state,"U"));
    }
    //move down
    if(row > 0){
      int temp [][] = copyBoard(state.getStateBoard());
      temp[row][col]= temp[row-1][col];
      temp[row-1][col] = 0;
      possibaleState.add(new State(temp,state,"D"));
    }
    //move left
    if(col < m_size-1){
      int temp [][] = copyBoard(state.getStateBoard());
      temp[row][col]= temp[row][col+1];
      temp[row][col+1] = 0;
      possibaleState.add(new State(temp,state,"L"));
    }
    //move right
    if(col > 0){
      int temp [][] = copyBoard(state.getStateBoard());
      temp[row][col]= temp[row][col-1];
      temp[row][col-1] = 0;
      possibaleState.add(new State(temp,state,"R"));
    }
    return possibaleState;
  }
  public int[] findZeroInBoard(int[][] board){
    int rowAndColIndex[]= new int [2];
    for(int i=0;i<m_size;i++){
      for (int j=0; j<m_size;j++){
        if (board[i][j]==0){
          rowAndColIndex[0]=i;
          rowAndColIndex[1]=j;
          return rowAndColIndex;
        }
      }
    }
    return rowAndColIndex;
  }
  
/*
 * get current state from string
 */
  private void getCurrentState(String state){
    int matrix[][] = new int[m_size][m_size];
    String parts[] = state.split("-");
    int index =0;
    for(int i=0;i<m_size;i++){
      for (int j=0; j<m_size;j++){
        matrix[i][j]=Integer.parseInt(parts[index]);
        index++;
      }
    }
    m_initState = new State(matrix,null, "");
  }
  
  public boolean checkIfGoalState(State state){  
    int counter = 1;
    for(int i=0;i<m_size;i++){
      for (int j=0; j<m_size;j++){
        if (i==m_size-1&&j==m_size-1){
          if (state.getStateBoard()[i][j]!=0 ){return false;}
        }
        else if(state.getStateBoard()[i][j] != counter){
          return false;
        };
        counter++;
      }
    }
    return true;
  }
  
  private int[][] copyBoard(int[][] srcBoard){
    int copyBoard[][] = new int [m_size][m_size];
    for(int i=0;i<m_size;i++){
      for (int j=0; j<m_size;j++){
        copyBoard[i][j] =srcBoard[i][j];
      }
    }
    return copyBoard;
  }
  
}
