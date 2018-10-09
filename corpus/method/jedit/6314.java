/**
	 * Creates a new search and replace dialog box.
	 * @param view The view
	 */
private  SearchDialog(View view) {
    super(view, jEdit.getProperty("search.title"), false);
    this.view = view;
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(new EmptyBorder(0, 12, 12, 12));
    setContentPane(content);
    JPanel centerPanel = new JPanel(new BorderLayout());
    centerPanel.add(BorderLayout.CENTER, createFieldPanel());
    centerPanel.add(BorderLayout.SOUTH, createSearchSettingsPanel());
    content.add(BorderLayout.CENTER, centerPanel);
    content.add(BorderLayout.SOUTH, createMultiFilePanel());
    content.add(BorderLayout.EAST, createButtonsPanel());
    setFocusTraversalPolicyProvider(true);
    focusOrder = new FocusOrder();
    initFocusOrder();
    setFocusTraversalPolicy(focusOrder);
    pack();
    jEdit.unsetProperty("search.width");
    jEdit.unsetProperty("search.d-width");
    jEdit.unsetProperty("search.height");
    jEdit.unsetProperty("search.d-height");
    GUIUtilities.loadGeometry(this, "search");
    load();
    EditBus.addToBus(this);
}