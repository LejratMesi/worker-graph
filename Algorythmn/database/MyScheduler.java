package Algorythmn.database;


import java.util.Timer;
import java.util.TimerTask;


public class MyScheduler extends PrezencaPunonjesve {
    public void scheduleTask() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Llogaritja();
            }
        };


        long delay = calculateDelay();
        long period = 24 * 60 * 60 * 1000;
        timer.schedule(task, delay, period);
    }

    private long calculateDelay() {

        long now = System.currentTimeMillis();
        long midnight = ((now / (24 * 60 * 60 * 1000)) * (24 * 60 * 60 * 1000)) + (12 * 60 * 60 * 1000);
        if (midnight < now) {
            midnight += 24 * 60 * 60 * 1000;
        }
        return midnight - now;
    }

    public static void main(String[] args) {
        MyScheduler scheduler = new MyScheduler();
        scheduler.scheduleTask();
        Llogaritja();
    }
}
