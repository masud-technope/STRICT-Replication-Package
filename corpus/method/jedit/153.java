/**
	 * Setter for the "jvmversion" attribute (optional)
	 */
public void setJvmversion(String s) {
    bundleProperties.setJVMVersion(s);
    if (bundleProperties.getJavaXKey() && (bundleProperties.getJavaVersion() >= 1.7)) {
        throw new BuildException("Setting usejavaxkey is useless if jvmversion is at least 1.7, because then the Oracle PList format is used");
    }
}