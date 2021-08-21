public class InfixCalculator {//class that handles calculations

     private  int Precedence(String x){ //higher value is higher precedence
        return switch (x) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            case "%" -> 4;
            case "(" -> 10;
            default -> -1;
        };
    }

    private  boolean isOperator(String o) { //returns true whenever the given string is an operator

        if (o.equals("%") || o.equals("/")|| o.equals("*") || o.equals("+") || o.equals("-")|| o.equals("^")){
            return true;
        } else{
            return false;
        }
     }

     public  GenQueue<String> infix_postfix(String expression){ //method that returns a genQueue in RPN that is passed to RPNSolver method to evaluate it

         GenStack<String> theStack = new GenStack<>();
        GenQueue<String> theQueue = new GenQueue<>();
        GenQueue<String> tQueue = new GenQueue<>();

        theStack.OperatorStack();
        theQueue.OperandsQueue();
        tQueue.OperandsQueue();



        String[] Earray = expression.split(" ");//splits the user-inputed expression into an array of strings allows for negative numbers since the splitting is done at white spaces
        for(int i = 0; i < Earray.length; i++){
            if(Earray[i].matches("-?\\d+(\\.\\d+)?") ){
                theQueue.push(Earray[i]);//if the ith element a number
            }else if(Earray[i].equals("(")){
                theStack.push(Earray[i]);//if it is a left parantheses it gets pushed
            }else if(Earray[i].equals(")")){
                while (!theStack.isEmpty() && !theStack.peakTop().equals("(")){//while the stack is not empty and the top of stack is not right parentes then top of stack is pushed onto queue
                    theQueue.push(theStack.pop());
                }
                theStack.pop(); //pops top of stack
            }else{
                while (!theStack.isEmpty() && Precedence(Earray[i]) < Precedence(theStack.peakTop() ) ){
                    //while the stack is not empty and the precedence of the ith element of the array is higher than what is on top of stack then it gets pushed onto queue via popping from stack
                    theQueue.push(theStack.pop());
                }
                theStack.push(Earray[i]);

            }
        }



        while (!theStack.isEmpty()){
            theQueue.push(theStack.pop());
        }

        while(!theQueue.isEmpty()){
            String x = theQueue.pop();
            if(!x.equals("(") ){ //removes any remaining parenthesis in the queue into a new queue;
                tQueue.push(x);
            }
        }


         System.out.print(expression + " in reverse polish notation (RPN) is:  " ); //prints the user input in RPN
         tQueue.viewQueue(); //prints queue


         return tQueue; //the queue is returned and eventually passed as a parameter to RPNSolver


    }

    public Double RPNSolver(GenQueue<String> RPN){ //evaluates the passed queue
         GenStack<Double> cStack = new GenStack<>();
         cStack.OperatorStack();

         String ss;

         while (!RPN.isEmpty()){
             ss = RPN.pop();//while the given queue is not empty it pops every element to a string
             if(isNumeric(ss)){//if the string above is a number then its value is parsed a double and pushed onto stack
                 double x = Double.parseDouble(ss);
                 cStack.push(x);
             }else if(isOperator(ss)){//if the string is an operator then it calls calculation method after popping two values from stack
                 double b = cStack.pop();
                 double a = cStack.pop();
                 cStack.push(calculation(a,b,ss));//in the end the stack will have one final value that is then popped and returned
             }
         }

        return cStack.pop(); //finally the result

    }


    private double calculation(double a, double b, String operator){//used to calculate based on passed doubles and appropiate operator
         if(operator.equals("*")){
             return a * b;
         }else if(operator.equals("+")){
             return a + b;
         }else if(operator.equals("-")){
             return a-b;
         }else if(operator.equals("%")){
             return a % b;
         }else if(operator.equals("^")){
             return Math.pow(a,b);
         }else{
             return a/b;
         }


    }

    private static boolean isNumeric(String str) {//returns true if the string is numeric else it catches the exception of trying to parse a value from it and returns false
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }





}
