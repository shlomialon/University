package FloydWarshall

/**
 * Created by Shlomi Alon on 30/05/2017.
 */

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

fun main(args: Array<String>) {
    val graph1: Array<Array<Boolean>> = arrayOf(arrayOf(false,true,true,false), arrayOf(true, false, false, true), arrayOf(true, false, false, true), arrayOf(false,true,true,false))
    isConnectable(graph1)
    val graph2: Array<Array<Boolean>> = arrayOf(arrayOf(false,true,true,false), arrayOf(true, false, false, true), arrayOf(true, false, false, true), arrayOf(false,true,true,false))
    pathOfMath(graph2)
    val graph3: Array<Array<Boolean>> = arrayOf(arrayOf(false,true,true,false), arrayOf(true, false, false, true), arrayOf(true, false, false, true), arrayOf(false,true,true,false))
    printBoolPath(pathOfMath(graph3),graph3)
}

