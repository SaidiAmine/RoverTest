package rover;

import rover.exceptions.ProcessingCommandsException;
import rover.models.Command;
import rover.models.GeographicPosition;
import rover.models.Orientation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RoverExerciseHelper {
    public static List<Command> commandRotations = List.of(Command.RIGHT, Command.LEFT);
    public static List<Integer> parsePlateauXY(String commandLine) {
        return Arrays.stream(commandLine.split("\\s+"))
                .toList()
                .stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public static void populateGeographicPosition(GeographicPosition geographicPosition, String commandLine) throws ProcessingCommandsException {
        var result = commandLine.split("\\s+");
        geographicPosition.setActualX(Integer.parseInt(result[0]));
        geographicPosition.setActualY(Integer.parseInt(result[1]));
        geographicPosition.setOrientation(getOrientationFromLetter(result[2]));
    }

    private static Orientation getOrientationFromLetter(String n) throws ProcessingCommandsException {
        if(n.equals("N"))
            return Orientation.NORTH;
        if(n.equals("E"))
            return Orientation.EAST;
        if(n.equals("W"))
            return Orientation.WEST;
        if(n.equals("S"))
            return Orientation.SOUTH;
        else
            throw new ProcessingCommandsException("Error while parsing Orientation.");
    }

    public static Command parseCommandFromLetter(String n) throws ProcessingCommandsException {
        if(n.equals("M"))
            return Command.MOVE;
        if(n.equals("L"))
            return Command.LEFT;
        if(n.equals("R"))
            return Command.RIGHT;
        else
            throw new ProcessingCommandsException("Error while parsing Command.");
    }
}
