package org.libprunus.buildlogic;

import com.diffplug.gradle.spotless.SpotlessExtension;
import com.diffplug.gradle.spotless.SpotlessPlugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaLibraryPlugin;

final class JavaBuildLogic {
    private final Project project;

    JavaBuildLogic(Project project) {
        this.project = project;
    }

    void apply() {
        applyNecessaryPlugins();
        configureSpotless();
    }

    private void applyNecessaryPlugins() {
        var pluginManager = project.getPluginManager();

        pluginManager.apply(JavaLibraryPlugin.class);
        pluginManager.apply(SpotlessPlugin.class);
    }

    private void configureSpotless() {
        var spotless = project.getExtensions().getByType(SpotlessExtension.class);

        spotless.java(javaExtension -> {
            javaExtension.target("src/**/*.java");
            javaExtension.targetExclude("**/build/generated/**/*.java");

            javaExtension.palantirJavaFormat();
            javaExtension.removeUnusedImports();
            javaExtension.importOrder();
            javaExtension.trimTrailingWhitespace();
            javaExtension.endWithNewline();
        });

        spotless.kotlinGradle(kotlinGradleExtension -> {
            kotlinGradleExtension.target(
                    project.fileTree(project.getProjectDir()).matching(patterns -> {
                        patterns.include("**/*.gradle.kts");
                        patterns.exclude("**/build/**");
                    }));

            kotlinGradleExtension.trimTrailingWhitespace();
            kotlinGradleExtension.endWithNewline();
        });
    }
}
