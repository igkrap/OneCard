import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Player{
	LinkedList<Card> holdingCards;
	String player_name;
	int player_number;
	int player_turn;
	boolean fail=false;
	boolean turnOn;
	boolean oc=false;
	boolean sayOnecard=true;
	public Player(int player_number,String player_name) {
		holdingCards=new LinkedList<>();
		this.player_number=player_number;
		this.player_name=player_name;
		this.player_turn=player_number;
	}
//	public void receiveCard(Card card) {
//		holdingCards.add(card);
//	}
//	public void useCard(Card card) {
//		holdingCards.remove(card);
//	}
//	public Card selectCard(int w) {
//		return Cardholds.get(w);
//	}
//	public void playerDraw(int atk) {
//		for(int i=0;i<atk+1;i++)
//		{receiveCard(cs.selectCard());
//		if(Cardholds.size()>=15) {System.out.println(player_name+"님이 파산하였습니다.");
//		while(Cardholds.size()>0) {
//			cs.Cardbundle.add(Cardholds.get(0));
//			Cardholds.remove(0);
//		}
//		Collections.shuffle(cs.Cardbundle);
//		fail=true;
//		break;
//		}
//		}
//		atk=0;
//		count=true;
//		}
//	public void playerUse(Card choose, String setPattern, int atk, int direction) {
//		System.out.println(selectCard(Cardholds.indexOf(choose)).getCardPattern()+
//				selectCard(Cardholds.indexOf(choose)).getCardA23KQJ()+"을 내려고합니다.");
//		if(SEVEN==false) {setPattern=cs.Cardstack.peek().getCardPattern();}
//		if(setPattern.equals("BLACKJOKER")||setPattern.equals("COLORJOKER")) {
//			if(SEVEN==true) {GameFrame.Center_panel.remove(changeimg);
//			GameFrame.Center_panel.repaint();
//    		GameFrame.Center_panel.revalidate();}
//			correct=false;
//			SEVEN=false;
//			if(atk==0&&cs.Cardstack.peek().getCardA23KQJ().equals("BLACKJOKER")){
//				if(selectCard(Cardholds.indexOf(choose)).getColor().equals("BLACK")) {
//					if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("K")) {cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//					useCard(Cardholds.indexOf(choose));correct=true;count=false;}
//					else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("Q")) {direction*=-1;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//					useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//					else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("J")) {if(direction>0) {direction=2;}else {direction=-2;}
//					cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//					useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//					else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("7")) {SEVEN=true;
//					if(GameFrame.myturn==true) {setPattern();} 
//					else{Random R=new Random(); int r=R.nextInt(CardDeck.PATTERNS.length);setPattern=CardDeck.PATTERNS[r];
//					}
//					cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//					useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//					else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("2")) {atk+=1;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//				    useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//					else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("A")) {atk+=2;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//					useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//					else {cs.stackCard(selectCard(Cardholds.indexOf(choose))); useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//					}
//				else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("COLORJOKER")) {
//					atk+=6;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//				useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//				else {correct=false;count=false;}}
//			else if(atk==0&&cs.Cardstack.peek().getCardA23KQJ().equals("COLORJOKER")){
//				if(selectCard(Cardholds.indexOf(choose)).getColor().equals("COLOR")) {
//					if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("K")) {cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//					useCard(Cardholds.indexOf(choose));correct=true;count=false;}
//					else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("Q")) {direction*=-1;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//					useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//					else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("J")) {if(direction>0) {direction=2;}else {direction=-2;}
//					cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//					useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//					else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("7")) {SEVEN=true;
//					if(GameFrame.myturn==true) {setPattern();} 
//					else{Random R=new Random(); int r=R.nextInt(CardDeck.PATTERNS.length);setPattern=CardDeck.PATTERNS[r];
//					}
//					cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//					useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//					else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("2")) {atk+=1;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//					useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//					else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("A")) {atk+=2;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//					useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//					else {cs.stackCard(selectCard(Cardholds.indexOf(choose))); useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//				}
//				else {correct=false;count=false;}}
//			else if(atk>0&&cs.Cardstack.peek().getCardA23KQJ().equals("BLACKJOKER")) {
//				if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("A")&&
//						selectCard(Cardholds.indexOf(choose)).getCardPattern().equals("SPADE")) 
//				{atk+=3;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//				useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//				else {correct=false;count=false; }
//			}
//			else if(atk>0&&cs.Cardstack.peek().getCardA23KQJ().equals("COLORJOKER")) {
//				correct=false;count=false;
//			}
//		}
//		else if(setPattern.equals(selectCard(Cardholds.indexOf(choose)).getCardPattern())||
//				cs.Cardstack.peek().getCardA23KQJ().equals(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ())) {
//			if(SEVEN==true) {GameFrame.Center_panel.remove(changeimg);
//			GameFrame.Center_panel.repaint();
//    		GameFrame.Center_panel.revalidate();}
//			SEVEN=false;
//			correct=false;
//		if(atk>0&&cs.Cardstack.peek().getCardA23KQJ().equals("2")) {
//			if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("2")) {atk+=1;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("A")) {atk+=2;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("BLACKJOKER")) {atk+=4;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("COLORJOKER")) {atk+=6;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("3")) {atk=0;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else {correct=false; count=false;}
//			}
//		else if(atk>0&&cs.Cardstack.peek().getCardA23KQJ().equals("A")) {
//			if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("A")) {atk+=2;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("3")) {atk=0;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else {correct=false;count=false; }
//		}
//		else if(atk>0&&cs.Cardstack.peek().getCardA23KQJ().equals("BLACKJOKER")) {
//			if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("A")&&
//					selectCard(Cardholds.indexOf(choose)).getCardPattern().equals("SPADE")) 
//			{atk+=4;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else {correct=false;count=false; }
//		}
//		else if(atk==0){
//			if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("K")) {cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=false;}
//			else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("Q")) {direction*=-1;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("J")) {if(direction>0) {direction=2;}else {direction=-2;}
//			cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("7")) {SEVEN=true;
//			if(GameFrame.myturn==true) {setPattern();} 
//			else{Random R=new Random(); int r=R.nextInt(CardDeck.PATTERNS.length);setPattern=CardDeck.PATTERNS[r];
//			changeimg=new JLabel(cd.patternimg(setPattern));
//    		changeimg.setBounds(420,130,60,60);
//    		GameFrame.Center_panel.add(changeimg);
//    		GameFrame.Center_panel.repaint();
//    		GameFrame.Center_panel.revalidate();}
//			cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("2")) {atk+=1;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("A")) {atk+=2;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//			useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			else {cs.stackCard(selectCard(Cardholds.indexOf(choose))); useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//			}
//		else{ count=false;correct=false;}
//		}
//		else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("BLACKJOKER")) {
//			if(SEVEN==true) {GameFrame.Center_panel.remove(changeimg);
//			GameFrame.Center_panel.repaint();
//    		GameFrame.Center_panel.revalidate();}
//			atk+=4;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//		useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//		else if(selectCard(Cardholds.indexOf(choose)).getCardA23KQJ().equals("COLORJOKER")) {
//			if(SEVEN==true) {GameFrame.Center_panel.remove(changeimg);
//			GameFrame.Center_panel.repaint();
//    		GameFrame.Center_panel.revalidate();}
//			atk+=6;cs.stackCard(selectCard(Cardholds.indexOf(choose)));
//		useCard(Cardholds.indexOf(choose));correct=true;count=true;}
//		else{ count=false;correct=false;}
//		if(Cardholds.size()==1) {oc=true;GameFrame.OneCardButton.setEnabled(true);}
//		if(Cardholds.size()==0) {End=true;}	
//	}
//
//	public void setPattern() {
//		count=false;
//		JRadioButton[] rb=new JRadioButton[4];
//		JButton Ok=new JButton();
//		String[] patterns=CardDeck.PATTERNS;
//		JFrame sp=new JFrame();
//		sp.setLayout(new FlowLayout());
//        ButtonGroup group=new ButtonGroup();
//        
//        for(int i=0; i<rb.length; i++){
//            rb[i]=new JRadioButton(patterns[i]);
//            group.add(rb[i]);
//            sp.add(rb[i]);
//            rb[i].addItemListener(new ItemListener() {
//            	@Override  
//                public void itemStateChanged(ItemEvent e) {
//                    if(rb[0].isSelected()){
//                    	change=patterns[0];
//                    }
//                    else if(rb[1].isSelected()){
//                    	change=patterns[1];
//                    }
//                    else if(rb[2].isSelected()) {
//            			change=patterns[2];
//                    }
//                    else if(rb[3].isSelected()) {
//                    	change=patterns[3];
//                    }
//                }
//        });
//        }
//        rb[0].setSelected(true);
//        sp.add(Ok);
//        Ok.addActionListener(new ActionListener() {
//        	@Override
//        	public void actionPerformed(ActionEvent e) {
//        		setPattern=change;changeimg=new JLabel(cd.patternimg(setPattern));
//        		changeimg.setBounds((int)GameFrame.CenterPanelDim.getSize().getWidth()/2+130,(int)GameFrame.CenterPanelDim.getSize().getHeight()/3+50,60,60);
//        		GameFrame.Center_panel.add(changeimg);
//        		GameFrame.Center_panel.repaint();
//        		GameFrame.Center_panel.revalidate();
//        		sp.dispose();
//        	}
//        });
//    		sp.setUndecorated(true);
//    		sp.setTitle("패턴 바꾸기"); 
//    		sp.setSize(300,150);
//    		sp.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-(int)(sp.getSize().getWidth()/2),
//    				(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-(int)(sp.getSize().getHeight()/2));
//    		sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    		sp.setVisible(true); 
//    		sp.setResizable(false);
//    	}	
}
