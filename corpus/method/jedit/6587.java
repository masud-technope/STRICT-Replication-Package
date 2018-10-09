//}}}
//{{{ addKeyword() method
private void addKeyword(String k, byte id) {
    if (keywords == null)
        return;
    keywords.add(k, id);
}