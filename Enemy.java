package Scripts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Enemy {
    Game game;
    int x;
    int y;
    int xa=0;
    int ya =0;
    int speed;
    int inicialX=800;
    int inicialY=600;
    int rangeX=300;
    int rangeY=300;
    String state;
    public Color color;
    public boolean isActive;
    public boolean seen;
    public boolean collisionX=false;
    public boolean collisionY=false;
    
    
    public Enemy(Game _game, int _x, int _y){
        game = _game;
        state = "idle";
        speed=1;
        color = Color.black;
        isActive = true;
        seen=false;
        x=_x;
        y=_y;
        inicialX = x;
        inicialY = y;
    }
    
    
    double wait3=1.5;
    boolean waitTres=false;
    public void paint (Graphics2D g){
        
        g.setColor(color);
        g.fillRect(x-game.CamX, y-game.CamY, 64, 64);
        state();
        if(collisionLight()&&game.p1.lightOn){
            waitTres=true;
            color = Color.red;
        }
        if(wait3<0){
            seen=true;
        }
        if(waitTres)
            wait3-=0.02;
       
    }
    
    void state(){
        
       if(isActive){
        
        if(game.p1.lightOn&&seen){
           state="chase";
           chase();
           color=Color.red;
          
        }
        if(seen&&game.p1.lightOn==false)
            color=Color.blue;
       }
        attack();
        
    }

    boolean tryY=false;
    boolean notYUp=false;
     boolean notYDown=false;
    
    void chase(){
        if(isActive) {
           
            
            if(game.p1.positionX-x<0&&tryY==false){
                xa=-speed;
            }
            if(game.p1.positionX-x>0&&tryY==false)
                xa=speed;
            if(game.p1.positionX-x==0)
                xa=0;
            if(collisionX==true)
                xa=0;
     
            if(game.p1.positionX==x||tryY==true){
                if(game.p1.positionY-y<0){
                    ya=-speed;
                    if(tryY==true&&notYDown==false)
                        ya-=2;
                }
                    
                if(game.p1.positionY-y>0){
                    ya=speed;
                    if(tryY==true&&notYUp==false)
                        ya+=2;
                }
                if(game.p1.positionY-y==0)
                    ya=0;
               
            } 
            if(game.p1.positionX!=x&&tryY==false)
                ya=0;
              
            tryY=false;    
           
            game.checkWallCollision();
            x+=xa;  
            y+=ya; 
        }
    }      
        
    void attack(){
        if(collisionPlayer()){
            isActive=false;
            game.isGameOver=true;
            color = Color.red;
        }
    }
    private boolean collisionPlayer(){
        
        return game.p1.getBoundsPlayer().intersects(getBounds());
        
    }
    
     private boolean collisionLight(){
        
        return game.p1.getBoundsLight().intersects(getBounds());
        
    }
    
    public void gameOver(){
        x = inicialX;
        y = inicialY;
        isActive=true;
        color = Color.black;
        wait3=5;
        waitTres=false;
        seen=false;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x+(-game.CamX), y+(-game.CamY), 64, 64);
    }
    
}
