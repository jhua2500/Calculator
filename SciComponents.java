import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SciComponents extends JFrame {
	JTabbedPane tPane;
	JPanel panel1;
	JButton zero, one, two, three, four, five, six, seven, eight, nine, plus, minus, 
    divide, multiply, clr, del, calc, point, pi, power, log, ans, sin, cos, tan, pars;
	JTextArea inputArea;
	JScrollPane scroll;
    DecimalFormat df = new DecimalFormat("0.00000");
    Solve s = new Solve();
    ArrayList<String> parsList = new ArrayList<String>();
	   	      
	public SciComponents()
	{
        setLayout( new BorderLayout() );
		tPane = new JTabbedPane();
		add( tPane );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setSize( 500, 500 );
		setResizable( true );
		setTitle( "Calculator" );

		panel1 = new JPanel( new GridBagLayout() );
		tPane.addTab( "Scientific", panel1 );

		zero = new JButton( "0" );
		zero.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "0" );
			}
		   }
		);
		one = new JButton( "1" );
		one.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "1" );
			}
		   }
		);
		two = new JButton( "2" );
		two.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "2" );
			}
		   }
		);
		three = new JButton( "3" );
		three.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "3" );
			}
		   }
		);
		four = new JButton( "4" );
		four.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "4" );
			}
		   }
		);
		five = new JButton( "5" );
		five.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "5" );
			}
		   }
		);
		six = new JButton( "6" );
		six.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "6" );	
			}
		   }
		);
		seven = new JButton( "7" );
		seven.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "7" );
			}
		   }
		);
		eight = new JButton( "8" );
		eight.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "8" );
			}
		   }
		);
		nine = new JButton( "9" );
		nine.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "9" );
			}
		   }
		);
		plus = new JButton( "+" );
		plus.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "+" );
			}
		   }
		);
		minus = new JButton( "-" );
		minus.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "-" );
			}
		   }
		);
		divide = new JButton( "/" );
		divide.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "/" );
			}
		   }
		);
		multiply = new JButton( "* " );
		multiply.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "*" );
			}
		   }
		);
		clr = new JButton( "CLR" );
		clr.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.setText( "" );
			   s.holdOperator = "";
			   s.operator = "";
			   s.holdNum = 0;
			   s.num = 0;
			   s.runningAnswer = 0;
			   s.numList.clear();
			   s.opList.clear();
			   parsList.clear();
			}
		   }
		);
		del = new JButton( "DEL" );
		del.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "\b" );
			}
		   }
		);
		ans = new JButton( "ANS" );
		ans.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( Double.toString( s.prevAnswer ) );
			}
		   }
		);
		point = new JButton( "." );
		point.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "." );
			}
		   }
		);
		pi = new JButton( "PI" );
		pi.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "pi" );
			}
		   }
		);
		power = new JButton( "EXP" );
		power.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "^" );
			}
		   }
		);
		log = new JButton( "LOG" );
		log.addActionListener (
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   inputArea.append( "log(" );
			   parsList.add("(");
			}
		   }
		);
		calc = new JButton( "CALCULATE" );
		calc.addActionListener(
		   new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
			   String equation = inputArea.getText(); 
			   s.expBuff = new StringBuffer(equation);
			   
			   while (s.expBuff.indexOf("(") != -1) {
				   new Parentheses(s.expBuff);
			   }
			   
			   //return new buff
			   s.execute();
			   String answer = df.format(s.runningAnswer);
			   inputArea.append( "\n" + answer );
			   s.prevAnswer = s.runningAnswer;
			}
		   }
		);
		sin = new JButton("SIN");
		sin.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						inputArea.append("sin(");
						parsList.add("(");
					}
				}
		);
		cos = new JButton("COS");
		cos.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						inputArea.append("cos(");
						parsList.add("(");
					}
				}
		);
		tan = new JButton("TAN");
		tan.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						inputArea.append("tan(");
						parsList.add("(");
					}
				}
		);
		pars = new JButton("(   )");
		pars.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int l = parsList.size();
						if (l != 0 && parsList.get(l-1) == "(") {
							inputArea.append(")");
							parsList.add(")");
						}
						else if (l != 0 && parsList.get(l-1) == ")") {
							inputArea.append("(");
							parsList.add("(");
						}
						else {
							inputArea.append("(");
							parsList.add("(");
						}
					}
				}
		);
		inputArea = new JTextArea();
		inputArea.setLineWrap( true );
		inputArea.setBorder(
		   BorderFactory.createLoweredBevelBorder() );
		scroll = new JScrollPane( inputArea );
		scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		scroll.setPreferredSize( new Dimension( 100, 75 ) );
	   }
}   
