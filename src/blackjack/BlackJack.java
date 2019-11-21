package blackjack;

import java.util.Scanner;

public class BlackJack {
	void start(){
		Dealer JackBlack = new Dealer();
		System.out.println("Welkom");		
		System.out.println("\nSpelen? [J]a of [N]ee");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		// if(s == "J" | s == "j"){} didn't work
		char j = s.charAt(0);
		
		if(j == 'j' || j == 'J') {
			Speler speler1 = new Speler();

			//String[] kaarten = {"H2","H3","H4","H5","H6","H7","H8","H9","H10","HB","HV","HK","HA","R2","R3","R4","R5","R6","R7","R8","R9","R10","RB","RV","RK","RA","S2","S3","S4","S5","S6","S7","S8","S9","S10","SB","SV","SK","SA","K2","K3","K4","K5","K6","K7","K8","K9","K10","KB","KV","KK","KA"};
			//String[] kaarten = {"Harten_2","Harten_3","Harten_4","Harten_5","Harten_6","Harten_7","Harten_8","Harten_9","Harten_10","Harten_B","Harten_V","Harten_K","Harten_A","Ruiten_2","Ruiten_3","Ruiten_4","Ruiten_5","Ruiten_6","Ruiten_7","Ruiten_8","Ruiten_9","Ruiten_10","Ruiten_B","Ruiten_V","Ruiten_K","Ruiten_A","Schoppen_2","Schoppen_3","Schoppen_4","Schoppen_5","Schoppen_6","Schoppen_7","Schoppen_8","Schoppen_9","Schoppen_10","Schoppen_B","Schoppen_V","Schoppen_K","Schoppen_A","Klaveren_2","Klaveren_3","Klaveren_4","Klaveren_5","Klaveren_6","Klaveren_7","Klaveren_8","Klaveren_9","Klaveren_10","Klaveren_B","Klaveren_V","Klaveren_K","Klaveren_A"};
			Kaart[] kaarten = {
					new Kaart("Harten", "2", 2), new Kaart("Harten", "3", 3), new Kaart("Harten", "4", 4), new Kaart("Harten", "5", 5), 
					new Kaart("Harten", "6", 6), new Kaart("Harten", "7", 7), new Kaart("Harten", "8", 8), new Kaart("Harten", "9", 9), 
					new Kaart("Harten", "10", 10), new Kaart("Harten", "B", 10), new Kaart("Harten", "V", 10), new Kaart("Harten", "K", 10), 
					new Kaart("Harten", "A", 11), 

					new Kaart("Ruiten", "2", 2), new Kaart("Ruiten", "3", 3), new Kaart("Ruiten", "4", 4), new Kaart("Ruiten", "5", 5), 
					new Kaart("Ruiten", "6", 6), new Kaart("Ruiten", "7", 7), new Kaart("Ruiten", "8", 8), new Kaart("Ruiten", "9", 9), 
					new Kaart("Ruiten", "10", 10), new Kaart("Ruiten", "B", 10), new Kaart("Ruiten", "V", 10), new Kaart("Ruiten", "K", 10), 
					new Kaart("Ruiten", "A", 11),

					new Kaart("Schoppen", "2", 2), new Kaart("Schoppen", "3", 3), new Kaart("Schoppen", "4", 4), new Kaart("Schoppen", "5", 5), 
					new Kaart("Schoppen", "6", 6), new Kaart("Schoppen", "7", 7), new Kaart("Schoppen", "8", 8), new Kaart("Schoppen", "9", 9), 
					new Kaart("Schoppen", "10", 10), new Kaart("Schoppen", "B", 10), new Kaart("Schoppen", "V", 10), new Kaart("Schoppen", "K", 10), 
					new Kaart("Schoppen", "A", 11), 

					new Kaart("Klaveren", "2", 2), new Kaart("Klaveren", "3", 3), new Kaart("Klaveren", "4", 4), new Kaart("Klaveren", "5", 5), 
					new Kaart("Klaveren", "6", 6), new Kaart("Klaveren", "7", 7), new Kaart("Klaveren", "8", 8), new Kaart("Klaveren", "9", 9), 
					new Kaart("Klaveren", "10", 10), new Kaart("Klaveren", "B", 10), new Kaart("Klaveren", "V", 10), new Kaart("Klaveren", "K", 10), 
					new Kaart("Klaveren", "A", 11)};
			
			ShuffleDeck d = new ShuffleDeck();

			Kaart[] geschudde_deck = d.shuffle(kaarten); // doelstelling 1
			
			speler1.opening(d.bovensteKaart(geschudde_deck), d.bovensteKaart(geschudde_deck));
			JackBlack.opening(d.bovensteKaart(geschudde_deck), d.bovensteKaart(geschudde_deck));
			
			boolean play = true;
			while(play == true) {
				System.out.println("Spelen? [J]a [N]ee");
				String p = sc.next();
				char q = p.charAt(0);
				if(q == 'j' || q == 'J') {
					speler1.vraagKaart(d.bovensteKaart(geschudde_deck));
					if(speler1.score > 21) {
						play = false;
					}
				}else {
					System.out.println("You passed");
					play = false;
				}
			}		
			if(speler1.score < 21) {
				JackBlack.reveal();
				while(JackBlack.score < 16) {
					JackBlack.play(d.bovensteKaart(geschudde_deck));
					if(JackBlack.score > 21) {
						System.out.println("Dealer: "+JackBlack.score+". Speler: "+speler1.score);
						System.out.println("Speler wint!");
					}
				}
				
				if(JackBlack.score > 15 && JackBlack.score < 22) {
					System.out.println("Dealer: "+JackBlack.score+". Speler: "+speler1.score);
					System.out.println("Dealer stopt");
					if(speler1.score > JackBlack.score && speler1.score < 22) {
						System.out.println("Speler wint");
					}else {
						System.out.println("Bank wint");
					}
				}else {
				}
			}else {
				System.out.println("Speler is dood, jammer!");
			}
		}else if(j == 'n' || j == 'N') {
			System.out.println("Oké, tot ziens!");
		}else {
			System.out.println("Invalid input. Tot ziens!");
		}
	}	
}
