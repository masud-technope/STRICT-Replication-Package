/*
		Note: we could probably do away with the unqualified name table
		in favor of a second name source
	*/
private UnqualifiedNameTable getUnqualifiedNameTable() {
    if (unqNameTable == null)
        unqNameTable = buildUnqualifiedNameTable();
    return unqNameTable;
}