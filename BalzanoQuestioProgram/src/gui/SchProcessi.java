package gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
		panel.setBounds(0, 0, 1416, 89);
		panelMainButton.add(panel);
		panel.setLayout(null);
		
		JLabel labelTitolo = new JLabel("Scheduling della CPU");
		labelTitolo.setForeground(new Color(0, 0, 0));
		labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitolo.setFont(new Font("Times New Roman", Font.BOLD, 50));
		labelTitolo.setBounds(0, 10, 1416, 63);
		panel.add(labelTitolo);
		
		JTextArea txtrUniversitDegliStudi = new JTextArea();
		txtrUniversitDegliStudi.setBounds(1151, 0, 265, 89);
		panel.add(txtrUniversitDegliStudi);
		txtrUniversitDegliStudi.setBackground(new Color(0, 204, 255));
		txtrUniversitDegliStudi.setText("UNIversit\u00E0 degli studi di NApoli\r\nAnno Accademico: 2021/2022\r\nProfessore: Walter Balzano\r\nProgettisti: Lanuto, Prosciutto, Scotto\r\n");
		txtrUniversitDegliStudi.setLineWrap(true);
		txtrUniversitDegliStudi.setFont(new Font("Cambria", Font.PLAIN, 14));
		txtrUniversitDegliStudi.setEditable(false);
		
		JButton buttonGenera = new JButton("Genera Esercizio");
		buttonGenera.setFont(new Font("Arial", Font.BOLD, 15));
		buttonGenera.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonGenera.setBackground(new Color(51, 204, 0));
		buttonGenera.setBounds(10, 95, 157, 48);
		panelMainButton.add(buttonGenera);
		
		JButton btnSlideArgomento = new JButton("Slide Argomento");
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
		btnNewButton_2.setBounds(110, 33, 125, 21);
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
				if(i==0) { series0.add(value,"P"+(i+1)); series0.add(value+value2,"P"+(i+1));}
				else if(i==1) { series1.add(value,"P"+(i+1)); series1.add(value+value2,"P"+(i+1));}
				else if(i==2) { series2.add(value,"P"+(i+1)); series2.add(value+value2,"P"+(i+1));}
				else if(i==3) { series3.add(value,"P"+(i+1)); series3.add(value+value2,"P"+(i+1));}
				else if(i==4) { series4.add(value,"P"+(i+1)); series4.add(value+value2,"P"+(i+1));}
				else if(i==5) { series5.add(value,"P"+(i+1)); series5.add(value+value2,"P"+(i+1));}

				//AGGIUNGI CHECKBOX
				//Aggiungi lista 
			}
		}
		
		 dataset1.removeAllSeries();
			
		if(series0.getItemCount() !=0) dataset1.addSeries(series0);
	        if(series1.getItemCount() !=0) dataset1.addSeries(series1);
	        if(series2.getItemCount() !=0) dataset1.addSeries(series2);
	        if(series3.getItemCount() !=0) dataset1.addSeries(series3);
	        if(series4.getItemCount() !=0) dataset1.addSeries(series4);
	        if(series5.getItemCount() !=0) dataset1.addSeries(series5);
		}
		});
				
	       
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

		chart1 = ChartFactory.createXYLineChart(
                "Average salary per age",
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
        chart1.setTitle(new TextTitle("Average Salary per Age",
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
        chart2.setTitle(new TextTitle("Average Salary per Age",
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
        chart3.setTitle(new TextTitle("Average Salary per Age",
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
        chart4.setTitle(new TextTitle("Average Salary per Age",
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
        
                      	
			}
		});        
		/*-----------------------------------------------------*/
       
/*
			/*}
		});*/
	}
}
