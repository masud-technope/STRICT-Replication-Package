//}}}
//{{{ toString() method
public String toString() {
    if (jar == null)
        return "<anonymous>(" + id + ')';
    else
        return jar.getPath() + " (" + id + ')';
}