/*
			Note: we should implement this for consistency, however our
			BshClassLoader can natively load from a JAR because it is a
			URLClassLoader... so it may be better to allow it to do it.
		*/
public byte[] getCode(String className) {
    throw new Error("Unimplemented");
}