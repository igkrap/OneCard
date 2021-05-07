import java.awt.Image;
import java.net.URL;
import java.util.Stack;

import javax.swing.ImageIcon;

public class Deck{
	final static String[] PATTERNS= { "SPADE","HEART","DIAMOND","CLUB"};
	private final int CARD_COUNT = 13;
	Stack<Card> cards=new Stack<>();
	URL imgURL;
	public Deck() {
		cards=this.makeCards();
	}
	private Stack<Card> makeCards(){
		Card card;
		String code="";
		String color="";
		String denomination;
		ImageIcon img;
		int j = 0;
		 for(String pattern : PATTERNS){
	            for(int i=1; i<=CARD_COUNT; i++) {
	            	if (pattern.equals("SPADE")) {j = 0; color="BLACK"; code="S";}
	            	else if (pattern.equals("HEART")) {j=13; color="COLOR";code="H";}
	            	else if (pattern.equals("DIAMOND")) {j=26; color="COLOR";code="D";}
	            	else if (pattern.equals("CLUB")) {j=39; color="BLACK";code="C";}
	            	imgURL=getClass().getClassLoader().getResource(String.valueOf(j+i)+".jpg");
	            	img=new ImageIcon(imgURL);
	            	//holdimg=img.getImage();
	            	//holdimg = holdimg.getScaledInstance((int)(GameFrame.GameFrameDim.getWidth()/16-GameFrame.GameFrameDim.getWidth()/200),
	            	//		(int)(GameFrame.GameFrameDim.getHeight()/8-GameFrame.GameFrameDim.getHeight()/100), java.awt.Image.SCALE_SMOOTH);
	            	//himg=new ImageIcon(holdimg);
	            	//centerimg=img.getImage();
	            	//centerimg = centerimg.getScaledInstance(105, 135, java.awt.Image.SCALE_SMOOTH);
	            	//cimg=new ImageIcon(centerimg);
	                if(i ==1){
	                denomination = "A"; code+="A";
	                }else if(i ==11){
	                denomination = "J"; code+="J";
	                }else if(i ==12){
	                denomination = "Q"; code+="Q";
	                }else if(i ==13){
	                denomination = "K"; code+="K";
	                }else {
	                denomination = String.valueOf(i); code+=i;
	                }
	                card = new Card(pattern, denomination,img);
	                cards.add(card);
	        }
	     }
		 imgURL=getClass().getClassLoader().getResource("BLACKJOKER.jpg");
		 img=new ImageIcon(imgURL);
		 card=new Card("BLACKJOKER","BLACKJOKER",img);
		 cards.add(card);
		 imgURL=getClass().getClassLoader().getResource("COLORJOKER.jpg");
		 img=new ImageIcon(imgURL);
		 card=new Card("COLORJOKER","COLORJOKER",img);
		 cards.add(card);
		 return cards;
	}
	public ImageIcon patternimg(String cardpattern) {
		ImageIcon img;
		Image fixIMG;
	if(cardpattern.equals("SPADE")){
		imgURL=getClass().getClassLoader().getResource("spade.png");
		img=new ImageIcon(imgURL);
		fixIMG=img.getImage();  //ImageIcon을 Image로 변환.
		fixIMG = fixIMG.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		img=new ImageIcon(fixIMG);
		return img;
	}
	else if(cardpattern.equals("HEART")) {
		imgURL=getClass().getClassLoader().getResource("heart.png");
		img=new ImageIcon(imgURL);
		fixIMG=img.getImage();  //ImageIcon을 Image로 변환.
		fixIMG = fixIMG.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		img=new ImageIcon(fixIMG);
		return img;
	}
	else if(cardpattern.equals("DIAMOND")) {
		imgURL=getClass().getClassLoader().getResource("diamond.png");
		img=new ImageIcon(imgURL);
		fixIMG=img.getImage();  //ImageIcon을 Image로 변환.
		fixIMG = fixIMG.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		img=new ImageIcon(fixIMG);
		return img;
	}
	else if(cardpattern.equals("CLUB")) {
		imgURL=getClass().getClassLoader().getResource("club.png");
		img=new ImageIcon(imgURL);
		fixIMG=img.getImage();  //ImageIcon을 Image로 변환.
		fixIMG = fixIMG.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		img=new ImageIcon(fixIMG);
		return img;
	}
	else {
		img=new ImageIcon("");
		return img;
	}
}
}
