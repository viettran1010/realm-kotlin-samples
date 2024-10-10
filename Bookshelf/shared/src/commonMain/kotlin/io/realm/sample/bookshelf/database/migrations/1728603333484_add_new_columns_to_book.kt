import io.realm.kotlin.migration.AutoMigration
import io.realm.kotlin.migration.AutoMigrationSubschema
import io.realm.kotlin.types.RealmObject
import kotlin.reflect.KClass

class Migration_1728603333484 : AutoMigration {
    override val schemaVersion: Long = 1728603333484
    override val targetSchema: Set<KClass<out RealmObject>> = setOf(Book::class)
    override fun up(schema: AutoMigrationSubschema) {
        schema.create("Book") {
            addField("enum1", String::class)
        }
    }

    override fun down(schema: AutoMigrationSubschema) {
        schema.get("Book")?.removeField("enum1")
    }
}