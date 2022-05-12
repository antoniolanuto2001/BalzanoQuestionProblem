package gui;

import model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.ScrollPaneUI;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.text.DefaultCaret;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;



public class Filosofi extends JFrame {

	public 	JTextArea textAreaLog;
	private JPanel contentPane;
	private JFrame frame;
	private JPanel panelMainButton = new JPanel();
	private Boolean continuaBoolean = false;
	private Boolean deadlockBoolean = false;
	/**
	 * Create the frame.
	 */
	public Filosofi(JFrame framechiamante) 
	{
		frame=this;
		textAreaLog = new JTextArea();
		Thread threadClassico[] = new Thread[5];
		Thread threadAtomico[] = new Thread[5];
		Thread threadCoda[]=new Thread[5];
		ImageIcon imageReady = new ImageIcon(this.getClass().getResource("/img/readyIcon.png"));
		ImageIcon imageNormal = new ImageIcon(this.getClass().getResource("/img/normaleIcon.png"));
		ImageIcon imageAttesa = new ImageIcon(this.getClass().getResource("/img/attesaIcon.png"));
		ImageIcon imageTavola = new ImageIcon(this.getClass().getResource("/img/tavolaIcon.png"));
		ImageIcon imageDeadLock = new ImageIcon(this.getClass().getResource("/img/deadlockIcon.png"));
		FilosofiClassica filosofiClassica[] = new FilosofiClassica[5];
		for (int i = 0; i < filosofiClassica.length; i++) 
		{
			filosofiClassica[i] = new FilosofiClassica(i,textAreaLog);
		}
		FilosofiAtomici filosofiAtomici[] = new FilosofiAtomici[5];
		for (int i = 0; i < filosofiClassica.length; i++) 
		{
			filosofiAtomici[i] = new FilosofiAtomici(i,textAreaLog);
		}
		FilosofiCoda filosofiCoda[]= new FilosofiCoda[5];
		for (int i = 0; i < filosofiCoda.length; i++) 
		{
			filosofiCoda[i]= new FilosofiCoda(i,textAreaLog);
			
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Balzano Question Problem : Filosofi a Cena");
		setContentPane(contentPane);
		
		
		
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);
		
		
		JLabel labelFilosofo1 = new JLabel("Filosofo1");
		labelFilosofo1.setBounds(364, 308, 94, 98);
		panelMainButton.add(labelFilosofo1);
		labelFilosofo1.setIcon(imageNormal);
		
		JLabel labelFilosofo2 = new JLabel("Filosofo 2 ");
		labelFilosofo2.setBounds(610, 181, 94, 98);
		labelFilosofo2.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo2);
		
		JLabel labelFilosofo3 = new JLabel("Filosofo 3");
		labelFilosofo3.setBounds(848, 308, 94, 98);
		labelFilosofo3.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo3);
		
		JLabel labelFilosofo4 = new JLabel("Filosofo 4");
		labelFilosofo4.setBounds(788, 589, 94, 98);
		labelFilosofo4.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo4);
		
		JLabel labelFilosofo5 = new JLabel("Filosofo 5");
		labelFilosofo5.setBounds(424, 600, 94, 98);
		labelFilosofo5.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo5);
		
		JScrollPane scroll= new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(10, 247, 344, 462);
		scroll.setPreferredSize(new DimensionUIResource(344, 5000));
		
		
        textAreaLog.setBorder(new LineBorder(new Color(0, 0, 0)));
        textAreaLog.setBackground(new Color(255, 255, 255));
        textAreaLog.setFont(new Font("Arial", Font.PLAIN, 13));
        textAreaLog.setBounds(10, 247, 344, 462);
        scroll.setViewportView(textAreaLog);
        DefaultCaret caret = (DefaultCaret)textAreaLog.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
        panelMainButton.add(scroll);
		
		JButton buttonIndietro = new JButton("Indietro");
		buttonIndietro.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonIndietro.setBackground(new Color(153, 204, 255));
		buttonIndietro.setOpaque(true);
		buttonIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{	
				continuaBoolean=false;
				labelFilosofo1.setIcon(imageNormal);
				labelFilosofo2.setIcon(imageNormal);
				labelFilosofo3.setIcon(imageNormal);
				labelFilosofo4.setIcon(imageNormal);
				labelFilosofo5.setIcon(imageNormal);
				for (int i = 0; i < filosofiClassica.length; i++) 
				{
					
					filosofiClassica[i].stop();
					filosofiAtomici[i].stop();
					filosofiCoda[i].stop();
					System.out.println("Ho interotto Esecuzione di entrambi i filosofi " + i);
				}
				framechiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonIndietro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonIndietro.setBounds(141, 147, 128, 46);
		panelMainButton.add(buttonIndietro);
		
		
		JPanel panelSuperiore = new JPanel();
		panelSuperiore.setBorder(new LineBorder(new Color(255,100,130), 5));
		panelSuperiore.setBackground(new Color(230, 230, 250));
		panelSuperiore.setBounds(0, 0, 1414, 124);
		panelMainButton.add(panelSuperiore);
		panelSuperiore.setLayout(null);
		
		JLabel labelSchemata = new JLabel("FILOSOFI A CENA ");
		labelSchemata.setHorizontalAlignment(SwingConstants.CENTER);
		labelSchemata.setBounds(465, 16, 423, 89);
		labelSchemata.setBorder(BorderFactory.createRaisedBevelBorder());
		panelSuperiore.add(labelSchemata);
		labelSchemata.setFont(new Font("Segoe UI", Font.BOLD, 48));
		
		JTextArea txtrUniversitDegliStudi = new JTextArea();
		txtrUniversitDegliStudi.setBounds(1126, 16, 278, 89);
		txtrUniversitDegliStudi.setBackground(new Color (230, 230, 250));
		txtrUniversitDegliStudi.setText("Universit\u00E0 degli studi di Napoli\r\nAnno Accademico: 2021/2022\r\nProfessore: Walter Balzano\r\nDevoloper: Lanuto, Prosciutto, Scotto\r\n");
		txtrUniversitDegliStudi.setLineWrap(true);
		txtrUniversitDegliStudi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtrUniversitDegliStudi.setEditable(false);
		panelSuperiore.add(txtrUniversitDegliStudi);
		
		
		
		JLabel labelTavola = new JLabel("tavola");
		labelTavola.setBounds(414, 282, 482, 371);
		labelTavola.setIcon(imageTavola);
		panelMainButton.add(labelTavola);
		ButtonGroup groupSceltaStrategiaFilosofi = new ButtonGroup();
		
		
		
		JButton buttonEsci = new JButton("Esci");
		buttonEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonEsci.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonEsci.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonEsci.setBackground(new Color(255, 204, 0));
		buttonEsci.setBounds(3, 146, 114, 48);
		panelMainButton.add(buttonEsci);
		
		JButton btnSlideArgomento = new JButton("Slide Argomento");
		btnSlideArgomento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI ("http://balzanoslidesistemiopera.altervista.org/Slides_Sistemi_Operativi.pdf#page=248"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	    btnSlideArgomento.setOpaque(true);
	    btnSlideArgomento.setFont(new Font("Segoe UI", Font.BOLD, 14));
	    btnSlideArgomento.setBorder(new LineBorder(new Color(0, 0, 0)));
	    btnSlideArgomento.setBackground(new Color(153, 255, 255));
	    btnSlideArgomento.setBounds(999, 146, 128, 48);
        panelMainButton.add(btnSlideArgomento);

     
     
        JLabel labelSliderMangia = new JLabel("Velocita Mangia : ");
        labelSliderMangia.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelSliderMangia.setBounds(1144, 411, 143, 30);
        panelMainButton.add(labelSliderMangia);
        
        JLabel labelSliderPensa = new JLabel("Velocita Pensa  : ");
        labelSliderPensa.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelSliderPensa.setBounds(1144, 523, 143, 30);
        panelMainButton.add(labelSliderPensa);
        
        
        
        JLabel labelLog = new JLabel("LOG Degli Eventi : ");
        labelLog.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelLog.setBounds(10, 205, 163, 36);
        panelMainButton.add(labelLog);
        
        JButton buttonVideo = new JButton("Video Youtube");
       
        buttonVideo.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI ("https://youtu.be/xPBZms_iICc?t=9113"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        buttonVideo.setBorder(new LineBorder(new Color(0, 0, 0)));
        buttonVideo.setBackground(new Color(221, 160, 221));
        buttonVideo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        buttonVideo.setBounds(848, 147, 138, 46);
        panelMainButton.add(buttonVideo);
        
        JPanel panelDiControllo = new JPanel();
		panelDiControllo.setBounds(1137, 134, 265, 617);
		
		panelDiControllo.setLayout(null);
		panelDiControllo.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));
		panelMainButton.add(panelDiControllo);
		
		JPanel pannellodicontrolloTitolo = new JPanel();
		pannellodicontrolloTitolo.setBounds(10, 10, 245, 54);
		pannellodicontrolloTitolo.setBackground(new Color(255, 204, 51));
		panelDiControllo.add(pannellodicontrolloTitolo);
		pannellodicontrolloTitolo.setLayout(null);
		pannellodicontrolloTitolo.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JLabel labelPnlCtrl = new JLabel("Pannello di controllo");
		labelPnlCtrl.setHorizontalAlignment(SwingConstants.CENTER);
		labelPnlCtrl.setBounds(0, 0, 245, 54);
		pannellodicontrolloTitolo.add(labelPnlCtrl);
		labelPnlCtrl.setFont(new Font("Arial", Font.BOLD, 22));
		
		 JPanel panelModalita = new JPanel();
		 panelModalita.setBackground(new Color(230, 230, 250));
		 panelModalita.setBounds(10, 105, 245, 166);
	        panelModalita.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));
	        panelDiControllo.add(panelModalita);
	        panelModalita.setLayout(null);
	        
		JRadioButton radioDefault = new JRadioButton("Nessuno");
		radioDefault.setBackground(new Color(230, 230, 250));
		radioDefault.setBounds(6, 7, 175, 36);
		panelModalita.add(radioDefault);
		radioDefault.setToolTipText("Filosofi fermi senza mangiare ");
		radioDefault.setFont(new Font("Segoe UI", Font.BOLD, 13));
		radioDefault.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				continuaBoolean=false;
				if (deadlockBoolean) 
				{
					deadlockBoolean=false;
					labelTavola.setIcon(imageTavola);
				}
				labelFilosofo1.setIcon(imageNormal);
				labelFilosofo2.setIcon(imageNormal);
				labelFilosofo3.setIcon(imageNormal);
				labelFilosofo4.setIcon(imageNormal);
				labelFilosofo5.setIcon(imageNormal);
				for (int i = 0; i < filosofiClassica.length; i++) 
				{
					
					filosofiClassica[i].stop();
					filosofiAtomici[i].stop();
					filosofiCoda[i].stop();
					System.out.println("Ho interotto Esecuzione di entrambi i filosofi " + i);
				}
				textAreaLog.setText("Reset Filosofi ...  \n");
				textAreaLog.append("I filosofi che potrebbero seguire stanno terminando\nesecuzione da precedenti Thread\n");
			}
		});
		groupSceltaStrategiaFilosofi.add(radioDefault);
		
		JSlider sliderVelocitaPensa = new JSlider(1, 5, 3);
		sliderVelocitaPensa.setBounds(33, 418, 206, 60);
		panelDiControllo.add(sliderVelocitaPensa);
		sliderVelocitaPensa.setPreferredSize(new Dimension(250, 60));
		sliderVelocitaPensa.setPaintTrack(true);
		sliderVelocitaPensa.setPaintTicks(true);
		sliderVelocitaPensa.setPaintLabels(true);
		sliderVelocitaPensa.setMinorTickSpacing(3);
		sliderVelocitaPensa.setMajorTickSpacing(1);
		
        JSlider sliderVelocitaMangia = new JSlider(1,5,3);
        sliderVelocitaMangia.setBounds(33, 305, 206, 60);
        panelDiControllo.add(sliderVelocitaMangia);
        sliderVelocitaMangia.setPreferredSize(new Dimension(250, 60));
        sliderVelocitaMangia.setPaintTrack(true);
        sliderVelocitaMangia.setPaintLabels(true);
        sliderVelocitaMangia.setPaintTicks(true);
        sliderVelocitaMangia.setMajorTickSpacing(1);
        sliderVelocitaMangia.setMinorTickSpacing(3);
        
        JRadioButton radioCoda = new JRadioButton("Schema Coda");
        radioCoda.setBackground(new Color(230, 230, 250));
        radioCoda.setBounds(6, 115, 206, 44);
        panelModalita.add(radioCoda);
        radioCoda.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		if (radioCoda.isSelected()) 
        		{
        			textAreaLog.setText("Modalita Schema a Coda Attivata : \n");
        			continuaBoolean=false;
        			if (deadlockBoolean) 
        			{	
        				deadlockBoolean=false;
        				labelTavola.setIcon(imageTavola);
        			}
        			for (int i = 0; i < threadCoda.length; i++) 
        			{
        				filosofiClassica[i].stop();
        				filosofiAtomici[i].stop();
        				System.out.println("Ho interotto Esecuzione dei filosofi atomici - classici" + i);
        				if(1==sliderVelocitaPensa.getValue())
        				{
        					filosofiCoda[i].tempoPensa=3000;
        				}
        				else if (2==sliderVelocitaPensa.getValue()) 
        				{
        					filosofiCoda[i].tempoPensa=1500;
        				}
        				else if (3==sliderVelocitaPensa.getValue()) 
        				{
        					filosofiCoda[i].tempoPensa=800;
        				}
        				else if (4==sliderVelocitaPensa.getValue()) 
        				{
        					filosofiCoda[i].tempoPensa=500;
        				}
        				else 
        				{
        					filosofiCoda[i].tempoPensa=300;
        				}
        				if(1==sliderVelocitaMangia.getValue())
        				{
        					filosofiCoda[i].tempoMangia=3000;
        				}
        				else if (2==sliderVelocitaMangia.getValue()) 
        				{
        					filosofiCoda[i].tempoMangia=1500;
        				}
        				else if (3==sliderVelocitaMangia.getValue()) 
        				{
        					filosofiCoda[i].tempoMangia=800;
        				}
        				else if (4==sliderVelocitaMangia.getValue()) 
        				{
        					filosofiCoda[i].tempoMangia=500;
        				}
        				else 
        				{
        					filosofiCoda[i].tempoMangia=300;
        				}
        				filosofiCoda[i].resume();
        				threadAtomico[i]= new Thread(filosofiCoda[i]);
        				threadAtomico[i].start();
        			}

        			continuaBoolean=true;
        			Thread threadCambiaFiloCoda= new Thread(new Runnable() 
        			{
        				@Override
        				public void run() 
        				{
        					// TODO Auto-generated method stub
        					while (continuaBoolean) 
        					{
        						//Filosofo 1 
        						if (filosofiCoda[0].pronto==true) 
        						{
        							labelFilosofo1.setIcon(imageReady);
        						}
        						else 
        						{
        							labelFilosofo1.setIcon(imageAttesa);
        						}
        						//Filosofo 2
        						if (filosofiCoda[1].pronto==true) 
        						{
        							labelFilosofo2.setIcon(imageReady);
        						}
        						else 
        						{
        							labelFilosofo2.setIcon(imageAttesa);
        						}
        						//Filosofo 3
        						if (filosofiCoda[2].pronto==true) 
        						{
        							labelFilosofo3.setIcon(imageReady);
        						}
        						else 
        						{
        							labelFilosofo3.setIcon(imageAttesa);
        						}
        						//Filosofo 4
        						if (filosofiCoda[3].pronto==true) 
        						{
        							labelFilosofo4.setIcon(imageReady);
        						}
        						else 
        						{
        							labelFilosofo4.setIcon(imageAttesa);
        						}
        						//Filosofo 5
        						if (filosofiCoda[4].pronto==true) 
        						{
        							labelFilosofo5.setIcon(imageReady);
        						}
        						else 
        						{
        							labelFilosofo5.setIcon(imageAttesa);
        						}
        						
        					}
        				}
        			});
        			threadCambiaFiloCoda.start();
        		}
        	}
        });
        radioCoda.setToolTipText("Solo 4 Filosofi possono sedersi conteporaneamente");
        radioCoda.setFont(new Font("Segoe UI", Font.BOLD, 13));
        groupSceltaStrategiaFilosofi.add(radioCoda);
        
        JRadioButton radioAtomico = new JRadioButton("Schema Atomico");
        radioAtomico.setBackground(new Color(230, 230, 250));
        radioAtomico.setBounds(6,85, 175, 36);
        panelModalita.add(radioAtomico);
        radioAtomico.setToolTipText("Ogni filosofo aspetta e posa entrambi le bacchette conteporaneamente");
        radioAtomico.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) 
        	{
        		if (radioAtomico.isSelected()) 
        		{
        			textAreaLog.setText("Modalita Schema Atomico Attivata : \n");
        			continuaBoolean=false;
        			if (deadlockBoolean) 
        			{
        				deadlockBoolean=false;
        				labelTavola.setIcon(imageTavola);
        			}
        			for (int i = 0; i < threadAtomico.length; i++) 
        			{
        				filosofiClassica[i].stop();
        				filosofiCoda[i].stop();
        				System.out.println("Ho interotto Esecuzione dei filosofi classici - coda " + i);
        				if(1==sliderVelocitaPensa.getValue())
        				{
        					filosofiAtomici[i].tempoPensa=3000;
        				}
        				else if (2==sliderVelocitaPensa.getValue()) 
        				{
        					filosofiAtomici[i].tempoPensa=1500;
        				}
        				else if (3==sliderVelocitaPensa.getValue()) 
        				{
        					filosofiAtomici[i].tempoPensa=800;
        				}
        				else if (4==sliderVelocitaPensa.getValue()) 
        				{
        					filosofiAtomici[i].tempoPensa=500;
        				}
        				else 
        				{
        					filosofiAtomici[i].tempoPensa=300;
        				}
        				if(1==sliderVelocitaMangia.getValue())
        				{
        					filosofiAtomici[i].tempoMangia=3000;
        				}
        				else if (2==sliderVelocitaMangia.getValue()) 
        				{
        					filosofiAtomici[i].tempoMangia=1500;
        				}
        				else if (3==sliderVelocitaMangia.getValue()) 
        				{
        					filosofiAtomici[i].tempoMangia=800;
        				}
        				else if (4==sliderVelocitaMangia.getValue()) 
        				{
        					filosofiAtomici[i].tempoMangia=500;
        				}
        				else 
        				{
        					filosofiAtomici[i].tempoMangia=300;
        				}
        				filosofiAtomici[i].resume();
        				threadAtomico[i]= new Thread(filosofiAtomici[i]);
        				threadAtomico[i].start();
        			}

        			continuaBoolean=true;
        			Thread threadCambiaFiloAtomico= new Thread(new Runnable() 
        			{
        				@Override
        				public void run() 
        				{
        					// TODO Auto-generated method stub
        					while (continuaBoolean) 
        					{
        						//Filosofo 1 
        						if (filosofiAtomici[0].pronto==true) 
        						{
        							labelFilosofo1.setIcon(imageReady);
        						}
        						else 
        						{
        							labelFilosofo1.setIcon(imageAttesa);
        						}
        						//Filosofo 2
        						if (filosofiAtomici[1].pronto==true) 
        						{
        							labelFilosofo2.setIcon(imageReady);
        						}
        						else 
        						{
        							labelFilosofo2.setIcon(imageAttesa);
        						}
        						//Filosofo 3
        						if (filosofiAtomici[2].pronto==true) 
        						{
        							labelFilosofo3.setIcon(imageReady);
        						}
        						else 
        						{
        							labelFilosofo3.setIcon(imageAttesa);
        						}
        						//Filosofo 4
        						if (filosofiAtomici[3].pronto==true) 
        						{
        							labelFilosofo4.setIcon(imageReady);
        						}
        						else 
        						{
        							labelFilosofo4.setIcon(imageAttesa);
        						}
        						//Filosofo 5
        						if (filosofiAtomici[4].pronto==true) 
        						{
        							labelFilosofo5.setIcon(imageReady);
        						}
        						else 
        						{
        							labelFilosofo5.setIcon(imageAttesa);
        						}
        						
        					}
        				}
        			});
        			threadCambiaFiloAtomico.start();
        		}
        	}
        });
        radioAtomico.setFont(new Font("Segoe UI", Font.BOLD, 13));
        groupSceltaStrategiaFilosofi.add(radioAtomico);
        
        
        JRadioButton radioClassico = new JRadioButton("Schema Classico");
        radioClassico.setBackground(new Color(230, 230, 250));
        radioClassico.setBounds(6, 46, 175, 36);
        panelModalita.add(radioClassico);
        radioClassico.setToolTipText("Ogni filosofo aspetta prende la bacchetta di sinistra ed aspetto quella di destra");
        radioClassico.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) 
        	{
        		if (radioClassico.isSelected()) 
        		{
        			textAreaLog.setText("Modalita Schema Classico Attivata : \n");
        			continuaBoolean=false;
        			if (deadlockBoolean) 
        			{
        				deadlockBoolean=false;
        				labelTavola.setIcon(imageTavola);
        			}
        			for (int i = 0; i < threadClassico.length; i++) 
        			{
        				filosofiAtomici[i].stop();
        				filosofiCoda[i].stop();
        				System.out.println("Ho interotto Esecuzione dei filosofi atomici - coda " + i);
        				filosofiClassica[i].resume();
        				//Slider Velocita Mangia
        				if(1==sliderVelocitaMangia.getValue())
        				{
        					filosofiClassica[i].tempoMangia=3000;
        				}
        				else if (2==sliderVelocitaMangia.getValue()) 
        				{
        					filosofiClassica[i].tempoMangia=1500;
        				}
        				else if (3==sliderVelocitaMangia.getValue()) 
        				{
        					filosofiClassica[i].tempoMangia=800;
        				}
        				else if (4==sliderVelocitaMangia.getValue()) 
        				{
        					filosofiClassica[i].tempoMangia=500;
        				}
        				else 
        				{
        					filosofiClassica[i].tempoMangia=100;
        				}
        				//Slider Velocita Pensa
        				if(1==sliderVelocitaPensa.getValue())
        				{
        					filosofiClassica[i].tempoPensa=3000;
        				}
        				else if (2==sliderVelocitaPensa.getValue()) 
        				{
        					filosofiClassica[i].tempoPensa=1500;
        				}
        				else if (3==sliderVelocitaPensa.getValue()) 
        				{
        					filosofiClassica[i].tempoPensa=800;
        				}
        				else if (4==sliderVelocitaPensa.getValue()) 
        				{
        					filosofiClassica[i].tempoPensa=500;
        				}
        				else 
        				{
        					filosofiClassica[i].tempoPensa=300;
        				}
        				threadClassico[i]= new Thread(filosofiClassica[i]);
        				threadClassico[i].start();
        			}
        			continuaBoolean=true;
        			Thread threadCambiaFiloClassico= new Thread(new Runnable() 
        			{
        				@Override
        				public void run() 
        				{
        					// TODO Auto-generated method stub
        					while (continuaBoolean && filosofiClassica[0].deadlockCheck==false) 
        					{
        						//Filosofo 1 
        						if (filosofiClassica[0].pronto==true) 
        						{
        							
        								
        							labelFilosofo1.setIcon(imageReady);
        						}
        						else 
        						{
        							
        							labelFilosofo1.setIcon(imageAttesa);
        						}
        						//Filosofo 2
        						if (filosofiClassica[1].pronto==true) 
        						{
        							
        							labelFilosofo2.setIcon(imageReady);
        						}
        						else 
        						{
        							
        							labelFilosofo2.setIcon(imageAttesa);
        						}
        						//Filosofo 3
        						if (filosofiClassica[2].pronto==true) 
        						{
        							
        							labelFilosofo3.setIcon(imageReady);
        						}
        						else 
        						{
        							
        							labelFilosofo3.setIcon(imageAttesa);
        						}
        						//Filosofo 4
        						if (filosofiClassica[3].pronto==true) 
        						{
        							
        							labelFilosofo4.setIcon(imageReady);
        						}
        						else 
        						{
        							
        							labelFilosofo4.setIcon(imageAttesa);
        						}
        						//Filosofo 5
        						if (filosofiClassica[4].pronto==true) 
        						{
        							
        							labelFilosofo5.setIcon(imageReady);
        						}
        						else 
        						{
        							
        							labelFilosofo5.setIcon(imageAttesa);
        						}
        						if (filosofiClassica[0].deadlockCheck==true)
        						{
        							labelFilosofo1.setIcon(imageNormal);
        							labelFilosofo2.setIcon(imageNormal);
        							labelFilosofo3.setIcon(imageNormal);
        							labelFilosofo4.setIcon(imageNormal);
        							labelFilosofo5.setIcon(imageNormal);
        							labelTavola.setIcon(imageDeadLock);
        							deadlockBoolean=true;
        						}
        					}
        				}
        			});
        			threadCambiaFiloClassico.start();
        		}
        		
        	    
        	}
        });
        radioClassico.setFont(new Font("Segoe UI", Font.BOLD, 13));
        groupSceltaStrategiaFilosofi.add(radioClassico);
        
        JLabel labelStrategia = new JLabel("Strategia :");
        labelStrategia.setForeground(new Color(0, 0, 0));
        labelStrategia.setFont(new Font("Segoe UI", Font.BOLD, 16));
        labelStrategia.setBounds(10, 75, 142, 25);
        panelDiControllo.add(labelStrategia);
        
       
        
        sliderVelocitaMangia.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseReleased(MouseEvent e) 
        	{
        		textAreaLog.append("Velocita Cambiata In Fase di Mangia: \n");
        		if (radioClassico.isSelected()) 
        		{
        			for (int i = 0; i < filosofiClassica.length; i++) 
					{
						filosofiClassica[i].stop();
						filosofiClassica[i].resume();
						if(1==sliderVelocitaMangia.getValue())
						{
							filosofiClassica[i].tempoMangia=3000;
						}
						else if (2==sliderVelocitaMangia.getValue()) 
						{
							filosofiClassica[i].tempoMangia=1500;
						}
						else if (3==sliderVelocitaMangia.getValue()) 
						{
							filosofiClassica[i].tempoMangia=800;
						}
						else if (4==sliderVelocitaMangia.getValue()) 
						{
							filosofiClassica[i].tempoMangia=500;
						}
						else 
						{
							filosofiClassica[i].tempoMangia=300;
						}
						
					}
				} 
        		else if (radioAtomico.isSelected())
        		{
        			for (int i = 0; i < filosofiAtomici.length; i++) 
					{
						
						if(1==sliderVelocitaMangia.getValue())
						{
							filosofiAtomici[i].tempoMangia=3000;
						}
						else if (2==sliderVelocitaMangia.getValue()) 
						{
							filosofiAtomici[i].tempoMangia=1200;
						}
						else if (3==sliderVelocitaMangia.getValue()) 
						{
							filosofiAtomici[i].tempoMangia=800;
						}
						else if (4==sliderVelocitaMangia.getValue()) 
						{
							filosofiAtomici[i].tempoMangia=500;
						}
						else 
						{
							filosofiAtomici[i].tempoMangia=300;
						}
					}
				}
        		else if (radioCoda.isSelected())
        		{
        			for (int i = 0; i < filosofiCoda.length; i++) 
					{
				
	        			if(1==sliderVelocitaMangia.getValue())
						{
							filosofiCoda[i].tempoMangia=3000;
						}
						else if (2==sliderVelocitaMangia.getValue()) 
						{
							filosofiCoda[i].tempoMangia=1200;
						}
						else if (3==sliderVelocitaMangia.getValue()) 
						{
							filosofiCoda[i].tempoMangia=800;
						}
						else if (4==sliderVelocitaMangia.getValue()) 
						{
							filosofiCoda[i].tempoMangia=500;
						}
						else 
						{
							filosofiCoda[i].tempoMangia=300;
						}
					}
				}
        	}
        });
		
        sliderVelocitaPensa.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseReleased(MouseEvent e) 
        	{
        		textAreaLog.append("Velocita Cambiata In Fase di Pensa: \n");
        		if (radioClassico.isSelected()) 
        		{
        			for (int i = 0; i < filosofiClassica.length; i++) 
					{
						
        				filosofiClassica[i].stop();
						if(1==sliderVelocitaPensa.getValue())
						{
							filosofiClassica[i].tempoPensa=3000;
						}
						else if (2==sliderVelocitaPensa.getValue()) 
						{
							filosofiClassica[i].tempoPensa=1200;
						}
						else if (3==sliderVelocitaPensa.getValue()) 
						{
							filosofiClassica[i].tempoPensa=800;
						}
						else if (4==sliderVelocitaPensa.getValue()) 
						{
							filosofiClassica[i].tempoPensa=500;
						}
						else 
						{
							filosofiClassica[i].tempoPensa=300;
						}
					}
        			for (int i = 0; i < filosofiClassica.length; i++) 
    				{
        				filosofiClassica[i].resume();
    					
    				}
				} 
        		else if (radioAtomico.isSelected())
        		{
        			for (int i = 0; i < filosofiAtomici.length; i++) 
					{
						
						if(1==sliderVelocitaPensa.getValue())
						{
							filosofiAtomici[i].tempoPensa=3000;
						}
						else if (2==sliderVelocitaPensa.getValue()) 
						{
							filosofiAtomici[i].tempoPensa=1000;
						}
						else if (3==sliderVelocitaPensa.getValue()) 
						{
							filosofiAtomici[i].tempoPensa=800;
						}
						else if (4==sliderVelocitaPensa.getValue()) 
						{
							filosofiAtomici[i].tempoPensa=500;
						}
						else 
						{
							filosofiAtomici[i].tempoPensa=300;
						}
					}
				}
        		else if (radioCoda.isSelected())
        		{
        			for (int i = 0; i < filosofiCoda.length; i++) 
					{
				
	        			if(1==sliderVelocitaPensa.getValue())
						{
							filosofiCoda[i].tempoPensa=3000;
						}
						else if (2==sliderVelocitaPensa.getValue()) 
						{
							filosofiCoda[i].tempoPensa=1200;
						}
						else if (3==sliderVelocitaPensa.getValue()) 
						{
							filosofiCoda[i].tempoPensa=800;
						}
						else if (4==sliderVelocitaPensa.getValue()) 
						{
							filosofiCoda[i].tempoPensa=500;
						}
						else 
						{
							filosofiCoda[i].tempoPensa=300;
						}
					}

				}
        	}
        });
        
        frame.setVisible(true); 
		
		
	}
}