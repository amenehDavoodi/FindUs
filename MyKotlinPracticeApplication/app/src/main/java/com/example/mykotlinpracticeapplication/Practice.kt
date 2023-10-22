package com.example.mykotlinpracticeapplication


fun main() {
	val a = mutableListOf(1, 2, 3, 1, 4)
	val b = mutableListOf(3, 4, 1)
	union(a, b)
}

fun listIterator(list: MutableList<Int>): MutableList<Int> {
	val iterator = list.listIterator()

	for (i in 1 until list.size){
		for (j in 0 until i){
			if (list[i]== list[j])
				iterator.remove()

		}
	}
//	while (iterator.hasNext()) {
//		val num = iterator.next()
//		if (list.contains(num)) {
//			iterator.remove()
//		}
//	}
	return list
}

fun union(a: MutableList<Int>, b: MutableList<Int>) {
	listIterator(a).addAll(listIterator(b))

	println(listIterator(a))
}

