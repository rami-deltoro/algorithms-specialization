package org.example.stanford;

import org.example.model.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPairTest {

    ClosestPair closestPair = new ClosestPair();

    @Test
    void bruteForce() {
        Point[] points = new Point[]{
                new Point(50,20),
                new Point(10,50),
                new Point(90,23),
                new Point(1,1),
                new Point(102,89),
                new Point(567,982),
                new Point(223,122),
                new Point(2,2),
                new Point(4423,2322),
        };

        Arrays.stream(closestPair.bruteForce(points))
                .forEach(System.out::println);
    }
}