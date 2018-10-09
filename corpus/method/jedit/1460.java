public void backup(int amount) {
    inBuf += amount;
    if ((bufpos -= amount) < 0)
        bufpos += bufsize;
}