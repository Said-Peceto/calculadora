package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculadoraGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textField;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator = ' ';

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    calculadoraGUI frame = new calculadoraGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public calculadoraGUI() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 324, 374);
        contentPane = new JPanel();
        contentPane.setBorder(UIManager.getBorder("DesktopIcon.border"));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Calculadora basica");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 11, 272, 27);
        contentPane.add(lblNewLabel);

        for (int i = 0; i < 10; i++) {
            JButton numButton = new JButton(String.valueOf(i));
            numButton.setBounds(11 + (i % 3) * 99, 131 + (i / 3) * 34, 89, 23);
            numButton.addActionListener(new NumberButtonListener(i));
            contentPane.add(numButton);
        }

        textField = new JTextField();
        textField.setBounds(10, 38, 288, 48);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnigual = new JButton("=");
        btnigual.setBounds(209, 233, 89, 23);
        btnigual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case 'x':
                        result = num1 * num2;
                        break;
                    case '÷':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            textField.setText("Error");
                            return;
                        }
                        break;
                }
                textField.setText(String.valueOf(result));
            }
        });
        contentPane.add(btnigual);
        
        JButton btnresta = new JButton("-");
        btnresta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnresta.setBounds(110, 267, 89, 23);
        btnresta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = '-';
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
            }
        });
        contentPane.add(btnresta);

        JButton btnSuma = new JButton("+");
        btnSuma.setBounds(209, 267, 89, 23);
        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = '+';
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
            }
        });
        contentPane.add(btnSuma);

        JButton btnDivision = new JButton("÷");
        btnDivision.setBounds(10, 267, 89, 23);
        btnDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = '÷';
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
            }
        });
        contentPane.add(btnDivision);

        JButton btnborrar = new JButton("Borrar");
        btnborrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentText = textField.getText();
                if (!currentText.isEmpty()) {
                    textField.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });
        btnborrar.setBounds(209, 301, 89, 23);
        contentPane.add(btnborrar);

        JButton btnReinicio = new JButton("C");
        btnReinicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                num1 = num2 = result = 0;
                operator = ' ';
            }
        });
        btnReinicio.setBounds(209, 97, 89, 23);
        contentPane.add(btnReinicio);
        

		JButton btnmultiplicación = new JButton("x");
		btnmultiplicación.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		btnmultiplicación.setBounds(110, 233, 89, 23);
		btnmultiplicación.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        operator = 'x';
		        num1 = Double.parseDouble(textField.getText());
		        textField.setText("");
		    }
		});
		contentPane.add(btnmultiplicación);

        
    }

    private class NumberButtonListener implements ActionListener {
        private int number;

        public NumberButtonListener(int number) {
            this.number = number;
        }

        public void actionPerformed(ActionEvent e) {
            textField.setText(textField.getText() + number);
        }
    }
}
