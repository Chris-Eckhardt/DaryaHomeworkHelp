package shapemaker;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame{

    private static final int FRAME_WIDTH = 1024;
    private static final int FRAME_HEIGHT = 768;

    // label to diaplay shape
    private static JTextArea display;

    // textfield for size
    private static JTextField sizeField;

    UI(ShapeMaker shapeMaker) {

        // JFrame
        JFrame frame = new JFrame("Shape Maker");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // create a label to display text
        display = new JTextArea();
        JLabel inputLabel = new JLabel(" size : ");
        JLabel blankLabel1 = new JLabel("        ");
        JLabel blankLabel2 = new JLabel("        ");
        JLabel blankLabel3 = new JLabel("        ");
        JLabel positionLabel = new JLabel("  _/_  ");



        // text field for shape size
        sizeField = new JTextField();
        sizeField.setColumns(3);

        // JButton
        JButton createBtn = new JButton("Create Shape");
        JButton previousBtn = new JButton("<<");
        JButton forwardBtn = new JButton(">>");

        // create button group
        ButtonGroup radioGroup = new ButtonGroup();

        // create radio buttons
        JRadioButton diamond = new JRadioButton();
        diamond.setText("Diamond");
        JRadioButton triangle = new JRadioButton();
        triangle.setText("Triangle");
        JRadioButton rectangle = new JRadioButton();
        rectangle.setText("Rectangle");

        // create a panel to add buttons
        JPanel buttonPanel = new JPanel();
        JPanel outputPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(12,1));

        // radioButtons
        buttonPanel.add(diamond);
        buttonPanel.add(rectangle);
        buttonPanel.add(triangle);
        // size text field
        buttonPanel.add(inputLabel);
        buttonPanel.add(sizeField);
        buttonPanel.add(createBtn);
        buttonPanel.add(blankLabel1);
        buttonPanel.add(blankLabel2);
        buttonPanel.add(blankLabel3);
        buttonPanel.add(positionLabel);
        buttonPanel.add(previousBtn);
        buttonPanel.add(forwardBtn);

        // group
        radioGroup.add(diamond);
        radioGroup.add(rectangle);
        radioGroup.add(triangle);


        // output display
        outputPanel.add(display);

        //////////////////////////////////////////////////////////

        createBtn.addActionListener(e -> {

            if(diamond.isSelected()) {
                shapeMaker.diamondCall(sizeField.getText());
            }

            if(triangle.isSelected()) {
                shapeMaker.triangleCall(sizeField.getText());
            }

            if(rectangle.isSelected()) {
                shapeMaker.rectangleCall(sizeField.getText());
            }

        });

        //////////////////////////////////////////////////////////

        previousBtn.addActionListener(e -> {

            shapeMaker.previousCall();
            positionLabel.setText(shapeMaker.getPosition());

        });

        //////////////////////////////////////////////////////////

        forwardBtn.addActionListener(e -> {

            shapeMaker.forwardCall();
            positionLabel.setText(shapeMaker.getPosition());

        });

        // setbackground of panel
        buttonPanel.setBackground(Color.GRAY);

        // add panel to frame
        frame.add(buttonPanel, BorderLayout.WEST);
        frame.add(display, BorderLayout.CENTER);

        // set the size of frame
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        frame.show();

    }

    public void badInput(int e) {
        if(e == 0) {
            display.setText("Not valid input. Please try again.");
        }
        if(e == 1) {
            display.setText("Please enter a number from 1 - 100 and try again.");
        }
    }

    public void printShape(String shape) {
        display.setText(shape);
    }
}
