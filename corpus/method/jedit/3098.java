/**
	 * @param frames The frames to be used in the animation
	 * @param rate The frame rate of the animation, in frames per second
	 * @param host The container that the animation is used in
	 */
public  AnimatedIcon(Image icon, Image[] frames, int rate, Component host) {
    super(icon);
    this.icon = icon;
    this.frames = frames;
    delay = 1000 / rate;
    this.host = host;
}