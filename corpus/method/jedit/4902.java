//}}}
//{{{ addBufferToList() method
private static void addBufferToList(Buffer buffer) {
    synchronized (bufferListLock) {
        String symlinkPath = buffer.getSymlinkPath();
        if ((VFSManager.getVFSForPath(symlinkPath).getCapabilities() & VFS.CASE_INSENSITIVE_CAP) != 0) {
            symlinkPath = symlinkPath.toLowerCase();
        }
        bufferCount++;
        bufferHash.put(symlinkPath, buffer);
        if (buffersFirst == null) {
            buffersFirst = buffersLast = buffer;
            return;
        } else //{{{ Sort buffer list
        if (sortBuffers) {
            String str11, str12;
            if (sortByName) {
                str11 = buffer.getName();
                str12 = buffer.getDirectory();
            } else {
                str11 = buffer.getDirectory();
                str12 = buffer.getName();
            }
            Buffer _buffer = buffersFirst;
            while (_buffer != null) {
                String str21, str22;
                if (sortByName) {
                    str21 = _buffer.getName();
                    str22 = _buffer.getDirectory();
                } else {
                    str21 = _buffer.getDirectory();
                    str22 = _buffer.getName();
                }
                int comp = StandardUtilities.compareStrings(str11, str21, true);
                if (comp < 0 || (comp == 0 && StandardUtilities.compareStrings(str12, str22, true) < 0)) {
                    buffer.next = _buffer;
                    buffer.prev = _buffer.prev;
                    _buffer.prev = buffer;
                    if (_buffer != buffersFirst)
                        buffer.prev.next = buffer;
                    else
                        buffersFirst = buffer;
                    return;
                }
                _buffer = _buffer.next;
            }
        //}}}
        }
        buffer.prev = buffersLast;
        // fixes the hang that can occur if we 'save as' to a
        // new filename which requires re-sorting
        buffer.next = null;
        buffersLast.next = buffer;
        buffersLast = buffer;
    }
}