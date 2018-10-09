public Component getComponentBefore(Container aContainer, Component aComponent) {
    int index = components.indexOf(aComponent);
    if (index == -1) {
        return null;
    }
    index = index == 0 ? components.size() - 1 : index - 1;
    Component component = components.get(index);
    if (!(component.isEnabled() && component.isFocusable())) {
        return getComponentBefore(aContainer, component);
    } else {
        return components.get(index);
    }
}