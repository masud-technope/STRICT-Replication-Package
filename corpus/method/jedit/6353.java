/**
	 * @param noWordSep the chars that are considered as word chars for this search
	 * @since jEdit 4.5pre1
	 */
public void setNoWordSep(String noWordSep) {
    if (noWordSep == null)
        this.noWordSep = "_";
    else
        this.noWordSep = noWordSep;
}