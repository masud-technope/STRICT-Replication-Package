/**
	*/
public void unsetVariable(String name) {
    super.unsetVariable(name);
    externalMap.remove(name);
}