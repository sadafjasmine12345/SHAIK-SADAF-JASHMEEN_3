//AWT Components: The program uses Frame, TextField, Button, and Panel components from the AWT package.
//Event Handling: The program implements the ActionListener interface to handle button clicks.
//Exception Handling: Basic try-catch blocks handle potential exceptions, such as number format exceptions.
//Layout Management: The GridLayout is used to arrange the buttons neatly, and BorderLayout is used to arrange the display and panel within the frame.
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    // Declaring components
    TextField display;
    Button[] numberButtons = new Button[10];
    Button addButton, subButton, mulButton, divButton, eqButton, clrButton;
    Panel panel;

    // Variables to hold operands and the result
    double num1, num2, result;
    char operator;

    // Constructor to setup the GUI
    public Calculator() {
        // Setting up the frame
        setTitle("CALCULATOR");
        setSize(500, 600);
        setLayout(new BorderLayout());

        // Initializing the display field
        display = new TextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Initializing the panel and buttons
        panel = new Panel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            panel.add(numberButtons[i]);
        }

        // Initializing operator buttons
        addButton = new Button("+");
        subButton = new Button("-");
        mulButton = new Button("*");
        divButton = new Button("/");

        // Initializing equals and clear buttons
        eqButton = new Button("=");
        clrButton = new Button("C");

        // Adding action listeners to operator and control buttons
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        eqButton.addActionListener(this);
        clrButton.addActionListener(this);

        // Adding buttons to the panel
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(eqButton);
        panel.add(clrButton);

        // Adding panel to the frame
        add(panel, BorderLayout.CENTER);

        // Window listener for closing the window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Setting frame visibility
        setVisible(true);
    }

    // Action performed method to handle button clicks
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                // Handling number button clicks
                display.setText(display.getText() + command);
            } else if (command.equals("+")) {
                num1 = Double.parseDouble(display.getText());
                operator = '+';
                display.setText("");
            } else if (command.equals("-")) {
                num1 = Double.parseDouble(display.getText());
                operator = '-';
                display.setText("");
            } else if (command.equals("*")) {
                num1 = Double.parseDouble(display.getText());
                operator = '*';
                display.setText("");
            } else if (command.equals("/")) {
                num1 = Double.parseDouble(display.getText());
                operator = '/';
                display.setText("");
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(display.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }

                display.setText(String.valueOf(result));
            } else if (command.equals("C")) {
                display.setText("");
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    // Main method to run the calculator application
    public static void main(String[] args) {
        new Calculator();
    }
}
