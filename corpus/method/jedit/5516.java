//{{{ addStyleChoice() method
private void addStyleChoice(String label, String property) {
    Font font = new JLabel().getFont();
    styleChoices.add(new StyleChoice(label, property, SyntaxUtilities.parseStyle(jEdit.getProperty(property), font.getFamily(), font.getSize(), true)));
//}}}
}