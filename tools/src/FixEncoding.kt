import java.io.File

fun main(args: Array<String>) {
	for (f in File("..").canonicalFile.listRecursively().filter { it.name.endsWith(".html") }) {
		//f.writeText(f.readText(Charsets.ISO_8859_1), Charsets.UTF_8)
		f.writeText(f.readText(Charsets.UTF_8), Charsets.ISO_8859_1)
	}
}

fun File.listRecursively(): List<File> = this.listFiles().flatMap { listOf(it) + if (it.isDirectory) it.listRecursively() else listOf() }
