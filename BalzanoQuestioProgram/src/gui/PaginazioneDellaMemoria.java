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
import java.security.Key;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.border.LineBorder;
import javax.swing.event.MenuKeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.text.BadLocationException;
import javax.swing.text.NumberFormatter;

import model.PanelGraficiPaginazioneMemoria;
import model.CreaLinee;

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

public class PaginazioneDellaMemoria extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private String scelta="0";


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

/**						BOTTONI PANNELLO PRINCIPALE							*/
		//BOTTONE INDIETRO	
		JButton btnIndietro = new JButton("Indietro");
			btnIndietro.setBorder(new LineBorder(new Color(102, 204, 255), 4));
			btnIndietro.setBackground(new Color(255, 255, 255));
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
			btnSlideArgomento.setBorder(new LineBorder(new Color(153, 102, 255), 4));
			btnSlideArgomento.setBackground(new Color(255, 255, 255));
			btnSlideArgomento.setBounds(239, 85, 128, 48);
			pannelloPrincipale.add(btnSlideArgomento);
			frame.setVisible(true); 
	        
		//BOTTONE ESCI
		JButton btnEsci = new JButton("Esci");
			btnEsci.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnEsci.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnEsci.setBorder(new LineBorder(new Color(255, 204, 0), 4));
			btnEsci.setBackground(new Color(255, 255, 255));
			btnEsci.setBounds(10, 85, 81, 48);
			pannelloPrincipale.add(btnEsci);
		
		//BOTTONE INFO SULL'USO DELL'APP	
		JButton btnInfouso = new JButton("Info/Uso");
			btnInfouso.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnInfouso.setBorder(new LineBorder(new Color(0, 0, 0), 4));
			btnInfouso.setBackground(new Color(255, 255, 255));
			btnInfouso.setBounds(525, 85, 81, 48);
			pannelloPrincipale.add(btnInfouso);

		//BOTTONE VIDEOLEZIONI	
		JButton buttonVideo = new JButton("Videolezione");
			buttonVideo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Desktop d = Desktop.getDesktop();
					try {
						d.browse(new URI ("https://youtu.be/s8fpbXN92Tk"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			buttonVideo.setFont(new Font("Segoe UI", Font.BOLD, 14));
			buttonVideo.setBorder(new LineBorder(new Color(153, 51, 0), 4));
			buttonVideo.setBackground(Color.WHITE);
			buttonVideo.setBounds(377, 86, 138, 46);
			pannelloPrincipale.add(buttonVideo);
		
			
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
		

/*INIZIO GUI COMPLICATA*/		

/**							PANNELLO GRAFICI								*/
		JPanel pannelloGrafici = new JPanel();
	        pannelloGrafici.setBounds(0, 143, 1131, 620);
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
			pannelloOPT.setBounds(10, 146, 1121, 157);
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
			pannelloLRU.setBounds(10, 299, 1121, 157);
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
			pannelloCLOCK.setBounds(10, 452, 1121, 157);
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
			jPanelFIFO.setBounds(615, 27, 500, 118);
			jPanelFIFO.setBackground(new java.awt.Color(255, 255, 255));
			jPanelFIFO.setLayout(null);
			pannelloFIFO.add(jPanelFIFO);

		//GRAFICO OPT
		PanelGraficiPaginazioneMemoria jPanelOPT = new PanelGraficiPaginazioneMemoria();
			jPanelOPT.setBackground(new java.awt.Color(255, 255, 255));
			jPanelOPT.setLayout(null);
			jPanelOPT.setBounds(615, 27, 500, 118);
			pannelloOPT.add(jPanelOPT);

		//GRAFICO LRU
		PanelGraficiPaginazioneMemoria jPanelLRU = new PanelGraficiPaginazioneMemoria();
			jPanelLRU.setBackground(new java.awt.Color(255, 255, 255));
			jPanelLRU.setLayout(null);
			jPanelLRU.setBounds(615, 27, 500, 118);
			pannelloLRU.add(jPanelLRU);
		
		//GRAFICO CLOCK
		PanelGraficiPaginazioneMemoria jPanelCLOCK = new PanelGraficiPaginazioneMemoria();
			jPanelCLOCK.setBackground(new java.awt.Color(255, 255, 255));
			jPanelCLOCK.setLayout(null);
			jPanelCLOCK.setBounds(615, 27, 500, 118);
			pannelloCLOCK.add(jPanelCLOCK);
			
/**						PANNELLO DI CONTROLLO						*/		
			
		JPanel panelDiControllo = new JPanel();
			panelDiControllo.setLayout(null);
			//panelDiControllo.setBorder(new LineBorder(new Color(0, 153, 0)));
			panelDiControllo.setBounds(1141, 85, 265, 668);
			pannelloPrincipale.add(panelDiControllo);
			
		JPanel pannelloTitoloDC = new JPanel();
			pannelloTitoloDC.setLayout(null);
			pannelloTitoloDC.setBorder(new LineBorder(new Color(0, 153, 0), 3));
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
			//panel_3.setBorder(new LineBorder(new Color(255, 204, 0), 2));
			pannelloEditor.setBounds(10, 95, 245, 224);
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
			
		JLabel lblSuccessioneDiRiferimento = new JLabel("Successione di riferimento:");
			lblSuccessioneDiRiferimento.setHorizontalAlignment(SwingConstants.CENTER);
			lblSuccessioneDiRiferimento.setForeground(Color.BLACK);
			lblSuccessioneDiRiferimento.setFont(new Font("Arial", Font.BOLD, 14));
			lblSuccessioneDiRiferimento.setBounds(10, 47, 225, 23);
			pannelloEditor.add(lblSuccessioneDiRiferimento);
			
		JCheckBox chckbxAttivaModifiche = new JCheckBox("Attiva modifiche");
			chckbxAttivaModifiche.setEnabled(false);
			chckbxAttivaModifiche.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chckbxAttivaModifiche.setBounds(10, 156, 136, 21);
			pannelloEditor.add(chckbxAttivaModifiche);
			
		JButton salvaModifiche = new JButton("Salva");
			salvaModifiche.setEnabled(false);
			salvaModifiche.setBounds(152, 157, 83, 21);
			pannelloEditor.add(salvaModifiche);
			
		JButton generaGrafici = new JButton("GENERA GRAFICI");
			generaGrafici.setBorder(new LineBorder(new Color(0, 204, 0), 2));
			generaGrafici.setBackground(new Color(255, 255, 255));
			generaGrafici.setFont(new Font("Tahoma", Font.PLAIN, 15));
			generaGrafici.setBounds(10, 195, 225, 21);
			pannelloEditor.add(generaGrafici);
			
		JButton btnGeneraSuccessione = new JButton("Genera successione");
			btnGeneraSuccessione.setBackground(new Color(255, 255, 255));
			btnGeneraSuccessione.setBorder(new LineBorder(new Color(0, 204, 255), 2));
			btnGeneraSuccessione.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnGeneraSuccessione.setBounds(10, 76, 225, 32);
			pannelloEditor.add(btnGeneraSuccessione);
			
		JPanel pannelloHelp = new JPanel();
			pannelloHelp.setLayout(null);
			pannelloHelp.setBounds(10, 354, 245, 284);
			panelDiControllo.add(pannelloHelp);
			
		JScrollPane scrollPaneHelp = new JScrollPane();
			scrollPaneHelp.setBounds(0, 0, 245, 284);
			//scrollPaneHelp.setBorder(new LineBorder(new Color(255, 204, 0), 3));
			pannelloHelp.add(scrollPaneHelp);
		
		JTextArea txtrHelpArea = new JTextArea();
			scrollPaneHelp.setViewportView(txtrHelpArea);
			txtrHelpArea.setWrapStyleWord(true);
			txtrHelpArea.setLineWrap(true);
			txtrHelpArea.setText("FIFO (First In First Out).\r\nE' la pi\u00F9 semplice, si tiene traccia in una tabella di quando \u00E8 stata allocata un'area di memoria. Quando vi \u00E8 una nuova richiesta di allocazione di pagine di memoria, se c'\u00E8 ancora spazio in memoria principale, semplicemente viene allocata la nuova pagina, altrimenti si consulta mediante la tabella quali sono le pagine allocate da pi\u00F9 tempo e si spostano in memoria secondaria.\r\nQuesto algoritmo \u00E8 molto semplice e di rapida esecuzione ma ha lo svantaggio di spostare in memoria secondaria le pagine pi\u00F9 vecchie anche se sono utilizzate di frequente.\r\n\r\nLRU (Least Recently Used)\r\nVengono sostituite le pagine usate meno di recente, poich\u00E8 queste hanno buona probabilit\u00E0 di non essere nuovamente utilizzate nell'immediato.\r\n\r\nOPT\r\nSi sostituisce la pagina che non si user\u00E0 per il periodo di tempo pi\u00F9 lungo. Non \u00E8 possibile conoscere in anticipo la successione dei riferimenti, viene usato principalmente per studi comparativi, per valutare le prestazioni degli algoritmi.");
			txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
			txtrHelpArea.setEditable(false);
		
		JTextField stringaNumeri = new JTextField();
			stringaNumeri.setEditable(false);
			stringaNumeri.setFont(new Font("Arial", Font.BOLD, 12));
			stringaNumeri.setHorizontalAlignment(SwingConstants.CENTER);
			stringaNumeri.setBounds(10, 115, 225, 19);
			pannelloEditor.add(stringaNumeri);
			stringaNumeri.setColumns(10);
		
		JLabel lblHelp = new JLabel("Spiegazione Argomento");
			lblHelp.setBounds(10, 329, 245, 25);
			panelDiControllo.add(lblHelp);
			lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
			lblHelp.setForeground(Color.RED);
			lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
			
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
/**							IMPLEMENTAZIONE EVENTI												*/
		
			stringaNumeri.addKeyListener(new KeyAdapter() {
		         public void keyTyped(KeyEvent e) {
		             char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
		                  e.consume();  //Ignora l'evento
		             }
		         }
		      });
			

			chckbxAttivaModifiche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					salvaModifiche.setEnabled(true);
					chckbxAttivaModifiche.setEnabled(true);

					if(chckbxAttivaModifiche.isSelected()==false) {
						salvaModifiche.doClick();
					}
					else {
						stringaNumeri.setEditable(true);

						generaGrafici.setEnabled(false);
					}
				}
			});
			
			salvaModifiche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stringaNumeri.setText(stringaNumeri.getText());
					stringaNumeri.setEditable(false);
					chckbxAttivaModifiche.setSelected(false);
					generaGrafici.setEnabled(true);
					salvaModifiche.setEnabled(false);

				}
			});
			

		
			
			generaGrafici.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scelta= (String) SceltaSlotDisponibili.getSelectedItem();
					int k=Integer.valueOf(scelta);
					
					for(int i=0;i<k;i++) {
						
						JLabel lblNewLabel = new JLabel("12");
						lblNewLabel.setBounds(10, 10+30*k, 30, 30);
						pannelloFIFO.add(lblNewLabel);
						
					}
				}
			});
			
			btnGeneraSuccessione.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chckbxAttivaModifiche.setEnabled(true);
					stringaNumeri.setText("");
					for (int i=0;i<18;i++) { 
						
						Random random = new Random();
						int value = random.nextInt(10 + 0) + 0;
						stringaNumeri.setText(stringaNumeri.getText()+" "+value);
					}
				}
			});
			

			SceltaSlotDisponibili.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
	
	}
}



/*
* Costruttore con unico parametro il limite della textfield
*/