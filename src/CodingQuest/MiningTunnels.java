package CodingQuest;

import java.io.*;
import java.util.*;

class Point {
    int x, y, level;

    public Point(int x, int y, int level) {
        this.x = x;

        this.y = y;
        this.level = level;
    }
}

public class MiningTunnels {

    // Function to check if the given coordinates are within the bounds of the map
    private static boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static int findShortestPath(char[][] map) {
        int rows = map.length;
        int cols = map[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[rows][cols][2]; // 2 levels

        queue.offer(new Point(0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // Check if we reached the exit
            if (current.x == rows - 1 && current.y == cols - 1) {
                return current.level;
            }

            // Explore adjacent cells
            for (int[] dir : directions) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                // If the new coordinates are valid and not visited before
                if (isValid(newX, newY, rows, cols) && !visited[newX][newY][current.level]) {
                    char cell = map[newX][newY];

                    // If it's an elevator, toggle the level
                    if (cell == '$') {
                        int newLevel = 1 - current.level; // Toggle level
                        if (!visited[newX][newY][newLevel]) {
                            queue.offer(new Point(newX, newY, current.level + 1)); // Elevator increases step count
                            visited[newX][newY][newLevel] = true;
                        }
                    } else if (cell != '#') { // Not a wall
                        queue.offer(new Point(newX, newY, current.level + 1));
                        visited[newX][newY][current.level] = true;
                    }
                }
            }
        }

        return -1; // No path found
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java MiningTunnels <input_file>");
            return;
        }

        String inputFile = args[0];

        try (Scanner scanner = new Scanner(new File(inputFile))) {
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            char[][] map = new char[lines.size()][];
            for (int i = 0; i < lines.size(); i++) {
                map[i] = lines.get(i).toCharArray();
            }

            int shortestPathLength = findShortestPath(map);
            System.out.println("Shortest path length to exit: " + shortestPathLength);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
        }
    }
}
