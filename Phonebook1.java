
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.PanelUI;


public class Phonebook1 extends JFrame{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static final int FRAME_WIDTH = 670;
   private static final int FRAME_HEIGHT = 70;
     
   private TreeMap<String, String > names = new TreeMap<String, String>();	
   private TreeMap<String, String > numbers = new TreeMap<String, String>();	
   
   
   private JLabel Label;
   private JTextField inputNumber;
   private JTextField inputName;
   private JButton button;
   private JButton button1;
   
   public static void main() {
	
	   
   }
 
   public void InvestmentFrame4(File String){  
	
	   try {
			Scanner scanner = new Scanner(new File("src//PhoneNumbers.txt")); 
			    while (scanner.hasNext()){
			      String rawInfo = scanner.nextLine();
			      
			      String[] info = rawInfo.split(",");
			      
			      String name = info[0];
			      String number = info[1];
			      names.put(name, number);
			      numbers.put(number, name);
			    }
			    scanner.close();
				}	
			catch(Exception e){
				   System.out.println("error");
		}
	   
	 /* balance = INITIAL_BALANCE;
      chart = new ChartComponent3(3 * INITIAL_BALANCE);
      chart.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT));
      chart.append(INITIAL_BALANCE);
            */
      createTextField();
      JButton();
      createPanel();

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   private void createTextField(){
	   
	   inputNumber=new JTextField(15);
		
	   inputNumber.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputNumber.getText();
			}
		});
		
	   inputName=new JTextField(15);
		inputName.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 inputName.getText();
				}
		});
		
   }
   
   private void JButton(){
      button = new JButton("Get Number");      
      button.addActionListener(new ActionListener() {
	  	  public void actionPerformed(ActionEvent event){
	  		if(names.containsKey(inputName.getText())){
				inputNumber.setText(names.get(inputName.getText()));
			}
			else{
				inputNumber.setText("No Number");
				}
	  	   } 
	    });
      	button1 = new JButton("Get Name");
	    
      	button1.addActionListener(new ActionListener() {
	  	  public void actionPerformed(ActionEvent event){
	  		if(numbers.containsKey(inputNumber.getText())){
	  			inputName.setText(numbers.get(inputNumber.getText()));
			}
			else{
				inputName.setText("No Name");
			}
		
	  	   } 
	    });
   }
   
	private static void getContentPanel(JFrame frame) {
		  final int FRAME_WIDTH = 670;
		    final int FRAME_HEIGHT = 70;
		    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		    frame.setTitle("Phonebook Search");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setResizable(false);    		
	}

	private static void setVisible(JFrame frame) {
		frame.setVisible(true);	
	
	}
	
   private void createPanel(){
      JPanel panel = new JPanel();
      panel.add(Label);
      panel.add(button);
      panel.add(button1);
      panel.add(inputNumber);
      panel.add(inputName);
      add(panel);
   }
}