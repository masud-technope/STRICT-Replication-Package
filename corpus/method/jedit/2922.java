//}}}
//{{{ getCode() method
/**
	 * @return the BeanShell code that will replay this action.
	 * BeanShellAction.getCode() returns something more interesting for Actions that were loaded
	 * from the actions.xml file. 
	 * You do not need to override this method if your action name is unique,
	 * this EditAction was added to an ActionSet and that to an ActionContext of jEdit.
	 * 
	 * concrete since jEdit 4.3pre7
	 * @since jEdit 2.7pre2
	 * 
	 */
public String getCode() {
    return "jEdit.getAction(" + name + ").invoke(view); ";
}