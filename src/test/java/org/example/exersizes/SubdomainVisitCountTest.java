package org.example.exersizes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SubdomainVisitCountTest {

    SubdomainVisitCount subdomainVisitCount = new SubdomainVisitCount();

    @Test
    void test() {
        System.out.println(subdomainVisitCount.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }

}