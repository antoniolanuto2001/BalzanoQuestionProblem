package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import javax.swing.JCheckBox;

import model.PanelGraficiSchHD;
import model.PanelGraficiSchHD;

public class SchHD extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Create the frame.
	 */
	public SchHD(JFrame framechiamante) 
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
			labelFedericoII.setBounds(10, 11, 199, 53);
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
			
		JButton btnGeneraEsempio = new JButton("GENERA ESERCIZIO");
			btnGeneraEsempio.setFont(new Font("Arial", Font.BOLD, 15));
			btnGeneraEsempio.setBorder(new LineBorder(new Color(229,57,53), 2, true));
			btnGeneraEsempio.setBackground(Color.WHITE);
			btnGeneraEsempio.setBounds(16, 147, 224, 34);
			pannelloParametri.add(btnGeneraEsempio);
			
		JComboBox comboBoxSceltaNCilindri = new JComboBox();
			comboBoxSceltaNCilindri.setModel(new DefaultComboBoxModel(new String[] {"200", "400", "600", "800", "1000", "1400", "1800", "2000"}));
			comboBoxSceltaNCilindri.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			comboBoxSceltaNCilindri.setBackground(Color.WHITE);
			comboBoxSceltaNCilindri.setBounds(166, 105, 74, 22);
			pannelloParametri.add(comboBoxSceltaNCilindri);
			
		JLabel labelPosizione = new JLabel("Numero Cilindri  :");
			labelPosizione.setFont(new Font("Segoe UI", Font.BOLD, 14));
			labelPosizione.setBounds(16, 105, 140, 22);
			pannelloParametri.add(labelPosizione);
		
		JLabel labelMostraSoluzioni = new JLabel("");
			labelMostraSoluzioni.setHorizontalAlignment(SwingConstants.CENTER);
			labelMostraSoluzioni.setEnabled(false);
			labelMostraSoluzioni.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			labelMostraSoluzioni.setBounds(90, 200, 79, 35);
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
			labelFastForwardPiu.setBounds(179, 200, 52, 35);
			pannelloParametri.add(labelFastForwardPiu);
			
		JLabel labelFastForwardMeno = new JLabel("");
			labelFastForwardMeno.setHorizontalAlignment(SwingConstants.CENTER);
			labelFastForwardMeno.setFont(new Font("Segoe UI", Font.PLAIN, 25));
			labelFastForwardMeno.setEnabled(false);
			labelFastForwardMeno.setBounds(24, 200, 52, 35);
			labelFastForwardMeno.setBackground(new Color(255, 255, 255));
			//btnFastForwardMeno.setBorder(new LineBorder(Color.black,2));
			labelFastForwardMeno.setIcon(new ImageIcon(SchProcessi.class.getResource("/img/fastFowardIconRovescio.png")));
			pannelloParametri.add(labelFastForwardMeno);
			
		
		JTextField textFieldRichieste = new JTextField();
			textFieldRichieste.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldRichieste.setFont(new Font("Arial", Font.BOLD, 10));
			textFieldRichieste.setEditable(false);
			textFieldRichieste.setColumns(10);
			textFieldRichieste.setBackground(Color.WHITE);
			textFieldRichieste.setBounds(10, 71, 235, 23);
			pannelloParametri.add(textFieldRichieste);
		
		JLabel labelCodaRichieste = new JLabel("Coda delle Richieste");
			labelCodaRichieste.setHorizontalAlignment(SwingConstants.CENTER);
			labelCodaRichieste.setForeground(Color.BLACK);
			labelCodaRichieste.setFont(new Font("Arial", Font.BOLD, 14));
			labelCodaRichieste.setBounds(16, 44, 224, 23);
			pannelloParametri.add(labelCodaRichieste);
			
		JLabel labelPosizioneInziale = new JLabel("Posizione Inziale testina : ");
			labelPosizioneInziale.setFont(new Font("Segoe UI", Font.BOLD, 14));
			labelPosizioneInziale.setBounds(10, 11, 183, 22);
			pannelloParametri.add(labelPosizioneInziale);
			
		JTextField textFieldInzialeTestina = new JTextField();
		textFieldInzialeTestina.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldInzialeTestina.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldInzialeTestina.setText("2000");
			textFieldInzialeTestina.setBounds(188, 13, 52, 20);
			pannelloParametri.add(textFieldInzialeTestina);
			textFieldInzialeTestina.setColumns(10);
			
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
		
		JLabel labelScrittaIndietro = new JLabel(" Indietro");
			labelScrittaIndietro.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelScrittaIndietro.setBounds(10, 129, 53, 12);
			panelMainButton.add(labelScrittaIndietro);
			
		JLabel labelIndietroIcon = new JLabel("");
			  labelIndietroIcon.addMouseListener(new MouseAdapter() {
		        	@Override
					public void mouseClicked(MouseEvent e) 
					{	
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
			labelIndietroIcon.setIcon(new ImageIcon(SchHD.class.getResource("/img/back-button.png")));
			labelIndietroIcon.setBounds(19, 91, 32, 32);
			panelMainButton.add(labelIndietroIcon);

		JLabel labelScrittaYoutube = new JLabel("Video Lezione");
			labelScrittaYoutube.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelScrittaYoutube.setBounds(918, 129, 82, 12);
			panelMainButton.add(labelScrittaYoutube);
		
		JLabel labelYoutubeIcon = new JLabel("Youtube");
			labelYoutubeIcon.setIcon(new ImageIcon(SchHD.class.getResource("/img/youtubeIcon2.png")));
			labelYoutubeIcon.setBounds(933, 81, 53, 46);
			panelMainButton.add(labelYoutubeIcon);
			labelYoutubeIcon.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI ("https://youtu.be/-EfXe93K_3E?t=2580"));
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
			
		JLabel labelScrittaSlide = new JLabel("Slide Argomento");
			labelScrittaSlide.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelScrittaSlide.setBounds(1007, 129, 95, 15);
			panelMainButton.add(labelScrittaSlide);
			
		JLabel labelSlideIcon = new JLabel("Slide");
			labelSlideIcon.setIcon(new ImageIcon(SchHD.class.getResource("/img/pdfIcon1.png")));
			labelSlideIcon.setBounds(1027, 81, 53, 46);
			panelMainButton.add(labelSlideIcon);
			
			/*GRAFICI*/
			
			
		JPanel pannelloGrafici = new JPanel();
			pannelloGrafici.setLayout(null);
			pannelloGrafici.setBounds(0, 144, 1131, 620);
			panelMainButton.add(pannelloGrafici);
			
		JPanel pannelloFCFS = new JPanel();
					pannelloFCFS.setLayout(null);
					pannelloFCFS.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloFCFS.setBounds(10, 0, 1121, 150);
					pannelloGrafici.add(pannelloFCFS);
				
				JLabel labelFirstcomeFirstserved = new JLabel("First-Come  First-Served");
					labelFirstcomeFirstserved.setHorizontalAlignment(SwingConstants.CENTER);
					labelFirstcomeFirstserved.setForeground(Color.RED);
					labelFirstcomeFirstserved.setFont(new Font("Tahoma", Font.PLAIN, 20));
					labelFirstcomeFirstserved.setBounds(10, 0, 306, 25);
					pannelloFCFS.add(labelFirstcomeFirstserved);
					
				JLabel labelDistanzaTotaleFCFS = new JLabel("Distanza totale:");
					labelDistanzaTotaleFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDistanzaTotaleFCFS.setBounds(31, 88, 98, 25);
					pannelloFCFS.add(labelDistanzaTotaleFCFS);
				
				JLabel labelDatoDistanzaFCFS = new JLabel("");
					labelDatoDistanzaFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDatoDistanzaFCFS.setBounds(139, 88, 45, 25);
					pannelloFCFS.add(labelDatoDistanzaFCFS);
				
				PanelGraficiSchHD jPanelFCFS = new PanelGraficiSchHD();
					jPanelFCFS.setLayout(null);
					jPanelFCFS.setBounds(326, 0, 784, 145);
					pannelloFCFS.add(jPanelFCFS);
					
		JPanel pannelloSSTF = new JPanel();
					pannelloSSTF.setLayout(null);
					pannelloSSTF.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloSSTF.setBounds(10, 153, 1121, 150);
					pannelloGrafici.add(pannelloSSTF);
				
				JLabel labelShortestSeekTime = new JLabel("Shortest Seek Time First");
					labelShortestSeekTime.setHorizontalAlignment(SwingConstants.CENTER);
					labelShortestSeekTime.setForeground(Color.RED);
					labelShortestSeekTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
					labelShortestSeekTime.setBounds(10, 0, 306, 25);
					pannelloSSTF.add(labelShortestSeekTime);
				
				JLabel labelDistanzaTotaleSSTF = new JLabel("Distanza totale:");
					labelDistanzaTotaleSSTF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDistanzaTotaleSSTF.setBounds(31, 88, 98, 25);
					pannelloSSTF.add(labelDistanzaTotaleSSTF);
					
				JLabel labelDatoDistanzaSSTF = new JLabel("");
					labelDatoDistanzaSSTF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDatoDistanzaSSTF.setBounds(139, 88, 45, 25);
					pannelloSSTF.add(labelDatoDistanzaSSTF);
				
				PanelGraficiSchHD jPanelSSFT = new PanelGraficiSchHD();
					jPanelSSFT.setLayout(null);
					jPanelSSFT.setBounds(326, 0, 784, 145);
					pannelloSSTF.add(jPanelSSFT);
				
		JPanel pannelloSCAN = new JPanel();
					pannelloSCAN.setLayout(null);
					pannelloSCAN.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloSCAN.setBounds(10, 306, 1121, 150);
					pannelloGrafici.add(pannelloSCAN);
				
				JLabel labelSCAN = new JLabel("SCAN");
					labelSCAN.setHorizontalAlignment(SwingConstants.CENTER);
					labelSCAN.setForeground(Color.RED);
					labelSCAN.setFont(new Font("Tahoma", Font.PLAIN, 20));
					labelSCAN.setBounds(10, 0, 306, 25);
					pannelloSCAN.add(labelSCAN);
				
				JLabel labelDistanzaTotaleSCAN = new JLabel("Distanza totale:");
					labelDistanzaTotaleSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDistanzaTotaleSCAN.setBounds(31, 88, 98, 25);
					pannelloSCAN.add(labelDistanzaTotaleSCAN);
				
				JLabel labelDatoDistanzaSCAN = new JLabel("");
					labelDatoDistanzaSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDatoDistanzaSCAN.setBounds(139, 88, 45, 25);
					pannelloSCAN.add(labelDatoDistanzaSCAN);
					
				PanelGraficiSchHD jPanelSCAN = new PanelGraficiSchHD();
					jPanelSCAN.setLayout(null);
					jPanelSCAN.setBounds(326, 0, 784, 145);
					pannelloSCAN.add(jPanelSCAN);
					
				JCheckBox chckbxSCAN = new JCheckBox("C-SCAN");
					chckbxSCAN.setEnabled(false);
					chckbxSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					chckbxSCAN.setBounds(209, 88, 98, 21);
					pannelloSCAN.add(chckbxSCAN);
					
				JLabel labelDirezioneSCAN = new JLabel("<  direzione  >");
					labelDirezioneSCAN.setHorizontalAlignment(SwingConstants.CENTER);
					labelDirezioneSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDirezioneSCAN.setBounds(121, 39, 98, 25);
					pannelloSCAN.add(labelDirezioneSCAN);
					
				JRadioButton rdbtnDestraSCAN = new JRadioButton("");
					rdbtnDestraSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					rdbtnDestraSCAN.setEnabled(false);
					rdbtnDestraSCAN.setBounds(92, 39, 23, 21);
					pannelloSCAN.add(rdbtnDestraSCAN);
					
				JRadioButton rdbtnSinistraSCAN = new JRadioButton("");
					rdbtnSinistraSCAN.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					rdbtnSinistraSCAN.setEnabled(false);
					rdbtnSinistraSCAN.setBounds(225, 39, 23, 21);
					pannelloSCAN.add(rdbtnSinistraSCAN);
					
		JPanel pannelloLOOK = new JPanel();
					pannelloLOOK.setLayout(null);
					pannelloLOOK.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloLOOK.setBounds(10, 459, 1121, 150);
					pannelloGrafici.add(pannelloLOOK);
					
				JLabel labelLook = new JLabel("LOOK");
					labelLook.setHorizontalAlignment(SwingConstants.CENTER);
					labelLook.setForeground(Color.RED);
					labelLook.setFont(new Font("Tahoma", Font.PLAIN, 20));
					labelLook.setBounds(10, 0, 306, 25);
					pannelloLOOK.add(labelLook);
					
				JLabel labelDistanzaTotaleLOOK = new JLabel("Distanza totale:");
					labelDistanzaTotaleLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDistanzaTotaleLOOK.setBounds(31, 88, 98, 25);
					pannelloLOOK.add(labelDistanzaTotaleLOOK);
					
				JLabel labelDatoDistanzaLOOK = new JLabel("");
					labelDatoDistanzaLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDatoDistanzaLOOK.setBounds(139, 88, 45, 25);
					pannelloLOOK.add(labelDatoDistanzaLOOK);
					
				PanelGraficiSchHD jPanelLOOK = new PanelGraficiSchHD();
					jPanelLOOK.setLayout(null);
					jPanelLOOK.setBounds(326, 0, 784, 145);
					pannelloLOOK.add(jPanelLOOK);
					
				JCheckBox chckbxLOOK = new JCheckBox("C-LOOK");
					chckbxLOOK.setEnabled(false);
					chckbxLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					chckbxLOOK.setBounds(209, 88, 98, 21);
					pannelloLOOK.add(chckbxLOOK);
					
				JLabel labelDirezioneLOOK = new JLabel("<  direzione  >");
					labelDirezioneLOOK.setHorizontalAlignment(SwingConstants.CENTER);
					labelDirezioneLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					labelDirezioneLOOK.setBounds(121, 39, 98, 25);
					pannelloLOOK.add(labelDirezioneLOOK);
					
				JRadioButton rdbtnDestraLOOK = new JRadioButton("");
					rdbtnDestraLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					rdbtnDestraLOOK.setEnabled(false);
					rdbtnDestraLOOK.setBounds(92, 39, 23, 21);
					pannelloLOOK.add(rdbtnDestraLOOK);
					
				JRadioButton rdbtnSinistraLOOK = new JRadioButton("");
					rdbtnSinistraLOOK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					rdbtnSinistraLOOK.setEnabled(false);
					rdbtnSinistraLOOK.setBounds(225, 39, 23, 21);
					pannelloLOOK.add(rdbtnSinistraLOOK);
					
/**--------------------------------IMPLEMENTAZIONE EVENTI-------------------------------------------*/
					
					btnGeneraEsempio.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							Random random = new Random();
							int ncilindri = random.nextInt(7 + 0) + 0;
							comboBoxSceltaNCilindri.setSelectedIndex(ncilindri);
							
							int position = random.nextInt(Integer.valueOf(String.valueOf(comboBoxSceltaNCilindri.getSelectedItem()))+0) + 0;
							textFieldInzialeTestina.setText(String.valueOf(position));
							
							int numero=Integer.valueOf(String.valueOf(comboBoxSceltaNCilindri.getSelectedItem()));
							
							for (int i=0;i<10;i++) { 
								int value = random.nextInt(numero + 0) + 0;
								if(i==0)textFieldRichieste.setText(String.valueOf(value));
								else textFieldRichieste.setText(textFieldRichieste.getText()+"-"+value);

							}
						}
						@Override
						public void mouseEntered(MouseEvent e) 
						{
							btnGeneraEsempio.setBackground(new Color(229,57,53));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							btnGeneraEsempio.setBackground(Color.WHITE);
						}
					});
	}
}
