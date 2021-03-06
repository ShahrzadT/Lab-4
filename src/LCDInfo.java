import lejos.nxt.LCD;
import lejos.util.Timer;
import lejos.util.TimerListener;
//Alessandro Parisi 260529758
//Shahrzad Tighnavardmollasarae 260413622
public class LCDInfo implements TimerListener{
	public static final int LCD_REFRESH = 100;
	private Odometer odo;
	private Timer lcdTimer;
	
	// arrays for displaying data
	private double [] pos;
	
	public LCDInfo(Odometer odo) {
		this.odo = odo;
		this.lcdTimer = new Timer(LCD_REFRESH, this);
		
		// initialise the arrays for displaying data
		pos = new double [3];
		
		// start the timer
		lcdTimer.start();
	}
	
	public void timedOut() { 
		odo.getPosition(pos);
		LCD.clear();
		LCD.drawString("X: ", 0, 4);
		LCD.drawString("Y: ", 0, 5);
		LCD.drawString("H: ", 0, 6);
		LCD.drawInt((int)(pos[0] * 10), 3, 4);
		LCD.drawInt((int)(pos[1] * 10), 3, 5);
		LCD.drawInt((int)pos[2], 3, 6);
	}
}
