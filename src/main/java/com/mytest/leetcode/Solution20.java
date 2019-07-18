package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution20 {

    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        log.info("{}",solution.isValid1("]"));
    }

//    private HashMap<Character, Character> mappings;
//
//    // Initialize hash map with mappings. This simply makes the code easier to read.
//    public Solution20() {
//        this.mappings = new HashMap<Character, Character>();
//        this.mappings.put(')', '(');
//        this.mappings.put('}', '{');
//        this.mappings.put(']', '[');
//    }
//
//    public boolean isValid(String s) {
//
//        // Initialize a stack to be used in the algorithm.
//        Stack<Character> stack = new Stack<Character>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            // If the current character is a closing bracket.
//            if (this.mappings.containsKey(c)) {
//
//                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
//                char topElement = stack.empty() ? '#' : stack.pop();
//
//                // If the mapping for this bracket doesn't match the stack's top element, return false.
//                if (topElement != this.mappings.get(c)) {
//                    return false;
//                }
//            } else {
//                // If it was an opening bracket, push to the stack.
//                stack.push(c);
//            }
//        }
//
//        // If the stack still contains elements, then it is an invalid expression.
//        return stack.isEmpty();
//    }

    public boolean isValid1(String s) {
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //包含闭合的，就需要pop
            if(mappings.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                }
                //最后一个应该是对应的开括号
                char pop = stack.pop();
                if(pop != mappings.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }
}
