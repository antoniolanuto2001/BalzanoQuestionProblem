package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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

import model.Semaforo;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuListener;
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

	/**
	 * Create the frame.
	 */
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
		desktopPane.setBounds(75, 170, 353, 156);
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
		JLabelTextMutex1.setBounds(888, 333, 79, 14);
		panelMainButton.add(JLabelTextMutex1);
		
		JLabel JLabelTextMutex2 = new JLabel("Mutex=1");
		JLabelTextMutex2.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		JLabelTextMutex2.setBounds(1094, 333, 79, 14);
		panelMainButton.add(JLabelTextMutex2);
		JLabelTextMutex2.setVisible(false);
		
		//creating a default semaphore graphic
		JPanel PannelloGraficaSemaforo1 = new Semaforo();
		PannelloGraficaSemaforo1.setBackground(new Color(255,255,255));
		PannelloGraficaSemaforo1.setBounds(833, 146, 174, 176);
		panelMainButton.add(PannelloGraficaSemaforo1);
		
		
		//second semaphore graphic
		JPanel PannelloGraficaSemaforo2 = new Semaforo();
		PannelloGraficaSemaforo2.setBackground(new Color(255,255,255));
		PannelloGraficaSemaforo2.setBounds(1029,146,174,176);
		panelMainButton.add(PannelloGraficaSemaforo2);
		PannelloGraficaSemaforo2.setVisible(false);
		
		NumSemaforiComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Object item = NumSemaforiComboBox.getSelectedItem();
				
				if("2".equals(item))
				{
					//visibilità semaforo
					PannelloGraficaSemaforo2.setVisible(true);
					//visibilità testo
					JLabelTextMutex2.setVisible(true);
					
				}else if("1".equals(item))
				{
					//visibilità semaforo
					PannelloGraficaSemaforo2.setVisible(false);
					//visibilità testo
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
		scrollTabella.setBounds(185, 376, 1032, 130);
		panelMainButton.add(scrollTabella);
		
		JTable tabella = new JTable();
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
		
		
		
		
		 JProgressBar progressBarP1 = new JProgressBar();
		 progressBarP1.setForeground(new Color(192, 192, 192));
		 progressBarP1.setBackground(new Color(255, 255, 255));
		 progressBarP1.setMaximum(300);
		 progressBarP1.setToolTipText("");
	        progressBarP1.setOrientation(SwingConstants.VERTICAL);
	        progressBarP1.setBounds(379, 517, 28, 207);
	        panelMainButton.add(progressBarP1);
	        
	        JProgressBar progressBarP2 = new JProgressBar();
	        progressBarP2.setBackground(new Color(255, 255, 255));
	        progressBarP2.setMaximum(300);
	        progressBarP2.setOrientation(SwingConstants.VERTICAL);
	        progressBarP2.setBounds(478, 517, 28, 207);
	        panelMainButton.add(progressBarP2);
	        progressBarP2.setVisible(false);
	        
	        JProgressBar progressBarP3 = new JProgressBar();
	        progressBarP3.setBackground(new Color(255, 255, 255));
	        progressBarP3.setMaximum(300);
	        progressBarP3.setOrientation(SwingConstants.VERTICAL);
	        progressBarP3.setBounds(569, 517, 28, 207);
	        panelMainButton.add(progressBarP3);
	        progressBarP3.setVisible(false);
	        
	        JProgressBar progressBarP4 = new JProgressBar();
	        progressBarP4.setBackground(new Color(255, 255, 255));
	        progressBarP4.setMaximum(300);
	        progressBarP4.setOrientation(SwingConstants.VERTICAL);
	        progressBarP4.setBounds(663, 517, 28, 207);
	        panelMainButton.add(progressBarP4);
	        progressBarP4.setVisible(false);
	        
	        
	        
	        JProgressBar progressBarP5 = new JProgressBar();
	        progressBarP5.setBackground(new Color(255, 255, 255));
	        progressBarP5.setMaximum(300);
	        progressBarP5.setOrientation(SwingConstants.VERTICAL);
	        progressBarP5.setBounds(752, 517, 28, 207);
	        panelMainButton.add(progressBarP5);
	        progressBarP5.setVisible(false);
	 
		
		//ACTION ON NUM PROCESSI
		
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
				
				if(sceltaNumero==2)
				{
					 progressBarP2.setVisible(true);
				}else if(sceltaNumero==1)
					progressBarP2.setVisible(false);
					
				if(sceltaNumero==3)
				{
					 progressBarP3.setVisible(true);
					 progressBarP2.setVisible(true);
				}else if(sceltaNumero==1 || sceltaNumero==2)
					progressBarP3.setVisible(false);
				
				if(sceltaNumero==4)
				{
					 progressBarP3.setVisible(true);
					 progressBarP2.setVisible(true);
					 progressBarP4.setVisible(true);
				}else if(sceltaNumero==1 || sceltaNumero==2 || sceltaNumero==3)
					progressBarP4.setVisible(false);
				
				if(sceltaNumero==5)
				{
					progressBarP3.setVisible(true);
					progressBarP2.setVisible(true);
					progressBarP4.setVisible(true);
					progressBarP5.setVisible(true);
				}else if(sceltaNumero==1 || sceltaNumero==2 || sceltaNumero==3 ||sceltaNumero==4)
					progressBarP5.setVisible(false);
				
			}
		});
		
		
		
		
		 JLabel GeneraEsercizioJLabel = new JLabel("Genera Esercizio");
	        GeneraEsercizioJLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        GeneraEsercizioJLabel.setBounds(1309, 422, 102, 15);
	        panelMainButton.add(GeneraEsercizioJLabel);
	        JLabel GeneraEsercizioIcon = new JLabel("");
	        GeneraEsercizioIcon.addMouseListener(new MouseAdapter() {
	        	@Override
				public void mouseClicked(MouseEvent e) {
					int rowCount = tabella.getRowCount();
					int columnCount = tabella.getColumnCount();
					int randomNum=0;
					int start_processo=0;
					int end_processo=0;
					int start_critica1=0,start_critica2=0,start_critica3=0;
					int end_critica1=0,end_critica2=0;
			
					
					//algoritmo di generazione valori 
					for(int i=0; i<rowCount; i++) {
						for(int j=1; j<columnCount; j++) {
						
							//inizio processo
							if(j==1)
							{
								randomNum= ThreadLocalRandom.current().nextInt(1, 50);
								start_processo=randomNum;
							}
							
							//fine processo
							if(j==2)
							{
								randomNum= ThreadLocalRandom.current().nextInt(270, 300);
								end_processo=randomNum;
							}
							
							//inizio zona critica 1
						
							if(j==3)
							{
								randomNum= ThreadLocalRandom.current().nextInt(55, 80);
								start_critica1=randomNum;
							}
							
							//fine zona critica 1
							if(j==4)
							{
								randomNum= ThreadLocalRandom.current().nextInt(100, 140);
								end_critica1=randomNum;
							}
							
							
							//inizio zona critica 2
							//start zona critica 2: >end zona critica 1 && compreso tra 160-184
							if(j==5)
							{
								randomNum= ThreadLocalRandom.current().nextInt(160, 184);
								start_critica2=randomNum;
							}
							
							//fine zona critica 2
							//end zona critica 2: > start zona critica 2 && compreso tra 195-230
							if(j==6)
							{
								randomNum= ThreadLocalRandom.current().nextInt(195, 230);
								end_critica2=randomNum;
							}
							
							//inizio zona critica 3
							//start zona critica 3: >end zona critica 2 && compreso tra 238-268
							if(j==7)
							{
								
								randomNum= ThreadLocalRandom.current().nextInt(238, 268);
								start_critica3=randomNum;
							}
							
							//fine zona critica 3
							//end zona critica 3: > start zona critica 3 && < end processo && compreso tra 275-287
							if(j==8)
							{
								randomNum= ThreadLocalRandom.current().nextInt(275,287);	
							}
							
							
							
							model1.setValueAt(randomNum, i, j);
						}
					}
					
				}
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
	        
	        GeneraEsercizioIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/write.png")));
	        GeneraEsercizioIcon.setBounds(1343, 371, 47, 57);
	        panelMainButton.add(GeneraEsercizioIcon);
	        
	        JLabel IndicatoreTempoIniz1 = new JLabel("Tempo 0");
	        IndicatoreTempoIniz1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
	        IndicatoreTempoIniz1.setBounds(316, 517, 53, 14);
	        panelMainButton.add(IndicatoreTempoIniz1);
	        
	        JLabel IndicatoreTempoFin1 = new JLabel("Tempo 300");
	        IndicatoreTempoFin1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
	        IndicatoreTempoFin1.setBounds(305, 709, 64, 14);
	        panelMainButton.add(IndicatoreTempoFin1);
	        
	        
	        
	        JLabel labelHelpIcon = new JLabel("Help");
	        labelHelpIcon.setBounds(1343, 460, 34, 46);
	        panelMainButton.add(labelHelpIcon);
	        labelHelpIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/question.png")));
	        
	       
	       
		
		
		
	}
}