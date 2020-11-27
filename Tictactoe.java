package tictactoe;

//all the imports
import java.awt.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.util.Random;


import java.awt.event.*;
//the class that holds the game and the J objects
public class Tictactoe extends JFrame {
	private static final long serialVersionUID = 1L;
	//all the declarations of the objects and components all variable used in the tictactoe class and the drawingboard class
	//J objects
	JButton play,match;
	JCheckBox playX,playO;
	JPanel west,westNorth,westCenter,south,southCenter,westNorthCenter,westSouthCenter;
	JLabel wins,turnXO;
	JRadioButton PVC,PVP,aiX,aiO;
	//variables
	boolean xturn,oturn;
	ButtonGroup group1,group2;
	int turn;
	boolean jNewG;
	boolean newG;
	int Owins=0;
	int Xwins=0;
	boolean player=true;
	int aiXO=2;
	Font times=new Font("Times new roman",Font.BOLD,48); 
	Font times1=new Font("Times new roman",Font.BOLD,20); 
	//main class
	public static void main(String[]args){

		new Tictactoe();
	}
	//adding all the components and objects
	public Tictactoe(){
		//sets the setting of the JFRAME
		this.setSize(800,800);
		this.setLocation(40,40);
		this.setResizable(false);
		this.setTitle("TicTacToe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new DrawingBoard(), BorderLayout.CENTER);
		//Radiobuttons deciding whether its player vs computer or player vs player and adds an action listener to each
		PVC=choiceXO("Player v.s Computer",true);
		PVP=choiceXO("Player v.s Player",false);
		aiX=playXO("Ai as X",false);
		aiO=playXO("Ai as O",true);
		//creates the new buttons for new match and new game and adds an action listener to each
		match=makeMeButtons1("New Match");
		play=makeMeButtons("New Game");
		//creates a Jlabel to show whose turn it is
		turnXO=new JLabel("Press New Game",null,JLabel.CENTER);
		//adds buttons to a group
		group1=new ButtonGroup();
		group1.add(PVC);
		group1.add(PVP);
		
		group2=new ButtonGroup();
		group2.add(aiX);
		group2.add(aiO);
		//player v.s computer is default
		PVC.setSelected(true);
		//creates JPanels where the components are going to placed
		westNorthCenter=new JPanel();
		westSouthCenter=new JPanel();
		west=new JPanel();
		westNorth=new JPanel();
		westCenter=new JPanel();
		south=new JPanel();
		southCenter=new JPanel();
		//creates jlabel to show wins
		wins=new JLabel("0||0",null,JLabel.CENTER);
		//sets font
		wins.setFont(times);
		turnXO.setFont(times1);
		//creates a new layout
		westNorthCenter.setLayout (new BorderLayout ());
		westCenter.setLayout (new BorderLayout ());
		westSouthCenter.setLayout (new BorderLayout ());
		west.setLayout (new BorderLayout ());
		westNorth.setLayout (new BorderLayout ());
		south.setLayout (new BorderLayout ());
		southCenter.setLayout (new BorderLayout ());
		westCenter.add(westNorthCenter,BorderLayout.NORTH);
		westNorthCenter.add(PVC,BorderLayout.NORTH);
		westNorthCenter.add(PVP,BorderLayout.CENTER);
		westSouthCenter.add(aiX,BorderLayout.SOUTH);
		westSouthCenter.add(aiO,BorderLayout.CENTER);
		west.add(westNorth,BorderLayout.NORTH);
		west.add(westCenter,BorderLayout.CENTER);
		west.add(westSouthCenter,BorderLayout.SOUTH);
		westNorth.add(play, BorderLayout.NORTH);
		westNorth.add(match,BorderLayout.CENTER);
		south.add(southCenter,BorderLayout.CENTER);
		southCenter.add(wins, BorderLayout.NORTH);
		southCenter.add(turnXO, BorderLayout.WEST);
		this.add(west,BorderLayout.WEST);
		this.add(south,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	public JButton makeMeButtons(String name){

		JButton theBut = new JButton(name);


		theBut.addActionListener(new ActionListener() {

 

			public void actionPerformed(ActionEvent e) {
				jNewG=true;
				if(player){
					turn=1;
					newG=true;
					repaint();
					turnXO.setText("Your Turn");
					xturn=true;
					oturn=false;
				}
				else{
					turn=1;
					newG=true;
					repaint();
					turnXO.setText("X's Turn");
					xturn=true;
					oturn=false;
				}
				




			}

		});



		return theBut; 

	}
	public JButton makeMeButtons1(String name){

		JButton theBut2 = new JButton(name);


		theBut2.addActionListener(new ActionListener() {



			public void actionPerformed(ActionEvent e) {

				Xwins=0;
				Owins=0;
				wins.setText("0||0");




			}

		});



		return theBut2; 

	}
	public JRadioButton playXO(String name,final boolean XorO){
		boolean click;
		if(XorO){
			click=true;
		}
		else{
			click=false;
		}
		JRadioButton theRadio= new JRadioButton(name,click);


		theRadio.addActionListener(new ActionListener() {



			public void actionPerformed(ActionEvent e) {
				if(newG){
					newG=false;
					turnXO.setText("Press new game to play with new ai");
					if(XorO){
						aiXO=2;
					}
					else{
						aiXO=1;
					}
				}
				else{
					if(XorO){
						aiXO=2;
					}
					else{
						aiXO=1;
					}
				}

			}

		});



		return theRadio; 

	}
	
	public JRadioButton choiceXO(String name,final boolean XorO){
		boolean click;
		if(XorO){
			click=true;
		}
		else{
			click=false;
		}
		JRadioButton theRadio= new JRadioButton(name,click);


		theRadio.addActionListener(new ActionListener() {



			public void actionPerformed(ActionEvent e) {
				if(newG){
					newG=false;
					turnXO.setText("Press new game to play new mode");
					if(XorO){
						player=true;
					}
					else{
						player=false;
					}
				}
				else{
					if(XorO){
						player=true;
					}
					else{
						player=false;
					}
				}

			}

		});



		return theRadio; 

	}
	class DrawingBoard extends JComponent {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int x,x1,x2;
		int y,y1,y2;
		int xP;
		int yP;
		int arrayXO[][]=new int[3][3];
		int patterns1[]=new int[8];
		int patterns2[]=new int[8];
		
		                     
		int r2;
		/*pattern[0-2] is rows
		 * pattern[3-5]is columns
		 *pattern[6-7]is diagonal 
		 * 
		 */
		int ax1,ax,ay,ay1;
		Random rand = new Random();
		boolean moveO=true;
		boolean choice=true;
		boolean Xtru;
		boolean Otru;
		boolean choice2,choice3;
		int s,r;
		int pax,pay;

		public DrawingBoard(){
			zeroPattern();
			
			this.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e)
				{
					if(newG){
						x=e.getX();
						y=e.getY();
						if(x>0&&x<600&&y>0&&y<600){
							x1=x/200;
							y1=y/200;

							if (arrayXO[x1][y1]==0){
								if(xturn){
									arrayXO[x1][y1]=1;
									turn+=1;
									repaint();
									if(checkWins(1,arrayXO)) {
										Xwins++;
										newG=false;
										turnXO.setText("X Won");
									}
									else changeTurn();
								}
								else if(oturn){
									arrayXO[x1][y1]=2;
									turn+=1;
									repaint();
									if(checkWins(2,arrayXO)) {
										Owins++;
										newG=false;
										turnXO.setText("O Won");
									}
									else changeTurn();

								}
							}
						}


					}}});



		}
		
		public void changeTurn() {
			if(turn==9) {
				newG=false;
				turnXO.setText("Tied");
			}
			else {
				if(oturn){
	
					turnXO.setText("X's Turn");
					xturn=true;
					oturn=false;
					if(aiXO==1&&player) {
						ai(1);
						turnXO.setText("Your Turn");
					}
				}
				
				else if(xturn){
					turnXO.setText("O's Turn");
					xturn=false;
					oturn=true;
					if(aiXO==2&&player) {
						ai(2);
						turnXO.setText("Your Turn");
					}
				}
			}
		}
		void ai(int p) {
			int[][] array=new int[3][3];
			array=copyArray(arrayXO);
			int x=100,y=100;
			int bestScore=-10000;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++) {
					if(arrayXO[i][j]==0) {
						int temp=bestMove(array,i,j,1000,p);
						array=copyArray(arrayXO);
						//System.out.println(temp);
						if(temp>bestScore) {
							bestScore=temp;
							x=i;
							y=j;
						}
					}
				}
			}
			arrayXO[x][y]=p;
			repaint();
			if(checkWins(aiXO,arrayXO)) {
				newG=false;
				turnXO.setText("Ai Won");
			}
			else {
				turn++;
				changeTurn();
			}
		}
		
		 int[][] copyArray(int[][] arrayXO2) {
			 int array[][]=new int[3][3];
			 for(int i=0;i<3;i++) {
				 for(int j=0;j<3;j++) {
						array[i][j]=arrayXO2[i][j];
				 }
			 }
			 return array;
		}

		public int bestMove(int[][] array,int x,int y,int n,int p) {
			
			int score=0;
			array[x][y]=p;
			if(checkWins(p,array)) {
				return n;
			}
			int i=0;
			int j=0;
			while(j<3){
				if(array[i][j]==0) {
					if(p==1) {
						if(p==aiXO)n=n*-1;
						else n=(n/10)*-1;
						score+=bestMove(array,i,j,n,2);
					}
					else if(p==2) {
						if(p==aiXO)n=n*-1;
						else n=n/10*-1;
						score+=bestMove(array,i,j,n,1);
					}
				}
				i++;
				if(i>2) {
					i=0;
					j++;		
				}
			}
			return score;
		}
		public void drawO(Graphics g){
			for(int x=0;x<3;x++) {
				for(int y=0;y<3;y++) {
					if(arrayXO[x][y]==2) {
						Graphics2D g2d = (Graphics2D)g;
						g2d.setStroke(new BasicStroke(15, BasicStroke.CAP_ROUND,
								BasicStroke.JOIN_ROUND));
						g2d.setColor(Color.BLUE);
						g2d.drawOval((x*200)+15,(y*200)+15,170,170);
					}
				}
			}
		}
		
		public boolean checkWins(int p,int[][] array) {
			for(int x=0;x<3;x++) {
				if(array[x][0]==p&&array[x][1]==p&&array[x][2]==p)return true;
			}
			for(int y=0;y<3;y++) {
				if(array[0][y]==p&&array[1][y]==p&&array[2][y]==p)return true;
			}
			if(array[0][0]==p&&array[1][1]==p&&array[2][2]==p)return true;
			if(array[2][0]==p&&array[1][1]==p&&array[0][2]==p)return true;
			return false;
		}
		
		public void grid(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_ROUND));
			int c;
			for (c=0;c<=600;c=c+200){
				if(c==0){
					c=2;
				}
				g2d.drawLine(c, 0, c, 600);
				if(c==2){
					c=0;
				}
			}
			for (c=0;c<=600;c=c+200){
				if(c==0){
					c=2;
				}
				g2d.drawLine(0, c, 600, c);
				if(c==2){
					c=0;
				}
			}
		}
		
		public void drawX(Graphics g){
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(arrayXO[i][j]==1) {
						x=i*200;
						y=j*200;
						Graphics2D g2d = (Graphics2D)g;
						g2d.setStroke(new BasicStroke(15, BasicStroke.CAP_ROUND,
							BasicStroke.JOIN_ROUND));
						g2d.setColor(Color.RED);
						g2d.drawLine(x+20, y+20,x+180,y+180);
						g2d.drawLine(x+180, y+20, x+20, y+180);
					}
				}
			}

		}
		
		
		public void zeroPattern(){

			for(int s=0;s<3;s++){
				for(int i=0;i<3;i++){
					arrayXO[s][i]=0;
				}
			}
			turn=0;

		}
		

		public void paint(Graphics g){
			if(jNewG){
				zeroPattern();
				jNewG=false;
				if(aiXO==1) {
					ai(1);
				}
			}
			super.paintComponent(g);    
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 600, 600);
			g.setColor(Color.BLACK);
			grid(g);
			drawO(g);
			drawX(g);

		}




	}
}


