package rover.models;

import rover.exceptions.OutOfBoundariesException;

public class GeographicPosition {
    private int actualX;
    private int actualY;
    private final int maximumX;
    private final int maximumY;

    private Orientation orientation;

    public GeographicPosition(int maximumX, int maximumY) {
        this.actualX = 0;
        this.actualY = 0;
        this.maximumX = maximumX;
        this.maximumY = maximumY;
    }

    public void setActualX(int actualX) {
        if(actualX > maximumX || actualY < 0)
            throw new OutOfBoundariesException("Actual X position is out of the defined maximum X position.");
        this.actualX = actualX;
    }

    public void setActualY(int actualY) {
        if(actualY > maximumY || actualY < 0)
            throw new OutOfBoundariesException("Actual Y position is out of the defined maximum Y position.");
        this.actualY = actualY;
    }

    public void incrementY() {
        setActualY(getActualY()+1);
    }

    public void incrementX() {
        setActualX(getActualX()+1);
    }

    public void decrementY() {
        setActualY(getActualY()-1);
    }

    public void decrementX() {
        setActualX(getActualX()-1);
    }

    public int getActualX() {
        return actualX;
    }

    public int getActualY() {
        return actualY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
