/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.crypto;

public final class ROT13Cipher extends AbstractRotationCipher {
    private final static int ROTATION_FACTOR = 13;

    private final static String UCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String LCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";

    public ROT13Cipher() {
        addConfig(ROTATION_FACTOR, UCASE_CHARS);
        addConfig(ROTATION_FACTOR, LCASE_CHARS);
    }
}
