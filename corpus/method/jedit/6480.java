//}}}
//{{{ loadMode() method
public void loadMode(Mode mode) {
    XModeHandler xmh = new XModeHandler(mode.getName()) {

        @Override
        public void error(String what, Object subst) {
            Log.log(Log.ERROR, this, subst);
        }

        @Override
        public TokenMarker getTokenMarker(String modeName) {
            Mode mode = getMode(modeName);
            if (mode == null)
                return null;
            else
                return mode.getTokenMarker();
        }
    };
    loadMode(mode, xmh);
}