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
import java.awt.Desktop;

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.SwingConstants;

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
		frame.setTitle("Balzano Question Problem : Main Menu");
		frame.setTitle("Balzano Question Problem");
		ImageIcon imageSfondo = new ImageIcon(this.getClass().getResource("/img/desktopIcon4.png"));
		
		JPanel panelMainButton = new JPanel();
		panelMainButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelMainButton.setBackground(new Color(187, 222, 251));
		panelMainButton.setBounds(0, 0, 1440, 800);
		
		frame.getContentPane().add(panelMainButton);
		panelMainButton.setLayout(null);
		
		JLabel labelSfondo = new JLabel("");
		labelSfondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI ("https://sites.google.com/site/walterbalzano/didattica/sistemi-operativi"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		labelSfondo.setBounds(89, 135, 1259, 356);
		labelSfondo.setIcon(imageSfondo);
		panelMainButton.add(labelSfondo);
		
		JButton buttonCpu = new JButton("Scheduling  Processi");
		buttonCpu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SchProcessi frameDachiamareProcessi= new SchProcessi(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
		});
		buttonCpu.setBackground(new Color(255, 255, 255));
		buttonCpu.setBorder(new LineBorder(new Color(0, 204, 255), 6));
		buttonCpu.setForeground(new Color(0, 0, 0));
		buttonCpu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonCpu.setBounds(281, 559, 215, 99);
		buttonCpu.setOpaque(true);
		panelMainButton.add(buttonCpu);
		
		
		JButton buttonHashing = new JButton("Hashing");
		buttonHashing.setBackground(new Color(255, 255, 255));
		buttonHashing.setBorder(new LineBorder(new Color(153, 0, 255), 6));
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
		buttonHashing.setBounds(731, 559, 215, 99);
		panelMainButton.add(buttonHashing);
		
		JButton buttonFiloACena = new JButton("Filosofi a Cena");
		buttonFiloACena.setForeground(Color.BLACK);
		buttonFiloACena.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonFiloACena.setBorder(new LineBorder(new Color(255, 0, 153), 6));
		buttonFiloACena.setBackground(new Color(255, 255, 255));
		buttonFiloACena.setBounds(506, 559, 215, 99);
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
		buttonSemafori.setBorder(new LineBorder(new Color(255, 204, 0), 6));
		buttonSemafori.setBackground(new Color(255, 255, 255));
		buttonSemafori.setOpaque(true);
		buttonSemafori.setBounds(1181, 559, 215, 99);
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
		buttonPaginazioneDellaMemoria.setBorder(new LineBorder(new Color(0, 204, 0), 6));
		buttonPaginazioneDellaMemoria.setBackground(new Color(255, 255, 255));
		buttonPaginazioneDellaMemoria.setOpaque(true);
		buttonPaginazioneDellaMemoria.setBounds(56, 559, 215, 99);
		buttonPaginazioneDellaMemoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PaginazioneDellaMemoria frameDachiamareProcessi= new PaginazioneDellaMemoria(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
		});	
		panelMainButton.add(buttonPaginazioneDellaMemoria);
		
		JButton buttonSchedulingHd = new JButton("Scheduling  HD");
		buttonSchedulingHd.setForeground(Color.BLACK);
		buttonSchedulingHd.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonSchedulingHd.setBorder(new LineBorder(new Color(0, 102, 255), 6));
		buttonSchedulingHd.setBackground(new Color(255, 255, 255));
		buttonSchedulingHd.setOpaque(true);
		buttonSchedulingHd.setBounds(956, 559, 215, 99);
		buttonSchedulingHd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SchHD frameDachiamareProcessi= new SchHD(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
		});
		
		panelMainButton.add(buttonSchedulingHd);
		
		JButton btnVideolezioni = new JButton("Videolezioni");
		btnVideolezioni.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnVideolezioni.setBorder(new LineBorder(new Color(153, 0, 0), 4));
		btnVideolezioni.setBackground(Color.WHITE);
		btnVideolezioni.setBounds(293, 9, 138, 46);
		panelMainButton.add(btnVideolezioni);
		
		JButton btnSlideCorso = new JButton("Slide Corso");
		btnSlideCorso.setOpaque(true);
		btnSlideCorso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnSlideCorso.setBorder(new LineBorder(new Color(255, 204, 0), 4));
		btnSlideCorso.setBackground(Color.WHITE);
		btnSlideCorso.setBounds(441, 8, 128, 48);
		panelMainButton.add(btnSlideCorso);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEsci.setOpaque(true);
		btnEsci.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnEsci.setBorder(new LineBorder(Color.RED, 4));
		btnEsci.setBackground(Color.WHITE);
		btnEsci.setBounds(10, 8, 128, 48);
		panelMainButton.add(btnEsci);
		
		JButton btnSitoWeb = new JButton("Sito Web");
		btnSitoWeb.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnSitoWeb.setBorder(new LineBorder(new Color(153, 0, 255), 4));
		btnSitoWeb.setBackground(Color.WHITE);
		btnSitoWeb.setBounds(148, 9, 138, 46);
		panelMainButton.add(btnSitoWeb);
		btnSitoWeb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI ("https://sites.google.com/site/walterbalzano/didattica/sistemi-operativi"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Paginazione Della Memoria");
		lblNewLabel.setBounds(66, 668, 195, 23);
		panelMainButton.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblSchedulingProcessi = new JLabel("Scheduling  Processi");
		lblSchedulingProcessi.setBounds(291, 668, 195, 23);
		panelMainButton.add(lblSchedulingProcessi);
		lblSchedulingProcessi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchedulingProcessi.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblFilosofiACena = new JLabel("Filosofi a Cena");
		lblFilosofiACena.setBounds(516, 668, 195, 23);
		panelMainButton.add(lblFilosofiACena);
		lblFilosofiACena.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilosofiACena.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblHashing = new JLabel("Hashing");
		lblHashing.setBounds(741, 668, 195, 23);
		panelMainButton.add(lblHashing);
		lblHashing.setHorizontalAlignment(SwingConstants.CENTER);
		lblHashing.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblSchedulingHd = new JLabel("Scheduling  HD");
		lblSchedulingHd.setBounds(966, 668, 205, 23);
		panelMainButton.add(lblSchedulingHd);
		lblSchedulingHd.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchedulingHd.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblSemafori = new JLabel("Semafori");
		lblSemafori.setBounds(1191, 668, 195, 23);
		panelMainButton.add(lblSemafori);
		lblSemafori.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemafori.setFont(new Font("Segoe UI", Font.BOLD, 12));
	
		
		
		
		
	}
}
