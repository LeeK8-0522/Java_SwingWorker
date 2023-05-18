package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JProgressBar;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class FibonacciView extends JFrame {

	// * Below are fields *
	private JPanel contentPane;
	private JTextField inputNumber_textField;
	private JTextField viewSum_textField;
	private JPanel North_panel;
	private JPanel inputNumber_panel;
	private JLabel inputNumber_label;
	private JPanel NorthButton_panel;
	
	private JButton getSum_button;
	private JButton Cancel_button;
	
	private JScrollPane Center_scrollPane;
	private JTextArea showSeries_textArea;
	private JPanel South_panel;
	private JProgressBar progressBar;
	private JPanel SouthEast_panel;
	//finish implementing fields
	
	public FibonacciView() {
		setPreferredSize(new Dimension(1000, 0));
		setTitle("Finding Fibonacci series sum");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		North_panel = new JPanel();
		North_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(North_panel, BorderLayout.NORTH);
		North_panel.setLayout(new BoxLayout(North_panel, BoxLayout.X_AXIS));
		
		inputNumber_panel = new JPanel();
		North_panel.add(inputNumber_panel);
		inputNumber_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		inputNumber_label = new JLabel("Number of row in Fibonacci series:");
		inputNumber_label.setSize(new Dimension(200, 0));
		inputNumber_label.setFont(new Font("굴림", Font.BOLD, 12));
		inputNumber_panel.add(inputNumber_label);
		
		inputNumber_textField = new JTextField();
		inputNumber_panel.add(inputNumber_textField);
		inputNumber_textField.setColumns(10);
		
		NorthButton_panel = new JPanel();
		North_panel.add(NorthButton_panel);
		NorthButton_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		getSum_button = new JButton("Get Sum of Fibonacci series");
		getSum_button.setFont(new Font("굴림", Font.BOLD, 12));
		NorthButton_panel.add(getSum_button);
		
		Cancel_button = new JButton("Cancel");
		Cancel_button.setEnabled(false);
		Cancel_button.setForeground(new Color(0, 0, 0));
		Cancel_button.setBackground(new Color(255, 206, 206));
		Cancel_button.setFont(new Font("굴림", Font.BOLD, 12));
		NorthButton_panel.add(Cancel_button);
		
		Center_scrollPane = new JScrollPane();
		contentPane.add(Center_scrollPane, BorderLayout.CENTER);
		
		showSeries_textArea = new JTextArea();
		showSeries_textArea.setEditable(false);
		Center_scrollPane.setViewportView(showSeries_textArea);
		
		South_panel = new JPanel();
		South_panel.setBorder(new EmptyBorder(2, 2, 2, 2));
		contentPane.add(South_panel, BorderLayout.SOUTH);
		South_panel.setLayout(new BoxLayout(South_panel, BoxLayout.X_AXIS));
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(156, 243, 160));
		progressBar.setBackground(new Color(245, 245, 245));
		progressBar.setPreferredSize(new Dimension(500, 14));
		South_panel.add(progressBar);
		
		SouthEast_panel = new JPanel();
		South_panel.add(SouthEast_panel);
		SouthEast_panel.setLayout(new BorderLayout(0, 0));
		
		viewSum_textField = new JTextField();
		viewSum_textField.setEditable(false);
		viewSum_textField.setFont(new Font("굴림", Font.BOLD, 12));
		viewSum_textField.setBackground(new Color(240, 240, 240));
		SouthEast_panel.add(viewSum_textField, BorderLayout.WEST);
		viewSum_textField.setColumns(10);
	}
	
	public void setListener(ActionListener listener) {
		getSum_button.addActionListener(listener);
		Cancel_button.addActionListener(listener);
	}//set action-listener to two buttons

	// * Below are getter-methods *
	public JButton getGetSumButton() {
		return this.getSum_button;
	}//return getSum-JButton
	
	public JButton getCancelButton() {
		return this.Cancel_button;
	}//return Cancel-JButton
	
	public String getInputData() {
		return this.inputNumber_textField.getText();
	}//return input data in string format
	//finish implementing getter-methods
	
	// * Below are setter-method *
	public void setShowSeriesTextArea(String input) {
		this.showSeries_textArea.setText(input);
	}//set input text in showSeries_textArea 
	
	public void setViewSumTextField(String input) {
		this.viewSum_textField.setText(input);
	}//set input text in viewSum_textFeild
	
	public void setProgressBar(int input) {
		this.progressBar.setValue(input);
	}//set percentage value in progressBar
	//finish implementing setter-methods 
	
	public void freezeCancelButton() {
		this.Cancel_button.setEnabled(false);
	}//freeze cancel-button
	
	public void activateCancelButton() {
		this.Cancel_button.setEnabled(true);
	}//activate cancel-button
}
