package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
  private List<String> operators = new ArrayList<String>();
  private List<Double> numbers = new ArrayList<Double>();
  private Double total = 0.0;

  public Double calculate(String expression) {
    checkExpression(expression);
    checkOperatorOnSequence(expression);
    separateOperations(expression);

    this.total = 0.0;
    for(int index = 0; index < numbers.size(); index++) {
      if(index == 0) {
        total = executeOperation(numbers.get(index), operators.get(index), numbers.get(index+1));
      } else 
      if(index > 1) {
        total = executeOperation(total, operators.get(index - 1), numbers.get(index));
      }
    }

    return total;
  }

  public Double getTotal() {
    return this.total;
  }

  private Double executeOperation (double a, String operator, double b) {
    switch(operator) {
      case "-":
        return a - b;
      case "+":
        return a + b;
      case "*":
        return a * b;
      case "/":
        return a / b;
      default:
        throw new Error("Operator not supported");
    }
  }

  private void separateOperations(String expression) {
    List <String> operators = new ArrayList<String>();
    List <Double> numbers = new ArrayList<Double>();
    char[] e = expression.toCharArray();
    String num = "";
    for(char c: e) {
      if(!isOperator(c)) {
        num += c;
      } else {
        operators.add(c + "");
        numbers.add(Double.parseDouble(num));
        num = "";
      }
    }
    if(!num.isBlank()) numbers.add(Double.parseDouble(num));

    this.operators = operators;
    this.numbers = numbers;
  }

  private void checkOperatorOnSequence(String expression) {
    for(int i = 0; i < expression.length() - 1; i++) {
      if(
        isOperator(expression.charAt(i)) && 
        isOperator(expression.charAt(i+1))
        ) 
      {
        throw new Error("Expression cannot have two operators in sequence");
      }
    }
  }

  private static void checkExpression(String expression) {
    if (expression == null) {
      throw new Error("String cannot be empty");
    }
    try {
        Double.parseDouble(expression.charAt(0) + "");
        Double.parseDouble(expression.charAt(expression.length() - 1) + "");
    } catch (NumberFormatException nfe) {
        throw new Error("First and last character must be a number");
    }
  }

  public boolean isOperator(char c) {
    if( c == '-' ||
        c == '+' ||
        c == '/' ||
        c == '*'
    ) return true;
    return false;
  }

}