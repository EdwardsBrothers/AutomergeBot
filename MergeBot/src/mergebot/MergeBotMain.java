package mergebot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;

public class MergeBotMain {

	private JFrame frmMergeBot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MergeBotMain window = new MergeBotMain();
					window.frmMergeBot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MergeBotMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMergeBot = new JFrame();
		frmMergeBot.setTitle("Merge Bot 1.0");
		frmMergeBot.setPreferredSize(new Dimension(400, 150));
		frmMergeBot.setContentPane(new MergeBotPanel());
		frmMergeBot.setBounds(100, 100, 400, 150);
		frmMergeBot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
