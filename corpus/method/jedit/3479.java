/**
	  * @return The effective number of cells in a column for the component's display area.
	  */
int getEffectiveRowspan() {
    return null == mainConstraints ? effectiveRowspan : mainConstraints.effectiveRowspan;
}