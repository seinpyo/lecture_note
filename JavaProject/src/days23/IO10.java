package days23;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IO10 {
	public static void main(String[] args) throws IOException {
		
		File dir = new File("C:\\Users\\JAVA01\\git\\repository\\JavaProject\\temp");
		if(!dir.exists()) dir.mkdirs();
		
		File file_text = new File(dir, "abc.txt");
		
		FileWriter fos_text = new FileWriter(file_text);

		fos_text.write("선거에 있어서 \"최고 득표자\"가 2인이상인 때에는 국회의 "
				+ "재적의원 과반수가 출석한 공개회의에서 다수표를 얻은 자를 \"당선자\"로 한다.");
		fos_text.write("이 헌법 시행 당시의 법령과 조약은 이 헌법에 위배되지 "
				+ "아니하는 한 그 효력을 지속한다.");
		fos_text.write("\n\n\n");
		fos_text.write("국회의 회의는 공개한다. 다만, 출석 위원 50% 이상의 찬성이 있거나 "
				+ "의장이 국가의 안정 보장을 위하여 필요하다고 인정할 때에는 공개하지 아니할 수 있다.");
		fos_text.write("\n\n\n");
		fos_text.close(); 
	}

}
