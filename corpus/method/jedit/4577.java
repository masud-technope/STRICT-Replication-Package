@Override
public String getExtendedAttribute(String name) {
    if (name.equals(EA_TYPE))
        return super.getExtendedAttribute(name);
    else {
        // etc.
        return null;
    }
}