package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
  private List<String> operations = new ArrayList<String>();

  public Double calculate(String expression) {
    checkFirstValue(expression);
    checkLastValue(expression);
    this.operations = separateOperations(expression);
    checkOperatorOnSequence();
    multiplyAndDivide();
    AddAndSubtract();
    return Double.parseDouble(this.operations.get(0));
  }

  private void multiplyAndDivide() {
    for(int i = 0; i < this.operations.size(); i++) {
      if(this.operations.get(i).compareTo("*") == 0||this.operations.get(i).compareTo("/") == 0) {
        Double a = Double.parseDouble(this.operations.get(i-1));
        char operator = this.operations.get(i).charAt(0);
        Double b = Double.parseDouble(this.operations.get(i+1));
        Double total = executeOperation(a, operator, b);

        this.operations.set(i-1, total.toString());
        this.operations.remove(i);
        this.operations.remove(i);
        i -= 2;
      }
    }
  }

  private void AddAndSubtract() {
    for(int i = 0; i < this.operations.size(); i++) {
      if(this.operations.get(i).compareTo("-") == 0||this.operations.get(i).compareTo("+") == 0) {
        Double a = Double.parseDouble(this.operations.get(i-1));
        char operator = this.operations.get(i).charAt(0);
        Double b = Double.parseDouble(this.operations.get(i+1));
        Double total = executeOperation(a, operator, b);

        this.operations.set(i-1, total.toString());
        this.operations.remove(i);
        this.operations.remove(i);
        i -= 2;
      }
    }
  }

  private Double executeOperation (double a, char operator, double b) {
    switch(operator) {
      case '-':
        return a - b;
      case '+':
        return a + b;
      case '*':
        return a * b;
      case '/':
        return a / b;
      default:
        throw new Error("Operator not supported");
    }
  }

  private List<String> separateOperations(String expression) {
    List<String> calculate = new ArrayList<String>();
    String number = "";
    for(int i = 0; i < expression.length(); i++) {
      if(isOperator(expression.charAt(i))) {
        if(number.length() > 0) calculate.add(number);
        calculate.add(expression.charAt(i) + "");
        number = "";
      } else {
        number = number.concat(expression.charAt(i) + "");
        if(i == expression.length() - 1) calculate.add(number);
      }
    }
    return calculate;
  }

  private void checkOperatorOnSequence() {
    for(int i = 0; i < this.operations.size() - 1; i++) {
      if(
        isOperator(this.operations.get(i).charAt(0)) && 
        isOperator(this.operations.get(i+1).charAt(0))
        ) 
      {
        throw new Error("Expression cannot have two operators in sequence");
      }
    }
  }

  private static void checkFirstValue(String expression) {
    if (expression == null) {
      throw new Error("String cannot be empty");
    }
    try {
        Double.parseDouble(expression.charAt(0) + "");
    } catch (NumberFormatException nfe) {
        throw new Error("First character must be a number");
    }
  }

  private static void checkLastValue(String expression) {
    if (expression == null) {
      throw new Error("String cannot be empty");
    }
    try {
        Double.parseDouble(expression.charAt(expression.length() - 1) + "");
    } catch (NumberFormatException nfe) {
        throw new Error("Last character must be a number");
    }
  }

  private boolean isOperator(char c) {
    if( c == '-' ||
        c == '+' ||
        c == '/' ||
        c == '*'
    ) return true;
    return false;
  }

}