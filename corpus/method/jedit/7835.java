// }}}
// {{{ addGroup() method
void addGroup(OptionGroup group) {
    if (root != null) {
        root.addOptionGroup(group);
    } else {
        addOptionGroup(group);
    }
}