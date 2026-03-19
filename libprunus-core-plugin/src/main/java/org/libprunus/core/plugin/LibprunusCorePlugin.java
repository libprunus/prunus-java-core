package org.libprunus.core.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.libprunus.core.plugin.buildlogic.JavaBuildLogic;

public final class LibprunusCorePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        new JavaBuildLogic(project).apply();
    }
}
