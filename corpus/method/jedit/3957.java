//}}}
//{{{ setEnabled() method
public void setEnabled(boolean b) {
    super.setEnabled(b);
    setBorderPainted(false);
    repaint();
}