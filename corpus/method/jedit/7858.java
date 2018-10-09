public int getIndexOfChild(Object parent, Object child) {
    if (parent instanceof OptionGroup) {
        return ((OptionGroup) parent).getMemberIndex(child);
    } else {
        return -1;
    }
}