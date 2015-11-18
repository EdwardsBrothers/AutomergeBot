package mergebot;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import java.io.File;

public class MergeBotPanel extends JPanel {

	private JButton btnMerge;
	private JLabel lblDatetime, lblLastMerge, lblTitle;
	private SimpleDateFormat sdf;
	private Timer timeTimer, delayTimer;
	private Date currentTime;
	private boolean validTime;
	private MergeBot mergeBot;
	private MergeBotListener mbl;
	private String editFilePath;
	private File currentEditFile;
	private long currentEditTimeStamp;
	
	
	
	/**
	 * Create the panel.
	 */
	public MergeBotPanel() {
		mbl = new MergeBotListener();
		sdf = new SimpleDateFormat("kk:mm");
		
		setPreferredSize(new Dimension(400, 150));
		setLayout(new BorderLayout(0, 0));
		
		lblTitle = new JLabel("Merge Bot");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		add(lblTitle, BorderLayout.NORTH);
		
		lblLastMerge = new JLabel("Last Merge:");
		lblLastMerge.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(lblLastMerge, BorderLayout.WEST);
		
		lblDatetime = new JLabel();
		lblDatetime.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDatetime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDatetime, BorderLayout.CENTER);
		
		btnMerge = new JButton("MERGE");
		btnMerge.setSize(new Dimension(100, 100));
		btnMerge.setPreferredSize(new Dimension(100, 100));
		btnMerge.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		btnMerge.addActionListener(mbl);
		add(btnMerge, BorderLayout.EAST);
		
		editFilePath = "Z:\\AAPRINT-EDIT";
		currentEditFile = new File(editFilePath);
		currentEditTimeStamp = currentEditFile.lastModified();
		
		timeTimer = new Timer(60000, mbl);
		delayTimer = new Timer(30000,mbl);
		mergeBot = new MergeBot();
		validTime = checkTime();

		timeTimer.start();
	}
	
	private boolean checkTime(){
		currentTime = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentTime);
		int hour = cal.get(Calendar.HOUR_OF_DAY);

		if(hour > 8 && hour < 18){
			return true;
		}
		return false;
	}
	
	private class MergeBotListener implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnMerge){
				if(validTime){
					mergeBot.merge();
					lblDatetime.setText(sdf.format(new Date()));
				}
			}
			
			if(e.getSource() == timeTimer){
				if(validTime){
					File tempFile = new File(editFilePath);
					long tempTimeStamp = tempFile.lastModified();
					if(currentEditTimeStamp != tempTimeStamp){
						currentEditFile = new File(editFilePath);
						currentEditTimeStamp = currentEditFile.lastModified();
						delayTimer.start();
					}
				}
				validTime = checkTime();
			}
			
			if(e.getSource() == delayTimer){
				if(validTime){
					mergeBot.merge();
					lblDatetime.setText(sdf.format(new Date()));
				}
			}
		}
	}

}
