import java.util.ArrayList;

public class ModPrimaryOperators {
	int i = 0, indexOfMultiply = -1, indexOfDivide = -1;
	
	public int compare(int m, int d)
	{
		if (m < d)
			return m;
		else
			return d;
	}

	public void modify(ArrayList<String> nList, ArrayList<String> oList) 
	{
		String operator = "";
		double x = 0, y = 0;
		
		while (oList.contains("*") || oList.contains("/")) {
			indexOfMultiply = oList.indexOf("*");
			indexOfDivide = oList.indexOf("/");
			
			if (indexOfMultiply == -1 && indexOfDivide != -1) {
				i = indexOfDivide;
				operator = oList.get(i);
			}
			else if (indexOfDivide == -1 && indexOfMultiply != -1) {
				i = indexOfMultiply;
				operator = oList.get(i);
			}
			else if (indexOfDivide != -1 && indexOfMultiply != -1){
				i = compare(indexOfMultiply, indexOfDivide);
				operator = oList.get(i);
			}			
			x = Double.parseDouble(nList.get(i));
			y = Double.parseDouble(nList.get(i+1));				
			switch(operator) {
				case "*":					
					nList.set(i, Double.toString(x * y));
					nList.remove(i+1);
					oList.remove(i);
					break;
				case "/": 
					nList.set(i, Double.toString(x / y));
					nList.remove(i+1);
					oList.remove(i);
		            break;
				default: 
					break;
			}
		}
		return;
	}	
}


