//}}}
//{{{ pushElement() method
private TagDecl pushElement(String name, Attributes attrs) {
    if (name != null) {
        TagDecl tag = new TagDecl(name, attrs);
        stateStack.push(tag);
        return tag;
    } else {
        stateStack.push(null);
        return null;
    }
}