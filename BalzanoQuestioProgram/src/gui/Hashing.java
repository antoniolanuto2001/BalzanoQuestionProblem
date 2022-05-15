package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.parolaHashing;

public class Hashing extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Create the frame.
	 */
	public Hashing(JFrame framechiamante) 
	{
		//Dizionario Parole
		String [] dizionarioParola = {"Vulcano","Amico","Organo","Rame","Gorilla","Orzo","Noci","Melanzana","Cristallo","Pavimento","Risotto","Sei","Stalattiti","Sinistra",
				"Siluro","Lavandino","Furbo","Moneta","Lampada","Camomilla","Proboscide","Russo","Blu","Valigia","Gorilla","Macchia","Grotta","Mutande","Pasta",
				"Cornice","Oggetto","Incrocio","Pannocchia","Scarpa","Giorno","Computer","Scaffale","Tanga","Pasta","Contenitore","Medicina","Sensuale","Viso","Elettricità","Canile"};
		
		System.out.println("String lenght "+dizionarioParola.length);//45
		ArrayList<parolaHashing> listaParolaHashings = new ArrayList<parolaHashing>();
		Random randomGenerator = new Random();
		int indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
		System.out.println("Random Number "+indexDaEstrarre);//45
		boolean tuttook= true;
		for (int i = 0; i < 15; i++) 
		{
			indexDaEstrarre = randomGenerator.nextInt(44 - 0 + 1) + 0;
			if (listaParolaHashings.size()==0) 
			{
				
				listaParolaHashings.add(new parolaHashing(dizionarioParola[indexDaEstrarre], indexDaEstrarre, i));
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
		for (parolaHashing iterato : listaParolaHashings) {
			System.out.println("Parola  "+iterato.indexParola+" : "+ iterato.parola);
		}
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
		JPanel panelSuperiore = new JPanel();
		panelSuperiore.setBackground(new Color(153, 204, 255));
		panelSuperiore.setBounds(0, 0, 1414, 124);
		panelMainButton.add(panelSuperiore);
		panelSuperiore.setLayout(null);

		JTextArea txtrUniversitDegliStudi = new JTextArea();
		txtrUniversitDegliStudi.setBounds(1125, 11, 278, 102);
		txtrUniversitDegliStudi.setBackground(new Color(153, 204, 255));
		txtrUniversitDegliStudi.setText("Universit\u00E0 degli studi di Napoli\r\nAnno Accademico: 2021/2022\r\nProfessore: Walter Balzano\r\nDevoloper: Lanuto, Prosciutto, Scotto\r\n");
		txtrUniversitDegliStudi.setLineWrap(true);
		txtrUniversitDegliStudi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtrUniversitDegliStudi.setEditable(false);
		panelSuperiore.add(txtrUniversitDegliStudi);
		
		JLabel labelSchemata = new JLabel(" Hashing ");
		labelSchemata.setBounds(573, 11, 320, 89);
		panelSuperiore.add(labelSchemata);
		labelSchemata.setFont(new Font("Segoe UI", Font.BOLD, 48));
		
		JButton buttonIndietro = new JButton("Indietro");
		buttonIndietro.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonIndietro.setBackground(new Color(153, 204, 255));
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
		
		JButton buttonEsci = new JButton("Esci");
		buttonEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
