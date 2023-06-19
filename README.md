
# 🏁 Informed Search Algorithms with Heuristics

This Java program implements informed search algorithms with heuristics to find the optimal path from an initial position to a final position on a map. It allows the user to choose the algorithm type and the heuristic type to use for the search.

## Usage

1. Compile the Java program:
`
javac src/start.java` 

2.  Run the program:

`java src/start` 

3.  Follow the prompts to provide the necessary inputs, including the initial and final positions, algorithm type, and heuristic type.

## Features

### Reading Map from File

The program reads the map data from a file. The map should be in a specific format, where each line represents a row in the map, and each number represents the height of a box in the map.

`ReadFile("map_custom.txt");` 

### Choosing Algorithm Type

The program allows the user to choose the algorithm type to use for the search. The available options are:

-   Best First Search (1)
-   A* Search (2)

`PrintAlgoTypes();` 

### Choosing Heuristic Type

The program allows the user to choose the heuristic type to use for the search. The available options are:

1.  Heuristic by position
2.  Heuristic by Euclidean distance
3.  Heuristic by height

`PrintHeuTypes();` 

### Searching for Optimal Path

The program performs the informed search using the selected algorithm and heuristic. It explores the map to find the optimal path from the initial position to the final position.

`SearchWalk(initial_position, final_position);` 

### Printing Walk and Statistics

The program prints the final walk, including the optimal path marked with asterisks, and various statistics such as the cost, number of steps, and number of explored nodes.

`PrintWalk();` 

Also, the program creates an HTML file with the walk as:

![html walk](https://github.com/pablosierrafernandez/Informed-Search-Algorithms-with-Heuristics/blob/main/walk.PNG?raw=tr)
## Input File Format

The input file should contain the map data in the following format:

2 3 1 0 1 2 3 4 5 6\n
1 2 3 4 5 6 7 8 9 0
... 

-   Each line represents a row in the map.
-   Each number represents the height of a box in the map.
-   Use `-1` to represent obstacles or inaccessible areas.
