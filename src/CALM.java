
//theworldisquiethere

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class CALM extends JFrame {

	public static CALM box;
	private Mailbox mailbox = new Mailbox();
	private JFrame optionsBox = new JFrame("");
	private JPanel atlas = new JPanel();
	private JPanel menoetius = new JPanel();
	private JPanel historyContainer = new JPanel();
	private JPanel menuContainer = new JPanel();
	private JPanel bContainer = new JPanel();
	private JPanel nameContainer = new JPanel();
	private JLabel options = new JLabel("?");
	private JLabel bPink = new JLabel(" ");
	private JLabel bRed = new JLabel(" ");
	private JLabel bOrange = new JLabel(" ");
	private JLabel bYellow = new JLabel(" ");
	private JLabel bGreen = new JLabel(" ");
	private JLabel bCyan = new JLabel(" ");
	private JLabel bBlue = new JLabel(" ");
	private JLabel bLGrey = new JLabel(" ");
	private DefaultStyledDocument doc = new DefaultStyledDocument();
	private JTextArea nameArea = new JTextArea();
	private JEditorPane history = new JEditorPane();
	private JTextArea messageArea = new JTextArea();
	private JScrollPane historyScroll = new JScrollPane(historyContainer);
	private JScrollPane messageContainer = new JScrollPane(messageArea);
	private Font manaFont = new Font("Serif", Font.PLAIN, 18);
	private String messageHistory = "", name = "anon"; 
	private boolean optionsOpen = false, optionsBuilt = false, sliderMouseDown = false, stick = true;
	private Color bgc = Color.BLACK, nc = Color.WHITE;


	public CALM() {
		
		super("C.A.L.M.");

		addListeners();	

		buildComponents();
	
		buildAtlas();

		buildAbox();

		messageArea.requestFocus();

	}
		
	private void updateOptions() {

		if (name.length() == 0)

			name = "anon";

		atlas.setBackground(bgc);

		if (bgc != Color.BLACK)

			nc = bgc;

		else

			nc = Color.DARK_GRAY;

		menoetius.setBackground(bgc);

	}
		
	private void options() {

		if (!optionsOpen) {

			if (!optionsBuilt) {

				optionsOpen = true;
				
				bPink.setBackground(Color.PINK);
				bPink.setOpaque(true);
				bRed.setBackground(Color.RED);
				bRed.setOpaque(true);
				bOrange.setBackground(Color.ORANGE);
				bOrange.setOpaque(true);
				bYellow.setBackground(Color.YELLOW);
				bYellow.setOpaque(true);
				bGreen.setBackground(Color.GREEN);
				bGreen.setOpaque(true);
				bCyan.setBackground(Color.CYAN);
				bCyan.setOpaque(true);
				bBlue.setBackground(Color.BLUE);
				bBlue.setOpaque(true);
				bLGrey.setBackground(Color.LIGHT_GRAY);
				bLGrey.setOpaque(true);

				bContainer.setLayout(new GridLayout(2, 4, 20, 20));
				bContainer.setBorder(new EmptyBorder(20, 20, 20, 20));
				bContainer.setOpaque(false);
				bContainer.add(bRed);
				bContainer.add(bOrange);
				bContainer.add(bYellow);
				bContainer.add(bGreen);
				bContainer.add(bBlue);	
				bContainer.add(bCyan);
				bContainer.add(bPink);
				bContainer.add(bLGrey);

				nameArea.setBackground(Color.DARK_GRAY);
				nameArea.setForeground(Color.WHITE);
				nameArea.setFont(manaFont);
				nameArea.setText(name);
				((PlainDocument)nameArea.getDocument()).setDocumentFilter(new SizeFilter(20));
				nameArea.setRows(1);
				nameArea.setMaximumSize(nameArea.getPreferredSize());
				nameArea.setBorder(new EmptyBorder(0, 10, 0, 10));
				nameContainer.setLayout(new GridLayout(1, 1));
				nameContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameArea.getPreferredSize().height));
				nameContainer.setOpaque(false);
				nameContainer.add(nameArea);

				menoetius.setLayout(new BoxLayout(menoetius, BoxLayout.Y_AXIS));
				menoetius.setBorder(new EmptyBorder(10, 10, 10, 10));
				menoetius.setBackground(bgc);
				menoetius.add(bContainer);
				menoetius.add(nameContainer);

				optionsBox.setSize(new Dimension(178, 199));
				optionsBox.setContentPane(menoetius);
				optionsBox.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
				if ((this.getX() + this.getWidth() + 20 + optionsBox.getWidth()) > Toolkit.getDefaultToolkit().getScreenSize().getWidth())

					optionsBox.setLocationRelativeTo(box);

				else

					optionsBox.setLocation(this.getX() + this.getWidth() + 20, this.getY() + (this.getHeight() / 2) - (optionsBox.getHeight() / 2));	
				
				optionsBox.setResizable(false);
				optionsBox.setVisible(true);
				optionsBox.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosing(WindowEvent e) {

						optionsOpen = false;
						optionsBox.setVisible(false);

					}

				});

				optionsBuilt = true;
	
			} else {

				optionsOpen = true;
				nameArea.setText(name);

				if ((this.getX() + this.getWidth() + 20 + optionsBox.getWidth()) > Toolkit.getDefaultToolkit().getScreenSize().getWidth())

					optionsBox.setLocationRelativeTo(box);

				else

					optionsBox.setLocation(this.getX() + this.getWidth() + 20, this.getY() + (this.getHeight() / 2) - (optionsBox.getHeight() / 2));
				
				optionsBox.setVisible(true);

			}

		} else {

			if ((this.getX() + this.getWidth() + 20 + optionsBox.getWidth()) > Toolkit.getDefaultToolkit().getScreenSize().getWidth())

				optionsBox.setLocationRelativeTo(box);

			else

				optionsBox.setLocation(this.getX() + this.getWidth() + 20, this.getY() + (this.getHeight() / 2) - (optionsBox.getHeight() / 2));
			
			optionsBox.requestFocus();

		}

	}

	private String getColour(Color container) {


		if (container.equals(Color.RED))
	
			return "red";
		
		else if (container.equals(Color.ORANGE))

			return "orange";

		else if (container.equals(Color.YELLOW))

			return "yellow";

		else if (container.equals(Color.GREEN))

			return "green";

		else if (container.equals(Color.BLUE))

			return "4169E1";

		else if (container.equals(Color.CYAN))

			return "00FFFF";

		else if (container.equals(Color.PINK))

			return "FFC0CB";

		else if (container.equals(Color.LIGHT_GRAY))

			return "696969";

		else 
			return "white";

	}

	private void addMessage(String container) {

		if (messageHistory.equals(""))

			messageHistory += container;

		else

			messageHistory += "<br>" + container;

		history.setText("<span style='color:white;font-size:18;'>" + messageHistory + "</span>");

	}

	private void addSysMessage(String container) {

		container = "<span style=\"color:DA70D6;\">" + container + "</span>";

		if (messageHistory.equals(""))

			messageHistory += container;

		else

			messageHistory += "<br>" + container;

		history.setText("<span style='color:white;font-size:18;'>" + messageHistory + "</span>");

	}

	private void sendMessage() {

		if (!messageArea.getText().replace("\n", "").equals("")) {

			mailbox.send("vfd <span style='color:" + getColour(nc) + ";'>" + name + "</span>: " + messageArea.getText());

		}

		messageArea.setText("");

	}

	private void addListeners() {

		messageArea.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER)

					sendMessage();

			}

		});

		options.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				options();

			}

		});

		nameArea.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				nameArea.selectAll();

			}

		});
	
		nameArea.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					name = nameArea.getText().trim();

					nameArea.setText("");

					updateOptions();
	
				}

			}

		});

		bRed.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (bgc != bRed.getBackground())

					bgc = Color.RED;
	
				else

					bgc = Color.BLACK;

				updateOptions();

			}

		});

		bOrange.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (bgc != bOrange.getBackground())

					bgc = Color.ORANGE;
	
				else

					bgc = Color.BLACK;

				updateOptions();

			}

		});

		bYellow.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (bgc != bYellow.getBackground())

					bgc = Color.YELLOW;
	
				else

					bgc = Color.BLACK;

				updateOptions();

			}

		});

		bGreen.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (bgc != bGreen.getBackground())

					bgc = Color.GREEN;
	
				else

					bgc = Color.BLACK;

				updateOptions();

			}

		});

		bBlue.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (bgc != bBlue.getBackground())

					bgc = Color.BLUE;
	
				else

					bgc = Color.BLACK;

				updateOptions();

			}

		});

		bCyan.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (bgc != bCyan.getBackground())

					bgc = Color.CYAN;
	
				else

					bgc = Color.BLACK;

				updateOptions();

			}

		});

		bPink.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (bgc != bPink.getBackground())

					bgc = Color.PINK;
	
				else

					bgc = Color.BLACK;

				updateOptions();

			}

		});

		bLGrey.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (bgc != bLGrey.getBackground())

					bgc = Color.LIGHT_GRAY;
	
				else

					bgc = Color.BLACK;

				updateOptions();

			}

		});
	
		historyScroll.getVerticalScrollBar().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				sliderMouseDown = true;
			
			}

			public void mouseReleased(MouseEvent e) {

				sliderMouseDown = false;

			}
	
		});

		historyScroll.getViewport().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

				BoundedRangeModel model = historyScroll.getVerticalScrollBar().getModel();

				if (sliderMouseDown && (model.getExtent() + model.getValue()) == model.getMaximum())

					stick = true;

				else if (sliderMouseDown)

					stick = false;

				if (stick) {

					((DefaultCaret)history.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

				} else

					((DefaultCaret)history.getCaret()).setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

			}

		});

	}

	private void buildComponents() {

		historyScroll.getVerticalScrollBar().setUnitIncrement(16);

		historyContainer.setLayout(new GridLayout(1, 1));
		historyContainer.add(history);
		historyContainer.setBackground(Color.BLACK);
		history.setOpaque(false);
		history.setContentType("text/html");
		history.setEditable(false);

		messageArea.setRows(1);
		((PlainDocument)messageArea.getDocument()).setDocumentFilter(new SizeFilter(1000));
		messageArea.setBackground(Color.DARK_GRAY);
		messageArea.setFont(manaFont);
		messageArea.setForeground(Color.WHITE);
		messageArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, messageArea.getPreferredSize().height));
		messageContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE, messageArea.getPreferredSize().height));
		messageContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		messageContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		messageContainer.setOpaque(false);

		menuContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE, messageArea.getPreferredSize().height));
		menuContainer.setLayout(new BoxLayout(menuContainer, BoxLayout.X_AXIS));
		menuContainer.add(messageContainer);
		menuContainer.add(options);
		menuContainer.setOpaque(false);

		options.setBorder(new EmptyBorder(5, 5, 5, 5));
		options.setBackground(Color.WHITE);
		options.setOpaque(true);

	}

	private void buildAtlas() {

		atlas.setPreferredSize(new Dimension(500, 400));
		atlas.setLayout(new BoxLayout(atlas, BoxLayout.Y_AXIS));
		atlas.setBorder(new EmptyBorder(10, 10, 10, 10));
		atlas.setBackground(bgc);
		atlas.add(historyScroll);
		atlas.add(Box.createRigidArea(new Dimension(1, 10)));
		atlas.add(menuContainer);

	}

	private void buildAbox() {

		setMinimumSize(new Dimension(518, 447));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(atlas);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void mailAction(String container) {

		addMessage(container);

	}

	public static void main(String args[]) {

		box = new CALM();

	}

}

