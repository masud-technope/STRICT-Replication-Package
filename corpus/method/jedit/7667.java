/**
	 *
	 * @param arr array of objects
	 * @param delim delimiter to separate strings
	 * @return a single string with each element in arr converted to a string and concatenated,
	 * separated by delim.
	 */
public static String join(Object[] arr, String delim) {
    return new StringList(arr).join(delim);
}