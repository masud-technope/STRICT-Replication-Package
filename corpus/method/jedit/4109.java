@Override
public void update() {
    int count = TaskManager.instance.countTasks();
    if (count == 0) {
        setIcon(null);
        setText(null);
    } else {
        synchronized (messageFormat) {
            setIcon(GUIUtilities.loadIcon("loader.gif"));
            args[0] = count;
            setText(messageFormat.format(args, stringBuffer, fieldPosition).toString());
            stringBuffer.setLength(0);
        }
    }
}