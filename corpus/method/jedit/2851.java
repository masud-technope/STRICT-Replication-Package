//{{{ BufferSet constructor
public  BufferSet(BufferSet source) {
    if (source == null)
        buffers = Collections.synchronizedList(new ArrayList<Buffer>());
    else
        buffers = Collections.synchronizedList(new ArrayList<Buffer>(source.buffers));
    listeners = new EventListenerList();
    if (jEdit.getBooleanProperty("sortBuffers")) {
        if (jEdit.getBooleanProperty("sortByName"))
            sorter = nameSorter;
        else
            sorter = pathSorter;
    }
}