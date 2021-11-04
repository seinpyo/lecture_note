package days14;

class CardDeck {
	private Card[] cards = new Card[52];	//52개의 객체가 들어가는 cards 배열
	
	CardDeck() {
		//cards[0] = new Card(Card.spade, 1); 이런식으로 52개를 채울 순 없으니 반복문
		
		int i = 0;
		for(int k=1; k<=4; k++) {	//1~4 무늬별로 
			for(int n=1; n<=13; n++) { // 번호는 1~13까지 
				cards[i] = new Card(k,n);	// 카드 장수는 : i 0~51(총 52장)
				i++;
			}
		}
	}
	
	public Card pick(int i) {
		return cards[i]; // cards[i] 객체가 리턴 
	}

	public void shuffle() {	
		//n번째 카드와 random으로 발생한 숫자번째의 카드를 서로 자리 바꿈 * 52;
		for(int i=0; i<52; i++) {
			int r = (int)(Math.random()*52);
			Card temp = cards[i];
			cards[i] = cards[r];
			cards[r] = temp;		//주소값들끼리 교환됨
		}

	}	
	
}
public class Class28_CardGame {

	public static void main(String[] args) {
		CardDeck d  = new CardDeck();	
		
		d.shuffle();
		
//		System.out.printf("%s ", d.pick(0).toString());
//		System.out.printf("%s ", d.pick(1));
//		System.out.printf("%s ", d.pick(2));
//		System.out.printf("%s ", d.pick(3));
//		System.out.printf("%s ", d.pick(4));
		
		Card[] player1 = new Card[5]; 
		Card[] player2 = new Card[5]; 
		Card[] player3 = new Card[5]; 
		Card[] player4 = new Card[5]; 
		
		//카드를 분배하기 

			
		d.shuffle();
	
		int r = 0;
		for(int c=0; c<5; c++) {
				player1[c] = d.pick(r++);
				player2[c] = d.pick(r++);
				player3[c] = d.pick(r++);
				player4[c] = d.pick(r++); }
		
		
		System.out.print("Player1 : ");
		for(int i=0; i<5; i++) System.out.printf("%s ", player1[i]);
		System.out.print("\nPlayer2 : ");
		for(int i=0; i<5; i++) System.out.printf("%s ", player2[i]);
		System.out.print("\nPlayer3 : ");
		for(int i=0; i<5; i++) System.out.printf("%s ", player3[i]);
		System.out.print("\nPlayer4 : ");
		for(int i=0; i<5; i++) System.out.printf("%s ", player4[i]);

	}

}
