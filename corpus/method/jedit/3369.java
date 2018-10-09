//{{{ Entry constructor
 Entry(DockableWindowFactory.Window factory) {
    this(factory, jEdit.getProperty(factory.name + ".dock-position", FLOATING));
//}}}
}