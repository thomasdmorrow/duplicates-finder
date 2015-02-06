package org.tom.dups

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.FileVisitor
import java.nio.file.Path
import org.tom.dups.FileUtilities._
import scala.collection.mutable.Map
import scala.collection.mutable.ListBuffer

object RemoveEditedApp extends App {

	val rightFiles = getFiles(Paths.get("D:\\temp"))

	println(rightFiles.size)

	for (p <- rightFiles) {

		if (p.toString().contains("-edited")) {

			val s = p.toAbsolutePath().toString().replace("-edited", "")
			val o = Paths.get(s)
			if (Files.exists(o) && Files.isRegularFile(o)) {

				println(s"deleting $p")
				Files.delete(p)
			}

		}
	}
}