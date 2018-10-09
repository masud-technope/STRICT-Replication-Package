//}}}
//{{{ setTemporaryProperty() method
public void setTemporaryProperty(String name, String value) {
    user.remove(name);
    system.setProperty(name, value);
}