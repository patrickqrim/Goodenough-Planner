import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * The Settings Class sets up a JPanel that allows users to select preferences for the application
 *
 * @author Benjamin Liu
 */
public class Settings extends JPanel
{
    private JComboBox styleList;
    private String[] styles;
    private JFrame frame;
    /**
     * Settings Constructor
     * Creates a color scheme picker using a dropdown list (JComboBox)
     * @param screen A parameter
     * @param s A parameter
     */
    public Settings(JFrame screen, String s) {
        frame = screen;
        JLabel styleLabel = new JLabel("Theme:");
        // creates an array of available styles
        String[] styles = { s,
                "com.jtattoo.plaf.texture.TextureLookAndFeel",
                "com.jtattoo.plaf.smart.SmartLookAndFeel",
                "com.jtattoo.plaf.noire.NoireLookAndFeel",
                "com.jtattoo.plaf.acryl.AcrylLookAndFeel",
                "com.jtattoo.plaf.aero.AeroLookAndFeel",
                "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel",
                "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel",
                "com.jtattoo.plaf.fast.FastLookAndFeel",
                "com.jtattoo.plaf.graphite.GraphiteLookAndFeel",
                "com.jtattoo.plaf.hifi.HiFiLookAndFeel",
                "com.jtattoo.plaf.mcwin.McWinLookAndFeel",
                "com.jtattoo.plaf.mint.MintLookAndFeel"
            }; 


        // puts the array into a dropdown menu the user can select from
        JComboBox styleList = new JComboBox(styles);
        styleList.setSelectedIndex(0);
        styleList.addActionListener(new ListListener());
        add(styleLabel);
        add(styleList);
    }
    private class ListListener implements ActionListener{
        /**
         * Method actionPerformed
         * Sets the color theme (LookAndFeel) of GUI after a selection is made in the dropdown list
         * @param e A parameter
         */
        public void actionPerformed(ActionEvent e){
            JComboBox cb = (JComboBox)e.getSource();
            try {
                // refresh all components to reflect change in theme
                UIManager.setLookAndFeel((String) cb.getSelectedItem());
                SwingUtilities.updateComponentTreeUI(frame);
            } catch (Exception ex) { }
        }
    }
}
