//}}}
//{{{ invoke() method
public void invoke(View view) {
    try {
        BeanShell.runCachedBlock(code.get(), view, new NameSpace(BeanShell.getNameSpace(), "BeanShellAction.invoke()"));
    } catch (Throwable e) {
        Log.log(Log.ERROR, this, e);
        new BeanShellErrorDialog(view, e);
    }
}