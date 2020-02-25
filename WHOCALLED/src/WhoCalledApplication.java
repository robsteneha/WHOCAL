import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class WhoCalledApplication {

	private JFrame frmWhoCalledApplication;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WhoCalledApplication window = new WhoCalledApplication();
					window.frmWhoCalledApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WhoCalledApplication() {
		initialize();
		// Whocalled wc=new Whocalled();
		// Frame.setTitle(Whocalled.getProjectName());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWhoCalledApplication = new JFrame();
		frmWhoCalledApplication.setTitle("WHOCALLED APPLICATION");
		frmWhoCalledApplication.setBounds(100, 100, 450, 300);
		frmWhoCalledApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWhoCalledApplication.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("WHOCALLED???");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(92, 47, 252, 22);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmWhoCalledApplication.getContentPane().add(lblNewLabel);

		JButton btnSearchByName = new JButton("Search By Name");
		btnSearchByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchByNameDialog snameDg = new SearchByNameDialog();
				snameDg.setModal(true);
				snameDg.setVisible(true);

			}
		});
		btnSearchByName.setBounds(39, 165, 130, 23);
		frmWhoCalledApplication.getContentPane().add(btnSearchByName);

		JButton btnSearchByNumber = new JButton("Search By Number");
		btnSearchByNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchByNumberDialog sNumDg = new searchByNumberDialog();
				sNumDg.setModal(true);
				sNumDg.setVisible(true);

			}
		});
		btnSearchByNumber.setBounds(238, 165, 152, 23);
		frmWhoCalledApplication.getContentPane().add(btnSearchByNumber);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				AddDataDialog ad = new AddDataDialog();
				ad.setModal(true);
				ad.setVisible(true);
			}
		});
		btnAdd.setBounds(157, 109, 89, 23);
		frmWhoCalledApplication.getContentPane().add(btnAdd);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\4ISE1JAVA\\WHOCALLED\\blackMan.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		frmWhoCalledApplication.getContentPane().add(lblNewLabel_1);
	}
}
