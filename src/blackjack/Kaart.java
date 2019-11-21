package blackjack;

public class Kaart {
	String naam;
	String soort;
	int value;
	int kaart_nummer = 0;
	String getKaart(String[] deck) {
		String n_card = deck[kaart_nummer];
		kaart_nummer++;
		return n_card;
	}
	int getValue(String kaart) {
		char k_v = kaart.charAt(kaart.length()-1);
		if(k_v == 'A') {
			return 11;
		}else if(k_v == 'K' || k_v == 'V' || k_v == 'B' || k_v == '0') {
			return 10;
		}else {
			int ch_int = Character.getNumericValue(k_v);
			return ch_int;
		}
	}
}
