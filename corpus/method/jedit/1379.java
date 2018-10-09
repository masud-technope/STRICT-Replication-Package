/**
		Set the external Map which to which this namespace synchronizes.
		The previous external map is detached from this namespace.  Previous
		map values are retained in the external map, but are removed from the
		BeanShell namespace.
	*/
public void setMap(Map map) {
    // Detach any existing namespace to preserve it, then clear this
    // namespace and set the new one
    this.externalMap = null;
    clear();
    this.externalMap = map;
}