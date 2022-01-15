import karelthecarpeter.*;
import static karelthecarpeter.Direction.*;
import static javafx.scene.paint.Color.*;
import java.io.*;

class MazeStripperMastery {
    public static void main(String[] args) {
        File worldFile = new File("Maze2.kwld");
        World w = new World(worldFile); 
        MazeStripperCloneMastery karel = new MazeStripperCloneMastery(w, 1, 10, NORTH, BLUE);
        karel.clearMaze();
    }
}
