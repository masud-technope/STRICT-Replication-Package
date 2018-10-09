//}}}
//{{{ getTerminateChar() method
/**
	 * Returns the number of chars that can be read before the rule parsing stops.
	 *
	 * @return a number of chars or -1 (default value) if there is no limit
	 */
public int getTerminateChar() {
    return terminateChar;
}