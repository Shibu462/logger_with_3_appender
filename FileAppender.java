import java.io.*;

class FileAppender implements LogAppender{
	private String filePath;
	
	public FileAppender(String filePath){
		this.filePath = filePath;
	}
	
	@Override
	public void append(String message){
		try(FileWriter fw = new FileWriter(filePath,true)){
			fw.write(message + "\n");
		}catch(IOException e){
			System.out.println("File write failed.");
		}
	}
}