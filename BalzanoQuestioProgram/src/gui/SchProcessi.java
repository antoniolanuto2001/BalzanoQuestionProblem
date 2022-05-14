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
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet.ColorAttribute;

import model.PanelGraficiSchProcessi;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.Desktop;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.beans.VetoableChangeListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;

public class SchProcessi extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private String scelta="0";
	ArrayList<CreaLinee> arrayPunti= new ArrayList<CreaLinee>();
	ArrayList<CreaLinee> arrayLinea= new ArrayList<CreaLinee>();
	ArrayList<CreaLinee> FCFS=new ArrayList<CreaLinee>();
	ArrayList<CreaLinee> SJF=new ArrayList<CreaLinee>();
	ArrayList<CreaLinee> SJFP=new ArrayList<CreaLinee>();
	ArrayList<CreaLinee> RR=new ArrayList<CreaLinee>();

public SchProcessi(JFrame framechiamante) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Balzano Question Problem : Scheduling della CPU");

/**							PANNELLO PRINCIPALE								*/
		JPanel pannelloPrincipale = new JPanel();
			pannelloPrincipale.setForeground(new Color(153, 204, 255));
			pannelloPrincipale.setBounds(0, 0, 1440, 800);
			frame.getContentPane().add(pannelloPrincipale);
			pannelloPrincipale.setLayout(null);

/**						BOTTONI PANNELLO PRINCIPALE							*/
		//BOTTONE INDIETRO	
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setBackground(new Color(255, 255, 255));
			btnIndietro.setBorder(new LineBorder(new Color(102, 51, 204), 4));
			btnIndietro.setOpaque(true);
			btnIndietro.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					framechiamante.setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				}
			});
			btnIndietro.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnIndietro.setBounds(101, 85, 128, 48);
			pannelloPrincipale.add(btnIndietro);
	
		//BOTTONE GENERA
		JButton btnGenera = new JButton("Genera Tabella Processi");
			btnGenera.setFont(new Font("Segoe UI", Font.BOLD, 12));
			btnGenera.setBorder(new LineBorder(new Color(0, 204, 0), 4));
			btnGenera.setBackground(new Color(255, 255, 255));
			btnGenera.setBounds(974, 86, 157, 48);
			pannelloPrincipale.add(btnGenera);
		
		//BOTTONE SLIDE ARGOMENTO
		JButton btnSlideArgomento = new JButton("Slide Argomento");
			btnSlideArgomento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Desktop d = Desktop.getDesktop();
					try {
						d.browse(new URI ("http://balzanoslidesistemiopera.altervista.org/Slides_Sistemi_Operativi.pdf#page=118"));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnSlideArgomento.setOpaque(true);
			btnSlideArgomento.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnSlideArgomento.setBorder(new LineBorder(new Color(0, 204, 255), 4));
			btnSlideArgomento.setBackground(new Color(255, 255, 255));
			btnSlideArgomento.setBounds(239, 85, 128, 48);
			pannelloPrincipale.add(btnSlideArgomento);
			frame.setVisible(true); 
	        
		//BOTTONE ESCI
		JButton btnEsci = new JButton("Esci");
			btnEsci.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnEsci.setBorder(new LineBorder(new Color(255, 204, 0), 4));
			btnEsci.setBackground(new Color(255, 255, 255));
			btnEsci.setBounds(10, 85, 81, 48);
			pannelloPrincipale.add(btnEsci);
		
		//BOTTONE INFO SULL'USO DELL'APP	
		JButton btnInfouso = new JButton("Info/Uso");
			btnEsci.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		
			btnInfouso.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnInfouso.setBorder(new LineBorder(new Color(0, 0, 0), 4));
			btnInfouso.setBackground(new Color(255, 255, 255));
			btnInfouso.setBounds(525, 85, 81, 48);
			pannelloPrincipale.add(btnInfouso);
			
		JButton buttonVideo = new JButton("Videolezione");
	        buttonVideo.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Desktop d = Desktop.getDesktop();
					try {
						d.browse(new URI ("https://youtu.be/OP_pscPLeio"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        	}
	        });
	        buttonVideo.setBorder(new LineBorder(new Color(153, 51, 0), 4));
	        buttonVideo.setBackground(new Color(255, 255, 255));
	        buttonVideo.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        buttonVideo.setBounds(377, 86, 138, 46);
	        pannelloPrincipale.add(buttonVideo);
	        
			
/**							PANNELLO TITOLO									*/
		JPanel pannelloTitolo = new JPanel();
			pannelloTitolo.setBorder(new LineBorder(new Color(51, 204, 255), 10));
			pannelloTitolo.setBackground(Color.WHITE);
			pannelloTitolo.setBounds(0, 0, 1406, 75);
			pannelloPrincipale.add(pannelloTitolo);
			pannelloTitolo.setLayout(null);
			
		//TITOLO
		JLabel labelTitolo = new JLabel("SCHEDULING DELLA CPU");
			labelTitolo.setForeground(new Color(0, 0, 0));
			labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitolo.setFont(new Font("Segoe UI", Font.BOLD, 40));
			labelTitolo.setBounds(0, 0, 1408, 73);
			pannelloTitolo.add(labelTitolo);
		

/*INIZIO GUI COMPLICATA*/		

/**							PANNELLO GRAFICI								*/
		JPanel pannelloGrafici = new JPanel();
	        pannelloGrafici.setBounds(0, 143, 1131, 620);
	        pannelloPrincipale.add(pannelloGrafici);
	        pannelloGrafici.setLayout(null);
        
        //PANNELLO FIRST-COME,FIRST-SERVED
        JPanel pannelloFCFS = new JPanel();
			pannelloFCFS.setBounds(10, 0, 1121, 150);
			pannelloGrafici.add(pannelloFCFS);
			pannelloFCFS.setLayout(null);
			pannelloFCFS.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));

		JLabel lblFirstcomeFirstserved = new JLabel("First-Come, First-Served");
			lblFirstcomeFirstserved.setHorizontalAlignment(SwingConstants.CENTER);
			lblFirstcomeFirstserved.setForeground(Color.RED);
			lblFirstcomeFirstserved.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblFirstcomeFirstserved.setBounds(10, 0, 489, 25);
			pannelloFCFS.add(lblFirstcomeFirstserved);
		
		JCheckBox chckbxMostraSoluzioneFCFS = new JCheckBox("Mostra Soluzione");
			chckbxMostraSoluzioneFCFS.setEnabled(false);
			chckbxMostraSoluzioneFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chckbxMostraSoluzioneFCFS.setBounds(513, 3, 150, 25);
			pannelloFCFS.add(chckbxMostraSoluzioneFCFS);
		
		JLabel lblTAMFCFS = new JLabel("Tempo di attesa medio:");
			lblTAMFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblTAMFCFS.setBounds(670, 3, 150, 25);
			pannelloFCFS.add(lblTAMFCFS);
		
		JLabel DatoTAMFCFS = new JLabel("");
			DatoTAMFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoTAMFCFS.setBounds(821, 3, 45, 25);
			pannelloFCFS.add(DatoTAMFCFS);
			
		JLabel lblCDCFCFS = new JLabel("Cambi di contesto: ");
			lblCDCFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblCDCFCFS.setBounds(887, 3, 130, 25);
			pannelloFCFS.add(lblCDCFCFS);
		
		JLabel DatoCDCFCFS = new JLabel("");
			DatoCDCFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoCDCFCFS.setBounds(1014, 3, 45, 25);
			pannelloFCFS.add(DatoCDCFCFS);
		
		//PANNELLO SHORTEST JOB FIRST
		JPanel pannelloSJF = new JPanel();
			pannelloSJF.setBounds(10, 153, 1121, 150);
			pannelloGrafici.add(pannelloSJF);
			pannelloSJF.setLayout(null);
			pannelloSJF.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));

		JLabel lblShortestJobFirts = new JLabel("Shortest Job First");
			lblShortestJobFirts.setHorizontalAlignment(SwingConstants.CENTER);
			lblShortestJobFirts.setForeground(Color.RED);
			lblShortestJobFirts.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblShortestJobFirts.setBounds(10, 0, 489, 25);
			pannelloSJF.add(lblShortestJobFirts);
		
		JCheckBox chckbxMostraSoluzioneSJF = new JCheckBox("Mostra Soluzione");
			chckbxMostraSoluzioneSJF.setEnabled(false);
			chckbxMostraSoluzioneSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chckbxMostraSoluzioneSJF.setBounds(513, 3, 150, 25);
			pannelloSJF.add(chckbxMostraSoluzioneSJF);
		
		JLabel lblTAMSJF = new JLabel("Tempo di attesa medio:");
			lblTAMSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblTAMSJF.setBounds(670, 3, 150, 25);
			pannelloSJF.add(lblTAMSJF);
		
		JLabel DatoTAMSJF = new JLabel("");
			DatoTAMSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoTAMSJF.setBounds(821, 3, 45, 25);
			pannelloSJF.add(DatoTAMSJF);
			
		JLabel lblCDCSJF = new JLabel("Cambi di contesto: ");
			lblCDCSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblCDCSJF.setBounds(887, 3, 130, 25);
			pannelloSJF.add(lblCDCSJF);
		
		JLabel DatoCDCSJF = new JLabel("");
			DatoCDCSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoCDCSJF.setBounds(1014, 3, 45, 25);
			pannelloSJF.add(DatoCDCSJF);
		
		//PANNELLO SHORTEST JOB FIRST PREEMPTIVE
		JPanel pannelloSJFP = new JPanel();
			pannelloSJFP.setLayout(null);
			pannelloSJFP.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
			pannelloSJFP.setBounds(10, 306, 1121, 150);
			pannelloGrafici.add(pannelloSJFP);
		
		JLabel lblShortestJobFirstPreemptive = new JLabel("Shortest Job First Preemptive");
			lblShortestJobFirstPreemptive.setHorizontalAlignment(SwingConstants.CENTER);
			lblShortestJobFirstPreemptive.setForeground(Color.RED);
			lblShortestJobFirstPreemptive.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblShortestJobFirstPreemptive.setBounds(10, 0, 489, 25);
			pannelloSJFP.add(lblShortestJobFirstPreemptive);
		
		JCheckBox chckbxMostraSoluzioneSJFP = new JCheckBox("Mostra Soluzione");
			chckbxMostraSoluzioneSJFP.setEnabled(false);
			chckbxMostraSoluzioneSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chckbxMostraSoluzioneSJFP.setBounds(513, 3, 150, 25);
			pannelloSJFP.add(chckbxMostraSoluzioneSJFP);
		
		JLabel lblTAMSJFP = new JLabel("Tempo di attesa medio:");
			lblTAMSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblTAMSJFP.setBounds(670, 3, 150, 25);
			pannelloSJFP.add(lblTAMSJFP);

		JLabel DatoTAMSJFP = new JLabel("");
			DatoTAMSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoTAMSJFP.setBounds(821, 3, 45, 25);
			pannelloSJFP.add(DatoTAMSJFP);
			
		JLabel lblCDCSJFP = new JLabel("Cambi di contesto: ");
			lblCDCSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblCDCSJFP.setBounds(887, 3, 130, 25);
			pannelloSJFP.add(lblCDCSJFP);
		
		JLabel DatoCDCSJFP = new JLabel("");
			DatoCDCSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoCDCSJFP.setBounds(1014, 3, 45, 25);
			pannelloSJFP.add(DatoCDCSJFP);
	
		//PANNELLO ROUND ROBIN
		JPanel pannelloRR = new JPanel();
			pannelloRR.setLayout(null);
			pannelloRR.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
			pannelloRR.setBounds(10, 459, 1121, 150);
			pannelloGrafici.add(pannelloRR);
		
		JLabel lblRoundRobin = new JLabel("Round Robin");
			lblRoundRobin.setHorizontalAlignment(SwingConstants.CENTER);
			lblRoundRobin.setForeground(Color.RED);
			lblRoundRobin.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRoundRobin.setBounds(10, 0, 351, 25);
			pannelloRR.add(lblRoundRobin);
		
		JCheckBox chckbxMostraSoluzioneRR = new JCheckBox("Mostra Soluzione");
			chckbxMostraSoluzioneRR.setEnabled(false);
			chckbxMostraSoluzioneRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chckbxMostraSoluzioneRR.setBounds(513, 3, 150, 25);
			pannelloRR.add(chckbxMostraSoluzioneRR);
		
		JLabel lblTAMRR = new JLabel("Tempo di attesa medio:");
			lblTAMRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblTAMRR.setBounds(670, 3, 150, 25);
			pannelloRR.add(lblTAMRR);

		JLabel DatoTAMRR = new JLabel("");
			DatoTAMRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoTAMRR.setBounds(821, 3, 45, 25);
			pannelloRR.add(DatoTAMRR);
			
		JLabel lblCDCRR = new JLabel("Cambi di contesto: ");
			lblCDCRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblCDCRR.setBounds(887, 3, 130, 25);
			pannelloRR.add(lblCDCRR);
		
		JLabel DatoCDCRR = new JLabel("");
			DatoCDCRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoCDCRR.setBounds(1014, 3, 45, 25);
			pannelloRR.add(DatoCDCRR);
		
		JLabel lblQRR = new JLabel("Q=");
			lblQRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblQRR.setBounds(371, 3, 32, 25);
			pannelloRR.add(lblQRR);
		
		JComboBox comboBoxQRR = new JComboBox();
			comboBoxQRR.setEnabled(false);
			comboBoxQRR.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
			comboBoxQRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			comboBoxQRR.setBackground(Color.WHITE);
			comboBoxQRR.setBounds(396, 5, 50, 21);
			pannelloRR.add(comboBoxQRR);
			
			
/**						PANNELLI CON GRAFICO CARTESIANO						*/			
				
		//GRAFICO FCFS
		PanelGraficiSchProcessi jPanelFCFS = new PanelGraficiSchProcessi();
			jPanelFCFS.setBackground(new java.awt.Color(255, 255, 255));
			jPanelFCFS.setBounds(10, 27, 1100, 118);
			jPanelFCFS.setLayout(null);
			pannelloFCFS.add(jPanelFCFS);

		//GRAFICO SJF
		PanelGraficiSchProcessi jPanelSJF = new PanelGraficiSchProcessi();
			jPanelSJF.setBackground(new java.awt.Color(255, 255, 255));
			jPanelSJF.setLayout(null);
			jPanelSJF.setBounds(10, 27, 1100, 118);
			pannelloSJF.add(jPanelSJF);

		//GRAFICO SJFP
		PanelGraficiSchProcessi jPanelSJFP = new PanelGraficiSchProcessi();
			jPanelSJFP.setBackground(new java.awt.Color(255, 255, 255));
			jPanelSJFP.setLayout(null);
			jPanelSJFP.setBounds(10, 27, 1100, 118);
			pannelloSJFP.add(jPanelSJFP);
		
		//GRAFICO RR
		PanelGraficiSchProcessi jPanelRR = new PanelGraficiSchProcessi();
			jPanelRR.setBackground(new java.awt.Color(255, 255, 255));
			jPanelRR.setLayout(null);
			jPanelRR.setBounds(10, 27, 1100, 118);
			pannelloRR.add(jPanelRR);

   
/**							PANNELLI DI CONTROLLO							*/			
		//PANNELLO DI CONTROLLO
		JPanel pannelloDiControllo = new JPanel();
			pannelloDiControllo.setBounds(1141, 85, 265, 668);
			pannelloPrincipale.add(pannelloDiControllo);
			pannelloDiControllo.setLayout(null);
			//pannelloDiControllo.setBorder(new LineBorder(new Color(255, 204, 51), 3));
		
		JPanel pannellodicontrolloTitolo = new JPanel();
			pannellodicontrolloTitolo.setBounds(10, 10, 245, 54);
			pannellodicontrolloTitolo.setBackground(new Color(255, 255, 255));
			pannelloDiControllo.add(pannellodicontrolloTitolo);
			pannellodicontrolloTitolo.setBorder(new LineBorder(new Color(0, 204, 255), 4));
			pannellodicontrolloTitolo.setLayout(null);
			
		JLabel labelPnlCtrl = new JLabel("Pannello di controllo");
			labelPnlCtrl.setBounds(10, 10, 225, 34);
			labelPnlCtrl.setHorizontalAlignment(SwingConstants.CENTER);
			pannellodicontrolloTitolo.add(labelPnlCtrl);
			labelPnlCtrl.setFont(new Font("Arial", Font.BOLD, 22));
		
		JLabel labelEditor = new JLabel("Editor");
			labelEditor.setHorizontalAlignment(SwingConstants.CENTER);
			labelEditor.setForeground(new Color(255, 0, 0));
			labelEditor.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelEditor.setBounds(0, 70, 265, 25);
			pannelloDiControllo.add(labelEditor);
			
		//PANNELLO EDITOR
		JPanel pannelloEDITOR = new JPanel();
			pannelloEDITOR.setBounds(10, 95, 245, 218);
			pannelloDiControllo.add(pannelloEDITOR);
			pannelloEDITOR.setLayout(null);
			//pannelloEDITOR.setBorder(new LineBorder(new Color(255, 204, 0), 3));
		
		JLabel lblNumeroDiProcessi = new JLabel("Numero di processi");
			lblNumeroDiProcessi.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumeroDiProcessi.setForeground(new Color(0, 0, 0));
			lblNumeroDiProcessi.setFont(new Font("Arial", Font.BOLD, 15));
			lblNumeroDiProcessi.setBounds(10, 2, 165, 23);
			pannelloEDITOR.add(lblNumeroDiProcessi);
		
		JComboBox comboBoxSceltaNProcessi = new JComboBox();
			comboBoxSceltaNProcessi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			comboBoxSceltaNProcessi.setBackground(new Color(255, 255, 255));
			comboBoxSceltaNProcessi.setModel(new DefaultComboBoxModel(new String[] {"6", "5", "4", "3", "2", "1", "0"}));
			comboBoxSceltaNProcessi.setBounds(185, 2, 50, 21);
			pannelloEDITOR.add(comboBoxSceltaNProcessi);
		
		JScrollPane scrollTabellaProcessi= new JScrollPane();
			scrollTabellaProcessi.setBounds(10, 27, 225, 121);
			pannelloEDITOR.add(scrollTabellaProcessi);
		
		final JTable tabellaProcessi = new JTable();
			tabellaProcessi.setEnabled(false);
			tabellaProcessi.setBackground(new Color(255, 255, 255));
			tabellaProcessi.setCellSelectionEnabled(true);
			tabellaProcessi.setFont(new Font("Arial", Font.BOLD, 12));
			scrollTabellaProcessi.setViewportView(tabellaProcessi);
		
		DefaultTableModel model1 = new DefaultTableModel(){
			
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0:
					return String.class;
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
		
		tabellaProcessi.setModel(model1);
		
		model1.addColumn("Processo");
		model1.addColumn("Arrivo");
		model1.addColumn("Durata");
		model1.addColumn("On/Off");
		
		tabellaProcessi.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabellaProcessi.getColumnModel().getColumn(1).setPreferredWidth(60);
		tabellaProcessi.getColumnModel().getColumn(2).setPreferredWidth(60);
		tabellaProcessi.getColumnModel().getColumn(3).setPreferredWidth(50);
		tabellaProcessi.getColumnModel().getColumn(0).setResizable(false);
		tabellaProcessi.getColumnModel().getColumn(1).setResizable(false);
		tabellaProcessi.getColumnModel().getColumn(2).setResizable(false);
		tabellaProcessi.getColumnModel().getColumn(3).setResizable(false);

		JLabel label = (JLabel) tabellaProcessi.getDefaultRenderer(Integer.class);
		label.setHorizontalAlignment (SwingConstants.CENTER);

		JLabel label2 = (JLabel) tabellaProcessi.getDefaultRenderer(String.class);
		label2.setHorizontalAlignment (SwingConstants.CENTER);
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label2.setBackground(Color.ORANGE);

		//PANNELLO PLOT
		JPanel PannelloPLOT = new JPanel();
			PannelloPLOT.setBounds(10, 348, 245, 94);
			pannelloDiControllo.add(PannelloPLOT);
			PannelloPLOT.setLayout(null);
			//PannelloPLOT.setBorder(new LineBorder(new Color(255, 204, 0), 3));
		
		JCheckBox chckbxGriglia = new JCheckBox("Griglia");
			chckbxGriglia.setSelected(true);
			chckbxGriglia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chckbxGriglia.setBounds(6, 6, 65, 21);
			PannelloPLOT.add(chckbxGriglia);

		JComboBox ModifyProcess = new JComboBox();
			ModifyProcess.setEnabled(false);
			ModifyProcess.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			ModifyProcess.setBackground(new Color(255, 255, 255));
			ModifyProcess.setModel(new DefaultComboBoxModel(new String[] {}));
			ModifyProcess.setBounds(10, 158, 60, 20);
			pannelloEDITOR.add(ModifyProcess);
		
		JComboBox ModifyArrivo = new JComboBox();
			ModifyArrivo.setEnabled(false);
			ModifyArrivo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			ModifyArrivo.setBackground(new Color(255, 255, 255));
			ModifyArrivo.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
			ModifyArrivo.setBounds(80, 158, 45, 20);
			pannelloEDITOR.add(ModifyArrivo);
		
		JComboBox ModifyDurata = new JComboBox();
			ModifyDurata.setEnabled(false);
			ModifyDurata.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			ModifyDurata.setBackground(new Color(255, 255, 255));
			ModifyDurata.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
			ModifyDurata.setBounds(135, 158, 45, 20);
			pannelloEDITOR.add(ModifyDurata);
			

		JButton modificaTabella = new JButton("OK");
			modificaTabella.setFont(new Font("Tahoma", Font.PLAIN, 6));
			modificaTabella.setBounds(185, 158, 50, 21);
			pannelloEDITOR.add(modificaTabella);
		
		JButton btnGeneraGrafici = new JButton("GENERA GRAFICI");
			btnGeneraGrafici.setEnabled(false);
			btnGeneraGrafici.setBackground(new Color(255, 255, 255));
			btnGeneraGrafici.setBorder(new LineBorder(new Color(51, 204, 255), 4));
			btnGeneraGrafici.setFont(new Font("Arial", Font.BOLD, 15));
			btnGeneraGrafici.setBounds(10, 183, 225, 28);
			pannelloEDITOR.add(btnGeneraGrafici);
			
		JButton btnSalvaModifica = new JButton("Salva Modifiche");
			btnSalvaModifica.setEnabled(false);
			btnSalvaModifica.setBounds(103, 63, 125, 21);
			PannelloPLOT.add(btnSalvaModifica);
		
		JCheckBox chckbxAttivaModifiche = new JCheckBox("Attiva modifiche");
			chckbxAttivaModifiche.setEnabled(false);
			chckbxAttivaModifiche.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chckbxAttivaModifiche.setBounds(100, 6, 140, 21);
			PannelloPLOT.add(chckbxAttivaModifiche);
		
		JCheckBox chkbkMostraAllSoluzione = new JCheckBox("Mostra tutte le soluzione");
			chkbkMostraAllSoluzione.setEnabled(false);
			chkbkMostraAllSoluzione.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chkbkMostraAllSoluzione.setBounds(6, 32, 222, 21);
			PannelloPLOT.add(chkbkMostraAllSoluzione);
		
		JLabel lblPlot = new JLabel("Plot");
			lblPlot.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlot.setForeground(Color.RED);
			lblPlot.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPlot.setBounds(10, 323, 245, 25);
			pannelloDiControllo.add(lblPlot);
		
		//PANNELLO HELP
		JPanel pannelloHelp = new JPanel();
			pannelloHelp.setBorder(new LineBorder(new Color(255, 204, 0), 3));
			pannelloHelp.setBounds(10, 469, 245, 189);
			pannelloDiControllo.add(pannelloHelp);
			pannelloHelp.setLayout(null);
		
		JScrollPane scrollPaneHelp = new JScrollPane();
			scrollPaneHelp.setBounds(0, 0, 245, 189);
			//scrollPaneHelp.setBorder(new LineBorder(new Color(255, 204, 0), 3));
			pannelloHelp.add(scrollPaneHelp);
		
		JTextArea txtrHelpArea = new JTextArea();
			scrollPaneHelp.setViewportView(txtrHelpArea);
			txtrHelpArea.setWrapStyleWord(true);
			txtrHelpArea.setLineWrap(true);
			txtrHelpArea.setText("FCFS: (First Come First Served). \r\nCon questo schema la CPU si assegna al processo che la richiede per  primo. Esso \u00E8 il piu' semplice degli algoritmi di scheduling della CPU ed \u00E8 basato su code FIFO. Questo algoritmo genera l' Effetto Convoglio: tutti i processi attendono che un lungo processo liberi la CPU.\r\nSJF: (Shortest Job First). \r\nDetto anche scheduling per brevit\u00E0. Questo algoritmo associa a ogni processo la lunghezza della successiva sequenza di operazioni della CPU. Se due processi hanno le seccessive sequenze di operazioni della CPU della stessa lunghezza, allora si applica lo scheduling FCFS. Esso ottimizza il tempo di attesa medio per un dato insieme di processi. \r\nSJFP: (Shortest Job First Preempitive). \r\nEsso \u00E8 spesso detto \"shortest remaining time first\"; \u00E8 uguale al SJF ma con la differenza che se arriva un nuovo processo con tempo di esecuzione inferiore a quello attualmente in esecuzione, allora quello nuovo prelaziona quello in esecuzione. \r\nRR: (Round Robin). \r\nE' detto scheduling circolare; E' simile al FCFS ma ha in pi\u00F9 la capacit\u00E0 di prelazione per la commutazione dei processi. Ciascun processo riceve una piccola quantit\u00E0 fissata del tempo della CPU, chiamata quanto di tempo q e la coda dei processi pronti \u00E8 trattata come una coda circolare. Per valori di q molto grandi RR tende al FCFS.\r\n");
			txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
			txtrHelpArea.setEditable(false);
		
		JLabel lblHelp = new JLabel("Help");
			lblHelp.setBounds(10, 444, 245, 25);
			pannelloDiControllo.add(lblHelp);
			lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
			lblHelp.setForeground(Color.RED);
			lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
			

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
/**							IMPLEMENTAZIONE EVENTI												*/
						
	//EVENTO SU BOTTONE GENERA TABELLA PROCESSI
		btnGenera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				arrayLinea.clear();
				arrayPunti.clear();
				FCFS.clear();
				
				ModifyProcess.removeAllItems();
				btnGeneraGrafici.setEnabled(true);
				chckbxAttivaModifiche.setEnabled(true);
				
				chckbxMostraSoluzioneFCFS.setEnabled(false);
				chckbxMostraSoluzioneSJF.setEnabled(false);
				chckbxMostraSoluzioneSJFP.setEnabled(false);
				chckbxMostraSoluzioneRR.setEnabled(false);
				chkbkMostraAllSoluzione.setEnabled(false);
				comboBoxQRR.setEnabled(false);
				btnSalvaModifica.setEnabled(false);
				tabellaProcessi.setEnabled(false);
				ModifyArrivo.setEnabled(false);
				ModifyDurata.setEnabled(false);
				ModifyProcess.setEnabled(false);
				modificaTabella.setEnabled(false);
				
				chckbxAttivaModifiche.setSelected(false);
				chckbxMostraSoluzioneFCFS.setSelected(false);
				chckbxMostraSoluzioneSJF.setSelected(false);
				chckbxMostraSoluzioneSJFP.setSelected(false);
				chckbxMostraSoluzioneRR.setSelected(false);
				chkbkMostraAllSoluzione.setSelected(false);

				comboBoxQRR.setSelectedIndex(0);
				ModifyArrivo.setSelectedIndex(0);
				ModifyDurata.setSelectedIndex(0);
				
				scelta= (String) comboBoxSceltaNProcessi.getSelectedItem();
				int numeroProcessi=Integer.valueOf(scelta);
				
				if (numeroProcessi>=0) 
				{			
					int rowCount = tabellaProcessi.getRowCount();
					for (int i = rowCount - 1; i >= 0; i--) {
					    model1.removeRow(i);
					}	
					for (int i=0;i<numeroProcessi;i++) 
					{ 
						Random random = new Random();
						int value = random.nextInt(15 + 0) + 0;
						model1.addRow(new Object[0]);
						model1.setValueAt("P"+(i+1),i,0);
						model1.setValueAt(value,i,1);
						int value2 = random.nextInt(15 + 0) + 0;
						model1.setValueAt(value2,i,2);	
						model1.setValueAt(false,i,3);
						ModifyProcess.addItem("P"+(i+1));

					}
				}
				
			}
		});

	//EVENTO SU BOX SCLETA NUMERO PROCESSI
		comboBoxSceltaNProcessi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayLinea.clear();
				arrayPunti.clear();
				FCFS.clear();

				ModifyProcess.removeAllItems();
				btnGeneraGrafici.setEnabled(true);
				chckbxAttivaModifiche.setEnabled(true);
				
				chckbxMostraSoluzioneFCFS.setEnabled(false);
				chckbxMostraSoluzioneSJF.setEnabled(false);
				chckbxMostraSoluzioneSJFP.setEnabled(false);
				chckbxMostraSoluzioneRR.setEnabled(false);
				chkbkMostraAllSoluzione.setEnabled(false);
				comboBoxQRR.setEnabled(false);
				btnSalvaModifica.setEnabled(false);
				tabellaProcessi.setEnabled(false);
				ModifyArrivo.setEnabled(false);
				ModifyDurata.setEnabled(false);
				ModifyProcess.setEnabled(false);
				modificaTabella.setEnabled(false);

				chckbxAttivaModifiche.setSelected(false);
				chckbxMostraSoluzioneFCFS.setSelected(false);
				chckbxMostraSoluzioneSJF.setSelected(false);
				chckbxMostraSoluzioneSJFP.setSelected(false);
				chckbxMostraSoluzioneRR.setSelected(false);
				chkbkMostraAllSoluzione.setSelected(false);
				
				comboBoxQRR.setSelectedIndex(1);
				ModifyArrivo.setSelectedIndex(1);
				ModifyDurata.setSelectedIndex(1);
				
				scelta= (String) comboBoxSceltaNProcessi.getSelectedItem();
				int numeroProcessi=Integer.valueOf(scelta);
				
				if (numeroProcessi>=0) 
				{			
					int rowCount = tabellaProcessi.getRowCount();
					for (int i = rowCount - 1; i >= 0; i--) {
					    model1.removeRow(i);
					}	
					for (int i=0;i<numeroProcessi;i++) 
					{ 
						Random random = new Random();
						int value = random.nextInt(15 + 0) + 0;
						model1.addRow(new Object[0]);
						model1.setValueAt("P"+(i+1),i,0);
						model1.setValueAt(value,i,1);
						int value2 = random.nextInt(15 + 0) + 0;
						model1.setValueAt(value2,i,2);	
						model1.setValueAt(false,i,3);
						ModifyProcess.addItem("P"+(i+1));
					}
				}
				
			}
		});

	//EVENTO SU BOTTONE GENERA GRAFICI
		btnGeneraGrafici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
				jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());
				jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
				jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
				
				arrayLinea.clear();
				arrayPunti.clear();
				FCFS.clear();
				
				chckbxMostraSoluzioneFCFS.setEnabled(true);
				chckbxMostraSoluzioneSJF.setEnabled(true);
				chckbxMostraSoluzioneSJFP.setEnabled(true);
				chckbxMostraSoluzioneRR.setEnabled(true);
				chkbkMostraAllSoluzione.setEnabled(true);
				btnGeneraGrafici.setEnabled(false);
				chckbxAttivaModifiche.setEnabled(true);
				chckbxAttivaModifiche.setSelected(false);

				comboBoxQRR.setEnabled(true);
				
				btnSalvaModifica.setEnabled(false);
				tabellaProcessi.setEnabled(false);
				ModifyArrivo.setEnabled(false);
				ModifyDurata.setEnabled(false);
				ModifyProcess.setEnabled(false);
				modificaTabella.setEnabled(false);

				chckbxAttivaModifiche.setSelected(false);
				chckbxMostraSoluzioneFCFS.setSelected(false);
				chckbxMostraSoluzioneSJF.setSelected(false);
				chckbxMostraSoluzioneSJFP.setSelected(false);
				chckbxMostraSoluzioneRR.setSelected(false);
				chkbkMostraAllSoluzione.setSelected(false);
				
				comboBoxQRR.setSelectedIndex(0);
				ModifyArrivo.setSelectedIndex(0);
				ModifyDurata.setSelectedIndex(0);
				
				
				for(int i=0;i<tabellaProcessi.getRowCount();i++) {
					if(Boolean.valueOf((tabellaProcessi.getValueAt(i, 3)).toString())==false) {
						System.out.println(Boolean.valueOf((tabellaProcessi.getValueAt(i, 3)).toString()));
						String num=(String) tabellaProcessi.getValueAt(i, 0);
						int numero=Integer.valueOf(num.substring(1));
						
						CreaLinee punto=new CreaLinee(numero,(int) tabellaProcessi.getValueAt(i, 1));
						CreaLinee linea=new CreaLinee(numero,(int) tabellaProcessi.getValueAt(i, 1),(int) tabellaProcessi.getValueAt(i, 2));

						arrayPunti.add(punto);
						arrayLinea.add(linea);
					}
				}
				
				CreaLinee[] lineaFCFS = new CreaLinee[arrayLinea.size()];
				for(int l=0;l<arrayLinea.size();l++) {  
						
					lineaFCFS[l]=arrayLinea.get(l);
				}

				Arrays.sort(lineaFCFS);

				int[] arrayLineeFCFS = new int[arrayLinea.size()*3];
				int i=0;

				for(int l=0;l<arrayLinea.size();l++) {  
					
					arrayLineeFCFS[i]=lineaFCFS[l].getProcesso();
					arrayLineeFCFS[i+1]=lineaFCFS[l].getArrivo();
					arrayLineeFCFS[i+2]=lineaFCFS[l].getDurata();
					i=i+3;
				}
				/*
				 * 
				//CREAZIONE FCFS
				for(int l=0;l<lineaFCFS.length;l++) {  

					if(l!=0) {
						lineaFCFS[l].setArrivo(lineaFCFS[l].getArrivo()+lineaFCFS[l-1].getDurata()+lineaFCFS[l-1].getArrivo()-lineaFCFS[l].getArrivo());
					}
					FCFS.add(lineaFCFS[l]);
				    System.out.println("P"+lineaFCFS[l].getProcesso()+" A"+lineaFCFS[l].getArrivo()+" D"+lineaFCFS[l].getDurata());
				}*/
			}
		});

	//EVENTO SU CHECKBOX MOSTRA TUTTE LE SOLUZIONI
		chkbkMostraAllSoluzione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkbkMostraAllSoluzione.isSelected()==true) {
					chckbxMostraSoluzioneFCFS.setSelected(true);
					chckbxMostraSoluzioneSJF.setSelected(true);
					chckbxMostraSoluzioneSJFP.setSelected(true);
					chckbxMostraSoluzioneRR.setSelected(true);
					jPanelFCFS.disegnaSoluzione(jPanelFCFS.getGraphics(),arrayPunti,FCFS,chckbxMostraSoluzioneFCFS.isSelected(), chckbxGriglia.isSelected());
					jPanelSJF.disegnaSoluzione(jPanelSJF.getGraphics(),arrayPunti,SJF,chckbxMostraSoluzioneSJF.isSelected(), chckbxGriglia.isSelected());
					jPanelSJFP.disegnaSoluzione(jPanelSJFP.getGraphics(),arrayPunti,SJFP,chckbxMostraSoluzioneSJFP.isSelected(), chckbxGriglia.isSelected());
					jPanelRR.disegnaSoluzione(jPanelRR.getGraphics(),arrayPunti,RR,chckbxMostraSoluzioneRR.isSelected(), chckbxGriglia.isSelected());

				}
				if(chkbkMostraAllSoluzione.isSelected()==false) {
					chckbxMostraSoluzioneFCFS.setSelected(false);
					chckbxMostraSoluzioneSJF.setSelected(false);
					chckbxMostraSoluzioneSJFP.setSelected(false);
					chckbxMostraSoluzioneRR.setSelected(false);
					jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(),chckbxGriglia.isSelected());
					jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(),chckbxGriglia.isSelected());
					jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(),chckbxGriglia.isSelected());
					jPanelRR.disegnaGriglia(jPanelRR.getGraphics(),chckbxGriglia.isSelected());

				}
			}
		});

	//EVENTO SU CHECKBOX GRIGLIA
		chckbxGriglia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if(chkbkMostraAllSoluzione.isSelected()==false) {
						jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
						jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());
						jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
						jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
					}
					if(chkbkMostraAllSoluzione.isSelected()==true) {
						jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
						jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());
						jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
						jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
						jPanelFCFS.disegnaSoluzione(jPanelFCFS.getGraphics(),arrayPunti,FCFS,chckbxMostraSoluzioneFCFS.isSelected(), chckbxGriglia.isSelected());
						jPanelSJF.disegnaSoluzione(jPanelSJF.getGraphics(),arrayPunti,SJF,chckbxMostraSoluzioneSJF.isSelected(), chckbxGriglia.isSelected());
						jPanelSJFP.disegnaSoluzione(jPanelSJFP.getGraphics(),arrayPunti,SJFP,chckbxMostraSoluzioneSJFP.isSelected(), chckbxGriglia.isSelected());
						jPanelRR.disegnaSoluzione(jPanelRR.getGraphics(),arrayPunti,RR,chckbxMostraSoluzioneRR.isSelected(), chckbxGriglia.isSelected());

					}
				}
		});
		
	//EVENTO BOTTONE SALVA MODIFICHE TABELLA "OK"
		modificaTabella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=ModifyProcess.getSelectedItem().toString();
				int numero=Integer.valueOf(num.substring(1));
				model1.setValueAt(String.valueOf(ModifyProcess.getSelectedItem()),numero-1 , 0);
				model1.setValueAt(Integer.valueOf((String) ModifyArrivo.getSelectedItem()),numero-1 , 1);
				model1.setValueAt(Integer.valueOf((String) ModifyDurata.getSelectedItem()),numero-1 , 2);
				System.out.println(Boolean.valueOf((tabellaProcessi.getValueAt(numero-1, 3)).toString()));

			}
		});

		btnSalvaModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGeneraGrafici.setEnabled(true);
				chckbxAttivaModifiche.setEnabled(false);
				chckbxAttivaModifiche.setSelected(false);
				tabellaProcessi.setEnabled(false);
				ModifyArrivo.setEnabled(false);
				ModifyProcess.setEnabled(false);
				ModifyDurata.setEnabled(false);
				btnSalvaModifica.setEnabled(false);
				modificaTabella.setEnabled(false);	
			}
		});
		
	//EVENTO SU CHECKBOX ATTIVA MODIFICHE
		chckbxAttivaModifiche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
								
				if(chckbxAttivaModifiche.isSelected()==true) {
					tabellaProcessi.setEnabled(true);
					ModifyArrivo.setEnabled(true);
					ModifyProcess.setEnabled(true);
					ModifyDurata.setEnabled(true);
					btnSalvaModifica.setEnabled(true);
					modificaTabella.setEnabled(true);
					if(chkbkMostraAllSoluzione.isSelected()==true)chkbkMostraAllSoluzione.doClick();
					if(chckbxMostraSoluzioneFCFS.isSelected()==true)chkbkMostraAllSoluzione.doClick();
					if(chckbxMostraSoluzioneSJF.isSelected()==true)chkbkMostraAllSoluzione.doClick();
					if(chckbxMostraSoluzioneSJFP.isSelected()==true)chkbkMostraAllSoluzione.doClick();
					if(chckbxMostraSoluzioneRR.isSelected()==true)chkbkMostraAllSoluzione.doClick();

					chkbkMostraAllSoluzione.setEnabled(false);
					chkbkMostraAllSoluzione.setSelected(false);
					chckbxMostraSoluzioneFCFS.setEnabled(false);
					chckbxMostraSoluzioneSJF.setEnabled(false);
					chckbxMostraSoluzioneSJFP.setEnabled(false);
					chckbxMostraSoluzioneRR.setEnabled(false);
					comboBoxQRR.setEnabled(false);
				}
				if(chckbxAttivaModifiche.isSelected()==false) {
					tabellaProcessi.setEnabled(false);
					ModifyArrivo.setEnabled(false);
					ModifyProcess.setEnabled(false);
					ModifyDurata.setEnabled(false);
					btnSalvaModifica.setEnabled(false);
					modificaTabella.setEnabled(false);
					chkbkMostraAllSoluzione.setEnabled(true);
					chkbkMostraAllSoluzione.setEnabled(true);
					chkbkMostraAllSoluzione.setSelected(true);
					chckbxMostraSoluzioneFCFS.setEnabled(true);
					chckbxMostraSoluzioneSJF.setEnabled(true);
					chckbxMostraSoluzioneSJFP.setEnabled(true);
					chckbxMostraSoluzioneRR.setEnabled(true);
					comboBoxQRR.setEnabled(true);

				}
			}
		});

	//EVENTO SULLA TABELLA
		tabellaProcessi.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		

		chckbxMostraSoluzioneFCFS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMostraSoluzioneFCFS.isSelected()==true)
					jPanelFCFS.disegnaSoluzione(jPanelFCFS.getGraphics(),arrayPunti,FCFS,chckbxMostraSoluzioneFCFS.isSelected(), chckbxGriglia.isSelected());
				else jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
			}
		});
		

		chckbxMostraSoluzioneSJF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMostraSoluzioneSJF.isSelected()==true)
					jPanelSJF.disegnaSoluzione(jPanelSJF.getGraphics(),arrayPunti,SJF,chckbxMostraSoluzioneSJF.isSelected(), chckbxGriglia.isSelected());
				else jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());

			}
		});
		

		chckbxMostraSoluzioneSJFP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMostraSoluzioneSJFP.isSelected()==true)
					jPanelSJFP.disegnaSoluzione(jPanelSJFP.getGraphics(),arrayPunti,FCFS,chckbxMostraSoluzioneSJFP.isSelected(), chckbxGriglia.isSelected());
				else jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
			}
		});
		

		chckbxMostraSoluzioneRR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMostraSoluzioneRR.isSelected()==true)
					jPanelRR.disegnaSoluzione(jPanelRR.getGraphics(),arrayPunti,FCFS,chckbxMostraSoluzioneRR.isSelected(), chckbxGriglia.isSelected());
				else jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
			}
		});
	}
}