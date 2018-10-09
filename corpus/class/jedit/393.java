/*
 * Autosave.java - Autosave manager
 * :tabSize=4:indentSize=4:noTabs=false:
 * :folding=explicit:collapseFolds=1:
 *
 * Copyright (C) 1998, 2003 Slava Pestov
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
package org.gjt.sp.jedit;

//{{{ Imports
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.gjt.sp.util.Log;

/**
 * @author Slava Pestov
 * @version $Id$
 */
class Autosave implements ActionListener {

    //{{{ setInterval() method
    public static void setInterval(int interval) {
        if (interval == 0) {
            if (timer != null) {
                timer.stop();
                timer = null;
            }
            return;
        }
        interval *= 1000;
        if (timer == null) {
            timer = new Timer(interval, new Autosave());
            timer.start();
        } else
            timer.setDelay(interval);
    }

    //}}}
    //{{{ stop() method
    public static void stop() {
        if (timer != null)
            timer.stop();
    }

    //}}}
    //{{{ actionPerformed() method
    public void actionPerformed(ActionEvent evt) {
        if (jEdit.getIntegerProperty("autosave", 0) == 0)
            return;
        // save list of open files
        if (jEdit.getViewCount() != 0 && PerspectiveManager.isPerspectiveDirty()) {
            PerspectiveManager.setPerspectiveDirty(false);
            PerspectiveManager.savePerspective(true);
        }
        boolean autosaveUntitled = jEdit.getBooleanProperty("autosaveUntitled");
        Buffer[] bufferArray = jEdit.getBuffers();
        for (Buffer buffer : bufferArray) {
            if (autosaveUntitled || !buffer.isUntitled())
                buffer.autosave();
        }
        // flush log
        Log.flushStream();
    }

    //}}}
    //{{{ Private members
    private static Timer timer;

    private  Autosave() {
    }
    //}}}
}
