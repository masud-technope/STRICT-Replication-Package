//{{{ EnhancedButton constructor
public  EnhancedButton(Icon icon, String toolTip, String action, ActionContext context) {
    super(icon);
    if (action != null) {
        // set the name of this button :
        // for instance, if the action is 'vfs.browser.previous'
        // the name will be 'previous'
        // this helps greatly in testing the UI with Fest-Swing
        int iSuffix = action.lastIndexOf('.');
        if (iSuffix < 0 || iSuffix == action.length() - 1) {
            setName(action);
        } else {
            setName(action.substring(iSuffix + 1));
        }
        setEnabled(true);
        addActionListener(new EditAction.Wrapper(context, action));
        addMouseListener(new HoverSetStatusMouseHandler(action));
    } else
        setEnabled(false);
    setToolTipText(toolTip);
}