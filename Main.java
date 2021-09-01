import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import com.thoughtworks.xstream.XStream;

public class Main {
    static String systemStyle;
    static File file;
    public static void main(String[] args) throws IOException{
        try {
            //here you can put the selected theme class name in JTattoo
            systemStyle = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) { }

        JFrame screen = new JFrame("Planner App!");
        screen.setResizable(false);
        screen.setLayout(new BorderLayout());
        screen.setSize(800,800);
        ArrayList<Task> tasks = new ArrayList<Task>();

        // sets up xstream to import data
        XStream xstream = new XStream();
        Class<?>[] classes = new Class[] { Task.class };
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        // read in previously created tasks stored in tasks.txt as xml data
        try {
            file = new File("tasks.txt");
        } catch (Exception a) { }
            FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        String storedTasks = new String(data, "UTF-8");
        /*
         * use xstream to convert xml text to Task objects that the application can process
         * try catch necessary to prevent errors when tasks.txt is empty
         */
        try{
            tasks = (ArrayList<Task>) (xstream.fromXML(storedTasks));
        } catch (Exception e) {}; 

        Time currentTime = new Time(1, 1, 3, 3, 2019);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel home = new Home(screen, tasks);
        home.setLayout(new BoxLayout(home, BoxLayout.PAGE_AXIS));
        JPanel cal = new Calendar(screen, tasks, currentTime);
        JPanel timer = new TimerScreen();
        JPanel settings = new Settings(screen, systemStyle);
        screen.setFont(new Font("Arial Light", Font.PLAIN, 22));
        tabbedPane.addTab("Home", home);
        tabbedPane.addTab("Calendar", cal);
        tabbedPane.addTab("Timer", timer);
        tabbedPane.addTab("Settings", settings);
        screen.add(tabbedPane);
        screen.setVisible(true);
    }
}
 