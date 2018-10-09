/***************************************************************************
	 * Execute the task
	 **************************************************************************/
/**
	 * The method executing the task
	 */
public void execute() throws BuildException {
    // Delete any existing Application bundle directory structure
    bundleDir = new File(mRootDir, bundleProperties.getApplicationName() + ".app");
    if (bundleDir.exists()) {
        Delete deleteTask = new Delete();
        deleteTask.setProject(getProject());
        deleteTask.setDir(bundleDir);
        deleteTask.execute();
    }
    if (mRootDir == null)
        throw new BuildException("Required attribute \"dir\" is not set.");
    if (mJarAttrs.isEmpty() && mJarFileSets.isEmpty() && mJarFileLists.isEmpty())
        throw new BuildException("Either the attribute \"jar\" must " + "be set, or one or more jarfilelists or " + "jarfilesets must be added.");
    if (!mJarAttrs.isEmpty() && (!mJarFileSets.isEmpty() || !mJarFileLists.isEmpty()))
        throw new BuildException("Cannot set both the attribute " + "\"jars\" and use jar filesets/filelists.  Use only one or the other.");
    if (bundleProperties.getApplicationName() == null)
        throw new BuildException("Required attribute \"name\" is not set.");
    if (bundleProperties.getMainClass() == null)
        throw new BuildException("Required attribute \"mainclass\" is not set.");
    // About Menu, deprecated under 1.4+
    if (useOldPropertyNames())
        bundleProperties.addJavaProperty(ABOUTMENU_KEY, bundleProperties.getCFBundleName());
    // Anti Aliased Graphics, renamed in 1.4+
    String antiAliasedProperty = useOldPropertyNames() ? "com.apple.macosx.AntiAliasedGraphicsOn" : "apple.awt.antialiasing";
    if (mAntiAliasedGraphics != null)
        bundleProperties.addJavaProperty(antiAliasedProperty, mAntiAliasedGraphics.toString());
    // Anti Aliased Text, renamed in 1.4+
    String antiAliasedTextProperty = useOldPropertyNames() ? "com.apple.macosx.AntiAliasedTextOn" : "apple.awt.textantialiasing";
    if (mAntiAliasedText != null)
        bundleProperties.addJavaProperty(antiAliasedTextProperty, mAntiAliasedText.toString());
    // Live Resize, deprecated under 1.4+
    if (useOldPropertyNames() && (mLiveResize != null))
        bundleProperties.addJavaProperty("com.apple.mrj.application.live-resize", mLiveResize.toString());
    // Screen Menu Bar, renamed in 1.4+
    String screenMenuBarProperty = useOldPropertyNames() ? "com.apple.macos.useScreenMenuBar" : "apple.laf.useScreenMenuBar";
    if (mScreenMenuBar != null)
        bundleProperties.addJavaProperty(screenMenuBarProperty, mScreenMenuBar.toString());
    // Growbox, added with 1.4+
    if ((useOldPropertyNames() == false) && (mGrowbox != null))
        bundleProperties.addJavaProperty("apple.awt.showGrowBox", mGrowbox.toString());
    // Growbox Intrudes, deprecated under 1.4+
    if (useOldPropertyNames() && (mGrowboxIntrudes != null))
        bundleProperties.addJavaProperty("com.apple.mrj.application.growbox.intrudes", mGrowboxIntrudes.toString());
    if (!mRootDir.exists() || (mRootDir.exists() && !mRootDir.isDirectory()))
        throw new BuildException("Destination directory specified by \"dir\" " + "attribute must already exist.");
    if (bundleDir.exists())
        throw new BuildException("The directory/bundle \"" + bundleDir.getName() + "\" already exists, cannot continue.");
    // Status message
    log("Creating application bundle: " + bundleDir);
    if (!bundleDir.mkdir())
        throw new BuildException("Unable to create bundle: " + bundleDir);
    // Make the Contents directory
    mContentsDir = new File(bundleDir, "Contents");
    if (!mContentsDir.mkdir())
        throw new BuildException("Unable to create directory " + mContentsDir);
    // Make the "MacOS" directory
    mMacOsDir = new File(mContentsDir, "MacOS");
    if (!mMacOsDir.mkdir())
        throw new BuildException("Unable to create directory " + mMacOsDir);
    // Make the Resources directory
    mResourcesDir = new File(mContentsDir, "Resources");
    if (!mResourcesDir.mkdir())
        throw new BuildException("Unable to create directory " + mResourcesDir);
    // Make the Resources/Java directory
    mJavaDir = new File(bundleProperties.getJavaVersion() < 1.7 ? mResourcesDir : mContentsDir, "Java");
    if (!mJavaDir.mkdir())
        throw new BuildException("Unable to create directory " + mJavaDir);
    if (mAppIcon != null) {
        try {
            File dest = new File(mResourcesDir, mAppIcon.getName());
            if (mVerbose)
                log("Copying application icon file to \"" + bundlePath(dest) + "\"");
            mFileUtils.copyFile(mAppIcon, dest);
        } catch (IOException ex) {
            throw new BuildException("Cannot copy icon file: " + ex);
        }
    }
    // Copy document type icons, if any, to the resource dir
    try {
        Iterator itor = bundleProperties.getDocumentTypes().iterator();
        while (itor.hasNext()) {
            DocumentType documentType = (DocumentType) itor.next();
            File iconFile = documentType.getIconFile();
            if (iconFile != null) {
                File dest = new File(mResourcesDir, iconFile.getName());
                if (mVerbose)
                    log("Copying document icon file to \"" + bundlePath(dest) + "\"");
                mFileUtils.copyFile(iconFile, dest);
            }
        }
    } catch (IOException ex) {
        throw new BuildException("Cannot copy document icon file: " + ex);
    }
    // Copy application jar(s) from the "jars" attribute (if any)
    processJarAttrs();
    // Copy application jar(s) from the nested jarfileset element(s)
    processJarFileSets();
    // Copy application jar(s) from the nested jarfilelist element(s)
    processJarFileLists();
    // Copy executable(s) from the "execs" attribute (if any)
    processExecAttrs();
    // Copy executable(s) from the nested execfileset element(s)
    processExecFileSets();
    // Copy executable(s) from the nested execfilelist element(s)
    processExecFileLists();
    // Copy resource(s) from the nested resourcefileset element(s)
    processResourceFileSets();
    // Copy resource(s) from the nested javafileset element(s)
    processJavaFileSets();
    // Copy resource(s) from the nested resourcefilelist element(s)
    processResourceFileLists();
    // Copy resource(s) from the nested javafilelist element(s)
    processJavaFileLists();
    // Add external classpath references from the extraclasspath attributes
    processExtraClassPathAttrs();
    // Add external classpath references from the nested
    // extraclasspathfileset element(s)
    processExtraClassPathFileSets();
    // Add external classpath references from the nested
    // extraclasspathfilelist attributes
    processExtraClassPathFileLists();
    // Copy HelpBooks into place
    copyHelpBooks();
    // Copy the JavaApplicationStub file from the Java system directory to
    // the MacOS directory
    copyApplicationStub();
    // Create the Info.plist file
    writeInfoPlist();
    // Create the PkgInfo file
    writePkgInfo();
// Done!
}