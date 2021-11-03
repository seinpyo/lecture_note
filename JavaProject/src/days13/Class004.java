package days13;

//getter setter 

class Dog {
	private String name;
	private int age; 
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
public class Class004 {

	public static void main(String[] args) {
		
		Dog d1 = new Dog();
		d1.setName("앙꼬");
		d1.setAge(10);
		d1.setPhone("010-1004-1004");
		
		System.out.printf("이름 : %s, 나이 : %d, 전화번호 : %s\n", d1.getName(), d1.getAge(), d1.getPhone());

	}

}
