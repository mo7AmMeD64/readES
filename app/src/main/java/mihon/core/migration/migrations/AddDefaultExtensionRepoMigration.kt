package mihon.core.migration.migrations

import logcat.LogPriority
import mihon.core.migration.Migration
import mihon.core.migration.MigrationContext
import mihon.domain.extension.repository.ExtensionStoreRepository
import tachiyomi.core.common.util.lang.withIOContext
import tachiyomi.core.common.util.system.logcat

/**
 * readES: automatically add the Yuzono manga extension repo on first launch
 * so the user doesn't have to add it manually in Settings > Browse.
 */
class AddDefaultExtensionRepoMigration : Migration {
    override val version: Float = Migration.ALWAYS

    override suspend fun invoke(migrationContext: MigrationContext): Boolean = withIOContext {
        val repository = migrationContext.get<ExtensionStoreRepository>() ?: return@withIOContext false
        try {
            repository.insert("https://raw.githubusercontent.com/yuzono/manga-repo/repo/index.min.json")
        } catch (e: Exception) {
            logcat(LogPriority.ERROR, e) { "Error adding default Yuzono extension repo" }
        }
        return@withIOContext true
    }
}
