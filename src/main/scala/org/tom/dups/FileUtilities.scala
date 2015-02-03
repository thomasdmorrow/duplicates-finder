package org.tom.dups

import java.io.File
import java.security.MessageDigest
import java.nio.file.Files._
import java.nio.file.Path
import scala.collection.JavaConversions._

object FileUtilities {

	val digest = MessageDigest.getInstance("MD5")

	def getFiles(path: Path): List[Path] = {

		val files = List.empty

		if (path == null) {

			return files
		}

		if (isRegularFile(path)) {

			return files :+ path
		}

		if (isDirectory(path)) {
			
			val dirStream = newDirectoryStream(path)
			
			return files ++ dirStream.flatMap(getFiles)
		}

		files
	}

	
	def equals(p1: Path, p2: Path): Boolean = {

		true
	}

	
	def sameSize(p1: Path, p2: Path): Boolean = {

		true
	}

	
	def md5(path: Path): Array[Byte] = {

		val bytes = readAllBytes(path)

		digest.digest(bytes)
	}
}