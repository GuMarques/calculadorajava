package src.main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  public static void main(String[] args) throws IOException {
    System.out.println("Calculator");
    Calculator calculator = new Calculator();
    String userInput = "";
    double accumaletedValue = 0.0;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    boolean flag = true;
    while(flag) {
      System.out.println("ce to clean \t c to exit");
      System.out.print("Expression: ");
      userInput = reader.readLine();
      switch (userInput) {
        case "ce":
          accumaletedValue = 0.0;
          System.out.println(accumaletedValue);
          break;
        case "c":
          flag = false;
          break;
        default:
          if(accumaletedValue == 0.0) {
            accumaletedValue = calculator.calculate(userInput);
            System.out.println(userInput + " = " + accumaletedValue + "\n");
          } else {
            if(calculator.isOperator(userInput.charAt(0))) {
              String calc = accumaletedValue + userInput;
              accumaletedValue = calculator.calculate(calc);
              System.out.println(calc + " = " + accumaletedValue + "\n");
            } else {
              accumaletedValue = calculator.calculate(userInput);
              System.out.println(userInput + " = " + accumaletedValue + "\n");
            }
          }
          break;
      }
    }
  }
}