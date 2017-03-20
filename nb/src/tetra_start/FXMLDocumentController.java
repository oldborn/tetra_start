/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetra_start;

import java.awt.Point;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author topcus
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    TilePane tilePane;

    Point point = new Point(0, 1);

    Random random = new Random();

    private boolean isFastModeOn = false;
    
    private long interval = 600;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for (int i = 0; i < 210; i++) {
            Rectangle rectangle = new Rectangle(30, 30);
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLACK);
            tilePane.getChildren().add(rectangle);
        }

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Loop(), 0,interval);

    }

    
    public class Loop extends TimerTask{

        @Override
        public void run() {
            getRekt(point.x, point.y).setFill(Color.WHITE);

            if (point.x != 20) {
                point.x++;
            }

            //point.y = point.y + (random.nextBoolean() ? 1 : -1);

            if (point.y < 0) {
                point.y = 0;
            } else if (point.y > 9) {
                point.y = 9;
            }
            //System.out.println("Game loop!");

            getRekt(point.x, point.y).setFill(Color.RED);
            if(point.x == 20){
                point = new Point(0, 1);
            }
            this.cancel();
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new Loop(), interval,interval);
        }
    
    }
    
    TimerTask loop = new TimerTask() {

        @Override
        public void run() {
            getRekt(point.x, point.y).setFill(Color.WHITE);

            if (point.x != 20) {
                point.x++;
            }

            //point.y = point.y + (random.nextBoolean() ? 1 : -1);

            if (point.y < 0) {
                point.y = 0;
            } else if (point.y > 9) {
                point.y = 9;
            }
            //System.out.println("Game loop!");

            getRekt(point.x, point.y).setFill(Color.RED);
            if(point.x == 20){
                point = new Point(0, 1);
            }
        }
    };

    public Rectangle getRekt(int i, int j) {
        Rectangle rect = (Rectangle) tilePane.getChildren().get(j + i * 10);

        return rect;
    }
    
    @FXML
    public void keyHandler(KeyEvent event){
        keyPressed(event.getCode());
    };
    
    public void keyPressed(KeyCode code) {
        if (code.equals(KeyCode.RIGHT) || code.equals(KeyCode.LEFT)) {
            getRekt(point.x, point.y).setFill(Color.WHITE);
            switch (code) {
                case RIGHT:
                    point.y++;
                    break;
                case LEFT:
                    point.y--;
                    break;
            }
            
             if (point.y < 0) {
                point.y = 0;
            } else if (point.y > 9) {
                point.y = 9;
            }
             getRekt(point.x, point.y).setFill(Color.RED);
        }
        
        if(code.equals(KeyCode.SPACE)){
            interval = 100;
        }
    }

    void keyReleased(KeyCode code) {
        interval = 600;
    }

}
