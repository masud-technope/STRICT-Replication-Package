//}}}
//{{{ toString() method
@Override
public String toString() {
    return getClass().getName() + '[' + (view.getEditPane() == this ? "active]" : "inactive]");
}