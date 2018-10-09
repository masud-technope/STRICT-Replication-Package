/**
	  * If the layout manager uses a per-component string,
	  * adds the component <code>component</code> to the layout,
	  * associating it with the string specified by <code>name</code>.
	  *
	  * @param name      The string to be associated with the component.
	  *                  Has to be {@code null}, so that default constraints are used.
	  * @param component The component to be added
	  * @throws IllegalArgumentException if {@code name} is not {@code null}
	  * @see #addLayoutComponent(java.awt.Component, java.lang.Object)
	  */
public void addLayoutComponent(String name, Component component) {
    addLayoutComponent(component, name);
}