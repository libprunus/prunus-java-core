package org.libprunus.buildlogic;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public final class BuildLogicPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        new JavaBuildLogic(project).apply();
    }

}
