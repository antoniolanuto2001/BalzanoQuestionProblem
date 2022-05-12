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
import java.util.regex.Pattern;

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

public class PaginazioneDellaMemoria extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private String scelta="0";
	ArrayList<CreaLinee> arrayPunti= new ArrayList<CreaLinee>();
	ArrayList<CreaLinee> arrayLinea= new ArrayList<CreaLinee>();
	ArrayList<CreaLinee> FCFS=new ArrayList<CreaLinee>();
	ArrayList<CreaLinee> SJF=new ArrayList<CreaLinee>();
	ArrayList<CreaLinee> SJFP=new ArrayList<CreaLinee>();
	ArrayList<CreaLinee> RR=new ArrayList<CreaLinee>();

	public PaginazioneDellaMemoria(JFrame framechiamante) 
	{
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
			btnIndietro.setBorder(new LineBorder(new Color(0, 0, 0)));
			btnIndietro.setBackground(new Color(153, 204, 255));
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
			btnSlideArgomento.setBorder(new LineBorder(new Color(0, 0, 0)));
			btnSlideArgomento.setBackground(new Color(153, 255, 255));
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
			btnEsci.setBorder(new LineBorder(new Color(0, 0, 0)));
			btnEsci.setBackground(new Color(255, 204, 0));
			btnEsci.setBounds(10, 85, 81, 48);
			pannelloPrincipale.add(btnEsci);
		
		//BOTTONE INFO SULL'USO DELL'APP	
		JButton btnInfouso = new JButton("Info/Uso");
			btnInfouso.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnInfouso.setBorder(new LineBorder(new Color(0, 0, 0)));
			btnInfouso.setBackground(new Color(255, 255, 255));
			btnInfouso.setBounds(377, 85, 81, 48);
			pannelloPrincipale.add(btnInfouso);

			
/**							PANNELLO TITOLO									*/
		JPanel pannelloTitolo = new JPanel();
			pannelloTitolo.setBackground(new Color(51, 204, 255));
			pannelloTitolo.setBounds(0, 0, 1416, 75);
			pannelloPrincipale.add(pannelloTitolo);
			pannelloTitolo.setLayout(null);
			
		//TITOLO
		JLabel labelTitolo = new JLabel("Paginazione della memoria");
			labelTitolo.setForeground(new Color(0, 0, 0));
			labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitolo.setFont(new Font("Times New Roman", Font.BOLD, 50));
			labelTitolo.setBounds(0, 0, 1416, 73);
			pannelloTitolo.add(labelTitolo);
		
		//TESTO CON VARIE INFO SUL PROGETTO
		JTextArea testoInfoProgetto = new JTextArea();
			testoInfoProgetto.setBounds(1152, 0, 251, 73);
			pannelloTitolo.add(testoInfoProgetto);
			testoInfoProgetto.setBackground(new Color(51, 204, 255));
			testoInfoProgetto.setText("Universit\u00E0 degli studi di NApoli\r\nAnno Accademico: 2021/2022\r\nProfessore: Walter Balzano\r\n Devoloper: Lanuto, Prosciutto, Scotto\r\n");
			testoInfoProgetto.setLineWrap(true);
			testoInfoProgetto.setFont(new Font("Cambria", Font.PLAIN, 13));
			testoInfoProgetto.setEditable(false);
		

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
			pannelloFCFS.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));

		JLabel FIFO = new JLabel("FIFO");
			FIFO.setHorizontalAlignment(SwingConstants.CENTER);
			FIFO.setForeground(Color.RED);
			FIFO.setFont(new Font("Tahoma", Font.PLAIN, 20));
			FIFO.setBounds(10, 0, 489, 25);
			pannelloFCFS.add(FIFO);
		
		JLabel lblTAMFCFS = new JLabel("Page faults:");
			lblTAMFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblTAMFCFS.setBounds(670, 3, 150, 25);
			pannelloFCFS.add(lblTAMFCFS);
		
		JLabel DatoTAMFCFS = new JLabel("");
			DatoTAMFCFS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoTAMFCFS.setBounds(821, 3, 45, 25);
			pannelloFCFS.add(DatoTAMFCFS);
		
		//PANNELLO SHORTEST JOB FIRST
		JPanel pannelloSJF = new JPanel();
			pannelloSJF.setBounds(10, 153, 1121, 150);
			pannelloGrafici.add(pannelloSJF);
			pannelloSJF.setLayout(null);
			pannelloSJF.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));

		JLabel OPT = new JLabel("OPT");
			OPT.setHorizontalAlignment(SwingConstants.CENTER);
			OPT.setForeground(Color.RED);
			OPT.setFont(new Font("Tahoma", Font.PLAIN, 20));
			OPT.setBounds(10, 0, 489, 25);
			pannelloSJF.add(OPT);
		
		JLabel lblTAMSJF = new JLabel("Page faults:");
			lblTAMSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblTAMSJF.setBounds(670, 3, 150, 25);
			pannelloSJF.add(lblTAMSJF);
		
		JLabel DatoTAMSJF = new JLabel("");
			DatoTAMSJF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoTAMSJF.setBounds(821, 3, 45, 25);
			pannelloSJF.add(DatoTAMSJF);
		
		//PANNELLO SHORTEST JOB FIRST PREEMPTIVE
		JPanel pannelloSJFP = new JPanel();
			pannelloSJFP.setLayout(null);
			pannelloSJFP.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));
			pannelloSJFP.setBounds(10, 306, 1121, 150);
			pannelloGrafici.add(pannelloSJFP);
		
		JLabel LRU = new JLabel("LRU");
			LRU.setHorizontalAlignment(SwingConstants.CENTER);
			LRU.setForeground(Color.RED);
			LRU.setFont(new Font("Tahoma", Font.PLAIN, 20));
			LRU.setBounds(10, 0, 489, 25);
			pannelloSJFP.add(LRU);
		
		JLabel lblTAMSJFP = new JLabel("Page faults:");
			lblTAMSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblTAMSJFP.setBounds(670, 3, 150, 25);
			pannelloSJFP.add(lblTAMSJFP);

		JLabel DatoTAMSJFP = new JLabel("");
			DatoTAMSJFP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoTAMSJFP.setBounds(821, 3, 45, 25);
			pannelloSJFP.add(DatoTAMSJFP);
	
		//PANNELLO ROUND ROBIN
		JPanel pannelloRR = new JPanel();
			pannelloRR.setLayout(null);
			pannelloRR.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));
			pannelloRR.setBounds(10, 459, 1121, 150);
			pannelloGrafici.add(pannelloRR);
		
		JLabel clock = new JLabel("Clock");
			clock.setHorizontalAlignment(SwingConstants.CENTER);
			clock.setForeground(Color.RED);
			clock.setFont(new Font("Tahoma", Font.PLAIN, 20));
			clock.setBounds(10, 0, 489, 25);
			pannelloRR.add(clock);
		
		JLabel lblTAMRR = new JLabel("Page faults:");
			lblTAMRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblTAMRR.setBounds(670, 3, 150, 25);
			pannelloRR.add(lblTAMRR);

		JLabel DatoTAMRR = new JLabel("");
			DatoTAMRR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			DatoTAMRR.setBounds(821, 3, 45, 25);
			pannelloRR.add(DatoTAMRR);
			
			
			
/**						PANNELLI CON GRAFICO CARTESIANO						*/			
				
		//GRAFICO FCFS
		PanelGraficiPaginazioneMemoria jPanelFCFS = new PanelGraficiPaginazioneMemoria();
			jPanelFCFS.setBackground(new java.awt.Color(255, 255, 255));
			jPanelFCFS.setBounds(615, 27, 500, 118);
			jPanelFCFS.setLayout(null);
			pannelloFCFS.add(jPanelFCFS);

		//GRAFICO SJF
		PanelGraficiPaginazioneMemoria jPanelSJF = new PanelGraficiPaginazioneMemoria();
			jPanelSJF.setBackground(new java.awt.Color(255, 255, 255));
			jPanelSJF.setLayout(null);
			jPanelSJF.setBounds(615, 27, 500, 118);
			pannelloSJF.add(jPanelSJF);

		//GRAFICO SJFP
		PanelGraficiPaginazioneMemoria jPanelSJFP = new PanelGraficiPaginazioneMemoria();
			jPanelSJFP.setBackground(new java.awt.Color(255, 255, 255));
			jPanelSJFP.setLayout(null);
			jPanelSJFP.setBounds(615, 27, 500, 118);
			pannelloSJFP.add(jPanelSJFP);
		
		//GRAFICO RR
		PanelGraficiPaginazioneMemoria jPanelRR = new PanelGraficiPaginazioneMemoria();
			jPanelRR.setBackground(new java.awt.Color(255, 255, 255));
			jPanelRR.setLayout(null);
			jPanelRR.setBounds(615, 27, 500, 118);
			pannelloRR.add(jPanelRR);
			
/**						PANNELLO DI CONTROLLO						*/		
			
		JPanel panelDiControllo = new JPanel();
			panelDiControllo.setLayout(null);
			panelDiControllo.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));
			panelDiControllo.setBounds(1141, 85, 265, 648);
			pannelloPrincipale.add(panelDiControllo);
			
		JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(BorderFactory.createRaisedBevelBorder());
			panel_2.setBackground(new Color(255, 204, 51));
			panel_2.setBounds(10, 10, 245, 54);
			panelDiControllo.add(panel_2);
			
		JLabel labelPnlCtrl = new JLabel("Pannello di controllo");
			labelPnlCtrl.setHorizontalAlignment(SwingConstants.CENTER);
			labelPnlCtrl.setFont(new Font("Arial", Font.BOLD, 22));
			labelPnlCtrl.setBounds(0, 0, 245, 54);
			panel_2.add(labelPnlCtrl);
			
		JLabel labelEditor = new JLabel("Editor");
			labelEditor.setHorizontalAlignment(SwingConstants.CENTER);
			labelEditor.setForeground(Color.RED);
			labelEditor.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelEditor.setBounds(0, 70, 265, 25);
			panelDiControllo.add(labelEditor);
			
		JPanel panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBorder(BorderFactory.createLineBorder(Color.black));
			panel_3.setBounds(10, 95, 245, 224);
			panelDiControllo.add(panel_3);
			
		JLabel lblSlotMemoria = new JLabel("Slot Memoria Disponibili");
			lblSlotMemoria.setHorizontalAlignment(SwingConstants.CENTER);
			lblSlotMemoria.setForeground(Color.BLACK);
			lblSlotMemoria.setFont(new Font("Arial", Font.BOLD, 14));
			lblSlotMemoria.setBounds(0, 2, 181, 23);
			panel_3.add(lblSlotMemoria);
			
		JComboBox SceltaSlotDisponibili = new JComboBox();
		SceltaSlotDisponibili.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
			SceltaSlotDisponibili.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			SceltaSlotDisponibili.setBackground(Color.WHITE);
			SceltaSlotDisponibili.setBounds(185, 2, 50, 21);
			panel_3.add(SceltaSlotDisponibili);
			
		JLabel lblSuccessioneDiRiferimento = new JLabel("Successione di riferimento:");
			lblSuccessioneDiRiferimento.setHorizontalAlignment(SwingConstants.CENTER);
			lblSuccessioneDiRiferimento.setForeground(Color.BLACK);
			lblSuccessioneDiRiferimento.setFont(new Font("Arial", Font.BOLD, 14));
			lblSuccessioneDiRiferimento.setBounds(10, 47, 225, 23);
			panel_3.add(lblSuccessioneDiRiferimento);
			
		JCheckBox chckbxAttivaModifiche = new JCheckBox("Attiva modifiche");
		chckbxAttivaModifiche.setEnabled(false);
			chckbxAttivaModifiche.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			chckbxAttivaModifiche.setBounds(10, 156, 136, 21);
			panel_3.add(chckbxAttivaModifiche);
			
		JButton salvaModifiche = new JButton("Salva");
		salvaModifiche.setEnabled(false);
			salvaModifiche.setBounds(152, 157, 83, 21);
			panel_3.add(salvaModifiche);
			
		JButton generaGrafici = new JButton("GENERA GRAFICI");
		generaGrafici.setBackground(new Color(204, 255, 255));
			generaGrafici.setFont(new Font("Tahoma", Font.PLAIN, 15));
			generaGrafici.setBounds(10, 195, 225, 21);
			panel_3.add(generaGrafici);
			
		JButton btnGeneraSuccessione = new JButton("Genera successione");
			btnGeneraSuccessione.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnGeneraSuccessione.setBounds(10, 76, 225, 21);
			panel_3.add(btnGeneraSuccessione);
			
		JPanel panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.setBounds(10, 329, 245, 309);
			panelDiControllo.add(panel_5);
			
		JLabel lblHelp = new JLabel("Help");
			lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
			lblHelp.setForeground(Color.RED);
			lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHelp.setBounds(0, 0, 245, 25);
			panel_5.add(lblHelp);
			
		JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 298, 225, -269);
			panel_5.add(scrollPane);
			
		JTextArea txtrHelpArea = new JTextArea();
			txtrHelpArea.setText("FIFO (First In First Out).\r\nE' la pi\u00F9 semplice, si tiene traccia in una tabella di quando \u00E8 stata allocata un'area di memoria. Quando vi \u00E8 una nuova richiesta di allocazione di pagine di memoria, se c'\u00E8 ancora spazio in memoria principale, semplicemente viene allocata la nuova pagina, altrimenti si consulta mediante la tabella quali sono le pagine allocate da pi\u00F9 tempo e si spostano in memoria secondaria.\r\nQuesto algoritmo \u00E8 molto semplice e di rapida esecuzione ma ha lo svantaggio di spostare in memoria secondaria le pagine pi\u00F9 vecchie anche se sono utilizzate di frequente.\r\nLRU (Least Recently Used)\r\nVengono sostituite le pagine usate meno di recente, poich\u00E8 queste hanno buona probabilit\u00E0 di non essere nuovamente utilizzate nell'immediato.\r\nOPT\r\nSi sostituisce la pagina che non si user\u00E0 per il periodo di tempo pi\u00F9 lungo. Non \u00E8 possibile conoscere in anticipo la successione dei riferimenti, viene usato principalmente per studi comparativi, per valutare le prestazioni degli algoritmi.");
			txtrHelpArea.setLineWrap(true);
			txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
			txtrHelpArea.setEditable(false);
			txtrHelpArea.setBounds(0, 27, 245, 282);
			panel_5.add(txtrHelpArea);
		
		JTextField stringaNumeri = new JTextField();
			stringaNumeri.setEditable(false);
			stringaNumeri.setFont(new Font("Arial", Font.BOLD, 12));
			stringaNumeri.setHorizontalAlignment(SwingConstants.CENTER);
			stringaNumeri.setBounds(10, 107, 225, 19);
			panel_3.add(stringaNumeri);
			stringaNumeri.setColumns(10);
		
			/*
			JFormattedTextField stringaNumeri=new JFormattedTextField();
			stringaNumeri.setEditable(false);
			stringaNumeri.setFont(new Font("Arial", Font.BOLD, 12));
			stringaNumeri.setHorizontalAlignment(SwingConstants.CENTER);
			stringaNumeri.setBounds(10, 107, 225, 19);
			panel_3.add(stringaNumeri);
			stringaNumeri.setColumns(10);
			
			stringaNumeri.setValue(new Integer(stringaNumeri.getText()));
			stringaNumeri.addPropertyChangeListener("value",this);
*//*
			NumberFormat longFormat = NumberFormat.getIntegerInstance();

			NumberFormatter numberFormatter = new NumberFormatter(longFormat);
			numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
			numberFormatter.setAllowsInvalid(false); //this is the key!!
			numberFormatter.setMinimum(0l); //Optional

			JFormattedTextField stringaNumeri = new JFormattedTextField(numberFormatter);
			//stringaNumeri.setEditable(false);
			stringaNumeri.setFont(new Font("Arial", Font.BOLD, 12));
			stringaNumeri.setHorizontalAlignment(SwingConstants.CENTER);
			stringaNumeri.setBounds(10, 107, 225, 19);
			panel_3.add(stringaNumeri);
			*/
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
/**							IMPLEMENTAZIONE EVENTI												*/
		
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
			stringaNumeri.addKeyListener(new KeyAdapter() {
		         public void keyTyped(KeyEvent e) {
		             char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != ' ')) {
		                  e.consume();  //Ignora l'evento
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
					System.out.println(stringaNumeri.getText());
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
