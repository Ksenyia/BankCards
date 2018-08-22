package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import by.task.service.validator.Validator;

public class Main extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1139303839249714718L;
	private JButton button = new JButton("Press");
	private JTextField inputNumber = new JTextField("", 5);
	private JLabel labelNumber = new JLabel("Input Number \n Use only number, space or \'-\':");
	private JLabel buttonLabel = new JLabel("Press button :");
	private JRadioButton radioVisa = new JRadioButton("Visa");
	private JRadioButton radioMasterCard = new JRadioButton("MasterCard");
	private JRadioButton radioAE = new JRadioButton("AMERICAN EXPRESS");
	private JRadioButton radioMaestro = new JRadioButton("Cirrus/Maestro");
	private JRadioButton radioDC = new JRadioButton("Diners Club — USA & Canada");
	private JRadioButton radioJCB = new JRadioButton("JCB");
	private JRadioButton radioDiscover = new JRadioButton("Discover");
	private JRadioButton radioDCInternational = new JRadioButton("Diners Club — International");
	private JRadioButton radioLaser = new JRadioButton("Laser");
	private JRadioButton radioVisaElectron = new JRadioButton("Visa Electron");
	private JRadioButton radioInstaPayment = new JRadioButton("InstaPayment");
	private JRadioButton radioDCCarteBlanche = new JRadioButton("Diners Club — Carte Blanche");
	
	public Main() {
	    super("Bank cards");
	    this.setBounds(100,100,550,550);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    Container container = this.getContentPane();
	    container.setLayout(new GridLayout(0,2));
	    ButtonGroup group = new ButtonGroup();
	    group.add(radioVisa);
	    group.add(radioMasterCard);
	    group.add(radioAE);
	    group.add(radioMaestro);
	    group.add(radioDC);
	    group.add(radioJCB);
	    group.add(radioDiscover);
	    group.add(radioDCInternational);
	    group.add(radioLaser);
	    group.add(radioVisaElectron);
	    group.add(radioDCCarteBlanche);
	    group.add(radioInstaPayment);
	    container.add(radioVisa);
	    container.add(radioMasterCard);
	    container.add(radioAE);
	    container.add(radioMaestro);
	    container.add(radioDC);
	    container.add(radioJCB);
	    container.add(radioDiscover);
	    container.add(radioDCInternational);
	    container.add(radioLaser);
	    container.add(radioVisaElectron);
	    container.add(radioDCCarteBlanche);
	    container.add(radioInstaPayment);
	    container.add(labelNumber);
	    container.add(inputNumber);


	    button.addActionListener((ActionListener) new ButtonEventListener());
	    container.add(buttonLabel);
	    container.add(button);
	}
	
	class ButtonEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String replacement = "";
			String message = replacement;
			int cardNumbersLength[] = getNumberLength();
			String space = " ";
			String dash = "-";
			String cardNumber = inputNumber.getText().trim().replaceAll(dash,replacement).replaceAll(space,replacement);
			String regex = "\\d+";
			if(!cardNumber.matches(regex)){
				message += "Error\n It should be number or \'-\' or space";
			}
			else{
				message = Validator.validate(cardNumber,cardNumbersLength);
			}
			String title = "Output";
			JOptionPane.showMessageDialog(null,
		    		message,
		    		title,
		    	    JOptionPane.PLAIN_MESSAGE);
		}

		private int[] getNumberLength() {
			int number[] = new int[2];
			if (radioAE.isSelected()){
				number[0] = 15;
				number[1] = 15;
			}
			if (radioVisa.isSelected()){
				number[0] = 13;
				number[1]= 16;
			}
			if (radioMasterCard.isSelected()||radioMaestro.isSelected()
					||radioLaser.isSelected()){
				number[0] = 16;
				number[1] = 19;
			}
			if (radioDC.isSelected()||radioJCB.isSelected()||
					radioVisaElectron.isSelected()||radioInstaPayment.isSelected()){
				number[0] = 16;
				number[1] = 16;
			}
			if (radioDiscover.isSelected()||radioDCInternational.isSelected()||
					radioDCCarteBlanche.isSelected()){
				number[0] = 14;
				number[1] = 14;
			}
			return number;
		}
	}


	public static void main(String[] args) {
		Main app = new Main();
		app.setVisible(true);
	}

}
