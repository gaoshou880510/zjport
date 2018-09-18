package cn.gov.learn.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class FileWirte {
	
	
	public static void main(String[] args) {
		 String filepath= "E:\\test.txt";
		 checkFile(filepath);
		 
		 writeContent("username,pwd\n",filepath,true);
		 for(int i=0;i<100;i++){
		   writeContent("abc"+i+",test"+i+"\n",filepath,true);
		 }
		 //writeContent("username,pwd\n",filepath,true);
	}
	/**
	 * 写入内容到文件
	 *
	 * @param number
	 * @param filename
	 * @return
	 */
	public static boolean writeContent(String c, String path, boolean isAppend) {
		File f = new File(path);
		try {
			FileOutputStream fos = new FileOutputStream(path, isAppend);
			OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
			writer.write(c);
			writer.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	  
	public static void checkFile(String filepath) {
		File f = new File(filepath);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		} else {
			f.delete();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
