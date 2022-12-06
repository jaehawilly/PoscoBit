package Pack01;

import java.util.List;

//<input type="text" name="item[0]" value="tiger0" /><br/>
public class Animal{
	List<String> item;

	public List<String> getItem() {
		return item;
	}

	public void setItem(List<String> item) {
		this.item = item;
	}
}