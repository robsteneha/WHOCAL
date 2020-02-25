import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class SearchByNameDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextArea textAreaSearchName;
	private String UserName;
	private JScrollPane scrollPane;

	/**
	 * Create the dialog.
	 */
	public SearchByNameDialog() {
		setTitle("Search By Name");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblName = new JLabel("Name");
			lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblName.setForeground(new Color(255, 255, 255));
			lblName.setHorizontalAlignment(SwingConstants.TRAILING);
			lblName.setBounds(48, 31, 57, 14);
			contentPanel.add(lblName);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setBounds(133, 28, 140, 20);
			contentPanel.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 82, 376, 130);
			contentPanel.add(scrollPane);

			textAreaSearchName = new JTextArea();
			scrollPane.setViewportView(textAreaSearchName);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("D:\\4ISE1JAVA\\WHOCALLED\\BlackWater.jpg"));
			lblNewLabel.setBounds(0, 0, 434, 260);
			contentPanel.add(lblNewLabel);
		}

		// scrollPane = new
		// JScrollPane(textAreaSearchName,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// textAreaSearchName.add(scrollPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("SEARCH");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						searchName();
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			/*
			 * { JButton cancelButton = new JButton("Cancel");
			 * cancelButton.setActionCommand("Cancel"); buttonPane.add(cancelButton); }
			 */
		}
	}

	// to check if the entered name is valid

	private boolean isAllLetters(String name) {
		char[] chars = name.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}

		return true;
	}

	private void searchName() {
		// TODO Auto-generated method stub
		// clearing the text area every time before displaying anything
		textAreaSearchName.setText("");
		UserName = textFieldName.getText().trim();
		if (UserName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter name");
			return;
		}
		if (!isAllLetters(UserName)) {
			JOptionPane.showMessageDialog(null, "please enter a valid name");
			return;
		} else {
			Pattern p1 = Pattern.compile(UserName, Pattern.CASE_INSENSITIVE);
			BufferedReader r = null;
			try {
				r = new BufferedReader(new FileReader("D://4ISE1JAVA/WHOCALLED/src/data.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String line;

			try {
				while ((line = r.readLine()) != null) {
					Matcher m = p1.matcher(line);
					while (m.find()) {
						// System.out.println(m.group(0));
						// int s1 = m.start(0);
						// int e1 = m.end(0);
						textAreaSearchName.append(line + "\n");
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
