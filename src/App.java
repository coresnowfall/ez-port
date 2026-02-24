
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

    /**
     * Loads in a folder full of songs using Song struct.
     */
    public Song[] loadFolder(String folderName) {

    }

    /**
     * Create loadedList
     */
    public JList<Janel> makeList(Song songs[]) {
        
    }

    // Declare jFrame objects
    JCheckBox jpgOption, mpOption, attOption;
    JButton bGo;
    JFileChooser pspRootFileChooser, songFileChooser;
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
		pChoices, pSongList;

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
        setResizable(false);

        // Initialize components


        // Initialize panels
        pAll = new JPanel(new BorderLayout());
        pHeader = new JPanel(new BorderLayout());
        pFooter = new JPanel(new BorderLayout());
        pContent = new JPanel(new BorderLayout());
        pInfo = new JPanel(new GridLayout(9, 1));
        pLoaded = new JPanel(new BorderLayout());
        pLogs = new JPanel(new BorderLayout());
        pAttribute = new JPanel(new GridLayout(5, 1));
        pChoices = new JPanel(new GridLayout(2, 3));
		pSongList = new JPanel(new BorderLayout());

		// Set attributes (CSS for this, maybe?)

		// Add to panels
		pAll.add(pHeader, "North");
		pAll.add(pContent, "Center");
		pAll.add(pFooter, "South");

		pHeader.add(lEzPortIcon);
		
		pContent.add(pInfo, "West");
		pContent.add(pLoaded, "Center");
		pContent.add(pLogs, "East");

        pFooter.add(options, "North");
        pFooter.add(pChoices, "South");

		pInfo.add(playlist);
		pInfo.add(tfPlaylist);
		pInfo.add(folder);
		pInfo.add(tfFolder);
		pInfo.add(songFileChooser);
		pInfo.add(root);
		pInfo.add(tfRoot);
        pInfo.add(pspRootFileChooser);
        pInfo.add(bGo);

		pLoaded.add(loaded, "North");
		pLoaded.add(pLoaded, "North");

        pLogs.add(logs, "North");
        pLogs.add(taLogs, "South");
        
        pChoices.add(jpgOption);
        pChoices.add(jpgCover);
        pChoices.add(mpOption);
        pChoices.add(mpCover);
        pChoices.add(attOption);
        pChoices.add(attCover);

        pLoaded.add(loadedList);
        pLoaded.add(scrLoaded);

        taLogs.add(scrLogs);

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
        System.out.println("Running...");
        new App();
    }
}
