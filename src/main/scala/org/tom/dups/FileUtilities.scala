package org.tom.dups

import java.io.File
import java.security.MessageDigest
import java.nio.file.Files._
import java.nio.file.Path
import scala.collection.JavaConversions._
import scala.collection.mutable.Map

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

	def isEqual(p1: Path, p2: Path): Boolean = {

		MessageDigest.isEqual(readAllBytes(p1), readAllBytes(p2))
	}

	def sameSize(p1: Path, p2: Path): Boolean = {

		true
	}

	def md5Bytes(path: Path): Array[Byte] = {

		val bytes = readAllBytes(path)

		digest.digest(bytes)
	}

	def md5(path: Path): String = {

		BigInt(1, md5Bytes(path)).toString(16)
	}

	def findDuplicates(paths: List[Path]): Map[String, List[Path]] = {

		val map = Map.empty[String, List[Path]]

		paths.foreach { p =>

			val hash = md5(p)

			if (map.get(hash).isEmpty) map(hash) = List.empty[Path]

			map(hash) = map(hash) :+ p
		}

		map.filter {pair => pair._2.size > 1}
	}
}