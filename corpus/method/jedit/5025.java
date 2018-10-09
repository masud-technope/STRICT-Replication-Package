//{{{ runMacro() method
@Override
public void runMacro(View view, Macro macro) {
    BeanShell.runScript(view, macro.getPath(), null, true);
//}}}
}