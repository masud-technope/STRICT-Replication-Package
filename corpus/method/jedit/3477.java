/**
	  * @return The effective number of cells in a row for the component's display area.
	  */
int getEffectiveColspan() {
    return null == mainConstraints ? effectiveColspan : mainConstraints.effectiveColspan;
}