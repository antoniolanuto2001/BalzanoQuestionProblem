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
		frame.setTitle("Balzano Question Problem : Main Menu");
		
		JPanel panelMainButton = new JPanel();
		panelMainButton.setForeground(new Color(153, 204, 255));
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
		
		JLabel labelScrittaPaginazione = new JLabel("Paginazione Della Memoria");
		labelScrittaPaginazione.setBounds(234, 626, 195, 23);
		panelMainButton.add(labelScrittaPaginazione);
		labelScrittaPaginazione.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaPaginazione.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel labelScrittaSchProcessi = new JLabel("Scheduling  Processi");
		labelScrittaSchProcessi.setBounds(415, 626, 195, 23);
		panelMainButton.add(labelScrittaSchProcessi);
		labelScrittaSchProcessi.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaSchProcessi.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel labelScrittaFilosofi = new JLabel("Filosofi a Cena");
		labelScrittaFilosofi.setBounds(574, 626, 195, 23);
		panelMainButton.add(labelScrittaFilosofi);
		labelScrittaFilosofi.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaFilosofi.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel labelScrittaHashing = new JLabel("Hashing");
		labelScrittaHashing.setBounds(719, 626, 195, 23);
		panelMainButton.add(labelScrittaHashing);
		labelScrittaHashing.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaHashing.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel labelScrittaHD = new JLabel("Scheduling  HD");
		labelScrittaHD.setBounds(876, 626, 205, 23);
		panelMainButton.add(labelScrittaHD);
		labelScrittaHD.setHorizontalAlignment(SwingConstants.CENTER);
		labelScrittaHD.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel labelScrittaSemafori = new JLabel("Semafori");
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
				labelSitoWeb.setForeground(Color.BLACK);
			}
		});
		labelSitoWeb.setHorizontalAlignment(SwingConstants.CENTER);
		labelSitoWeb.setForeground(Color.BLACK);
		labelSitoWeb.setFont(new Font("Segoe UI", Font.BOLD, 20));
		labelSitoWeb.setBounds(400, 11, 138, 23);
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
				labelVideolezioni.setForeground(Color.BLACK);
			}
		});
		labelVideolezioni.setHorizontalAlignment(SwingConstants.CENTER);
		labelVideolezioni.setForeground(Color.BLACK);
		labelVideolezioni.setFont(new Font("Segoe UI", Font.BOLD, 20));
		labelVideolezioni.setBounds(644, 11, 138, 23);
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
		
		JLabel testLabel2 = new JLabel("<3 ");
		testLabel2.setForeground(new Color(255, 51, 51));
		testLabel2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		testLabel2.setBounds(660, 367, 41, 35);
		panelMainButton.add(testLabel2);
		
		JButton buttonCpu = new JButton("Scheduling  Processi");
		buttonCpu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SchProcessiNuovoDiProva frameDachiamareProcessi= new SchProcessiNuovoDiProva(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
			}
		});
		buttonCpu.setBackground(new Color(204, 204, 255));
		buttonCpu.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonCpu.setForeground(new Color(0, 0, 0));
		buttonCpu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		buttonCpu.setBounds(260, 190, 215, 77);
		buttonCpu.setOpaque(true);
		panelMainButton.add(buttonCpu);
		
		JButton buttonHashing = new JButton("Hashing");
		buttonHashing.setBackground(new Color(153, 204, 255));
		buttonHashing.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonHashing.setForeground(new Color(0, 0, 0));
		buttonHashing.setOpaque(true);
		buttonHashing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				SchProcessi frameDachiamareProcessi= new SchProcessi(frame);
				frameDachiamareProcessi.setVisible(true);	
				frame.setVisible(false);
				
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
		buttonSemafori.setBackground(new Color(255, 102, 102));
		buttonSemafori.setOpaque(true);
		buttonSemafori.setBounds(876, 190, 215, 77);
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
		buttonPaginazioneDellaMemoria.setBackground(new Color(255, 153, 153));
		buttonPaginazioneDellaMemoria.setOpaque(true);
		buttonPaginazioneDellaMemoria.setBounds(884, 332, 215, 77);
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
		buttonSchedulingHd.setBackground(new Color(255, 153, 204));
		buttonSchedulingHd.setOpaque(true);
		buttonSchedulingHd.setBounds(576, 456, 215, 77);
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
