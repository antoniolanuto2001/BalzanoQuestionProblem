
/*---------------------------------------*/

// RENDERE NON SPOSTABILI LE COLONEE DELLA TABELLA

//controllo sui valori inseriti nella tabella a mano in attiva modifiche
//controllo sugli eventi che spariscono le cose
//pannelli che si muovo a coprire soluzione

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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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
	private static int i=20;


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
	        
	        JLabel labelIndietroIcon = new JLabel();
	        labelIndietroIcon.setHorizontalAlignment(SwingConstants.CENTER);
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
	        labelIndietroIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/back-button.png")));
	        labelIndietroIcon.setBounds(10, 75, 53, 46);
	        pannelloPrincipale.add(labelIndietroIcon);
	        
	        JLabel labelScrittaYoutube = new JLabel("Video Lezione");
	        labelScrittaYoutube.setHorizontalAlignment(SwingConstants.CENTER);
	        labelScrittaYoutube.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        labelScrittaYoutube.setBounds(61, 120, 95, 12);
	        pannelloPrincipale.add(labelScrittaYoutube);
	        JLabel labelYoutubeIcon = new JLabel("Youtube");
	        labelYoutubeIcon.setHorizontalAlignment(SwingConstants.LEFT);
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
	        labelYoutubeIcon.setBounds(83, 75, 47, 46);
	        pannelloPrincipale.add(labelYoutubeIcon);
	        
	        JLabel labelScrittaSlide = new JLabel("Slide Argomento");
	        labelScrittaSlide.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        labelScrittaSlide.setBounds(158, 119, 95, 15);
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
	        labelSlideIcon.setBounds(180, 75, 53, 46);
	        pannelloPrincipale.add(labelSlideIcon);
	
		//BOTTONE GENERA
		JButton btnGenera = new JButton("Genera Tabella Processi");
			btnGenera.setBackground(Color.WHITE);
			btnGenera.setFont(new Font("Segoe UI", Font.BOLD, 12));
			btnGenera.setBorder(new LineBorder(new Color(0, 200, 83), 4));
			//btnGenera.setBackground(new Color(255, 255, 255));
			btnGenera.setBounds(974, 86, 157, 48);
			pannelloPrincipale.add(btnGenera);
			frame.setVisible(true);
	        
			
/**							PANNELLO TITOLO										*/
		JPanel pannelloTitolo = new JPanel();
			pannelloTitolo.setBorder(new LineBorder(new Color(100, 181, 246), 7));
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
			
			JLabel labelFedericoII = new JLabel("");
			labelFedericoII.setIcon(new ImageIcon(SchProcessi.class.getResource("/img/logoUninaIcon2.png")));
			labelFedericoII.setBounds(10, 11, 199, 53);
			pannelloTitolo.add(labelFedericoII);
		

/*---------------------------INIZIO GUI COMPLICATA---------------------------*/		

/**							PANNELLO GRAFICI								*/
		JPanel pannelloGrafici = new JPanel();
	        pannelloGrafici.setBounds(0, 143, 1131, 620);
	        pannelloPrincipale.add(pannelloGrafici);
	        pannelloGrafici.setLayout(null);
        
	        //PANNELLO FIRST-COME,FIRST-SERVED
/*
		JPanel pannelloFCFSS = new JPanel();
			pannelloFCFSS.setBounds(20, 27, 1100, 118);
			pannelloGrafici.add(pannelloFCFSS);
			pannelloFCFSS.setLayout(null);
*/
        JPanel pannelloFCFS = new JPanel();
			pannelloFCFS.setBounds(10, 0, 1121, 150);
			pannelloGrafici.add(pannelloFCFS);
			pannelloFCFS.setLayout(null);
			pannelloFCFS.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
		
			JLabel labelFirstcomeFirstserved = new JLabel("First-Come  First-Served");
				labelFirstcomeFirstserved.setHorizontalAlignment(SwingConstants.CENTER);
				labelFirstcomeFirstserved.setForeground(Color.RED);
				labelFirstcomeFirstserved.setFont(new Font("Tahoma", Font.PLAIN, 20));
				labelFirstcomeFirstserved.setBounds(156, 0, 236, 25);
				pannelloFCFS.add(labelFirstcomeFirstserved);
		
			JCheckBox chckbxMostraSoluzioneFCFS = new JCheckBox("Mostra Soluzione");
				chckbxMostraSoluzioneFCFS.setHorizontalAlignment(SwingConstants.CENTER);
				chckbxMostraSoluzioneFCFS.setEnabled(false);
				chckbxMostraSoluzioneFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				chckbxMostraSoluzioneFCFS.setBounds(513, 3, 150, 25);
				pannelloFCFS.add(chckbxMostraSoluzioneFCFS);
			
			JLabel labelTAMFCFS = new JLabel("Tempo di attesa medio:");
				labelTAMFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelTAMFCFS.setBounds(670, 3, 150, 25);
				pannelloFCFS.add(labelTAMFCFS);
			
			JLabel labelDatoTAMFCFS = new JLabel("");
				labelDatoTAMFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelDatoTAMFCFS.setBounds(821, 3, 45, 25);
				pannelloFCFS.add(labelDatoTAMFCFS);
				
			JLabel labelCDCFCFS = new JLabel("Cambi di contesto: ");
				labelCDCFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelCDCFCFS.setBounds(887, 3, 130, 25);
				pannelloFCFS.add(labelCDCFCFS);
			
			JLabel labelDatoCDCFCFS = new JLabel("");
				labelDatoCDCFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelDatoCDCFCFS.setBounds(1014, 3, 45, 25);
				pannelloFCFS.add(labelDatoCDCFCFS);
			
			//PANNELLO SHORTEST JOB FIRST
		JPanel pannelloSJF = new JPanel();
			pannelloSJF.setBounds(10, 153, 1121, 150);
			pannelloGrafici.add(pannelloSJF);
			pannelloSJF.setLayout(null);
			pannelloSJF.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));

			JLabel labelShortestJobFirts = new JLabel("Shortest Job First");
				labelShortestJobFirts.setHorizontalAlignment(SwingConstants.CENTER);
				labelShortestJobFirts.setForeground(Color.RED);
				labelShortestJobFirts.setFont(new Font("Tahoma", Font.PLAIN, 20));
				labelShortestJobFirts.setBounds(188, 0, 181, 25);
				pannelloSJF.add(labelShortestJobFirts);
			
			JCheckBox chckbxMostraSoluzioneSJF = new JCheckBox("Mostra Soluzione");
			chckbxMostraSoluzioneSJF.setHorizontalAlignment(SwingConstants.CENTER);
				chckbxMostraSoluzioneSJF.setEnabled(false);
				chckbxMostraSoluzioneSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				chckbxMostraSoluzioneSJF.setBounds(513, 3, 150, 25);
				pannelloSJF.add(chckbxMostraSoluzioneSJF);
			
			JLabel labelTAMSJF = new JLabel("Tempo di attesa medio:");
				labelTAMSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelTAMSJF.setBounds(670, 3, 150, 25);
				pannelloSJF.add(labelTAMSJF);
			
			JLabel labelDatoTAMSJF = new JLabel("");
				labelDatoTAMSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelDatoTAMSJF.setBounds(821, 3, 45, 25);
				pannelloSJF.add(labelDatoTAMSJF);
				
			JLabel labelCDCSJF = new JLabel("Cambi di contesto: ");
				labelCDCSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelCDCSJF.setBounds(887, 3, 130, 25);
				pannelloSJF.add(labelCDCSJF);
			
			JLabel labelDatoCDCSJF = new JLabel("");
				labelDatoCDCSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelDatoCDCSJF.setBounds(1014, 3, 45, 25);
				pannelloSJF.add(labelDatoCDCSJF);
			
			//PANNELLO SHORTEST JOB FIRST PREEMPTIVE
		JPanel pannelloSJFP = new JPanel();
			pannelloSJFP.setLayout(null);
			pannelloSJFP.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
			pannelloSJFP.setBounds(10, 306, 1121, 150);
			pannelloGrafici.add(pannelloSJFP);
		
			JLabel labelShortestJobFirstPreemptive = new JLabel("Shortest Job First Preemptive");
				labelShortestJobFirstPreemptive.setHorizontalAlignment(SwingConstants.CENTER);
				labelShortestJobFirstPreemptive.setForeground(Color.RED);
				labelShortestJobFirstPreemptive.setFont(new Font("Tahoma", Font.PLAIN, 20));
				labelShortestJobFirstPreemptive.setBounds(130, 0, 285, 25);
				pannelloSJFP.add(labelShortestJobFirstPreemptive);
			
			JCheckBox chckbxMostraSoluzioneSJFP = new JCheckBox("Mostra Soluzione");
			chckbxMostraSoluzioneSJFP.setHorizontalAlignment(SwingConstants.CENTER);
				chckbxMostraSoluzioneSJFP.setEnabled(false);
				chckbxMostraSoluzioneSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				chckbxMostraSoluzioneSJFP.setBounds(513, 3, 150, 25);
				pannelloSJFP.add(chckbxMostraSoluzioneSJFP);
			
			JLabel labelTAMSJFP = new JLabel("Tempo di attesa medio:");
				labelTAMSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelTAMSJFP.setBounds(670, 3, 150, 25);
				pannelloSJFP.add(labelTAMSJFP);
	
			JLabel labelDatoTAMSJFP = new JLabel("");
				labelDatoTAMSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelDatoTAMSJFP.setBounds(821, 3, 45, 25);
				pannelloSJFP.add(labelDatoTAMSJFP);
				
			JLabel labelCDCSJFP = new JLabel("Cambi di contesto: ");
				labelCDCSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelCDCSJFP.setBounds(887, 3, 130, 25);
				pannelloSJFP.add(labelCDCSJFP);
			
			JLabel labelDatoCDCSJFP = new JLabel("");
				labelDatoCDCSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelDatoCDCSJFP.setBounds(1014, 3, 45, 25);
				pannelloSJFP.add(labelDatoCDCSJFP);
		
			//PANNELLO ROUND ROBIN
		JPanel pannelloRR = new JPanel();
			pannelloRR.setLayout(null);
			pannelloRR.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
			pannelloRR.setBounds(10, 459, 1121, 150);
			pannelloGrafici.add(pannelloRR);
		
			JLabel labelRoundRobin = new JLabel("Round Robin");
				labelRoundRobin.setHorizontalAlignment(SwingConstants.CENTER);
				labelRoundRobin.setForeground(Color.RED);
				labelRoundRobin.setFont(new Font("Tahoma", Font.PLAIN, 20));
				labelRoundRobin.setBounds(187, 0, 165, 25);
				pannelloRR.add(labelRoundRobin);
			
			JCheckBox chckbxMostraSoluzioneRR = new JCheckBox("Mostra Soluzione");
			chckbxMostraSoluzioneRR.setHorizontalAlignment(SwingConstants.CENTER);
				chckbxMostraSoluzioneRR.setEnabled(false);
				chckbxMostraSoluzioneRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				chckbxMostraSoluzioneRR.setBounds(513, 3, 150, 25);
				pannelloRR.add(chckbxMostraSoluzioneRR);
			
			JLabel labelTAMRR = new JLabel("Tempo di attesa medio:");
				labelTAMRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelTAMRR.setBounds(670, 3, 150, 25);
				pannelloRR.add(labelTAMRR);
	
			JLabel labelDatoTAMRR = new JLabel("");
				labelDatoTAMRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelDatoTAMRR.setBounds(821, 3, 45, 25);
				pannelloRR.add(labelDatoTAMRR);
				
			JLabel labelCDCRR = new JLabel("Cambi di contesto: ");
				labelCDCRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelCDCRR.setBounds(887, 3, 130, 25);
				pannelloRR.add(labelCDCRR);
			
			JLabel labelDatoCDCRR = new JLabel("");
				labelDatoCDCRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelDatoCDCRR.setBounds(1014, 3, 45, 25);
				pannelloRR.add(labelDatoCDCRR);
			
			JLabel labelQRR = new JLabel("Q =");
				labelQRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				labelQRR.setBounds(407, 0, 32, 25);
				pannelloRR.add(labelQRR);
			
			JComboBox comboBoxQRR = new JComboBox();
				comboBoxQRR.setEnabled(false);
				comboBoxQRR.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
				comboBoxQRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				comboBoxQRR.setBackground(Color.WHITE);
				comboBoxQRR.setBounds(432, 2, 50, 21);
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
			pannellodicontrolloTitolo.setBorder(new LineBorder(new Color(100, 181, 246), 4));
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
			pannelloEDITOR.setBounds(10, 95, 245, 347);
			pannelloDiControllo.add(pannelloEDITOR);
			pannelloEDITOR.setLayout(null);
			//pannelloEDITOR.setBorder(new LineBorder(new Color(255, 204, 0), 3));
		
		JLabel labellNumeroDiProcessi = new JLabel("Numero di processi");
		labellNumeroDiProcessi.setEnabled(false);
			labellNumeroDiProcessi.setHorizontalAlignment(SwingConstants.CENTER);
			labellNumeroDiProcessi.setForeground(new Color(0, 0, 0));
			labellNumeroDiProcessi.setFont(new Font("Arial", Font.BOLD, 15));
			labellNumeroDiProcessi.setBounds(10, 2, 165, 23);
			pannelloEDITOR.add(labellNumeroDiProcessi);
		
		JComboBox comboBoxSceltaNProcessi = new JComboBox();
		comboBoxSceltaNProcessi.setEnabled(false);
			comboBoxSceltaNProcessi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			comboBoxSceltaNProcessi.setBackground(new Color(255, 255, 255));
			comboBoxSceltaNProcessi.setModel(new DefaultComboBoxModel(new String[] {"6", "5", "4", "3", "2", "1"}));
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

		JCheckBox chckbxGriglia = new JCheckBox("Griglia");
			chckbxGriglia.setSelected(true);
			chckbxGriglia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chckbxGriglia.setBounds(10, 255, 65, 21);
			pannelloEDITOR.add(chckbxGriglia);

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
			btnGeneraGrafici.setBorder(new LineBorder(new Color(100, 181, 246), 4));
			btnGeneraGrafici.setFont(new Font("Arial", Font.BOLD, 15));
			btnGeneraGrafici.setBounds(10, 219, 225, 28);
			pannelloEDITOR.add(btnGeneraGrafici);
			
		JButton btnSalvaModifica = new JButton("Salva Modifica");
			btnSalvaModifica.setEnabled(false);
			btnSalvaModifica.setBounds(116, 190, 119, 21);
			pannelloEDITOR.add(btnSalvaModifica);
		
		JCheckBox chckbxAttivaModifiche = new JCheckBox("Modifica");
			chckbxAttivaModifiche.setEnabled(false);
			chckbxAttivaModifiche.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chckbxAttivaModifiche.setBounds(20, 190, 94, 21);
			pannelloEDITOR.add(chckbxAttivaModifiche);
		
		JButton btnMostraSoluzioni = new JButton("");
			btnMostraSoluzioni.setEnabled(false);
			btnMostraSoluzioni.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnMostraSoluzioni.setBounds(80, 287, 79, 35);
			btnMostraSoluzioni.setIcon(new ImageIcon(Hashing.class.getResource("/img/playIcon2.png")));
			pannelloEDITOR.add(btnMostraSoluzioni);
			
		JLabel labelFastForwardPiu = new JLabel("");
			labelFastForwardPiu.setHorizontalAlignment(SwingConstants.CENTER);
			labelFastForwardPiu.setEnabled(false);
			labelFastForwardPiu.setIcon(new ImageIcon(Hashing.class.getResource("/img/fastFowardIcon1.png")));
			labelFastForwardPiu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			labelFastForwardPiu.setBounds(163, 287, 70, 35);
			pannelloEDITOR.add(labelFastForwardPiu);
			
		JLabel labelFastForwardMeno = new JLabel("");
			labelFastForwardMeno.setHorizontalAlignment(SwingConstants.CENTER);
			labelFastForwardMeno.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			labelFastForwardMeno.setEnabled(false);
			labelFastForwardMeno.setBounds(5, 287, 70, 35);
			labelFastForwardMeno.setIcon(new ImageIcon(SchProcessi.class.getResource("/img/fastFowardIconRovescio.png")));
			pannelloEDITOR.add(labelFastForwardMeno);
			
		//PANNELLO HELP
		JPanel pannelloHelp = new JPanel();
			pannelloHelp.setBorder(new LineBorder(new Color(255, 204, 0), 3));
			pannelloHelp.setBounds(10, 469, 245, 189);
			pannelloDiControllo.add(pannelloHelp);
			pannelloHelp.setLayout(null);
		
		JScrollPane scrollPaneHelp = new JScrollPane();
			scrollPaneHelp.setBounds(0, 0, 245, 189);
			pannelloHelp.add(scrollPaneHelp);
        	
		JTextArea txtrHelpArea = new JTextArea();
			scrollPaneHelp.setViewportView(txtrHelpArea);
			txtrHelpArea.setWrapStyleWord(true);
			txtrHelpArea.setLineWrap(true);
			txtrHelpArea.setText("FCFS: (First Come First Served). \r\nCon questo schema la CPU si assegna al processo che la richiede per  primo. Esso è il piu' semplice degli algoritmi di scheduling della CPU ed è basato su code FIFO. Questo algoritmo genera l' Effetto Convoglio: tutti i processi attendono che un lungo processo liberi la CPU.\r\n\r\nSJF: (Shortest Job First). \r\nDetto anche scheduling per brevità. Questo algoritmo associa a ogni processo la lunghezza della successiva sequenza di operazioni della CPU. Se due processi hanno le seccessive sequenze di operazioni della CPU della stessa lunghezza, allora si applica lo scheduling FCFS. Esso ottimizza il tempo di attesa medio per un dato insieme di processi. \r\n\r\nSJFP: (Shortest Job First Preempitive). \r\nEsso è spesso detto \"shortest remaining time first\"; è uguale al SJF ma con la differenza che se arriva un nuovo processo con tempo di esecuzione inferiore a quello attualmente in esecuzione, allora quello nuovo prelaziona quello in esecuzione. \r\n\r\nRR: (Round Robin). \r\nE' detto scheduling circolare; E' simile al FCFS ma ha in più la capacità di prelazione per la commutazione dei processi. Ciascun processo riceve una piccola quantità fissata del tempo della CPU, chiamata quanto di tempo q e la coda dei processi pronti è trattata come una coda circolare. Per valori di q molto grandi RR tende al FCFS.\r\n");
			txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
			txtrHelpArea.setCaretPosition(0);
			txtrHelpArea.setEditable(false);
		                
		JLabel labelHelp = new JLabel("Spiegazioni argomento");
			labelHelp.setBounds(10, 444, 245, 25);
			pannelloDiControllo.add(labelHelp);
			labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
			labelHelp.setForeground(Color.RED);
			labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
		JLabel labelHelpIcon = new JLabel("Help");
			labelHelpIcon.setBounds(273, 75, 34, 46);
			pannelloPrincipale.add(labelHelpIcon);
	        labelHelpIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/question.png")));
	        
	    JLabel labelInfouso = new JLabel("Info/Uso");
	        labelInfouso.setHorizontalAlignment(SwingConstants.CENTER);
	        labelInfouso.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        labelInfouso.setBounds(263, 120, 59, 12);
	        pannelloPrincipale.add(labelInfouso);

			

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
/**							IMPLEMENTAZIONE EVENTI																																	 */
						
	//EVENTO SU BOTTONE GENERA TABELLA PROCESSI
		btnGenera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				labellNumeroDiProcessi.setEnabled(true);
				comboBoxSceltaNProcessi.setEnabled(true);
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
				if(btnMostraSoluzioni.isSelected()==true)btnMostraSoluzioni.doClick();
				if(chckbxAttivaModifiche.isSelected()==true)chckbxAttivaModifiche.doClick();

				chckbxMostraSoluzioneFCFS.setEnabled(false);
				chckbxMostraSoluzioneSJF.setEnabled(false);
				chckbxMostraSoluzioneSJFP.setEnabled(false);
				chckbxMostraSoluzioneRR.setEnabled(false);
				btnMostraSoluzioni.setEnabled(false);
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
				btnGenera.setBackground(new Color (0, 200, 83));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGenera.setBackground(Color.WHITE);
			}
		});

	//EVENTO SU BOX SCELTA NUMERO PROCESSI
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
				if(btnMostraSoluzioni.isSelected()==true)btnMostraSoluzioni.doClick();
				if(chckbxAttivaModifiche.isSelected()==true)chckbxAttivaModifiche.doClick();

				chckbxMostraSoluzioneFCFS.setEnabled(false);
				chckbxMostraSoluzioneSJF.setEnabled(false);
				chckbxMostraSoluzioneSJFP.setEnabled(false);
				chckbxMostraSoluzioneRR.setEnabled(false);
				btnMostraSoluzioni.setEnabled(false);
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
						btnMostraSoluzioni.setEnabled(true);
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
						btnMostraSoluzioni.setSelected(false);
						labelFastForwardPiu.setEnabled(true);

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
	
						for(int l=0;l<arrayLinea.size();l++) {  
								
							linea[l]=arrayLinea.get(l);

						}
		
						Arrays.sort(linea);
						
						FCFS=FCFSClass(linea);
						SJF=SJFClass(linea);
						SJFP=SJFPClass(linea);
						String qua= (String) comboBoxQRR.getSelectedItem();
						quantum=Integer.valueOf(qua);
						RR=RRClass(linea);
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				if (btnGeneraGrafici.isEnabled()) {
					
					btnGeneraGrafici.setBackground(new Color(100, 181, 246));
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

	//EVENTO CAMBIO QUANTUM RR
		comboBoxQRR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	//EVENTO MOSTRA SOLUZIONE PASSO PASSO
		labelFastForwardPiu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
	//EVENTO SU CHECKBOX MOSTRA TUTTE LE SOLUZIONI
		btnMostraSoluzioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(chckbxMostraSoluzioneFCFS.isSelected()==false)chckbxMostraSoluzioneFCFS.doClick();
					if(chckbxMostraSoluzioneSJF.isSelected()==false)chckbxMostraSoluzioneSJF.doClick();
					if(chckbxMostraSoluzioneSJFP.isSelected()==false)chckbxMostraSoluzioneSJFP.doClick();
					if(chckbxMostraSoluzioneRR.isSelected()==false)chckbxMostraSoluzioneRR.doClick();
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
					jPanelRR.disegnaSoluzioneRR(jPanelRR.getGraphics(),arrayPunti,RR,chckbxMostraSoluzioneRR.isSelected(), chckbxGriglia.isSelected());
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
							if(btnMostraSoluzioni.isSelected()==true)btnMostraSoluzioni.doClick();
							if(chckbxMostraSoluzioneFCFS.isSelected()==true)btnMostraSoluzioni.doClick();
							if(chckbxMostraSoluzioneSJF.isSelected()==true)btnMostraSoluzioni.doClick();
							if(chckbxMostraSoluzioneSJFP.isSelected()==true)btnMostraSoluzioni.doClick();
							if(chckbxMostraSoluzioneRR.isSelected()==true)btnMostraSoluzioni.doClick();
		
							btnMostraSoluzioni.setEnabled(false);
							btnMostraSoluzioni.setSelected(false);
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
					labelDatoTAMFCFS.setText(String.valueOf(frmt.format(averageFCFS)));
					labelDatoCDCFCFS.setText(String.valueOf(cbFCFS));
				}
				else {
					jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
					labelDatoTAMFCFS.setText(" ");
					labelDatoCDCFCFS.setText(" ");
				}
			}
		});
		
		chckbxMostraSoluzioneSJF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMostraSoluzioneSJF.isSelected()==true) {
					jPanelSJF.disegnaSoluzioneSJF(jPanelSJF.getGraphics(),arrayPunti,SJF,chckbxMostraSoluzioneSJF.isSelected(), chckbxGriglia.isSelected());
					DecimalFormat frmt = new DecimalFormat();
					frmt.setMaximumFractionDigits(3);
					labelDatoTAMSJF.setText(String.valueOf(frmt.format(averageSJF)));
					labelDatoCDCSJF.setText(String.valueOf(cbSJF));
				}
				else {
					jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());
					labelDatoTAMSJF.setText(" ");
					labelDatoCDCSJF.setText(" ");
				}
			}
		});
		
		chckbxMostraSoluzioneSJFP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMostraSoluzioneSJFP.isSelected()==true) {
					jPanelSJFP.disegnaSoluzioneSJFP(jPanelSJFP.getGraphics(),arrayPunti,SJFP,chckbxMostraSoluzioneSJFP.isSelected(), chckbxGriglia.isSelected());
					DecimalFormat frmt = new DecimalFormat();
					frmt.setMaximumFractionDigits(3);
					labelDatoTAMSJFP.setText(String.valueOf(frmt.format(averageSJFP)));
					labelDatoCDCSJFP.setText(String.valueOf(cbSJFP));
				}
				else {
					jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
					labelDatoTAMSJFP.setText(" ");
					labelDatoCDCSJFP.setText(" ");
				}
			}
		});
		
		chckbxMostraSoluzioneRR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMostraSoluzioneRR.isSelected()==true) {
					jPanelRR.disegnaSoluzioneRR(jPanelRR.getGraphics(),arrayPunti,RR,chckbxMostraSoluzioneRR.isSelected(), chckbxGriglia.isSelected());
					DecimalFormat frmt = new DecimalFormat();
					frmt.setMaximumFractionDigits(3);
					labelDatoTAMRR.setText(String.valueOf(frmt.format(averageRR)));
					labelDatoCDCRR.setText(String.valueOf(cbRR));
				}
				else {
					jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
					labelDatoTAMRR.setText(" ");
					labelDatoCDCRR.setText(" ");
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

//METODO PER CALCOLARE SJFP
	public ArrayList<Integer> SJFPClass(CreaLinee[] lineaSJFP){
		
		int n=lineaSJFP.length,cambio=0;
		ArrayList<Integer> punti=new ArrayList<Integer>();
		ArrayList<Integer> puntiArray=new ArrayList<Integer>();

	       int proc[][] = new int[n + 1][4];//proc[][0] is the AT array,[][1] - RT,[][2] - WT,[][3] - TT
	       for(int i = 1; i <= n; i++)
	       {
	      proc[lineaSJFP[i-1].getProcesso()][0] = lineaSJFP[i-1].getArrivo();
	      proc[lineaSJFP[i-1].getProcesso()][1] = lineaSJFP[i-1].getDurata();

	     }
	       
	     
	       //Calculation of Total Time and Initialization of Time Chart array
	     int total_time = 0;
	     for(int i = 1; i <= n; i++)
	     {
	      total_time += proc[i][1];
	     }
	     int time_chart[] = new int[total_time];
	     
	     for(int i = 0; i < total_time; i++)
	     {
	      //Selection of shortest process which has arrived
	      int sel_proc = 0;
	      int min = 99999;
	      for(int j = 1; j <= n; j++)
	      {
	       if(proc[j][0] <= i)//Condition to check if Process has arrived
	       {
	        if(proc[j][1] < min && proc[j][1] != 0)
	        {
	         min = proc[j][1];
	         sel_proc = j;
	        }
	       }
	      }
	      
	      //Assign selected process to current time in the Chart
	      time_chart[i] = sel_proc;
	      
	      //Decrement Remaining Time of selected process by 1 since it has been assigned the CPU for 1 unit of time
	      proc[sel_proc][1]--;
	      
	      //WT and TT Calculation
	      for(int j = 1; j <= n; j++)
	      {
	       if(proc[j][0] <= i)
	       {
	        if(proc[j][1] != 0)
	        {
	         proc[j][3]++;//If process has arrived and it has not already completed execution its TT is incremented by 1
	            if(j != sel_proc)//If the process has not been currently assigned the CPU and has arrived its WT is incremented by 1
	             proc[j][2]++;
	        }
	        else if(j == sel_proc)//This is a special case in which the process has been assigned CPU and has completed its execution
	         proc[j][3]++;
	       }
	      }
	      
	      //Printing the Time Chart
	      if(i != 0)
	      {
	       if(sel_proc != time_chart[i - 1])
	        //If the CPU has been assigned to a different Process we need to print the current value of time and the name of 
	        //the new Process
	       {
	        System.out.print("--" + i + "--P" + sel_proc);
	        cambio++;
	        punti.add(i);
	        punti.add(sel_proc);
	        
	       }
	      }
	      else{//If the current time is 0 i.e the printing has just started we need to print the name of the First selected Process
	       System.out.print(i + "--P" + sel_proc);
	       punti.add(i);
	        punti.add(sel_proc);
	      }
	      if(i == total_time - 1){//All the process names have been printed now we have to print the time at which execution ends
	       System.out.print("--" + (i + 1));
	       punti.add(i+1);
	      }
	     }
	     System.out.println();
	     System.out.println();
	     
	     //Printing the WT and TT for each Process
	     System.out.println("P\t WT \t TT ");
	     for(int i = 1; i <= n; i++)
	     {
	      System.out.printf("%d\t%2dms\t%2dms",i,proc[i][2],proc[i][3]);
	      System.out.println();
	     }
	     
	     System.out.println();
	     
	     //Printing the average WT & TT
	     float WT = 0,TT = 0;
	     for(int i = 1; i <= n; i++)
	     {
	      WT += proc[i][2];
	      TT += proc[i][3];
	     }
	     WT /= n;
	     TT /= n;
	     System.out.println("The Average WT is: " + WT + "ms");
	     System.out.println("The Average TT is: " + TT + "ms");
	 
	     for(int i = 0; i < punti.size();)
	     {
	    	 if(i+1<punti.size()) {
	      puntiArray.add(punti.get(i));
	      puntiArray.add(punti.get(i+1));
	      puntiArray.add(punti.get(i+2));
	      puntiArray.add(punti.get(i+1));
	    	 }
	      i=i+2;
	     }
	    
	     cbSJFP=cambio-1;
	     averageSJFP=WT;
	     return puntiArray;
	 }
	    
//METODO PER CALCOLARE RR
	public ArrayList<Integer> RRClass(CreaLinee[] lineaRR){
		
		int pro=lineaRR.length,cambio=0;
		int j,time,remain,flag=0;
		float avgwt=0,avgtt=0;

		ArrayList<Integer> punti=new ArrayList<Integer>();
		ArrayList<Integer> puntiArray=new ArrayList<Integer>();

		int ts = quantum;
       remain=pro;

	    int proc[][] = new int[pro + 1][6];//proc[][0] is the AT array,[][1] - RT,[][2] - WT,[][3] - TT
	    
		   for(int i = 0; i < pro; i++){
				
				proc[lineaRR[i].getProcesso()][0] = lineaRR[i].getProcesso();
				proc[lineaRR[i].getProcesso()][1] = lineaRR[i].getArrivo();
				proc[lineaRR[i].getProcesso()][2] = lineaRR[i].getDurata();
				proc[lineaRR[i].getProcesso()][5] = lineaRR[i].getDurata();
		   }


       for(time=0,i=0;remain!=0;)
       {
              if(proc[lineaRR[i].getProcesso()][5]<=ts && proc[lineaRR[i].getProcesso()][5]>0)
              {
                     time = time + proc[lineaRR[i].getProcesso()][5];
                     //printf(" -> [P%d] <- %d",a[i].p,time);
         	        punti.add(time);
                    punti.add(proc[lineaRR[i].getProcesso()][0]);
                    cambio++;

                     proc[lineaRR[i].getProcesso()][5]=0;
                     flag=1;
              }
              else if(proc[lineaRR[i].getProcesso()][5] > 0)
              {
                     proc[lineaRR[i].getProcesso()][5] = proc[lineaRR[i].getProcesso()][5] - ts;
                     time = time + ts;
                     //printf(" -> [P%d] <- %d",a[i].p,time);
                     punti.add(time);
                     punti.add(proc[lineaRR[i].getProcesso()][0]);
                     cambio++;
              }
              if(proc[lineaRR[i].getProcesso()][5]==0 && flag==1)
              {
                     remain--;
                     proc[lineaRR[i].getProcesso()][4] = time-proc[lineaRR[i].getProcesso()][1];
                     proc[lineaRR[i].getProcesso()][3] = time-proc[lineaRR[i].getProcesso()][1]-proc[lineaRR[i].getProcesso()][2];
                     avgwt = avgwt + time-proc[lineaRR[i].getProcesso()][1]-proc[lineaRR[i].getProcesso()][2];
                     avgtt = avgtt + time-proc[lineaRR[i].getProcesso()][1];
                     flag=0;
              }
              if(i==pro-1)
                     i=0;
              else if(proc[lineaRR[i+1].getProcesso()][1]<= time)
                     i++;
              else
                     i=0;
       }
   //    printf("\n\n");
   //    printf("***************************************\n");
   //    printf("Pro\tArTi\tBuTi\tTaTi\tWtTi\n");
   //    printf("***************************************\n");
       for(i=0;i<pro;i++)
       {
             // printf("P%d\t%d\t%d\t%d\t%d\n",a[i].p,a[i].art,a[i].but,a[i].tat,a[i].wtt);
       }
   //    printf("***************************************\n");
       avgwt = avgwt/pro;
       avgtt = avgtt/pro;
    //   printf("Average Waiting Time : %.2f\n",avgwt);
    //   printf("Average Turnaround Time : %.2f\n",avgtt);
       for(int i = 0; i < punti.size();)
	     {
	    	 if(i+2<punti.size()) {
	      puntiArray.add(punti.get(i));
	      puntiArray.add(punti.get(i+1));
	      puntiArray.add(punti.get(i+2));
	      puntiArray.add(punti.get(i+1));
	    	 }
	      i=i+2;
	     }
	    
	     cbRR=cambio-1;
	     averageRR=avgwt;
	     return puntiArray;	
	    }
		/*	
		int n=lineaRR.length,cambio=0;
		ArrayList<Integer> punti=new ArrayList<Integer>();
		ArrayList<Integer> puntiArray=new ArrayList<Integer>();

		int q = quantum;

	    int proc[][] = new int[n + 1][4];//proc[][0] is the AT array,[][1] - RT,[][2] - WT,[][3] - TT
	    
	    for(int i = 1; i <= n; i++){
		      proc[lineaRR[i-1].getProcesso()][0] = lineaRR[i-1].getArrivo();
	    	proc[lineaRR[i-1].getProcesso()][1] = lineaRR[i-1].getDurata();
	    }
		     
		       //Calculation of Total Time and Initialization of Time Chart array
		     int total_time = 0;
		     for(int i = 1; i <= n; i++)
		     {
		      total_time += proc[i][1];
		     }
		     int time_chart[] = new int[total_time];
		     
		     int sel_proc = 1;
		     int current_q = 0;
		     for(int i = 0; i < total_time; i++)
		     {
		      //Assign selected process to current time in the Chart
		      time_chart[i] = sel_proc;
		      
		      //Decrement Remaining Time of selected process by 1 since it has been assigned the CPU for 1 unit of time
		      proc[sel_proc][1]--;
		      
		      //WT and TT Calculation
		      for(int j = 1; j <= n; j++)
		      {
		       if(proc[j][1] != 0)
		       {
		        proc[j][3]++;//If process has not completed execution its TT is incremented by 1
		        if(j != sel_proc)//If the process has not been currently assigned the CPU its WT is incremented by 1
		         proc[j][2]++;
		       }
		       else if(j == sel_proc)//This is a special case in which the process has been assigned CPU and has completed its execution
		        proc[j][3]++;
		      }
		      
		      //Printing the Time Chart
		      if(i != 0)
		      {
		       if(sel_proc != time_chart[i - 1])
		        //If the CPU has been assigned to a different Process we need to print the current value of time and the name of 
		        //the new Process
		       {
		        System.out.print("--" + i + "--P" + sel_proc);
		        cambio++;
		        punti.add(i);
		        punti.add(sel_proc);
		       }
		      }
		      else{//If the current time is 0 i.e the printing has just started we need to print the name of the First selected Process
		       System.out.print(i + "--P" + sel_proc);
		       punti.add(i);
		        punti.add(sel_proc);
		      }
		      if(i == total_time - 1){//All the process names have been printed now we have to print the time at which execution ends
		       System.out.print("--" + (i + 1));
		       punti.add(i+1);
		      }
		      //Updating value of sel_proc for next iteration
		      current_q++;
		      if(current_q == q || proc[sel_proc][1] == 0)//If Time slice has expired or the current process has completed execution
		      {
		       current_q = 0;
		       //This will select the next valid value for sel_proc
		       for(int j = 1; j <= n; j++)
		       {
		        sel_proc++;
		        if(sel_proc == (n + 1))
		            sel_proc = 1;
		        if(proc[sel_proc][1] != 0)
		         break;
		       }
		      }
		     }
		     System.out.println();
		     for(int i = 1; i <= n; i++)
		     {
		      System.out.printf("%d\t%2dms\t%2dms",i,proc[i][2],proc[i][3]);
		      System.out.println();
		     }		     
		 
		     //Printing the average WT & TT
		     float WT = 0,TT = 0;
		     for(int i = 1; i <= n; i++)
		     {
		      WT += proc[i][2];
		      TT += proc[i][3];
		     }
		     WT /= n;
		     TT /= n;

		     
		     for(int i = 0; i < punti.size();)
		     {
		    	 if(i+1<punti.size()) {
		      puntiArray.add(punti.get(i));
		      puntiArray.add(punti.get(i+1));
		      puntiArray.add(punti.get(i+2));
		      puntiArray.add(punti.get(i+1));
		    	 }
		      i=i+2;
		     }
		    
		     cbRR=cambio-1;
		     averageRR=WT;
		     return puntiArray;
		 }
	*/	    
}
