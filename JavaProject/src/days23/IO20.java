package days23;

import java.io.*;
import java.util.ArrayList;

public class IO20 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File dir = new File("C:\\StudybyMyself\\JavaProject\\temp");
		if(!dir.exists()) dir.mkdirs();
		File file = new File(dir, "2021_11_18_09_39.dat");
		
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		
		ArrayList<CalculatorResult> list = (ArrayList<CalculatorResult>)ois.readObject();
		
		for(int i = 0; i<list.size(); i++) System.out.printf("%d. %s \n", i+1, list.get(i));
		ois.close();
		
	}
}
