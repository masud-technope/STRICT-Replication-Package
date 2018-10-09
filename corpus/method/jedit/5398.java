//}}}
//{{{ addFoldStyleChooser() method
private void addFoldStyleChooser() {
    painters = ServiceManager.getServiceNames(JEditTextArea.FOLD_PAINTER_SERVICE);
    foldPainter = new JComboBox<String>();
    String current = JEditTextArea.getFoldPainterName();
    int selected = 0;
    for (int i = 0; i < painters.length; i++) {
        String painter = painters[i];
        foldPainter.addItem(jEdit.getProperty("options.gutter.foldStyleNames." + painter, painter));
        if (painter.equals(current))
            selected = i;
    }
    foldPainter.setSelectedIndex(selected);
    addComponent(new JLabel(jEdit.getProperty("options.gutter.foldStyle.label")), foldPainter);
}