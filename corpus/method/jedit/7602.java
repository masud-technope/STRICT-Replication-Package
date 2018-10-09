/**
	 * When <code>beepOnOutput</code> is set, every output going to standard
	 * error is signaled by a standard beep. This is intended for debugging
	 * purposes, to allow for immediate problem detection.
	 * @since jEdit 5.1pre1
	 */
public static void setBeepOnOutput(boolean beepOnOutput) {
    Log.beepOnOutput = beepOnOutput;
}