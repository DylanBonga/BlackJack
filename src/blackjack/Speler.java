package blackjack;

import java.util.ArrayList;

public class Speler {
	ArrayList<Kaart> hand = new ArrayList<>(2);
	int score = 0;
	void opening(Kaart card, Kaart card2) {
		hand.add(card);
		hand.add(card2);
		printHand();
		int total_v = card.getValue() + card2.getValue(); //dit lijkt me onhandig? 
		score += total_v;
	}
	
	void vraagKaart(Kaart card) {
		System.out.println("Mag ik een kaart?");
		hand.add(card);
		printHand();
		int total_v = card.getValue();
		score += total_v;
	}
	void printHand() {
		System.out.print("Speler: ");
		for(int x = 0; x < hand.size(); x++) {
			System.out.print(hand.get(x).naam+" ");
		}
		System.out.println("");
	}
}
