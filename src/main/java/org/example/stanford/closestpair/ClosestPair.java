package org.example.stanford.closestpair;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Point;

import java.util.Arrays;


@Slf4j
public class ClosestPair {

    ClosestPairMergeSort closestPairMergeSort = new ClosestPairMergeSort();
    PointMergeSort pointMergeSort = new PointMergeSort();

    /*
        Piggy backing merge sort, Time Complexity O(n logn)
     */
    public int[] oneDimension(int[] points) {
        return closestPairMergeSort.sort(points,points.length);
    }

    public double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.getX()-p2.getX()),2)+Math.pow((p1.getY()-p2.getY()),2));
    }

    public double closestRecursive(final Point[] pointsSortedByX, final Point[] pointsSortedByY, int arrayLength) {
        if(arrayLength <=3) {
            return -1;//brute force;
        }

        int mid = arrayLength / 2;

        final Point[] lowerHalfOfXPoints = new Point[mid];
        final Point[] higherHalfOfXPoints = new Point[mid];

        System.arraycopy(pointsSortedByX,0,lowerHalfOfXPoints,0,lowerHalfOfXPoints.length);
        System.arraycopy(pointsSortedByX,mid,higherHalfOfXPoints,0,higherHalfOfXPoints.length);

        final Point[] lowerHalfOfYPoints = new Point[mid];
        final Point[] higherHalfOfYPoints = new Point[mid];
        System.arraycopy(pointsSortedByY,0,lowerHalfOfYPoints,0,lowerHalfOfYPoints.length);
        System.arraycopy(pointsSortedByY,mid,higherHalfOfYPoints,0,higherHalfOfYPoints.length);

        double distanceLeft = closestRecursive(lowerHalfOfXPoints,lowerHalfOfYPoints,mid);
        double distanceRight = closestRecursive(higherHalfOfXPoints,higherHalfOfYPoints,mid);



        return 0;

    }

    public void findClosestDistance(Point[] points) {
        final Point[] pointsSortedByX = new Point[points.length];
        final Point[] pointsSortedByY = new Point[points.length];

        System.arraycopy(points,0,pointsSortedByX,0,points.length);
        System.arraycopy(points,0,pointsSortedByY,0,points.length);

        pointMergeSort.sortByX(pointsSortedByX,pointsSortedByX.length);
        pointMergeSort.sortByY(pointsSortedByY,pointsSortedByY.length);


    }

    public Point[] bruteForce(Point[] points) {

        double min = Integer.MAX_VALUE;
        int indexI = 0;
        int indexJ = 0;

        for(int i =0;i<points.length;i++) {
            Point pointI = points[i];
            for(int j=i+1;j< points.length;j++) {
                Point pointJ = points[j];
                double distance = Math.sqrt(Math.pow((pointI.getX()-pointJ.getX()),2)+Math.pow((pointI.getY()-pointJ.getY()),2));
                if(distance < min) {
                    min = distance;
                    indexI = i;
                    indexJ = j;
                }
            }
        }

        return new Point[]{points[indexI],points[indexJ]};
    }
}
