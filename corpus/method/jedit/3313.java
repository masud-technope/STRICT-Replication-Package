// }}}
// {{{ shortTitle() method
public String shortTitle(String name) {
    String title = jEdit.getProperty(name + ".title");
    if (title == null)
        return "NO TITLE PROPERTY: " + name;
    return title;
}