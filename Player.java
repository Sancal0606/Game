package Scripts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {
    private Game game;
    public int horzMove=0;
    public int vertMove=0;
    public int positionX=300;
    public int positionY=10;
    public int speed;
    public boolean couldMove=true;
    int inicialX;
    int inicialY;
    
    public Image actualSprite;
    private Image sprite00;
    private Image sprite01;
    private Image sprite02;
    private Image sprite03;
    private Image sprite04;
    public int spriteSizeX;
    public int spriteSizeY;    
    
    private int addX=0;
    private int addY=64;
    public int col=1;
    
    public boolean lightOn = false;
    public boolean pila = true;
    public int dirHorzLight=0;
    public int dirVertLight = 0;
    
    boolean canMove=true;
    
    
    public Player (Game _game, int _x, int _y){
        this.game = _game;
        positionX = _x;
        positionY = _y;
        inicialX = _x;
        inicialY = _y;
        speed = 2;
        loadSprite();
    }
    
    private void loadSprite(){
        
        ImageIcon i0 = new ImageIcon("src/Images/Player0.0.png");
        ImageIcon i1 = new ImageIcon("src/Images/Player0.1.png");
        ImageIcon i2 = new ImageIcon("src/Images/Player0.2.png");
        ImageIcon i3 = new ImageIcon("src/Images/Player0.3.png");
        ImageIcon i4 = new ImageIcon("src/Images/Player0.4.png");
    
        sprite00= i0.getImage();
        sprite01 = i1.getImage();
        sprite02 = i2.getImage();
        sprite03 = i3.getImage();
        sprite04 = i4.getImage();
        
        actualSprite = sprite01;
        spriteSizeX = actualSprite.getWidth(game);
        spriteSizeY= actualSprite.getHeight(game);
    }
    
    public void move(){
        game.checkCollision();
        if(positionX+(horzMove)>0&&positionX+horzMove+54<game.getWidth()&&positionY+vertMove>0&&positionY+vertMove+54<game.getHeight()&&canMove){
            positionX= positionX+ horzMove;
            game.CamY+=vertMove;
            game.CamX+=horzMove;
            positionY=positionY+ vertMove;   
        }
      
    }
    
    public void keyReleased(KeyEvent e){
        horzMove=0;
        vertMove=0;
        dirHorzLight=0;
        dirVertLight = 0;
    }
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_A)
            horzMove=-speed;
        if(e.getKeyCode()==KeyEvent.VK_D)
            horzMove=speed;
        if(e.getKeyCode()==KeyEvent.VK_W)
            vertMove=-speed;
        if(e.getKeyCode()==KeyEvent.VK_S)
            vertMove=speed;
        if(e.getKeyCode()==KeyEvent.VK_SHIFT&&pila&&canMove){
            lightOn=!lightOn;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            dirVertLight = 1;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            dirVertLight = -1;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            dirHorzLight = 1;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            dirHorzLight = -1;
        }
    }
    
    private void getDirection(){
        if(dirHorzLight==1){
            actualSprite=sprite04;
            addX=64;
            addY=0;
        }
        if(dirHorzLight==-1){
            actualSprite=sprite02;
            addX= -64;
            addY=0;
        }
        if(dirVertLight==1){
            actualSprite = sprite01;
            addY = 64;
            addX=0;
        }
        if(dirVertLight==-1){
            actualSprite= sprite03;
            addY = -64;
            addX=0;
        }
        if(dirVertLight==0&&dirHorzLight==0){
            actualSprite = sprite00;
            
        }
        if(dirVertLight==1&& dirHorzLight==1){
            addX=48;
            addY=48;
        }
        if(dirVertLight==1&&dirHorzLight==-1){
            addX=-48;
            addY=48;
        }
        if(dirVertLight==-1&&dirHorzLight==1){
            addX=48;
            addY=-48;
        }
        if(dirVertLight==-1&&dirHorzLight==-1){
            addX=-48;
            addY=-48;
        }
    }
    
    public int getPositionX(){
        return positionX;
    }
    
    public int getPositionY(){
        return positionY;
    }
    
    public void gameOver(){
        positionX =inicialX;
        positionY = inicialY;
        lightOn = false;
        pila=true;
        canMove=true;
    }

    public void paint(Graphics2D g){
       getDirection();
      
       
        
       
        g.drawImage(actualSprite,positionX-game.CamX,positionY-game.CamY,null);
        g.setColor(Color.yellow);
        
        if(lightOn)
            g.fillOval(positionX+addX-game.CamX, positionY+addY-game.CamY, 64, 64);
        
    }
    
    public Rectangle getBoundsLight() {
        return new Rectangle(positionX+addX-game.CamX, positionY+addY-game.CamY, 54, 54);
    }
    
    public Rectangle getBoundsPlayer() {
        return new Rectangle(positionX+12-game.CamX, positionY+12-game.CamY,40, 40);
    }
    
}
