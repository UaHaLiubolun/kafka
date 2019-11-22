/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.Calculate
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.Stack;

import org.checkerframework.checker.units.qual.C;

/**
 * Calculate
 * @description TODO
 * @author liubolun
 * @date 2019年11月22日 13:59
 * @version 3.1.1
 */
public class Calculate {

    public int calculate(String s) {
//        Stack<String> characters = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '+' || c == '-') {
//                if (characters.empty() || characters.peek().equals("(")) {
//                } else {
//                    sb.append(characters.pop());
//                }
//                characters.push(String.valueOf(c));
//            } else if (c == '(') {
//                characters.push(String.valueOf(c));
//            } else if (c == ')') {
//                while (true) {
//                    String sss = characters.pop();
//                    if(sss.equals("(")) {
//                        break;
//                    } else {
//                        sb.append(sss);
//                    }
//                }
//            } else if (c != ' ') {
//                sb.append(c);
//            }
//        }
//        while (!characters.empty()) {
//            sb.append(characters.pop());
//        }
//        for (int i = 0; i < sb.length(); i++) {
//            char c = sb.charAt(i);
//            if (c != '+' && c != '-') {
//                characters.push(c);
//            } else if  (c == '+'){
//                char a = characters.pop();
//                char b = characters.pop();
//                int cc = a + b - '0' - '0';
//                characters.push((char) (cc + '0'));
//            } else {
//                char a = characters.pop();
//                char b = characters.pop();
//                int cc = b - a;
//                characters.push((char) (cc + '0'));
//            }
//        }
//        return characters.pop() - '0';
        return 1;
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
//        System.out.println(calculate.calculate(" 2-1 + 2 "));
        System.out.println(1<<3);
    }
}
