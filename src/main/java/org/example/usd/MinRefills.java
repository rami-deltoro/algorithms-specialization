package org.example.usd;


public class MinRefills {

    public String calculateMinRefills(int[] gasStationPoints, int maxDistanceWithoutRefuel) {
        
        int numRefills = 0;
        int currentPosition = 0;

        int end = gasStationPoints.length-2;

        int lastRefill = 0;
        while (currentPosition <= end) {
            lastRefill = currentPosition;

            while (currentPosition<=end && (gasStationPoints[currentPosition+1] - gasStationPoints[lastRefill] <=maxDistanceWithoutRefuel)) {
                currentPosition++;
            }

            if(currentPosition==lastRefill) {
                return "IMPOSSIBLE";
            }

            if(currentPosition<=end) {
                numRefills++;
            }

        }

        return String.valueOf(numRefills);
    }
}
