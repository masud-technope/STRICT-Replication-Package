//}}}
//{{{ setCurrentBindings() method
@Override
public void setCurrentBindings(Hashtable bindings) {
    view.getStatus().setMessage((String) bindings.get(PREFIX_STR));
    currentBindings = bindings;
}