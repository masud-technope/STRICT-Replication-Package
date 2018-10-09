//{{{ FontSelectorDialog constructor
public  FontSelectorDialog(Dialog parent, Font font) {
    super(parent, jEdit.getProperty("font-selector.title"), true);
    init(font);
}