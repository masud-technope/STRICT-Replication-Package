@Override
public Dimension getPreferredSize() {
    Dimension d = super.getPreferredSize();
    splitPane.setDividerLocation(browser.isHorizontalLayout() ? d.width + 3 : d.height + 3);
    return d;
}