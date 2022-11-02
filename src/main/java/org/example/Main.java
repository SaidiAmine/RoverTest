package org.example;

import rover.GeographicPosition;
import rover.MyFileReader;
import rover.Rover;
import rover.RoverExerciseHelper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MyFileReader reader = new MyFileReader();
        var maxXY = RoverExerciseHelper.parsePlateauXY(reader.getCommandLines().get(0));
        GeographicPosition geographicPosition = new GeographicPosition(maxXY.get(0), maxXY.get(1));
        RoverExerciseHelper.populateGeographicPosition(geographicPosition, reader.getCommandLines().get(1));
        Rover rover = new Rover(geographicPosition);
//        for(command: reader.getCommandLines())
    }
}