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
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Key;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.border.LineBorder;
import javax.swing.event.MenuKeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.text.BadLocationException;
import javax.swing.text.NumberFormatter;

import model.PanelGraficiPaginazioneMemoria;
import model.parolaHashing;
import model.CreaLinee;
import model.PanelGraficiMatricePaginazioneDellaMemoria;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
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
import java.util.Queue;


public class PaginazioneDellaMemoria extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private String scelta="0";
	private int pieno=0;
	private int[] numeri;
	private int[] numeriFIFO;
	private int[] numeriLRU;
	private int[] numeriOPT;
	private int[] numeriCLOCK;

	private int[] pfFIFO;
	private int[] pfLRU;
	private int[] pfOPT;
	private int[] pfCLOCK;
	
	private int pagefaultFIFO;
	private int pagefaultLRU;
	private int pagefaultOPT;
	private int pagefaultCLOCK;

	public PaginazioneDellaMemoria(JFrame framechiamante) {
		
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Paginazione della memoria");

/**							PANNELLO PRINCIPALE								*/
		JPanel pannelloPrincipale = new JPanel();
			pannelloPrincipale.setForeground(new Color(153, 204, 255));
			pannelloPrincipale.setBounds(0, 0, 1440, 800);
			frame.getContentPane().add(pannelloPrincipale);
			pannelloPrincipale.setLayout(null);
	        
	        JLabel labelScrittaIndietro = new JLabel(" Indietro");
	        labelScrittaIndietro.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        labelScrittaIndietro.setBounds(20, 120, 53, 12);
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
		        labelIndietroIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/back-button.png")));
		        labelIndietroIcon.setBounds(29, 75, 34, 46);
		        pannelloPrincipale.add(labelIndietroIcon);
		        
	        JLabel labelScrittaYoutube = new JLabel("Videolezione");
		        labelScrittaYoutube.setHorizontalAlignment(SwingConstants.CENTER);
		        labelScrittaYoutube.setFont(new Font("Tahoma", Font.PLAIN, 13));
		        labelScrittaYoutube.setBounds(73, 120, 95, 12);
		        pannelloPrincipale.add(labelScrittaYoutube);
		        JLabel labelYoutubeIcon = new JLabel("Youtube");
		        labelYoutubeIcon.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		Desktop d = Desktop.getDesktop();
						try {
							d.browse(new URI ("https://youtu.be/s8fpbXN92Tk"));
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
		        labelYoutubeIcon.setIcon(new ImageIcon(Filosofi.class.getResource("/img/youtubeIcon2.png")));
		        labelYoutubeIcon.setBounds(93, 75, 53, 46);
		        pannelloPrincipale.add(labelYoutubeIcon);
		        
	        JLabel labelScrittaSlide = new JLabel("Slide Argomento");
		        labelScrittaSlide.setFont(new Font("Tahoma", Font.PLAIN, 13));
		        labelScrittaSlide.setBounds(166, 119, 95, 15);
		        pannelloPrincipale.add(labelScrittaSlide);
		        JLabel labelSlideIcon = new JLabel("Slide");
		        labelSlideIcon.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		Desktop d = Desktop.getDesktop();
						try {
							d.browse(new URI ("http://balzanoslidesistemiopera.altervista.org/Slides_Sistemi_Operativi.pdf#page=118"));
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
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
		        labelSlideIcon.setBounds(185, 75, 53, 46);
		        pannelloPrincipale.add(labelSlideIcon);
		
/**							PANNELLO TITOLO									*/
		JPanel pannelloTitolo = new JPanel();
			pannelloTitolo.setBorder(new LineBorder(new Color(0, 153, 0), 10));
			pannelloTitolo.setBounds(0, 0, 1416, 75);
			pannelloPrincipale.add(pannelloTitolo);
			pannelloTitolo.setLayout(null);
			
		//TITOLO
		JLabel labelTitolo = new JLabel("PAGINAZIONE DELLA MEMORIA");
			labelTitolo.setForeground(new Color(0, 0, 0));
			labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitolo.setFont(new Font("Segoe UI", Font.BOLD, 40));
			labelTitolo.setBounds(0, 0, 1419, 73);
			pannelloTitolo.add(labelTitolo);
		
/*-----------------------------------------------------------------------------------------------------------------------------*/
			
/*INIZIO GUI COMPLICATA*/		

/**							PANNELLO GRAFICI								*/
		JPanel pannelloGrafici = new JPanel();
	        pannelloGrafici.setBounds(0, 135, 1131, 618);
	        pannelloPrincipale.add(pannelloGrafici);
	        pannelloGrafici.setLayout(null);
        
        //PANNELLO FIFO
        JPanel pannelloFIFO = new JPanel();
		        	pannelloFIFO.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloFIFO.setBounds(10, 0, 1121, 150);
					pannelloGrafici.add(pannelloFIFO);
					//pannelloFCFS.setBorder(new LineBorder(new Color(0, 204, 0), 2));
					pannelloFIFO.setLayout(null);
		
					JLabel FIFO = new JLabel("FIFO");
					FIFO.setBounds(10, 0, 489, 25);
					FIFO.setHorizontalAlignment(SwingConstants.CENTER);
					FIFO.setForeground(Color.RED);
					FIFO.setFont(new Font("Tahoma", Font.PLAIN, 20));
					pannelloFIFO.add(FIFO);
				
					JLabel lblPageFaultsFIFO = new JLabel("Page faults:");
					lblPageFaultsFIFO.setBounds(670, 3, 86, 25);
					lblPageFaultsFIFO.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					pannelloFIFO.add(lblPageFaultsFIFO);
				
					JLabel DATOFIFO = new JLabel("");
					DATOFIFO.setBounds(753, 3, 45, 25);
					DATOFIFO.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					pannelloFIFO.add(DATOFIFO);
					
		//PANNELLO OPT
		JPanel pannelloOPT = new JPanel();
					pannelloOPT.setBounds(10, 155, 1121, 150);
					pannelloGrafici.add(pannelloOPT);
					pannelloOPT.setLayout(null);
					pannelloOPT.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
		
					JLabel OPT = new JLabel("OPT");
					OPT.setHorizontalAlignment(SwingConstants.CENTER);
					OPT.setForeground(Color.RED);
					OPT.setFont(new Font("Tahoma", Font.PLAIN, 20));
					OPT.setBounds(10, 3, 489, 25);
					pannelloOPT.add(OPT);
				
					JLabel lblPageFaultsOPT = new JLabel("Page faults:");
					lblPageFaultsOPT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					lblPageFaultsOPT.setBounds(670, 3, 78, 25);
					pannelloOPT.add(lblPageFaultsOPT);
				
					JLabel DATOOPT = new JLabel("");
					DATOOPT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					DATOOPT.setBounds(758, 3, 45, 25);
					pannelloOPT.add(DATOOPT);

		//PANNELLO LRU
		JPanel pannelloLRU = new JPanel();
					pannelloLRU.setLayout(null);
					pannelloLRU.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloLRU.setBounds(10, 310, 1121, 150);
					pannelloGrafici.add(pannelloLRU);
				
					JLabel LRU = new JLabel("LRU");
					LRU.setHorizontalAlignment(SwingConstants.CENTER);
					LRU.setForeground(Color.RED);
					LRU.setFont(new Font("Tahoma", Font.PLAIN, 20));
					LRU.setBounds(10, 3, 489, 25);
					pannelloLRU.add(LRU);
				
					JLabel lblPageFaultsLRU = new JLabel("Page faults:");
					lblPageFaultsLRU.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					lblPageFaultsLRU.setBounds(670, 3, 81, 25);
					pannelloLRU.add(lblPageFaultsLRU);
		
					JLabel DATOLRU = new JLabel("");
					DATOLRU.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					DATOLRU.setBounds(761, 3, 45, 25);
					pannelloLRU.add(DATOLRU);

	
		//PANNELLO CLOCK
		JPanel pannelloCLOCK = new JPanel();
					pannelloCLOCK.setLayout(null);
					pannelloCLOCK.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloCLOCK.setBounds(10, 465, 1121, 150);
					pannelloGrafici.add(pannelloCLOCK);
				
					JLabel clock = new JLabel("Clock");
					clock.setHorizontalAlignment(SwingConstants.CENTER);
					clock.setForeground(Color.RED);
					clock.setFont(new Font("Tahoma", Font.PLAIN, 20));
					clock.setBounds(10, 3, 489, 25);
					pannelloCLOCK.add(clock);
				
					JLabel lblPageFaultClock = new JLabel("Page faults:");
					lblPageFaultClock.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					lblPageFaultClock.setBounds(670, 3, 82, 25);
					pannelloCLOCK.add(lblPageFaultClock);
		
					JLabel DATOCLOCK = new JLabel("");
					DATOCLOCK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					DATOCLOCK.setBounds(762, 3, 45, 25);
					pannelloCLOCK.add(DATOCLOCK);

			
/**						PANNELLI CON GRAFICO CARTESIANO						*/			
				
		//GRAFICO FIFO
		PanelGraficiPaginazioneMemoria jPanelFIFO = new PanelGraficiPaginazioneMemoria();
			jPanelFIFO.setBounds(590, 29, 525, 118);
			jPanelFIFO.setBackground(new java.awt.Color(255, 255, 255));
			jPanelFIFO.setLayout(null);
			pannelloFIFO.add(jPanelFIFO);

		//GRAFICO OPT
		PanelGraficiPaginazioneMemoria jPanelOPT = new PanelGraficiPaginazioneMemoria();
			jPanelOPT.setBackground(new java.awt.Color(255, 255, 255));
			jPanelOPT.setLayout(null);
			jPanelOPT.setBounds(590, 29, 525, 118);
			pannelloOPT.add(jPanelOPT);

		//GRAFICO LRU
		PanelGraficiPaginazioneMemoria jPanelLRU = new PanelGraficiPaginazioneMemoria();
			jPanelLRU.setBackground(new java.awt.Color(255, 255, 255));
			jPanelLRU.setLayout(null);
			jPanelLRU.setBounds(590, 29, 525, 118);
			pannelloLRU.add(jPanelLRU);
		
		//GRAFICO CLOCK
		PanelGraficiPaginazioneMemoria jPanelCLOCK = new PanelGraficiPaginazioneMemoria();
			jPanelCLOCK.setBackground(new java.awt.Color(255, 255, 255));
			jPanelCLOCK.setLayout(null);
			jPanelCLOCK.setBounds(590, 29, 525, 118);
			pannelloCLOCK.add(jPanelCLOCK);

			
/**						PANNELLI CON GRAFICO MATRICI							*/			
			
		//GRAFICO FIFO
		PanelGraficiMatricePaginazioneDellaMemoria jPanelFIFOMATRICE = new PanelGraficiMatricePaginazioneDellaMemoria();
			jPanelFIFOMATRICE.setBounds(20, 29, 560, 118);
			jPanelFIFOMATRICE.setLayout(null);
			pannelloFIFO.add(jPanelFIFOMATRICE);

		//GRAFICO OPT
		PanelGraficiMatricePaginazioneDellaMemoria jPanelOPTMATRICE = new PanelGraficiMatricePaginazioneDellaMemoria();
			jPanelOPTMATRICE.setLayout(null);
			jPanelOPTMATRICE.setBounds(20, 29, 560, 118);
			pannelloOPT.add(jPanelOPTMATRICE);

		//GRAFICO LRU
		PanelGraficiMatricePaginazioneDellaMemoria jPanelLRUMATRICE = new PanelGraficiMatricePaginazioneDellaMemoria();
			jPanelLRUMATRICE.setLayout(null);
			jPanelLRUMATRICE.setBounds(20, 29, 560, 118);
			pannelloLRU.add(jPanelLRUMATRICE);
		
		//GRAFICO CLOCK
		PanelGraficiMatricePaginazioneDellaMemoria jPanelCLOCKMATRICE = new PanelGraficiMatricePaginazioneDellaMemoria();
			jPanelCLOCKMATRICE.setLayout(null);
			jPanelCLOCKMATRICE.setBounds(20, 29, 560, 118);
			pannelloCLOCK.add(jPanelCLOCKMATRICE);
		

/**						PANNELLO DI CONTROLLO						*/		
			
		JPanel panelDiControllo = new JPanel();
			panelDiControllo.setLayout(null);
			//panelDiControllo.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
			panelDiControllo.setBounds(1141, 85, 265, 668);
			pannelloPrincipale.add(panelDiControllo);
			
		JPanel pannelloTitoloDC = new JPanel();
			pannelloTitoloDC.setLayout(null);
			pannelloTitoloDC.setBorder(new LineBorder(new Color(0, 153, 0), 4));
			//panel_2.setBackground(new Color(255, 255, 255));
			pannelloTitoloDC.setBounds(10, 10, 245, 54);
			panelDiControllo.add(pannelloTitoloDC);
			
		JLabel labelPnlCtrl = new JLabel("Pannello di controllo");
			labelPnlCtrl.setHorizontalAlignment(SwingConstants.CENTER);
			labelPnlCtrl.setFont(new Font("Arial", Font.BOLD, 22));
			labelPnlCtrl.setBounds(0, 0, 245, 54);
			pannelloTitoloDC.add(labelPnlCtrl);
			
		JLabel labelEditor = new JLabel("Editor");
			labelEditor.setHorizontalAlignment(SwingConstants.CENTER);
			labelEditor.setForeground(Color.RED);
			labelEditor.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelEditor.setBounds(0, 70, 265, 25);
			panelDiControllo.add(labelEditor);
			
		JPanel pannelloEditor = new JPanel();
			pannelloEditor.setLayout(null);
			//pannelloEditor.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
			pannelloEditor.setBounds(10, 95, 245, 246);
			panelDiControllo.add(pannelloEditor);
			
		JLabel lblSlotMemoria = new JLabel("Slot Memoria Disponibili");
			lblSlotMemoria.setHorizontalAlignment(SwingConstants.CENTER);
			lblSlotMemoria.setForeground(Color.BLACK);
			lblSlotMemoria.setFont(new Font("Arial", Font.BOLD, 14));
			lblSlotMemoria.setBounds(0, 2, 181, 23);
			pannelloEditor.add(lblSlotMemoria);
			
		JComboBox SceltaSlotDisponibili = new JComboBox();
			SceltaSlotDisponibili.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
			SceltaSlotDisponibili.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			SceltaSlotDisponibili.setBackground(Color.WHITE);
			SceltaSlotDisponibili.setBounds(185, 2, 50, 21);
			pannelloEditor.add(SceltaSlotDisponibili);
			
		JButton generaGrafici = new JButton("GENERA GRAFICI");
			generaGrafici.setEnabled(false);
			generaGrafici.setBorder(new LineBorder(new Color(0, 204, 0), 2));
			generaGrafici.setBackground(new Color(255, 255, 255));
			generaGrafici.setFont(new Font("Tahoma", Font.PLAIN, 15));
			generaGrafici.setBounds(10, 137, 225, 21);
			pannelloEditor.add(generaGrafici);
			
		JLabel labelPlay = new JLabel(">");
			labelPlay.setEnabled(false);
			labelPlay.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			labelPlay.setBounds(44, 168, 39, 35);
			labelPlay.setIcon(new ImageIcon(Hashing.class.getResource("/img/playIcon2.png")));
			pannelloEditor.add(labelPlay);
			
		JLabel labelScrittaPlay = new JLabel("Codifica Tutto");
			labelScrittaPlay.setHorizontalAlignment(SwingConstants.CENTER);
			labelScrittaPlay.setFont(new Font("Tahoma", Font.PLAIN, 11));
			labelScrittaPlay.setEnabled(false);
			labelScrittaPlay.setBounds(28, 213, 75, 17);
			pannelloEditor.add(labelScrittaPlay);
			
		JLabel labelScrittaFast = new JLabel("Codifica Passo");
			labelScrittaFast.setHorizontalAlignment(SwingConstants.CENTER);
			labelScrittaFast.setFont(new Font("Tahoma", Font.PLAIN, 11));
			labelScrittaFast.setEnabled(false);
			labelScrittaFast.setBounds(124, 213, 75, 17);
			pannelloEditor.add(labelScrittaFast);
			
		JLabel labelFastForward = new JLabel(">>");
			labelFastForward.setIcon(new ImageIcon(Hashing.class.getResource("/img/fastFowardIcon1.png")));
			labelFastForward.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			labelFastForward.setEnabled(false);
			labelFastForward.setBounds(142, 168, 39, 35);
			pannelloEditor.add(labelFastForward);
			
		JButton btnGeneraSuccessione = new JButton("Genera successione");
			btnGeneraSuccessione.setBackground(new Color(255, 255, 255));
			btnGeneraSuccessione.setBorder(new LineBorder(new Color(0, 204, 255), 2));
			btnGeneraSuccessione.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnGeneraSuccessione.setBounds(10, 32, 225, 32);
			pannelloEditor.add(btnGeneraSuccessione);
			
		JPanel pannelloHelp = new JPanel();
			pannelloHelp.setLayout(null);
			pannelloHelp.setBounds(10, 380, 245, 258);
			panelDiControllo.add(pannelloHelp);
			
		JScrollPane scrollPaneHelp = new JScrollPane();
			scrollPaneHelp.setBounds(0, 0, 245, 258);
			//scrollPaneHelp.setBorder(new LineBorder(new Color(255, 204, 0), 3));
			pannelloHelp.add(scrollPaneHelp);
		
		JTextArea txtrHelpArea = new JTextArea();
			scrollPaneHelp.setViewportView(txtrHelpArea);
			txtrHelpArea.setWrapStyleWord(true);
			txtrHelpArea.setLineWrap(true);
			txtrHelpArea.setText("FIFO (First In First Out).\r\nE' la pi\u00F9 semplice, si tiene traccia in una tabella di quando \u00E8 stata allocata un'area di memoria. Quando vi \u00E8 una nuova richiesta di allocazione di pagine di memoria, se c'\u00E8 ancora spazio in memoria principale, semplicemente viene allocata la nuova pagina, altrimenti si consulta mediante la tabella quali sono le pagine allocate da pi\u00F9 tempo e si spostano in memoria secondaria.\r\nQuesto algoritmo \u00E8 molto semplice e di rapida esecuzione ma ha lo svantaggio di spostare in memoria secondaria le pagine pi\u00F9 vecchie anche se sono utilizzate di frequente.\r\n\r\nOPT\r\nSi sostituisce la pagina che non si user\u00E0 per il periodo di tempo pi\u00F9 lungo. Non \u00E8 possibile conoscere in anticipo la successione dei riferimenti, viene usato principalmente per studi comparativi, per valutare le prestazioni degli algoritmi.\r\n\r\nLRU (Least Recently Used)\r\nVengono sostituite le pagine usate meno di recente, poich\u00E8 queste hanno buona probabilit\u00E0 di non essere nuovamente utilizzate nell'immediato.\r\n");
			txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
			txtrHelpArea.setEditable(false);
		
		JTextField stringaNumeri = new JTextField();
			stringaNumeri.setBackground(Color.WHITE);
			stringaNumeri.setEditable(false);
			stringaNumeri.setFont(new Font("Arial", Font.BOLD, 10));
			stringaNumeri.setHorizontalAlignment(SwingConstants.CENTER);
			stringaNumeri.setBounds(10, 97, 225, 23);
			pannelloEditor.add(stringaNumeri);
			stringaNumeri.setColumns(10);
			
		JLabel lblSuccessioneDiRiferimento = new JLabel("Successione di riferimento:");
			lblSuccessioneDiRiferimento.setBounds(10, 70, 225, 23);
			pannelloEditor.add(lblSuccessioneDiRiferimento);
			lblSuccessioneDiRiferimento.setHorizontalAlignment(SwingConstants.CENTER);
			lblSuccessioneDiRiferimento.setForeground(Color.BLACK);
			lblSuccessioneDiRiferimento.setFont(new Font("Arial", Font.BOLD, 14));
			
		JLabel lblHelp = new JLabel("Spiegazione Argomento");
			lblHelp.setBounds(10, 354, 245, 25);
			panelDiControllo.add(lblHelp);
			lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
			lblHelp.setForeground(Color.RED);
			lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
		JLabel labelHelpIcon = new JLabel("Help");
			labelHelpIcon.setBounds(282, 75, 34, 46);
			pannelloPrincipale.add(labelHelpIcon);
	        labelHelpIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/question.png")));
	        
	    JLabel lblInfouso = new JLabel("Info/Uso");
	        lblInfouso.setHorizontalAlignment(SwingConstants.CENTER);
	        lblInfouso.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblInfouso.setBounds(273, 119, 59, 12);
	        pannelloPrincipale.add(lblInfouso);

			
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
/**							IMPLEMENTAZIONE EVENTI												*/
		
	/*		stringaNumeri.addKeyListener(new KeyAdapter() {
		         public void keyTyped(KeyEvent e) {
		             char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
		                  e.consume();  //Ignora l'evento
		             }
		         }
		      });
			
*/
		
	//EVENTO GENERAZIONE STRINGA DI NUMERI
		btnGeneraSuccessione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				labelFastForward.setEnabled(true);
				labelScrittaFast.setEnabled(true);
				labelScrittaPlay.setEnabled(true);
				labelPlay.setEnabled(true);
				
				stringaNumeri.setText("");
				numeri=new int[25];

				DATOFIFO.setText("");
				numeriFIFO=new int[25];
				pfFIFO=new int[12];
				jPanelFIFOMATRICE.resetGrafico(jPanelFIFOMATRICE.getGraphics());
				jPanelFIFO.resetGrafico(jPanelFIFO.getGraphics());
				
				for (int i=0;i<25;i++) { 
					pieno=1;
					Random random = new Random();
					int value = random.nextInt(10 + 0) + 0;
					stringaNumeri.setText(stringaNumeri.getText()+" "+value);
					numeri[i]=value;
				}
				generaGrafici.setEnabled(true);

			}
			@Override
			public void mouseEntered(MouseEvent e) {
					
				btnGeneraSuccessione.setBackground(new Color(51, 204, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {

				btnGeneraSuccessione.setBackground(new Color(255, 255, 255));
			}
		});
			
	
	//EVENTO SU BOTTONE GENERA GRAFICI
		generaGrafici.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(generaGrafici.isEnabled()) {
					generaGrafici.setEnabled(false);
					//GENERAZIONE GRAFICI
					pfFIFO=FIFOGrafico(numeri);
					jPanelFIFO.disegnaSoluzione(jPanelFIFO.getGraphics(), pfFIFO);
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				if (generaGrafici.isEnabled()) {
					
					generaGrafici.setBackground(new Color(0, 204, 0));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if (generaGrafici.isEnabled()) {
					
					generaGrafici.setBackground(Color.white);
				}
				else {
					
					generaGrafici.setBackground(Color.white);
				}
			}
		});

	//EVENTO SUI BOTTONI PLAY O PLAYSTEPbySTEP
		labelPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
			
				labelFastForward.setEnabled(false);
				labelScrittaFast.setEnabled(false);
				labelPlay.setEnabled(false);
				labelScrittaPlay.setEnabled(false);
				
				//GENERAZIONE MATRICI
				String j= SceltaSlotDisponibili.getSelectedItem().toString();
				int s=Integer.valueOf(j);
				
				numeriFIFO=FIFO(numeri,s);
				DATOFIFO.setText(String.valueOf(pagefaultFIFO));
				jPanelFIFOMATRICE.disegnaSoluzioneFIFO(jPanelFIFOMATRICE.getGraphics(),numeriFIFO,s,pagefaultFIFO);

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				labelScrittaPlay.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e){
				
				labelScrittaPlay.setForeground(Color.BLACK);
			}
		});
		
		labelFastForward.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				
				labelPlay.setEnabled(false);
				labelScrittaPlay.setEnabled(false);
			}
			@Override
			public void mouseEntered(MouseEvent e){
				
				labelScrittaFast.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				labelScrittaFast.setForeground(Color.BLACK);
			}
		});
		
	//EVENTO SU CAMPO DI SLOT DISPONIBILI

		SceltaSlotDisponibili.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pieno==0) {
				
				}
				else {
					generaGrafici.setEnabled(true);
					
					labelFastForward.setEnabled(true);
					labelScrittaFast.setEnabled(true);
					labelScrittaPlay.setEnabled(true);
					labelPlay.setEnabled(true);
					
					DATOFIFO.setText("");
					numeriFIFO=new int[25];
					jPanelFIFOMATRICE.resetGrafico(jPanelFIFOMATRICE.getGraphics());

				}
			
			}
		});
	}
	
/**										IMPLEMENTAZIONE METODI RICHIAMATI E USATI SOPRA 											*/
	
//ALGORITMO CALCOLO PUNTI FIFO MATRICE
	int[] FIFO(int incomingStream[], int frames){
		
		int[] arrayFIFO = new int[25];
	    int page_faults = 0;
	
		for (int j=0; j < arrayFIFO.length;) {
		
		    for (int i=0; i < incomingStream.length; i++) {
		        int flag=0;
		    	if(i-frames<0) {
		    		
		    		for(int k=1;k<=frames;k++) {
		    			if(i-k>=0) {
		    				if(incomingStream[i]==incomingStream[i-k]) flag=1;
		    			}
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		page_faults++;
		        		j++;
		    		}	    		
		    	}
		    	else if(i-frames>=0) {
		    		flag=0;
		    		for(int k=1;k<=frames;k++) {
		    			if(j-k>=0)	if(incomingStream[i]==arrayFIFO[j-k]) flag=1;
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		page_faults++;
		        		j++;
		    		}
		    	}
		    }
		    j=26;
		}
	
	    pagefaultFIFO=page_faults;
	    return arrayFIFO;
	}

//ALGORITMO CALCOLO PUNTI FIFO GRFICO
	int[] FIFOGrafico(int incomingStream[]){
		
		int[] arrayPunti = new int[12];
		int[] arrayFIFO = new int[25];
	    int pf1 = 0, pf2 = 0, pf3 = 0, pf4 = 0, pf5 = 0, pf6 = 0;
	    int frames1=1, frames2=2, frames3=3, frames4=4, frames5=5, frames6=6;
	    
		for (int j=0; j < arrayFIFO.length;) {
		
		    for (int i=0; i < incomingStream.length; i++) {
		    	//PAGFAULT1
		        int flag=0;
		    	if(i-frames1<0) {
		    		
		    		for(int k=1;k<=frames1;k++) {
		    			if(i-k>=0) {
		    				if(incomingStream[i]==incomingStream[i-k]) flag=1;
		    			}
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		pf1++;
		        		j++;
		    		}	    		
		    	}
		    	else if(i-frames1>=0) {
		    		flag=0;
		    		for(int k=1;k<=frames1;k++) {
		    			if(j-k>=0)	if(incomingStream[i]==arrayFIFO[j-k]) flag=1;
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		pf1++;
		        		j++;
		    		}
		    	}
		    }
		    j=26;

		}
		for (int j=0; j < arrayFIFO.length;) {
			
		    for (int i=0; i < incomingStream.length; i++) {    	
		    	//PAGFAULT2
		        int flag=0;
		    	if(i-frames2<0) {
		    		
		    		for(int k=1;k<=frames2;k++) {
		    			if(i-k>=0) {
		    				if(incomingStream[i]==incomingStream[i-k]) flag=1;
		    			}
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		    			pf2++;
		        		j++;
		    		}	    		
		    	}
		    	else if(i-frames2>=0) {
		    		flag=0;
		    		for(int k=1;k<=frames2;k++) {
		    			if(j-k>=0)	if(incomingStream[i]==arrayFIFO[j-k]) flag=1;
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		pf2++;
		        		j++;
		    		}
		    	}
		    }
		    j=26;

		}
		for (int j=0; j < arrayFIFO.length;) {
			
		    for (int i=0; i < incomingStream.length; i++) {
		    	//PAGFAULT3
		    	int flag=0;
		    	if(i-frames3<0) {
		    		
		    		for(int k=1;k<=frames3;k++) {
		    			if(i-k>=0) {
		    				if(incomingStream[i]==incomingStream[i-k]) flag=1;
		    			}
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		pf3++;
		        		j++;
		    		}	    		
		    	}
		    	else if(i-frames3>=0) {
		    		flag=0;
		    		for(int k=1;k<=frames3;k++) {
		    			if(j-k>=0)	if(incomingStream[i]==arrayFIFO[j-k]) flag=1;
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		pf3++;
		        		j++;
		    		}
		    	}
		    }
		    j=26;

		}		
		for (int j=0; j < arrayFIFO.length;) {
		
		    for (int i=0; i < incomingStream.length; i++) {
		    	//PAGFAULT4
		        int flag=0;
		    	if(i-frames4<0) {
		    		
		    		for(int k=1;k<=frames4;k++) {
		    			if(i-k>=0) {
		    				if(incomingStream[i]==incomingStream[i-k]) flag=1;
		    			}
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		pf4++;
		        		j++;
		    		}	    		
		    	}
		    	else if(i-frames4>=0) {
		    		flag=0;
		    		for(int k=1;k<=frames4;k++) {
		    			if(j-k>=0)	if(incomingStream[i]==arrayFIFO[j-k]) flag=1;
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		pf4++;
		        		j++;
		    		}
		    	}
		    }
		    j=26;

		}
		for (int j=0; j < arrayFIFO.length;) {
			
		    for (int i=0; i < incomingStream.length; i++) {
		    	//PAGFAULT5
		    	int flag=0;
		    	if(i-frames5<0) {
		    		
		    		for(int k=1;k<=frames5;k++) {
		    			if(i-k>=0) {
		    				if(incomingStream[i]==incomingStream[i-k]) flag=1;
		    			}
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		pf5++;
		        		j++;
		    		}	    		
		    	}
		    	else if(i-frames5>=0) {
		    		flag=0;
		    		for(int k=1;k<=frames5;k++) {
		    			if(j-k>=0)	if(incomingStream[i]==arrayFIFO[j-k]) flag=1;
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		pf5++;
		        		j++;
		    		}
		    	}
		    }
		    j=26;

		}
		for (int j=0; j < arrayFIFO.length;) {
			
		    for (int i=0; i < incomingStream.length; i++) {
		    	//PAGFAULT6
		        int flag=0;
		    	if(i-frames6<0) {
		    		
		    		for(int k=1;k<=frames6;k++) {
		    			if(i-k>=0) {
		    				if(incomingStream[i]==incomingStream[i-k]) flag=1;
		    			}
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		pf6++;
		        		j++;
		    		}	    		
		    	}
		    	else if(i-frames6>=0) {
		    		flag=0;
		    		for(int k=1;k<=frames6;k++) {
		    			if(j-k>=0)	if(incomingStream[i]==arrayFIFO[j-k]) flag=1;
		    		}
		    		if(flag==0) {
		    			arrayFIFO[j]=incomingStream[i];
		        		pf6++;
		        		j++;
		    		}
		    	}
		    }
		    j=26;
		}
		
		arrayPunti[0]=1;
		arrayPunti[1]=pf1;
		arrayPunti[2]=2;
		arrayPunti[3]=pf2;
		arrayPunti[4]=3;
		arrayPunti[5]=pf3;
		arrayPunti[6]=4;
		arrayPunti[7]=pf4;
		arrayPunti[8]=5;
		arrayPunti[9]=pf5;
		arrayPunti[10]=6;
		arrayPunti[11]=pf6;

	    return arrayPunti;
	}

//ALGORITMO CALCOLO PUNTI LRU MATRICE
	int[] LRU(int reference[], int frames){
		
		        int pointer = 0, hit = 0, fault = 0,ref_len;
		        Boolean isFull = false;
		        int buffer[];
		        ArrayList<Integer> stack = new ArrayList<Integer>();
		        int mem_layout[][];
		        
		        ref_len = reference.length;
		        
		        mem_layout = new int[ref_len][frames];
		        buffer = new int[frames];
		        for(int j = 0; j < frames; j++)
		                buffer[j] = -1;
		        

		        for(int i = 0; i < ref_len; i++)
		        {
		            if(stack.contains(reference[i]))
		            {
		             stack.remove(stack.indexOf(reference[i]));
		            }
		            stack.add(reference[i]);
		            int search = -1;
		            for(int j = 0; j < frames; j++)
		            {
		                if(buffer[j] == reference[i])
		                {
		                    search = j;
		                    hit++;
		                    break;
		                }
		            }
		            if(search == -1)
		            {
		             if(isFull)
		             {
		              int min_loc = ref_len;
		                    for(int j = 0; j < frames; j++)
		                    {
		                     if(stack.contains(buffer[j]))
		                        {
		                            int temp = stack.indexOf(buffer[j]);
		                            if(temp < min_loc)
		                            {
		                                min_loc = temp;
		                                pointer = j;
		                            }
		                        }
		                    }
		             }
		                buffer[pointer] = reference[i];
		                fault++;
		                pointer++;
		                if(pointer == frames)
		                {
		                 pointer = 0;
		                 isFull = true;
		                }
		            }
		            for(int j = 0; j < frames; j++)
		                mem_layout[i][j] = buffer[j];
		        }
		        
		        for(int i = 0; i < frames; i++)
		        {
		            for(int j = 0; j < ref_len; j++)
		                //System.out.printf("%3d ",mem_layout[j][i]);
		            System.out.println();
		        }

		        pagefaultLRU=fault;
		        return reference;
	}  
		

//ALGORITMO CALCOLO PUNTI OPT MATRICE
	int[] OPT(int reference[], int frames){
		
	    int  pointer = 0, hit = 0, fault = 0,ref_len;
	    boolean isFull = false;
	    int buffer[];
	    int mem_layout[][];
	    
	    ref_len = reference.length;
	    mem_layout = new int[ref_len][frames];
	    buffer = new int[frames];
	    for(int j = 0; j < frames; j++)
	            buffer[j] = -1;
	    
	    
	    for(int i = 0; i < ref_len; i++)
	    {
	     int search = -1;
	     for(int j = 0; j < frames; j++)
	     {
	      if(buffer[j] == reference[i])
	      {
	       search = j;
	       hit++;
	       break;
	      } 
	     }
	     if(search == -1)
	     {
	      if(isFull)
	      {
	       int index[] = new int[frames];
	       boolean index_flag[] = new boolean[frames];
	       for(int j = i + 1; j < ref_len; j++)
	       {
	        for(int k = 0; k < frames; k++)
	        {
	         if((reference[j] == buffer[k]) && (index_flag[k] == false))
	         {
	          index[k] = j;
	          index_flag[k] = true;
	          break;
	         }
	        }
	       }
	       int max = index[0];
	       pointer = 0;
	       if(max == 0)
	        max = 200;
	       for(int j = 0; j < frames; j++)
	       {
	        if(index[j] == 0)
	         index[j] = 200;
	        if(index[j] > max)
	        {
	         max = index[j];
	         pointer = j;
	        }
	       }
	      }
	      buffer[pointer] = reference[i];
	      fault++;
	      if(!isFull)
	      {
	       pointer++;
	          if(pointer == frames)
	          {
	           pointer = 0;
	           isFull = true;
	          }
	      }
	     }
	        for(int j = 0; j < frames; j++)
	            mem_layout[i][j] = buffer[j];
	    }
	    
	    for(int i = 0; i < frames; i++)
	    {
	        for(int j = 0; j < ref_len; j++)
	            System.out.printf("%3d ",mem_layout[j][i]);
	        System.out.println();
	    }
	    
	    pagefaultOPT=fault;
        return reference;
	}


//ALGORITMO CALCOLO PUNTI CLOCK MATRICE
	int[] CLOCK(int reference[], int frames){
		
		int  pointer = 0, hit = 0, fault = 0,ref_len;
        int buffer[][];
        int mem_layout[][];
        int used_layout[][];
        
        ref_len = reference.length;
        mem_layout = new int[ref_len][frames];
        used_layout = new int[ref_len][frames];
        buffer = new int[frames][2];
        for(int j = 0; j < frames; j++)
        {
         buffer[j][0] = -1;
         buffer[j][1] = 0;
        }
       
        for(int i = 0; i < ref_len; i++)
        {
         int search = -1;
         for(int j = 0; j < frames; j++)
         {
          if(buffer[j][0] == reference[i])
          {
           search = j;
           hit++;
           buffer[j][1] = 1;
           break;
          } 
         }
         if(search == -1)
         {
          
          while(buffer[pointer][1] == 1)
          {
           buffer[pointer][1] = 0;
           pointer++;
           if(pointer == frames)
            pointer = 0;
          }
          buffer[pointer][0] = reference[i];
          buffer[pointer][1] = 1;
          fault++;
          pointer++;
          if(pointer == frames)
           pointer = 0;
         }
            for(int j = 0; j < frames; j++)
   {
    mem_layout[i][j] = buffer[j][0];
    used_layout[i][j] = buffer[j][1];
   }
        }
        
        for(int i = 0; i < frames; i++)
        {
            for(int j = 0; j < ref_len; j++)
                System.out.printf("%3d %d ",mem_layout[j][i],used_layout[j][i]);
            System.out.println();
        }
        
        pagefaultCLOCK=fault;
        return reference;
    }
}



