/**
		Primitives compare equal with other Primitives containing an equal
		wrapped value.
	*/
public boolean equals(Object obj) {
    if (obj instanceof Primitive)
        return ((Primitive) obj).value.equals(this.value);
    else
        return false;
}