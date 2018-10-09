//{{{ record() method
public void record(String code) {
    if (BeanShell.isScriptRunning())
        return;
    flushInput();
    append("\n");
    append(code);
//}}}
}