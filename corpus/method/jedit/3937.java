@Override
public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    if (!jEdit.getProperty("view-registers.none").equals(value)) {
        char name = value.toString().charAt(0);
        String label;
        if (name == '\n')
            label = "\n";
        else if (name == '\t')
            label = "\t";
        else if (name == '$')
            label = jEdit.getProperty("view-registers.clipboard");
        else if (name == '%')
            label = jEdit.getProperty("view-registers.selection");
        else
            label = String.valueOf(name);
        Register register = Registers.getRegister(name);
        String registerValue;
        if (register == null) {
            // The register is not defined anymore, it has been removed before
            // the painting event
            registerValue = jEdit.getProperty("view-registers.undefined");
        } else {
            registerValue = register.toString();
            if (registerValue.length() > 100)
                registerValue = registerValue.substring(0, 100) + "...";
            registerValue = registerValue.replaceAll("\n", " ");
            registerValue = registerValue.replaceAll("\t", " ");
        }
        setText(label + " : " + registerValue);
    }
    return this;
}