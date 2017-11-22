package antiSpamFilter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;

public class Interface {

	private JFrame frame;
	private JTextField rulesPath;
	private JTextField hamPath;
	private JTextField spamPath;
	private JTextField mFalsePosField;
	private JTextField mFalseNegField;
	private JTextField aFalsePositiveField;
	private JTextField aFalseNegativeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel pathPanel = new JPanel();
		frame.getContentPane().add(pathPanel);
		pathPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel rulesLabel = new JLabel("Path Rules.cf");
		rulesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pathPanel.add(rulesLabel);
		
		rulesPath = new JTextField();
		pathPanel.add(rulesPath);
		rulesPath.setColumns(10);
		
		JButton rulesButton = new JButton("Change");
		pathPanel.add(rulesButton);
		
		JLabel hamLabel = new JLabel("Path Ham.log");
		hamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pathPanel.add(hamLabel);
		
		hamPath = new JTextField();
		pathPanel.add(hamPath);
		hamPath.setColumns(10);
		
		JButton hamButton = new JButton("Change");
		pathPanel.add(hamButton);
		
		JLabel spamLabel = new JLabel("Path Spam.log");
		spamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pathPanel.add(spamLabel);
		
		spamPath = new JTextField();
		pathPanel.add(spamPath);
		spamPath.setColumns(10);
		
		JButton spamButton = new JButton("Change");
		pathPanel.add(spamButton);
		
		JPanel manualPanel = new JPanel();
		frame.getContentPane().add(manualPanel);
		manualPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel manResultsPanel = new JPanel();
		manualPanel.add(manResultsPanel, BorderLayout.WEST);
		manResultsPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel mFalsePosLabel = new JLabel("FP:");
		mFalsePosLabel.setToolTipText("False Positives");
		mFalsePosLabel.setHorizontalAlignment(SwingConstants.CENTER);
		manResultsPanel.add(mFalsePosLabel);
		
		mFalsePosField = new JTextField();
		mFalsePosField.setHorizontalAlignment(SwingConstants.CENTER);
		mFalsePosField.setText("0");
		manResultsPanel.add(mFalsePosField);
		mFalsePosField.setColumns(10);
		
		JLabel mFalseNegLabel = new JLabel("FN:");
		mFalseNegLabel.setToolTipText("False Negatives");
		mFalseNegLabel.setHorizontalAlignment(SwingConstants.CENTER);
		manResultsPanel.add(mFalseNegLabel);
		
		mFalseNegField = new JTextField();
		mFalseNegField.setHorizontalAlignment(SwingConstants.CENTER);
		mFalseNegField.setText("0");
		manResultsPanel.add(mFalseNegField);
		mFalseNegField.setColumns(10);
		
		JPanel manRulesPanel = new JPanel();
		manualPanel.add(manRulesPanel, BorderLayout.CENTER);
		manRulesPanel.setLayout(new GridLayout(0, 2, 1, 0));
		
		JTextArea mRulesTextArea = new JTextArea();
		mRulesTextArea.setEditable(false);
		manRulesPanel.add(mRulesTextArea);
		
		JTextArea mWeightTextArea = new JTextArea();
		manRulesPanel.add(mWeightTextArea);
		
		JPanel manButtonsPanel = new JPanel();
		manualPanel.add(manButtonsPanel, BorderLayout.EAST);
		manButtonsPanel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JButton testButton = new JButton("Test");
		manButtonsPanel.add(testButton);
		
		JButton mSaveButton = new JButton("Save");
		manButtonsPanel.add(mSaveButton);
		
		JPanel autoPanel = new JPanel();
		frame.getContentPane().add(autoPanel);
		autoPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel autoResultsPanel = new JPanel();
		autoPanel.add(autoResultsPanel, BorderLayout.WEST);
		autoResultsPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel aFalsePositiveLabel = new JLabel("FP:");
		aFalsePositiveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		aFalsePositiveLabel.setToolTipText("False Positives");
		autoResultsPanel.add(aFalsePositiveLabel);
		
		aFalsePositiveField = new JTextField();
		aFalsePositiveField.setText("0");
		aFalsePositiveField.setHorizontalAlignment(SwingConstants.CENTER);
		autoResultsPanel.add(aFalsePositiveField);
		aFalsePositiveField.setColumns(10);
		
		JLabel aFalseNegativeLabel = new JLabel("FN:");
		aFalseNegativeLabel.setToolTipText("False Negatives");
		aFalseNegativeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		autoResultsPanel.add(aFalseNegativeLabel);
		
		aFalseNegativeField = new JTextField();
		aFalseNegativeField.setText("0");
		aFalseNegativeField.setHorizontalAlignment(SwingConstants.CENTER);
		autoResultsPanel.add(aFalseNegativeField);
		aFalseNegativeField.setColumns(10);
		
		JPanel autoRulesPanel = new JPanel();
		autoPanel.add(autoRulesPanel, BorderLayout.CENTER);
		autoRulesPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JTextArea aRulesTextArea = new JTextArea();
		aRulesTextArea.setEditable(false);
		autoRulesPanel.add(aRulesTextArea);
		
		JTextArea aWeightTextArea = new JTextArea();
		aWeightTextArea.setEditable(false);
		autoRulesPanel.add(aWeightTextArea);
		
		JPanel autoButtonsPanel = new JPanel();
		autoPanel.add(autoButtonsPanel, BorderLayout.EAST);
		autoButtonsPanel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JButton generateButton = new JButton("Generate");
		autoButtonsPanel.add(generateButton);
		
		JButton aSaveButton = new JButton("Save");
		autoButtonsPanel.add(aSaveButton);
	}

}
