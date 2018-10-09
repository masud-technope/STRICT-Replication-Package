//}}}
//{{{ getExtensions() method
TextAreaExtension[] getExtensions() {
    TextAreaExtension[] retVal = new TextAreaExtension[extensions.size()];
    Iterator<Entry> iter = extensions.iterator();
    int i = 0;
    while (iter.hasNext()) retVal[i++] = iter.next().ext;
    return retVal;
}