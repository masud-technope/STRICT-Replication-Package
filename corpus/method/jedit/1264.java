/**
		Get the path components including any component paths.
	*/
public URL[] getPathComponents() {
    return (URL[]) getFullPath().toArray(new URL[0]);
}