import karelthecarpeter.*;
import static karelthecarpeter.Direction.*;

class GPSCarpeter extends SensibleCarpeter {
    private int street;
    private int avenue;
    private Direction direction;
    private String name;
    private World w;
    
    public GPSCarpeter(World w, int latitude, int longitude, Direction direction, int rugs) {
        super(w, latitude, longitude, direction, rugs);
        this.street = latitude;
        this.avenue = longitude;
        this.direction = direction;
        this.w = w;
    }

    public GPSCarpeter(World w, int latitude, int longitude, Direction direction, int rugs, javafx.scene.paint.Color shirtColor) {
        super(w, latitude, longitude, direction, rugs, shirtColor);
        this.street = latitude;
        this.avenue = longitude;
        this.direction = direction;
        this.w = w;
    }

    public GPSCarpeter(World w, String name, int latitude, int longitude, Direction direction, int rugs) {
        super(w, name, latitude, longitude, direction, rugs);
        this.street = latitude;
        this.avenue = longitude;
        this.direction = direction;
        this.name = name;
        this.w = w;
    }

    public GPSCarpeter(World w, String name, int latitude, int longitude, Direction direction, int rugs, javafx.scene.paint.Color shirtColor) {
        super(w, name, latitude, longitude, direction, rugs, shirtColor);
        this.street = latitude;
        this.avenue = longitude;
        this.direction = direction;
        this.name = name;
        this.w = w;
    }

    public String getName() {
        return this.name;
    }
    
    public World getWorld() {
        return w;
    }
    
    @Override
    public void setName(String newName) {
        this.name = newName;
        super.setName(newName);
    }
    
    public int getLatitude() {
        return street;
    }
    
    public int getLongitude() {
        return avenue;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public void move() {
        if (frontIsClear()) {
            if (facingNorth()) {
                street = street + 1;
            }
            else if (facingSouth()) {
                street = street - 1;
            }
            else if (facingEast()) {
                avenue = avenue + 1;
            }
            else { // facingWest
                avenue = avenue - 1;
            }
            super.move();
        }
    }
    
    public void turnAround() {
        turnLeft();
        turnLeft();
    }
    
    /**
     * Move backward one position. Ends up facing the current direction.
     */
    public void moveBack() {
        turnAround();
        move();
        turnAround();
    }
    
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    @Override
    public void turnLeft() {
        if (direction == NORTH) {
            direction = WEST;
        } else if (direction == SOUTH) {
            direction = EAST;
        } else if (direction == EAST) {
            direction = NORTH;
        } else if (direction == WEST) {
            direction = SOUTH;
        }
        super.turnLeft();
    }
    
    public boolean leftIsClear() {
        turnLeft();
        if (frontIsClear()) {
            turnRight();
            return true;
        } else {
            turnRight();
            return false;
        }
    }
    
    public boolean rightIsClear() {
        turnRight();
        if (frontIsClear()) {
            turnLeft();
            return true;
        } else {
            turnLeft();
            return false;
        }
    }
}
