import java.text.DecimalFormat
import kotlin.random.Random

val formatter = DecimalFormat("###.######")

fun main() {
    println("Floyd Warshall Algorithm")
    // 10x10 matrix
    val graph = arrayOf(
        arrayOf(
            0.0,
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD()
        ),
        arrayOf(
            getRD(),
            0.0,
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD()
        ),
        arrayOf(
            getRD(),
            getRD(),
            0.0,
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD()
        ),
        arrayOf(
            getRD(),
            getRD(),
            getRD(),
            0.0,
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD()
        ),
        arrayOf(
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            0.0,
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD()
        ),
        arrayOf(
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            0.0,
            getRD(),
            getRD(),
            getRD(),
            getRD()
        ),
        arrayOf(
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            0.0,
            getRD(),
            getRD(),
            getRD()
        ),
        arrayOf(
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            0.0,
            getRD(),
            getRD()
        ),
        arrayOf(
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            0.0,
            getRD()
        ),
        arrayOf(
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            getRD(),
            0.0
        )
    )
    println("------------------")
    display(graph)
    println("------------------")
    compute(graph)
}

// get random distance
fun getRD(): Double {
    return formatter.format(Random.nextDouble(0.0, 20.0)).toDouble()
}

fun compute(graph: Array<Array<Double>>) {
    val distances: Array<Array<Double>> = graph

    for (k in 0 until distances.size) {
        for (i in 0 until distances.size) {
            for (j in 0 until distances.size) {
                val tempDistance = distances[i][k] + distances[k][j]

                if (tempDistance < distances[i][j]) {
                    distances[i][j] = formatter.format(tempDistance).toDouble()
                }
            }
        }
    }

    display(distances)
    println("----------------")
    displayRoutePath(distances)
}

fun display(distances: Array<Array<Double>>) {
    for (i in 0 until distances.size) {
        for (j in 0 until distances.size) {
            print("Route:$j\t${distances[i][j]}\t")
        }
        print("\n")
    }
}

fun displayRoutePath(distances: Array<Array<Double>>) {
    var i = 0
    var loopCounter = 0
    val routeIndex = mutableListOf<Int>()
    val routeList = mutableListOf<String>()

    while (loopCounter < distances.size) {
        var minRouteIndex = 0
        var minDistance = if (i == 0) distances[i][1] else distances[i][0]

        for (j in 0 until distances.size) {
            if()
            if (minDistance > distances[i][j] && distances[i][j] != 0.0) {
                minDistance = distances[i][j]
                minRouteIndex = j
                routeIndex.add(j)
            }
        }
        i = minRouteIndex
        routeList.add("Route:$minRouteIndex \t distance: $minDistance")
        loopCounter++
    }

    routeList.forEach {
        println(it)
    }
}



