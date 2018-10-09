//}}}
//{{{ setMessageComponent() method
public void setMessageComponent(Component comp) {
    currentMessageIsIO = false;
    if (comp == null || messageComp == comp) {
        return;
    }
    messageComp = comp;
    panel.add(BorderLayout.CENTER, messageComp);
}