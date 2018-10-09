/**
	  * Returns a string representation of the object. In general, the
	  * {@code toString} method returns a string that
	  * "textually represents" this object. The result should
	  * be a concise but informative representation that is easy for a
	  * person to read.
	  *
	  * @return  a string representation of the object.
	  */
public String toString() {
    return getClass().getName() + "[row=" + row + ",col=" + col + ",colspan=" + colspan + ",effectiveColspan=" + effectiveColspan + ",rowspan=" + rowspan + ",effectiveRowspan=" + effectiveRowspan + ",placeholder=" + placeholder + ",component=" + component + ",mainConstraints=" + mainConstraints + "]";
}