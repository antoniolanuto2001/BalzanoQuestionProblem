package gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PaginazioneMemoria extends JFrame {

		private JPanel contentPane;
		private JFrame frame;
		private String scelta="0";

		XYSeries series0 = new XYSeries("P1");
		XYSeries series1 = new XYSeries("P2");
		XYSeries series2 = new XYSeries("P3");
		XYSeries series3 = new XYSeries("P4");
		XYSeries series4 = new XYSeries("P5");
		XYSeries series5 = new XYSeries("P6");
		XYSeriesCollection dataset1 = new XYSeriesCollection();
		XYSeriesCollection dataset2 = new XYSeriesCollection();
		XYSeriesCollection dataset3 = new XYSeriesCollection();
		XYSeriesCollection dataset4 = new XYSeriesCollection();
		XYSeriesCollection dataset = new XYSeriesCollection();

		ArrayList<XYSeries> arraySeries=new ArrayList<XYSeries>();
		
		JFreeChart chart1 = ChartFactory.createXYLineChart(
	            "GRAFICO FCFS",
	            "",
	            ""  ,
	            dataset,
	            PlotOrientation.VERTICAL,
	            true,
	            true,
	            false
	    );
		JFreeChart chart2 = ChartFactory.createXYLineChart(
	            "GRAFICO SJF",
	            "",
	            ""  ,
	            dataset,
	            PlotOrientation.VERTICAL,
	            true,
	            true,
	            false
	    );
		JFreeChart chart3 = ChartFactory.createXYLineChart(
	            "GRAFICO SJFP",
	            "",
	            ""  ,
	            dataset,
	            PlotOrientation.VERTICAL,
	            true,
	            true,
	            false
	    );
		JFreeChart chart4 = ChartFactory.createXYLineChart(
	            "GRAFICO RR",
	            "",
	            ""  ,
	            dataset,
	            PlotOrientation.VERTICAL,
	            true,
	            true,
	            false
	    );
		
		private int i=0;
		private JTextField stringaNumeri;

		//private TimeSeriesCollection timeCollection;


		/**
		 * Create the frame.
		 */
		public PaginazioneMemoria(JFrame framechiamante) 
		{
			frame=this;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1440, 800);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			setTitle("Applicativo esercizi Sistemi Operativi I: Paginazione della memoria");

			JPanel panelMainButton = new JPanel();
			panelMainButton.setForeground(new Color(153, 204, 255));
			panelMainButton.setBounds(0, 0, 1440, 800);
			frame.getContentPane().add(panelMainButton);
			panelMainButton.setLayout(null);

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
			buttonIndietro.setBounds(315, 95, 128, 48);
			panelMainButton.add(buttonIndietro);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(51, 204, 255));
			panel.setBounds(0, 0, 1416, 75);
			panelMainButton.add(panel);
			panel.setLayout(null);
			
			JLabel labelTitolo = new JLabel("Paginazione della memoria");
			labelTitolo.setForeground(new Color(0, 0, 0));
			labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitolo.setFont(new Font("Times New Roman", Font.BOLD, 50));
			labelTitolo.setBounds(0, 0, 1416, 73);
			panel.add(labelTitolo);
			
			JTextArea txtrUniversitDegliStudi = new JTextArea();
			txtrUniversitDegliStudi.setBounds(1151, 0, 265, 73);
			panel.add(txtrUniversitDegliStudi);
			txtrUniversitDegliStudi.setBackground(new Color(0, 204, 255));
			txtrUniversitDegliStudi.setText("UNIversit\u00E0 degli studi di NApoli\r\nAnno Accademico: 2021/2022\r\nProfessore: Walter Balzano\r\nProgettisti: Lanuto, Prosciutto, Scotto\r\n");
			txtrUniversitDegliStudi.setLineWrap(true);
			txtrUniversitDegliStudi.setFont(new Font("Cambria", Font.PLAIN, 13));
			txtrUniversitDegliStudi.setEditable(false);
			
			JButton buttonGenera = new JButton("Genera Esercizio");
			buttonGenera.setFont(new Font("Arial", Font.BOLD, 15));
			buttonGenera.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonGenera.setBackground(new Color(51, 204, 0));
			buttonGenera.setBounds(10, 95, 157, 48);
			panelMainButton.add(buttonGenera);
			
			JButton btnSlideArgomento = new JButton("Slide Argomento");
			btnSlideArgomento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					File file = new File("C:\\Users\\biagi\\Desktop\\13° SO\\APPBalzano\\BalzanoQuestionProblem\\BalzanoQuestioProgram\\src\\gui\\SLIDE6.pdf");
					try {
						Desktop.getDesktop().open(file);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(contentPane,"FILE NON PRESENTE");
						e1.printStackTrace();
					}
				}
			});
		    btnSlideArgomento.setOpaque(true);
		    btnSlideArgomento.setFont(new Font("Segoe UI", Font.BOLD, 14));
		    btnSlideArgomento.setBorder(new LineBorder(new Color(0, 0, 0)));
		    btnSlideArgomento.setBackground(new Color(153, 255, 255));
		    btnSlideArgomento.setBounds(177, 95, 128, 48);
	        panelMainButton.add(btnSlideArgomento);
	        frame.setVisible(true); 
		        
			JButton buttonEsci = new JButton("Esci");
			buttonEsci.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			buttonEsci.setFont(new Font("Segoe UI", Font.BOLD, 14));
			buttonEsci.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonEsci.setBackground(new Color(255, 204, 0));
			buttonEsci.setBounds(453, 95, 128, 48);
			panelMainButton.add(buttonEsci);
	        
	        String[] grade =  new String[7];
	        grade[0] = "";
	        grade[1] = "Processo 1";
	        grade[2] = "Processo 2";
	        grade[3] = "Processo 3";
	        grade[4] = "Processo 4";
	        grade[5] = "Processo 5";
	        grade[6] = "Processo 6";
	        SymbolAxis rangeAxis = new SymbolAxis("", grade);

	        /*GRAFICO 1*/        
	        XYPlot plot1 = chart1.getXYPlot();
	        XYLineAndShapeRenderer renderer1 = new XYLineAndShapeRenderer();
	        renderer1.setSeriesPaint(0, Color.RED);
	        renderer1.setSeriesStroke(0, new BasicStroke(2.0f));
	        plot1.setRenderer(renderer1);
	        plot1.setBackgroundPaint(Color.white);
	        plot1.setRangeGridlinesVisible(true);
	        plot1.setRangeGridlinePaint(Color.BLACK);
	        plot1.setDomainGridlinesVisible(true);
	        plot1.setDomainGridlinePaint(Color.BLACK);
	        chart1.getLegend().setFrame(BlockBorder.NONE);
	        chart1.setTitle(new TextTitle("GRAFICO FCFS",
	        new Font("Serif", java.awt.Font.BOLD, 18)
	        )
	        );
	        
	        rangeAxis.setTickUnit(new NumberTickUnit(1));
	        rangeAxis.setRange(0,grade.length);
	        plot1.setRangeAxis(rangeAxis);
	        
	        /*GRAFICO 2*/
	        XYPlot plot2 = chart2.getXYPlot();
	        XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();
	        renderer2.setSeriesPaint(0, Color.RED);
	        renderer2.setSeriesStroke(0, new BasicStroke(2.0f));
	        plot2.setRenderer(renderer2);
	        plot2.setBackgroundPaint(Color.white);
	        plot2.setRangeGridlinesVisible(true);
	        plot2.setRangeGridlinePaint(Color.BLACK);
	        plot2.setDomainGridlinesVisible(true);
	        plot2.setDomainGridlinePaint(Color.BLACK);
	        chart2.getLegend().setFrame(BlockBorder.NONE);
	        chart2.setTitle(new TextTitle("GRAFICO SJF",
	        new Font("Serif", java.awt.Font.BOLD, 18)
	        )
	        );
	        
	        rangeAxis.setTickUnit(new NumberTickUnit(1));
	        rangeAxis.setRange(0,grade.length);
	        plot2.setRangeAxis(rangeAxis);
	        
	        /*GRAFICO 3*/
	        XYPlot plot3 = chart3.getXYPlot();
	        XYLineAndShapeRenderer renderer3 = new XYLineAndShapeRenderer();
	        renderer3.setSeriesPaint(0, Color.RED);
	        renderer3.setSeriesStroke(0, new BasicStroke(2.0f));
	        plot3.setRenderer(renderer3);
	        plot3.setBackgroundPaint(Color.white);
	        plot3.setRangeGridlinesVisible(true);
	        plot3.setRangeGridlinePaint(Color.BLACK);
	        plot3.setDomainGridlinesVisible(true);
	        plot3.setDomainGridlinePaint(Color.BLACK);
	        chart3.getLegend().setFrame(BlockBorder.NONE);
	        chart3.setTitle(new TextTitle("GRAFICO SJFP",
	        new Font("Serif", java.awt.Font.BOLD, 18)
	        )
	        );
	        
	        rangeAxis.setTickUnit(new NumberTickUnit(1));
	        rangeAxis.setRange(0,grade.length);
	        plot3.setRangeAxis(rangeAxis);
	        
	        /*GRAFICO 4*/
	        XYPlot plot4 = chart4.getXYPlot();
	        XYLineAndShapeRenderer renderer4 = new XYLineAndShapeRenderer();
	        renderer4.setSeriesPaint(0, Color.RED);
	        renderer4.setSeriesStroke(0, new BasicStroke(2.0f));
	        plot4.setRenderer(renderer4);
	        plot4.setBackgroundPaint(Color.white);
	        plot4.setRangeGridlinesVisible(true);
	        plot4.setRangeGridlinePaint(Color.BLACK);
	        plot4.setDomainGridlinesVisible(true);
	        plot4.setDomainGridlinePaint(Color.BLACK);
	        chart4.getLegend().setFrame(BlockBorder.NONE);
	        chart4.setTitle(new TextTitle("GRAFICO RR",
	        new Font("Serif", java.awt.Font.BOLD, 18)
	        )
	        );
	        
	       
	        
	        rangeAxis.setTickUnit(new NumberTickUnit(1));
	        rangeAxis.setRange(0,grade.length);
	        plot4.setRangeAxis(rangeAxis);
	                
		    
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(1129, 97, 265, 648);
			panelMainButton.add(panel_1);
			panel_1.setLayout(null);
			panel_1.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 51),2));
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(10, 10, 245, 54);
			panel_2.setBackground(new Color(255, 204, 51));
			panel_1.add(panel_2);
			panel_2.setLayout(null);
			panel_2.setBorder(BorderFactory.createRaisedBevelBorder());
				
			JLabel labelPnlCtrl = new JLabel("Pannello di controllo");
			labelPnlCtrl.setHorizontalAlignment(SwingConstants.CENTER);
			labelPnlCtrl.setBounds(0, 0, 245, 54);
			panel_2.add(labelPnlCtrl);
			labelPnlCtrl.setFont(new Font("Arial", Font.BOLD, 22));
			
			JLabel labelEditor = new JLabel("Editor");
			labelEditor.setHorizontalAlignment(SwingConstants.CENTER);
			labelEditor.setForeground(new Color(255, 0, 0));
			labelEditor.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelEditor.setBounds(0, 70, 265, 25);
			panel_1.add(labelEditor);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(10, 95, 245, 224);
			panel_1.add(panel_3);
			panel_3.setLayout(null);
			panel_3.setBorder(BorderFactory.createLineBorder(Color.black));
			
			JLabel lblSlotMemoria = new JLabel("Slot Memoria Disponibili");
			lblSlotMemoria.setHorizontalAlignment(SwingConstants.CENTER);
			lblSlotMemoria.setForeground(new Color(0, 0, 0));
			lblSlotMemoria.setFont(new Font("Arial", Font.BOLD, 14));
			lblSlotMemoria.setBounds(0, 2, 181, 23);
			panel_3.add(lblSlotMemoria);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			comboBox.setBackground(new Color(255, 255, 255));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7"}));
			comboBox.setBounds(185, 2, 50, 21);
			panel_3.add(comboBox);
			
			JLabel lblSuccessioneDiRiferimento = new JLabel("Successione di riferimento:");
			lblSuccessioneDiRiferimento.setHorizontalAlignment(SwingConstants.CENTER);
			lblSuccessioneDiRiferimento.setForeground(Color.BLACK);
			lblSuccessioneDiRiferimento.setFont(new Font("Arial", Font.BOLD, 14));
			lblSuccessioneDiRiferimento.setBounds(10, 47, 225, 23);
			panel_3.add(lblSuccessioneDiRiferimento);
			
			stringaNumeri = new JTextField();
			stringaNumeri.setEditable(false);
			stringaNumeri.setFont(new Font("Arial", Font.BOLD, 12));
			stringaNumeri.setHorizontalAlignment(SwingConstants.CENTER);
			stringaNumeri.setBounds(10, 107, 225, 19);
			panel_3.add(stringaNumeri);
			stringaNumeri.setColumns(10);
			
			JCheckBox chckbxAttivaModifiche = new JCheckBox("Attiva modifiche");
			chckbxAttivaModifiche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stringaNumeri.setEditable(true);
				}
			});
			chckbxAttivaModifiche.setBounds(10, 156, 136, 21);
			panel_3.add(chckbxAttivaModifiche);
			chckbxAttivaModifiche.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			
			JButton btnNewButton_2 = new JButton("Salva");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stringaNumeri.setText(stringaNumeri.getText());
					stringaNumeri.setEditable(false);
				}
			});
			btnNewButton_2.setBounds(152, 157, 83, 21);
			panel_3.add(btnNewButton_2);
			
			JButton btnPlay = new JButton("ESEGUI");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(stringaNumeri.getText());
				}
			});
			btnPlay.setBounds(63, 195, 118, 21);
			panel_3.add(btnPlay);
			btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JButton btnNewButton = new JButton("<");
			btnNewButton.setBounds(10, 195, 51, 21);
			panel_3.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton(">");
			btnNewButton_1.setBounds(184, 195, 51, 21);
			panel_3.add(btnNewButton_1);
			
			JButton btnGeneraSuccessione = new JButton("Genera successione");
			btnGeneraSuccessione.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stringaNumeri.setText("");
					for (int i=0;i<18;i++) { 
						
						Random random = new Random();
						int value = random.nextInt(10 + 0) + 0;
						stringaNumeri.setText(stringaNumeri.getText()+" "+value);
					}
				}
			});
			btnGeneraSuccessione.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnGeneraSuccessione.setBounds(10, 76, 225, 21);
			panel_3.add(btnGeneraSuccessione);
			
		       
			JPanel panel_5 = new JPanel();
			panel_5.setBounds(10, 329, 245, 309);
			panel_1.add(panel_5);
			panel_5.setLayout(null);
			
			JTextArea txtrHelpArea = new JTextArea();
			txtrHelpArea.setBounds(0, 27, 245, 282);
			panel_5.add(txtrHelpArea);
			txtrHelpArea.setText("AREA HELP");
			txtrHelpArea.setFont(new Font("Cambria", Font.PLAIN, 14));
			txtrHelpArea.setEditable(false);
			txtrHelpArea.setLineWrap(true);
			
			JLabel lblHelp = new JLabel("Help");
			lblHelp.setBounds(0, 0, 245, 25);
			panel_5.add(lblHelp);
			lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
			lblHelp.setForeground(Color.RED);
			lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JPanel panel_6 = new JPanel();
			panel_6.setLayout(null);
			panel_6.setBounds(5, 153, 1114, 600);
			panelMainButton.add(panel_6);
			
			JPanel panel_7 = new JPanel();
			panel_7.setLayout(null);
			panel_7.setBounds(0, 0, 548, 295);
			panel_6.add(panel_7);
			
			JPanel panel_8 = new JPanel();
			panel_8.setLayout(null);
			panel_8.setBounds(556, 0, 548, 295);
			panel_6.add(panel_8);
			
			JPanel panel_9 = new JPanel();
			panel_9.setLayout(null);
			panel_9.setBounds(0, 305, 548, 295);
			panel_6.add(panel_9);
			
			JPanel panel_10 = new JPanel();
			panel_10.setLayout(null);
			panel_10.setBounds(558, 305, 548, 295);
			panel_6.add(panel_10);
			
			
		}
	}
