package ex3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class VegetationData {
    private int[][] dataArray;
    private Map<Double, Map<Double, Integer>> dataMap;

    public VegetationData(String filename) throws Exception {
        // Initialize the 2D array and Map
        dataArray = new int[2000][1000];
        dataMap = new HashMap<>();

        // Open the file and create a BufferedReader to read from it
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        // Loop through each line in the file
        while ((line = reader.readLine()) != null) {
            // Split the line into longitude, latitude, and density
            String[] parts = line.split(",");
            double longitude = Double.parseDouble(parts[0]);
            double latitude = Double.parseDouble(parts[1]);
            int density = Integer.parseInt(parts[2]);

            // Calculate the indices in the 2D array for this coordinate
            int x = (int) ((longitude + 180) * 9.995 / 360 * dataArray.length);
            int y = (int) ((latitude + 90) * 4.995 / 180 * dataArray[0].length);

            // Store the density in the 2D array
            dataArray[x][y] = density;

            // Store the density in the Map
            if (!dataMap.containsKey(longitude)) {
                dataMap.put(longitude, new HashMap<>());
            }
            dataMap.get(longitude).put(latitude, density);
        }

        // Close the file
        reader.close();
    }

    public int getFromArray(int x, int y) {
        return dataArray[x][y];
    }

    public Integer getFromMap(double longitude, double latitude) {
        // Round the coordinates to one decimal place
        longitude = Math.round(longitude * 10) / 10.0;
        latitude = Math.round(latitude * 10) / 10.0;

        // Find the closest longitude value in the Map
        double closestLongitude = 0;
        double closestDistance = Double.MAX_VALUE;
        for (double key : dataMap.keySet()) {
            double distance = Math.abs(key - longitude);
            if (distance < closestDistance) {
                closestLongitude = key;
                closestDistance = distance;
            }
        }

        // Find the closest latitude value in the inner Map
        double closestLatitude = 0;
        closestDistance = Double.MAX_VALUE;
        for (double key : dataMap.get(closestLongitude).keySet()) {
            double distance = Math.abs(key - latitude);
            if (distance < closestDistance) {
                closestLatitude = key;
                closestDistance = distance;
            }
        }

        // Return the density at the closest coordinate
        return dataMap.get(closestLongitude).get(closestLatitude);



    }
}
