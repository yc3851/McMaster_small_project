import java.util.ArrayList;
import java.util.EventObject;

public class DetailEvent extends EventObject {
	
	String resultList;
	public DetailEvent(Object source, String string) {
		super(source);
		
		this.resultList = string;
		
	}
	public String getResult() {
		return this.resultList;
	}
}
