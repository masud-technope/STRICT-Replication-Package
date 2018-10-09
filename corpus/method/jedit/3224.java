//}}}
//{{{ removeLayoutComponent() method
public void removeLayoutComponent(Component comp) {
    if (center == comp)
        center = null;
    else if (comp == top)
        top = null;
    else if (comp == left)
        left = null;
    else if (comp == bottom)
        bottom = null;
    else if (comp == right)
        right = null;
}