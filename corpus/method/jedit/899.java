//}}}
//{{{ removeExtendedAttributes() method
private void removeExtendedAttributes(VFS vfs) {
    String[] attrs = vfs.getExtendedAttributes();
    vfs_attr_loop: for (int i = 0; i < attrs.length; i++) {
        Iterator<ExtendedAttribute> iter = extAttrs.iterator();
        while (iter.hasNext()) {
            ExtendedAttribute attr = iter.next();
            if (attrs[i].equals(attr.name)) {
                if (--attr.ref == 0) {
                    // we no longer have any
                    // dirs using this extended
                    // attribute
                    iter.remove();
                }
                continue vfs_attr_loop;
            }
        }
        // this vfs has an extended attribute which is not
        // in the list ???
        Log.log(Log.WARNING, this, "We forgot about " + attrs[i]);
    }
}