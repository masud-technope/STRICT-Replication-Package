//{{{ Entry constructor
 Entry(DockableWindowFactory.Window factory, String position) {
    this.factory = factory;
    this.position = position;
// get the title here, not in the factory constructor,
// since the factory might be created before a plugin's
// props are loaded
//}}}
}