
public class SymbolTable {

	int size;
	Symbol[] symbolTable;

	public SymbolTable(int size){
		this.size = 0;
		this.symbolTable = new Symbol [size];
	}

	public SymbolTable(SymbolTable s){
		symbolTable = new Symbol [s.symbolTable.length];
		this.size = s.size;
		for (int i = 0; i < size; i++)
			symbolTable[i] = s.symbolTable[i];	
	}

	public void add(Symbol s) throws Exception {
		if(contains(s) == -1) {
			if(size == symbolTable.length) throw new Exception("Try to add to full array");
			for (int i = 0; i < symbolTable.length; i++) {
				if(symbolTable[i] == null) {
					symbolTable[i] = new Symbol(s);
					size++;
					break;
				}
			}
		}
	}

	public void remove(Symbol s) throws Exception {
		if(size == 0)throw new Exception("Try to remove from empty array");
		int index = contains(s);
		if(index != -1){
			symbolTable[index] = null;
			size--;
		}
	}

	public int contains(Symbol s) {
		if(s == null) 
			return -1;
		for (int i = 0; i < symbolTable.length; i++) {
			if(symbolTable[i] != null && s.equals(symbolTable[i]))
				return i;
		}
		return -1;
	}

	public void set(String name, int value) throws Exception{
		int i;
		for (i = 0; i < symbolTable.length; i++) {
			if(symbolTable[i] != null && symbolTable[i].getName().equals(name)) {
				symbolTable[i].setValue(value);
				break;
			}
		}
		if(i == symbolTable.length) {
			add(new Symbol(name, value));
		}
	}

	@Override
	public String toString() {
		return "SymbolTable [size=" + size + ", symbolTable=" + symbolTable + "]";
	}

	public static void main(String[] args){
		
		SymbolTable t = new SymbolTable(10); 
		Symbol s1 = new Symbol("shlomi1",1);
		Symbol s2 = new Symbol("shlomi2",2);
		Symbol s3 = new Symbol("shlomi3",3);
		Symbol s4 = new Symbol("shlomi4",4);
		Symbol s5 = new Symbol("shlomi5",5);
		try {
			t.add(s1);
			t.add(s2);
			t.add(s3);
			t.add(s4);
			t.add(s5);
			t.set("shlomi6", 6);
			t.set("shlomi6", 8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < t.size; i++) {
			System.out.println(t.symbolTable[i].name + " " + t.symbolTable[i].value);
		}
		
	}
}

