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
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
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

import java.awt.SystemColor;
import java.awt.Taskbar;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicBorders.ToggleButtonBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.Box;

public class Semafori extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	public 	boolean continuaBoolean;
	public ArrayList<ProcessoSemaforo> StartEndProcessi = new ArrayList<ProcessoSemaforo>();
	final int min_JProgress_range=0;
	final int max_JProgress_range=300;

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
		
		
		
		continuaBoolean=true;
		JPanel panelMainButton = new JPanel();
		panelMainButton.setBackground(new Color(255, 255, 255));
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);

		JPanel panelSuperiore = new JPanel();
		panelSuperiore.setBackground(new Color(245, 245, 245));
		panelSuperiore.setBounds(-71, 0, 1495, 73);
		panelMainButton.add(panelSuperiore);
		panelSuperiore.setLayout(null);

		JLabel labelTitoloSchermata = new JLabel(" Semafori ");
		labelTitoloSchermata.setBounds(70, 0, 320, 89);
		panelSuperiore.add(labelTitoloSchermata);
		labelTitoloSchermata.setBackground(new Color(224, 255, 255));
		labelTitoloSchermata.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 47));
		

		JLabel labelIndietroIcon = new JLabel("Indietro");
	    labelIndietroIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/back-button.png")));
	    labelIndietroIcon.setBounds(10, 87, 34, 46);
	    panelMainButton.add(labelIndietroIcon);
		
		JLabel labelScrittaSlide = new JLabel("Slide Argomento");
	    labelScrittaSlide.setFont(new Font("Tw Cen MT", Font.BOLD, 13));
	    labelScrittaSlide.setBounds(1316, 345, 95, 15);
	    panelMainButton.add(labelScrittaSlide);
	     
	    JLabel labelSlideIcon = new JLabel("");
	    labelSlideIcon.setIcon(new ImageIcon(Filosofi.class.getResource("/img/pdfIcon1.png")));
	    labelSlideIcon.setBounds(1333, 296, 53, 46);
	    panelMainButton.add(labelSlideIcon);

		JLabel labelScrittaYoutube = new JLabel("VideoLezione");
		labelScrittaYoutube.setFont(new Font("Tw Cen MT", Font.BOLD, 13));
		labelScrittaYoutube.setBounds(1322, 260, 82, 27);
		panelMainButton.add(labelScrittaYoutube);
		
		JLabel labelYoutubeIcon = new JLabel("");
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
		JLabelTextMutex1.setBounds(705, 222, 79, 14);
		panelMainButton.add(JLabelTextMutex1);
		
		JLabel JLabelTextMutex2 = new JLabel("Mutex=1");
		JLabelTextMutex2.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		JLabelTextMutex2.setBounds(986, 222, 79, 14);
		panelMainButton.add(JLabelTextMutex2);
		JLabelTextMutex2.setVisible(false);
		
		//creating a default semaphore graphic
		JLabel GraficaSemaforo1JLabel = new JLabel("");
		JLabelTextMutex1.setLabelFor(GraficaSemaforo1JLabel);
		GraficaSemaforo1JLabel.setIcon(new ImageIcon(Semafori.class.getResource("/img/semaforoVerdeIcon1.png")));
		GraficaSemaforo1JLabel.setBackground(new Color(255,255,255));
		GraficaSemaforo1JLabel.setBounds(577, 117, 118, 205);
		panelMainButton.add(GraficaSemaforo1JLabel);
		GraficaSemaforo1JLabel.setLayout(null);
		
		
		//second semaphore graphic
		JLabel GraficaSemaforo2JLabel = new JLabel("");
		JLabelTextMutex2.setLabelFor(GraficaSemaforo2JLabel);
		GraficaSemaforo2JLabel.setIcon(new ImageIcon(Semafori.class.getResource("/img/semaforoVerdeIcon1.png")));
		GraficaSemaforo2JLabel.setBackground(new Color(255,255,255));
		GraficaSemaforo2JLabel.setBounds(841,117, 118, 205);
		panelMainButton.add(GraficaSemaforo2JLabel);
		GraficaSemaforo2JLabel.setLayout(null);
		GraficaSemaforo2JLabel.setVisible(false);

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


		JLabel GeneraEsercizioJLabel = new JLabel("Genera Esercizio");
		GeneraEsercizioJLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 13));
		GeneraEsercizioJLabel.setBounds(1316, 422, 102, 15);
		panelMainButton.add(GeneraEsercizioJLabel);
		
		
		JLabel GeneraEsercizioIcon = new JLabel("");
		GeneraEsercizioIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/write.png")));
		GeneraEsercizioIcon.setBounds(1343, 371, 47, 57);
		panelMainButton.add(GeneraEsercizioIcon);
	        
		JLabel StartTimeIndexJLabel = new JLabel("Tempo 0");
		StartTimeIndexJLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		StartTimeIndexJLabel.setBounds(250, 499, 53, 14);
		panelMainButton.add(StartTimeIndexJLabel);
	        
		JLabel EndTimeIndexJLabel = new JLabel("Tempo 300");
		EndTimeIndexJLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		EndTimeIndexJLabel.setBounds(492, 499, 64, 14);
		panelMainButton.add(EndTimeIndexJLabel);
	        
	            
		JLabel HelpIconJLabel = new JLabel("");
		HelpIconJLabel.setBounds(1343, 451, 34, 46);
		panelMainButton.add(HelpIconJLabel);
		HelpIconJLabel.setIcon(new ImageIcon(Semafori.class.getResource("/img/question.png")));
		
		JLabel HelpJLabel = new JLabel("Info Uso");
		HelpJLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 13));
		HelpJLabel.setBounds(1335, 498, 70, 15);
		panelMainButton.add(HelpJLabel);
		
		
		JPanel BaseProgressBar1JPanel = new JPanel();
		BaseProgressBar1JPanel.setBackground(Color.GRAY);
		BaseProgressBar1JPanel.setBounds(250, 524, 300, 29);
		panelMainButton.add(BaseProgressBar1JPanel);
		BaseProgressBar1JPanel.setLayout(null);
		BaseProgressBar1JPanel.setOpaque(true);
		
		
		GraficaIndicatoreSemafori TestIndicatore = new GraficaIndicatoreSemafori(0, 0, 4, 29);
		BaseProgressBar1JPanel.add(TestIndicatore);
		TestIndicatore.setLayout(null);
		TestIndicatore.setVisible(true);
	
		

		JPanel BaseProgressBar2JPanel = new JPanel();
		BaseProgressBar2JPanel.setVisible(false);
		BaseProgressBar2JPanel.setLayout(null);
		BaseProgressBar2JPanel.setBackground(Color.GRAY);
		BaseProgressBar2JPanel.setBounds(250, 564, 300, 29);
		panelMainButton.add(BaseProgressBar2JPanel);
		BaseProgressBar2JPanel.setOpaque(true);
	        
		JPanel BaseProgressBar3JPanel = new JPanel();
		BaseProgressBar3JPanel.setVisible(false);
		BaseProgressBar3JPanel.setLayout(null);
		BaseProgressBar3JPanel.setBackground(Color.GRAY);
		BaseProgressBar3JPanel.setBounds(250, 604, 300, 29);
		panelMainButton.add(BaseProgressBar3JPanel);
		BaseProgressBar3JPanel.setOpaque(true);
	        
        JPanel BaseProgressBar4JPanel = new JPanel();
        BaseProgressBar4JPanel.setVisible(false);
        BaseProgressBar4JPanel.setLayout(null);
        BaseProgressBar4JPanel.setBackground(Color.GRAY);
        BaseProgressBar4JPanel.setBounds(250, 642, 300, 29);
        panelMainButton.add(BaseProgressBar4JPanel);
        BaseProgressBar4JPanel.setOpaque(true);
	        
	        
        JPanel BaseProgressBar5JPanel = new JPanel();
        BaseProgressBar5JPanel.setVisible(false);
        BaseProgressBar5JPanel.setLayout(null);
        BaseProgressBar5JPanel.setBackground(Color.GRAY);
        BaseProgressBar5JPanel.setBounds(250, 682, 300, 29);
        panelMainButton.add(BaseProgressBar5JPanel);
        BaseProgressBar5JPanel.setOpaque(true);
        
        JPanel Indicatore2 = new JPanel();
        BaseProgressBar2JPanel.add(Indicatore2);
        Indicatore2.setBackground(Color.BLACK);
        Indicatore2.setBounds(0,0,4,29);
        Indicatore2.setVisible(true);
        Indicatore2.setLayout(null);
        Indicatore2.setOpaque(true);
        
        JPanel Indicatore3= new JPanel();
        BaseProgressBar3JPanel.add(Indicatore3);
        Indicatore3.setBackground(Color.BLACK);
        Indicatore3.setBounds(0,0,4,29);
        Indicatore3.setVisible(true);
        Indicatore3.setLayout(null);
        Indicatore3.setOpaque(true);
        
        JPanel Indicatore4 = new JPanel();
        BaseProgressBar4JPanel.add(Indicatore4);
        Indicatore4.setBackground(Color.BLACK);
        Indicatore4.setBounds(0,0,4,29);
        Indicatore4.setVisible(true);
        Indicatore4.setLayout(null);
        Indicatore4.setOpaque(true);
        
        JPanel Indicatore5 = new JPanel();
        BaseProgressBar5JPanel.add(Indicatore5);
        Indicatore5.setBackground(Color.BLACK);
        Indicatore5.setBounds(0,0,4,29);
        Indicatore5.setVisible(true);
        Indicatore5.setLayout(null);
        Indicatore5.setOpaque(true);
        

     
        
 
        
       
        JPanel JobDuration1JPanel = new JPanel();
        JobDuration1JPanel.setVisible(false);
        JobDuration1JPanel.setLayout(null);
        JobDuration1JPanel.setBackground(Color.GREEN);
        JobDuration1JPanel.setMaximumSize(new Dimension(300,29));
        JobDuration1JPanel.setOpaque(true);
        
        JPanel JobDuration2JPanel = new JPanel();
        JobDuration2JPanel.setVisible(false);
        JobDuration2JPanel.setLayout(null);
        JobDuration2JPanel.setBackground(Color.GREEN);
        JobDuration2JPanel.setMaximumSize(new Dimension(300,29));
        JobDuration2JPanel.setOpaque(true);
        
        JPanel JobDuration3JPanel = new JPanel();
        JobDuration3JPanel.setVisible(false);
        JobDuration3JPanel.setLayout(null);
        JobDuration3JPanel.setBackground(Color.GREEN);
        JobDuration3JPanel.setMaximumSize(new Dimension(300,29));
        JobDuration3JPanel.setOpaque(true);
        
        JPanel JobDuration4JPanel = new JPanel();
        JobDuration4JPanel.setVisible(false);
        JobDuration4JPanel.setLayout(null);
        JobDuration4JPanel.setBackground(Color.GREEN);
        JobDuration4JPanel.setMaximumSize(new Dimension(300,29));
        JobDuration4JPanel.setOpaque(true);
        
        JPanel JobDuration5JPanel = new JPanel();
        JobDuration5JPanel.setVisible(false);
        JobDuration5JPanel.setLayout(null);
        JobDuration5JPanel.setBackground(Color.GREEN);
        JobDuration5JPanel.setMaximumSize(new Dimension(300,29));
        JobDuration5JPanel.setOpaque(true);

        JPanel CriticalArea1JPanel1 = new JPanel();
        CriticalArea1JPanel1.setVisible(false);
        CriticalArea1JPanel1.setLayout(null);
        CriticalArea1JPanel1.setBackground(Color.RED);
        CriticalArea1JPanel1.setOpaque(true);
        CriticalArea1JPanel1.setMaximumSize(new Dimension(300,29));
        
        JPanel CriticalArea2JPanel1 = new JPanel();
        CriticalArea2JPanel1.setVisible(false);
        CriticalArea2JPanel1.setLayout(null);
        CriticalArea2JPanel1.setBackground(Color.RED);
        CriticalArea2JPanel1.setOpaque(true);
        CriticalArea2JPanel1.setMaximumSize(new Dimension(300,29));
        
        JPanel CriticalArea3JPanel1 = new JPanel();
        CriticalArea3JPanel1.setVisible(false);
        CriticalArea3JPanel1.setLayout(null);
        CriticalArea3JPanel1.setBackground(Color.RED);
        CriticalArea3JPanel1.setOpaque(true);
        CriticalArea3JPanel1.setMaximumSize(new Dimension(300,29));
        
        
        JPanel CriticalArea1JPanel2 = new JPanel();
        CriticalArea1JPanel2.setVisible(false);
        CriticalArea1JPanel2.setLayout(null);
        CriticalArea1JPanel2.setBackground(Color.RED);
        CriticalArea1JPanel2.setOpaque(true);
        CriticalArea1JPanel2.setMaximumSize(new Dimension(300,29));
        
        JPanel CriticalArea2JPanel2 = new JPanel();
        CriticalArea2JPanel2.setVisible(false);
        CriticalArea2JPanel2.setLayout(null);
        CriticalArea2JPanel2.setBackground(Color.RED);
        CriticalArea2JPanel2.setOpaque(true);
        CriticalArea2JPanel2.setMaximumSize(new Dimension(300,29));
        
        JPanel CriticalArea3JPanel2 = new JPanel();
        CriticalArea3JPanel2.setVisible(false);
        CriticalArea3JPanel2.setLayout(null);
        CriticalArea3JPanel2.setBackground(Color.RED);
        CriticalArea3JPanel2.setOpaque(true);
        CriticalArea3JPanel2.setMaximumSize(new Dimension(300,29));
        
        JPanel CriticalArea1JPanel3 = new JPanel();
        CriticalArea1JPanel3.setVisible(false);
        CriticalArea1JPanel3.setLayout(null);
        CriticalArea1JPanel3.setBackground(Color.RED);
        CriticalArea1JPanel3.setOpaque(true);
        CriticalArea1JPanel3.setMaximumSize(new Dimension(300,29));
        
        
        JPanel CriticalArea2JPanel3 = new JPanel();
        CriticalArea2JPanel3.setVisible(false);
        CriticalArea2JPanel3.setLayout(null);
        CriticalArea2JPanel3.setBackground(Color.RED);
        CriticalArea2JPanel3.setOpaque(true);
        CriticalArea2JPanel3.setMaximumSize(new Dimension(300,29));
        
        JPanel CriticalArea3JPanel3 = new JPanel();
        CriticalArea3JPanel3.setVisible(false);
        CriticalArea3JPanel3.setLayout(null);
        CriticalArea3JPanel3.setBackground(Color.RED);
        CriticalArea3JPanel3.setOpaque(true);
        CriticalArea3JPanel3.setMaximumSize(new Dimension(300,29));
        
        
        
        JPanel CriticalArea1JPanel4 = new JPanel();
        CriticalArea1JPanel4.setVisible(false);
        CriticalArea1JPanel4.setLayout(null);
        CriticalArea1JPanel4.setBackground(Color.RED);
        CriticalArea1JPanel4.setOpaque(true);
        CriticalArea1JPanel4.setMaximumSize(new Dimension(300,29));
        
        
        JPanel CriticalArea2JPanel4 = new JPanel();
        CriticalArea2JPanel4.setVisible(false);
        CriticalArea2JPanel4.setLayout(null);
        CriticalArea2JPanel4.setBackground(Color.RED);
        CriticalArea2JPanel4.setOpaque(true);
        CriticalArea2JPanel4.setMaximumSize(new Dimension(300,29));
        
        
        JPanel CriticalArea3JPanel4 = new JPanel();
        CriticalArea3JPanel4.setVisible(false);
        CriticalArea3JPanel4.setLayout(null);
        CriticalArea3JPanel4.setBackground(Color.RED);
        CriticalArea3JPanel4.setOpaque(true);
        CriticalArea3JPanel4.setMaximumSize(new Dimension(300,29));
        
        
        
        JPanel CriticalArea1JPanel5 = new JPanel();
        CriticalArea1JPanel5.setVisible(false);
        CriticalArea1JPanel5.setLayout(null);
        CriticalArea1JPanel5.setBackground(Color.RED);
        CriticalArea1JPanel5.setOpaque(true);
        CriticalArea1JPanel5.setMaximumSize(new Dimension(300,29));
        
        JPanel CriticalArea2JPanel5 = new JPanel();
        CriticalArea2JPanel5.setVisible(false);
        CriticalArea2JPanel5.setLayout(null);
        CriticalArea2JPanel5.setBackground(Color.RED);
        CriticalArea2JPanel5.setOpaque(true);
        CriticalArea2JPanel5.setMaximumSize(new Dimension(300,29));
        
        JPanel CriticalArea3JPanel5 = new JPanel();
        CriticalArea3JPanel5.setVisible(false);
        CriticalArea3JPanel5.setLayout(null);
        CriticalArea3JPanel5.setBackground(Color.RED);
        CriticalArea3JPanel5.setOpaque(true);
        CriticalArea3JPanel5.setMaximumSize(new Dimension(300,29));
	        
	    
	        
	        
	        
	        
//------------------------------------------------------------------------------------------------
//								ACTIONS PERFORMED
//------------------------------------------------------------------------------------------------	        
	        
	        
	        

	        GeneraEsercizioIcon.addMouseListener(new MouseAdapter() {
	        	@Override
				public void mouseClicked(MouseEvent e) 
	        	{
					int rowCount = tabella.getRowCount();
					int columnCount = tabella.getColumnCount();
					int randomNum=0;
					int startpoint=0,endpoint=0;
					int end_processo=0,start_processo=0;
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
								
								randomNum= (int)Math.floor(Math.random()*(50-1+1)+1);
								StartEndProcessi.get(StartEndProcessi.size() - 1).inizioProcesso=randomNum;
								start_processo=randomNum;
							}
							
							//fine processo
							if(j==2)
							{
								
								randomNum= (int)Math.floor(Math.random()*(300-260+1)+260);
								StartEndProcessi.get(StartEndProcessi.size() - 1).fineProcesso=randomNum;
								end_processo=randomNum;
						
							}
							
							
							//inizio zona critica 1
						
							if(j==3)
							{
								
								randomNum= (int)Math.floor(Math.random()*(75-55+1)+55);
								StartEndProcessi.get(StartEndProcessi.size() - 1).inizioZonaCritica1=randomNum;
								start_critica1=randomNum;
								
							}
							
							//fine zona critica 1
							if(j==4)
							{
								
								randomNum= (int)Math.floor(Math.random()*(101-80+1)+80);
								StartEndProcessi.get(StartEndProcessi.size() - 1).fineZonaCritica1=randomNum;
								end_critica1=randomNum;
								
							}
							
							
							//inizio zona critica 2
							//start zona critica 2: >end zona critica 1 && compreso tra 160-184
							if(j==5)
							{
								
								randomNum= (int)Math.floor(Math.random()*(135-105+1)+105);
								StartEndProcessi.get(StartEndProcessi.size() - 1).inizioZonaCritica2=randomNum;
								start_critica2=randomNum;
								
							}
							
							//fine zona critica 2
							//end zona critica 2: > start zona critica 2 && compreso tra 195-230
							if(j==6)
							{
								
								randomNum= (int)Math.floor(Math.random()*(190-166+1)+166);
								StartEndProcessi.get(StartEndProcessi.size() - 1).fineZonaCritica2=randomNum;
								end_critica2=randomNum;
							}
							//inizio zona critica 3
							//start zona critica 3: >end zona critica 2 && compreso tra 238-268
							if(j==7)
							{
								
								randomNum= (int)Math.floor(Math.random()*(220-200+1)+200);
								StartEndProcessi.get(StartEndProcessi.size() - 1).inizioZonaCritica3=randomNum;
								start_critica3=randomNum;
							}
							//fine zona critica 3
							//end zona critica 3: > start zona critica 3 && < end processo && compreso tra 275-287
							if(j==8)
							{
								
								randomNum= ThreadLocalRandom.current().nextInt(250,280);
								
								
								
								StartEndProcessi.get(StartEndProcessi.size() - 1).fineZonaCritica3=randomNum;
								
							}
							
							model1.setValueAt(randomNum, i, j);
							randomNum=0;
					}//second for
							
	        }//first for
					

			if(rowCount==1)
			{
				//Repaint di P1
			/*	BaseProgressBar1JPanel.removeAll();
				BaseProgressBar1JPanel.repaint();
			*/
				
				//Job Duration 1
				startpoint=StartEndProcessi.get(0).inizioProcesso;
				endpoint=StartEndProcessi.get(0).fineProcesso;
				System.out.println("[INIZIO] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration1JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar1JPanel.add(JobDuration1JPanel);
		        JobDuration1JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(0).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea1JPanel1);
				CriticalArea1JPanel1.setVisible(true);
	        
				//Critical Area 2 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(0).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea2JPanel1);
				CriticalArea2JPanel1.setVisible(true);
				
				//Critical Area 2 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(0).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea3JPanel1);
				CriticalArea3JPanel1.setVisible(true);
			}
			
			
			else if(rowCount==2)
			{
				//Repaint di P1 e P2
			
			/*	BaseProgressBar1JPanel.removeAll();
				BaseProgressBar1JPanel.repaint();
				BaseProgressBar2JPanel.removeAll();
				BaseProgressBar2JPanel.repaint();
				
			*/
		
				//PROCESSO 1 !!!
						
				//Job Duration 1
				startpoint=StartEndProcessi.get(0).inizioProcesso;
				endpoint=StartEndProcessi.get(0).fineProcesso;
				System.out.println("[INIZIO P1] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration1JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar1JPanel.add(JobDuration1JPanel);
		        JobDuration1JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(0).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea1JPanel1);
				CriticalArea1JPanel1.setVisible(true);
	        
				//Critical Area 2 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(0).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea2JPanel1);
				CriticalArea2JPanel1.setVisible(true);
				
				//Critical Area 3 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(0).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea3JPanel1);
				CriticalArea3JPanel1.setVisible(true);
			
		        //PROCESSO 2 !!!
				
						
				//Job Duration 2
				startpoint=StartEndProcessi.get(1).inizioProcesso;
				endpoint=StartEndProcessi.get(1).fineProcesso;
				System.out.println("[INIZIO P2] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration2JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar2JPanel.add(JobDuration2JPanel);
		        JobDuration2JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(1).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea1JPanel2);
				CriticalArea1JPanel2.setVisible(true);
	        
				//Critical Area 2 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(1).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea2JPanel2);
				CriticalArea2JPanel2.setVisible(true);
				
				//Critical Area 3 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(1).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea3JPanel2);
				CriticalArea3JPanel2.setVisible(true);
				
		     
			}
			
			else if(rowCount==3)
			{
				//Repaint di P1, P2, P3
				
			/*	BaseProgressBar1JPanel.removeAll();
				BaseProgressBar1JPanel.repaint();
				BaseProgressBar2JPanel.removeAll();
				BaseProgressBar2JPanel.repaint();
				BaseProgressBar3JPanel.removeAll();
				BaseProgressBar3JPanel.repaint();
			*/
		
				//PROCESSO 1 !!!
						
				//Job Duration 1
				startpoint=StartEndProcessi.get(0).inizioProcesso;
				endpoint=StartEndProcessi.get(0).fineProcesso;
				System.out.println("[INIZIO P1] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration1JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar1JPanel.add(JobDuration1JPanel);
				JobDuration1JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(0).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea1JPanel1);
				CriticalArea1JPanel1.setVisible(true);
	        
				//Critical Area 2 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(0).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea2JPanel1);
				CriticalArea2JPanel1.setVisible(true);
				
				//Critical Area 3 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(0).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea3JPanel1);
				CriticalArea3JPanel1.setVisible(true);
			
		        //PROCESSO 2 !!!
				
						
				//Job Duration 2
				startpoint=StartEndProcessi.get(1).inizioProcesso;
				endpoint=StartEndProcessi.get(1).fineProcesso;
				System.out.println("[INIZIO P2] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration2JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar2JPanel.add(JobDuration2JPanel);
				JobDuration2JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(1).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea1JPanel2);
				CriticalArea1JPanel2.setVisible(true);
	        
				//Critical Area 2 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(1).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea2JPanel2);
				CriticalArea2JPanel2.setVisible(true);
				
				//Critical Area 3 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(1).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea3JPanel2);
				CriticalArea3JPanel2.setVisible(true);
				
				
				
				//PROCESSO 3 !!!
				
				//Job Duration 3
				startpoint=StartEndProcessi.get(2).inizioProcesso;
				endpoint=StartEndProcessi.get(2).fineProcesso;
				System.out.println("[INIZIO P3] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration3JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar3JPanel.add(JobDuration3JPanel);
		        JobDuration3JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(2).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration3JPanel.add(CriticalArea1JPanel3);
				CriticalArea1JPanel3.setVisible(true);
	        
				//Critical Area 2 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(2).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration3JPanel.add(CriticalArea2JPanel3);
				CriticalArea2JPanel3.setVisible(true);
				
				//Critical Area 3 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(2).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration3JPanel.add(CriticalArea3JPanel3);
				CriticalArea3JPanel3.setVisible(true);
				
		     
			}
			else if(rowCount==4)
			{
				//Repaint di P1, P2, P3, P4
				
			/*	BaseProgressBar1JPanel.removeAll();
				BaseProgressBar1JPanel.repaint();
				BaseProgressBar2JPanel.removeAll();
				BaseProgressBar2JPanel.repaint();
				BaseProgressBar3JPanel.removeAll();
				BaseProgressBar3JPanel.repaint();
				BaseProgressBar4JPanel.removeAll();
				BaseProgressBar4JPanel.repaint();
		
			*/
				//PROCESSO 1 !!!
						
				//Job Duration 1
				startpoint=StartEndProcessi.get(0).inizioProcesso;
				endpoint=StartEndProcessi.get(0).fineProcesso;
				System.out.println("[INIZIO P1] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration1JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar1JPanel.add(JobDuration1JPanel);
				JobDuration1JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(0).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea1JPanel1);
				CriticalArea1JPanel1.setVisible(true);
	        
				//Critical Area 2 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(0).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea2JPanel1);
				CriticalArea2JPanel1.setVisible(true);
				
				//Critical Area 3 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(0).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea3JPanel1);
				CriticalArea3JPanel1.setVisible(true);
			
		        //PROCESSO 2 !!!
				
						
				//Job Duration 2
				startpoint=StartEndProcessi.get(1).inizioProcesso;
				endpoint=StartEndProcessi.get(1).fineProcesso;
				System.out.println("[INIZIO P2] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration2JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar2JPanel.add(JobDuration2JPanel);
				JobDuration2JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(1).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea1JPanel2);
				CriticalArea1JPanel2.setVisible(true);
	        
				//Critical Area 2 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(1).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea2JPanel2);
				CriticalArea2JPanel2.setVisible(true);
				
				//Critical Area 3 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(1).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea3JPanel2);
				CriticalArea3JPanel2.setVisible(true);
				
				
				
				//PROCESSO 3 !!!
				
				//Job Duration 3
				startpoint=StartEndProcessi.get(2).inizioProcesso;
				endpoint=StartEndProcessi.get(2).fineProcesso;
				System.out.println("[INIZIO P3] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration3JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar3JPanel.add(JobDuration3JPanel);
		        JobDuration3JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(2).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration3JPanel.add(CriticalArea1JPanel3);
				CriticalArea1JPanel3.setVisible(true);
	        
				//Critical Area 2 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(2).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration3JPanel.add(CriticalArea2JPanel3);
				CriticalArea2JPanel3.setVisible(true);
				
				//Critical Area 3 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(2).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration3JPanel.add(CriticalArea3JPanel3);
				CriticalArea3JPanel3.setVisible(true);
				

				
				//PROCESSO 4 !!!
				
				//Job Duration 4
				startpoint=StartEndProcessi.get(3).inizioProcesso;
				endpoint=StartEndProcessi.get(3).fineProcesso;
				System.out.println("[INIZIO P4] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration4JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar4JPanel.add(JobDuration4JPanel);
		        JobDuration4JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(3).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration4JPanel.add(CriticalArea1JPanel4);
				CriticalArea1JPanel4.setVisible(true);
	        
				//Critical Area 2 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(3).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration4JPanel.add(CriticalArea2JPanel4);
				CriticalArea2JPanel4.setVisible(true);
				
				//Critical Area 3 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(3).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration4JPanel.add(CriticalArea3JPanel4);
				CriticalArea3JPanel4.setVisible(true);

			}
			else if(rowCount==5)
			{
				//Repaint di P1, P2, P3, P4, P5
				
			/*	BaseProgressBar1JPanel.removeAll();
				BaseProgressBar1JPanel.repaint();
				BaseProgressBar2JPanel.removeAll();
				BaseProgressBar2JPanel.repaint();
				BaseProgressBar3JPanel.removeAll();
				BaseProgressBar3JPanel.repaint();
				BaseProgressBar4JPanel.removeAll();
				BaseProgressBar4JPanel.repaint();
				BaseProgressBar5JPanel.removeAll();
				BaseProgressBar5JPanel.repaint();
			*/
				//PROCESSO 1 !!!
						
				//Job Duration 1
				startpoint=StartEndProcessi.get(0).inizioProcesso;
				endpoint=StartEndProcessi.get(0).fineProcesso;
				System.out.println("[INIZIO P1] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration1JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar1JPanel.add(JobDuration1JPanel);
				JobDuration1JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(0).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea1JPanel1);
				CriticalArea1JPanel1.setVisible(true);
	        
				//Critical Area 2 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(0).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea2JPanel1);
				CriticalArea2JPanel1.setVisible(true);
				
				//Critical Area 3 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(0).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P1] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration1JPanel.add(CriticalArea3JPanel1);
				CriticalArea3JPanel1.setVisible(true);
			
		        //PROCESSO 2 !!!
				
						
				//Job Duration 2
				startpoint=StartEndProcessi.get(1).inizioProcesso;
				endpoint=StartEndProcessi.get(1).fineProcesso;
				System.out.println("[INIZIO P2] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration2JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar2JPanel.add(JobDuration2JPanel);
				JobDuration2JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(1).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea1JPanel2);
				CriticalArea1JPanel2.setVisible(true);
	        
				//Critical Area 2 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(1).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea2JPanel2);
				CriticalArea2JPanel2.setVisible(true);
				
				//Critical Area 3 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(1).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration2JPanel.add(CriticalArea3JPanel2);
				CriticalArea3JPanel2.setVisible(true);
				
				
				
				//PROCESSO 3 !!!
				
				//Job Duration 3
				startpoint=StartEndProcessi.get(2).inizioProcesso;
				endpoint=StartEndProcessi.get(2).fineProcesso;
				System.out.println("[INIZIO P3] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration3JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar3JPanel.add(JobDuration3JPanel);
		        JobDuration3JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(2).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration3JPanel.add(CriticalArea1JPanel3);
				CriticalArea1JPanel3.setVisible(true);
	        
				//Critical Area 2 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(2).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration3JPanel.add(CriticalArea2JPanel3);
				CriticalArea2JPanel3.setVisible(true);
				
				//Critical Area 3 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(2).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration3JPanel.add(CriticalArea3JPanel3);
				CriticalArea3JPanel3.setVisible(true);
				

				
				//PROCESSO 4 !!!
				
				//Job Duration 4
				startpoint=StartEndProcessi.get(3).inizioProcesso;
				endpoint=StartEndProcessi.get(3).fineProcesso;
				System.out.println("[INIZIO P4] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration4JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar4JPanel.add(JobDuration4JPanel);
		        JobDuration4JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(3).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration4JPanel.add(CriticalArea1JPanel4);
				CriticalArea1JPanel4.setVisible(true);
	        
				//Critical Area 2 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(3).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration4JPanel.add(CriticalArea2JPanel4);
				CriticalArea2JPanel4.setVisible(true);
				
				//Critical Area 3 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(3).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration4JPanel.add(CriticalArea3JPanel4);
				CriticalArea3JPanel4.setVisible(true);
				
				
				//PROCESSO 5 !!!
				
				//Job Duration 5
				startpoint=StartEndProcessi.get(4).inizioProcesso;
				endpoint=StartEndProcessi.get(4).fineProcesso;
				System.out.println("[INIZIO P5] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration5JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar5JPanel.add(JobDuration5JPanel);
		        JobDuration5JPanel.setVisible(true);
		       
		        //Critical Area 1 JPanel 5
				startpoint=StartEndProcessi.get(4).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(4).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P5] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel5.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration5JPanel.add(CriticalArea1JPanel5);
				CriticalArea1JPanel5.setVisible(true);
	        
				//Critical Area 2 JPanel 5
				startpoint=StartEndProcessi.get(4).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(4).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P5] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel5.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration5JPanel.add(CriticalArea2JPanel5);
				CriticalArea2JPanel5.setVisible(true);
				
				//Critical Area 3 JPanel 5
				startpoint=StartEndProcessi.get(4).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(4).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P5] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel5.setBounds(startpoint, 0, endpoint-startpoint, 29);
				JobDuration5JPanel.add(CriticalArea3JPanel5);
				CriticalArea3JPanel5.setVisible(true);
	
			}

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
						BaseProgressBar1JPanel.setVisible(true);
						BaseProgressBar2JPanel.setVisible(false);
						BaseProgressBar3JPanel.setVisible(false);
						BaseProgressBar4JPanel.setVisible(false);
						BaseProgressBar5JPanel.setVisible(false);
						
						JobDuration1JPanel.setVisible(false);
						JobDuration2JPanel.setVisible(false);
						JobDuration3JPanel.setVisible(false);
						JobDuration4JPanel.setVisible(false);
						JobDuration5JPanel.setVisible(false);
						
					
					}
					else if(sceltaNumero==2)
					{
						BaseProgressBar1JPanel.setVisible(true);
						BaseProgressBar2JPanel.setVisible(true);
						BaseProgressBar3JPanel.setVisible(false);
						BaseProgressBar4JPanel.setVisible(false);
						BaseProgressBar5JPanel.setVisible(false);
						
						JobDuration1JPanel.setVisible(false);
						JobDuration2JPanel.setVisible(false);
						JobDuration3JPanel.setVisible(false);
						JobDuration4JPanel.setVisible(false);
						JobDuration5JPanel.setVisible(false);
					}
					
					else if(sceltaNumero==3)
					{
						BaseProgressBar1JPanel.setVisible(true);
						BaseProgressBar2JPanel.setVisible(true);
						BaseProgressBar3JPanel.setVisible(true);
						BaseProgressBar4JPanel.setVisible(false);
						BaseProgressBar5JPanel.setVisible(false);
						
						JobDuration1JPanel.setVisible(false);
						JobDuration2JPanel.setVisible(false);
						JobDuration3JPanel.setVisible(false);
						JobDuration4JPanel.setVisible(false);
						JobDuration5JPanel.setVisible(false);
					}
					
					else if(sceltaNumero==4)
					{
						BaseProgressBar1JPanel.setVisible(true);
						BaseProgressBar2JPanel.setVisible(true);
						BaseProgressBar3JPanel.setVisible(true);
						BaseProgressBar4JPanel.setVisible(true);
						BaseProgressBar5JPanel.setVisible(false);
						
						JobDuration1JPanel.setVisible(false);
						JobDuration2JPanel.setVisible(false);
						JobDuration3JPanel.setVisible(false);
						JobDuration4JPanel.setVisible(false);
						JobDuration5JPanel.setVisible(false);
					}
					
					else if(sceltaNumero==5)
					{
						BaseProgressBar1JPanel.setVisible(true);
						BaseProgressBar2JPanel.setVisible(true);
						BaseProgressBar3JPanel.setVisible(true);
						BaseProgressBar4JPanel.setVisible(true);
						BaseProgressBar5JPanel.setVisible(true);
						
						JobDuration1JPanel.setVisible(false);
						JobDuration2JPanel.setVisible(false);
						JobDuration3JPanel.setVisible(false);
						JobDuration4JPanel.setVisible(false);
						JobDuration5JPanel.setVisible(false);
					}
					
				}
			});
			
	       
	       
		
			NumSemaforiComboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					String numeroSemaforiString = (String) NumSemaforiComboBox.getSelectedItem();
					int numeroSemaforiInt=Integer.valueOf(numeroSemaforiString);
					if(numeroSemaforiInt==1)
					{
						//Attivo il Primo Semaforo 
						GraficaSemaforo2JLabel.setVisible(true);
						JLabelTextMutex2.setVisible(true);
						//Disattivo il secondo
						GraficaSemaforo2JLabel.setVisible(false);
						JLabelTextMutex2.setVisible(false);
					}
					else if(numeroSemaforiInt==2)
					{
						//Abilito anche il secondo semaforo 
						GraficaSemaforo2JLabel.setVisible(true);
						JLabelTextMutex2.setVisible(true);
					}
						
				}
			});
			
			
			
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
				
				
				
				StartPauseToggleButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{	
						if(StartPauseToggleButton.isSelected()&& StartEndProcessi.size()!=0) 
						{
							continuaBoolean=true;
							System.out.println("[ToggleButton]: START");
							TestIndicatore.setXInziale(StartEndProcessi.get(0).inizioProcesso);
							TestIndicatore.setXFinale(StartEndProcessi.get(0).fineProcesso);
							Thread threadmuovereIndicatore = new Thread(new Runnable() {
								
								@Override
								public void run() 
								{
									
									// TODO Auto-generated method stub
									for(int i=0; i<300; i++) 
									{										
										TestIndicatore.moveForward();
										if (continuaBoolean == false) 
										{
											
											TestIndicatore.Reset(0);	
											BaseProgressBar1JPanel.repaint();
											break;
										}
										else if (TestIndicatore.LimitReached()) 
										{
											i=0;
											TestIndicatore.Reset(StartEndProcessi.get(0).inizioProcesso);
										}
										try 
										{
											Thread.sleep(50);//Questo è accelatore Erasmo fai attenzione 
											//Meno dimuisci piu va veloce , fai attenzione va piu veloce della Nissan Micra
											BaseProgressBar1JPanel.repaint();
											Thread.sleep(10);
										} 
										catch (InterruptedException e1)
										{
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}
							});
							threadmuovereIndicatore.start();
						}
						else 
						{
							System.out.println("[ToggleButton]: PAUSE");
							continuaBoolean=false;
						}
					}
				});
				
				ResetButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						continuaBoolean=false;
					}
				});
				
	}
}