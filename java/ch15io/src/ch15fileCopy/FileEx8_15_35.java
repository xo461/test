package ch15fileCopy;

import java.io.File;

class FileEx8_15_35 {
	static int deleteFiles = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1) {
			System.out.println("USAGE : java FileEx8 Extension");
			System.exit(0);
		}
		
		String currDir = System.getProperty("user.dir");
		
		File dir = new File(currDir);
		String ext = "." + args[0];
		
		delete(dir, ext);
		System.out.println(deleteFiles + "개의 파일이 삭제되었습니다.");
		
	}
	public static void delete(File dir, String ext){
		File[] files = dir.listFiles();
		
		for(int i=0; i < files.length; i++) {
			if(files[i].isDirectory()) {
				delete(files[i], ext);
			}else {
				String filename = files[i].getAbsolutePath();
				
				if(filename.endsWith(ext)) {
					System.out.println(filename);
					if(files[i].delete()) {
						System.out.println("- 삭제성공");
						deleteFiles++;
					}else {
						System.out.println();
					}
				}
			}
		}
	}	
}

