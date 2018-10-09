//}}}
//{{{ setSelectedColor() method
public void setSelectedColor(Color color) {
    ((ColorWell) getIcon()).color = color;
    repaint();
    fireStateChanged();
}