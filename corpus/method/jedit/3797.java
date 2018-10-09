/**
  	 * 	@return The value of the text field as either an Integer or a Float, 
 	 * 	depending on whether this text field allows Integers or Floats.
 	 */
public Number getValue() {
    if (integerOnly)
        return Integer.valueOf(getText());
    else
        return Float.valueOf(getText());
}