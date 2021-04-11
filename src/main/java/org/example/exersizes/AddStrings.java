package org.example.exersizes;

import lombok.extern.slf4j.Slf4j;

/**
 * https://leetcode.com/problems/add-strings/
 */
@Slf4j
public class AddStrings {


    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int num1Length = num1.length();
        int num2Length = num2.length();
        int length = num1Length > num2Length ? num1Length : num2Length;
        int carry = 0;
        for(int i=0;i<length;i++) {
            int num1Digit = getDigit(num1,(num1Length)-i-1);
            int num2Digit = getDigit(num2,(num2Length)-i-1);

            if(num1Digit + num2Digit + carry > 9) {
                result.append((num1Digit + num2Digit + carry) - 10);
                carry = 1;
            }else {
                result.append(num1Digit + num2Digit + carry);
                carry = 0;
            }
        }

        if(carry >0) {
            result.append(carry);
        }

        return result.reverse().toString();

    }

    private int getDigit(String num,int index) {
        if(index>=num.length() || index<0) {
            return 0;
        } else {
            return (num.charAt(index) - '0') ;
        }
    }

}
