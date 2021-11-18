package days23;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class MyClass implements Serializable {
	String name;
}

public class IO15 {
	public static void main(String[] args) throws FileNotFoundException, IOException  {
		File dir = new File("C:\\Users\\JAVA01\\git\\repository\\JavaProject\\temp");
		if(!dir.exists()) dir.mkdirs();
		File file = new File(dir, "MyClass.dat");
		
		MyClass obj  =new MyClass();
		obj.name = "홍길동"; //멤버변수 값 대입
		
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		oos.writeObject(obj);
		oos.close();

	}

}
