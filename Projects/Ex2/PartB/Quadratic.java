package PartB;

import java.util.Scanner;

/**
 * Created by Shlomi Alon on 19/12/2016.
 */
public class Quadratic{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 or else number without 0 for end the progrem");
        int end = sc.nextInt();

        while(end!=0){
            System.out.println("ax^2 + bx + c = 0 , get number for a: ");
            double a = sc.nextDouble();
            System.out.println( a + "x^2 + bx + c = 0, get number for b: ");
            double b = sc.nextDouble();
            System.out.println( a + "x^2 + " + b +"x + c = 0 , get number for c: ");
            double c = sc.nextDouble();
            System.out.println( a + "x^2 + " + b +"x + " + c + " =  ");
            double x1 , x2, inroot;

            if(a!=0) {
                try {
                    inroot = (b * b) - (4 * a * c);
                    if (inroot < 0) {
                        throw new SquareEquationException("Error, no real root");
                    }

                    x1 = (-b + Math.sqrt(inroot)) / (2 * a);
                    x2 = (-b - Math.sqrt(inroot)) / (2 * a);

                    if (x1 == x2) {
                        System.out.println("x1= x2=" + x1);
                    } else {
                        System.out.println("x1=" + x1 + " , " + "x2=" + x2);
                    }
                } catch (SquareEquationException e ) {
                   e.printStackTrace();
                }
            }
    try {
        if (a == 0 && b != 0 && c != 0) {
            System.out.println("x1=,x2= " + (-c / b));
        } else if (b == 0 && a != 0 && c != 0) {
            System.out.println("x1= " + Math.sqrt((c / a)) + "," + "x2= " + -1 * (Math.sqrt((c / a))));
        } else if (c == 0 && b != 0 && a != 0) {
            System.out.println("x1= 0" + "," + "x2= " + (-b / a));
        } else if (a == 0 && b == 0 && c != 0) {
           throw new SquareEquationException("Error, No Answer!");
        } else if (a == 0 && b != 0 || a != 0 && b == 0) {
            System.out.println("x1=,x2= 0");
        } else if (a == 0) {
            throw new SquareEquationException("x1 can be any number - trivial!");
        }
    } catch ( SquareEquationException e ) {
        e.printStackTrace();
    }
            System.out.println("Enter 1 or else number without 0 for end the progrem");
            end = sc.nextInt();
        }
        System.out.println("Ex2, Done!");
    }
}
