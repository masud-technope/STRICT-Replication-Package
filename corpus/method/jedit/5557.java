public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == alternateDockingLayout) {
        if (layout.getIcon() == layoutIcon1)
            layout.setIcon(layoutIcon2);
        else if (layout.getIcon() == layoutIcon2)
            layout.setIcon(layoutIcon1);
        else if (layout.getIcon() == layoutIcon3)
            layout.setIcon(layoutIcon4);
        else if (layout.getIcon() == layoutIcon4)
            layout.setIcon(layoutIcon3);
    } else if (evt.getSource() == alternateToolBarLayout) {
        if (layout.getIcon() == layoutIcon1)
            layout.setIcon(layoutIcon3);
        else if (layout.getIcon() == layoutIcon3)
            layout.setIcon(layoutIcon1);
        else if (layout.getIcon() == layoutIcon2)
            layout.setIcon(layoutIcon4);
        else if (layout.getIcon() == layoutIcon4)
            layout.setIcon(layoutIcon2);
    } else if (evt.getSource() == showBufferSwitcher) {
        bufferSwitcherMaxRowCount.setEditable(showBufferSwitcher.isSelected());
    }
}