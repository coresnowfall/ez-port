
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class App extends JFrame implements ActionListener {

    // Utility methods
    /**
     * Returns % of total screen size in pixels.
     *
     * @param percent - percent to give (eg. 10% = 0.10, 90% = 0.90)
     * @param tog - 0 for length, anything else for width
     * @return int pixel percent of total screen size (rounded)
     */
    public static int scrnPerc(double percent, int tog) {
        if (tog == 0) {
            return (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * percent);
        } else {
            return (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * percent);
        } // end if, else
    } // double scrnPerc(float, int)

    /**
     * Gets the value of a JTextField component.
     *
     * @param component - component to read
     * @return int value of component
     */
    public int getValue(JTextField component) {
        return Integer.parseInt(component.getText());
    } // int getValue(JTextField)

    /**
     * Changes the value of a jTextField by however amount.
     *
     * @param amt - the amount to change by
     * @param component - the component to change
     */
    public void changeValue(int amt, JTextField component) {
        component.setText(String.valueOf(getValue(component)) + amt);
    } // void changeValue(int, JTextField)

    /**
     * Appends text to a jTextField.
     *
     * @param append - string to append
     * @param component - the component to change
     */
    public void appendText(String append, JTextField component) {
        component.setText(component.getText() + append);
    }

    /**
     * Appends text to a jTextField with a newline inbetween.
     *
     * @param append - string to append
     * @param component - the component to change
     */
    public void appendTextN(String append, JTextField component) {
        component.setText(component.getText() + "\n" + append);
    }

    // Declare jFrame objects
    JCheckBox jpgOption, mpOption, attOption;
    JButton bGo;
    JButton pspRootFileChooser, songFileChooser;
    ImageIcon logo, ezPortIcon;
    JLabel lEzPortIcon, loaded, logs, options, playlist, folder, root,
        jpgCover, mpCover, attCover;
    JTextField tfRoot, tfPlaylist, tfFolder;
    JTextArea taLogs;
    JScrollPane scrLogs, scrLoaded;
    JList<JPanel> loadedList;

    // Panels
    JPanel pAll, pHeader, pFooter, pContent, pInfo, 
		pLoaded, pLogs, pAttribute, 
		pChoices, pSongList, pAtt, pSong, pCover;

    // Needed booleans and vars
    static int something = 0;

    /**
     * Jframe method, sets content of jframe and formatting.
     */
    App() throws IOException {
        // Do everything here (set up the frame)
        setSize(scrnPerc(0.7, 1), scrnPerc(0.7, 0));

        // Set layout type here
        setLayout(new BorderLayout());
        setTitle("Ez-Port");
        setFocusable(false);
        setResizable(true);

        // Initialize components
        jpgOption = new JCheckBox();
        mpOption = new JCheckBox();
        attOption = new JCheckBox();

        bGo = new JButton("Import Playlist");

        pspRootFileChooser = new JButton("Choose ROOT");
        songFileChooser = new JButton("Choose Song File Folder");

        logo = new ImageIcon("");
        ezPortIcon = new ImageIcon("");

        lEzPortIcon = new JLabel("Icon goes Here.");
        loaded = new JLabel("Loaded songs...");
        logs = new JLabel("Logs");
        options = new JLabel("Options");
        playlist = new JLabel("Playlist directory");
        folder = new JLabel("Folder...");
        root = new JLabel("Root Folder directory");
        jpgCover = new JLabel("Convert cover format to jpg");
        mpCover = new JLabel("Convert song format to mp3");
        attCover = new JLabel("Change filename to title attribute");
        
        tfRoot = new JTextField("Enter root folder..");
        tfPlaylist = new JTextField("Enter playlist folder..");
        tfFolder = new JTextField("Enter folder directory...");

        taLogs = new JTextArea("Logs go here...");

        scrLogs = new JScrollPane(taLogs);
        scrLoaded = new JScrollPane();

        // Set component details
        jpgOption.setSelected(true);
        mpOption.setSelected(true);
        attOption.setSelected(true);

        bGo.setEnabled(false);



        taLogs.setEditable(false);
        taLogs.setRows(15);

        // Initialize panels
        pAll = new JPanel(new BorderLayout());
        pHeader = new JPanel(new BorderLayout());
        pFooter = new JPanel(new BorderLayout());
        pContent = new JPanel(new BorderLayout());
        pInfo = new JPanel(new GridLayout(9, 1));
        pLoaded = new JPanel(new BorderLayout());
        pLogs = new JPanel(new BorderLayout());
        pAttribute = new JPanel(new GridLayout(5, 1));
        pChoices = new JPanel(new GridLayout(1, 3));
		pSongList = new JPanel(new BorderLayout());
        pAtt = new JPanel(new BorderLayout());
        pSong = new JPanel(new BorderLayout());
        pCover = new JPanel(new BorderLayout());

		// Set attributes (CSS for this, maybe?)

		// Add to panels
		pAll.add(pHeader, BorderLayout.NORTH);
		pAll.add(pContent, BorderLayout.CENTER);
		pAll.add(pFooter, BorderLayout.SOUTH);

		pHeader.add(lEzPortIcon);
		
		pContent.add(pInfo, BorderLayout.WEST);
		pContent.add(pLoaded, BorderLayout.CENTER);
		pContent.add(pLogs, BorderLayout.EAST);

        pFooter.add(options, BorderLayout.NORTH);
        pFooter.add(pChoices, BorderLayout.CENTER);

		pInfo.add(playlist);
		pInfo.add(tfPlaylist);
		pInfo.add(folder);
		pInfo.add(tfFolder);
		pInfo.add(songFileChooser);
		pInfo.add(root);
		pInfo.add(tfRoot);
        pInfo.add(pspRootFileChooser);
        pInfo.add(bGo);

		pLoaded.add(loaded, BorderLayout.NORTH);

        pLogs.add(logs, BorderLayout.NORTH);
        pLogs.add(taLogs, BorderLayout.SOUTH);

        pAtt.add(attOption, BorderLayout.WEST);
        pAtt.add(attCover, BorderLayout.CENTER);
        
        pSong.add(mpOption, BorderLayout.WEST);
        pSong.add(mpCover, BorderLayout.CENTER);

        pCover.add(jpgOption, BorderLayout.WEST);
        pCover.add(jpgCover, BorderLayout.CENTER);
        
        pChoices.add(pAtt);
        pChoices.add(pSong);
        pChoices.add(pCover);

        pLoaded.add(scrLoaded);
        taLogs.add(scrLogs);

        add(pAll);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Last
		setVisible(true);
    }

    /**
     * Action performed, for when any event happens
     */
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) throws Exception {

        // Dont put anything here pretty much...
        new App();
    }
}
