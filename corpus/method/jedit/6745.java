//}}}
//{{{ removeExtension() method
void removeExtension(TextAreaExtension ext) {
    Iterator<Entry> iter = extensions.iterator();
    while (iter.hasNext()) {
        if (iter.next().ext == ext) {
            iter.remove();
            return;
        }
    }
}