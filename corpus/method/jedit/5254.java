//}}}
//{{{ addOptionPane() method
public void addOptionPane(OptionPane pane) {
    String label = jEdit.getProperty("options." + pane.getName() + ".label", "NO LABEL PROPERTY: " + pane.getName());
    insertionSort(label, pane);
}