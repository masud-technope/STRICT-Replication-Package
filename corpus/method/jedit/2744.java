//}}}
//
//	//{{{ getIoTask() method
//	public IoTask getIoTask()
//	{
//		return ioTask;
//	} //}}}
//
//	//{{{ setIoTask() method
//	public void setIoTask(IoTask task)
//	{
//		assert(ioTask == null || ioTask != null && ioTask.getState() == StateValue.DONE);
//		this.ioTask = task;
//	} //}}}
//{{{ getAutoReloadDialog() method
/**
	 * @return the status of the AUTORELOAD_DIALOG flag
	 * If true, prompt for reloading or notify user
	 * when the file has changed on disk
	 */
public boolean getAutoReloadDialog() {
    return getFlag(AUTORELOAD_DIALOG);
}