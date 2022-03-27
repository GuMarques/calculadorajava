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
    System.out.println(calculator.calculate("20*10/2"));
    // while(userInput != "e") {
    //   System.out.println("Enter e to exit");
    //   System.out.println("Enter ce to clean the calculator");
    //   System.out.println("Or Enter a expression to calculate");
    //   userInput = reader.readLine();
    //   switch(userInput) {
    //     case "e":
    //       break;
    //     case "ce":
    //       accumaletedValue = 0.0;
    //       break;
    //     default:
    //       accumaletedValue = calculator.calc(userInput);
    //       System.out.println(userInput + " = " + accumaletedValue);
    //       break;
    //   }
    // }
  }
}