package Scripts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pilas {
    Game game;
    int radius = 50;
    Color color;
    public boolean isActive=true;
    int posX;
    int posY;
    
    public Pilas(Game _game, int _posX, int _posY){
        game = _game;
        posX = _posX;
        posY = _posY;
    }
    
    public void paint(Graphics2D g){
      if(isActive){
        if(collisionLight()&&game.p1.lightOn){
         color = Color.green;
       }
       else{
           color = Color.black;
       }
       g.setColor(color);
       g.fillOval(posX+7-game.CamX, posY+7-game.CamY, radius, radius);
       checkCollision();
      }
    }
    
    void checkCollision(){
        if(collisionPlayer()){
            game.bateria.countdown+=(game.bateria.numeroInicial*.25);
            isActive=false;
            color=Color.green;
            game.p1.pila=true;
        }
    }
    
    public void gameOver(){
        isActive = true;
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle(posX-game.CamX, posY-game.CamY, radius, radius);    
    }
    
    private boolean collisionLight(){
        return game.p1.getBoundsLight().intersects(getBounds());
    }
    
    private boolean collisionPlayer(){
        return game.p1.getBoundsPlayer().intersects(getBounds());
    }
}
