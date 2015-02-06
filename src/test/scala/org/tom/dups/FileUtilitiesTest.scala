package org.tom.dups;

import java.io.File
import org.scalatest._
import org.tom.dups.FileUtilities._
import java.nio.file.Paths

class FindDuplicatesTest extends FlatSpec with Matchers {

	"get files" should "find files in all directories recursively" in {

		val files = getFiles(Paths.get("src/test/resources/files-test"))

		files.size shouldBe 3
	}

	"md5 of file" should "be computed correctly" in {

		val checksum = md5(Paths.get("src/test/resources/files-test/dirA/fileA1"))

		val checksumString = checksum.toUpperCase()

		checksumString shouldBe "B26E313ED4A7CA6904B0E9369E5B957"
	}
	
	"find duplicates" should "return lists of identical files" in {
		
		val files = getFiles(Paths.get("src/test/resources/files-test"))
		
		val dups = findDuplicates(files)
		
	}
	"md5 of two equal files" should "be the same" in {
		
		val checksum1 = md5(Paths.get("src/test/resources/files-test/dirA/fileA1"))
		val checksum2 = md5(Paths.get("src/test/resources/files-test/dirA/fileA2"))

		checksum1 should equal (checksum2)
	}
	
	"md5 of two different files" should "be different" in {
		
		val checksum1 = md5(Paths.get("src/test/resources/files-test/dirA/fileA1"))
		val checksum2 = md5(Paths.get("src/test/resources/files-test/dirB/fileB1"))

		checksum1 should not equal (checksum2)
	}
}
