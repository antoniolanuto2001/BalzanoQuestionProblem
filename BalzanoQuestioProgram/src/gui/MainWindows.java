package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindows {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @author Antonio Lanuto
	 * @author Erasmo Prosciutto
	 * @author Biagio Scotto
	 * Tommaso sei fortissimo 
	 * ciao a turuttututti
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
		frame.setTitle("Balzano Question Problem");
		ImageIcon imageSfondo = new ImageIcon(this.getClass().getResource("/img/desktopIcon4.png"));
		
		JPanel panelMainButton = new JPanel();
		panelMainButton.setBackground(new Color(187, 222, 251));
		panelMainButton.setBounds(0, 0, 1440, 800);
		
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);
		
		JLabel labelSfondo = new JLabel("");
		labelSfondo.setBounds(89, 135, 1259, 356);
		labelSfondo.setIcon(imageSfondo);
		panelMainButton.add(labelSfondo);
		
		JButton buttonCpu = new JButton("Scheduling  Processi");
		buttonCpu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SchProcessiNuovoDiProva frameDachiamareProcessi= new SchProcessiNuovoDiProva(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
		});
		buttonCpu.setBackground(new Color(141,237,252));
		buttonCpu.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonCpu.setForeground(new Color(0, 0, 0));
		buttonCpu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonCpu.setBounds(1192, 569, 215, 77);
		buttonCpu.setOpaque(true);
		panelMainButton.add(buttonCpu);
		
		
		JButton buttonHashing = new JButton("Hashing");
		buttonHashing.setBackground(new Color(122,207,240));
		buttonHashing.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonHashing.setForeground(new Color(0, 0, 0));
		buttonHashing.setOpaque(true);
		buttonHashing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hashing frameDachiamareProcessi= new Hashing(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
		});
		buttonHashing.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonHashing.setBounds(961, 569, 215, 77);
		panelMainButton.add(buttonHashing);
		
		JButton buttonFiloACena = new JButton("Filosofi a Cena");
		buttonFiloACena.setForeground(Color.BLACK);
		buttonFiloACena.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonFiloACena.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonFiloACena.setBackground(new Color(221,71,130));
		buttonFiloACena.setBounds(506, 569, 215, 77);
		buttonFiloACena.setOpaque(true);
		buttonFiloACena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Filosofi frameDachiamareProcessi= new Filosofi(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
		});
		
		panelMainButton.add(buttonFiloACena);
		
		JButton buttonSemafori = new JButton("Semafori");
		buttonSemafori.setForeground(Color.BLACK);
		buttonSemafori.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonSemafori.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonSemafori.setBackground(new Color(235,158,132));
		buttonSemafori.setOpaque(true);
		buttonSemafori.setBounds(281, 569, 215, 77);
		buttonSemafori.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Semafori frameDachiamareProcessi= new Semafori(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
		});
		
		panelMainButton.add(buttonSemafori);
		
		JButton buttonPaginazioneDellaMemoria = new JButton("Paginazione Della Memoria");
		buttonPaginazioneDellaMemoria.setForeground(Color.BLACK);
		buttonPaginazioneDellaMemoria.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonPaginazioneDellaMemoria.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonPaginazioneDellaMemoria.setBackground(new Color(245,243,236));
		buttonPaginazioneDellaMemoria.setOpaque(true);
		buttonPaginazioneDellaMemoria.setBounds(56, 569, 215, 77);
		buttonPaginazioneDellaMemoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PaginazioneMemoria frameDachiamareProcessi= new PaginazioneMemoria(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
		});	
		panelMainButton.add(buttonPaginazioneDellaMemoria);
		
		JButton buttonSchedulingHd = new JButton("Scheduling  HD");
		buttonSchedulingHd.setForeground(Color.BLACK);
		buttonSchedulingHd.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonSchedulingHd.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonSchedulingHd.setBackground(new Color(123,63,190));
		buttonSchedulingHd.setOpaque(true);
		buttonSchedulingHd.setBounds(736, 569, 215, 77);
		buttonSchedulingHd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SchHD frameDachiamareProcessi= new SchHD(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
		});
		
		panelMainButton.add(buttonSchedulingHd);
	
		
		
		
		
	}
}
