//{{{ BeanShellAction constructor
public  BeanShellAction(String name, String code, String isSelected, boolean noRepeat, boolean noRecord, boolean noRememberLast) {
    super(name);
    /* Some characters that we like to use in action names
		 * ('.', '-') are not allowed in BeanShell identifiers. */
    String sanitizedName = name.replace('.', '_').replace('-', '_');
    this.code = new CachedBshMethod("action_" + sanitizedName, code);
    if (isSelected != null) {
        this.isSelected = new CachedBshMethod("selected_" + sanitizedName, isSelected);
    }
    this.noRepeat = noRepeat;
    this.noRecord = noRecord;
    this.noRememberLast = noRememberLast;
    jEdit.setTemporaryProperty(name + ".toggle", isSelected != null ? "true" : "false");
}