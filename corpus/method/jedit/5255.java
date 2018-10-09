//}}}
//{{{ addOptionPane() method
public void addOptionPane(String pane) {
    String label = jEdit.getProperty("options." + pane + ".label", "NO LABEL PROPERTY: " + pane);
    insertionSort(label, pane);
}