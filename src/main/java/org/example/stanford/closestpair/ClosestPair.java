package org.example.stanford.closestpair;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Point;


@Slf4j
public class ClosestPair {

    ClosestPairMergeSort closestPairMergeSort = new ClosestPairMergeSort();

    /*
        Piggy backing merge sort, Time Complexity O(n logn)
     */
    public int[] oneDimension(int[] points) {
        return closestPairMergeSort.sort(points,points.length);
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
