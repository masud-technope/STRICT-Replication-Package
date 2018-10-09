//}}}
//{{{ propertiesChanged() method
/**
	 * Reload internal configuration based on the given properties.
	 *
	 * @param	props	Configuration properties.
	 *
	 * @since jEdit 4.4pre1
	 */
public static void propertiesChanged(IPropertyManager props) {
    fontSubstList = null;
    if (props == null) {
        fontSubstEnabled = false;
        fontSubstSystemFontsEnabled = true;
        preferredFonts = null;
    } else {
        fontSubstEnabled = Boolean.parseBoolean(props.getProperty("view.enableFontSubst"));
        fontSubstSystemFontsEnabled = Boolean.parseBoolean(props.getProperty("view.enableFontSubstSystemFonts"));
    }
    List<Font> userFonts = new ArrayList<Font>();
    String family;
    int i = 0;
    if (props != null) {
        while ((family = props.getProperty("view.fontSubstList." + i)) != null) {
            /*
				 * The default font is Font.DIALOG if the family
				 * doesn't match any installed fonts. The following
				 * check skips fonts that don't exist.
				 */
            Font f = Font.decode(props.getProperty("view.fontSubstList." + i));
            if (f != null && (!"dialog".equalsIgnoreCase(f.getFamily()) || "dialog".equalsIgnoreCase(family)))
                userFonts.add(f);
            i++;
        }
    }
    preferredFonts = userFonts.toArray(new Font[userFonts.size()]);
    // Clear cache, not to hold reference to old fonts which
    // might become unused after properties changed.
    glyphCache = null;
}