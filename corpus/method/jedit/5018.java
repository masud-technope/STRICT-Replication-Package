//}}}
//{{{ runMacro() method
/**
		 * Runs the specified macro. This method is optional; it is
		 * called if the specified macro is a startup script. The
		 * default behavior is to simply call {@link #runMacro(View,Macros.Macro)}.
		 *
		 * @param view The view - may be null.
		 * @param macro The macro.
		 * @param ownNamespace  A hint indicating whenever functions and
		 * variables defined in the script are to be self-contained, or
		 * made available to other scripts. The macro handler may ignore
		 * this parameter.
		 * @since jEdit 4.1pre3
		 */
public void runMacro(View view, Macro macro, boolean ownNamespace) {
    runMacro(view, macro);
//}}}
}