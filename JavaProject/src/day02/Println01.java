package day02;

public class Println01 {
	public static void main(String[] args) {
		//println()�� printf("\n")�� ���� ������.
		//println�� \n�� ��� ��� ��� �� �ٹٲ��� �� �� ����.
		//System.out.println("\n"); -> �ι� �ٹٲ�.
		
		//printf�� ���� format ��� ����(%d, %f ��)�� ������� ���Ѵ�.
		//printf���� ����� ������ ����
		System.out.println(10);
		System.out.println(12.123);
		System.out.println("Java Programming"); 
		
		System.out.println(10 + ", " + 12.123 + ", " + "Java Programming");
		// '+' �����ڴ� ���ڿ� �ٸ� ������ �����Ͱ� ����Ǹ�, �̾���̱�
		// ���ڵ鳢�� '+'�� ����Ǹ� ��� ���� ������ �ȴ�.
		
		// ���ڿ� ���ڰ� �����Ǵ� �� 
		// 1. ����ǥ�ȿ� �������� �ƴ���
		// 2. 123�� ���̽ʻ� "123"�� ���̻�
		// 3. 987�� 1234���� ������, "987"�� "1234"���� ũ�ٰ� ǥ���� 
		//		- ���ڵ鰣�� �񱳴� ù���ں��� �ϳ��� ���� ��ġ�� ���ڿ� ��
		//		- ù���ڿ��� ũ�Ⱑ �����Ǹ� �� ������ ������ �ʴ´�.
		//		- ù��¥�� ���� ��� �ι�° ���ڸ� ��
		//		- �ι�° ���ڵ� ���ٸ� ����° �� ...
		//		- �������� ã���� �� ���� ������ ���ڸ� �۴�, �ڿ� ������ ���ڸ� ũ�ٰ� ��
		//		- (a:�۴�~z:ũ��, ��:�۴�~��:ũ��) air > apple
		
		System.out.println("10" + "5");
		System.out.println("10" + 5);
		System.out.println(10 + "5");
		System.out.println(10 + 5); 	//�������
		System.out.println("Hello" + " World~!");
		System.out.println(10 + " + " + 5 + " = " + 10 + 5); // �տ��� ���� ����Ǿ� = �ڿ� 10�� �ٰ� 5�� �׳� ���� �ٴ´�
		System.out.println(10 + " + " + 5 + " = " + (10+5));
		System.out.println("10 + 5" + " = " + (10+5));
		System.out.println("10 + 5 = " + (10+5));
		System.out.println("10 + 5 = 1" + 5);
		System.out.println("10 + 5 = 15");
		
	}
}
