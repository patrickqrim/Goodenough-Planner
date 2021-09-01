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
public class WeekView extends JPanel
{
    // instance variables - replace the example below with your own
    private int x;
    private ArrayList<Task> taskss;
    private Time current;

    private JList[] listt = new JList[7];
    private JPanel[] tasksbox = new JPanel[7];
    private JScrollPane[] scroller = new JScrollPane[7];

    private DefaultListModel[] listModel = new DefaultListModel[7];

    /**
     * Constructor for objects of class dayView
     */
    public WeekView(int a, int b,ArrayList<Task> tasks, Time t)
    {
        // initialise instance variables
        //setSize(800,800);
        setPreferredSize(new Dimension (a,b));
        taskss = tasks;
        current = t;

        JButton addTask = new JButton("Click to Refresh Tasks");
        add(addTask);
        addTask.addActionListener(new RefreshListener());

        for(int i = 0; i < 7; i++){
            listModel[i] = new DefaultListModel();
        }

        for(int i = 0; i < 7; i++){
            listModel[i].addElement("                              " + t.getDate(i) + ":");
            
            JList list = new JList(listModel[i]);
           
            listt[i] = list;
            listt[i].setDragEnabled(true);
            tasksbox[i] = new JPanel();
            scroller[i] = new JScrollPane(list);
            scroller[i].setAlignmentX(CENTER_ALIGNMENT);

            scroller[i].setPreferredSize(new Dimension(800,70));
            tasksbox[i].setLayout(new BoxLayout(tasksbox[i], BoxLayout.PAGE_AXIS));
            tasksbox[i].setPreferredSize(new Dimension(800,70));
            tasksbox[i].setMaximumSize(new Dimension(800,70));

            tasksbox[i].add(scroller[i]);
            add(tasksbox[i]);
        }

    }
    private class RefreshListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            for(int k = 0; k < 7; k++){
                for(int i = 0; i < taskss.size(); i++){
                    if(taskss.get(i).getStartTime().getDate().equals(current.getDate(k))){
                        boolean bool = true;
                        for(int j = 0; j < listModel[k].getSize(); j++){
                            if(listModel[k].getElementAt(j).equals("                              " + taskss.get(i).getName() + " : Start Time = " + taskss.get(i).getStartTime() + " ; End Time = " + taskss.get(i).getEndTime())){
                                bool = false;
                            }
                        }
                        if(bool){
                            listModel[k].addElement("                              " + taskss.get(i).getName() + " : Start Time = " + taskss.get(i).getStartTime() + " ; End Time = " + taskss.get(i).getEndTime());
                        }
                    }
                }
            }
        }
    }

}
