package com.learnwithK.utils;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum MyFeatures implements Feature {
    @Label("Allow to Save Employee Details in Database")
    ALLOW_EMPLOYEE_SAVE,

    @Label("Delete Employee Records from Database")
    DELETE_EMPLOYEE_RECORD;

    @Override
    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}