package de.uni_hd.giscience.helios;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.net.URI;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import java.awt.Choice;
import java.awt.BorderLayout;
import java.awt.Canvas;
import javax.swing.UIManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;

public class main {

	private JFrame frmOmeksimulator;
	// private JTextField textField;
	String S = "";
	private JTextField textField_1;
	private JTextField Error;
	private JTextField path2;
	private JTextField pulse1;
	private JTextField scan1;
	// private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frmOmeksimulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	public void helios1(JLabel word) {
		word.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				try {
					Desktop.getDesktop().browse(new URI(
							"http://www.github.com/GIScience/helios/wiki/Howto:-Build-HELIOS-with-Eclipse-and-Maven"));
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
	}

	public void web1(JLabel word) {
		word.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				try {
					Desktop.getDesktop().browse(new URI("https://osimulatorcs.wixsite.com/osimulator"));
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOmeksimulator = new JFrame();
		frmOmeksimulator.setTitle("Omek-Simulator");
		frmOmeksimulator.setBounds(100, 100, 817, 661);
		frmOmeksimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOmeksimulator.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Omek Simulator ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(28, 20, 151, 29);
		frmOmeksimulator.getContentPane().add(lblNewLabel);
		// Image img =new
		// ImageIcon(this.getClass().getResource("/platforms.png")).getImage();

		JRadioButton ownpath = new JRadioButton("If you already have  xml file,\nput the path here and run it : ");
		ownpath.setBounds(6, 436, 419, 23);
		frmOmeksimulator.getContentPane().add(ownpath);

		JLabel lblNewLabel_2 = new JLabel("");
		// Image img2 =new
		// ImageIcon(this.getClass().getResource("/platforms.png")).getImage();
		// lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(461, 58, 141, 113);
		frmOmeksimulator.getContentPane().add(lblNewLabel_2);
		/*
		 * ButtonGroup bg=new ButtonGroup(); bg.add(b1); bg.add(b2);
		 */

		JLabel lblPlatform = new JLabel("Platform:");
		lblPlatform.setForeground(Color.BLACK);
		lblPlatform.setBounds(29, 103, 61, 16);
		frmOmeksimulator.getContentPane().add(lblPlatform);

		JRadioButton quadcopterbutton = new JRadioButton("Quadcopter");
		quadcopterbutton.setBounds(231, 137, 112, 23);
		frmOmeksimulator.getContentPane().add(quadcopterbutton);

		JRadioButton Tractorbutton = new JRadioButton("Tractor");
		Tractorbutton.setBounds(128, 137, 91, 23);
		frmOmeksimulator.getContentPane().add(Tractorbutton);

		JRadioButton Tripodbutton = new JRadioButton("Tripod");
		Tripodbutton.setBounds(29, 137, 73, 23);
		frmOmeksimulator.getContentPane().add(Tripodbutton);

		JRadioButton Aircraftbutton = new JRadioButton("Aircraft");
		Aircraftbutton.setBounds(378, 137, 85, 23);
		frmOmeksimulator.getContentPane().add(Aircraftbutton);
		ButtonGroup bg = new ButtonGroup();
		bg.add(quadcopterbutton);
		bg.add(Tractorbutton);
		bg.add(Tripodbutton);
		bg.add(Aircraftbutton);

		JLabel lblFrequency = new JLabel("Scan Freq:");
		lblFrequency.setForeground(Color.BLACK);
		lblFrequency.setBounds(39, 181, 91, 16);
		frmOmeksimulator.getContentPane().add(lblFrequency);

		// JRadioButton rdbtn10 = new JRadioButton("10HZ");
		// rdbtn10.setBounds(38, 153, 78, 23);
		// frmOmeksimulator.getContentPane().add(rdbtn10);

		// JRadioButton rdbtn100 = new JRadioButton("100HZ");
		// rdbtn100.setBounds(128, 153, 85, 23);
		// frmOmeksimulator.getContentPane().add(rdbtn100);

		// JRadioButton rdbtn1000 = new JRadioButton("1000HZ");
		// rdbtn1000.setBounds(225, 153, 141, 23);
		// frmOmeksimulator.getContentPane().add(rdbtn1000);
		// ButtonGroup bg2=new ButtonGroup();
		// bg2.add(rdbtn10);
		// bg2.add(rdbtn100);
		// bg2.add(rdbtn1000);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(119, 176, 100, 26);
		frmOmeksimulator.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		// ***** Path ****//
		JRadioButton Direct = new JRadioButton("Direct Path ( Segment)");
		Direct.setBounds(28, 294, 182, 23);
		frmOmeksimulator.getContentPane().add(Direct);

		JRadioButton Indirect = new JRadioButton("Indirect path ( L path)");
		Indirect.setBounds(200, 294, 169, 23);
		frmOmeksimulator.getContentPane().add(Indirect);
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(Indirect);
		bg2.add(Direct);

		JRadioButton simple = new JRadioButton("Simple Scene");
		simple.setBounds(21, 345, 141, 23);
		frmOmeksimulator.getContentPane().add(simple);

		JRadioButton comp = new JRadioButton("Complicated Scene ");
		comp.setBounds(174, 345, 169, 23);
		frmOmeksimulator.getContentPane().add(comp);

		ButtonGroup bg3 = new ButtonGroup();
		bg3.add(simple);
		bg3.add(comp);

		JButton btnNewButton = new JButton("Run!");
		btnNewButton.addActionListener(new ActionListener() {

			// *************Running the prog ***********************

			public void actionPerformed(ActionEvent e) {

				String s = textField_1.getText();
				String er = Error.getText();
				String path = path2.getText();
				String pu = pulse1.getText();
				String an = scan1.getText();

				// System.out.println("textField="+s);
				LidarSim a = new LidarSim();
				WindowEvent closingEvent = new WindowEvent(frmOmeksimulator, WindowEvent.WINDOW_CLOSING);
				Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
				frmOmeksimulator.setVisible(false);
				// frmOmeksimulator.dispose();
				// System.exit(0);

				if (quadcopterbutton.isSelected() && Direct.isSelected() && simple.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#quadcopter\" scanner=\"data/scanners_als.xml#riegl_vux-1uav\" scene=\"data/scenes/demo/SimpleScene.xml#arbaro_demo\">"
							+ "\n<Error>" + er + "</Error>" + "\n<leg>"
							+ "\n<platformSettings  x=\"19.458\" y=\"0.00\" z=\"60.000\" onGround=\"false\"/>"
							+ "\n<scannerSettings  active=\"true\" pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\"  headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n</leg>" + "\n<leg>"
							+ "\n<platformSettings  x=\"-19.458\" y=\"0.00\" z=\"60.000\" onGround=\"false\"/>"
							+ "\n<scannerSettings  active=\"true\" pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n</survey>" + "\n</document>";
					// java.io.FileWriter fw;
					/*
					 * try { fw = new java.io.FileWriter("data/surveys/demo/quad10.xml");
					 * fw.write(xml_file);
					 * 
					 * //fw.close(); } catch (IOException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */

					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					// System.out.println(arr.length);
					a.init(arr);

					// String s="data/surveys/demo/quad10.xml";

					// frmOmeksimulator.dispose();
					// frmOmeksimulator.getDefaultCloseOperation();
					// System.exit(0);
					// frmOmeksimulator.setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
				if (quadcopterbutton.isSelected() && Direct.isSelected() && comp.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\"?> "

							+ "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#quadcopter\" scanner=\"data/scanners_als.xml#riegl_vux-1uav\" scene=\"data/scenes/demo/arbaro_demo.xml#arbaro_demo\">"
							+ "\n<Error>" + er + "</Error>" + "\n<leg>"
							+ "\n<platformSettings  x=\"5.458\" y=\"-4.300\" z=\"60.000\" onGround=\"false\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\"  headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n<leg>"
							+ "\n<platformSettings  x=\"-6.458\" y=\"4.340\" z=\"60.000\" onGround=\"false\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n</survey>" + "\n</document>";
					// java.io.FileWriter fw;
					/*
					 * try { fw = new java.io.FileWriter("data/surveys/demo/quad10.xml");
					 * fw.write(xml_file);
					 * 
					 * //fw.close(); } catch (IOException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */

					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);

					// String s="data/surveys/demo/quad10.xml";

					// frmOmeksimulator.dispose();
					// frmOmeksimulator.getDefaultCloseOperation();
					// System.exit(0);
					// frmOmeksimulator.setDefaultCloseOperation(EXIT_ON_CLOSE);
				}

				if (quadcopterbutton.isSelected() && Indirect.isSelected() && simple.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\" ?> "

							+ "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#quadcopter\" scanner=\"data/scanners_als.xml#riegl_vux-1uav\" scene=\"data/scenes/demo/SimpleScene.xml#arbaro_demo\">"
							+ "\n<leg>"
							+ "<platformSettings  x=\"-3.822\" y=\"12.071\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\" pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"-2.975\" y=\"4.710\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\" pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"1.512\" y=\"11.269\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"1.512\" y=\"11.269\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "\n</survey>" + "\n</document>";

					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}

				if (quadcopterbutton.isSelected() && Indirect.isSelected() && comp.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\" ?> "

							+ "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#quadcopter\" scanner=\"data/scanners_als.xml#riegl_vux-1uav\" scene=\"data/scenes/demo/arbaro_demo.xml#arbaro_demo\">"
							+ "\n<leg>"
							+ "<platformSettings  x=\"-3.822\" y=\"12.071\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"-2.975\" y=\"4.710\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"1.512\" y=\"11.269\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"1.512\" y=\"11.269\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "\n</survey>" + "\n</document>";

					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}

				if (Tractorbutton.isSelected() && Direct.isSelected() && simple.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\" ?> "

							+ "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#tractor\" scanner=\"data/scanners_tls.xml#tractorscanner\" scene=\"data/scenes/demo/SimpleScene.xml#arbaro_demo\">"
							+ "\n<leg>" + "\n<platformSettings  x=\"9.552\" y=\"2.149\" \" z=\"0\" onGround=\"true\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\"  headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n<leg>"
							+ "\n<platformSettings  x=\"8.944\" y=\"12.211\" z=\"0\" onGround=\"true\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n</survey>" + "\n</document>";
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}

				if (Tractorbutton.isSelected() && Indirect.isSelected() && simple.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\" ?> "

							+ "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#tractor\" scanner=\"data/scanners_tls.xml#tractorscanner\" scene=\"data/scenes/demo/SimpleScene.xml#arbaro_demo\">"
							+ "\n<leg>" + "\n<platformSettings  x=\"14.327\" y=\"8.414\"  z=\"0\" onGround=\"true\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\"  headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n<leg>"
							+ "\n<platformSettings  x=\"1.296\" y=\"17.835\" z=\"0\" onGround=\"true\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n<leg>"
							+ "\n<platformSettings  x=\"-14.364\" y=\"12.606\" z=\"0\" onGround=\"true\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n</survey>" + "\n</document>";
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}

				if (Tractorbutton.isSelected() && Direct.isSelected() && comp.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\" ?> "

							+ "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#tractor\" scanner=\"data/scanners_tls.xml#tractorscanner\" scene=\"data/scenes/demo/arbaro_demo.xml#arbaro_demo\">"
							+ "\n<leg>" + "\n<platformSettings  x=\"1.660\" y=\"-26.364\" z=\"0\" onGround=\"true\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\"  headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"-16.05\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n<leg>"
							+ "\n<platformSettings  x=\"6.376\" y=\"-19.142\" z=\"0\" onGround=\"true\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"-16.05\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n</survey>" + "\n</document>";
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}

				if (Tractorbutton.isSelected() && Indirect.isSelected() && comp.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\" ?> "

							+ "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#tractor\" scanner=\"data/scanners_tls.xml#tractorscanner\" scene=\"data/scenes/demo/arbaro_demo.xml#arbaro_demo\">"
							+ "\n<leg>" + "\n<platformSettings  x=\"1.660\" y=\"-26.364\" z=\"0\" onGround=\"true\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\"  headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"-16.05\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n<leg>"
							+ "\n<platformSettings  x=\"6.376\" y=\"-19.142\" z=\"0\" onGround=\"true\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"-16.05\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>"
							+ "\n<platformSettings  x=\"19.414\" y=\"-26.484\" z=\"0\" onGround=\"true\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"-16.05\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n</survey>" + "\n</document>";
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}
				if (Tripodbutton.isSelected() && comp.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\"?> " + "\n<document>"
							+ " \n<survey name=\"Arbaro Demo\" platform=\"data/platforms.xml#tripod\" scanner=\"data/scanners_tls.xml#riegl_vz400\" scene=\"data/scenes/demo/arbaro_demo.xml#arbaro_demo\">"
							+ "\n<leg>"
							+ "\n<platformSettings x=\"10.638\" y=\"-39.072\"  z=\"0.00\" onGround=\"true\"/>"
							+ "\n<scannerSettings id=\"profile1\" active=\"true\"  pulseFreq_hz=\"" + pu
							+ "\" scanAngle_deg=\"" + an + "\" scanFreq_hz=\"" + s
							+ "\"  headRotatePerSec_deg=\"10.0\" headRotateStart_deg=\"128.91550582542592\" headRotateStop_deg=\"223.45354343073828\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n</survey>" + "\n</document>";
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}
				if (Tripodbutton.isSelected() && simple.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\"?> " + "\n<document>"
							+ " \n<survey name=\"Arbaro Demo\" platform=\"data/platforms.xml#tripod\" scanner=\"data/scanners_tls.xml#riegl_vz400\" scene=\"data/scenes/demo/SimpleScene.xml#arbaro_demo\">"
							+ "\n<leg>" + "\n<platformSettings  x=\"17.458\" y=\"0.300\" z=\"0.00\" onGround=\"true\"/>"
							+ "\n<scannerSettings id=\"profile1\" active=\"true\"  pulseFreq_hz=\"" + pu
							+ "\" scanAngle_deg=\"" + an + "\" scanFreq_hz=\"" + s
							+ "\"  headRotatePerSec_deg=\"10.0\" headRotateStart_deg=\"128.91550582542592\" headRotateStop_deg=\"223.45354343073828\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n</survey>" + "\n</document>";
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}
				if (Aircraftbutton.isSelected() && Direct.isSelected() && comp.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\" ?> "

							+ "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#sr22\" scanner=\"data/scanners_als.xml#copterscanner\" scene=\"data/scenes/demo/arbaro_demo.xml#arbaro_demo\">"
							+ "\n<leg>"
							+ "\n<platformSettings  x=\"17.458\" y=\"-5.300\" z=\"60.000\" onGround=\"false\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\"  headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n<leg>"
							+ "\n<platformSettings  x=\"10.458\" y=\"5.300\" z=\"60.000\" onGround=\"false\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n</survey>" + "\n</document>";
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}

				if (Aircraftbutton.isSelected() && Direct.isSelected() && simple.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\" ?> "

							+ "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#sr22\" scanner=\"data/scanners_als.xml#copterscanner\" scene=\"data/scenes/demo/SimpleScene.xml#arbaro_demo\">"
							+ "\n<leg>"
							+ "\n<platformSettings  x=\"19.458\" y=\"0.00\" z=\"60.000\" onGround=\"false\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\"  headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n<leg>"
							+ "\n<platformSettings  x=\"-19.458\" y=\"0.00\" z=\"60.000\" onGround=\"false\"/>"
							+ "\n<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "\n</leg>" + "\n</survey>" + "\n</document>";
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}

				if (Aircraftbutton.isSelected() && Indirect.isSelected() && comp.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\"?> "

							+ "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#sr22\" scanner=\"data/scanners_als.xml#riegl_vux-1uav\" scene=\"data/scenes/demo/arbaro_demo.xml#arbaro_demo\">"
							+ "\n<leg>"
							+ "<platformSettings  x=\"-3.822\" y=\"12.071\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"-2.975\" y=\"4.710\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"1.512\" y=\"11.269\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"1.512\" y=\"11.269\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "\n</survey>" + "\n</document>";
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}

				if (Aircraftbutton.isSelected() && Indirect.isSelected() && simple.isSelected()) {
					String[] arr = new String[1];
					String xml_file = "<?xml version=\"1.0\" ?> "

							+ "\n<document>"
							+ " \n<survey name=\"TLS Arbaro\" platform=\"data/platforms.xml#sr22\" scanner=\"data/scanners_als.xml#riegl_vux-1uav\" scene=\"data/scenes/demo/SimpleScene.xml#arbaro_demo\">"
							+ "\n<leg>"
							+ "<platformSettings  x=\"-3.822\" y=\"12.071\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"-2.975\" y=\"4.710\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"1.512\" y=\"11.269\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "<leg>"
							+ "<platformSettings  x=\"1.512\" y=\"11.269\" z=\"30.000\" onGround=\"false\"/>"
							+ "<scannerSettings  active=\"true\"  pulseFreq_hz=\"" + pu + "\" scanAngle_deg=\"" + an
							+ "\" scanFreq_hz=\"" + s
							+ "\" headRotatePerSec_deg=\"0.00\" headRotateStart_deg=\"0.00\" headRotateStop_deg=\"0.00\"/>"
							+ "\n<Error>" + er + "</Error>" + "</leg>" + "\n</survey>" + "\n</document>";
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;

					Document doc;
					try {
						builder = factory.newDocumentBuilder();
						doc = builder.parse(new InputSource(new StringReader(xml_file)));
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						transformer = transformerFactory.newTransformer();
						StreamResult result = new StreamResult(new File("data/surveys/demo/mainxml.xml"));
						DOMSource source = new DOMSource(doc);
						transformer.transform(source, result);
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Write the parsed document to an xml file

					arr[0] = "data/surveys/demo/mainxml.xml";
					System.out.println(arr.length);
					a.init(arr);
				}
				if (ownpath.isSelected()) {
					String[] arr = new String[1];
					arr[0] = path;
					// System.out.println(arr.length);
					a.init(arr);

				}
			}

		});

		btnNewButton.setBounds(582, 560, 117, 29);
		frmOmeksimulator.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel(
				"All you have to do is , to choose one of the platforms and then write a frequency you want . ");
		lblNewLabel_1.setForeground(new Color(65, 105, 225));
		lblNewLabel_1.setBounds(28, 75, 606, 16);
		frmOmeksimulator.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("The Created file will be saved as :\n ");
		lblNewLabel_3.setForeground(new Color(0, 0, 139));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(102, 94, 169, 36);
		frmOmeksimulator.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\"data/surveys/demo/mainxml.xml\"");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setBounds(94, 118, 208, 16);
		frmOmeksimulator.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("For the moving Platforms choose a path :");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(28, 269, 325, 29);
		frmOmeksimulator.getContentPane().add(lblNewLabel_5);

		JLabel lblScene = new JLabel("Scene :");
		lblScene.setBounds(39, 327, 61, 16);
		frmOmeksimulator.getContentPane().add(lblScene);

		JLabel lblError = new JLabel("Error:");
		lblError.setBounds(29, 380, 61, 16);
		frmOmeksimulator.getContentPane().add(lblError);

		Error = new JTextField();
		Error.setBounds(67, 380, 130, 26);
		frmOmeksimulator.getContentPane().add(Error);
		Error.setColumns(10);

		path2 = new JTextField();
		path2.setBounds(10, 471, 453, 26);
		frmOmeksimulator.getContentPane().add(path2);
		path2.setColumns(10);

		JLabel helios = new JLabel();
		helios.setText("<html> <a href=\"\">Helios</a></html>");
		helios.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helios.setBounds(36, 509, 54, 16);
		frmOmeksimulator.getContentPane().add(helios);
		String str = "<a href=\"/www.github.com/GIScience/helios/wiki/Howto:-Build-HELIOS-with-Eclipse-and-Maven\" /a>";
		helios1(helios);
		JLabel lblIfYouAlready = new JLabel("Expert Mode :");
		lblIfYouAlready.setBounds(30, 408, 443, 16);
		frmOmeksimulator.getContentPane().add(lblIfYouAlready);

		JLabel img;
		ImageIcon im2, im;

		// JLabel img;
		im = new ImageIcon(getClass().getResource("/q.png"));
		img = new JLabel(im);
		// img.setIcon(new ImageIcon("/extra/qu.png"));
		// img.setBounds(457, 292, 177, 152);
		img.setBounds(532, 137, 228, 231);
		// contentPane.add(img);
		frmOmeksimulator.getContentPane().add(img);

		JLabel lblNewLabel_6 = new JLabel("KCG Ariel ");
		lblNewLabel_6.setBounds(28, 526, 74, 16);
		frmOmeksimulator.getContentPane().add(lblNewLabel_6);

		JLabel lblVersion = new JLabel("version 0.1");
		lblVersion.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblVersion.setBackground(Color.WHITE);
		lblVersion.setBounds(6, 617, 102, 16);
		frmOmeksimulator.getContentPane().add(lblVersion);

		JLabel lblForMoreInformation = new JLabel("For more Information and xml files , you can visit Our ");
		lblForMoreInformation.setBounds(28, 542, 343, 16);
		frmOmeksimulator.getContentPane().add(lblForMoreInformation);

		JLabel web = new JLabel("website.");
		web.setText("<html> <a href=\"\">website</a></html>");
		web.setCursor(new Cursor(Cursor.HAND_CURSOR));
		web.setBounds(374, 542, 61, 16);
		frmOmeksimulator.getContentPane().add(web);
		web1(web);

		im2 = new ImageIcon(getClass().getResource("/qr.png"));
		JLabel img2 = new JLabel(im2);
		// img2.setIcon(new ImageIcon("/Picture1.png"));
		img2.setBounds(129, 560, 112, 80);
		frmOmeksimulator.getContentPane().add(img2);

		JLabel pulse = new JLabel("Pulse Freq");
		pulse.setBounds(41, 209, 74, 16);
		frmOmeksimulator.getContentPane().add(pulse);

		pulse1 = new JTextField();
		pulse1.setBounds(119, 204, 100, 26);
		frmOmeksimulator.getContentPane().add(pulse1);
		pulse1.setColumns(10);

		JLabel scan = new JLabel("Scan Angle :");
		scan.setBounds(41, 241, 89, 16);
		frmOmeksimulator.getContentPane().add(scan);

		scan1 = new JTextField();
		scan1.setBounds(141, 236, 100, 26);
		frmOmeksimulator.getContentPane().add(scan1);
		scan1.setColumns(10);

	}
}
