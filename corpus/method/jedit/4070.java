//{{{ getToolTipText() method
@Override
public String getToolTipText() {
    Runtime runtime = Runtime.getRuntime();
    long free = runtime.freeMemory();
    long total = runtime.totalMemory();
    long used = total - free;
    args[0] = (int) (used / 1024);
    args[1] = (int) (total / 1024);
    return jEdit.getProperty("view.status.memory-tooltip", args);
//}}}
}