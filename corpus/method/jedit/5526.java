public void save() {
    Font f;
    int i = 0;
    while ((f = jEdit.getFontProperty("view.fontSubstList." + i)) != null) {
        jEdit.unsetProperty("view.fontSubstList." + i);
        i++;
    }
    for (i = 0; i < fontsModel.size(); i++) {
        f = (Font) fontsModel.getElementAt(i);
        jEdit.setFontProperty("view.fontSubstList." + i, f);
    }
}