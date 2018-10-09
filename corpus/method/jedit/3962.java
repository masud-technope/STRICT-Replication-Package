//}}}
//{{{ setEnabled() method
public void setEnabled(boolean b) {
    super.setEnabled(b);
    setBorderPainted(true);
    repaint();
}