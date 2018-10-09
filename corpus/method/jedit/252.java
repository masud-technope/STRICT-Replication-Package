/**
         * If the fullpath attribute is set, the file in the fileset
         * is written with the last part of the path in the archive.
         * If the fullpath ends in '/' the file is omitted from the archive.
         * It is an error to have more than one file specified in such a fileset.
         * @param fullpath the path to use for the file in a fileset.
         */
public void setFullpath(String fullpath) {
    this.fullpath = fullpath;
}