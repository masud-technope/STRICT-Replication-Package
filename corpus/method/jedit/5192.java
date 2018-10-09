/**
	 * Cancels the exit process. If a plugin calls this method, jEdit will not
	 * exit anymore
	 */
public void cancelExit() {
    hasBeenExitCancelled = true;
}