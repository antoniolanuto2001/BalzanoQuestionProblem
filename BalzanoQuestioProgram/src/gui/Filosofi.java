package gui;

import model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

import com.orsonpdf.GraphicsStateDictionary;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;



public class Filosofi extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JPanel panelMainButton = new JPanel();
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
		setContentPane(contentPane);
		
		
		
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);
		
		JLabel labelFilosofo1 = new JLabel("Filosofo1");
		labelFilosofo1.setBounds(63, 277, 94, 98);
		panelMainButton.add(labelFilosofo1);
		labelFilosofo1.setIcon(imageAttesa);
		
		JButton buttonIndietro = new JButton("Indietro");
		buttonIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		JLabel labelFilosofo2 = new JLabel("Filosofo 2 ");
		labelFilosofo2.setBounds(308, 164, 94, 98);
		panelMainButton.add(labelFilosofo2);
		
		JLabel labelFilosofo3 = new JLabel("Filosofo 3");
		labelFilosofo3.setBounds(577, 298, 94, 98);
		panelMainButton.add(labelFilosofo3);
		
		JLabel labelFilosofo4 = new JLabel("Filosofo 4");
		labelFilosofo4.setBounds(493, 582, 94, 98);
		panelMainButton.add(labelFilosofo4);
		
		JLabel labelFilosofo5 = new JLabel("Filosofo 4");
		labelFilosofo5.setBounds(127, 582, 94, 98);
		panelMainButton.add(labelFilosofo5);
		buttonIndietro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonIndietro.setBounds(10, 135, 128, 46);
		panelMainButton.add(buttonIndietro);
		
		JPanel panelSuperiore = new JPanel();
		panelSuperiore.setBackground(new Color(204, 204, 255));
		panelSuperiore.setBounds(0, 0, 1414, 124);
		panelMainButton.add(panelSuperiore);
		panelSuperiore.setLayout(null);
		
		JLabel labelSchemata = new JLabel("Filosofi A Cena ");
		labelSchemata.setBounds(531, 11, 404, 89);
		panelSuperiore.add(labelSchemata);
		labelSchemata.setFont(new Font("Segoe UI", Font.BOLD, 48));
		ButtonGroup groupSceltaStrategiaFilosofi = new ButtonGroup();
		JRadioButton radioDefault = new JRadioButton("Nessuna");
		radioDefault.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
					for (int i = 0; i < filosofiClassica.length; i++) 
					{
						filosofiClassica[i].stop();
						filosofiAtomici[i].stop();
						System.out.println("Ho interotto Esecuzione di entrambi i filosofi " + i);
					}
			}
		});
		radioDefault.setBounds(1161, 324, 175, 36);
		groupSceltaStrategiaFilosofi.add(radioDefault);
		panelMainButton.add(radioDefault);
		JRadioButton radioClassico = new JRadioButton("Schema Classico");
		radioClassico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (radioClassico.isSelected()) 
				{
					labelFilosofo1.setIcon(imageAttesa);
					for (int i = 0; i < threadClassico.length; i++) 
					{
						filosofiAtomici[i].stop();
						System.out.println("Ho interotto Esecuzione dei filosofi atomici " + i);
						filosofiClassica[i].resume();
						threadClassico[i]= new Thread(filosofiClassica[i]);
						threadClassico[i].start();
					}
				}
				
			    
			}
		});
		radioClassico.setFont(new Font("Tahoma", Font.PLAIN, 11));
		radioClassico.setBounds(1161, 363, 175, 34);
		groupSceltaStrategiaFilosofi.add(radioClassico);
		panelMainButton.add(radioClassico);
		
		JRadioButton radioAtomico = new JRadioButton("Schema Atomico");
		radioAtomico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (radioAtomico.isSelected()) 
				{
					labelFilosofo1.setIcon(imageReady);
					for (int i = 0; i < threadAtomico.length; i++) 
					{
						filosofiClassica[i].stop();
						System.out.println("Ho interotto Esecuzione dei filosofi Classici" + i);
						filosofiAtomici[i].resume();
						threadAtomico[i]= new Thread(filosofiAtomici[i]);
						threadAtomico[i].start();
					}
				}
			}
		});
		radioAtomico.setBounds(1161, 400, 175, 34);
		groupSceltaStrategiaFilosofi.add(radioAtomico);
		panelMainButton.add(radioAtomico);
		
		JLabel labelTavola = new JLabel("tavola");
		labelTavola.setBounds(117, 251, 482, 371);
		labelTavola.setIcon(imageTavola);
		panelMainButton.add(labelTavola);
		
		
		
		
	}
}
