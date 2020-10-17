package school;

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
	JPanel west,westNorth,westCenter,south,southCenter,westNorthCenter;
	JLabel wins,turnXO;
	JRadioButton PVC,PVP;
	//variables
	boolean xturn,oturn;
	ButtonGroup group1,group2;
	int turn;
	boolean jNewG;
	boolean newG;
	int Owins=0;
	int Xwins=0;
	boolean playerX=true;
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
		//creates the new buttons for new match and new game and adds an action listener to each
		match=makeMeButtons1("New Match");
		play=makeMeButtons("New Game");
		//creates a Jlabel to show whose turn it is
		turnXO=new JLabel("Press New Game",null,JLabel.CENTER);
		//adds buttons to a group
		group1=new ButtonGroup();
		group1.add(PVC);
		group1.add(PVP);
		//player v.s computer is default
		PVC.setSelected(true);
		//creates JPanels where the components are going to placed
		westNorthCenter=new JPanel();
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
		west.setLayout (new BorderLayout ());
		westNorth.setLayout (new BorderLayout ());
		south.setLayout (new BorderLayout ());
		southCenter.setLayout (new BorderLayout ());
		westCenter.add(westNorthCenter,BorderLayout.NORTH);
		westNorthCenter.add(PVC,BorderLayout.NORTH);
		westNorthCenter.add(PVP,BorderLayout.CENTER);
		west.add(westNorth,BorderLayout.NORTH);
		west.add(westCenter,BorderLayout.CENTER);
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
				if(playerX){
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
						playerX=true;
					}
					else{
						playerX=false;
					}
				}
				else{
					if(XorO){
						playerX=true;
					}
					else{
						playerX=false;
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
		int ax,ax1;
		int ay,ay1;
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
		Random rand = new Random();
		boolean moveO=true;
		boolean choice=true;
		boolean Xtru;
		boolean Ytru;
		boolean choice2,choice3;
		int s,r;
		int pax,pay;

		public DrawingBoard(){
			zeroPatternX();

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
									x2=x1*200;
									y2=y1*200;
									Xtru=true;
									turn+=1;
									repaint(0,x1*200,y1*200,200,200);
								}
								else if(oturn){
									arrayXO[x1][y1]=1;
									ax1=x1;
									ay1=y1;
									Ytru=true;
									turn+=1;
									repaint(0,x1*200,y1*200,200,200);

								}
							}
						}


					}}});



		}
		public void AiO1(){
			//first checks if it can win
			if(playerX){
				moveO=true;
				for(s=0;s<8;s++){
					if(moveO){
						if(patterns2[s]==11){
							if(s==0||s==1||s==2){
								ax=0;
								ay=s;
								if(arrayXO[ax][ay]==0){
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);


								}

							}
							else if((s==3||s==4||s==5)){
								ax=s-3;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==6)){
								ax=0;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==7)){
								ax=2;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
						}
						else if(patterns2[s]==101){
							if(s==0||s==1||s==2){
								ax=1;
								ay=s;
								if(arrayXO[ax][ay]==0){
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);


								}

							}
							else if((s==3||s==4||s==5)){
								ax=s-3;
								ay=1;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==6)){
								ax=1;
								ay=1;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==7)){
								ax=1;
								ay=1;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
						}
						else if(patterns2[s]==110){
							if(s==0||s==1||s==2){
								ax=2;
								ay=s;
								if(arrayXO[ax][ay]==0){
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);


								}

							}
							else if((s==3||s==4||s==5)){
								ax=s-3;
								ay=2;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==6)){
								ax=2;
								ay=2;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==7)){
								ax=0;
								ay=2;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
						}
					}
				}
				for(s=0;s<8;s++){
					if(moveO){
						if(patterns1[s]==11){
							if(s==0||s==1||s==2){
								ax=0;
								ay=s;
								if(arrayXO[ax][ay]==0){
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);


								}

							}
							else if((s==3||s==4||s==5)){
								ax=s-3;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==6)){
								ax=0;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==7)){
								ax=2;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
						}
						else if(patterns1[s]==101){
							if(s==0||s==1||s==2){
								ax=1;
								ay=s;
								if(arrayXO[ax][ay]==0){
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);


								}

							}
							else if((s==3||s==4||s==5)){
								ax=s-3;
								ay=1;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==6)){
								ax=1;
								ay=1;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==7)){
								ax=1;
								ay=1;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
						}
						else if(patterns1[s]==110){
							if(s==0||s==1||s==2){
								ax=2;
								ay=s;
								if(arrayXO[ax][ay]==0){
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);


								}

							}
							else if((s==3||s==4||s==5)){
								ax=s-3;
								ay=2;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==6)){
								ax=2;
								ay=2;
								if(arrayXO[ax][ay]==0){
									System.out.print(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
							else if((s==7)){
								ax=0;
								ay=2;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);

								}
							}
						}
					}
				}
				if(moveO){
					if(turn==2){

						r=rand.nextInt(4)+1;
						if(r==1&&arrayXO[0][0]==0){

							ax=0;
							ay=0;
							arrayXO[ax][ay]=1;
							Ytru=true;
							choice=false;
							moveO=false;
							ax1=ax;
							ay1=ay;
							pax=ax;
							pay=ay;
							repaint(0,ax*200,ay*200,200,200);

						}
						else if(r==2&&arrayXO[2][0]==0){
							ax=2;
							ay=0;
							arrayXO[ax][ay]=1;
							Ytru=true;
							choice=false;
							moveO=false;
							ax1=ax;
							ay1=ay;
							pax=ax;
							pay=ay;
							repaint(0,ax*200,ay*200,200,200);
						}
						else if(r==3&&arrayXO[0][2]==0){
							ax=0;
							ay=2;
							arrayXO[ax][ay]=1;
							Ytru=true;
							choice=false;
							moveO=false;
							ax1=ax;
							ay1=ay;
							pax=ax;
							pay=ay;
							repaint(0,ax*200,ay*200,200,200);
						}
						else if(r==4&&arrayXO[2][2]==0){
							ax=2;
							ay=2;
							arrayXO[ax][ay]=1;
							Ytru=true;
							choice=false;
							moveO=false;
							ax1=ax;
							ay1=ay;
							pax=ax;
							pay=ay;
							repaint(0,ax*200,ay*200,200,200);
						}
					}



					else if(turn==4){
						if((pax==0||pax==2)&&(pay==0||pay==2)){
							if(arrayXO[1][1]==1){
								if(pax==0&&pay==0){
									r=rand.nextInt(2)+1;
									if(r==1){
										ax=2;
										ay=1;
										if(arrayXO[ax][ay]==0){
											System.out.println(true);
											arrayXO[ax][ay]=1;
											Ytru=true;
											moveO=false;
											ax1=ax;
											ay1=ay;
											pax=ax;
											pay=ay;
											repaint(0,ax*200,ay*200,200,200);
										}
									}
									else if(r==2){
										ax=1;
										ay=2;
										if(arrayXO[ax][ay]==0){
											System.out.println(true);
											arrayXO[ax][ay]=1;
											Ytru=true;
											moveO=false;
											ax1=ax;
											ay1=ay;
											pax=ax;
											pay=ay;
											repaint(0,ax*200,ay*200,200,200);
										}
									}

								}
								else if(pax==2&&pay==0){
									r=rand.nextInt(2)+1;
									if(r==1){
										ax=1;
										ay=2;
										if(arrayXO[ax][ay]==0){
											System.out.println(true);
											arrayXO[ax][ay]=1;
											Ytru=true;
											moveO=false;
											ax1=ax;
											ay1=ay;
											pax=ax;
											pay=ay;
											repaint(0,ax*200,ay*200,200,200);
										}
									}
									else if(r==2){
										ax=0;
										ay=1;
										if(arrayXO[ax][ay]==0){
											System.out.println(true);
											arrayXO[ax][ay]=1;
											Ytru=true;
											moveO=false;
											ax1=ax;
											ay1=ay;
											pax=ax;
											pay=ay;
											repaint(0,ax*200,ay*200,200,200);
										}
									}

								}
								else if(pax==0&&pay==2){
									r=rand.nextInt(2)+1;
									if(r==1){
										ax=1;
										ay=0;
										if(arrayXO[ax][ay]==0){
											System.out.println(true);
											arrayXO[ax][ay]=1;
											Ytru=true;
											moveO=false;
											ax1=ax;
											ay1=ay;
											pax=ax;
											pay=ay;
											repaint(0,ax*200,ay*200,200,200);
										}
									}
									else if(r==2){
										ax=2;
										ay=1;
										if(arrayXO[ax][ay]==0){
											System.out.println(true);
											arrayXO[ax][ay]=1;
											Ytru=true;
											moveO=false;
											ax1=ax;
											ay1=ay;
											pax=ax;
											pay=ay;
											repaint(0,ax*200,ay*200,200,200);
										}
									}

								}
								else if(pax==2&&pay==2){
									r=rand.nextInt(2)+1;
									if(r==1){
										ax=1;
										ay=0;
										if(arrayXO[ax][ay]==0){
											System.out.println(true);
											arrayXO[ax][ay]=1;
											Ytru=true;
											moveO=false;
											ax1=ax;
											ay1=ay;
											pax=ax;
											pay=ay;
											repaint(0,ax*200,ay*200,200,200);
										}
									}
									else if(r==2){
										ax=0;
										ay=1;
										if(arrayXO[ax][ay]==0){
											System.out.println(true);
											arrayXO[ax][ay]=1;
											Ytru=true;
											moveO=false;
											ax1=ax;
											ay1=ay;
											pax=ax;
											pay=ay;
											repaint(0,ax*200,ay*200,200,200);
										}
									}

								}


								else if(arrayXO[1][1]==0){
									if(pax==0&&pay==0){
										r=rand.nextInt(2)+1;
										if(r==1){
											ax=2;
											ay=0;
											if(arrayXO[ax][ay]==0){
												System.out.println(true);
												arrayXO[ax][ay]=1;
												Ytru=true;
												moveO=false;
												ax1=ax;
												ay1=ay;
												pax=ax;
												pay=ay;
												repaint(0,ax*200,ay*200,200,200);
											}
										}
										else if(r==2){
											ax=0;
											ay=2;
											if(arrayXO[ax][ay]==0){
												System.out.println(true);
												arrayXO[ax][ay]=1;
												Ytru=true;
												moveO=false;
												ax1=ax;
												ay1=ay;
												pax=ax;
												pay=ay;
												repaint(0,ax*200,ay*200,200,200);
											}
										}

									}
									else if(pax==2&&pay==0){
										r=rand.nextInt(2)+1;
										if(r==1){
											ax=0;
											ay=0;
											if(arrayXO[ax][ay]==0){
												System.out.println(true);
												arrayXO[ax][ay]=1;
												Ytru=true;
												moveO=false;
												ax1=ax;
												ay1=ay;
												pax=ax;
												pay=ay;
												repaint(0,ax*200,ay*200,200,200);
											}
										}
										else if(r==2){
											ax=2;
											ay=2;
											if(arrayXO[ax][ay]==0){
												System.out.println(true);
												arrayXO[ax][ay]=1;
												Ytru=true;
												moveO=false;
												ax1=ax;
												ay1=ay;
												pax=ax;
												pay=ay;
												repaint(0,ax*200,ay*200,200,200);
											}
										}

									}
									else if(pax==0&&pay==2){
										r=rand.nextInt(2)+1;
										if(r==1){
											ax=0;
											ay=2;
											if(arrayXO[ax][ay]==0){
												System.out.println(true);
												arrayXO[ax][ay]=1;
												Ytru=true;
												moveO=false;
												ax1=ax;
												ay1=ay;
												pax=ax;
												pay=ay;
												repaint(0,ax*200,ay*200,200,200);
											}
										}
										else if(r==2){
											ax=2;
											ay=2;
											if(arrayXO[ax][ay]==0){
												System.out.println(true);
												arrayXO[ax][ay]=1;
												Ytru=true;
												moveO=false;
												ax1=ax;
												ay1=ay;
												pax=ax;
												pay=ay;
												repaint(0,ax*200,ay*200,200,200);
											}
										}

									}
									else if(pax==2&&pay==2){
										r=rand.nextInt(2)+1;
										if(r==1){
											ax=2;
											ay=0;
											if(arrayXO[ax][ay]==0){
												System.out.println(true);
												arrayXO[ax][ay]=1;
												Ytru=true;
												moveO=false;
												ax1=ax;
												ay1=ay;
												pax=ax;
												pay=ay;
												repaint(0,ax*200,ay*200,200,200);
											}
										}
										else if(r==2){
											ax=0;
											ay=2;
											if(arrayXO[ax][ay]==0){
												System.out.println(true);
												arrayXO[ax][ay]=1;
												Ytru=true;
												moveO=false;
												ax1=ax;
												ay1=ay;
												pax=ax;
												pay=ay;
												repaint(0,ax*200,ay*200,200,200);
											}
										}
									}
								}

							}
						}
					}
					else if(turn==6){
						if(pax==1&&pay==0){
							if(arrayXO[0][2]==1){
								ax=0;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);
								}
							}
							else if(arrayXO[2][2]==1){
								ax=2;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);
								}
							}
						}
						else if(pax==0&&pay==1){
							if(arrayXO[2][0]==1){
								ax=0;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);
								}
							}
							else if(arrayXO[2][2]==1){
								ax=0;
								ay=2;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);
								}
							}
						}
						else if(pax==2&&pay==1){
							if(arrayXO[0][0]==1){
								ax=2;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);
								}
							}
							else if(arrayXO[0][2]==1){
								ax=2;
								ay=2;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);
								}
							}
						}
						else if(pax==1&&pay==2){
							if(arrayXO[0][0]==1){
								ax=0;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);
								}
							}
							else if(arrayXO[0][2]==1){
								ax=2;
								ay=0;
								if(arrayXO[ax][ay]==0){
									System.out.println(true);
									arrayXO[ax][ay]=1;
									Ytru=true;
									moveO=false;
									ax1=ax;
									ay1=ay;
									pax=ax;
									pay=ay;
									repaint(0,ax*200,ay*200,200,200);
								}
							}
						}
					}
				}
				while(moveO&&turn!=10){
					ax=rand.nextInt(3)+0;
					ay=rand.nextInt(3)+0;
					System.out.println(ax+" "+ay);
					if(arrayXO[ax][ay]==0){
						System.out.println(true);
						arrayXO[ax][ay]=1;
						Ytru=true;
						moveO=false;
						ax1=ax;
						ay1=ay;
						pax=ax;
						pay=ay;
						repaint(0,ax*200,ay*200,200,200);
					}
				}
				moveO=true;
				if(moveO){
					turn+=1;
				}








				patternsO();
			}

		}
		public void drawO(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(15, BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_ROUND));
			g2d.setColor(Color.BLUE);
			g2d.drawOval((ax1*200)+15,(ay1*200)+15,170,170);
			if(playerX==false){
				patternsO();
				if(newG){
					turnXO.setText("X's Turn");
				}
				xturn=true;
				oturn=false;
			}

		}
		public void patternsO(){

			if(ax1==0&&ay==0){
				patterns2[0]+=100;
				patterns2[3]+=100;
				patterns2[6]+=100;

			}
			if(ax1==1&&ay1==0){
				patterns2[0]+=10;
				patterns2[4]+=100;


			}
			if(ax1==2&&ay1==0){
				patterns2[0]+=1;
				patterns2[5]+=100;
				patterns2[7]+=100;

			}
			if(ax1==0&&ay1==1){
				patterns2[1]+=100;
				patterns2[3]+=10;


			}
			if(ax1==1&&ay1==1){
				patterns2[1]+=10;
				patterns2[4]+=10;
				patterns2[6]+=10;
				patterns2[7]+=10;


			}
			if(ax1==2&&ay1==1){
				patterns2[1]+=1;
				patterns2[5]+=10;


			}
			if(ax1==0&&ay1==2){
				patterns2[2]+=100;
				patterns2[3]+=1;
				patterns2[7]+=1;

			}
			if(ax1==1&&ay1==2){
				patterns2[2]+=10;
				patterns2[4]+=1;

			}
			if(ax1==2&&ay1==2){
				patterns2[2]+=1;
				patterns2[5]+=1;
				patterns2[6]+=1;

			}
			for(s=0;s<8;s++){
				if(patterns2[s]==111){
					System.out.println("O wins "+s);
					newG=false;
					Owins+=1;
					wins.setText(Xwins+"||"+Owins);
					turnXO.setText("O wins/Press new game to continue");
					zeroPatternX();


				}

			}

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
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(15, BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_ROUND));
			g2d.setColor(Color.RED);
			g2d.drawLine(x2+20, y2+20,x2+180,y2+180);
			g2d.drawLine(x2+180, y2+20, x2+20, y2+180);
			patternsX();
			if(playerX==false){
				if(newG){
					turnXO.setText("O's Turn");
				}
				xturn=false;
				oturn=true;
			}

		}
		public void zeroPatternX(){

			for(int s=0;s<8;s++){
				patterns1[s]=0;
				patterns2[s]=0;
			}
			for(int s=0;s<3;s++){
				for(int i=0;i<3;i++){
					arrayXO[s][i]=0;
				}
			}

		}
		public void patternsX(){

			if(x1==0&&y1==0){
				patterns1[0]+=100;
				patterns1[3]+=100;
				patterns1[6]+=100;

			}
			if(x1==1&&y1==0){
				patterns1[0]+=10;
				patterns1[4]+=100;


			}
			if(x1==2&&y1==0){
				patterns1[0]+=1;
				patterns1[5]+=100;
				patterns1[7]+=100;

			}
			if(x1==0&&y1==1){
				patterns1[1]+=100;
				patterns1[3]+=10;


			}
			if(x1==1&&y1==1){
				patterns1[1]+=10;
				patterns1[4]+=10;
				patterns1[6]+=10;
				patterns1[7]+=10;


			}
			if(x1==2&&y1==1){
				patterns1[1]+=1;
				patterns1[5]+=10;


			}
			if(x1==0&&y1==2){
				patterns1[2]+=100;
				patterns1[3]+=1;
				patterns1[7]+=1;

			}
			if(x1==1&&y1==2){
				patterns1[2]+=10;
				patterns1[4]+=1;


			}
			if(x1==2&&y1==2){
				patterns1[2]+=1;
				patterns1[5]+=1;
				patterns1[6]+=1;

			}
			for(s=0;s<8;s++){
				if(patterns1[s]==111){
					System.out.println("X wins "+s);
					newG=false;
					Xwins+=1;
					wins.setText(Xwins+"||"+Owins);
					turnXO.setText("X wins/Press new game to continue");
					zeroPatternX();


				}       
			}

			if(turn==10&&newG){

				turnXO.setText("Draw/Press new game to continue");
				newG=false;
			}

			if(newG&&playerX){
				AiO1();
			}
		}

		public void paint(Graphics g){
			if(jNewG){
				zeroPatternX();
				jNewG=false;
			}
			super.paintComponent(g);    
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 600, 600);
			g.setColor(Color.BLACK);
			grid(g);
			if(turn==1){
				zeroPatternX();
			}
			if(Xtru){
				Xtru=false;
				drawX(g);


			}
			else if(Ytru){
				Ytru=false;
				drawO(g);



			}

		}




	}
}


