package org.tom.dups;

import java.io.File
import org.scalatest._
import org.tom.dups.FileUtilities._
import java.nio.file.Paths

class FindDuplicatesAppTest extends FlatSpec with Matchers {

	"get files" should "find files in all directories recursively" in {

		val files = getFiles(Paths.get("src/test/resources/files-test"))

		assert(files.size === 3)

		println(files)

//		val fil = getFiles(Paths.get("D:\\temp\\Takeout"))

//		println(fil.size)

	}

	"md5 of file" should "be computed correctly" in {
		
		val checksum = md5(Paths.get("src/test/resources/files-test/dirA/fileA1"))
		
		assert(BigInt(1, checksum).toString(16).toUpperCase() == "B26E313ED4A7CA6904B0E9369E5B957")
	}
}
