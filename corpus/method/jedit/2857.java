//}}}
//{{{ getSorter()
/** @return the Comparator used for this bufferset
	    can be null if there is no sorting 
		@since jEdit 5.2
	*/
@Nullable
public Comparator<Buffer> getSorter() {
    return sorter;
}