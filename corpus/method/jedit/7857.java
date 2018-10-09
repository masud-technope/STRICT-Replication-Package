public int getChildCount(Object parent) {
    if (parent instanceof OptionGroup) {
        return ((OptionGroup) parent).getMemberCount();
    } else {
        return 0;
    }
}