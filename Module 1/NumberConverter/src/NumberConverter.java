/**
 * The NumberConverter program takes an input string and converts it to the selected data type.
 * 
 * @author Travis Breon
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NumberConverter implements ActionListener{


	public static void main(String[] args) {
		new NumberConverter().Menu();
	}


	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton binToHex = new JButton();
	JButton binToDec = new JButton();
	JButton hexToBin = new JButton();
	JButton hexToDec = new JButton();
	JButton decToHex = new JButton();
	JButton decToBin = new JButton();
	
	//Menu class creates the GUI for the application
	private void Menu() {		
		frame.setVisible(true);
		frame.add(panel);
		panel.add(binToHex);
		panel.add(binToDec);
		panel.add(hexToBin);
		panel.add(hexToDec);
		panel.add(decToHex);
		panel.add(decToBin);
		binToHex.setText("Bin to Hex");
		binToDec.setText("Bin to Dec");
		hexToBin.setText("Hex to Bin");
		hexToDec.setText("Hex to Dec");
		decToHex.setText("Dec to Hex");
		decToBin.setText("Dec to Bin");
		frame.pack();
		binToHex.addActionListener(this);
		binToDec.addActionListener(this);
		hexToBin.addActionListener(this);
		hexToDec.addActionListener(this);
		decToHex.addActionListener(this);
		decToBin.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String input = JOptionPane.showInputDialog("Enter A Value");
		if(e.getSource() == binToHex) {
			binary.convertToHexadecminal(input);
		}
		else if(e.getSource() == binToDec) {
			binary.convertToDecimal(input);
		}
		else if(e.getSource() == hexToBin) {
			hexadecimal.convertToBinary(input);
		}
		else if(e.getSource() == hexToDec) {
			hexadecimal.convertToDecimal(input);
		}
		else if(e.getSource() == decToBin) {
			decimal.convertToBinary(input);
		}
		else if(e.getSource() == decToHex) {
			decimal.convertToHexidecimal(input);
		}
	}
	
	/*
	 * This class contains the convertToHexadecminal and convertToDecimal methods
	 */
	public static class binary {
		/*
		 * This method converts binary to hexadecimal
		 */
		public static void convertToHexadecminal(String input) {
			String binary;
			StringBuilder hexadecimal = new StringBuilder();
			if(input.length()%4==1) {
				 binary = "000" + input;
			}
			else if(input.length()%4==2) {
				 binary = "00" + input;
			}
			else if(input.length()%4==3) {
				 binary = "0" + input;
			}
			else {
				 binary = input;
			}
			int initial = 1;
		    int sum = 0;
		    for(int i = 0; i < binary.length(); i++){
		        if(initial == 1)
		            sum+=Integer.parseInt(binary.charAt(i) + "")*8;
		        else if(initial == 2)
		            sum+=Integer.parseInt(binary.charAt(i) + "")*4;
		        else if(initial == 3)
		            sum+=Integer.parseInt(binary.charAt(i) + "")*2;
		        else if(initial == 4 || i < binary.length()+1){
		            sum+=Integer.parseInt(binary.charAt(i) + "")*1;
		            initial = 0;
		            if(sum < 10)
		                hexadecimal.append(sum);
		            else if(sum == 10)
		            	hexadecimal.append("A");
		            else if(sum == 11)
		            	hexadecimal.append("B");
		            else if(sum == 12)
		            	hexadecimal.append("C");
		            else if(sum == 13)
		            	hexadecimal.append("D");
		            else if(sum == 14)
		            	hexadecimal.append("E");
		            else if(sum == 15)
		            	hexadecimal.append("F");
		            sum=0;
		        }
		        initial++; 
		    }
		    JOptionPane.showMessageDialog(null, "Binary conversion to hexadecimal is: " + hexadecimal);
		  }
		
		/*
		 * This method converts binary to decimal
		 */
		public static void convertToDecimal(String input) {
			int decimal = 0;
			for(int i = 0; i < input.length(); i++){
				if(input.charAt(i)=='1') {
				decimal = (int) (decimal + Math.pow(2,  input.length()-1-i));
			}
			}
			JOptionPane.showMessageDialog(null, "Binary conversion to decimal is: " + decimal);
		  }
	}
	
	/*
	 * This class contains the convertToBinary and convertToHexidecimal methods
	 */
	public static class decimal {
		/*
		 * This method converts decimal to binary
		 */
		public static void convertToBinary(String number) {
			StringBuilder binary = new StringBuilder();
			int inumber = Integer.parseInt(number);
			while(inumber>0) {
			binary.append(inumber%2);
			inumber = inumber/2;
			}
			JOptionPane.showMessageDialog(null, "Decimal conversion to binary is: " + binary.reverse());
		  }
		/*
		 * This method converts decimal to hexadecimal
		 */
		public static void convertToHexidecimal(String number) {
			String digits = "0123456789ABCDEF";
			String hexidecimal = "";
	        if (Integer.parseInt(number) == 0) {
	        	hexidecimal="0";
	        }
	        int d=Integer.parseInt(number);
	        while (d > 0) {
	            int n = d % 16;
	            hexidecimal = digits.charAt(n) + hexidecimal;  
	            d = d / 16;
	        }
	        JOptionPane.showMessageDialog(null, "Decimal conversion to hexidecimal is: " + hexidecimal);
		  }
	}
	
	/*
	 * This class contains the convertToBinary and convertToDecimal methods
	 */
	public static class hexadecimal {
		/*
		 * This method converts hexadecimal to binary
		 */
		public static void convertToBinary(String number) {
			String hex_char,bin_char,binary;
		    binary = "";
		    int len = number.length()/2;
		    for(int i=0;i<len;i++){
		        hex_char = number.substring(2*i,2*i+2);
		        int conv_int = Integer.parseInt(hex_char,16);
		        bin_char = Integer.toBinaryString(conv_int);
		        if(i==0) binary = bin_char; 
		        else binary = binary+bin_char;
		    }
		    JOptionPane.showMessageDialog(null, "Hexadecimal conversion to binary is: " + binary);
		  }
		/*
		 * This method converts hexadecimal to decimal
		 */
		public static void convertToDecimal(String number) {
			String digits = "0123456789ABCDEF";
			number = number.toUpperCase();
            int decimal = 0;
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                int d = digits.indexOf(c);
                decimal = 16*decimal + d;
            }
            JOptionPane.showMessageDialog(null, "Hexadecimal conversion to decimal is: " + decimal);
		  }
	}
}


