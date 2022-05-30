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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractWriter;
import javax.swing.text.AttributeSet.FontAttribute;

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
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTextArea;

public class Semafori extends JFrame {
	
	private JPanel contentPane;
	private JFrame frame;
	public 	boolean timeToContinue;
	public boolean timeToReset;
	public boolean timeToResetFromPause;
	public boolean timeToPause;
	public boolean timeToRestartFromPause;
	public int temporaryValue1;
	public int temporaryValue2;
	public int temporaryValue3;
	public int temporaryValue4;
	public int temporaryValue5;
	
	public boolean startforfirst;
	public boolean pauseforfirst;
	public boolean pauseforsecond;
	public boolean startforsecond;
	
	public boolean startforthird;
	public boolean pauseforthird;
	public boolean pauseforfourth;
	public boolean startforfourth;
	public boolean startforfifth;
	public boolean pauseforfifth;
	
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
		setTitle("Balzano Question Problem : Semafori");
		setBounds(100, 100, 1440, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		startforsecond=false;
		startforfirst=false;
		pauseforfirst=false;
		pauseforsecond=false;
		timeToResetFromPause=false;
		timeToReset=false;
		timeToPause=false;
		timeToContinue=true;
		timeToRestartFromPause=false;
		int [] ripartenza = new int[5];
		Arrays.fill(ripartenza, 0);
		JPanel panelMainButton = new JPanel();
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);

		JPanel CorniceTitoloJPanel = new JPanel();
		CorniceTitoloJPanel.setBorder(new LineBorder(Color.ORANGE, 7, true));
		CorniceTitoloJPanel.setBounds(0, 0, 1416, 75);
		panelMainButton.add(CorniceTitoloJPanel);
		CorniceTitoloJPanel.setLayout(null);
		
		
		JPanel panelControllo = new JPanel();
		panelControllo.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		panelControllo.setBounds(1139, 85, 277, 658);
		panelMainButton.add(panelControllo);
		panelControllo.setLayout(null);
		
		
		JLabel TitoloSemaforiJLabel = new JLabel("SEMAFORI");
		TitoloSemaforiJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitoloSemaforiJLabel.setBackground(new Color(211, 211, 211));
		TitoloSemaforiJLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
		TitoloSemaforiJLabel.setBounds(6, 5, 1181, 60);
		CorniceTitoloJPanel.add(TitoloSemaforiJLabel);
		
		JLabel labelFedericoII = new JLabel("");
		labelFedericoII.setIcon(new ImageIcon(Semafori.class.getResource("/img/logoUninaIcon2.png")));
		labelFedericoII.setBounds(1209, 11, 199, 41);
		CorniceTitoloJPanel.add(labelFedericoII);
		
		JLabel labelScrittaSlide = new JLabel("Slide");
		labelScrittaSlide.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaSlide.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelScrittaSlide.setBounds(146,122,61,15);
		panelMainButton.add(labelScrittaSlide);

		JLabel labelIndietroIcon = new JLabel("");
		labelIndietroIcon.setHorizontalAlignment(SwingConstants.CENTER);
	    labelIndietroIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/back-button.png")));
	    labelIndietroIcon.setBounds(10, 80, 53, 46);
	    panelMainButton.add(labelIndietroIcon);
	     
	    JLabel labelSlideIcon = new JLabel("");
	    labelSlideIcon.setHorizontalAlignment(SwingConstants.CENTER);
	    labelSlideIcon.setIcon(new ImageIcon(Filosofi.class.getResource("/img/pdfIcon1.png")));
	    labelSlideIcon.setBounds(150, 80, 53, 46);
	    panelMainButton.add(labelSlideIcon);
		
		JLabel labelYoutubeIcon = new JLabel("");
		labelYoutubeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		labelYoutubeIcon.setIcon(new ImageIcon(Semafori.class.getResource("/img/youtubeIcon2.png")));
		labelYoutubeIcon.setBounds(80, 80, 47, 46);
		panelMainButton.add(labelYoutubeIcon);
		
		JLabel labelScrittaYoutube = new JLabel("Lezione");
		labelScrittaYoutube.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaYoutube.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelScrittaYoutube.setBounds(78,122,50,12);
		panelMainButton.add(labelScrittaYoutube);
		
		
		//SCRITTA MUTEX DEL SEMAFORO 1 CON VALORE 1
		JLabel JLabelTextMutex1_1 = new JLabel("Mutex=1");
		JLabelTextMutex1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		JLabelTextMutex1_1.setBounds(155, 607, 79, 14);
		panelMainButton.add(JLabelTextMutex1_1);
		JLabelTextMutex1_1.setVisible(true);
		
		//SCRITTA MUTEX DEL SEMAFORO 2 CON VALORE 1
		JLabel JLabelTextMutex2_1 = new JLabel("Mutex=1");
		JLabelTextMutex2_1.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		JLabelTextMutex2_1.setBounds(391, 607, 79, 14);
		panelMainButton.add(JLabelTextMutex2_1);
		JLabelTextMutex2_1.setVisible(false);
		
		//SCRITTA MUTEX DEL SEMAFORO 1 CON VALORE 0
		JLabel JLabelTextMutex1_0 = new JLabel("Mutex=0");
		JLabelTextMutex1_0.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		JLabelTextMutex1_0.setBounds(155, 607, 79, 14);
		panelMainButton.add(JLabelTextMutex1_0);
		JLabelTextMutex1_0.setVisible(false);
		
		//SCRITTA MUTEX DEL SEMAFORO 2 CON VALORE 0
		JLabel JLabelTextMutex2_0 = new JLabel("Mutex=0");
		JLabelTextMutex2_0.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		JLabelTextMutex2_0.setBounds(391, 607, 79, 14);
		panelMainButton.add(JLabelTextMutex2_0);
		JLabelTextMutex2_0.setVisible(false);
		
		//PRIMA GRAFICA SEMAFORO VERDE
		JLabel GraficaSemaforo1VerdeJLabel = new JLabel("");
		JLabelTextMutex1_1.setLabelFor(GraficaSemaforo1VerdeJLabel);
		GraficaSemaforo1VerdeJLabel.setIcon(new ImageIcon(Semafori.class.getResource("/img/semaforoVerdeIcon1.png")));
		GraficaSemaforo1VerdeJLabel.setBackground(new Color(255,255,255));
		GraficaSemaforo1VerdeJLabel.setBounds(27, 502, 118, 205);
		panelMainButton.add(GraficaSemaforo1VerdeJLabel);
		GraficaSemaforo1VerdeJLabel.setLayout(null);
		GraficaSemaforo1VerdeJLabel.setVisible(true);
		
		//PRIMA GRAFICA SEMAFORO ROSSO
		JLabel GraficaSemaforo1RossoJLabel = new JLabel("");
		JLabelTextMutex1_0.setLabelFor(GraficaSemaforo1RossoJLabel);
		GraficaSemaforo1RossoJLabel.setIcon(new ImageIcon(Semafori.class.getResource("/img/semaforoRossoIcon1.png")));
		GraficaSemaforo1RossoJLabel.setBackground(new Color(255,255,255));
		GraficaSemaforo1RossoJLabel.setBounds(27, 502, 118, 205);
		panelMainButton.add(GraficaSemaforo1RossoJLabel);
		GraficaSemaforo1RossoJLabel.setLayout(null);
		GraficaSemaforo1RossoJLabel.setVisible(false);
		
		
		//SECONDA GRAFICA SEMAFORO ROSSO
		JLabel GraficaSemaforo2RossoJLabel = new JLabel("");
		JLabelTextMutex2_0.setLabelFor(GraficaSemaforo2RossoJLabel);
		GraficaSemaforo2RossoJLabel.setIcon(new ImageIcon(Semafori.class.getResource("/img/semaforoRossoIcon1.png")));
		GraficaSemaforo2RossoJLabel.setBackground(new Color(255,255,255));
		GraficaSemaforo2RossoJLabel.setBounds(27, 502, 118, 205);
		panelMainButton.add(GraficaSemaforo2RossoJLabel);
		GraficaSemaforo2RossoJLabel.setLayout(null);
		GraficaSemaforo2RossoJLabel.setVisible(false);
		
		
		//SECONDA GRAFICA SEMAFORO VERDE
		JLabel GraficaSemaforo2VerdeJLabel = new JLabel("");
		JLabelTextMutex2_1.setLabelFor(GraficaSemaforo2VerdeJLabel);
		GraficaSemaforo2VerdeJLabel.setIcon(new ImageIcon(Semafori.class.getResource("/img/semaforoVerdeIcon1.png")));
		GraficaSemaforo2VerdeJLabel.setBackground(new Color(255,255,255));
		GraficaSemaforo2VerdeJLabel.setBounds(263,502, 118, 205);
		panelMainButton.add(GraficaSemaforo2VerdeJLabel);
		GraficaSemaforo2VerdeJLabel.setLayout(null);
		GraficaSemaforo2VerdeJLabel.setVisible(false);

		
		JScrollPane scrollTabella= new JScrollPane();
		scrollTabella.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollTabella.setBounds(10, 152, 1108, 196);
		panelMainButton.add(scrollTabella);
		
		JTable tabella = new JTable();
		tabella.setOpaque(true);
		tabella.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		tabella.setGridColor(Color.WHITE);
		tabella.setEnabled(false);
		tabella.setColumnSelectionAllowed(true);
		DefaultTableModel model1 = new DefaultTableModel()
		{
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0:
					return String.class;
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
		
		JLabel label = (JLabel) tabella.getDefaultRenderer(String.class);
		label.setHorizontalAlignment (SwingConstants.CENTER);

		JLabel label2 = (JLabel) tabella.getDefaultRenderer(String.class);
		label2.setHorizontalAlignment (SwingConstants.CENTER);
		label2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label2.setBackground(Color.orange);
		
		JLabel label3 = (JLabel) tabella.getDefaultRenderer(Integer.class);
		label3.setHorizontalAlignment (SwingConstants.CENTER);
		label3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label3.setBackground(Color.LIGHT_GRAY);
		
		
		
		JPanel panelControlloProcessi = new JPanel();
		panelControlloProcessi.setBackground(new Color(220,220,220));
		panelControlloProcessi.setBounds(17, 240, 245, 154);
		panelControlloProcessi.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		panelControllo.add(panelControlloProcessi);
		panelControlloProcessi.setLayout(null);
		
		
		JButton GeneraEsercizioJButton = new JButton();
		GeneraEsercizioJButton.setBackground(Color.WHITE);
		GeneraEsercizioJButton.setBorder(new LineBorder(Color.orange, 2));
		GeneraEsercizioJButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GeneraEsercizioJButton.setText("Genera Esercizio");
		GeneraEsercizioJButton.setSize(141, 27);
		GeneraEsercizioJButton.setLocation(57, 110);
		GeneraEsercizioJButton.setVisible(true);
		panelControlloProcessi.add(GeneraEsercizioJButton);
	        
		JLabel StartTimeIndexJLabel = new JLabel("Tempo 0");
		StartTimeIndexJLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		StartTimeIndexJLabel.setBounds(548, 502, 53, 14);
		panelMainButton.add(StartTimeIndexJLabel);
	        
		JLabel EndTimeIndexJLabel = new JLabel("Tempo 300");
		EndTimeIndexJLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		EndTimeIndexJLabel.setBounds(790, 502, 64, 14);
		panelMainButton.add(EndTimeIndexJLabel);
		
		
		JPanel BaseProgressBar1JPanel = new JPanel();
		BaseProgressBar1JPanel.setBackground(new Color(211,211,211));
		BaseProgressBar1JPanel.setBounds(548, 527, 300, 29);
		panelMainButton.add(BaseProgressBar1JPanel);
		BaseProgressBar1JPanel.setLayout(null);
		BaseProgressBar1JPanel.setOpaque(true);


		JPanel BaseProgressBar2JPanel = new JPanel();
		BaseProgressBar2JPanel.setVisible(false);
		BaseProgressBar2JPanel.setLayout(null);
		BaseProgressBar2JPanel.setBackground(new Color(211,211,211));
		BaseProgressBar2JPanel.setBounds(548, 567, 300, 29);
		panelMainButton.add(BaseProgressBar2JPanel);
		BaseProgressBar2JPanel.setOpaque(true);
	        
		JPanel BaseProgressBar3JPanel = new JPanel();
		BaseProgressBar3JPanel.setVisible(false);
		BaseProgressBar3JPanel.setLayout(null);
		BaseProgressBar3JPanel.setBackground(new Color(211,211,211));
		BaseProgressBar3JPanel.setBounds(548, 607, 300, 29);
		panelMainButton.add(BaseProgressBar3JPanel);
		BaseProgressBar3JPanel.setOpaque(true);
	        
        JPanel BaseProgressBar4JPanel = new JPanel();
        BaseProgressBar4JPanel.setVisible(false);
        BaseProgressBar4JPanel.setLayout(null);
        BaseProgressBar4JPanel.setBackground(new Color(211,211,211));
        BaseProgressBar4JPanel.setBounds(548, 645, 300, 29);
        panelMainButton.add(BaseProgressBar4JPanel);
        BaseProgressBar4JPanel.setOpaque(true);
	        
	        
        JPanel BaseProgressBar5JPanel = new JPanel();
        BaseProgressBar5JPanel.setVisible(false);
        BaseProgressBar5JPanel.setLayout(null);
        BaseProgressBar5JPanel.setBackground(new Color(211,211,211));
        BaseProgressBar5JPanel.setBounds(548, 685, 300, 29);
        panelMainButton.add(BaseProgressBar5JPanel);
        BaseProgressBar5JPanel.setOpaque(true);

		
		GraficaIndicatoreSemafori Indicator1JPanel = new GraficaIndicatoreSemafori(0, 0, 4, 29);
		Indicator1JPanel.setSize(4, 29);
		BaseProgressBar1JPanel.add(Indicator1JPanel);
		Indicator1JPanel.setLayout(null);
		Indicator1JPanel.setVisible(true);
		
		GraficaIndicatoreSemafori Indicator2JPanel = new GraficaIndicatoreSemafori(0, 0, 4, 29);
		BaseProgressBar2JPanel.add(Indicator2JPanel);
		Indicator2JPanel.setLayout(null);
		Indicator2JPanel.setVisible(true);
		
		
		GraficaIndicatoreSemafori Indicator3JPanel = new GraficaIndicatoreSemafori(0, 0, 4, 29);
		BaseProgressBar3JPanel.add(Indicator3JPanel);
		Indicator3JPanel.setLayout(null);
		Indicator3JPanel.setVisible(true);
        
		
		GraficaIndicatoreSemafori Indicator4JPanel = new GraficaIndicatoreSemafori(0, 0, 4, 29);
		BaseProgressBar4JPanel.add(Indicator4JPanel);
		Indicator4JPanel.setLayout(null);
		Indicator4JPanel.setVisible(true);
		
		
		GraficaIndicatoreSemafori Indicator5JPanel = new GraficaIndicatoreSemafori(0, 0, 4, 29);
		BaseProgressBar5JPanel.add(Indicator5JPanel);
		Indicator5JPanel.setLayout(null);
		Indicator5JPanel.setVisible(true);
		
		
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
        				
        JLabel labelPnlCtrl = new JLabel("Pannello di controllo");
        labelPnlCtrl.setBounds(17, 11, 245, 54);
        panelControllo.add(labelPnlCtrl);
        labelPnlCtrl.setHorizontalAlignment(SwingConstants.CENTER);
        labelPnlCtrl.setFont(new Font("Arial", Font.BOLD, 22));
        labelPnlCtrl.setBorder(new LineBorder(Color.ORANGE, 2));
        
        
        
        
        
        
        
        
        
        
        				
        JLabel SceltaOpzioniJLabel = new JLabel("Scelta  Opzioni:");
        SceltaOpzioniJLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        SceltaOpzioniJLabel.setForeground(Color.RED);
        SceltaOpzioniJLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        SceltaOpzioniJLabel.setBounds(59, 85, 151, 26);
        panelControllo.add(SceltaOpzioniJLabel);
        				
        JPanel panelSceltaProcessi = new JPanel();
        panelSceltaProcessi.setBackground(new Color(220,220,220));
        panelSceltaProcessi.setBounds(17, 115, 245, 93);
        panelSceltaProcessi.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        panelControllo.add(panelSceltaProcessi);
        panelSceltaProcessi.setLayout(null);
        				
        JLabel labelNumeroSemafori = new JLabel("Numero Semafori : ");
        labelNumeroSemafori.setBounds(10, 45, 139, 22);
        panelSceltaProcessi.add(labelNumeroSemafori);
        labelNumeroSemafori.setForeground(Color.BLACK);
        labelNumeroSemafori.setFont(new Font("Segoe UI", Font.BOLD, 14));
        				
        				
        				JComboBox NumSemaforiComboBox = new JComboBox();
        				NumSemaforiComboBox.setBounds(180, 45, 58, 22);
        				panelSceltaProcessi.add(NumSemaforiComboBox);
        				NumSemaforiComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
        				NumSemaforiComboBox.setMaximumRowCount(2);
        				
        				
        				
        				
        				//Eventi And Co
        				
        						JComboBox NumProcessiComboBox = new JComboBox();
        						NumProcessiComboBox.setBounds(180, 13, 58, 22);
        						panelSceltaProcessi.add(NumProcessiComboBox);
        						NumProcessiComboBox.setModel(new DefaultComboBoxModel(new String[]{"1","2","3","4","5"}));
        						
        						JLabel labelNumProcessi = new JLabel("Numero Processi : ");
        						labelNumProcessi.setBounds(10, 11, 139, 22);
        						panelSceltaProcessi.add(labelNumProcessi);
        						labelNumProcessi.setForeground(Color.BLACK);
        						labelNumProcessi.setFont(new Font("Segoe UI", Font.BOLD, 14));
        						

        						
        						JButton buttonReset = new JButton("Back");
        						buttonReset.setBounds(118, 65, 121, 23);
        						panelControlloProcessi.add(buttonReset);
        						
        						buttonReset.setFont(new Font("Times New Roman", Font.BOLD, 12));
        						buttonReset.setBackground(new Color(255, 255, 255));
        						
        						JToggleButton toggleButtonStartPause = new JToggleButton("Start/Pause");
        						toggleButtonStartPause.setBounds(118, 15, 121, 23);
        						panelControlloProcessi.add(toggleButtonStartPause);
        						toggleButtonStartPause.setFont(new Font("Times New Roman", Font.BOLD, 12));
        						toggleButtonStartPause.setBackground(new Color(255, 255, 255));
        						
        						JLabel labelAvvia = new JLabel("Movimento :");
        						labelAvvia.setForeground(Color.BLACK);
        						labelAvvia.setFont(new Font("Segoe UI", Font.BOLD, 14));
        						labelAvvia.setBounds(10, 15, 105, 22);
        						panelControlloProcessi.add(labelAvvia);
        						
        						JLabel labelReset = new JLabel("Ripristino :");
        						labelReset.setForeground(Color.BLACK);
        						labelReset.setFont(new Font("Segoe UI", Font.BOLD, 14));
        						labelReset.setBounds(10, 65, 105, 22);
        						panelControlloProcessi.add(labelReset);
        						
        						JLabel ControlloIndicatoreJLabel = new JLabel("Controllo  Indicatore :");
        						ControlloIndicatoreJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        						ControlloIndicatoreJLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        						ControlloIndicatoreJLabel.setForeground(Color.RED);
        						ControlloIndicatoreJLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        						ControlloIndicatoreJLabel.setBounds(10, 210, 245, 26);
        						panelControllo.add(ControlloIndicatoreJLabel);
        						
        						JPanel pannelloHelp = new JPanel();
        						pannelloHelp.setBounds(17, 427, 245, 221);
        						panelControllo.add(pannelloHelp);
        						pannelloHelp.setLayout(null);
        						
        						JScrollPane scrollPaneHelp = new JScrollPane();
        						scrollPaneHelp.setBounds(0, 0, 245, 255);
        						pannelloHelp.add(scrollPaneHelp);
        						
        						JTextArea txtrHelpArea = new JTextArea();
        						scrollPaneHelp.setViewportView(txtrHelpArea);
        						txtrHelpArea.setWrapStyleWord(true);
        						txtrHelpArea.setLineWrap(true);
        						txtrHelpArea.setText("I semafori sono utilizzabili per risolvere il problema della sezione critica con n processi. Gli n processi condividono un semaforo comune, mutex, inizializzato a 1. I semafori sono utilizzabili anche per risolvere diversi problemi di sincronizzazione. Si considerino, per esempio, due processi in esecuzione concorrente: P1 con un'istruzione S1 e P2 con un'istruzione S2. Questo schema si pu\u00F2 prontamente realizzare facendo condividere a P1 e P2 un semaforo comune, sincronizzazione, inizializzato a 0.\r\nL'operazione di bloccaggio pone il processo in una coda d'attesa associata al semaforo e cambia lo stato del processo nello stato d'attesa. Quindi si trasferisce il controllo allo scheduler della CPU che sceglie un altro processo pronto per l'esecuzione. Un processo bloccato, che attende a un semaforo S, sar\u00E0 riavviato in seguito al termine della zona critica di un altro processo. Per aggiungere e togliere processi dalla lista assicurando un'attesa limitata si pu\u00F2 usare una coda FIFO, della quale il semaforo contiene i puntatori al primo e all'ultimo elemento (in generale si pu\u00F2 usare qualsiasi criterio d'accodamento poich\u00E9 il corretto uso dei semafori non dipende dal particolare criterio adottato). La realizzazione di un semaforo con coda d'attesa pu\u00F2 condurre a situazioni in cui ciascun processo di un insieme di processi attende indefinitamente un evento che pu\u00F2 essere causato solo da uno dei processi dello stesso insieme. Quando si verifica una situazione del genere si dice che i processi sono in deadlock.");
        						txtrHelpArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        						txtrHelpArea.setCaretPosition(0);
        						txtrHelpArea.setEditable(false);
        						
        						JLabel labelHelp = new JLabel("  Spiegazione Argomento : ");
        						labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
        						labelHelp.setForeground(Color.RED);
        						labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
        						labelHelp.setBounds(17, 400, 245, 25);
        						panelControllo.add(labelHelp);
        						
        						
        						
        						toggleButtonStartPause.addMouseListener(new MouseAdapter() {
        							@Override
        							public void mouseClicked(MouseEvent e) 
        							{
        								int NumProcessi=StartEndProcessi.size();
        								final int iniziocritica1_1;
        								int finecritica1_1;
        								int iniziocritica2_1;
        								int finecritica2_1;
        								int iniziocritica3_1;
        								int finecritica3_1;
        								
          								int iniziocritica1_2;
        								int finecritica1_2;
        								int iniziocritica2_2;
        								int finecritica2_2;
        								int iniziocritica3_2;
        								int finecritica3_2;
        								
          								int iniziocritica1_3;
        								int finecritica1_3;
        								int iniziocritica2_3;
        								int finecritica2_3;
        								int iniziocritica3_3;
        								int finecritica3_3;
        								
          								int iniziocritica1_4;
        								int finecritica1_4;
        								int iniziocritica2_4;
        								int finecritica2_4;
        								int iniziocritica3_4;
        								int finecritica3_4;
        								
          								int iniziocritica1_5;
        								int finecritica1_5;
        								int iniziocritica2_5;
        								int finecritica2_5;
        								int iniziocritica3_5;
        								int finecritica3_5;
        								
        								

        								//Al momento dello start non possono piu' essere cambiati i valori di
        								//processi e semafori
        								if(toggleButtonStartPause.isSelected() && NumProcessi>0) 
        								{
        									NumProcessiComboBox.setEnabled(false);
        									NumSemaforiComboBox.setEnabled(false);
        								}
        								else
        								{
        									NumProcessiComboBox.setEnabled(true);
        									NumSemaforiComboBox.setEnabled(true);
        								}
	
        								//1 Processo
        								if(toggleButtonStartPause.isSelected() && NumProcessi==1) 
        								{
        									iniziocritica1_1=StartEndProcessi.get(0).inizioZonaCritica1;
        									finecritica1_1=StartEndProcessi.get(0).fineZonaCritica1;
        									iniziocritica2_1=StartEndProcessi.get(0).inizioZonaCritica2;
        									finecritica2_1=StartEndProcessi.get(0).fineZonaCritica2;
        									iniziocritica3_1=StartEndProcessi.get(0).inizioZonaCritica3;
        									finecritica3_1=StartEndProcessi.get(0).fineZonaCritica3;
        									
        									timeToContinue=true;
        									timeToPause=false;

        									
        									Indicator1JPanel.setXInziale(StartEndProcessi.get(0).inizioProcesso);	
        									Indicator1JPanel.setXFinale(StartEndProcessi.get(0).fineProcesso);
        									
        									Thread threadmuovereIndicatore1 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											// TODO Auto-generated method stub
        											for(int i=0; i<300; i++) 
        											{	
						
        												//gestione Cambiamento Semaforo INIZIO-FINE PER LE 3 ZONE CRITICHE
        												if(iniziocritica1_1==Indicator1JPanel.getX() || iniziocritica2_1==Indicator1JPanel.getX() 
        														|| iniziocritica3_1==Indicator1JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												if(finecritica1_1==Indicator1JPanel.getX() || finecritica2_1==Indicator1JPanel.getX() 
        														|| finecritica3_1==Indicator1JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
       
        												
        												//Si Stoppa
        												if(timeToPause==true && timeToContinue==false)
        												{
        													
        													temporaryValue1=Indicator1JPanel.getX();
        													Indicator1JPanel.Reset(temporaryValue1);
        													BaseProgressBar1JPanel.repaint();
        													break;
        												}	
        												//Torna a Capo
        												else if (Indicator1JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator1JPanel.Reset(StartEndProcessi.get(0).inizioProcesso);
        													
        													if(iniziocritica1_1!=Indicator1JPanel.getX()) {
        														GraficaSemaforo1RossoJLabel.setVisible(false);
        														GraficaSemaforo1VerdeJLabel.setVisible(true);
        														JLabelTextMutex1_0.setVisible(false);
        														JLabelTextMutex1_1.setVisible(true);
        													}
        												}
        												//Riparte da quel punto
        												else if(ripartenza[0]==1) 
        												{
        													Indicator1JPanel.setXInziale(temporaryValue1);
        													i=temporaryValue1;
        													ripartenza[0]=0;
        												}

        												Indicator1JPanel.moveForward();
        												
        												try 
        												{
        													Thread.sleep(20);
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
        									threadmuovereIndicatore1.start();
        									
      
        								}
        								//2 Processi
        								else if(toggleButtonStartPause.isSelected() && NumProcessi==2)
        								{
        									timeToContinue=true;
        									timeToPause=false;


        									iniziocritica1_1=StartEndProcessi.get(0).inizioZonaCritica1;
        									finecritica1_1=StartEndProcessi.get(0).fineZonaCritica1;
        									iniziocritica2_1=StartEndProcessi.get(0).inizioZonaCritica2;
        									finecritica2_1=StartEndProcessi.get(0).fineZonaCritica2;
        									iniziocritica3_1=StartEndProcessi.get(0).inizioZonaCritica3;
        									finecritica3_1=StartEndProcessi.get(0).fineZonaCritica3;
        									
        									iniziocritica1_2=StartEndProcessi.get(1).inizioZonaCritica1;
        									finecritica1_2=StartEndProcessi.get(1).fineZonaCritica1;
        									iniziocritica2_2=StartEndProcessi.get(1).inizioZonaCritica2;
        									finecritica2_2=StartEndProcessi.get(1).fineZonaCritica2;
        									iniziocritica3_2=StartEndProcessi.get(1).inizioZonaCritica3;
        									finecritica3_2=StartEndProcessi.get(1).fineZonaCritica3;
											
        									Indicator1JPanel.setXInziale(StartEndProcessi.get(0).inizioProcesso);
        									Indicator1JPanel.setXFinale(StartEndProcessi.get(0).fineProcesso);
        									Indicator2JPanel.setXInziale(StartEndProcessi.get(1).inizioProcesso);
        									Indicator2JPanel.setXFinale(StartEndProcessi.get(1).fineProcesso);
        									
        									
        									Thread threadmuovereIndicatore1 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											
        											for(int i=0; i<300; i++) 
        											{	
        												if(i==299)
        													i=0;
        												
        												//GESTIONE PAUSA PER INDICATORE 1 QUANDO INDICATORE 2 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE DUE SI TROVA IN UNA DELLE ZONE CRITICHE
        												if((Indicator2JPanel.getX()>=iniziocritica1_2 && Indicator2JPanel.getX()<=finecritica1_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica2_2 && Indicator2JPanel.getX()<=finecritica2_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica3_2 && Indicator2JPanel.getX()<=finecritica3_2))
        												{
        													
        													//SE L'INDICATORE 1 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator1JPanel.getX()==iniziocritica1_1-1 || Indicator1JPanel.getX()==iniziocritica2_1-1 || 
        															Indicator1JPanel.getX()==iniziocritica3_1-1	) 
        													{
        														
        														pauseforfirst=true;
        														startforfirst=false;
            													
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforfirst=false;
            													startforfirst=true;
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfirst=false;
        														startforfirst=false;
        													}
        														
        												}
        												// ALTRIMENTI L'INDICATORE 1 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforfirst=false;
        													startforfirst=false;
        												}
        													
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL PRIMO INDICATORE
        												if(iniziocritica1_1==Indicator1JPanel.getX() || iniziocritica2_1==Indicator1JPanel.getX() 
        														|| iniziocritica3_1==Indicator1JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL PRIMO INDICATORE
        												if(finecritica1_1==Indicator1JPanel.getX() || finecritica2_1==Indicator1JPanel.getX() 
        														|| finecritica3_1==Indicator1JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												//E' IL MOMENTO DI FERMARE IL PRIMO INDICATORE PERCHE' IL SECONDO E' IN ZONA CRITICA
        												if(pauseforfirst==true && startforfirst==false) {
        													temporaryValue1=Indicator1JPanel.getX();
        													Indicator1JPanel.Reset(temporaryValue1);
        													BaseProgressBar1JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue1=Indicator1JPanel.getX();
        													Indicator1JPanel.Reset(temporaryValue1);
        													BaseProgressBar1JPanel.repaint();
        													break;
        												}

        												//IL PRIMO INDICATORE HA RAGGIUNTO IL LIMITE X DEI 300
        												else if (Indicator1JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator1JPanel.Reset(StartEndProcessi.get(0).inizioProcesso);
        												}
        												
        												//L'INDICE DEL PRIMO INDICATORE E' ARRIVATO A 300 MA IL PRIMO INDICATORE
        												//SI TROVA IN PAUSA PER ZONA CRITICA DEL SECONDO
        												else if (i==299 && pauseforfirst==true) 
        												{
        													i=0;
        													Indicator1JPanel.Reset(temporaryValue1);
        												}
        											
        												
        												//IL PRIMO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[0]==1) 
        												{
        													Indicator1JPanel.setXInziale(temporaryValue1);
        													i=temporaryValue1;
        													ripartenza[0]=0;
        												}

        												//L'INDICATORE SI MUOVE SE E SOLO SE: PAUSEFORFIRST E STARTFORFIRST SONO FALSE
        												// O SE PAUSEFORFIRST=FALSE E STARTFORFIRST=TRUE
        												 if((pauseforfirst==false && startforfirst ==false) || (pauseforfirst==false && startforfirst==true)) 
        												 {
        													Indicator1JPanel.moveForward();
        													
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar1JPanel.repaint();
        													Thread.sleep(10);
        												} 
        												catch (InterruptedException e1)
        												{
        													
        													e1.printStackTrace();
        												}
        											}
        										
        										}
        									});
        									
        									Thread threadmuovereIndicatore2 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											

        											// TODO Auto-generated method stub
        											for(int i=0; i<300; i++) 
        											{	
        												
        												if(i==299)
        													i=0;
        												
        												//GESTIONE PAUSA PER INDICATORE 2 QUANDO INDICATORE 1 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE UNO SI TROVA IN UNA DELLE ZONE CRITICHE
        												if((Indicator1JPanel.getX()>=iniziocritica1_1 && Indicator1JPanel.getX()<=finecritica1_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica2_1 && Indicator1JPanel.getX()<=finecritica2_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica3_1 && Indicator1JPanel.getX()<=finecritica3_1))
        												{
        													
        													//SE L'INDICATORE 2 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator2JPanel.getX()==iniziocritica1_2-1 || Indicator2JPanel.getX()==iniziocritica2_2-1 || 
        															Indicator2JPanel.getX()==iniziocritica3_2-1	) 
        													{
        														
        														pauseforsecond=true;
        														startforsecond=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforsecond==true)
        													{
            													pauseforsecond=false;
            													startforsecond=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforsecond=false;
        														startforsecond=false;
        													}
        														
        												}
        												// ALTRIMENTI L'INDICATORE 2 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforsecond=false;
        													startforsecond=false;
        												}
            											
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL SECONDO INDICATORE
        												if(iniziocritica1_2==Indicator2JPanel.getX() || iniziocritica2_2==Indicator2JPanel.getX() 
        														|| iniziocritica3_2==Indicator2JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL SECONDO INDICATORE
        												if(finecritica1_2==Indicator2JPanel.getX() || finecritica2_2==Indicator2JPanel.getX() 
        														|| finecritica3_2==Indicator2JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												
        										

        												//E' IL MOMENTO DI FERMARE IL SECONDO INDICATORE PERCHE' IL PRIMO E' IN ZONA CRITICA
        												if(pauseforsecond==true && startforsecond==false) {
        													temporaryValue2=Indicator2JPanel.getX();
        													Indicator2JPanel.Reset(temporaryValue2);
        													BaseProgressBar2JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue2=Indicator2JPanel.getX();
        													Indicator2JPanel.Reset(temporaryValue2);
        													BaseProgressBar2JPanel.repaint();
        													break;
        												}
        												
        												//LA X DELL'INDICATORE 2 HA RAGGIUNTO IL LIMITE DEI 300
        												else if (Indicator2JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator2JPanel.Reset(StartEndProcessi.get(1).inizioProcesso);
        												}
        												
        												//L'INDICE i HA RAGGIUNTO I 300 MA L'INDICATORE DUE SI TROVA IN PAUSA PER
        												//ZONA CRITICA DEL PRIMO INDICATORE
        												else if (i==299 && pauseforsecond==true) 
        												{
        													i=0;
        													Indicator2JPanel.Reset(Indicator2JPanel.getX());
        												}
        											
        												//IL SECONDO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[1]==1) 
        												{
        													Indicator2JPanel.setXInziale(temporaryValue2);
        													i=temporaryValue2;
        													ripartenza[1]=0;
        												}

        												 if((pauseforsecond==false && startforsecond==false) || (pauseforsecond==false && startforsecond==true)) {
        													Indicator2JPanel.moveForward();
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar2JPanel.repaint();
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
        									
        									threadmuovereIndicatore1.start();
        									threadmuovereIndicatore2.start();
        								}
        								
        								else if(toggleButtonStartPause.isSelected() && NumProcessi==3)
        								{
        									timeToContinue=true;
        									timeToPause=false;
        									
        									
        									iniziocritica1_1=StartEndProcessi.get(0).inizioZonaCritica1;
        									finecritica1_1=StartEndProcessi.get(0).fineZonaCritica1;
        									iniziocritica2_1=StartEndProcessi.get(0).inizioZonaCritica2;
        									finecritica2_1=StartEndProcessi.get(0).fineZonaCritica2;
        									iniziocritica3_1=StartEndProcessi.get(0).inizioZonaCritica3;
        									finecritica3_1=StartEndProcessi.get(0).fineZonaCritica3;
        									
        									iniziocritica1_2=StartEndProcessi.get(1).inizioZonaCritica1;
        									finecritica1_2=StartEndProcessi.get(1).fineZonaCritica1;
        									iniziocritica2_2=StartEndProcessi.get(1).inizioZonaCritica2;
        									finecritica2_2=StartEndProcessi.get(1).fineZonaCritica2;
        									iniziocritica3_2=StartEndProcessi.get(1).inizioZonaCritica3;
        									finecritica3_2=StartEndProcessi.get(1).fineZonaCritica3;
        									
        									
        									iniziocritica1_3=StartEndProcessi.get(2).inizioZonaCritica1;
        									finecritica1_3=StartEndProcessi.get(2).fineZonaCritica1;
        									iniziocritica2_3=StartEndProcessi.get(2).inizioZonaCritica2;
        									finecritica2_3=StartEndProcessi.get(2).fineZonaCritica2;
        									iniziocritica3_3=StartEndProcessi.get(2).inizioZonaCritica3;
        									finecritica3_3=StartEndProcessi.get(2).fineZonaCritica3;
        									
        									
        									
        									
        									
        									
        									
											
        									Indicator1JPanel.setXInziale(StartEndProcessi.get(0).inizioProcesso);
        									Indicator1JPanel.setXFinale(StartEndProcessi.get(0).fineProcesso);
        									Indicator2JPanel.setXInziale(StartEndProcessi.get(1).inizioProcesso);
        									Indicator2JPanel.setXFinale(StartEndProcessi.get(1).fineProcesso);
        									Indicator3JPanel.setXInziale(StartEndProcessi.get(2).inizioProcesso);
        									Indicator3JPanel.setXFinale(StartEndProcessi.get(2).fineProcesso);
        									
        									
        									Thread threadmuovereIndicatore1 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											
        											for(int i=0; i<300; i++) 
        											{	
        												if(i==299)
        													i=0;
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 1 QUANDO INDICATORE 3 SI TROVA IN ZONA CRITICA
        												
        												if((Indicator3JPanel.getX()>=iniziocritica1_3 && Indicator3JPanel.getX()<=finecritica1_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica2_3 && Indicator3JPanel.getX()<=finecritica2_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica3_3 && Indicator3JPanel.getX()<=finecritica3_3))
        												{
        													
        													//SE L'INDICATORE 1 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator1JPanel.getX()==iniziocritica1_1-1 || Indicator1JPanel.getX()==iniziocritica2_1-1 || 
        															Indicator1JPanel.getX()==iniziocritica3_1-1	) 
        													{
        														
        														pauseforfirst=true;
        														startforfirst=false;
            													
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforfirst=false;
            													startforfirst=true;
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfirst=false;
        														startforfirst=false;
        													}
        														
        												}

        												//GESTIONE PAUSA PER INDICATORE 1 QUANDO INDICATORE 2 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE DUE SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator2JPanel.getX()>=iniziocritica1_2 && Indicator2JPanel.getX()<=finecritica1_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica2_2 && Indicator2JPanel.getX()<=finecritica2_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica3_2 && Indicator2JPanel.getX()<=finecritica3_2))
        												{
        													
        													//SE L'INDICATORE 1 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator1JPanel.getX()==iniziocritica1_1-1 || Indicator1JPanel.getX()==iniziocritica2_1-1 || 
        															Indicator1JPanel.getX()==iniziocritica3_1-1	) 
        													{
        														
        														pauseforfirst=true;
        														startforfirst=false;
            													
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforfirst=false;
            													startforfirst=true;
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfirst=false;
        														startforfirst=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 1 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforfirst=false;
        													startforfirst=false;
        												}
        													
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL PRIMO INDICATORE
        												if(iniziocritica1_1==Indicator1JPanel.getX() || iniziocritica2_1==Indicator1JPanel.getX() 
        														|| iniziocritica3_1==Indicator1JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL PRIMO INDICATORE
        												if(finecritica1_1==Indicator1JPanel.getX() || finecritica2_1==Indicator1JPanel.getX() 
        														|| finecritica3_1==Indicator1JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												//E' IL MOMENTO DI FERMARE IL PRIMO INDICATORE PERCHE' IL SECONDO E' IN ZONA CRITICA
        												if(pauseforfirst==true && startforfirst==false) {
        													temporaryValue1=Indicator1JPanel.getX();
        													Indicator1JPanel.Reset(temporaryValue1);
        													BaseProgressBar1JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue1=Indicator1JPanel.getX();
        													Indicator1JPanel.Reset(temporaryValue1);
        													BaseProgressBar1JPanel.repaint();
        													break;
        												}

        												//IL PRIMO INDICATORE HA RAGGIUNTO IL LIMITE X DEI 300
        												else if (Indicator1JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator1JPanel.Reset(StartEndProcessi.get(0).inizioProcesso);
        												}
        												
        												//L'INDICE DEL PRIMO INDICATORE E' ARRIVATO A 300 MA IL PRIMO INDICATORE
        												//SI TROVA IN PAUSA PER ZONA CRITICA DEL SECONDO
        												else if (i==299 && pauseforfirst==true) 
        												{
        													i=0;
        													Indicator1JPanel.Reset(temporaryValue1);
        												}
        											
        												
        												//IL PRIMO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[0]==1) 
        												{
        													Indicator1JPanel.setXInziale(temporaryValue1);
        													i=temporaryValue1;
        													ripartenza[0]=0;
        												}

        												//L'INDICATORE SI MUOVE SE E SOLO SE: PAUSEFORFIRST E STARTFORFIRST SONO FALSE
        												// O SE PAUSEFORFIRST=FALSE E STARTFORFIRST=TRUE
        												 if((pauseforfirst==false && startforfirst ==false) || (pauseforfirst==false && startforfirst==true)) 
        												 {
        													Indicator1JPanel.moveForward();
        													
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar1JPanel.repaint();
        													Thread.sleep(10);
        												} 
        												catch (InterruptedException e1)
        												{
        													
        													e1.printStackTrace();
        												}
        											}
        										
        										}
        									});
        									
        									Thread threadmuovereIndicatore2 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											

        											// TODO Auto-generated method stub
        											for(int i=0; i<300; i++) 
        											{	
        												
        												if(i==299)
        													i=0;
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 2 QUANDO INDICATORE 3 SI TROVA IN ZONA CRITICA
        												if((Indicator3JPanel.getX()>=iniziocritica1_3 && Indicator3JPanel.getX()<=finecritica1_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica2_3 && Indicator3JPanel.getX()<=finecritica2_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica3_3 && Indicator3JPanel.getX()<=finecritica3_3))
        												{
        													
        													//SE L'INDICATORE 2 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator2JPanel.getX()==iniziocritica1_2-1 || Indicator2JPanel.getX()==iniziocritica2_2-1 || 
        															Indicator2JPanel.getX()==iniziocritica3_2-1	) 
        													{
        														
        														pauseforsecond=true;
        														startforsecond=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforsecond==true)
        													{
            													pauseforsecond=false;
            													startforsecond=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforsecond=false;
        														startforsecond=false;
        													}
        														
        												}        												

        												
        												//GESTIONE PAUSA PER INDICATORE 2 QUANDO INDICATORE 1 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE UNO SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator1JPanel.getX()>=iniziocritica1_1 && Indicator1JPanel.getX()<=finecritica1_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica2_1 && Indicator1JPanel.getX()<=finecritica2_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica3_1 && Indicator1JPanel.getX()<=finecritica3_1))
        												{
        													
        													//SE L'INDICATORE 2 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator2JPanel.getX()==iniziocritica1_2-1 || Indicator2JPanel.getX()==iniziocritica2_2-1 || 
        															Indicator2JPanel.getX()==iniziocritica3_2-1	) 
        													{
        														
        														pauseforsecond=true;
        														startforsecond=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforsecond==true)
        													{
            													pauseforsecond=false;
            													startforsecond=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforsecond=false;
        														startforsecond=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 2 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforsecond=false;
        													startforsecond=false;
        												}
            											
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL SECONDO INDICATORE
        												if(iniziocritica1_2==Indicator2JPanel.getX() || iniziocritica2_2==Indicator2JPanel.getX() 
        														|| iniziocritica3_2==Indicator2JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL SECONDO INDICATORE
        												if(finecritica1_2==Indicator2JPanel.getX() || finecritica2_2==Indicator2JPanel.getX() 
        														|| finecritica3_2==Indicator2JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												
        										

        												//E' IL MOMENTO DI FERMARE IL SECONDO INDICATORE PERCHE' IL PRIMO E' IN ZONA CRITICA
        												if(pauseforsecond==true && startforsecond==false) {
        													temporaryValue2=Indicator2JPanel.getX();
        													Indicator2JPanel.Reset(temporaryValue2);
        													BaseProgressBar2JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue2=Indicator2JPanel.getX();
        													Indicator2JPanel.Reset(temporaryValue2);
        													BaseProgressBar2JPanel.repaint();
        													break;
        												}
        												
        												//LA X DELL'INDICATORE 2 HA RAGGIUNTO IL LIMITE DEI 300
        												else if (Indicator2JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator2JPanel.Reset(StartEndProcessi.get(1).inizioProcesso);
        												}
        												
        												//L'INDICE i HA RAGGIUNTO I 300 MA L'INDICATORE DUE SI TROVA IN PAUSA PER
        												//ZONA CRITICA DEL PRIMO INDICATORE
        												else if (i==299 && pauseforsecond==true) 
        												{
        													i=0;
        													Indicator2JPanel.Reset(Indicator2JPanel.getX());
        												}
        											
        												//IL SECONDO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[1]==1) 
        												{
        													Indicator2JPanel.setXInziale(temporaryValue2);
        													i=temporaryValue2;
        													ripartenza[1]=0;
        												}

        												 if((pauseforsecond==false && startforsecond==false) || (pauseforsecond==false && startforsecond==true)) {
        													Indicator2JPanel.moveForward();
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar2JPanel.repaint();
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
        									
        									
        									Thread threadmuovereIndicatore3 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											
        											for(int i=0; i<300; i++) 
        											{	
        												if(i==299)
        													i=0;
        												
        												//GESTIONE PAUSA PER INDICATORE 3 QUANDO INDICATORE 1 SI TROVA IN ZONA CRITICA
        												if((Indicator1JPanel.getX()>=iniziocritica1_1 && Indicator1JPanel.getX()<=finecritica1_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica2_1 && Indicator1JPanel.getX()<=finecritica2_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica3_1 && Indicator1JPanel.getX()<=finecritica3_1))
        												{
        													
        													//SE L'INDICATORE 3 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator3JPanel.getX()==iniziocritica1_3-1 || Indicator3JPanel.getX()==iniziocritica2_3-1 || 
        															Indicator3JPanel.getX()==iniziocritica3_3-1	) 
        													{
        														
        														pauseforthird=true;
        														startforthird=false;
            													
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforthird=false;
            													startforthird=true;
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforthird=false;
        														startforthird=false;
        													}
        														
        												}
        												        												
        												//GESTIONE PAUSA PER INDICATORE 3 QUANDO INDICATORE 2 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE 2 SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator2JPanel.getX()>=iniziocritica1_2 && Indicator2JPanel.getX()<=finecritica1_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica2_2 && Indicator2JPanel.getX()<=finecritica2_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica3_2 && Indicator2JPanel.getX()<=finecritica3_2))
        												{
        													
        													//SE L'INDICATORE 3 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator3JPanel.getX()==iniziocritica1_3-1 || Indicator3JPanel.getX()==iniziocritica2_3-1 || 
        															Indicator3JPanel.getX()==iniziocritica3_3-1	) 
        													{
        														
        														pauseforthird=true;
        														startforthird=false;
            													
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforthird=false;
            													startforthird=true;
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforthird=false;
        														startforthird=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 3 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforthird=false;
        													startforthird=false;
        												}
        													
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL TERZO INDICATORE
        												if(iniziocritica1_3==Indicator3JPanel.getX() || iniziocritica2_3==Indicator3JPanel.getX() 
        														|| iniziocritica3_3==Indicator3JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL TERZO INDICATORE
        												if(finecritica1_3==Indicator3JPanel.getX() || finecritica2_3==Indicator3JPanel.getX() 
        														|| finecritica3_3==Indicator3JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												//E' IL MOMENTO DI FERMARE IL TERZO INDICATORE PERCHE' IL SECONDO O IL PRIMO SONO IN ZONA CRITICA
        												if(pauseforthird==true && startforthird==false) {
        													temporaryValue3=Indicator3JPanel.getX();
        													Indicator3JPanel.Reset(temporaryValue3);
        													BaseProgressBar3JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue3=Indicator3JPanel.getX();
        													Indicator3JPanel.Reset(temporaryValue3);
        													BaseProgressBar3JPanel.repaint();
        													break;
        												}

        												//IL TERZO INDICATORE HA RAGGIUNTO IL LIMITE X DEI 300
        												else if (Indicator3JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator3JPanel.Reset(StartEndProcessi.get(2).inizioProcesso);
        												}
        												
        												//L'INDICE i DEL TERZO INDICATORE E' ARRIVATO A 300 MA
        												//SI TROVA IN PAUSA PER ZONA CRITICA DEL SECONDO O PRIMO
        												else if (i==299 && pauseforthird==true) 
        												{
        													i=0;
        													Indicator3JPanel.Reset(temporaryValue3);
        												}
        											
        												
        												//IL TERZO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[2]==1) 
        												{
        													Indicator3JPanel.setXInziale(temporaryValue3);
        													i=temporaryValue3;
        													ripartenza[2]=0;
        												}

        												//QUANDO SI MUOVE L'INDICATORE
        												 if((pauseforthird==false && startforthird ==false) || (pauseforthird==false && startforthird==true)) 
        												 {
        													Indicator3JPanel.moveForward();
        													
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar3JPanel.repaint();
        													Thread.sleep(10);
        												} 
        												catch (InterruptedException e1)
        												{
        													
        													e1.printStackTrace();
        												}
        											}
        										
        										}
        									});
        									
        									threadmuovereIndicatore1.start();
        									threadmuovereIndicatore2.start();
        									threadmuovereIndicatore3.start();
        								}
        								
        								
        								else if(toggleButtonStartPause.isSelected() && NumProcessi==4)
        								{
        									timeToContinue=true;
        									timeToPause=false;
        									
        									
        									iniziocritica1_1=StartEndProcessi.get(0).inizioZonaCritica1;
        									finecritica1_1=StartEndProcessi.get(0).fineZonaCritica1;
        									iniziocritica2_1=StartEndProcessi.get(0).inizioZonaCritica2;
        									finecritica2_1=StartEndProcessi.get(0).fineZonaCritica2;
        									iniziocritica3_1=StartEndProcessi.get(0).inizioZonaCritica3;
        									finecritica3_1=StartEndProcessi.get(0).fineZonaCritica3;
        									
        									iniziocritica1_2=StartEndProcessi.get(1).inizioZonaCritica1;
        									finecritica1_2=StartEndProcessi.get(1).fineZonaCritica1;
        									iniziocritica2_2=StartEndProcessi.get(1).inizioZonaCritica2;
        									finecritica2_2=StartEndProcessi.get(1).fineZonaCritica2;
        									iniziocritica3_2=StartEndProcessi.get(1).inizioZonaCritica3;
        									finecritica3_2=StartEndProcessi.get(1).fineZonaCritica3;
        									
        									
        									iniziocritica1_3=StartEndProcessi.get(2).inizioZonaCritica1;
        									finecritica1_3=StartEndProcessi.get(2).fineZonaCritica1;
        									iniziocritica2_3=StartEndProcessi.get(2).inizioZonaCritica2;
        									finecritica2_3=StartEndProcessi.get(2).fineZonaCritica2;
        									iniziocritica3_3=StartEndProcessi.get(2).inizioZonaCritica3;
        									finecritica3_3=StartEndProcessi.get(2).fineZonaCritica3;
											
        									
        									iniziocritica1_4=StartEndProcessi.get(3).inizioZonaCritica1;
        									finecritica1_4=StartEndProcessi.get(3).fineZonaCritica1;
        									iniziocritica2_4=StartEndProcessi.get(3).inizioZonaCritica2;
        									finecritica2_4=StartEndProcessi.get(3).fineZonaCritica2;
        									iniziocritica3_4=StartEndProcessi.get(3).inizioZonaCritica3;
        									finecritica3_4=StartEndProcessi.get(3).fineZonaCritica3;
        									
        									Indicator1JPanel.setXInziale(StartEndProcessi.get(0).inizioProcesso);
        									Indicator1JPanel.setXFinale(StartEndProcessi.get(0).fineProcesso);
        									Indicator2JPanel.setXInziale(StartEndProcessi.get(1).inizioProcesso);
        									Indicator2JPanel.setXFinale(StartEndProcessi.get(1).fineProcesso);
        									Indicator3JPanel.setXInziale(StartEndProcessi.get(2).inizioProcesso);
        									Indicator3JPanel.setXFinale(StartEndProcessi.get(2).fineProcesso);
        									Indicator4JPanel.setXInziale(StartEndProcessi.get(3).inizioProcesso);
        									Indicator4JPanel.setXFinale(StartEndProcessi.get(3).fineProcesso);

        									
        									
        									Thread threadmuovereIndicatore1 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											
        											for(int i=0; i<300; i++) 
        											{	
        												if(i==299)
        													i=0;
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 1 QUANDO INDICATORE 4 SI TROVA IN ZONA CRITICA
        												if((Indicator4JPanel.getX()>=iniziocritica1_4 && Indicator4JPanel.getX()<=finecritica1_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica2_4 && Indicator4JPanel.getX()<=finecritica2_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica3_4 && Indicator4JPanel.getX()<=finecritica3_4))
        												{
        													
        													//SE L'INDICATORE 1 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator1JPanel.getX()==iniziocritica1_1-1 || Indicator1JPanel.getX()==iniziocritica2_1-1 || 
        															Indicator1JPanel.getX()==iniziocritica3_1-1	) 
        													{
        														
        														pauseforfirst=true;
        														startforfirst=false;
            													
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforfirst=false;
            													startforfirst=true;
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfirst=false;
        														startforfirst=false;
        													}
        														
        												}
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 1 QUANDO INDICATORE 3 SI TROVA IN ZONA CRITICA
        												
        												else if((Indicator3JPanel.getX()>=iniziocritica1_3 && Indicator3JPanel.getX()<=finecritica1_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica2_3 && Indicator3JPanel.getX()<=finecritica2_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica3_3 && Indicator3JPanel.getX()<=finecritica3_3))
        												{
        													
        													//SE L'INDICATORE 1 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator1JPanel.getX()==iniziocritica1_1-1 || Indicator1JPanel.getX()==iniziocritica2_1-1 || 
        															Indicator1JPanel.getX()==iniziocritica3_1-1	) 
        													{
        														
        														pauseforfirst=true;
        														startforfirst=false;
            													
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforfirst=false;
            													startforfirst=true;
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfirst=false;
        														startforfirst=false;
        													}
        														
        												}

        												//GESTIONE PAUSA PER INDICATORE 1 QUANDO INDICATORE 2 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE DUE SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator2JPanel.getX()>=iniziocritica1_2 && Indicator2JPanel.getX()<=finecritica1_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica2_2 && Indicator2JPanel.getX()<=finecritica2_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica3_2 && Indicator2JPanel.getX()<=finecritica3_2))
        												{
        													
        													//SE L'INDICATORE 1 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator1JPanel.getX()==iniziocritica1_1-1 || Indicator1JPanel.getX()==iniziocritica2_1-1 || 
        															Indicator1JPanel.getX()==iniziocritica3_1-1	) 
        													{
        														
        														pauseforfirst=true;
        														startforfirst=false;
            													
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforfirst=false;
            													startforfirst=true;
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfirst=false;
        														startforfirst=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 1 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforfirst=false;
        													startforfirst=false;
        												}
        													
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL PRIMO INDICATORE
        												if(iniziocritica1_1==Indicator1JPanel.getX() || iniziocritica2_1==Indicator1JPanel.getX() 
        														|| iniziocritica3_1==Indicator1JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL PRIMO INDICATORE
        												if(finecritica1_1==Indicator1JPanel.getX() || finecritica2_1==Indicator1JPanel.getX() 
        														|| finecritica3_1==Indicator1JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												//E' IL MOMENTO DI FERMARE IL PRIMO INDICATORE PERCHE' IL SECONDO E' IN ZONA CRITICA
        												if(pauseforfirst==true && startforfirst==false) {
        													temporaryValue1=Indicator1JPanel.getX();
        													Indicator1JPanel.Reset(temporaryValue1);
        													BaseProgressBar1JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue1=Indicator1JPanel.getX();
        													Indicator1JPanel.Reset(temporaryValue1);
        													BaseProgressBar1JPanel.repaint();
        													break;
        												}

        												//IL PRIMO INDICATORE HA RAGGIUNTO IL LIMITE X DEI 300
        												else if (Indicator1JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator1JPanel.Reset(StartEndProcessi.get(0).inizioProcesso);
        												}
        												
        												//L'INDICE DEL PRIMO INDICATORE E' ARRIVATO A 300 MA IL PRIMO INDICATORE
        												//SI TROVA IN PAUSA PER ZONA CRITICA DEL SECONDO
        												else if (i==299 && pauseforfirst==true) 
        												{
        													i=0;
        													Indicator1JPanel.Reset(temporaryValue1);
        												}
        											
        												
        												//IL PRIMO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[0]==1) 
        												{
        													Indicator1JPanel.setXInziale(temporaryValue1);
        													i=temporaryValue1;
        													ripartenza[0]=0;
        												}

        												//L'INDICATORE SI MUOVE SE E SOLO SE: PAUSEFORFIRST E STARTFORFIRST SONO FALSE
        												// O SE PAUSEFORFIRST=FALSE E STARTFORFIRST=TRUE
        												 if((pauseforfirst==false && startforfirst ==false) || (pauseforfirst==false && startforfirst==true)) 
        												 {
        													Indicator1JPanel.moveForward();
        													
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar1JPanel.repaint();
        													Thread.sleep(10);
        												} 
        												catch (InterruptedException e1)
        												{
        													
        													e1.printStackTrace();
        												}
        											}
        										
        										}
        									});
        									
        									Thread threadmuovereIndicatore2 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											

        											// TODO Auto-generated method stub
        											for(int i=0; i<300; i++) 
        											{	
        												
        												if(i==299)
        													i=0;
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 2 QUANDO INDICATORE 4 SI TROVA IN ZONA CRITICA
        												if((Indicator4JPanel.getX()>=iniziocritica1_4 && Indicator4JPanel.getX()<=finecritica1_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica2_4 && Indicator4JPanel.getX()<=finecritica2_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica3_4 && Indicator4JPanel.getX()<=finecritica3_4))
        												{
        													
        													//SE L'INDICATORE 2 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator2JPanel.getX()==iniziocritica1_2-1 || Indicator2JPanel.getX()==iniziocritica2_2-1 || 
        															Indicator2JPanel.getX()==iniziocritica3_2-1	) 
        													{
        														
        														pauseforsecond=true;
        														startforsecond=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforsecond==true)
        													{
            													pauseforsecond=false;
            													startforsecond=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforsecond=false;
        														startforsecond=false;
        													}
        														
        												} 
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 2 QUANDO INDICATORE 3 SI TROVA IN ZONA CRITICA
        												else if((Indicator3JPanel.getX()>=iniziocritica1_3 && Indicator3JPanel.getX()<=finecritica1_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica2_3 && Indicator3JPanel.getX()<=finecritica2_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica3_3 && Indicator3JPanel.getX()<=finecritica3_3))
        												{
        													
        													//SE L'INDICATORE 2 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator2JPanel.getX()==iniziocritica1_2-1 || Indicator2JPanel.getX()==iniziocritica2_2-1 || 
        															Indicator2JPanel.getX()==iniziocritica3_2-1	) 
        													{
        														
        														pauseforsecond=true;
        														startforsecond=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforsecond==true)
        													{
            													pauseforsecond=false;
            													startforsecond=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforsecond=false;
        														startforsecond=false;
        													}
        														
        												}        												

        												
        												//GESTIONE PAUSA PER INDICATORE 2 QUANDO INDICATORE 1 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE UNO SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator1JPanel.getX()>=iniziocritica1_1 && Indicator1JPanel.getX()<=finecritica1_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica2_1 && Indicator1JPanel.getX()<=finecritica2_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica3_1 && Indicator1JPanel.getX()<=finecritica3_1))
        												{
        													
        													//SE L'INDICATORE 2 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator2JPanel.getX()==iniziocritica1_2-1 || Indicator2JPanel.getX()==iniziocritica2_2-1 || 
        															Indicator2JPanel.getX()==iniziocritica3_2-1	) 
        													{
        														
        														pauseforsecond=true;
        														startforsecond=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforsecond==true)
        													{
            													pauseforsecond=false;
            													startforsecond=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforsecond=false;
        														startforsecond=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 2 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforsecond=false;
        													startforsecond=false;
        												}
            											
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL SECONDO INDICATORE
        												if(iniziocritica1_2==Indicator2JPanel.getX() || iniziocritica2_2==Indicator2JPanel.getX() 
        														|| iniziocritica3_2==Indicator2JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL SECONDO INDICATORE
        												if(finecritica1_2==Indicator2JPanel.getX() || finecritica2_2==Indicator2JPanel.getX() 
        														|| finecritica3_2==Indicator2JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												
        										

        												//E' IL MOMENTO DI FERMARE IL SECONDO INDICATORE PERCHE' IL PRIMO E' IN ZONA CRITICA
        												if(pauseforsecond==true && startforsecond==false) {
        													temporaryValue2=Indicator2JPanel.getX();
        													Indicator2JPanel.Reset(temporaryValue2);
        													BaseProgressBar2JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue2=Indicator2JPanel.getX();
        													Indicator2JPanel.Reset(temporaryValue2);
        													BaseProgressBar2JPanel.repaint();
        													break;
        												}
        												
        												//LA X DELL'INDICATORE 2 HA RAGGIUNTO IL LIMITE DEI 300
        												else if (Indicator2JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator2JPanel.Reset(StartEndProcessi.get(1).inizioProcesso);
        												}
        												
        												//L'INDICE i HA RAGGIUNTO I 300 MA L'INDICATORE DUE SI TROVA IN PAUSA PER
        												//ZONA CRITICA DEL PRIMO INDICATORE
        												else if (i==299 && pauseforsecond==true) 
        												{
        													i=0;
        													Indicator2JPanel.Reset(Indicator2JPanel.getX());
        												}
        											
        												//IL SECONDO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[1]==1) 
        												{
        													Indicator2JPanel.setXInziale(temporaryValue2);
        													i=temporaryValue2;
        													ripartenza[1]=0;
        												}

        												 if((pauseforsecond==false && startforsecond==false) || (pauseforsecond==false && startforsecond==true)) {
        													Indicator2JPanel.moveForward();
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar2JPanel.repaint();
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
        									
        									
        									Thread threadmuovereIndicatore3 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											
        											for(int i=0; i<300; i++) 
        											{	
        												if(i==299)
        													i=0;
        												
        												
        												
        												
        												if((Indicator4JPanel.getX()>=iniziocritica1_4 && Indicator4JPanel.getX()<=finecritica1_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica2_4 && Indicator4JPanel.getX()<=finecritica2_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica3_4 && Indicator4JPanel.getX()<=finecritica3_4))
        												{
        													
        													//SE L'INDICATORE 3 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator3JPanel.getX()==iniziocritica1_3-1 || Indicator3JPanel.getX()==iniziocritica2_3-1 || 
        															Indicator3JPanel.getX()==iniziocritica3_3-1	) 
        													{
        														
        														pauseforthird=true;
        														startforthird=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforthird==true)
        													{
            													pauseforthird=false;
            													startforthird=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforthird=false;
        														startforthird=false;
        													}
        														
        												} 
        												        												
        												//GESTIONE PAUSA PER INDICATORE 3 QUANDO INDICATORE 1 SI TROVA IN ZONA CRITICA
        												else if((Indicator1JPanel.getX()>=iniziocritica1_1 && Indicator1JPanel.getX()<=finecritica1_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica2_1 && Indicator1JPanel.getX()<=finecritica2_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica3_1 && Indicator1JPanel.getX()<=finecritica3_1))
        												{
        													
        													//SE L'INDICATORE 3 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator3JPanel.getX()==iniziocritica1_3-1 || Indicator3JPanel.getX()==iniziocritica2_3-1 || 
        															Indicator3JPanel.getX()==iniziocritica3_3-1	) 
        													{
        														
        														pauseforthird=true;
        														startforthird=false;
            													
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforthird=false;
            													startforthird=true;
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforthird=false;
        														startforthird=false;
        													}
        														
        												}
        												        												
        												//GESTIONE PAUSA PER INDICATORE 3 QUANDO INDICATORE 2 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE 2 SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator2JPanel.getX()>=iniziocritica1_2 && Indicator2JPanel.getX()<=finecritica1_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica2_2 && Indicator2JPanel.getX()<=finecritica2_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica3_2 && Indicator2JPanel.getX()<=finecritica3_2))
        												{
        													
        													//SE L'INDICATORE 3 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator3JPanel.getX()==iniziocritica1_3-1 || Indicator3JPanel.getX()==iniziocritica2_3-1 || 
        															Indicator3JPanel.getX()==iniziocritica3_3-1	) 
        													{
        														
        														pauseforthird=true;
        														startforthird=false;
            													
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforthird=false;
            													startforthird=true;
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforthird=false;
        														startforthird=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 3 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforthird=false;
        													startforthird=false;
        												}
        													
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL TERZO INDICATORE
        												if(iniziocritica1_3==Indicator3JPanel.getX() || iniziocritica2_3==Indicator3JPanel.getX() 
        														|| iniziocritica3_3==Indicator3JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL TERZO INDICATORE
        												if(finecritica1_3==Indicator3JPanel.getX() || finecritica2_3==Indicator3JPanel.getX() 
        														|| finecritica3_3==Indicator3JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												//E' IL MOMENTO DI FERMARE IL TERZO INDICATORE PERCHE' IL SECONDO O IL PRIMO SONO IN ZONA CRITICA
        												if(pauseforthird==true && startforthird==false) {
        													temporaryValue3=Indicator3JPanel.getX();
        													Indicator3JPanel.Reset(temporaryValue3);
        													BaseProgressBar3JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue3=Indicator3JPanel.getX();
        													Indicator3JPanel.Reset(temporaryValue3);
        													BaseProgressBar3JPanel.repaint();
        													break;
        												}

        												//IL TERZO INDICATORE HA RAGGIUNTO IL LIMITE X DEI 300
        												else if (Indicator3JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator3JPanel.Reset(StartEndProcessi.get(2).inizioProcesso);
        												}
        												
        												//L'INDICE i DEL TERZO INDICATORE E' ARRIVATO A 300 MA
        												//SI TROVA IN PAUSA PER ZONA CRITICA DEL SECONDO O PRIMO
        												else if (i==299 && pauseforthird==true) 
        												{
        													i=0;
        													Indicator3JPanel.Reset(temporaryValue3);
        												}
        											
        												
        												//IL TERZO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[2]==1) 
        												{
        													Indicator3JPanel.setXInziale(temporaryValue3);
        													i=temporaryValue3;
        													ripartenza[2]=0;
        												}

        												//QUANDO SI MUOVE L'INDICATORE
        												 if((pauseforthird==false && startforthird ==false) || (pauseforthird==false && startforthird==true)) 
        												 {
        													Indicator3JPanel.moveForward();
        													
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar3JPanel.repaint();
        													Thread.sleep(10);
        												} 
        												catch (InterruptedException e1)
        												{
        													
        													e1.printStackTrace();
        												}
        											}
        										
        										}
        									});
        									
        								
        									Thread threadmuovereIndicatore4 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											
        											for(int i=0; i<300; i++) 
        											{	
        												if(i==299)
        													i=0;
        												
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 4 QUANDO INDICATORE 3 SI TROVA IN ZONA CRITICA
        												if((Indicator3JPanel.getX()>=iniziocritica1_3 && Indicator3JPanel.getX()<=finecritica1_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica2_3 && Indicator3JPanel.getX()<=finecritica2_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica3_3 && Indicator3JPanel.getX()<=finecritica3_3))
        												{
        													
        													//SE L'INDICATORE 4 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator4JPanel.getX()==iniziocritica1_4-1 || Indicator4JPanel.getX()==iniziocritica2_4-1 || 
        															Indicator4JPanel.getX()==iniziocritica3_4-1	) 
        													{
        														
        														pauseforfourth=true;
        														startforfourth=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfourth==true)
        													{
            													pauseforfourth=false;
            													startforfourth=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfourth=false;
        														startforfourth=false;
        													}
        														
        												} 
        												        												
        												//GESTIONE PAUSA PER INDICATORE 4 QUANDO INDICATORE 1 SI TROVA IN ZONA CRITICA
        												else if((Indicator1JPanel.getX()>=iniziocritica1_1 && Indicator1JPanel.getX()<=finecritica1_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica2_1 && Indicator1JPanel.getX()<=finecritica2_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica3_1 && Indicator1JPanel.getX()<=finecritica3_1))
        												{
        													
        													//SE L'INDICATORE 4 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator4JPanel.getX()==iniziocritica1_4-1 || Indicator4JPanel.getX()==iniziocritica2_4-1 || 
        															Indicator4JPanel.getX()==iniziocritica3_4-1	) 
        													{
        														
        														pauseforfourth=true;
        														startforfourth=false;
            													
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfourth==true)
        													{
            													pauseforfourth=false;
            													startforfourth=true;
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfourth=false;
        														startforfourth=false;
        													}
        														
        												}
        												        												
        												//GESTIONE PAUSA PER INDICATORE 4 QUANDO INDICATORE 2 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE 2 SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator2JPanel.getX()>=iniziocritica1_2 && Indicator2JPanel.getX()<=finecritica1_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica2_2 && Indicator2JPanel.getX()<=finecritica2_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica3_2 && Indicator2JPanel.getX()<=finecritica3_2))
        												{
        													
        													//SE L'INDICATORE 4 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator4JPanel.getX()==iniziocritica1_4-1 || Indicator4JPanel.getX()==iniziocritica2_4-1 || 
        															Indicator4JPanel.getX()==iniziocritica3_4-1	) 
        													{
        														
        														pauseforfourth=true;
        														startforfourth=false;
            													
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfourth==true)
        													{
            													pauseforfourth=false;
            													startforfourth=true;
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfourth=false;
        														startforfourth=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 4 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforfourth=false;
        													startforfourth=false;
        												}
        													
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL QUARTO INDICATORE
        												if(iniziocritica1_4==Indicator4JPanel.getX() || iniziocritica2_4==Indicator4JPanel.getX() 
        														|| iniziocritica3_4==Indicator4JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL QUARTO INDICATORE
        												if(finecritica1_4==Indicator4JPanel.getX() || finecritica2_4==Indicator4JPanel.getX() 
        														|| finecritica3_4==Indicator4JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												//E' IL MOMENTO DI FERMARE IL QUARTO INDICATORE PERCHE' IL SECONDO O IL PRIMO O IL TERZO SONO IN ZONA CRITICA
        												if(pauseforfourth==true && startforfourth==false) {
        													temporaryValue4=Indicator4JPanel.getX();
        													Indicator4JPanel.Reset(temporaryValue4);
        													BaseProgressBar4JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue4=Indicator4JPanel.getX();
        													Indicator4JPanel.Reset(temporaryValue4);
        													BaseProgressBar4JPanel.repaint();
        													break;
        												}

        												//IL QUARTO INDICATORE HA RAGGIUNTO IL LIMITE X DEI 300
        												else if (Indicator4JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator4JPanel.Reset(StartEndProcessi.get(3).inizioProcesso);
        												}
        												
        												//L'INDICE i DEL QUARTO INDICATORE E' ARRIVATO A 300 MA
        												//SI TROVA IN PAUSA PER ZONA CRITICA DEL SECONDO O PRIMO O TERZO
        												else if (i==299 && pauseforfourth==true) 
        												{
        													i=0;
        													Indicator4JPanel.Reset(temporaryValue4);
        												}
        											
        												
        												//IL QUARTO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[3]==1) 
        												{
        													Indicator4JPanel.setXInziale(temporaryValue4);
        													i=temporaryValue4;
        													ripartenza[3]=0;
        												}

        												//QUANDO SI MUOVE L'INDICATORE
        												 if((pauseforfourth==false && startforfourth ==false) || (pauseforfourth==false && startforfourth==true)) 
        												 {
        													Indicator4JPanel.moveForward();
        													
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar4JPanel.repaint();
        													Thread.sleep(10);
        												} 
        												catch (InterruptedException e1)
        												{
        													
        													e1.printStackTrace();
        												}
        											}
        										
        										}
        									});
        									
        									
        									threadmuovereIndicatore1.start();
        									threadmuovereIndicatore2.start();
        									threadmuovereIndicatore3.start();
        									threadmuovereIndicatore4.start();
        								
        								}
        								
        								else if(toggleButtonStartPause.isSelected() && NumProcessi==5)
        								{
        									timeToContinue=true;
        									timeToPause=false;
											
        									
        									iniziocritica1_1=StartEndProcessi.get(0).inizioZonaCritica1;
        									finecritica1_1=StartEndProcessi.get(0).fineZonaCritica1;
        									iniziocritica2_1=StartEndProcessi.get(0).inizioZonaCritica2;
        									finecritica2_1=StartEndProcessi.get(0).fineZonaCritica2;
        									iniziocritica3_1=StartEndProcessi.get(0).inizioZonaCritica3;
        									finecritica3_1=StartEndProcessi.get(0).fineZonaCritica3;
        									
        									iniziocritica1_2=StartEndProcessi.get(1).inizioZonaCritica1;
        									finecritica1_2=StartEndProcessi.get(1).fineZonaCritica1;
        									iniziocritica2_2=StartEndProcessi.get(1).inizioZonaCritica2;
        									finecritica2_2=StartEndProcessi.get(1).fineZonaCritica2;
        									iniziocritica3_2=StartEndProcessi.get(1).inizioZonaCritica3;
        									finecritica3_2=StartEndProcessi.get(1).fineZonaCritica3;
        									
        									
        									iniziocritica1_3=StartEndProcessi.get(2).inizioZonaCritica1;
        									finecritica1_3=StartEndProcessi.get(2).fineZonaCritica1;
        									iniziocritica2_3=StartEndProcessi.get(2).inizioZonaCritica2;
        									finecritica2_3=StartEndProcessi.get(2).fineZonaCritica2;
        									iniziocritica3_3=StartEndProcessi.get(2).inizioZonaCritica3;
        									finecritica3_3=StartEndProcessi.get(2).fineZonaCritica3;
											
        									
        									iniziocritica1_4=StartEndProcessi.get(3).inizioZonaCritica1;
        									finecritica1_4=StartEndProcessi.get(3).fineZonaCritica1;
        									iniziocritica2_4=StartEndProcessi.get(3).inizioZonaCritica2;
        									finecritica2_4=StartEndProcessi.get(3).fineZonaCritica2;
        									iniziocritica3_4=StartEndProcessi.get(3).inizioZonaCritica3;
        									finecritica3_4=StartEndProcessi.get(3).fineZonaCritica3;
        									
        									
        									iniziocritica1_5=StartEndProcessi.get(4).inizioZonaCritica1;
        									finecritica1_5=StartEndProcessi.get(4).fineZonaCritica1;
        									iniziocritica2_5=StartEndProcessi.get(4).inizioZonaCritica2;
        									finecritica2_5=StartEndProcessi.get(4).fineZonaCritica2;
        									iniziocritica3_5=StartEndProcessi.get(4).inizioZonaCritica3;
        									finecritica3_5=StartEndProcessi.get(4).fineZonaCritica3;
        									
        									
        									
        									
        									Indicator1JPanel.setXInziale(StartEndProcessi.get(0).inizioProcesso);
        									Indicator1JPanel.setXFinale(StartEndProcessi.get(0).fineProcesso);
        									Indicator2JPanel.setXInziale(StartEndProcessi.get(1).inizioProcesso);
        									Indicator2JPanel.setXFinale(StartEndProcessi.get(1).fineProcesso);
        									Indicator3JPanel.setXInziale(StartEndProcessi.get(2).inizioProcesso);
        									Indicator3JPanel.setXFinale(StartEndProcessi.get(2).fineProcesso);
        									Indicator4JPanel.setXInziale(StartEndProcessi.get(3).inizioProcesso);
        									Indicator4JPanel.setXFinale(StartEndProcessi.get(3).fineProcesso);
        									Indicator5JPanel.setXInziale(StartEndProcessi.get(4).inizioProcesso);
        									Indicator5JPanel.setXFinale(StartEndProcessi.get(4).fineProcesso);

        									
        									
        									Thread threadmuovereIndicatore1 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											
        											for(int i=0; i<300; i++) 
        											{	
        												if(i==299)
        													i=0;
        												
        												//GESTIONE PAUSA PER INDICATORE 1 QUANDO INDICATORE 5 SI TROVA IN ZONA CRITICA
        												if((Indicator5JPanel.getX()>=iniziocritica1_5 && Indicator5JPanel.getX()<=finecritica1_5) ||
        														(Indicator5JPanel.getX()>=iniziocritica2_5 && Indicator5JPanel.getX()<=finecritica2_5) ||
        														(Indicator5JPanel.getX()>=iniziocritica3_5 && Indicator5JPanel.getX()<=finecritica3_5))
        												{
        													
        													//SE L'INDICATORE 1 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator1JPanel.getX()==iniziocritica1_1-1 || Indicator1JPanel.getX()==iniziocritica2_1-1 || 
        															Indicator1JPanel.getX()==iniziocritica3_1-1	) 
        													{
        														
        														pauseforfirst=true;
        														startforfirst=false;
            													
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforfirst=false;
            													startforfirst=true;
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfirst=false;
        														startforfirst=false;
        													}
        														
        												}
        												
        												//GESTIONE PAUSA PER INDICATORE 1 QUANDO INDICATORE 4 SI TROVA IN ZONA CRITICA
        												else if((Indicator4JPanel.getX()>=iniziocritica1_4 && Indicator4JPanel.getX()<=finecritica1_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica2_4 && Indicator4JPanel.getX()<=finecritica2_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica3_4 && Indicator4JPanel.getX()<=finecritica3_4))
        												{
        													
        													//SE L'INDICATORE 1 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator1JPanel.getX()==iniziocritica1_1-1 || Indicator1JPanel.getX()==iniziocritica2_1-1 || 
        															Indicator1JPanel.getX()==iniziocritica3_1-1	) 
        													{
        														
        														pauseforfirst=true;
        														startforfirst=false;
            													
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforfirst=false;
            													startforfirst=true;
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfirst=false;
        														startforfirst=false;
        													}
        														
        												}
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 1 QUANDO INDICATORE 3 SI TROVA IN ZONA CRITICA
        												
        												else if((Indicator3JPanel.getX()>=iniziocritica1_3 && Indicator3JPanel.getX()<=finecritica1_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica2_3 && Indicator3JPanel.getX()<=finecritica2_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica3_3 && Indicator3JPanel.getX()<=finecritica3_3))
        												{
        													
        													//SE L'INDICATORE 1 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator1JPanel.getX()==iniziocritica1_1-1 || Indicator1JPanel.getX()==iniziocritica2_1-1 || 
        															Indicator1JPanel.getX()==iniziocritica3_1-1	) 
        													{
        														
        														pauseforfirst=true;
        														startforfirst=false;
            													
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforfirst=false;
            													startforfirst=true;
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfirst=false;
        														startforfirst=false;
        													}
        														
        												}

        												//GESTIONE PAUSA PER INDICATORE 1 QUANDO INDICATORE 2 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE DUE SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator2JPanel.getX()>=iniziocritica1_2 && Indicator2JPanel.getX()<=finecritica1_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica2_2 && Indicator2JPanel.getX()<=finecritica2_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica3_2 && Indicator2JPanel.getX()<=finecritica3_2))
        												{
        													
        													//SE L'INDICATORE 1 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator1JPanel.getX()==iniziocritica1_1-1 || Indicator1JPanel.getX()==iniziocritica2_1-1 || 
        															Indicator1JPanel.getX()==iniziocritica3_1-1	) 
        													{
        														
        														pauseforfirst=true;
        														startforfirst=false;
            													
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforfirst=false;
            													startforfirst=true;
        													}
        													//L'INDICATORE 1 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfirst=false;
        														startforfirst=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 1 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforfirst=false;
        													startforfirst=false;
        												}
        													
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL PRIMO INDICATORE
        												if(iniziocritica1_1==Indicator1JPanel.getX() || iniziocritica2_1==Indicator1JPanel.getX() 
        														|| iniziocritica3_1==Indicator1JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL PRIMO INDICATORE
        												if(finecritica1_1==Indicator1JPanel.getX() || finecritica2_1==Indicator1JPanel.getX() 
        														|| finecritica3_1==Indicator1JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												//E' IL MOMENTO DI FERMARE IL PRIMO INDICATORE PERCHE' IL SECONDO 
        												//O IL TERZO O IL QUARTO O IL QUINTO SONO IN ZONA CRITICA
        												if(pauseforfirst==true && startforfirst==false) {
        													temporaryValue1=Indicator1JPanel.getX();
        													Indicator1JPanel.Reset(temporaryValue1);
        													BaseProgressBar1JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue1=Indicator1JPanel.getX();
        													Indicator1JPanel.Reset(temporaryValue1);
        													BaseProgressBar1JPanel.repaint();
        													break;
        												}

        												//IL PRIMO INDICATORE HA RAGGIUNTO IL LIMITE X DEI 300
        												else if (Indicator1JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator1JPanel.Reset(StartEndProcessi.get(0).inizioProcesso);
        												}
        												
        												//L'INDICE DEL PRIMO INDICATORE E' ARRIVATO A 300 MA IL PRIMO INDICATORE
        												//SI TROVA IN PAUSA PER ZONA CRITICA DEL SECONDO O DEL TERZO O DEL QUARTO O DEL QUINTO
        												else if (i==299 && pauseforfirst==true) 
        												{
        													i=0;
        													Indicator1JPanel.Reset(temporaryValue1);
        												}
        											
        												
        												//IL PRIMO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[0]==1) 
        												{
        													Indicator1JPanel.setXInziale(temporaryValue1);
        													i=temporaryValue1;
        													ripartenza[0]=0;
        												}

        												 //QUANDO SI MUOVE L'INDICATORE
        												 if((pauseforfirst==false && startforfirst ==false) || (pauseforfirst==false && startforfirst==true)) 
        												 {
        													Indicator1JPanel.moveForward();
        													
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar1JPanel.repaint();
        													Thread.sleep(10);
        												} 
        												catch (InterruptedException e1)
        												{
        													
        													e1.printStackTrace();
        												}
        											}
        										
        										}
        									});
        									
        									Thread threadmuovereIndicatore2 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											

        											// TODO Auto-generated method stub
        											for(int i=0; i<300; i++) 
        											{	
        												
        												if(i==299)
        													i=0;
        												
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 2 QUANDO INDICATORE 5 SI TROVA IN ZONA CRITICA
        												if((Indicator5JPanel.getX()>=iniziocritica1_5 && Indicator5JPanel.getX()<=finecritica1_5) ||
        														(Indicator5JPanel.getX()>=iniziocritica2_5 && Indicator5JPanel.getX()<=finecritica2_5) ||
        														(Indicator5JPanel.getX()>=iniziocritica3_5 && Indicator5JPanel.getX()<=finecritica3_5))
        												{
        													
        													//SE L'INDICATORE 2 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator2JPanel.getX()==iniziocritica1_2-1 || Indicator2JPanel.getX()==iniziocritica2_2-1 || 
        															Indicator2JPanel.getX()==iniziocritica3_2-1	) 
        													{
        														
        														pauseforsecond=true;
        														startforsecond=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforsecond==true)
        													{
            													pauseforsecond=false;
            													startforsecond=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforsecond=false;
        														startforsecond=false;
        													}
        														
        												} 
        												
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 2 QUANDO INDICATORE 4 SI TROVA IN ZONA CRITICA
        												else if((Indicator4JPanel.getX()>=iniziocritica1_4 && Indicator4JPanel.getX()<=finecritica1_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica2_4 && Indicator4JPanel.getX()<=finecritica2_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica3_4 && Indicator4JPanel.getX()<=finecritica3_4))
        												{
        													
        													//SE L'INDICATORE 2 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator2JPanel.getX()==iniziocritica1_2-1 || Indicator2JPanel.getX()==iniziocritica2_2-1 || 
        															Indicator2JPanel.getX()==iniziocritica3_2-1	) 
        													{
        														
        														pauseforsecond=true;
        														startforsecond=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforsecond==true)
        													{
            													pauseforsecond=false;
            													startforsecond=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforsecond=false;
        														startforsecond=false;
        													}
        														
        												} 
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 2 QUANDO INDICATORE 3 SI TROVA IN ZONA CRITICA
        												else if((Indicator3JPanel.getX()>=iniziocritica1_3 && Indicator3JPanel.getX()<=finecritica1_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica2_3 && Indicator3JPanel.getX()<=finecritica2_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica3_3 && Indicator3JPanel.getX()<=finecritica3_3))
        												{
        													
        													//SE L'INDICATORE 2 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator2JPanel.getX()==iniziocritica1_2-1 || Indicator2JPanel.getX()==iniziocritica2_2-1 || 
        															Indicator2JPanel.getX()==iniziocritica3_2-1	) 
        													{
        														
        														pauseforsecond=true;
        														startforsecond=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforsecond==true)
        													{
            													pauseforsecond=false;
            													startforsecond=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforsecond=false;
        														startforsecond=false;
        													}
        														
        												}        												

        												
        												//GESTIONE PAUSA PER INDICATORE 2 QUANDO INDICATORE 1 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE UNO SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator1JPanel.getX()>=iniziocritica1_1 && Indicator1JPanel.getX()<=finecritica1_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica2_1 && Indicator1JPanel.getX()<=finecritica2_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica3_1 && Indicator1JPanel.getX()<=finecritica3_1))
        												{
        													
        													//SE L'INDICATORE 2 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator2JPanel.getX()==iniziocritica1_2-1 || Indicator2JPanel.getX()==iniziocritica2_2-1 || 
        															Indicator2JPanel.getX()==iniziocritica3_2-1	) 
        													{
        														
        														pauseforsecond=true;
        														startforsecond=false;
            													
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforsecond==true)
        													{
            													pauseforsecond=false;
            													startforsecond=true;
        													}
        													//L'INDICATORE 2 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforsecond=false;
        														startforsecond=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 2 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforsecond=false;
        													startforsecond=false;
        												}
            											
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL SECONDO INDICATORE
        												if(iniziocritica1_2==Indicator2JPanel.getX() || iniziocritica2_2==Indicator2JPanel.getX() 
        														|| iniziocritica3_2==Indicator2JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL SECONDO INDICATORE
        												if(finecritica1_2==Indicator2JPanel.getX() || finecritica2_2==Indicator2JPanel.getX() 
        														|| finecritica3_2==Indicator2JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												
        										

        												//E' IL MOMENTO DI FERMARE IL SECONDO INDICATORE PERCHE' IL PRIMO
        												//O IL TERZO O IL QUARTO O IL QUINTO SONO IN ZONA CRITICA
        												if(pauseforsecond==true && startforsecond==false) {
        													temporaryValue2=Indicator2JPanel.getX();
        													Indicator2JPanel.Reset(temporaryValue2);
        													BaseProgressBar2JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue2=Indicator2JPanel.getX();
        													Indicator2JPanel.Reset(temporaryValue2);
        													BaseProgressBar2JPanel.repaint();
        													break;
        												}
        												
        												//LA X DELL'INDICATORE 2 HA RAGGIUNTO IL LIMITE DEI 300
        												else if (Indicator2JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator2JPanel.Reset(StartEndProcessi.get(1).inizioProcesso);
        												}
        												
        												//L'INDICE i HA RAGGIUNTO I 300 MA L'INDICATORE DUE SI TROVA IN PAUSA PER
        												//ZONA CRITICA DEL PRIMO INDICATORE O DEL TERZO O DEL QUARTO O DEL QUINTO
        												else if (i==299 && pauseforsecond==true) 
        												{
        													i=0;
        													Indicator2JPanel.Reset(Indicator2JPanel.getX());
        												}
        											
        												//IL SECONDO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[1]==1) 
        												{
        													Indicator2JPanel.setXInziale(temporaryValue2);
        													i=temporaryValue2;
        													ripartenza[1]=0;
        												}

        												 if((pauseforsecond==false && startforsecond==false) || (pauseforsecond==false && startforsecond==true)) {
        													Indicator2JPanel.moveForward();
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar2JPanel.repaint();
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
        									
        									
        									Thread threadmuovereIndicatore3 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											
        											for(int i=0; i<300; i++) 
        											{	
        												if(i==299)
        													i=0;
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 3 QUANDO INDICATORE 5 SI TROVA IN ZONA CRITICA
        												if((Indicator5JPanel.getX()>=iniziocritica1_5 && Indicator5JPanel.getX()<=finecritica1_5) ||
        														(Indicator5JPanel.getX()>=iniziocritica2_5 && Indicator5JPanel.getX()<=finecritica2_5) ||
        														(Indicator5JPanel.getX()>=iniziocritica3_5 && Indicator5JPanel.getX()<=finecritica3_5))
        												
        												{
        													
        													//SE L'INDICATORE 3 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator3JPanel.getX()==iniziocritica1_3-1 || Indicator3JPanel.getX()==iniziocritica2_3-1 || 
        															Indicator3JPanel.getX()==iniziocritica3_3-1	) 
        													{
        														
        														pauseforthird=true;
        														startforthird=false;
            													
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforthird==true)
        													{
            													pauseforthird=false;
            													startforthird=true;
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforthird=false;
        														startforthird=false;
        													}
        														
        												} 
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 3 QUANDO INDICATORE 4 SI TROVA IN ZONA CRITICA
        												else if((Indicator4JPanel.getX()>=iniziocritica1_4 && Indicator4JPanel.getX()<=finecritica1_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica2_4 && Indicator4JPanel.getX()<=finecritica2_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica3_4 && Indicator4JPanel.getX()<=finecritica3_4))
        												{
        													
        													//SE L'INDICATORE 3 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator3JPanel.getX()==iniziocritica1_3-1 || Indicator3JPanel.getX()==iniziocritica2_3-1 || 
        															Indicator3JPanel.getX()==iniziocritica3_3-1	) 
        													{
        														
        														pauseforthird=true;
        														startforthird=false;
            													
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforthird==true)
        													{
            													pauseforthird=false;
            													startforthird=true;
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforthird=false;
        														startforthird=false;
        													}
        														
        												} 
        												        												
        												//GESTIONE PAUSA PER INDICATORE 3 QUANDO INDICATORE 1 SI TROVA IN ZONA CRITICA
        												else if((Indicator1JPanel.getX()>=iniziocritica1_1 && Indicator1JPanel.getX()<=finecritica1_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica2_1 && Indicator1JPanel.getX()<=finecritica2_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica3_1 && Indicator1JPanel.getX()<=finecritica3_1))
        												{
        													
        													//SE L'INDICATORE 3 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator3JPanel.getX()==iniziocritica1_3-1 || Indicator3JPanel.getX()==iniziocritica2_3-1 || 
        															Indicator3JPanel.getX()==iniziocritica3_3-1	) 
        													{
        														
        														pauseforthird=true;
        														startforthird=false;
            													
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforthird=false;
            													startforthird=true;
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforthird=false;
        														startforthird=false;
        													}
        														
        												}
        												        												
        												//GESTIONE PAUSA PER INDICATORE 3 QUANDO INDICATORE 2 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE 2 SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator2JPanel.getX()>=iniziocritica1_2 && Indicator2JPanel.getX()<=finecritica1_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica2_2 && Indicator2JPanel.getX()<=finecritica2_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica3_2 && Indicator2JPanel.getX()<=finecritica3_2))
        												{
        													
        													//SE L'INDICATORE 3 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator3JPanel.getX()==iniziocritica1_3-1 || Indicator3JPanel.getX()==iniziocritica2_3-1 || 
        															Indicator3JPanel.getX()==iniziocritica3_3-1	) 
        													{
        														
        														pauseforthird=true;
        														startforthird=false;
            													
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfirst==true)
        													{
            													pauseforthird=false;
            													startforthird=true;
        													}
        													//L'INDICATORE 3 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforthird=false;
        														startforthird=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 3 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforthird=false;
        													startforthird=false;
        												}
        													
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL TERZO INDICATORE
        												if(iniziocritica1_3==Indicator3JPanel.getX() || iniziocritica2_3==Indicator3JPanel.getX() 
        														|| iniziocritica3_3==Indicator3JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL TERZO INDICATORE
        												if(finecritica1_3==Indicator3JPanel.getX() || finecritica2_3==Indicator3JPanel.getX() 
        														|| finecritica3_3==Indicator3JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												//E' IL MOMENTO DI FERMARE IL TERZO INDICATORE PERCHE' IL SECONDO O IL PRIMO SONO IN ZONA CRITICA
        												if(pauseforthird==true && startforthird==false) {
        													temporaryValue3=Indicator3JPanel.getX();
        													Indicator3JPanel.Reset(temporaryValue3);
        													BaseProgressBar3JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue3=Indicator3JPanel.getX();
        													Indicator3JPanel.Reset(temporaryValue3);
        													BaseProgressBar3JPanel.repaint();
        													break;
        												}

        												//IL TERZO INDICATORE HA RAGGIUNTO IL LIMITE X DEI 300
        												else if (Indicator3JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator3JPanel.Reset(StartEndProcessi.get(2).inizioProcesso);
        												}
        												
        												//L'INDICE i DEL TERZO INDICATORE E' ARRIVATO A 300 MA
        												//SI TROVA IN PAUSA PER ZONA CRITICA DEL SECONDO O PRIMO
        												else if (i==299 && pauseforthird==true) 
        												{
        													i=0;
        													Indicator3JPanel.Reset(temporaryValue3);
        												}
        											
        												
        												//IL TERZO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[2]==1) 
        												{
        													Indicator3JPanel.setXInziale(temporaryValue3);
        													i=temporaryValue3;
        													ripartenza[2]=0;
        												}

        												//QUANDO SI MUOVE L'INDICATORE
        												 if((pauseforthird==false && startforthird ==false) || (pauseforthird==false && startforthird==true)) 
        												 {
        													Indicator3JPanel.moveForward();
        													
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar3JPanel.repaint();
        													Thread.sleep(10);
        												} 
        												catch (InterruptedException e1)
        												{
        													
        													e1.printStackTrace();
        												}
        											}
        										
        										}
        									});
        									
        								
        									Thread threadmuovereIndicatore4 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											
        											for(int i=0; i<300; i++) 
        											{	
        												if(i==299)
        													i=0;
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 4 QUANDO INDICATORE 5 SI TROVA IN ZONA CRITICA
        												if((Indicator5JPanel.getX()>=iniziocritica1_5 && Indicator5JPanel.getX()<=finecritica1_5) ||
        														(Indicator5JPanel.getX()>=iniziocritica2_5 && Indicator5JPanel.getX()<=finecritica2_5) ||
        														(Indicator5JPanel.getX()>=iniziocritica3_5 && Indicator5JPanel.getX()<=finecritica3_5))
        												
        												{
        													
        													//SE L'INDICATORE 4 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator4JPanel.getX()==iniziocritica1_4-1 || Indicator4JPanel.getX()==iniziocritica2_4-1 || 
        															Indicator4JPanel.getX()==iniziocritica3_4-1	) 
        													{
        														
        														pauseforfourth=true;
        														startforfourth=false;
            													
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfourth==true)
        													{
            													pauseforfourth=false;
            													startforfourth=true;
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfourth=false;
        														startforfourth=false;
        													}
        														
        												} 

        												
        												//GESTIONE PAUSA PER INDICATORE 4 QUANDO INDICATORE 3 SI TROVA IN ZONA CRITICA
        												else if((Indicator3JPanel.getX()>=iniziocritica1_3 && Indicator3JPanel.getX()<=finecritica1_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica2_3 && Indicator3JPanel.getX()<=finecritica2_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica3_3 && Indicator3JPanel.getX()<=finecritica3_3))
        												{
        													
        													//SE L'INDICATORE 4 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator4JPanel.getX()==iniziocritica1_4-1 || Indicator4JPanel.getX()==iniziocritica2_4-1 || 
        															Indicator4JPanel.getX()==iniziocritica3_4-1	) 
        													{
        														
        														pauseforfourth=true;
        														startforfourth=false;
            													
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfourth==true)
        													{
            													pauseforfourth=false;
            													startforfourth=true;
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfourth=false;
        														startforfourth=false;
        													}
        														
        												} 
        												        												
        												//GESTIONE PAUSA PER INDICATORE 4 QUANDO INDICATORE 1 SI TROVA IN ZONA CRITICA
        												else if((Indicator1JPanel.getX()>=iniziocritica1_1 && Indicator1JPanel.getX()<=finecritica1_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica2_1 && Indicator1JPanel.getX()<=finecritica2_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica3_1 && Indicator1JPanel.getX()<=finecritica3_1))
        												{
        													
        													//SE L'INDICATORE 4 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator4JPanel.getX()==iniziocritica1_4-1 || Indicator4JPanel.getX()==iniziocritica2_4-1 || 
        															Indicator4JPanel.getX()==iniziocritica3_4-1	) 
        													{
        														
        														pauseforfourth=true;
        														startforfourth=false;
            													
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfourth==true)
        													{
            													pauseforfourth=false;
            													startforfourth=true;
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfourth=false;
        														startforfourth=false;
        													}
        														
        												}
        												        												
        												//GESTIONE PAUSA PER INDICATORE 4 QUANDO INDICATORE 2 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE 2 SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator2JPanel.getX()>=iniziocritica1_2 && Indicator2JPanel.getX()<=finecritica1_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica2_2 && Indicator2JPanel.getX()<=finecritica2_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica3_2 && Indicator2JPanel.getX()<=finecritica3_2))
        												{
        													
        													//SE L'INDICATORE 4 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator4JPanel.getX()==iniziocritica1_4-1 || Indicator4JPanel.getX()==iniziocritica2_4-1 || 
        															Indicator4JPanel.getX()==iniziocritica3_4-1	) 
        													{
        														
        														pauseforfourth=true;
        														startforfourth=false;
            													
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfourth==true)
        													{
            													pauseforfourth=false;
            													startforfourth=true;
        													}
        													//L'INDICATORE 4 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfourth=false;
        														startforfourth=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 4 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforfourth=false;
        													startforfourth=false;
        												}
        													
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL QUARTO INDICATORE
        												if(iniziocritica1_4==Indicator4JPanel.getX() || iniziocritica2_4==Indicator4JPanel.getX() 
        														|| iniziocritica3_4==Indicator4JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL QUARTO INDICATORE
        												if(finecritica1_4==Indicator4JPanel.getX() || finecritica2_4==Indicator4JPanel.getX() 
        														|| finecritica3_4==Indicator4JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												//E' IL MOMENTO DI FERMARE IL QUARTO INDICATORE PERCHE' IL SECONDO O IL PRIMO O IL TERZO SONO IN ZONA CRITICA
        												if(pauseforfourth==true && startforfourth==false) {
        													temporaryValue4=Indicator4JPanel.getX();
        													Indicator4JPanel.Reset(temporaryValue4);
        													BaseProgressBar4JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue4=Indicator4JPanel.getX();
        													Indicator4JPanel.Reset(temporaryValue4);
        													BaseProgressBar4JPanel.repaint();
        													break;
        												}

        												//IL QUARTO INDICATORE HA RAGGIUNTO IL LIMITE X DEI 300
        												else if (Indicator4JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator4JPanel.Reset(StartEndProcessi.get(3).inizioProcesso);
        												}
        												
        												//L'INDICE i DEL QUARTO INDICATORE E' ARRIVATO A 300 MA
        												//SI TROVA IN PAUSA PER ZONA CRITICA DEL SECONDO O PRIMO O TERZO
        												else if (i==299 && pauseforfourth==true) 
        												{
        													i=0;
        													Indicator4JPanel.Reset(temporaryValue4);
        												}
        											
        												
        												//IL QUARTO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[3]==1) 
        												{
        													Indicator4JPanel.setXInziale(temporaryValue4);
        													i=temporaryValue4;
        													ripartenza[3]=0;
        												}

        												//QUANDO SI MUOVE L'INDICATORE
        												 if((pauseforfourth==false && startforfourth ==false) || (pauseforfourth==false && startforfourth==true)) 
        												 {
        													Indicator4JPanel.moveForward();
        													
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar4JPanel.repaint();
        													Thread.sleep(10);
        												} 
        												catch (InterruptedException e1)
        												{
        													
        													e1.printStackTrace();
        												}
        											}
        										
        										}
        									});
        									
        									
        									Thread threadmuovereIndicatore5 = new Thread(new Runnable() {
        										@Override
        										public void run() 
        										{
        											
        											for(int i=0; i<300; i++) 
        											{	
        												if(i==299)
        													i=0;
        												
        												
        												//GESTIONE PAUSA PER INDICATORE 5 QUANDO INDICATORE 4 SI TROVA IN ZONA CRITICA
        												if((Indicator4JPanel.getX()>=iniziocritica1_4 && Indicator4JPanel.getX()<=finecritica1_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica2_4 && Indicator4JPanel.getX()<=finecritica2_4) ||
        														(Indicator4JPanel.getX()>=iniziocritica3_4 && Indicator4JPanel.getX()<=finecritica3_4))
        												
        												{
        													
        													//SE L'INDICATORE 5 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator5JPanel.getX()==iniziocritica1_5-1 || Indicator5JPanel.getX()==iniziocritica2_5-1 || 
        															Indicator5JPanel.getX()==iniziocritica3_5-1	) 
        													{
        														
        														pauseforfifth=true;
        														startforfifth=false;
            													
        													}
        													//L'INDICATORE 5 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfifth==true)
        													{
            													pauseforfifth=false;
            													startforfifth=true;
        													}
        													//L'INDICATORE 5 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfifth=false;
        														startforfifth=false;
        													}
        														
        												} 

        												
        												//GESTIONE PAUSA PER INDICATORE 5 QUANDO INDICATORE 3 SI TROVA IN ZONA CRITICA
        												else if((Indicator3JPanel.getX()>=iniziocritica1_3 && Indicator3JPanel.getX()<=finecritica1_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica2_3 && Indicator3JPanel.getX()<=finecritica2_3) ||
        														(Indicator3JPanel.getX()>=iniziocritica3_3 && Indicator3JPanel.getX()<=finecritica3_3))
        												{
        													
        													//SE L'INDICATORE 5 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator5JPanel.getX()==iniziocritica1_5-1 || Indicator5JPanel.getX()==iniziocritica2_5-1 || 
        															Indicator5JPanel.getX()==iniziocritica3_5-1	) 
        													{
        														
        														pauseforfifth=true;
        														startforfifth=false;
            													
        													}
        													//L'INDICATORE 5 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfifth==true)
        													{
            													pauseforfifth=false;
            													startforfifth=true;
        													}
        													//L'INDICATORE 5 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfifth=false;
        														startforfifth=false;
        													}
        														
        												} 
        												        												
        												//GESTIONE PAUSA PER INDICATORE 5 QUANDO INDICATORE 1 SI TROVA IN ZONA CRITICA
        												else if((Indicator1JPanel.getX()>=iniziocritica1_1 && Indicator1JPanel.getX()<=finecritica1_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica2_1 && Indicator1JPanel.getX()<=finecritica2_1) ||
        														(Indicator1JPanel.getX()>=iniziocritica3_1 && Indicator1JPanel.getX()<=finecritica3_1))
        												{
        													
        													//SE L'INDICATORE 5 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator5JPanel.getX()==iniziocritica1_5-1 || Indicator5JPanel.getX()==iniziocritica2_5-1 || 
        															Indicator5JPanel.getX()==iniziocritica3_5-1	) 
        													{
        														
        														pauseforfifth=true;
        														startforfifth=false;
            													
        													}
        													//L'INDICATORE 5 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfourth==true)
        													{
            													pauseforfifth=false;
            													startforfifth=true;
        													}
        													//L'INDICATORE 5 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfifth=false;
        														startforfifth=false;
        													}
        														
        												}
        												        												
        												//GESTIONE PAUSA PER INDICATORE 5 QUANDO INDICATORE 2 SI TROVA IN ZONA CRITICA
        												
        												//SE L'INDICATORE 2 SI TROVA IN UNA DELLE ZONE CRITICHE
        												else if((Indicator2JPanel.getX()>=iniziocritica1_2 && Indicator2JPanel.getX()<=finecritica1_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica2_2 && Indicator2JPanel.getX()<=finecritica2_2) ||
        														(Indicator2JPanel.getX()>=iniziocritica3_2 && Indicator2JPanel.getX()<=finecritica3_2))
        												{
        													
        													//SE L'INDICATORE 5 STA PER ENTRARE IN UNA ZONA CRITICA
        													if(Indicator5JPanel.getX()==iniziocritica1_5-1 || Indicator5JPanel.getX()==iniziocritica2_5-1 || 
        															Indicator5JPanel.getX()==iniziocritica3_5-1	) 
        													{
        														
        														pauseforfifth=true;
        														startforfifth=false;
            													
        													}
        													//L'INDICATORE 5 NON STA PER ENTRARE IN ZONA CRITICA MA STAVA IN PAUSA PER POI RIPARTIRE
        													else if(pauseforfifth==true)
        													{
            													pauseforfifth=false;
            													startforfifth=true;
        													}
        													//L'INDICATORE 5 NON STA PER ENTRARE IN ZONA CRITICA E NON ERA NEMMENO IN PAUSA
        													else 
        													{
        														pauseforfifth=false;
        														startforfifth=false;
        													}
        														
        												}
        												
        												
        												// ALTRIMENTI L'INDICATORE 5 PROCEDE SENZA MODIFICHE
        												else 
        												{
        													pauseforfifth=false;
        													startforfifth=false;
        												}
        													
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER INIZIO DELLE 3 ZONE CRITICHE DEL QUINTO INDICATORE
        												if(iniziocritica1_5==Indicator5JPanel.getX() || iniziocritica2_5==Indicator5JPanel.getX() 
        														|| iniziocritica3_5==Indicator5JPanel.getX()) 
        												{
        													
        													GraficaSemaforo1VerdeJLabel.setVisible(false);
        													GraficaSemaforo1RossoJLabel.setVisible(true);
        													JLabelTextMutex1_1.setVisible(false);
        													JLabelTextMutex1_0.setVisible(true);
        												}
        												
        												//GESTIONE CAMBIAMENTO COLORE SEMAFORO PER FINE DELLE 3 ZONE CRITICHE DEL QUINTO INDICATORE
        												if(finecritica1_5==Indicator5JPanel.getX() || finecritica2_5==Indicator5JPanel.getX() 
        														|| finecritica3_5==Indicator5JPanel.getX()) {
        													GraficaSemaforo1RossoJLabel.setVisible(false);
        													GraficaSemaforo1VerdeJLabel.setVisible(true);
        													JLabelTextMutex1_0.setVisible(false);
        													JLabelTextMutex1_1.setVisible(true);
        												}
        												
        												//E' IL MOMENTO DI FERMARE IL QUINTO INDICATORE PERCHE' IL SECONDO O IL PRIMO O IL TERZO
        												//O IL QUARTO SONO IN ZONA CRITICA
        												if(pauseforfifth==true && startforfifth==false) {
        													temporaryValue5=Indicator5JPanel.getX();
        													Indicator5JPanel.Reset(temporaryValue5);
        													BaseProgressBar5JPanel.repaint();

        												}
        												
        												//E' STATO PREMUTO IL TASTO DI PAUSA
        												if(timeToPause==true && timeToContinue==false)
        												{
        													temporaryValue5=Indicator5JPanel.getX();
        													Indicator5JPanel.Reset(temporaryValue5);
        													BaseProgressBar5JPanel.repaint();
        													break;
        												}

        												//IL QUINTO INDICATORE HA RAGGIUNTO IL LIMITE X DEI 300
        												else if (Indicator5JPanel.LimitReached()) 
        												{
        													i=0;
        													Indicator5JPanel.Reset(StartEndProcessi.get(4).inizioProcesso);
        												}
        												
        												//L'INDICE i DEL QUINTO INDICATORE E' ARRIVATO A 300 MA
        												//SI TROVA IN PAUSA PER ZONA CRITICA DEL SECONDO O PRIMO O TERZO O QUARTO
        												else if (i==299 && pauseforfifth==true) 
        												{
        													i=0;
        													Indicator5JPanel.Reset(temporaryValue5);
        												}
        											
        												
        												//IL QUINTO INDICATORE RIPARTE DALL'ULTIMA POSIZIONE DOPO CHE ERA STATO PREMUTO PAUSA
        												else if(ripartenza[4]==1) 
        												{
        													Indicator5JPanel.setXInziale(temporaryValue5);
        													i=temporaryValue5;
        													ripartenza[4]=0;
        												}

        												//QUANDO SI MUOVE L'INDICATORE
        												 if((pauseforfifth==false && startforfifth ==false) || (pauseforfifth==false && startforfifth==true)) 
        												 {
        													Indicator5JPanel.moveForward();
        													
        												}
        													
        												
        												try 
        												{
        													Thread.sleep(20);
        													BaseProgressBar5JPanel.repaint();
        													Thread.sleep(10);
        												} 
        												catch (InterruptedException e1)
        												{
        													
        													e1.printStackTrace();
        												}
        											}
        										
        										}
        									});
        									
        									
        									threadmuovereIndicatore1.start();
        									threadmuovereIndicatore2.start();
        									threadmuovereIndicatore3.start();
        									threadmuovereIndicatore4.start();
        									threadmuovereIndicatore5.start();
        								
        								}
        							
        								
        								
        								
        								//LA PAUSA
        								else if(!toggleButtonStartPause.isSelected() && NumProcessi!=0) 
        								{
        									System.out.println("[ToggleButton]: PAUSE");
        									timeToContinue=false;
        									timeToPause=true;
        									Arrays.fill(ripartenza, 1);
        									
        								}
        								
        								//CONDIZIONE DI ERRORE
        								else if(toggleButtonStartPause.isSelected() && NumProcessi==0) 
        								{
        									toggleButtonStartPause.setSelected(false);
        								    JOptionPane.showMessageDialog(new JFrame(), "Non e' possibile iniziare senza aver generato un esercizio!", "Start/Pause Error Dialog",
        								            JOptionPane.ERROR_MESSAGE);

        									timeToContinue=false;
        								}
        							}
	
        							
        							@Override
        							public void mouseEntered(MouseEvent e) 
        							{
        								toggleButtonStartPause.setBackground(Color.ORANGE);
        							}
        							@Override
        							public void mouseExited(MouseEvent e) {
        								toggleButtonStartPause.setBackground(Color.WHITE);
        							}
        						});
        						


								
        						
        						
        						//Time to Reset to the origin value 0
        						buttonReset.addMouseListener(new MouseAdapter() {
        							@Override
        							public void mouseClicked(MouseEvent e) 
        							{
        								int NumProcessi=StartEndProcessi.size();
        								
        								
        								//MESSAGGIO DI ERRORE
        								if(NumProcessi==0) 
        								{
        									JOptionPane.showMessageDialog(new JFrame(), "Non e' possibile resettare senza aver generato un esercizio!", "Reset Error Dialog",
        								            JOptionPane.ERROR_MESSAGE);
        								}
        								

        								else 
        								{
        									System.out.println("[ResetButton]: Reset effettuato");
        									timeToContinue=false;
        									timeToPause=true;
        									Arrays.fill(ripartenza,0);
        									

        									
        									//RESET DA INIZIO PROCESSO PER OGNI NUMERO PROCESSO
        									
        									if(NumProcessi>=1) 
        									{
        										Indicator1JPanel.Reset(StartEndProcessi.get(0).inizioProcesso);
        										
        										if(NumProcessi>=2) 
        										{
        											Indicator2JPanel.Reset(StartEndProcessi.get(1).inizioProcesso);
        											
        											if(NumProcessi>=3)
        											{
        												Indicator3JPanel.Reset(StartEndProcessi.get(2).inizioProcesso);
        												
        												if(NumProcessi>=4)
        												{
        													Indicator4JPanel.Reset(StartEndProcessi.get(3).inizioProcesso);
        													
        													if(NumProcessi==5)
        													{
        														Indicator5JPanel.Reset(StartEndProcessi.get(4).inizioProcesso);
        													}
        												}
        											}
        										}
        									}
        									
        								
        									//IN OGNI CASO REPAINT DI TUTTI I COMPONENTI
        									
        									BaseProgressBar1JPanel.repaint();
        									BaseProgressBar2JPanel.repaint();
        									BaseProgressBar3JPanel.repaint();
        									BaseProgressBar4JPanel.repaint();
        									BaseProgressBar5JPanel.repaint();
        									
        									//METTO IL PULSANTE START IN PAUSE
        									toggleButtonStartPause.setSelected(false);
        									
        									//ABILITO I SELETTORI DI MODIFICA NUM PROCESSI E NUM SEMAFORI
        									NumProcessiComboBox.setEnabled(true);
        									NumSemaforiComboBox.setEnabled(true);
        									
        									
        									
        									
        									//SEMAFORI
											GraficaSemaforo1RossoJLabel.setVisible(false);
											GraficaSemaforo1VerdeJLabel.setVisible(true);
											JLabelTextMutex1_0.setVisible(false);
											JLabelTextMutex1_1.setVisible(true);
        			
        								}

        							}
        							@Override
        							public void mouseEntered(MouseEvent e) 
        							{
        								
        								buttonReset.setBackground(Color.ORANGE);
        							}
        							@Override
        							public void mouseExited(MouseEvent e) {
        								buttonReset.setBackground(Color.WHITE);
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
					
					Arrays.fill(ripartenza, 0);
					GraficaSemaforo1RossoJLabel.setVisible(false);
					GraficaSemaforo1VerdeJLabel.setVisible(true);
					JLabelTextMutex1_0.setVisible(false);
					JLabelTextMutex1_1.setVisible(true);

					if(rowCount==1) 
					{
						Indicator1JPanel.Reset(0);
						Indicator1JPanel.repaint();
					}
					else if(rowCount==2)
					{
						Indicator1JPanel.Reset(0);
						Indicator1JPanel.repaint();
						Indicator2JPanel.Reset(0);
						Indicator2JPanel.repaint();
					}else if(rowCount==3)
					{
						Indicator1JPanel.Reset(0);
						Indicator1JPanel.repaint();
						Indicator2JPanel.Reset(0);
						Indicator2JPanel.repaint();
						Indicator3JPanel.Reset(0);
						Indicator3JPanel.repaint();
					}else if(rowCount==4)
					{
						Indicator1JPanel.Reset(0);
						Indicator1JPanel.repaint();
						Indicator2JPanel.Reset(0);
						Indicator2JPanel.repaint();
						Indicator3JPanel.Reset(0);
						Indicator3JPanel.repaint();
						Indicator4JPanel.Reset(0);
						Indicator4JPanel.repaint();
					}else if(rowCount==5) {
						Indicator1JPanel.Reset(0);
						Indicator1JPanel.repaint();
						Indicator2JPanel.Reset(0);
						Indicator2JPanel.repaint();
						Indicator3JPanel.Reset(0);
						Indicator3JPanel.repaint();
						Indicator4JPanel.Reset(0);
						Indicator4JPanel.repaint();
						Indicator5JPanel.Reset(0);
						Indicator5JPanel.repaint();
					}
					
					timeToContinue=true;
					timeToReset=false;
					timeToPause=false;
					timeToRestartFromPause=false;
					
					StartEndProcessi.removeAll(StartEndProcessi);
					

						

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
						CriticalArea1JPanel1.setVisible(false);
						CriticalArea1JPanel2.setVisible(false);
						CriticalArea1JPanel3.setVisible(false);
						CriticalArea1JPanel4.setVisible(false);
						CriticalArea1JPanel5.setVisible(false);
						CriticalArea2JPanel1.setVisible(false);
						CriticalArea2JPanel2.setVisible(false);
						CriticalArea2JPanel3.setVisible(false);
						CriticalArea2JPanel4.setVisible(false);
						CriticalArea2JPanel5.setVisible(false);
						CriticalArea3JPanel1.setVisible(false);
						CriticalArea3JPanel2.setVisible(false);
						CriticalArea3JPanel3.setVisible(false);
						CriticalArea3JPanel4.setVisible(false);
						CriticalArea3JPanel5.setVisible(false);
						
						
					
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
						CriticalArea1JPanel1.setVisible(false);
						CriticalArea1JPanel2.setVisible(false);
						CriticalArea1JPanel3.setVisible(false);
						CriticalArea1JPanel4.setVisible(false);
						CriticalArea1JPanel5.setVisible(false);
						CriticalArea2JPanel1.setVisible(false);
						CriticalArea2JPanel2.setVisible(false);
						CriticalArea2JPanel3.setVisible(false);
						CriticalArea2JPanel4.setVisible(false);
						CriticalArea2JPanel5.setVisible(false);
						CriticalArea3JPanel1.setVisible(false);
						CriticalArea3JPanel2.setVisible(false);
						CriticalArea3JPanel3.setVisible(false);
						CriticalArea3JPanel4.setVisible(false);
						CriticalArea3JPanel5.setVisible(false);
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
						CriticalArea1JPanel1.setVisible(false);
						CriticalArea1JPanel2.setVisible(false);
						CriticalArea1JPanel3.setVisible(false);
						CriticalArea1JPanel4.setVisible(false);
						CriticalArea1JPanel5.setVisible(false);
						CriticalArea2JPanel1.setVisible(false);
						CriticalArea2JPanel2.setVisible(false);
						CriticalArea2JPanel3.setVisible(false);
						CriticalArea2JPanel4.setVisible(false);
						CriticalArea2JPanel5.setVisible(false);
						CriticalArea3JPanel1.setVisible(false);
						CriticalArea3JPanel2.setVisible(false);
						CriticalArea3JPanel3.setVisible(false);
						CriticalArea3JPanel4.setVisible(false);
						CriticalArea3JPanel5.setVisible(false);
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
						CriticalArea1JPanel1.setVisible(false);
						CriticalArea1JPanel2.setVisible(false);
						CriticalArea1JPanel3.setVisible(false);
						CriticalArea1JPanel4.setVisible(false);
						CriticalArea1JPanel5.setVisible(false);
						CriticalArea2JPanel1.setVisible(false);
						CriticalArea2JPanel2.setVisible(false);
						CriticalArea2JPanel3.setVisible(false);
						CriticalArea2JPanel4.setVisible(false);
						CriticalArea2JPanel5.setVisible(false);
						CriticalArea3JPanel1.setVisible(false);
						CriticalArea3JPanel2.setVisible(false);
						CriticalArea3JPanel3.setVisible(false);
						CriticalArea3JPanel4.setVisible(false);
						CriticalArea3JPanel5.setVisible(false);
					}
					//pippo
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
						CriticalArea1JPanel1.setVisible(false);
						CriticalArea1JPanel2.setVisible(false);
						CriticalArea1JPanel3.setVisible(false);
						CriticalArea1JPanel4.setVisible(false);
						CriticalArea1JPanel5.setVisible(false);
						CriticalArea2JPanel1.setVisible(false);
						CriticalArea2JPanel2.setVisible(false);
						CriticalArea2JPanel3.setVisible(false);
						CriticalArea2JPanel4.setVisible(false);
						CriticalArea2JPanel5.setVisible(false);
						CriticalArea3JPanel1.setVisible(false);
						CriticalArea3JPanel2.setVisible(false);
						CriticalArea3JPanel3.setVisible(false);
						CriticalArea3JPanel4.setVisible(false);
						CriticalArea3JPanel5.setVisible(false);
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
        							GraficaSemaforo2VerdeJLabel.setVisible(true);
        							JLabelTextMutex2_1.setVisible(true);
        							//Disattivo il secondo
        							GraficaSemaforo2VerdeJLabel.setVisible(false);
        							JLabelTextMutex2_1.setVisible(false);
        						}
        						else if(numeroSemaforiInt==2)
        						{

        							//Abilito anche il secondo semaforo 
        							GraficaSemaforo2VerdeJLabel.setVisible(true);
        							JLabelTextMutex2_1.setVisible(true);
        						}
        							
        					}
        				});
        

     
        
 
        
       

	        
	    
	           
	        
//------------------------------------------------------------------------------------------------
//								ACTIONS PERFORMED
//------------------------------------------------------------------------------------------------	        
	        
	        
	        

	        GeneraEsercizioJButton.addMouseListener(new MouseAdapter() {
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
					
					
					
				//non possono essere generati esercizi mentre ci sono esercizi in esecuzione
				if(!toggleButtonStartPause.isSelected()) {

					StartEndProcessi.removeAll(StartEndProcessi);
					Arrays.fill(ripartenza, 0);

					GraficaSemaforo1RossoJLabel.setVisible(false);
					GraficaSemaforo1VerdeJLabel.setVisible(true);
					JLabelTextMutex1_0.setVisible(false);
					JLabelTextMutex1_1.setVisible(true);
					
					//ripartono gli indacatori da capo
					
					if(rowCount==1) {
						Indicator1JPanel.Reset(0);
						Indicator1JPanel.repaint();
					}else if(rowCount==2) {
						Indicator1JPanel.Reset(0);
						Indicator1JPanel.repaint();
						Indicator2JPanel.Reset(0);
						Indicator2JPanel.repaint();
					}else if(rowCount==3) {
						Indicator1JPanel.Reset(0);
						Indicator1JPanel.repaint();
						Indicator2JPanel.Reset(0);
						Indicator2JPanel.repaint();
						Indicator3JPanel.Reset(0);
						Indicator3JPanel.repaint();
					}else if(rowCount==4) {
						Indicator1JPanel.Reset(0);
						Indicator1JPanel.repaint();
						Indicator2JPanel.Reset(0);
						Indicator2JPanel.repaint();
						Indicator3JPanel.Reset(0);
						Indicator3JPanel.repaint();
						Indicator4JPanel.Reset(0);
						Indicator4JPanel.repaint();
					}else if(rowCount==5) {
						Indicator1JPanel.Reset(0);
						Indicator1JPanel.repaint();
						Indicator2JPanel.Reset(0);
						Indicator2JPanel.repaint();
						Indicator3JPanel.Reset(0);
						Indicator3JPanel.repaint();
						Indicator4JPanel.Reset(0);
						Indicator4JPanel.repaint();
						Indicator5JPanel.Reset(0);
						Indicator5JPanel.repaint();
					}
					timeToContinue=true;
					timeToReset=false;
					timeToPause=false;
					timeToRestartFromPause=false;
					
					
					
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
								do {
									randomNum= ThreadLocalRandom.current().nextInt(250,280);
								}while(randomNum>=end_processo);
									
								
								
								
								StartEndProcessi.get(StartEndProcessi.size() - 1).fineZonaCritica3=randomNum;
								
							}
							
							model1.setValueAt(randomNum, i, j);
							randomNum=0;
					}//second for
							
	        }//first for
					
					
			//INSERIMENTO GRAFICA VERDE E ROSSA SULLE BARRE DEI PROCESSI

			if(rowCount==1)
			{
				//Repaint di P1
			/*	BaseProgressBar1JPanel.removeAll();
				BaseProgressBar1JPanel.repaint();
			*/
				
				
		        //Critical Area 1 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(0).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar1JPanel.add(CriticalArea1JPanel1);
				CriticalArea1JPanel1.setVisible(true);
	        
				
				
				
				//Critical Area 2 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(0).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar1JPanel.add(CriticalArea2JPanel1);
				CriticalArea2JPanel1.setVisible(true);
				
				//Critical Area 2 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(0).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar1JPanel.add(CriticalArea3JPanel1);
				CriticalArea3JPanel1.setVisible(true);
				
				//Job Duration 1
				startpoint=StartEndProcessi.get(0).inizioProcesso;
				endpoint=StartEndProcessi.get(0).fineProcesso;
				System.out.println("[INIZIO] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration1JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar1JPanel.add(JobDuration1JPanel);
		        JobDuration1JPanel.setVisible(true);
		       
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
						
				
		       
				//Critical Area 1 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(0).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar1JPanel.add(CriticalArea1JPanel1);
				CriticalArea1JPanel1.setVisible(true);
	        
				
				
				
				//Critical Area 2 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(0).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar1JPanel.add(CriticalArea2JPanel1);
				CriticalArea2JPanel1.setVisible(true);
				
				//Critical Area 2 JPanel 1
				startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(0).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar1JPanel.add(CriticalArea3JPanel1);
				CriticalArea3JPanel1.setVisible(true);
				
				//Job Duration 1
				startpoint=StartEndProcessi.get(0).inizioProcesso;
				endpoint=StartEndProcessi.get(0).fineProcesso;
				System.out.println("[INIZIO] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration1JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar1JPanel.add(JobDuration1JPanel);
		        JobDuration1JPanel.setVisible(true);
		        //PROCESSO 2 !!!
				
						
				
		        //Critical Area 1 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(1).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar2JPanel.add(CriticalArea1JPanel2);
				CriticalArea1JPanel2.setVisible(true);
	        
				//Critical Area 2 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(1).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar2JPanel.add(CriticalArea2JPanel2);
				CriticalArea2JPanel2.setVisible(true);
				
				//Critical Area 3 JPanel 2
				startpoint=StartEndProcessi.get(1).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(1).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar2JPanel.add(CriticalArea3JPanel2);
				CriticalArea3JPanel2.setVisible(true);
				
				//Job Duration 2
				startpoint=StartEndProcessi.get(1).inizioProcesso;
				endpoint=StartEndProcessi.get(1).fineProcesso;
				System.out.println("[INIZIO P2] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration2JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar2JPanel.add(JobDuration2JPanel);
		        JobDuration2JPanel.setVisible(true);
		       
		     
			}
			
			else if(rowCount==3)
			{
				//Repaint di P1 e P2
				
				/*	BaseProgressBar1JPanel.removeAll();
					BaseProgressBar1JPanel.repaint();
					BaseProgressBar2JPanel.removeAll();
					BaseProgressBar2JPanel.repaint();
					
				*/
			
					//PROCESSO 1 !!!
							
					
			       
					//Critical Area 1 JPanel 1
					startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
					endpoint=StartEndProcessi.get(0).fineZonaCritica1;
					System.out.println("[ZONA CRITICA 1] : Valori in posizione: " +startpoint + " e "+endpoint);				
					CriticalArea1JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(CriticalArea1JPanel1);
					CriticalArea1JPanel1.setVisible(true);
		        
					
					
					
					//Critical Area 2 JPanel 1
					startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
					endpoint=StartEndProcessi.get(0).fineZonaCritica2;
					System.out.println("[ZONA CRITICA 2] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea2JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(CriticalArea2JPanel1);
					CriticalArea2JPanel1.setVisible(true);
					
					//Critical Area 2 JPanel 1
					startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
					endpoint=StartEndProcessi.get(0).fineZonaCritica3;
					System.out.println("[ZONA CRITICA 3] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea3JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(CriticalArea3JPanel1);
					CriticalArea3JPanel1.setVisible(true);
					
					//Job Duration 1
					startpoint=StartEndProcessi.get(0).inizioProcesso;
					endpoint=StartEndProcessi.get(0).fineProcesso;
					System.out.println("[INIZIO] : Valori in posizione: " +startpoint + " e "+endpoint);			
					JobDuration1JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(JobDuration1JPanel);
			        JobDuration1JPanel.setVisible(true);
			        //PROCESSO 2 !!!
					
							
					
			        //Critical Area 1 JPanel 2
					startpoint=StartEndProcessi.get(1).inizioZonaCritica1;
					endpoint=StartEndProcessi.get(1).fineZonaCritica1;
					System.out.println("[ZONA CRITICA 1 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);				
					CriticalArea1JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar2JPanel.add(CriticalArea1JPanel2);
					CriticalArea1JPanel2.setVisible(true);
		        
					//Critical Area 2 JPanel 2
					startpoint=StartEndProcessi.get(1).inizioZonaCritica2;
					endpoint=StartEndProcessi.get(1).fineZonaCritica2;
					System.out.println("[ZONA CRITICA 2 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea2JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar2JPanel.add(CriticalArea2JPanel2);
					CriticalArea2JPanel2.setVisible(true);
					
					//Critical Area 3 JPanel 2
					startpoint=StartEndProcessi.get(1).inizioZonaCritica3;
					endpoint=StartEndProcessi.get(1).fineZonaCritica3;
					System.out.println("[ZONA CRITICA 3 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea3JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar2JPanel.add(CriticalArea3JPanel2);
					CriticalArea3JPanel2.setVisible(true);
					
					//Job Duration 2
					startpoint=StartEndProcessi.get(1).inizioProcesso;
					endpoint=StartEndProcessi.get(1).fineProcesso;
					System.out.println("[INIZIO P2] : Valori in posizione: " +startpoint + " e "+endpoint);			
					JobDuration2JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
			        BaseProgressBar2JPanel.add(JobDuration2JPanel);
			        JobDuration2JPanel.setVisible(true);
				
				
				//PROCESSO 3 !!!
				
				
		       
		        //Critical Area 1 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(2).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar3JPanel.add(CriticalArea1JPanel3);
				CriticalArea1JPanel3.setVisible(true);
	        
				//Critical Area 2 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(2).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar3JPanel.add(CriticalArea2JPanel3);
				CriticalArea2JPanel3.setVisible(true);
				
				//Critical Area 3 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(2).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar3JPanel.add(CriticalArea3JPanel3);
				CriticalArea3JPanel3.setVisible(true);
				
				//Job Duration 3
				startpoint=StartEndProcessi.get(2).inizioProcesso;
				endpoint=StartEndProcessi.get(2).fineProcesso;
				System.out.println("[INIZIO P3] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration3JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar3JPanel.add(JobDuration3JPanel);
		        JobDuration3JPanel.setVisible(true);
		     
			}
			else if(rowCount==4)
			{
//Repaint di P1 e P2
				
				/*	BaseProgressBar1JPanel.removeAll();
					BaseProgressBar1JPanel.repaint();
					BaseProgressBar2JPanel.removeAll();
					BaseProgressBar2JPanel.repaint();
					
				*/
			
					//PROCESSO 1 !!!
							
					
			       
					//Critical Area 1 JPanel 1
					startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
					endpoint=StartEndProcessi.get(0).fineZonaCritica1;
					System.out.println("[ZONA CRITICA 1] : Valori in posizione: " +startpoint + " e "+endpoint);				
					CriticalArea1JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(CriticalArea1JPanel1);
					CriticalArea1JPanel1.setVisible(true);
		        
					
					
					
					//Critical Area 2 JPanel 1
					startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
					endpoint=StartEndProcessi.get(0).fineZonaCritica2;
					System.out.println("[ZONA CRITICA 2] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea2JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(CriticalArea2JPanel1);
					CriticalArea2JPanel1.setVisible(true);
					
					//Critical Area 2 JPanel 1
					startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
					endpoint=StartEndProcessi.get(0).fineZonaCritica3;
					System.out.println("[ZONA CRITICA 3] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea3JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(CriticalArea3JPanel1);
					CriticalArea3JPanel1.setVisible(true);
					
					//Job Duration 1
					startpoint=StartEndProcessi.get(0).inizioProcesso;
					endpoint=StartEndProcessi.get(0).fineProcesso;
					System.out.println("[INIZIO] : Valori in posizione: " +startpoint + " e "+endpoint);			
					JobDuration1JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(JobDuration1JPanel);
			        JobDuration1JPanel.setVisible(true);
			        //PROCESSO 2 !!!
					
							
					
			        //Critical Area 1 JPanel 2
					startpoint=StartEndProcessi.get(1).inizioZonaCritica1;
					endpoint=StartEndProcessi.get(1).fineZonaCritica1;
					System.out.println("[ZONA CRITICA 1 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);				
					CriticalArea1JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar2JPanel.add(CriticalArea1JPanel2);
					CriticalArea1JPanel2.setVisible(true);
		        
					//Critical Area 2 JPanel 2
					startpoint=StartEndProcessi.get(1).inizioZonaCritica2;
					endpoint=StartEndProcessi.get(1).fineZonaCritica2;
					System.out.println("[ZONA CRITICA 2 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea2JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar2JPanel.add(CriticalArea2JPanel2);
					CriticalArea2JPanel2.setVisible(true);
					
					//Critical Area 3 JPanel 2
					startpoint=StartEndProcessi.get(1).inizioZonaCritica3;
					endpoint=StartEndProcessi.get(1).fineZonaCritica3;
					System.out.println("[ZONA CRITICA 3 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea3JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar2JPanel.add(CriticalArea3JPanel2);
					CriticalArea3JPanel2.setVisible(true);
					
					//Job Duration 2
					startpoint=StartEndProcessi.get(1).inizioProcesso;
					endpoint=StartEndProcessi.get(1).fineProcesso;
					System.out.println("[INIZIO P2] : Valori in posizione: " +startpoint + " e "+endpoint);			
					JobDuration2JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
			        BaseProgressBar2JPanel.add(JobDuration2JPanel);
			        JobDuration2JPanel.setVisible(true);
				
				
				//PROCESSO 3 !!!
				
				
		       
		        //Critical Area 1 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(2).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar3JPanel.add(CriticalArea1JPanel3);
				CriticalArea1JPanel3.setVisible(true);
	        
				//Critical Area 2 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(2).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar3JPanel.add(CriticalArea2JPanel3);
				CriticalArea2JPanel3.setVisible(true);
				
				//Critical Area 3 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(2).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar3JPanel.add(CriticalArea3JPanel3);
				CriticalArea3JPanel3.setVisible(true);
				
				//Job Duration 3
				startpoint=StartEndProcessi.get(2).inizioProcesso;
				endpoint=StartEndProcessi.get(2).fineProcesso;
				System.out.println("[INIZIO P3] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration3JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar3JPanel.add(JobDuration3JPanel);
		        JobDuration3JPanel.setVisible(true);
		     
				
				//PROCESSO 4 !!!
				
				
		       
		        //Critical Area 1 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(3).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar4JPanel.add(CriticalArea1JPanel4);
				CriticalArea1JPanel4.setVisible(true);
	        
				//Critical Area 2 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(3).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar4JPanel.add(CriticalArea2JPanel4);
				CriticalArea2JPanel4.setVisible(true);
				
				//Critical Area 3 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(3).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar4JPanel.add(CriticalArea3JPanel4);
				CriticalArea3JPanel4.setVisible(true);

				//Job Duration 4
				startpoint=StartEndProcessi.get(3).inizioProcesso;
				endpoint=StartEndProcessi.get(3).fineProcesso;
				System.out.println("[INIZIO P4] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration4JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar4JPanel.add(JobDuration4JPanel);
		        JobDuration4JPanel.setVisible(true);
			}
			else if(rowCount==5)
			{
//Repaint di P1 e P2
				
				/*	BaseProgressBar1JPanel.removeAll();
					BaseProgressBar1JPanel.repaint();
					BaseProgressBar2JPanel.removeAll();
					BaseProgressBar2JPanel.repaint();
					
				*/
			
					//PROCESSO 1 !!!
							
					
			       
					//Critical Area 1 JPanel 1
					startpoint=StartEndProcessi.get(0).inizioZonaCritica1;
					endpoint=StartEndProcessi.get(0).fineZonaCritica1;
					System.out.println("[ZONA CRITICA 1] : Valori in posizione: " +startpoint + " e "+endpoint);				
					CriticalArea1JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(CriticalArea1JPanel1);
					CriticalArea1JPanel1.setVisible(true);
		        
					
					
					
					//Critical Area 2 JPanel 1
					startpoint=StartEndProcessi.get(0).inizioZonaCritica2;
					endpoint=StartEndProcessi.get(0).fineZonaCritica2;
					System.out.println("[ZONA CRITICA 2] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea2JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(CriticalArea2JPanel1);
					CriticalArea2JPanel1.setVisible(true);
					
					//Critical Area 2 JPanel 1
					startpoint=StartEndProcessi.get(0).inizioZonaCritica3;
					endpoint=StartEndProcessi.get(0).fineZonaCritica3;
					System.out.println("[ZONA CRITICA 3] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea3JPanel1.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(CriticalArea3JPanel1);
					CriticalArea3JPanel1.setVisible(true);
					
					//Job Duration 1
					startpoint=StartEndProcessi.get(0).inizioProcesso;
					endpoint=StartEndProcessi.get(0).fineProcesso;
					System.out.println("[INIZIO] : Valori in posizione: " +startpoint + " e "+endpoint);			
					JobDuration1JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar1JPanel.add(JobDuration1JPanel);
			        JobDuration1JPanel.setVisible(true);
			        //PROCESSO 2 !!!
					
							
					
			        //Critical Area 1 JPanel 2
					startpoint=StartEndProcessi.get(1).inizioZonaCritica1;
					endpoint=StartEndProcessi.get(1).fineZonaCritica1;
					System.out.println("[ZONA CRITICA 1 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);				
					CriticalArea1JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar2JPanel.add(CriticalArea1JPanel2);
					CriticalArea1JPanel2.setVisible(true);
		        
					//Critical Area 2 JPanel 2
					startpoint=StartEndProcessi.get(1).inizioZonaCritica2;
					endpoint=StartEndProcessi.get(1).fineZonaCritica2;
					System.out.println("[ZONA CRITICA 2 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea2JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar2JPanel.add(CriticalArea2JPanel2);
					CriticalArea2JPanel2.setVisible(true);
					
					//Critical Area 3 JPanel 2
					startpoint=StartEndProcessi.get(1).inizioZonaCritica3;
					endpoint=StartEndProcessi.get(1).fineZonaCritica3;
					System.out.println("[ZONA CRITICA 3 di P2] : Valori in posizione: " +startpoint + " e "+endpoint);
					CriticalArea3JPanel2.setBounds(startpoint, 0, endpoint-startpoint, 29);
					BaseProgressBar2JPanel.add(CriticalArea3JPanel2);
					CriticalArea3JPanel2.setVisible(true);
					
					//Job Duration 2
					startpoint=StartEndProcessi.get(1).inizioProcesso;
					endpoint=StartEndProcessi.get(1).fineProcesso;
					System.out.println("[INIZIO P2] : Valori in posizione: " +startpoint + " e "+endpoint);			
					JobDuration2JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
			        BaseProgressBar2JPanel.add(JobDuration2JPanel);
			        JobDuration2JPanel.setVisible(true);
				
				
				//PROCESSO 3 !!!
				
				
		       
		        //Critical Area 1 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(2).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar3JPanel.add(CriticalArea1JPanel3);
				CriticalArea1JPanel3.setVisible(true);
	        
				//Critical Area 2 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(2).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar3JPanel.add(CriticalArea2JPanel3);
				CriticalArea2JPanel3.setVisible(true);
				
				//Critical Area 3 JPanel 3
				startpoint=StartEndProcessi.get(2).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(2).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P3] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel3.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar3JPanel.add(CriticalArea3JPanel3);
				CriticalArea3JPanel3.setVisible(true);
				
				//Job Duration 3
				startpoint=StartEndProcessi.get(2).inizioProcesso;
				endpoint=StartEndProcessi.get(2).fineProcesso;
				System.out.println("[INIZIO P3] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration3JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar3JPanel.add(JobDuration3JPanel);
		        JobDuration3JPanel.setVisible(true);
		     
				
				//PROCESSO 4 !!!
				
				
		       
		        //Critical Area 1 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(3).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar4JPanel.add(CriticalArea1JPanel4);
				CriticalArea1JPanel4.setVisible(true);
	        
				//Critical Area 2 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(3).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar4JPanel.add(CriticalArea2JPanel4);
				CriticalArea2JPanel4.setVisible(true);
				
				//Critical Area 3 JPanel 4
				startpoint=StartEndProcessi.get(3).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(3).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P4] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel4.setBounds(startpoint, 0, endpoint-startpoint, 29);
				BaseProgressBar4JPanel.add(CriticalArea3JPanel4);
				CriticalArea3JPanel4.setVisible(true);

				//Job Duration 4
				startpoint=StartEndProcessi.get(3).inizioProcesso;
				endpoint=StartEndProcessi.get(3).fineProcesso;
				System.out.println("[INIZIO P4] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration4JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar4JPanel.add(JobDuration4JPanel);
		        JobDuration4JPanel.setVisible(true);
		        
		        
				//PROCESSO 5 !!!
				
				
		       
		        //Critical Area 1 JPanel 5
				startpoint=StartEndProcessi.get(4).inizioZonaCritica1;
				endpoint=StartEndProcessi.get(4).fineZonaCritica1;
				System.out.println("[ZONA CRITICA 1 di P5] : Valori in posizione: " +startpoint + " e "+endpoint);				
				CriticalArea1JPanel5.setBounds(startpoint, 0, endpoint-startpoint, 29);
				 BaseProgressBar5JPanel.add(CriticalArea1JPanel5);
				CriticalArea1JPanel5.setVisible(true);
	        
				//Critical Area 2 JPanel 5
				startpoint=StartEndProcessi.get(4).inizioZonaCritica2;
				endpoint=StartEndProcessi.get(4).fineZonaCritica2;
				System.out.println("[ZONA CRITICA 2 di P5] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea2JPanel5.setBounds(startpoint, 0, endpoint-startpoint, 29);
				 BaseProgressBar5JPanel.add(CriticalArea2JPanel5);
				CriticalArea2JPanel5.setVisible(true);
				
				//Critical Area 3 JPanel 5
				startpoint=StartEndProcessi.get(4).inizioZonaCritica3;
				endpoint=StartEndProcessi.get(4).fineZonaCritica3;
				System.out.println("[ZONA CRITICA 3 di P5] : Valori in posizione: " +startpoint + " e "+endpoint);
				CriticalArea3JPanel5.setBounds(startpoint, 0, endpoint-startpoint, 29);
				 BaseProgressBar5JPanel.add(CriticalArea3JPanel5);
				CriticalArea3JPanel5.setVisible(true);
	
				//Job Duration 5
				startpoint=StartEndProcessi.get(4).inizioProcesso;
				endpoint=StartEndProcessi.get(4).fineProcesso;
				System.out.println("[INIZIO P5] : Valori in posizione: " +startpoint + " e "+endpoint);			
				JobDuration5JPanel.setBounds(startpoint, 0, endpoint-startpoint, 29);
		        BaseProgressBar5JPanel.add(JobDuration5JPanel);
		        JobDuration5JPanel.setVisible(true);
			}

		}
				
		
		//Messaggio di avvertimento: impossibile generare nuovi esercizi se ve ne sono in esecuzione
		else 
		{
			 JOptionPane.showMessageDialog(new JFrame(), "Non e' possibile generare nuovi esercizi con sessioni in esecuzione: seleziona 'Pause' o 'Reset'!", "Nuovo Esercizio Error Dialog",
			            JOptionPane.ERROR_MESSAGE);
		}
				
				}
				
	        	@Override
				public void mouseEntered(MouseEvent e) 
				{
	        		GeneraEsercizioJButton.setBackground(Color.ORANGE);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					GeneraEsercizioJButton.setBackground(Color.WHITE);
				}
			});
						
					

			
			
			
			 labelIndietroIcon.addMouseListener(new MouseAdapter() {
		        	@Override
					public void mouseClicked(MouseEvent e) 
					{
		        		
		        		if(!toggleButtonStartPause.isSelected()) {
							framechiamante.setVisible(true);
							frame.setVisible(false);
							frame.dispose();
		        		}else {
		       			 JOptionPane.showMessageDialog(new JFrame(), "Si prega di mettere in pausa la sessione prima di tornare indietro!", "Indietro Error Dialog",
		 			            JOptionPane.ERROR_MESSAGE);
		        		}
		        		

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
			 	public void mouseEntered(MouseEvent e) {
			 		labelScrittaSlide.setForeground(Color.RED);
			 	}
			 	
			 	@Override 
			 	public void mouseExited(MouseEvent e) {
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
					public void mouseEntered(MouseEvent e) {
						labelScrittaYoutube.setForeground(Color.RED);
					}
					
					@Override 
					public void mouseExited(MouseEvent e) {
						labelScrittaYoutube.setForeground(Color.BLACK);
					}
				});

				
	
	}
}