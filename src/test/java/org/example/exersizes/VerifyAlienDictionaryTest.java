package org.example.exersizes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerifyAlienDictionaryTest {

    VerifyAlienDictionary verifyAlienDictionary = new VerifyAlienDictionary();

    @Test
    void isAlienSorted() {
        assertFalse(verifyAlienDictionary.isAlienSorted(new String[]{"word","world","row"},"worldabcefghijkmnpqstuvxyz"));
//
        assertFalse(verifyAlienDictionary.isAlienSorted(new String[]{"apple","app"},"abcdefghijklmnopqrstuvwxyz"));
        assertTrue(verifyAlienDictionary.isAlienSorted(new String[]{"hello","hello"},"abcdefghijklmnopqrstuvwxyz"));
        assertTrue(verifyAlienDictionary.isAlienSorted(new String[]{"apap","app"},"abcdefghijklmnopqrstuvwxyz"));

    }
}