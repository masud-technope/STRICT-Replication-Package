//}}}
//{{{ showEvaluateDialog() method
/**
	 * Prompts for a BeanShell expression to evaluate.
	 * @param view the View
	 * @since jEdit 2.7pre2
	 */
public static void showEvaluateDialog(View view) {
    String command = GUIUtilities.input(view, "beanshell-eval-input", null);
    if (command != null) {
        if (!command.endsWith(";"))
            command = command + ";";
        int repeat = view.getInputHandler().getRepeatCount();
        if (view.getMacroRecorder() != null) {
            view.getMacroRecorder().record(repeat, command);
        }
        Object returnValue = null;
        try {
            for (int i = 0; i < repeat; i++) {
                returnValue = bsh._eval(view, bsh.getNameSpace(), command);
            }
        } catch (Throwable e) {
            Log.log(Log.ERROR, BeanShell.class, e);
            bsh.handleException(view, null, e);
        }
        if (returnValue != null) {
            String[] args = { returnValue.toString() };
            GUIUtilities.message(view, "beanshell-eval", args);
        }
    }
}