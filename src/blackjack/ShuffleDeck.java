package blackjack;

import java.util.Random;

public class ShuffleDeck {
	
	Random r = new Random();
	
	Kaart[] shuffle(Kaart[] speelKaarten) {
		
		Kaart[] shuffled = new Kaart[speelKaarten.length];

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
	
	int kaartNummer = 0; 
	
	Kaart bovensteKaart(Kaart[] deck){
		
		return deck[kaartNummer++];
	}
}
