import java.util.ArrayList;
import java.util.List;

public class Calculator {
  private List<Double> numbers = new ArrayList<Double>();
  private List<Character> operators = new ArrayList<Character>();

  public float calc(String expression) {
    this.numbers = getNumbers(expression);
    this.operators = getOperators(expression);

  }

  private List<Double> getNumbers(String expression) {

  }

  private List<Character> getOperators(String expression) {
    
  }

}