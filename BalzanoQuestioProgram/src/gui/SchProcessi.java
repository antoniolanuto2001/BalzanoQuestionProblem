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
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class SchProcessi extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private String scelta="0";

	private TimeSeriesCollection timeCollection;


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
		
		JButton buttonIndietro = new JButton("Indietro");
		buttonIndietro.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonIndietro.setBackground(new Color(153, 204, 255));
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
		buttonIndietro.setBounds(0, 697, 128, 46);
		panelMainButton.add(buttonIndietro);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 255));
		panel.setBounds(0, 0, 1416, 89);
		panelMainButton.add(panel);
		panel.setLayout(null);
		
		JLabel labelTitolo = new JLabel("Scheduling della CPU");
		labelTitolo.setForeground(new Color(0, 0, 0));
		labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitolo.setFont(new Font("Times New Roman", Font.BOLD, 50));
		labelTitolo.setBounds(0, 10, 1416, 63);
		panel.add(labelTitolo);
		
		JButton buttonGenera = new JButton("Genera Esercizio");
		buttonGenera.setFont(new Font("Arial", Font.BOLD, 15));
		buttonGenera.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonGenera.setBackground(new Color(51, 204, 0));
		buttonGenera.setBounds(0, 97, 167, 46);
		panelMainButton.add(buttonGenera);
		
		JButton buttonEsci = new JButton("Esci");
		buttonEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonEsci.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonEsci.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonEsci.setBackground(new Color(255, 204, 0));
		buttonEsci.setBounds(138, 697, 128, 46);
		panelMainButton.add(buttonEsci);
		
		/*buttonGenera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		*/	
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1129, 97, 265, 656);
		panelMainButton.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 265, 64);
		panel_2.setBackground(new Color(255, 204, 51));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createRaisedBevelBorder());

		JLabel labelPnlCtrl = new JLabel("Pannello di controllo");
		labelPnlCtrl.setBounds(10, 10, 245, 44);
		panel_2.add(labelPnlCtrl);
		labelPnlCtrl.setHorizontalAlignment(SwingConstants.CENTER);
		labelPnlCtrl.setFont(new Font("Arial", Font.BOLD, 22));
		
		JLabel labelEditor = new JLabel("Editor");
		labelEditor.setHorizontalAlignment(SwingConstants.CENTER);
		labelEditor.setForeground(new Color(255, 0, 0));
		labelEditor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelEditor.setBounds(0, 70, 265, 25);
		panel_1.add(labelEditor);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 95, 265, 270);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblNumeroDiProcessi = new JLabel("Numero di processi");
		lblNumeroDiProcessi.setForeground(new Color(0, 0, 0));
		lblNumeroDiProcessi.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNumeroDiProcessi.setBounds(10, 0, 136, 25);
		panel_3.add(lblNumeroDiProcessi);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setBackground(new Color(255, 204, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6"}));
		comboBox.setBounds(156, 3, 43, 21);
		panel_3.add(comboBox);
		//-------------------------------------
		
		JScrollPane scroll= new JScrollPane();
		scroll.setBounds(0, 27, 265, 243);
		panel_3.add(scroll);
		
		final JTable table = new JTable();
		scroll.setViewportView(table);
		
		DefaultTableModel model1 = new DefaultTableModel() {
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0:
					return Integer.class;
				case 1:
					return Integer.class;
				case 2:
					return Integer.class;
				default:
					return Integer.class;
					
				}
			}
		};
		
		table.setModel(model1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 390, 265, 48);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Griglia");
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(6, 21, 83, 21);
		panel_4.add(chckbxNewCheckBox);
		
		JButton btnPlay = new JButton("ESEGUI");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPlay.setBounds(95, 20, 138, 21);
		panel_4.add(btnPlay);
		
		JLabel lblPlot = new JLabel("Plot");
		lblPlot.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlot.setForeground(Color.RED);
		lblPlot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlot.setBounds(0, 365, 265, 25);
		panel_1.add(lblPlot);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 464, 265, 182);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JTextArea txtrHelpArea = new JTextArea();
		txtrHelpArea.setBounds(0, 0, 265, 182);
		panel_5.add(txtrHelpArea);
		txtrHelpArea.setText("AREA HELP");
		txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
		txtrHelpArea.setEditable(false);
		txtrHelpArea.setLineWrap(true);
		
		JLabel lblHelp = new JLabel("Help");
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelp.setForeground(Color.RED);
		lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHelp.setBounds(0, 440, 265, 25);
		panel_1.add(lblHelp);
		
		model1.addColumn("Processo");
		model1.addColumn("Arrivo");
		model1.addColumn("Durata");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scelta= (String) comboBox.getSelectedItem();
			
		int r=Integer.valueOf(scelta);
		if (r!=0) {			
			for (int i=0;i<r;i++) { 
			
			Random random = new Random();
			int value = random.nextInt(30 + 0) + 0;
			model1.addRow(new Object[0]);
			model1.setValueAt("P"+(i+1),i,0);
			model1.setValueAt(value,i,1);
			value = random.nextInt(30 + 0) + 0;
			model1.setValueAt(value,i,2);
			
		//AGGIUNGI CHECKBOX
		//Aggiungi lista 
				}
			}
		if (r!=0) {			
			for (int i=0;i<r;i++) { 
				
			}
			}
		}
		});
		//	});
		
	}

}

