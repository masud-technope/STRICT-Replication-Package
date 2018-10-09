// }}}
//{{{ createTextArea() method
/**
	 * Create a standalone TextArea.
	 * If you want to use it in jEdit, please use {@link JEditEmbeddedTextArea#JEditEmbeddedTextArea()}
	 *
	 * @return a textarea
	 * @since 4.3pre13
	 */
public static StandaloneTextArea createTextArea() {
    final Properties props = new Properties();
    props.putAll(loadProperties("/keymaps/jEdit_keys.props"));
    props.putAll(loadProperties("/org/gjt/sp/jedit/jedit.props"));
    StandaloneTextArea textArea = new StandaloneTextArea(new IPropertyManager() {

        public String getProperty(String name) {
            return props.getProperty(name);
        }
    });
    textArea.getBuffer().setProperty("folding", "explicit");
    return textArea;
}