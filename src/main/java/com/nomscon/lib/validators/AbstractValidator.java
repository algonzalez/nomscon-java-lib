/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */

package com.nomscon.lib.validators;

public abstract class AbstractValidator<T> implements Validator<T> {
    private final String DEFAULT_DESCRIPTION
            = "Checks that an item meets the validation criteria.";
    
    private String name;
    private String description;
    
    protected AbstractValidator() {
        this.name = this.getClass().getSimpleName();
        this.description = DEFAULT_DESCRIPTION;
    }

    @Override
    public String getName() { return name; }
    
    @Override
    public String getDescription() { return description; }
    
    @Override
    public String toString() {
        return String.format("%s: %s", getName(), getDescription());
    }
    
    protected void setName(String namme) { this.name = name; }
    protected void setDescription(String description) {
        this.description = description;
    }
}
