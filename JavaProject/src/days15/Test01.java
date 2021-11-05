package days15;

public class Test01 {

	public static void main(String[] args) {
		int[] a = {56, 87};
		int tot = 0;
		double ave;
		tot = sum(a);
		System.out.println(tot);
		ave = average(a);
		System.out.println(ave);
 
	}

	static int sum(int[] a) {
		int sum = 0;
		for(int i=0; i<a.length; i++) { sum += a[i];}
		return sum;

	}
	
	static double average(int[] a) {
		int sum = sum(a);
		double avg = sum/3;
		return avg;
	}
}
