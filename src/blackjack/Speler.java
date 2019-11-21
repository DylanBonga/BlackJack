package blackjack;

import java.util.ArrayList;

public class Speler {
	ArrayList<String> hand = new ArrayList<>(2);
	int score = 0;
	void opening(String card, String card2) {
		hand.add(card);
		hand.add(card2);
		printHand();
		Kaart k = new Kaart();
		int total_v = k.getValue(card) + k.getValue(card2);
		score += total_v;
	}
	
	void vraagKaart(String card) {
		System.out.println("Mag ik een kaart?");
		hand.add(card);
		printHand();
		Kaart k = new Kaart();
		int total_v = k.getValue(card);
		score += total_v;
	}
	void printHand() {
		System.out.print("Speler: ");
		for(int x = 0; x < hand.size(); x++) {
			System.out.print(hand.get(x)+" ");
		}
		System.out.println("");
	}
}
