//}}}
//{{{ handlePropertiesChanged() method
@EBHandler
public void handlePropertiesChanged(PropertiesChanged msg) {
    painter.setLineExtraSpacing(jEdit.getIntegerProperty("options.textarea.lineSpacing", 0));
}