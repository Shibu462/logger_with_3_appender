public class ServerAppender implements LogAppender{
	
	@Override
	public void append(String message){
		System.out.println("[Sent to Server]" + message);
	}
	
}