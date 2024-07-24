package SwingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class temp_con extends JFrame{
	 public JTextField inputField;
	    public JComboBox<String> fromUnit;
	    public JComboBox<String> toUnit;
	    public JLabel resultLabel;

	    public temp_con() {
	        setTitle("Temperature Converter");
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        createUI();

	        setVisible(true);
	    }

	    public void createUI() {
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(5, 2, 10, 10));

	        JLabel inputLabel = new JLabel("Enter temperature:");
	        panel.add(inputLabel);

	        inputField = new JTextField();
	        panel.add(inputField);

	        JLabel fromLabel = new JLabel("From:");
	        panel.add(fromLabel);

	        fromUnit = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
	        panel.add(fromUnit);

	        JLabel toLabel = new JLabel("To:");
	        panel.add(toLabel);

	        toUnit = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
	        panel.add(toUnit);

	        JButton convertButton = new JButton("Convert");
	        convertButton.addActionListener(new ConvertAction());
	        panel.add(convertButton);

	        resultLabel = new JLabel("Result:");
	        panel.add(resultLabel);

	        add(panel);
	    }

	    public class ConvertAction implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            try {
	                double inputTemp = Double.parseDouble(inputField.getText());
	                String from = (String) fromUnit.getSelectedItem();
	                String to = (String) toUnit.getSelectedItem();

	                double result = 0;
	                if (from.equals("Celsius")) {
	                    if (to.equals("Fahrenheit")) {
	                        result = celsiusToFahrenheit(inputTemp);
	                    } else if (to.equals("Kelvin")) {
	                        result = celsiusToKelvin(inputTemp);
	                    } else {
	                        result = inputTemp;
	                    }
	                } else if (from.equals("Fahrenheit")) {
	                    if (to.equals("Celsius")) {
	                        result = fahrenheitToCelsius(inputTemp);
	                    } else if (to.equals("Kelvin")) {
	                        result = fahrenheitToKelvin(inputTemp);
	                    } else {
	                        result = inputTemp;
	                    }
	                } else if (from.equals("Kelvin")) {
	                    if (to.equals("Celsius")) {
	                        result = kelvinToCelsius(inputTemp);
	                    } else if (to.equals("Fahrenheit")) {
	                        result = kelvinToFahrenheit(inputTemp);
	                    } else {
	                        result = inputTemp;
	                    }
	                }

	                resultLabel.setText(String.format("Result: %.2f %s", result, to));
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
	            }
	        }

	        public double celsiusToFahrenheit(double celsius) {
	            return (celsius * 9/5) + 32;
	        }

	        public double celsiusToKelvin(double celsius) {
	            return celsius + 273.15;
	        }

	        public double fahrenheitToCelsius(double fahrenheit) {
	            return (fahrenheit - 32) * 5/9;
	        }

	        public double fahrenheitToKelvin(double fahrenheit) {
	            return (fahrenheit - 32) * 5/9 + 273.15;
	        }

	        public double kelvinToCelsius(double kelvin) {
	            return kelvin - 273.15;
	        }

	        public double kelvinToFahrenheit(double kelvin) {
	            return (kelvin - 273.15) * 9/5 + 32;
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new temp_con());
	    }
}
