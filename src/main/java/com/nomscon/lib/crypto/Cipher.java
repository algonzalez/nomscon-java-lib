/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.crypto;

public interface Cipher {
    String encode(String unencodedText);
    String decode(String encodedText);
}
