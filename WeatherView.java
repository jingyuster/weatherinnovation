package jl.weatherinnovation;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.Forecast;
import com.github.fedy2.weather.data.unit.DegreeUnit;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class WeatherView extends JFrame {

	/**
	 * Auto generated content
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	WeatherInnovationClass wInClass = new WeatherInnovationClass();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherView frame = new WeatherView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 */
	public WeatherView() throws JAXBException, IOException{
		
			//Look up weather information for location user has input and create list with info
		YahooWeatherService service = new YahooWeatherService();
		Channel result = service.getForecast(wInClass.getWOEID(), DegreeUnit.FAHRENHEIT);
		List<Forecast> fCasts = result.getItem().getForecasts();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			//Create labels for columns of information
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(23, 11, 46, 14);
		contentPane.add(lblDay);
		
		JLabel lblHigh = new JLabel("High");
		lblHigh.setBounds(161, 11, 46, 14);
		contentPane.add(lblHigh);
		
		JLabel lblLow = new JLabel("Low");
		lblLow.setBounds(91, 11, 46, 14);
		contentPane.add(lblLow);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(217, 11, 207, 14);
		contentPane.add(lblDescription);
		
			//Label which day corresponds with forecast
		JLabel lblNewLabel = new JLabel(fCasts.get(0).getDay().toString());
		lblNewLabel.setBounds(23, 43, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(fCasts.get(1).getDay().toString());
		lblNewLabel_1.setBounds(23, 83, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(fCasts.get(2).getDay().toString());
		lblNewLabel_2.setBounds(23, 124, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(fCasts.get(3).getDay().toString());
		lblNewLabel_3.setBounds(23, 164, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(fCasts.get(4).getDay().toString());
		lblNewLabel_4.setBounds(23, 203, 46, 14);
		contentPane.add(lblNewLabel_4);
		
			//List the low temperatures for each day
		JLabel lblNewLabel_5 = new JLabel("" + fCasts.get(0).getLow());
		lblNewLabel_5.setBounds(91, 43, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("" + fCasts.get(1).getLow());
		lblNewLabel_6.setBounds(91, 83, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("" + fCasts.get(2).getLow());
		lblNewLabel_7.setBounds(91, 124, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("" + fCasts.get(3).getLow());
		lblNewLabel_8.setBounds(91, 164, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("" + fCasts.get(4).getLow());
		lblNewLabel_9.setBounds(91, 203, 46, 14);
		contentPane.add(lblNewLabel_9);
		
			//List the high temperaturs for each day
		JLabel lblNewLabel_10 = new JLabel("" + fCasts.get(0).getHigh());
		lblNewLabel_10.setBounds(161, 43, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("" + fCasts.get(1).getHigh());
		lblNewLabel_11.setBounds(161, 83, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("" + fCasts.get(2).getHigh());
		lblNewLabel_12.setBounds(161, 124, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("" + fCasts.get(3).getHigh());
		lblNewLabel_13.setBounds(161, 164, 46, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("" + fCasts.get(4).getHigh());
		lblNewLabel_14.setBounds(161, 203, 46, 14);
		contentPane.add(lblNewLabel_14);
		
			//Label the conditions for each forecast
		JLabel lblNewLabel_15 = new JLabel("" + fCasts.get(0).getText());
		lblNewLabel_15.setBounds(217, 43, 207, 14);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("" + fCasts.get(1).getText());
		lblNewLabel_16.setBounds(217, 83, 207, 14);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("" + fCasts.get(2).getText());
		lblNewLabel_17.setBounds(217, 124, 207, 14);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("" + fCasts.get(3).getText());
		lblNewLabel_18.setBounds(217, 164, 207, 14);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("" + fCasts.get(4).getText());
		lblNewLabel_19.setBounds(217, 203, 207, 14);
		contentPane.add(lblNewLabel_19);
	}

}
