//}}}
//{{{ _init() method
@Override
protected void _init() {
    //{{{ Large file mode
    addSeparator("options.editing.largefilemode.title");
    String labelText = jEdit.getProperty("options.editing.largefilemode", new Object[] { jEdit.getIntegerProperty("largeBufferSize"), jEdit.getIntegerProperty("longLineLimit") });
    JLabel titleLabel = new JLabel(labelText);
    titleLabel.setToolTipText(jEdit.getProperty("options.editing.largefilemode.tooltip"));
    addComponent(titleLabel);
    addComponent(askLargeFileMode = new JRadioButton(jEdit.getProperty("options.editing.largefilemode.option.ask")));
    addComponent(fullSyntaxLargeFileMode = new JRadioButton(jEdit.getProperty("options.editing.largefilemode.option.full")));
    addComponent(limitedSyntaxLargeFileMode = new JRadioButton(jEdit.getProperty("options.editing.largefilemode.option.limited")));
    addComponent(noHighlightLargeFileMode = new JRadioButton(jEdit.getProperty("options.editing.largefilemode.option.nohighlight")));
    String option = jEdit.getProperty("largefilemode", "ask");
    if ("full".equals(option)) {
        fullSyntaxLargeFileMode.setSelected(true);
    } else if ("limited".equals(option)) {
        limitedSyntaxLargeFileMode.setSelected(true);
    } else if ("nohighlight".equals(option)) {
        noHighlightLargeFileMode.setSelected(true);
    } else {
        askLargeFileMode.setSelected(true);
    }
    ButtonGroup largeFileModeButtonGroup = new ButtonGroup();
    largeFileModeButtonGroup.add(askLargeFileMode);
    largeFileModeButtonGroup.add(fullSyntaxLargeFileMode);
    largeFileModeButtonGroup.add(limitedSyntaxLargeFileMode);
    largeFileModeButtonGroup.add(noHighlightLargeFileMode);
//}}}
}