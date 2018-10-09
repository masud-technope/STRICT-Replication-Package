/*
		object is a java.lang wrapper for boolean, char, or number type
	*/
private boolean isWrapper(Object obj) {
    return (obj instanceof Boolean || obj instanceof Character || obj instanceof Number);
}