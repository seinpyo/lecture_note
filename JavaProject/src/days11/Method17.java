package days11;

import java.util.Scanner;

public class Method17 {

	public static void main(String[] args) {
		
		int[][] scores;
		double[] avg;
		//int s = getStudentNumber(); : 학생수를 입력받아 리턴하는 매서드
		//int k = getSubjectNumber(); : 과목수를 입력받아 리턴하는 메서드
		//scores = new int[s][k];
		
		scores = new int[getStudentNumber()][getSubjectNumber()+1];	//총점까지 저장하기위해 +1
		avg = new double[scores.length];
		input(scores);	 // s명의 학생의 k개의 과목수 입력
		cals(scores, avg);		 // 총점 평균 계산
		output(scores, avg);		// 성적표 출력

	} 
	
	public static int getStudentNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수를 입력하세요 : ");
		return sc.nextInt();
	}
	
	public static int getSubjectNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("과목 수를 입력하세요 : ");
		return sc.nextInt();
	
	}
	
	public static void input(int[][] arr) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length-1; j++) {
				System.out.printf("%d번 학생의 %d과목 점수를 입력하세요 : ", i+1, j+1);	//0이 아닌 1부터 출력되도록 +1
				arr[i][j] = sc.nextInt();
				}
			}
		}
	
	public static void cals (int[][] arr, double[] avg) {
		int[] sum = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length-1; j++) {		//총점칸은 빼기 위해 -1
				arr[i][arr[i].length-1] += arr[i][j];	//총점칸(arr[i][j])에 총점 누적
			}
			
			avg[i] = arr[i][arr[i].length-1]/(double)(arr[i].length-1);
			
		}
	}
	
	public static void output (int[][] arr, double[] a) {
		int sub = arr[0].length;	//과목수
		int std = arr.length;		//학생수 
		System.out.println();
		System.out.println("\t\t###성적표###");
		System.out.println("=============================================");
		System.out.print("번호\t");
		for(int i=0; i<sub-1; i++) System.out.printf("과목%d\t", i+1);
		System.out.print("총점\t평균\t");
		System.out.println("\n=============================================");
		for(int i=0; i<std; i++) {
			System.out.printf("%d\t", i+1);	//번호
			for(int j=0; j<sub; j++) {
				System.out.printf("%d\t", arr[i][j]);
			}
			System.out.printf("%.1f\t\n", a[i]);
		}
		System.out.println("=============================================");
	}
	
}
