import io.realm.kotlin.migration.AutoMigration
import io.realm.kotlin.migration.AutoMigrationSubschema
import io.realm.kotlin.types.RealmObject
import kotlin.reflect.KClass

class Migration_1728604058120 : AutoMigration {
    override val schemaVersion: Long = 1728604058120
    override val targetSchema: Set<KClass<out RealmObject>> = setOf(Book::class)
    override fun up(schema: AutoMigrationSubschema) {
        schema.get("Book")?.apply {
            addField("subtitle", String::class, defaultValue = "")
            addField("title", String::class, defaultValue = "")
            addField("editionCount", Int::class, defaultValue = 0)
            addField("firstPublishYear", Int::class, defaultValue = 0)
            addField("imgId", String::class, defaultValue = "")
            addField("enum1", String::class, defaultValue = "")
            addField("birthday", String::class, defaultValue = "")
            addListField("authors", String::class)
        }
    }

    override fun down(schema: AutoMigrationSubschema) {
        schema.get("Book")?.apply {
            removeField("subtitle")
            removeField("title")
            removeField("editionCount")
            removeField("firstPublishYear")
            removeField("imgId")
            removeField("enum1")
            removeField("birthday")
            removeListField("authors")
        }
    }
}