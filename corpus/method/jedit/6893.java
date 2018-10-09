//}}}
//{{{ removeLayoutComponent() method
/**
 	 * Removes the specified component from the layout.
 	 * @param comp The component to be removed.
 	 */
public void removeLayoutComponent(Component comp) {
    if (center == comp)
        center = null;
    else if (right == comp)
        right = null;
    else if (left == comp)
        left = null;
    else if (bottom == comp)
        bottom = null;
    else if (top == comp)
        top = null;
    else if (topLeft == comp)
        topLeft = null;
    else if (topRight == comp)
        topRight = null;
    else if (bottomLeft == comp)
        bottomLeft = null;
    else if (bottomRight == comp)
        bottomRight = null;
}