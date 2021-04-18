package org.example.stanford;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Point;

@Slf4j
public class ClosestPair {



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
