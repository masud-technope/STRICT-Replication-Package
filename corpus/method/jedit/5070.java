//}}}
//{{{ update() method
public void update(JMenu menu) {
    Vector macroVector = Macros.getMacroHierarchy();
    int count = menu.getMenuComponentCount();
    createMacrosMenu(menu, macroVector, 0);
    if (count == menu.getMenuComponentCount()) {
        JMenuItem mi = new JMenuItem(jEdit.getProperty("no-macros.label"));
        mi.setEnabled(false);
        menu.add(mi);
    }
}