/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.crypto;

// ROT47 for 7-bit printable ASCII chr(33)..chr(126) or !..~
public final class ROT47Cipher extends AbstractRotationCipher {
    private final static int ROTATION_FACTOR = 47;

    public ROT47Cipher() {
        StringBuilder sb = new StringBuilder(('~' - '!') + 1);
        for (int i = '!'; i <= '~'; i++) {
            sb.append((char)i);
        }
        addConfig(ROTATION_FACTOR, sb.toString());
    }
}
