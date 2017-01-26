package com.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ExpressionEvaluation {
	
	public Stack<Integer> evaluate(String expression) {
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> operands = new Stack<Character>();
		
		char[] input = expression.toCharArray();
		
		for (int i = 0; i < input.length; i++) {
			if(input[i] >= '0' && input[i] <= '9') {
				StringBuilder builder = new StringBuilder();
				while(i < input.length && input[i] >= '0' && input[i] <= '9') {
					builder.append(input[i++]);
				}
				values.push(Integer.valueOf(builder.toString()));
			}
			
			if(input[i] == '+' || input[i] == '-' || input[i] ==  '*' || input[i] == '/') {
				if(!operands.isEmpty() && hasPrecedence(operands.peek(), input[i])) {
					values.push(applyOperand(operands.pop(), values.pop(), values.pop()));
				} 
					
				operands.push(input[i]);
			
			}
		}
		return values;
	}
	
	public boolean hasPrecedence(Character operand1 , Character operand2) {
		if((operand1 == '/' || operand1 == '*') && (operand2 == '+' || operand2 =='-')) {
			return false;
		} else {
			return true;
		}
	}
	
	public int applyOperand(Character operand, Integer value1, Integer value2) {
		int value = 0;
		switch(operand) {
			case '+':
				value = value1 + value2;
				break;
			case '-':
				value = value1 - value2;
				break;
			case '*':
				value = value1 - value2;
				break;
			case '/':
				value = value1 / value2;
				break;
		}
		return value;
	}
	
	public static void main(String[] args) {
		ExpressionEvaluation evaluation = new ExpressionEvaluation();
		System.out.println(evaluation.evaluate("2+3*2"));
	}
}