public Component getComponentAfter(Container aContainer, Component aComponent) {
    int index = components.indexOf(aComponent);
    if (index == -1) {
        return null;
    }
    index = index >= components.size() - 1 ? 0 : index + 1;
    Component component = components.get(index);
    if (!(component.isEnabled() && component.isFocusable())) {
        return getComponentAfter(aContainer, component);
    } else {
        return components.get(index);
    }
}