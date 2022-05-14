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
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);
		
		//modified
		JLabel labelSchemata = new JLabel(" Semafori ");
		labelSchemata.setBounds(573, 11, 320, 89);
		panelMainButton.add(labelSchemata);
		labelSchemata.setFont(new Font("Segoe UI", Font.BOLD, 48));
		
		
		//added
		JPanel panelSuperiore = new JPanel();
		panelSuperiore.setBackground(SystemColor.activeCaption);
		panelSuperiore.setBounds(0, 0, 1414, 124);
		panelMainButton.add(panelSuperiore);
		panelSuperiore.setLayout(null);
		
		
		JButton buttonIndietro = new JButton("Indietro");
		buttonIndietro.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonIndietro.setBackground(SystemColor.inactiveCaption);
		buttonIndietro.setOpaque(true);
		buttonIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				framechiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonIndietro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonIndietro.setBounds(10, 135, 128, 46);
		panelMainButton.add(buttonIndietro);
		
		
		
	
		
		
		
		JButton SlideArgomentoJButton = new JButton("Slide Argomento");
		SlideArgomentoJButton.addMouseListener(new MouseAdapter() {
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
		});
		
		SlideArgomentoJButton.setBackground(SystemColor.inactiveCaption);
		SlideArgomentoJButton.setOpaque(true);
		SlideArgomentoJButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		SlideArgomentoJButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		SlideArgomentoJButton.setBounds(331,135,143,46);
		panelMainButton.add(SlideArgomentoJButton);
		
		JButton VideoLezioneJButton = new JButton("VideoLezione");
		VideoLezioneJButton.addMouseListener(new MouseAdapter() {
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
		});
		
		VideoLezioneJButton.setBackground(SystemColor.inactiveCaption);
		VideoLezioneJButton.setOpaque(true);
		VideoLezioneJButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		VideoLezioneJButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		VideoLezioneJButton.setBounds(509,135,143,46);
		panelMainButton.add(VideoLezioneJButton);
		
		
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Pannello di controllo");
		lblNewLabel.setBounds(1168, 168, 137, 27);
		panelMainButton.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		desktopPane.setBackground(SystemColor.inactiveCaption);
		desktopPane.setBounds(1051, 200, 353, 156);
		panelMainButton.add(desktopPane);
		
		JTextField TextFieldNumProcessi = new JTextField();
		TextFieldNumProcessi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		TextFieldNumProcessi.setBounds(10, 32, 126, 21);
		desktopPane.add(TextFieldNumProcessi);
		TextFieldNumProcessi.setText("Numero Processi:");
		TextFieldNumProcessi.setColumns(10);
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.setBackground(new Color(255, 255, 255));
		ResetButton.setBounds(219, 96, 121, 23);
		desktopPane.add(ResetButton);
		
		JToggleButton StartPauseToggleButton = new JToggleButton("Start/Pause");
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
		JLabelTextMutex1.setBounds(239, 625, 79, 14);
		panelMainButton.add(JLabelTextMutex1);
		
		JLabel JLabelTextMutex2 = new JLabel("Mutex=1");
		JLabelTextMutex2.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		JLabelTextMutex2.setBounds(573, 625, 79, 14);
		panelMainButton.add(JLabelTextMutex2);
		JLabelTextMutex2.setVisible(false);
		
		//creating a default semaphore graphic
		JPanel PannelloGraficaSemaforo1 = new Semaforo();
		PannelloGraficaSemaforo1.setBounds(65, 527, 164, 213);
		panelMainButton.add(PannelloGraficaSemaforo1);
		
		
		//second semaphore graphic
		JPanel PannelloGraficaSemaforo2 = new Semaforo();
		PannelloGraficaSemaforo2.setBounds(395,527,164,213);
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
		scrollTabella.setBounds(81, 403, 1032, 103);
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
				
				
				
			}
		});
		
		
		
		
		JButton GeneraEsercizioJButton = new JButton("Genera Esercizio");
		GeneraEsercizioJButton.setBackground(SystemColor.inactiveCaption);
		GeneraEsercizioJButton.setOpaque(true);
		GeneraEsercizioJButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		GeneraEsercizioJButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GeneraEsercizioJButton.setBounds(155, 135, 143, 46);
		panelMainButton.add(GeneraEsercizioJButton);
		
		GeneraEsercizioJButton.addMouseListener(new MouseAdapter() {
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
		});
		
		
		
		
	}
}