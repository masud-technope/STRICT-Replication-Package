//{{{ runMacro() method
@Override
public void runMacro(View view, Macro macro, boolean ownNamespace) {
    BeanShell.runScript(view, macro.getPath(), null, ownNamespace);
//}}}
}