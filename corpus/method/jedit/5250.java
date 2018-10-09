/**
	 * Creates an option group.
	 * @param label The label
	 * @param options A whitespace-separated list of option pane names
	 * @since jEdit 4.2pre2
	 */
public  OptionGroup(String name, String label, String options) {
    this.name = name;
    this.label = label;
    members = new Vector<Object>();
    StringTokenizer st = new StringTokenizer(options);
    while (st.hasMoreTokens()) {
        String pane = st.nextToken();
        addOptionPane(pane);
    }
}