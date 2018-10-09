//}}}
//{{{ getPreferredSize() method
/**
	 * Returns the painter's preferred size.
	 */
@Override
public Dimension getPreferredSize() {
    Dimension dim = new Dimension();
    char[] foo = new char[80];
    for (int i = 0; i < foo.length; i++) foo[i] = ' ';
    dim.width = (int) getStringWidth(new String(foo));
    dim.height = getLineHeight() * 25;
    return dim;
}