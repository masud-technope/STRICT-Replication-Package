/***************************************************************************
	 * Nested tasks - new tasks with custom attributes
	 **************************************************************************/
//new ins 08/05/2015 Tobias Bley / UltraMixer
public void addConfiguredLSEnvironment(LSEnvironment lsEnvironment) throws BuildException {
    String name = lsEnvironment.getName();
    String value = lsEnvironment.getValue();
    if ((name == null) || (value == null))
        throw new BuildException("'<lsenvironment>' must have both 'name' and 'value' attibutes");
    bundleProperties.addLSEnvironment(name, value);
}