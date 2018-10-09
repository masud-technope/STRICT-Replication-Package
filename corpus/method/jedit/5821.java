//}}}
//{{{ setStatus() method
/**
	 * This method is unused with the plugin manager.
	 *
	 * @param status the new status (it will be ignored)
	 * @since jEdit 4.3pre3
	 */
public void setStatus(String status) {
    SwingUtilities.invokeLater(() -> progress.setString(status));
}