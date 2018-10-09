/**  Tobias Fischer, v2.4.0
	 * Setter for the alternative 'JavaX' dictionary key
	 */
public void setUseJavaXKey(boolean b) {
    if (b && (bundleProperties.getJavaVersion() >= 1.7)) {
        throw new BuildException("Setting usejavaxkey is useless if jvmversion is at least 1.7, because then the Oracle PList format is used");
    }
    bundleProperties.setJavaXKey(b);
}