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
import java.util.Date;

public class MergeBotPanel extends JPanel {

	private JButton btnMerge;
	private JLabel lblDatetime;
	private JLabel lblLastMerge;
	private SimpleDateFormat sdf;
	private Timer timer;
	private boolean validTime;
	private Date startTime,endTime;
	private MergeBot mergeBot;
	private MergeBotListener mbl;

	/**
	 * Create the panel.
	 */
	public MergeBotPanel() {
		mbl = new MergeBotListener();
		sdf = new SimpleDateFormat("kk:mm");
		try {
			startTime = sdf.parse("06:00");
			endTime = sdf.parse("18:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setPreferredSize(new Dimension(400, 150));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("Merge Bot");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		add(lblTitle, BorderLayout.NORTH);
		
		lblLastMerge = new JLabel("Last Merge:");
		lblLastMerge.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(lblLastMerge, BorderLayout.WEST);
		
		lblDatetime = new JLabel();
		lblDatetime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDatetime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDatetime, BorderLayout.CENTER);
		
		btnMerge = new JButton("MERGE");
		btnMerge.setSize(new Dimension(100, 100));
		btnMerge.setPreferredSize(new Dimension(100, 100));
		btnMerge.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		btnMerge.addActionListener(mbl);
		add(btnMerge, BorderLayout.EAST);
		
		timer = new Timer(1800000, mbl);
		mergeBot = new MergeBot();
		

	}
	
	private boolean checkTime(){
		Date currentTime = new Date();
		if(currentTime.compareTo(startTime)<0){
			return false;
		}
		if(currentTime.compareTo(endTime)>0){
			return false;
		}
		return true;
	}
	
	private class MergeBotListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if((e.getSource()==btnMerge  || e.getSource() == timer) && validTime ){
				mergeBot.merge();
				btnMerge.setText(sdf.format(new Date()));
				validTime = checkTime();
			}
			if(e.getSource() == timer && !validTime){
				if(checkTime()){
					mergeBot.merge();
					btnMerge.setText(sdf.format(new Date()));
					validTime = checkTime();
				}
			}
			
		}
		
	}

}
