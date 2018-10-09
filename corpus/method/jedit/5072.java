//{{{ getPreferredSize() method
public Dimension getPreferredSize() {
    Dimension d = super.getPreferredSize();
    String shortcut = getShortcut();
    if (shortcut != null) {
        FontMetrics fm = getFontMetrics(acceleratorFont);
        d.width += (fm.stringWidth(shortcut) + fm.stringWidth("AAAA"));
    }
    return d;
//}}}
}