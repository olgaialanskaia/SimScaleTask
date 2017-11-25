package com.simscale.support;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Test data helper
 */
public class TestData {

    public static Map<String, Object> getTestProject(final String projectName) {

        Map<String, Object> publicPermission = new HashMap<>();
        publicPermission.put("billableAction", false);
        publicPermission.put("getCopy", true);
        publicPermission.put("read", true);
        publicPermission.put("readPreview", true);
        publicPermission.put("write", false);


        Map<String, Object> project = new HashMap<>();
        project.put("categories", Arrays.asList("AEROSPACE"));
        project.put("description", "TestTest");
        project.put("fileTypes", Arrays.asList());
        project.put("isPrivate", false);
        project.put("measurementSystem", "SI");
        project.put("projectName", projectName);
        project.put("publicPermission", publicPermission);
        project.put("userHasAcademicPlan", false);
        project.put("userHasEnterprisePlan", false);
        project.put("userHasFreePlan", true);
        project.put("userHasProfessionalPlan", false);

        return project;
    }

}
