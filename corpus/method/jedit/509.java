/**
	 * Determine if the given entry is a descendant of this entry.
	 * Descendancy is determined by the name of the descendant
	 * starting with this entry's name.
	 *
	 * @param desc Entry to be checked as a descendent of this.
	 * @return True if entry is a descendant of this.
	 */
public boolean isDescendent(TarEntry desc) {
    return desc.header.name.toString().startsWith(this.header.name.toString());
}