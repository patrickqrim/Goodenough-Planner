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
public class MonthView extends JPanel
{
    // instance variables - replace the example below with your own
    private int x;
    private ArrayList<Task> taskss;
    private Time current;
    private int DAYS;

    private JList[] listt;
    private JPanel[] tasksbox;
    private JScrollPane[] scroller;
    private DefaultListModel[] listModel;

    /**
     * Constructor for objects of class dayView
     */
    public MonthView(int a, int b,ArrayList<Task> tasks, Time t)
    {
        switch(t.getMonth()){
            case 1: DAYS = 31; break;
            case 2: DAYS = 28; break;
            case 3: DAYS = 31; break;
            case 4: DAYS = 30; break;
            case 5: DAYS = 31; break;
            case 6: DAYS = 30; break;
            case 7: DAYS = 31; break;
            case 8: DAYS = 31; break;
            case 9: DAYS = 30; break;
            case 10: DAYS = 31; break;
            case 11: DAYS = 30; break;
            case 12: DAYS = 31; break;
            default: DAYS = 1; break;
        }

        listt = new JList[DAYS];
        tasksbox = new JPanel[DAYS];
        scroller = new JScrollPane[DAYS];
        listModel = new DefaultListModel[DAYS];

        // initialise instance variables
        //setSize(800,800);
        setPreferredSize(new Dimension (a,b));
        taskss = tasks;
        current = t;

        JButton addTask = new JButton("Click to Refresh Tasks");
        addTask.setPreferredSize(new Dimension(670,40));
        add(addTask);
        addTask.addActionListener(new RefreshListener());

        setLayout(new FlowLayout(FlowLayout.LEFT));

        for(int i = 0; i < DAYS; i++){
            listModel[i] = new DefaultListModel();
        }

        for(int i = 0; i < DAYS; i++){
            listModel[i].addElement("   " + t.getDate(i-t.getDay()+1) + ":");

            JList list = new JList(listModel[i]);

            listt[i] = list;
            listt[i].setDragEnabled(true);
            tasksbox[i] = new JPanel();
            scroller[i] = new JScrollPane(list);
            scroller[i].setAlignmentX(CENTER_ALIGNMENT);

            scroller[i].setPreferredSize(new Dimension(90,80));
            tasksbox[i].setLayout(new BoxLayout(tasksbox[i], BoxLayout.PAGE_AXIS));
            tasksbox[i].setPreferredSize(new Dimension(90,80));
            tasksbox[i].setMaximumSize(new Dimension(90,80));

            tasksbox[i].add(scroller[i]);
            add(tasksbox[i]);
        }

    }
    private class RefreshListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            for(int k = 0; k < DAYS; k++){
                for(int i = 0; i < taskss.size(); i++){
                    if(taskss.get(i).getStartTime().getDate().equals(current.getDate(k-current.getDay()+1))){
                        boolean bool = true;
                        for(int j = 0; j < listModel[k].getSize(); j++){
                            if(listModel[k].getElementAt(j).equals("          " + taskss.get(i).getName())){
                                bool = false;
                            }
                        }
                        if(bool){
                            listModel[k].addElement("          " + taskss.get(i).getName());
                        }
                    }
                }
            }
        }
    }

}
