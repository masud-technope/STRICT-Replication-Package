/**
		The hash of the Primitive is tied to the hash of the wrapped value but
		shifted so that they are not the same.
	*/
public int hashCode() {
    // arbitrary
    return this.value.hashCode() * 21;
}