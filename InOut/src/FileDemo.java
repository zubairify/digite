import java.io.File;
import java.util.Date;

public class FileDemo {
	public static void main(String[] args) {
		String path = "/Volumes/KB/Dump/jstl.pdf";
		
		File file = new File(path);
		
		if(file.exists()) {
			System.out.println(file.getName());
			System.out.println(file.getPath());
			System.out.println(file.getParent());
			
			if(file.isFile()) {
				System.out.println(file.canRead());
				System.out.println(file.canWrite());
				
				Date dt = new Date(file.lastModified());
				System.out.println(dt);
				
				System.out.println(file.length()/1024 + "KB");
			} else {
				String[] content = file.list();
				System.out.println("Content of directory..");
				for (String item : content) 
					System.out.println(item);
			}
		} else
			System.out.println("File does not exist");
	}
}


