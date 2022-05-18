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

import javax.swing.BorderFactory;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JRadioButton;

public class Hashing extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	public 	boolean puoiCambiare=false;
	public 	boolean puoiCambiareSpeciale=false;
	public int iteratoreScorittore;

	/**
	 * Create the frame.
	 */
	public Hashing(JFrame framechiamante) 
	{

		
		iteratoreScorittore=0;
		//Dizionario Parole
		String [] dizionarioParola = {"Vulcano","Amico","Organo","Rame","Gorilla","Orzo","Noci","Melanzana","Cristallo","Pavimento","Risotto","Sei","Stalattiti","Sinistra",
				"Siluro","Lavandino","Furbo","Moneta","Lampada","Camomilla","Proboscide","Russo","Blu","Valigia","Gorilla","Macchia","Grotta","Mutande","Pasta",
				"Cornice","Oggetto","Incrocio","Pannocchia","Scarpa","Giorno","Computer","Scaffale","Tanga","Pasta","Contenitore","Medicina","Sensuale","Viso","Elettricità","Canile"};
		ArrayList<parolaHashing> listaParolaHashings = new ArrayList<parolaHashing>();
		Random randomGenerator = new Random();
		
		
		
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
		textParoleBase.setFont(new Font("Arial", Font.PLAIN, 22));
		textParoleBase.setEditable(false);
		textParoleBase.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textParoleBase.setBounds(26, 237, 264, 406);
		panelMainButton.add(textParoleBase);
		
		JPanel panelControllo = new JPanel();
		panelControllo.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		panelControllo.setBounds(1130, 76, 274, 670);
		panelMainButton.add(panelControllo);
		panelControllo.setLayout(null);
		
		JLabel labelgenerale = new JLabel("       Plot :");
		labelgenerale.setForeground(Color.RED);
		labelgenerale.setVerticalAlignment(SwingConstants.BOTTOM);
		labelgenerale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelgenerale.setBounds(68, 80, 122, 26);
		panelControllo.add(labelgenerale);
		
		JPanel panelPlot = new JPanel();
		panelPlot.setBounds(10, 107, 254, 180);
		panelPlot.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		panelControllo.add(panelPlot);
		panelPlot.setLayout(null);
		
		JButton buttonGeneraEsempio = new JButton("GENERA PAROLE");
		
		
		buttonGeneraEsempio.setBackground(Color.WHITE);
		buttonGeneraEsempio.addMouseListener(new MouseAdapter() {
			@Override
        	public void mouseEntered(MouseEvent e) 
        	{
        		buttonGeneraEsempio.setBackground(new Color(229,57,53));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) 
        	{
        		buttonGeneraEsempio.setBackground(Color.WHITE);
        	}
		});
		
		
		buttonGeneraEsempio.setBorder(new LineBorder(new Color(229,57,53), 2, true));
		buttonGeneraEsempio.setFont(new Font("Arial", Font.BOLD, 15));
		buttonGeneraEsempio.setBounds(15, 78, 224, 34);
		panelPlot.add(buttonGeneraEsempio);
		
		JComboBox comboBoxSceltaNParole = new JComboBox();
		
		
		comboBoxSceltaNParole.setEnabled(false);
		comboBoxSceltaNParole.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxSceltaNParole.setBackground(new Color(255, 255, 255));
		comboBoxSceltaNParole.setModel(new DefaultComboBoxModel(new String[] {"9","8","7","6", "5", "4"}));
		comboBoxSceltaNParole.setBounds(193, 22, 51, 22);
		panelPlot.add(comboBoxSceltaNParole);
		
		JLabel labelGrandezza = new JLabel("Grandezza Dizionario : ");
		labelGrandezza.setEnabled(false);
		labelGrandezza.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelGrandezza.setBounds(20, 22, 160, 22);
		panelPlot.add(labelGrandezza);
		
		JLabel labelPlay = new JLabel(">");
		labelPlay.setEnabled(false);
		
		labelPlay.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelPlay.setBounds(52, 123, 39, 35);
		labelPlay.setIcon(new ImageIcon(Hashing.class.getResource("/img/playIcon2.png")));
		panelPlot.add(labelPlay);
		
		JLabel labelScrittaPlay = new JLabel("Codifica Tutto");
		labelScrittaPlay.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelScrittaPlay.setEnabled(false);
		labelScrittaPlay.setBounds(35, 157, 75, 17);
		panelPlot.add(labelScrittaPlay);
		
		JLabel labelScrittaFast = new JLabel("Codifica Passo");
		labelScrittaFast.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelScrittaFast.setEnabled(false);
		labelScrittaFast.setBounds(140, 157, 75, 17);
		panelPlot.add(labelScrittaFast);
		
		JLabel labelFastForward = new JLabel(">>");
		
		labelFastForward.setIcon(new ImageIcon(Hashing.class.getResource("/img/fastFowardIcon1.png")));
		labelFastForward.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelFastForward.setEnabled(false);
		labelFastForward.setBounds(157, 123, 39, 35);
		panelPlot.add(labelFastForward);
		
		
		
		JPanel panelSomma = new JPanel();
		panelSomma.setLayout(null);
		panelSomma.setBounds(10, 313, 254, 135);
		panelSomma.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		panelControllo.add(panelSomma);
		
		JRadioButton radioSommaNormale = new JRadioButton("Somma di Caratteri");
		
		
		radioSommaNormale.setSelected(true);
		radioSommaNormale.setEnabled(false);
		radioSommaNormale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioSommaNormale.setBounds(6, 31, 189, 31);
		panelSomma.add(radioSommaNormale);
		
		JRadioButton radioSommaMultipla = new JRadioButton("Somma di Caratteri Quadratica");
		radioSommaMultipla.setEnabled(false);
		radioSommaMultipla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioSommaMultipla.setBounds(6, 74, 213, 31);
		panelSomma.add(radioSommaMultipla);
		
		JLabel labelSomma = new JLabel("    Somma : ");
		labelSomma.setForeground(Color.RED);
		labelSomma.setVerticalAlignment(SwingConstants.BOTTOM);
		labelSomma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelSomma.setBounds(75, 287, 122, 26);
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
		labelCodifica.setBounds(91, 459, 122, 26);
		panelControllo.add(labelCodifica);
		
		JPanel panelCodifica = new JPanel();
		panelCodifica.setLayout(null);
		panelCodifica.setBounds(10, 485, 254, 180);
		panelCodifica.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		panelControllo.add(panelCodifica);
		
		JRadioButton radioXmod = new JRadioButton("x Mod 8");
		radioXmod.setEnabled(false);
		radioXmod.setSelected(true);
		radioXmod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioXmod.setBounds(6, 31, 189, 31);
		panelCodifica.add(radioXmod);
		
		JRadioButton radio5xMod8 = new JRadioButton("(5x + 2 ) mod 8 ");
		radio5xMod8.setEnabled(false);
		radio5xMod8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radio5xMod8.setBounds(6, 74, 213, 31);
		panelCodifica.add(radio5xMod8);
		
		JRadioButton radioxJ2mod8 = new JRadioButton("(x + J\u00B2) mod 8");
		radioxJ2mod8.setEnabled(false);
		radioxJ2mod8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioxJ2mod8.setBounds(6, 115, 213, 31);
		panelCodifica.add(radioxJ2mod8);
		
		ButtonGroup groupSomma = new ButtonGroup();
		groupSomma.add(radioSommaNormale);
		groupSomma.add(radioSommaMultipla);
		ButtonGroup groupCodifica = new ButtonGroup();
		groupCodifica.add(radioXmod);
		groupCodifica.add(radio5xMod8);
		groupCodifica.add(radioxJ2mod8);
		
		JLabel labelPnlCtrl = new JLabel("Pannello di controllo");
		labelPnlCtrl.setBorder(new LineBorder(new Color (30, 136, 229), 2));
		labelPnlCtrl.setHorizontalAlignment(SwingConstants.CENTER);
		labelPnlCtrl.setFont(new Font("Arial", Font.BOLD, 22));
		labelPnlCtrl.setBounds(14, 11, 245, 54);
		panelControllo.add(labelPnlCtrl);
		
		JLabel labelDizionario = new JLabel("PAROLE ORIGINALI : ");
		labelDizionario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelDizionario.setBounds(89, 183, 139, 46);
		panelMainButton.add(labelDizionario);
		
		JTextArea textParoleSommate = new JTextArea();
		textParoleSommate.setFont(new Font("Arial", Font.PLAIN, 22));
		textParoleSommate.setEditable(false);
		textParoleSommate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textParoleSommate.setBounds(434, 237, 251, 406);
		panelMainButton.add(textParoleSommate);
		
		JLabel labelCodifica1 = new JLabel("SOMMA CARATTERI : ");
		labelCodifica1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelCodifica1.setBounds(485, 183, 157, 46);
		panelMainButton.add(labelCodifica1);
		
		JLabel labelSomma2 = new JLabel("CODIFICA FINALE :");
		labelSomma2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelSomma2.setBounds(925, 192, 134, 29);
		panelMainButton.add(labelSomma2);
		
		JTextArea textParoleCodificate = new JTextArea();
		textParoleCodificate.setFont(new Font("Arial", Font.PLAIN, 22));
		textParoleCodificate.setEditable(false);
		textParoleCodificate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textParoleCodificate.setBounds(866, 237, 236, 406);
		panelMainButton.add(textParoleCodificate);
		
		JLabel labelFrecciaSomma = new JLabel("Somma ->");
		labelFrecciaSomma.setIcon(new ImageIcon(Hashing.class.getResource("/img/frecciaDestraIcon1.png")));
		labelFrecciaSomma.setBounds(300, 367, 124, 111);
		panelMainButton.add(labelFrecciaSomma);
		
		JLabel labelFrecciaCodifica = new JLabel("Codifica ->");
		labelFrecciaCodifica.setIcon(new ImageIcon(Hashing.class.getResource("/img/frecciaDestraIcon1.png")));
		labelFrecciaCodifica.setBounds(719, 367, 124, 111);
		panelMainButton.add(labelFrecciaCodifica);
		
		JLabel labelFrecciaScrittaSomma = new JLabel("");
		labelFrecciaScrittaSomma.setBounds(292, 382, 69, 14);
		panelMainButton.add(labelFrecciaScrittaSomma);
		
		JLabel labelFrecciaScrittaCodifica = new JLabel("");
		labelFrecciaScrittaCodifica.setBounds(689, 385, 89, 14);
		panelMainButton.add(labelFrecciaScrittaCodifica);
		buttonGeneraEsempio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				iteratoreScorittore=0;
				//Generazione varibiali 
				labelFrecciaScrittaSomma.setText("");
				labelFrecciaScrittaCodifica.setText("");
				puoiCambiare=false;
				puoiCambiareSpeciale=false;
				int indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
				boolean tuttook= true;
				//Enable e Flush degl Elementi
				comboBoxSceltaNParole.setEnabled(true);
				listaParolaHashings.removeAll(listaParolaHashings);
				labelGrandezza.setEnabled(true);
				labelFastForward.setEnabled(true);
				labelScrittaFast.setEnabled(true);
				labelScrittaPlay.setEnabled(true);
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
				iteratoreScorittore=0;
				puoiCambiare=false;
				puoiCambiareSpeciale=false;
				labelFastForward.setEnabled(true);
				labelScrittaFast.setEnabled(true);
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
				labelFastForward.setEnabled(false);
				labelScrittaFast.setEnabled(false);
				puoiCambiare=true;
				textParoleSommate.setText("");
				textParoleCodificate.setText("");
				for (parolaHashing iteraParolaHashing : listaParolaHashings) 
				{	
					//Per La Somma
					if (radioSommaNormale.isSelected()) 
					{
						textParoleSommate.append(""+iteraParolaHashing.sommaNormale()+"\n");
						labelFrecciaScrittaSomma.setText("S. Normale");
					}
					else 
					{
						textParoleSommate.append(""+iteraParolaHashing.sommaquadatrica()+"\n");
						labelFrecciaScrittaSomma.setText("S. Quadrica");
					}
					
					//Per La Codifica
					if(radioXmod.isSelected())
					{
						textParoleCodificate.append(""+iteraParolaHashing.xMod8()+"\n");
						labelFrecciaScrittaCodifica.setText("X mod 8");
					}
					else if (radio5xMod8.isSelected())
					{
						textParoleCodificate.append(""+iteraParolaHashing.x5_2mod8()+"\n");
						labelFrecciaScrittaCodifica.setText("(5x + 2 ) mod 8 ");
					}
					else if(radioxJ2mod8.isSelected())
					{
						textParoleCodificate.append(""+iteraParolaHashing.x_j2mod8()+"\n");
						labelFrecciaScrittaCodifica.setText("(x + J²) mod 8");
					}
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelScrittaPlay.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				labelScrittaPlay.setForeground(Color.BLACK);
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
					labelFrecciaScrittaSomma.setText("S. Normale");
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
				else if (puoiCambiareSpeciale)
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					labelFrecciaScrittaSomma.setText("S. Normale");
					for (int i = 0; i < iteratoreScorittore; i++) 
					{
						textParoleSommate.append(""+listaParolaHashings.get(i).sommaNormale()+"\n");
						
						//Per La Codifica
						if(radioXmod.isSelected())
						{
							textParoleCodificate.append(""+listaParolaHashings.get(i).xMod8()+"\n");
						}
						else if (radio5xMod8.isSelected())
						{
							textParoleCodificate.append(""+listaParolaHashings.get(i).x5_2mod8()+"\n");
						}
						else if(radioxJ2mod8.isSelected())
						{
							textParoleCodificate.append(""+listaParolaHashings.get(i).x_j2mod8()+"\n");
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
					labelFrecciaScrittaSomma.setText("S. Quadrica");
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
				else if (puoiCambiareSpeciale) 
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					labelFrecciaScrittaSomma.setText("S. Quadrica");
					for (int i = 0; i < iteratoreScorittore; i++) 
					{	
						textParoleSommate.append(""+listaParolaHashings.get(i).sommaquadatrica()+"\n");
						//Per La Codifica
						if(radioXmod.isSelected())
						{
							textParoleCodificate.append(""+listaParolaHashings.get(i).xMod8()+"\n");
						}
						else if (radio5xMod8.isSelected())
						{
							textParoleCodificate.append(""+listaParolaHashings.get(i).x5_2mod8()+"\n");
						}
						else if(radioxJ2mod8.isSelected())
						{
							textParoleCodificate.append(""+listaParolaHashings.get(i).x_j2mod8()+"\n");
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
					labelFrecciaScrittaCodifica.setText("X mod 8");
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
				else if (puoiCambiareSpeciale)
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					labelFrecciaScrittaCodifica.setText("X mod 8");
					for (int i = 0; i < iteratoreScorittore; i++) 
					{
						textParoleCodificate.append(""+listaParolaHashings.get(i).xMod8()+"\n");
						//Per La Somma
						if (radioSommaNormale.isSelected()) 
						{
							textParoleSommate.append(""+listaParolaHashings.get(i).sommaNormale()+"\n");
						}
						else 
						{
							textParoleSommate.append(""+listaParolaHashings.get(i).sommaquadatrica()+"\n");
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
					labelFrecciaScrittaCodifica.setText("(5x + 2 ) mod 8 ");
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
				else if (puoiCambiareSpeciale)
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					labelFrecciaScrittaCodifica.setText("(5x + 2 ) mod 8 ");
					for (int i = 0; i < iteratoreScorittore; i++) 
					{
						textParoleCodificate.append(""+listaParolaHashings.get(i).x5_2mod8()+"\n");
						//Per La Somma
						if (radioSommaNormale.isSelected()) 
						{
							textParoleSommate.append(""+listaParolaHashings.get(i).sommaNormale()+"\n");
						}
						else 
						{
							textParoleSommate.append(""+listaParolaHashings.get(i).sommaquadatrica()+"\n");
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
					labelFrecciaScrittaCodifica.setText("(x + J²) mod 8");
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
				else if (puoiCambiareSpeciale)
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					labelFrecciaScrittaCodifica.setText("(x + J²) mod 8");
					for (int i = 0; i < iteratoreScorittore; i++) 
					{
						textParoleCodificate.append(""+listaParolaHashings.get(i).x_j2mod8()+"\n");
						//Per La Somma
						if (radioSommaNormale.isSelected()) 
						{
							textParoleSommate.append(""+listaParolaHashings.get(i).sommaNormale()+"\n");
						}
						else 
						{
							textParoleSommate.append(""+listaParolaHashings.get(i).sommaquadatrica()+"\n");
						}	
					}
				}
			}
		});
		labelFastForward.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				labelPlay.setEnabled(false);
				labelScrittaPlay.setEnabled(false);
				
				if (iteratoreScorittore<=listaParolaHashings.size()) 
				{
					if (iteratoreScorittore!=listaParolaHashings.size()) 
					{
						iteratoreScorittore++;
					}
					puoiCambiareSpeciale=true;
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					for (int i = 0; i < iteratoreScorittore; i++) 
					{
						//Per La Somma
						if (radioSommaNormale.isSelected()) 
						{
							textParoleSommate.append(""+listaParolaHashings.get(i).sommaNormale()+"\n");
							labelFrecciaScrittaSomma.setText("S. Normale");
						}
						else 
						{
							textParoleSommate.append(""+listaParolaHashings.get(i).sommaquadatrica()+"\n");
							labelFrecciaScrittaSomma.setText("S. Quadrica");
						}
						
						//Per La Codifica
						if(radioXmod.isSelected())
						{
							textParoleCodificate.append(""+listaParolaHashings.get(i).xMod8()+"\n");
							labelFrecciaScrittaCodifica.setText("X mod 8");
						}
						else if (radio5xMod8.isSelected())
						{
							textParoleCodificate.append(""+listaParolaHashings.get(i).x5_2mod8()+"\n");
							labelFrecciaScrittaCodifica.setText("(5x + 2 ) mod 8 ");
						}
						else if(radioxJ2mod8.isSelected())
						{
							textParoleCodificate.append(""+listaParolaHashings.get(i).x_j2mod8()+"\n");
							labelFrecciaScrittaCodifica.setText("(x + J²) mod 8");
						}
					}
				
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				labelScrittaFast.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				labelScrittaFast.setForeground(Color.BLACK);
			}
		});
	
	}
}
