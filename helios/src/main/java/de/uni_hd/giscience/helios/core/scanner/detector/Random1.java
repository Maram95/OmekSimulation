package de.uni_hd.giscience.helios.core.scanner.detector;


import java.io.File;
//import java.io.File;
import java.util.Random;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import de.uni_hd.giscience.helios.core.Asset;
public class Random1 {
	/*
	Element legNode;
	Element platformSettingsNode = (Element) legNode.getElementsByTagName("platformSettings").item(0);
	Asset result = null;
	result= createPlatformSettingsFromXml(platformSettingsNode);
	
	//Document doc = dBuilder.parse(fXmlFile);
*/
	
	

	int CC ;
	int seed0 = 2;
	Random r1;
	long seed ;
	double r;
	Random r2;
	
	//constructor 
	// here we read the error reference from the .xml file .
	
	public Random1() {
		String er="" ;
		try{
			
		
		File file = new File("data/surveys/demo/mainxml.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
		        .newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);
		
		er = document.getElementsByTagName("Error").item(0).getTextContent();
		System.out.println(er);
		}
		
		 catch (Exception e){
		        System.out.println("Error reading configuration file:");
		        System.out.println(e.getMessage());
		    }
		
		//System.out.println(er);
		er = er.replaceAll("\\s+","");
		try{
			CC = Integer.parseInt(er);
			}
		catch(NumberFormatException ex){ // handle your exception
			System.out.println("Error");
			}
		//CC = Integer.parseInt(er);
		
		//System.out.println("cc"+CC);
		seed0 = 2;
		r1 = new Random(CC);
		seed =  r1.nextLong();
		r=0;
		r2=null;
	}
	
	

		public  double rand(){
	
	for(int i=0;i<seed0;i++) {
		seed =  r1.nextLong();
	}
	 r2 = new Random(seed);
	//double s0=0, s1=0, size =10;
	
	
		r = r2.nextDouble();
	
	return r;
	
}

		public static void main(String[] a) {
		/*final int CC = 33331;
		int seed0 = 2;
		
		Random r1 = new Random(CC);
		long seed =  r1.nextLong();
		for(int i=0;i<seed0;i++) {
			seed =  r1.nextLong();
		}
		Random r2 = new Random(seed);
		double s0=0, s1=0, size =10;
		for(int i=0;i<size;i++) {
			double r = r2.nextDouble();
		//	double r  =r1.nextGaussian()*10;
		//	s0 += r;
		//	s1 += Math.abs(r);
			System.out.println(i+") "+r);
		}*/
		//System.out.println("Ave: "+s1/size);
		//System.out.println("Ave: "+s0/size);
		 
		
		Random1 a1= new Random1();
		
		for(int i=0;i<10;i++) {
		double r4=a1.rand();
		System.out.println(i+"-----) "+r4);
		}
	}
}