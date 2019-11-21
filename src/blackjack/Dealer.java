package blackjack;

import java.util.ArrayList;

public class Dealer {
	ArrayList<String> hand = new ArrayList<>(2);
	int score = 0;
	void opening(String card, String card2) {
		hand.add(card);
		hand.add(card2);
		System.out.println("Dealer: "+hand.get(0));
		Kaart k = new Kaart();
		int total_v = k.getValue(card);
		score += total_v;
	}
	void reveal() {
		printHand();
		Kaart k = new Kaart();
		int total_v = k.getValue(hand.get(1));
		score += total_v;
	}
	void play(String card) {
		hand.add(card);
		printHand();
		Kaart k = new Kaart();
		int total_v = k.getValue(card);
		score += total_v;
	}
	void printHand() {
		System.out.print("Dealer: ");
		for(int x = 0; x < hand.size(); x++) {
			System.out.print(hand.get(x)+" ");
		}
		System.out.println("");
	}
}
