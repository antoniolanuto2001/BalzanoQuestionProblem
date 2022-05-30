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
import java.util.LinkedList;
import java.util.List;
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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Hashing extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	//Chaining
	public  JLabel labelNumero0;
	public  JLabel labelNumero1;
	public  JLabel labelNumero2;
	public  JLabel labelNumero3;
	public  JLabel labelNumero4;
	public  JLabel labelNumero5;
	public  JLabel labelNumero6;
	public  JLabel labelNumero7;
	public 	JLabel labelArrayChaining;
	public  JLabel labelLinked0_1;
	public  JLabel labelLinked0_2;
	public  JLabel labelLinked0_3;
	public  JLabel labelLinked1_1;
	public  JLabel labelLinked1_2;
	public  JLabel labelLinked1_3;
	public  JLabel labelLinked2_1;
	public  JLabel labelLinked2_2;
	public  JLabel labelLinked2_3;
	public  JLabel labelLinked3_1;
	public  JLabel labelLinked3_2;
	public  JLabel labelLinked3_3;
	public  JLabel labelLinked4_1;
	public  JLabel labelLinked4_2;
	public  JLabel labelLinked4_3;
	public  JLabel labelLinked5_1;
	public  JLabel labelLinked5_2;
	public  JLabel labelLinked5_3;
	public  JLabel labelLinked6_1;
	public  JLabel labelLinked6_2;
	public  JLabel labelLinked6_3;
	public  JLabel labelLinked7_1;
	public  JLabel labelLinked7_2;
	public  JLabel labelLinked7_3;
	//Open Addressing
	public  JLabel labelNumero0Addres;
	public  JLabel labelNumero1Addres;
	public  JLabel labelNumero2Addres;
	public  JLabel labelNumero3Addres;
	public  JLabel labelNumero4Addres;
	public  JLabel labelNumero5Addres;
	public  JLabel labelNumero6Addres;
	public  JLabel labelNumero7Addres;
	public  JLabel labelLinked0_1Addres;
	public  JLabel labelLinked0_2Addres;
	public  JLabel labelLinked0_3Addres;
	public  JLabel labelLinked1_1Addres;
	public  JLabel labelLinked1_2Addres;
	public  JLabel labelLinked1_3Addres;
	public  JLabel labelLinked2_1Addres;
	public  JLabel labelLinked2_2Addres;
	public  JLabel labelLinked2_3Addres;
	public  JLabel labelLinked3_1Addres;
	public  JLabel labelLinked3_2Addres;
	public  JLabel labelLinked3_3Addres;
	public  JLabel labelLinked4_1Addres;
	public  JLabel labelLinked4_2Addres;
	public  JLabel labelLinked4_3Addres;
	public  JLabel labelLinked5_1Addres;
	public  JLabel labelLinked5_2Addres;
	public  JLabel labelLinked5_3Addres;
	public  JLabel labelLinked6_1Addres;
	public  JLabel labelLinked6_2Addres;
	public  JLabel labelLinked6_3Addres;
	public  JLabel labelLinked7_1Addres;
	public  JLabel labelLinked7_2Addres;
	public  JLabel labelLinked7_3Addres;
	public  ImageIcon numero0baseIcon = new ImageIcon(this.getClass().getResource("/img/numero0Icon1.png"));
	public  ImageIcon numero1baseIcon = new ImageIcon(this.getClass().getResource("/img/numero1Icon1.png"));
	public  ImageIcon numero2baseIcon = new ImageIcon(this.getClass().getResource("/img/numero2Icon1.png"));
	public  ImageIcon numero3baseIcon = new ImageIcon(this.getClass().getResource("/img/numero3Icon1.png"));
	public  ImageIcon numero4baseIcon = new ImageIcon(this.getClass().getResource("/img/numero4Icon1.png"));
	public  ImageIcon numero5baseIcon = new ImageIcon(this.getClass().getResource("/img/numero5Icon1.png"));
	public  ImageIcon numero6baseIcon = new ImageIcon(this.getClass().getResource("/img/numero6Icon1.png"));
	public  ImageIcon numero7baseIcon = new ImageIcon(this.getClass().getResource("/img/numero7Icon1.png"));
	
	public  ImageIcon numero0LinkedIcon = new ImageIcon(this.getClass().getResource("/img/linked0Icon1.png"));
	public  ImageIcon numero1LinkedIcon = new ImageIcon(this.getClass().getResource("/img/linked1Icon1.png"));
	public  ImageIcon numero2LinkedIcon = new ImageIcon(this.getClass().getResource("/img/linked2Icon1.png"));
	public  ImageIcon numero3LinkedIcon = new ImageIcon(this.getClass().getResource("/img/linked3Icon1.png"));
	public  ImageIcon numero4LinkedIcon = new ImageIcon(this.getClass().getResource("/img/linked4Icon1.png"));
	public  ImageIcon numero5LinkedIcon = new ImageIcon(this.getClass().getResource("/img/linked5Icon1.png"));
	public  ImageIcon numero6LinkedIcon = new ImageIcon(this.getClass().getResource("/img/linked6Icon1.png"));
	public  ImageIcon numero7LinkedIcon = new ImageIcon(this.getClass().getResource("/img/linked7Icon1.png"));
	
	public 	boolean puoiCambiare=false;
	public 	boolean puoiCambiareSpeciale=false;
	public int iteratoreScorittore;
	public LinkedList <Integer> []  listChaing = new LinkedList[8];
	public LinkedList <Integer> []  listOpenAddresing = new LinkedList[8];
	private JScrollPane scrollPaneHelp;
	private JLabel labelHelp;
	private JTextArea txtrHashLaModello;
	/**
	 * Create the frame.
	 */
	public Hashing(JFrame framechiamante) 
	{

		for (int i = 0; i < listChaing.length; i++) 
		{	
			listChaing[i]=new LinkedList <Integer>();
		}

		for (int i = 0; i < listOpenAddresing.length; i++) 
		{	
			listOpenAddresing[i]=new LinkedList <Integer>();
		}
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
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Operating Systems Simulator: Hashing");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelMainButton = new JPanel();
		panelMainButton.setToolTipText("");
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);
		JPanel panelSuperiore = new JPanel();
		panelSuperiore.setBorder(new LineBorder(new Color(30, 136, 229), 7));
		panelSuperiore.setBounds(0, 0, 1414, 73);
		panelMainButton.add(panelSuperiore);
		panelSuperiore.setLayout(null);
		
		JLabel labelSchemata = new JLabel("HASHING");
		labelSchemata.setBounds(559, 0, 262, 73);
		panelSuperiore.add(labelSchemata);
		labelSchemata.setFont(new Font("Segoe UI", Font.BOLD, 48));
		
		JLabel labelFedericoII = new JLabel("New label");
		labelFedericoII.setIcon(new ImageIcon(Hashing.class.getResource("/img/logoUninaIcon2.png")));
		labelFedericoII.setLabelFor(panelSuperiore);
		labelFedericoII.setBounds(1194, 11, 199, 53);
		panelSuperiore.add(labelFedericoII);
		
		JTextArea textParoleBase = new JTextArea();
		textParoleBase.setFont(new Font("Arial", Font.PLAIN, 22));
		textParoleBase.setEditable(false);
		textParoleBase.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textParoleBase.setBounds(294, 224, 213, 257);
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
		buttonGeneraEsempio.setOpaque(true);
		buttonGeneraEsempio.setBackground(Color.WHITE);
		buttonGeneraEsempio.addMouseListener(new MouseAdapter() {
			@Override
        	public void mouseEntered(MouseEvent e) 
        	{
        		buttonGeneraEsempio.setBackground(new Color (30, 136, 229));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) 
        	{
        		buttonGeneraEsempio.setBackground(Color.WHITE);
        	}
		});
		buttonGeneraEsempio.setBorder(new LineBorder(new Color (30, 136, 229), 2, true));
		buttonGeneraEsempio.setFont(new Font("Arial", Font.BOLD, 15));
		buttonGeneraEsempio.setBounds(15, 78, 224, 34);
		panelPlot.add(buttonGeneraEsempio);
		
		JComboBox comboBoxSceltaNParole = new JComboBox();
		
		
		comboBoxSceltaNParole.setEnabled(false);
		comboBoxSceltaNParole.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxSceltaNParole.setBackground(new Color(255, 255, 255));
		comboBoxSceltaNParole.setModel(new DefaultComboBoxModel(new String[] {"8","7","6", "5", "4"}));
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
        
        JLabel labelIndietroIcon = new JLabel("");
        labelIndietroIcon.addMouseListener(new MouseAdapter() {
        	@Override
			public void mouseClicked(MouseEvent e) 
			{	
				framechiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
        	
        });
        labelIndietroIcon.setIcon(new ImageIcon(Hashing.class.getResource("/img/back-button.png")));
        labelIndietroIcon.setBounds(18, 88, 32, 32);
        panelMainButton.add(labelIndietroIcon);
        
        JLabel labelScrittaYoutube = new JLabel(" Lezione");
        labelScrittaYoutube.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelScrittaYoutube.setBounds(81, 123, 53, 12);
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
        labelYoutubeIcon.setBounds(81, 76, 53, 46);
        panelMainButton.add(labelYoutubeIcon);
        
        JLabel labelScrittaSlide = new JLabel("Slide");
        labelScrittaSlide.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelScrittaSlide.setBounds(164, 123, 30, 15);
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
        labelSlideIcon.setBounds(154, 76, 53, 46);
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
		labelDizionario.setBounds(339, 186, 139, 38);
		panelMainButton.add(labelDizionario);
		
		JTextArea textParoleSommate = new JTextArea();
		textParoleSommate.setFont(new Font("Arial", Font.PLAIN, 22));
		textParoleSommate.setEditable(false);
		textParoleSommate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textParoleSommate.setBounds(653, 224, 139, 257);
		panelMainButton.add(textParoleSommate);
		
		JLabel labelCodifica1 = new JLabel("SOMMA CARATTERI : ");
		labelCodifica1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelCodifica1.setBounds(653, 189, 152, 32);
		panelMainButton.add(labelCodifica1);
		
		JLabel labelSomma2 = new JLabel("CODIFICA FINALE :");
		labelSomma2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelSomma2.setBounds(957, 194, 134, 29);
		panelMainButton.add(labelSomma2);
		
		JTextArea textParoleCodificate = new JTextArea();
		textParoleCodificate.setFont(new Font("Arial", Font.PLAIN, 22));
		textParoleCodificate.setEditable(false);
		textParoleCodificate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textParoleCodificate.setBounds(953, 224, 138, 257);
		panelMainButton.add(textParoleCodificate);
		
		JLabel labelFrecciaSomma = new JLabel("Somma ->");
		labelFrecciaSomma.setIcon(new ImageIcon(Hashing.class.getResource("/img/frecciaDestraIcon1.png")));
		labelFrecciaSomma.setBounds(526, 306, 124, 111);
		panelMainButton.add(labelFrecciaSomma);
		
		JLabel labelFrecciaCodifica = new JLabel("Codifica ->");
		labelFrecciaCodifica.setIcon(new ImageIcon(Hashing.class.getResource("/img/frecciaDestraIcon1.png")));
		labelFrecciaCodifica.setBounds(825, 306, 124, 111);
		panelMainButton.add(labelFrecciaCodifica);
		
		JLabel labelFrecciaScrittaSomma = new JLabel("");
		labelFrecciaScrittaSomma.setBounds(517, 328, 69, 14);
		panelMainButton.add(labelFrecciaScrittaSomma);
		
		JLabel labelFrecciaScrittaCodifica = new JLabel("");
		labelFrecciaScrittaCodifica.setBounds(794, 328, 89, 14);
		panelMainButton.add(labelFrecciaScrittaCodifica);
		
		JLabel labelScrittaChaning = new JLabel("       CHAINING : ");
		labelScrittaChaning.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelScrittaChaning.setBounds(515, 481, 139, 38);
		panelMainButton.add(labelScrittaChaning);
		
		JLabel labelScrittaOpen = new JLabel("  OPEN ADDRESSING : ");
		labelScrittaOpen.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelScrittaOpen.setBounds(798, 481, 152, 38);
		panelMainButton.add(labelScrittaOpen);
		
		labelNumero0 = new JLabel("");
		labelNumero0.setIcon(null);
		labelNumero0.setBounds(452, 544, 30, 25);
		panelMainButton.add(labelNumero0);
		
		 labelNumero1 = new JLabel("");
		labelNumero1.setIcon(null);
		labelNumero1.setBounds(485, 544, 30, 25);
		panelMainButton.add(labelNumero1);
		
		labelNumero2 = new JLabel("");
		labelNumero2.setIcon(null);
		labelNumero2.setBounds(518, 544, 30, 25);
		panelMainButton.add(labelNumero2);
		
		 labelNumero3 = new JLabel("");
		labelNumero3.setIcon(null);
		labelNumero3.setBounds(549, 544, 30, 25);
		panelMainButton.add(labelNumero3);
		
		labelNumero4 = new JLabel("");
		labelNumero4.setIcon(null);
		labelNumero4.setBounds(582, 544, 30, 25);
		panelMainButton.add(labelNumero4);
		
		
		 labelNumero5 = new JLabel("");
		labelNumero5.setIcon(null);
		labelNumero5.setBounds(615, 544, 30, 25);
		panelMainButton.add(labelNumero5);
		
		
		labelNumero6 = new JLabel("");
		labelNumero6.setIcon(null);
		labelNumero6.setBounds(648, 544, 30, 25);
		panelMainButton.add(labelNumero6);
		
		
		labelNumero7 = new JLabel("");
		labelNumero7.setIcon(null);
		labelNumero7.setBounds(680, 544, 30, 25);
		panelMainButton.add(labelNumero7);
		
		labelArrayChaining = new JLabel("");
		labelArrayChaining.setIcon(new ImageIcon(Hashing.class.getResource("/img/arrayIcon1.png")));
		labelArrayChaining.setBounds(450, 541, 264, 33);
		panelMainButton.add(labelArrayChaining);
		
		
		labelLinked0_1 = new JLabel("");
		labelLinked0_1.setBounds(452, 588, 30, 29);
		panelMainButton.add(labelLinked0_1);
		
		labelLinked0_2 = new JLabel("");
		labelLinked0_2.setBounds(452, 628, 30, 29);
		panelMainButton.add(labelLinked0_2);
		
		labelLinked0_3 = new JLabel("");
		labelLinked0_3.setBounds(452, 668, 30, 29);
		panelMainButton.add(labelLinked0_3);
		
		labelLinked1_1 = new JLabel("");
		labelLinked1_1.setBounds(485, 588, 30, 29);
		panelMainButton.add(labelLinked1_1);
		
		 labelLinked1_2 = new JLabel("");
		labelLinked1_2.setBounds(485, 628, 30, 29);
		panelMainButton.add(labelLinked1_2);
		
		 labelLinked1_3 = new JLabel("");
		labelLinked1_3.setBounds(485, 668, 30, 29);
		panelMainButton.add(labelLinked1_3);
		
		 labelLinked2_1 = new JLabel("");
		labelLinked2_1.setBounds(520, 588, 30, 29);
		panelMainButton.add(labelLinked2_1);
		
		 labelLinked2_2 = new JLabel("");
		labelLinked2_2.setBounds(520, 628, 30, 29);
		panelMainButton.add(labelLinked2_2);
		
		 labelLinked2_3 = new JLabel("");
		labelLinked2_3.setBounds(520, 668, 30, 29);
		panelMainButton.add(labelLinked2_3);
		
		labelLinked3_1 = new JLabel("");
		labelLinked3_1.setBounds(550, 588, 30, 29);
		panelMainButton.add(labelLinked3_1);
		
		labelLinked3_2 = new JLabel("");
		labelLinked3_2.setBounds(550, 628, 30, 29);
		panelMainButton.add(labelLinked3_2);
		
		labelLinked3_3 = new JLabel("");
		labelLinked3_3.setBounds(550, 668, 30, 29);
		panelMainButton.add(labelLinked3_3);
		
		labelLinked4_1 = new JLabel("");
		labelLinked4_1.setBounds(582, 588, 30, 29);
		panelMainButton.add(labelLinked4_1);
		
		labelLinked4_2 = new JLabel("");
		labelLinked4_2.setBounds(582, 628, 30, 29);
		panelMainButton.add(labelLinked4_2);
		
		labelLinked4_3 = new JLabel("");
		labelLinked4_3.setBounds(582, 668, 30, 29);
		panelMainButton.add(labelLinked4_3);
		
		labelLinked5_1 = new JLabel("");
		labelLinked5_1.setBounds(615, 588, 30, 29);
		panelMainButton.add(labelLinked5_1);
		
		labelLinked5_2 = new JLabel("");
		labelLinked5_2.setBounds(615, 628, 30, 29);
		panelMainButton.add(labelLinked5_2);
		
		labelLinked5_3 = new JLabel("");
		labelLinked5_3.setBounds(615, 668, 30, 29);
		panelMainButton.add(labelLinked5_3);
		
		labelLinked6_1 = new JLabel("");
		labelLinked6_1.setBounds(648, 588, 30, 29);
		panelMainButton.add(labelLinked6_1);
		
		labelLinked6_2 = new JLabel("");
		labelLinked6_2.setBounds(648, 628, 30, 29);
		panelMainButton.add(labelLinked6_2);
		
		labelLinked6_3 = new JLabel("");
		labelLinked6_3.setBounds(648, 668, 30, 29);
		panelMainButton.add(labelLinked6_3);
		
		labelLinked7_1 = new JLabel("");
		labelLinked7_1.setBounds(680, 588, 30, 29);
		panelMainButton.add(labelLinked7_1);
		
		labelLinked7_2 = new JLabel("");
		labelLinked7_2.setBounds(680, 628, 30, 29);
		panelMainButton.add(labelLinked7_2);
		
		labelLinked7_3 = new JLabel("");
		labelLinked7_3.setBounds(680, 668, 30, 29);
		panelMainButton.add(labelLinked7_3);

		JLabel labelNumeriChaining = new JLabel("   0      1       2      3      4       5      6      7 ");
		labelNumeriChaining.setFont(new Font("Segoe UI", Font.BOLD, 13));
		labelNumeriChaining.setBounds(452, 518, 258, 23);
		panelMainButton.add(labelNumeriChaining);
		
		labelNumero0Addres = new JLabel("");
		labelNumero0Addres.setBounds(746, 544, 30, 25);
		panelMainButton.add(labelNumero0Addres);
		
		labelNumero1Addres = new JLabel("");
		labelNumero1Addres.setBounds(779, 544, 30, 25);
		panelMainButton.add(labelNumero1Addres);
		
		labelNumero2Addres = new JLabel("");
		labelNumero2Addres.setBounds(812, 544, 30, 25);
		panelMainButton.add(labelNumero2Addres);
		
		labelNumero3Addres = new JLabel("");
		labelNumero3Addres.setBounds(843, 544, 30, 25);
		panelMainButton.add(labelNumero3Addres);
		
		labelNumero4Addres = new JLabel("");
		labelNumero4Addres.setBounds(876, 544, 30, 25);
		panelMainButton.add(labelNumero4Addres);
		
		labelNumero5Addres = new JLabel("");
		labelNumero5Addres.setBounds(909, 544, 30, 25);
		panelMainButton.add(labelNumero5Addres);
		
		labelNumero6Addres = new JLabel("");
		labelNumero6Addres.setBounds(942, 544, 30, 25);
		panelMainButton.add(labelNumero6Addres);
		
		labelNumero7Addres = new JLabel("");
		labelNumero7Addres.setBounds(974, 544, 30, 25);
		panelMainButton.add(labelNumero7Addres);
		
		JLabel labelArrayAddres = new JLabel("");
		labelArrayAddres.setIcon(new ImageIcon(Hashing.class.getResource("/img/arrayIcon1.png")));
		labelArrayAddres.setBounds(744, 541, 264, 33);
		panelMainButton.add(labelArrayAddres);
		
		labelLinked0_1Addres = new JLabel("");
		labelLinked0_1Addres.setBounds(746, 588, 30, 29);
		panelMainButton.add(labelLinked0_1Addres);
		
		labelLinked0_2Addres = new JLabel("");
		labelLinked0_2Addres.setBounds(746, 628, 30, 29);
		panelMainButton.add(labelLinked0_2Addres);
		
		labelLinked0_3Addres = new JLabel("");
		labelLinked0_3Addres.setBounds(746, 668, 30, 29);
		panelMainButton.add(labelLinked0_3Addres);
		
		labelLinked1_1Addres = new JLabel("");
		labelLinked1_1Addres.setBounds(779, 588, 30, 29);
		panelMainButton.add(labelLinked1_1Addres);
		
		labelLinked1_2Addres = new JLabel("");
		labelLinked1_2Addres.setBounds(779, 628, 30, 29);
		panelMainButton.add(labelLinked1_2Addres);
		
		labelLinked1_3Addres = new JLabel("");
		labelLinked1_3Addres.setBounds(779, 668, 30, 29);
		panelMainButton.add(labelLinked1_3Addres);
		
		labelLinked2_1Addres = new JLabel("");
		labelLinked2_1Addres.setBounds(814, 588, 30, 29);
		panelMainButton.add(labelLinked2_1Addres);
		
		labelLinked2_2Addres = new JLabel("");
		labelLinked2_2Addres.setBounds(814, 628, 30, 29);
		panelMainButton.add(labelLinked2_2Addres);
		
		labelLinked2_3Addres = new JLabel("");
		labelLinked2_3Addres.setBounds(814, 668, 30, 29);
		panelMainButton.add(labelLinked2_3Addres);
		
		labelLinked3_1Addres = new JLabel("");
		labelLinked3_1Addres.setBounds(844, 588, 30, 29);
		panelMainButton.add(labelLinked3_1Addres);
		
		labelLinked3_2Addres = new JLabel("");
		labelLinked3_2Addres.setBounds(844, 628, 30, 29);
		panelMainButton.add(labelLinked3_2Addres);
		
		labelLinked3_3Addres = new JLabel("");
		labelLinked3_3Addres.setBounds(844, 668, 30, 29);
		panelMainButton.add(labelLinked3_3Addres);
		
		labelLinked4_1Addres = new JLabel("");
		labelLinked4_1Addres.setBounds(876, 588, 30, 29);
		panelMainButton.add(labelLinked4_1Addres);
		
		labelLinked4_2Addres = new JLabel("");
		labelLinked4_2Addres.setBounds(876, 628, 30, 29);
		panelMainButton.add(labelLinked4_2Addres);
		
		labelLinked4_3Addres = new JLabel("");
		labelLinked4_3Addres.setBounds(876, 668, 30, 29);
		panelMainButton.add(labelLinked4_3Addres);
		
		labelLinked5_1Addres = new JLabel("");
		labelLinked5_1Addres.setBounds(909, 588, 30, 29);
		panelMainButton.add(labelLinked5_1Addres);
		
		labelLinked5_2Addres = new JLabel("");
		labelLinked5_2Addres.setBounds(909, 628, 30, 29);
		panelMainButton.add(labelLinked5_2Addres);
		
		labelLinked5_3Addres = new JLabel("");
		labelLinked5_3Addres.setBounds(909, 668, 30, 29);
		panelMainButton.add(labelLinked5_3Addres);
		
		labelLinked6_1Addres = new JLabel("");
		labelLinked6_1Addres.setBounds(942, 588, 30, 29);
		panelMainButton.add(labelLinked6_1Addres);
		
		labelLinked6_2Addres = new JLabel("");
		labelLinked6_2Addres.setBounds(942, 628, 30, 29);
		panelMainButton.add(labelLinked6_2Addres);
		
		labelLinked6_3Addres = new JLabel("");
		labelLinked6_3Addres.setBounds(942, 668, 30, 29);
		panelMainButton.add(labelLinked6_3Addres);
		
		 labelLinked7_1Addres = new JLabel("");
		labelLinked7_1Addres.setBounds(974, 588, 30, 29);
		panelMainButton.add(labelLinked7_1Addres);
		
		 labelLinked7_2Addres = new JLabel("");
		labelLinked7_2Addres.setBounds(974, 628, 30, 29);
		panelMainButton.add(labelLinked7_2Addres);
		
		labelLinked7_3Addres = new JLabel("");
		labelLinked7_3Addres.setBounds(974, 668, 30, 29);
		panelMainButton.add(labelLinked7_3Addres);
		
		JLabel labelNumeriAddres = new JLabel("   0      1       2      3      4       5      6      7 ");
		labelNumeriAddres.setFont(new Font("Segoe UI", Font.BOLD, 13));
		labelNumeriAddres.setBounds(746, 518, 258, 23);
		panelMainButton.add(labelNumeriAddres);
		
		scrollPaneHelp = new JScrollPane();
		scrollPaneHelp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneHelp.setBounds(20, 222, 245, 369);
		panelMainButton.add(scrollPaneHelp);
		
		txtrHashLaModello = new JTextArea();
		scrollPaneHelp.setViewportView(txtrHashLaModello);
		txtrHashLaModello.setWrapStyleWord(true);
		txtrHashLaModello.setText("HASH\r\nLa modello HASH (hash=tritare, sminuzzare) permette di memorizzare oggetti generici ricavando un  indirizzo per la memorizzazione a partire proprio dalla chiave dell'oggetto considerato.\r\nLa funzione hash quindi trasforma ogni chiave k in un numero compreso in un intervallo [0,N-1] (in cui N è la capacità del bucket impiegato).\r\nLa funzione Hash può essere considerata come la composizione di due funzioni più semplici: la prima funzione è applicata direttamente alla chiave dell'elemento considerato e ne ricava un valore intero qualsiasi; successivamente, con l'applicazione della seconda funzione, si ha la possibilità di \"proiettare\" tale vale intero generico in un ben più ristretto intervallo di soli N elementi.\r\nPoiché due chiavi distinte possono generare il medesimo valore hash, si possono verificare vere e proprie collisioni. Per gestire le collisioni sono in genere applicate due distinte metodologie: il Chaining e l'Open Addressing.\r\nCon la  tecnica del Chaining gli oggetti di  tutte le chiavi che hanno lo stesso valore hash apparterranno alla medesima linked list (ogni nuovo elemento viene aggiunto in testa alla linked list).\r\nCon  la tecnica dell' Open Addressing, gli elementi da memorizzare sono contenuti tutti in un array prefissato: in caso di collisione si possono applicare diverse tecniche come quella che sceglie la prima locazione libera immediatamente successiva alla locazione che ha determinato la collisione.");
		txtrHashLaModello.setLineWrap(true);
		txtrHashLaModello.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtrHashLaModello.setEditable(false);
		txtrHashLaModello.setCaretPosition(0);
		
		labelHelp = new JLabel("  Spiegazione Argomento : ");
		labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
		labelHelp.setForeground(Color.RED);
		labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelHelp.setBounds(20, 186, 245, 25);
		panelMainButton.add(labelHelp);
		
		
		
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
				resetIconEntrambi();
				
				
				String numeroParoleString = (String) comboBoxSceltaNParole.getSelectedItem();
				int numeroParoleInt=Integer.valueOf(numeroParoleString);
				//Generazione Parole
				for (int i = 0; i < numeroParoleInt ; i++) 
				{
					indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
					if (listaParolaHashings.size()==0) 
					{
						
						listaParolaHashings.add(new parolaHashing(dizionarioParola[indexDaEstrarre], indexDaEstrarre, i));
						textParoleBase.append(i+": "+listaParolaHashings.get(0).parola+ "\n");
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
								textParoleBase.append(i+": "+listaParolaHashings.get(listaParolaHashings.size()-1).parola+ "\n");
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
				labelPlay.setEnabled(true);
				labelScrittaPlay.setEnabled(true);
				//Generazione varibiali 
				int indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
				boolean tuttook= true;
				//Enable e Flush degl Elementi
				comboBoxSceltaNParole.setEnabled(true);
				listaParolaHashings.removeAll(listaParolaHashings);
				textParoleBase.setText("");
				textParoleSommate.setText("");
				textParoleCodificate.setText("");
				resetIconEntrambi();
				
				String numeroParoleString = (String) comboBoxSceltaNParole.getSelectedItem();
				int numeroParoleInt=Integer.valueOf(numeroParoleString);
				//Generazione Parole
				for (int i = 0; i < numeroParoleInt ; i++) 
				{
					indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
					if (listaParolaHashings.size()==0) 
					{
						
						listaParolaHashings.add(new parolaHashing(dizionarioParola[indexDaEstrarre], indexDaEstrarre, i));
						textParoleBase.append(i+": "+listaParolaHashings.get(0).parola+ "\n");
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
								textParoleBase.append(i+": "+listaParolaHashings.get(listaParolaHashings.size()-1).parola+ "\n");
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
				int iteratore=0;
				resetIconEntrambi();
				for (int i = 0; i < listChaing.length; i++) 
				{	
					listChaing[i].removeAll(listChaing[i]);
					listChaing[i]=new LinkedList <Integer>();
				}
				for (int i = 0; i < listOpenAddresing.length; i++) 
				{	
					listOpenAddresing[i].removeAll(listChaing[i]);
					listOpenAddresing[i]=new LinkedList <Integer>();
				}
				
				
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
					listChaing[iteraParolaHashing.risultatoFinale].addFirst(iteratore);
					if (listOpenAddresing[iteraParolaHashing.risultatoFinale].isEmpty()) 
					{
						listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
					}
					else 
					{
						listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
						if (iteraParolaHashing.risultatoFinale != 7 && listOpenAddresing[iteraParolaHashing.risultatoFinale++].isEmpty()) 
						{
							listOpenAddresing[iteraParolaHashing.risultatoFinale++].addLast(iteratore);
						}
						else 
						{
							for (int j = 0; j < dizionarioParola.length; j++) 
							{
								if (listOpenAddresing[j].isEmpty()) 
								{
									listOpenAddresing[j].addLast(iteratore);
									break;
								}
							}
						}
					}
					iteratore++;
				}
				stampaChaining(listChaing, listaParolaHashings.size());
				stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
				
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
					int iteratore=0;
					resetIconEntrambi();
					
					for (int i = 0; i < listChaing.length; i++) 
					{	
						listChaing[i].removeAll(listChaing[i]);
						listChaing[i]=new LinkedList <Integer>();
					}
					for (int i = 0; i < listOpenAddresing.length; i++) 
					{	
						listOpenAddresing[i].removeAll(listChaing[i]);
						listOpenAddresing[i]=new LinkedList <Integer>();
					}
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
						listChaing[iteraParolaHashing.risultatoFinale].addFirst(iteratore);
						if (listOpenAddresing[iteraParolaHashing.risultatoFinale].isEmpty()) 
						{
							listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
						}
						else 
						{
							listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
							if (iteraParolaHashing.risultatoFinale != 7 && listOpenAddresing[iteraParolaHashing.risultatoFinale++].isEmpty()) 
							{
								listOpenAddresing[iteraParolaHashing.risultatoFinale++].addLast(iteratore);
							}
							else 
							{
								for (int j = 0; j < dizionarioParola.length; j++) 
								{
									if (listOpenAddresing[j].isEmpty()) 
									{
										listOpenAddresing[j].addLast(iteratore);
										break;
									}
								}
							}
						}
						iteratore++;
					}
					stampaChaining(listChaing, listaParolaHashings.size());
					stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
				}
				else if (puoiCambiareSpeciale)
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					resetIconEntrambi();
					for (int i = 0; i < listChaing.length; i++) 
					{	
						listChaing[i].removeAll(listChaing[i]);
						listChaing[i]=new LinkedList <Integer>();
					}
					for (int i = 0; i < listOpenAddresing.length; i++) 
					{	
						listOpenAddresing[i].removeAll(listChaing[i]);
						listOpenAddresing[i]=new LinkedList <Integer>();
					}
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
						listChaing[listaParolaHashings.get(i).risultatoFinale].addFirst(i);
						if (listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].isEmpty()) 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
						}
						else 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
							if (listaParolaHashings.get(i).risultatoFinale != 7 && listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].isEmpty()) 
							{
								listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].addLast(i);
							}
							else 
							{
								for (int j = 0; j < dizionarioParola.length; j++) 
								{
									if (listOpenAddresing[j].isEmpty()) 
									{
										listOpenAddresing[j].addLast(i);
										break;
									}
								}
							}
						}
					}
					stampaChaining(listChaing, listaParolaHashings.size());
					stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
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
					int iteratore=0;
					resetIconEntrambi();
					for (int i = 0; i < listChaing.length; i++) 
					{	
						listChaing[i].removeAll(listChaing[i]);
						listChaing[i]=new LinkedList <Integer>();
					}
					for (int i = 0; i < listOpenAddresing.length; i++) 
					{	
						listOpenAddresing[i].removeAll(listChaing[i]);
						listOpenAddresing[i]=new LinkedList <Integer>();
					}
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
						listChaing[iteraParolaHashing.risultatoFinale].addFirst(iteratore);
						if (listOpenAddresing[iteraParolaHashing.risultatoFinale].isEmpty()) 
						{
							listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
						}
						else 
						{
							listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
							if (iteraParolaHashing.risultatoFinale != 7 && listOpenAddresing[iteraParolaHashing.risultatoFinale++].isEmpty()) 
							{
								listOpenAddresing[iteraParolaHashing.risultatoFinale++].addLast(iteratore);
							}
							else 
							{
								for (int j = 0; j < dizionarioParola.length; j++) 
								{
									if (listOpenAddresing[j].isEmpty()) 
									{
										listOpenAddresing[j].addLast(iteratore);
										break;
									}
								}
							}
						}
						iteratore++;
					}
					stampaChaining(listChaing, listaParolaHashings.size());
					stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
					
				}
				else if (puoiCambiareSpeciale) 
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					labelFrecciaScrittaSomma.setText("S. Quadrica");
					resetIconEntrambi();

					for (int i = 0; i < listChaing.length; i++) 
					{	
						listChaing[i].removeAll(listChaing[i]);
						listChaing[i]=new LinkedList <Integer>();
					}
					for (int i = 0; i < listOpenAddresing.length; i++) 
					{	
						listOpenAddresing[i].removeAll(listChaing[i]);
						listOpenAddresing[i]=new LinkedList <Integer>();
					}
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
						listChaing[listaParolaHashings.get(i).risultatoFinale].addFirst(i);
						if (listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].isEmpty()) 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
						}
						else 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
							if (listaParolaHashings.get(i).risultatoFinale != 7 && listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].isEmpty()) 
							{
								listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].addLast(i);
							}
							else 
							{
								for (int j = 0; j < dizionarioParola.length; j++) 
								{
									if (listOpenAddresing[j].isEmpty()) 
									{
										listOpenAddresing[j].addLast(i);
										break;
									}
								}
							}
						}
					}
					stampaChaining(listChaing, listaParolaHashings.size());
					stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
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
					int iteratore=0;
					resetIconEntrambi();
					for (int i = 0; i < listChaing.length; i++) 
					{	
						listChaing[i].removeAll(listChaing[i]);
						listChaing[i]=new LinkedList <Integer>();
					}
					for (int i = 0; i < listOpenAddresing.length; i++) 
					{	
						listOpenAddresing[i].removeAll(listChaing[i]);
						listOpenAddresing[i]=new LinkedList <Integer>();
					}
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
						listChaing[iteraParolaHashing.risultatoFinale].addFirst(iteratore);
						if (listOpenAddresing[iteraParolaHashing.risultatoFinale].isEmpty()) 
						{
							listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
						}
						else 
						{
							listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
							if (iteraParolaHashing.risultatoFinale != 7 && listOpenAddresing[iteraParolaHashing.risultatoFinale++].isEmpty()) 
							{
								listOpenAddresing[iteraParolaHashing.risultatoFinale++].addLast(iteratore);
							}
							else 
							{
								for (int j = 0; j < dizionarioParola.length; j++) 
								{
									if (listOpenAddresing[j].isEmpty()) 
									{
										listOpenAddresing[j].addLast(iteratore);
										break;
									}
								}
							}
						}
						iteratore++;
					}
					stampaChaining(listChaing, listaParolaHashings.size());
					stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
				}
				else if (puoiCambiareSpeciale)
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					resetIconEntrambi();
					
					labelFrecciaScrittaCodifica.setText("X mod 8");
					for (int i = 0; i < listChaing.length; i++) 
					{	
						listChaing[i].removeAll(listChaing[i]);
						listChaing[i]=new LinkedList <Integer>();
					}
					for (int i = 0; i < listOpenAddresing.length; i++) 
					{	
						listOpenAddresing[i].removeAll(listChaing[i]);
						listOpenAddresing[i]=new LinkedList <Integer>();
					}
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
						listChaing[listaParolaHashings.get(i).risultatoFinale].addFirst(i);
						if (listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].isEmpty()) 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
						}
						else 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
							if (listaParolaHashings.get(i).risultatoFinale != 7 && listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].isEmpty()) 
							{
								listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].addLast(i);
							}
							else 
							{
								for (int j = 0; j < dizionarioParola.length; j++) 
								{
									if (listOpenAddresing[j].isEmpty()) 
									{
										listOpenAddresing[j].addLast(i);
										break;
									}
								}
							}
						}
					}
					stampaChaining(listChaing, listaParolaHashings.size());
					stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
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
					int iteratore=0;
					resetIconEntrambi();
					
					for (int i = 0; i < listChaing.length; i++) 
					{	
						listChaing[i].removeAll(listChaing[i]);
						listChaing[i]=new LinkedList <Integer>();
					}
					for (int i = 0; i < listOpenAddresing.length; i++) 
					{	
						listOpenAddresing[i].removeAll(listChaing[i]);
						listOpenAddresing[i]=new LinkedList <Integer>();
					}	
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
						listChaing[iteraParolaHashing.risultatoFinale].addFirst(iteratore);
						if (listOpenAddresing[iteraParolaHashing.risultatoFinale].isEmpty()) 
						{
							listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
						}
						else 
						{
							listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
							if (iteraParolaHashing.risultatoFinale != 7 && listOpenAddresing[iteraParolaHashing.risultatoFinale++].isEmpty()) 
							{
								listOpenAddresing[iteraParolaHashing.risultatoFinale++].addLast(iteratore);
							}
							else 
							{
								for (int j = 0; j < dizionarioParola.length; j++) 
								{
									if (listOpenAddresing[j].isEmpty()) 
									{
										listOpenAddresing[j].addLast(iteratore);
										break;
									}
								}
							}
						}
						iteratore++;
					}
					stampaChaining(listChaing, listaParolaHashings.size());
					stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
						
				}
				else if (puoiCambiareSpeciale)
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					labelFrecciaScrittaCodifica.setText("(5x + 2 ) mod 8 ");
					
					resetIconEntrambi();
					
					for (int i = 0; i < listChaing.length; i++) 
					{	
						listChaing[i].removeAll(listChaing[i]);
						listChaing[i]=new LinkedList <Integer>();
					}
					for (int i = 0; i < listOpenAddresing.length; i++) 
					{	
						listOpenAddresing[i].removeAll(listChaing[i]);
						listOpenAddresing[i]=new LinkedList <Integer>();
					}
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
						listChaing[listaParolaHashings.get(i).risultatoFinale].addFirst(i);
						if (listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].isEmpty()) 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
						}
						else 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
							if (listaParolaHashings.get(i).risultatoFinale != 7 && listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].isEmpty()) 
							{
								listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].addLast(i);
							}
							else 
							{
								for (int j = 0; j < dizionarioParola.length; j++) 
								{
									if (listOpenAddresing[j].isEmpty()) 
									{
										listOpenAddresing[j].addLast(i);
										break;
									}
								}
							}
						}
					}
					stampaChaining(listChaing, listaParolaHashings.size());
					stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
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
					int iteratore=0;
					resetIconEntrambi();
					
					for (int i = 0; i < listChaing.length; i++) 
					{	
						listChaing[i].removeAll(listChaing[i]);
						listChaing[i]=new LinkedList <Integer>();
					}
					for (int i = 0; i < listOpenAddresing.length; i++) 
					{	
						listOpenAddresing[i].removeAll(listChaing[i]);
						listOpenAddresing[i]=new LinkedList <Integer>();
					}
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
						listChaing[iteraParolaHashing.risultatoFinale].addFirst(iteratore);
						if (listOpenAddresing[iteraParolaHashing.risultatoFinale].isEmpty()) 
						{
							listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
						}
						else 
						{
							listOpenAddresing[iteraParolaHashing.risultatoFinale].addLast(iteratore);
							if (iteraParolaHashing.risultatoFinale != 7 && listOpenAddresing[iteraParolaHashing.risultatoFinale++].isEmpty()) 
							{
								listOpenAddresing[iteraParolaHashing.risultatoFinale++].addLast(iteratore);
							}
							else 
							{
								for (int j = 0; j < dizionarioParola.length; j++) 
								{
									if (listOpenAddresing[j].isEmpty()) 
									{
										listOpenAddresing[j].addLast(iteratore);
										break;
									}
								}
							}
						}
						iteratore++;
					}
					stampaChaining(listChaing, listaParolaHashings.size());
					stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
				}
				else if (puoiCambiareSpeciale)
				{
					textParoleSommate.setText("");
					textParoleCodificate.setText("");
					resetIconEntrambi();
					
					for (int i = 0; i < listChaing.length; i++) 
					{	
						listChaing[i].removeAll(listChaing[i]);
						listChaing[i]=new LinkedList <Integer>();
					}
					for (int i = 0; i < listOpenAddresing.length; i++) 
					{	
						listOpenAddresing[i].removeAll(listChaing[i]);
						listOpenAddresing[i]=new LinkedList <Integer>();
					}
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
						listChaing[listaParolaHashings.get(i).risultatoFinale].addFirst(i);
						if (listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].isEmpty()) 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
						}
						else 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
							if (listaParolaHashings.get(i).risultatoFinale != 7 && listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].isEmpty()) 
							{
								listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].addLast(i);
							}
							else 
							{
								for (int j = 0; j < dizionarioParola.length; j++) 
								{
									if (listOpenAddresing[j].isEmpty()) 
									{
										listOpenAddresing[j].addLast(i);
										break;
									}
								}
							}
						}
					}
					stampaChaining(listChaing, listaParolaHashings.size());
					stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
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
				resetIconEntrambi();
				if (iteratoreScorittore<=listaParolaHashings.size()) 
				{
					if (iteratoreScorittore!=listaParolaHashings.size()) 
					{
						iteratoreScorittore++;
					}
					puoiCambiareSpeciale=true;
					textParoleSommate.setText("");
					textParoleCodificate.setText("");

					
					for (int i = 0; i < listChaing.length; i++) 
					{	
						listChaing[i].removeAll(listChaing[i]);
						listChaing[i]=new LinkedList <Integer>();
					}
					for (int i = 0; i < listOpenAddresing.length; i++) 
					{	
						listOpenAddresing[i].removeAll(listChaing[i]);
						listOpenAddresing[i]=new LinkedList <Integer>();
					}
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
						listChaing[listaParolaHashings.get(i).risultatoFinale].addFirst(i);
						if (listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].isEmpty()) 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
						}
						else 
						{
							listOpenAddresing[listaParolaHashings.get(i).risultatoFinale].addLast(i);
							if (listaParolaHashings.get(i).risultatoFinale != 7 && listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].isEmpty()) 
							{
								listOpenAddresing[listaParolaHashings.get(i).risultatoFinale++].addLast(i);
							}
							else 
							{
								for (int j = 0; j < dizionarioParola.length; j++) 
								{
									if (listOpenAddresing[j].isEmpty()) 
									{
										listOpenAddresing[j].addLast(i);
										break;
									}
								}
							}
						}
					}
					stampaChaining(listChaing, listaParolaHashings.size());
					stampaOpenAddressing(listOpenAddresing, listaParolaHashings.size());
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
	
 
	public void stampaChaining (LinkedList <Integer> []  listChaing ,int size) 
	{
		for (int i = 0; i < size; i++) 
		{
			if (i==0) 
			{
				if (listChaing[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listChaing[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						Integer numero = (Integer) scorre.next();
						//Primo Elemento
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero0.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero0.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero0.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero0.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero0.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero0.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero0.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero0.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked0_1.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked0_1.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked0_1.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked0_1.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked0_1.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked0_1.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked0_1.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked0_1.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked0_2.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked0_2.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked0_2.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked0_2.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked0_2.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked0_2.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked0_2.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked0_2.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked0_3.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked0_3.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked0_3.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked0_3.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked0_3.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked0_3.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked0_3.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked0_3.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
						labelNumero0.revalidate();
					}
				}
			}
			else if (i==1) 
			{
				if (listChaing[i].listIterator() != null) 
				{
						Iterator <Integer> scorre = listChaing[i].iterator();
						int labelDascorre=0;
						while (scorre.hasNext()) 
						{
							Integer numero = (Integer) scorre.next();
							if (numero == 0 && labelDascorre== 0) 
							{
								labelNumero1.setIcon(numero0baseIcon);
							}
							else if (numero == 1 && labelDascorre== 0) 
							{
								labelNumero1.setIcon(numero1baseIcon);
							}
							else if (numero == 2 && labelDascorre== 0) 
							{
								labelNumero1.setIcon(numero2baseIcon);
							}
							else if (numero == 3 && labelDascorre== 0) 
							{
								labelNumero1.setIcon(numero3baseIcon);
							}
							else if (numero == 4 && labelDascorre== 0) 
							{
								labelNumero1.setIcon(numero4baseIcon);
							}
							else if (numero == 5 && labelDascorre== 0) 
							{
								labelNumero1.setIcon(numero5baseIcon);
							}
							else if (numero == 6 && labelDascorre== 0) 
							{
								labelNumero1.setIcon(numero6baseIcon);
							}
							else if (numero == 7 && labelDascorre== 0) 
							{
								labelNumero1.setIcon(numero7baseIcon);
							}
							//Elemento Linked 1
							if (numero == 0 && labelDascorre== 1) 
							{
								labelLinked1_1.setIcon(numero0LinkedIcon);
							}
							else if (numero == 1 && labelDascorre== 1) 
							{
								labelLinked1_1.setIcon(numero1LinkedIcon);
							}
							else if (numero == 2 && labelDascorre== 1) 
							{
								labelLinked1_1.setIcon(numero2LinkedIcon);
							}
							else if (numero == 3 && labelDascorre== 1) 
							{
								labelLinked1_1.setIcon(numero3LinkedIcon);
							}
							else if (numero == 4 && labelDascorre== 1) 
							{
								labelLinked1_1.setIcon(numero4LinkedIcon);
							}
							else if (numero == 5 && labelDascorre== 1) 
							{
								labelLinked1_1.setIcon(numero5LinkedIcon);
							}
							else if (numero == 6 && labelDascorre== 1) 
							{
								labelLinked1_1.setIcon(numero6LinkedIcon);
							}
							else if (numero == 7 && labelDascorre== 1) 
							{
								labelLinked1_1.setIcon(numero7LinkedIcon);
							}
							//Elemento Linked 2
							if (numero == 0 && labelDascorre== 2) 
							{
								labelLinked1_2.setIcon(numero0LinkedIcon);
							}
							else if (numero == 1 && labelDascorre== 2) 
							{
								labelLinked1_2.setIcon(numero1LinkedIcon);
							}
							else if (numero == 2 && labelDascorre== 2) 
							{
								labelLinked1_2.setIcon(numero2LinkedIcon);
							}
							else if (numero == 3 && labelDascorre== 2) 
							{
								labelLinked1_2.setIcon(numero3LinkedIcon);
							}
							else if (numero == 4 && labelDascorre== 2) 
							{
								labelLinked1_2.setIcon(numero4LinkedIcon);
							}
							else if (numero == 5 && labelDascorre== 2) 
							{
								labelLinked1_2.setIcon(numero5LinkedIcon);
							}
							else if (numero == 6 && labelDascorre== 2) 
							{
								labelLinked1_2.setIcon(numero6LinkedIcon);
							}
							else if (numero == 7 && labelDascorre== 2) 
							{
								labelLinked1_2.setIcon(numero7LinkedIcon);
							}
							//Elemento Linked 3
							if (numero == 0 && labelDascorre== 3) 
							{
								labelLinked1_3.setIcon(numero0LinkedIcon);
							}
							else if (numero == 1 && labelDascorre== 3) 
							{
								labelLinked1_3.setIcon(numero1LinkedIcon);
							}
							else if (numero == 2 && labelDascorre== 3) 
							{
								labelLinked1_3.setIcon(numero2LinkedIcon);
							}
							else if (numero == 3 && labelDascorre== 3) 
							{
								labelLinked1_3.setIcon(numero3LinkedIcon);
							}
							else if (numero == 4 && labelDascorre== 3) 
							{
								labelLinked1_3.setIcon(numero4LinkedIcon);
							}
							else if (numero == 5 && labelDascorre== 3) 
							{
								labelLinked1_3.setIcon(numero5LinkedIcon);
							}
							else if (numero == 6 && labelDascorre== 3) 
							{
								labelLinked1_3.setIcon(numero6LinkedIcon);
							}
							else if (numero == 7 && labelDascorre== 3) 
							{
								labelLinked1_3.setIcon(numero7LinkedIcon);
							}
							labelDascorre++;
							labelNumero1.revalidate();
						}
						
				}
			}
			else if (i==2) 
			{
				if (listChaing[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listChaing[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero2.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero2.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero2.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero2.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero2.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero2.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero2.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero2.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked2_1.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked2_1.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked2_1.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked2_1.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked2_1.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked2_1.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked2_1.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked2_1.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked2_2.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked2_2.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked2_2.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked2_2.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked2_2.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked2_2.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked2_2.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked2_2.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked2_3.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked2_3.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked2_3.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked2_3.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked2_3.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked2_3.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked2_3.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked2_3.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
						labelNumero2.revalidate();
					}
				}
			}
			else if (i==3) 
			{
				if (listChaing[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listChaing[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero3.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero3.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero3.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero3.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero3.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero3.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero3.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero3.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked3_1.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked3_1.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked3_1.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked3_1.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked3_1.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked3_1.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked3_1.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked3_1.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked3_2.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked3_2.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked3_2.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked3_2.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked3_2.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked3_2.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked3_2.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked3_2.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked3_3.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked3_3.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked3_3.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked3_3.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked3_3.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked3_3.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked3_3.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked3_3.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
						labelNumero3.revalidate();
					}
				}
			}
			else if (i==4) 
			{
				if (listChaing[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listChaing[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero4.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero4.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero4.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero4.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero4.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero4.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero4.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero4.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked4_1.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked4_1.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked4_1.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked4_1.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked4_1.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked4_1.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked4_1.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked4_1.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked4_2.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked4_2.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked4_2.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked4_2.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked4_2.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked4_2.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked4_2.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked4_2.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked4_3.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked4_3.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked4_3.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked4_3.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked4_3.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked4_3.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked4_3.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked4_3.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
						labelNumero4.revalidate();
					}
				}
			}
			else if (i==5) 
			{
				if (listChaing[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listChaing[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero5.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero5.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero5.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero5.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero5.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero5.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero5.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero5.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked5_1.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked5_1.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked5_1.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked5_1.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked5_1.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked5_1.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked5_1.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked5_1.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked5_2.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked5_2.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked5_2.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked5_2.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked5_2.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked5_2.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked5_2.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked5_2.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked5_3.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked5_3.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked5_3.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked5_3.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked5_3.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked5_3.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked5_3.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked5_3.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
		
						labelNumero5.revalidate();
					}
				}
			}
			else if (i==6) 
			{
				if (listChaing[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listChaing[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
					
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero6.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero6.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero6.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero6.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero6.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero6.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero6.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero6.setIcon(numero7baseIcon);
						}
		
						//Elemento Linked 1
								if (numero == 0 && labelDascorre== 1) 
								{
									labelLinked6_1.setIcon(numero0LinkedIcon);
								}
								else if (numero == 1 && labelDascorre== 1) 
								{
									labelLinked6_1.setIcon(numero1LinkedIcon);
								}
								else if (numero == 2 && labelDascorre== 1) 
								{
									labelLinked6_1.setIcon(numero2LinkedIcon);
								}
								else if (numero == 3 && labelDascorre== 1) 
								{
									labelLinked6_1.setIcon(numero3LinkedIcon);
								}
								else if (numero == 4 && labelDascorre== 1) 
								{
									labelLinked6_1.setIcon(numero4LinkedIcon);
								}
								else if (numero == 5 && labelDascorre== 1) 
								{
									labelLinked6_1.setIcon(numero5LinkedIcon);
								}
								else if (numero == 6 && labelDascorre== 1) 
								{
									labelLinked6_1.setIcon(numero6LinkedIcon);
								}
								else if (numero == 7 && labelDascorre== 1) 
								{
									labelLinked6_1.setIcon(numero7LinkedIcon);
								}
								//Elemento Linked 2
								if (numero == 0 && labelDascorre== 2) 
								{
									labelLinked6_2.setIcon(numero0LinkedIcon);
								}
								else if (numero == 1 && labelDascorre== 2) 
								{
									labelLinked6_2.setIcon(numero1LinkedIcon);
								}
								else if (numero == 2 && labelDascorre== 2) 
								{
									labelLinked6_2.setIcon(numero2LinkedIcon);
								}
								else if (numero == 3 && labelDascorre== 2) 
								{
									labelLinked6_2.setIcon(numero3LinkedIcon);
								}
								else if (numero == 4 && labelDascorre== 2) 
								{
									labelLinked6_2.setIcon(numero4LinkedIcon);
								}
								else if (numero == 5 && labelDascorre== 2) 
								{
									labelLinked6_2.setIcon(numero5LinkedIcon);
								}
								else if (numero == 6 && labelDascorre== 2) 
								{
									labelLinked6_2.setIcon(numero6LinkedIcon);
								}
								else if (numero == 7 && labelDascorre== 2) 
								{
									labelLinked6_2.setIcon(numero7LinkedIcon);
								}
								//Elemento Linked 3
								if (numero == 0 && labelDascorre== 3) 
								{
									labelLinked6_3.setIcon(numero0LinkedIcon);
								}
								else if (numero == 1 && labelDascorre== 3) 
								{
									labelLinked6_3.setIcon(numero1LinkedIcon);
								}
								else if (numero == 2 && labelDascorre== 3) 
								{
									labelLinked6_3.setIcon(numero2LinkedIcon);
								}
								else if (numero == 3 && labelDascorre== 3) 
								{
									labelLinked6_3.setIcon(numero3LinkedIcon);
								}
								else if (numero == 4 && labelDascorre== 3) 
								{
									labelLinked6_3.setIcon(numero4LinkedIcon);
								}
								else if (numero == 5 && labelDascorre== 3) 
								{
									labelLinked6_3.setIcon(numero5LinkedIcon);
								}
								else if (numero == 6 && labelDascorre== 3) 
								{
									labelLinked6_3.setIcon(numero6LinkedIcon);
								}
								else if (numero == 7 && labelDascorre== 3) 
								{
									labelLinked6_3.setIcon(numero7LinkedIcon);
								}
								labelDascorre++;
						labelNumero6.revalidate();
					}
				}
			}
			else if (i==7) 
			{
				if (listChaing[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listChaing[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero7.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero7.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero7.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero7.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero7.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero7.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero7.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero7.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked7_1.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked7_1.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked7_1.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked7_1.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked7_1.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked7_1.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked7_1.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked7_1.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked7_2.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked7_2.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked7_2.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked7_2.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked7_2.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked7_2.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked7_2.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked7_2.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked7_3.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked7_3.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked7_3.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked7_3.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked7_3.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked7_3.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked7_3.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked7_3.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
						labelNumero7.revalidate();
					}
				}
			}
	}
	
	}
	public void stampaOpenAddressing (LinkedList <Integer> []  listOpenAddres ,int size) 
	{
		for (int i = 0; i < size; i++) 
		{
			if (i==0) 
			{
				if (listOpenAddres[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listOpenAddres[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						Integer numero = (Integer) scorre.next();
						//Primo Elemento
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero0Addres.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero0Addres.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero0Addres.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero0Addres.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero0Addres.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero0Addres.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero0Addres.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero0Addres.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked0_1Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked0_1Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked0_1Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked0_1Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked0_1Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked0_1Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked0_1Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked0_1Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked0_2Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked0_2Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked0_2Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked0_2Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked0_2Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked0_2Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked0_2Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked0_2Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked0_3Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked0_3Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked0_3Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked0_3Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked0_3Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked0_3Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked0_3Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked0_3Addres.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
						labelNumero0Addres.revalidate();
					}
				}
			}
			else if (i==1) 
			{
				if (listOpenAddres[i].listIterator() != null) 
				{
						Iterator <Integer> scorre = listOpenAddres[i].iterator();
						int labelDascorre=0;
						while (scorre.hasNext()) 
						{
							Integer numero = (Integer) scorre.next();
							if (numero == 0 && labelDascorre== 0) 
							{
								labelNumero1Addres.setIcon(numero0baseIcon);
							}
							else if (numero == 1 && labelDascorre== 0) 
							{
								labelNumero1Addres.setIcon(numero1baseIcon);
							}
							else if (numero == 2 && labelDascorre== 0) 
							{
								labelNumero1Addres.setIcon(numero2baseIcon);
							}
							else if (numero == 3 && labelDascorre== 0) 
							{
								labelNumero1Addres.setIcon(numero3baseIcon);
							}
							else if (numero == 4 && labelDascorre== 0) 
							{
								labelNumero1Addres.setIcon(numero4baseIcon);
							}
							else if (numero == 5 && labelDascorre== 0) 
							{
								labelNumero1Addres.setIcon(numero5baseIcon);
							}
							else if (numero == 6 && labelDascorre== 0) 
							{
								labelNumero1Addres.setIcon(numero6baseIcon);
							}
							else if (numero == 7 && labelDascorre== 0) 
							{
								labelNumero1Addres.setIcon(numero7baseIcon);
							}
							//Elemento Linked 1
							if (numero == 0 && labelDascorre== 1) 
							{
								labelLinked1_1Addres.setIcon(numero0LinkedIcon);
							}
							else if (numero == 1 && labelDascorre== 1) 
							{
								labelLinked1_1Addres.setIcon(numero1LinkedIcon);
							}
							else if (numero == 2 && labelDascorre== 1) 
							{
								labelLinked1_1Addres.setIcon(numero2LinkedIcon);
							}
							else if (numero == 3 && labelDascorre== 1) 
							{
								labelLinked1_1Addres.setIcon(numero3LinkedIcon);
							}
							else if (numero == 4 && labelDascorre== 1) 
							{
								labelLinked1_1Addres.setIcon(numero4LinkedIcon);
							}
							else if (numero == 5 && labelDascorre== 1) 
							{
								labelLinked1_1Addres.setIcon(numero5LinkedIcon);
							}
							else if (numero == 6 && labelDascorre== 1) 
							{
								labelLinked1_1Addres.setIcon(numero6LinkedIcon);
							}
							else if (numero == 7 && labelDascorre== 1) 
							{
								labelLinked1_1Addres.setIcon(numero7LinkedIcon);
							}
							//Elemento Linked 2
							if (numero == 0 && labelDascorre== 2) 
							{
								labelLinked1_2Addres.setIcon(numero0LinkedIcon);
							}
							else if (numero == 1 && labelDascorre== 2) 
							{
								labelLinked1_2Addres.setIcon(numero1LinkedIcon);
							}
							else if (numero == 2 && labelDascorre== 2) 
							{
								labelLinked1_2Addres.setIcon(numero2LinkedIcon);
							}
							else if (numero == 3 && labelDascorre== 2) 
							{
								labelLinked1_2Addres.setIcon(numero3LinkedIcon);
							}
							else if (numero == 4 && labelDascorre== 2) 
							{
								labelLinked1_2Addres.setIcon(numero4LinkedIcon);
							}
							else if (numero == 5 && labelDascorre== 2) 
							{
								labelLinked1_2Addres.setIcon(numero5LinkedIcon);
							}
							else if (numero == 6 && labelDascorre== 2) 
							{
								labelLinked1_2Addres.setIcon(numero6LinkedIcon);
							}
							else if (numero == 7 && labelDascorre== 2) 
							{
								labelLinked1_2Addres.setIcon(numero7LinkedIcon);
							}
							//Elemento Linked 3
							if (numero == 0 && labelDascorre== 3) 
							{
								labelLinked1_3Addres.setIcon(numero0LinkedIcon);
							}
							else if (numero == 1 && labelDascorre== 3) 
							{
								labelLinked1_3Addres.setIcon(numero1LinkedIcon);
							}
							else if (numero == 2 && labelDascorre== 3) 
							{
								labelLinked1_3Addres.setIcon(numero2LinkedIcon);
							}
							else if (numero == 3 && labelDascorre== 3) 
							{
								labelLinked1_3Addres.setIcon(numero3LinkedIcon);
							}
							else if (numero == 4 && labelDascorre== 3) 
							{
								labelLinked1_3Addres.setIcon(numero4LinkedIcon);
							}
							else if (numero == 5 && labelDascorre== 3) 
							{
								labelLinked1_3Addres.setIcon(numero5LinkedIcon);
							}
							else if (numero == 6 && labelDascorre== 3) 
							{
								labelLinked1_3Addres.setIcon(numero6LinkedIcon);
							}
							else if (numero == 7 && labelDascorre== 3) 
							{
								labelLinked1_3Addres.setIcon(numero7LinkedIcon);
							}
							labelDascorre++;
							labelNumero1Addres.revalidate();
						}
						
				}
			}
			else if (i==2) 
			{
				if (listOpenAddres[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listOpenAddres[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero2Addres.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero2Addres.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero2Addres.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero2Addres.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero2Addres.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero2Addres.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero2Addres.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero2Addres.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked2_1Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked2_1Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked2_1Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked2_1Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked2_1Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked2_1Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked2_1Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked2_1Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked2_2Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked2_2Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked2_2Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked2_2Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked2_2Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked2_2Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked2_2Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked2_2Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked2_3Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked2_3Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked2_3Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked2_3Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked2_3Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked2_3Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked2_3Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked2_3Addres.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
						labelNumero2Addres.revalidate();
					}
				}
			}
			else if (i==3) 
			{
				if (listOpenAddres[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listOpenAddres[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero3Addres.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero3Addres.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero3Addres.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero3Addres.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero3Addres.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero3Addres.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero3Addres.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero3Addres.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked3_1Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked3_1Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked3_1Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked3_1Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked3_1Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked3_1Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked3_1Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked3_1Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked3_2Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked3_2Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked3_2Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked3_2Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked3_2Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked3_2Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked3_2Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked3_2Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked3_3Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked3_3Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked3_3Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked3_3Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked3_3Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked3_3Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked3_3Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked3_3Addres.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
						labelNumero3Addres.revalidate();
					}
				}
			}
			else if (i==4) 
			{
				if (listOpenAddres[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listOpenAddres[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero4Addres.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero4Addres.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero4Addres.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero4Addres.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero4Addres.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero4Addres.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero4Addres.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero4Addres.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked4_1Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked4_1Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked4_1Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked4_1Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked4_1Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked4_1Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked4_1Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked4_1Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked4_2Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked4_2Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked4_2Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked4_2Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked4_2Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked4_2Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked4_2Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked4_2Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked4_3Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked4_3Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked4_3Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked4_3Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked4_3Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked4_3Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked4_3Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked4_3Addres.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
						labelNumero4Addres.revalidate();
					}
				}
			}
			else if (i==5) 
			{
				if (listOpenAddres[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listOpenAddres[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero5Addres.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero5Addres.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero5Addres.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero5Addres.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero5Addres.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero5Addres.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero5Addres.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero5Addres.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked5_1Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked5_1Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked5_1Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked5_1Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked5_1Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked5_1Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked5_1Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked5_1Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked5_2Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked5_2Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked5_2Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked5_2Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked5_2Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked5_2Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked5_2Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked5_2Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked5_3Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked5_3Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked5_3Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked5_3Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked5_3Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked5_3Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked5_3Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked5_3Addres.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
		
						labelNumero5Addres.revalidate();
					}
				}
			}
			else if (i==6) 
			{
				if (listOpenAddres[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listOpenAddres[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
					
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero6Addres.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero6Addres.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero6Addres.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero6Addres.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero6Addres.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero6Addres.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero6Addres.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero6Addres.setIcon(numero7baseIcon);
						}
		
						//Elemento Linked 1
								if (numero == 0 && labelDascorre== 1) 
								{
									labelLinked6_1Addres.setIcon(numero0LinkedIcon);
								}
								else if (numero == 1 && labelDascorre== 1) 
								{
									labelLinked6_1Addres.setIcon(numero1LinkedIcon);
								}
								else if (numero == 2 && labelDascorre== 1) 
								{
									labelLinked6_1Addres.setIcon(numero2LinkedIcon);
								}
								else if (numero == 3 && labelDascorre== 1) 
								{
									labelLinked6_1Addres.setIcon(numero3LinkedIcon);
								}
								else if (numero == 4 && labelDascorre== 1) 
								{
									labelLinked6_1Addres.setIcon(numero4LinkedIcon);
								}
								else if (numero == 5 && labelDascorre== 1) 
								{
									labelLinked6_1Addres.setIcon(numero5LinkedIcon);
								}
								else if (numero == 6 && labelDascorre== 1) 
								{
									labelLinked6_1Addres.setIcon(numero6LinkedIcon);
								}
								else if (numero == 7 && labelDascorre== 1) 
								{
									labelLinked6_1Addres.setIcon(numero7LinkedIcon);
								}
								//Elemento Linked 2
								if (numero == 0 && labelDascorre== 2) 
								{
									labelLinked6_2Addres.setIcon(numero0LinkedIcon);
								}
								else if (numero == 1 && labelDascorre== 2) 
								{
									labelLinked6_2Addres.setIcon(numero1LinkedIcon);
								}
								else if (numero == 2 && labelDascorre== 2) 
								{
									labelLinked6_2Addres.setIcon(numero2LinkedIcon);
								}
								else if (numero == 3 && labelDascorre== 2) 
								{
									labelLinked6_2Addres.setIcon(numero3LinkedIcon);
								}
								else if (numero == 4 && labelDascorre== 2) 
								{
									labelLinked6_2Addres.setIcon(numero4LinkedIcon);
								}
								else if (numero == 5 && labelDascorre== 2) 
								{
									labelLinked6_2Addres.setIcon(numero5LinkedIcon);
								}
								else if (numero == 6 && labelDascorre== 2) 
								{
									labelLinked6_2Addres.setIcon(numero6LinkedIcon);
								}
								else if (numero == 7 && labelDascorre== 2) 
								{
									labelLinked6_2Addres.setIcon(numero7LinkedIcon);
								}
								//Elemento Linked 3
								if (numero == 0 && labelDascorre== 3) 
								{
									labelLinked6_3Addres.setIcon(numero0LinkedIcon);
								}
								else if (numero == 1 && labelDascorre== 3) 
								{
									labelLinked6_3Addres.setIcon(numero1LinkedIcon);
								}
								else if (numero == 2 && labelDascorre== 3) 
								{
									labelLinked6_3Addres.setIcon(numero2LinkedIcon);
								}
								else if (numero == 3 && labelDascorre== 3) 
								{
									labelLinked6_3Addres.setIcon(numero3LinkedIcon);
								}
								else if (numero == 4 && labelDascorre== 3) 
								{
									labelLinked6_3Addres.setIcon(numero4LinkedIcon);
								}
								else if (numero == 5 && labelDascorre== 3) 
								{
									labelLinked6_3Addres.setIcon(numero5LinkedIcon);
								}
								else if (numero == 6 && labelDascorre== 3) 
								{
									labelLinked6_3Addres.setIcon(numero6LinkedIcon);
								}
								else if (numero == 7 && labelDascorre== 3) 
								{
									labelLinked6_3Addres.setIcon(numero7LinkedIcon);
								}
								labelDascorre++;
						labelNumero6Addres.revalidate();
					}
				}
			}
			else if (i==7) 
			{
				if (listOpenAddres[i].listIterator() != null) 
				{
					Iterator <Integer> scorre = listOpenAddres[i].iterator();
					int labelDascorre=0;
					while (scorre.hasNext()) 
					{
						Integer numero = (Integer) scorre.next();
						if (numero == 0 && labelDascorre== 0) 
						{
							labelNumero7Addres.setIcon(numero0baseIcon);
						}
						else if (numero == 1 && labelDascorre== 0) 
						{
							labelNumero7Addres.setIcon(numero1baseIcon);
						}
						else if (numero == 2 && labelDascorre== 0) 
						{
							labelNumero7Addres.setIcon(numero2baseIcon);
						}
						else if (numero == 3 && labelDascorre== 0) 
						{
							labelNumero7Addres.setIcon(numero3baseIcon);
						}
						else if (numero == 4 && labelDascorre== 0) 
						{
							labelNumero7Addres.setIcon(numero4baseIcon);
						}
						else if (numero == 5 && labelDascorre== 0) 
						{
							labelNumero7Addres.setIcon(numero5baseIcon);
						}
						else if (numero == 6 && labelDascorre== 0) 
						{
							labelNumero7Addres.setIcon(numero6baseIcon);
						}
						else if (numero == 7 && labelDascorre== 0) 
						{
							labelNumero7Addres.setIcon(numero7baseIcon);
						}
						//Elemento Linked 1
						if (numero == 0 && labelDascorre== 1) 
						{
							labelLinked7_1Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 1) 
						{
							labelLinked7_1Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 1) 
						{
							labelLinked7_1Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 1) 
						{
							labelLinked7_1Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 1) 
						{
							labelLinked7_1Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 1) 
						{
							labelLinked7_1Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 1) 
						{
							labelLinked7_1Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 1) 
						{
							labelLinked7_1Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 2
						if (numero == 0 && labelDascorre== 2) 
						{
							labelLinked7_2Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 2) 
						{
							labelLinked7_2Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 2) 
						{
							labelLinked7_2Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 2) 
						{
							labelLinked7_2Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 2) 
						{
							labelLinked7_2Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 2) 
						{
							labelLinked7_2Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 2) 
						{
							labelLinked7_2Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 2) 
						{
							labelLinked7_2Addres.setIcon(numero7LinkedIcon);
						}
						//Elemento Linked 3
						if (numero == 0 && labelDascorre== 3) 
						{
							labelLinked7_3Addres.setIcon(numero0LinkedIcon);
						}
						else if (numero == 1 && labelDascorre== 3) 
						{
							labelLinked7_3Addres.setIcon(numero1LinkedIcon);
						}
						else if (numero == 2 && labelDascorre== 3) 
						{
							labelLinked7_3Addres.setIcon(numero2LinkedIcon);
						}
						else if (numero == 3 && labelDascorre== 3) 
						{
							labelLinked7_3Addres.setIcon(numero3LinkedIcon);
						}
						else if (numero == 4 && labelDascorre== 3) 
						{
							labelLinked7_3Addres.setIcon(numero4LinkedIcon);
						}
						else if (numero == 5 && labelDascorre== 3) 
						{
							labelLinked7_3Addres.setIcon(numero5LinkedIcon);
						}
						else if (numero == 6 && labelDascorre== 3) 
						{
							labelLinked7_3Addres.setIcon(numero6LinkedIcon);
						}
						else if (numero == 7 && labelDascorre== 3) 
						{
							labelLinked7_3Addres.setIcon(numero7LinkedIcon);
						}
						labelDascorre++;
						labelNumero7Addres.revalidate();
					}
				}
			}
	}
	
	}
	public void resetIconEntrambi()
	{
		labelNumero0.setIcon(null);
		labelNumero1.setIcon(null);
		labelNumero2.setIcon(null);
		labelNumero3.setIcon(null);
		labelNumero4.setIcon(null);
		labelNumero5.setIcon(null);
		labelNumero6.setIcon(null);
		labelNumero7.setIcon(null);
		labelNumero0.setIcon(null);
		labelNumero1.setIcon(null);
		labelNumero2.setIcon(null);
		labelNumero3.setIcon(null);
		labelNumero4.setIcon(null);
		labelNumero5.setIcon(null);
		labelNumero6.setIcon(null);
		labelNumero7.setIcon(null);
		labelLinked0_1.setIcon(null);
		labelLinked1_1.setIcon(null);
		labelLinked2_1.setIcon(null);
		labelLinked3_1.setIcon(null);
		labelLinked4_1.setIcon(null);
		labelLinked5_1.setIcon(null);
		labelLinked6_1.setIcon(null);
		labelLinked7_1.setIcon(null);
		labelLinked0_2.setIcon(null);
		labelLinked1_2.setIcon(null);
		labelLinked2_2.setIcon(null);
		labelLinked3_2.setIcon(null);
		labelLinked4_2.setIcon(null);
		labelLinked5_2.setIcon(null);
		labelLinked6_2.setIcon(null);
		labelLinked7_2.setIcon(null);
		labelLinked0_3.setIcon(null);
		labelLinked1_3.setIcon(null);
		labelLinked2_3.setIcon(null);
		labelLinked3_3.setIcon(null);
		labelLinked4_3.setIcon(null);
		labelLinked5_3.setIcon(null);
		labelLinked6_3.setIcon(null);
		labelLinked7_3.setIcon(null);
		
		labelNumero0Addres.setIcon(null);
		labelNumero1Addres.setIcon(null);
		labelNumero2Addres.setIcon(null);
		labelNumero3Addres.setIcon(null);
		labelNumero4Addres.setIcon(null);
		labelNumero5Addres.setIcon(null);
		labelNumero6Addres.setIcon(null);
		labelNumero7Addres.setIcon(null);
		labelNumero0Addres.setIcon(null);
		labelNumero1Addres.setIcon(null);
		labelNumero2Addres.setIcon(null);
		labelNumero3Addres.setIcon(null);
		labelNumero4Addres.setIcon(null);
		labelNumero5Addres.setIcon(null);
		labelNumero6Addres.setIcon(null);
		labelNumero7Addres.setIcon(null);
		labelLinked0_1Addres.setIcon(null);
		labelLinked1_1Addres.setIcon(null);
		labelLinked2_1Addres.setIcon(null);
		labelLinked3_1Addres.setIcon(null);
		labelLinked4_1Addres.setIcon(null);
		labelLinked5_1Addres.setIcon(null);
		labelLinked6_1Addres.setIcon(null);
		labelLinked7_1Addres.setIcon(null);
		labelLinked0_2Addres.setIcon(null);
		labelLinked1_2Addres.setIcon(null);
		labelLinked2_2Addres.setIcon(null);
		labelLinked3_2Addres.setIcon(null);
		labelLinked4_2Addres.setIcon(null);
		labelLinked5_2Addres.setIcon(null);
		labelLinked6_2Addres.setIcon(null);
		labelLinked7_2Addres.setIcon(null);
		labelLinked0_3Addres.setIcon(null);
		labelLinked1_3Addres.setIcon(null);
		labelLinked2_3Addres.setIcon(null);
		labelLinked3_3Addres.setIcon(null);
		labelLinked4_3Addres.setIcon(null);
		labelLinked5_3Addres.setIcon(null);
		labelLinked6_3Addres.setIcon(null);
		labelLinked7_3Addres.setIcon(null);
		
	}
}


