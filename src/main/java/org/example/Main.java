package org.example;

import rover.models.GeographicPosition;
import rover.MyFileReader;
import rover.Rover;
import rover.RoverExerciseHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        MyFileReader reader = new MyFileReader(); // contains all lines

        var maxXY = RoverExerciseHelper.parsePlateauXY(reader.getCommandLines().get(0));
        List<Rover> roverList = new ArrayList<>();
        for(int i=1; i<reader.getCommandLines().size(); i+=2) {
            System.out.println("Rover position: " + reader.getCommandLines().get(i));
            System.out.println("Rover commnds: " + reader.getCommandLines().get(i+1));
            GeographicPosition geographicPosition = new GeographicPosition(maxXY.get(0), maxXY.get(1));
            try {
                RoverExerciseHelper.populateGeographicPosition(geographicPosition, reader.getCommandLines().get(i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Rover rover = new Rover(geographicPosition);
            rover.setRoverCommands(reader.getCommandLines().get(i+1));
            roverList.add(rover);
        }
        for(Rover rover: roverList) {
            rover.executeCommands();
            System.out.println(rover.toString());
        }
        System.out.println("The end.");
    }
}