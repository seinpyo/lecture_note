package day02;

public class Printf03 {
	public static void main(String[] args) {
		System.out.printf("\t\t\t ###����ǥ###\n");
		System.out.printf("--------------------------------------------------------------\n");
		System.out.printf("%3s\t%10s\t%3s\t%3s\t%s\t%s\t%5s\n","��ȣ","�̸�","����","����","����","����","���");
		System.out.printf("--------------------------------------------------------------\n");
		System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n", 1, "ȫ�浿", 9, 89, 72, 84+89+72, ((84+89+72)/3.0));
		System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n", 2, "��浿", 32, 76, 100, 32+76+100, (32+76+100)/3.0);
		System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n", 3, "�ֱ浿", 97, 88, 91, 97+88+91, (97+88+91)/3.0);
	}

}
