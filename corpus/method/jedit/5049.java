//}}}
//{{{ getPreferredSize() method
@Override
public Dimension getPreferredSize() {
    Dimension d = super.getPreferredSize();
    if (shortcut != null) {
        FontMetrics fm = getFontMetrics(EnhancedMenuItem.acceleratorFont);
        d.width += (fm.stringWidth(shortcut) + fm.stringWidth("AAAA"));
    }
    return d;
}