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
import java.awt.Component;


public class PaginazioneDellaMemoria extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private int pieno=0;
	private int[] numeri;
	private int[][] numeriFIFO;
	private int[][] numeriLRU;
	private int[][] numeriOPT;
	private int[][] numeriCLOCK;

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
		        
	        JLabel labelScrittaYoutube = new JLabel("Videolezione");
		        labelScrittaYoutube.setHorizontalAlignment(SwingConstants.CENTER);
		        labelScrittaYoutube.setFont(new Font("Tahoma", Font.PLAIN, 13));
		        labelScrittaYoutube.setBounds(1171, 120, 95, 12);
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
		        labelYoutubeIcon.setBounds(1196, 75, 53, 46);
		        pannelloPrincipale.add(labelYoutubeIcon);
		        
	        JLabel labelScrittaSlide = new JLabel("Slide Argomento");
		        labelScrittaSlide.setFont(new Font("Tahoma", Font.PLAIN, 13));
		        labelScrittaSlide.setBounds(1259, 119, 95, 15);
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
		        labelSlideIcon.setBounds(1276, 75, 53, 46);
		        pannelloPrincipale.add(labelSlideIcon);
		
/**							PANNELLO TITOLO									*/
		JPanel pannelloTitolo = new JPanel();
		pannelloTitolo.setBackground(Color.WHITE);
			pannelloTitolo.setBorder(new LineBorder(new Color(0, 153, 0), 10));
			pannelloTitolo.setBounds(0, 0, 1416, 75);
			pannelloPrincipale.add(pannelloTitolo);
			pannelloTitolo.setLayout(null);
			
		//TITOLO
		JLabel labelTitolo = new JLabel("PAGINAZIONE DELLA MEMORIA");
			labelTitolo.setForeground(new Color(0, 0, 0));
			labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitolo.setFont(new Font("Segoe UI", Font.BOLD, 40));
			labelTitolo.setBounds(79, 0, 1104, 73);
			pannelloTitolo.add(labelTitolo);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/img/logounina.png")));
			lblNewLabel.setBounds(10, 10, 200, 55);
			pannelloTitolo.add(lblNewLabel);
			
/*-----------------------------------------------------------------------------------------------------------------------------*/
			
/*INIZIO GUI COMPLICATA*/		

/**							PANNELLO GRAFICI								*/
		JPanel pannelloGrafici = new JPanel();
	        pannelloGrafici.setBounds(0, 86, 1131, 667);
	        pannelloPrincipale.add(pannelloGrafici);
	        pannelloGrafici.setLayout(null);
        
        //PANNELLO FIFO
        JPanel pannelloFIFO = new JPanel();
		        	pannelloFIFO.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloFIFO.setBounds(5, 5, 1121, 160);
					pannelloGrafici.add(pannelloFIFO);
					pannelloFIFO.setLayout(null);
		
					JLabel FIFO = new JLabel("FIFO");
					FIFO.setHorizontalAlignment(SwingConstants.CENTER);
					FIFO.setBounds(36, 0, 28, 157);
					FIFO.setForeground(Color.RED);
					FIFO.setFont(new Font("Tahoma", Font.PLAIN, 35));
					pannelloFIFO.add(FIFO);
					FIFO.setText(transformStringToHtml(FIFO.getText()));
					
					JLabel lblPageFaultsFIFO = new JLabel("Page faults correnti:");
					lblPageFaultsFIFO.setBounds(598, 1, 125, 18);
					pannelloFIFO.add(lblPageFaultsFIFO);
					lblPageFaultsFIFO.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					
					JLabel DATOFIFO = new JLabel("");
					DATOFIFO.setBounds(725, 1, 38, 18);
					pannelloFIFO.add(DATOFIFO);
					DATOFIFO.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		//PANNELLO OPT
		JPanel pannelloOPT = new JPanel();
					pannelloOPT.setBounds(5, 170, 1121, 160);
					pannelloGrafici.add(pannelloOPT);
					pannelloOPT.setLayout(null);
					pannelloOPT.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
		
					JLabel OPT = new JLabel("OPT");
					OPT.setHorizontalAlignment(SwingConstants.CENTER);
					OPT.setForeground(Color.RED);
					OPT.setFont(new Font("Tahoma", Font.PLAIN, 35));
					OPT.setBounds(36, 0, 28, 157);
					pannelloOPT.add(OPT);
					OPT.setText(transformStringToHtml(OPT.getText()));

					JLabel lblPageFaultsOPT = new JLabel("Page faults correnti:");
					lblPageFaultsOPT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					lblPageFaultsOPT.setBounds(598, 1, 125, 18);
					pannelloOPT.add(lblPageFaultsOPT);
				
					JLabel DATOOPT = new JLabel("");
					DATOOPT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					DATOOPT.setBounds(725, 1, 38, 18);
					pannelloOPT.add(DATOOPT);

		//PANNELLO LRU
		JPanel pannelloLRU = new JPanel();
					pannelloLRU.setLayout(null);
					pannelloLRU.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloLRU.setBounds(5, 335, 1121, 160);
					pannelloGrafici.add(pannelloLRU);
				
					JLabel LRU = new JLabel("LRU");
					LRU.setHorizontalAlignment(SwingConstants.CENTER);
					LRU.setForeground(Color.RED);
					LRU.setFont(new Font("Tahoma", Font.PLAIN, 35));
					LRU.setBounds(36, 0, 28, 157);
					pannelloLRU.add(LRU);
					LRU.setText(transformStringToHtml(LRU.getText()));

					JLabel lblPageFaultsLRU = new JLabel("Page faults correnti:");
					lblPageFaultsLRU.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					lblPageFaultsLRU.setBounds(598, 1, 125, 18);
					pannelloLRU.add(lblPageFaultsLRU);
		
					JLabel DATOLRU = new JLabel("");
					DATOLRU.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					DATOLRU.setBounds(725, 1, 38, 18);
					pannelloLRU.add(DATOLRU);

	
		//PANNELLO CLOCK
		JPanel pannelloCLOCK = new JPanel();
					pannelloCLOCK.setLayout(null);
					pannelloCLOCK.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
					pannelloCLOCK.setBounds(5, 500, 1121, 160);
					pannelloGrafici.add(pannelloCLOCK);
				
					JLabel clock = new JLabel("Clock");
					clock.setHorizontalAlignment(SwingConstants.CENTER);
					clock.setForeground(Color.RED);
					clock.setFont(new Font("Tahoma", Font.PLAIN, 25));
					clock.setBounds(36, 0, 28, 157);
					pannelloCLOCK.add(clock);
					clock.setText(transformStringToHtml(clock.getText()));

					JLabel lblPageFaultClock = new JLabel("Page faults correnti:");
					lblPageFaultClock.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					lblPageFaultClock.setBounds(598, 1, 125, 18);
					pannelloCLOCK.add(lblPageFaultClock);
		
					JLabel DATOCLOCK = new JLabel("");
					DATOCLOCK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					DATOCLOCK.setBounds(725, 1, 38, 18);
					pannelloCLOCK.add(DATOCLOCK);

			
/**						PANNELLI CON GRAFICO CARTESIANO						*/			
				
		//GRAFICO FIFO
		PanelGraficiPaginazioneMemoria jPanelFIFO = new PanelGraficiPaginazioneMemoria();
			jPanelFIFO.setBounds(590, 21, 525, 118);
			jPanelFIFO.setBackground(new java.awt.Color(255, 255, 255));
			jPanelFIFO.setLayout(null);
			pannelloFIFO.add(jPanelFIFO);

		//GRAFICO OPT
		PanelGraficiPaginazioneMemoria jPanelOPT = new PanelGraficiPaginazioneMemoria();
			jPanelOPT.setBackground(new java.awt.Color(255, 255, 255));
			jPanelOPT.setLayout(null);
			jPanelOPT.setBounds(590, 21, 525, 118);
			pannelloOPT.add(jPanelOPT);

		//GRAFICO LRU
		PanelGraficiPaginazioneMemoria jPanelLRU = new PanelGraficiPaginazioneMemoria();
			jPanelLRU.setBackground(new java.awt.Color(255, 255, 255));
			jPanelLRU.setLayout(null);
			jPanelLRU.setBounds(590, 21, 525, 118);
			pannelloLRU.add(jPanelLRU);
		
		//GRAFICO CLOCK
		PanelGraficiPaginazioneMemoria jPanelCLOCK = new PanelGraficiPaginazioneMemoria();
			jPanelCLOCK.setBackground(new java.awt.Color(255, 255, 255));
			jPanelCLOCK.setLayout(null);
			jPanelCLOCK.setBounds(590, 21, 525, 118);
			pannelloCLOCK.add(jPanelCLOCK);

			
/**						PANNELLI CON GRAFICO MATRICI							*/			
			
		//GRAFICO FIFO
		PanelGraficiMatricePaginazioneDellaMemoria jPanelFIFOMATRICE = new PanelGraficiMatricePaginazioneDellaMemoria();
			jPanelFIFOMATRICE.setBounds(92, 0, 437, 147);
			jPanelFIFOMATRICE.setLayout(null);
			pannelloFIFO.add(jPanelFIFOMATRICE);
			
			JLabel numeroPageFault1 = new JLabel("Numero di page faults");
			numeroPageFault1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			numeroPageFault1.setHorizontalAlignment(SwingConstants.CENTER);
			numeroPageFault1.setBounds(590, 139, 521, 18);
			pannelloFIFO.add(numeroPageFault1);
			
			JLabel lblNewLabel1 = new JLabel("SLOT");
			lblNewLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel1.setBounds(570, 21, 15, 118);
			pannelloFIFO.add(lblNewLabel1);
			lblNewLabel1.setText(transformStringToHtml(lblNewLabel1.getText()));
			
		//GRAFICO OPT
		PanelGraficiMatricePaginazioneDellaMemoria jPanelOPTMATRICE = new PanelGraficiMatricePaginazioneDellaMemoria();
			jPanelOPTMATRICE.setLayout(null);
			jPanelOPTMATRICE.setBounds(92, 0, 437, 147);
			pannelloOPT.add(jPanelOPTMATRICE);

			JLabel numeroPageFault2 = new JLabel("Numero di page faults");
			numeroPageFault2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			numeroPageFault2.setHorizontalAlignment(SwingConstants.CENTER);
			numeroPageFault2.setBounds(590, 139, 521, 18);
			pannelloOPT.add(numeroPageFault2);
			
			JLabel lblNewLabel2 = new JLabel("SLOT");
			lblNewLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel2.setBounds(570, 21, 15, 118);
			pannelloOPT.add(lblNewLabel2);
			lblNewLabel2.setText(transformStringToHtml(lblNewLabel2.getText()));
			
		//GRAFICO LRU
		PanelGraficiMatricePaginazioneDellaMemoria jPanelLRUMATRICE = new PanelGraficiMatricePaginazioneDellaMemoria();
			jPanelLRUMATRICE.setLayout(null);
			jPanelLRUMATRICE.setBounds(92, 0, 437, 147);
			pannelloLRU.add(jPanelLRUMATRICE);
		
			JLabel numeroPageFault3 = new JLabel("Numero di page faults");
			numeroPageFault3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			numeroPageFault3.setHorizontalAlignment(SwingConstants.CENTER);
			numeroPageFault3.setBounds(590, 139, 521, 18);
			pannelloLRU.add(numeroPageFault3);
			
			JLabel lblNewLabel3 = new JLabel("SLOT");
			lblNewLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel3.setBounds(570, 21, 15, 118);
			pannelloLRU.add(lblNewLabel3);
			lblNewLabel3.setText(transformStringToHtml(lblNewLabel3.getText()));
			
		//GRAFICO CLOCK
		PanelGraficiMatricePaginazioneDellaMemoria jPanelCLOCKMATRICE = new PanelGraficiMatricePaginazioneDellaMemoria();
			jPanelCLOCKMATRICE.setLayout(null);
			jPanelCLOCKMATRICE.setBounds(92, 0, 437, 147);
			pannelloCLOCK.add(jPanelCLOCKMATRICE);
		
			JLabel numeroPageFault4 = new JLabel("Numero di page faults");
			numeroPageFault4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			numeroPageFault4.setHorizontalAlignment(SwingConstants.CENTER);
			numeroPageFault4.setBounds(590, 139, 521, 18);
			pannelloCLOCK.add(numeroPageFault4);

			JLabel lblNewLabel4 = new JLabel("SLOT");
			lblNewLabel4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel4.setBounds(570, 21, 15, 118);
			pannelloCLOCK.add(lblNewLabel4);
			lblNewLabel4.setText(transformStringToHtml(lblNewLabel4.getText()));
			
/**						PANNELLO DI CONTROLLO						*/		
			
		JPanel panelDiControllo = new JPanel();
			panelDiControllo.setLayout(null);
			//panelDiControllo.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
			panelDiControllo.setBounds(1141, 135, 265, 618);
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
			pannelloEditor.setBounds(10, 95, 245, 234);
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
			
		JButton generaGrafici = new JButton("CALCOLA GRAFICI");
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
			pannelloHelp.setBounds(10, 354, 245, 254);
			panelDiControllo.add(pannelloHelp);
			
		JScrollPane scrollPaneHelp = new JScrollPane();
			scrollPaneHelp.setBounds(0, 0, 245, 255);
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
			lblHelp.setBounds(10, 330, 245, 25);
			panelDiControllo.add(lblHelp);
			lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
			lblHelp.setForeground(Color.RED);
			lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
		JLabel labelHelpIcon = new JLabel("Help");
			labelHelpIcon.setBounds(1372, 75, 34, 46);
			pannelloPrincipale.add(labelHelpIcon);
	        labelHelpIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/question.png")));
	        
	    JLabel lblInfouso = new JLabel("Info/Uso");
	        lblInfouso.setHorizontalAlignment(SwingConstants.CENTER);
	        lblInfouso.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblInfouso.setBounds(1357, 120, 59, 12);
	        pannelloPrincipale.add(lblInfouso);

        	JLabel labelScrittaIndietro = new JLabel(" Indietro");
        	labelScrittaIndietro.setBounds(1133, 120, 53, 12);
        	pannelloPrincipale.add(labelScrittaIndietro);
        	labelScrittaIndietro.setFont(new Font("Tahoma", Font.PLAIN, 13));

	        JLabel labelIndietroIcon = new JLabel("Exit");
	        	labelIndietroIcon.setBounds(1141, 75, 34, 46);
	        	pannelloPrincipale.add(labelIndietroIcon);
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

				String j= SceltaSlotDisponibili.getSelectedItem().toString();
				int s=Integer.valueOf(j);
				
				DATOFIFO.setText("");
				numeriFIFO=new int[25][s];
				pfFIFO=new int[12];
				jPanelFIFOMATRICE.resetGrafico(jPanelFIFOMATRICE.getGraphics());
				jPanelFIFO.resetGrafico(jPanelFIFO.getGraphics());
				
				DATOOPT.setText("");
				numeriOPT=new int[25][s];
				pfOPT=new int[12];
				jPanelOPTMATRICE.resetGrafico(jPanelOPTMATRICE.getGraphics());
				jPanelOPT.resetGrafico(jPanelOPT.getGraphics());
				
				DATOLRU.setText("");
				numeriLRU=new int[25][s];
				pfLRU=new int[12];
				jPanelLRUMATRICE.resetGrafico(jPanelLRUMATRICE.getGraphics());
				jPanelLRU.resetGrafico(jPanelLRU.getGraphics());
				
				DATOCLOCK.setText("");
				numeriCLOCK=new int[25][s];
				pfCLOCK=new int[12];
				jPanelCLOCKMATRICE.resetGrafico(jPanelCLOCKMATRICE.getGraphics());
				jPanelCLOCK.resetGrafico(jPanelCLOCK.getGraphics());
				
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
					
					pfOPT=OPTGrafico(numeri);
					jPanelOPT.disegnaSoluzione(jPanelOPT.getGraphics(), pfOPT);
					
					pfLRU=LRUGrafico(numeri);
					jPanelLRU.disegnaSoluzione(jPanelLRU.getGraphics(), pfLRU);
					
					pfCLOCK=CLOCKGrafico(numeri);
					jPanelCLOCK.disegnaSoluzione(jPanelCLOCK.getGraphics(), pfCLOCK);
					
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
			
				if(labelPlay.isEnabled()) {
					labelFastForward.setEnabled(false);
					labelScrittaFast.setEnabled(false);
					labelPlay.setEnabled(false);
					labelScrittaPlay.setEnabled(false);
					
					//GENERAZIONE MATRICI
					String j= SceltaSlotDisponibili.getSelectedItem().toString();
					int s=Integer.valueOf(j);
					
					numeriFIFO=FIFO(numeri,s);
					DATOFIFO.setText(String.valueOf(pagefaultFIFO));
					jPanelFIFOMATRICE.disegnaSoluzioneFIFO(jPanelFIFOMATRICE.getGraphics(),numeriFIFO,s,pagefaultFIFO,numeri);
					
					numeriOPT=OPT(numeri,s);
					DATOOPT.setText(String.valueOf(pagefaultOPT));
					jPanelOPTMATRICE.disegnaSoluzioneOPT(jPanelOPTMATRICE.getGraphics(),numeriOPT,s,pagefaultOPT,numeri);
					
					numeriLRU=LRU(numeri,s);
					DATOLRU.setText(String.valueOf(pagefaultLRU));
					jPanelLRUMATRICE.disegnaSoluzioneLRU(jPanelLRUMATRICE.getGraphics(),numeriLRU,s,pagefaultLRU,numeri);
					
					numeriCLOCK=CLOCK(numeri,s);
					DATOCLOCK.setText(String.valueOf(pagefaultCLOCK));
					jPanelCLOCKMATRICE.disegnaSoluzioneCLOCK(jPanelCLOCKMATRICE.getGraphics(),numeriCLOCK,s,pagefaultCLOCK,numeri);
				}
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
					//generaGrafici.setEnabled(true);
					
					labelFastForward.setEnabled(true);
					labelScrittaFast.setEnabled(true);
					labelScrittaPlay.setEnabled(true);
					labelPlay.setEnabled(true);
					jPanelFIFOMATRICE.resetGrafico(jPanelFIFOMATRICE.getGraphics());
					jPanelOPTMATRICE.resetGrafico(jPanelOPTMATRICE.getGraphics());
					jPanelLRUMATRICE.resetGrafico(jPanelLRUMATRICE.getGraphics());
					jPanelCLOCKMATRICE.resetGrafico(jPanelCLOCKMATRICE.getGraphics());

				}
			
			}
		});
	}
	
/**										IMPLEMENTAZIONE METODI RICHIAMATI E USATI SOPRA 											*/
	
//OK ALGORITMO CALCOLO PUNTI FIFO MATRICE
	/*int[] FIFO(int incomingStream[], int frames){
		
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
*/
	int[][] FIFO(int reference[], int frames){
		
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
          buffer[pointer] = reference[i];
          fault++;
          pointer++;
          if(pointer == frames)
           pointer = 0;
         }
            for(int j = 0; j < frames; j++)
                mem_layout[i][j] = buffer[j];
        }
        
        pagefaultFIFO=fault;
        return mem_layout;
	}
	    
//OK ALGORITMO CALCOLO PUNTI FIFO GRAFICO
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

//ALGORITMO CALCOLO PUNTI OPT MATRICE
	int[][] OPT(int reference[], int frames){
		
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
	   	    
	    pagefaultOPT=fault;
        return mem_layout;
	}

//OK ALGORITMO CALCOLO PUNTI OPT GRAFICO
	int[] OPTGrafico(int reference[]){
		int[] arrayPunti = new int[12];
		int[] arrayFIFO = new int[25];
	    int pf1 = 0, pf2 = 0, pf3 = 0, pf4 = 0, pf5 = 0, pf6 = 0;
	    int frames1=1, frames2=2, frames3=3, frames4=4, frames5=5, frames6=6;
	    
	
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
		    boolean isFull = false;
		    int buffer[];
		    int mem_layout[][];
		    
		    ref_len = reference.length;
		    mem_layout = new int[ref_len][frames1];
		    buffer = new int[frames1];
		    for(int j = 0; j < frames1; j++)
		            buffer[j] = -1;
		    
		    
		    for(int i = 0; i < ref_len; i++)
		    {
		     int search = -1;
		     for(int j = 0; j < frames1; j++)
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
		       int index[] = new int[frames1];
		       boolean index_flag[] = new boolean[frames1];
		       for(int j = i + 1; j < ref_len; j++)
		       {
		        for(int k = 0; k < frames1; k++)
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
		       for(int j = 0; j < frames1; j++)
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
		          if(pointer == frames1)
		          {
		           pointer = 0;
		           isFull = true;
		          }
		      }
		     }
		        for(int j = 0; j < frames1; j++)
		            mem_layout[i][j] = buffer[j];
		    }
		    pf1=fault;
	    }
	    
	    //pagefault2
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
		    boolean isFull = false;
		    int buffer[];
		    int mem_layout[][];
		    
		    ref_len = reference.length;
		    mem_layout = new int[ref_len][frames2];
		    buffer = new int[frames2];
		    for(int j = 0; j < frames2; j++)
		            buffer[j] = -1;
		    
		    
		    for(int i = 0; i < ref_len; i++)
		    {
		     int search = -1;
		     for(int j = 0; j < frames2; j++)
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
		       int index[] = new int[frames2];
		       boolean index_flag[] = new boolean[frames2];
		       for(int j = i + 1; j < ref_len; j++)
		       {
		        for(int k = 0; k < frames2; k++)
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
		       for(int j = 0; j < frames2; j++)
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
		          if(pointer == frames2)
		          {
		           pointer = 0;
		           isFull = true;
		          }
		      }
		     }
		        for(int j = 0; j < frames2; j++)
		            mem_layout[i][j] = buffer[j];
		    }
		    pf2=fault;

	    }
	    
	    //pagefault3
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
		    boolean isFull = false;
		    int buffer[];
		    int mem_layout[][];
		    
		    ref_len = reference.length;
		    mem_layout = new int[ref_len][frames3];
		    buffer = new int[frames3];
		    for(int j = 0; j < frames3; j++)
		            buffer[j] = -1;
		    
		    
		    for(int i = 0; i < ref_len; i++)
		    {
		     int search = -1;
		     for(int j = 0; j < frames3; j++)
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
		       int index[] = new int[frames3];
		       boolean index_flag[] = new boolean[frames3];
		       for(int j = i + 1; j < ref_len; j++)
		       {
		        for(int k = 0; k < frames3; k++)
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
		       for(int j = 0; j < frames3; j++)
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
		          if(pointer == frames3)
		          {
		           pointer = 0;
		           isFull = true;
		          }
		      }
		     }
		        for(int j = 0; j < frames3; j++)
		            mem_layout[i][j] = buffer[j];
		    }
		    pf3=fault;

	    }
	    
	    //pagefault4
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
		    boolean isFull = false;
		    int buffer[];
		    int mem_layout[][];
		    
		    ref_len = reference.length;
		    mem_layout = new int[ref_len][frames4];
		    buffer = new int[frames4];
		    for(int j = 0; j < frames4; j++)
		            buffer[j] = -1;
		    
		    
		    for(int i = 0; i < ref_len; i++)
		    {
		     int search = -1;
		     for(int j = 0; j < frames4; j++)
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
		       int index[] = new int[frames4];
		       boolean index_flag[] = new boolean[frames4];
		       for(int j = i + 1; j < ref_len; j++)
		       {
		        for(int k = 0; k < frames4; k++)
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
		       for(int j = 0; j < frames4; j++)
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
		          if(pointer == frames4)
		          {
		           pointer = 0;
		           isFull = true;
		          }
		      }
		     }
		        for(int j = 0; j < frames4; j++)
		            mem_layout[i][j] = buffer[j];
		    }
		    pf4=fault;

	    }
	    
	    //pagefault5
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
		    boolean isFull = false;
		    int buffer[];
		    int mem_layout[][];
		    
		    ref_len = reference.length;
		    mem_layout = new int[ref_len][frames5];
		    buffer = new int[frames5];
		    for(int j = 0; j < frames5; j++)
		            buffer[j] = -1;
		    
		    
		    for(int i = 0; i < ref_len; i++)
		    {
		     int search = -1;
		     for(int j = 0; j < frames5; j++)
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
		       int index[] = new int[frames5];
		       boolean index_flag[] = new boolean[frames5];
		       for(int j = i + 1; j < ref_len; j++)
		       {
		        for(int k = 0; k < frames5; k++)
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
		       for(int j = 0; j < frames5; j++)
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
		          if(pointer == frames5)
		          {
		           pointer = 0;
		           isFull = true;
		          }
		      }
		     }
		        for(int j = 0; j < frames5; j++)
		            mem_layout[i][j] = buffer[j];
		    }
		    pf5=fault;

	    }
	    
	    //pagefaults6
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
		    boolean isFull = false;
		    int buffer[];
		    int mem_layout[][];
		    
		    ref_len = reference.length;
		    mem_layout = new int[ref_len][frames6];
		    buffer = new int[frames6];
		    for(int j = 0; j < frames6; j++)
		            buffer[j] = -1;
		    
		    
		    for(int i = 0; i < ref_len; i++)
		    {
		     int search = -1;
		     for(int j = 0; j < frames6; j++)
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
		       int index[] = new int[frames6];
		       boolean index_flag[] = new boolean[frames6];
		       for(int j = i + 1; j < ref_len; j++)
		       {
		        for(int k = 0; k < frames6; k++)
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
		       for(int j = 0; j < frames6; j++)
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
		          if(pointer == frames6)
		          {
		           pointer = 0;
		           isFull = true;
		          }
		      }
		     }
		        for(int j = 0; j < frames6; j++)
		            mem_layout[i][j] = buffer[j];
		    }
		    pf6=fault;

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
	int[][] LRU(int reference[], int frames){
		
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
		       
		        pagefaultLRU=fault;
		        return mem_layout;
	}  
	
//OK ALGORITMO CALCOLO PUNTI LRU GRAFICO
	int[] LRUGrafico(int reference[]){
		
		int[] arrayPunti = new int[12];
		int[] arrayFIFO = new int[25];
	    int pf1 = 0, pf2 = 0, pf3 = 0, pf4 = 0, pf5 = 0, pf6 = 0;
	    int frames1=1, frames2=2, frames3=3, frames4=4, frames5=5, frames6=6;
	    
	    //pagefault1
		{
		 int pointer = 0, hit = 0, fault = 0,ref_len;
	        Boolean isFull = false;
	        int buffer[];
	        ArrayList<Integer> stack = new ArrayList<Integer>();
	        int mem_layout[][];
	        
	        ref_len = reference.length;
	        
	        mem_layout = new int[ref_len][frames1];
	        buffer = new int[frames1];
	        for(int j = 0; j < frames1; j++)
	                buffer[j] = -1;
	        

	        for(int i = 0; i < ref_len; i++)
	        {
	            if(stack.contains(reference[i]))
	            {
	             stack.remove(stack.indexOf(reference[i]));
	            }
	            stack.add(reference[i]);
	            int search = -1;
	            for(int j = 0; j < frames1; j++)
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
	                    for(int j = 0; j < frames1; j++)
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
	                if(pointer == frames1)
	                {
	                 pointer = 0;
	                 isFull = true;
	                }
	            }
	            for(int j = 0; j < frames1; j++)
	                mem_layout[i][j] = buffer[j];
	        }
	        pf1=fault;
		}
		
		//pagefault2
				{
				 int pointer = 0, hit = 0, fault = 0,ref_len;
			        Boolean isFull = false;
			        int buffer[];
			        ArrayList<Integer> stack = new ArrayList<Integer>();
			        int mem_layout[][];
			        
			        ref_len = reference.length;
			        
			        mem_layout = new int[ref_len][frames2];
			        buffer = new int[frames2];
			        for(int j = 0; j < frames2; j++)
			                buffer[j] = -1;
			        

			        for(int i = 0; i < ref_len; i++)
			        {
			            if(stack.contains(reference[i]))
			            {
			             stack.remove(stack.indexOf(reference[i]));
			            }
			            stack.add(reference[i]);
			            int search = -1;
			            for(int j = 0; j < frames2; j++)
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
			                    for(int j = 0; j < frames2; j++)
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
			                if(pointer == frames2)
			                {
			                 pointer = 0;
			                 isFull = true;
			                }
			            }
			            for(int j = 0; j < frames2; j++)
			                mem_layout[i][j] = buffer[j];
			        }
			        pf2=fault;
				}
				
				//pagefault3
				{
				 int pointer = 0, hit = 0, fault = 0,ref_len;
			        Boolean isFull = false;
			        int buffer[];
			        ArrayList<Integer> stack = new ArrayList<Integer>();
			        int mem_layout[][];
			        
			        ref_len = reference.length;
			        
			        mem_layout = new int[ref_len][frames3];
			        buffer = new int[frames3];
			        for(int j = 0; j < frames3; j++)
			                buffer[j] = -1;
			        

			        for(int i = 0; i < ref_len; i++)
			        {
			            if(stack.contains(reference[i]))
			            {
			             stack.remove(stack.indexOf(reference[i]));
			            }
			            stack.add(reference[i]);
			            int search = -1;
			            for(int j = 0; j < frames3; j++)
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
			                    for(int j = 0; j < frames3; j++)
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
			                if(pointer == frames3)
			                {
			                 pointer = 0;
			                 isFull = true;
			                }
			            }
			            for(int j = 0; j < frames3; j++)
			                mem_layout[i][j] = buffer[j];
			        }
			        pf3=fault;
				}
				
				//pagefault4
				{
				 int pointer = 0, hit = 0, fault = 0,ref_len;
			        Boolean isFull = false;
			        int buffer[];
			        ArrayList<Integer> stack = new ArrayList<Integer>();
			        int mem_layout[][];
			        
			        ref_len = reference.length;
			        
			        mem_layout = new int[ref_len][frames4];
			        buffer = new int[frames4];
			        for(int j = 0; j < frames4; j++)
			                buffer[j] = -1;
			        

			        for(int i = 0; i < ref_len; i++)
			        {
			            if(stack.contains(reference[i]))
			            {
			             stack.remove(stack.indexOf(reference[i]));
			            }
			            stack.add(reference[i]);
			            int search = -1;
			            for(int j = 0; j < frames4; j++)
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
			                    for(int j = 0; j < frames4; j++)
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
			                if(pointer == frames4)
			                {
			                 pointer = 0;
			                 isFull = true;
			                }
			            }
			            for(int j = 0; j < frames4; j++)
			                mem_layout[i][j] = buffer[j];
			        }
			        pf4=fault;
				}
				
				//pagefault5
				{
				 int pointer = 0, hit = 0, fault = 0,ref_len;
			        Boolean isFull = false;
			        int buffer[];
			        ArrayList<Integer> stack = new ArrayList<Integer>();
			        int mem_layout[][];
			        
			        ref_len = reference.length;
			        
			        mem_layout = new int[ref_len][frames5];
			        buffer = new int[frames5];
			        for(int j = 0; j < frames5; j++)
			                buffer[j] = -1;
			        

			        for(int i = 0; i < ref_len; i++)
			        {
			            if(stack.contains(reference[i]))
			            {
			             stack.remove(stack.indexOf(reference[i]));
			            }
			            stack.add(reference[i]);
			            int search = -1;
			            for(int j = 0; j < frames5; j++)
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
			                    for(int j = 0; j < frames5; j++)
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
			                if(pointer == frames5)
			                {
			                 pointer = 0;
			                 isFull = true;
			                }
			            }
			            for(int j = 0; j < frames5; j++)
			                mem_layout[i][j] = buffer[j];
			        }
			        pf5=fault;
				}
				
				//pagefault6
				{
				 int pointer = 0, hit = 0, fault = 0,ref_len;
			        Boolean isFull = false;
			        int buffer[];
			        ArrayList<Integer> stack = new ArrayList<Integer>();
			        int mem_layout[][];
			        
			        ref_len = reference.length;
			        
			        mem_layout = new int[ref_len][frames6];
			        buffer = new int[frames6];
			        for(int j = 0; j < frames6; j++)
			                buffer[j] = -1;
			        

			        for(int i = 0; i < ref_len; i++)
			        {
			            if(stack.contains(reference[i]))
			            {
			             stack.remove(stack.indexOf(reference[i]));
			            }
			            stack.add(reference[i]);
			            int search = -1;
			            for(int j = 0; j < frames6; j++)
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
			                    for(int j = 0; j < frames6; j++)
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
			                if(pointer == frames6)
			                {
			                 pointer = 0;
			                 isFull = true;
			                }
			            }
			            for(int j = 0; j < frames6; j++)
			                mem_layout[i][j] = buffer[j];
			        }
			        pf6=fault;
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
		
//ALGORITMO CALCOLO PUNTI CLOCK MATRICE
	int[][] CLOCK(int reference[], int frames){
		
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
        
        pagefaultCLOCK=fault;
        return mem_layout;
    }
	
//ALGORITMO CALCOLO PUNTI CLOCK GRAFICO
	int[] CLOCKGrafico(int reference[]){
		int[] arrayPunti = new int[12];
		int[] arrayFIFO = new int[25];
	    int pf1 = 0, pf2 = 0, pf3 = 0, pf4 = 0, pf5 = 0, pf6 = 0;
	    int frames1=1, frames2=2, frames3=3, frames4=4, frames5=5, frames6=6;
	    
	    //pagefault1
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
	        int buffer[][];
	        int mem_layout[][];
	        int used_layout[][];
	        
	        ref_len = reference.length;
	        mem_layout = new int[ref_len][frames1];
	        used_layout = new int[ref_len][frames1];
	        buffer = new int[frames1][2];
	        for(int j = 0; j < frames1; j++)
	        {
	         buffer[j][0] = -1;
	         buffer[j][1] = 0;
	        }
	       
	        for(int i = 0; i < ref_len; i++)
	        {
	         int search = -1;
	         for(int j = 0; j < frames1; j++)
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
	           if(pointer == frames1)
	            pointer = 0;
	          }
	          buffer[pointer][0] = reference[i];
	          buffer[pointer][1] = 1;
	          fault++;
	          pointer++;
	          if(pointer == frames1)
	           pointer = 0;
	         }
	            for(int j = 0; j < frames1; j++)
		   {
		    mem_layout[i][j] = buffer[j][0];
		    used_layout[i][j] = buffer[j][1];
		   }
		       }
	        pf1=fault;
	    }
	    
	    //pagefault2
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
	        int buffer[][];
	        int mem_layout[][];
	        int used_layout[][];
	        
	        ref_len = reference.length;
	        mem_layout = new int[ref_len][frames2];
	        used_layout = new int[ref_len][frames2];
	        buffer = new int[frames2][2];
	        for(int j = 0; j < frames2; j++)
	        {
	         buffer[j][0] = -1;
	         buffer[j][1] = 0;
	        }
	       
	        for(int i = 0; i < ref_len; i++)
	        {
	         int search = -1;
	         for(int j = 0; j < frames2; j++)
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
	           if(pointer == frames2)
	            pointer = 0;
	          }
	          buffer[pointer][0] = reference[i];
	          buffer[pointer][1] = 1;
	          fault++;
	          pointer++;
	          if(pointer == frames2)
	           pointer = 0;
	         }
	            for(int j = 0; j < frames2; j++)
		   {
		    mem_layout[i][j] = buffer[j][0];
		    used_layout[i][j] = buffer[j][1];
		   }
		       }
	        pf2=fault;
	    }
	    
	    //pagefault3
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
	        int buffer[][];
	        int mem_layout[][];
	        int used_layout[][];
	        
	        ref_len = reference.length;
	        mem_layout = new int[ref_len][frames3];
	        used_layout = new int[ref_len][frames3];
	        buffer = new int[frames3][2];
	        for(int j = 0; j < frames3; j++)
	        {
	         buffer[j][0] = -1;
	         buffer[j][1] = 0;
	        }
	       
	        for(int i = 0; i < ref_len; i++)
	        {
	         int search = -1;
	         for(int j = 0; j < frames3; j++)
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
	           if(pointer == frames3)
	            pointer = 0;
	          }
	          buffer[pointer][0] = reference[i];
	          buffer[pointer][1] = 1;
	          fault++;
	          pointer++;
	          if(pointer == frames3)
	           pointer = 0;
	         }
	            for(int j = 0; j < frames3; j++)
		   {
		    mem_layout[i][j] = buffer[j][0];
		    used_layout[i][j] = buffer[j][1];
		   }
		       }
	        pf3=fault;
	    }
	    
	    //pagefault4
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
	        int buffer[][];
	        int mem_layout[][];
	        int used_layout[][];
	        
	        ref_len = reference.length;
	        mem_layout = new int[ref_len][frames4];
	        used_layout = new int[ref_len][frames4];
	        buffer = new int[frames4][2];
	        for(int j = 0; j < frames4; j++)
	        {
	         buffer[j][0] = -1;
	         buffer[j][1] = 0;
	        }
	       
	        for(int i = 0; i < ref_len; i++)
	        {
	         int search = -1;
	         for(int j = 0; j < frames4; j++)
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
	           if(pointer == frames4)
	            pointer = 0;
	          }
	          buffer[pointer][0] = reference[i];
	          buffer[pointer][1] = 1;
	          fault++;
	          pointer++;
	          if(pointer == frames4)
	           pointer = 0;
	         }
	            for(int j = 0; j < frames4; j++)
		   {
		    mem_layout[i][j] = buffer[j][0];
		    used_layout[i][j] = buffer[j][1];
		   }
		       }
	        pf4=fault;
	    }
	    
	    //pagefault5
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
	        int buffer[][];
	        int mem_layout[][];
	        int used_layout[][];
	        
	        ref_len = reference.length;
	        mem_layout = new int[ref_len][frames5];
	        used_layout = new int[ref_len][frames5];
	        buffer = new int[frames5][2];
	        for(int j = 0; j < frames5; j++)
	        {
	         buffer[j][0] = -1;
	         buffer[j][1] = 0;
	        }
	       
	        for(int i = 0; i < ref_len; i++)
	        {
	         int search = -1;
	         for(int j = 0; j < frames5; j++)
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
	           if(pointer == frames5)
	            pointer = 0;
	          }
	          buffer[pointer][0] = reference[i];
	          buffer[pointer][1] = 1;
	          fault++;
	          pointer++;
	          if(pointer == frames5)
	           pointer = 0;
	         }
	            for(int j = 0; j < frames5; j++)
		   {
		    mem_layout[i][j] = buffer[j][0];
		    used_layout[i][j] = buffer[j][1];
		   }
		       }
	        pf5=fault;
	    }
	    
	    //pagefault6
	    {
	    	int  pointer = 0, hit = 0, fault = 0,ref_len;
	        int buffer[][];
	        int mem_layout[][];
	        int used_layout[][];
	        
	        ref_len = reference.length;
	        mem_layout = new int[ref_len][frames6];
	        used_layout = new int[ref_len][frames6];
	        buffer = new int[frames6][2];
	        for(int j = 0; j < frames6; j++)
	        {
	         buffer[j][0] = -1;
	         buffer[j][1] = 0;
	        }
	       
	        for(int i = 0; i < ref_len; i++)
	        {
	         int search = -1;
	         for(int j = 0; j < frames6; j++)
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
	           if(pointer == frames6)
	            pointer = 0;
	          }
	          buffer[pointer][0] = reference[i];
	          buffer[pointer][1] = 1;
	          fault++;
	          pointer++;
	          if(pointer == frames6)
	           pointer = 0;
	         }
	            for(int j = 0; j < frames6; j++)
		   {
		    mem_layout[i][j] = buffer[j][0];
		    used_layout[i][j] = buffer[j][1];
		   }
		       }
	        pf6=fault;
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

		    return arrayPunti;	}
	
	
	public static String transformStringToHtml(String strToTransform) {
	    String ans = "<html>";
	    String br = "<br>";
	    String[] lettersArr = strToTransform.split("");
	    for (String letter : lettersArr) {
	        ans += letter + br;
	    }
	    ans += "</html>";
	    return ans;
	}
}



