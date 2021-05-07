import java.net.URL;

import javax.swing.ImageIcon;

public class Card {
	private String pattern;
	private String A23KQJ;
	private ImageIcon cardimg;
	URL CardBackimageURL = getClass().getClassLoader().getResource("CardBack.jpg");
	public ImageIcon cardbackimg=new ImageIcon(CardBackimageURL) ;
	public Card() {}
	public Card(String pattern,String A23KQJ,ImageIcon cardimg) {
		this.pattern=pattern;
		this.A23KQJ=A23KQJ;
		this.cardimg=cardimg;
	}
	public ImageIcon showCardimg(){
		return this.cardimg;
	}
	public String getCardPattern() {
		return this.pattern;
	}
	public String getCardA23KQJ() {
		return this.A23KQJ;
	}
	public String getColor() {
		return null;
	}
	public ImageIcon showHoldimg() {
		return null;
	}
	public ImageIcon showCenterCardimg() {
		return null;
	}
}
