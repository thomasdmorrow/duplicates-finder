package org.tom.dups

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.FileVisitor
import java.nio.file.Path
import org.tom.dups.FileUtilities._
import scala.collection.mutable.Map
import scala.collection.mutable.ListBuffer
import java.nio.file.SimpleFileVisitor

object FindDuplicatesApp extends App {

//	val rightFiles = getFiles(Paths.get("D:\\temp"))
//
//	val map = findDuplicates(rightFiles)
//
//	map.values.foreach { paths =>
//
//		paths.foreach { path =>
//			println(path.toAbsolutePath())
//		}
//		println()
//	}
	
	Files.walkFileTree(Paths.get(""), new SimpleFileVisitor[Path](){
		
		
	})
}
