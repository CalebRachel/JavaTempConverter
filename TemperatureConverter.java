import javax.swing.*;
import java.awt.*;

public class TemperatureConverter extends JFrame {
    private JTextField textFieldFahrenheit;
    private JLabel labelCelsius;

    public TemperatureConverter() {
        super("Fahrenheit to Celsius Converter");

        textFieldFahrenheit = new JTextField(10);
        JButton buttonConvert = new JButton("Convert to Celsius");
        labelCelsius = new JLabel("Celsius result will be shown here");

        // Use lambda expression for ActionListener
        buttonConvert.addActionListener(e -> performConversion());

        JPanel contentPanel = new JPanel(new FlowLayout());
        contentPanel.add(textFieldFahrenheit);
        contentPanel.add(buttonConvert);
        contentPanel.add(labelCelsius);

        this.setContentPane(contentPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 100);
        this.setLocationRelativeTo(null); // Center the window
        this.setVisible(true);
    }

    private void performConversion() {
        try {
            double fahrenheit = Double.parseDouble(textFieldFahrenheit.getText());
            double celsius = (fahrenheit - 32) * 5.0 / 9.0;

            labelCelsius.setText(String.format("%.2f Celsius", celsius));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid numeric value for Fahrenheit.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TemperatureConverter::new);
    }
}
