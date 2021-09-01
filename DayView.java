import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

/**
 * Write a description of class dayView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DayView extends JPanel
{
    // instance variables - replace the example below with your own
    private int x;
    private ArrayList<Task> taskss;
    private Time current;
    private JList listt;
    private JPanel tasksbox;
    private JScrollPane scroller;
    private DefaultListModel listModel = new DefaultListModel();
    /**
     * Constructor for objects of class dayView
     */
    public DayView(int a, int b,ArrayList<Task> tasks, Time t)
    {
        // initialise instance variables
        //setSize(800,800);
        setPreferredSize(new Dimension (a,b));
        taskss = tasks;
        current = t;

        JButton addTask = new JButton("Click to Refresh Tasks");
        add(addTask);
        addTask.addActionListener(new RefreshListener());

        JList list = new JList(listModel);
        listt = list;
        listt.setDragEnabled(true);
        tasksbox = new JPanel();
        scroller = new JScrollPane(list);
        scroller.setAlignmentX(CENTER_ALIGNMENT); 

        scroller.setPreferredSize(new Dimension(800,100));
        tasksbox.setLayout(new BoxLayout(tasksbox, BoxLayout.PAGE_AXIS));
        tasksbox.setPreferredSize(new Dimension(800,100));
        tasksbox.setMaximumSize(new Dimension(800,100));

        tasksbox.add(scroller);
        add(tasksbox);
    }
    private class RefreshListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            for(int i = 0; i < taskss.size(); i++){
                if(taskss.get(i).getStartTime().getDate().equals(current.getDate())){
                    boolean bool = true;
                    for(int j = 0; j < listModel.getSize(); j++){
                        if(listModel.getElementAt(j).equals("                              " + taskss.get(i).getName() + " : Start Time = " + taskss.get(i).getStartTime() + " ; End Time = " + taskss.get(i).getEndTime())){
                            bool = false;
                        }
                    }
                    if(bool){
                        listModel.addElement("                              " + taskss.get(i).getName() + " : Start Time = " + taskss.get(i).getStartTime() + " ; End Time = " + taskss.get(i).getEndTime());
                    }
                }
            }

        }
    }

}
