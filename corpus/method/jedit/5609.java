// }}}
//{{{ getCachePath() method
/**
	 * Returns the full path name of this plugin's summary file.
	 * The summary file is used to store certain information which allows
	 * loading of the plugin's resources and core class to be deferred
	 * until the plugin is first used. As long as a plugin is using the
	 * jEdit 4.2 plugin API, no extra effort is required to take advantage
	 * of the summary cache.
	 */
public String getCachePath() {
    return cachePath;
}