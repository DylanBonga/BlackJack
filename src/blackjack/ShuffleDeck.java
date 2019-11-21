package blackjack;

import java.util.Random;

public class ShuffleDeck {
	
	Random r = new Random();
	
	String[] shuffle(String[] speelKaarten) {
		
		String[] shuffled = new String[speelKaarten.length];

		for(int i = 0; i < speelKaarten.length; i++) {
			int plek = r.nextInt(52);
			if(shuffled[plek] == null) {
				shuffled[plek] = speelKaarten[i];
			}else {
				i--;
			}
		}		
		return shuffled;
	}
}
