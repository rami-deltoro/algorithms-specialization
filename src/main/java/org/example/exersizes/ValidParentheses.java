package org.example.exersizes;

import lombok.extern.slf4j.Slf4j;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *  https://leetcode.com/problems/valid-parentheses/
 */
@Slf4j
public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> charStack = new Stack();

        for(int i=0;i<s.length();i++) {

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                charStack.push(s.charAt(i));
                continue;
            }


                switch (s.charAt(i)) {
                    case '(':
                    case '{':
                    case '[': {
                        charStack.push(s.charAt(i));
                        break;
                    }
                    case '}': {
                        char popedChar = charStack.isEmpty() ? '#': charStack.pop();
                        if(popedChar != '{') {
                            return false;
                        }
                        break;
                    }
                    case ')': {
                        char popedChar = charStack.isEmpty() ? '#': charStack.pop();
                        if(popedChar != '(') {
                            return false;
                        }
                        break;
                    }
                    case ']': {
                        char popedChar = charStack.isEmpty() ? '#': charStack.pop();
                        if(popedChar != '[') {
                            return false;
                        }
                        break;
                    }
                    default: return false;
                }

        }

        return charStack.isEmpty();
    }
}
