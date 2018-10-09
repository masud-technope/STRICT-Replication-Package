vfs java virtual filesystem implementation tab size tabsize indent size indentsize no tabs notabs folding explicit collapse folds collapsefolds copyright slava pestov program free software redistribute modify terms gnu general license published free software foundation version license version program distributed hope warranty implied warranty merchantability fitness purpose gnu general license details received copy gnu general license program write free software foundation temple place suite boston usa org gjt jedit imports java awt color java awt component java java closeable java util java util regex pattern java util regex pattern syntax exception patternsyntaxexception org gjt jedit msg properties changed propertieschanged org gjt jedit org gjt jedit bufferio buffer load request bufferloadrequest org gjt jedit bufferio buffer save request buffersaverequest org gjt jedit bufferio buffer insert request bufferinsertrequest org gjt util log org gjt util progress observer progressobserver org gjt util ioutilities org gjt util standard utilities standardutilities org gjt util task org gjt util thread utilities threadutilities virtual filesystem implementation plugins provide virtual file systems defining entries code services xml code files pre service org gjt jedit vfs my vfs myvfs service pre urls form code path code handled vfs named code code link org gjt jedit service manager servicemanager details session objects session persist login network sockets file system implementations kind persistence dummy object session methods names prefixed expect session object session method link create vfssession createvfssession string component method called awt edt thread filesystem code awt session cap code capability session disposed link end vfssession endvfssession object component thread safety methods called thread link create vfssession createvfssession string component code awt session cap code capability set link insert view buffer string link load view buffer string link save view buffer string remaining methods required thread safe subclasses implementing vfs override methods link get capabilities getcapabilities returns reflecting functionality implemented vfs vfsmanager get vfsfor path getvfsforpath string vfsmanager get vfsfor protocol getvfsforprotocol string author slava pestov author vfs capabilities read capability j edit jedit pre read cap write capability j edit jedit pre write cap browse capability j edit jedit pre official api adding items file system browser plugins menu j edit jedit earlier j edit jedit provide code browser actions xml code file plugin jar define code plugin browser menu item code code plugin browser menu code properties link org gjt jedit edit plugin editplugin details browse cap delete file capability j edit jedit pre delete cap rename file capability j edit jedit pre rename cap directory capability j edit jedit pre mkdir cap latency capability set confirm dialog directory search vfs j edit jedit pre latency cap insensitive file system capability j edit jedit pre insensitive cap sessions created event dispatching thread file system capability set file system require code create vfssession createvfssession code called edt systems implement code create vfssession createvfssession code set j edit jedit pre awt session cap extended attributes file type j edit jedit pre string type type file status read read write j edit jedit pre string status status file size j edit jedit pre string size size file modified j edit jedit pre string modified modified iobufsize creates virtual filesystem param param caps capabilities vfs string caps caps caps reasonable defaults ext attrs extattrs string size type creates virtual filesystem param param caps capabilities param ext attrs extattrs extended attributes j edit jedit pre vfs string caps string ext attrs extattrs caps caps ext attrs extattrs ext attrs extattrs get name getname method returns vfs label stored code vfs label code property string get name getname get capabilities getcapabilities method returns capabilities vfs j edit jedit pre get capabilities getcapabilities caps is markers file supported ismarkersfilesupported method returns additional markers file saved vfs code j edit jedit pre is markers file supported ismarkersfilesupported get extended attributes getextendedattributes method returns extended attributes supported vfs j edit jedit pre string get extended attributes getextendedattributes ext attrs extattrs get file name getfilename method returns file component path param path path j edit jedit pre string get file name getfilename string path path equals path path ends with endswith path ends with endswith file separator path path substring path length math max path last index of lastindexof path last index of lastindexof file separator char separatorchar path index of indexof don get file name getfilename roots path length path path substring get file path getfilepath method returns path component vfs path standard implementation cuts protocol protocol separator character delegates eventually vfs paths vfs path jode archive test zip test txt vfs implementation additional vfs path username password host port ftp vfs archive filename archive vfs method overridden remove easiest remove additional delegate code get file path getfilepath param vfs path vfspath vfs path j edit jedit pre string get file path getfilepath string vfs path vfspath misc utilities miscutilities is url isurl vfs path vfspath vfs path vfspath string file path filepath vfs path vfspath substring misc utilities miscutilities get protocol of url getprotocolofurl vfs path vfspath length vfsmanager get vfsfor path getvfsforpath file path filepath get file path getfilepath file path filepath get parent of path getparentofpath method returns parent path overridden browsing filesystem work param path path j edit jedit pre string get parent of path getparentofpath string path ignore character path properly handle paths foo bar last index lastindex path length last index lastindex path char at charat last index lastindex file separator char separatorchar path char at charat last index lastindex last index lastindex count math max last index lastindex path last index of lastindexof file separator char separatorchar count path last index of lastindexof count ensures get file parent getfileparent protocol protocol path last index of lastindexof path substring construct path constructpath method constructs path directory file component overridden browsing filesystem work writing vfs method called ensure correct behavior call link org gjt jedit misc utilities miscutilities construct path constructpath string string param parent parent directory param path path j edit jedit pre string construct path constructpath string parent string path parent path get file separator getfileseparator method returns file separator vfs j edit jedit pre get file separator getfileseparator get two stage save name gettwostagesavename method returns temporary file based path j edit jedit saves file code save code renames original file virtual file systems support code code character filenames method permits vfs override behavior method returns code code stage save file introduced j edit jedit pre param path path j edit jedit pre string get two stage save name gettwostagesavename string path misc utilities miscutilities construct path constructpath get parent of path getparentofpath path get file name getfilename path save reload directory reloaddirectory method called directory reloaded file system browser flush cache j edit jedit pre reload directory reloaddirectory string path create vfssession createvfssession methods creates vfs session method called awt thread prompt login password simpler filesystem set code awt session cap code capability set sessions thread param path path question param comp component parent dialog boxes session session errors j edit jedit pre object create vfssession createvfssession string path component comp object link create vfssession createvfssession called thread checks code awt session cap code capability enters edt thread object create vfssession safe createvfssessionsafe string path component comp object session get capabilities getcapabilities awt session cap session create vfssession createvfssession path comp session getter sessiongetter getter session getter sessiongetter path comp thread utilities threadutilities run in dispatch thread and wait runindispatchthreadandwait getter session getter session load method loads buffer implementation posts request thread param view view param buffer buffer param path path param untitled buffer untitled load view view buffer buffer string path untitled get capabilities getcapabilities read cap vfsmanager error view path vfs supported load string object session create vfssession createvfssession path view session get capabilities getcapabilities write cap buffer set read only setreadonly task request buffer load request bufferloadrequest view buffer session path untitled buffer is temporary istemporary hyper search hypersearch faster request buffer load request bufferloadrequest interations ftp connection dialog runned dispatch thread thread utilities threadutilities run in dispatch thread runindispatchthread request thread utilities threadutilities run in background runinbackground request save method saves specifies buffer implementation posts request thread param view view param buffer buffer param path path save view view buffer buffer string path get capabilities getcapabilities write cap vfsmanager error view path vfs supported save string object session create vfssession createvfssession path view session save path save path buffer previous path buffer get path getpath create backup path path backed backed property set path equals buffer get path getpath buffer unset property unsetproperty buffer backed thread utilities threadutilities run in background runinbackground buffer save request buffersaverequest view buffer session path copy methods copy file vfs param progress progress observer don monitor progress launch command work thread workthread param source vfs sourcevfs source vfs param source session sourcesession vfs session param source path sourcepath source path file exists param target vfs targetvfs target vfs param target session targetsession target session param target path targetpath target path path exists file parent exists param comp component parent error dialog boxes param can stop canstop copy stopped copy successful ioexception ioexception error occurs j edit jedit pre copy progress observer progressobserver progress vfs source vfs sourcevfs object source session sourcesession string source path sourcepath vfs target vfs targetvfs object target session targetsession string target path targetpath component comp can stop canstop ioexception copy progress source vfs sourcevfs source session sourcesession source path sourcepath target vfs targetvfs target session targetsession target path targetpath comp can stop canstop copy file vfs param progress progress observer don monitor progress launch command work thread workthread param source vfs sourcevfs source vfs param source session sourcesession vfs session param source path sourcepath source path file exists param target vfs targetvfs target vfs param target session targetsession target session param target path targetpath target path path exists file parent exists param comp component parent error dialog boxes param can stop canstop copy stopped param send vfsupdate sendvfsupdate send vfs update copy lot copy copy successful ioexception ioexception error occurs j edit jedit copy progress observer progressobserver progress vfs source vfs sourcevfs object source session sourcesession string source path sourcepath vfs target vfs targetvfs object target session targetsession string target path targetpath component comp can stop canstop send vfsupdate sendvfsupdate ioexception source path sourcepath equals target path targetpath log log log warning vfs j edit jedit get property getproperty ioerror copy object source path sourcepath progress progress set status setstatus initializing input stream inputstream output stream outputstream vfsfile source vfsfile sourcevfsfile source vfs sourcevfs get file getfile source session sourcesession source path sourcepath comp source vfsfile sourcevfsfile file not found exception filenotfoundexception source path source path sourcepath doesn exists progress progress set maximum setmaximum source vfsfile sourcevfsfile get length getlength vfsfile target vfsfile targetvfsfile target vfs targetvfs get file getfile target session targetsession target path targetpath comp target vfsfile targetvfsfile string parent target path parenttargetpath misc utilities miscutilities get parent of path getparentofpath target path targetpath vfsfile parent target vfsfile parenttargetvfsfile target vfs targetvfs get file getfile target session targetsession parent target path parenttargetpath comp parent target vfsfile parenttargetvfsfile file not found exception filenotfoundexception target path parent target path parenttargetpath doesn exists parent target vfsfile parenttargetvfsfile get type gettype vfsfile directory string target filename targetfilename misc utilities miscutilities get file name getfilename target path targetpath target path targetpath misc utilities miscutilities construct path constructpath parent target path parenttargetpath target filename targetfilename ioexception parent target path file target vfsfile targetvfsfile get type gettype vfsfile directory target vfsfile targetvfsfile get path getpath equals source vfsfile sourcevfsfile get path getpath target path targetpath misc utilities miscutilities construct path constructpath target path targetpath source vfsfile sourcevfsfile get name getname buffered input stream bufferedinputstream source vfs sourcevfs create input stream createinputstream source session sourcesession source path sourcepath comp buffered output stream bufferedoutputstream target vfs targetvfs create output stream createoutputstream target session targetsession target path targetpath comp copy result copyresult ioutilities copy stream copystream iobufsize progress can stop canstop send vfsupdate sendvfsupdate vfsmanager send vfsupdate sendvfsupdate target vfs targetvfs target path targetpath copy result copyresult ioutilities close quietly closequietly closeable ioutilities close quietly closequietly closeable copy file vfs param progress progress observer don monitor progress launch command work thread workthread param source path sourcepath source path param target path targetpath target path param comp component parent error dialog boxes param can stop canstop copy stopped param send vfsupdate sendvfsupdate send vfs update copy lot copy copy successful ioexception ioexception error occurs j edit jedit copy progress observer progressobserver progress string source path sourcepath string target path targetpath component comp can stop canstop send vfsupdate sendvfsupdate ioexception vfs source vfs sourcevfs vfsmanager get vfsfor path getvfsforpath source path sourcepath vfs target vfs targetvfs vfsmanager get vfsfor path getvfsforpath target path targetpath object source session sourcesession object target session targetsession source session sourcesession source vfs sourcevfs create vfssession createvfssession source path sourcepath comp source session sourcesession log log log warning vfs unable valid session source vfs sourcevfs path source path sourcepath target session targetsession target vfs targetvfs create vfssession createvfssession target path targetpath comp target session targetsession log log log warning vfs unable valid session target vfs targetvfs path target path targetpath copy progress source vfs sourcevfs source session sourcesession source path sourcepath target vfs targetvfs target session targetsession target path targetpath comp can stop canstop send vfsupdate sendvfsupdate source session sourcesession source vfs sourcevfs end vfssession endvfssession source session sourcesession comp target session targetsession target vfs targetvfs end vfssession endvfssession target session targetsession comp copy file vfs param progress progress observer don monitor progress launch command work thread workthread param source path sourcepath source path param target path targetpath target path param comp component parent error dialog boxes param can stop canstop copy stopped copy successful ioexception ioexception error occurs j edit jedit pre copy progress observer progressobserver progress string source path sourcepath string target path targetpath component comp can stop canstop ioexception copy progress source path sourcepath target path targetpath comp can stop canstop insert method inserts file buffer implementation posts request thread param view view param buffer buffer param path path insert view view buffer buffer string path get capabilities getcapabilities read cap vfsmanager error view path vfs supported load string object session create vfssession createvfssession path view session thread utilities threadutilities run in background runinbackground buffer insert request bufferinsertrequest view buffer session path method starts requires session object canon path canonpath method returns canonical form path code code expanded user directory param session session param path path param comp component parent error dialog boxes exception ioexception error occurred j edit jedit pre string canon path canonpath object session string path component comp ioexception path list directory listdirectory method convenience method matches file names globs optionally list directory recursively param session session param directory directory note full url including host path username password needed vfs session instance param glob file names matching glob returned param recursive subdirectories listed param comp component parent error dialog boxes exception ioexception error occurred j edit jedit pre string list directory listdirectory object session string directory string glob recursive component comp ioexception string retval list directory listdirectory session directory glob recursive comp retval list directory listdirectory method convenience method matches file names globs optionally list directory recursively param session session param directory directory note full url including host path username password needed vfs session instance param glob file names matching glob returned param recursive subdirectories listed param comp component parent error dialog boxes exception ioexception error occurred param skip binary skipbinary ignore binary files slow process open files param skip hidden skiphidden skips hidden files directories backup files ignores file bak j edit jedit pre string list directory listdirectory object session string directory string glob recursive component comp skip binary skipbinary skip hidden skiphidden ioexception vfsfile filter vfsfilefilter filter glob vfsfile filter globvfsfilefilter glob list directory listdirectory session directory filter recursive comp skip binary skipbinary skip hidden skiphidden list directory listdirectory method convenience method filters directory listing filter optionally list directory recursively param session session param directory directory note full url including host path username password needed vfs session instance param filter link vfsfile filter vfsfilefilter filtering param recursive subdirectories listed param comp component parent error dialog boxes exception ioexception error occurred param skip binary skipbinary ignore binary files slow process open files param skip hidden skiphidden skips hidden files directories backup files ignores file bak j edit jedit pre string list directory listdirectory object session string directory vfsfile filter vfsfilefilter filter recursive component comp skip binary skipbinary skip hidden skiphidden ioexception list string files array list arraylist string list files listfiles session hash set hashset string files directory filter recursive comp skip binary skipbinary skip hidden skiphidden string ret val retval files to array toarray string files size arrays sort ret val retval standard utilities standardutilities string compare stringcompare string ret val retval list files listfiles method lists directory param session session param directory directory note full url including host path username password needed vfs session instance param comp component parent error dialog boxes exception ioexception error occurred j edit jedit pre vfsfile list files listfiles object session string directory component comp ioexception vfsmanager error comp directory vfs supported list string get file getfile method returns directory entry param session session link vfs create vfssession createvfssession string component param path path param comp component parent error dialog boxes exception ioexception error occurred directory entry doesn exist j edit jedit pre vfsfile get file getfile object session string path component comp ioexception delete method deletes url param session vfs session param path path param comp component parent error dialog boxes exception ioexception error occurs j edit jedit pre delete object session string path component comp ioexception rename method renames url filesystems support moving urls directories rely behavior param session vfs session param path param path param comp component parent error dialog boxes exception ioexception error occurs j edit jedit pre rename object session string string component comp ioexception mkdir method creates directory url param session vfs session param directory directory param comp component parent error dialog boxes exception ioexception error occurs j edit jedit pre mkdir object session string directory component comp ioexception backup method backs file implementation pre copies file backup directory pre empty param session vfs session param path path param comp component parent error dialog boxes exception ioexception error occurs j edit jedit pre backup object session string path component comp ioexception vfs vfs src vfssrc vfsmanager get vfsfor path getvfsforpath path vfs src vfssrc get file getfile session path comp file backup exist file applicable local filesystem don worry backup purposes real filesystem file backup dir backupdir misc utilities miscutilities prepare backup directory preparebackupdirectory path backup dir backupdir log log log warning vfs backup remote file path failed backup directory backup dir backupdir exists backup directory log log log warning vfs backup file path failed directory backup dir backupdir exist file backup file backupfile misc utilities miscutilities prepare backup file preparebackupfile path backup dir backupdir backup file backupfile copy vfs copy vfs vfs dst vfsdst vfsmanager get vfsfor path getvfsforpath backup file backupfile get path getpath object session dst sessiondst vfs dst vfsdst create vfssession safe createvfssessionsafe backup file backupfile get path getpath comp session dst sessiondst copy vfs src vfssrc session path vfs dst vfsdst session dst sessiondst backup file backupfile get path getpath comp log log log warning vfs backup file path failed copy backup file backupfile failed vfs dst vfsdst end vfssession endvfssession session dst sessiondst comp create input stream createinputstream method creates input stream method called thread param session vfs session param path path param ignore errors ignoreerrors file errors param comp component parent error dialog boxes inputstream code code problem exception ioexception error occurs j edit jedit pre input stream inputstream create input stream createinputstream object session string path ignore errors ignoreerrors component comp ioexception vfsmanager error comp path vfs supported load string create output stream createoutputstream method creates output stream method called thread param session vfs session param path path param comp component parent error dialog boxes exception ioexception error occurs j edit jedit pre output stream outputstream create output stream createoutputstream object session string path component comp ioexception vfsmanager error comp path vfs supported save string save complete savecomplete method called file saved param session vfs session param buffer buffer param path path buffer saved link org gjt jedit buffer get path getpath user invoked save copy command param comp component parent error dialog boxes exception ioexception error occurs j edit jedit pre save complete savecomplete object session buffer buffer string path component comp ioexception finish two stage save finishtwostagesave method called file saved two stage save twostagesave saving file apply permissions param session vfs session param buffer buffer param path path buffer saved link org gjt jedit buffer get path getpath user invoked save copy command param comp component parent error dialog boxes exception ioexception error occurs j edit jedit pre finish two stage save finishtwostagesave object session buffer buffer string path component comp ioexception end vfssession endvfssession method finishes vfs session called vfs complete avoid leaving stale network connections param session vfs session param comp component parent error dialog boxes exception ioexception error occurred j edit jedit pre end vfssession endvfssession object session component comp ioexception get default color for getdefaultcolorfor method returns color file matching user regular expressions j edit jedit pre color get default color for getdefaultcolorfor string lock colors load colors loadcolors color entry colorentry entry colors entry matcher matches entry color implementation link comparator compares link vfsfile instances j edit jedit pre directory entry compare directoryentrycompare comparator vfsfile sort ignore case sortignorecase sort mix files and dirs sortmixfilesanddirs creates code directory entry compare directoryentrycompare code param sort mix files and dirs sortmixfilesanddirs directories top listing param sort ignore case sortignorecase upper directory entry compare directoryentrycompare sort mix files and dirs sortmixfilesanddirs sort ignore case sortignorecase sort mix files and dirs sortmixfilesanddirs sort mix files and dirs sortmixfilesanddirs sort ignore case sortignorecase sort ignore case sortignorecase compare vfsfile file vfsfile file sort mix files and dirs sortmixfilesanddirs file get type gettype file get type gettype file get type gettype file get type gettype standard utilities standardutilities compare strings comparestrings file get name getname file get name getname sort ignore case sortignorecase members string caps string ext attrs extattrs list color entry colorentry colors object lock object initializer edit bus editbus add to bus addtobus ebcomponent handle message handlemessage ebmessage msg msg properties changed propertieschanged lock colors recursive list files listfiles method list files listfiles object session collection string stack list string files string directory vfsfile filter vfsfilefilter filter recursive component comp skip binary skipbinary skip hidden skiphidden ioexception recursive misc utilities miscutilities is url isurl directory string resolved path resolvedpath misc utilities miscutilities resolve symlinks resolvesymlinks directory symlink traverse resolved path directory equals resolved path resolvedpath stack resolved path resolvedpath log log log error recursion list files listfiles directory stack add resolved path resolvedpath vfsfile files list files listfiles session directory comp files files length files length thread current thread currentthread is interrupted isinterrupted vfsfile file files skip hidden skiphidden file is hidden ishidden misc utilities miscutilities is backup isbackup file get name getname filter accept file file get type gettype vfsfile directory file get type gettype vfsfile filesystem recursive string canon path canonpath canon path canonpath session file get path getpath comp list files listfiles session stack files canon path canonpath filter recursive comp skip binary skipbinary skip hidden skiphidden regular file skip binary skipbinary file is binary isbinary session log log log notice file get path getpath skipped binary file ioexception log log log error files add file get path getpath load colors loadcolors method load colors loadcolors lock colors array list arraylist color entry colorentry j edit jedit get boolean property getbooleanproperty vfs browser colorize string glob glob j edit jedit get property getproperty vfs browser colors glob colors add color entry colorentry pattern compile standard utilities standardutilities glob to re globtore glob j edit jedit get color property getcolorproperty vfs browser colors color color black pattern syntax exception patternsyntaxexception log log log error vfs invalid regular expression glob log log log error vfs color entry colorentry color entry colorentry pattern color color color entry colorentry pattern color color color color session getter sessiongetter session getter sessiongetter runnable session getter sessiongetter string path component comp path path comp comp object session string path component comp session create vfssession createvfssession path comp object session