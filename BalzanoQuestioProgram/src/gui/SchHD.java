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

public class SchHD extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textFieldRichieste;
	private JTextField textFieldInzialeTestina;
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
		
		JPanel panelSuperiore = new JPanel();
		panelSuperiore.setLayout(null);
		panelSuperiore.setBorder(new LineBorder(new Color(0, 151, 167), 7));
		panelSuperiore.setBounds(0, 0, 1414, 73);
		panelMainButton.add(panelSuperiore);
		
		JLabel lblSchedulingHardDisk = new JLabel("SCHEDULING HARD DISK");
		lblSchedulingHardDisk.setFont(new Font("Segoe UI", Font.BOLD, 48));
		lblSchedulingHardDisk.setBounds(408, 0, 608, 73);
		panelSuperiore.add(lblSchedulingHardDisk);
		
		JLabel labelFedericoII = new JLabel("New label");
		labelFedericoII.setIcon(new ImageIcon(SchHD.class.getResource("/img/logoUninaIcon2.png")));
		labelFedericoII.setBounds(10, 11, 199, 53);
		panelSuperiore.add(labelFedericoII);
		
		JPanel panelControllo = new JPanel();
		panelControllo.setLayout(null);
		panelControllo.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		panelControllo.setBounds(1130, 81, 274, 670);
		panelMainButton.add(panelControllo);
		
		JLabel labelgenerale = new JLabel("Parametri :");
		labelgenerale.setVerticalAlignment(SwingConstants.BOTTOM);
		labelgenerale.setForeground(Color.RED);
		labelgenerale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelgenerale.setBounds(86, 80, 114, 26);
		panelControllo.add(labelgenerale);
		
		JPanel panelPlot = new JPanel();
		panelPlot.setLayout(null);
		panelPlot.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		panelPlot.setBounds(10, 107, 254, 265);
		panelControllo.add(panelPlot);
		
		JButton buttonGeneraEsempio = new JButton("GENERA ESERCIZIO");
		buttonGeneraEsempio.setFont(new Font("Arial", Font.BOLD, 15));
		buttonGeneraEsempio.setBorder(new LineBorder(new Color(229,57,53), 2, true));
		buttonGeneraEsempio.setBackground(Color.WHITE);
		buttonGeneraEsempio.setBounds(16, 147, 224, 34);
		panelPlot.add(buttonGeneraEsempio);
		
		JComboBox comboBoxSceltaNParole = new JComboBox();
		comboBoxSceltaNParole.setModel(new DefaultComboBoxModel(new String[] {"200", "400", "600", "800", "1400", "2000", "3000", "4000"}));
		comboBoxSceltaNParole.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxSceltaNParole.setBackground(Color.WHITE);
		comboBoxSceltaNParole.setBounds(189, 105, 51, 22);
		panelPlot.add(comboBoxSceltaNParole);
		
		JLabel labelPosizione = new JLabel("Numero Cilindri  :");
		labelPosizione.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelPosizione.setBounds(16, 105, 160, 22);
		panelPlot.add(labelPosizione);
		
		JLabel labelPlay = new JLabel(">");
		labelPlay.setIcon(new ImageIcon(SchHD.class.getResource("/img/playIcon2.png")));
		labelPlay.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelPlay.setEnabled(false);
		labelPlay.setBounds(49, 188, 39, 35);
		panelPlot.add(labelPlay);
		
		JLabel labelScrittaPlay = new JLabel("    Play Tutto");
		labelScrittaPlay.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelScrittaPlay.setEnabled(false);
		labelScrittaPlay.setBounds(32, 222, 75, 17);
		panelPlot.add(labelScrittaPlay);
		
		JLabel labelScrittaFast = new JLabel("    Play  Passo");
		labelScrittaFast.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelScrittaFast.setEnabled(false);
		labelScrittaFast.setBounds(137, 222, 75, 17);
		panelPlot.add(labelScrittaFast);
		
		JLabel labelFastForward = new JLabel(">>");
		labelFastForward.setIcon(new ImageIcon(SchHD.class.getResource("/img/fastFowardIcon1.png")));
		labelFastForward.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelFastForward.setEnabled(false);
		labelFastForward.setBounds(154, 188, 39, 35);
		panelPlot.add(labelFastForward);
		
		textFieldRichieste = new JTextField();
		textFieldRichieste.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRichieste.setFont(new Font("Arial", Font.BOLD, 10));
		textFieldRichieste.setEditable(false);
		textFieldRichieste.setColumns(10);
		textFieldRichieste.setBackground(Color.WHITE);
		textFieldRichieste.setBounds(10, 71, 235, 23);
		panelPlot.add(textFieldRichieste);
		
		JLabel labelCodaRichieste = new JLabel("Successione di riferimento:");
		labelCodaRichieste.setHorizontalAlignment(SwingConstants.CENTER);
		labelCodaRichieste.setForeground(Color.BLACK);
		labelCodaRichieste.setFont(new Font("Arial", Font.BOLD, 14));
		labelCodaRichieste.setBounds(15, 44, 225, 23);
		panelPlot.add(labelCodaRichieste);
		
		JLabel labelPosizioneInziale = new JLabel("Posizione Inziale testina : ");
		labelPosizioneInziale.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelPosizioneInziale.setEnabled(false);
		labelPosizioneInziale.setBounds(10, 11, 183, 22);
		panelPlot.add(labelPosizioneInziale);
		
		textFieldInzialeTestina = new JTextField();
		textFieldInzialeTestina.setBounds(197, 13, 43, 20);
		panelPlot.add(textFieldInzialeTestina);
		textFieldInzialeTestina.setColumns(10);
		
		JLabel labelPnlCtrl = new JLabel("Pannello di controllo");
		labelPnlCtrl.setHorizontalAlignment(SwingConstants.CENTER);
		labelPnlCtrl.setFont(new Font("Arial", Font.BOLD, 22));
		labelPnlCtrl.setBorder(new LineBorder(new Color (0, 151, 167), 2));
		labelPnlCtrl.setBounds(14, 11, 245, 54);
		panelControllo.add(labelPnlCtrl);
		
		JPanel pannelloHelp = new JPanel();
		pannelloHelp.setLayout(null);
		pannelloHelp.setBounds(20, 405, 245, 254);
		panelControllo.add(pannelloHelp);
		
		JScrollPane scrollPaneHelp = new JScrollPane();
		scrollPaneHelp.setBounds(0, 0, 245, 255);
		pannelloHelp.add(scrollPaneHelp);
		
		JTextArea txtrHelpArea = new JTextArea();
		scrollPaneHelp.setViewportView(txtrHelpArea);
		txtrHelpArea.setWrapStyleWord(true);
		txtrHelpArea.setLineWrap(true);
		txtrHelpArea.setText("FIFO (First In First Out).\r\nE' la pi\u00F9 semplice, si tiene traccia in una tabella di quando \u00E8 stata allocata un'area di memoria. Quando vi \u00E8 una nuova richiesta di allocazione di pagine di memoria, se c'\u00E8 ancora spazio in memoria principale, semplicemente viene allocata la nuova pagina, altrimenti si consulta mediante la tabella quali sono le pagine allocate da pi\u00F9 tempo e si spostano in memoria secondaria.\r\nQuesto algoritmo \u00E8 molto semplice e di rapida esecuzione ma ha lo svantaggio di spostare in memoria secondaria le pagine pi\u00F9 vecchie anche se sono utilizzate di frequente.\r\n\r\nOPT\r\nSi sostituisce la pagina che non si user\u00E0 per il periodo di tempo pi\u00F9 lungo. Non \u00E8 possibile conoscere in anticipo la successione dei riferimenti, viene usato principalmente per studi comparativi, per valutare le prestazioni degli algoritmi.\r\n\r\nLRU (Least Recently Used)\r\nVengono sostituite le pagine usate meno di recente, poich\u00E8 queste hanno buona probabilit\u00E0 di non essere nuovamente utilizzate nell'immediato.\r\n");
		txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
		txtrHelpArea.setCaretPosition(0);
		txtrHelpArea.setEditable(false);
		
		JLabel labellHelp = new JLabel("Spiegazione Argomento");
		labellHelp.setHorizontalAlignment(SwingConstants.CENTER);
		labellHelp.setForeground(Color.RED);
		labellHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labellHelp.setBounds(20, 381, 245, 25);
		panelControllo.add(labellHelp);
		
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
		
		JLabel labelYoutubeIcon = new JLabel("Youtube");
		
		labelYoutubeIcon.setIcon(new ImageIcon(SchHD.class.getResource("/img/youtubeIcon2.png")));
		labelYoutubeIcon.setBounds(933, 81, 53, 46);
		panelMainButton.add(labelYoutubeIcon);
		
		JLabel labelScrittaSlide = new JLabel("Slide Argomento");
		labelScrittaSlide.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelScrittaSlide.setBounds(1007, 129, 95, 15);
		panelMainButton.add(labelScrittaSlide);
		
		JLabel labelSlideIcon = new JLabel("Slide");
		labelSlideIcon.setIcon(new ImageIcon(SchHD.class.getResource("/img/pdfIcon1.png")));
		labelSlideIcon.setBounds(1027, 81, 53, 46);
		panelMainButton.add(labelSlideIcon);
		
		JLabel labelScrittaYoutube = new JLabel("Video Lezione");
		labelScrittaYoutube.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelScrittaYoutube.setBounds(918, 129, 82, 12);
		panelMainButton.add(labelScrittaYoutube);
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
	}
}
