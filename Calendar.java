import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

/**
 * Write a description of class Calendar here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calendar extends JPanel
{
    public Calendar(JFrame s, ArrayList<Task> tasks, Time t) {
        int x = s.getWidth() - 100, y = s.getHeight() - 100;

        setSize(x, y);
        setPreferredSize(new Dimension (x, y));
        JFrame j = new JFrame();
        JTabbedPane calendarScreen = new JTabbedPane();
        JPanel day = new DayView(x,y,tasks,t);
        JPanel week = new WeekView(x,y, tasks, t); // set week and month view extend panel later
        JPanel month = new MonthView(x,y, tasks, t);

        calendarScreen.addTab("Today", day);
        calendarScreen.addTab("This Week", week);
        calendarScreen.addTab("This Month", month);

        // maybe implement dynamic resize not sure if in this class
        // addComponentListener(new ComponentAdapter() {
        // public void componentResized(ComponentEvent e) {
        // setSize(x-y
        // }
        // });

        add(calendarScreen);
    }

}
