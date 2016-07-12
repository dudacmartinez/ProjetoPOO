package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class FrameTestes extends JFrame {

	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JTabbedPane tabbedPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FrameTestes frame = new FrameTestes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameTestes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		setContentPane(panel);
	
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		tabbedPane = new JTabbedPane();
		
		tabbedPane.add("1",panel1);
		tabbedPane.add("2",panel2);
		tabbedPane.add("3",panel3);
		
		panel.add(tabbedPane);
	
	
		
	}
	

}
