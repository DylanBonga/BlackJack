package blackjack;



public class Kaart {
	String naam;
	String soort;
	int value;
	
	Kaart(String s, String waarde, int w_getal){
		naam = "["+s+" "+waarde+"]";
		soort = s;
		value = w_getal;
	}
	
	int kaart_nummer = 0;
	Kaart getKaart(Kaart[] deck) {
		kaart_nummer++;
		return deck[kaart_nummer];
	}
	
	int getValue() {
		return value;
		
	}
}
