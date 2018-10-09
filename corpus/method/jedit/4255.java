//{{{ save() method
private void save(int extendedState, Rectangle bounds) {
    cancelResizeSave();
    switch(extendedState) {
        case Frame.MAXIMIZED_VERT:
            jEdit.setIntegerProperty(name + ".x", bounds.x);
            jEdit.setIntegerProperty(name + ".width", bounds.width);
            break;
        case Frame.MAXIMIZED_HORIZ:
            jEdit.setIntegerProperty(name + ".y", bounds.y);
            jEdit.setIntegerProperty(name + ".height", bounds.height);
            break;
        case Frame.NORMAL:
            saveGeometry(frame, parent, name);
            break;
    }
//}}}
}