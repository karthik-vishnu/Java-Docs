package com.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ExpressionEvaluation {
	
	public int evaluate(String expression) {
		Stack<Integer> numbers = new Stack<Integer>();
		Stack<Character> operand = new Stack<Character>();
		
		char[] chars = expression.toCharArray();
		int count = 0;
		for(int i=0; i<chars.length; i++) {
			StringBuilder builder = new StringBuilder();
			
			while(i<chars.length && chars[i]>= '0' && chars[i] <= '9') {
				builder.append(chars[i++]);
			}
			numbers.push(Integer.valueOf(builder.toString()));
			
			if(i<chars.length && (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/')) {
				if(!operand.isEmpty()) {
					
					if(hasPrecedence(operand.peek(), chars[i])) {
						numbers.push(applyOperand(numbers.pop(), numbers.pop(), operand.pop()));
						operand.push(chars[i]);
					} else {
						operand.push(chars[i]);
					}
				} else {
					operand.push(chars[i]);
				}
			}
		}
		while(numbers.size() > 1) {
			numbers.push(applyOperand(numbers.pop(), numbers.pop(), operand.pop()));
		}
		return numbers.pop();
	}
	
	public boolean hasPrecedence(char first, char second) {
		if(first == '+' || first == '-' && second == '*' || second =='/') {
			return false;
		} else if(first == '*' || first == '/' && second =='*' || second == '/') {
			return true;
		} else {
			return true;
		}
	}
	
	public int applyOperand(int a, int b, char c) {
		int result = 0;
		switch(c) {
			case '+':
				result = b+a;
				break;
			case '-':
				result = b-a;
				break;
			case '*':
				result = b*a;
				break;
			case '/':
				result = b/a;
				break;
		}
		return result;
	}
	public static void main(String[] args) {
		ExpressionEvaluation evaluation = new ExpressionEvaluation();
		System.out.println(evaluation.evaluate("1/2*3"));
	}
}