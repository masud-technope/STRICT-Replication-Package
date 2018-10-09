//}}}
//{{{ Package-private members
//{{{ resetClassManager() method
/**
	 * Causes BeanShell internal structures to drop references to cached
	 * Class instances.
	 */
static void resetClassManager() {
    bsh.resetClassManager();
}