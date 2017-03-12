package Part_C;

import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class MyCalculator {

    public static void runProgram() {
        Scanner sc = new Scanner(System.in);
        boolean condition = true;
        while (condition) {
            System.out.println("Enter type of variable : 1(int), 2(double), 2(complex) or 0(Exit)");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter Operation :");
                    System.out.println("+ (addition)\n- (subtract)\n* (multiply)\n/ (division)");
                    System.out.println("% (remainder)\nMAX (maximum)\nMIN (minimum)");
                    System.out.println("S (pow sqaure)\nF (factorial)\nFI (fibonacci)");
                    intOperation(sc.next(), sc);
                    break;
                case 2:
                    System.out.println("Enter Operation :");
                    System.out.println("+ (addition)\n- (subtract)\n* (multiply)\n/ (division)");
                    System.out.println("SR (square root)\nS (pow square)");
                    System.out.println("COS (cos(n))\nSIN (sin(n))\nLOG (log(n))");
                    doubleOperation(sc.next(), sc);
                    break;
                case 3:
                    System.out.println("Enter Operation :");
                    System.out.println("+ (addition)\n- (subtract)\n* (multiply)\n/ (division)");
                    complexOperation(sc.next(), sc);
                    break;
                case 0:
                    condition = false;
                    System.out.println("Thank you. Please come again!");
                    break;
                default:
                    System.out.println("Please enter a valid digit.");
                    break;
            }
        }
    }

    public static void intOperation(String operation, Scanner sc) {
        int number1, number2;
        switch (operation) {
            case "+":
                System.out.println("Enter first number : ");
                number1 = sc.nextInt();
                System.out.println("Enter second number : ");
                number2 = sc.nextInt();
                IntBinaryOperator addInt = (a, b) -> a + b;
                System.out.println(number1 + " + " + number2 + " = " + addInt.applyAsInt(number1, number2));
                break;
            case "-":
                System.out.println("Enter first number : ");
                number1 = sc.nextInt();
                System.out.println("Enter second number : ");
                number2 = sc.nextInt();
                IntBinaryOperator subtractInt = (a, b) -> a - b;
                System.out.println(number1 + " - " + number2 + " = " + subtractInt.applyAsInt(number1, number2));
                break;

            case "*":
                System.out.println("Enter first number : ");
                number1 = sc.nextInt();
                System.out.println("Enter second number : ");
                number2 = sc.nextInt();
                IntBinaryOperator multiplyInt = (a, b) -> a * b;
                System.out.println(number1 + " * " + number2 + " = " + multiplyInt.applyAsInt(number1, number2));
                break;
            case "/":
                System.out.println("Enter first number : ");
                number1 = sc.nextInt();
                System.out.println("Enter second number : ");
                number2 = sc.nextInt();
                if (number2 == 0) {
                    System.out.println("Cannot divide by 0");
                    break;
                }
                IntBinaryOperator divideInt = (a, b) -> a / b;
                System.out.println(number1 + " / " + number2 + " = " + divideInt.applyAsInt(number1, number2));
                break;
            case "%":
                System.out.println("Enter first number : ");
                number1 = sc.nextInt();
                System.out.println("Enter second number : ");
                number2 = sc.nextInt();
                if (number2 == 0) {
                    System.out.println("Cannot divide by 0");
                    break;
                }
                IntBinaryOperator remainderInt = (a, b) -> a % b;
                System.out.println(number1 + " % " + number2 + " = " + remainderInt.applyAsInt(number1, number2));
                break;
            case "MAX":
                System.out.println("Enter first number : ");
                number1 = sc.nextInt();
                System.out.println("Enter second number : ");
                number2 = sc.nextInt();
                IntBinaryOperator max = (a, b) -> a >= b ? a : b;
                System.out.println(number1 + " or " + number2 + " (Max)? " + max.applyAsInt(number1, number2));
                break;
            case "MIN":
                System.out.println("Enter first number : ");
                number1 = sc.nextInt();
                System.out.println("Enter second number : ");
                number2 = sc.nextInt();
                IntBinaryOperator min = (a, b) -> a >= b ? b : a;
                System.out.println(number1 + " or " + number2 + " (Min)? " + min.applyAsInt(number1, number2));
                break;
            case "S":
                System.out.println("Enter first number : ");
                number1 = sc.nextInt();
                IntUnaryOperator powerInt = a -> a * a;
                System.out.println(number1 + " * " + number1 + " = " + powerInt.applyAsInt(number1));
                break;
            case "F":
                System.out.println("Enter number : ");
                number1 = sc.nextInt();
                if (number1 < 0) {
                    System.out.println("Please type only positive numbers");
                    break;
                }
                IntUnaryOperator factorial = a -> {
                    int ans = 1;
                    for (int i = 2; i <= a; i++) {
                        ans *= i;
                    }
                    return ans;
                };
                System.out.println(number1 + "! = " + factorial.applyAsInt(number1));
                break;
            case "FI":
                System.out.println("Enter number : ");
                number1 = sc.nextInt();
                if (number1 < 0) {
                    System.out.println("Please type only positive numbers");
                    break;
                }
                IntUnaryOperator fibonacci = fib -> {
                    int a = 0;
                    int b = 1;
                    for (int i = 0; i < fib; i++) {
                        int temp = b;
                        b += a;
                        a = temp;
                    }
                    return a;
                };
                System.out.println("Fibonacci sequence element " + number1 + " = " + fibonacci.applyAsInt(number1));
                break;
            default:
                System.out.println("Not a listed operation.");
        }
    }

    public static void doubleOperation(String operation, Scanner sc) {
        double number1, number2;
        switch (operation) {
            case "+":
                System.out.println("Enter first number : ");
                number1 = sc.nextDouble();
                System.out.println("Enter second number : ");
                number2 = sc.nextDouble();
                DoubleBinaryOperator addDouble = (a, b) -> a + b;
                System.out.println(number1 + " + " + number2 + " = " + addDouble.applyAsDouble(number1, number2));
                break;
            case "-":
                System.out.println("Enter first number : ");
                number1 = sc.nextDouble();
                System.out.println("Enter second number : ");
                number2 = sc.nextDouble();
                DoubleBinaryOperator subtractDouble = (a, b) -> a - b;
                System.out.println(number1 + " - " + number2 + " = " + subtractDouble.applyAsDouble(number1, number2));
                break;
            case "*":
                System.out.println("Enter first number : ");
                number1 = sc.nextDouble();
                System.out.println("Enter second number : ");
                number2 = sc.nextDouble();
                DoubleBinaryOperator multiplyDouble = (a, b) -> a * b;
                System.out.println(number1 + " * " + number2 + " = " + multiplyDouble.applyAsDouble(number1, number2));
                break;
            case "/":
                System.out.println("Enter first number : ");
                number1 = sc.nextDouble();
                System.out.println("Enter second number : ");
                number2 = sc.nextDouble();
                if (number2 == 0) {
                    System.out.println("Cannot divide by 0");
                    break;
                }
                DoubleBinaryOperator divideDouble = (a, b) -> a / b;
                System.out.println(number1 + " / " + number2 + " = " + divideDouble.applyAsDouble(number1, number2));
                break;
            case "SR":
                System.out.println("Enter first number : ");
                number1 = sc.nextDouble();
                if (number1 < 0) {
                    System.out.println("Please type only positive numbers");
                    break;
                }
                DoubleUnaryOperator squareroot = Math::sqrt;
                System.out.println("sqrt(" + number1 + ") = " + squareroot.applyAsDouble(number1));
                break;
            case "S":
                System.out.println("Enter first number : ");
                number1 = sc.nextDouble();
                DoubleUnaryOperator powerDouble = a -> a * a;
                System.out.println(number1 + " * " + number1 + " = " + powerDouble.applyAsDouble(number1));
                break;
            case "COS":
                System.out.println("Enter first number : ");
                number1 = sc.nextDouble();
                DoubleUnaryOperator cos = Math::cos;
                System.out.println("cos(" + number1 + ") = " + cos.applyAsDouble(number1));
                break;
            case "SIN":
                System.out.println("Enter first number : ");
                number1 = sc.nextDouble();
                DoubleUnaryOperator sin = Math::sin;
                System.out.println("sin(" + number1 + ") = " + sin.applyAsDouble(number1));
                break;
            case "LOG":
                System.out.println("Enter first number : ");
                number1 = sc.nextDouble();
                if (number1 < 0) {
                    System.out.println("Please type only positive numbers");
                    break;
                }
                DoubleUnaryOperator log = Math::log;
                System.out.println("log10(" + number1 + ") = " + log.applyAsDouble(number1));
                break;
            default:
                System.out.println("Not a listed operation.");
        }
    }

    public static void complexOperation(String operation, Scanner sc) {
        if ("+-*/".contains(operation)) {
            double real1, imaginary1, real2, imaginary2;
            System.out.println("Enter first real number : ");
            real1 = sc.nextInt();
            System.out.println("Enter first imaginary number : ");
            imaginary1 = sc.nextInt();
            System.out.println("Enter second real number : ");
            real2 = sc.nextInt();
            System.out.println("Enter second imaginary number : ");
            imaginary2 = sc.nextInt();
            if ((real2 == 0) && (imaginary2 == 0)) {
                System.out.println("Can't divide by 0.");
                return;
            }
            Complex c1 = new Complex(real1, imaginary1);
            Complex c2 = new Complex(real2, imaginary2);

            switch (operation) {
                case "+":
                    BinaryOperator<Complex> addComplex = Complex::add;
                    System.out.println(c1 + " + " + c2 + " = " + addComplex.apply(c1, c2));
                    break;
                case "-":
                    BinaryOperator<Complex> subtractComplex = Complex::subtract;
                    System.out.println(c1 + " - (" + c2 + ") = " + subtractComplex.apply(c1, c2));
                    break;
                case "*":
                    BinaryOperator<Complex> multiplyComplex = Complex::multiply;
                    System.out.println("(" + c1 + ") * (" + c2 + ") = " + multiplyComplex.apply(c1, c2));
                    break;
                case "/":
                    BinaryOperator<Complex> divideComplex = Complex::divide;
                    System.out.println("(" + c1 + ") / (" + c2 + ") = " + divideComplex.apply(c1, c2));
                    break;
            }
        }
        System.out.println("Not a listed operation.");

    }

    public static void main(String[] args) {
        runProgram();
    }

}

class Complex {

    double real;
    double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }



    Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imaginary + c.imaginary);
    }

    Complex subtract(Complex c) {
        return new Complex(this.real - c.real, this.imaginary - c.imaginary);
    }

    Complex multiply(Complex c) {
        double real = (this.real * c.real) - (this.imaginary * c.imaginary);
        double imaginary = (this.real * c.imaginary) + (this.imaginary * c.real);
        return new Complex(real, imaginary);
    }

    Complex divide(Complex c) {
        double real = ((this.real * c.real) + (this.imaginary * c.imaginary))
                / ((c.real * c.real) + (c.imaginary * c.imaginary));
        double imaginary = ((this.imaginary * c.real) - (this.real * c.imaginary))
                / ((c.real * c.real) + (c.imaginary * c.imaginary));
        return new Complex(real, imaginary);
    }

    @Override
    public String toString() {
        if ((this.real == 0) || (this.imaginary == 0)) {
            if (this.real == 0) {
                if (this.imaginary == 0) {
                    return "0";
                }
                return this.imaginary + "i";
            } else {
                return this.real + "";
            }
        }
        return this.real + " + " + this.imaginary + "i";
    }
}
