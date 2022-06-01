package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JCheckBox;

import model.PanelGraficiSchHD;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SchHD extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private int[]successione=new int[0];
	
	private int[]numeriFCFS=new int[0];
	private int distanzaFCFS;
	
	private int[]numeriSSTF=new int[0];
	private int distanzaSSTF;
	
	private int[]numeriSCAN=new int[0];
	private int distanzaSCAN;
	
	private int[]numeriCSCAN=new int[0];
	private int distanzaCSCAN;
	
	private int[]numeriLOOK=new int[0];
	private int distanzaLOOK;
	
	private int[]numeriCLOOK=new int[0];
	private int distanzaCLOOK;

	int flag=0;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SchHD(JFrame framechiamante) 
	{
		frame=this;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 0, 1440, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Operating Systems Simulator: Scheduling HD");

		JPanel panelMainButton = new JPanel();
			panelMainButton.setForeground(new Color(153, 204, 255));
			panelMainButton.setBounds(0, 0, 1440, 800);
			frame.getContentPane().add(panelMainButton);
			panelMainButton.setLayout(null);
			
		JPanel pannelloTitolo = new JPanel();
			pannelloTitolo.setLayout(null);
			pannelloTitolo.setBorder(new LineBorder(new Color(0, 151, 167), 7));
			pannelloTitolo.setBounds(0, 0, 1414, 73);
			panelMainButton.add(pannelloTitolo);
			
		JLabel labelSchedulingHardDisk = new JLabel("SCHEDULING HARD DISK");
			labelSchedulingHardDisk.setFont(new Font("Segoe UI", Font.BOLD, 48));
			labelSchedulingHardDisk.setBounds(408, 0, 608, 73);
			pannelloTitolo.add(labelSchedulingHardDisk);

		JLabel labelFedericoII = new JLabel("");
			labelFedericoII.setIcon(new ImageIcon(SchHD.class.getResource("/img/logoUninaIcon2.png")));
			labelFedericoII.setBounds(1215, 11, 199, 53);
			pannelloTitolo.add(labelFedericoII);
			
		JPanel pannelloControllo = new JPanel();
			pannelloControllo.setLayout(null);
			pannelloControllo.setBounds(1130, 81, 274, 670);
			panelMainButton.add(pannelloControllo);
			
		JLabel labelgenerale = new JLabel("Parametri :");
			labelgenerale.setVerticalAlignment(SwingConstants.BOTTOM);
			labelgenerale.setForeground(Color.RED);
			labelgenerale.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelgenerale.setBounds(86, 80, 114, 26);
			pannelloControllo.add(labelgenerale);
			
		JPanel pannelloParametri = new JPanel();
			pannelloParametri.setLayout(null);
			pannelloParametri.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
			pannelloParametri.setBounds(10, 107, 254, 265);
			pannelloControllo.add(pannelloParametri);
			
		JButton btnGeneraEsercizio = new JButton("GENERA ESERCIZIO");
			btnGeneraEsercizio.setFont(new Font("Arial", Font.BOLD, 15));
			btnGeneraEsercizio.setBorder(new LineBorder(new Color (0, 151, 167), 2, true));
			btnGeneraEsercizio.setBackground(Color.WHITE);
			btnGeneraEsercizio.setBounds(16, 160, 224, 34);
			pannelloParametri.add(btnGeneraEsercizio);
			
		JComboBox comboBoxSceltaNCilindri = new JComboBox();
			comboBoxSceltaNCilindri.setModel(new DefaultComboBoxModel(new String[] {"50", "100", "200", "400", "500", "600", "800", "1000"}));
			comboBoxSceltaNCilindri.setSelectedIndex(2);
			comboBoxSceltaNCilindri.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			comboBoxSceltaNCilindri.setBackground(Color.WHITE);
			comboBoxSceltaNCilindri.setBounds(166, 125, 74, 22);
			pannelloParametri.add(comboBoxSceltaNCilindri);
			
		JLabel labelPosizione = new JLabel("Numero Cilindri  :");
			labelPosizione.setFont(new Font("Segoe UI", Font.BOLD, 14));
			labelPosizione.setBounds(16, 125, 140, 22);
			pannelloParametri.add(labelPosizione);
		
		JLabel labelMostraSoluzioni = new JLabel("");
			labelMostraSoluzioni.setEnabled(false);
			labelMostraSoluzioni.setHorizontalAlignment(SwingConstants.CENTER);
			labelMostraSoluzioni.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			labelMostraSoluzioni.setBounds(90, 210, 79, 35);
			labelMostraSoluzioni.setBackground(new Color(255, 255, 255));
			//btnMostraSoluzioni.setBorder(new LineBorder(Color.black, 2));
			labelMostraSoluzioni.setIcon(new ImageIcon(PaginazioneDellaMemoria.class.getResource("/img/playIcon2.png")));
			pannelloParametri.add(labelMostraSoluzioni);
			
		JLabel labelFastForwardPiu = new JLabel("");
			labelFastForwardPiu.setHorizontalAlignment(SwingConstants.CENTER);
			labelFastForwardPiu.setEnabled(false);
			labelFastForwardPiu.setBackground(new Color(255, 255, 255));
			//btnFastForwardPiu.setBorder(new LineBorder(Color.black,2));
			labelFastForwardPiu.setIcon(new ImageIcon(Hashing.class.getResource("/img/fastFowardIcon1.png")));
			labelFastForwardPiu.setFont(new Font("Segoe UI", Font.PLAIN, 25));
			labelFastForwardPiu.setBounds(179, 210, 52, 35);
			pannelloParametri.add(labelFastForwardPiu);
			
		JLabel labelFastForwardMeno = new JLabel("");
			labelFastForwardMeno.setHorizontalAlignment(SwingConstants.CENTER);
			labelFastForwardMeno.setFont(new Font("Segoe UI", Font.PLAIN, 25));
			labelFastForwardMeno.setEnabled(false);
			labelFastForwardMeno.setBounds(24, 210, 52, 35);
			labelFastForwardMeno.setBackground(new Color(255, 255, 255));
			//btnFastForwardMeno.setBorder(new LineBorder(Color.black,2));
			labelFastForwardMeno.setIcon(new ImageIcon(SchProcessi.class.getResource("/img/fastFowardIconRovescio.png")));
			pannelloParametri.add(labelFastForwardMeno);
			
		JTextField textFieldRichieste = new JTextField();
			textFieldRichieste.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldRichieste.setFont(new Font("Arial", Font.BOLD, 12));
			textFieldRichieste.setColumns(10);
			textFieldRichieste.setBackground(Color.WHITE);
			textFieldRichieste.setBounds(10, 71, 234, 23);
			pannelloParametri.add(textFieldRichieste);
		
		JLabel labelCodaRichieste = new JLabel("Coda delle Richieste");
			labelCodaRichieste.setHorizontalAlignment(SwingConstants.CENTER);
			labelCodaRichieste.setForeground(Color.BLACK);
			labelCodaRichieste.setFont(new Font("Arial", Font.BOLD, 14));
			labelCodaRichieste.setBounds(10, 44, 230, 23);
			pannelloParametri.add(labelCodaRichieste);
			
		JLabel labelPosizioneInziale = new JLabel("Posizione iniziale testina : ");
			labelPosizioneInziale.setFont(new Font("Segoe UI", Font.BOLD, 14));
			labelPosizioneInziale.setBounds(10, 11, 183, 22);
			pannelloParametri.add(labelPosizioneInziale);
			
		JTextField textFieldInzialeTestina = new JTextField();
			textFieldInzialeTestina.setFont(new Font("Arial", Font.PLAIN, 15));
			textFieldInzialeTestina.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldInzialeTestina.setText("0");
			textFieldInzialeTestina.setBounds(188, 13, 52, 20);
			pannelloParametri.add(textFieldInzialeTestina);
			textFieldInzialeTestina.setColumns(10);
			
		JLabel labelMessaggioErrore = new JLabel("");
			labelMessaggioErrore.setForeground(Color.RED);
			labelMessaggioErrore.setFont(new Font("Arial", Font.PLAIN, 12));
			labelMessaggioErrore.setBounds(10, 100, 230, 23);
			pannelloParametri.add(labelMessaggioErrore);
			
		JLabel labelPnlCtrl = new JLabel("Pannello di controllo");
			labelPnlCtrl.setHorizontalAlignment(SwingConstants.CENTER);
			labelPnlCtrl.setFont(new Font("Arial", Font.BOLD, 22));
			labelPnlCtrl.setBorder(new LineBorder(new Color (0, 151, 167), 2));
			labelPnlCtrl.setBounds(14, 11, 245, 54);
			pannelloControllo.add(labelPnlCtrl);
		
		JPanel pannelloHelp = new JPanel();
			pannelloHelp.setLayout(null);
			pannelloHelp.setBounds(20, 405, 245, 254);
			pannelloControllo.add(pannelloHelp);
			
		JScrollPane scrollPaneHelp = new JScrollPane();
			scrollPaneHelp.setBounds(0, 0, 245, 255);
			pannelloHelp.add(scrollPaneHelp);
		
		JTextArea txtrHelpArea = new JTextArea();
			scrollPaneHelp.setViewportView(txtrHelpArea);
			txtrHelpArea.setWrapStyleWord(true);
			txtrHelpArea.setLineWrap(true);
			txtrHelpArea.setText("FCFS (First Come First Served)\r\nSceglie la richiesta arrivata per prima; \u00E8 naturalmente l'algoritmo pi\u00F9 semplice ma non garantisce la massima velocit\u00E0 del sercizio.\r\n\r\nSSTF (Shortest Seek Time First)\r\nSeleziona la richiesta con il minor tempo di ricerca rispetto all'attuale posizione della testina.\r\n\r\nSCAN (Scansione)\r\nSecondo l'algoritmo SCAN il braccio dell'unit\u00E0 a disco parte da un estremo del disco e si sposta nella sola direzione possibile, servendo le richieste mentre attraversa i cilindri, fino a che non giunge all'altro estremo del disco: a questo punto, il braccio inverte la marcia, e la\r\nprocedura continua.\r\nL'algoritmo SCAN \u00E8 a volte chiamato algoritmo dell'ascensore, perch\u00E9 il braccio dell'unit\u00E0 a disco si comporta proprio come un ascensore che serve prima tutte le richieste in salita e poi tutte quelle in discesa.\r\n");
			txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
			txtrHelpArea.setCaretPosition(0);
			txtrHelpArea.setEditable(false);
		
		JLabel labelHelp = new JLabel("Spiegazione Argomento");
			labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
			labelHelp.setForeground(Color.RED);
			labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelHelp.setBounds(20, 381, 245, 25);
			pannelloControllo.add(labelHelp);
			
		JLabel labelIndietroIcon = new JLabel("");
			  labelIndietroIcon.addMouseListener(new MouseAdapter() {
		        	@Override
					public void mouseClicked(MouseEvent e) 
					{	
						framechiamante.setVisible(true);
						frame.setVisible(false);
						frame.dispose();
					}
			  });
			labelIndietroIcon.setIcon(new ImageIcon(SchHD.class.getResource("/img/back-button.png")));
			labelIndietroIcon.setBounds(10, 78, 53, 46);
			panelMainButton.add(labelIndietroIcon);

		JLabel labelScrittaYoutube = new JLabel("Lezione");
			labelScrittaYoutube.setHorizontalAlignment(SwingConstants.CENTER);
			labelScrittaYoutube.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelScrittaYoutube.setBounds(80, 120, 50, 12);
			panelMainButton.add(labelScrittaYoutube);
		
		JLabel labelYoutubeIcon = new JLabel("");
			labelYoutubeIcon.setHorizontalAlignment(SwingConstants.CENTER);
			labelYoutubeIcon.setIcon(new ImageIcon(SchHD.class.getResource("/img/youtubeIcon2.png")));
			labelYoutubeIcon.setBounds(80, 75, 47, 46);
			panelMainButton.add(labelYoutubeIcon);
			labelYoutubeIcon.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI ("https://youtu.be/-EfXe93K_3E?t=2580"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
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
			
		JLabel labelScrittaSlide = new JLabel("Slide");
			labelScrittaSlide.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelScrittaSlide.setBounds(162, 119, 40, 15);
			panelMainButton.add(labelScrittaSlide);
			
		JLabel labelSlideIcon = new JLabel("");
			labelSlideIcon.setIcon(new ImageIcon(SchHD.class.getResource("/img/pdfIcon1.png")));
			labelSlideIcon.setBounds(150, 75, 53, 46);
			panelMainButton.add(labelSlideIcon);
			
/*----------------------------GRAFICI---------------------------*/
	//GRAFICI
		JPanel pannelloGrafici = new JPanel();
			pannelloGrafici.setLayout(null);
			pannelloGrafici.setBounds(0, 136, 1131, 628);
			panelMainButton.add(pannelloGrafici);
			
	//PANNELLO FCFS
		JPanel pannelloFCFS = new JPanel();
					pannelloFCFS.setLayout(null);
					pannelloFCFS.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloFCFS.setBounds(7, 5, 1121, 150);
					pannelloGrafici.add(pannelloFCFS);
				
				JLabel labelFirstcomeFirstserved = new JLabel("FCFS");
					labelFirstcomeFirstserved.setHorizontalAlignment(SwingConstants.CENTER);
					labelFirstcomeFirstserved.setForeground(Color.RED);
					labelFirstcomeFirstserved.setFont(new Font("Tahoma", Font.PLAIN, 25));
					labelFirstcomeFirstserved.setBounds(0, 0, 107, 25);
					pannelloFCFS.add(labelFirstcomeFirstserved);
					
				JLabel labelDistanzaTotaleFCFS = new JLabel("Distanza totale:");
					labelDistanzaTotaleFCFS.setHorizontalAlignment(SwingConstants.CENTER);
					labelDistanzaTotaleFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDistanzaTotaleFCFS.setBounds(0, 35, 107, 25);
					pannelloFCFS.add(labelDistanzaTotaleFCFS);
				
				JLabel labelDatoDistanzaFCFS = new JLabel("");
					labelDatoDistanzaFCFS.setHorizontalAlignment(SwingConstants.CENTER);
					labelDatoDistanzaFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					labelDatoDistanzaFCFS.setBounds(0, 70, 107, 25);
					pannelloFCFS.add(labelDatoDistanzaFCFS);
				
				PanelGraficiSchHD jPanelFCFS = new PanelGraficiSchHD();
					jPanelFCFS.setLayout(null);
					jPanelFCFS.setBounds(117, 0, 1000, 145);
					pannelloFCFS.add(jPanelFCFS);
			
	//PANNELLO SSTF
		JPanel pannelloSSTF = new JPanel();
					pannelloSSTF.setLayout(null);
					pannelloSSTF.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloSSTF.setBounds(7, 158, 1121, 150);
					pannelloGrafici.add(pannelloSSTF);
				
				JLabel labelShortestSeekTime = new JLabel("SSTF");
					labelShortestSeekTime.setHorizontalAlignment(SwingConstants.CENTER);
					labelShortestSeekTime.setForeground(Color.RED);
					labelShortestSeekTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
					labelShortestSeekTime.setBounds(0, 0, 107, 25);
					pannelloSSTF.add(labelShortestSeekTime);
				
				JLabel labelDistanzaTotaleSSTF = new JLabel("Distanza totale:");
					labelDistanzaTotaleSSTF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDistanzaTotaleSSTF.setBounds(0, 35, 107, 25);
					pannelloSSTF.add(labelDistanzaTotaleSSTF);
					
				JLabel labelDatoDistanzaSSTF = new JLabel("");
					labelDatoDistanzaSSTF.setHorizontalAlignment(SwingConstants.CENTER);
					labelDatoDistanzaSSTF.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					labelDatoDistanzaSSTF.setBounds(0, 70, 107, 25);
					pannelloSSTF.add(labelDatoDistanzaSSTF);
				
				PanelGraficiSchHD jPanelSSFT = new PanelGraficiSchHD();
					jPanelSSFT.setLayout(null);
					jPanelSSFT.setBounds(117, 0, 1000, 145);
					pannelloSSTF.add(jPanelSSFT);
					
	//PANNELLO SCAN
		JPanel pannelloSCAN = new JPanel();
					pannelloSCAN.setLayout(null);
					pannelloSCAN.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloSCAN.setBounds(7, 311, 1121, 150);
					pannelloGrafici.add(pannelloSCAN);
				
				JLabel labelSCAN = new JLabel("SCAN");
					labelSCAN.setHorizontalAlignment(SwingConstants.CENTER);
					labelSCAN.setForeground(Color.RED);
					labelSCAN.setFont(new Font("Tahoma", Font.PLAIN, 20));
					labelSCAN.setBounds(0, 0, 107, 25);
					pannelloSCAN.add(labelSCAN);
				
				JLabel labelDistanzaTotaleSCAN = new JLabel("Distanza totale:");
					labelDistanzaTotaleSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDistanzaTotaleSCAN.setBounds(0, 35, 107, 25);
					pannelloSCAN.add(labelDistanzaTotaleSCAN);
				
				JLabel labelDatoDistanzaSCAN = new JLabel("");
					labelDatoDistanzaSCAN.setHorizontalAlignment(SwingConstants.CENTER);
					labelDatoDistanzaSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					labelDatoDistanzaSCAN.setBounds(0, 65, 107, 25);
					pannelloSCAN.add(labelDatoDistanzaSCAN);
					
				PanelGraficiSchHD jPanelSCAN = new PanelGraficiSchHD();
					jPanelSCAN.setLayout(null);
					jPanelSCAN.setBounds(117, 0, 1000, 145);
					pannelloSCAN.add(jPanelSCAN);
					
				JCheckBox chckbxSCAN = new JCheckBox("C-SCAN");
					chckbxSCAN.setEnabled(false);
					chckbxSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					chckbxSCAN.setBounds(0, 95, 98, 21);
					pannelloSCAN.add(chckbxSCAN);
					
				JLabel labelDirezioneSCAN = new JLabel("direzione");
					labelDirezioneSCAN.setHorizontalAlignment(SwingConstants.CENTER);
					labelDirezioneSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDirezioneSCAN.setBounds(24, 120, 67, 25);
					pannelloSCAN.add(labelDirezioneSCAN);
					
				JRadioButton rdbtnDestraSCAN = new JRadioButton("");
					rdbtnDestraSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					rdbtnDestraSCAN.setEnabled(false);
					rdbtnDestraSCAN.setBounds(90, 120, 23, 21);
					pannelloSCAN.add(rdbtnDestraSCAN);
					
				JRadioButton rdbtnSinistraSCAN = new JRadioButton("");
					rdbtnSinistraSCAN.setSelected(true);
					rdbtnSinistraSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					rdbtnSinistraSCAN.setEnabled(false);
					rdbtnSinistraSCAN.setBounds(0, 120, 23, 21);
					pannelloSCAN.add(rdbtnSinistraSCAN);
			
	//PANNELLO LOOK
		JPanel pannelloLOOK = new JPanel();
					pannelloLOOK.setLayout(null);
					pannelloLOOK.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloLOOK.setBounds(7, 464, 1121, 150);
					pannelloGrafici.add(pannelloLOOK);
					
				JLabel labelLOOK = new JLabel("LOOK");
					labelLOOK.setHorizontalAlignment(SwingConstants.CENTER);
					labelLOOK.setForeground(Color.RED);
					labelLOOK.setFont(new Font("Tahoma", Font.PLAIN, 20));
					labelLOOK.setBounds(0, 0, 107, 25);
					pannelloLOOK.add(labelLOOK);
					
				JLabel labelDistanzaTotaleLOOK = new JLabel("Distanza totale:");
					labelDistanzaTotaleLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDistanzaTotaleLOOK.setBounds(0, 35, 107, 25);
					pannelloLOOK.add(labelDistanzaTotaleLOOK);
					
				JLabel labelDatoDistanzaLOOK = new JLabel("");
					labelDatoDistanzaLOOK.setHorizontalAlignment(SwingConstants.CENTER);
					labelDatoDistanzaLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					labelDatoDistanzaLOOK.setBounds(0, 65, 107, 25);
					pannelloLOOK.add(labelDatoDistanzaLOOK);
					
				PanelGraficiSchHD jPanelLOOK = new PanelGraficiSchHD();
					jPanelLOOK.setLayout(null);
					jPanelLOOK.setBounds(117, 0, 1000, 145);
					pannelloLOOK.add(jPanelLOOK);
					
				JCheckBox chckbxLOOK = new JCheckBox("C-LOOK");
					chckbxLOOK.setEnabled(false);
					chckbxLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					chckbxLOOK.setBounds(0, 95, 98, 20);
					pannelloLOOK.add(chckbxLOOK);
					
				JLabel labelDirezioneLOOK = new JLabel("direzione");
					labelDirezioneLOOK.setHorizontalAlignment(SwingConstants.CENTER);
					labelDirezioneLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDirezioneLOOK.setBounds(24, 120, 67, 25);
					pannelloLOOK.add(labelDirezioneLOOK);
					
				JRadioButton rdbtnDestraLOOK = new JRadioButton("");
					rdbtnDestraLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					rdbtnDestraLOOK.setEnabled(false);
					rdbtnDestraLOOK.setBounds(90, 120, 23, 21);
					pannelloLOOK.add(rdbtnDestraLOOK);
					
				JRadioButton rdbtnSinistraLOOK = new JRadioButton("");
					rdbtnSinistraLOOK.setSelected(true);
					rdbtnSinistraLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					rdbtnSinistraLOOK.setEnabled(false);
					rdbtnSinistraLOOK.setBounds(0, 120, 23, 21);
					pannelloLOOK.add(rdbtnSinistraLOOK);
					
/**--------------------------------IMPLEMENTAZIONE EVENTI-------------------------------------------*/
			
	//EVENTO BOTTONE GENERA ESERCIZIO
		btnGeneraEsercizio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jPanelFCFS.resetGrafico(jPanelFCFS.getGraphics());
				jPanelSSFT.resetGrafico(jPanelSSFT.getGraphics());
				jPanelSCAN.resetGrafico(jPanelSCAN.getGraphics());
				jPanelLOOK.resetGrafico(jPanelLOOK.getGraphics());
				textFieldRichieste.setBackground(Color.WHITE);
				labelMessaggioErrore.setText("");
				labelFastForwardMeno.setEnabled(true);
				labelFastForwardPiu.setEnabled(true);
				labelMostraSoluzioni.setEnabled(true);

				chckbxSCAN.setEnabled(false);
				chckbxLOOK.setEnabled(false);
				rdbtnDestraLOOK.setEnabled(false);
				rdbtnDestraSCAN.setEnabled(false);
				rdbtnSinistraLOOK.setEnabled(false);
				rdbtnSinistraSCAN.setEnabled(false);
				
				labelDatoDistanzaFCFS.setText("");
				labelDatoDistanzaLOOK.setText("");
				labelDatoDistanzaSCAN.setText("");
				labelDatoDistanzaSSTF.setText("");
				
				successione=new int[10];
				Random random = new Random();
/*				int ncilindri = random.nextInt(7 + 0) + 0;
				comboBoxSceltaNCilindri.setSelectedIndex(ncilindri);
*/				
				int position = random.nextInt(Integer.valueOf(String.valueOf(comboBoxSceltaNCilindri.getSelectedItem()))+0) + 0;
				textFieldInzialeTestina.setText(String.valueOf(position));
				
				int numero=Integer.valueOf(String.valueOf(comboBoxSceltaNCilindri.getSelectedItem()));
				for (int i=0;i<10;i++) { 
					int value = random.nextInt(numero + 0) + 0;
					if(i==0)textFieldRichieste.setText(String.valueOf(value));
					else textFieldRichieste.setText(textFieldRichieste.getText()+"-"+value);
					successione[i]=value;
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btnGeneraEsercizio.setBackground(new Color (0, 151, 167));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGeneraEsercizio.setBackground(Color.WHITE);
			}
		});
					
	//EVENTO SUI BOTTONI PLAY 
		labelMostraSoluzioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				if(labelMostraSoluzioni.isEnabled()) {
					jPanelFCFS.resetGrafico(jPanelFCFS.getGraphics());
					jPanelSSFT.resetGrafico(jPanelSSFT.getGraphics());
					jPanelLOOK.resetGrafico(jPanelLOOK.getGraphics());
					jPanelSCAN.resetGrafico(jPanelSCAN.getGraphics());
					textFieldRichieste.setBackground(Color.WHITE);
					labelMessaggioErrore.setText("");
					labelMostraSoluzioni.setEnabled(false);
					labelFastForwardMeno.setEnabled(false);
					labelFastForwardPiu.setEnabled(false);

					chckbxSCAN.setEnabled(true);
					chckbxLOOK.setEnabled(true);
					
					if(rdbtnDestraLOOK.isSelected())rdbtnDestraLOOK.setEnabled(false);
					else rdbtnDestraLOOK.setEnabled(true);
					
					if(rdbtnDestraSCAN.isSelected())rdbtnDestraSCAN.setEnabled(false);
					else rdbtnDestraSCAN.setEnabled(true);
					
					if(rdbtnSinistraLOOK.isSelected())rdbtnSinistraLOOK.setEnabled(false);
					else rdbtnSinistraLOOK.setEnabled(true);
					
					if(rdbtnSinistraSCAN.isSelected())rdbtnSinistraSCAN.setEnabled(false);
					else rdbtnSinistraSCAN.setEnabled(true);
					
					//GENERAZIONE MATRICI
					String j= textFieldInzialeTestina.getText().toString();
					int s=Integer.valueOf(j);

					String k= comboBoxSceltaNCilindri.getSelectedItem().toString();
					int nc=Integer.valueOf(k);
										
					numeriFCFS=FCFS(successione,s);
					numeriSSTF=SSTF(successione,s);
					String direzioneS = new String();
					String direzioneL = new String();
										
					if(rdbtnDestraSCAN.isSelected()) direzioneS="right";
					else if(rdbtnSinistraSCAN.isSelected())direzioneS="left";
					
					/*if(chckbxSCAN.isSelected())numeriCSCAN=CSCAN(successione,s,direzioneS,nc);
					else 
						*/
					numeriSCAN=SCAN(successione,s,direzioneS,nc);

					if(rdbtnDestraLOOK.isSelected()) direzioneL="right";
					else if(rdbtnSinistraLOOK.isSelected())direzioneL="left";
					
					/*if(chckbxLOOK.isSelected())numeriCLOOK=CLOOK(successione,s,direzioneL,nc);
					else 
						*/
					numeriLOOK=LOOK(successione,s,direzioneL,nc);

					labelDatoDistanzaFCFS.setText(String.valueOf(distanzaFCFS));
					jPanelFCFS.disegnaSoluzione(jPanelFCFS.getGraphics(),numeriFCFS,nc,distanzaFCFS,successione);
					
					labelDatoDistanzaSSTF.setText(String.valueOf(distanzaSSTF));
					jPanelSSFT.disegnaSoluzione(jPanelSSFT.getGraphics(),numeriSSTF,nc,distanzaSSTF,successione);
					
					if(chckbxLOOK.isSelected()) {
						labelDatoDistanzaLOOK.setText(String.valueOf(distanzaCLOOK));
						jPanelLOOK.disegnaSoluzione(jPanelLOOK.getGraphics(),numeriCLOOK,nc,distanzaCLOOK,successione);
					}else {
						labelDatoDistanzaLOOK.setText(String.valueOf(distanzaLOOK));
						jPanelLOOK.disegnaSoluzione(jPanelLOOK.getGraphics(),numeriLOOK,nc,distanzaLOOK,successione);
					}
					
					if(chckbxSCAN.isSelected()) {
						labelDatoDistanzaSCAN.setText(String.valueOf(distanzaCSCAN));
						jPanelSCAN.disegnaSoluzione(jPanelSCAN.getGraphics(),numeriCSCAN,nc,distanzaCSCAN,successione);
					}else {
						labelDatoDistanzaSCAN.setText(String.valueOf(distanzaSCAN));
						jPanelSCAN.disegnaSoluzione(jPanelSCAN.getGraphics(),numeriSCAN,nc,distanzaSCAN,successione);
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(labelMostraSoluzioni.isEnabled())
					labelMostraSoluzioni.setBackground(Color.red);
				}
			@Override
			public void mouseExited(MouseEvent e){
				
				labelMostraSoluzioni.setBackground(new Color(255, 255, 255));
			}
		});		

	//TESTINA INIZIALE
		textFieldInzialeTestina.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textFieldInzialeTestina.isEditable()){
					int diff=0;
					int count=0;
					if(successione.length>0) {
						for(int i=0;i<successione.length;i++) {
							if(successione[i]>Integer.valueOf(comboBoxSceltaNCilindri.getSelectedItem().toString())) diff=1;
						}
							
						if(textFieldInzialeTestina.getText().equals("")) {
							textFieldInzialeTestina.setBackground(Color.red);
							labelMostraSoluzioni.setEnabled(false);
							labelFastForwardMeno.setEnabled(false);
							labelFastForwardPiu.setEnabled(false);
							
							count++;
						}
						else if(Integer.valueOf( textFieldInzialeTestina.getText())>Integer.valueOf(comboBoxSceltaNCilindri.getSelectedItem().toString()) || Integer.valueOf(comboBoxSceltaNCilindri.getSelectedItem().toString())<0) {
							textFieldInzialeTestina.setBackground(Color.red);
							labelMostraSoluzioni.setEnabled(false);
							labelFastForwardMeno.setEnabled(false);
							labelFastForwardPiu.setEnabled(false);
							count++;
						}
						if(diff==1) {
							textFieldRichieste.setBackground(Color.red);
							labelMessaggioErrore.setText("ERRORE: Verificare coda delle richieste");
							labelMostraSoluzioni.setEnabled(false);
							labelFastForwardMeno.setEnabled(false);
							labelFastForwardPiu.setEnabled(false);
							count++;
						}
						if(count==0){
							textFieldInzialeTestina.setBackground(new Color(255,255,255));
							labelMostraSoluzioni.setEnabled(true);
							labelFastForwardMeno.setEnabled(true);
							labelFastForwardPiu.setEnabled(true);
							textFieldRichieste.setBackground(Color.white);
							labelMessaggioErrore.setText("");
						}	
					}
				}
			}
		});
		textFieldInzialeTestina.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9'))) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});

	//CAMBIAMENTO CILINDRI E VERIFICA TESTINA INIZIALE
		comboBoxSceltaNCilindri.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int diff=0;
				int count=0;
				if(successione.length>0) {
					for(int i=0;i<successione.length;i++) {
						if(successione[i]>Integer.valueOf(comboBoxSceltaNCilindri.getSelectedItem().toString())) diff=1;
					}
						
					if(textFieldInzialeTestina.getText().equals("")) {
						textFieldInzialeTestina.setBackground(Color.red);
						labelMostraSoluzioni.setEnabled(false);
						labelFastForwardMeno.setEnabled(false);
						labelFastForwardPiu.setEnabled(false);
						count++;
					}
					if(Integer.valueOf( textFieldInzialeTestina.getText())>Integer.valueOf(comboBoxSceltaNCilindri.getSelectedItem().toString()) || Integer.valueOf(comboBoxSceltaNCilindri.getSelectedItem().toString())<0) {
						textFieldInzialeTestina.setBackground(Color.red);
						labelMostraSoluzioni.setEnabled(false);
						labelFastForwardMeno.setEnabled(false);
						labelFastForwardPiu.setEnabled(false);
						count++;
					}
					if(diff==1) {
						textFieldRichieste.setBackground(Color.red);
						labelMessaggioErrore.setText("ERRORE: Verificare coda delle richieste");
						labelMostraSoluzioni.setEnabled(false);
						labelFastForwardMeno.setEnabled(false);
						labelFastForwardPiu.setEnabled(false);
						count++;
					}
					if(count==0){
						textFieldInzialeTestina.setBackground(new Color(255,255,255));
						labelMostraSoluzioni.setEnabled(true);
						labelFastForwardMeno.setEnabled(true);
						labelFastForwardPiu.setEnabled(true);
						textFieldRichieste.setBackground(Color.white);
						labelMessaggioErrore.setText("");
					}
				
				}
			}
		});
		
	//EVENTO SU MUOVERE TEXTFIELD CODA DELLE RICHIESTE
		textFieldRichieste.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if (c != KeyEvent.VK_HOME && c != KeyEvent.VK_END) {
	                  e.consume();  //Ignora l'evento
	             }   
			}
		});
		
	//EVENTI SUI BOTTONI DI DIREZIONE DI SCAN
		rdbtnSinistraSCAN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnSinistraSCAN.isSelected()) {
					rdbtnSinistraSCAN.setEnabled(false);
					rdbtnDestraSCAN.setSelected(false);
					rdbtnDestraSCAN.setEnabled(true);
					
					jPanelSCAN.resetGrafico(jPanelSCAN.getGraphics());
					
					String j= textFieldInzialeTestina.getText().toString();
					int s=Integer.valueOf(j);

					String k= comboBoxSceltaNCilindri.getSelectedItem().toString();
					int nc=Integer.valueOf(k);
					
					String direzioneS = new String();
					String direzioneL = new String();
										
					if(rdbtnDestraSCAN.isSelected()) direzioneS="right";
					else if(rdbtnSinistraSCAN.isSelected())direzioneS="left";
					
					/*if(chckbxSCAN.isSelected())numeriCSCAN=CSCAN(successione,s,direzioneS,nc);
					else 
						*/
					numeriSCAN=SCAN(successione,s,direzioneS,nc);

					if(chckbxSCAN.isSelected()) {
						labelDatoDistanzaSCAN.setText(String.valueOf(distanzaCSCAN));
						jPanelSCAN.disegnaSoluzione(jPanelSCAN.getGraphics(),numeriCSCAN,nc,distanzaCSCAN,successione);
					}else {
						labelDatoDistanzaSCAN.setText(String.valueOf(distanzaSCAN));
						jPanelSCAN.disegnaSoluzione(jPanelSCAN.getGraphics(),numeriSCAN,nc,distanzaSCAN,successione);
					}
				}
				
			}
		});
		rdbtnDestraSCAN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnDestraSCAN.isSelected()) {
					rdbtnDestraSCAN.setEnabled(false);
					rdbtnSinistraSCAN.setSelected(false);
					rdbtnSinistraSCAN.setEnabled(true);
					
					jPanelSCAN.resetGrafico(jPanelSCAN.getGraphics());
					labelDatoDistanzaSCAN.setText("");

					String j= textFieldInzialeTestina.getText().toString();
					int s=Integer.valueOf(j);

					String k= comboBoxSceltaNCilindri.getSelectedItem().toString();
					int nc=Integer.valueOf(k);
					
					String direzioneS = new String();
					String direzioneL = new String();
										
					if(rdbtnDestraSCAN.isSelected()) direzioneS="right";
					else if(rdbtnSinistraSCAN.isSelected())direzioneS="left";
					
					/*if(chckbxSCAN.isSelected())numeriCSCAN=CSCAN(successione,s,direzioneS,nc);
					else 
						*/
					numeriSCAN=SCAN(successione,s,direzioneS,nc);

					if(chckbxSCAN.isSelected()) {
						labelDatoDistanzaSCAN.setText(String.valueOf(distanzaCSCAN));
						jPanelSCAN.disegnaSoluzione(jPanelSCAN.getGraphics(),numeriCSCAN,nc,distanzaCSCAN,successione);
					}else {
						labelDatoDistanzaSCAN.setText(String.valueOf(distanzaSCAN));
						jPanelSCAN.disegnaSoluzione(jPanelSCAN.getGraphics(),numeriSCAN,nc,distanzaSCAN,successione);
					}
				}
			}
		});
		
	//EVENTI SUI BOTTONI DI DIREZIONE DI LOOK
		rdbtnSinistraLOOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnSinistraLOOK.isSelected()) {
					rdbtnSinistraLOOK.setEnabled(false);
					rdbtnDestraLOOK.setSelected(false);
					rdbtnDestraLOOK.setEnabled(true);
					
					jPanelLOOK.resetGrafico(jPanelLOOK.getGraphics());
					
					String j= textFieldInzialeTestina.getText().toString();
					int s=Integer.valueOf(j);

					String k= comboBoxSceltaNCilindri.getSelectedItem().toString();
					int nc=Integer.valueOf(k);
					
					String direzioneS = new String();
					String direzioneL = new String();
										
					if(rdbtnDestraLOOK.isSelected()) direzioneS="right";
					else if(rdbtnSinistraLOOK.isSelected())direzioneS="left";
					
					/*if(chckbxLOOK.isSelected())numeriCLOOK=CLOOK(successione,s,direzioneS,nc);
					else 
						*/
					numeriLOOK=LOOK(successione,s,direzioneS,nc);

					if(chckbxLOOK.isSelected()) {
						labelDatoDistanzaLOOK.setText(String.valueOf(distanzaCLOOK));
						jPanelLOOK.disegnaSoluzione(jPanelLOOK.getGraphics(),numeriCLOOK,nc,distanzaCLOOK,successione);
					}else {
						labelDatoDistanzaLOOK.setText(String.valueOf(distanzaLOOK));
						jPanelLOOK.disegnaSoluzione(jPanelLOOK.getGraphics(),numeriLOOK,nc,distanzaLOOK,successione);
					}
				}
				
			}
		});
		rdbtnDestraLOOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnDestraLOOK.isSelected()) {
					rdbtnDestraLOOK.setEnabled(false);
					rdbtnSinistraLOOK.setSelected(false);
					rdbtnSinistraLOOK.setEnabled(true);
					
					jPanelLOOK.resetGrafico(jPanelLOOK.getGraphics());
					labelDatoDistanzaLOOK.setText("");

					String j= textFieldInzialeTestina.getText().toString();
					int s=Integer.valueOf(j);

					String k= comboBoxSceltaNCilindri.getSelectedItem().toString();
					int nc=Integer.valueOf(k);
					
					String direzioneS = new String();
					String direzioneL = new String();
										
					if(rdbtnDestraLOOK.isSelected()) direzioneS="right";
					else if(rdbtnSinistraLOOK.isSelected())direzioneS="left";
					
					/*if(chckbxLOOK.isSelected())numeriCLOOK=CLOOK(successione,s,direzioneS,nc);
					else 
						*/
					numeriLOOK=LOOK(successione,s,direzioneS,nc);

					if(chckbxLOOK.isSelected()) {
						labelDatoDistanzaLOOK.setText(String.valueOf(distanzaCLOOK));
						jPanelLOOK.disegnaSoluzione(jPanelLOOK.getGraphics(),numeriCLOOK,nc,distanzaCLOOK,successione);
					}else {
						labelDatoDistanzaLOOK.setText(String.valueOf(distanzaLOOK));
						jPanelLOOK.disegnaSoluzione(jPanelLOOK.getGraphics(),numeriLOOK,nc,distanzaLOOK,successione);
					}
				}
			}
		});
		
	//EVENTO SUI BOTTONI PLAYSTEPbySTEP
		labelFastForwardPiu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
			
				if(labelFastForwardPiu.isEnabled()) {
					labelFastForwardMeno.setEnabled(true);
					labelMostraSoluzioni.setEnabled(true);
					
					textFieldRichieste.setBackground(Color.WHITE);
					labelMessaggioErrore.setText("");
					
					chckbxSCAN.setEnabled(true);
					chckbxLOOK.setEnabled(true);
					
					if(rdbtnDestraLOOK.isSelected())rdbtnDestraLOOK.setEnabled(false);
					else rdbtnDestraLOOK.setEnabled(true);
					
					if(rdbtnDestraSCAN.isSelected())rdbtnDestraSCAN.setEnabled(false);
					else rdbtnDestraSCAN.setEnabled(true);
					
					if(rdbtnSinistraLOOK.isSelected())rdbtnSinistraLOOK.setEnabled(false);
					else rdbtnSinistraLOOK.setEnabled(true);
					
					if(rdbtnSinistraSCAN.isSelected())rdbtnSinistraSCAN.setEnabled(false);
					else rdbtnSinistraSCAN.setEnabled(true);
					
					//GENERAZIONE MATRICI
					String j= textFieldInzialeTestina.getText().toString();
					int s=Integer.valueOf(j);

					String k= comboBoxSceltaNCilindri.getSelectedItem().toString();
					int nc=Integer.valueOf(k);
										
					numeriFCFS=FCFS(successione,s);
					numeriSSTF=SSTF(successione,s);
					String direzioneS = new String();
					String direzioneL = new String();
										
					if(rdbtnDestraSCAN.isSelected()) direzioneS="right";
					else if(rdbtnSinistraSCAN.isSelected())direzioneS="left";
					
					/*if(chckbxSCAN.isSelected())numeriCSCAN=CSCAN(successione,s,direzioneS,nc);
					else 
						*/
					numeriSCAN=SCAN(successione,s,direzioneS,nc);

					if(rdbtnDestraLOOK.isSelected()) direzioneL="right";
					else if(rdbtnSinistraLOOK.isSelected())direzioneL="left";
					
					/*if(chckbxLOOK.isSelected())numeriCLOOK=CLOOK(successione,s,direzioneL,nc);
					else 
						*/
					numeriLOOK=LOOK(successione,s,direzioneL,nc);
					
					flag++;
					
					if(flag<numeriFCFS.length) {
						int[] array=new int[flag];
						for(int i=0;i<flag;i++) {
							array[i]=numeriFCFS[i];
						}
						labelDatoDistanzaFCFS.setText(String.valueOf(distanzaFCFS));
						jPanelFCFS.disegnaSoluzione(jPanelFCFS.getGraphics(),array,nc,distanzaFCFS,successione);
					}
					
					if(flag<numeriSSTF.length) {
						int[] array=new int[flag];
						for(int i=0;i<flag;i++) {
							array[i]=numeriSSTF[i];
						}		
						labelDatoDistanzaSSTF.setText(String.valueOf(distanzaSSTF));
						jPanelSSFT.disegnaSoluzione(jPanelSSFT.getGraphics(),array,nc,distanzaSSTF,successione);
					}	
					
					if(chckbxLOOK.isSelected()) {
						if(flag<numeriCLOOK.length) {
							int[] array=new int[flag];
							for(int i=0;i<flag;i++) {
								array[i]=numeriCLOOK[i];
							}	
						labelDatoDistanzaLOOK.setText(String.valueOf(distanzaCLOOK));
						jPanelLOOK.disegnaSoluzione(jPanelLOOK.getGraphics(),array,nc,distanzaCLOOK,successione);
						}	
					}else {
						if(flag<numeriLOOK.length) {
							int[] array=new int[flag];
							for(int i=0;i<flag;i++) {
								array[i]=numeriLOOK[i];
							}
						labelDatoDistanzaLOOK.setText(String.valueOf(distanzaLOOK));
						jPanelLOOK.disegnaSoluzione(jPanelLOOK.getGraphics(),array,nc,distanzaLOOK,successione);
						}	
					}
							
					if(chckbxSCAN.isSelected()) {
						if(flag<numeriCSCAN.length) {
							int[] array=new int[flag];
							for(int i=0;i<flag;i++) {
								array[i]=numeriCSCAN[i];
							}	
						labelDatoDistanzaSCAN.setText(String.valueOf(distanzaCSCAN));
						jPanelSCAN.disegnaSoluzione(jPanelSCAN.getGraphics(),array,nc,distanzaCSCAN,successione);
						}	
					}else {
						if(flag<numeriSCAN.length) {
							int[] array=new int[flag];
							for(int i=0;i<flag;i++) {
								array[i]=numeriSCAN[i];
							}
							labelDatoDistanzaSCAN.setText(String.valueOf(distanzaSCAN));
							jPanelSCAN.disegnaSoluzione(jPanelSCAN.getGraphics(),array,nc,distanzaSCAN,successione);
						}
					}	
							
					if(flag<max(numeriSSTF.length,numeriFCFS.length,numeriCSCAN.length,numeriCLOOK.length,numeriSCAN.length,numeriLOOK.length)) {
						labelFastForwardPiu.setEnabled(true);
						labelMostraSoluzioni.setEnabled(true);
					}
					else {
						labelFastForwardPiu.setEnabled(false);
						labelMostraSoluzioni.setEnabled(false);
					}
				}
			}

			private int max(int length1, int length2, int length3, int length4, int length5,	int length6) {

				int[] array=new int [6];
				
				array[0]=length1;
				array[1]=length2;
				array[2]=length3;
				array[3]=length4;
				array[4]=length5;
				array[5]=length6;
				
				int massimo=array[0];

				for(int i=0; i<6; i++) {
				      if( array[i]>massimo ) {
				        massimo=array[i];
				      }
				    }
				
				return massimo;
			}
			
		});
		
	/*	
		btnFastForwardMeno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				
				if(btnFastForwardMeno.isEnabled()) {
					btnFastForwardPiu.setEnabled(true);
					btnMostraSoluzioni.setEnabled(true);

					String j= comboSceltaSlotDisponibili.getSelectedItem().toString();
					int s=Integer.valueOf(j);
					flag--;
					
					if(flag>=0) {
						
						int arrayF[][]= new int[flag][s];
						int arrayO[][]= new int[flag][s];
						int arrayL[][]= new int[flag][s];
						int arrayC[][]= new int[flag][s];
	
						int num[]=new int[flag];
						
						numeriFIFO=FIFO(numeri,s);
						numeriOPT=OPT(numeri,s);
						numeriLRU=LRU(numeri,s);
						numeriCLOCK=CLOCK(numeri,s);
						
						labelDATOFIFO.setText(String.valueOf(pagefaultFIFO));
						labelDATOOPT.setText(String.valueOf(pagefaultOPT));
						labelDATOLRU.setText(String.valueOf(pagefaultLRU));
						labelDATOCLOCK.setText(String.valueOf(pagefaultCLOCK));
											
					
						for(int i = 0; i < s; i++)
					    {
					        for(int z = 0; z < flag; z++) {
					        	arrayF[z][i]=numeriFIFO[z][i];
					        	arrayO[z][i]=numeriOPT[z][i];
					        	arrayL[z][i]=numeriLRU[z][i];
					        	arrayC[z][i]=numeriCLOCK[z][i];

					        }
					    }
						for(int i = 0; i < flag; i++)
					    {
							num[i]=numeri[i];
					    }
						jPanelFIFOMATRICE.resetGrafico(jPanelFIFOMATRICE.getGraphics());
						jPanelOPTMATRICE.resetGrafico(jPanelOPTMATRICE.getGraphics());
						jPanelLRUMATRICE.resetGrafico(jPanelLRUMATRICE.getGraphics());
						jPanelCLOCKMATRICE.resetGrafico(jPanelCLOCKMATRICE.getGraphics());

						jPanelFIFOMATRICE.disegnaSoluzioneFIFO(jPanelFIFOMATRICE.getGraphics(),arrayF,s,pagefaultFIFO,num);
						jPanelOPTMATRICE.disegnaSoluzioneOPT(jPanelOPTMATRICE.getGraphics(),arrayO,s,pagefaultOPT,num);
						jPanelLRUMATRICE.disegnaSoluzioneLRU(jPanelLRUMATRICE.getGraphics(),arrayL,s,pagefaultLRU,num);
						jPanelCLOCKMATRICE.disegnaSoluzioneCLOCK(jPanelCLOCKMATRICE.getGraphics(),arrayC,s,pagefaultCLOCK,num);

					}	
					else {
						btnFastForwardMeno.setEnabled(false);
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e){
				if(btnFastForwardMeno.isEnabled())
					btnFastForwardMeno.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnFastForwardMeno.setBackground(new Color(255, 255, 255));
			}
		});*/
	}	
	
/**-------------------------IMPLEMENTAZIONE ALGORTIMI UTILIZZATI--------------------------------*/

//ALGORITMO FCFS OK
	public int[] FCFS(int[] queue, int testa){
		int head=testa;
		//Resultant variable which are used to store information of number of time or operation
		int seek_time = 0;
		int distance = 0;
		int n=queue.length;
		// Loop controlling variable
		int i = 0;
		int[] array= new int[queue.length+1];
		
		for (i = 0; i < array.length; i++)
		{
			if(i==0)array[i]=testa;
			else array[i]=queue[i-1];
		}
		for (i = 0; i < n; i++)
		{
			//Get distance 
			distance = queue[i] - head;
			if (distance < 0)
			{
				//When distance is negative then convert into it absolute value
				distance = -distance;
			}
			// Update head data into current track value
			head = queue[i];
			// Add current distance into seek
			seek_time += distance;
		}
		//Display result
		distanzaFCFS=seek_time;
		return array;
	}
	
//ALGORITMO SSTF OK
	public int[] SSTF(int[] queue, int testa){
		
		int head=testa;
		int n=queue.length;
		int[] array= new int[queue.length+1];

			if (n <= 0)
			{
				return array;
			}
			int seek_time = 0;
			double minimum = 0.0;
			//This are storing the information of seek sequence
			int[] skeek = new int[n + 1];
			//Create 2d array which is used to store distance and visited status
			int[][] auxiliary = new int[n][2];
			for (int i = 0; i < n; ++i)
			{
				// set initial distance
				auxiliary[i][0] = 0;
				// set the visiting element status
				auxiliary[i][1] = 0;
			}
			// Loop controlling variable
			int i = 0;
			int j = 0;
			int location = 0;
			for (i = 0; i < n; i++)
			{
				skeek[i] = head;
				// Find distance using head value
				for (j = 0; j < n; ++j)
				{
					auxiliary[j][0] = queue[j] - head;
					if (auxiliary[j][0] < 0)
					{
						auxiliary[j][0] = -auxiliary[j][0];
					}
				}
				minimum = Integer.MAX_VALUE;
				location = -1;
				//Find the minimum element location that is not visited
				for (j = 0; j < n; ++j)
				{
					if (auxiliary[j][1] == 0 && auxiliary[j][0] <= minimum)
					{
						// Get the new minimum distance element location
						location = j;
						minimum = auxiliary[j][0];
					}
				}
				// Update the visited status of new get element
				auxiliary[location][1] = 1;
				// Update head data into current track value
				head = queue[location];
				// Add current distance into seek
				seek_time += auxiliary[location][0];
			}
			if (head != 0)
			{
				// Add last skee info
				skeek[n] = head;
			}
			//Display given queue elements
			for (i = 0; i <= n; i++)
			{
				array[i]=skeek[i];
			}
			
			distanzaSSTF=seek_time;
			return array;
		}
	
//ALGORITMO SCAN OK
	public int[] SCAN(int[] arr, int testa, String direction, int disk_size){
		
			int head=testa;
			int size = arr.length;
		    int seek_count = 0;
		    int distance, cur_track;
		    Vector<Integer> left = new Vector<Integer>(),
		                    right = new Vector<Integer>();
		    Vector<Integer> seek_sequence = new Vector<Integer>();
		 
		    // appending end values
		    // which has to be visited
		    // before reversing the direction
		    if (direction == "left")
		        left.add(0);
		    else if (direction == "right")
		        right.add(disk_size - 1);
		 
		    for (int i = 0; i < size; i++)
		    {
		        if (arr[i] < head)
		            left.add(arr[i]);
		        if (arr[i] > head)
		            right.add(arr[i]);
		    }
		 
		    // sorting left and right vectors
		    Collections.sort(left);
		    Collections.sort(right);
		 
		    // run the while loop two times.
		    // one by one scanning right
		    // and left of the head
		    int run = 2;
		    while (run-- >0)
		    {
		        if (direction == "left")
		        {
		            for (int i = left.size() - 1; i >= 0; i--)
		            {
		                cur_track = left.get(i);
		 
		                // appending current track to seek sequence
		                seek_sequence.add(cur_track);
		 
		                // calculate absolute distance
		                distance = Math.abs(cur_track - head);
		 
		                // increase the total count
		                seek_count += distance;
		 
		                // accessed track is now the new head
		                head = cur_track;
		            }
		            direction = "right";
		        }
		        else if (direction == "right")
		        {
		            for (int i = 0; i < right.size(); i++)
		            {
		                cur_track = right.get(i);
		                 
		                // appending current track to seek sequence
		                seek_sequence.add(cur_track);
		 
		                // calculate absolute distance
		                distance = Math.abs(cur_track - head);
		 
		                // increase the total count
		                seek_count += distance;
		 
		                // accessed track is now new head
		                head = cur_track;
		            }
		            direction = "left";
		        }
		    }
		 
		    System.out.print("Total number of seek operations = "
		                        + seek_count + "\n");
		 
		    System.out.print("Seek Sequence is" + " \n");
		    int k=seek_sequence.size();
		    
			int array[]=new int[k+1];
			array[0]=testa;
		    for (int i = 0; i < seek_sequence.size(); i++)
		    {
		    	array[i+1]=seek_sequence.get(i);
		        System.out.print(seek_sequence.get(i) + " ");
		    }
		    System.out.println();
		    for (int i = 0; i < array.length; i++)
		    {
		        System.out.print(array[i] + " ");
		    }
		    System.out.println();

		    distanzaSCAN=seek_count;
		    return array;
	  }

//ALGORITMO CSCAN NO
	public void CSCAN(int[] arr, int testa, String direction, int disk_size){
		
		int head=testa;
		int size=arr.length;
 		 
	        int seek_count = 0;
	        int distance, cur_track;
	 
	        Vector<Integer> left = new Vector<Integer>();
	        Vector<Integer> right = new Vector<Integer>();
	        Vector<Integer> seek_sequence
	            = new Vector<Integer>();
	 
	        // Appending end values which has
	        // to be visited before reversing
	        // the direction
	        left.add(0);
	        right.add(disk_size - 1);
	 
	        // Tracks on the left of the
	        // head will be serviced when
	        // once the head comes back
	        // to the beggining (left end).
	        for (int i = 0; i < size; i++) {
	            if (arr[i] < head)
	                left.add(arr[i]);
	            if (arr[i] > head)
	                right.add(arr[i]);
	        }
	 
	        // Sorting left and right vectors
	        Collections.sort(left);
	        Collections.sort(right);
	 
	        // First service the requests
	        // on the right side of the
	        // head.
	        for (int i = 0; i < right.size(); i++) {
	            cur_track = right.get(i);
	 
	            // Appending current track to seek sequence
	            seek_sequence.add(cur_track);
	 
	            // Calculate absolute distance
	            distance = Math.abs(cur_track - head);
	 
	            // Increase the total count
	            seek_count += distance;
	 
	            // Accessed track is now new head
	            head = cur_track;
	        }
	       
	        // Once reached the right end
	        // jump to the beggining.
	        head = 0;
	 
	        // adding seek count for head returning from 199 to
	        // 0
	        seek_count += (disk_size - 1);
	 
	        // Now service the requests again
	        // which are left.
	        for (int i = 0; i < left.size(); i++) {
	            cur_track = left.get(i);
	 
	            // Appending current track to
	            // seek sequence
	            seek_sequence.add(cur_track);
	 
	            // Calculate absolute distance
	            distance = Math.abs(cur_track - head);
	 
	            // Increase the total count
	            seek_count += distance;
	 
	            // Accessed track is now the new head
	            head = cur_track;
	        }
	 
	        System.out.println("Total number of seek "
	                           + "operations = " + seek_count);
	 
	        System.out.println("Seek Sequence is");
	 
	        for (int i = 0; i < seek_sequence.size(); i++) {
	            System.out.println(seek_sequence.get(i));
	        }
	        
		    if (direction == "right") {
		    	int k=seek_sequence.size();
			    
				int array[]=new int[k+1];
				array[0]=testa;
			    for (int i = 0; i < seek_sequence.size(); i++)
			    {
			    	array[i+1]=seek_sequence.get(i);
			        System.out.print(seek_sequence.get(i) + " ");
			    }
			    System.out.println();
			    for (int i = 0; i < array.length; i++)
			    {
			        System.out.print(array[i] + " ");
			    }
			    System.out.println();

			    distanzaSCAN=seek_count;
			   // return array;
		    }
		    else if (direction == "left") {
		    	
		    }

	}		

//ALGORITMO LOOK OK
	public int[] LOOK(int[] arr, int testa, String direction, int disk_size){
		
		int head=testa;
		int size=arr.length;
		int seek_count = 0;
	    int distance, cur_track;
		     
	    Vector<Integer> left = new Vector<Integer>();
	    Vector<Integer> right = new Vector<Integer>();
	    Vector<Integer> seek_sequence = new Vector<Integer>();
	   
	    // Appending values which are
	    // currently at left and right
	    // direction from the head.
	    for(int i = 0; i < size; i++)
	    {
	        if (arr[i] < head)
	            left.add(arr[i]);
	        if (arr[i] > head)
	            right.add(arr[i]);
	    } 
	   
	    // Sorting left and right vectors
	    // for servicing tracks in the
	    // correct sequence.
	    Collections.sort(left); 
	    Collections.sort(right); 
	     
	    // Run the while loop two times.
	    // one by one scanning right
	    // and left side of the head
	    int run = 2;
	    while (run-- > 0)
	    {
	        if (direction == "left")
	        {
	            for(int i = left.size() - 1;
	                    i >= 0; i--)
	            {
	                cur_track = left.get(i);
	   
	                // Appending current track to
	                // seek sequence
	                seek_sequence.add(cur_track);
	   
	                // Calculate absolute distance
	                distance = Math.abs(cur_track - head);
	   
	                // Increase the total count
	                seek_count += distance;
	   
	                // Accessed track is now the new head
	                head = cur_track;
	            }
	             
	            // Reversing the direction
	            direction = "right";
	        }
	        else if (direction == "right")
	        {
	            for(int i = 0; i < right.size(); i++)
	            {
	                cur_track = right.get(i);
	                 
	                // Appending current track to
	                // seek sequence
	                seek_sequence.add(cur_track);
	   
	                // Calculate absolute distance
	                distance = Math.abs(cur_track - head);
	   
	                // Increase the total count
	                seek_count += distance;
	   
	                // Accessed track is now new head
	                head = cur_track;
	            }
	             
	            // Reversing the direction
	            direction = "left";
	        }
	    }
	     
	    System.out.print("Total number of seek operations = "
                + seek_count + "\n");

		System.out.print("Seek Sequence is" + " \n");
		int k=seek_sequence.size();
		
		int array[]=new int[k+1];
		array[0]=testa;
		for (int i = 0; i < seek_sequence.size(); i++)
		{
			array[i+1]=seek_sequence.get(i);
		    System.out.print(seek_sequence.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < array.length; i++)
		{
		    System.out.print(array[i] + " ");
		}
		System.out.println();
		
		distanzaLOOK=seek_count;
		return array;
	}

//ALGORITMO CLOOK
	public void CLOOK(int[] arr, int head, String direction, int disk_size){
		
		int size=arr.length;
		int[] array= new int[arr.length+1];
 
	    int seek_count = 0;
	    int distance, cur_track;
	     
		     
	    Vector<Integer> left = new Vector<Integer>();
	    Vector<Integer> right = new Vector<Integer>();
	    Vector<Integer> seek_sequence = new Vector<Integer>();
	   
	    // Tracks on the left of the
	    // head will be serviced when
	    // once the head comes back
	    // to the beginning (left end)
	    for(int i = 0; i < size; i++)
	    {
	        if (arr[i] < head)
	            left.add(arr[i]);
	        if (arr[i] > head)
	            right.add(arr[i]);
	    }
	   
	    // Sorting left and right vectors
	    Collections.sort(left); 
	    Collections.sort(right); 
	   
	    // First service the requests
	    // on the right side of the
	    // head
	    for(int i = 0; i < right.size(); i++)
	    {
	        cur_track = right.get(i);
	   
	        // Appending current track
	        // to seek sequence
	        seek_sequence.add(cur_track);
	   
	        // Calculate absolute distance
	        distance = Math.abs(cur_track - head);
	   
	        // Increase the total count
	        seek_count += distance;
	   
	        // Accessed track is now new head
	        head = cur_track;
	    }
	   
	    // Once reached the right end
	    // jump to the last track that
	    // is needed to be serviced in
	    // left direction
	    seek_count += Math.abs(head - left.get(0));
	    head = left.get(0);
	   
	    // Now service the requests again
	    // which are left
	    for(int i = 0; i < left.size(); i++)
	    {
	        cur_track = left.get(i);
	   
	        // Appending current track to
	        // seek sequence
	        seek_sequence.add(cur_track);
	   
	        // Calculate absolute distance
	        distance = Math.abs(cur_track - head);
	   
	        // Increase the total count
	        seek_count += distance;
	   
	        // Accessed track is now the new head
	        head = cur_track;
	    }
	     
	    for (int i = 0; i < array.length; i++)
		{
			if(i==0)array[i]=head;
			else array[i]=seek_sequence.get(i-1);
		}
	    
	    distanzaCLOOK=seek_count;
		//return array;
	}
}



