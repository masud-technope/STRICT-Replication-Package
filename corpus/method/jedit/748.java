//{{{ paintBorder() method
public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    // paint the opposite icon of what the state is
    switch(state) {
        case STATE_COLLAPSED:
            EXPAND_ICON.paintIcon(c, g, x + level * LEVEL_WIDTH + 2, y + (height - EXPAND_ICON.getIconHeight()) / 2);
            break;
        case STATE_EXPANDED:
            COLLAPSE_ICON.paintIcon(c, g, x + level * LEVEL_WIDTH + 2, y + (height - COLLAPSE_ICON.getIconHeight()) / 2);
            break;
    }
//}}}
}