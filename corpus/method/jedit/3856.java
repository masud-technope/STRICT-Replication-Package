//{{{ layoutContainer() method
public void layoutContainer(Container parent) {
    Insets insets = ((JComponent) parent).getBorder().getBorderInsets(parent);
    Component[] comp = parent.getComponents();
    if (comp.length <= 2) {
        for (Component aComp : comp) aComp.setVisible(false);
        return;
    }
    comp[0].setVisible(true);
    comp[1].setVisible(true);
    Dimension dim = comp[2].getPreferredSize();
    if (position.equals(DockableWindowManagerImpl.TOP) || position.equals(DockableWindowManagerImpl.BOTTOM)) {
        int width = parent.getWidth() - insets.right;
        int rowHeight = Math.max(dim.height, closeBox.getPreferredSize().width);
        int x = (rowHeight << 1) + insets.left;
        int y = insets.top;
        closeBox.setBounds(insets.left, insets.top, rowHeight, rowHeight);
        menuBtn.setBounds(insets.left + rowHeight, insets.top, rowHeight, rowHeight);
        for (int i = 2; i < comp.length; i++) {
            int btnWidth = comp[i].getPreferredSize().width;
            if (btnWidth + x > width) {
                x = insets.left;
                y += rowHeight;
            }
            comp[i].setBounds(x, y, btnWidth, rowHeight);
            x += btnWidth;
        }
    /* if(y + rowHeight != parent.getHeight())
				{
					parent.setSize(
						parent.getWidth(),
						y + rowHeight);
					((JComponent)parent).revalidate();
				} */
    } else {
        int height = parent.getHeight() - insets.bottom;
        int colWidth = Math.max(dim.width, closeBox.getPreferredSize().height);
        int x = insets.left;
        int y = (colWidth << 1) + insets.top;
        closeBox.setBounds(insets.left, insets.top, colWidth, colWidth);
        menuBtn.setBounds(insets.left, insets.top + colWidth, colWidth, colWidth);
        for (int i = 2; i < comp.length; i++) {
            int btnHeight = comp[i].getPreferredSize().height;
            if (btnHeight + y > height) {
                x += colWidth;
                y = insets.top;
            }
            comp[i].setBounds(x, y, colWidth, btnHeight);
            y += btnHeight;
        }
    /* if(x + colWidth != parent.getWidth())
				{
					parent.setSize(x + colWidth,
						parent.getHeight());
					((JComponent)parent).revalidate();
				} */
    }
//}}}
}