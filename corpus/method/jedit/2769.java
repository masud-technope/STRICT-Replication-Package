//}}}
public boolean isEditable() {
    // respects "locked" property
    return super.isEditable() && !isLocked();
}