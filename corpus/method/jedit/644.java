//{{{ setInterval() method
public static void setInterval(int interval) {
    if (interval == 0) {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
        return;
    }
    interval *= 1000;
    if (timer == null) {
        timer = new Timer(interval, new Autosave());
        timer.start();
    } else
        timer.setDelay(interval);
}