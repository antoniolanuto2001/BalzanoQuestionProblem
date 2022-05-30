
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

import model.PanelGraficiSchProcessi;
import model.CreaLinee;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.Desktop;

import javax.swing.border.MatteBorder;

import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class SchProcessi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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


@SuppressWarnings({ "unchecked", "rawtypes" })
public SchProcessi(JFrame framechiamante) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 0, 1440, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Operating Systems Simulator: Scheduling Della CPU");
		setLocationRelativeTo(null);
		setResizable(false);

/**							PANNELLO PRINCIPALE								*/
		JPanel pannelloPrincipale = new JPanel();
			pannelloPrincipale.setForeground(new Color(153, 204, 255));
			pannelloPrincipale.setBounds(0, 0, 1440, 800);
			frame.getContentPane().add(pannelloPrincipale);
			pannelloPrincipale.setLayout(null);
	        
	        JLabel labelIndietroIcon = new JLabel();
	        labelIndietroIcon.setHorizontalAlignment(SwingConstants.CENTER);
	        labelIndietroIcon.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		framechiamante.setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				}
	        	
	        });
	        labelIndietroIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/back-button.png")));
	        labelIndietroIcon.setBounds(10, 80, 53, 46);
	        pannelloPrincipale.add(labelIndietroIcon);
	        
	        JLabel labelScrittaYoutube = new JLabel("Lezione");
	        labelScrittaYoutube.setHorizontalAlignment(SwingConstants.CENTER);
	        labelScrittaYoutube.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        labelScrittaYoutube.setBounds(78, 122, 50, 12);
	        pannelloPrincipale.add(labelScrittaYoutube);
	        JLabel labelYoutubeIcon = new JLabel("");
	        labelYoutubeIcon.setHorizontalAlignment(SwingConstants.CENTER);
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
	        labelYoutubeIcon.setBounds(80, 80, 47, 46);
	        pannelloPrincipale.add(labelYoutubeIcon);
	        
	        JLabel labelScrittaSlide = new JLabel("Slide");
	        labelScrittaSlide.setHorizontalAlignment(SwingConstants.CENTER);
	        labelScrittaSlide.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        labelScrittaSlide.setBounds(144, 122, 61, 15);
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
	        labelSlideIcon.setBounds(150, 80, 53, 46);
	        pannelloPrincipale.add(labelSlideIcon);
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
			labelFedericoII.setBounds(1205, 12, 199, 53);
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
			chckbxMostraSoluzioneFCFS.setSelected(true);
				chckbxMostraSoluzioneFCFS.setHorizontalAlignment(SwingConstants.CENTER);
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
			chckbxMostraSoluzioneSJF.setSelected(true);
			chckbxMostraSoluzioneSJF.setHorizontalAlignment(SwingConstants.CENTER);
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
			chckbxMostraSoluzioneSJFP.setSelected(true);
			chckbxMostraSoluzioneSJFP.setHorizontalAlignment(SwingConstants.CENTER);
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
				chckbxMostraSoluzioneRR.setSelected(true);
				chckbxMostraSoluzioneRR.setHorizontalAlignment(SwingConstants.CENTER);
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
			pannelloDiControllo.setBounds(1141, 80, 265, 673);
			pannelloPrincipale.add(pannelloDiControllo);
			pannelloDiControllo.setLayout(null);
			//pannelloDiControllo.setBorder(new LineBorder(new Color(255, 204, 51), 3));
		
		JPanel pannellodicontrolloTitolo = new JPanel();
			pannellodicontrolloTitolo.setBounds(10, 5, 245, 54);
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
			labelEditor.setBounds(0, 60, 265, 25);
			pannelloDiControllo.add(labelEditor);
			
		//PANNELLO EDITOR
		JPanel pannelloEDITOR = new JPanel();
			pannelloEDITOR.setBounds(10, 85, 245, 345);
			pannelloDiControllo.add(pannelloEDITOR);
			pannelloEDITOR.setLayout(null);
			//pannelloEDITOR.setBorder(new LineBorder(new Color(255, 204, 0), 3));
		
		JLabel labellNumeroDiProcessi = new JLabel("Numero di processi");
			labellNumeroDiProcessi.setHorizontalAlignment(SwingConstants.CENTER);
			labellNumeroDiProcessi.setForeground(new Color(0, 0, 0));
			labellNumeroDiProcessi.setFont(new Font("Arial", Font.BOLD, 15));
			labellNumeroDiProcessi.setBounds(10, 2, 165, 23);
			pannelloEDITOR.add(labellNumeroDiProcessi);
		
		JComboBox comboBoxSceltaNProcessi = new JComboBox();
			comboBoxSceltaNProcessi.setEnabled(false);
			comboBoxSceltaNProcessi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			comboBoxSceltaNProcessi.setBackground(new Color(255, 255, 255));
			comboBoxSceltaNProcessi.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
			comboBoxSceltaNProcessi.setSelectedIndex(2);
			comboBoxSceltaNProcessi.setBounds(185, 2, 50, 21);
			pannelloEDITOR.add(comboBoxSceltaNProcessi);


		JCheckBox chckbxGriglia = new JCheckBox("Griglia");
			chckbxGriglia.setSelected(true);
			chckbxGriglia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chckbxGriglia.setBounds(10, 276, 65, 21);
			pannelloEDITOR.add(chckbxGriglia);
		
		JLabel labelMostraSoluzioni = new JLabel("");
			labelMostraSoluzioni.setHorizontalAlignment(SwingConstants.CENTER);
			labelMostraSoluzioni.setBackground(Color.WHITE);
			labelMostraSoluzioni.setEnabled(false);
			labelMostraSoluzioni.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			labelMostraSoluzioni.setBounds(80, 305, 79, 35);
			labelMostraSoluzioni.setIcon(new ImageIcon(Hashing.class.getResource("/img/playIcon2.png")));
			pannelloEDITOR.add(labelMostraSoluzioni);
			
		JLabel labelFastForwardPiu = new JLabel("");
			labelFastForwardPiu.setBackground(Color.WHITE);
			labelFastForwardPiu.setHorizontalAlignment(SwingConstants.CENTER);
			labelFastForwardPiu.setEnabled(false);
			labelFastForwardPiu.setIcon(new ImageIcon(Hashing.class.getResource("/img/fastFowardIcon1.png")));
			labelFastForwardPiu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			labelFastForwardPiu.setBounds(163, 305, 70, 35);
			pannelloEDITOR.add(labelFastForwardPiu);
			
		JLabel labelFastForwardMeno = new JLabel("");
			labelFastForwardMeno.setBackground(Color.WHITE);
			labelFastForwardMeno.setHorizontalAlignment(SwingConstants.CENTER);
			labelFastForwardMeno.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			labelFastForwardMeno.setEnabled(false);
			labelFastForwardMeno.setBounds(5, 305, 70, 35);
			labelFastForwardMeno.setIcon(new ImageIcon(SchProcessi.class.getResource("/img/fastFowardIconRovescio.png")));
			pannelloEDITOR.add(labelFastForwardMeno);
			
		//TABELLA PROCESSI
		JPanel panelTabella = new JPanel();
			panelTabella.setBorder(new LineBorder(new Color(100, 181, 246),2));
			panelTabella.setBounds(10, 36, 222, 188);
			pannelloEDITOR.add(panelTabella);
			GridBagLayout gbl_panelTabella = new GridBagLayout();
			gbl_panelTabella.columnWidths = new int[]{0, 70, 70, 70, 0};
			gbl_panelTabella.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panelTabella.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panelTabella.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelTabella.setLayout(gbl_panelTabella);
			
			Component horizontalStrut_1 = Box.createHorizontalStrut(20);
			horizontalStrut_1.setBackground(Color.BLACK);
			GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
			gbc_horizontalStrut_1.gridwidth = 3;
			gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
			gbc_horizontalStrut_1.gridx = 1;
			gbc_horizontalStrut_1.gridy = 0;
			panelTabella.add(horizontalStrut_1, gbc_horizontalStrut_1);
			
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.gridheight = 8;
			gbc_verticalStrut.insets = new Insets(0, 0, 0, 5);
			gbc_verticalStrut.gridx = 0;
			gbc_verticalStrut.gridy = 1;
			panelTabella.add(verticalStrut, gbc_verticalStrut);
			
			Component horizontalStrut = Box.createHorizontalStrut(20);
			horizontalStrut.setBackground(Color.BLACK);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.gridwidth = 3;
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
			gbc_horizontalStrut.gridx = 1;
			gbc_horizontalStrut.gridy = 2;
			panelTabella.add(horizontalStrut, gbc_horizontalStrut);
			
			JLabel labelP1 = new JLabel("");
			labelP1.setHorizontalAlignment(SwingConstants.CENTER);
			labelP1.setEnabled(false);
			GridBagConstraints gbc_labelP1 = new GridBagConstraints();
			gbc_labelP1.insets = new Insets(0, 0, 5, 5);
			gbc_labelP1.gridx = 1;
			gbc_labelP1.gridy = 3;
			panelTabella.add(labelP1, gbc_labelP1);
			
			JTextField textArrivoP1 = new JTextField("");
			textArrivoP1.setColumns(4);
			textArrivoP1.setEnabled(false);
			textArrivoP1.setEditable(false);
			textArrivoP1.setVisible(false);
			textArrivoP1.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_textArrivoP1 = new GridBagConstraints();
			gbc_textArrivoP1.insets = new Insets(0, 0, 5, 5);
			gbc_textArrivoP1.gridx = 2;
			gbc_textArrivoP1.gridy = 3;
			panelTabella.add(textArrivoP1, gbc_textArrivoP1);
			
			JTextField textDurataP1 = new JTextField("");
			textDurataP1.setColumns(4);
			textDurataP1.setHorizontalAlignment(SwingConstants.CENTER);
			textDurataP1.setEnabled(false);
			textDurataP1.setEditable(false);
			textDurataP1.setVisible(false);
			GridBagConstraints gbc_textDurataP1 = new GridBagConstraints();
			gbc_textDurataP1.insets = new Insets(0, 0, 5, 0);
			gbc_textDurataP1.gridx = 3;
			gbc_textDurataP1.gridy = 3;
			panelTabella.add(textDurataP1, gbc_textDurataP1);
			/*
			JCheckBox chckbxP1 = new JCheckBox("");
			chckbxP1.setEnabled(false);
			chckbxP1.setVisible(false);
			GridBagConstraints gbc_chckbxP1 = new GridBagConstraints();
			gbc_chckbxP1.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxP1.gridx = 4;
			gbc_chckbxP1.gridy = 3;
			panelTabella.add(chckbxP1, gbc_chckbxP1);
			*/
			JLabel labelP2 = new JLabel("");
			labelP2.setHorizontalAlignment(SwingConstants.CENTER);
			labelP2.setEnabled(false);
			GridBagConstraints gbc_labelP2 = new GridBagConstraints();
			gbc_labelP2.insets = new Insets(0, 0, 5, 5);
			gbc_labelP2.gridx = 1;
			gbc_labelP2.gridy = 4;
			panelTabella.add(labelP2, gbc_labelP2);
			
			JTextField textArrivoP2 = new JTextField("");
			textArrivoP2.setColumns(4);
			textArrivoP2.setEnabled(false);
			textArrivoP2.setEditable(false);
			textArrivoP2.setVisible(false);
			textArrivoP2.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_textArrivoP2 = new GridBagConstraints();
			gbc_textArrivoP2.insets = new Insets(0, 0, 5, 5);
			gbc_textArrivoP2.gridx = 2;
			gbc_textArrivoP2.gridy = 4;
			panelTabella.add(textArrivoP2, gbc_textArrivoP2);
			
			JTextField textDurataP2 = new JTextField("");
			textDurataP2.setColumns(4);
			textDurataP2.setEditable(false);
			textDurataP2.setEnabled(false);
			textDurataP2.setVisible(false);
			textDurataP2.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_textDurataP2 = new GridBagConstraints();
			gbc_textDurataP2.insets = new Insets(0, 0, 5, 0);
			gbc_textDurataP2.gridx = 3;
			gbc_textDurataP2.gridy = 4;
			panelTabella.add(textDurataP2, gbc_textDurataP2);
			/*
			JCheckBox chckbxP2 = new JCheckBox("");
			chckbxP2.setEnabled(false);
			chckbxP2.setVisible(false);
			GridBagConstraints gbc_chckbxP2 = new GridBagConstraints();
			gbc_chckbxP2.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxP2.gridx = 4;
			gbc_chckbxP2.gridy = 4;
			panelTabella.add(chckbxP2, gbc_chckbxP2);
			*/
			JLabel labelP3 = new JLabel("");
			labelP3.setHorizontalAlignment(SwingConstants.CENTER);
			labelP3.setEnabled(false);
			GridBagConstraints gbc_labelP3 = new GridBagConstraints();
			gbc_labelP3.insets = new Insets(0, 0, 5, 5);
			gbc_labelP3.gridx = 1;
			gbc_labelP3.gridy = 5;
			panelTabella.add(labelP3, gbc_labelP3);
			
			JTextField textArrivoP3 = new JTextField("");
			textArrivoP3.setColumns(4);
			textArrivoP3.setEnabled(false);
			textArrivoP3.setEditable(false);
			textArrivoP3.setVisible(false);
			textArrivoP3.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_textArrivoP3 = new GridBagConstraints();
			gbc_textArrivoP3.insets = new Insets(0, 0, 5, 5);
			gbc_textArrivoP3.gridx = 2;
			gbc_textArrivoP3.gridy = 5;
			panelTabella.add(textArrivoP3, gbc_textArrivoP3);
			
			JTextField textDurataP3 = new JTextField("");
			textDurataP3.setColumns(4);
			textDurataP3.setHorizontalAlignment(SwingConstants.CENTER);
			textDurataP3.setEnabled(false);
			textDurataP3.setEditable(false);
			textDurataP3.setVisible(false);
			GridBagConstraints gbc_textDurataP3 = new GridBagConstraints();
			gbc_textDurataP3.insets = new Insets(0, 0, 5, 0);
			gbc_textDurataP3.gridx = 3;
			gbc_textDurataP3.gridy = 5;
			panelTabella.add(textDurataP3, gbc_textDurataP3);
			/*
			JCheckBox chckbxP3 = new JCheckBox("");
			chckbxP3.setEnabled(false);
			chckbxP3.setVisible(false);
			GridBagConstraints gbc_chckbxP3 = new GridBagConstraints();
			gbc_chckbxP3.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxP3.gridx = 4;
			gbc_chckbxP3.gridy = 5;
			panelTabella.add(chckbxP3, gbc_chckbxP3);
			*/
			JLabel labelP4 = new JLabel("");
			labelP4.setHorizontalAlignment(SwingConstants.CENTER);
			labelP4.setEnabled(false);
			GridBagConstraints gbc_labelP4 = new GridBagConstraints();
			gbc_labelP4.insets = new Insets(0, 0, 5, 5);
			gbc_labelP4.gridx = 1;
			gbc_labelP4.gridy = 6;
			panelTabella.add(labelP4, gbc_labelP4);
			
			JTextField textArrivoP4 = new JTextField("");
			textArrivoP4.setColumns(4);
			textArrivoP4.setHorizontalAlignment(SwingConstants.CENTER);
			textArrivoP4.setEnabled(false);
			textArrivoP4.setEditable(false);
			textArrivoP4.setVisible(false);
			GridBagConstraints gbc_textArrivoP4 = new GridBagConstraints();
			gbc_textArrivoP4.insets = new Insets(0, 0, 5, 5);
			gbc_textArrivoP4.gridx = 2;
			gbc_textArrivoP4.gridy = 6;
			panelTabella.add(textArrivoP4, gbc_textArrivoP4);
			
			JTextField textDurataP4 = new JTextField("");
			textDurataP4.setColumns(4);
			textDurataP4.setEditable(false);
			textDurataP4.setEnabled(false);
			textDurataP4.setVisible(false);
			textDurataP4.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_textDurataP4 = new GridBagConstraints();
			gbc_textDurataP4.insets = new Insets(0, 0, 5, 0);
			gbc_textDurataP4.gridx = 3;
			gbc_textDurataP4.gridy = 6;
			panelTabella.add(textDurataP4, gbc_textDurataP4);
			/*
			JCheckBox chckbxP4 = new JCheckBox("");
			chckbxP4.setEnabled(false);
			chckbxP4.setVisible(false);
			GridBagConstraints gbc_chckbxP4 = new GridBagConstraints();
			gbc_chckbxP4.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxP4.gridx = 4;
			gbc_chckbxP4.gridy = 6;
			panelTabella.add(chckbxP4, gbc_chckbxP4);
			*/
			JLabel labelP5 = new JLabel("");
			labelP5.setHorizontalAlignment(SwingConstants.CENTER);
			labelP5.setEnabled(false);
			GridBagConstraints gbc_labelP5 = new GridBagConstraints();
			gbc_labelP5.insets = new Insets(0, 0, 5, 5);
			gbc_labelP5.gridx = 1;
			gbc_labelP5.gridy = 7;
			panelTabella.add(labelP5, gbc_labelP5);
			
			JTextField textArrivoP5 = new JTextField("");
			textArrivoP5.setColumns(4);
			textArrivoP5.setHorizontalAlignment(SwingConstants.CENTER);
			textArrivoP5.setEnabled(false);
			textArrivoP5.setEditable(false);
			textArrivoP5.setVisible(false);
			GridBagConstraints gbc_textArrivoP5 = new GridBagConstraints();
			gbc_textArrivoP5.insets = new Insets(0, 0, 5, 5);
			gbc_textArrivoP5.gridx = 2;
			gbc_textArrivoP5.gridy = 7;
			panelTabella.add(textArrivoP5, gbc_textArrivoP5);
			
			JTextField textDurataP5 = new JTextField("");
			textDurataP5.setColumns(4);
			textDurataP5.setHorizontalAlignment(SwingConstants.CENTER);
			textDurataP5.setEnabled(false);
			textDurataP5.setEditable(false);
			textDurataP5.setVisible(false);
			GridBagConstraints gbc_textDurataP5 = new GridBagConstraints();
			gbc_textDurataP5.insets = new Insets(0, 0, 5, 0);
			gbc_textDurataP5.gridx = 3;
			gbc_textDurataP5.gridy = 7;
			panelTabella.add(textDurataP5, gbc_textDurataP5);
			/*
			JCheckBox chckbxP5 = new JCheckBox("");
			chckbxP5.setEnabled(false);
			chckbxP5.setVisible(false);
			GridBagConstraints gbc_chckbxP5 = new GridBagConstraints();
			gbc_chckbxP5.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxP5.gridx = 4;
			gbc_chckbxP5.gridy = 7;
			panelTabella.add(chckbxP5, gbc_chckbxP5);
			*/
			JLabel labelP6 = new JLabel("");
			labelP6.setHorizontalAlignment(SwingConstants.CENTER);
			labelP6.setEnabled(false);
			GridBagConstraints gbc_labelP6 = new GridBagConstraints();
			gbc_labelP6.insets = new Insets(0, 0, 0, 5);
			gbc_labelP6.gridx = 1;
			gbc_labelP6.gridy = 8;
			panelTabella.add(labelP6, gbc_labelP6);
			
			JTextField textArrivoP6 = new JTextField("");
			textArrivoP6.setColumns(4);
			textArrivoP6.setHorizontalAlignment(SwingConstants.CENTER);
			textArrivoP6.setEditable(false);
			textArrivoP6.setEnabled(false);
			textArrivoP6.setVisible(false);
			GridBagConstraints gbc_textArrivoP6 = new GridBagConstraints();
			gbc_textArrivoP6.insets = new Insets(0, 0, 0, 5);
			gbc_textArrivoP6.gridx = 2;
			gbc_textArrivoP6.gridy = 8;
			panelTabella.add(textArrivoP6, gbc_textArrivoP6);
			
			JTextField textDurataP6 = new JTextField("");
			textDurataP6.setColumns(4);
			textDurataP6.setEnabled(false);
			textDurataP6.setEditable(false);
			textDurataP6.setVisible(false);
			textDurataP6.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_textDurataP6 = new GridBagConstraints();
			gbc_textDurataP6.gridx = 3;
			gbc_textDurataP6.gridy = 8;
			panelTabella.add(textDurataP6, gbc_textDurataP6);
			/*
			JCheckBox chckbxP6 = new JCheckBox("");
			chckbxP6.setEnabled(false);
			chckbxP6.setVisible(false);
			GridBagConstraints gbc_chckbxP6 = new GridBagConstraints();
			gbc_chckbxP6.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxP6.gridx = 4;
			gbc_chckbxP6.gridy = 8;
			panelTabella.add(chckbxP6, gbc_chckbxP6);
			*/
			JLabel labelProcesso = new JLabel("PROCESSO");
			labelProcesso.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_labelProcesso = new GridBagConstraints();
			gbc_labelProcesso.anchor = GridBagConstraints.NORTH;
			gbc_labelProcesso.insets = new Insets(0, 0, 5, 5);
			gbc_labelProcesso.gridx = 1;
			gbc_labelProcesso.gridy = 1;
			panelTabella.add(labelProcesso, gbc_labelProcesso);
			
			JLabel labelArrivo = new JLabel("ARRIVO");
			labelArrivo.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_labelArrivo = new GridBagConstraints();
			gbc_labelArrivo.insets = new Insets(0, 0, 5, 5);
			gbc_labelArrivo.gridx = 2;
			gbc_labelArrivo.gridy = 1;
			panelTabella.add(labelArrivo, gbc_labelArrivo);
						
			JLabel labelDurata = new JLabel("DURATA");
			labelDurata.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_labelDurata = new GridBagConstraints();
			gbc_labelDurata.insets = new Insets(0, 0, 5, 0);
			gbc_labelDurata.gridx = 3;
			gbc_labelDurata.gridy = 1;
			panelTabella.add(labelDurata, gbc_labelDurata);
			
				//BOTTONE GENERA
				JButton btnGenera = new JButton("Genera Esercizio");
				btnGenera.setBounds(10, 235, 223, 35);
				pannelloEDITOR.add(btnGenera);
				btnGenera.setBackground(Color.WHITE);
				btnGenera.setFont(new Font("Segoe UI", Font.BOLD, 17));
				btnGenera.setBorder(new LineBorder(new Color(100, 181, 246), 4));
				
	//EVENTO SU BOTTONE GENERA TABELLA PROCESSI
		btnGenera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
				jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());
				jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
				jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
				
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
				
				labelMostraSoluzioni.setEnabled(true);
				comboBoxQRR.setEnabled(false);
										
				scelta= (String) comboBoxSceltaNProcessi.getSelectedItem();
				int numeroProcessi=Integer.valueOf(scelta);
					
				labelP1.setText("");	
				labelP2.setText("");	
				labelP3.setText("");	
				labelP4.setText("");	
				labelP5.setText("");	
				labelP6.setText("");	

				textArrivoP1.setText("");
				textArrivoP2.setText("");
				textArrivoP3.setText("");
				textArrivoP4.setText("");
				textArrivoP5.setText("");
				textArrivoP6.setText("");
				
				textDurataP1.setText("");
				textDurataP2.setText("");
				textDurataP3.setText("");
				textDurataP4.setText("");
				textDurataP5.setText("");
				textDurataP6.setText("");

				labelP1.setEnabled(false);
				textDurataP1.setEnabled(false);
				textDurataP1.setEditable(false);
				textDurataP1.setVisible(false);
				textArrivoP1.setEnabled(false);
				textArrivoP1.setEditable(false);
				textArrivoP1.setVisible(false);
				
				labelP2.setEnabled(false);
				textDurataP2.setEnabled(false);
				textDurataP2.setEditable(false);
				textDurataP2.setVisible(false);
				textArrivoP2.setEnabled(false);
				textArrivoP2.setEditable(false);
				textArrivoP2.setVisible(false);
				
				labelP3.setEnabled(false);
				textDurataP3.setEnabled(false);
				textDurataP3.setEditable(false);
				textDurataP3.setVisible(false);
				textArrivoP3.setEnabled(false);
				textArrivoP3.setEditable(false);
				textArrivoP3.setVisible(false);
				
				labelP4.setEnabled(false);
				textDurataP4.setEnabled(false);
				textDurataP4.setEditable(false);
				textDurataP4.setVisible(false);
				textArrivoP4.setEnabled(false);
				textArrivoP4.setEditable(false);
				textArrivoP4.setVisible(false);
				
				labelP5.setEnabled(false);
				textDurataP5.setEnabled(false);
				textDurataP5.setEditable(false);
				textDurataP5.setVisible(false);
				textArrivoP5.setEnabled(false);
				textArrivoP5.setEditable(false);
				textArrivoP5.setVisible(false);
				
				labelP6.setEnabled(false);
				textDurataP6.setEnabled(false);
				textDurataP6.setEditable(false);
				textDurataP6.setVisible(false);
				textArrivoP6.setEnabled(false);
				textArrivoP6.setEditable(false);
				textArrivoP6.setVisible(false);
				
				for (int i=0;i<numeroProcessi;i++){ 
					
					Random random = new Random();
					int value = random.nextInt(15 + 0) + 0;
					if(i==0) {
				labelP1.setEnabled(true);
				labelP1.setText("P"+(i+1));	
					}
					if(i==1) {
				labelP2.setEnabled(true);
				labelP2.setText("P"+(i+1));	
					}
					if(i==2) {
				labelP3.setEnabled(true);
				labelP3.setText("P"+(i+1));	
					}
					if(i==3) {
				labelP4.setEnabled(true);
				labelP4.setText("P"+(i+1));	
					}
					if(i==4) {
				labelP5.setEnabled(true);
				labelP5.setText("P"+(i+1));	
					}
					if(i==5) {
				labelP6.setEnabled(true);
				labelP6.setText("P"+(i+1));	
					}

					if(i==0) {
				textArrivoP1.setEnabled(true);
				textArrivoP1.setEditable(true);
				textArrivoP1.setText(String.valueOf(value));	
				textArrivoP1.setVisible(true);
					}
					if(i==1) {
				textArrivoP2.setEnabled(true);
				textArrivoP2.setEditable(true);
				textArrivoP2.setText(String.valueOf(value));
				textArrivoP2.setVisible(true);
					}
					if(i==2) {
				textArrivoP3.setEnabled(true);
				textArrivoP3.setEditable(true);
				textArrivoP3.setText(String.valueOf(value));
				textArrivoP3.setVisible(true);
					}
					if(i==3) {
				textArrivoP4.setEnabled(true);
				textArrivoP4.setEditable(true);
				textArrivoP4.setText(String.valueOf(value));
				textArrivoP4.setVisible(true);
					}
					if(i==4) {
				textArrivoP5.setEnabled(true);
				textArrivoP5.setEditable(true);
				textArrivoP5.setText(String.valueOf(value));	
				textArrivoP5.setVisible(true);
					}
					if(i==5) {
				textArrivoP6.setEnabled(true);
				textArrivoP6.setEditable(true);
				textArrivoP6.setText(String.valueOf(value));
				textArrivoP6.setVisible(true);
					}
					
					int value2 = random.nextInt(15 + 0) + 0;
					
					if(i==0) {
				textDurataP1.setEnabled(true);
				textDurataP1.setEditable(true);
				textDurataP1.setText(String.valueOf(value2));
				textDurataP1.setVisible(true);
					}
					if(i==1) {
				textDurataP2.setEnabled(true);
				textDurataP2.setEditable(true);
				textDurataP2.setText(String.valueOf(value2));	
				textDurataP2.setVisible(true);
					}
					if(i==2) {
				textDurataP3.setEnabled(true);
				textDurataP3.setEditable(true);
				textDurataP3.setText(String.valueOf(value2));
				textDurataP3.setVisible(true);
					}
					if(i==3) {
				textDurataP4.setEnabled(true);
				textDurataP4.setEditable(true);
				textDurataP4.setText(String.valueOf(value2));
				textDurataP4.setVisible(true);
					}
					if(i==4) {
				textDurataP5.setEnabled(true);
				textDurataP5.setEditable(true);
				textDurataP5.setText(String.valueOf(value2));	
				textDurataP5.setVisible(true);
					}
					if(i==5) {
				textDurataP6.setEnabled(true);
				textDurataP6.setEditable(true);
				textDurataP6.setText(String.valueOf(value2));
				textDurataP6.setVisible(true);
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btnGenera.setBackground(new Color(100, 181, 246));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGenera.setBackground(Color.WHITE);
			}
		});
			
		//PANNELLO HELP
		JPanel pannelloHelp = new JPanel();
			pannelloHelp.setBorder(new LineBorder(new Color(255, 204, 0), 3));
			pannelloHelp.setBounds(10, 455, 245, 213);
			pannelloDiControllo.add(pannelloHelp);
			pannelloHelp.setLayout(null);
		
		JScrollPane scrollPaneHelp = new JScrollPane();
			scrollPaneHelp.setBounds(0, 0, 245, 213);
			pannelloHelp.add(scrollPaneHelp);
        	
		JTextArea txtrHelpArea = new JTextArea();
			scrollPaneHelp.setViewportView(txtrHelpArea);
			txtrHelpArea.setWrapStyleWord(true);
			txtrHelpArea.setLineWrap(true);
			txtrHelpArea.setText("FCFS: (First Come First Served). \r\nCon questo schema la CPU si assegna al processo che la richiede per  primo. Esso \u00E8 il piu' semplice degli algoritmi di scheduling della CPU ed \u00E8 basato su code FIFO. Questo algoritmo genera l' Effetto Convoglio: tutti i processi attendono che un lungo processo liberi la CPU.\r\n\r\nSJF: (Shortest Job First). \r\nDetto anche scheduling per brevit\u00E0. Questo algoritmo associa a ogni processo la lunghezza della successiva sequenza di operazioni della CPU. Se due processi hanno le seccessive sequenze di operazioni della CPU della stessa lunghezza, allora si applica lo scheduling FCFS. Esso ottimizza il tempo di attesa medio per un dato insieme di processi. \r\n\r\nSJFP: (Shortest Job First Preempitive). \r\nEsso \u00E8 spesso detto \"shortest remaining time first\"; \u00E8 uguale al SJF ma con la differenza che se arriva un nuovo processo con tempo di esecuzione inferiore a quello attualmente in esecuzione, allora quello nuovo prelaziona quello in esecuzione. \r\n\r\nRR: (Round Robin). \r\nE' detto scheduling circolare; E' simile al FCFS ma ha in pi\u00F9 la capacit\u00E0 di prelazione per la commutazione dei processi. Ciascun processo riceve una piccola quantit\u00E0 fissata del tempo della CPU, chiamata quanto di tempo q e la coda dei processi pronti \u00E8 trattata come una coda circolare. Per valori di 'q' molto grandi RR tende al FCFS.\r\n");
			txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
			txtrHelpArea.setCaretPosition(0);
			txtrHelpArea.setEditable(false);
		                
		JLabel labelHelp = new JLabel("Spiegazioni argomento");
			labelHelp.setBounds(10, 430, 245, 25);
			pannelloDiControllo.add(labelHelp);
			labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
			labelHelp.setForeground(Color.RED);
			labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));

			

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
/**							IMPLEMENTAZIONE EVENTI																																	 */

	//EVENTO SU BOX SCELTA NUMERO PROCESSI
		comboBoxSceltaNProcessi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
				jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());
				jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
				jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
				
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
				
				labelMostraSoluzioni.setEnabled(true);
				comboBoxQRR.setEnabled(false);
												
				scelta= (String) comboBoxSceltaNProcessi.getSelectedItem();
				int numeroProcessi=Integer.valueOf(scelta);
							
				labelP1.setText("");	
				labelP2.setText("");	
				labelP3.setText("");	
				labelP4.setText("");	
				labelP5.setText("");	
				labelP6.setText("");	

				textArrivoP1.setText("");
				textArrivoP2.setText("");
				textArrivoP3.setText("");
				textArrivoP4.setText("");
				textArrivoP5.setText("");
				textArrivoP6.setText("");
				
				textDurataP1.setText("");
				textDurataP2.setText("");
				textDurataP3.setText("");
				textDurataP4.setText("");
				textDurataP5.setText("");
				textDurataP6.setText("");

				labelP1.setEnabled(false);
				textDurataP1.setEnabled(false);
				textDurataP1.setEditable(false);
				textDurataP1.setVisible(false);
				textArrivoP1.setEnabled(false);
				textArrivoP1.setEditable(false);
				textArrivoP1.setVisible(false);
				
				labelP2.setEnabled(false);
				textDurataP2.setEnabled(false);
				textDurataP2.setEditable(false);
				textDurataP2.setVisible(false);
				textArrivoP2.setEnabled(false);
				textArrivoP2.setEditable(false);
				textArrivoP2.setVisible(false);
				
				labelP3.setEnabled(false);
				textDurataP3.setEnabled(false);
				textDurataP3.setEditable(false);
				textDurataP3.setVisible(false);
				textArrivoP3.setEnabled(false);
				textArrivoP3.setEditable(false);
				textArrivoP3.setVisible(false);
				
				labelP4.setEnabled(false);
				textDurataP4.setEnabled(false);
				textDurataP4.setEditable(false);
				textDurataP4.setVisible(false);
				textArrivoP4.setEnabled(false);
				textArrivoP4.setEditable(false);
				textArrivoP4.setVisible(false);
				
				labelP5.setEnabled(false);
				textDurataP5.setEnabled(false);
				textDurataP5.setEditable(false);
				textDurataP5.setVisible(false);
				textArrivoP5.setEnabled(false);
				textArrivoP5.setEditable(false);
				textArrivoP5.setVisible(false);
				
				labelP6.setEnabled(false);
				textDurataP6.setEnabled(false);
				textDurataP6.setEditable(false);
				textDurataP6.setVisible(false);
				textArrivoP6.setEnabled(false);
				textArrivoP6.setEditable(false);
				textArrivoP6.setVisible(false);
				
				for (int i=0;i<numeroProcessi;i++){ 
					
					Random random = new Random();
					int value = random.nextInt(15 + 0) + 0;
					if(i==0) {
						labelP1.setEnabled(true);
						labelP1.setText("P"+(i+1));	
					}
					if(i==1) {
						labelP2.setEnabled(true);
						labelP2.setText("P"+(i+1));	
					}
					if(i==2) {
						labelP3.setEnabled(true);
						labelP3.setText("P"+(i+1));	
					}
					if(i==3) {
						labelP4.setEnabled(true);
						labelP4.setText("P"+(i+1));	
					}
					if(i==4) {
						labelP5.setEnabled(true);
						labelP5.setText("P"+(i+1));	
					}
					if(i==5) {
						labelP6.setEnabled(true);
						labelP6.setText("P"+(i+1));	
					}

					if(i==0) {
						textArrivoP1.setEnabled(true);
						textArrivoP1.setEditable(true);
						textArrivoP1.setText(String.valueOf(value));	
						textArrivoP1.setVisible(true);
					}
					if(i==1) {
						textArrivoP2.setEnabled(true);
						textArrivoP2.setEditable(true);
						textArrivoP2.setText(String.valueOf(value));
						textArrivoP2.setVisible(true);
					}
					if(i==2) {
						textArrivoP3.setEnabled(true);
						textArrivoP3.setEditable(true);
						textArrivoP3.setText(String.valueOf(value));
						textArrivoP3.setVisible(true);
					}
					if(i==3) {
						textArrivoP4.setEnabled(true);
						textArrivoP4.setEditable(true);
						textArrivoP4.setText(String.valueOf(value));
						textArrivoP4.setVisible(true);
					}
					if(i==4) {
						textArrivoP5.setEnabled(true);
						textArrivoP5.setEditable(true);
						textArrivoP5.setText(String.valueOf(value));	
						textArrivoP5.setVisible(true);
					}
					if(i==5) {
						textArrivoP6.setEnabled(true);
						textArrivoP6.setEditable(true);
						textArrivoP6.setText(String.valueOf(value));
						textArrivoP6.setVisible(true);
					}
					
					int value2 = random.nextInt(15 + 0) + 0;
					
					if(i==0) {
						textDurataP1.setEnabled(true);
						textDurataP1.setEditable(true);
						textDurataP1.setText(String.valueOf(value2));
						textDurataP1.setVisible(true);
					}
					if(i==1) {
						textDurataP2.setEnabled(true);
						textDurataP2.setEditable(true);
						textDurataP2.setText(String.valueOf(value2));	
						textDurataP2.setVisible(true);
					}
					if(i==2) {
						textDurataP3.setEnabled(true);
						textDurataP3.setEditable(true);
						textDurataP3.setText(String.valueOf(value2));
						textDurataP3.setVisible(true);
					}
					if(i==3) {
						textDurataP4.setEnabled(true);
						textDurataP4.setEditable(true);
						textDurataP4.setText(String.valueOf(value2));
						textDurataP4.setVisible(true);
					}
					if(i==4) {
						textDurataP5.setEnabled(true);
						textDurataP5.setEditable(true);
						textDurataP5.setText(String.valueOf(value2));	
						textDurataP5.setVisible(true);
					}
					if(i==5) {
						textDurataP6.setEnabled(true);
						textDurataP6.setEditable(true);
						textDurataP6.setText(String.valueOf(value2));
						textDurataP6.setVisible(true);
					}
				}
			}
		});

	//EVENTO SU BOTTONE PLAY
		labelMostraSoluzioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jPanelFCFS.disegnaGriglia(jPanelFCFS.getGraphics(), chckbxGriglia.isSelected());
				jPanelSJF.disegnaGriglia(jPanelSJF.getGraphics(), chckbxGriglia.isSelected());
				jPanelSJFP.disegnaGriglia(jPanelSJFP.getGraphics(), chckbxGriglia.isSelected());
				jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
				labelDatoTAMFCFS.setText("");
				labelDatoTAMSJF.setText("");
				labelDatoTAMSJFP.setText("");
				labelDatoTAMRR.setText("");
				labelCDCFCFS.setText("");
				labelCDCSJF.setText("");
				labelCDCSJFP.setText("");
				labelCDCRR.setText("");

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
				
				labelMostraSoluzioni.setEnabled(true);
				comboBoxQRR.setEnabled(true);
				int numeroFor= Integer.valueOf(comboBoxSceltaNProcessi.getSelectedItem().toString());
				for(int i=0;i<numeroFor;i++) {
					if(i==0) {
							
							CreaLinee punto=new CreaLinee(1,Integer.valueOf( textArrivoP1.getText()));
							CreaLinee linea=new CreaLinee(1,Integer.valueOf( textArrivoP1.getText()),Integer.valueOf( textDurataP1.getText()));

							arrayPunti.add(punto);
							arrayLinea.add(linea);
					}
					
					if(i==1) {
							CreaLinee punto=new CreaLinee(2,Integer.valueOf( textArrivoP2.getText()));
							CreaLinee linea=new CreaLinee(2,Integer.valueOf( textArrivoP2.getText()),Integer.valueOf( textDurataP2.getText()));

							arrayPunti.add(punto);
							arrayLinea.add(linea);
					}
					
					if(i==2) {
							CreaLinee punto=new CreaLinee(3,Integer.valueOf( textArrivoP3.getText()));
							CreaLinee linea=new CreaLinee(3,Integer.valueOf( textArrivoP3.getText()),Integer.valueOf( textDurataP3.getText()));

							arrayPunti.add(punto);
							arrayLinea.add(linea);
					}
					
					if(i==3) {
							CreaLinee punto=new CreaLinee(4,Integer.valueOf( textArrivoP4.getText()));
							CreaLinee linea=new CreaLinee(4,Integer.valueOf( textArrivoP4.getText()),Integer.valueOf( textDurataP4.getText()));

							arrayPunti.add(punto);
							arrayLinea.add(linea);
					}
					
					if(i==4) {
							CreaLinee punto=new CreaLinee(5,Integer.valueOf( textArrivoP5.getText()));
							CreaLinee linea=new CreaLinee(5,Integer.valueOf( textArrivoP5.getText()),Integer.valueOf( textDurataP5.getText()));

							arrayPunti.add(punto);
							arrayLinea.add(linea);
					}
					
					if(i==5) {
							CreaLinee punto=new CreaLinee(6,Integer.valueOf( textArrivoP6.getText()));
							CreaLinee linea=new CreaLinee(6,Integer.valueOf( textArrivoP6.getText()),Integer.valueOf( textDurataP6.getText()));

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
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelMostraSoluzioni.setBackground(new Color (0, 200, 83));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelMostraSoluzioni.setBackground(Color.white);
			}
		});
	//EVENTO CAMBIO QUANTUM RR

		comboBoxQRR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				CreaLinee[] linea = new CreaLinee[arrayLinea.size()];

				for(int l=0;l<arrayLinea.size();l++) {  
						
					linea[l]=arrayLinea.get(l);

				}

				Arrays.sort(linea);
				String qua= (String) comboBoxQRR.getSelectedItem();
				quantum=Integer.valueOf(qua);
				RR=RRClass(linea);
				if(chckbxMostraSoluzioneRR.isSelected()==true) {
					jPanelRR.disegnaGriglia(jPanelRR.getGraphics(), chckbxGriglia.isSelected());
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
	//EVENTO MOSTRA SOLUZIONE PASSO PASSO
		labelFastForwardPiu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		

	//EVENTO SU CHECKBOX GRIGLIA
		chckbxGriglia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
	
	
//EVENTI SULLA TABELLA

		//P1
		textArrivoP1.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textArrivoP1.getText().equals("")) {
					textArrivoP1.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textArrivoP1.getText())>15 || Integer.valueOf( textArrivoP1.getText())<0) {
					textArrivoP1.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textArrivoP1.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textArrivoP1.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
		//P2
		textArrivoP2.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textArrivoP2.getText().equals("")) {
					textArrivoP2.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textArrivoP2.getText())>15 || Integer.valueOf( textArrivoP2.getText())<0) {
					textArrivoP2.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textArrivoP2.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textArrivoP2.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
		//P3
		textArrivoP3.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textArrivoP3.getText().equals("")) {
					textArrivoP3.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textArrivoP3.getText())>15 || Integer.valueOf( textArrivoP3.getText())<0) {
					textArrivoP3.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textArrivoP3.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textArrivoP3.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
		//P4
		textArrivoP4.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textArrivoP4.getText().equals("")) {
					textArrivoP4.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textArrivoP4.getText())>15 || Integer.valueOf( textArrivoP4.getText())<0) {
					textArrivoP4.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textArrivoP4.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textArrivoP4.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
		//P5
		textArrivoP5.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textArrivoP5.getText().equals("")) {
					textArrivoP5.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textArrivoP5.getText())>15 || Integer.valueOf( textArrivoP5.getText())<0) {
					textArrivoP5.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textArrivoP5.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textArrivoP5.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
		//P6
		textArrivoP6.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textArrivoP6.getText().equals("")) {
					textArrivoP6.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textArrivoP6.getText())>15 || Integer.valueOf( textArrivoP6.getText())<0) {
					textArrivoP6.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textArrivoP6.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textArrivoP6.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
		//P1
		textDurataP1.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textDurataP1.getText().equals("")) {
					textDurataP1.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textDurataP1.getText())>15 || Integer.valueOf( textDurataP1.getText())<0) {
					textDurataP1.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textDurataP1.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textDurataP1.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
		//P2
		textDurataP2.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textDurataP2.getText().equals("")) {
					textDurataP2.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textDurataP2.getText())>15 || Integer.valueOf( textDurataP2.getText())<0) {
					textDurataP2.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textDurataP2.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textDurataP2.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
		//P3
		textDurataP3.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textDurataP3.getText().equals("")) {
					textDurataP3.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textDurataP3.getText())>15 || Integer.valueOf( textDurataP3.getText())<0) {
					textDurataP3.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textDurataP3.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textDurataP3.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
		//P4
		textDurataP4.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textDurataP4.getText().equals("")) {
					textDurataP4.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textDurataP4.getText())>15 || Integer.valueOf( textDurataP4.getText())<0) {
					textDurataP4.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textDurataP4.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textDurataP4.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
		//P5
		textDurataP5.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textDurataP5.getText().equals("")) {
					textDurataP5.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textDurataP5.getText())>15 || Integer.valueOf( textDurataP5.getText())<0) {
					textDurataP5.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textDurataP5.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textDurataP5.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
		//P6
		textDurataP6.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textDurataP6.getText().equals("")) {
					textDurataP6.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}
				else if(Integer.valueOf( textDurataP6.getText())>15 || Integer.valueOf( textDurataP6.getText())<0) {
					textDurataP6.setBackground(Color.red);
					labelMostraSoluzioni.setEnabled(false);
				}else {
					textDurataP6.setBackground(new Color(255,255,255));
					labelMostraSoluzioni.setEnabled(true);
				}
				
			}
		});
		textDurataP6.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
	                  e.consume();  //Ignora l'evento
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
		@SuppressWarnings("unused")
		int temp;
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
		float avgwt=0, avgta=0;
	 
		for(int i=0;i<n;i++){
			at[i] = lineaSJF[i].getArrivo();
			bt[i] = lineaSJF[i].getDurata();
			pid[i] = lineaSJF[i].getProcesso();
			f[i] = 0;
		}
	
		@SuppressWarnings("unused")
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
	        cambio++;
	        punti.add(i);
	        punti.add(sel_proc);
	        
	       }
	      }
	      else{//If the current time is 0 i.e the printing has just started we need to print the name of the First selected Process
	       punti.add(i);
	        punti.add(sel_proc);
	      }
	      if(i == total_time - 1){//All the process names have been printed now we have to print the time at which execution ends
	       punti.add(i+1);
	      }
	     }

	     
	     //Printing the WT and TT for each Process
	     
	     
	     //Printing the average WT & TT
	     @SuppressWarnings("unused")
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
	    
	     cbSJFP=cambio-1;
	     averageSJFP=WT;
	     return puntiArray;
	 }
	    
//METODO PER CALCOLARE RR
	public ArrayList<Integer> RRClass(CreaLinee[] lineaRR){
		
		int pro=lineaRR.length,cambio=0;
		@SuppressWarnings("unused")
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
}
