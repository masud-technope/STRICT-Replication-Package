//}}}
//{{{ getMember() method
public Object getMember(int index) {
    return (index >= 0 && index < members.size()) ? members.elementAt(index) : null;
}