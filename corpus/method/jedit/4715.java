//}}}
//{{{ getColor() method
/**
	 * Returns the color that will be used to display the file.
	 *
	 * @return the color of the file
	 */
public Color getColor() {
    if (!colorCalculated) {
        colorCalculated = true;
        color = VFS.getDefaultColorFor(name);
    }
    return color;
}