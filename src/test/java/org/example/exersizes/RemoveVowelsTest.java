package org.example.exersizes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveVowelsTest {

    private RemoveVowels removeVowels = new RemoveVowels();

    @Test
    void test() {
        assertEquals("ltcdscmmntyfrcdrs",removeVowels.removeVowels("leetcodeisacommunityforcoders"));
    }
}