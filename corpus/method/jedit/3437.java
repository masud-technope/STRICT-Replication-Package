private void componentRemoved(Component comp) {
    comp.removeKeyListener(keyHandler);
    if (comp instanceof Container) {
        Container cont = (Container) comp;
        cont.removeContainerListener(this);
        Component[] comps = cont.getComponents();
        for (Component comp1 : comps) componentRemoved(comp1);
    }
}