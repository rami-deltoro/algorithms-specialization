package org.example.stanford.closestPair;

import org.example.model.Point;
import org.example.stanford.closestpair.ClosestPair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @Test
    void oneDimension() {
        int[] points = new int[]{11,22,33,44,55,66,67,77,88,99};

        System.out.println(Arrays.toString(closestPair.oneDimension(points)));
    }

    @Test
    void findDistance() {
        Point[] points = new Point[]{
                new Point(50,20),
                new Point(10,50),
                new Point(90,23),
                new Point(1,1),
                new Point(102,89),
                new Point(567,982),
                new Point(223,122),
                new Point(3,2),
                new Point(300,45),
                new Point(250,25),
        };

        System.out.println(closestPair.findClosestDistance(points));
    }
}