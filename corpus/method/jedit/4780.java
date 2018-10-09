//}}}
//{{{ showMemoryDialog() method
/**
	 * Performs garbage collection and displays a dialog box showing
	 * memory status.
	 * @param view The view
	 * @since jEdit 4.0pre1
	 */
public static void showMemoryDialog(View view) {
    Runtime rt = Runtime.getRuntime();
    long usedBefore = rt.totalMemory() - rt.freeMemory();
    System.gc();
    long free = rt.freeMemory();
    long total = rt.totalMemory();
    long used = total - free;
    int totalKb = (int) (total / 1024);
    int usedKb = (int) (used / 1024);
    JProgressBar progress = new JProgressBar(0, totalKb);
    progress.setValue(usedKb);
    progress.setStringPainted(true);
    progress.setString(jEdit.getProperty("memory-status.use", new Object[] { usedKb, totalKb }));
    Object[] message = new Object[4];
    message[0] = getProperty("memory-status.gc", new Object[] { (usedBefore - used) / 1024 });
    message[1] = Box.createVerticalStrut(12);
    message[2] = progress;
    message[3] = Box.createVerticalStrut(6);
    JOptionPane.showMessageDialog(view, message, jEdit.getProperty("memory-status.title"), JOptionPane.INFORMATION_MESSAGE);
}