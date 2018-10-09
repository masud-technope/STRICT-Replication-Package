private void mainSort() {
    int i;
    int j;
    int ss;
    int sb;
    int[] runningOrder = new int[256];
    int[] copy = new int[256];
    boolean[] bigDone = new boolean[256];
    int c1;
    int c2;
    //   if (verbosity >= 4) fprintf ( stderr, "        sort initialise ...\n" );
    for (i = 0; i < NUM_OVERSHOOT_BYTES; i++) {
        m_block[m_last + i + 2] = m_block[(i % (m_last + 1)) + 1];
    }
    for (i = 0; i <= m_last + NUM_OVERSHOOT_BYTES; i++) {
        m_quadrant[i] = 0;
    }
    m_block[0] = m_block[m_last + 1];
    if (m_last < 4000) {
        /*
             * Use simpleSort(), since the full sorting mechanism
             * has quite a large constant overhead.
             */
        for (i = 0; i <= m_last; i++) {
            m_zptr[i] = i;
        }
        m_firstAttempt = false;
        m_workDone = 0;
        m_workLimit = 0;
        simpleSort(0, m_last, 0);
    } else {
        for (i = 0; i <= 255; i++) {
            bigDone[i] = false;
        }
        for (i = 0; i <= 65536; i++) {
            m_ftab[i] = 0;
        }
        c1 = m_block[0];
        for (i = 0; i <= m_last; i++) {
            c2 = m_block[i + 1];
            m_ftab[(c1 << 8) + c2]++;
            c1 = c2;
        }
        for (i = 1; i <= 65536; i++) {
            m_ftab[i] += m_ftab[i - 1];
        }
        c1 = m_block[1];
        for (i = 0; i < m_last; i++) {
            c2 = m_block[i + 2];
            j = (c1 << 8) + c2;
            c1 = c2;
            m_ftab[j]--;
            m_zptr[m_ftab[j]] = i;
        }
        j = ((m_block[m_last + 1]) << 8) + (m_block[1]);
        m_ftab[j]--;
        m_zptr[m_ftab[j]] = m_last;
        /*
             * Now ftab contains the first loc of every small bucket.
             * Calculate the running order, from smallest to largest
             * big bucket.
             */
        for (i = 0; i <= 255; i++) {
            runningOrder[i] = i;
        }
        {
            int vv;
            int h = 1;
            do {
                h = 3 * h + 1;
            } while (h <= 256);
            do {
                h = h / 3;
                for (i = h; i <= 255; i++) {
                    vv = runningOrder[i];
                    j = i;
                    while ((m_ftab[((runningOrder[j - h]) + 1) << 8] - m_ftab[(runningOrder[j - h]) << 8]) > (m_ftab[((vv) + 1) << 8] - m_ftab[(vv) << 8])) {
                        runningOrder[j] = runningOrder[j - h];
                        j = j - h;
                        if (j <= (h - 1)) {
                            break;
                        }
                    }
                    runningOrder[j] = vv;
                }
            } while (h != 1);
        }
        /*
             * The main sorting loop.
             */
        for (i = 0; i <= 255; i++) {
            /*
                 * Process big buckets, starting with the least full.
                 */
            ss = runningOrder[i];
            /*
                 * Complete the big bucket [ss] by quicksorting
                 * any unsorted small buckets [ss, j].  Hopefully
                 * previous pointer-scanning phases have already
                 * completed many of the small buckets [ss, j], so
                 * we don't have to sort them at all.
                 */
            for (j = 0; j <= 255; j++) {
                sb = (ss << 8) + j;
                if (!((m_ftab[sb] & SETMASK) == SETMASK)) {
                    int lo = m_ftab[sb] & CLEARMASK;
                    int hi = (m_ftab[sb + 1] & CLEARMASK) - 1;
                    if (hi > lo) {
                        qSort3(lo, hi, 2);
                        if (m_workDone > m_workLimit && m_firstAttempt) {
                            return;
                        }
                    }
                    m_ftab[sb] |= SETMASK;
                }
            }
            /*
                 * The ss big bucket is now done.  Record this fact,
                 * and update the quadrant descriptors.  Remember to
                 * update quadrants in the overshoot area too, if
                 * necessary.  The "if (i < 255)" test merely skips
                 * this updating for the last bucket processed, since
                 * updating for the last bucket is pointless.
                 */
            bigDone[ss] = true;
            if (i < 255) {
                int bbStart = m_ftab[ss << 8] & CLEARMASK;
                int bbSize = (m_ftab[(ss + 1) << 8] & CLEARMASK) - bbStart;
                int shifts = 0;
                while ((bbSize >> shifts) > 65534) {
                    shifts++;
                }
                for (j = 0; j < bbSize; j++) {
                    int a2update = m_zptr[bbStart + j];
                    int qVal = (j >> shifts);
                    m_quadrant[a2update] = qVal;
                    if (a2update < NUM_OVERSHOOT_BYTES) {
                        m_quadrant[a2update + m_last + 1] = qVal;
                    }
                }
                if (!(((bbSize - 1) >> shifts) <= 65535)) {
                    panic();
                }
            }
            /*
                 * Now scan this big bucket so as to synthesise the
                 * sorted order for small buckets [t, ss] for all t != ss.
                 */
            for (j = 0; j <= 255; j++) {
                copy[j] = m_ftab[(j << 8) + ss] & CLEARMASK;
            }
            for (j = m_ftab[ss << 8] & CLEARMASK; j < (m_ftab[(ss + 1) << 8] & CLEARMASK); j++) {
                c1 = m_block[m_zptr[j]];
                if (!bigDone[c1]) {
                    m_zptr[copy[c1]] = m_zptr[j] == 0 ? m_last : m_zptr[j] - 1;
                    copy[c1]++;
                }
            }
            for (j = 0; j <= 255; j++) {
                m_ftab[(j << 8) + ss] |= SETMASK;
            }
        }
    }
}