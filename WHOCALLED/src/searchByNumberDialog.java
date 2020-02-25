import java.awt.FlowLayout;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class searchByNumberDialog extends JDialog {
	private JTextField textFieldCountryCode;
	private JTextField textFieldNumber;
	private JTextArea textAreaSearchNumber;
	private String countryCode;

	/**
	 * Create the dialog.
	 */
	public searchByNumberDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setForeground(Color.BLACK);
		setTitle("Search By Number");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton searchButton = new JButton("SEARCH");
				searchButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						searchMobile();
					}

				});
				searchButton.setActionCommand("OK");
				buttonPane.add(searchButton);
				getRootPane().setDefaultButton(searchButton);
			}
			/*
			 * { JButton cancelButton = new JButton("Cancel");
			 * cancelButton.setActionCommand("Cancel"); buttonPane.add(cancelButton); }
			 */
		}

		JLabel lblEnterTheCounty = new JLabel("Enter the County Code");
		lblEnterTheCounty.setForeground(new Color(255, 255, 255));
		lblEnterTheCounty.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEnterTheCounty.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnterTheCounty.setBounds(30, 32, 142, 14);
		getContentPane().add(lblEnterTheCounty);

		textFieldCountryCode = new JTextField();
		textFieldCountryCode.setBounds(221, 29, 153, 20);
		getContentPane().add(textFieldCountryCode);
		textFieldCountryCode.setColumns(10);

		textFieldNumber = new JTextField();
		textFieldNumber.setBounds(221, 78, 153, 20);
		getContentPane().add(textFieldNumber);
		textFieldNumber.setColumns(10);

		JLabel lblNewLabel = new JLabel("Enter the number");
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(30, 81, 142, 14);
		getContentPane().add(lblNewLabel);

		textAreaSearchNumber = new JTextArea();
		textAreaSearchNumber.setBounds(30, 122, 368, 95);
		getContentPane().add(textAreaSearchNumber);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\4ISE1JAVA\\WHOCALLED\\BlackWater.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		getContentPane().add(lblNewLabel_1);
	}

	private void searchMobile() {
		// TODO Auto-generated method stub
		textAreaSearchNumber.setText("");
		countryCode = textFieldCountryCode.getText().trim();
		if (countryCode.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter country code");
			return;
		}
		if (countryCode.length() != 2) {
			JOptionPane.showMessageDialog(null, "please enter a valid country code");
			return;
		}
		String restOfNumStr = textFieldNumber.getText().trim();
		if (restOfNumStr.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter phone number");
			return;
		}
		if (restOfNumStr.length() != 10) {
			JOptionPane.showMessageDialog(null, "please enter a valid phone number");
			return;
		}
		//
		File file = new File("D://4ISE1JAVA/WHOCALLED/src/data.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<Long, String> names = new HashMap<>();
		RBTree tree = new RBTree(0);
		String finalToString = "";
		String countryName = "";
		while (scanner.hasNext()) {
			String country = scanner.next();
			long phoneNum = scanner.nextLong();
			String name = scanner.next();
			tree.insert(phoneNum);
			names.put(phoneNum, name);
		}
		scanner.close();
		//
		//
		long goodPhoneNumber = Long.parseLong((countryCode + restOfNumStr));
		int countryCodeInt = Integer.parseInt(countryCode);
		boolean isThere = tree.search(goodPhoneNumber);

		switch (countryCodeInt) {
		case (1):
					countryName = "USA/Canada";
					break;
		case (91):
					countryName = "India";
					break;
		case (52):
					countryName = "Mexico";
					break;
		case (61):
					countryName = "Australia";
					break;
		case (55):
					countryName = "Brazil";
					break;
		case (44):
					countryName = "England";
					break;
		case (81):
					countryName = "Japan";
					break;
		case (49):
					countryName = "Germany";
			break;

		default:
					countryName = "unlisted";
		}

		if (isThere) {
			finalToString += "Search Successful!\nCountry: " + countryName + "\n";
			String callerName = names.get(goodPhoneNumber);
			finalToString += "Caller Name: " + callerName + "\n";
			finalToString += "Phone Number: " + (countryCode + restOfNumStr) + "\n";
			textAreaSearchNumber.append(finalToString);
			// System.out.println(finalToString);
			// System.out.print("To begin new search, type \"begin\". Type \"exit\" to
			// quit.\n");
		} else {

			textAreaSearchNumber.append("The search was inconclusive, the call originated from " + countryName+".");
		}

	}
}
