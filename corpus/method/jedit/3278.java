//{{{ booleanListToArray() method
/**
		 * This method transforms a List<Boolean> into the corresponding
		 * boolean[] array
		 * @param list the List<Boolean> you want to convert
		 * @return a boolean[] array
		 */
private boolean[] booleanListToArray(java.util.List<Boolean> list) {
    boolean[] returnValue = new boolean[list.size()];
    int i = 0;
    for (Boolean value : list) {
        returnValue[i++] = value.booleanValue();
    }
    return returnValue;
//}}}
}