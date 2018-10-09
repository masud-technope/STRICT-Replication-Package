@Override
protected JEditBeanShellAction createBeanShellAction(String actionName, String code, String selected, boolean noRepeat, boolean noRecord, boolean noRememberLast) {
    return new JEditBeanShellAction(actionName, code, selected, noRepeat, noRecord, noRememberLast);
}