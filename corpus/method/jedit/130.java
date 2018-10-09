/**
	 * Setter for the "buildnumber" attribute (optional) This key specifies the
	 * exact build version of the bundle. This string is usually of the form
	 * nn.n.nxnnn where n is a digit and x is a character from the set [abdf].
	 * The first number is the major version number of the bundle and can
	 * contain one or two digits to represent a number in the range 0-99. The
	 * second and third numbers are minor revision numbers and must be a single
	 * numeric digit. The fourth set of digits is the specific build number for
	 * the release.
	 *
	 * You may omit minor revision and build number information as appropriate.
	 * You may also omit major and minor revision information and specify only a
	 * build number. For example, valid version numbers include: 1.0.1,
	 * 1.2.1b10, 1.2d200, d125, 101, and 1.0.
	 *
	 * The value of this key typically changes between builds and is displayed
	 * in the Cocoa About panel in parenthesis. To specify the version
	 * information of a released bundle, use the CFBundleShortVersionString key.
	 */
public void setBuild(String s) {
    bundleProperties.setCFBundleVersion(s);
}