package Part_A;

import java.util.Stack;

public class Ex13 {

    //--Returns the solution of the given math expression.
    public static int evalExpr1(String expression) {
        if ((!expression.contains("(") && !expression.contains(")"))) {
            return calculateSmallestExpression(expression);
        } else {
            int open_bracket = expression.indexOf("(");
            int bracket_counter = 1;
            int close_bracket = 0;
            for (int i = open_bracket + 1; i < expression.length(); i++) {
                if (expression.charAt(i) == ')') {
                    bracket_counter--;
                    if (bracket_counter == 0) {
                        close_bracket = i;
                        break;
                    }   
                }
                else if (expression.charAt(i) == '(') bracket_counter++;     
            }
            String substring = expression.substring(open_bracket + 1, close_bracket);
            String result = expression.substring(0, open_bracket) + evalExpr1(substring) + expression.substring(close_bracket + 1);
            if (result.contains("(") && result.contains(")"))
                result = evalExpr1(result) + "";
            if (!result.matches("[0-9]+")) {
                return calculateSmallestExpression(result);
            } else {
                return Integer.parseInt(result);
            }
        }
    }

    //--Solves only expression such as : (number1) (function) (number2)
    public static int calculateSmallestExpression(String expression) {
        if (expression.length() > 2) {
            int number1 = 0, index = 0;
            char character = expression.charAt(index);
            while ((character >= '0') && (character <= '9')) {
                number1 = (number1 * 10) + (character - 48);
                character = expression.charAt(++index);
            }
            int number2 = 0;
            char function = character;
            character = expression.charAt(++index);
            while ((character >= '0') && (character <= '9')) {
                number2 = (number2 * 10) + (character - 48);
                if (index + 1 < expression.length()) {
                    character = expression.charAt(++index);
                } else {
                    break;
                }
            }
            switch (function) {
                case '+':
                    return number1 + number2;
                case '-':
                    return number1 - number2;
                case '*':
                    return number1 * number2;
                case '%':
                    return number1 % number2;
            }
            return 0;
        } else {
            return 0;
        }
    }

    /*
     * Given an expression, returns true if the expression
     * is valid, and false if it's not.
     */
    public static boolean isLegalExp(String expression) {
        if (expression.length() == 1) return expression.matches("[0-9]");
        return isBracketsValid(expression) && isExpressionValid(expression);
    }

    /*
     * Given an expression, returns true if the expression
     * has valid brackets, and false if it doesn't.
     */
    public static boolean isBracketsValid(String expression) {
        Stack<Character> brackets = new Stack();
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '(') {
                brackets.push(character);
            }
            if (character == ')') {
                if (brackets.isEmpty()) {
                    return false;
                }
                brackets.pop();
            }
        }
        if (brackets.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isExpressionValid(String expression) {
        //--First character and last must be open and closed brackets.
        if ((expression.charAt(0) != '(') || (expression.charAt(expression.length() - 1) != ')')) return false;
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i - 1) == '(') { //--Character is an open bracket.
                if (!"0123456789".contains(expression.charAt(i) + "")) 
                    if (expression.charAt(i) != '(') return false;
            } else if (expression.charAt(i) == ')') { //--Character is a closed bracket.
                if (!"0123456789".contains(expression.charAt(i - 1) + "")) 
                    if (expression.charAt(i) != ')') return false;
            } else if (Character.isDigit(expression.charAt(i - 1))) { //--Character is a digit.
                if (!"+-*%".contains(expression.charAt(i) + "")) //--Character is not an operator.
                    if (expression.charAt(i) != ')') return false;
            } else if ("+-*%".contains(expression.charAt(i - 1) + "")) //--Character is an operator
                if (!Character.isDigit(expression.charAt(i))) 
                    if (expression.charAt(i) != '(') return false;
        }
        return true;
    }

    /*
     * Returns the value if the expression given is valid.
     * If not, the function will return "error".
     */
    public static String evalExpr2(String expression) {
        if (isLegalExp(expression)) {
            return evalExpr1(expression) + "";
        } else {
            return "error";
        }
    }

    public static void main(String[] args) {
        String expression = "((4*((4%3)+2))*3)";
        System.out.println("evalExpr2 : " + evalExpr2(expression));
        String[] exp = {"0", "(9-6)*(3+3)", "(((2+3)*3)+(3-1))", "(1+((2+3)*(4*5)))", "((1+5)%4)"};
	String[] errExp = {"1+4)", "((2+3)*3)+(3-1)))", "(1+(2)"};
	for(int i = 0; i < exp.length; i++){
            System.out.println(exp[i] + " = " + evalExpr2(exp[i]));
	}
	System.out.println();
	for(int i = 0; i < errExp.length; i++) {
            System.out.println(errExp[i] + " = " + evalExpr2(errExp[i]));
	}
    }

}
