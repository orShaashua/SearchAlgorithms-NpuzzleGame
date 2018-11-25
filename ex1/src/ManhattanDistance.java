
import java.util.Comparator;

public class ManhattanDistance implements Comparator<State>{ 
  
  // Overriding compare()method of Comparator  
  public int compare(State s1, State s2) { 
    int s1_cost = calculateManhattanDistance(s1)+ s1.getDepth();
    int s2_cost = calculateManhattanDistance(s2) + s2.getDepth();
    //if the cost of s1 smaller then s2 then s1 have higher priority
    if (s1_cost < s2_cost){
        return -1;
    }
    //if the cost of s2 smaller then s1 then s2 have higher priority
    else if (s1_cost > s2_cost){
        return 1;
    }
    //if the cost of s1 and s2 is the same 
    //give higher priority to the state with the lowest time stamp   
    else{
      if(s1.getTimestamp() < s2.getTimestamp()){
        return -1;
      }else{
        return 1;
      }
    }
  }
  
  private int calculateManhattanDistance(State state) {
    int manhattanDistanceSum = 0;
    int[][] puzzleBoard= state.getStateBoard(); 
    int N = puzzleBoard.length;
    for (int x = 0; x < N; x++) // x-dimension, traversing rows (i)
        for (int y = 0; y < N; y++) { // y-dimension, traversing cols (j)
            int value = puzzleBoard[x][y]; // tiles array contains board elements
            if (value != 0) { // we don't compute MD for element 0
                int targetX = (value - 1) / N; // expected x-coordinate (row)
                int targetY = (value - 1) % N; // expected y-coordinate (col)
                int dx = x - targetX; // x-distance to expected coordinate
                int dy = y - targetY; // y-distance to expected coordinate
                manhattanDistanceSum += Math.abs(dx) + Math.abs(dy); 
            } 
        }
    return manhattanDistanceSum;
}
}
