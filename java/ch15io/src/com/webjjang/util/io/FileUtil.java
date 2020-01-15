package com.webjjang.util.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	public static boolean copy(String source, String target) {

		try {
			
			FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(target);

	
			int data = 0;
			// 입력 파일 객체에서 데이터를 읽어 왔을때 -1인경우 데이터가 없는 경우이다.
			while ((data = fis.read()) != -1) {
				
				fos.write(data);
			}
			fis.close();
			fos.close();
			return true;
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

}

