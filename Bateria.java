package Scripts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Bateria {
    Game game;
    public double countdown;
    public double numeroInicial;
    private int pila;
    
    public Bateria(Game _game){
        game = _game;
        numeroInicial = 240;
        countdown = numeroInicial;
        pila = 4;
    }
    
    void countdown(){
        if(game.p1.lightOn){
            countdown-=0.02;
        }
        if(countdown<=numeroInicial){
           pila=4;
        }
        if(countdown<=(numeroInicial*.75))
            pila=3;
        if(countdown<=(numeroInicial*.50))
            pila=2;
        if(countdown<=(numeroInicial*.25))
            pila=1;
        if(countdown<=(numeroInicial*.0)){
            pila=0;
            game.p1.pila=false;
            game.p1.lightOn =false;
        }
    }
    
    public void gameOver(){
        countdown = numeroInicial;
    }
    
    public void paint(Graphics2D g){
        g.setColor(Color.green);
        g.setFont(new Font("Verdana", Font.BOLD, 30));
        g.drawString(String.valueOf(pila),(game.getWidth()/2)-20,30);
    }
}
