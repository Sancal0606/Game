package Scripts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trampa {
    Game game;
    int posX;
    int posY;
    Color color;
    
    public Trampa(Game _game, int _posX, int _posY){
        game = _game;
        posX = _posX;
        posY = _posY;
    }
    
    public void paint(Graphics2D g){
       
        if(collisionLight()&&game.p1.lightOn){
            color = Color.red;
        }
        else if (!collisionPlayer()&&!collisionEnemy()&&!collisionEnemy2()){
            color = Color.black;
        }
          g.setColor(color);
        g.fillRect(posX-game.CamX, posY-game.CamY, 64, 64);
        collision();
    }
    
    void collision(){
        if(collisionPlayer()){
            color=Color.red;
            game.isGameOver = true;
            game.p1.positionX=posX;
            game.p1.positionY=posY;
        }
        if(collisionEnemy()){
            color = Color.red;
            game.enemy.color = Color.GRAY;
            game.enemy.isActive = false;
            game.enemy.x=posX;
            game.enemy.y = posY;
        }
         if(collisionEnemy2()){
            color = Color.red;
            game.enemy2.color = Color.GRAY;
            game.enemy2.isActive = false;
            game.enemy2.x=posX;
            game.enemy2.y = posY;
        }
    }
    
    private boolean collisionLight(){
        return game.p1.getBoundsLight().intersects(getBoundsTrampa());
    }
    
    private boolean collisionPlayer(){
        return game.p1.getBoundsPlayer().intersects(getBoundsTrampa());
    }
    private boolean collisionEnemy(){
        return game.enemy.getBounds().intersects(getBoundsTrampa());
    }
    
    private boolean collisionEnemy2(){
        return game.enemy2.getBounds().intersects(getBoundsTrampa());
    }
    
    public Rectangle getBoundsTrampa(){
        return new Rectangle(posX+14-game.CamX, posY+14-game.CamY, 50, 50);
    }
}
