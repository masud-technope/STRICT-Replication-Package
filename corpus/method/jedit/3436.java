private void componentAdded(Component comp) {
    comp.addKeyListener(keyHandler);
    if (comp instanceof Container) {
        Container cont = (Container) comp;
        cont.addContainerListener(this);
        Component[] comps = cont.getComponents();
        for (Component comp1 : comps) componentAdded(comp1);
    }
}