package mergebot;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;

public class MergeBot{
		
	private Desktop desktop;
	private String kittyPath, kittyTitle, kittyMenuTitle;
	private Robot robot;
	
	public MergeBot(){
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		desktop = Desktop.getDesktop();
		kittyPath = "C:\\Users\\jedwards\\Desktop\\kitty.exe";
		kittyTitle = "192.168.0.4 - KiTTY";
		kittyMenuTitle = "KiTTY Configuration";
	}
	
	public void startKitty(){
		File kittyFile = new File(kittyPath);
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.open(kittyFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HWND hwnd = User32.INSTANCE.FindWindow(null, kittyMenuTitle);
		User32.INSTANCE.ShowWindow(hwnd, 9);
		User32.INSTANCE.SetForegroundWindow(hwnd);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_J);		robot.keyRelease(KeyEvent.VK_J);
		robot.keyPress(KeyEvent.VK_B);		robot.keyRelease(KeyEvent.VK_B);
		robot.keyPress(KeyEvent.VK_E);		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_N);		robot.keyRelease(KeyEvent.VK_N);
		robot.keyPress(KeyEvent.VK_T);		robot.keyRelease(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_L);		robot.keyRelease(KeyEvent.VK_L);
		robot.keyPress(KeyEvent.VK_E);		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_Y);		robot.keyRelease(KeyEvent.VK_Y);
		robot.keyPress(KeyEvent.VK_ENTER);		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_A);		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_0);		robot.keyRelease(KeyEvent.VK_0);
		robot.keyPress(KeyEvent.VK_S);		robot.keyRelease(KeyEvent.VK_S);		
		robot.keyPress(KeyEvent.VK_0);		robot.keyRelease(KeyEvent.VK_0);		
		robot.keyPress(KeyEvent.VK_D);		robot.keyRelease(KeyEvent.VK_D);		
		robot.keyPress(KeyEvent.VK_0);		robot.keyRelease(KeyEvent.VK_0);
		robot.keyPress(KeyEvent.VK_F);		robot.keyRelease(KeyEvent.VK_F);
		robot.keyPress(KeyEvent.VK_0);		robot.keyRelease(KeyEvent.VK_0);
		robot.keyPress(KeyEvent.VK_ENTER);		robot.keyRelease(KeyEvent.VK_ENTER);
		
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		    alertFailure();
		}			
		robot.keyPress(KeyEvent.VK_ENTER);		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public void merge(){
		HWND hwnd = User32.INSTANCE.FindWindow(null, kittyTitle);
		if(hwnd == null){
			System.out.println("no putty");
			alertFailure();
			return;
		}
		User32.INSTANCE.ShowWindow(hwnd, 9);
		User32.INSTANCE.SetForegroundWindow(hwnd);
		
		robot.keyPress(KeyEvent.VK_2);		robot.keyRelease(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_ENTER);		robot.keyRelease(KeyEvent.VK_ENTER);
		
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		    alertFailure();
		}	
		
		
		robot.keyPress(KeyEvent.VK_5);		robot.keyRelease(KeyEvent.VK_5);
		robot.keyPress(KeyEvent.VK_ENTER);		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		    alertFailure();
		}	
		
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_A);		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		    alertFailure();
		}	
		
		robot.keyPress(KeyEvent.VK_ENTER);		robot.keyRelease(KeyEvent.VK_ENTER);
		
		try {
		    Thread.sleep(5000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		    alertFailure();
		}	
		
		robot.keyPress(KeyEvent.VK_ENTER);		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);		robot.keyRelease(KeyEvent.VK_ENTER);		
	}
	
	public void alertFailure(){
			
	}

}
