package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.Box;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class Semafori extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField TextFieldNumProcessi;
	private JTextField txtNumeroSemafori;

	/**
	 * Create the frame.
	 */
	public Semafori(JFrame framechiamante) 
	
	{
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelMainButton = new JPanel();
		panelMainButton.setBackground(SystemColor.control);
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton, BorderLayout.CENTER);
		panelMainButton.setLayout(null);
		
		JLabel labelSchemata = new JLabel("Semafori");
		labelSchemata.setFont(new Font("Segoe UI", Font.BOLD, 28));
		labelSchemata.setBounds(718, 11, 137, 38);
		panelMainButton.add(labelSchemata);
		
		JButton buttonIndietro = new JButton("Indietro");
		buttonIndietro.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonIndietro.setBackground(new Color(153, 204, 255));
		buttonIndietro.setOpaque(true);
		buttonIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				framechiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonIndietro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonIndietro.setBounds(30, 99, 128, 46);
		panelMainButton.add(buttonIndietro);
		
		JLabel lblNewLabel = new JLabel("Pannello di controllo");
		lblNewLabel.setBounds(1041, 136, 137, 27);
		panelMainButton.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		desktopPane.setBackground(SystemColor.controlHighlight);
		desktopPane.setBounds(929, 160, 353, 156);
		panelMainButton.add(desktopPane);
		
		TextFieldNumProcessi = new JTextField();
		TextFieldNumProcessi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		TextFieldNumProcessi.setBounds(10, 32, 121, 21);
		desktopPane.add(TextFieldNumProcessi);
		TextFieldNumProcessi.setText("Numero Processi:");
		TextFieldNumProcessi.setColumns(10);
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.setBackground(new Color(255, 255, 255));
		ResetButton.setBounds(219, 96, 121, 23);
		desktopPane.add(ResetButton);
		
		JToggleButton StartPauseToggleButton = new JToggleButton("Start/Pause");
		StartPauseToggleButton.setBounds(219, 31, 121, 23);
		desktopPane.add(StartPauseToggleButton);
		StartPauseToggleButton.setBackground(new Color(255, 255, 255));
		
		JComboBox NumSemaforiComboBox = new JComboBox();
		NumSemaforiComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		NumSemaforiComboBox.setMaximumRowCount(2);
		NumSemaforiComboBox.setBounds(132, 97, 37, 20);
		desktopPane.add(NumSemaforiComboBox);
		
		JComboBox NumProcessiComboBox = new JComboBox();
		NumProcessiComboBox.setModel(new DefaultComboBoxModel(new String[]{"1","2","3","4","5"}));
		
		NumProcessiComboBox.setBounds(126, 32, 43, 21);
		desktopPane.add(NumProcessiComboBox);
		
		
		
		txtNumeroSemafori = new JTextField();
		txtNumeroSemafori.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtNumeroSemafori.setText("Numero Semafori:");
		txtNumeroSemafori.setBounds(10, 97, 126, 20);
		desktopPane.add(txtNumeroSemafori);
		txtNumeroSemafori.setColumns(10);
		
		JLabel UniversitaJLabel = new JLabel("Universit\u00E0 degli studi di Napoli: \"Federico II\"");
		UniversitaJLabel.setFont(new Font("Sylfaen", Font.BOLD, 13));
		UniversitaJLabel.setBounds(1118, 640, 269, 27);
		panelMainButton.add(UniversitaJLabel);
		
		JLabel CorsoJLabel = new JLabel("Corso di Sistemi Operativi del Prof. W. Balzano");
		CorsoJLabel.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		CorsoJLabel.setBounds(1128, 666, 245, 27);
		panelMainButton.add(CorsoJLabel);
		
		JLabel AnnoJLabel = new JLabel("Anno: 2021/2022");
		AnnoJLabel.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		AnnoJLabel.setBounds(1191, 693, 102, 18);
		panelMainButton.add(AnnoJLabel);
		
		JLabel SviluppatoriJLabel = new JLabel("Sviluppata da: A. Lanuto, E. Prosciutto, B. Scotto");
		SviluppatoriJLabel.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		SviluppatoriJLabel.setBounds(1118, 722, 269, 18);
		panelMainButton.add(SviluppatoriJLabel);
		
		JButton GeneraEsercizioJButton = new JButton("Genera Esercizio");
		GeneraEsercizioJButton.setBackground(new Color(153, 204, 255));
		GeneraEsercizioJButton.setOpaque(true);
		GeneraEsercizioJButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		GeneraEsercizioJButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GeneraEsercizioJButton.setBounds(181, 99, 143, 46);
		panelMainButton.add(GeneraEsercizioJButton);
		
	}
}
