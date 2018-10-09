//{{{ addExtendedAttributes() method
private void addExtendedAttributes(VFS vfs) {
    String[] attrs = vfs.getExtendedAttributes();
    vfs_attr_loop: for (int i = 0; i < attrs.length; i++) {
        for (ExtendedAttribute attr : extAttrs) {
            if (attrs[i].equals(attr.name)) {
                attr.ref++;
                continue vfs_attr_loop;
            }
        }
        // this vfs has an extended attribute which is not
        // in the list. add it to the end with a ref count
        // of 1
        extAttrs.add(new ExtendedAttribute(attrs[i]));
    }
}