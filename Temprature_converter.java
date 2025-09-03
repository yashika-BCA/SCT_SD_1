package Temprature_converter_GUI_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temprature_converter {
    JFrame frame;

    public Temprature_converter() {
        frame = new JFrame("Temperature Converter");
        frame.setSize(600, 600); // Narrower width, taller height
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 10, 20, 10); // Extra vertical spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        Font font = new Font("Arial", Font.PLAIN, 30); // Scaled font

        // Label: Enter Temperature
        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(inputLabel, gbc);

        // TextField: Temperature Input
        JTextField inputField = new JTextField();
        inputField.setFont(font);
        inputField.setPreferredSize(new Dimension(160, 70));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(inputField, gbc);

        // Dropdown: From Unit
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> fromUnitBox = new JComboBox<>(units);
        fromUnitBox.setFont(font);
        fromUnitBox.setPreferredSize(new Dimension(140, 60));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        frame.add(fromUnitBox, gbc);

        // Label: To
        JLabel toLabel = new JLabel("To");
        toLabel.setFont(font);
        toLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(toLabel, gbc);

        // Dropdown: To Unit
        JComboBox<String> toUnitBox = new JComboBox<>(units);
        toUnitBox.setFont(font);
        toUnitBox.setPreferredSize(new Dimension(140, 60));
        gbc.gridx = 2;
        gbc.gridy = 1;
        frame.add(toUnitBox, gbc);

        // Button: Convert
        JButton convertButton = new JButton("Convert");
        convertButton.setFont(font);
        convertButton.setPreferredSize(new Dimension(90, 50));
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(convertButton, gbc);

        // Button: Reset
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(font);
        resetButton.setPreferredSize(new Dimension(90, 50));
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(resetButton, gbc);

        // Button: Exit
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(font);
        exitButton.setPreferredSize(new Dimension(90, 50));
        gbc.gridx = 2;
        gbc.gridy = 2;
        frame.add(exitButton, gbc);

        // Label: Result
        JLabel resultLabel = new JLabel("Converted Value:");
        resultLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        frame.add(resultLabel, gbc);

        // Convert Logic
        convertButton.addActionListener(e -> {
            try {
                double inputTemp = Double.parseDouble(inputField.getText());
                String fromUnit = (String) fromUnitBox.getSelectedItem();
                String toUnit = (String) toUnitBox.getSelectedItem();
                double result = 0;

                if (fromUnit.equals(toUnit)) {
                    result = inputTemp;
                } else if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
                    result = (inputTemp * 9 / 5) + 32;
                } else if (fromUnit.equals("Celsius") && toUnit.equals("Kelvin")) {
                    result = inputTemp + 273.15;
                } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
                    result = (inputTemp - 32) * 5 / 9;
                } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Kelvin")) {
                    result = ((inputTemp - 32) * 5 / 9) + 273.15;
                } else if (fromUnit.equals("Kelvin") && toUnit.equals("Celsius")) {
                    result = inputTemp - 273.15;
                } else if (fromUnit.equals("Kelvin") && toUnit.equals("Fahrenheit")) {
                    result = ((inputTemp - 273.15) * 9 / 5) + 32;
                }

                resultLabel.setText("Converted Value: " + String.format("%.2f", result) + " " + toUnit);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Reset Logic
        resetButton.addActionListener(e -> {
            inputField.setText("");
            fromUnitBox.setSelectedIndex(0);
            toUnitBox.setSelectedIndex(0);
            resultLabel.setText("Converted Value:");
        });

        // Exit Logic
        exitButton.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Temprature_converter();
    }
}
