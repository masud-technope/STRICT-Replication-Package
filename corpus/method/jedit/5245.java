//}}}
//{{{ Private members
//{{{ insertionSort() method
private void insertionSort(String newLabel, Object newObj) {
    if (sort) {
        for (int i = 0; i < members.size(); i++) {
            Object obj = members.elementAt(i);
            String label;
            if (obj instanceof OptionPane) {
                String name = ((OptionPane) obj).getName();
                label = jEdit.getProperty("options." + name + ".label", "NO LABEL PROPERTY: " + name);
            } else if (obj instanceof String) {
                label = jEdit.getProperty("options." + obj + ".label", "NO LABEL PROPERTY: " + obj);
            } else if (obj instanceof OptionGroup)
                label = ((OptionGroup) obj).getLabel();
            else
                throw new InternalError();
            if (newLabel.compareToIgnoreCase(label) < 0) {
                members.insertElementAt(newObj, i);
                return;
            }
        }
    }
    members.addElement(newObj);
}