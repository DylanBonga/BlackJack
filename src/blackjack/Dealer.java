package blackjack;

import java.util.ArrayList;

public class Dealer {
	ArrayList<Kaart> hand = new ArrayList<>(2);
	int score = 0;
	void opening(Kaart card, Kaart card2) {
		hand.add(card);
		hand.add(card2);
		System.out.println("Dealer: "+hand.get(0).naam);
		int total_v = card.getValue();
		score += total_v;
	}
	
	void reveal() {
		printHand();
		int total_v = hand.get(1).getValue();
		score += total_v;
	}
	void play(Kaart card) {
		hand.add(card);
		printHand();
		int total_v = card.getValue();
		score += total_v;
	}
	void printHand() {
		System.out.print("Dealer: ");
		for(int x = 0; x < hand.size(); x++) {
			System.out.print(hand.get(x).naam+" ");
		}
		System.out.println("");
	}
}
