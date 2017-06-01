package FloydWarshall
/**
 * Created by Shlomi Alon on 30/05/2017.
 */
//Floyd – Warshall   algorithm 4 problems
    fun  isConnectable(graph: Array<Array<Boolean>>){
    for(k in 0..graph.size-1) {
            for (i in graph.indices){
                for (j in graph.indices){
                    graph[i][j] = (graph[i][k] && graph[k][j]) || graph[i][j]
                }
            }
        }
    printBooleanMat(graph)
    }

fun pathOfMath(graph:Array<Array<Boolean>>):Array<Array<String>>{
    var pathMat: Array<Array<String>> = arrayOf(arrayOf("","","",""), arrayOf("","","",""), arrayOf("", "", "", ""), arrayOf("","","",""))
    for (i in graph.indices){
        for (j in graph.indices){
            if(graph[i][j] == true)
                pathMat[i][j] = " " + i + "->" + j
            else
                pathMat[i][j] = "False"
        }
    }
    for(k in 0..graph.size-1) {
        for (i in graph.indices){
            for (j in graph.indices) {
                if (graph[i][j] == false) {
                    graph[i][j] = (graph[i][k] && graph[k][j])
                    if(graph[i][j] == true)
                        pathMat[i][j] = pathMat[i][k] + pathMat[k][j]
                }
            }
        }
    }
    return pathMat
}

fun printBoolPath(pathMat: Array<Array<String>>, mat: Array<Array<Boolean>>) {
    println()
    for (i in pathMat.indices) {
        for (j in 0..pathMat[0].size - 1) {
            if (mat[i][j]) print("[" + pathMat[i][j] + "];\t")
        }
        println()
    }
}

fun numberOfTheConnectedComponents(mat: Array<IntArray>): IntArray {
    val ansArr = IntArray(mat.size)
    val n = mat.size
    var nunComp = 0
    var i: Int
    i = 0
    while (i < n) {
        if (ansArr[i] == 0) {
            nunComp++
            ansArr[i] = nunComp
        }
        for (j in 0..n - 1) {
            if (ansArr[j] == 0 && mat[i][j] != 0) {
                ansArr[j] = nunComp
            }
        }
        i++
    }
    return ansArr
}

//Floyd – Warshall   algorithm for weight graph
fun buildMatrix(graph:Array<Array<Int>>) {
    var size = graph.size
    var pathMatrix: Array<Array<String>> = arrayOf(arrayOf("", "", "", ""), arrayOf("", "", "", ""), arrayOf("", "", "", ""), arrayOf("", "", "", ""))

    for (i in 0..graph.size - 1) {
        for (j in 0..graph.size - 1) {
            if (!graph[i][j].equals(Int.MAX_VALUE)) {
                pathMatrix[i][j] = " " + i + "->" + j
            } else
                pathMatrix[i][j] = ""
        }
    }
    for(k in 0..size-1) {
        for (i in 0..size - 1) {
            for (j in 0..size - 1) {
                if (graph[i][k] != Int.MAX_VALUE && graph[k][j] != Int.MAX_VALUE) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j]
                        pathMatrix[i][j] = pathMatrix[i][k] + pathMatrix[k][j]
                    }

                }
            }
        }
    }
    printIntMat(graph)
    printStringMat(pathMatrix)
}

fun numberOfTheConnectedComponentsWeightGraph(mat: Array<IntArray>){
    var connectComp = IntArray(mat.size)
    var numComp = 0
    for (i in 0..mat.size-1){
        if(connectComp[i] == 0) {
            numComp++
            connectComp[i] = numComp
        }
        for (j in 0..mat.size-1){
            if(mat[i][j] != 0 && connectComp[j] == 0){
                connectComp[j] = numComp
            }
        }
    }
    for (i in 0..connectComp.size-1){
        print(connectComp[i])
        print("\t")
    }
}

//Help Functions
fun printBooleanMat(mat: Array<Array<Boolean>>) {
    for (i in 0..mat.size-1) {
        for (j in 0..mat.size-1) {
            print(mat[i][j])
            print('\t')
        }
        println()
    }
    println()
}

fun printStringMat(mat: Array<Array<String>>) {
    for (i in 0..mat.size-1) {
        for (j in 0..mat.size-1) {
            print(mat[i][j])
            print('\t')
        }
        println()
    }
    println()
}

fun printIntMat(mat: Array<Array<Int>>) {
    for (i in 0..mat.size-1) {
        for (j in 0..mat.size-1) {
            print(mat[i][j])
            print('\t')
        }
        println()
    }
    println()
}

fun main(args: Array<String>) {

//    val graph1: Array<Array<Boolean>> = arrayOf(arrayOf(false,true,true,false), arrayOf(true, false, false, true), arrayOf(true, false, false, true), arrayOf(false,true,true,false))
//    isConnectable(graph1)
//    val graph2: Array<Array<Boolean>> = arrayOf(arrayOf(false,true,true,false), arrayOf(true, false, false, true), arrayOf(true, false, false, true), arrayOf(false,true,true,false))
//    pathOfMath(graph2)
//    val graph3: Array<Array<Boolean>> = arrayOf(arrayOf(false,true,true,false), arrayOf(true, false, false, true), arrayOf(true, false, false, true), arrayOf(false,true,true,false))
//    printBoolPath(pathOfMath(graph3),graph3)

//    val graph1: Array<Array<Int>> = arrayOf(
//                                    arrayOf(Int.MAX_VALUE, 5, 6, Int.MAX_VALUE),
//                                    arrayOf(5, Int.MAX_VALUE, Int.MAX_VALUE, 4),
//                                    arrayOf(6, Int.MAX_VALUE, Int.MAX_VALUE, 2),
//                                    arrayOf(Int.MAX_VALUE, 4, 2, Int.MAX_VALUE))
//    buildMatrix(graph1)
//
//    val matrix = arrayOf(intArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0), intArrayOf(0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1), intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0), intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1), intArrayOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1))
//    numberOfTheConnectedComponentsWeightGraph(matrix)
}


