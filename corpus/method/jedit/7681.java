//}}}
//{{{ parseColor() method
/**
	 * @since jEdit 4.3pre13
	 */
public static Color parseColor(String name, Color defaultColor) {
    if (name == null || name.length() == 0)
        return defaultColor;
    name = name.trim();
    if (name.charAt(0) == '#') {
        try {
            name = name.substring(1);
            if (name.length() == 6)
                name = "ff" + name;
            BigInteger bi = new BigInteger(name, 16);
            return new Color(bi.intValue(), true);
        } catch (NumberFormatException nf) {
            return defaultColor;
        }
    } else if ("red".equals(name))
        return Color.red;
    else if ("green".equals(name))
        return Color.green;
    else if ("blue".equals(name))
        return Color.blue;
    else if ("yellow".equals(name))
        return Color.yellow;
    else if ("orange".equals(name))
        return Color.orange;
    else if ("white".equals(name))
        return Color.white;
    else if ("lightGray".equals(name))
        return Color.lightGray;
    else if ("gray".equals(name))
        return Color.gray;
    else if ("darkGray".equals(name))
        return Color.darkGray;
    else if ("black".equals(name))
        return Color.black;
    else if ("cyan".equals(name))
        return Color.cyan;
    else if ("magenta".equals(name))
        return Color.magenta;
    else if ("pink".equals(name))
        return Color.pink;
    else
        return defaultColor;
}