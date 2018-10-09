//}}}
//{{{ resetClassManager() method
/**
	 * Causes BeanShell internal structures to drop references to cached
	 * Class instances.
	 */
void resetClassManager() {
    classManager.reset();
}