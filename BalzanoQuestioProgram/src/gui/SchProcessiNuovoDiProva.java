// RENDERE NON SPOSTABILI LE COLONEE DELLA TABELLA

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import model.CreaLinee;

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
import java.awt.Desktop;

public class SchProcessiNuovoDiProva extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private String scelta="0";
	private int i=0;
	private int tool = 1;
    int currentX, currentY, oldX, oldY;

    ArrayList<CreaLinee> lineesFCFS= new ArrayList<CreaLinee>();
    ArrayList<CreaLinee> lineesSJF= new ArrayList<CreaLinee>();
    ArrayList<CreaLinee> lineesSJFP= new ArrayList<CreaLinee>();
    ArrayList<CreaLinee> lineesRR= new ArrayList<CreaLinee>();

	/**
	 * Create the frame.
	 */
	public SchProcessiNuovoDiProva(JFrame framechiamante) 
	{
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Balzano Question Problem : Scheduling della CPU");

		JPanel panelMainButton = new JPanel();
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);

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
		buttonIndietro.setBounds(315, 85, 128, 48);
		panelMainButton.add(buttonIndietro);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 255));
		panel.setBounds(0, 0, 1416, 75);
		panelMainButton.add(panel);
		panel.setLayout(null);
		
		JLabel labelTitolo = new JLabel("Scheduling della CPU");
		labelTitolo.setForeground(new Color(0, 0, 0));
		labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitolo.setFont(new Font("Segoe UI", Font.BOLD, 50));
		labelTitolo.setBounds(0, 0, 1416, 73);
		panel.add(labelTitolo);
		
		JTextArea txtrUniversitDegliStudi = new JTextArea();
		txtrUniversitDegliStudi.setBounds(1152, 0, 251, 73);
		panel.add(txtrUniversitDegliStudi);
		txtrUniversitDegliStudi.setBackground(new Color(51, 204, 255));
		txtrUniversitDegliStudi.setText("Universit\u00E0 degli studi di NApoli\r\nAnno Accademico: 2021/2022\r\nProfessore: Walter Balzano\r\n Devoloper: Lanuto, Prosciutto, Scotto\r\n");
		txtrUniversitDegliStudi.setLineWrap(true);
		txtrUniversitDegliStudi.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtrUniversitDegliStudi.setEditable(false);
		

		JButton buttonGenera = new JButton("Genera Esercizio");
		buttonGenera.setFont(new Font("Arial", Font.BOLD, 13));
		buttonGenera.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonGenera.setBackground(new Color(0, 255, 51));
		buttonGenera.setBounds(10, 85, 157, 48);
		panelMainButton.add(buttonGenera);
		
		JButton btnSlideArgomento = new JButton("Slide Argomento");
		btnSlideArgomento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI ("http://balzanoslidesistemiopera.altervista.org/Slides_Sistemi_Operativi.pdf#page=118"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSlideArgomento.setOpaque(true);
	    btnSlideArgomento.setFont(new Font("Segoe UI", Font.BOLD, 14));
	    btnSlideArgomento.setBorder(new LineBorder(new Color(0, 0, 0)));
	    btnSlideArgomento.setBackground(new Color(153, 255, 255));
	    btnSlideArgomento.setBounds(177, 85, 128, 48);
        panelMainButton.add(btnSlideArgomento);
        frame.setVisible(true); 
	        
		JButton buttonEsci = new JButton("Esci");
		buttonEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonEsci.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonEsci.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonEsci.setBackground(new Color(255, 204, 0));
		buttonEsci.setBounds(454, 85, 81, 48);
		panelMainButton.add(buttonEsci);
		
/*PRIMA PARTE GUI*/		
		
		Panel2 jPanelFCFS2 = new Panel2();
		jPanelFCFS2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFCFS2.setBounds(17, 27, 1100, 118);
        jPanelFCFS2.setLayout(null);
       
        Panel2 jPanelFCFS3 = new Panel2();
        jPanelFCFS3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFCFS3.setBounds(17, 180, 1100, 118);
        jPanelFCFS3.setLayout(null);
        
        Panel2 jPanelFCFS4 = new Panel2();
        jPanelFCFS4.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFCFS4.setBounds(17, 333, 1100, 118);
        jPanelFCFS4.setLayout(null);
        
        Panel2 jPanelFCFS5 = new Panel2();
        jPanelFCFS5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFCFS5.setBounds(17, 486, 1100, 118);
        jPanelFCFS5.setLayout(null);
        
   	    JPanel panel_6 = new JPanel();
        panel_6.setBounds(0, 143, 1131, 620);
        panelMainButton.add(panel_6);
        panel_6.setLayout(null);
        
        panel_6.add(jPanelFCFS2);
        panel_6.add(jPanelFCFS3);
        panel_6.add(jPanelFCFS4);
        panel_6.add(jPanelFCFS5);

        
        /*First-Come, First-Served*/
        JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 0, 1121, 150);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		panel_7.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));

		JLabel lblFirstcomeFirstserved = new JLabel("First-Come, First-Served");
		lblFirstcomeFirstserved.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstcomeFirstserved.setForeground(Color.RED);
		lblFirstcomeFirstserved.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstcomeFirstserved.setBounds(10, 0, 489, 25);
		panel_7.add(lblFirstcomeFirstserved);
		
		JCheckBox chckbxMostraSoluzione = new JCheckBox("Mostra Soluzione");
		chckbxMostraSoluzione.setEnabled(false);
		chckbxMostraSoluzione.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chckbxMostraSoluzione.setBounds(513, 3, 150, 25);
		panel_7.add(chckbxMostraSoluzione);
		
		JLabel lblTAM = new JLabel("Tempo di attesa medio:");
		lblTAM.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTAM.setBounds(670, 3, 150, 25);
		panel_7.add(lblTAM);
		
		JLabel lblCDC = new JLabel("Cambi di contesto: ");
		lblCDC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCDC.setBounds(887, 3, 130, 25);
		panel_7.add(lblCDC);
		
		JLabel DatoTAM = new JLabel("");
		DatoTAM.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DatoTAM.setBounds(821, 3, 45, 25);
		panel_7.add(DatoTAM);
		
		JLabel DatoCDC = new JLabel("");
		DatoCDC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DatoCDC.setBounds(1014, 3, 45, 25);
		panel_7.add(DatoCDC);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));
		panel_7_1.setBounds(10, 153, 1121, 150);
		panel_6.add(panel_7_1);
		
		JLabel lblFirstcomeFirstserved_1 = new JLabel("Shortest Job First");
		lblFirstcomeFirstserved_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstcomeFirstserved_1.setForeground(Color.RED);
		lblFirstcomeFirstserved_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstcomeFirstserved_1.setBounds(10, 0, 489, 25);
		panel_7_1.add(lblFirstcomeFirstserved_1);
		
		JCheckBox chckbxMostraSoluzione_1 = new JCheckBox("Mostra Soluzione");
		chckbxMostraSoluzione_1.setEnabled(false);
		chckbxMostraSoluzione_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chckbxMostraSoluzione_1.setBounds(513, 3, 150, 25);
		panel_7_1.add(chckbxMostraSoluzione_1);
		
		JLabel lblTAM_1 = new JLabel("Tempo di attesa medio:");
		lblTAM_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTAM_1.setBounds(670, 3, 150, 25);
		panel_7_1.add(lblTAM_1);
		
		JLabel lblCDC_1 = new JLabel("Cambi di contesto: ");
		lblCDC_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCDC_1.setBounds(887, 3, 130, 25);
		panel_7_1.add(lblCDC_1);
		
		JLabel DatoTAM_1 = new JLabel("");
		DatoTAM_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DatoTAM_1.setBounds(821, 3, 45, 25);
		panel_7_1.add(DatoTAM_1);
		
		JLabel DatoCDC_1 = new JLabel("");
		DatoCDC_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DatoCDC_1.setBounds(1014, 3, 45, 25);
		panel_7_1.add(DatoCDC_1);
		
		JPanel panel_7_2 = new JPanel();
		panel_7_2.setLayout(null);
		panel_7_2.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));
		panel_7_2.setBounds(10, 306, 1121, 150);
		panel_6.add(panel_7_2);
		
		JLabel lblFirstcomeFirstserved_2 = new JLabel("Shortest Job First Preemptive");
		lblFirstcomeFirstserved_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstcomeFirstserved_2.setForeground(Color.RED);
		lblFirstcomeFirstserved_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstcomeFirstserved_2.setBounds(10, 0, 489, 25);
		panel_7_2.add(lblFirstcomeFirstserved_2);
		
		JCheckBox chckbxMostraSoluzione_2 = new JCheckBox("Mostra Soluzione");
		chckbxMostraSoluzione_2.setEnabled(false);
		chckbxMostraSoluzione_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chckbxMostraSoluzione_2.setBounds(513, 3, 150, 25);
		panel_7_2.add(chckbxMostraSoluzione_2);
		
		JLabel lblTAM_2 = new JLabel("Tempo di attesa medio:");
		lblTAM_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTAM_2.setBounds(670, 3, 150, 25);
		panel_7_2.add(lblTAM_2);
		
		JLabel lblCDC_2 = new JLabel("Cambi di contesto: ");
		lblCDC_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCDC_2.setBounds(887, 3, 130, 25);
		panel_7_2.add(lblCDC_2);
		
		JLabel DatoTAM_2 = new JLabel("");
		DatoTAM_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DatoTAM_2.setBounds(821, 3, 45, 25);
		panel_7_2.add(DatoTAM_2);
		
		JLabel DatoCDC_2 = new JLabel("");
		DatoCDC_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DatoCDC_2.setBounds(1014, 3, 45, 25);
		panel_7_2.add(DatoCDC_2);
		
		JPanel panel_7_3 = new JPanel();
		panel_7_3.setLayout(null);
		panel_7_3.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));
		panel_7_3.setBounds(10, 459, 1121, 150);
		panel_6.add(panel_7_3);
		
		JLabel lblFirstcomeFirstserved_3 = new JLabel("Round Robin");
		lblFirstcomeFirstserved_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstcomeFirstserved_3.setForeground(Color.RED);
		lblFirstcomeFirstserved_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstcomeFirstserved_3.setBounds(10, 0, 351, 25);
		panel_7_3.add(lblFirstcomeFirstserved_3);
		
		JCheckBox chckbxMostraSoluzione_3 = new JCheckBox("Mostra Soluzione");
		chckbxMostraSoluzione_3.setEnabled(false);
		chckbxMostraSoluzione_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chckbxMostraSoluzione_3.setBounds(513, 3, 150, 25);
		panel_7_3.add(chckbxMostraSoluzione_3);
		
		JLabel lblTAM_3 = new JLabel("Tempo di attesa medio:");
		lblTAM_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTAM_3.setBounds(670, 3, 150, 25);
		panel_7_3.add(lblTAM_3);
		
		JLabel lblCDC_3 = new JLabel("Cambi di contesto: ");
		lblCDC_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCDC_3.setBounds(887, 3, 130, 25);
		panel_7_3.add(lblCDC_3);
		
		JLabel DatoTAM_3 = new JLabel("");
		DatoTAM_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DatoTAM_3.setBounds(821, 3, 45, 25);
		panel_7_3.add(DatoTAM_3);
		
		JLabel DatoCDC_3 = new JLabel("");
		DatoCDC_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DatoCDC_3.setBounds(1014, 3, 45, 25);
		panel_7_3.add(DatoCDC_3);
		
		JLabel lblTAM_3_1 = new JLabel("Q=");
		lblTAM_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTAM_3_1.setBounds(371, 3, 32, 25);
		panel_7_3.add(lblTAM_3_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(396, 5, 50, 21);
		panel_7_3.add(comboBox_1);
			    
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1141, 105, 265, 648);
		panelMainButton.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 245, 54);
		panel_2.setBackground(new Color(255, 204, 51));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createRaisedBevelBorder());
			
		JLabel labelPnlCtrl = new JLabel("Pannello di controllo");
		labelPnlCtrl.setHorizontalAlignment(SwingConstants.CENTER);
		labelPnlCtrl.setBounds(0, 0, 245, 54);
		panel_2.add(labelPnlCtrl);
		labelPnlCtrl.setFont(new Font("Arial", Font.BOLD, 22));
		
		JLabel labelEditor = new JLabel("Editor");
		labelEditor.setHorizontalAlignment(SwingConstants.CENTER);
		labelEditor.setForeground(new Color(255, 0, 0));
		labelEditor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelEditor.setBounds(0, 70, 265, 25);
		panel_1.add(labelEditor);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 95, 245, 201);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblNumeroDiProcessi = new JLabel("Numero di processi");
		lblNumeroDiProcessi.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDiProcessi.setForeground(new Color(0, 0, 0));
		lblNumeroDiProcessi.setFont(new Font("Arial", Font.BOLD, 15));
		lblNumeroDiProcessi.setBounds(10, 2, 165, 23);
		panel_3.add(lblNumeroDiProcessi);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"6", "5", "4", "3", "2", "1", "0"}));
		comboBox.setBounds(185, 2, 50, 21);
		panel_3.add(comboBox);
		
		JScrollPane scroll= new JScrollPane();
		scroll.setBounds(10, 27, 225, 136);
		panel_3.add(scroll);
		
		final JTable table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setEnabled(false);
		table.setFont(new Font("Arial", Font.BOLD, 12));
		scroll.setViewportView(table);
		
		DefaultTableModel model1 = new DefaultTableModel()
		{
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0:
					return Integer.class;
				case 1:
					return Integer.class;
				case 2:
					return Integer.class;
				case 3:
					return Boolean.class;
				default:
					return Integer.class;
					
				}
			}
		};
		
		table.setModel(model1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 328, 245, 94);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBorder(BorderFactory.createLineBorder(Color.black));

		JButton btnEsegui = new JButton("Esegui");
		btnEsegui.setEnabled(false);
		btnEsegui.setBounds(16, 63, 77, 21);
		panel_4.add(btnEsegui);
		
		JCheckBox chckbxGriglia = new JCheckBox("Griglia");
		chckbxGriglia.setSelected(true);
		chckbxGriglia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chckbxGriglia.setBounds(6, 6, 65, 21);
		panel_4.add(chckbxGriglia);
		
		JTextField ModifyProcess = new JTextField("");
		ModifyProcess.setEnabled(false);
		ModifyProcess.setHorizontalAlignment(SwingConstants.CENTER);
		ModifyProcess.setFont(new Font("Arial", Font.BOLD, 12));
		ModifyProcess.setBounds(35, 173, 40, 20);
		panel_3.add(ModifyProcess);
		
		JTextField ModifyArrivo = new JTextField("");
		ModifyArrivo.setEnabled(false);
		ModifyArrivo.setHorizontalAlignment(SwingConstants.CENTER);
		ModifyArrivo.setFont(new Font("Arial", Font.BOLD, 12));
		ModifyArrivo.setBounds(85, 173, 40, 20);
		panel_3.add(ModifyArrivo);
		
		JTextField ModifyDurata = new JTextField("");
		ModifyDurata.setEnabled(false);
		ModifyDurata.setHorizontalAlignment(SwingConstants.CENTER);
		ModifyDurata.setFont(new Font("Arial", Font.BOLD, 12));
		ModifyDurata.setBounds(135, 173, 40, 20);
		panel_3.add(ModifyDurata);
		
		JButton btnSalvaModifica = new JButton("Salva Modifiche");
		btnSalvaModifica.setEnabled(false);
		btnSalvaModifica.setBounds(103, 63, 125, 21);
		panel_4.add(btnSalvaModifica);
		
		JCheckBox chckbxAttivaModifiche = new JCheckBox("Attiva modifiche");
		chckbxAttivaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getRowCount()>0){
				boolean test= chckbxAttivaModifiche.isSelected();
				if(test==true) {	
					table.setEnabled(true);
					ModifyDurata.setEnabled(true);
					ModifyArrivo.setEnabled(true);
					ModifyProcess.setEnabled(true);
	
				}else {
					table.setEnabled(false);
					ModifyDurata.setEnabled(false);
					ModifyArrivo.setEnabled(false);
					ModifyProcess.setEnabled(false);

				}	
				btnSalvaModifica.setEnabled(true);
				btnSalvaModifica.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						chckbxMostraSoluzione.setSelected(false);
						chckbxMostraSoluzione_1.setSelected(false);
						chckbxMostraSoluzione_2.setSelected(false);
						chckbxMostraSoluzione_3.setSelected(false);
						lineesFCFS.clear();
						lineesSJF.clear();
						lineesSJFP.clear();
						lineesRR.clear();
						jPanelFCFS2.disegnaGriglia(jPanelFCFS2.getGraphics(),lineesFCFS,chckbxMostraSoluzione.isSelected(), chckbxGriglia.isSelected());
						jPanelFCFS3.disegnaGriglia(jPanelFCFS3.getGraphics(),lineesSJF,chckbxMostraSoluzione_1.isSelected(), chckbxGriglia.isSelected());
						jPanelFCFS4.disegnaGriglia(jPanelFCFS4.getGraphics(),lineesSJFP,chckbxMostraSoluzione_2.isSelected(), chckbxGriglia.isSelected());
						jPanelFCFS5.disegnaGriglia(jPanelFCFS5.getGraphics(),lineesRR,chckbxMostraSoluzione_3.isSelected(), chckbxGriglia.isSelected());


						table.setEnabled(false);
						chckbxAttivaModifiche.setSelected(false);
						ModifyDurata.setEnabled(false);
						ModifyArrivo.setEnabled(false);
						ModifyProcess.setEnabled(false);
						
						for(int i=0;i<6;i++) {
			    		if(table.getValueAt(i,0).equals(ModifyProcess.getText())) {    	
			    			model1.setValueAt(ModifyArrivo.getText(),i, 1);
			    			model1.setValueAt(ModifyDurata.getText(),i, 2);
			    		}
						}
						
						for (int i=0;i<table.getRowCount();i++) 
						{ 
							if(Boolean.valueOf((table.getValueAt(i, 3)).toString())==false) {
						    int a=Integer.valueOf((table.getValueAt(i, 1)).toString());
						    int b=Integer.valueOf((table.getValueAt(i, 2)).toString());

						    CreaLinee punti=new CreaLinee();
						    CreaLinee distanza=new CreaLinee();

							punti.creaPunti(a,i+1);
							lineesFCFS.add(punti);
							lineesSJF.add(punti);
							lineesSJFP.add(punti);
							lineesRR.add(punti);
							
							distanza.creaDistanza(i+1,a,b);
							lineesFCFS.add(distanza);
							lineesSJF.add(distanza);
							lineesSJFP.add(distanza);
							lineesRR.add(distanza);
							}
						}
						
			    		ModifyDurata.setText("");
						ModifyArrivo.setText("");
						ModifyProcess.setText("");
						btnSalvaModifica.setEnabled(false);

					}
					
				});
				}
				else chckbxAttivaModifiche.setSelected(false);

			}
		});
		chckbxAttivaModifiche.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chckbxAttivaModifiche.setBounds(100, 6, 140, 21);
		panel_4.add(chckbxAttivaModifiche);
		
		JCheckBox chkbkMostraAllSoluzione = new JCheckBox("Mostra soluzione sempre");
		chkbkMostraAllSoluzione.setEnabled(false);
		chkbkMostraAllSoluzione.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			boolean test1= chkbkMostraAllSoluzione.isSelected();

			if(test1==true) {
					
				chckbxMostraSoluzione.setSelected(true);
				chckbxMostraSoluzione_1.setSelected(true);
				chckbxMostraSoluzione_2.setSelected(true);
				chckbxMostraSoluzione_3.setSelected(true);
				
				boolean test= chckbxMostraSoluzione.isSelected();
				lineesFCFS=creaFCFS(lineesFCFS,lineesFCFS);
				jPanelFCFS2.disegnaGriglia(jPanelFCFS2.getGraphics(),lineesFCFS,chckbxMostraSoluzione.isSelected(), chckbxGriglia.isSelected());
				
				boolean test2= chckbxMostraSoluzione_1.isSelected();
				lineesSJF=creaSJF(lineesSJF);
				jPanelFCFS3.disegnaGriglia(jPanelFCFS3.getGraphics(),lineesSJF,chckbxMostraSoluzione_1.isSelected(), chckbxGriglia.isSelected());
					
				boolean test3= chckbxMostraSoluzione_2.isSelected();
				lineesSJFP=creaSJFP(lineesSJFP);
				jPanelFCFS4.disegnaGriglia(jPanelFCFS4.getGraphics(),lineesSJFP,chckbxMostraSoluzione_2.isSelected(), chckbxGriglia.isSelected());
					
				boolean test4= chckbxMostraSoluzione_3.isSelected();
				lineesRR=creaRR(lineesRR);
				jPanelFCFS5.disegnaGriglia(jPanelFCFS5.getGraphics(),lineesRR,chckbxMostraSoluzione_3.isSelected(), chckbxGriglia.isSelected());
			}
			else {
				chckbxMostraSoluzione.setSelected(false);
				chckbxMostraSoluzione_1.setSelected(false);
				chckbxMostraSoluzione_2.setSelected(false);
				chckbxMostraSoluzione_3.setSelected(false);
			
				jPanelFCFS2.disegnaGriglia(jPanelFCFS2.getGraphics(),null,chckbxMostraSoluzione.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS3.disegnaGriglia(jPanelFCFS3.getGraphics(),null,chckbxMostraSoluzione_1.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS4.disegnaGriglia(jPanelFCFS4.getGraphics(),null,chckbxMostraSoluzione_2.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS5.disegnaGriglia(jPanelFCFS5.getGraphics(),null,chckbxMostraSoluzione_3.isSelected(), chckbxGriglia.isSelected());

			}
		}
		});
		chkbkMostraAllSoluzione.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chkbkMostraAllSoluzione.setBounds(6, 32, 222, 21);
		panel_4.add(chkbkMostraAllSoluzione);
		
		JLabel lblPlot = new JLabel("Plot");
		lblPlot.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlot.setForeground(Color.RED);
		lblPlot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlot.setBounds(0, 303, 265, 25);
		panel_1.add(lblPlot);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 449, 245, 189);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 245, 189);
		panel_5.add(scrollPane);
		
		JTextArea txtrHelpArea = new JTextArea();
		scrollPane.setViewportView(txtrHelpArea);
		txtrHelpArea.setWrapStyleWord(true);
		txtrHelpArea.setLineWrap(true);
		txtrHelpArea.setText("FCFS: (First Come First Served). \r\nCon questo schema la CPU si assegna al processo che la richiede per  primo. Esso \u00E8 il piu' semplice degli algoritmi di scheduling della CPU ed \u00E8 basato su code FIFO. Questo algoritmo genera l' Effetto Convoglio: tutti i processi attendono che un lungo processo liberi la CPU.\r\nSJF: (Shortest Job First). \r\nDetto anche scheduling per brevit\u00E0. Questo algoritmo associa a ogni processo la lunghezza della successiva sequenza di operazioni della CPU. Se due processi hanno le seccessive sequenze di operazioni della CPU della stessa lunghezza, allora si applica lo scheduling FCFS. Esso ottimizza il tempo di attesa medio per un dato insieme di processi. \r\nSJFP: (Shortest Job First Preempitive). \r\nEsso \u00E8 spesso detto \"shortest remaining time first\"; \u00E8 uguale al SJF ma con la differenza che se arriva un nuovo processo con tempo di esecuzione inferiore a quello attualmente in esecuzione, allora quello nuovo prelaziona quello in esecuzione. \r\nRR: (Round Robin). \r\nE' detto scheduling circolare; E' simile al FCFS ma ha in pi\u00F9 la capacit\u00E0 di prelazione per la commutazione dei processi. Ciascun processo riceve una piccola quantit\u00E0 fissata del tempo della CPU, chiamata quanto di tempo q e la coda dei processi pronti \u00E8 trattata come una coda circolare. Per valori di q molto grandi RR tende al FCFS.\r\n");
		txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
		txtrHelpArea.setEditable(false);
		
		JLabel lblHelp = new JLabel("Help");
		lblHelp.setBounds(10, 422, 245, 25);
		panel_1.add(lblHelp);
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelp.setForeground(Color.RED);
		lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnInfouso = new JButton("Info/Uso");
		btnInfouso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnInfouso.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnInfouso.setBackground(new Color(255, 255, 255));
		btnInfouso.setBounds(545, 85, 81, 48);
		panelMainButton.add(btnInfouso);
		
		model1.addColumn("Processo");
		model1.addColumn("Arrivo");
		model1.addColumn("Durata");
		model1.addColumn("On/Off");

		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);

		JLabel label = (JLabel) table.getDefaultRenderer(Integer.class);
		label.setHorizontalAlignment (SwingConstants.CENTER);
				
		buttonGenera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chkbkMostraAllSoluzione.setEnabled(false);
				chckbxMostraSoluzione.setEnabled(false);
				chckbxMostraSoluzione_1.setEnabled(false);
				chckbxMostraSoluzione_2.setEnabled(false);
				chckbxMostraSoluzione_3.setEnabled(false);
				lineesFCFS.clear();
				lineesSJF.clear();
				lineesSJFP.clear();
				lineesRR.clear();

				jPanelFCFS2.disegnaGriglia(jPanelFCFS2.getGraphics(),lineesFCFS,chckbxMostraSoluzione.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS3.disegnaGriglia(jPanelFCFS3.getGraphics(),lineesSJF,chckbxMostraSoluzione_1.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS4.disegnaGriglia(jPanelFCFS4.getGraphics(),lineesSJFP,chckbxMostraSoluzione_2.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS5.disegnaGriglia(jPanelFCFS5.getGraphics(),lineesRR,chckbxMostraSoluzione_3.isSelected(), chckbxGriglia.isSelected());

				scelta= (String) comboBox.getSelectedItem();
				btnEsegui.setEnabled(false);
				chckbxAttivaModifiche.setSelected(false);
				btnSalvaModifica.setEnabled(false);
				chkbkMostraAllSoluzione.setSelected(false);
				chckbxMostraSoluzione.setSelected(false);
				chckbxMostraSoluzione_1.setSelected(false);
				chckbxMostraSoluzione_2.setSelected(false);
				chckbxMostraSoluzione_3.setSelected(false);
				table.setEnabled(false);
				ModifyDurata.setEnabled(false);
				ModifyArrivo.setEnabled(false);
				ModifyProcess.setEnabled(false);
		int r=Integer.valueOf(scelta);
		
		if (r>=0) 
		{			
			int rowCount = table.getRowCount();
			for (int i = rowCount - 1; i >= 0; i--) {
			    model1.removeRow(i);
			}	
			for (int i=0;i<r;i++) 
			{ 
		
				Random random = new Random();
				int value = random.nextInt(15 + 0) + 0;
				model1.addRow(new Object[0]);
				model1.setValueAt("P"+(i+1),i,0);
				model1.setValueAt(value,i,1);
				int value2 = random.nextInt(15 + 0) + 0;
				model1.setValueAt(value2,i,2);	
				model1.setValueAt(false,i,3);
			}
		}
		
		btnEsegui.setEnabled(true);
		
		}
		});
		
		
		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				chkbkMostraAllSoluzione.setEnabled(false);
				chckbxMostraSoluzione.setEnabled(false);
				chckbxMostraSoluzione_1.setEnabled(false);
				chckbxMostraSoluzione_2.setEnabled(false);
				chckbxMostraSoluzione_3.setEnabled(false);
				
				lineesFCFS.clear();
				lineesSJF.clear();
				lineesSJFP.clear();
				lineesRR.clear();

				jPanelFCFS2.disegnaGriglia(jPanelFCFS2.getGraphics(),lineesFCFS,chckbxMostraSoluzione.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS3.disegnaGriglia(jPanelFCFS3.getGraphics(),lineesSJF,chckbxMostraSoluzione_1.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS4.disegnaGriglia(jPanelFCFS4.getGraphics(),lineesSJFP,chckbxMostraSoluzione_2.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS5.disegnaGriglia(jPanelFCFS5.getGraphics(),lineesRR,chckbxMostraSoluzione_3.isSelected(), chckbxGriglia.isSelected());

				scelta= (String) comboBox.getSelectedItem();
				btnEsegui.setEnabled(false);
				chckbxAttivaModifiche.setSelected(false);
				btnSalvaModifica.setEnabled(false);
				chkbkMostraAllSoluzione.setSelected(false);
				chckbxMostraSoluzione.setSelected(false);
				chckbxMostraSoluzione_1.setSelected(false);
				chckbxMostraSoluzione_2.setSelected(false);
				chckbxMostraSoluzione_3.setSelected(false);
				table.setEnabled(false);
				ModifyDurata.setEnabled(false);
				ModifyArrivo.setEnabled(false);
				ModifyProcess.setEnabled(false);
		int r=Integer.valueOf(scelta);
		
		if (r>=0) 
		{			
			int rowCount = table.getRowCount();
			for (int i = rowCount - 1; i >= 0; i--) {
			    model1.removeRow(i);
			}	
			for (int i=0;i<r;i++) 
			{ 
		
				Random random = new Random();
				int value = random.nextInt(15 + 0) + 0;
				model1.addRow(new Object[0]);
				model1.setValueAt("P"+(i+1),i,0);
				model1.setValueAt(value,i,1);
				int value2 = random.nextInt(15 + 0) + 0;
				model1.setValueAt(value2,i,2);	
				model1.setValueAt(false,i,3);
			}
		}
		
		btnEsegui.setEnabled(true);
		
		}
		});

		btnEsegui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxAttivaModifiche.setSelected(false);
				btnSalvaModifica.setEnabled(false);
				table.setEnabled(false);
				ModifyDurata.setEnabled(false);
				ModifyArrivo.setEnabled(false);
				ModifyProcess.setEnabled(false);
				btnEsegui.setEnabled(false);
				chkbkMostraAllSoluzione.setSelected(false);
				chckbxMostraSoluzione.setSelected(false);
				chckbxMostraSoluzione_1.setSelected(false);
				chckbxMostraSoluzione_2.setSelected(false);
				chckbxMostraSoluzione_3.setSelected(false);

				lineesFCFS.clear();
				lineesSJF.clear();
				lineesSJFP.clear();
				lineesRR.clear();

				jPanelFCFS2.disegnaGriglia(jPanelFCFS2.getGraphics(),lineesFCFS,chckbxMostraSoluzione.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS3.disegnaGriglia(jPanelFCFS3.getGraphics(),lineesSJF,chckbxMostraSoluzione_1.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS4.disegnaGriglia(jPanelFCFS4.getGraphics(),lineesSJFP,chckbxMostraSoluzione_2.isSelected(), chckbxGriglia.isSelected());
				jPanelFCFS5.disegnaGriglia(jPanelFCFS5.getGraphics(),lineesRR,chckbxMostraSoluzione_3.isSelected(), chckbxGriglia.isSelected());

				scelta= (String) comboBox.getSelectedItem();
				
				int r=Integer.valueOf(scelta);
				
				if (r>=0) 
				{			
					for (int i=0;i<table.getRowCount();i++) 
					{ 
						if(Boolean.valueOf((table.getValueAt(i, 3)).toString())==false) {
					    int a=Integer.valueOf((table.getValueAt(i, 1)).toString());
					    int b=Integer.valueOf((table.getValueAt(i, 2)).toString());

					    CreaLinee punti=new CreaLinee();
					    CreaLinee distanza=new CreaLinee();

						punti.creaPunti(a,i+1);
						lineesFCFS.add(punti);
						lineesSJF.add(punti);
						lineesSJFP.add(punti);
						lineesRR.add(punti);
						
						distanza.creaDistanza(i+1,a,b);
						lineesFCFS.add(distanza);
						lineesSJF.add(distanza);
						lineesSJFP.add(distanza);
						lineesRR.add(distanza);
						}
					}
						
				}
				chkbkMostraAllSoluzione.setEnabled(true);
				chckbxMostraSoluzione.setEnabled(true);
				chckbxMostraSoluzione_1.setEnabled(true);
				chckbxMostraSoluzione_2.setEnabled(true);
				chckbxMostraSoluzione_3.setEnabled(true);

			}
		});
		
		chckbxMostraSoluzione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean test= chckbxMostraSoluzione.isSelected();
				lineesFCFS=creaFCFS(lineesFCFS,lineesFCFS);
				jPanelFCFS2.disegnaGriglia(jPanelFCFS2.getGraphics(),lineesFCFS,chckbxMostraSoluzione.isSelected(), chckbxGriglia.isSelected());
			}
		});
		
		chckbxMostraSoluzione_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean test2= chckbxMostraSoluzione_1.isSelected();
				lineesSJF=creaSJF(lineesSJF);
				jPanelFCFS3.disegnaGriglia(jPanelFCFS3.getGraphics(),lineesSJF,chckbxMostraSoluzione_1.isSelected(), chckbxGriglia.isSelected());
			}
		});
		
		chckbxMostraSoluzione_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean test3= chckbxMostraSoluzione_2.isSelected();
				lineesSJFP=creaSJFP(lineesSJFP);
				jPanelFCFS4.disegnaGriglia(jPanelFCFS4.getGraphics(),lineesSJFP,chckbxMostraSoluzione_2.isSelected(), chckbxGriglia.isSelected());
			}
		});
		
		chckbxMostraSoluzione_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean test4= chckbxMostraSoluzione_3.isSelected();
				lineesRR=creaRR(lineesRR);
				jPanelFCFS5.disegnaGriglia(jPanelFCFS5.getGraphics(),lineesRR,chckbxMostraSoluzione_3.isSelected(), chckbxGriglia.isSelected());
			}
		});
		
		chckbxGriglia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean test= chckbxMostraSoluzione.isSelected();
				jPanelFCFS2.disegnaGriglia(jPanelFCFS2.getGraphics(),lineesFCFS,chckbxMostraSoluzione.isSelected(), chckbxGriglia.isSelected());
				boolean test2= chckbxMostraSoluzione_1.isSelected();
				jPanelFCFS3.disegnaGriglia(jPanelFCFS3.getGraphics(),lineesSJF,chckbxMostraSoluzione_1.isSelected(), chckbxGriglia.isSelected());
				boolean test3= chckbxMostraSoluzione_2.isSelected();
				jPanelFCFS4.disegnaGriglia(jPanelFCFS4.getGraphics(),lineesSJFP,chckbxMostraSoluzione_2.isSelected(), chckbxGriglia.isSelected());
				boolean test4= chckbxMostraSoluzione_3.isSelected();
				jPanelFCFS5.disegnaGriglia(jPanelFCFS5.getGraphics(),lineesRR,chckbxMostraSoluzione_3.isSelected(), chckbxGriglia.isSelected());
			}
		});
		/*-----------------------------------------------------*/
       
	}
	
	

    class Panel2 extends JPanel {
    	
    	int xMin=0, xMax=50, yMin=0, yMax=40;//valore degli estremi del piao cartesiano
    	int l=1100, h=118;//salvo dimensioni della finestra in delle variabili per renderle più facili da utilizzare e da modificare
    	float intervalloX, intervalloY;
	   	static public float a=30;
    	
	   	public void paintComponent(Graphics g){
    	super.paintComponent(g); 
    	setBackground(Color.white); 
    	intervalloX=l/((float)xMax-xMin);
    	intervalloY=h/((float)yMax-yMin);
    	int i,j,k;

    	g.setColor(Color.black);
    	
    	g.setColor(Color.lightGray);

    	for(i=0;i<120;) {
        	g.drawLine(0,h-i, l,h-i);
    		i=i+15;
    	}
    	g.setColor(Color.BLUE);
    	g.drawLine(0,h-15, l,h-15);
    	g.setColor(Color.lightGray);

    	for(j=0;j<1075;) {
    		g.drawLine(l-j,0,l-j,h);
    		j=j+15;
    	}
    	g.setColor(Color.BLUE);
		g.drawLine(l-j+15,0,l-j+15,h);

		g.setFont(new Font("Times New Roman", Font.BOLD, 11));
    	g.setColor(Color.black);
    	g.drawString("P1",3,92);
    	g.drawString("P2",3,77);
    	g.drawString("P3",3,62);
    	g.drawString("P4",3,47);
    	g.drawString("P5",3,32);
    	g.drawString("P6",3,17);
    	int count=2;
    	for( k=01;k<70;k++){
    		if(k<10)g.drawString(" 0"+String.valueOf(k)+" ",12+count*15,115);
    		else g.drawString(" "+String.valueOf(k)+" ",12+count*15,115);
    		count++;
    	}
    	}
   
    	public void disegnaGriglia(Graphics g, ArrayList<CreaLinee> dataset,Boolean selectSoluzione,Boolean selectGriglia){
    		super.paintComponent(g); 
        	setBackground(Color.white); 
        	int i,j,k;
        	g.setColor(Color.black);
        	
        	g.setColor(Color.lightGray);

        	if(selectGriglia==true) {
        		for(i=0;i<120;) {
        			g.drawLine(0,h-i, l,h-i);
        			i=i+15;
        		}
        		g.setColor(Color.BLUE);
        		g.drawLine(0,h-15, l,h-15);
        		g.setColor(Color.lightGray);

        		for(j=0;j<1075;) {
        			g.drawLine(l-j,0,l-j,h);
        			j=j+15;
        		}
        		g.setColor(Color.BLUE);
        		g.drawLine(l-j+15,0,l-j+15,h);
        	}
        	else {
        		for(i=0;i<120;) {
            		i=i+15;
            	}
            	g.setColor(Color.BLUE);
            	g.drawLine(0,h-15, l,h-15);

            	for(j=0;j<1075;) {
            		j=j+15;
            	}
            	g.setColor(Color.BLUE);
        		g.drawLine(l-j+15,0,l-j+15,h);
            }        		
        	
        	
        	g.setFont(new Font("Times New Roman", Font.BOLD, 11));
        	g.setColor(Color.black);
        	g.drawString("P1",3,92);
        	g.drawString("P2",3,77);
        	g.drawString("P3",3,62);
        	g.drawString("P4",3,47);
        	g.drawString("P5",3,32);
        	g.drawString("P6",3,17);
    	
        	int count=2;
        	for( k=01;k<70;k++){
        		if(k<10)g.drawString(" 0"+String.valueOf(k)+" ",12+count*15,115);
        		else g.drawString(" "+String.valueOf(k)+" ",12+count*15,115);
        		count++;
        	}
        	
        	if(selectSoluzione==true) {
        		g.setColor(Color.red);
            	
            	for(int l=0;l<dataset.size();l++) {        		
            		if(l%2==0) {
            			g.drawString("O",30+dataset.get(l).ritornaPunti().get(0)*15,92-l/2*15);
            		}
            	}

            	/*for(int l=0;l<dataset.size();l++) {
            		
            		if(dataset.get(0).ritornaPunti().get(2)==1) {
            			g.drawLine(15+dataset.get(0).ritornaPunti().get(0)*15,88,15+dataset.get(0).ritornaPunti().get(0)*15+dataset.get(0).ritornaPunti().get(1)*15,88);
               		}
            		
            	}*/
        	}
    	}
    }
    
    
    ArrayList<CreaLinee> creaFCFS(ArrayList<CreaLinee> lineefcfs,ArrayList<CreaLinee> TMP ){
    	//CON ARRAY ORDINATO PER ARRIVO AGGIUNGERE ALL'ARRIVO DEL SUCCESSIVO LA DURATA DEL PRECEDENTE

    	ArrayList<CreaLinee> FCFS= new ArrayList<CreaLinee>();
		
    	for(int l=0;l<lineefcfs.size();l++) {  
    		if(l%2!=0) {
    			FCFS.add(lineefcfs.get(l));
    		}
    	}
    	return FCFS;
	}
    
    ArrayList<CreaLinee> creaSJF(ArrayList<CreaLinee> lineesjf){
    	//NON NE HO IDEA
    	ArrayList<CreaLinee> SJF= new ArrayList<CreaLinee>();
		
    	for(int l=0;l<lineesjf.size();l++) {  
    		if(l%2!=0) {
    			SJF.add(lineesjf.get(l));
    		}
    	}
		return SJF;
	}
    
    ArrayList<CreaLinee> creaSJFP(ArrayList<CreaLinee> lineesjfp){
		return lineesjfp;
	}
    
    ArrayList<CreaLinee> creaRR(ArrayList<CreaLinee> lineerr){
    	//CON ARRAY ORDINATO PER ARRIVO INSERIRE IN ARRAY NP,ARRIVO+DURATAPREC,DURATA-Q FINCHE' DURATA>0

    	ArrayList<CreaLinee> RR= new ArrayList<CreaLinee>();
		
    	for(int l=0;l<lineerr.size();l++) {  
    		if(l%2!=0) {
    			RR.add(lineerr.get(l));
    		}
    	}
		return RR;	
	}
}
//System.out.println(	"P"+lineefcfs.get(l).ritornaLinee().get(0)+" A"+	lineefcfs.get(l).ritornaLinee().get(1)+" D"+lineefcfs.get(l).ritornaLinee().get(2));
/*for(int k=0;k<TMP.size();k++) { 
	if(k%2!=0) {
		
	if((TMP.get(k).ritornaLinee().get(1))<min) {
		min=TMP.get(k).ritornaLinee().get(1);
		min2=TMP.get(k);
	
	}
	
  }
}
if(min2!=null) {
	//System.out.println(	"P1");
	for(int a=0;a<FCFS.size();a++) { 

		if((min2.ritornaLinee().get(0))==(FCFS.get(a).ritornaLinee().get(0))) {

			flag=1;
		}
	}
	if(flag==0) {

	FCFS.add(min2);
	System.out.println(	"P"+FCFS.get(0)+min2);

	System.out.println(	"P"+FCFS.get(0).ritornaLinee().get(0)+" A"+	FCFS.get(0).ritornaLinee().get(1)+" D"+FCFS.get(0).ritornaLinee().get(2));

	min=16;
	}
}*/