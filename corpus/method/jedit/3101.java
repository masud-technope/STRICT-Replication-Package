//}}}
//{{{ start() method
/**
	 * Starts the animation rolling
	 */
public void start() {
    if (timer != null)
        return;
    timer = new Timer(delay, new Animator());
    timer.start();
}