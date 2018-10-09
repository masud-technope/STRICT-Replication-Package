//{{{ endElement() method
@Override
public void endElement(String uri, String localName, String name) {
    if (name == null)
        return;
    String tag = peekElement();
    if (name.equals(tag)) {
        if (tag.equals("DOCKABLE")) {
            registerDockableWindow(plugin, dockableName, code.toString(), actions, movable);
            cachedDockableNames.add(dockableName);
            cachedDockableActionFlags.add(Boolean.valueOf(actions));
            cachedDockableMovableFlags.add(Boolean.valueOf(movable));
            // make default be true for the next
            // action
            actions = true;
            movable = MOVABLE_DEFAULT;
            code.setLength(0);
        }
        popElement();
    } else {
        // can't happen
        throw new InternalError();
    }
//}}}
}