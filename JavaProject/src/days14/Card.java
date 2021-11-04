package days14;

//카드 별로 정보 (무늬/숫자(1~13))

public class Card {
	final static int spade = 4;
	final static int diamond = 3;
	final static int heart = 2;
	final static int clover = 1;
	//final : 변수의 값을 변경하지 못하도록 하는 키워드
	
	private int kind;	//4:스페이드 3:다이아 2:하트 1:클로버
	private int number;	//1~13
	
	
	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	Card(){
		this(spade, 1);
	}
	
	public String toString() {
		// 호출되면 호출객체의 무늬와 숫자를 String으로 리턴해주는 멤버 메서드
		// kind 4, number 13 => 문자열 "[Spade:K]" 라고 리턴
		String[] kinds = {"", "♣", "♥", "◆", "♠"};
		String[] nums = {"", "A", "1", "2", "3", "4", "5", "6", "7","8", "9", "10", "J", "Q", "K"};
		String result = "["+kinds[this.kind] + ":" + nums[this.number] + "]";
		return result;
	}
	
	//toString 메서드가 포함된 클래스로 만든 객체를 System.out.println(객체이름(참조변수)); 로 출력되면
	//이전처럼 "패키지.클래스.해쉬코드" 가 출력되는 것이 아니라 toString이 리턴해주는 값이 출력된다.
	//System.out.println(객체이름(참조변수).toString());이라고 한 것과 같은 출력을 보인다는 것
	
	//Card c = new Card(4,13);
	//System.out.println(c);  = [Spade:K]
	//System.out.println(c.toString()); = [Spade:K]  (위와 결과 같음)
	
	//String result = "카드 1 : " + c;  
	//String result = "카드 1 : " + c.toString;  => 결과 같음
}
