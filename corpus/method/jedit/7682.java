//{{{ getColorHexString() method
/**
	 * Converts a color object to its hex value. The hex value
	 * prefixed is with `#', for example `#ff0088'.
	 * @param c The color object
	 * @since jEdit 4.3pre13	 
	 */
public static String getColorHexString(Color c) {
    String mask = "#ff000000";
    String colString = Integer.toHexString(c.getRGB());
    return mask.substring(0, mask.length() - colString.length()).concat(colString);
}