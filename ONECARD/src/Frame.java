
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import java.net.URL;

import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.DataLine;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
@SuppressWarnings("serial")
class Frame extends JFrame{
    AudioFormat format; 
    DataLine.Info info;
    URL soundURL;
	void playSound(boolean LOOP,String filename) {
        try (InputStream in = getClass().getResourceAsStream(filename)) {
            InputStream bufferedIn = new BufferedInputStream(in);
           
            try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn)) {
            	
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
                if(LOOP)clip.loop(-1);
                
            }
        } catch (Exception e) {
           e.printStackTrace();
       }
    }
}

@SuppressWarnings("serial")
class StartFrame extends Frame{
	JTextField pnum;
	ImageIcon icon;
	URL imgURL;
	JPanel down_panel;
	public StartFrame(){
		setTitle("OneCard"); 
		//setSize(500,300);
		setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
		setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-(int)(this.getSize().getWidth()/2),
			(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-(int)(this.getSize().getHeight()/2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(true);
		imgURL=getClass().getClassLoader().getResource("Title.png");
		icon = new ImageIcon(imgURL);
		Image img=icon.getImage();
		img=img.getScaledInstance((int)getSize().getWidth(),(int)getSize().getHeight()-(int)(getSize().getHeight()/10), java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(img);
		 JPanel background = new JPanel() {
	            public void paintComponent(Graphics g) {
	                g.drawImage(icon.getImage(), 0, 0, null);
	                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	                super.paintComponent(g);
	                
	            }
	        };
	    
	    background.setBounds(0,0,(int)this.getSize().getWidth(),(int)(this.getSize().getHeight())-(int)(getSize().getHeight()/10));
	    background.setLayout(null);
	    down_panel=new JPanel(); 
	    JLabel pnum_label=new JLabel("Players?[2~4]: ");
		pnum=new JTextField(1); 
		JButton start_button=new JButton("Start!");
		int down_panel_X=(int)(background.getSize().getWidth()/3)-(int)(background.getSize().getWidth()/9);
		int down_panel_Y=(int)(background.getSize().getHeight()-(int)background.getSize().getHeight()/10);
		int down_panel_width=(int)background.getSize().getWidth()/2;
		int down_panel_height=(int)background.getSize().getHeight()/10;
		down_panel.setBounds(down_panel_X,down_panel_Y,down_panel_width,down_panel_height);
		down_panel.setLayout(new FlowLayout()); 
		down_panel.add(pnum_label);
		down_panel.add(pnum);
		down_panel.add(start_button);
		down_panel.setBackground(new Color(255, 0, 0, 0));   
	    background.add(down_panel);
	   
		add(background);
		
		start_button.addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e) {
				int p=Integer.parseInt(pnum.getText());
				if(2<=p&&p<=4)
				{	dispose();
			
				playSound(false,"start.wav");
					new GameFrame(p);  }
				else{JOptionPane.showMessageDialog(null, "숫자2~4 를 입력해주세요");}}});
		//setUndecorated(true);
		
	   setVisible(true); 
		}
}
@SuppressWarnings("serial")
class GameFrame extends Frame{
	static Boolean myturn=true;
	ImageIcon Img;
	JLabel img;
	static JPanel Center_panel;
	ArrayList<Player> Game_Player=new ArrayList<>();
	static JPanel[] Empty_panel=new JPanel[4]; 
	ArrayList<JPanel> hold_panel=new ArrayList<>();
	int P_no;
	static JLabel cci;
	Game game1;
	static ImageIcon clockwise;
	static ImageIcon counterclockwise;
	static JLabel message;
	static JLabel otherPlayerCardBack;
	static JLabel directionimg;
	public static JButton turnButton;
	URL imgURL;
	ImageIcon Bg;
	protected boolean oc;
	static Dimension GameFrameDim;
	static Dimension CenterPanelDim;
	public GameFrame(int P_no){
		setTitle("OneCard");
		int GameFrame_Width=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3;
		int GameFrame_Height=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/25;
		GameFrameDim=new Dimension(GameFrame_Width,GameFrame_Height); 
		setSize(GameFrameDim);
		//setSize(1015,830);
		setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-(int)(this.getSize().getWidth()/2),
				(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-(int)(this.getSize().getHeight()/2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.P_no=P_no;
		game1=new Game(P_no);
		Game_Player=game1.gamePlayerList();
		setLayout(null);
		basePlayerPanel();
		imgURL=getClass().getClassLoader().getResource("clockwise.png");
		clockwise=new ImageIcon(imgURL);
		imgURL=getClass().getClassLoader().getResource("counterclockwise.png");
		counterclockwise=new ImageIcon(imgURL);
		Image d=clockwise.getImage();
		d=d.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		clockwise=new ImageIcon(d);
		d=counterclockwise.getImage();
		d=d.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		counterclockwise=new ImageIcon(d);
		message=new JLabel("게임 시작.   "+Game_Player.get(game1.turn).player_name+"의 턴입니다.");
		message.setBounds((int)Center_panel.getSize().getWidth()/2-100,(int)Center_panel.getSize().getHeight()/3-30,250,20);
		directionimg=new JLabel(clockwise);
		directionimg.setBounds(0,0,50,50);
		Center_panel.add(directionimg);
		Center_panel.add(message);
		addCenterCardButton();
		addCenterStackCard();
		addNextTurnButton();
		
		for(int i=0;i<game1.player.get(0).Cardholds.size();i++) {
			addPlayerCardButton(Game_Player.get(0).holds,game1.player.get(0).Cardholds.get(i));
		}
		for(int i=1;i<game1.player.size();i++) {
			for(int j=0;j<game1.player.get(i).Cardholds.size();j++) {
				Game_Player.get(i).holds.add(otherPlayerCardBack());
			}
		}
		
		
		setVisible(true); 
		setResizable(false);
		playSound(true,"bgm.wav");
		
	}
public void gameSimulation() {
		Game_Player.get(game1.turn).spot.setBackground(Color.green);
		Game_Player.get(game1.turn).spot.repaint();
		Game_Player.get(game1.turn).spot.revalidate();
		if(game1.gamePlayerList().get(0).fail==false)
		{if(game1.turn!=0) {
	Timer timer1=new Timer();
	TimerTask task1=new TimerTask() {
		@Override
		public void run(){
				for(int i=0;i<game1.gamePlayerList().get(game1.turn).Cardholds.size();i++) {
				game1.playerUse(game1.gamePlayerList().get(game1.turn).Cardholds.get(i)); 
					if(game1.correct==true&&game1.count==false) {Game_Player.get(game1.turn).holds.removeAll();
					cci.setIcon(game1.cs.Cardstack.peek().showCardimg());playSound(false,"putDown.wav");continue;}
					if(game1.correct==true&&game1.count==true) {Game_Player.get(game1.turn).holds.removeAll();
					cci.setIcon(game1.cs.Cardstack.peek().showCardimg());playSound(false,"putDown.wav");break;
					}}
				for(int i=0;i<game1.gamePlayerList().get(game1.turn).Cardholds.size();i++) {
					Game_Player.get(game1.turn).holds.add(otherPlayerCardBack());
				}
				if(game1.End==true) {new ResultFrame(game1.gamePlayerList().get(game1.turn));}
				else {
					if(game1.count==false) {
						playSound(false,"Draw.wav");
						game1.playerDraw();
						if(game1.gamePlayerList().get(game1.turn).fail==false) {
						Game_Player.get(game1.turn).holds.removeAll();
						for(int i=0;i<game1.gamePlayerList().get(game1.turn).Cardholds.size();i++) {
							Game_Player.get(game1.turn).holds.add(otherPlayerCardBack());}
						System.out.println("Player "+(game1.turn+1)+"이 카드를 뽑았습니다. Player"+(game1.turn+1)+"의 총 카드 수"+
							game1.gamePlayerList().get(game1.turn).Cardholds.size());
						System.out.println("카드덱의 남은 카드수: "+game1.cs.Cardbundle.size());}
					}
					if(game1.count==true) {
						System.out.println("Player "+(game1.turn+1)+"이 턴을 마칩니다.");
						Center_panel.repaint();
						Center_panel.revalidate();
						Game_Player.get(game1.turn).spot.setBackground(Color.white);
						Game_Player.get(game1.turn).spot.repaint();
						Game_Player.get(game1.turn).spot.revalidate();
						Game_Player.get(game1.turn).holds.repaint();
						Game_Player.get(game1.turn).holds.revalidate();
						Empty_panel[game1.turn].repaint();
						Empty_panel[game1.turn].revalidate();
						if(Game_Player.get(game1.turn).fail==true) {playSound(false,"bomb.wav");}
						game1.gamePhase();
						if(game1.End==true) {new ResultFrame(game1.gamePlayerList().get(game1.turn));}
						GameFrame.message.setText("플레이어"+(game1.turn+1)+"의 턴입니다.");
						gameSimulation();	
					}
				}
		}
	};
	timer1.schedule(task1,2000);
		}
		else {
			myturn=true;
		}}
		
}
	public void basePlayerPanel() {
		for(int i=0;i<4;i++) {
			Empty_panel[i]=new JPanel();
			Empty_panel[i].setLayout(null);
			Empty_panel[i].setBorder(new LineBorder(Color.black,3,true));
		}
		for(int i=0;i<P_no;i++) {
			Game_Player.get(i).spot=new JPanel();
			Game_Player.get(i).spot.setBackground(Color.white);
			Game_Player.get(i).spot.setLayout(null);
			Game_Player.get(i).spot.setBorder(new LineBorder(Color.black,3,true));
			Game_Player.get(i).holds=new JPanel();
			Game_Player.get(i).holds.setBackground(Color.darkGray);
			Game_Player.get(i).spot.add(Game_Player.get(i).holds);
		}
		Game_Player.get(0).spot.setBackground(Color.green);
		int panel0_X=0;
		int panel0_Y=(int)(this.getSize().getHeight()-this.getSize().getHeight()/4-this.getSize().getHeight()/25);
		int panel0_Width=(int)(this.getSize().getWidth()-this.getSize().getWidth()/5);
		int panel0_Height=(int)this.getSize().getHeight()/4;
		///
		int panel1_X=0;
		int panel1_Y=0;
		int panel1_Width=(int)this.getSize().getWidth()/5;
		int panel1_Height=(int)(this.getSize().getHeight()-this.getSize().getHeight()/4-this.getSize().getHeight()/25);
		///
		int panel2_X=(int)this.getSize().getWidth()/5;
		int panel2_Y=0;
		int panel2_Width=(int)(this.getSize().getWidth()-this.getSize().getWidth()/5);
		int panel2_Height=(int)(this.getSize().getHeight()/4-this.getSize().getHeight()/25);
		///
		int panel3_X=(int)(this.getSize().getWidth()-this.getSize().getWidth()/5);
		int panel3_Y=(int)(this.getSize().getHeight()/4-this.getSize().getHeight()/25);
		int panel3_Width=(int)this.getSize().getWidth()/5;
		int panel3_Height=(int)(this.getSize().getHeight()-this.getSize().getHeight()/4);
		///
		Empty_panel[0].setBounds(panel0_X,panel0_Y,panel0_Width,panel0_Height);
		Empty_panel[1].setBounds(panel1_X,panel1_Y,panel1_Width,panel1_Height);
		Empty_panel[2].setBounds(panel2_X,panel2_Y,panel2_Width,panel2_Height); 
		Empty_panel[3].setBounds(panel3_X,panel3_Y,panel3_Width,panel3_Height); 
		imgURL=getClass().getClassLoader().getResource("CenterBackGround.png");
		Bg=new ImageIcon(imgURL);
		Image img=Bg.getImage();
		img=img.getScaledInstance((int)this.getSize().getWidth(),(int)getSize().getHeight()-(int)(getSize().getHeight()/10), java.awt.Image.SCALE_SMOOTH);
		Bg=new ImageIcon(img);
		Center_panel=new JPanel(){
            public void paintComponent(Graphics g) {
                
                g.drawImage(Bg.getImage(), 0, 0, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };
        int Center_panel_X=(int)this.getSize().getWidth()/5;
        int Center_panel_Y=(int)(this.getSize().getHeight()/4-this.getSize().getHeight()/25);
        int Center_panel_Width=(int)(this.getSize().getWidth()-this.getSize().getWidth()/5-this.getSize().getWidth()/5+3);
        int Center_panel_Height=(int)(this.getSize().getHeight()-this.getSize().getHeight()/4-this.getSize().getHeight()/4);
        CenterPanelDim=new Dimension(Center_panel_Width,Center_panel_Height);
		Center_panel.setLayout(null);
		Center_panel.setBackground(Color.black);
		Center_panel.setBorder(new LineBorder(Color.black,3));
        Center_panel.setBounds(Center_panel_X,Center_panel_Y,Center_panel_Width,Center_panel_Height);
        Game_Player.get(Game_Player.get(0).player_number).spot.setBounds(0,0,(int)Empty_panel[0].getSize().getWidth(),(int)Empty_panel[0].getSize().getHeight());
        Game_Player.get(Game_Player.get(1).player_number).spot.setBounds(0,0,(int)Empty_panel[1].getSize().getWidth(),(int)Empty_panel[1].getSize().getHeight());
        Game_Player.get(Game_Player.get(0).player_number).holds.setBounds((int)Empty_panel[0].getSize().getWidth()/5,3,(int)(Empty_panel[0].getSize().getWidth()-Empty_panel[0].getSize().getWidth()/5),(int)Empty_panel[0].getSize().getHeight()-3);
        Game_Player.get(Game_Player.get(1).player_number).holds.setBounds(3,(int)Empty_panel[1].getSize().getHeight()/4,(int)Empty_panel[1].getSize().getWidth()-6,(int)(Empty_panel[1].getSize().getHeight()-Empty_panel[1].getSize().getHeight()/4));
        if(P_no==2)
		{Empty_panel[2].removeAll();
		Empty_panel[3].removeAll();}
        else if(P_no==3) {
        Game_Player.get(Game_Player.get(2).player_number).spot.setBounds(0,0,(int)Empty_panel[2].getSize().getWidth(),(int)Empty_panel[2].getSize().getHeight());
        Game_Player.get(Game_Player.get(2).player_number).holds.setBounds((int)Empty_panel[2].getSize().getWidth()/5,3,(int)(Empty_panel[2].getSize().getWidth()-Empty_panel[2].getSize().getWidth()/5),(int)Empty_panel[2].getSize().getHeight()-6);
        Empty_panel[3].removeAll();}
        else if(P_no==4) {
        Game_Player.get(Game_Player.get(2).player_number).spot.setBounds(0,0,(int)Empty_panel[2].getSize().getWidth(),(int)Empty_panel[2].getSize().getHeight());
        Game_Player.get(Game_Player.get(2).player_number).holds.setBounds((int)Empty_panel[2].getSize().getWidth()/5,3,(int)(Empty_panel[2].getSize().getWidth()-Empty_panel[2].getSize().getWidth()/5),(int)Empty_panel[2].getSize().getHeight()-6);
        Game_Player.get(Game_Player.get(3).player_number).spot.setBounds(0,0,(int)Empty_panel[3].getSize().getWidth(),(int)Empty_panel[3].getSize().getHeight());
        Game_Player.get(Game_Player.get(3).player_number).holds.setBounds(3,(int)Empty_panel[3].getSize().getHeight()/4,(int)Empty_panel[3].getSize().getWidth()-6,(int)(Empty_panel[3].getSize().getHeight()-Empty_panel[3].getSize().getHeight()/4));}
        setPlayerPanel();
			
		
			add(Empty_panel[0]);
			add(Empty_panel[1]);
			add(Empty_panel[2]);
			add(Empty_panel[3]);
			add(Center_panel);	
		}
	



	public void setPlayerPanel() {
		for(int i=0;i<4;i++) {Empty_panel[i].removeAll();}
		for(int i=0;i<Game_Player.size();i++) {
			JLabel player_name=new JLabel(game1.gamePlayerList().get(i).player_name);
			player_name.setBounds(20,0,60,20);
			Game_Player.get(i).spot.add(player_name);
			Empty_panel[Game_Player.get(i).player_number].add(Game_Player.get(i).spot);}
	}
	public void addCenterCardButton() {
		Card card=new Card();
		JButton CenterCard=new JButton(card.cardbackimg);
		CenterCard.setBounds((int)Center_panel.getSize().getWidth()/2-125,(int)Center_panel.getSize().getHeight()/3,115,150);
		CenterCard.setOpaque(false);
		CenterCard.setBorder(new LineBorder(Color.black,2,true));
		CenterCard.setFocusPainted(false);
		CenterCard.setContentAreaFilled(false);
		CenterCard.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			playSound(false,"Click.wav");
			if(myturn==true) {
			if(game1.count==true) {YOU_CANT_MORE();}
			else {

			message.setText("카드를 뽑습니다.");
			game1.playerDraw();
			playSound(false,"Draw.wav");
			Game_Player.get(0).holds.removeAll();
			for(int i=0;i<game1.gamePlayerList().get(0).Cardholds.size();i++)
			{addPlayerCardButton(Game_Player.get(0).holds,game1.gamePlayerList().get(0).Cardholds.get(i));}
			Game_Player.get(0).holds.repaint();
			Game_Player.get(0).holds.revalidate();
			if(Game_Player.get(0).fail==true) {new FailFrame();}
			}
		} else {NOT_YOUR_TURN(); }
		}});
		Center_panel.add(CenterCard);
	}
	public void addPlayerCardButton(JPanel p,Card c) {
		JButton PlayerCard=new JButton(c.showHoldimg());
		PlayerCard.setPreferredSize(new Dimension((int)(getSize().getWidth()/16-getSize().getWidth()/200), (int)(getSize().getHeight()/8-getSize().getHeight()/100)));
		PlayerCard.setOpaque(false);
		PlayerCard.setFocusPainted(false);
		PlayerCard.setContentAreaFilled(false);
		
		PlayerCard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playSound(false,"Click.wav");
				if(myturn==true) {
				if(game1.count==true) {YOU_CANT_MORE();}
				else {
					message.setText("카드를 냅니다.");
					game1.playerUse(c);
				if(game1.correct==true) {
					playSound(false,"putDown.wav");
				p.remove(PlayerCard);
				cci.setIcon(game1.cs.Cardstack.peek().showCardimg());
				Center_panel.revalidate();
				Center_panel.repaint();
				p.revalidate();
				p.repaint();
				
				if(game1.End==true) {new ResultFrame(game1.gamePlayerList().get(game1.turn));}
				}
				else {
					YOU_CANT_USE();
				}
			}}
				else{NOT_YOUR_TURN();}}
			});
			p.add(PlayerCard);
	}
	public void addOneCardButton() {
		JButton OneCardButton=new JButton("원카드");
		OneCardButton.setBounds((int)Center_panel.getSize().getWidth()/100,
				(int)(Center_panel.getSize().getHeight()-Center_panel.getSize().getHeight()/5-Center_panel.getSize().getHeight()/100),
				(int)Center_panel.getSize().getWidth()/5,(int)Center_panel.getSize().getHeight()/5);
		OneCardButton.setBackground(Color.white);
		OneCardButton.setBorder(new LineBorder(Color.black,3,true));
		OneCardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						game1.playerDraw();
						}
						else {
							Game_Player.get(i).sayOnecard=true;
							game1.playerDraw();
							break;
						}
					}
				}
				if(oc==false) {
					JOptionPane.showMessageDialog(null,"dd");
				}
				
			}
		});
	}
	public void addCenterStackCard() {
		cci=new JLabel(game1.cs.Cardstack.peek().showCardimg());
		cci.setBounds((int)Center_panel.getSize().getWidth()/2,(int)Center_panel.getSize().getHeight()/3,115,150);
		
		cci.setBorder(new LineBorder(Color.black,2,true));
		Center_panel.add(cci);
	}
	public void addNextTurnButton() {
		turnButton=new JButton("턴 넘기기!");
		turnButton.setBounds((int)(Center_panel.getSize().getWidth()-Center_panel.getSize().getWidth()/5-Center_panel.getSize().getWidth()/100),
				(int)(Center_panel.getSize().getHeight()-Center_panel.getSize().getHeight()/5-Center_panel.getSize().getHeight()/100),
				(int)Center_panel.getSize().getWidth()/5,(int)Center_panel.getSize().getHeight()/5);
		
		turnButton.setBackground(Color.white);
		turnButton.setBorder(new LineBorder(Color.black,3,true));
		turnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(myturn==true) {
			if(game1.count==true)
			{
				
				Game_Player.get(game1.turn).spot.setBackground(Color.white);
				Game_Player.get(game1.turn).spot.repaint();
				Game_Player.get(game1.turn).spot.revalidate();
				game1.gamePhase();
				playSound(false,"GetObject.wav");
				message.setText("플레이어"+(game1.turn+1)+"의 턴입니다.");
			gameSimulation();
			if(myturn==true) {
				turnButton.setEnabled(true);
			}
			else{turnButton.setEnabled(false);}
			}
			else {YOU_CANT_END_TURN();}
				} else {NOT_YOUR_TURN();}
			}}
			);
		Center_panel.add(turnButton);
	}
	public JLabel otherPlayerCardBack() {
		imgURL=getClass().getClassLoader().getResource("CardBack.jpg");
		ImageIcon img=new ImageIcon(imgURL);
		Image IMG=img.getImage();
		IMG=IMG.getScaledInstance((int)this.getSize().getWidth()/20,(int)this.getSize().getHeight()/10 , java.awt.Image.SCALE_SMOOTH);
		img=new ImageIcon(IMG);
		otherPlayerCardBack=new JLabel(img);
		otherPlayerCardBack.setBorder(new LineBorder(Color.black,1,true));
		return otherPlayerCardBack;
	}
	public void YOU_CANT_USE() {
		playSound(false,"warning.wav"); JOptionPane.showMessageDialog(null, "낼 수없는 카드입니다.");} 
	public void YOU_CANT_MORE() {
		playSound(false,"warning.wav"); JOptionPane.showMessageDialog(null, "턴을 넘겨야합니다.");}
	public void YOU_CANT_END_TURN() {
		playSound(false,"warning.wav"); JOptionPane.showMessageDialog(null, "아직 턴을 종료할 수 없습니다.");}
	public void NOT_YOUR_TURN() {
		playSound(false,"warning.wav"); JOptionPane.showMessageDialog(null, "당신의 턴이 아닙니다.");}
	
}

@SuppressWarnings("serial")
class ResultFrame extends Frame{
	ResultFrame(Player player){
		setLayout(new FlowLayout());
		JButton exitButton=new JButton("나가기");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(new JLabel(player.player_name+"님이 이겼습니다."));
		add(exitButton);
		setTitle("결과창"); 
		setSize(300,150);
		setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-(int)(this.getSize().getWidth()/2),
				(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-(int)(this.getSize().getHeight()/2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); 
		setResizable(false);
	}
}
@SuppressWarnings("serial")
class FailFrame extends Frame{
	FailFrame(){
		setLayout(new FlowLayout());
		JButton exitButton=new JButton("나가기");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(new JLabel("파산하셨습니다."));		
		add(exitButton);
		setTitle("파산!"); 
		setSize(300,150);
		setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-(int)(this.getSize().getWidth()/2),
				(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-(int)(this.getSize().getHeight()/2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); 
		setResizable(false);
		playSound(false,"failed_bgm.wav");
	}
}