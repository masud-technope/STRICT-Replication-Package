//}}}
//{{{ pushElement() method
private String pushElement(String name) {
    name = (name == null) ? null : name.intern();
    stateStack.push(name);
    return name;
}