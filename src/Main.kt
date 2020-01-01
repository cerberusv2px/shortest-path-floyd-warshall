import java.text.DecimalFormat
import kotlin.random.Random

val formatter = DecimalFormat("###.######")

fun main() {

    val data = prepareData(10)
    display(data)
    println("------------------")
    compute(data)
}

// get random distance
fun getRD(): Double {
    return formatter.format(Random.nextDouble(0.0, 20.0)).toDouble()
}

fun compute(graph: List<List<Route>>) {
    val distances: List<List<Route>> = graph

    for (k in 0 until distances.size) {
        for (i in 0 until distances.size) {
            for (j in 0 until distances.size) {
                val tempDistance = distances[i][k].distance + distances[k][j].distance

                if (tempDistance < distances[i][j].distance) {
                    distances[i][j].distance = formatter.format(tempDistance).toDouble()
                }
            }
        }
    }

    display(distances)
    println("----------------")
    displayRoutePath(distances)
}

fun display(distances: List<List<Route>>) {
    for (i in 0 until distances.size) {
        print("$i \t")
        for (j in 0 until distances.size) {
            print("Route:$j\t${distances[i][j].distance}\t")
        }
        print("\n")
    }
}

fun displayRoutePath(distances: List<List<Route>>) {
    var i = 0
    var loopCounter = 0
    val routeList = mutableListOf<String>()
    val routeIndex = mutableListOf<Int>()
    routeIndex.add(0)
    while (loopCounter < distances.size) {
        var minRouteIndex = 0
        var minDistance = 9999999.99

        var j = 0

        while (j < distances.size) {
            if (i != j) {
                if (!routeIndex.contains(j)) {
                    if (minDistance > distances[i][j].distance) {
                        minDistance = distances[i][j].distance
                        minRouteIndex = j
                    }
                }
            }
            j++
        }

        if (!routeIndex.contains(minRouteIndex)) {
            routeIndex.add(minRouteIndex)
            routeList.add("Route:$minRouteIndex \t distance: $minDistance")
        }

        i = minRouteIndex
        loopCounter++
    }

    routeList.forEach {
        println(it)
    }
}

fun prepareData(size: Int): List<List<Route>> {
    val list = mutableListOf<MutableList<Route>>()
    for (i in 0 until size) {
        val tempList = mutableListOf<Route>()
        for (j in 0 until size) {
            if (i == j) {
                tempList.add(Route(0.0))
            }
            tempList.add(Route(getRD()))
        }
        list.add(tempList)
    }
    return list
}

