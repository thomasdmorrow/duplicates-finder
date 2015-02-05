package org.tom.dups;

import java.io.File
import org.scalatest._
import org.tom.dups.FileUtilities._
import java.nio.file.Paths
import scala.actors.threadpool.helpers.NanoTimer
import scala.actors.threadpool.helpers.Utils
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Queue
import java.nio.file.Path
import scala.concurrent.duration._

class FindDuplicatesPerfTest extends FlatSpec with Matchers {

	"get file size" should "get size quickly" in {

		val files = getFiles(Paths.get("C:\\Users\\morrow\\views\\morrow_view\\gui"))
		

		val buf = Queue(files: _*)

		if(buf.size % 2 == 1) buf.dequeue()

		val start = System.nanoTime()
		
		while(!buf.isEmpty) {

			val f1 = buf.dequeue()
			val f2 = buf.dequeue()

			val a = isEqual(f1, f2)
		}

		val time = System.nanoTime() - start
		println()
		println(s"Finished in ${time.nanos} milliseconds")
		println(s"${files.size} files")
		println()
		
	}

}
