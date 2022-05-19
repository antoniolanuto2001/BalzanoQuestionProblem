package gui;

import java.lang.*;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import model.ProcessoSemaforo;
import model.Semaforo;

import java.awt.SystemColor;
import java.awt.Taskbar;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Semafori extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	public ArrayList<ProcessoSemaforo> StartEndProcessi = new ArrayList<ProcessoSemaforo>();
	final int min_JProgress_range=0;
	final int max_JProgress_range=300;

	/**
	 * Create the frame.
	 */
	

	
	//setting a position value on JProgressBarSeconds
	public int findRightPositionJProgressBar(int toconvert) {
	
		int val=0;
		
		for(int i=0; i<=300; i++) {
			if(i==toconvert) {
				val=(300*toconvert)/538;
				
			}
		}
		
		return  val+40;
	}
	
	
	
	
	
	
	
	public Semafori(JFrame framechiamante) 
	
	{
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelMainButton = new JPanel();
		panelMainButton.setBackground(new Color(255, 255, 255));
		panelMainButton.setBorder(new CompoundBorder());
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);
		
		
		//added
		JPanel panelSuperiore = new JPanel();
		panelSuperiore.setBackground(new Color(245, 245, 245));
		panelSuperiore.setBounds(-71, 0, 1495, 73);
		panelMainButton.add(panelSuperiore);
		panelSuperiore.setLayout(null);
		
		//modified
		JLabel labelTitoloSchermata = new JLabel(" Semafori ");
		labelTitoloSchermata.setBounds(70, 0, 320, 89);
		panelSuperiore.add(labelTitoloSchermata);
		labelTitoloSchermata.setBackground(new Color(224, 255, 255));
		labelTitoloSchermata.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 47));
		
		
		
		
		   JLabel labelIndietroIcon = new JLabel("Indietro");
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
	        		labelIndietroIcon.setForeground(Color.RED);
	        	}
	        	@Override
	        	public void mouseExited(MouseEvent e) 
	        	{
	        		labelIndietroIcon.setForeground(Color.BLACK);
	        	}
	        });
	        labelIndietroIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/back-button.png")));
	        labelIndietroIcon.setBounds(10, 87, 34, 46);
	        panelMainButton.add(labelIndietroIcon);
		
		 JLabel labelScrittaSlide = new JLabel("Slide Argomento");
	        labelScrittaSlide.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        labelScrittaSlide.setBounds(1309, 345, 95, 15);
	        panelMainButton.add(labelScrittaSlide);
	        JLabel labelSlideIcon = new JLabel("Slide");
	        labelSlideIcon.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Desktop d = Desktop.getDesktop();
					try {
						d.browse(new URI ("http://balzanoslidesistemiopera.altervista.org/Slides_Sistemi_Operativi.pdf#page=232"));
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
	        labelSlideIcon.setBounds(1333, 296, 53, 46);
	        panelMainButton.add(labelSlideIcon);
	        
		
		//scritta youtube
		 JLabel labelScrittaYoutube = new JLabel("VideoLezione");
	        labelScrittaYoutube.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        labelScrittaYoutube.setBounds(1322, 273, 82, 12);
	        panelMainButton.add(labelScrittaYoutube);
	        JLabel labelYoutubeIcon = new JLabel("Youtube");
	        labelYoutubeIcon.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Desktop d = Desktop.getDesktop();
					try {
						d.browse(new URI ("https://youtu.be/xPBZms_iICc?t=5976"));
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
	        labelYoutubeIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/youtubeIcon2.png")));
	        labelYoutubeIcon.setBounds(1332, 222, 54, 46);
	        panelMainButton.add(labelYoutubeIcon);
		
		
	        
	        
	        
		
		
		JLabel lblNewLabel = new JLabel("Pannello di controllo");
		lblNewLabel.setBounds(189, 146, 137, 27);
		panelMainButton.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBounds(89, 166, 353, 156);
		panelMainButton.add(desktopPane);
		
		JTextField TextFieldNumProcessi = new JTextField();
		TextFieldNumProcessi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		TextFieldNumProcessi.setBounds(10, 32, 126, 21);
		desktopPane.add(TextFieldNumProcessi);
		TextFieldNumProcessi.setText("Numero Processi:");
		TextFieldNumProcessi.setColumns(10);
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		ResetButton.setBackground(new Color(255, 255, 255));
		ResetButton.setBounds(219, 96, 121, 23);
		desktopPane.add(ResetButton);
		
		JToggleButton StartPauseToggleButton = new JToggleButton("Start/Pause");
		StartPauseToggleButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		StartPauseToggleButton.setBounds(219, 31, 121, 23);
		desktopPane.add(StartPauseToggleButton);
		StartPauseToggleButton.setBackground(new Color(255, 255, 255));
		
		
		JComboBox NumSemaforiComboBox = new JComboBox();
		NumSemaforiComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		NumSemaforiComboBox.setMaximumRowCount(2);
		NumSemaforiComboBox.setBounds(132, 97, 47, 20);
		desktopPane.add(NumSemaforiComboBox);
		
		
		JLabel JLabelTextMutex1 = new JLabel("Mutex=1");
		JLabelTextMutex1.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		JLabelTextMutex1.setBounds(752, 222, 79, 14);
		panelMainButton.add(JLabelTextMutex1);
		
		JLabel JLabelTextMutex2 = new JLabel("Mutex=1");
		JLabelTextMutex2.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		JLabelTextMutex2.setBounds(1025, 222, 79, 14);
		panelMainButton.add(JLabelTextMutex2);
		JLabelTextMutex2.setVisible(false);
		
		//creating a default semaphore graphic
		JPanel PannelloGraficaSemaforo1 = new Semaforo();
		PannelloGraficaSemaforo1.setBackground(new Color(255,255,255));
		PannelloGraficaSemaforo1.setBounds(568, 146, 174, 176);
		panelMainButton.add(PannelloGraficaSemaforo1);
		
		
		//second semaphore graphic
		JPanel PannelloGraficaSemaforo2 = new Semaforo();
		PannelloGraficaSemaforo2.setBackground(new Color(255,255,255));
		PannelloGraficaSemaforo2.setBounds(841,146,174,176);
		panelMainButton.add(PannelloGraficaSemaforo2);
		PannelloGraficaSemaforo2.setVisible(false);
		
		NumSemaforiComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Object item = NumSemaforiComboBox.getSelectedItem();
				
				if("2".equals(item))
				{
					//visibilit� semaforo
					PannelloGraficaSemaforo2.setVisible(true);
					//visibilit� testo
					JLabelTextMutex2.setVisible(true);
					
				}else if("1".equals(item))
				{
					//visibilit� semaforo
					PannelloGraficaSemaforo2.setVisible(false);
					//visibilit� testo
					JLabelTextMutex2.setVisible(false);
				}
					
			}
		});
		
	
		
		
	
		
		
		JComboBox NumProcessiComboBox = new JComboBox();
		
		
		NumProcessiComboBox.setModel(new DefaultComboBoxModel(new String[]{"1","2","3","4","5"}));
		
		NumProcessiComboBox.setBounds(132, 32, 47, 21);
		desktopPane.add(NumProcessiComboBox);
		
		
		
		JTextField txtNumeroSemafori = new JTextField();
		txtNumeroSemafori.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtNumeroSemafori.setText("Numero Semafori:");
		txtNumeroSemafori.setBounds(10, 97, 126, 20);
		desktopPane.add(txtNumeroSemafori);
		txtNumeroSemafori.setColumns(10);
		
		JLabel UniversitaJLabel = new JLabel("Universit\u00E0 degli studi di Napoli: \"Federico II\"");
		UniversitaJLabel.setFont(new Font("Sylfaen", Font.BOLD, 13));
		UniversitaJLabel.setBounds(1118, 640, 269, 27);
		panelMainButton.add(UniversitaJLabel);
		
		JLabel CorsoJLabel = new JLabel("Corso di Sistemi Operativi del Prof. W. Balzano");
		CorsoJLabel.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		CorsoJLabel.setBounds(1128, 666, 245, 27);
		panelMainButton.add(CorsoJLabel);
		
		JLabel AnnoJLabel = new JLabel("Anno: 2021/2022");
		AnnoJLabel.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		AnnoJLabel.setBounds(1191, 693, 102, 18);
		panelMainButton.add(AnnoJLabel);
		
		JLabel SviluppatoriJLabel = new JLabel("Sviluppata da: A. Lanuto, E. Prosciutto, B. Scotto");
		SviluppatoriJLabel.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		SviluppatoriJLabel.setBounds(1118, 722, 269, 18);
		panelMainButton.add(SviluppatoriJLabel);
		
	
		
		

		
		JScrollPane scrollTabella= new JScrollPane();
		scrollTabella.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Table View", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollTabella.setBounds(144, 345, 1032, 130);
		panelMainButton.add(scrollTabella);
		
		JTable tabella = new JTable();
		tabella.setEnabled(false);
		tabella.setColumnSelectionAllowed(true);
		DefaultTableModel model1 = new DefaultTableModel()
		{
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0:
					return Integer.class;
				case 1:
					return Integer.class;
				case 2:
					return Integer.class;
				default:
					return Integer.class;
					
				}
			}
		};
		model1.addColumn("Nome Processo");
		model1.addColumn("Inizio Processo");
		model1.addColumn("Fine Processo");
		model1.addColumn("Inizio Zona Critica 1");	
		model1.addColumn("Fine Zona Critica 1");	
		model1.addColumn("Inizio Zona Critica 2");	
		model1.addColumn("Fine Zona Critica 2");
		model1.addColumn("Inizio Zona Critica 3");	
		model1.addColumn("Fine Zona Critica 3");
		tabella.setModel(model1);
		model1.addRow(new Object[]{"P1", "0", "300","0","0","0","0","0","0"});
		
		scrollTabella.setViewportView(tabella);

	        
	        //ProgressBar di secondo livello per colori
	        

	        
	        JProgressBar progressBarP3_Second = new JProgressBar();
	        progressBarP3_Second.setForeground(new Color(0, 250, 154));
	        //progressBarP3_Second.setBounds(39, 602, 146, 14);
	        panelMainButton.add(progressBarP3_Second);
	        progressBarP3_Second.setVisible(false);
	        
	        JProgressBar progressBarP4_Second = new JProgressBar();
	        progressBarP4_Second.setForeground(new Color(0, 250, 154));
	        //progressBarP4_Second.setBounds(39, 640, 146, 14);
	        panelMainButton.add(progressBarP4_Second);
	        progressBarP4_Second.setVisible(false);
	        
	        JProgressBar progressBarP5_Second = new JProgressBar();
	        progressBarP5_Second.setForeground(new Color(0, 250, 154));
	        //progressBarP5_Second.setBounds(39, 679, 146, 14);
	        panelMainButton.add(progressBarP5_Second);
	        progressBarP5_Second.setVisible(false);
	        
	        
		
		//ACTION ON NUM PROCESSI
		
		
		
		
		
		 JLabel GeneraEsercizioJLabel = new JLabel("Genera Esercizio");
	        GeneraEsercizioJLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        GeneraEsercizioJLabel.setBounds(1309, 422, 102, 15);
	        panelMainButton.add(GeneraEsercizioJLabel);
	        JLabel GeneraEsercizioIcon = new JLabel("");
	        
	        
	        //icona
	        GeneraEsercizioIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/write.png")));
	        GeneraEsercizioIcon.setBounds(1343, 371, 47, 57);
	        panelMainButton.add(GeneraEsercizioIcon);
	        
	        JLabel IndicatoreTempoIniz1 = new JLabel("Tempo 0");
	        IndicatoreTempoIniz1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
	        IndicatoreTempoIniz1.setBounds(250, 499, 53, 14);
	        panelMainButton.add(IndicatoreTempoIniz1);
	        
	        JLabel IndicatoreTempoFin1 = new JLabel("Tempo 300");
	        IndicatoreTempoFin1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
	        IndicatoreTempoFin1.setBounds(492, 499, 64, 14);
	        panelMainButton.add(IndicatoreTempoFin1);
	        
	        
	        
	        JLabel labelHelpIcon = new JLabel("Help");
	        labelHelpIcon.setBounds(1343, 460, 34, 46);
	        panelMainButton.add(labelHelpIcon);
	        labelHelpIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/question.png")));
	        
	        JPanel panelProgressBar1 = new JPanel();
	        panelProgressBar1.setBackground(Color.GRAY);
	        panelProgressBar1.setBounds(250, 524, 300, 29);
	        panelMainButton.add(panelProgressBar1);
	        panelProgressBar1.setLayout(null);
	        
	        JPanel panelProgressBar2 = new JPanel();
	        panelProgressBar2.setVisible(false);
	        panelProgressBar2.setLayout(null);
	        panelProgressBar2.setBackground(Color.GRAY);
	        panelProgressBar2.setBounds(250, 564, 300, 29);
	        panelMainButton.add(panelProgressBar2);
	        
	        JPanel panelProgressBar3 = new JPanel();
	        panelProgressBar3.setVisible(false);
	        panelProgressBar3.setLayout(null);
	        panelProgressBar3.setBackground(Color.GRAY);
	        panelProgressBar3.setBounds(250, 604, 300, 29);
	        panelMainButton.add(panelProgressBar3);
	        
	        JPanel panelProgressBar4 = new JPanel();
	        panelProgressBar4.setVisible(false);
	        panelProgressBar4.setLayout(null);
	        panelProgressBar4.setBackground(Color.GRAY);
	        panelProgressBar4.setBounds(250, 642, 300, 29);
	        panelMainButton.add(panelProgressBar4);
	        
	        
	        JPanel panelProgressBar5 = new JPanel();
	        panelProgressBar5.setVisible(false);
	        panelProgressBar5.setLayout(null);
	        panelProgressBar5.setBackground(Color.GRAY);
	        panelProgressBar5.setBounds(250, 682, 300, 29);
	        panelMainButton.add(panelProgressBar5);
	        
	        JProgressBar progressBarDurataProcesso_1 = new JProgressBar();
	        progressBarDurataProcesso_1.setMaximum(300);
	        progressBarDurataProcesso_1.setBackground(new Color(0, 250, 154));
	       // progressBarP1_Second.setBounds(39, 522, 146, 14);
	        
	        
	        JProgressBar progressBarZona1_1 = new JProgressBar();
	        progressBarZona1_1.setMaximum(300);       
	        progressBarZona1_1.setBackground(Color.RED);
	        
	        JProgressBar progressBarZona2_1 = new JProgressBar();
	        progressBarZona2_1.setMaximum(300);       
	        progressBarZona2_1.setBackground(new Color(229,57,53));
	        
	        JProgressBar progressBarZona3_1 = new JProgressBar();
	        progressBarZona3_1.setMaximum(300);       
	        progressBarZona3_1.setBackground(new Color(229,57,53));
	        
	        JProgressBar progressBarDurataProcesso_2 = new JProgressBar();
	        progressBarDurataProcesso_2.setMaximum(300);
	        progressBarDurataProcesso_2.setBackground(new Color(0, 250, 154));
	       // progressBarP1_Second.setBounds(39, 522, 146, 14);
	        
	    
	        JProgressBar progressBarZona1_2 = new JProgressBar();
	        progressBarZona1_2.setMaximum(300);       
	        progressBarZona1_2.setBackground(Color.RED);
	        
	        JProgressBar progressBarZona2_2 = new JProgressBar();
	        progressBarZona2_2.setMaximum(300);       
	        progressBarZona2_2.setBackground(new Color(229,57,53));
	        
	        JProgressBar progressBarZona3_2 = new JProgressBar();
	        progressBarZona3_2.setMaximum(300);       
	        progressBarZona3_2.setBackground(new Color(229,57,53));


	        
	        

	        GeneraEsercizioIcon.addMouseListener(new MouseAdapter() {
	        	@Override
				public void mouseClicked(MouseEvent e) 
	        	{
					int rowCount = tabella.getRowCount();
					int columnCount = tabella.getColumnCount();
					int randomNum=0;
					int k=0;
					int start_processo=0;
					int end_processo=0;
					int start_critica1=0,start_critica2=0,start_critica3=0;
					int end_critica1=0,end_critica2=0;
			
					StartEndProcessi.removeAll(StartEndProcessi);
					//algoritmo di generazione valori 
					for(int i=0; i<rowCount; i++) 
					{
						StartEndProcessi.add(new ProcessoSemaforo());
						for(int j=1; j<columnCount; j++) 
						{
						
							//inizio processo
							if(j==1)
							{
								randomNum= ThreadLocalRandom.current().nextInt(1, 50);
								StartEndProcessi.get(StartEndProcessi.size() - 1).inizioProcesso=randomNum;
							}
							
							//fine processo
							if(j==2)
							{
								randomNum= ThreadLocalRandom.current().nextInt(270, 300);
								StartEndProcessi.get(StartEndProcessi.size() - 1).fineProcesso=randomNum;
								end_processo=randomNum;
							}
							
							
							//inizio zona critica 1
						
							if(j==3)
							{
								randomNum= ThreadLocalRandom.current().nextInt(55, 80);
								StartEndProcessi.get(StartEndProcessi.size() - 1).inizioZonaCritica1=randomNum;
								
							}
							
							//fine zona critica 1
							if(j==4)
							{
								randomNum= ThreadLocalRandom.current().nextInt(100, 140);
								StartEndProcessi.get(StartEndProcessi.size() - 1).fineZonaCritica1=randomNum;
								
							}
							
							
							//inizio zona critica 2
							//start zona critica 2: >end zona critica 1 && compreso tra 160-184
							if(j==5)
							{
								randomNum= ThreadLocalRandom.current().nextInt(160, 184);
								StartEndProcessi.get(StartEndProcessi.size() - 1).inizioZonaCritica2=randomNum;
								
							}
							
							//fine zona critica 2
							//end zona critica 2: > start zona critica 2 && compreso tra 195-230
							if(j==6)
							{
								randomNum= ThreadLocalRandom.current().nextInt(195, 230);
								StartEndProcessi.get(StartEndProcessi.size() - 1).fineZonaCritica2=randomNum;
							}
							//inizio zona critica 3
							//start zona critica 3: >end zona critica 2 && compreso tra 238-268
							if(j==7)
							{
								randomNum= ThreadLocalRandom.current().nextInt(238, 268);
								StartEndProcessi.get(StartEndProcessi.size() - 1).inizioZonaCritica3=randomNum;
							}
							//fine zona critica 3
							//end zona critica 3: > start zona critica 3 && < end processo && compreso tra 275-287
							if(j==8)
							{
								do
									randomNum= ThreadLocalRandom.current().nextInt(275,287);
								while(randomNum>end_processo);
								StartEndProcessi.get(StartEndProcessi.size() - 1).fineZonaCritica3=randomNum;
							}
							model1.setValueAt(randomNum, i, j);

					}//second for
							
	        }//first for
					
					
					
			String NumeroProcessiS = (String) NumProcessiComboBox.getSelectedItem();
			int NumeroProcessi= Integer.valueOf(NumeroProcessiS);
			int startpoint,endpoint;
			startpoint=endpoint=0;
			
			
			
			if(NumeroProcessi==1)
			{
				panelProgressBar1.removeAll();
				panelProgressBar1.repaint();
				
		        //Zona Critica 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(0).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1] : Valori in posizione: " +startpoint + " e "+endpoint);
				progressBarZona1_1.setMaximum(endpoint);
				progressBarZona1_1.setMinimum(startpoint);
				progressBarZona1_1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				panelProgressBar1.add(progressBarZona1_1);
		        
				//Zona Critica 2
				startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(0).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2] : Valori in posizione: " +startpoint + " e "+endpoint);
				progressBarZona2_1.setMaximum(endpoint);
				progressBarZona2_1.setMinimum(startpoint);
				progressBarZona2_1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				panelProgressBar1.add(progressBarZona2_1);
				
				//Zona Critica 3
				startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(0).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3] : Valori in posizione: " +startpoint + " e "+endpoint);
				progressBarZona3_1.setMaximum(endpoint);
				progressBarZona3_1.setMinimum(startpoint);
				progressBarZona3_1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				panelProgressBar1.add(progressBarZona3_1);
		        
				//Inizio
				startpoint=StartEndProcessi.get(0).inizioProcesso;
				endpoint=StartEndProcessi.get(0).fineProcesso;
				System.out.println("[INIZIO] : Valori in posizione: " +startpoint + " e "+endpoint);
				panelProgressBar1.repaint();				
				progressBarDurataProcesso_1.setMaximum(endpoint);
				progressBarDurataProcesso_1.setMinimum(startpoint);
				progressBarDurataProcesso_1.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        panelProgressBar1.add(progressBarDurataProcesso_1);
		        
		       
		        
				   
			}
			
			
			if(NumeroProcessi==2)
			{
				//PROCESSO 1 !!!
				panelProgressBar1.removeAll();
				panelProgressBar1.repaint();
				panelProgressBar2.removeAll();
				panelProgressBar2.repaint();
				
		        //Zona Critica 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(0).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1] : Valori in posizione: " +startpoint + " e "+endpoint);
				progressBarZona1_1.setMaximum(endpoint);
				progressBarZona1_1.setMinimum(startpoint);
				progressBarZona1_1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				panelProgressBar1.add(progressBarZona1_1);
		       
				//Zona Critica 2
				startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(0).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2] : Valori in posizione: " +startpoint + " e "+endpoint);
				progressBarZona2_1.setMaximum(endpoint);
				progressBarZona2_1.setMinimum(startpoint);
				progressBarZona2_1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				panelProgressBar1.add(progressBarZona2_1);
				
				 
				
				//Zona Critica 3
				startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(0).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3] : Valori in posizione: " +startpoint + " e "+endpoint);
				progressBarZona3_1.setMaximum(endpoint);
				progressBarZona3_1.setMinimum(startpoint);
				progressBarZona3_1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				panelProgressBar1.add(progressBarZona3_1);
		        
				
				//Inizio
				startpoint=StartEndProcessi.get(0).inizioProcesso;
				endpoint=StartEndProcessi.get(0).fineProcesso;
				System.out.println("[INIZIO] : Valori in posizione: " +startpoint + " e "+endpoint);
				panelProgressBar1.repaint();				
				progressBarDurataProcesso_1.setMaximum(endpoint);
				progressBarDurataProcesso_1.setMinimum(startpoint);
				progressBarDurataProcesso_1.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        panelProgressBar1.add(progressBarDurataProcesso_1);
			
		        //PROCESSO 2 !!!
				
				
		        //Zona Critica 1
				startpoint=StartEndProcessi.get(1).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(1).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1] : Valori in posizione: " +startpoint + " e "+endpoint);
				progressBarZona1_2.setMaximum(endpoint);
				progressBarZona1_2.setMinimum(startpoint);
				progressBarZona1_2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				panelProgressBar2.add(progressBarZona1_2);
		        

		       
				//Zona Critica 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(1).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2] : Valori in posizione: " +startpoint + " e "+endpoint);
				progressBarZona2_2.setMaximum(endpoint);
				progressBarZona2_2.setMinimum(startpoint);
				progressBarZona2_2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				panelProgressBar2.add(progressBarZona2_2);
				
				//Zona Critica 3
				startpoint=StartEndProcessi.get(1).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(1).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3] : Valori in posizione: " +startpoint + " e "+endpoint);
				progressBarZona3_2.setMaximum(endpoint);
				progressBarZona3_2.setMinimum(startpoint);
				progressBarZona3_2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				panelProgressBar2.add(progressBarZona3_2);
		        
				//Inizio
				startpoint=StartEndProcessi.get(1).inizioProcesso;
				endpoint=StartEndProcessi.get(1).fineProcesso;
				System.out.println("[INIZIO] : Valori in posizione: " +startpoint + " e "+endpoint);			
				progressBarDurataProcesso_2.setMaximum(endpoint);
				progressBarDurataProcesso_2.setMinimum(startpoint);
				progressBarDurataProcesso_2.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        panelProgressBar2.add(progressBarDurataProcesso_2);
			}
			
			/*	
			if(NumeroProcessi==3)
				
			{
				System.out.println("Debug 3");
				//startpoint=findRightPositionJProgressBar(Integer.valueOf(StartEndProcessi.get(4)));
				//endpoint=findRightPositionJProgressBar(Integer.valueOf(StartEndProcessi.get(5)));
				progressBarP3_Second.setMaximum(endpoint);
				progressBarP3_Second.setMinimum(0);
				progressBarP3_Second.setBounds(startpoint+250, 602, 550-endpoint, 29);
				for(int m=0; m<=endpoint; m++) {
		        	progressBarP3_Second.setValue(m);
		        }
		        progressBarP3_Second.setVisible(true);
			}
			else if(NumeroProcessi==1 || NumeroProcessi==2)
			{
				progressBarP3_Second.setVisible(false);
			}
				
			
			if(NumeroProcessi==4)
			{
				System.out.println("Debug 4");
				//startpoint=findRightPositionJProgressBar(Integer.valueOf(StartEndProcessi.get(6)));
				//endpoint=findRightPositionJProgressBar(Integer.valueOf(StartEndProcessi.get(7)));
				progressBarP4_Second.setMaximum(endpoint);
				progressBarP4_Second.setMinimum(0);
				
				progressBarP4_Second.setBounds(startpoint+250, 640, 550-endpoint, 29);
				for(int m=0; m<=endpoint; m++) {
		        	progressBarP4_Second.setValue(m);
		        }
		        progressBarP4_Second.setVisible(true);
				
			}
			else if(NumeroProcessi==1 || NumeroProcessi==2 || NumeroProcessi==3)
			{
				progressBarP4_Second.setVisible(false);
			}
				
			
			if(NumeroProcessi==5)
			{
				System.out.println("Debug 5");
				//startpoint=findRightPositionJProgressBar(Integer.valueOf(StartEndProcessi.get(8)));
				//endpoint=findRightPositionJProgressBar(Integer.valueOf(StartEndProcessi.get(9)));
				progressBarP5_Second.setMaximum(endpoint);
				progressBarP5_Second.setMinimum(0);
				progressBarP5_Second.setBounds(startpoint+250, 680, 550-endpoint, 29);
				for(int m=0; m<=endpoint; m++) {
		        	progressBarP5_Second.setValue(m);
		        }
		        progressBarP5_Second.setVisible(true);
			
			}
			else if(NumeroProcessi==1 || NumeroProcessi==2 || NumeroProcessi==3 || NumeroProcessi==4)
			{
				
				progressBarP5_Second.setVisible(false);
			}
			*/
				
			
		

		}
	        	//mouseclicked end
	        	@Override
	        	public void mouseEntered(MouseEvent e) 
	        	{
	        		GeneraEsercizioJLabel.setForeground(Color.RED);
	        	}
	        	@Override
	        	public void mouseExited(MouseEvent e) 
	        	{
	        		GeneraEsercizioJLabel.setForeground(Color.BLACK);
	        	}
			});
	        NumProcessiComboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e)
				{
					String sceltaNumeroString =(String) NumProcessiComboBox.getSelectedItem();
					int sceltaNumero= Integer.valueOf(sceltaNumeroString);
					int rowCount = tabella.getRowCount();
					int columnCount = tabella.getColumnCount();

					//rimuove tutte le righe precedenti
					for (int i = rowCount - 1; i >= 0; i--) 
					{
				    	model1.removeRow(i);
					}
					//ricrea la tabella
					for (int i=0;i<sceltaNumero;i++) 
					{ 
						model1.addRow(new Object[0]);
						model1.setValueAt("P"+(i+1),i,0);
						
						
						//setting default values
						for(int j=1; j<columnCount; j++) {
							
							if(j==2)
								model1.setValueAt("300",i,j);
							else
								model1.setValueAt("0", i, j);
						}
					}
					
					
					//managing progress bars
					
					
					if (sceltaNumero==1) 
					{
						panelProgressBar1.setVisible(true);
						panelProgressBar2.setVisible(false);
						panelProgressBar3.setVisible(false);
						panelProgressBar4.setVisible(false);
						panelProgressBar5.setVisible(false);
					}
					else if(sceltaNumero==2)
					{
						panelProgressBar1.setVisible(true);
						panelProgressBar2.setVisible(true);
						panelProgressBar3.setVisible(false);
						panelProgressBar4.setVisible(false);
						panelProgressBar5.setVisible(false);
					}
					
					else if(sceltaNumero==3)
					{
						panelProgressBar1.setVisible(true);
						panelProgressBar2.setVisible(true);
						panelProgressBar3.setVisible(true);
						panelProgressBar4.setVisible(false);
						panelProgressBar5.setVisible(false);
					}
					
					else if(sceltaNumero==4)
					{
						panelProgressBar1.setVisible(true);
						panelProgressBar2.setVisible(true);
						panelProgressBar3.setVisible(true);
						panelProgressBar4.setVisible(true);
						panelProgressBar5.setVisible(false);
					}
					
					else if(sceltaNumero==5)
					{
						panelProgressBar1.setVisible(true);
						panelProgressBar2.setVisible(true);
						panelProgressBar3.setVisible(true);
						panelProgressBar4.setVisible(true);
						panelProgressBar5.setVisible(true);
					}
					
				}
			});
			
	       
	       
		
		
		
	}
}