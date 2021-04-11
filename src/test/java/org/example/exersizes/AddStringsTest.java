package org.example.exersizes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddStringsTest {

    AddStrings addStrings = new AddStrings();

    @Test
    void addStrings() {
        String total = addStrings.addStrings("456","77");
        System.out.println("total = "+total);
    }
}