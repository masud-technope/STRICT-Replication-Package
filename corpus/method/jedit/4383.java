public int compare(EditPlugin p1, EditPlugin p2) {
    return StandardUtilities.compareStrings(jEdit.getProperty("plugin." + p1.getClassName() + ".name"), jEdit.getProperty("plugin." + p2.getClassName() + ".name"), true);
}