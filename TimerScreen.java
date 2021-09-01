import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TimerScreen extends JPanel
{
    private JLabel label;
    private long lastTickTime;
    private Timer timer;
    public TimerScreen() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        label = new JLabel(String.format("%02d:%02d:%02d.%03d", 0, 0, 0, 0));
        label.setFont(new Font("Arial", Font.PLAIN, 36));
        timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    long runningTime = System.currentTimeMillis() - lastTickTime;
                    Duration duration = Duration.ofMillis(runningTime);
                    long hours = duration.toHours();
                    duration = duration.minusHours(hours);
                    long minutes = duration.toMinutes();
                    duration = duration.minusMinutes(minutes);
                    long millis = duration.toMillis();
                    long seconds = millis / 1000;
                    millis -= (seconds * 1000);
                    label.setFont(new Font("Arial", Font.PLAIN, 36));
                    label.setText(String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, millis));
                }
            });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 10;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(4, 4, 4, 4);
        add(label, gbc);

        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!timer.isRunning()) {
                        lastTickTime = System.currentTimeMillis();
                        timer.start();
                    }
                }
            });
        JButton stop = new JButton("Stop");
        stop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timer.stop();
                }
            });

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(start, gbc);
        gbc.gridx++;
        add(stop, gbc);
    }

}
