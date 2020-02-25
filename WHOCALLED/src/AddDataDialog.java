import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class AddDataDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCountry;
	private JTextField textFieldPhNo;
	private JTextField textFieldName;
	private JTextField textFieldResult;
	private String cName;
	private String phno;
	private String name;

	/**
	 * Create the dialog.
	 */
	public AddDataDialog() {
		setTitle("Add New Entry");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel CNameLabel = new JLabel("Country Name");
		CNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		CNameLabel.setForeground(new Color(255, 255, 240));
		CNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		CNameLabel.setBounds(31, 48, 117, 14);
		contentPanel.add(CNameLabel);

		JLabel PhNoLabel = new JLabel("Full Phone Number");
		PhNoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		PhNoLabel.setForeground(new Color(255, 255, 255));
		PhNoLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		PhNoLabel.setBounds(31, 88, 117, 14);
		contentPanel.add(PhNoLabel);

		JLabel lblNewLabel_2 = new JLabel("Caller Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 240));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(31, 134, 117, 14);
		contentPanel.add(lblNewLabel_2);

		textFieldCountry = new JTextField();
		textFieldCountry.setBounds(170, 45, 137, 20);
		contentPanel.add(textFieldCountry);
		textFieldCountry.setColumns(10);

		textFieldPhNo = new JTextField();
		textFieldPhNo.setBounds(170, 85, 137, 20);
		contentPanel.add(textFieldPhNo);
		textFieldPhNo.setColumns(10);

		textFieldName = new JTextField();
		textFieldName.setBounds(170, 131, 137, 20);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldResult = new JTextField();
		textFieldResult.setBounds(31, 185, 368, 32);
		contentPanel.add(textFieldResult);
		textFieldResult.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\4ISE1JAVA\\WHOCALLED\\BlackWater.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addMore();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}

		}
	}

	private void addMore() {
		textFieldResult.setText("");
		cName = textFieldCountry.getText().trim();
		if (cName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter the country name");
			return;
		}
		if (!isAllLetters(cName)) {
			JOptionPane.showMessageDialog(null, "please enter a valid country name");
			return;
		}

		phno = textFieldPhNo.getText().trim();
		if (phno.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter the phone number");
			return;
		}
		// if((!(phno.length()==12))||((!(phno.length()==11))&&((cName!="USA")||(cName!="Canada")))){
		if (!(phno.length() == 12)) {

			JOptionPane.showMessageDialog(null, "please enter a valid phone number");
			return;
		}

		name = textFieldName.getText().trim();
		if (name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter the name");
			return;
		}
		if (!isAllLetters(name)) {
			JOptionPane.showMessageDialog(null, "please enter a valid name");
			return;
		}

		String finalToString = cName + " " + phno + " " + name;
		File file = new File("D://4ISE1JAVA/WHOCALLED/src/data.txt");
		FileWriter fr = null;
		try {
			fr = new FileWriter(file, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter br = new BufferedWriter(fr);
		PrintWriter pr = new PrintWriter(br);
		pr.println(finalToString);
		try {
			pr.close();
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textFieldResult.setText("New Phone Entry Successfully added to the database!");

	}

	private boolean isAllLetters(String name) {
		char[] chars = name.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}

		return true;
	}
}
