/**
     * Set how to handle long files, those with a name&gt;16 chars or containing spaces.
     * Optional, default=warn.
     * <p>
     * Allowable values are
     * <ul>
     * <li>  truncate - names are truncated to the maximum length, spaces are replaced by '_'
     * <li>  fail - names greater than the maximum cause a build exception
     * <li>  warn - names greater than the maximum cause a warning and TRUNCATE is used
     * <li>  bsd - BSD variant is used if any names are greater than the maximum.
     * <li>  gnu - GNU variant is used if any names are greater than the maximum.
     * <li>  omit - files with a name greater than the maximum are omitted from the archive
     * </ul>
     * @param mode the mode to handle long file names.
     */
public void setLongfile(ArLongFileMode mode) {
    this.longFileMode = mode;
}