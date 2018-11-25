
import java.util.List;

public interface ISearchable {
  public State getInitialState();
  public boolean checkIfGoalState(State state);
  public List<State> getAllPossibleState(State state);
}
