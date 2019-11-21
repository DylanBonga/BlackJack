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
			String[] kaarten = {"Harten_2","Harten_3","Harten_4","Harten_5","Harten_6","Harten_7","Harten_8","Harten_9","Harten_10","Harten_B","Harten_V","Harten_K","Harten_A","Ruiten_2","Ruiten_3","Ruiten_4","Ruiten_5","Ruiten_6","Ruiten_7","Ruiten_8","Ruiten_9","Ruiten_10","Ruiten_B","Ruiten_V","Ruiten_K","Ruiten_A","Schoppen_2","Schoppen_3","Schoppen_4","Schoppen_5","Schoppen_6","Schoppen_7","Schoppen_8","Schoppen_9","Schoppen_10","Schoppen_B","Schoppen_V","Schoppen_K","Schoppen_A","Klaveren_2","Klaveren_3","Klaveren_4","Klaveren_5","Klaveren_6","Klaveren_7","Klaveren_8","Klaveren_9","Klaveren_10","Klaveren_B","Klaveren_V","Klaveren_K","Klaveren_A"};
			
			ShuffleDeck d = new ShuffleDeck();
			String[] geschudde_deck = d.shuffle(kaarten); // doelstelling 1
			
			Kaart k = new Kaart();
			
			speler1.opening(k.getKaart(geschudde_deck), k.getKaart(geschudde_deck));
			JackBlack.opening(k.getKaart(geschudde_deck), k.getKaart(geschudde_deck));
			
			boolean play = true;
			while(play == true) {
				System.out.println("Spelen? [J]a [N]ee");
				String p = sc.next();
				char q = p.charAt(0);
				if(q == 'j' || q == 'J') {
					speler1.vraagKaart(k.getKaart(geschudde_deck));
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
					JackBlack.play(k.getKaart(geschudde_deck));
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
