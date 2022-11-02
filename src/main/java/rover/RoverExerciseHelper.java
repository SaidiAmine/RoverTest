package rover;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RoverExerciseHelper {
    public static List<Command> commandRotations = List.of(Command.RIGHT, Command.LEFT);
    public static List<Integer> parsePlateauXY(String commandLine) {
//        List<Integer> XY = new ArrayList<>();
        return Arrays.stream(commandLine.split("\\s+"))
                .toList()
                .stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
//        var myvar = commandLines.stream().s ;
//        String[] strArray = commandLines
//                .split("\\s+")
//                .findFirst()
//                .get();
//        return XY;
    }

    public static void populateGeographicPosition(GeographicPosition geographicPosition, String commandLine) {
        var result = commandLine.split("\\s+");
        geographicPosition.setActualX(Integer.parseInt(result[0]));
        geographicPosition.setActualY(Integer.parseInt(result[1]));
        geographicPosition.setOrientation(getOrientationFromLetter(result[2]));
//        GeographicPosition geographicPosition =
//                new GeographicPosition(Integer.parseInt(result[0]), Integer.parseInt(result[1]),
//                        getOrientationFromLetter(result[2]));
//        return null;
    }

    private static Orientation getOrientationFromLetter(String n) {
        Orientation orientation = null;
        switch (n) {
            case "N" : orientation = Orientation.NORTH;
            case "S" : orientation = Orientation.SOUTH;
            case "E" : orientation = Orientation.EAST;
            case "W" : orientation =  Orientation.WEST;
        }
        return orientation;
    }

    private static Command parseCommandFromLetter(String n) throws Exception {
        if(n.equals("M"))
            return Command.MOVE;
        if(n.equals("L"))
            return Command.LEFT;
        if(n.equals("R"))
            return Command.RIGHT;
        else
            throw new Exception();
    }
}
