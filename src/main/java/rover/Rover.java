package rover;


import rover.models.Command;
import rover.models.GeographicPosition;
import rover.models.Orientation;

import static rover.models.Orientation.*;

public class Rover {
    private GeographicPosition geographicPosition;
    private String roverCommands;

    public Rover(GeographicPosition geographicPosition) {
        this.geographicPosition = geographicPosition;
    }

    private void executeCommand(Command command) {
        if(RoverExerciseHelper.commandRotations.contains(command)) {
            rotate(command);
        } else if (command.equals(Command.MOVE)) {
            switch (geographicPosition.getOrientation()) {
                case NORTH -> geographicPosition.incrementY();
                case EAST -> geographicPosition.incrementX();
                case WEST -> geographicPosition.decrementX();
                case SOUTH -> geographicPosition.decrementY();
            }
        }
    }

    public void executeCommands() {
        for(char ch : roverCommands.toCharArray()) {
            executeCommand(RoverExerciseHelper.parseCommandFromLetter(String.valueOf(ch)));
        }
    }

    public void rotate(Command command) {
        if(command.equals(Command.RIGHT)) {
            chooseRotation(EAST, SOUTH, WEST, NORTH);
        } else if (command.equals(Command.LEFT)) {
            chooseRotation(WEST, NORTH, EAST, SOUTH);
        }
    }

    private void chooseRotation(Orientation one, Orientation two, Orientation three, Orientation four) {
        switch (geographicPosition.getOrientation()) {
            case NORTH:
                geographicPosition.setOrientation(one);
                break;
            case EAST:
                geographicPosition.setOrientation(two);
                break;
            case SOUTH:
                geographicPosition.setOrientation(three);
                break;
            case WEST:
                geographicPosition.setOrientation(four);
                break;
        }
    }

    public void setRoverCommands(String roverCommands) {
        this.roverCommands = roverCommands;
    }

    @Override
    public String toString() {
        return "Rover Orientation: "+geographicPosition.getOrientation()
                +" - X: "+geographicPosition.getActualX()+" - Y: "+geographicPosition.getActualY();
    }

}
