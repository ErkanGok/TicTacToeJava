/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.src.main;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.ChangedCharSetException;

/**
 *
 * @author PC
 */
public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;
    public static final int WÝDTH =300;
    public static final int HEÝGHT = 350;
    public static final int SCALE = 2;
    public final String TITLE = "Tic Tac Toe";
    public Rectangle playButton = new Rectangle(490,630,90,40);
    private boolean running = false;
    private Thread thread;
    
    private boolean karar = false;
    public char oyuncu = 'X';
    public int skorx=0;
    public int skoro=0;
    //==========================================
    public int round = 1;
    
    MouseInput mouse = new MouseInput(this);
    DrawingView view = new DrawingView(this,mouse);
   
    private BufferedImage backround = null;       
    private BufferedImage playerx = null;
    private BufferedImage playero = null;
    
    
    public char arraylist[][] = new char[3][3] ;
    public boolean winx = false;
    public boolean wino = false;
    public int hboya = 0;
    public int vboya = 0;
    public int solboya = 0;
    public int saðboya = 0;
    
   
    
    public void init() {
    	 
    	DrawingView view = new DrawingView(this,mouse);    	
    	
    	try {
    		
    		backround = view.loadImage("/backround.png");
    		playerx = view.loadImage("/x.png");
    		playero = view.loadImage("/o.png");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	this.addMouseListener(new MouseInput(this));
    
    	arraylist[0][0] = 'a';
    	arraylist[0][1] = 'b';
    	arraylist[0][2] = 'c';
    	arraylist[1][0] = 'd';
    	arraylist[1][1] = 'e';
    	arraylist[1][2] = 'f';
    	arraylist[2][0] = 'g';
    	arraylist[2][1] = 'h';
    	arraylist[2][2] = 'ý';
    	
    	
    	 /*System.out.println(arraylist[0][0]);
	     System.out.println(arraylist[0][1]);
	     System.out.println(arraylist[0][2]);
	     System.out.println(arraylist[1][0]);
	     System.out.println(arraylist[1][1]);
	     System.out.println(arraylist[1][2]);
	     System.out.println(arraylist[2][0]);
	     System.out.println(arraylist[2][1]);
	     System.out.println(arraylist[2][2]);*/
    	
    	
    	
    	 
    	 
    	
    }
    
    
    //==========================================
    
    private synchronized void start() {
        
        if(running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    //============================================
    
     private synchronized void stop() {
        
        if(!running)
            return;
        
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(1);
    }
     
     //======================================  
    
   public void run() {
       init();
       long lastTime = System.nanoTime();
       final double amountOfTicks = 60.0;
       double ns = 1000000000/amountOfTicks;
       double delta = 0;
       int updates = 0;
       int frames = 0;
       long timer = System.currentTimeMillis();
       
       while(running){     
          long now = System.nanoTime();
          delta += (now - lastTime) /ns;
          lastTime = now;
          
          if(delta >= 1) {
             
              updates++;
              delta--;
          }
          
           render();  
           frames++;
           
           if(System.currentTimeMillis() - timer > 1000) {
               timer+=1000;
               System.out.println(updates + " Ticks , Fps " + frames);
               updates = 0;
               frames = 0;
           
           }
               
       }
       
       
       
       stop();
   
   }
   
   //======================================
   

	   
	   


 
   
   //======================================
   
   public void record() {	
	
	   //horizantal
	   for (int i = 0; i < 3; i++)
	    {		   
	        if (arraylist[i][0] == arraylist[i][1] && arraylist[i][1] == arraylist[i][2]) {        	
	           winx = true;	           
	           if(i==0)
	   	        hboya=1;   
	           if(i==1)
	   	        hboya=2; 
	           if(i==2)
	   	        hboya=3;  
	           
	           mouse.kazanan = arraylist[i][0];
	           																		      }                                                                  
	     }
	        
	  
	       
	    
	    
	   
	   //vertical
	   for (int i = 0; i < 3; i++)
	    {		   
	        if (arraylist[0][i] == arraylist[1][i] && arraylist[1][i] == arraylist[2][i]) {	        
	            winx = true;	         
	           if(i==0)
	    	        vboya=4;   
	    	   if(i==1)
	    	        vboya=5; 
	    	   if(i==2)
	    	        vboya=6; 	
	    	   mouse.kazanan = arraylist[0][i];  }
	    }	   
	  
	   
	   
	   //diagonal
	   if ((arraylist[0][0] == arraylist[1][1] && arraylist[1][1] == arraylist[2][2])) {
	        winx = true;	       
	   		solboya = 7;	
	   	 mouse.kazanan = arraylist[0][0]; }
	   
	   if((arraylist[0][2] == arraylist[1][1] && arraylist[1][1] == arraylist[2][0]))  {
		   winx = true;		   
	   	   saðboya = 8;	   
	   	 mouse.kazanan = arraylist[0][2];}
	   
	   
	  
   }
   
   
   
   //======================================
   
   public void render() {
       
       BufferStrategy bs = this.getBufferStrategy(); 
       if (bs == null) {
           
           createBufferStrategy(3);
           return;
       }
       
       Graphics g = bs.getDrawGraphics();
       ///////////////////////////////////
       record();
      
      
      //System.out.println(winx);
       
    
      
 
   view.backround(g); 
   
  view.playerx(g); 
    
   view.playero(g); 
   
   
   Font fnt1 = new Font("arial",Font.BOLD,20);
		g.setFont(fnt1);
		g.setColor(Color.black);
		g.drawString("Sýradaki Oyuncu: "+mouse.oyuncu, 5, 635);
	
	Font fnt2 = new Font("arial",Font.BOLD,20);
		g.setFont(fnt2);
		g.setColor(Color.red);
		g.drawString("Round: "+round, 255, 635);
		
	Font fnt3 = new Font("arial",Font.BOLD,20);
		g.setFont(fnt3);
		g.setColor(Color.black);
		g.drawString("X: "+mouse.x, 275, 665);
			
	Font fnt4 = new Font("arial",Font.BOLD,20);
		g.setFont(fnt4);
		g.setColor(Color.black);
		g.drawString("O: "+mouse.o, 275, 695);
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.black);
		g.drawString("Clear",playButton.x+19,playButton.y+27);
		g2d.setBackground(Color.black);		
		g2d.draw(playButton);
	 
  
       
       ///////////////////////////////////      
       g.dispose();
       bs.show();
   
   }
   
   //=======================================
   
    public static void main(String[] args) {
    	
        Game game = new Game();
        
        game.setPreferredSize(new Dimension(WÝDTH * SCALE, HEÝGHT * SCALE));
        game.setMaximumSize(new Dimension(WÝDTH * SCALE, HEÝGHT * SCALE));
        game.setMinimumSize(new Dimension(WÝDTH * SCALE, HEÝGHT * SCALE));
        
        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);   
        
       
        game.start();
        
   
         
    }


	public BufferedImage getBackround() {
		return backround;
	}


	public BufferedImage getPlayerx() {
		return playerx;
	}

	public BufferedImage getPlayero() {
		return playero;
	}


	public boolean isKarar() {
		return karar;
	}


	public void setKarar(boolean karar) {
		this.karar = karar;
	}


	public char getOyuncu() {
		return oyuncu;
	}


	public void setOyuncu(char oyuncu) {
		this.oyuncu = oyuncu;
	}
	
	


	
	


    

  
    
    
    
}

