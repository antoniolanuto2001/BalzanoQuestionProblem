package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class MainWindows {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @author Antonio Lanuto
	 * @author Erasmo Prosciutto
	 * @author Biagio Scotto
	 * Ciao tommaso come stai ???????
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindows window = new MainWindows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1440, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelMainButton = new JPanel();
		panelMainButton.setForeground(new Color(153, 204, 255));
		panelMainButton.setBounds(0, 0, 1440, 800);
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);
		
		JLabel testLabel1 = new JLabel("Ciao Erasmo ed Biagio");
		testLabel1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		testLabel1.setBounds(610, 332, 143, 41);
		panelMainButton.add(testLabel1);
		
		JLabel testLabel2 = new JLabel("<3 ");
		testLabel2.setForeground(new Color(255, 0, 51));
		testLabel2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		testLabel2.setBounds(660, 367, 41, 35);
		panelMainButton.add(testLabel2);
		
		JButton buttonCpu = new JButton("Scheduling  Processi");
		buttonCpu.setBackground(new Color(204, 204, 255));
		buttonCpu.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonCpu.setForeground(new Color(0, 0, 0));
		buttonCpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonCpu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonCpu.setBounds(260, 190, 215, 77);
		panelMainButton.add(buttonCpu);
		
		JButton buttonHashing = new JButton("Hashing");
		buttonHashing.setBackground(new Color(153, 204, 255));
		buttonHashing.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonHashing.setForeground(new Color(0, 0, 0));
		buttonHashing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonHashing.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonHashing.setBounds(563, 190, 215, 77);
		panelMainButton.add(buttonHashing);
		
		JButton buttonFiloACena = new JButton("Filosofi a Cena");
		buttonFiloACena.setForeground(Color.BLACK);
		buttonFiloACena.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonFiloACena.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonFiloACena.setBackground(new Color(153, 255, 153));
		buttonFiloACena.setBounds(260, 347, 215, 77);
		panelMainButton.add(buttonFiloACena);
		
		JButton buttonSemafori = new JButton("Semafori");
		buttonSemafori.setForeground(Color.BLACK);
		buttonSemafori.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonSemafori.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonSemafori.setBackground(new Color(255, 102, 102));
		buttonSemafori.setBounds(876, 190, 215, 77);
		panelMainButton.add(buttonSemafori);
		
		JButton buttonPaginazioneDellaMemoria = new JButton("Paginazione Della Memoria");
		buttonPaginazioneDellaMemoria.setForeground(Color.BLACK);
		buttonPaginazioneDellaMemoria.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonPaginazioneDellaMemoria.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonPaginazioneDellaMemoria.setBackground(new Color(255, 153, 153));
		buttonPaginazioneDellaMemoria.setBounds(884, 332, 215, 77);
		panelMainButton.add(buttonPaginazioneDellaMemoria);
		
		JButton buttonSchedulingHd = new JButton("Scheduling  HD");
		buttonSchedulingHd.setForeground(Color.BLACK);
		buttonSchedulingHd.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonSchedulingHd.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonSchedulingHd.setBackground(new Color(255, 153, 204));
		buttonSchedulingHd.setBounds(576, 456, 215, 77);
		panelMainButton.add(buttonSchedulingHd);
		
		
		
		
	}
}
