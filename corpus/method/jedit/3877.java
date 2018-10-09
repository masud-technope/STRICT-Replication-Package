@Override
public void ok() {
    DataFlavor flavor = (DataFlavor) flavorList.getSelectedValue();
    if (flavor == null) {
        flavor = DataFlavor.stringFlavor;
    }
    Registers.paste(textArea, '$', flavor);
    dispose();
}