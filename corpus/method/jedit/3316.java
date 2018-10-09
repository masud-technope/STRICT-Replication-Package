// }}}
// {{{ longTitle() method
public String longTitle(String name) {
    String title = jEdit.getProperty(getLongTitlePropertyName(name));
    if (title == null)
        return shortTitle(name);
    return title;
}