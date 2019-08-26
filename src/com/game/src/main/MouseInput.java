package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

public class MouseInput implements MouseListener {
	
	Game game;	
	public boolean karar = false;
	public static char oyuncu = 'X';
	public static char kazanan;
	static int x = 0;
	static int o = 0;
	public MouseInput(Game game) {
		this.game = game;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();	
		
		 
		
		
		
		//============== X için=======================		
		
		if(isKarar()==false) {
			
		//1.satýr//
		if (mx>=0 && mx<=200 && my>=0 && my<=200 && game.arraylist[0][0] != 'O' ) 	{		
		game.arraylist[0][0] = 'X';     setKarar(true);          }
		if (mx>=200 && mx<=400 && my>=0 && my<=200 && game.arraylist[0][1] != 'O' ) {		
		game.arraylist[0][1] = 'X';   setKarar(true);              }
		if (mx>=400 && mx<=600 && my>=0 && my<=200 &&  game.arraylist[0][2] != 'O') {		
		game.arraylist[0][2] = 'X';     setKarar(true);            }
		//2.satýr//	
		if (mx>=0 && mx<=200 && my>=200 && my<=400 && game.arraylist[1][0] != 'O') {		
		game.arraylist[1][0] = 'X';    setKarar(true);             }
		if (mx>=200 && mx<=400 && my>=200 && my<=400 &&  game.arraylist[1][1] != 'O') { 		
		game.arraylist[1][1] = 'X';     setKarar(true);              }
		if (mx>=400 && mx<=600 && my>=200 && my<=400 && game.arraylist[1][2] != 'O') {		
		game.arraylist[1][2] = 'X';    setKarar(true);               }
		//3.satýr//
		if (mx>=0 && mx<=200 && my>=400 && my<=600 && game.arraylist[2][0] != 'O')   {			
		game.arraylist[2][0] = 'X';    setKarar(true);               }
		if (mx>=200 && mx<=400 && my>=400 && my<=600 && game.arraylist[2][1] != 'O') {			
		game.arraylist[2][1] = 'X';     setKarar(true);              }
		if (mx>=400 && mx<=600 && my>=400 && my<=600 && game.arraylist[2][2] != 'O') {			
		game.arraylist[2][2] = 'X';     setKarar(true);              }		
		}
		
		/* if(game.arraylist[0][0]=='X')
			   setKarar(true);
		   if(game.arraylist[0][1]=='X')
			   setKarar(true);
		   if(game.arraylist[0][2]=='X')
			   setKarar(true);
		   if(game.arraylist[1][0]=='X')
			   setKarar(true);
		   if(game.arraylist[1][1]=='X')
			   setKarar(true);
		   if(game.arraylist[1][2]=='X')
			   setKarar(true);
		   if(game.arraylist[2][0]=='X')
			   setKarar(true);
		   if(game.arraylist[2][1]=='X')
			   setKarar(true);
		   if(game.arraylist[2][2]=='X')
			   setKarar(true);         */
		
		
		
		//============== O için=======================	
		
		if(isKarar()==true) {
		
		//1.satýr//
		if (mx>=0 && mx<=200 && my>=0 && my<=200 && game.arraylist[0][0] != 'X' ) 	{				
		game.arraylist[0][0] = 'O';   setKarar(false);             }
		if (mx>=200 && mx<=400 && my>=0 && my<=200 && game.arraylist[0][1] != 'X' ) {				
		game.arraylist[0][1] = 'O';     setKarar(false);            }
		if (mx>=400 && mx<=600 && my>=0 && my<=200 && game.arraylist[0][2] != 'X') {				
		game.arraylist[0][2] = 'O';   setKarar(false);              }
		//2.satýr//	
		if (mx>=0 && mx<=200 && my>=200 && my<=400 && game.arraylist[1][0] != 'X') {				
		game.arraylist[1][0] = 'O';   setKarar(false);              }
		if (mx>=200 && mx<=400 && my>=200 && my<=400 && game.arraylist[1][1] != 'X') {				
		game.arraylist[1][1] = 'O';   setKarar(false);                }
		if (mx>=400 && mx<=600 && my>=200 && my<=400 && game.arraylist[1][2] != 'X') {				
		game.arraylist[1][2] = 'O';   setKarar(false);                }
		//3.satýr//
		if (mx>=0 && mx<=200 && my>=400 && my<=600 && game.arraylist[2][0] != 'X')   {					
		game.arraylist[2][0] = 'O';    setKarar(false);               }
		if (mx>=200 && mx<=400 && my>=400 && my<=600 && game.arraylist[2][1] != 'X') {				
		game.arraylist[2][1] = 'O';    setKarar(false);               }
		if (mx>=400 && mx<=600 && my>=400 && my<=600 && game.arraylist[2][2] != 'X') {					
		game.arraylist[2][2] = 'O';    setKarar(false);               }
		
		}
		
		
		
		
		
		
		/* if(game.arraylist[0][0]=='O')
			   setKarar(false);
		   if(game.arraylist[0][1]=='O')
			   setKarar(false);
		   if(game.arraylist[0][2]=='O')
			   setKarar(false);
		   if(game.arraylist[1][0]=='O')
			   setKarar(false);
		   if(game.arraylist[1][1]=='O')
			   setKarar(false);
		   if(game.arraylist[1][2]=='O')
			   setKarar(false);
		   if(game.arraylist[2][0]=='O')
			   setKarar(false);
		   if(game.arraylist[2][1]=='O')
			   setKarar(false);
		   if(game.arraylist[2][2]=='O')
			   setKarar(false);  */
		
		
		   
		   
		   	 /*System.out.println(game.arraylist[0][0]);
		     System.out.println(game.arraylist[0][1]);
		     System.out.println(game.arraylist[0][2]);
		     System.out.println(game.arraylist[1][0]);
		     System.out.println(game.arraylist[1][1]);
		     System.out.println(game.arraylist[1][2]);
		     System.out.println(game.arraylist[2][0]);
		     System.out.println(game.arraylist[2][1]);
		     System.out.println(game.arraylist[2][2]);*/
		
		
		if(isKarar()==true) {
			oyuncu ='O';
			    }
		if(isKarar()==false) {
			oyuncu='X';
			}
		      
		 System.out.println(isKarar());
		 
		 if(mx>=491 && mx<=580 && my>=631 && my<=669) {
			     game. hboya = 0;
			     game.vboya = 0;
			     game.solboya = 0;
			     game.saðboya = 0;
			     game.round++;			     
			     game.arraylist[0][0] = 'a';
			     game.arraylist[0][1] = 'b';
			     game.arraylist[0][2] = 'c';
			     game.arraylist[1][0] = 'd';
			     game.arraylist[1][1] = 'e';
			     game.arraylist[1][2] = 'f';
			     game.arraylist[2][0] = 'g';
			     game.arraylist[2][1] = 'h';
			     game.arraylist[2][2] = 'ý';			     
			     if(game.winx==true) {
			     JOptionPane.showMessageDialog(null, "Roundu Kazanan Oyuncu: "+kazanan, "KAZANAN !", 1);
			     if(kazanan=='X') {
			    	 x++;
			     }else if (kazanan=='O') {
			    	 o++;
			     }  }			     
			     if(game.winx==false)
		    	 JOptionPane.showMessageDialog(null, "Roundu Kazanan Oyuncu Yok", "BERABERE !", 1);
		 }
		
		
				
		
	System.out.println("mx: "+mx+"my: "+my);
		game.winx = false;

		
	}
	
	
	
	
	
	
	
	
	 
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public boolean isKarar() {
		return karar;
	}
	public void setKarar(boolean karar) {
		this.karar = karar;
	}
	

	

	
	
	
	
	

}
