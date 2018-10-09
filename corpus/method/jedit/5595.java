//}}}
//{{{ toString() method
@Override
public String toString() {
    if (plugin == null)
        return path;
    else
        return path + ",class=" + plugin.getClassName();
}