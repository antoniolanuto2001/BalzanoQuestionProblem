package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class SchProcessi extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Create the frame.
	 */
	public SchProcessi(JFrame framechiamante) 
	{
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelMainButton = new JPanel();
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);
		
		JLabel labelSchemata = new JLabel("Scheduler Processi Schermata");
		labelSchemata.setFont(new Font("Segoe UI", Font.BOLD, 16));
		labelSchemata.setBounds(604, 355, 245, 89);
		panelMainButton.add(labelSchemata);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				framechiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setBounds(434, 377, 128, 46);
		panelMainButton.add(btnNewButton);
		
	}
}
