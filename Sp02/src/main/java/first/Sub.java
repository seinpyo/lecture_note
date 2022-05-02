package first;

public class Sub implements Calculator {
	@Override
	public int cal(int firstNum, int secondNum) {
		int result = firstNum - secondNum;
		return result;
	}
}
