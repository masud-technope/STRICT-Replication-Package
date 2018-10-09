//}}}
//{{{ cancel() method
@Override
public void cancel() {
    if (currentPane != null)
        jEdit.setProperty(name + ".last", currentPane.getName());
    dispose();
}