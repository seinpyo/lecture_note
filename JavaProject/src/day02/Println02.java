package day02;

public class Println02 {
	public static void main(String[] args) {
	
		System.out.println("\t\t\t ###성적표###");
		System.out.println("--------------------------------------------------------------");
		System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("--------------------------------------------------------------\n");
		System.out.println(1 + "\t" + "홍길동"+ "\t\t" + "9" + "\t"  + "89" + "\t" + "72" + "\t" + (84+89+72) + "\t" + ((84+89+72)/3.0));
		System.out.println(2 + "\t" + "고길동"+ "\t\t" + "91" + "\t"  + "100" + "\t" + "62" + "\t" + (91+100+62) + "\t" + ((91+100+62)/3.0));
		System.out.println(3 + "\t" + "이길동"+ "\t\t" + "66" + "\t"  + "63" + "\t" + "90" + "\t" + (66+63+90) + "\t" + ((66+63+90)/3.0));
		
	}
}
