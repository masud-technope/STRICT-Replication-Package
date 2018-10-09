@Override
protected void handleException(TextArea textArea, String path, Throwable t) {
    Log.log(Log.ERROR, this, t, t);
//			new BeanShellErrorDialog(null,t);
}