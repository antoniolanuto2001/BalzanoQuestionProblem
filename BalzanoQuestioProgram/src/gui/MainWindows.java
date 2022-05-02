package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;

public class MainWindows {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @author Antonio Lanuto
	 * @author Erasmo Prosciutto
	 * @author Biagio Scotto
	 * Ciao tommaso come stai ???????
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindows window = new MainWindows();
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
	public MainWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1440, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelMainButton = new JPanel();
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);
		
		JLabel testLabel1 = new JLabel("Ciao Erasmo ed Biagio");
		testLabel1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		testLabel1.setBounds(610, 332, 143, 41);
		panelMainButton.add(testLabel1);
		
		JLabel testLabel2 = new JLabel("<3 ");
		testLabel2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		testLabel2.setBounds(660, 367, 41, 35);
		panelMainButton.add(testLabel2);
	}
}
