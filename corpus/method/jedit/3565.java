//{{{ FontSelectorDialog constructor
public  FontSelectorDialog(Frame parent, Font font) {
    super(parent, jEdit.getProperty("font-selector.title"), true);
    init(font);
}