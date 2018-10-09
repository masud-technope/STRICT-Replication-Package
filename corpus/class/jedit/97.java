/*
 * HyperSearchFileNode.java - HyperSearch file node
 * :tabSize=4:indentSize=4:noTabs=false:
 * :folding=explicit:collapseFolds=1:
 *
 * Copyright (C) 2005 Slava Pestov
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.gjt.sp.jedit.search;

import org.gjt.sp.jedit.Buffer;
import org.gjt.sp.jedit.EditPane;
import org.gjt.sp.jedit.MiscUtilities;
import org.gjt.sp.jedit.View;
import org.gjt.sp.jedit.jEdit;

/**
 * A file in the HyperSearch results window.
 * @author Slava Pestov
 * @version $Id$
 */
public class HyperSearchFileNode implements HyperSearchNode {

    public String path;

    public boolean showFullPath = true;

    private static String fileSep = System.getProperty("file.separator");

    static {
        if (fileSep.equals("\\"))
            fileSep = "\\\\";
    }

    public  HyperSearchFileNode(String path) {
        this.path = path;
    }

    public Buffer getBuffer(View view) {
        return jEdit.openFile(view, path);
    }

    public void goTo(EditPane editPane) {
        Buffer buffer = getBuffer(editPane.getView());
        if (buffer == null)
            return;
        editPane.setBuffer(buffer);
    }

    public String toString() {
        if (showFullPath)
            return path;
        String[] paths = path.split(fileSep);
        return paths[paths.length - 1];
    }

    public boolean equals(Object compareObj) {
        if (!(compareObj instanceof HyperSearchFileNode))
            return false;
        HyperSearchFileNode otherResult = (HyperSearchFileNode) compareObj;
        return path.equals(MiscUtilities.resolveSymlinks(otherResult.path));
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;
}
