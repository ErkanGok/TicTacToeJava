package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class DrawingView {
	
	Game game;
	MouseInput mouse;
	char oyuncu='X';
	
	
	public  DrawingView(Game game,MouseInput mouse) {
		this.game = game;
		this.mouse = mouse;
		this.oyuncu = mouse.oyuncu;
		
	}	
	  private BufferedImage image; 	 
	    
	    public BufferedImage loadImage(String path) throws IOException {
	    
	        image = ImageIO.read(getClass().getResource(path));
	        
	        return image;        
	    }
	    
	    //==========================================
	    
	   
	    
	    //==========================================
	    
	   
	    
	    //==========================================
	    
	    public void backround(Graphics g) {	    
	    	
	    	 g.drawImage(game.getBackround(), 0 , 0 ,game.getWidth(), game.getHeight(), null);	    	 
	    	 
	    	//horizantalboyama
	    	if (game.hboya == 1) {
	    	 g.setColor(Color.green);
	    	 g.fillRect(0, 0, 650, 203); }
	    	if (game.hboya == 2) {
		     g.setColor(Color.green);		     
		     g.fillRect(0, 203, 650, 203); }
	    	if (game.hboya == 3) {
		     g.setColor(Color.green);		    	
		     g.fillRect(0, 403, 650, 203);}
	    	//vertical boyama
	    	if (game.vboya == 4) {
		    	 g.setColor(Color.green);
		    	 g.fillRect(0, 0, 203, 608); }
		    if (game.vboya == 5) {
			     g.setColor(Color.green);			        
			     g.fillRect(199, 0, 210, 608); }
		    if (game.vboya == 6) {
			     g.setColor(Color.green);			    	 
			     g.fillRect(400, 0, 210, 608);}
		    	//diagonal boyama
		    if(game.solboya==7)	 {
			     g.setColor(Color.green);			    	 
			     g.fillRect(0, 0, 210, 208);
			     g.fillRect(200, 200, 210, 208);
			     g.fillRect(400, 400, 210, 208);
			     				  }
		    if(game.saðboya==8)	 {
			     g.setColor(Color.green);			    	 
			     g.fillRect(400, 0, 210, 208);
			     g.fillRect(200, 200, 210, 208);
			     g.fillRect(0, 400, 210, 208);			     
			     				  }
		    
		  
		    
		    
	    }
	    
	    public void playerx(Graphics g) {
	    	
	    	
	    	//1.satýr//
	    	if(game.arraylist[0][0] == 'X') {
	    	 g.drawImage(game.getPlayerx(), 0 , 0 ,200,200, null);	
	    	                   }
	    	if(game.arraylist[0][1] == 'X') {
		    g.drawImage(game.getPlayerx(), 200 , 0 ,200,200, null);
		                       }
	    	if(game.arraylist[0][2] == 'X') {
			g.drawImage(game.getPlayerx(), 400 , 0 ,200,200, null);
			                   }
	    	//2.satýr//
	    	if(game.arraylist[1][0] == 'X') { 
		    g.drawImage(game.getPlayerx(), 0 , 200 ,200,200, null);
		                      }
		    if(game.arraylist[1][1] == 'X') {
			g.drawImage(game.getPlayerx(), 200 , 200 ,200,200, null);
			                    }
		    if(game.arraylist[1][2] == 'X') {
		    g.drawImage(game.getPlayerx(), 400 , 200 ,200,200, null);
		                      }
		    //3.satýr//
		    if(game.arraylist[2][0] == 'X') {
			g.drawImage(game.getPlayerx(), 0 , 400 ,200,200, null);
			                 }
			if(game.arraylist[2][1] == 'X') { 
		    g.drawImage(game.getPlayerx(), 200 , 400 ,200,200, null);
		                     }
			if(game.arraylist[2][2] == 'X') {
			g.drawImage(game.getPlayerx(), 400 , 400 ,200,200, null);
			                   }
			
			
		
		   
	    }
	    
	    public void playero(Graphics g) {    	
	    	
	    	//1.satýr//
	    	if(game.arraylist[0][0] == 'O') { 
	    	 g.drawImage(game.getPlayero(), 0 , 0 ,200,200, null);
	    	                  }
	    	if(game.arraylist[0][1] == 'O') {
		    g.drawImage(game.getPlayero(), 200 , 0 ,200,200, null);
		                        }
	    	if(game.arraylist[0][2] == 'O') {
			g.drawImage(game.getPlayero(), 400 , 0 ,200,200, null);
			                    }
	    	//2.satýr//
	    	if(game.arraylist[1][0] == 'O') {
		    g.drawImage(game.getPlayero(), 0 , 200 ,200,200, null);
		                       }
		    if(game.arraylist[1][1] == 'O') {
			g.drawImage(game.getPlayero(), 200 , 200 ,200,200, null);
			                    }
		    if(game.arraylist[1][2] == 'O') {
		    g.drawImage(game.getPlayero(), 400 , 200 ,200,200, null);
		                        }
		    //3.satýr//
		    if(game.arraylist[2][0] == 'O') {
			g.drawImage(game.getPlayero(), 0 , 400 ,200,200, null);
			                     }
			if(game.arraylist[2][1] == 'O') {
		    g.drawImage(game.getPlayero(), 200 , 400 ,200,200, null);
		                        }
			if(game.arraylist[2][2] == 'O') {
			g.drawImage(game.getPlayero(), 400 , 400 ,200,200, null);
			                  }		
			
			
			  
	    	
	    }
	    
	    
	    
	   
	    
	  
	    
	   

		
	    
	    

}
