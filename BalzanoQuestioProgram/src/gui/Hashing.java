package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.parolaHashing;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class Hashing extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	public 	boolean puoiCambiare=false;

	/**
	 * Create the frame.
	 */
	public Hashing(JFrame framechiamante) 
	{
		//Dizionario Parole
		String [] dizionarioParola = {"Vulcano","Amico","Organo","Rame","Gorilla","Orzo","Noci","Melanzana","Cristallo","Pavimento","Risotto","Sei","Stalattiti","Sinistra",
				"Siluro","Lavandino","Furbo","Moneta","Lampada","Camomilla","Proboscide","Russo","Blu","Valigia","Gorilla","Macchia","Grotta","Mutande","Pasta",
				"Cornice","Oggetto","Incrocio","Pannocchia","Scarpa","Giorno","Computer","Scaffale","Tanga","Pasta","Contenitore","Medicina","Sensuale","Viso","Elettricità","Canile"};
		ArrayList<parolaHashing> listaParolaHashings = new ArrayList<parolaHashing>();
		Random randomGenerator = new Random();
		
		
		ImageIcon imagePlay = new ImageIcon(this.getClass().getResource("/img/playIcon1.png"));
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelMainButton = new JPanel();
		panelMainButton.setToolTipText("Parole base prese da dizionario di sistema\r\n");
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);
		JPanel panelSuperiore = new JPanel();
		panelSuperiore.setBorder(new LineBorder(new Color (30, 136, 229), 5));
		panelSuperiore.setBounds(0, 0, 1414, 73);
		panelMainButton.add(panelSuperiore);
		panelSuperiore.setLayout(null);
		
		JLabel labelSchemata = new JLabel("HASHING");
		labelSchemata.setBounds(559, 0, 262, 73);
		panelSuperiore.add(labelSchemata);
		labelSchemata.setFont(new Font("Segoe UI", Font.BOLD, 48));
		
		JTextArea textParoleBase = new JTextArea();
		textParoleBase.setFont(new Font("Arial", Font.PLAIN, 18));
		textParoleBase.setEditable(false);
		textParoleBase.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textParoleBase.setBounds(50, 250, 210, 406);
		panelMainButton.add(textParoleBase);
		
		JPanel panelControllo = new JPanel();
		panelControllo.setBorder(new LineBorder(new Color(255, 102, 51), 2));
		panelControllo.setBounds(1130, 76, 274, 664);
		panelMainButton.add(panelControllo);
		panelControllo.setLayout(null);
		
		JLabel labelgenerale = new JLabel("       Plot :");
		labelgenerale.setForeground(Color.RED);
		labelgenerale.setVerticalAlignment(SwingConstants.BOTTOM);
		labelgenerale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelgenerale.setBounds(68, 58, 122, 26);
		panelControllo.add(labelgenerale);
		
		JPanel panelPlot = new JPanel();
		panelPlot.setBorder(new LineBorder(new Color(204, 0, 0), 2, true));
		panelPlot.setBounds(10, 85, 254, 169);
		panelControllo.add(panelPlot);
		panelPlot.setLayout(null);
		
		JButton buttonGeneraEsempio = new JButton("Genera Esempio");
		
		
		buttonGeneraEsempio.setBorder(new LineBorder(Color.RED, 2, true));
		buttonGeneraEsempio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		buttonGeneraEsempio.setBounds(69, 78, 127, 34);
		panelPlot.add(buttonGeneraEsempio);
		
		JComboBox comboBoxSceltaNParole = new JComboBox();
		
		
		comboBoxSceltaNParole.setEnabled(false);
		comboBoxSceltaNParole.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxSceltaNParole.setBackground(new Color(255, 255, 255));
		comboBoxSceltaNParole.setModel(new DefaultComboBoxModel(new String[] {"9","8","7","6", "5", "4"}));
		comboBoxSceltaNParole.setBounds(167, 46, 50, 21);
		panelPlot.add(comboBoxSceltaNParole);
		
		JLabel labelGrandezza = new JLabel("Grandezza Dizionario : ");
		labelGrandezza.setEnabled(false);
		labelGrandezza.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		labelGrandezza.setBounds(31, 45, 126, 22);
		panelPlot.add(labelGrandezza);
		
		JLabel labelPlay = new JLabel(">");
		labelPlay.setEnabled(false);
		
		labelPlay.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelPlay.setBounds(110, 123, 39, 35);
		labelPlay.setIcon(imagePlay);
		panelPlot.add(labelPlay);
		
		
		
		JPanel panelSomma = new JPanel();
		panelSomma.setLayout(null);
		panelSomma.setBorder(new LineBorder(new Color(204, 0, 0), 2, true));
		panelSomma.setBounds(10, 279, 254, 135);
		panelControllo.add(panelSomma);
		
		JRadioButton radioSommaNormale = new JRadioButton("Somma di Caratteri");
		
		
		radioSommaNormale.setSelected(true);
		radioSommaNormale.setEnabled(false);
		radioSommaNormale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioSommaNormale.setBounds(6, 31, 189, 31);
		panelSomma.add(radioSommaNormale);
		
		JRadioButton radioSommaMultipla = new JRadioButton("Somma di Caratteri Quadratica");
		radioSommaMultipla.setEnabled(false);
		radioSommaMultipla.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioSommaMultipla.setBounds(6, 74, 213, 31);
		panelSomma.add(radioSommaMultipla);
		
		JLabel labelSomma = new JLabel("    Somma : ");
		labelSomma.setForeground(Color.RED);
		labelSomma.setVerticalAlignment(SwingConstants.BOTTOM);
		labelSomma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelSomma.setBounds(68, 253, 122, 26);
		panelControllo.add(labelSomma);
		
		JLabel labelScrittaIndietro = new JLabel(" Indietro");
        labelScrittaIndietro.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelScrittaIndietro.setBounds(12, 132, 53, 12);
        panelMainButton.add(labelScrittaIndietro);
        
        JLabel labelIndietroIcon = new JLabel("Exit");
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
        
      
		JLabel labelCodifica = new JLabel("Codifica :");
		labelCodifica.setForeground(Color.RED);
		labelCodifica.setVerticalAlignment(SwingConstants.BOTTOM);
		labelCodifica.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		labelCodifica.setBounds(91, 425, 122, 26);
		panelControllo.add(labelCodifica);
		
		JPanel panelCodifica = new JPanel();
		panelCodifica.setLayout(null);
		panelCodifica.setBorder(new LineBorder(new Color(204, 0, 0), 2, true));
		panelCodifica.setBounds(10, 451, 254, 180);
		panelControllo.add(panelCodifica);
		
		JRadioButton radioXmod = new JRadioButton("x Mod 8");
		radioXmod.setEnabled(false);
		radioXmod.setSelected(true);
		radioXmod.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioXmod.setBounds(6, 31, 189, 31);
		panelCodifica.add(radioXmod);
		
		JRadioButton radio5xMod8 = new JRadioButton("(5x + 2 ) mod 8 ");
		radio5xMod8.setEnabled(false);
		radio5xMod8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radio5xMod8.setBounds(6, 74, 213, 31);
		panelCodifica.add(radio5xMod8);
		
		JRadioButton radioxJ2mod8 = new JRadioButton("(x + J\u00B2) mod 8");
		radioxJ2mod8.setEnabled(false);
		radioxJ2mod8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioxJ2mod8.setBounds(6, 115, 213, 31);
		panelCodifica.add(radioxJ2mod8);
		
		ButtonGroup groupSomma = new ButtonGroup();
		groupSomma.add(radioSommaNormale);
		groupSomma.add(radioSommaMultipla);
		ButtonGroup groupCodifica = new ButtonGroup();
		groupCodifica.add(radioXmod);
		groupCodifica.add(radio5xMod8);
		groupCodifica.add(radioxJ2mod8);
		
		JLabel labelDizionario = new JLabel("Dizionario :");
		labelDizionario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelDizionario.setBounds(50, 210, 116, 29);
		panelMainButton.add(labelDizionario);
		
		JTextArea textParoleSommate = new JTextArea();
		textParoleSommate.setFont(new Font("Arial", Font.PLAIN, 18));
		textParoleSommate.setEditable(false);
		textParoleSommate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textParoleSommate.setBounds(417, 250, 210, 406);
		panelMainButton.add(textParoleSommate);
		
		JLabel labelCodifica1 = new JLabel("Somma : ");
		labelCodifica1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelCodifica1.setBounds(411, 210, 116, 29);
		panelMainButton.add(labelCodifica1);
		
		JLabel labelSomma2 = new JLabel("Codifica :");
		labelSomma2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelSomma2.setBounds(812, 210, 116, 29);
		panelMainButton.add(labelSomma2);
		
		JTextArea textParoleCodificate = new JTextArea();
		textParoleCodificate.setFont(new Font("Arial", Font.PLAIN, 18));
		textParoleCodificate.setEditable(false);
		textParoleCodificate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textParoleCodificate.setBounds(814, 250, 199, 406);
		panelMainButton.add(textParoleCodificate);
		buttonGeneraEsempio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Generazione varibiali 
				puoiCambiare=false;
				int indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
				boolean tuttook= true;
				//Enable e Flush degl Elementi
				comboBoxSceltaNParole.setEnabled(true);
				listaParolaHashings.removeAll(listaParolaHashings);
				labelGrandezza.setEnabled(true);
				labelPlay.setEnabled(true);
				textParoleBase.setText("");
				textParoleSommate.setText("");
				textParoleCodificate.setText("");
				radioSommaNormale.setEnabled(true);
				radioSommaMultipla.setEnabled(true);
				radioXmod.setEnabled(true);
				radioxJ2mod8.setEnabled(true);
				radio5xMod8.setEnabled(true);
				String numeroParoleString = (String) comboBoxSceltaNParole.getSelectedItem();
				int numeroParoleInt=Integer.valueOf(numeroParoleString);
				//Generazione Parole
				for (int i = 0; i < numeroParoleInt ; i++) 
				{
					indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
					if (listaParolaHashings.size()==0) 
					{
						
						listaParolaHashings.add(new parolaHashing(dizionarioParola[indexDaEstrarre], indexDaEstrarre, i));
						textParoleBase.append(listaParolaHashings.get(0).parola+ "\n");
					}
					else 
					{
						while (tuttook) 
						{
							
							for (parolaHashing iteratore : listaParolaHashings) 
							{
								if(iteratore.indexString==indexDaEstrarre)
								{
									tuttook=false;
									break;
								}
							}
							if (tuttook==true)
							{
								listaParolaHashings.add(new parolaHashing(dizionarioParola[indexDaEstrarre], indexDaEstrarre, i));
								textParoleBase.append(listaParolaHashings.get(listaParolaHashings.size()-1).parola+ "\n");
								tuttook=false;
							}
							else 
							{
								indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
								tuttook=true;
							}
						}
						tuttook=true;
					}
				}
				
			}
		});
		comboBoxSceltaNParole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Generazione varibiali 
				int indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
				boolean tuttook= true;
				//Enable e Flush degl Elementi
				comboBoxSceltaNParole.setEnabled(true);
				listaParolaHashings.removeAll(listaParolaHashings);
				textParoleBase.setText("");
				textParoleSommate.setText("");
				textParoleCodificate.setText("");
				String numeroParoleString = (String) comboBoxSceltaNParole.getSelectedItem();
				int numeroParoleInt=Integer.valueOf(numeroParoleString);
				//Generazione Parole
				for (int i = 0; i < numeroParoleInt ; i++) 
				{
					indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
					if (listaParolaHashings.size()==0) 
					{
						
						listaParolaHashings.add(new parolaHashing(dizionarioParola[indexDaEstrarre], indexDaEstrarre, i));
						textParoleBase.append(listaParolaHashings.get(0).parola+ "\n");
					}
					else 
					{
						while (tuttook) 
						{
							
							for (parolaHashing iteratore : listaParolaHashings) 
							{
								if(iteratore.indexString==indexDaEstrarre)
								{
									tuttook=false;
									break;
								}
							}
							if (tuttook==true)
							{
								listaParolaHashings.add(new parolaHashing(dizionarioParola[indexDaEstrarre], indexDaEstrarre, i));
								textParoleBase.append(listaParolaHashings.get(listaParolaHashings.size()-1).parola+ "\n");
								tuttook=false;
							}
							else 
							{
								indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
								tuttook=true;
							}
						}
						tuttook=true;
					}
				}
			}
		});
		
		labelPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				puoiCambiare=true;
				textParoleSommate.setText("");
				textParoleCodificate.setText("");
				for (parolaHashing iteraParolaHashing : listaParolaHashings) 
				{	
					//Per La Somma
					if (radioSommaNormale.isSelected()) 
					{
						textParoleSommate.append(""+iteraParolaHashing.sommaNormale()+"\n");
					}
					else 
					{
						textParoleSommate.append(""+iteraParolaHashing.sommaquadatrica()+"\n");
					}
					
					//Per La Codifica
					if(radioXmod.isSelected())
					{
						textParoleCodificate.append(""+iteraParolaHashing.xMod8()+"\n");
					}
					else if (radio5xMod8.isSelected())
					{
						textParoleCodificate.append(""+iteraParolaHashing.x5_2mod8()+"\n");
					}
					else if(radioxJ2mod8.isSelected())
					{
						textParoleCodificate.append(""+iteraParolaHashing.x_j2mod8()+"\n");
					}
					
				}
			}
		});
		radioSommaNormale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (puoiCambiare) 
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					for (parolaHashing iteraParolaHashing : listaParolaHashings) 
					{	
						textParoleSommate.append(""+iteraParolaHashing.sommaNormale()+"\n");
						//Per La Codifica
						if(radioXmod.isSelected())
						{
							textParoleCodificate.append(""+iteraParolaHashing.xMod8()+"\n");
						}
						else if (radio5xMod8.isSelected())
						{
							textParoleCodificate.append(""+iteraParolaHashing.x5_2mod8()+"\n");
						}
						else if(radioxJ2mod8.isSelected())
						{
							textParoleCodificate.append(""+iteraParolaHashing.x_j2mod8()+"\n");
						}
					}
				}
			}
		});
		radioSommaMultipla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (puoiCambiare) 
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					for (parolaHashing iteraParolaHashing : listaParolaHashings) 
					{	
						textParoleSommate.append(""+iteraParolaHashing.sommaquadatrica()+"\n");
						//Per La Codifica
						if(radioXmod.isSelected())
						{
							textParoleCodificate.append(""+iteraParolaHashing.xMod8()+"\n");
						}
						else if (radio5xMod8.isSelected())
						{
							textParoleCodificate.append(""+iteraParolaHashing.x5_2mod8()+"\n");
						}
						else if(radioxJ2mod8.isSelected())
						{
							textParoleCodificate.append(""+iteraParolaHashing.x_j2mod8()+"\n");
						}
					}
				}
			}
		});
		radioXmod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (puoiCambiare) 
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					for (parolaHashing iteraParolaHashing : listaParolaHashings) 
					{	
						textParoleCodificate.append(""+iteraParolaHashing.xMod8()+"\n");
						//Per La Somma
						if (radioSommaNormale.isSelected()) 
						{
							textParoleSommate.append(""+iteraParolaHashing.sommaNormale()+"\n");
						}
						else 
						{
							textParoleSommate.append(""+iteraParolaHashing.sommaquadatrica()+"\n");
						}	
					}
				}
			}
		});
		radio5xMod8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (puoiCambiare) 
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					for (parolaHashing iteraParolaHashing : listaParolaHashings) 
					{	
						textParoleCodificate.append(""+iteraParolaHashing.x5_2mod8()+"\n");
						//Per La Somma
						if (radioSommaNormale.isSelected()) 
						{
							textParoleSommate.append(""+iteraParolaHashing.sommaNormale()+"\n");
						}
						else 
						{
							textParoleSommate.append(""+iteraParolaHashing.sommaquadatrica()+"\n");
						}	
					}
				}
			}
		});
		radioxJ2mod8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (puoiCambiare) 
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					for (parolaHashing iteraParolaHashing : listaParolaHashings) 
					{	
						textParoleCodificate.append(""+iteraParolaHashing.x_j2mod8()+"\n");
						//Per La Somma
						if (radioSommaNormale.isSelected()) 
						{
							textParoleSommate.append(""+iteraParolaHashing.sommaNormale()+"\n");
						}
						else 
						{
							textParoleSommate.append(""+iteraParolaHashing.sommaquadatrica()+"\n");
						}	
					}
				}
			}
		});
		
	
	}
}
