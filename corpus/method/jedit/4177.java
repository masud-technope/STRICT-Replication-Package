//{{{ TaskCellRenderer constructor
private  TaskCellRenderer() {
    progress = new JProgressBar();
    button = new JButton(GUIUtilities.loadIcon(jEdit.getProperty("close-buffer.icon")));
    progress.setStringPainted(true);
//}}}
}