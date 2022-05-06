package gui;

import model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;



public class Filosofi extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private boolean continuaEsecuzione;

	/**
	 * Create the frame.
	 */
	public Filosofi(JFrame framechiamante) 
	{
		frame=this;
		continuaEsecuzione=false;
		Thread threadClassico[] = new Thread[5];
		Thread threadAtomico[] = new Thread[5];
		FilosofiClassica filosofiClassica[] = new FilosofiClassica[5];
		for (int i = 0; i < filosofiClassica.length; i++) 
		{
			filosofiClassica[i] = new FilosofiClassica(i);
		}
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
		JRadioButton radioClassico = new JRadioButton("Schema Classico");
		radioClassico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (radioClassico.isSelected()) 
				{
					for (int i = 0; i < threadClassico.length; i++) 
					{
						filosofiClassica[i].resume();
						threadClassico[i]= new Thread(filosofiClassica[i]);
						threadClassico[i].start();
					}
				}
				else 
				{
					for (int i = 0; i < filosofiClassica.length; i++) 
					{
						filosofiClassica[i].stop();
						System.out.println("Ho interotto Esecuzione del " + i);
					}
				}
			    
			}
		});
		radioClassico.setFont(new Font("Tahoma", Font.PLAIN, 11));
		radioClassico.setBounds(1123, 366, 175, 34);
		groupSceltaStrategiaFilosofi.add(radioClassico);
		panelMainButton.add(radioClassico);
		
		JRadioButton radioAtomico = new JRadioButton("Schema Atomico");
		radioAtomico.setBounds(1123, 403, 175, 34);
		groupSceltaStrategiaFilosofi.add(radioAtomico);
		panelMainButton.add(radioAtomico);
		
		JRadioButton radioDefault = new JRadioButton("Nessuna");
		radioDefault.setBounds(1123, 327, 175, 36);
		panelMainButton.add(radioDefault);
		
	}
}
