package org.example.stanford.closestpair;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    public double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.getX()-p2.getX()),2)+Math.pow((p1.getY()-p2.getY()),2));
    }

    public double findClosestDistance(Point[] points) {
        final Point[] pointsSortedByX = new Point[points.length];
        final Point[] pointsSortedByY = new Point[points.length];

        System.arraycopy(points,0,pointsSortedByX,0,points.length);
        System.arraycopy(points,0,pointsSortedByY,0,points.length);

        pointMergeSort.sortByX(pointsSortedByX,pointsSortedByX.length);
        pointMergeSort.sortByY(pointsSortedByY,pointsSortedByY.length);

        final List<Point> sortedByXPoints = Arrays.asList(pointsSortedByX);
        final List<Point> sortedByYPoints = Arrays.asList(pointsSortedByY);


        return findClosestPoint(sortedByXPoints,sortedByYPoints,sortedByXPoints.size());

    }

    private double findClosestPoint(final List<Point> sortedByXPoints,final List<Point> sortedByYPoints, int numOfPoints) {
        if(numOfPoints <=3) {
            final Point[] closestPoints = bruteForce(sortedByXPoints.toArray(new Point[0]));
            log.info("closestPoints[0] = {} , closestPoints[1] = {}",closestPoints[0],closestPoints[1]);
            log.info("calculateDistance(closestPoints[0],closestPoints[1]) = {}",calculateDistance(closestPoints[0],closestPoints[1]));
            return calculateDistance(closestPoints[0],closestPoints[1]);
        }

        int middleIndex = numOfPoints / 2;
        final Point middlePoint = sortedByXPoints.get(middleIndex);

        final List<Point> leftSubList = new ArrayList<>();
        final List<Point> rightSubList = new ArrayList<>();


        for(int i=0;i<numOfPoints;++i) {
            final Point iteratedPoint = sortedByXPoints.get(i);
            if(iteratedPoint.getX() < middlePoint.getX()) {
                leftSubList.add(iteratedPoint);
            } else {
                rightSubList.add(iteratedPoint);
            }
        }

        double deltaLeft = findClosestPoint(leftSubList,sortedByYPoints,middleIndex);
        double deltaRight = findClosestPoint(rightSubList,sortedByYPoints,numOfPoints-middleIndex);
        double delta = Math.min(deltaLeft,deltaRight);

        final List<Point> pointsInMiddleStrip = new ArrayList<>();


        for(int i=0;i<numOfPoints;i++) {
            final Point iteratedPoint = sortedByYPoints.get(i);
            if (Math.abs(iteratedPoint.getX() - middlePoint.getX()) < delta) {
                pointsInMiddleStrip.add(iteratedPoint);
            }
        }

        double minDistanceInStrip = findMinimumDistanceInStrip(pointsInMiddleStrip,delta);
        return Math.min(delta,minDistanceInStrip);
    }

    private double findMinimumDistanceInStrip(List<Point> pointsInStrip, double delta) {

        double minDistance = delta;

        for(int i=0;i<pointsInStrip.size();i++) {
            //The && will guarantee at most 16 iterations, this is proven in geometry.
            for(int j=i+1;j<pointsInStrip.size() && pointsInStrip.get(j).getY() - pointsInStrip.get(i).getY() < minDistance;j++) {
                minDistance = calculateDistance(pointsInStrip.get(i),pointsInStrip.get(j));
            }
        }

        return minDistance;
    }

    /*
        Time Complexity : O(n^2)
     */
    public Point[] bruteForce(Point[] points) {
        log.info("points size = {}",points.length);
        Arrays.stream(points).forEach(point -> log.info("Point = {}",point));
        double minDistance = Double.MAX_VALUE;
        int indexI = 0;
        int indexJ = 0;

        for(int i =0;i<points.length-1;i++) {
            for(int j=i+1;j< points.length;j++) {
                double actualDistance = calculateDistance(points[i],points[j]);
                if(actualDistance < minDistance) {
                    minDistance = actualDistance;
                    indexI = i;
                    indexJ = j;
                }
            }
        }

        return new Point[]{points[indexI],points[indexJ]};
    }
}
