public int read() {
    if (m_streamEnd) {
        return -1;
    } else {
        int retChar = m_currentChar;
        switch(m_currentState) {
            case START_BLOCK_STATE:
                break;
            case RAND_PART_A_STATE:
                break;
            case RAND_PART_B_STATE:
                setupRandPartB();
                break;
            case RAND_PART_C_STATE:
                setupRandPartC();
                break;
            case NO_RAND_PART_A_STATE:
                break;
            case NO_RAND_PART_B_STATE:
                setupNoRandPartB();
                break;
            case NO_RAND_PART_C_STATE:
                setupNoRandPartC();
                break;
            default:
                break;
        }
        return retChar;
    }
}