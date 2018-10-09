protected void _init() {
    super._init();
    includeOptionsLink = new JCheckBox(jEdit.getProperty("options.context.includeOptionsLink.label"));
    includeOptionsLink.setSelected(jEdit.getBooleanProperty("options.context.includeOptionsLink"));
    addButton(includeOptionsLink);
}