package days23;


import java.io.*;
import java.util.ArrayList;

public class IO18 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File dir = new File("C:\\Users\\JAVA01\\git\\repository\\JavaProject\\temp");
		if(!dir.exists()) dir.mkdirs();
		File file = new File(dir, "Point.dat");
		
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		ArrayList<Point> list;
		list = (ArrayList<Point>) ois.readObject();
		
		for (int i=0; i<list.size(); i++) {
			System.out.printf("%s ", list.get(i).toString());

		if((i+1) % 5==0) System.out.println();
		}

	}

}
