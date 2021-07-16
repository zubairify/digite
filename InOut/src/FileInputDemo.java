import java.io.FileInputStream;
import java.io.IOException;

public class FileInputDemo {
	
	public static void main(String[] args) {
		
		String path = "/Volumes/KB/Dump/song.txt";
		FileInputStream istream = null;
		int b = 0;
		byte[] bar = null;
		try {
			istream = new FileInputStream(path);
//			while(true) {
//				b = istream.read();
//				if(b == -1) break;
//				System.out.print((char)b);
//			}
			
			bar = new byte[istream.available()];
			istream.read(bar);
			String str = new String(bar);
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				istream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
