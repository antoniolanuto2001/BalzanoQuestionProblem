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
import javax.swing.text.AttributeSet.ColorAttribute;
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
		ImageIcon imageCPU = new ImageIcon(this.getClass().getResource("/img/cpuIcon1.png"));
		ImageIcon imageFilosofi = new ImageIcon(this.getClass().getResource("/img/filosofoIcon1.png"));
		ImageIcon imageHashing = new ImageIcon(this.getClass().getResource("/img/hashingIcon1.png"));
		ImageIcon imageHD = new ImageIcon(this.getClass().getResource("/img/hdIcon1.png"));
		ImageIcon imageSemafori = new ImageIcon(this.getClass().getResource("/img/semaforoIcon1.png"));
		JPanel panelMainButton = new JPanel();
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
		
		JLabel labelScrittaPaginazione = new JLabel("PAGINAZIONE DELLA MEMORIA");
		labelScrittaPaginazione.setForeground(new Color(0, 0, 0));
		labelScrittaPaginazione.setBounds(234, 626, 195, 23);
		panelMainButton.add(labelScrittaPaginazione);
		labelScrittaPaginazione.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaPaginazione.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel labelScrittaSchProcessi = new JLabel("SCHEDULING DEI PROCESSI");
		labelScrittaSchProcessi.setForeground(new Color(0, 0, 0));
		labelScrittaSchProcessi.setBounds(415, 626, 195, 23);
		panelMainButton.add(labelScrittaSchProcessi);
		labelScrittaSchProcessi.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaSchProcessi.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel labelScrittaFilosofi = new JLabel("FILOSOFI A CENA");
		labelScrittaFilosofi.setForeground(new Color(0, 0, 0));
		labelScrittaFilosofi.setBounds(574, 626, 195, 23);
		panelMainButton.add(labelScrittaFilosofi);
		labelScrittaFilosofi.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaFilosofi.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel labelScrittaHashing = new JLabel("HASHING");
		labelScrittaHashing.setForeground(new Color(0, 0, 0));
		labelScrittaHashing.setBounds(719, 626, 195, 23);
		panelMainButton.add(labelScrittaHashing);
		labelScrittaHashing.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaHashing.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel labelScrittaHD = new JLabel("SCHEDULING HD");
		labelScrittaHD.setForeground(new Color(0, 0, 0));
		labelScrittaHD.setBounds(876, 626, 205, 23);
		panelMainButton.add(labelScrittaHD);
		labelScrittaHD.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaHD.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel labelScrittaSemafori = new JLabel("SEMAFORI");
		labelScrittaSemafori.setForeground(new Color(0, 0, 0));
		labelScrittaSemafori.setBounds(1023, 627, 195, 23);
		panelMainButton.add(labelScrittaSemafori);
		labelScrittaSemafori.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaSemafori.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel labelSitoWeb = new JLabel("SITO WEB");
		labelSitoWeb.addMouseListener(new MouseAdapter() {
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
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelSitoWeb.setForeground(new Color (255,127,80));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelSitoWeb.setForeground(new Color(211, 47, 47));
			}
		});
		labelSitoWeb.setHorizontalAlignment(SwingConstants.CENTER);
		labelSitoWeb.setForeground(new Color(211, 47, 47));
		labelSitoWeb.setFont(new Font("Segoe UI", Font.BOLD, 26));
		labelSitoWeb.setBounds(329, 11, 205, 54);
		panelMainButton.add(labelSitoWeb);
		
		JLabel labelVideolezioni = new JLabel("VIDEOLEZIONI");
		labelVideolezioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI ("https://www.youtube.com/channel/UCQWnq8ucak-M5D27I3yfwiw"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelVideolezioni.setForeground(new Color (255,127,80));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelVideolezioni.setForeground(new Color(211, 47, 47));
			}
		});
		labelVideolezioni.setHorizontalAlignment(SwingConstants.CENTER);
		labelVideolezioni.setForeground(new Color(211, 47, 47));
		labelVideolezioni.setFont(new Font("Segoe UI", Font.BOLD, 26));
		labelVideolezioni.setBounds(574, 11, 279, 54);
		panelMainButton.add(labelVideolezioni);
		
		JLabel labellSlideCorso = new JLabel("SLIDE CORSO");
		labellSlideCorso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI ("http://balzanoslidesistemiopera.altervista.org/Slides_Sistemi_Operativi.pdf"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
		
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labellSlideCorso.setForeground(new Color (255,127,80));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labellSlideCorso.setForeground(new Color(211, 47, 47));
			}
		});
		labellSlideCorso.setHorizontalAlignment(SwingConstants.CENTER);
		labellSlideCorso.setForeground(new Color(211, 47, 47));
		labellSlideCorso.setFont(new Font("Segoe UI", Font.BOLD, 26));
		labellSlideCorso.setBounds(871, 11, 247, 54);
		panelMainButton.add(labellSlideCorso);
		
		JLabel labelPaginazione = new JLabel("Paginzione Icon");
		labelPaginazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PaginazioneDellaMemoria frameDachiamareProcessi= new PaginazioneDellaMemoria(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelScrittaPaginazione.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelScrittaPaginazione.setForeground(Color.BLACK);
			}
		});
		labelPaginazione.setIcon(new ImageIcon(MainWindows.class.getResource("/img/paginazioneIcon2.png")));
		labelPaginazione.setBounds(274, 516, 117, 99);
		panelMainButton.add(labelPaginazione);
		
		JLabel labelCpu = new JLabel("Cpu Icon");
		labelCpu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				SchProcessi frameDachiamareProcessi= new SchProcessi(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelScrittaSchProcessi.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelScrittaSchProcessi.setForeground(Color.BLACK);
			}
		});
		labelCpu.setBounds(453, 516, 117, 99);
		labelCpu.setIcon(imageCPU);
		panelMainButton.add(labelCpu);
		
		JLabel labelFilosofo = new JLabel("Filosofo Icon");
		labelFilosofo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Filosofi frameDachiamareProcessi= new Filosofi(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelScrittaFilosofi.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelScrittaFilosofi.setForeground(Color.BLACK);
			}
		});
		labelFilosofo.setBounds(615, 516, 117, 99);
		labelFilosofo.setIcon(imageFilosofi);
		panelMainButton.add(labelFilosofo);
		
		JLabel labelHashing = new JLabel("Hashing Icon");
		labelHashing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hashing frameDachiamareProcessi= new Hashing(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelScrittaHashing.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelScrittaHashing.setForeground(Color.BLACK);
			}
		});
		labelHashing.setBounds(757, 519, 117, 99);
		labelHashing.setIcon(imageHashing);
		panelMainButton.add(labelHashing);
		
		JLabel labelHD = new JLabel("Sch HD");
		labelHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SchHD frameDachiamareProcessi= new SchHD(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelScrittaHD.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelScrittaHD.setForeground(Color.BLACK);
			}
		});
		labelHD.setBounds(912, 528, 117, 99);
		labelHD.setIcon(imageHD);
		panelMainButton.add(labelHD);
		
		JLabel labelSemaforo = new JLabel("Semafori");
		labelSemaforo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Semafori frameDachiamareProcessi= new Semafori(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelScrittaSemafori.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelScrittaSemafori.setForeground(Color.BLACK);
			}
		});
		labelSemaforo.setBounds(1064, 523, 117, 99);
		labelSemaforo.setIcon(imageSemafori);
		panelMainButton.add(labelSemaforo);
	
		
		
		
		
	}
}