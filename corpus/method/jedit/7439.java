//}}}
//{{{ toString() method
@Override
public String toString() {
    return getClass().getName() + '[' + (jEdit.getActiveView() == this ? "active" : "inactive") + ']';
}