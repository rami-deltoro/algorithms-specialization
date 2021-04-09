package org.example.exersizes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    ValidParentheses validParentheses = new ValidParentheses();

    @Test
    void isValid() {
        assertTrue(validParentheses.isValid("()"));
    }
}