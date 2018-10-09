//}}}
//{{{ unsetProperty() method
void unsetProperty(String name) {
    if (getDefaultProperty(name) != null)
        user.setProperty(name, "");
    else
        user.remove(name);
}