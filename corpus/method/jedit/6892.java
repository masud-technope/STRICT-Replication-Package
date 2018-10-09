//{{{ addLayoutComponent() method
/**
 	 * Adds a component to the layout using the <code>name</code> parameter to
 	 * position the component.
 	 * @param name One of CENTER, RIGHT, LEFT, BOTTOM, TOP, TOP_LEFT, TOP_RIGHT, 
 	 * BOTTOM_LEFT, BOTTOM_RIGHT.
 	 * @param comp The component to add at the given position. If <code>null</code>, the 
 	 * component will be removed from that position.
 	 */
public void addLayoutComponent(String name, Component comp) {
    switch(name) {
        case CENTER:
            center = comp;
            break;
        case RIGHT:
            right = comp;
            break;
        case LEFT:
            left = comp;
            break;
        case BOTTOM:
            bottom = comp;
            break;
        case TOP:
            top = comp;
            break;
        case TOP_LEFT:
            topLeft = comp;
            break;
        case TOP_RIGHT:
            topRight = comp;
            break;
        case BOTTOM_LEFT:
            bottomLeft = comp;
            break;
        case BOTTOM_RIGHT:
            bottomRight = comp;
            break;
    }
}