//}}}
//{{{ copyToolTips() method
private static void copyToolTips(Component c1, Component c2) {
    if (!(c1 instanceof JComponent) || !(c2 instanceof JComponent))
        return;
    JComponent jc1 = (JComponent) c1;
    String tooltip = jc1.getToolTipText();
    int tooltips = 0;
    if (tooltip != null && !tooltip.isEmpty())
        tooltips++;
    JComponent jc2 = (JComponent) c2;
    String tooltip2 = jc2.getToolTipText();
    if (tooltip2 != null && !tooltip2.isEmpty()) {
        tooltip = tooltip2;
        tooltips++;
    }
    //     nothing
    if (tooltips == 1) {
        jc1.setToolTipText(tooltip);
        jc2.setToolTipText(tooltip);
    }
}