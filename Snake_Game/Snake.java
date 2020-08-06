import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Demo extends JFrame
{
	Home h;
	static int points=0,maxPoints=0;
	// Board b;
	Demo()
	{

		h=new Home(points,maxPoints);
		h.setSize(1300,1000);
		add(h);
	}
	
}



class Home extends JPanel implements ActionListener
{
	
	JButton b1,b2;
	Board b;
	Details d;
	int points;
	int maxPoints;
	Home(int points,int maxPoints)
	{
		
		this.points=points;
		this.maxPoints=maxPoints;
		setLayout(null);
		d=new Details(points,maxPoints,this);
		d.setLocation(0,0);
		add(d);
		b=new Board(d,points,maxPoints);
		b.setLocation(300,0);
		add(b);
	}
	public void actionPerformed(ActionEvent e)
	{

		// b=new Board(d,points,maxPoints);
		// b.setLocation(300,0);
		// add(b);
			b.reset();
	
		
	}
}
class Details extends JPanel
{
	JLabel name,player,score,high_score,score1,high_score1;
	JButton reset;
	JLabel l1,l2;
	Font f1,f2,f3;
	ImageIcon icon,icon1,icon2,icon3;
	Image pic,round;
	String player_name;
	Details(int points,int maxPoints,Home h)
	{
		player_name = (String)JOptionPane.showInputDialog(
					   this,
					   "Enter player name", 
					   "Snake game",            
					   JOptionPane.PLAIN_MESSAGE,
					   null,            
					   null, 
					   null
					);
				// System.out.println(result);
		
		JOptionPane.showMessageDialog(this,"\npress Space to: PLAY/PAUSE\npress direction Keys to move\n");
		// icon=new ImageIcon("new5.gif");
		// icon=new ImageIcon("1111111snake.gif");
		icon=new ImageIcon("my.gif");
		icon1=new ImageIcon("round.gif");
		icon2=new ImageIcon("new11.gif");
		pic=icon.getImage();
		
		
		round=icon1.getImage();
		setSize(300,1000);
		f1=new Font("Stencil",Font.BOLD,35);
		// f1=new Font("Pristina",Font.BOLD,35);
		f2=new Font("forte",Font.BOLD,35);
		f3=new Font("Stencil",Font.BOLD,45);
		setLayout(null);
		
		JLabel l3=new JLabel(icon1);
		l3.setBounds(0,0,300,300);
		
		// JLabel l4=new JLabel(icon2);
		// l4.setBounds(0,400,300,600);
		
		
		l1=new JLabel("SNaKE-GAmE");
		l1.setForeground(new Color(255,165,0));
		l1.setBounds(0,100,300,100);
		l1.setFont(f3);
		l1.setBackground(Color.black);
		add(l1);
		add(l3);
		
		
		l2=new JLabel(icon);
		l2.setBounds(0,600,300,400);
		add(l2);
		// l1.setText("SNAKE");
		// l1.setForeground(Color.red);
		// l1.setFont(f);
		
		high_score=new JLabel("HIGH SCORE");
		high_score.setFont(f1);
		high_score.setOpaque(true);
		high_score.setBounds(30,320,250,40);
		add(high_score);
			
		high_score1=new JLabel();
		high_score1.setFont(f1);
		high_score1.setText(""+maxPoints);
		high_score1.setOpaque(true);
		high_score1.setBounds(150,360,100,40);
		high_score1.setBackground(Color.red);
		add(high_score1);
		
		score=new JLabel("SCORE");
		score.setFont(f1);
		score.setOpaque(true);
		// score.setText(""+points);
		score.setBounds(60,420,200,40);
		add(score);
		
		score1=new JLabel();
		score1.setFont(f1);
		score1.setOpaque(true);
		score1.setText(""+points);
		// Score1.setAlign(55);
		score1.setBackground(Color.red);
		score1.setBounds(150,460,100,40);
		add(score1);
		
		name=new JLabel(player_name);
		name.setBounds(30,510,200,40);
		name.setFont(f1);
		name.setForeground(new Color(51,187,255));
		name.setOpaque(true);
		add(name);
		
		reset =new JButton("ReseT");
		reset.setFont(f1);
		reset.setBounds(50,580,180,40);
		add(reset);
		// add(l4);
		reset.addActionListener(h);
			reset.setFocusable(false);
		
	}
}
class Board extends JPanel implements ActionListener ,KeyListener
{
	ImageIcon ic1,ic2,ic3,ic4,ic5,ic6;
	Image head,food,body,brick1,brick2,grass;
	
	int[] x=new int[100];
	int[] y=new int[100];
	
	Details d;
	
	int r1=0,r2=0,r3=1;
	
	boolean start_game=false;
	boolean right=true,left=false,up=false,down=false;

	void randomDemo()
	{
		r1=(int)Math.round(Math.random()*44+2);
		r2=(int)Math.round(Math.random()*43+2);
		r1*=20;
		r2*=20;
	}
	
	int dots=5;
	static	int points, maxPoints,time=100;
		
	static Timer t;
	
	Board(Details d ,int points,int maxPoints)
	{
		this.d=d;
		
		
		this.points=points;
		this.maxPoints=maxPoints;
		setSize(1000,1000);
		setBackground(Color.black);
		
		randomDemo();
		// System.out.println("in constructor");
		ic1=new ImageIcon("new1.png");
			head=ic1.getImage();
		
		ic2=new ImageIcon("new.png");
			body=ic2.getImage();
	
		ic3=new ImageIcon("new2.png");
			food=ic3.getImage();
			
		ic4=new ImageIcon("brick.png");	
			brick1=ic4.getImage();
		
		ic5=new ImageIcon("brick1.png");
			brick2=ic5.getImage();
		
		ic6=new ImageIcon("grass2.jpg");
			grass=ic6.getImage();
			
			
	repeat(100);
		// time=100;
	addKeyListener(this);
	setFocusable(true);
		
	x[0]=300;
	y[0]=200;
	x[1]=280;
	y[1]=200;
	x[2]=260;
	y[2]=200;
	x[3]=240;
	y[3]=200;
	x[4]=220;
	y[4]=200;
	
	}
	void repeat(int time)
	{
	t=new Timer(time,this);
	t.start();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
			g.drawImage(grass,0,0,this);
			for(int i=0;i<dots;i++)
			{
				if(i==0)
					g.drawImage(head,x[i],y[i],this);
				else
					g.drawImage(body,x[i],y[i],this);
			}
			g.drawImage(food,r1,r2,this);
			
			g.drawImage(brick1,953,0,this);
			g.drawImage(brick1,0,0,this);
			
			g.drawImage(brick2,0,0,this);
			g.drawImage(brick2,0,936,this);
	
	}
		public void actionPerformed(ActionEvent e)
		{
			
			if(r1 == x[0] && r2 == y[0])
			{
				dots++;
				time=time-10;
				// repeat(time);	
				this.t.stop();
				this.t=new Timer(time,this);
				t.start();
				// t.start();
				randomDemo();
				
				// System.out.println("in condition");
				
				d.score1.setText(""+ ++points);
				
				if(points>maxPoints)
				d.high_score1.setText(""+ ++maxPoints);
					
				repaint();
			}
			if(start_game)
			{
				
				
				for(int  i=dots-1;i>0;i--)
				{
					// System.out.print("\t"+x[0]);
					x[i]=x[i-1];
					y[i]=y[i-1];
				}	
					if(right)
						x[0]+=20;
			   		if(left)
						x[0]-=20;
					if(up)
						y[0]-=20;
					if(down)
						y[0]+=20;
					
							//Boundary conditions
							if(x[0]>=940)
								{
									x[0]=40;
								}
							if(x[0]<40)
								{
									x[0]=940;
								}
							if(y[0]>910)
								{
									y[0]=40;
								}
							if(y[0]<40)
								{
									// y[0]=910;
									y[0]=920;
								}
								
				
					
			}
			for(int p=2;p<dots;p++)
			{
					
					if(x[0]== x[p] && y[0]==y[p])
						{
							start_game=false;
							// if(dots>5)
							dots=5;
							JOptionPane.showMessageDialog(null,"wrong move");
							reset();
							// for(int as=p;as<dots;as++)
							// {
								// x[as]=0;
								// y[as]=0;
							// }
							
							// repaint();
							break;
							// x[0]=80;
							// y[0]=80;
							// right=true;
							// left=false;
							// up=false;
							// down=false;
							// start_game=true;
						}
						
			}
			// int mm=x[0],nn=y[0];
			// if(r1==nn &&r2==nn)
			repaint();
		}
		
		public void keyReleased(KeyEvent e1)
		{
		}
		public void reset()
		{
				x[0]=300;
				y[0]=200;
				x[1]=280;
				y[1]=200;
				x[2]=260;
				y[2]=200;
				x[3]=240;
				y[3]=200;
				x[4]=220;
				y[4]=200;
			dots=5;
			
			this.t.stop();
			time=100;
				this.t=new Timer(100,this);
				t.start();
			
			start_game=false;
			right=true;
			left=false;
			up=false;
			down=false;
			points=0;
			d.score1.setText(""+ points);
			// time=100;
			r3=1;
			randomDemo();
			// System.out.println("in reset");
		}
		
		public void keyPressed(KeyEvent e1)
		{
			if(e1.getKeyCode()==KeyEvent.VK_SPACE)
			{
				if(r3%2!=0)
			start_game=true;
				else
					start_game=false;
				r3++;
			}
			if(!right)
			if(e1.getKeyCode()==KeyEvent.VK_LEFT)
			{
				right=false;
				left=true;
				up=false;
				down=false;
			}
			
			if(!left)
			if(e1.getKeyCode()==KeyEvent.VK_RIGHT)
			{
				right=true;
				left=false;
				up=false;
				down=false;
				
			}
			
			if(!down)
			if(e1.getKeyCode()==KeyEvent.VK_UP)
			{
				right=false;
				left=false;
				down=false;
				up=true;
				
			}
			
			if(!up)
			if(e1.getKeyCode()==KeyEvent.VK_DOWN)
			{
				right=false;
				left=false;
				up=false;
				down=true;
				
			}
		}
		
		public void keyTyped(KeyEvent e1)
		{
			
		}
}
class Snake 
{
	public static void main(String...ar)
	{
		Demo d=new Demo();
		d.setVisible(true);
		d.setBounds(100,0,1300,1000);
		d.setDefaultCloseOperation(d.EXIT_ON_CLOSE);
		d.setResizable(false);
	}
}