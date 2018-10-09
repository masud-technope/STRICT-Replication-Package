/**
	 * Construct an entry with only a name. This allows the programmer
	 * to construct the entry's header "by hand". File is set to null.
	 */
public  TarEntry(String name) {
    this.initialize();
    this.nameTarHeader(this.header, name);
}