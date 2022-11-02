package rover;


import static rover.Orientation.*;

public class Rover {
    private GeographicPosition geographicPosition;
//    private Orientation orientation;

    public Rover(GeographicPosition geographicPosition) {
        this.geographicPosition = geographicPosition;
//        this.orientation = orientation;
    }

    public void executeCommand(Command command) {
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

    public void rotate(Command command) {
        if(command.equals(Command.RIGHT)) {
            testrefactor(EAST, SOUTH, WEST, NORTH);
        } else if (command.equals(Command.LEFT)) {
            testrefactor((Orientation) WEST, (Orientation) NORTH, (Orientation) EAST, (Orientation) SOUTH);
        }
    }

    private void testrefactor(Orientation east, Orientation south, Orientation west, Orientation north) {
        switch (geographicPosition.getOrientation()) {
            case NORTH:
                geographicPosition.setOrientation(east);
                break;
            case EAST:
                geographicPosition.setOrientation(south);
                break;
            case SOUTH:
                geographicPosition.setOrientation(west);
                break;
            case WEST:
                geographicPosition.setOrientation(north);
                break;
        }
    }

//    public void turnLeft() {
//        switch (this.orientation) {
//            case NORTH :
//                break;
//        }
//    }
}
