//}}}
//{{{ loadMode() method
/**
	 * Loads an XML-defined edit mode from the specified reader.
	 * @param mode The edit mode
	 */
/* package-private */
static void loadMode(Mode mode) {
    final String fileName = (String) mode.getProperty("file");
    XModeHandler xmh = new XModeHandler(mode.getName()) {

        @Override
        public void error(String what, Object subst) {
            String msg;
            Object line = "<unknown>";
            if (subst == null)
                msg = jEdit.getProperty("xmode-error." + what);
            else {
                msg = jEdit.getProperty("xmode-error." + what, new String[] { subst.toString() });
                if (subst instanceof Throwable)
                    Log.log(Log.ERROR, this, subst);
                if (subst instanceof SAXParseException) {
                    line = ((SAXParseException) subst).getLineNumber();
                }
            }
            Object[] args = { fileName, line, null, msg };
            GUIUtilities.error(null, "xmode-error", args);
        }

        @Override
        public TokenMarker getTokenMarker(String modeName) {
            Mode mode = getMode(modeName);
            if (mode == null)
                return null;
            else
                return mode.getTokenMarker();
        }
    };
    ModeProvider.instance.loadMode(mode, xmh);
}