//}}}
//{{{ pushElement() method
private String pushElement(String name) {
    stateStack.push(name);
    return name;
}