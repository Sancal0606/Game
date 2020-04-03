package Scripts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {

    Player p1 = new Player(this,64,256);
    Bateria bateria = new Bateria(this);
    
    public static int tiempo=20;
   
    Wall wall1 = new Wall(this,128,0,64,64); 
    Wall wall2= new Wall(this,192,0,64,64); 
    Wall wall3 = new Wall(this,256,0,64,64);
    Wall wall4 = new Wall(this,320,0,64,64);   
    Wall wall5 = new Wall(this,384,0,64,64);
    Wall wall6 = new Wall(this,448,0,64,64); 
    Wall wall7 = new Wall(this,512,0,64,64); 
    Wall wall8 = new Wall(this,576,0,64,64); 
    Wall wall9 = new Wall(this,640,0,64,64); 
    Wall wall10 = new Wall(this,704,0,64,64); 
    Wall wall11 = new Wall(this,768,0,64,64);
    Wall wall12 = new Wall(this,128,64,64,64);
    Wall wall13 = new Wall(this,384,64,64,64);
    Wall wall14 = new Wall(this,896,64,64,64);   
    Wall wall15 = new Wall(this,128,128,64,64);
    Wall wall16 = new Wall(this,256,128,64,64);
    Wall wall17 = new Wall(this,640,128,64,64);
    Wall wall18 = new Wall(this,704,128,64,64);
    Wall wall19 = new Wall(this,768,128,64,64);  
    Wall wall20 = new Wall(this,0,192,64,64);
    Wall wall21 = new Wall(this,64,192,64,64);
    Wall wall22 = new Wall(this,128,192,64,64);
    Wall wall23 = new Wall(this,384,192,64,64);
    Wall wall24 = new Wall(this,640,192,64,64);
    Wall wall25 = new Wall(this,0,256,64,64);
    Wall wall26 = new Wall(this,256,256,64,64); 
    Wall wall27 = new Wall(this,384,256,64,64); 
    Wall wall28 = new Wall(this,448,256,64,64);
    Wall wall29 = new Wall(this,512,256,64,64);   
    Wall wall30 = new Wall(this,576,256,64,64);
    Wall wall31 = new Wall(this,640,256,64,64); 
    Wall wall32 = new Wall(this,0,320,64,64); 
    Wall wall33 = new Wall(this,64,320,64,64); 
    Wall wall34 = new Wall(this,256,320,64,64); 
    Wall wall35 = new Wall(this,384,320,64,64); 
    Wall wall36 = new Wall(this,448,320,64,64);
    Wall wall37 = new Wall(this,64,384,64,64);
    Wall wall38 = new Wall(this,128,384,64,64);
    Wall wall39 = new Wall(this,448,384,64,64);   
    Wall wall40 = new Wall(this,128,448,64,64);
    Wall wall41 = new Wall(this,192,448,64,64);
    Wall wall42 = new Wall(this,256,448,64,64);
    Wall wall43 = new Wall(this,320,448,64,64);
    Wall wall44 = new Wall(this,384,448,64,64);  
    Wall wall45 = new Wall(this,448,448,64,64);
     
    Pilas pila = new Pilas(this,256,64);
    
    Trampa trampa = new Trampa(this,192,256);
    Trampa trampa2 = new Trampa(this,512,64);
    Trampa trampa3 = new Trampa(this,512,128);
    
    Enemy enemy = new Enemy (this,384,384);
    Enemy enemy2 = new Enemy(this,704,64);
    
      int CamX=0;
    int CamY=0;
   
    
    public boolean isGameOver=false;
   
    public int getTiempo(){
        return tiempo;
    }
    
    public Game(){
        isGameOver=false;
        addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e){
               
           }
           @Override
           public void keyReleased(KeyEvent e){
               p1.keyReleased(e);
           }
           @Override
           public void keyPressed(KeyEvent e){
               p1.keyPressed(e);
           }
        });
        setFocusable(true);
    }
    int a=1;
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
	g2d.setColor(Color.white);
        wall1.paint(g2d);
        wall2.paint(g2d);
        wall3.paint(g2d);
        wall4.paint(g2d);
        wall5.paint(g2d);
        wall6.paint(g2d);
        wall7.paint(g2d);
        wall8.paint(g2d);
        wall9.paint(g2d);
        wall10.paint(g2d);
        wall11.paint(g2d);
        wall12.paint(g2d);
        wall13.paint(g2d);
        wall14.paint(g2d);
        wall15.paint(g2d);
        wall16.paint(g2d);
        wall17.paint(g2d);
        wall18.paint(g2d);
        wall19.paint(g2d);
        wall20.paint(g2d);
        wall21.paint(g2d);
        wall22.paint(g2d);
        wall23.paint(g2d);
        wall24.paint(g2d);
        wall25.paint(g2d);
        wall26.paint(g2d);
        wall27.paint(g2d);
        wall28.paint(g2d);
        wall29.paint(g2d);
        wall30.paint(g2d);
        wall31.paint(g2d);
        wall32.paint(g2d);
        wall33.paint(g2d);
        wall34.paint(g2d);
        wall35.paint(g2d);
        wall36.paint(g2d);
        wall37.paint(g2d);
        wall38.paint(g2d);
        wall39.paint(g2d);
        wall40.paint(g2d);
        wall41.paint(g2d);
        wall42.paint(g2d);
        wall43.paint(g2d);
        wall44.paint(g2d);
        wall45.paint(g2d);
        
        bateria.paint(g2d);
        
        enemy.paint(g2d);
        enemy2.paint(g2d);
        
        trampa.paint(g2d);
        trampa2.paint(g2d);
        trampa3.paint(g2d);
        
        p1.paint(g2d);
        
        pila.paint(g2d);
        
    }
    float waitGameOver=5;
    
    public void gameOver(){
        
       
        if(isGameOver){
            
            p1.canMove=false;
             waitGameOver-=0.02;
            if(waitGameOver<=0){
                CamX=0;
                CamY=0;
                p1.gameOver();
                bateria.gameOver();
                pila.gameOver();
                waitGameOver=5;
                enemy.gameOver();
                enemy2.gameOver();
                isGameOver=false;
            }
        }
        
    }
    
    private void move(){
        p1.move();
        bateria.countdown();
        gameOver();
    }
    
    void checkCollision(){
       wall1.checkCollision();
       wall2.checkCollision();
       wall3.checkCollision();
       wall4.checkCollision();
       wall5.checkCollision();
       wall6.checkCollision();
       wall7.checkCollision();
       wall8.checkCollision(); 
       wall9.checkCollision();
       wall10.checkCollision();
       wall11.checkCollision();
       wall12.checkCollision();
       wall13.checkCollision();
       wall14.checkCollision();
       wall15.checkCollision();
       wall16.checkCollision();
       wall17.checkCollision();
       wall18.checkCollision();
       wall19.checkCollision();
       wall20.checkCollision();
       wall21.checkCollision();
       wall22.checkCollision();
       wall23.checkCollision();
       wall24.checkCollision();
       wall25.checkCollision();
       wall26.checkCollision();
       wall27.checkCollision();
       wall28.checkCollision(); 
       wall29.checkCollision();
       wall30.checkCollision();
       wall31.checkCollision();
       wall32.checkCollision();
       wall33.checkCollision();
       wall34.checkCollision();
       wall35.checkCollision();
       wall36.checkCollision();
       wall37.checkCollision();
       wall38.checkCollision();
       wall39.checkCollision();
       wall40.checkCollision();
       wall41.checkCollision();
       wall42.checkCollision();
       wall43.checkCollision();
       wall44.checkCollision();
       wall45.checkCollision();
    }
    
    public void checkWallCollision(){
        wall1.enemyWall();
        wall2.enemyWall();
        wall8.enemyWall();
        wall4.enemyWall();
        wall5.enemyWall();
        wall6.enemyWall();
        wall9.enemyWall();
        wall10.enemyWall();
        wall11.enemyWall();
        wall12.enemyWall();
        wall13.enemyWall();
        wall14.enemyWall();
        wall15.enemyWall();
        wall16.enemyWall();
        wall17.enemyWall();
        wall18.enemyWall();
        wall19.enemyWall();
        wall20.enemyWall();
        wall21.enemyWall();
        wall22.enemyWall();
        wall23.enemyWall();
        wall24.enemyWall();
        wall25.enemyWall();
        wall26.enemyWall();
        wall27.enemyWall();
        wall28.enemyWall();
        wall29.enemyWall();
        wall30.enemyWall();
        wall31.enemyWall();
        wall32.enemyWall();
        wall33.enemyWall();
        wall34.enemyWall();
        wall35.enemyWall();
        wall36.enemyWall();
        wall37.enemyWall();
        wall38.enemyWall();
        wall39.enemyWall();
        wall40.enemyWall();
        wall41.enemyWall();
        wall42.enemyWall();
        wall43.enemyWall();
        wall44.enemyWall();
        wall45.enemyWall();
        
    }
 
    
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Game");
        Game game = new Game();
        frame.add(game);
        frame.setSize(966, 669);
        
        frame.setResizable(false);
        game.setBackground(Color.black);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true){
            game.repaint();
            game.move();
            Thread.sleep(20);
            
        }
    }
}