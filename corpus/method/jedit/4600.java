@Override
public String getExtendedAttribute(String name) {
    fetchAttrs();
    if (name.equals(EA_MODIFIED)) {
        return DATE_FORMAT.format(new Date(modified));
    } else {
        return super.getExtendedAttribute(name);
    }
}