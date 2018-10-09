public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == add) {
        JDialog parent = GenericGUIUtilities.getParentDialog(this);
        Font selected = new FontSelectorDialog(parent, null).getSelectedFont();
        if (selected != null) {
            fontsModel.addElement(selected);
            fonts.setSelectedIndex(fontsModel.size() - 1);
        }
    } else if (ae.getSource() == remove) {
        int idx = fonts.getSelectedIndex();
        if (idx != -1)
            fontsModel.removeElementAt(idx);
    } else if (ae.getSource() == up) {
        int idx = fonts.getSelectedIndex();
        if (idx > 0) {
            Font font = fontsModel.getElementAt(idx);
            fontsModel.removeElementAt(idx);
            fontsModel.add(idx - 1, font);
            fonts.setSelectedIndex(idx - 1);
        }
    } else if (ae.getSource() == down) {
        int idx = fonts.getSelectedIndex();
        if (idx != -1 && idx < fontsModel.size() - 1) {
            Font font = fontsModel.getElementAt(idx);
            fontsModel.removeElementAt(idx);
            fontsModel.add(idx + 1, font);
            fonts.setSelectedIndex(idx + 1);
        }
    }
}