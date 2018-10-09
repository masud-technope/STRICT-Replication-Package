//{{{ TextAreaDialog constructor
public  TextAreaDialog(Frame frame, String name, Throwable t) {
    this(frame, jEdit.getProperty(name + ".title"), jEdit.getProperty(name + ".message"), UIManager.getIcon("OptionPane.errorIcon"), MiscUtilities.throwableToString(t));
}