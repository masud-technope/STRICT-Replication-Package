//{{{ FontSelectorDialog constructor
 FontSelectorDialog(Frame parent, Font font, FontSelector fontSelector) {
    super(parent, jEdit.getProperty("font-selector.title"), true);
    this.fontSelector = fontSelector;
    init(font);
}