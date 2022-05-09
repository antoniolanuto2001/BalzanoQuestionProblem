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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.AttributeSet.ColorAttribute;

import com.orsonpdf.GraphicsStateDictionary;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JSlider;



public class Filosofi extends JFrame {

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
		Thread threadClassico[] = new Thread[5];
		Thread threadAtomico[] = new Thread[5];
		ImageIcon imageReady = new ImageIcon(this.getClass().getResource("/img/readyIcon.png"));
		ImageIcon imageNormal = new ImageIcon(this.getClass().getResource("/img/normaleIcon.png"));
		ImageIcon imageAttesa = new ImageIcon(this.getClass().getResource("/img/attesaIcon.png"));
		ImageIcon imageTavola = new ImageIcon(this.getClass().getResource("/img/tavolaIcon.png"));
		ImageIcon imageDeadLock = new ImageIcon(this.getClass().getResource("/img/deadlockIcon.png"));
		FilosofiClassica filosofiClassica[] = new FilosofiClassica[5];
		for (int i = 0; i < filosofiClassica.length; i++) 
		{
			filosofiClassica[i] = new FilosofiClassica(i);
		}
		FilosofiAtomici filosofiAtomici[] = new FilosofiAtomici[5];
		for (int i = 0; i < filosofiClassica.length; i++) 
		{
			filosofiAtomici[i] = new FilosofiAtomici(i);
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
		labelFilosofo1.setBounds(216, 307, 94, 98);
		panelMainButton.add(labelFilosofo1);
		labelFilosofo1.setIcon(imageNormal);
		
		JLabel labelFilosofo2 = new JLabel("Filosofo 2 ");
		labelFilosofo2.setBounds(462, 180, 94, 98);
		labelFilosofo2.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo2);
		
		JLabel labelFilosofo3 = new JLabel("Filosofo 3");
		labelFilosofo3.setBounds(700, 307, 94, 98);
		labelFilosofo3.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo3);
		
		JLabel labelFilosofo4 = new JLabel("Filosofo 4");
		labelFilosofo4.setBounds(640, 588, 94, 98);
		labelFilosofo4.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo4);
		
		JLabel labelFilosofo5 = new JLabel("Filosofo 4");
		labelFilosofo5.setBounds(276, 599, 94, 98);
		labelFilosofo5.setIcon(imageNormal);
		panelMainButton.add(labelFilosofo5);
		
		
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
					System.out.println("Ho interotto Esecuzione di entrambi i filosofi " + i);
				}
				framechiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonIndietro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonIndietro.setBounds(10, 135, 128, 46);
		panelMainButton.add(buttonIndietro);
		
		
		JPanel panelSuperiore = new JPanel();
		panelSuperiore.setBackground(new Color(204, 204, 255));
		panelSuperiore.setBounds(0, 0, 1414, 124);
		panelMainButton.add(panelSuperiore);
		panelSuperiore.setLayout(null);

        JSlider sliderVelocitaMangia = new JSlider(1,5,3);
       
        sliderVelocitaMangia.setBounds(996, 439, 206, 60);
        sliderVelocitaMangia.setPreferredSize(new Dimension(250, 60));
        sliderVelocitaMangia.setPaintTrack(true);
        sliderVelocitaMangia.setPaintLabels(true);
        sliderVelocitaMangia.setPaintTicks(true);
        sliderVelocitaMangia.setMajorTickSpacing(1);
        sliderVelocitaMangia.setMinorTickSpacing(3);
        panelMainButton.add(sliderVelocitaMangia);
        
        JSlider sliderVelocitaPensa = new JSlider(1, 5, 3);
        sliderVelocitaPensa.setPreferredSize(new Dimension(250, 60));
        sliderVelocitaPensa.setPaintTrack(true);
        sliderVelocitaPensa.setPaintTicks(true);
        sliderVelocitaPensa.setPaintLabels(true);
        sliderVelocitaPensa.setMinorTickSpacing(3);
        sliderVelocitaPensa.setMajorTickSpacing(1);
        sliderVelocitaPensa.setBounds(996, 552, 206, 60);
        panelMainButton.add(sliderVelocitaPensa);
		
		JLabel labelSchemata = new JLabel("Filosofi A Cena ");
		labelSchemata.setBounds(531, 11, 404, 89);
		panelSuperiore.add(labelSchemata);
		labelSchemata.setFont(new Font("Segoe UI", Font.BOLD, 48));
		
		JLabel labelTavola = new JLabel("tavola");
		labelTavola.setBounds(266, 281, 482, 371);
		labelTavola.setIcon(imageTavola);
		panelMainButton.add(labelTavola);
		ButtonGroup groupSceltaStrategiaFilosofi = new ButtonGroup();
		JRadioButton radioDefault = new JRadioButton("Nessuno");
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
					System.out.println("Ho interotto Esecuzione di entrambi i filosofi " + i);
				}
			}
		});
		radioDefault.setBounds(996, 239, 175, 36);
		groupSceltaStrategiaFilosofi.add(radioDefault);
		panelMainButton.add(radioDefault);
		
		
		JRadioButton radioClassico = new JRadioButton("Schema Classico");
		radioClassico.setToolTipText("Ogni filosofo aspetta prende la bacchetta di sinistra ed aspetto quella di destra");
		radioClassico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (radioClassico.isSelected()) 
				{
					continuaBoolean=false;
					if (deadlockBoolean) 
					{
						deadlockBoolean=false;
						labelTavola.setIcon(imageTavola);
					}
					for (int i = 0; i < threadClassico.length; i++) 
					{
						filosofiAtomici[i].stop();
						System.out.println("Ho interotto Esecuzione dei filosofi atomici " + i);
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
		radioClassico.setBounds(996, 278, 175, 36);
		groupSceltaStrategiaFilosofi.add(radioClassico);
		panelMainButton.add(radioClassico);
		
		JRadioButton radioAtomico = new JRadioButton("Schema Atomico");
		radioAtomico.setToolTipText("Ogni filosofo aspetta e posa entrambi le bacchette conteporaneamente");
		radioAtomico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (radioAtomico.isSelected()) 
				{
					continuaBoolean=false;
					if (deadlockBoolean) 
					{
						deadlockBoolean=false;
						labelTavola.setIcon(imageTavola);
					}
					for (int i = 0; i < threadAtomico.length; i++) 
					{
						filosofiClassica[i].stop();
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
						System.out.println("Ho interotto Esecuzione dei filosofi Classici" + i);
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
		radioAtomico.setBounds(996, 321, 175, 36);
		radioAtomico.setFont(new Font("Segoe UI", Font.BOLD, 13));
		groupSceltaStrategiaFilosofi.add(radioAtomico);
		panelMainButton.add(radioAtomico);
		
		
		
		JButton buttonEsci = new JButton("Esci");
		buttonEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JRadioButton radioCoda = new JRadioButton("Schema Coda");
		radioCoda.setToolTipText("Ogni filosofo aspetta e posa entrambi le bacchette conteporaneamente");
		radioCoda.setFont(new Font("Segoe UI", Font.BOLD, 13));
		radioCoda.setBounds(996, 361, 206, 44);
		panelMainButton.add(radioCoda);
		buttonEsci.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonEsci.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonEsci.setBackground(new Color(255, 204, 0));
		buttonEsci.setBounds(141, 134, 128, 48);
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
	    btnSlideArgomento.setBounds(279, 134, 128, 48);
        panelMainButton.add(btnSlideArgomento);
        
        sliderVelocitaMangia.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseReleased(MouseEvent e) 
        	{
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
        	}
        });

     
     
        JLabel labelSliderMangia = new JLabel("Velocita Mangia : ");
        labelSliderMangia.setFont(new Font("Segoe UI", Font.BOLD, 11));
        labelSliderMangia.setBounds(996, 410, 143, 30);
        panelMainButton.add(labelSliderMangia);
        
        JLabel labelSliderPensa = new JLabel("Velocita Pensa  : ");
        labelSliderPensa.setFont(new Font("Segoe UI", Font.BOLD, 11));
        labelSliderPensa.setBounds(996, 522, 143, 30);
        panelMainButton.add(labelSliderPensa);
        
        sliderVelocitaPensa.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseReleased(MouseEvent e) 
        	{
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
        	}
        });
        
        frame.setVisible(true); 
		
		
	}
}
