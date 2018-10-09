/**
		Change the parent of the class instance namespace.
		This is currently used for inner class support.
		Note: This method will likely be removed in the future.
	*/
// This could be static
public void setInstanceNameSpaceParent(Object instance, String className, NameSpace parent) {
    This ithis = ClassGeneratorUtil.getClassInstanceThis(instance, className);
    ithis.getNameSpace().setParent(parent);
}