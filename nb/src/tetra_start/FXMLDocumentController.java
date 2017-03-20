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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for(int i = 0; i < 210; i++){
                Rectangle rectangle = new Rectangle(30, 30);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                tilePane.getChildren().add(rectangle);
        }
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(loop, 0, 200);
        
    }
    
    TimerTask loop = new TimerTask() {
        
        
        @Override
        public void run() {
            getRekt(point.x, point.y).setFill(Color.WHITE);
            
            if(point.x != 20)
                point.x++;
            
            point.y = point.y + (random.nextBoolean() ? 1 : -1);
            
            if(point.y < 0){
                point.y = 0;
            }else if(point.y >9){
                point.y = 9;
            }
            System.out.println("Game loop!");
            
            
            getRekt(point.x, point.y).setFill(Color.RED);
            
        }
    };

    public Rectangle getRekt(int i, int j){
        Rectangle rect = (Rectangle) tilePane.getChildren().get(j+i*10);

        return rect;
    }    
    
}
