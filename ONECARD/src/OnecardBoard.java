import java.util.Collections;
import java.util.Stack;

public class OnecardBoard{
	Stack<Card> Cardbundle; 
	Stack<Card> Cardstack;
	public OnecardBoard() {	
	}
	public OnecardBoard(Deck cardDeck) {
		Cardbundle=cardDeck.cards;
		Cardstack.push(Cardbundle.pop());
	}
	public Card selectCard() {
		if (Cardbundle.size()==0) {
			System.out.println("카드를 다시 섞습니다.");
			Cardbundle=Cardstack;
			Card card=Cardstack.pop();
			Cardstack=new Stack<>();
			Cardstack.push(card);
			CardShuffle();
		}
		return Cardbundle.pop();
	}
	public void stackCard(Card card) {
		Cardstack.push(card);
	}
	public void CardShuffle() {
		Collections.shuffle(Cardbundle);
	}
}
