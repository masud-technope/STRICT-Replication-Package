//}}}
//{{{ handleError() method
static void handleError(Component comp, Exception e) {
    Log.log(Log.ERROR, SearchAndReplace.class, e);
    if (comp instanceof Dialog) {
        new TextAreaDialog((Dialog) comp, beanshell ? "searcherror-bsh" : "searcherror", e);
    } else {
        new TextAreaDialog((Frame) comp, beanshell ? "searcherror-bsh" : "searcherror", e);
    }
}