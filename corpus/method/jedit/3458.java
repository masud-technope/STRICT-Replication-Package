/**
	  * Creates an extended grid layout manager with the specified horizontal
	  * and vertical gap, and the specified distance to the borders
	  * of the parent container.
	  *
	  * @param hgap The horizontal space between two columns ({@literal >=0})
	  * @param vgap The vertical space between two rows ({@literal >=0})
	  * @param distanceToBorders The distances to the borders of the parent container
	  * @throws IllegalArgumentException if hgap {@literal < 0}
	  * @throws IllegalArgumentException if vgap {@literal < 0}
	  */
public  ExtendedGridLayout(int hgap, int vgap, Insets distanceToBorders) {
    if (hgap < 0) {
        throw new IllegalArgumentException("hgap must be non-negative (" + hgap + ')');
    }
    if (vgap < 0) {
        throw new IllegalArgumentException("vgap must be non-negative (" + vgap + ')');
    }
    this.hgap = hgap;
    this.vgap = vgap;
    this.distanceToBorders = (Insets) distanceToBorders.clone();
    comptable = new Hashtable<Component, ExtendedGridLayoutConstraints>();
}