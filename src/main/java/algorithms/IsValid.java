/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.IsValid
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.Stack;

/**
 * IsValid
 * @description TODO
 * @author liubolun
 * @date 2019年11月14日 20:17
 * @version 2.9
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                char newC;
                if (s.charAt(i) == '}') newC = '{';
                else if (s.charAt(i) == ']') newC = '[';
                else newC = '(';
                if (c != newC) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("()"));
    }
}
