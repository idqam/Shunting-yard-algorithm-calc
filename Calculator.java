import java.util.Scanner;

public class Calculator{

    public static void main(String[] args) {

       Scanner ss = new Scanner(System.in);

       String InputExp = ss.nextLine();

      InfixCalculator calc = new InfixCalculator(); //instantiates the calculator

        System.out.println(InputExp + " is equal to = " + calc.RPNSolver(calc.infix_postfix(InputExp)));













    }




}
