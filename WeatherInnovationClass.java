package jl.weatherinnovation;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import java.io.IOException;
import javax.xml.bind.JAXBException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class WeatherInnovationClass {

	private JFrame frame;
	private static String userWord;
	JTextField userInput;
	private JLabel label;
	private JLabel lblPleaseEnterYou;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherInnovationClass window = new WeatherInnovationClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	public WeatherInnovationClass() throws JAXBException, IOException{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	private void initialize() throws JAXBException, IOException{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
			//Create text input field where user enters location in the form of WOEID
		userInput = new JTextField();
		userInput.setToolTipText("ie: John's Creek's WOEID = 12770508");
		userInput.setBounds(104, 152, 205, 33);
		frame.getContentPane().add(userInput);
		userInput.setColumns(10);
		
			//Create the submit button
		JButton btnSubmitWoeid = new JButton("Submit");
		btnSubmitWoeid.addActionListener( (e)-> {
			try {
				submitAction();
			} catch (JAXBException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnSubmitWoeid.setBounds(148, 196, 118, 23);
		frame.getContentPane().add(btnSubmitWoeid);
		
			//Add weather icon to GUI
		label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/weather.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(94, 11, 92, 99);
		frame.getContentPane().add(label);
		
			//Add company name to GUI
		JLabel lblWeatherinnovation = new JLabel("WeatherInnovation");
		lblWeatherinnovation.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblWeatherinnovation.setBounds(176, 34, 133, 46);
		frame.getContentPane().add(lblWeatherinnovation);
		
			//Add instructions for text field
		lblPleaseEnterYou = new JLabel("Please enter your area's WOEID (Where on Earth Identifier)");
		lblPleaseEnterYou.setBounds(51, 105, 358, 14);
		frame.getContentPane().add(lblPleaseEnterYou);
	}
	
	/**Pass user input from text field to variable 
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	private void submitAction() throws JAXBException, IOException{
		userWord = userInput.getText();
		frame.dispose();
		WeatherView wView = new WeatherView();
		wView.setVisible(true);
	}
	
	/** Returns the WOEID the user input as a string that can be then passed to the YahooWeatherService constructor
	 * 
	 * @return WOEID string
	 */
	public String getWOEID(){
		return userWord;
	}
}
