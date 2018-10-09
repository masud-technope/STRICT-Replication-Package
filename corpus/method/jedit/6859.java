//}}}
//{{{ getActionForEvent() method
public String getActionForEvent(MouseEvent evt, String variant) {
    String modStr = KeyEventTranslator.getModifierString(evt);
    if (modStr == null) {
        return propertyManager.getProperty("view." + name + '.' + variant + "Click");
    } else {
        return propertyManager.getProperty("view." + name + '.' + KeyEventTranslator.getModifierString(evt) + variant + "Click");
    }
}