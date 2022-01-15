import karelthecarpeter.*;
import static karelthecarpeter.Direction.*;

class MazeStripperCloneMastery extends GPSCarpeter {
    
    public MazeStripperCloneMastery(World w, int latitude, int longitude, Direction direction, javafx.scene.paint.Color c) {
        super(w, latitude, longitude, direction, 0, c);
    }
    
    private void checkSides() {
        if (leftIsClear()) {
            MazeStripperCloneMastery leftSweeper = new MazeStripperCloneMastery(getWorld(), getLatitude(), getLongitude(), getDirection(), new javafx.scene.paint.Color(Math.random(), Math.random(), Math.random(), 1.0));
            leftSweeper.turnLeft();
            leftSweeper.clearMaze();
        }
        if (rightIsClear()) {
            MazeStripperCloneMastery rightSweeper = new MazeStripperCloneMastery(getWorld(), getLatitude(), getLongitude(), getDirection(), new javafx.scene.paint.Color(Math.random(), Math.random(), Math.random(), 1.0));
            rightSweeper.turnRight();
            rightSweeper.clearMaze();
        }
    }
    
    private void stripRugs() {
        while (onRug()) {
            pickupRug();
        }
    }
    
    public void clearMaze() {
        while (frontIsClear()) {
            stripRugs();
            checkSides();
            if (frontIsClear()) {
                move();
            }
        }
        stripRugs();
        checkSides();
    }
}
