//}}}
//{{{ addRemove() method
/**
	 * Add a remove operation for the given jar
	 * @param jar the jar name
	 */
void addRemove(String jar) {
    addOperation(new Remove(jar));
}