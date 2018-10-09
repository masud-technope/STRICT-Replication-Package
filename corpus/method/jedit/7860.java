public Object getChild(Object parent, int index) {
    if (parent instanceof OptionGroup) {
        return ((OptionGroup) parent).getMember(index);
    } else {
        return null;
    }
}