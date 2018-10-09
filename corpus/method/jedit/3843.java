public int compare(AbstractButton o1, AbstractButton o2) {
    String name1 = o1.getActionCommand();
    String name2 = o2.getActionCommand();
    return StandardUtilities.compareStrings(jEdit.getProperty(name1 + ".title", ""), jEdit.getProperty(name2 + ".title", ""), true);
}