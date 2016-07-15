import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Axes extends JPanel {
   ArrayList<Double> xVals = new ArrayList<Double>(), yVals = new ArrayList<Double>(), 
		   			  list = new ArrayList<Double>();
   int pass = 1;
      
   public Axes()
   {	   
	   setOpaque( false );
   }
   
   public double getxScale() { return (double)getWidth()/32; }
   public double getyScale() { return (double)getHeight()/32; }
   
   public ArrayList<Double> lines(double x)
   {
	   double w = 0;
	   
	   if (pass == 5) {
		   w = x;
		   x /= 2;
		   pass = 1;
		   for (int j = 0; j < 17; j++)
			   list.add(x+w*j);
	   }
	   else if (pass == 1) {
		   w = x;
		   x /= 2;
		   pass++;
		   list.add(x);
		   return lines(x);
	   }
	   else if (pass == 2) {
		   w = x;
		   x /= 2;
		   list.add(x); list.add(x+w);
		   pass++;
		   return lines(x);
	   }
	   else if (pass == 3) {
		   w = x;
		   x /= 2;
		   list.add(x); list.add(x+w); list.add(x+2*w); list.add(x+3*w);
		   pass++;
		   return lines(x);
	   }
	   else if (pass == 4) {
		   w = x;
		   x /= 2;
		   for (int j = 0; j < 8; j++) 
			   list.add(x+j*w);
		   pass++;
		   return lines(x);
	   }
	   pass = 1;
	   return list; 
   }
   
   public void paintComponent( Graphics g )
   {
	   double x=0, y=0;
	   super.paintComponent(g);
	   Graphics2D g2 = (Graphics2D) g;

	   xVals.clear();
	   xVals = lines((double)getWidth());
	   for (int j = 0; j < xVals.size(); j++) {
		   if (xVals.get(j) == (double)getWidth()/2) {
			   g2.setColor(Color.black);
			   g2.draw(new Line2D.Double(xVals.get(j), 0, xVals.get(j), getHeight()));
			   x = xVals.get(j);
		   }
		   else {
			   g2.setColor(Color.lightGray);
			   g2.draw(new Line2D.Double(xVals.get(j), 0, xVals.get(j), getHeight()));
		   }
	   }
	   
	   yVals.clear();
	   yVals = lines((double)getHeight());
	   for (int h = 0; h < yVals.size(); h++) {
		   if (yVals.get(h) == (double)getHeight()/2) {
			   g2.setColor(Color.black);
			   g2.draw(new Line2D.Double(0, yVals.get(h), getWidth(), yVals.get(h)));
			   y = yVals.get(h);
		   }
		   else {
			   g2.setColor(Color.lightGray);
			   g2.draw(new Line2D.Double(0, yVals.get(h), getWidth(), yVals.get(h)));
		   }
       }
	   System.out.println("Axes:");
	   System.out.println(getxScale());
	   System.out.println(getyScale());
	   System.out.println("x:"+x);
	   System.out.println("y:"+y+"\n");
	   
	   //PREVIOUS METHOD FOR DRAWING AXES:
	   /*double xScale = getWidth()/32, yScale = getHeight()/32;	
	   super.paintComponent(g);
	   Graphics2D g2 = ( Graphics2D ) g;

	   g2.setColor(Color.lightGray);
	   for (double x = 0; x < getWidth(); x+=xScale) 
			   g2.draw(new Line2D.Double(x, 0, x, getHeight()));
	   
	   for (double y = 0; y < getHeight(); y+=yScale) 			   
			   g2.draw(new Line2D.Double(0, y, getWidth(), y));
			   
	   g2.setColor(Color.black);
	   g2.draw(new Line2D.Double(getWidth()/2, 0, getWidth()/2, getHeight()));
	   g2.draw(new Line2D.Double(0, getHeight()/2, getWidth(), getHeight()/2));
	   //g2.draw(new Line2D.Double(xScale*25, 0, xScale*25, getHeight()));
	   //g2.draw(new Line2D.Double(0, yScale*25, getWidth(), yScale*25));*/
   }	   
} 
