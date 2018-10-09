//{{{ BeanShellAction constructor
public  JEditBeanShellAction(String name, String code, String isSelected, boolean noRepeat, boolean noRecord, boolean noRememberLast) {
    super(name);
    this.code = code;
    this.isSelected = isSelected;
    this.noRepeat = noRepeat;
    this.noRecord = noRecord;
    this.noRememberLast = noRememberLast;
    /* Some characters that we like to use in action names
		 * ('.', '-') are not allowed in BeanShell identifiers. */
    sanitizedName = name.replace('.', '_').replace('-', '_');
}