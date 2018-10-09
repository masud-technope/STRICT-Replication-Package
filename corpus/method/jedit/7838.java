private void save(Object obj) {
    if (obj instanceof OptionGroup) {
        OptionGroup grp = (OptionGroup) obj;
        Enumeration<Object> members = grp.getMembers();
        while (members.hasMoreElements()) {
            save(members.nextElement());
        }
    } else if (obj instanceof OptionPane) {
        try {
            ((OptionPane) obj).save();
        } catch (Throwable t) {
            Log.log(Log.ERROR, this, "Error saving options:");
            Log.log(Log.ERROR, this, t);
        }
    } else if (obj instanceof String) {
        save(deferredOptionPanes.get(obj));
    }
}