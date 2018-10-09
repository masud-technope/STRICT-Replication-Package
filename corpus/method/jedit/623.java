//}}}
//{{{ endElement() method
@Override
@SuppressWarnings({ "unchecked" })
public void endElement(String uri, String localName, String qName) {
    String tag = peekElement();
    if (qName.equals(tag)) {
        if (tag.equals("ACTION")) {
            String selected = (isSelected.length() > 0) ? isSelected.toString() : null;
            JEditAbstractEditAction action = actionSet.createBeanShellAction(actionName, code.toString(), selected, noRepeat, noRecord, noRememberLast);
            actionSet.addAction(action);
            noRepeat = noRecord = noRememberLast = false;
            code.setLength(0);
            isSelected.setLength(0);
        }
        popElement();
    } else {
        // can't happen
        throw new InternalError();
    }
}