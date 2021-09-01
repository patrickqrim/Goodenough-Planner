import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import com.thoughtworks.xstream.XStream;

public class Home extends JPanel {
    private ArrayList<Task> tasks;
    private DefaultListModel listModel = new DefaultListModel();
    public Home(JFrame f, ArrayList<Task> t)  throws IOException{
        tasks = t;
        JButton addTask = new JButton("Click to Add Task");
        addTask.setPreferredSize(new Dimension(670,40));
        add(addTask);
        addTask.addActionListener(new addTaskListener());

        listModel.addElement("Eat");
        listModel.addElement("Sleep");
        listModel.addElement("Do HW");
        JList list = new JList(listModel);
        list.setDragEnabled(true);

        JPanel tasksbox = new JPanel();
        JScrollPane scroller = new JScrollPane(list);
        scroller.setAlignmentX(LEFT_ALIGNMENT); 

        scroller.setPreferredSize(new Dimension(800,100));
        tasksbox.setLayout(new BoxLayout(tasksbox, BoxLayout.PAGE_AXIS));
        tasksbox.setPreferredSize(new Dimension(800,100));
        tasksbox.setMaximumSize(new Dimension(800,100));

        tasksbox.add(scroller);
        add(tasksbox);

    }
    private class addTaskListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            String taskName = JOptionPane.showInputDialog("Enter Name of Task");
            int startHour = Integer.parseInt(JOptionPane.showInputDialog("Enter Start Hour (24 hour time)"));
            int startMinute = Integer.parseInt(JOptionPane.showInputDialog("Enter Start Minute (24 hour time)"));
            int endHour = Integer.parseInt(JOptionPane.showInputDialog("Enter End Hour (24 hour time)"));
            int endMinute = Integer.parseInt(JOptionPane.showInputDialog("Enter End Minute (24 hour time)"));
            int startDay = Integer.parseInt(JOptionPane.showInputDialog("Enter Start Day"));
            int startMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter Start Month"));
            int startYear = Integer.parseInt(JOptionPane.showInputDialog("Enter Start Year"));
            int endDay = Integer.parseInt(JOptionPane.showInputDialog("Enter End Day"));
            int endMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter End Month"));
            int endYear = Integer.parseInt(JOptionPane.showInputDialog("Enter End Year"));
            listModel.addElement(taskName);
            Time startTime = new Time(startHour, startMinute, startDay, startMonth, startYear);
            Time endTime = new Time(endHour, endMinute, endDay, endMonth, endYear);
            // add a new task to the list of tasks
            tasks.add(new Task(taskName, startTime,endTime));

            /* convert the Task object to XML to be stored in tasks.txt
             * try catch required to catch errors (primarily IOException)
             */
            XStream xstream = new XStream();
            try{
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tasks.txt")));
                out.println(xstream.toXML(tasks));
                out.close();
            } catch (Exception exception) {}

        }
    }

}