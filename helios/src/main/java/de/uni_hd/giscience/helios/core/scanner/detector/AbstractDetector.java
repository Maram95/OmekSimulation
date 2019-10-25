package de.uni_hd.giscience.helios.core.scanner.detector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ExecutorService;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.w3c.dom.Document;

import de.uni_hd.giscience.helios.core.MeasurementsBuffer;
import de.uni_hd.giscience.helios.core.scanner.Measurement;
import de.uni_hd.giscience.helios.core.scanner.Velodyne;
import de.uni_hd.giscience.helios.core.scanner.ScannerSettings;

public abstract class AbstractDetector {

	Velodyne scanner = null;

	public double cfg_device_accuracy_m = 0;
	public double cfg_device_rangeMin_m = 0;
	public int cfg_setting_beamSampleQuality = 1;
	public double error=0;
	public Random rand;
	// File output:
	String outputFileLineFormatString = "%.3f %.3f %.3f %.4f \"%s\"";
	String outputFileLineFormatString2 = "%.3f %.3f %.3f";
	String outputFileLineFormatString3 = "%.3f %.3f %.3f";
	BufferedWriter mPointsFileWriter = null;
	BufferedWriter mPointsFileWriter2 = null;
	BufferedWriter mPointsFileWriter3 = null;
	
	String outputFilePath;

	public MeasurementsBuffer mBuffer;

	public AbstractDetector(Velodyne scanner, double accuracy_m, double rangeMin_m) {

		this.cfg_device_accuracy_m = accuracy_m;
		this.cfg_device_rangeMin_m = rangeMin_m;
		 rand = new Random(31);

		this.scanner = scanner;  
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
			error = Double.parseDouble(er);
			}
		catch(NumberFormatException ex){ // handle your exception
			System.out.println("Error");
		}
		
	}

	public void applySettings(ScannerSettings settings) {
	}
	/*public int Error(){
		//############read from xml file the Error reference ######### 
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
			error = Integer.parseInt(er);
			}
		catch(NumberFormatException ex){ // handle your exception
			System.out.println("Error");
			}
		return error;
	}
*/
	// ATTENTION: This method needs to be synchronized since multiple threads are writing to the output file!
	public synchronized void setOutputFilePath(String path) {

		// ATTENTION: There's a chance that closing the pointsFileWriter triggers an exception since other
		// threads might still write to it.
		String string = path;
		String[] parts = string.split("/");
		String path2 ="";
		String path3 ="";
		for(int i=0;i<parts.length-1;i++){
			path2=path2+parts[i]+"/";	
			path3=path3+parts[i]+"/";	
		}
		path2=path2+"data-with-errors.xyz";
		path3=path3+"Platform-path.xyz";
		//System.out.println("path2:"+path2);
	File outputFilePath = new File(path);
	
	//String desktop = System.getProperty("user.home");
	//System.out.println(desktop+"!!!!!!!!");
	//String path3=userHomeFolder+"extra.xyz";
	File outputFilePath2 = new File(path2);
	File outputFilePath3 = new File(path3);
	
		if (mPointsFileWriter != null) {
			try {
				mPointsFileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (mPointsFileWriter2 != null) {
			try {
				mPointsFileWriter2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (mPointsFileWriter3 != null) {
			try {
				mPointsFileWriter3.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (path.equals("")) {
			mPointsFileWriter = null;
			return;
		}
try {

			outputFilePath.getParentFile().mkdirs();

			mPointsFileWriter = new BufferedWriter(new FileWriter(outputFilePath, true), 500000);
			//System.out.println(path);
			mPointsFileWriter2 = new BufferedWriter(new FileWriter(outputFilePath2, true), 500000);
			mPointsFileWriter3 = new BufferedWriter(new FileWriter(outputFilePath3, true), 500000);
			
		} catch (Exception e) {
			mPointsFileWriter = null;
			mPointsFileWriter2 = null;
			mPointsFileWriter3 = null;


			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public abstract void simulatePulse(ExecutorService execService, Vector3D absoluteBeamOrigin, Rotation absoluteBeamAttitude, int state_currentPulseNumber, long currentGpsTime);

	synchronized public void shutdown() {

		if (mPointsFileWriter != null) {
			try {
				mPointsFileWriter.flush();
				mPointsFileWriter2.flush();
				mPointsFileWriter3.flush();
				
				mPointsFileWriter.close();
				mPointsFileWriter2.close();
				mPointsFileWriter3.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO 3: Move writing of output files to separate classes
	public synchronized void writeMeasurement(Measurement m) {

		// ############# BEGIN Write measured point to output file ############
		if (mPointsFileWriter != null) {

			Vector3D shifted = m.position.add(scanner.platform.scene.getShift());
			Vector3D shifted3 = m.beamOrigin.add(scanner.platform.scene.getShift());			
			/*ZonedDateTime zdt = ZonedDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "HH:mm:ss:SSS" );
			String output = formatter.format ( zdt );
			System.out.println(outputFileLineFormatString+"!@#$%^");
			System.out.print(shifted.getX()+"-X ,");
			System.out.print(shifted.getY()+"-Y , ");
			System.out.print(shifted.getZ()+"-Z ,");
			System.out.print(m.intensity+"-intensity . \n");
			*/
			//Vector3D origin=scanner.platform.getPosition();
			Vector3D origin=scanner.platform.getAbsoluteMountPosition();
			
			//int E=Error();
			//double len=Math.sqrt(Math.pow(shifted.getX(), 2)+Math.pow(shifted.getY(), 2)+Math.pow(shifted.getZ(), 2));
			double x1=shifted.getX();
			double y1=shifted.getY();
			double z1=shifted.getZ();
			//Vector3D position =scanner.platform.getPosition();
			//System.out.println("x"+position.getX() + "y"+position.getY()+"z"+position.getZ() );
			
			double x=origin.getX();
			double y=origin.getY();
			double z=origin.getZ();
			
			double dx=x1-x;
			double dy=y1-y;
			double dz=z1-z;
			//System.out.println("Error: "+error);
			
			double len=Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2)+Math.pow(dz, 2));
			Vector3D P=new Vector3D(dx,dy,dz);
			//Vector3D newv=new Vector3D(dx,dy,dz);
			double nx=dx/len;
			double ny=dy/len;
			double nz=dz/len;
			Vector3D f=new Vector3D(P.getX()+nx,P.getY()+ny, P.getZ()+nz);
			//Random rand ;
		   // int randomNum = rand.nextInt((error - (-1*error) + 1) + min;
			
			
			/*nx=nx*norm;
			ny=ny*norm;
			nz=nz*norm;*/
			
			//Vector3D norm=new Vector3D(nx,ny,nz);
			//Vector3D f=new Vector3D(P.getX()+nx,P.getY()+ny, P.getZ()+nz);
			
			//double lenv=Math.sqrt(Math.pow(norm.getX(), 2)+Math.pow(norm.getY(), 2)+Math.pow(norm.getZ(), 2));
			//System.out.println("length"+len+"\n");
			//len=len+error;
			//System.out.println("length2:  "+len+"\n");
			//System.out.println("vector1"+newv.toString());
			//System.out.println();
			/*Random1 a1= new Random1();
			double randomNum=a1.rand();
			Random rand = new Random();
			int randomNum = 1 + rand.nextInt((5 - 1) + 1);
			double per=len*randomNum/100;
			//double newlen=len+randomNum;
			double x2=x+f.getX();
			double y2=y+f.getY();
			double z2=z+f.getZ();
			
			/*
			double len =Math.sqrt(Math.pow(shifted.getX(), 2)+Math.pow(shifted.getY(), 2)+Math.pow(shifted.getZ(), 2));
		//	Random rand = new Random(333333331);
			double err0 = rand.nextGaussian();
			err0 = err0 * error;	 // [-err, +err)
			double dd = len+err0;
			if(dd == 0) {
				dd=1;
				}
			double norm = len/ (dd); // [1-eps, 1+eps];
			*/double err0 = rand.nextGaussian();
			err0 = err0 * error;	 // [-err, +err)
			double dd = len+err0;
			if(dd == 0) {
				dd=1;
				}
			double norm = len/ (dd); // [1-eps, 1+eps];
			double x2=x+norm*dx;
			double y2=y+norm*dy;
			double z2=z+norm*dz;
			Vector3D shifted2= new Vector3D(x2,y2,z2) ;
			//System.out.println("vector2 x: "+shifted2.getX());
			/*System.out.print(shifted2.getX()+"-X ,");
			System.out.print(shifted2.getY()+"-Y , ");
			System.out.print(shifted2.getZ()+"-Z ,\n");
			*/
			String line = String.format(outputFileLineFormatString, shifted.getX(), shifted.getY(), shifted.getZ(), m.intensity, m.hitObjectId,System.currentTimeMillis())+" "+m.time;
			
			String line2 = String.format(outputFileLineFormatString2, shifted2.getX(), shifted2.getY(), shifted2.getZ());
			/*
			System.out.print(shifted3.getX()+"-X ,");
			System.out.print(shifted3.getY()+"-Y , ");
			System.out.print(shifted3.getZ()+"-Z ,\n");
			*/
			String line3 = String.format(outputFileLineFormatString3, shifted3.getX(), shifted3.getY(), shifted3.getZ());

			//line = String.format(outputFileLineFormatString, shifted.getX(), shifted.getY(), shifted.getZ(), m.intensity, m.hitObjectId);

			line += "\n";
			line2 += "\n";
			line3 += "\n";
			
			try {
				mPointsFileWriter2.write(line2);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				mPointsFileWriter3.write(line3);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				mPointsFileWriter.write(line);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// ############# END Write measured point to output file ############
	}




}
