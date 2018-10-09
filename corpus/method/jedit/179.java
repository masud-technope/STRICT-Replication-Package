/***************************************************************************
	 * Private utility methods.
	 **************************************************************************/
private void setExecutable(File f) {
    Chmod chmodTask = new Chmod();
    chmodTask.setProject(getProject());
    chmodTask.setFile(f);
    chmodTask.setPerm("ugo+rx");
    if (mVerbose)
        log("Setting \"" + bundlePath(f) + "\" to executable");
    chmodTask.execute();
}