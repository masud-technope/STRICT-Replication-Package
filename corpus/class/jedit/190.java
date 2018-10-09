/*
 * Mode.java - jEdit editing mode
 * :tabSize=4:indentSize=4:noTabs=false:
 * :folding=explicit:collapseFolds=1:
 *
 * Copyright (C) 1998, 1999, 2000 Slava Pestov
 * Copyright (C) 1999 mike dillon
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
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.gjt.sp.jedit.indent.DeepIndentRule;
import org.gjt.sp.jedit.indent.IndentRule;
import org.gjt.sp.jedit.indent.IndentRuleFactory;
import org.gjt.sp.jedit.indent.WhitespaceRule;
import org.gjt.sp.jedit.syntax.TokenMarker;
import org.gjt.sp.jedit.syntax.ModeProvider;
import org.gjt.sp.util.Log;
import org.gjt.sp.util.StandardUtilities;

/**
 * An edit mode defines specific settings for editing some type of file.
 * One instance of this class is created for each supported edit mode.
 *
 * @author Slava Pestov
 * @version $Id$
 */
public class Mode {

    /**
	 * Creates a new edit mode.
	 *
	 * @param name The name used in mode listings and to query mode
	 * properties
	 * @see #getProperty(String)
	 */
    public  Mode(String name) {
        this.name = name;
        this.ignoreWhitespace = true;
        props = new Hashtable();
    }

    //}}}
    //{{{ init() method
    /**
	 * Initializes the edit mode. Should be called after all properties
	 * are loaded and set.
	 */
    public void init() {
        try {
            filepathMatcher = null;
            String filenameGlob = (String) getProperty("filenameGlob");
            if (filenameGlob != null && !filenameGlob.isEmpty()) {
                // translate glob to regex
                String filepathRE = StandardUtilities.globToRE(filenameGlob);
                // Windows paths in there)
                if (filepathRE.contains("/") || filepathRE.contains("\\\\")) {
                    filepathRE = filepathRE.replaceAll("/|\\\\\\\\", "[/\\\\\\\\]");
                } else {
                    filepathRE = String.format("(?:.*[/\\\\])?%s", filepathRE);
                }
                this.filepathMatcher = Pattern.compile(filepathRE, Pattern.CASE_INSENSITIVE).matcher("");
            }
            firstlineMatcher = null;
            String firstlineGlob = (String) getProperty("firstlineGlob");
            if (firstlineGlob != null && !firstlineGlob.isEmpty()) {
                firstlineMatcher = Pattern.compile(StandardUtilities.globToRE(firstlineGlob), Pattern.CASE_INSENSITIVE).matcher("");
            }
        } catch (PatternSyntaxException re) {
            Log.log(Log.ERROR, this, "Invalid filename/firstline" + " globs in mode " + name);
            Log.log(Log.ERROR, this, re);
        }
        marker = null;
    }

    public TokenMarker getTokenMarker() {
        loadIfNecessary();
        return marker;
    }

    public void setTokenMarker(TokenMarker marker) {
        this.marker = marker;
    }

    public void loadIfNecessary() {
        if (marker == null) {
            ModeProvider.instance.loadMode(this);
            if (marker == null)
                Log.log(Log.ERROR, this, "Mode not correctly loaded, token marker is still null");
        }
    }

    public boolean isUserMode() {
        return isUserMode;
    }

    public void setUserMode(boolean b) {
        isUserMode = b;
    }

    public Object getProperty(String key) {
        return props.get(key);
    }

    public boolean getBooleanProperty(String key) {
        Object value = getProperty(key);
        return StandardUtilities.getBoolean(value, false);
    }

    public void setProperty(String key, Object value) {
        props.put(key, value);
    }

    public void unsetProperty(String key) {
        props.remove(key);
    }

    @SuppressWarnings({ "unchecked" })
    public void setProperties(Map props) {
        if (props == null)
            return;
        ignoreWhitespace = !"false".equalsIgnoreCase((String) props.get("ignoreWhitespace"));
        this.props.putAll(props);
    }

    public boolean accept(String fileName, String firstLine) {
        return accept(null, fileName, firstLine);
    }

    public boolean accept(String filePath, String fileName, String firstLine) {
        return acceptFile(filePath, fileName) || acceptIdentical(filePath, fileName) || acceptFirstLine(firstLine);
    }

    @Deprecated
    public boolean acceptFilename(String fileName) {
        return acceptFile(null, fileName);
    }

    public boolean acceptFile(String filePath, String fileName) {
        if (filepathMatcher == null)
            return false;
        return fileName != null && filepathMatcher.reset(fileName).matches() || filePath != null && filepathMatcher.reset(filePath).matches();
    }

    public boolean acceptFilenameIdentical(String fileName) {
        return acceptIdentical(null, fileName);
    }

    public boolean acceptIdentical(String filePath, String fileName) {
        String filenameGlob = (String) getProperty("filenameGlob");
        if (filenameGlob == null)
            return false;
        if (fileName != null && fileName.equalsIgnoreCase(filenameGlob))
            return true;
        if (filePath != null) {
            int lastUnixPos = filePath.lastIndexOf('/');
            int lastWindowsPos = filePath.lastIndexOf('\\');
            int index = Math.max(lastUnixPos, lastWindowsPos);
            String filename = filePath.substring(index + 1);
            return filename.equalsIgnoreCase(filenameGlob);
        }
        return false;
    }

    public boolean acceptFirstLine(String firstLine) {
        if (firstlineMatcher == null)
            return false;
        return firstLine != null && firstlineMatcher.reset(firstLine).matches();
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public boolean getIgnoreWhitespace() {
        return ignoreWhitespace;
    }

    public synchronized List<IndentRule> getIndentRules() {
        if (indentRules == null) {
            initIndentRules();
        }
        return indentRules;
    }

    public synchronized boolean isElectricKey(char ch) {
        if (electricKeys == null) {
            String[] props = { "indentOpenBrackets", "indentCloseBrackets", "electricKeys" };
            StringBuilder buf = new StringBuilder();
            for (String prop1 : props) {
                String prop = (String) getProperty(prop1);
                if (prop != null)
                    buf.append(prop);
            }
            electricKeys = buf.toString();
        }
        return (electricKeys.indexOf(ch) >= 0);
    }

    private void initIndentRules() {
        List<IndentRule> rules = new LinkedList<IndentRule>();
        String[] regexpProps = { "indentNextLine", "indentNextLines" };
        for (int i = 0; i < regexpProps.length; i++) {
            IndentRule rule = createRegexpIndentRule(regexpProps[i]);
            if (rule != null)
                rules.add(rule);
        }
        String[] bracketProps = { "indentOpenBracket", "indentCloseBracket", "unalignedOpenBracket", "unalignedCloseBracket" };
        for (String bracketProp : bracketProps) createBracketIndentRules(bracketProp, rules);
        String[] finalProps = { "unindentThisLine", "unindentNextLines" };
        for (int i = 0; i < finalProps.length; i++) {
            IndentRule rule = createRegexpIndentRule(finalProps[i]);
            if (rule != null)
                rules.add(rule);
        }
        if (getBooleanProperty("deepIndent")) {
            String unalignedOpenBrackets = (String) getProperty("unalignedOpenBrackets");
            if (unalignedOpenBrackets != null) {
                for (int i = 0; i < unalignedOpenBrackets.length(); i++) {
                    char openChar = unalignedOpenBrackets.charAt(i);
                    char closeChar = TextUtilities.getComplementaryBracket(openChar, null);
                    if (closeChar != '\0')
                        rules.add(new DeepIndentRule(openChar, closeChar));
                }
            }
        }
        if (!getIgnoreWhitespace())
            rules.add(new WhitespaceRule());
        indentRules = Collections.unmodifiableList(rules);
    }

    private IndentRule createRegexpIndentRule(String prop) {
        String value = (String) getProperty(prop);
        try {
            if (value != null) {
                Method m = IndentRuleFactory.class.getMethod(prop, String.class);
                return (IndentRule) m.invoke(null, value);
            }
        } catch (Exception e) {
            Log.log(Log.ERROR, this, "Bad indent rule " + prop + '=' + value + ':');
            Log.log(Log.ERROR, this, e);
        }
        return null;
    }

    private void createBracketIndentRules(String prop, Collection<IndentRule> rules) {
        String value = (String) getProperty(prop + 's');
        try {
            if (value != null) {
                for (int i = 0; i < value.length(); i++) {
                    char ch = value.charAt(i);
                    Method m = IndentRuleFactory.class.getMethod(prop, char.class);
                    rules.add((IndentRule) m.invoke(null, ch));
                }
            }
        } catch (Exception e) {
            Log.log(Log.ERROR, this, "Bad indent rule " + prop + '=' + value + ':');
            Log.log(Log.ERROR, this, e);
        }
    }

    protected final String name;

    protected final Map<String, Object> props;

    private Matcher firstlineMatcher;

    private Matcher filepathMatcher;

    protected TokenMarker marker;

    private List<IndentRule> indentRules;

    private String electricKeys;

    private boolean ignoreWhitespace;

    private boolean isUserMode;
}
