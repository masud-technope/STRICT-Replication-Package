//}}}
//{{{ stop() method
/**
	 * Stops the animation, and resets to frame 0
	 */
public void stop() {
    current = 0;
    if (timer != null) {
        timer.stop();
        timer = null;
    }
    setImage(icon);
    host.repaint();
}