package org.example.usd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MinRefillsTest {

    private MinRefills minRefills = new MinRefills();

    @Test
    void test() {
        int positionA = 0;
        int positionB = 400;
        int[] gasStationPoints = new int[]{positionA,100,200,300,positionB};
        int maxDistanceWithoutRefuel = 201;

        System.out.println(minRefills.calculateMinRefills(gasStationPoints,maxDistanceWithoutRefuel));
    }
}