public  GlobalOptionGroup(OptionGroup rootGroup) {
    super("Global Options");
    root = rootGroup;
    String optionGroups = jEdit.getProperty("options.groups", "jedit browser");
    String[] groups = optionGroups.split(" ");
    for (String group : groups) {
        OptionGroup optionGroup = new OptionGroup(group);
        String paneList = "options.group." + group;
        String def = "";
        if ("jedit".equals(group)) {
            def = "general abbrevs appearance context docking editing encodings gutter mouse " + "plugin-manager print firewall save-back shortcuts status syntax textarea " + "toolbar view";
        } else if ("browser".equals(group)) {
            def = "browser.general browser.colors";
        }
        String optionPanes = jEdit.getProperty(paneList, def);
        String[] panes = optionPanes.split(" ");
        for (String pane : panes) {
            optionGroup.addOptionPane(pane);
        }
        addGroup(optionGroup);
    }
}