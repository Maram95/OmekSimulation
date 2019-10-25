// TODO 2: Fix scan angle getting out of control under certain (unknown) circumstances
/*
package de.uni_hd.giscience.helios.core.scanner;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import de.uni_hd.giscience.helios.core.Asset;
import de.uni_hd.giscience.helios.core.platform.Platform;
import de.uni_hd.giscience.helios.core.scanner.beamDeflector.AbstractBeamDeflector;
import de.uni_hd.giscience.helios.core.scanner.detector.AbstractDetector;

public class Velodyne extends Asset {

	public int length=1;
	public ScannerHead scannerHead = null;
	public AbstractBeamDeflector [] beamDeflector = new AbstractBeamDeflector[length] ;
	public Platform platform = null;
	public AbstractDetector []detector = new AbstractDetector[length] ;;

	// Misc:
	public String cfg_device_visModelPath = "";

	// ########## BEGIN Emitter ########### 
	public Vector3D[] cfg_device_headRelativeEmitterPosition = new Vector3D[length];
	//public Vector3D cfg_device_headRelativeEmitterPosition = new Vector3D(0, 0, 0); ///the emitter on the plan
	
	//public Vector3D cfg_device_headRelativeEmitterPosition2 = new Vector3D(0, 5, 0);
	//public Vector3D cfg_device_headRelativeEmitterPosition3 = new Vector3D(0, 10, 0);
	//public Vector3D [] beams=new Vector3D [length-1];
	double angle_deg= 30;
	double angle_rad=Math.toRadians(angle_deg);
	public Rotation cfg_device_headRelativeEmitterAttitude = new Rotation(new Vector3D(1, 0, 0), 0);
	//public Rotation cfg_device_headRelativeEmitterAttitude2 = new Rotation(new Vector3D(0.8, 0.1, 0.2), 0.1);
	ArrayList<Integer> cfg_device_supportedPulseFreqs_Hz = new ArrayList<Integer>();
	public double cfg_device_beamDivergence_rad = 0; //הסתעפות קרן הלייזר
	
	double cfg_device_pulseLength_ns = 0;

	int cfg_setting_pulseFreq_Hz = 0;
	// ########## END Emitter ###########

	// State variables:
	int state_currentPulseNumber = 0;
	boolean state_lastPulseWasHit = false;
	boolean state_isActive = true;

	
	public Velodyne(double beamDiv_rad, Vector3D beamOrigin, Rotation beamOrientation, ArrayList<Integer> pulseFreqs, double pulseLength_ns, String visModel) {
		
		// Configure emitter:
		this.cfg_device_headRelativeEmitterPosition[0] =new Vector3D (beamOrigin.getX(),beamOrigin.getY(),beamOrigin.getZ());
		//z' = z*cos q - x*sin q
		//x' = z*sin q + x*cos q
		//y' = y
		//for(int i=0; i<beams.length;i++){
			//beams[i]=new Vector3D(0,0,0);
		//}
		//beamorigin(cfg_device_headRelativeEmitterPosition[0]);
		this.cfg_device_headRelativeEmitterAttitude = beamOrientation;
		this.cfg_device_supportedPulseFreqs_Hz = pulseFreqs;
		this.cfg_device_beamDivergence_rad = beamDiv_rad;
		this.cfg_device_pulseLength_ns = pulseLength_ns;

		// Configure misc:
		this.cfg_device_visModelPath = visModel;
	}
	
		/*double x,y,z;
		//x=v.getX();
		//y=v.getY();
		//z=v.getZ();
		//cfg_device_headRelativeEmitterPosition[0]=new Vector3D (x,y,z);
		//for(int i=1 ;i<cfg_device_headRelativeEmitterPosition.length;i++){
		//x=cfg_device_headRelativeEmitterPosition[i-1].getZ()*Math.sin(angle_rad)+cfg_device_headRelativeEmitterPosition[i-1].getX()*Math.cos(angle_rad);
		//y=cfg_device_headRelativeEmitterPosition[i-1].getY();
		//z=cfg_device_headRelativeEmitterPosition[i-1].getZ()*Math.cos(angle_rad)-cfg_device_headRelativeEmitterPosition[i-1].getX()*Math.sin(angle_rad);
		//y=cfg_device_headRelativeEmitterPosition[i-1].getY()+3;
			//cfg_device_headRelativeEmitterPosition[i]=new Vector3D (x,y,z);
			//System.out.println("V("+i+")"+x+","+y+","+z);
		//}
		
		
	public void beamorigin(Vector3D v) {
		double x,y,z;
		x=v.getX();
		y=v.getY();
		z=v.getZ();
		cfg_device_headRelativeEmitterPosition[0]=new Vector3D (x,y,z);
		for(int i=1 ;i<cfg_device_headRelativeEmitterPosition.length;i++){
		//x=cfg_device_headRelativeEmitterPosition[i-1].getZ()*Math.sin(angle_rad)+cfg_device_headRelativeEmitterPosition[i-1].getX()*Math.cos(angle_rad);
		//y=cfg_device_headRelativeEmitterPosition[i-1].getY();
		//z=cfg_device_headRelativeEmitterPosition[i-1].getZ()*Math.cos(angle_rad)-cfg_device_headRelativeEmitterPosition[i-1].getX()*Math.sin(angle_rad);
		y=cfg_device_headRelativeEmitterPosition[i-1].getY()+3;
		cfg_device_headRelativeEmitterPosition[i]=new Vector3D (x,y,z);
		//System.out.println("Angel:"+Math.toDegrees(v.angle(cfg_device_headRelativeEmitterPosition[i],cfg_device_headRelativeEmitterPosition[i-1])));
		
		
		/*  double x,y,z;
		 
		x=v.getX();
		y=v.getY();
		z=v.getZ();
		double a,b,c;
		a=x*x+z*z;
		//b=Math.sqrt(x*x+y*y+z*z);
		c=x*x+z*z;
		double y2;
		//cfg_device_headRelativeEmitterPosition[0]=new Vector3D (x,y,z);
		for(int i=1 ;i<cfg_device_headRelativeEmitterPosition.length;i++){
			//x=cfg_device_headRelativeEmitterPosition[i-1].getZ()*Math.sin(angle_deg)+cfg_device_headRelativeEmitterPosition[i-1].getX()*Math.cos(angle_deg);
			//y=cfg_device_headRelativeEmitterPosition[i-1].getY();
			//z=cfg_device_headRelativeEmitterPosition[i-1].getZ()*Math.cos(angle_deg)-cfg_device_headRelativeEmitterPosition[i-1].getX()*Math.sin(angle_deg);
			 
			//b=Math.sqrt(x*x+y*y+z*z);
			//a=x*x+z*z;
			
			//c=x*x+z*z;
			//y2= polinom((b*b*Math.cos(angle_rad)*(Math.cos(angle_rad)-y*y)),(-2*a*y),(c*b*b*(Math.cos(angle_rad)*(Math.cos(angle_rad)))-a*a));
			
			//this.cfg_device_headRelativeEmitterPosition[i]=new Vector3D (x,y2,z);
			//System.out.println(x+","+y2+","+z);
			//System.out.println("Angel:"+Math.toDegrees(v.angle(cfg_device_headRelativeEmitterPosition[i],cfg_device_headRelativeEmitterPosition[i-1])));
			//y=y2;
			
		}}
	public double polinom(double a,double b,double c){
		double d=(b*b-4*a*c)/(2*a);
		double x1=0,x2=0;
		if(a!=0){
			if(d>0)
			{
				x1=(-b+Math.sqrt(d))/(2*a);
				x2=(-b-Math.sqrt(d))/(2*a);
			//	System.out.println("יש שניי שורשים שונים" + x1 + "" + x2);
			}
			else if(d==0)
			{
				x1=(-b+Math.sqrt(d))/(2*a);
				//x2=(-b-Math.sqrt(d))/(2*a);
			//	System.out.println("יש שני שורשים שווים" + x1 + "" + x2);
			}
			else if(d<0)
				System.out.println("error delta");
		}
		else System.out.println("error!!");

		if(x1>x2)
			return x1;
		else
			return x2;
	}


	
	public void applySettings(ScannerSettings settings) {

		// Configure scanner:
		this.setActive(settings.active);
		this.setPulseFreq_Hz(settings.pulseFreq_Hz);
		for(int i=0;i<detector.length;i++){
			detector[i].applySettings(settings);
		}
		scannerHead.applySettings(settings);
		for(int i=0;i<beamDeflector.length;i++){
		beamDeflector[i].applySettings(settings);
	}}

	
	public void doSimStep(ExecutorService execService) {

		// Update head attitude (we do this even when the scanner is inactive):
		scannerHead.doSimStep(cfg_setting_pulseFreq_Hz);

		// If the scanner is inactive, stop here:
		if (!state_isActive) {
			return;
		}

		// Update beam deflector attitude:
		for(int i=0;i<beamDeflector.length;i++){
		this.beamDeflector[i].doSimStep();
		
		if (!beamDeflector[i].lastPulseLeftDevice()) {
			return;
		}}

		// Global pulse counter:
		state_currentPulseNumber++;

		// Calculate absolute beam origin:
	
		Vector3D []absoluteBeamOrigin=new Vector3D[length];
		for(int i=0 ;i<absoluteBeamOrigin.length;i++){
			 absoluteBeamOrigin[i] = this.platform.getAbsoluteMountPosition().add(cfg_device_headRelativeEmitterPosition[i]);
		}
		
		//Vector3D absoluteBeamOrigin = this.platform.getAbsoluteMountPosition().add(cfg_device_headRelativeEmitterPosition);
		//Vector3D absoluteBeamOrigin1 = this.platform.getAbsoluteMountPosition().add(cfg_device_headRelativeEmitterPosition2);
		//Vector3D absoluteBeamOrigin2 = this.platform.getAbsoluteMountPosition().add(cfg_device_headRelativeEmitterPosition3);
		

		// Calculate absolute beam attitude:
		Rotation mountRelativeEmitterAttitude = this.scannerHead.getMountRelativeAttitude().applyTo(this.cfg_device_headRelativeEmitterAttitude);
		//double y =this.cfg_device_headRelativeEmitterAttitude.getQ1()+100;
		// Rotation cfg_device_headRelativeEmitterAttitude2=new Rotation(new Vector3D(y,this.cfg_device_headRelativeEmitterAttitude.getQ2(),this.cfg_device_headRelativeEmitterAttitude.getQ3()), this.cfg_device_headRelativeEmitterAttitude.getQ0());
	//	Rotation mountRelativeEmitterAttitude2 = this.scannerHead.getMountRelativeAttitude().applyTo(cfg_device_headRelativeEmitterAttitude);
		//Rotation absoluteBeamAttitude1 = platform.getAbsoluteMountAttitude().applyTo(mountRelativeEmitterAttitude).applyTo(beamDeflector[1].getEmitterRelativeAttitude());
		//Rotation absoluteBeamAttitude2 = platform.getAbsoluteMountAttitude().applyTo(mountRelativeEmitterAttitude).applyTo(beamDeflector[1].getEmitterRelativeAttitude());
		for(int j=0;j<length;j++){
			//Rotation absoluteBeamAttitude2 = platform.getAbsoluteMountAttitude().applyTo(mountRelativeEmitterAttitude2).applyTo(beamDeflector[0].getEmitterRelativeAttitude());
		Rotation absoluteBeamAttitude = platform.getAbsoluteMountAttitude().applyTo(mountRelativeEmitterAttitude).applyTo(beamDeflector[j].getEmitterRelativeAttitude());
		Long unixTime = System.currentTimeMillis() / 1000L;
		Long currentGpsTime = (unixTime - 315360000) - 1000000000;
		
		detector[j].simulatePulse(execService, absoluteBeamOrigin[j], absoluteBeamAttitude, state_currentPulseNumber, currentGpsTime);
		//for(int j=1;j<beamDeflector.length;j++){
		// Caclulate time of the emitted pulse
		
		//detector[0].simulatePulse(execService, absoluteBeamOrigin, absoluteBeamAttitude, state_currentPulseNumber, currentGpsTime);
		//detector[j].simulatePulse(execService, absoluteBeamOrigin1[j-1], absoluteBeamAttitude1[j-1], state_currentPulseNumber, currentGpsTime);
	//	}
		
		}}
	
	
	public int getPulseFreq_Hz() {
		return this.cfg_setting_pulseFreq_Hz;
	}

	public double getPulseLength_ns() {
		return this.cfg_device_pulseLength_ns;
	}

	
	public boolean lastPulseWasHit() {
		return this.state_lastPulseWasHit;
	}

	public boolean isActive() {
		return this.state_isActive;
	}

	public void setActive(boolean active) {
		state_isActive = active;
	}

	
	public void setPulseFreq_Hz(int pulseFreq_Hz) {

		// Check of requested pulse freq is > 0:
		if (pulseFreq_Hz < 0) {
			System.out.println("ERROR: Attempted to set pulse frequency < 0. This is not possible.");
			pulseFreq_Hz = 0;
		}

		// Check if requested pulse freq is supported by device:
		if (!cfg_device_supportedPulseFreqs_Hz.contains(pulseFreq_Hz)) {
			System.out.println("WARNING: Specified pulse frequency is not supported by this device. We'll set it nevertheless.");
		}

		// Set new pulse frequency:
		this.cfg_setting_pulseFreq_Hz = pulseFreq_Hz;

		//System.out.println("Pulse frequency set to " + this.cfg_setting_pulseFreq_Hz);
	}
	
	public void setLastPulseWasHit(boolean value) {
		
		if (value == state_lastPulseWasHit) return;
		
		synchronized(this) {
			this.state_lastPulseWasHit = value;
		}
	}
}*/
// TODO 2: Fix scan angle getting out of control under certain (unknown) circumstances

package de.uni_hd.giscience.helios.core.scanner;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import de.uni_hd.giscience.helios.core.Asset;
import de.uni_hd.giscience.helios.core.platform.Platform;
import de.uni_hd.giscience.helios.core.scanner.beamDeflector.AbstractBeamDeflector;
import de.uni_hd.giscience.helios.core.scanner.detector.AbstractDetector;

public class Velodyne extends Asset {

	public ScannerHead scannerHead = null;
	public AbstractBeamDeflector beamDeflector = null;
	public Platform platform = null;
	public AbstractDetector detector = null;

	// FWF settings
	//public FWFSettings FWF_settings;
	//
	
	// Misc:
	public String cfg_device_visModelPath = "";

	// ########## BEGIN Emitter ###########
	public Vector3D cfg_device_headRelativeEmitterPosition = new Vector3D(0, 0, 0);
	public Rotation cfg_device_headRelativeEmitterAttitude = new Rotation(new Vector3D(1, 0, 0), 0);
	ArrayList<Integer> cfg_device_supportedPulseFreqs_Hz = new ArrayList<Integer>();
	public double cfg_device_beamDivergence_rad = 0;
	double cfg_device_pulseLength_ns = 0;

	int cfg_setting_pulseFreq_Hz = 0;
	// ########## END Emitter ###########

	// State variables:
	int state_currentPulseNumber = 0;
	boolean state_lastPulseWasHit = false;
	boolean state_isActive = true;

	
	public Velodyne(double beamDiv_rad, Vector3D beamOrigin, Rotation beamOrientation, ArrayList<Integer> pulseFreqs, double pulseLength_ns, String visModel) {
		
		// Configure emitter:
		this.cfg_device_headRelativeEmitterPosition = beamOrigin;
		this.cfg_device_headRelativeEmitterAttitude = beamOrientation;
		this.cfg_device_supportedPulseFreqs_Hz = pulseFreqs;
		this.cfg_device_beamDivergence_rad = beamDiv_rad;
		this.cfg_device_pulseLength_ns = pulseLength_ns;

		// Configure misc:
		this.cfg_device_visModelPath = visModel;
	}
	
	public void applySettings(ScannerSettings settings) {

		// Configure scanner:
		this.setActive(settings.active);
		this.setPulseFreq_Hz(settings.pulseFreq_Hz);

		detector.applySettings(settings);
		scannerHead.applySettings(settings);
		beamDeflector.applySettings(settings);
	}

	

	public void doSimStep(ExecutorService execService) {

		// Update head attitude (we do this even when the scanner is inactive):
		scannerHead.doSimStep(cfg_setting_pulseFreq_Hz);

		// If the scanner is inactive, stop here:
		if (!state_isActive) {
			return;
		}

		// Update beam deflector attitude:
		this.beamDeflector.doSimStep();

		if (!beamDeflector.lastPulseLeftDevice()) {
			return;
		}

		// Global pulse counter:
		state_currentPulseNumber++;

		// Calculate absolute beam origin:
		Vector3D absoluteBeamOrigin = this.platform.getAbsoluteMountPosition().add(cfg_device_headRelativeEmitterPosition);

		// Calculate absolute beam attitude:
		Rotation mountRelativeEmitterAttitude = this.scannerHead.getMountRelativeAttitude().applyTo(this.cfg_device_headRelativeEmitterAttitude);
		Rotation absoluteBeamAttitude = platform.getAbsoluteMountAttitude().applyTo(mountRelativeEmitterAttitude).applyTo(beamDeflector.getEmitterRelativeAttitude());

		// Caclulate time of the emitted pulse
		Long unixTime = System.currentTimeMillis() / 1000L;
		Long currentGpsTime = (unixTime - 315360000) - 1000000000;

		detector.simulatePulse(execService, absoluteBeamOrigin, absoluteBeamAttitude, state_currentPulseNumber, currentGpsTime);
	}

	
	
	public int getPulseFreq_Hz() {
		return this.cfg_setting_pulseFreq_Hz;
	}

	public double getPulseLength_ns() {
		return this.cfg_device_pulseLength_ns;
	}

	
	public boolean lastPulseWasHit() {
		return this.state_lastPulseWasHit;
	}

	public boolean isActive() {
		return this.state_isActive;
	}

	public void setActive(boolean active) {
		state_isActive = active;
	}

	
	public void setPulseFreq_Hz(int pulseFreq_Hz) {

		// Check of requested pulse freq is > 0:
		if (pulseFreq_Hz < 0) {
			System.out.println("ERROR: Attempted to set pulse frequency < 0. This is not possible.");
			pulseFreq_Hz = 0;
		}

		// Check if requested pulse freq is supported by device:
		if (!cfg_device_supportedPulseFreqs_Hz.contains(pulseFreq_Hz)) {
			System.out.println("WARNING: Specified pulse frequency is not supported by this device. We'll set it nevertheless.");
		}

		// Set new pulse frequency:
		this.cfg_setting_pulseFreq_Hz = pulseFreq_Hz;

		//System.out.println("Pulse frequency set to " + this.cfg_setting_pulseFreq_Hz);
	}
	
	public void setLastPulseWasHit(boolean value) {
		
		if (value == state_lastPulseWasHit) return;
		
		synchronized(this) {
			this.state_lastPulseWasHit = value;
		}
	}
}