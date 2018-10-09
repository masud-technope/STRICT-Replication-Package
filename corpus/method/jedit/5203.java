//}}}
//{{{ isExiting() method
/**
	 * Returns true if this plugin is being unloaded as part of the
	 * shutdown process, in which case some components like the help
	 * viewer and plugin manager ignore the event.
	 * @since jEdit 4.2pre3
	 */
public boolean isExiting() {
    return exit;
}