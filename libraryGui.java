  //@MoeAlomar GitHub: https://github.com/MoeAlomar
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;

import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.TextField;
import java.awt.List;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import java.io.*;
public class libraryGui implements Serializable	{

	private JFrame frame;
	private JTextField textField;

		Library library = new Library("Barnes & Noble", 3000);
		private JTextField AuthorField;
		private JTextField TitleField;
		private JTextField ISBNField;
		private JTextField NPField;
		private JTextField CoverTypeField;
		private JTextField SizeField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					libraryGui window = new libraryGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public libraryGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(library.getName());
		//frame.setSize(400,500);
		frame.setResizable(false);
		frame.setVisible(true);
		ImageIcon logo = new ImageIcon("library.png");
		frame.setIconImage(logo.getImage());
	
		frame.setBounds(400, 200, 455, 320);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 428, 254);
		frame.getContentPane().add(tabbedPane);
		ButtonGroup group = new ButtonGroup();
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Find Book", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Book ISBN: ");
		lblNewLabel.setBounds(10, 11, 108, 14);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setBounds(148, 8, 96, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(0, 84, 395, 142);
		panel_1.add(textArea);
		JButton SearchButton = new JButton("Search");
		
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				String WISBN =  textField.getText();
				try {
					int ISBN = Integer.parseInt(WISBN);
					if(ISBN == 0) {
						for(int i = 0 ; i<library.bCount; i++) {
							textArea.setText(library.displayAllBooks());
							}
					
					} else {
						Book found = library.findBook(ISBN);
						textArea.setText(found.toString());
					}
					
				} catch (NumberFormatException exc1) {
					JOptionPane.showMessageDialog(null, "Please input whole numbers only!");
					System.out.println("Please input whole numbers only!");
				} catch (NullPointerException exc2) {

					JOptionPane.showMessageDialog(null, "No book has been found with that ISBN.");
					System.out.println("No book has been found with that ISBN.");
				}
			}});
		SearchButton.setBounds(306, 55, 89, 23);
		panel_1.add(SearchButton);
		
		JLabel lblNewLabel_1 = new JLabel("Enter 0 to Display all Books");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setBounds(139, 30, 148, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Print Saved Books");
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { library.LoadFromfile("D:\\Eclipse workspace\\113Project\\src\\Books.data");

						textArea.setText(null);				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(148, 55, 148, 23);
		panel_1.add(btnNewButton_1);
		tabbedPane.setFocusable(false);
		
		JPanel panel = new JPanel();
		panel.addFocusListener(new FocusAdapter() {
			
		});
		tabbedPane.addTab("Add Book", null, panel, null);
		panel.setLayout(null);
		
		JLabel TitleLabel = new JLabel("Title: ");
		TitleLabel.setBounds(10, 11, 32, 14);
		panel.add(TitleLabel);
		
		JLabel lblAuthor = new JLabel("Author: ");
		lblAuthor.setBounds(10, 36, 68, 14);
		panel.add(lblAuthor);
		
		JLabel lblIsbn = new JLabel("ISBN: ");
		lblIsbn.setBounds(10, 72, 53, 14);
		panel.add(lblIsbn);
		
		AuthorField = new JTextField();
		AuthorField.setBounds(88, 38, 109, 20);
		panel.add(AuthorField);
		AuthorField.setColumns(10);
		
		TitleField = new JTextField();
		TitleField.setColumns(10);
		TitleField.setBounds(88, 8, 109, 20);
		panel.add(TitleField);
		
		JLabel Sizelbl = new JLabel("Size");
		Sizelbl.setEnabled(false);
		Sizelbl.setBounds(10, 126, 53, 14);
		panel.add(Sizelbl);
		
		JLabel MBlbl = new JLabel("MB");
		MBlbl.setEnabled(false);
		MBlbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		MBlbl.setBounds(106, 126, 48, 14);
		panel.add(MBlbl);
		
		NPField = new JTextField();
		NPField.setEnabled(false);
		NPField.setBounds(301, 123, 96, 20);
		panel.add(NPField);
		NPField.setColumns(10);
		
		CoverTypeField = new JTextField();
		CoverTypeField.setEnabled(false);
		CoverTypeField.setColumns(10);
		CoverTypeField.setBounds(301, 154, 96, 20);
		panel.add(CoverTypeField);
		
		JLabel NofPageslbl = new JLabel("Number of Pages");
		NofPageslbl.setEnabled(false);
		NofPageslbl.setBounds(196, 126, 109, 17);
		panel.add(NofPageslbl);
		
		JLabel CvrTypelbl = new JLabel("Cover Type");
		CvrTypelbl.setEnabled(false);
		CvrTypelbl.setBounds(196, 154, 109, 14);
		panel.add(CvrTypelbl);

		SizeField = new JTextField();
		SizeField.setEnabled(false);
		SizeField.setColumns(10);
		SizeField.setBounds(37, 123, 59, 20);
		panel.add(SizeField);
		
		JRadioButton PaperBookButton = new JRadioButton("PaperBook");
		PaperBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sizelbl.setEnabled(false);
				SizeField.setEnabled(false);
				SizeField.setEditable(false);
				MBlbl.setEnabled(false);
				NPField.setEnabled(true);
				NofPageslbl.setEnabled(true);
				CvrTypelbl.setEnabled(true);
				CoverTypeField.setEnabled(true);
			}
		});
		PaperBookButton.setBounds(275, 93, 109, 23);
		panel.add(PaperBookButton);
		
		JRadioButton rdbtnEbook = new JRadioButton("EBook");
		rdbtnEbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NPField.setEnabled(false);
				NofPageslbl.setEnabled(false);
				CvrTypelbl.setEnabled(false);
				CoverTypeField.setEnabled(false);
				Sizelbl.setEnabled(true);
				SizeField.setEnabled(true);
				SizeField.setEditable(true);
				MBlbl.setEnabled(true);
			}
			});
		group.add(rdbtnEbook);
		group.add(PaperBookButton);
		rdbtnEbook.setBounds(20, 93, 109, 23);
		panel.add(rdbtnEbook);
		ISBNField = new JTextField();
		ISBNField.setToolTipText("Numbers Only");
		ISBNField.setColumns(10);
		ISBNField.setBounds(88, 69, 109, 20);
		panel.add(ISBNField);
		
		JButton AddBookButton = new JButton("Add Book");
		AddBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SISBN = ISBNField.getText();
				int ISBN = Integer.parseInt(SISBN);
				if(PaperBookButton.isSelected()) {
					String NP = NPField.getText();
					int NOP = Integer.parseInt(NP);
					try {
						library.addbook(new PaperBook(TitleField.getText(),AuthorField.getText(),ISBN,"PaperBook",
								NOP,CoverTypeField.getText()));
					} catch (FullOrAddedException e1) {
						e1.printStackTrace();
					} 
				
				}
			
				else if(rdbtnEbook.isSelected()) {
					int Size = Integer.parseInt(SizeField.getText());
				try {
					library.addbook(new eBook(TitleField.getText(),AuthorField.getText(),
						ISBN,"Ebook",Size));
				} catch (FullOrAddedException e1) {
					e1.printStackTrace();
				} 
			}
			}});
		AddBookButton.setBounds(299, 192, 98, 23);
		panel.add(AddBookButton);
		
		JButton btnNewButton = new JButton("Save Added Books");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					try {
						library.savetofile("D:\\Eclipse workspace\\113Project\\src\\Books.data");
					} catch (IOException e1) {
					
						e1.printStackTrace();
					}
				
			JOptionPane.showMessageDialog(null, "Books Saved!");
			}
		});
		btnNewButton.setBounds(156, 193, 139, 22);
		panel.add(btnNewButton);
		
		
		
		
	}
		}
