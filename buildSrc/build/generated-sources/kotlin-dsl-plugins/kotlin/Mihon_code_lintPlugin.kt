/**
 * Precompiled [mihon.code.lint.gradle.kts][Mihon_code_lint_gradle] script plugin.
 *
 * @see Mihon_code_lint_gradle
 */
public
class Mihon_code_lintPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Mihon_code_lint_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
