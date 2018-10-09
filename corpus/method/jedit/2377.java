public  TokenMgrError(String message, int reason) {
    super(message);
    errorCode = reason;
}