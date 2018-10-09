//}}}
//{{{ characters() method
public void characters(char[] c, int off, int len) {
    String tag = peekElement();
    if (tag.equals("DESCRIPTION")) {
        description.append(c, off, len);
    } else if (tag.equals("PLUGIN_SET_ENTRY"))
        pluginSetEntry.append(c, off, len);
    else if (tag.equals("AUTHOR")) {
        if (author.length() != 0)
            author.append(", ");
        author.append(c, off, len);
    } else if (tag.equals("DOWNLOAD"))
        download.append(c, off, len);
    else if (tag.equals("DOWNLOAD_SOURCE"))
        downloadSource.append(c, off, len);
}