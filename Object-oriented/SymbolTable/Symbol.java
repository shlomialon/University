
public class Symbol {

	String name;
	int value;
	
	public Symbol(String name, int value){
		this.name = name;	
		this.value = value;
	}
	
	public Symbol(Symbol s) {
		this.name = s.name;
		this.value = s.value;
	}

	public boolean equals(Symbol a){
		if(a.name == this.name && a.value == this.value)
			return true;
		else
			return false;
	}

	public String getName() {
		if(name != null)
		return name;
		else return null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
