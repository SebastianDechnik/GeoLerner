import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;


public class Zegar { 
    private int time = 15;
    private Timer timer;
    private CountdownListener countdownListener;

    public int getTime(){
        return time;
    }
    public Zegar(){
        
    }
    
    public void setCountdownListener(CountdownListener listener) {
        this.countdownListener = listener;
    }
    
 public void startCountdown(JLabel poleZegara) {
        
        timer = new Timer(1000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                time--;
                poleZegara.setText(time + "");
                if (time <= 0) {
                    ((Timer)e.getSource()).stop();   
                    if (countdownListener != null) {
                        countdownListener.onCountdownFinish();
                    } 
                }
                
            }
        });
        timer.start();  
    }
 
    public void stopCountdown(){
        timer.stop();
    }
    public void resetCountdown(JLabel poleZegara){
        timer.restart();
        timer.stop();
        time = 16;
        poleZegara.setText(" ");
    }

}
