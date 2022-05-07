package gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.Canvas;
import java.awt.GridLayout;

import java.awt.Desktop;

public class SchProcessi extends JFrame {

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	private int i=0;

	//private TimeSeriesCollection timeCollection;


	/**
	 * Create the frame.
	 */
	public SchProcessi(JFrame framechiamante) 
	{
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Applicativo esercizi Sistemi Operativi I: Scheduling della CPU");

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
		
		JLabel labelTitolo = new JLabel("Scheduling della CPU");
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
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI ("https://youtu.be/0HjA3ZC_KmE?t=114"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
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
		
/*PRIMA PARTE GUI*/		
		
		/*buttonGenera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {*/
	    JPanel panel_6 = new JPanel();
        panel_6.setBounds(0, 153, 1114, 600);
        panelMainButton.add(panel_6);
        panel_6.setLayout(null);
        
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
        ChartPanel chartPanel1 = new ChartPanel((JFreeChart) null);
        chartPanel1.setBounds(0, 0, 548, 295);
        panel_6.add(chartPanel1);
        chartPanel1.setChart(chart1);
        chartPanel1.addChartMouseListener(new ChartMouseListener() {
        public void chartMouseClicked(ChartMouseEvent arg0) {
        }
        public void chartMouseMoved(ChartMouseEvent arg0) {
        }
        });
        chartPanel1.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel1.setBackground(Color.white);
        chartPanel1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Tempo di attesa medio:");
        lblNewLabel.setBounds(10, 10, 132, 13);
        chartPanel1.add(lblNewLabel);
        
        JLabel lblCambiDiContesto = new JLabel("Cambi di contesto: ");
        lblCambiDiContesto.setBounds(10, 27, 115, 13);
        chartPanel1.add(lblCambiDiContesto);
        
        textField = new JTextField();
        textField.setBounds(152, 10, 42, 13);
        chartPanel1.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(152, 27, 42, 13);
        chartPanel1.add(textField_1);
        
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
        ChartPanel chartPanel2 = new ChartPanel((JFreeChart) null);
        chartPanel2.setBounds(556, 0, 548, 295);
        panel_6.add(chartPanel2);
        chartPanel2.setChart(chart2);
        chartPanel2.addChartMouseListener(new ChartMouseListener() {
        public void chartMouseClicked(ChartMouseEvent arg0) {
        }
        public void chartMouseMoved(ChartMouseEvent arg0) {
        }
        });
        chartPanel2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel2.setBackground(Color.white);
        chartPanel2.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("Tempo di attesa medio:");
        lblNewLabel_3.setBounds(10, 10, 135, 13);
        chartPanel2.add(lblNewLabel_3);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(155, 7, 44, 13);
        chartPanel2.add(textField_2);
        
        JLabel lblCambiDiContesto_1 = new JLabel("Cambi di contesto: ");
        lblCambiDiContesto_1.setBounds(10, 27, 115, 13);
        chartPanel2.add(lblCambiDiContesto_1);
        
        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(155, 24, 44, 13);
        chartPanel2.add(textField_7);
        
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
        ChartPanel chartPanel3 = new ChartPanel((JFreeChart) null);
        chartPanel3.setBounds(0, 305, 548, 295);
        panel_6.add(chartPanel3);
        chartPanel3.setChart(chart3);
        chartPanel3.addChartMouseListener(new ChartMouseListener() {
        public void chartMouseClicked(ChartMouseEvent arg0) {
        }
        public void chartMouseMoved(ChartMouseEvent arg0) {
        }
        });
        chartPanel3.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel3.setBackground(Color.white);
        chartPanel3.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Tempo di attesa medio:");
        lblNewLabel_1.setBounds(10, 10, 132, 13);
        chartPanel3.add(lblNewLabel_1);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(152, 10, 41, 13);
        chartPanel3.add(textField_4);
        
        JLabel lblCambiDiContesto_3 = new JLabel("Cambi di contesto: ");
        lblCambiDiContesto_3.setBounds(10, 27, 115, 13);
        chartPanel3.add(lblCambiDiContesto_3);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(152, 27, 41, 13);
        chartPanel3.add(textField_5);
        
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
        ChartPanel chartPanel4 = new ChartPanel((JFreeChart) null);
        chartPanel4.setBounds(558, 305, 548, 295);
        panel_6.add(chartPanel4);
        chartPanel4.setChart(chart4);
        chartPanel4.addChartMouseListener(new ChartMouseListener() {
        public void chartMouseClicked(ChartMouseEvent arg0) {
        }
        public void chartMouseMoved(ChartMouseEvent arg0) {
        }
        });
        chartPanel4.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel4.setBackground(Color.white);
        chartPanel4.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Tempo di attesa medio:");
        lblNewLabel_2.setBounds(10, 10, 132, 13);
        chartPanel4.add(lblNewLabel_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(152, 10, 46, 13);
        chartPanel4.add(textField_3);
        
        JLabel lblCambiDiContesto_2 = new JLabel("Cambi di contesto: ");
        lblCambiDiContesto_2.setBounds(10, 27, 115, 13);
        chartPanel4.add(lblCambiDiContesto_2);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(152, 27, 46, 13);
        chartPanel4.add(textField_6);
        
        JLabel lblNewLabel_4 = new JLabel("Tempo per processo:");
        lblNewLabel_4.setBounds(372, 10, 125, 13);
        chartPanel4.add(lblNewLabel_4);
        
        JButton btnNewButton_3_2 = new JButton("0");
        btnNewButton_3_2.setBounds(420, 27, 57, 21);
        chartPanel4.add(btnNewButton_3_2);
                
        JButton btnNewButton_3 = new JButton("<");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnNewButton_3_2.setText(String.valueOf(i-1));
        		i=i-1;
        	}
        });
        btnNewButton_3.setBounds(371, 27, 46, 21);
        chartPanel4.add(btnNewButton_3);
        
        JButton btnNewButton_3_1 = new JButton(">");
        btnNewButton_3_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnNewButton_3_2.setText(String.valueOf(i+1));
        		i=i+1;
        	}
        });
        btnNewButton_3_1.setBounds(481, 27, 46, 21);
        chartPanel4.add(btnNewButton_3_1);
        
       
        
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
		panel_3.setBounds(10, 95, 245, 170);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblNumeroDiProcessi = new JLabel("Numero di processi");
		lblNumeroDiProcessi.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDiProcessi.setForeground(new Color(0, 0, 0));
		lblNumeroDiProcessi.setFont(new Font("Arial", Font.BOLD, 15));
		lblNumeroDiProcessi.setBounds(10, 2, 165, 23);
		panel_3.add(lblNumeroDiProcessi);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6"}));
		comboBox.setBounds(185, 2, 50, 21);
		panel_3.add(comboBox);
		
		JScrollPane scroll= new JScrollPane();
		scroll.setBounds(10, 27, 225, 136);
		panel_3.add(scroll);
		
		final JTable table = new JTable();
		table.setColumnSelectionAllowed(true);
		scroll.setViewportView(table);
		
		DefaultTableModel model1 = new DefaultTableModel()
		{
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0:
					return Integer.class;
				case 1:
					return Integer.class;
				case 2:
					return Integer.class;
				default:
					return Integer.class;
					
				}
			}
		};
		
		table.setModel(model1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 310, 245, 104);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBorder(BorderFactory.createLineBorder(Color.black));

		JCheckBox chckbxNewCheckBox = new JCheckBox("Griglia");
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(6, 6, 65, 21);
		panel_4.add(chckbxNewCheckBox);
		
		JButton btnPlay = new JButton("ESEGUI");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPlay.setBounds(60, 75, 126, 21);
		panel_4.add(btnPlay);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setBounds(6, 75, 51, 21);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.setBounds(189, 75, 51, 21);
		panel_4.add(btnNewButton_1);
		
		JCheckBox chckbxAttivaModifiche = new JCheckBox("Attiva modifiche");
		chckbxAttivaModifiche.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chckbxAttivaModifiche.setBounds(100, 6, 140, 21);
		panel_4.add(chckbxAttivaModifiche);
		
		JButton btnNewButton_2 = new JButton("Salva Modifiche");
		/*btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scelta= (String) comboBox.getSelectedItem();
				int r=Integer.valueOf(scelta);
				for(int i=0; i<r;i++) {
					int z=table.get;
				}
				
	    		if(z>=0) {    	
	    			model.setValueAt(textField.getText(), z, 7);
	    			model.setValueAt(textArea.getText(), z, 6);
	    		}
			}
		});
		*/
		btnNewButton_2.setBounds(100, 33, 125, 21);
		panel_4.add(btnNewButton_2);
		
		JLabel lblPlot = new JLabel("Plot");
		lblPlot.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlot.setForeground(Color.RED);
		lblPlot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlot.setBounds(0, 275, 265, 25);
		panel_1.add(lblPlot);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 468, 245, 170);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JTextArea txtrHelpArea = new JTextArea();
		txtrHelpArea.setBounds(0, 27, 245, 141);
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
		
		model1.addColumn("Processo");
		model1.addColumn("Arrivo");
		model1.addColumn("Durata");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);

		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				scelta= (String) comboBox.getSelectedItem();
			
		int r=Integer.valueOf(scelta);
		if(series0.getItemCount() !=0) series0.clear();
		if(series1.getItemCount() !=0)series1.clear();
		if(series2.getItemCount() !=0)series2.clear();
		if(series3.getItemCount() !=0)series3.clear();
		if(series4.getItemCount() !=0)series4.clear();
		if(series5.getItemCount() !=0)series5.clear();
		if (r!=0) 
		{			
			int rowCount = table.getRowCount();
			//Remove rows one by one from the end of the table
			for (int i = rowCount - 1; i >= 0; i--) {
			    model1.removeRow(i);
			}	
			for (int i=0;i<r;i++) 
			{ 
		
				Random random = new Random();
				int value = random.nextInt(30 + 0) + 0;
				model1.addRow(new Object[0]);
				model1.setValueAt("P"+(i+1),i,0);
				model1.setValueAt(value,i,1);
				int value2 = random.nextInt(30 + 0) + 0;
				model1.setValueAt(value2,i,2);	
				if(i==0) { series0.add(value,i+1); series0.add(value+value2,i+1);}
				else if(i==1) { series1.add(value,i+1); series1.add(value+value2,i+1);}
				else if(i==2) { series2.add(value,i+1); series2.add(value+value2,i+1);}
				else if(i==3) { series3.add(value,i+1); series3.add(value+value2,i+1);}
				else if(i==4) { series4.add(value,i+1); series4.add(value+value2,i+1);}
				else if(i==5) { series5.add(value,i+1); series5.add(value+value2,i+1);}

				//AGGIUNGI CHECKBOX
				//Aggiungi lista 
			}
		}
		
		 dataset1.removeAllSeries();
			
		 	if(series0.getItemCount() !=0) {
		 		dataset1.addSeries(series0);
		        arraySeries.add(series0);
		 	}
	        if(series1.getItemCount() !=0) {
	        	dataset1.addSeries(series1);
		        arraySeries.add(series1);
	        }
	        if(series2.getItemCount() !=0) {
	        	dataset1.addSeries(series2);
		        arraySeries.add(series2);
	        }
	        if(series3.getItemCount() !=0) {
	        	dataset1.addSeries(series3);
		        arraySeries.add(series3);
	        }
	        if(series4.getItemCount() !=0) {
	        	dataset1.addSeries(series4);
		        arraySeries.add(series4);
	        }
	        if(series5.getItemCount() !=0) {
	        	dataset1.addSeries(series5);
		        arraySeries.add(series5);
	        }
	        
		}
		});
				
	       
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

		chart1 = ChartFactory.createXYLineChart(
                "First-come, First-served",
                "",
                ""  ,
                dataset1,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
		chart2 = ChartFactory.createXYLineChart(
                "Shortest Job First",
                "",
                ""  ,
                dataset1,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
		chart3 = ChartFactory.createXYLineChart(
                "Shortest Job First Preemptive",
                "",
                ""  ,
                dataset1,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
		chart4 = ChartFactory.createXYLineChart(
                "Round Robin",
                "",
                ""  ,
                dataset1,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
       
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
        chart1.setTitle(new TextTitle("First-come, First-served",
        new Font("Serif", java.awt.Font.BOLD, 18)
        )
        );
        ChartPanel chartPanel1 = new ChartPanel((JFreeChart) null);
        chartPanel1.setBounds(0, 0, 548, 295);
        panel_6.add(chartPanel1);
        chartPanel1.setChart(chart1);
        chartPanel1.addChartMouseListener(new ChartMouseListener() {
        public void chartMouseClicked(ChartMouseEvent arg0) {
        }
        public void chartMouseMoved(ChartMouseEvent arg0) {
        }
        });
        chartPanel1.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel1.setBackground(Color.white);
     
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
        chart2.setTitle(new TextTitle("Shortest Job First",
        new Font("Serif", java.awt.Font.BOLD, 18)
        )
        );
        ChartPanel chartPanel2 = new ChartPanel((JFreeChart) null);
        chartPanel2.setBounds(556, 0, 548, 295);
        panel_6.add(chartPanel2);
        chartPanel2.setChart(chart2);
        chartPanel2.addChartMouseListener(new ChartMouseListener() {
        public void chartMouseClicked(ChartMouseEvent arg0) {
        }
        public void chartMouseMoved(ChartMouseEvent arg0) {
        }
        });
        chartPanel2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel2.setBackground(Color.white);

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
        chart3.setTitle(new TextTitle("Shortest Job First Preemptive",
        new Font("Serif", java.awt.Font.BOLD, 18)
        )
        );
        ChartPanel chartPanel3 = new ChartPanel((JFreeChart) null);
        chartPanel3.setBounds(0, 305, 548, 295);
        panel_6.add(chartPanel3);
        chartPanel3.setChart(chart3);
        chartPanel3.addChartMouseListener(new ChartMouseListener() {
        public void chartMouseClicked(ChartMouseEvent arg0) {
        }
        public void chartMouseMoved(ChartMouseEvent arg0) {
        }
        });
        chartPanel3.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel3.setBackground(Color.white);
        
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
        chart4.setTitle(new TextTitle("Round Robin",
        new Font("Serif", java.awt.Font.BOLD, 18)
        )
        );
        ChartPanel chartPanel4 = new ChartPanel((JFreeChart) null);
        chartPanel4.setBounds(558, 305, 548, 295);
        panel_6.add(chartPanel4);
        chartPanel4.setChart(chart4);
        chartPanel4.addChartMouseListener(new ChartMouseListener() {
        public void chartMouseClicked(ChartMouseEvent arg0) {
        }
        public void chartMouseMoved(ChartMouseEvent arg0) {
        }
        });
        chartPanel4.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel4.setBackground(Color.white);
        
        rangeAxis.setTickUnit(new NumberTickUnit(1));
        rangeAxis.setRange(0,grade.length);
        plot4.setRangeAxis(rangeAxis);
        
                      	
			}
		});        
		/*-----------------------------------------------------*/
       
/*
			/*}
		});*/
	}
	
	XYSeriesCollection FCFS(ArrayList<XYSeries> serie) {
		
		
		int n = serie.size();
		int pid[] = new int[n];   // process ids
		int ar[] = new int[n];     // arrival times
		int bt[] = new int[n];     // burst or execution times
		int ct[] = new int[n];     // completion times
		int ta[] = new int[n];     // turn around times
		int wt[] = new int[n];     // waiting times
		int temp;
		float avgwt=0,avgta=0;
		
		XYSeries series;
		int arrivo,durata;
		
		for(int i = 0; i < n; i++)
		{
		//System.out.println("enter process " + (i+1) + " arrival time: ");
		series=serie.get(i);
		arrivo=(int) series.getX(0);
		durata=(int) series.getX(1);
		ar[i] = arrivo;
		//System.out.println("enter process " + (i+1) + " brust time: ");
		bt[i] = durata;
		pid[i] = i+1;
		}
		 
		//sorting according to arrival times
		for(int i = 0 ; i <n; i++)
		{
		for(int  j=0;  j < n-(i+1) ; j++)
		{
		if( ar[j] > ar[j+1] )
		{
		temp = ar[j];
		ar[j] = ar[j+1];
		ar[j+1] = temp;
		temp = bt[j];
		bt[j] = bt[j+1];
		bt[j+1] = temp;
		temp = pid[j];
		pid[j] = pid[j+1];
		pid[j+1] = temp;
		}
		}
		}
		// finding completion times
		for(int  i = 0 ; i < n; i++)
		{
		if( i == 0)
		{
		ct[i] = ar[i] + bt[i];
		}
		else
		{
		if( ar[i] > ct[i-1])
		{
		ct[i] = ar[i] + bt[i];
		}
		else
		ct[i] = ct[i-1] + bt[i];
		}
		ta[i] = ct[i] - ar[i] ;          // turnaround time= completion time- arrival time
		wt[i] = ta[i] - bt[i] ;          // waiting time= turnaround time- burst time
		avgwt += wt[i] ;               // total waiting time
		avgta += ta[i] ;               // total turnaround time
		}
		//System.out.println("\npid  arrival  brust  complete turn waiting");
		for(int  i = 0 ; i< n;  i++)
		{
		System.out.println(pid[i] + "  \t " + ar[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t"  + wt[i] ) ;
		}
		//sc.close();
		System.out.println("\naverage waiting time: "+ (avgwt/n));     // printing average waiting time.
		System.out.println("average turnaround time:"+(avgta/n));    // printing average turnaround time.
		return dataset ;
		}
		
		
		
}
