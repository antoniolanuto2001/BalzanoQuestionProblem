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
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;



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
		labelFilosofo1.setBounds(409, 310, 94, 98);
		panelMainButton.add(labelFilosofo1);
		labelFilosofo1.setIcon(imageNormal);
		
		JLabel labelFilosofo2 = new JLabel("Filosofo 2 ");
		labelFilosofo2.setBounds(655, 183, 94, 98);
		labelFilosofo2.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo2);
		
		JLabel labelFilosofo3 = new JLabel("Filosofo 3");
		labelFilosofo3.setBounds(893, 310, 94, 98);
		labelFilosofo3.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo3);
		
		JLabel labelFilosofo4 = new JLabel("Filosofo 4");
		labelFilosofo4.setBounds(833, 591, 94, 98);
		labelFilosofo4.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo4);
		
		JLabel labelFilosofo5 = new JLabel("Filosofo 5");
		labelFilosofo5.setBounds(469, 602, 94, 98);
		labelFilosofo5.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo5);
		
		JScrollPane scroll= new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(10, 200, 344, 530);
		scroll.setPreferredSize(new DimensionUIResource(344, 5000));
		
		
        textAreaLog.setBorder(new LineBorder(new Color(0, 0, 0)));
        textAreaLog.setBackground(new Color(255, 255, 255));
        textAreaLog.setFont(new Font("Arial", Font.PLAIN, 13));
        textAreaLog.setBounds(10, 247, 344, 462);
        scroll.setViewportView(textAreaLog);
        DefaultCaret caret = (DefaultCaret)textAreaLog.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
        panelMainButton.add(scroll);
		
		
		JPanel panelSuperiore = new JPanel();
		panelSuperiore.setBorder(new LineBorder(new Color(149, 117, 205), 5));
		panelSuperiore.setBounds(0, 0, 1414, 73);
		panelMainButton.add(panelSuperiore);
		panelSuperiore.setLayout(null);
		
		JLabel labelSchemata = new JLabel("FILOSOFI A CENA ");
		labelSchemata.setBackground(Color.LIGHT_GRAY);
		labelSchemata.setForeground(Color.BLACK);
		labelSchemata.setHorizontalAlignment(SwingConstants.CENTER);
		labelSchemata.setBounds(449, 11, 527, 51);
		labelSchemata.setBorder(null);
		panelSuperiore.add(labelSchemata);
		labelSchemata.setFont(new Font("Segoe UI", Font.BOLD, 48));
		
		
		
		JLabel labelTavola = new JLabel("tavola");
		labelTavola.setBounds(459, 284, 482, 371);
		labelTavola.setIcon(imageTavola);
		panelMainButton.add(labelTavola);
		ButtonGroup groupSceltaStrategiaFilosofi = new ButtonGroup();
        
        
        
        JLabel labelLog = new JLabel(" LOG DEGLI EVENTI : ");
        labelLog.setFont(new Font("Segoe UI", Font.BOLD, 16));
        labelLog.setBounds(92, 153, 172, 36);
        panelMainButton.add(labelLog);
        
        JPanel panelDiControllo = new JPanel();
		panelDiControllo.setBounds(1130, 76, 274, 664);
		
		panelDiControllo.setLayout(null);
		panelDiControllo.setBorder(BorderFactory.createDashedBorder(Color.BLACK));;
		panelMainButton.add(panelDiControllo);
		
		JPanel panelVelocita = new JPanel();
		panelVelocita.setBorder(BorderFactory.createDashedBorder(Color.BLACK));;
        panelVelocita.setBounds(14, 350, 245, 245);
        panelDiControllo.add(panelVelocita);
        panelVelocita.setLayout(null);
		
		JPanel panelModalita = new JPanel();
		panelModalita.setBounds(14, 112, 245, 183);
        panelModalita.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        panelDiControllo.add(panelModalita);
        panelModalita.setLayout(null);
	        
		JRadioButton radioDefault = new JRadioButton("Nessuno");
		radioDefault.setBounds(6, 7, 175, 36);
		panelModalita.add(radioDefault);
		radioDefault.setToolTipText("Filosofi fermi senza mangiare ");
		radioDefault.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		sliderVelocitaPensa.setBounds(15, 145, 206, 60);
		panelVelocita.add(sliderVelocitaPensa);
		sliderVelocitaPensa.setPreferredSize(new Dimension(250, 60));
		sliderVelocitaPensa.setPaintTrack(true);
		sliderVelocitaPensa.setPaintTicks(true);
		sliderVelocitaPensa.setPaintLabels(true);
		sliderVelocitaPensa.setMinorTickSpacing(3);
		sliderVelocitaPensa.setMajorTickSpacing(1);
		
        JSlider sliderVelocitaMangia = new JSlider(1,5,3);
        sliderVelocitaMangia.setBounds(15, 48, 206, 60);
        panelVelocita.add(sliderVelocitaMangia);
        sliderVelocitaMangia.setPreferredSize(new Dimension(250, 60));
        sliderVelocitaMangia.setPaintTrack(true);
        sliderVelocitaMangia.setPaintLabels(true);
        sliderVelocitaMangia.setPaintTicks(true);
        sliderVelocitaMangia.setMajorTickSpacing(1);
        sliderVelocitaMangia.setMinorTickSpacing(3);
        
        JRadioButton radioCoda = new JRadioButton("Schema Coda");
        radioCoda.setBounds(6, 124, 206, 44);
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
        radioCoda.setFont(new Font("Tahoma", Font.PLAIN, 14));
        groupSceltaStrategiaFilosofi.add(radioCoda);
        
        JRadioButton radioAtomico = new JRadioButton("Schema Atomico");
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
        radioAtomico.setFont(new Font("Tahoma", Font.PLAIN, 14));
        groupSceltaStrategiaFilosofi.add(radioAtomico);
        
        
        JRadioButton radioClassico = new JRadioButton("Schema Classico");
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
        radioClassico.setFont(new Font("Tahoma", Font.PLAIN, 14));
        groupSceltaStrategiaFilosofi.add(radioClassico);
        
        JLabel labelStrategia = new JLabel("  Strategia :");
        labelStrategia.setForeground(Color.RED);
        labelStrategia.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelStrategia.setBounds(82, 76, 118, 25);
        panelDiControllo.add(labelStrategia);
        
        JLabel labelSliderPensa = new JLabel("Pensa  : ");
        labelSliderPensa.setBounds(20, 119, 143, 30);
        panelVelocita.add(labelSliderPensa);
        labelSliderPensa.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        JLabel labelSliderMangia = new JLabel("Mangia : ");
        labelSliderMangia.setBounds(20, 24, 143, 30);
        panelVelocita.add(labelSliderMangia);
        labelSliderMangia.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        JLabel labelVelocit = new JLabel("   Velocità  :");
        labelVelocit.setForeground(Color.RED);
        labelVelocit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelVelocit.setBounds(82, 317, 118, 25);
        panelDiControllo.add(labelVelocit);
        
        JLabel labelCtrl = new JLabel("Pannello Di Controllo");
        labelCtrl.setBorder(new LineBorder(new Color(149, 117, 205), 3));
        labelCtrl.setHorizontalAlignment(SwingConstants.CENTER);
        labelCtrl.setFont(new Font("Arial", Font.BOLD, 22));
        labelCtrl.setBounds(14, 11, 245, 54);
        panelDiControllo.add(labelCtrl);
        
        JLabel labelScrittaIndietro = new JLabel(" Indietro");
        labelScrittaIndietro.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelScrittaIndietro.setBounds(12, 132, 53, 12);
        panelMainButton.add(labelScrittaIndietro);
        
        JLabel labelIndietroIcon = new JLabel("Exit");
        labelIndietroIcon.addMouseListener(new MouseAdapter() {
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
        labelIndietroIcon.setIcon(new ImageIcon(Filosofi.class.getResource("/img/indietroIcon1.png")));
        labelIndietroIcon.setBounds(10, 84, 53, 46);
        panelMainButton.add(labelIndietroIcon);
        
        JLabel labelScrittaYoutube = new JLabel("Video Youtube");
        labelScrittaYoutube.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelScrittaYoutube.setBounds(918, 132, 82, 12);
        panelMainButton.add(labelScrittaYoutube);
        JLabel labelYoutubeIcon = new JLabel("Youtube");
        labelYoutubeIcon.addMouseListener(new MouseAdapter() {
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
        labelYoutubeIcon.setBounds(933, 84, 53, 46);
        panelMainButton.add(labelYoutubeIcon);
        
        JLabel labelScrittaSlide = new JLabel("Slide Argomento");
        labelScrittaSlide.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelScrittaSlide.setBounds(1007, 132, 95, 15);
        panelMainButton.add(labelScrittaSlide);
        JLabel labelSlideIcon = new JLabel("Slide");
        labelSlideIcon.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
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
        labelSlideIcon.setBounds(1027, 84, 53, 46);
        panelMainButton.add(labelSlideIcon);
        
      
        
        
        
        
        
       
        
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