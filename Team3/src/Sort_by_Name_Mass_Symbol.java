import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*; 



class Elements{

public String name;
public int a_numb;
public int state;
public int group;
public String symbol;
public float a_mass;

	public Elements(String name,int a_numb,int group,int state,String symbol,float a_mass) {
	    super();
	    this.name = name;
	    this.a_mass = a_mass;
	    this.group = group;
	    this.symbol = symbol;
	    this.state = state;
	    this.a_numb = a_numb;
	}

	public float getMass() {
		return a_mass;
	}
	public String getName() {
		return name;
	}
	public float getNum() {
		return a_numb;
	}
	public int getState() {
		return state;
	}
	public int getGroup() {
		return group;
	}
	public String getSymbol() {
		return symbol;
	}

	

	@Override
	public String toString() {
	    return String.format("%4d%10s%16s%17f%8d%8d\n",a_numb,name,symbol,a_mass,state,group);
	}
}
class sort_name implements Comparator<Elements> 
{ 
    public int compare(Elements a, Elements b) 
    { 
        return a.name.compareTo(b.name); 
    } 
} 
class sort_symbol implements Comparator<Elements> 
{ 
    public int compare(Elements a, Elements b) 
    { 
        return a.symbol.compareTo(b.symbol); 
    } 
} 

class sort_mass implements Comparator<Elements>{
	public int compare(Elements a, Elements b) {
	    if (a.getMass() > b.getMass()) {
	      return -1;
	    }
	    if (a.getMass() < b.getMass()) {
	      return 1;
	    }
	    return 0;
		}

}



public class Sort_by_Name_Mass_Symbol {

public static final String CSV_PATH = "elements.csv";
public static boolean append = true;
public static ArrayList<String> aList = new ArrayList<String>();

public static void main(String[] args) throws IOException {

    readFile(CSV_PATH);
    ArrayList<Elements> lists = convertToElements(aList); 
    System.out.println("ordered by name:");
    System.out.println("Atomic# | Symbol |     Name      |   Atomic Mass  | State | Group |");
    System.out.println("-------------------------------------------------------------------");
    Collections.sort(lists, new sort_name());
    for(Elements list : lists){	
        System.out.println(list.toString());
    }
    
    System.out.println("ordered by symbol:");
    System.out.println("Atomic# | Symbol |     Name      |   Atomic Mass  | State | Group |");
    System.out.println("-------------------------------------------------------------------");
    Collections.sort(lists, new sort_symbol());
    for(Elements list : lists){	
        System.out.println(list.toString());
    }
    
    System.out.println("ordered by mass:");
    System.out.println("Atomic# | Symbol |     Name      |   Atomic Mass  | State | Group |");
    System.out.println("-------------------------------------------------------------------");
    Collections.sort(lists, new sort_mass());
    for(Elements list : lists){	
        System.out.println(list.toString());
    }
}

public static ArrayList<String> readFile(String path) throws IOException{

    FileReader fr = new FileReader(path);
    BufferedReader bf = new BufferedReader(fr);
    String line = null;
    while( (line = bf.readLine()) != null){
        aList.add(line);
    }
    bf.close();

    return aList;

}

		public static ArrayList<Elements>convertToElements(ArrayList<String> elementsStrings) {
		    ArrayList<Elements> elements = new ArrayList<>();
		    elementsStrings.remove(0);
		    for(String elementString : elementsStrings) {
		        String[] parts = elementString.split(",");
		        int a_numb = Integer.valueOf(parts[0]);
		        String name = parts[2];
		        String symbol = parts[1];
		        float a_mass = Float.valueOf(parts[3]);
		        int state = Integer.valueOf(parts[4]);
		        int group = Integer.valueOf(parts[5]);
		        elements.add(new Elements(name,a_numb,group,state,symbol,a_mass));
		    }
		    return elements;
		}
}



