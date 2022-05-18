// RENDERE NON SPOSTABILI LE COLONEE DELLA TABELLA
//controllo sui valori inseriti nella tabella a mano in attiva modifiche
//controllo sugli eventi che spariscono le cose
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.Desktop;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorListener;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class SchProcessi extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private String scelta="0";
	
	ArrayList<CreaLinee> arrayPunti= new ArrayList<CreaLinee>();
	ArrayList<CreaLinee> arrayLinea= new ArrayList<CreaLinee>();
	ArrayList<Integer> FCFS=new ArrayList<Integer>();
	ArrayList<Integer> SJF=new ArrayList<Integer>();
	ArrayList<Integer> SJFP=new ArrayList<Integer>();
	ArrayList<Integer> RR=new ArrayList<Integer>();
	private float averageFCFS;
	private float averageSJF;
	private float averageSJFP;
	private float averageRR;
	private int cbFCFS;
	private int cbSJF;
	private int cbSJFP;
	private int cbRR;
	private int quantum;

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
	        
	        JLabel labelScrittaIndietro = new JLabel(" Indietro");
	        labelScrittaIndietro.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        labelScrittaIndietro.setBounds(10, 120, 53, 12);
	        pannelloPrincipale.add(labelScrittaIndietro);
	        
	        JLabel labelIndietroIcon = new JLabel("Exit");
	        labelIndietroIcon.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		framechiamante.setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				}
	        	@Override
	        	public void mouseEntered(MouseEvent e) 
	        	{
	        		labelScrittaIndietro.setForeground(Color.RED);
	        	}
	        	@Override
	        	public void mouseExited(MouseEvent e) 
	        	{
	        		labelScrittaIndietro.setForeground(Color.BLACK);
	        	}
	        });
	        labelIndietroIcon.setIcon(new ImageIcon(Filosofi.class.getResource("/img/indietroIcon1.png")));
	        labelIndietroIcon.setBounds(10, 75, 53, 46);
	        pannelloPrincipale.add(labelIndietroIcon);
	        
	        JLabel labelScrittaYoutube = new JLabel("Video Youtube");
	        labelScrittaYoutube.setHorizontalAlignment(SwingConstants.CENTER);
	        labelScrittaYoutube.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        labelScrittaYoutube.setBounds(133, 120, 95, 12);
	        pannelloPrincipale.add(labelScrittaYoutube);
	        JLabel labelYoutubeIcon = new JLabel("Youtube");
	        labelYoutubeIcon.addMouseListener(new MouseAdapter() {
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
	        	@Override
	        	public void mouseEntered(MouseEvent e) 
	        	{
	        		labelScrittaYoutube.setForeground(Color.RED);
	        	}
	        	@Override
	        	public void mouseExited(MouseEvent e) 
	        	{
	        		labelScrittaYoutube.setForeground(Color.BLACK);
	        	}
	        });
	        labelYoutubeIcon.setIcon(new ImageIcon(Filosofi.class.getResource("/img/youtubeIcon2.png")));
	        labelYoutubeIcon.setBounds(150, 75, 53, 46);
	        pannelloPrincipale.add(labelYoutubeIcon);
	        
	        JLabel labelScrittaSlide = new JLabel("Slide Argomento");
	        labelScrittaSlide.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        labelScrittaSlide.setBounds(226, 120, 95, 15);
	        pannelloPrincipale.add(labelScrittaSlide);
	        JLabel labelSlideIcon = new JLabel("Slide");
	        labelSlideIcon.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
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
	        	@Override
	        	public void mouseEntered(MouseEvent e) 
	        	{
	        		labelScrittaSlide.setForeground(Color.RED);
	        	}
	        	@Override
	        	public void mouseExited(MouseEvent e) 
	        	{
	        		labelScrittaSlide.setForeground(Color.BLACK);
	        	}
	        });
	        labelSlideIcon.setIcon(new ImageIcon(Filosofi.class.getResource("/img/pdfIcon1.png")));
	        labelSlideIcon.setBounds(243, 75, 53, 46);
	        pannelloPrincipale.add(labelSlideIcon);
	
		//BOTTONE GENERA
		JButton btnGenera = new JButton("Genera Tabella Processi");
			btnGenera.setBackground(Color.WHITE);
			btnGenera.setFont(new Font("Segoe UI", Font.BOLD, 12));
			btnGenera.setBorder(new LineBorder(new Color(0, 204, 0), 4));
			//btnGenera.setBackground(new Color(255, 255, 255));
			btnGenera.setBounds(974, 86, 157, 48);
			pannelloPrincipale.add(btnGenera);
			frame.setVisible(true);
		
		//BOTTONE INFO SULL'USO DELL'APP	
		JLabel btnInfouso = new JLabel("Info/Uso");
			btnInfouso.setHorizontalAlignment(SwingConstants.CENTER);
			btnInfouso.setFont(new Font("Segoe UI", Font.BOLD, 14));
			//btnInfouso.setBorder(new LineBorder(new Color(0, 0, 0), 4));
			btnInfouso.setBackground(new Color(255, 255, 255));
			btnInfouso.setBounds(73, 82, 81, 28);
			pannelloPrincipale.add(btnInfouso);
	        
			
/**							PANNELLO TITOLO										*/
		JPanel pannelloTitolo = new JPanel();
			pannelloTitolo.setBorder(new LineBorder(new Color(51, 204, 255), 10));
			//pannelloTitolo.setBackground(Color.WHITE);
			pannelloTitolo.setBounds(0, 0, 1416, 75);
			pannelloPrincipale.add(pannelloTitolo);
			pannelloTitolo.setLayout(null);
	
			//TITOLO
		JLabel labelTitolo = new JLabel("SCHEDULING DELLA CPU");
			labelTitolo.setForeground(new Color(0, 0, 0));
			labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitolo.setFont(new Font("Segoe UI", Font.BOLD, 40));
			labelTitolo.setBounds(0, 0, 1417, 73);
			pannelloTitolo.add(labelTitolo);
		

/*---------------------------INIZIO GUI COMPLICATA---------------------------*/		

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

   
/**							PANNELLO DI CONTROLLO							*/			
		//PANNELLO DI CONTROLLO
		JPanel pannelloDiControllo = new JPanel();
			pannelloDiControllo.setBounds(1141, 85, 265, 668);
			pannelloPrincipale.add(pannelloDiControllo);
			pannelloDiControllo.setLayout(null);
			//pannelloDiControllo.setBorder(new LineBorder(new Color(255, 204, 51), 3));
		
		JPanel pannellodicontrolloTitolo = new JPanel();
			pannellodicontrolloTitolo.setBounds(10, 10, 245, 54);
			//pannellodicontrolloTitolo.setBackground(new Color(255, 255, 255));
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
		modificaTabella.setEnabled(false);
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
		
		JLabel lblGestione = new JLabel("Gestione");
			lblGestione.setHorizontalAlignment(SwingConstants.CENTER);
			lblGestione.setForeground(Color.RED);
			lblGestione.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblGestione.setBounds(10, 323, 245, 25);
			pannelloDiControllo.add(lblGestione);
		
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
			txtrHelpArea.setText("FCFS: (First Come First Served). \r\nCon questo schema la CPU si assegna al processo che la richiede per  primo. Esso è il piu' semplice degli algoritmi di scheduling della CPU ed è basato su code FIFO. Questo algoritmo genera l' Effetto Convoglio: tutti i processi attendono che un lungo processo liberi la CPU.\r\n\r\nSJF: (Shortest Job First). \r\nDetto anche scheduling per brevità. Questo algoritmo associa a ogni processo la lunghezza della successiva sequenza di operazioni della CPU. Se due processi hanno le seccessive sequenze di operazioni della CPU della stessa lunghezza, allora si applica lo scheduling FCFS. Esso ottimizza il tempo di attesa medio per un dato insieme di processi. \r\n\r\nSJFP: (Shortest Job First Preempitive). \r\nEsso è spesso detto \"shortest remaining time first\"; è uguale al SJF ma con la differenza che se arriva un nuovo processo con tempo di esecuzione inferiore a quello attualmente in esecuzione, allora quello nuovo prelaziona quello in esecuzione. \r\n\r\nRR: (Round Robin). \r\nE' detto scheduling circolare; E' simile al FCFS ma ha in più la capacità di prelazione per la commutazione dei processi. Ciascun processo riceve una piccola quantità fissata del tempo della CPU, chiamata quanto di tempo q e la coda dei processi pronti è trattata come una coda circolare. Per valori di q molto grandi RR tende al FCFS.\r\n");
			txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
			txtrHelpArea.setEditable(false);
		                
		JLabel lblHelp = new JLabel("Spiegazioni argomento");
			lblHelp.setBounds(10, 444, 245, 25);
			pannelloDiControllo.add(lblHelp);
			lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
			lblHelp.setForeground(Color.RED);
			lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
			

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
/**							IMPLEMENTAZIONE EVENTI																																	 */
						
	//EVENTO SU BOTTONE GENERA TABELLA PROCESSI
		btnGenera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				arrayPunti.clear();
				arrayLinea.clear();
				FCFS.clear();
				SJF.clear();
				SJFP.clear();
				RR.clear();
				averageFCFS=0;
				averageSJF=0;
				averageSJFP=0;
				averageRR=0;
				cbFCFS=0;
				cbSJF=0;
				cbSJFP=0;
				cbRR=0;
				quantum=0;
				
				if(chckbxMostraSoluzioneFCFS.isSelected()==true)chckbxMostraSoluzioneFCFS.doClick();
				if(chckbxMostraSoluzioneSJF.isSelected()==true)chckbxMostraSoluzioneSJF.doClick();
				if(chckbxMostraSoluzioneSJFP.isSelected()==true)chckbxMostraSoluzioneSJFP.doClick();
				if(chckbxMostraSoluzioneRR.isSelected()==true)chckbxMostraSoluzioneRR.doClick();
				if(chkbkMostraAllSoluzione.isSelected()==true)chkbkMostraAllSoluzione.doClick();
				if(chckbxAttivaModifiche.isSelected()==true)chckbxAttivaModifiche.doClick();

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
				
				ModifyProcess.removeAllItems();
				btnGeneraGrafici.setEnabled(true);
				chckbxAttivaModifiche.setEnabled(true);
				
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
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btnGenera.setBackground(new Color(0, 204, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGenera.setBackground(Color.WHITE);
			}
		});

	//EVENTO SU BOX SCLETA NUMERO PROCESSI
		comboBoxSceltaNProcessi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayPunti.clear();
				arrayLinea.clear();
				FCFS.clear();
				SJF.clear();
				SJFP.clear();
				RR.clear();
				averageFCFS=0;
				averageSJF=0;
				averageSJFP=0;
				averageRR=0;
				cbFCFS=0;
				cbSJF=0;
				cbSJFP=0;
				cbRR=0;
				quantum=0;
				
				if(chckbxMostraSoluzioneFCFS.isSelected()==true)chckbxMostraSoluzioneFCFS.doClick();
				if(chckbxMostraSoluzioneSJF.isSelected()==true)chckbxMostraSoluzioneSJF.doClick();
				if(chckbxMostraSoluzioneSJFP.isSelected()==true)chckbxMostraSoluzioneSJFP.doClick();
				if(chckbxMostraSoluzioneRR.isSelected()==true)chckbxMostraSoluzioneRR.doClick();
				if(chkbkMostraAllSoluzione.isSelected()==true)chkbkMostraAllSoluzione.doClick();
				if(chckbxAttivaModifiche.isSelected()==true)chckbxAttivaModifiche.doClick();

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
				
				ModifyProcess.removeAllItems();
				btnGeneraGrafici.setEnabled(true);
				chckbxAttivaModifiche.setEnabled(true);
				
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

	//EVENTO SU BOTTONE GENERA GRAFICI
		btnGeneraGrafici.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Integer.valueOf(String.valueOf(comboBoxSceltaNProcessi.getSelectedItem()))==0) {
					btnGeneraGrafici.setEnabled(false);
					chckbxAttivaModifiche.setEnabled(false);
				}
				else {
					if (btnGeneraGrafici.isEnabled()) {
		
						jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
						jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());
						jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
						jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
						
						arrayPunti.clear();
						arrayLinea.clear();
						FCFS.clear();
						SJF.clear();
						SJFP.clear();
						RR.clear();
						averageFCFS=0;
						averageSJF=0;
						averageSJFP=0;
						averageRR=0;
						cbFCFS=0;
						cbSJF=0;
						cbSJFP=0;
						cbRR=0;
						quantum=0;
						
						chckbxMostraSoluzioneFCFS.setEnabled(true);
						chckbxMostraSoluzioneSJF.setEnabled(true);
						chckbxMostraSoluzioneSJFP.setEnabled(true);
						chckbxMostraSoluzioneRR.setEnabled(true);
						chkbkMostraAllSoluzione.setEnabled(true);
						btnGeneraGrafici.setEnabled(false);
						chckbxAttivaModifiche.setEnabled(true);
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
								String num=(String) tabellaProcessi.getValueAt(i, 0);
								int numero=Integer.valueOf(num.substring(1));
								
								CreaLinee punto=new CreaLinee(numero,(int) tabellaProcessi.getValueAt(i, 1));
								CreaLinee linea=new CreaLinee(numero,(int) tabellaProcessi.getValueAt(i, 1),(int) tabellaProcessi.getValueAt(i, 2));
		
								arrayPunti.add(punto);
								arrayLinea.add(linea);
							}
						}
						
						CreaLinee[] linea = new CreaLinee[arrayLinea.size()];
			/*			CreaLinee[] lineaSJF = new CreaLinee[arrayLinea.size()];
				CreaLinee[] lineaSJFP = new CreaLinee[arrayLinea.size()];
						CreaLinee[] lineaRR = new CreaLinee[arrayLinea.size()];
		*/
						for(int l=0;l<arrayLinea.size();l++) {  
								
							linea[l]=arrayLinea.get(l);
		/*					lineaSJF[l]=arrayLinea.get(l);
							lineaSJFP[l]=arrayLinea.get(l);
							lineaRR[l]=arrayLinea.get(l);
		*/
						}
		
						Arrays.sort(linea);
				//		Arrays.sort(lineaRR);
						
						FCFS=FCFSClass(linea);
						SJF=SJFClass(linea);
						//SJFP=SJFPClass(lineaSJFP);
						String qua= (String) comboBoxQRR.getSelectedItem();
						quantum=Integer.valueOf(qua);
						//RR=RRClass(linea);
		
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				if (btnGeneraGrafici.isEnabled()) {
					
					btnGeneraGrafici.setBackground(new Color(51, 204, 255));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if (btnGeneraGrafici.isEnabled()) {
					
					btnGeneraGrafici.setBackground(new Color(255, 255, 255));
				}
				else {
					
					btnGeneraGrafici.setBackground(new Color(255, 255, 255));
				}
			}
		});

		
	//EVENTO SU CHECKBOX MOSTRA TUTTE LE SOLUZIONI
		chkbkMostraAllSoluzione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkbkMostraAllSoluzione.isSelected()==true) {
					if(chckbxMostraSoluzioneFCFS.isSelected()==false)chckbxMostraSoluzioneFCFS.doClick();
					if(chckbxMostraSoluzioneSJF.isSelected()==false)chckbxMostraSoluzioneSJF.doClick();
					if(chckbxMostraSoluzioneSJFP.isSelected()==false)chckbxMostraSoluzioneSJFP.doClick();
					if(chckbxMostraSoluzioneRR.isSelected()==false)chckbxMostraSoluzioneRR.doClick();
				
				}
				if(chkbkMostraAllSoluzione.isSelected()==false) {	
					if(chckbxMostraSoluzioneFCFS.isSelected()==true)chckbxMostraSoluzioneFCFS.doClick();
					if(chckbxMostraSoluzioneSJF.isSelected()==true)chckbxMostraSoluzioneSJF.doClick();
					if(chckbxMostraSoluzioneSJFP.isSelected()==true)chckbxMostraSoluzioneSJFP.doClick();
					if(chckbxMostraSoluzioneRR.isSelected()==true)chckbxMostraSoluzioneRR.doClick();
				}
			}
		});

	//EVENTO SU CHECKBOX GRIGLIA
		chckbxGriglia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
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
				*/
				if(chckbxMostraSoluzioneFCFS.isSelected()==false) {
					jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
					}
				if(chckbxMostraSoluzioneFCFS.isSelected()==true) {
					jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
					jPanelFCFS.disegnaSoluzioneFCFS(jPanelFCFS.getGraphics(),arrayPunti,FCFS,chckbxMostraSoluzioneFCFS.isSelected(), chckbxGriglia.isSelected());
				}
				
				if(chckbxMostraSoluzioneSJF.isSelected()==false) {
					jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());
				}
				if(chckbxMostraSoluzioneSJF.isSelected()==true) {
					jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());
					jPanelSJF.disegnaSoluzioneSJF(jPanelSJF.getGraphics(),arrayPunti,SJF,chckbxMostraSoluzioneSJF.isSelected(), chckbxGriglia.isSelected());
				}
				
				if(chckbxMostraSoluzioneSJFP.isSelected()==false) {
					jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
				}
				if(chckbxMostraSoluzioneSJFP.isSelected()==true) {
					jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
					jPanelSJFP.disegnaSoluzioneSJF(jPanelSJFP.getGraphics(),arrayPunti,SJFP,chckbxMostraSoluzioneSJFP.isSelected(), chckbxGriglia.isSelected());
				}
				
				if(chckbxMostraSoluzioneRR.isSelected()==false) {
					jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
				}
				if(chckbxMostraSoluzioneRR.isSelected()==true) {
					jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
					jPanelRR.disegnaSoluzioneFCFS(jPanelRR.getGraphics(),arrayPunti,RR,chckbxMostraSoluzioneRR.isSelected(), chckbxGriglia.isSelected());
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

			}
		});

	//EVENTO BOTTONE SALVA MODIFICHE 
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
		chckbxAttivaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(String.valueOf(comboBoxSceltaNProcessi.getSelectedItem()))==0) {
					JOptionPane.showMessageDialog(contentPane, "Errore: numero di processi modificabili '0'!");
					chckbxAttivaModifiche.setSelected(false);
				}
				else {			
					if(chckbxAttivaModifiche.isSelected()==true) {
							btnGeneraGrafici.setEnabled(false);
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
						btnSalvaModifica.doClick();
					}
				}
			}
		});

	//EVENTO SULLA TABELLA
		tabellaProcessi.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		
		
	//EVENTI SU MOSTRA SOLUZIONE FCFS,SJF,SJFP,RR
		
		chckbxMostraSoluzioneFCFS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMostraSoluzioneFCFS.isSelected()==true) {
					jPanelFCFS.disegnaSoluzioneFCFS(jPanelFCFS.getGraphics(),arrayPunti,FCFS,chckbxMostraSoluzioneFCFS.isSelected(), chckbxGriglia.isSelected());
					DecimalFormat frmt = new DecimalFormat();
					frmt.setMaximumFractionDigits(3);
					DatoTAMFCFS.setText(String.valueOf(frmt.format(averageFCFS)));
					DatoCDCFCFS.setText(String.valueOf(cbFCFS));
				}
				else {
					jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
					DatoTAMFCFS.setText(" ");
					DatoCDCFCFS.setText(" ");
				}
			}
		});
		
		chckbxMostraSoluzioneSJF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMostraSoluzioneSJF.isSelected()==true) {
					jPanelSJF.disegnaSoluzioneSJF(jPanelSJF.getGraphics(),arrayPunti,SJF,chckbxMostraSoluzioneSJF.isSelected(), chckbxGriglia.isSelected());
					DecimalFormat frmt = new DecimalFormat();
					frmt.setMaximumFractionDigits(3);
					DatoTAMSJF.setText(String.valueOf(frmt.format(averageSJF)));
					DatoCDCSJF.setText(String.valueOf(cbSJF));
				}
				else {
					jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());
					DatoTAMSJF.setText(" ");
					DatoCDCSJF.setText(" ");
				}
			}
		});
		
		chckbxMostraSoluzioneSJFP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMostraSoluzioneSJFP.isSelected()==true) {
					jPanelSJFP.disegnaSoluzioneSJF(jPanelSJFP.getGraphics(),arrayPunti,SJFP,chckbxMostraSoluzioneSJFP.isSelected(), chckbxGriglia.isSelected());
					DecimalFormat frmt = new DecimalFormat();
					frmt.setMaximumFractionDigits(3);
					DatoTAMSJFP.setText(String.valueOf(frmt.format(averageSJFP)));
					DatoCDCSJFP.setText(String.valueOf(cbSJFP));
				}
				else {
					jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
					DatoTAMSJFP.setText(" ");
					DatoCDCSJFP.setText(" ");
				}
			}
		});
		
		chckbxMostraSoluzioneRR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMostraSoluzioneRR.isSelected()==true) {
					jPanelRR.disegnaSoluzioneFCFS(jPanelRR.getGraphics(),arrayPunti,RR,chckbxMostraSoluzioneRR.isSelected(), chckbxGriglia.isSelected());
					DecimalFormat frmt = new DecimalFormat();
					frmt.setMaximumFractionDigits(3);
					DatoTAMRR.setText(String.valueOf(frmt.format(averageRR)));
					DatoCDCRR.setText(String.valueOf(cbRR));
				}
				else {
					jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
					DatoTAMRR.setText(" ");
					DatoCDCRR.setText(" ");
				}
			}
		});
	
}


/**										IMPLEMENTAZIONE METODI RICHIAMATI E USATI SOPRA 											*/
	
//METODO PER CALCOLARE FCFS
public ArrayList<Integer> FCFSClass(CreaLinee[] lineaFCFS){
	
	ArrayList<Integer> punti=new ArrayList<Integer>();
	int n = lineaFCFS.length;
	int pid[] = new int[n];   // process ids
	int ar[] = new int[n];     // arrival times
	int bt[] = new int[n];     // burst or execution times
	int ct[] = new int[n];     // completion times
	int ta[] = new int[n];     // turn around times
	int wt[] = new int[n];     // waiting times
	int temp;
	float avgwt=0,avgta=0;

	for(int i = 0; i < n; i++){
		ar[i]=lineaFCFS[i].getArrivo();
		bt[i] = lineaFCFS[i].getDurata();
		pid[i] = lineaFCFS[i].getProcesso();
	}

	for(int  i = 0 ; i < n; i++){
		if( i == 0){
			ct[i] = ar[i] + bt[i];
		}
		else{
			if( ar[i] > ct[i-1]){
				ct[i] = ar[i] + bt[i];
			}
			else ct[i] = ct[i-1] + bt[i];
		}
		ta[i] = ct[i] - ar[i] ;          // turnaround time= completion time- arrival time
		wt[i] = ta[i] - bt[i] ;          // waiting time= turnaround time- burst time
		avgwt += wt[i] ;               // total waiting time
		avgta += ta[i] ;               // total turnaround time
	}	

	for(int  i = 0 ; i< n;  i++){
		punti.add(ar[i]+wt[i]);
		punti.add(pid[i]);
		punti.add(ct[i]);
		punti.add(pid[i]);
	}
	
	float aver=(avgwt/n);
	averageFCFS=aver;

	for(int  i = 0 ; i< n;  i++){
		if(bt[i]!=0) cbFCFS++;
	}
	
	cbFCFS=cbFCFS-1;
	return punti;
}

//METODO PER CALCOLARE SJF
public ArrayList<Integer> SJFClass(CreaLinee[] lineaSJF){
	
	ArrayList<Integer> punti=new ArrayList<Integer>();
	int n = lineaSJF.length;
	int pid[] = new int[n];
	int at[] = new int[n]; // at means arrival time
	int bt[] = new int[n]; // bt means burst time
	int ct[] = new int[n]; // ct means complete time
	int ta[] = new int[n]; // ta means turn around time
	int wt[] = new int[n];  //wt means waiting time
	int f[] = new int[n];  // f means it is flag it checks process is completed or not
	int st=0, tot=0;
	float avgwt=0, avgta=0;
 
	for(int i=0;i<n;i++){
		at[i] = lineaSJF[i].getArrivo();
		bt[i] = lineaSJF[i].getDurata();
		pid[i] = lineaSJF[i].getProcesso();
		f[i] = 0;
	}

	boolean a = true;
	while(true){
		int c=n, min=999;
		if (tot == n) // total no of process = completed process loop will be terminated
			break;
		for (int i=0; i<n; i++){
			if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min)){
				min=bt[i];
				c=i;
			}
		}
		if (c==n) st++;
		else{
			ct[c]=st+bt[c];
			st+=bt[c];
			ta[c]=ct[c]-at[c];
			wt[c]=ta[c]-bt[c];
			f[c]=1;
			tot++;
		}
	}
	for(int i=0;i<n;i++){
		avgwt+= wt[i];
		avgta+= ta[i];
	}

	for(int  i = 0 ; i< n;  i++){
		punti.add(at[i]+wt[i]);
		punti.add(pid[i]);
		punti.add(ct[i]);
		punti.add(pid[i]);
	}

	float aver=(avgwt/n);
	averageSJF=aver;

	for(int  i = 0 ; i< n;  i++){
		if(bt[i]!=0) cbSJF++;
	}

	cbSJF=cbSJF-1;
	return punti;
}



}
