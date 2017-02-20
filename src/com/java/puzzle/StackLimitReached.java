
public class StackLimitReached extends Exception{
	
	public StackLimitReached(String message){
		super(message);
	}
	public StackLimitReached(){
		super("Stack limit has reached cannot add elements");
	}
}
