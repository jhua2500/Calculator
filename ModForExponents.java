import java.util.ArrayList;

public class ModForExponents {
	int i = -1;
		
	public void modify(ArrayList<String> nList, ArrayList<String> oList)
	{
		double x = 0, y = 0;
		
		while (oList.contains("^")) {
			i = oList.indexOf("^");		
			x = Double.parseDouble(nList.get(i));
			y = Double.parseDouble(nList.get(i+1));							
			nList.set(i, Double.toString(Math.pow(x, y)));
			nList.remove(i+1);
			oList.remove(i);
		}
		return;
	}
}
