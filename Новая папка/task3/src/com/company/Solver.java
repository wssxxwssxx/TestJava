package com.company;
import java.util.Scanner;
import java.util.Stack;

public class Solver {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String str = in.nextLine();
        String[] strings = str.split(" ");

        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < strings.length; i++){
            if(isNumber(strings[i])){
                stack.push(Integer.parseInt(strings[i]));
            }
            else{
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();

                switch (strings[i]){
                    case "+":
                        stack.push(tmp2 + tmp1);
                        break;
                    case "-":
                        stack.push(tmp2 - tmp1);
                        break;
                    case "*":
                        stack.push(tmp2 * tmp1);
                        break;
                    case "/":
                        stack.push(tmp2 / tmp1);
                        break;
                }
            }
        }

        if(!stack.empty()){
            System.out.println(stack.pop());
        }
    }
    private static boolean isNumber(String string){
        try {
            Integer.parseInt(string);

            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}