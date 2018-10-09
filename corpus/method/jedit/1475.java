protected void AdjustBuffSize() {
    if (available == bufsize) {
        if (tokenBegin > 2048) {
            bufpos = 0;
            available = tokenBegin;
        } else
            ExpandBuff(false);
    } else if (available > tokenBegin)
        available = bufsize;
    else if ((tokenBegin - available) < 2048)
        ExpandBuff(true);
    else
        available = tokenBegin;
}